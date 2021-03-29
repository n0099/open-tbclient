package d.b.i0.r2.x;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.R;
import d.b.b.e.p.q;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static a f59888c = new a();

    /* renamed from: d  reason: collision with root package name */
    public static DownloadData f59889d = null;

    /* renamed from: e  reason: collision with root package name */
    public static List<DownloadData> f59890e = new LinkedList();

    /* renamed from: a  reason: collision with root package name */
    public b f59891a = null;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: b  reason: collision with root package name */
    public Handler f59892b = new HandlerC1513a(this, Looper.getMainLooper());

    /* renamed from: d.b.i0.r2.x.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class HandlerC1513a extends Handler {
        public HandlerC1513a(a aVar, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 900002 || message.arg2 <= 0 || a.f59889d == null) {
                return;
            }
            a.f59889d.setLength(message.arg1);
            a.f59889d.setSize(message.arg2);
            a.f59889d.setStatus(1);
            if (a.f59889d.getCallback() != null) {
                a.f59889d.getCallback().onFileUpdateProgress(a.f59889d);
            }
        }
    }

    @SuppressLint({"DefaultLocale"})
    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<DownloadData, DownloadData, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public c f59893a = new c();

        public b() {
        }

        public void b() {
            c cVar = this.f59893a;
            if (cVar != null) {
                cVar.e();
            }
            cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public Integer doInBackground(DownloadData... downloadDataArr) {
            FileInputStream fileInputStream;
            FileInputStream fileInputStream2 = null;
            if (downloadDataArr[0] == null) {
                return null;
            }
            if (downloadDataArr[0].getCallback() != null && !downloadDataArr[0].getCallback().onPreDownload(downloadDataArr[0])) {
                return 0;
            }
            File file = new File(downloadDataArr[0].getPath());
            if (file.exists()) {
                file.delete();
            }
            if (!file.exists()) {
                this.f59893a.f(downloadDataArr[0].getUrl());
                if (Boolean.valueOf(this.f59893a.a(d.b.i0.r2.b.i(downloadDataArr[0].getId(), downloadDataArr[0].getName()), a.this.f59892b, TbConfig.NET_MSG_GETLENTH, 1, 3000)).booleanValue()) {
                    File e2 = d.b.i0.r2.b.e(d.b.i0.r2.b.i(downloadDataArr[0].getId(), downloadDataArr[0].getName()));
                    if (e2 != null) {
                        try {
                            try {
                                String parent = e2.getParent();
                                String parent2 = file.getParent();
                                if (parent.equals(parent2)) {
                                    e2.renameTo(new File(parent2, file.getName()));
                                } else {
                                    d.b.b.e.p.f.f(e2, file);
                                    d.b.b.e.p.f.n(e2);
                                }
                            } catch (Exception e3) {
                                e3.printStackTrace();
                                return 7;
                            }
                        } catch (IOException unused) {
                            d.b.b.e.p.f.n(file);
                            return 7;
                        }
                    } else {
                        return 1;
                    }
                } else {
                    return 3;
                }
            }
            if (!d.b.b.e.p.k.isEmpty(downloadDataArr[0].getCheck())) {
                try {
                    try {
                        fileInputStream = new FileInputStream(downloadDataArr[0].getPath());
                    } catch (FileNotFoundException e4) {
                        e = e4;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (!q.b(fileInputStream).equalsIgnoreCase(downloadDataArr[0].getCheck())) {
                        d.b.b.e.p.f.n(new File(downloadDataArr[0].getPath()));
                        try {
                            fileInputStream.close();
                        } catch (IOException e5) {
                            BdLog.d(e5.getMessage());
                        }
                        return 4;
                    }
                    try {
                        fileInputStream.close();
                    } catch (IOException e6) {
                        BdLog.d(e6.getMessage());
                    }
                } catch (FileNotFoundException e7) {
                    e = e7;
                    fileInputStream2 = fileInputStream;
                    BdLog.d(e.getMessage());
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e8) {
                            BdLog.d(e8.getMessage());
                        }
                    }
                    return 6;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e9) {
                            BdLog.d(e9.getMessage());
                        }
                    }
                    throw th;
                }
            }
            if (downloadDataArr[0].getCallback() == null || downloadDataArr[0].getCallback().onFileDownloaded(downloadDataArr[0])) {
                return 0;
            }
            return 2;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            this.f59893a.e();
            a.f59889d.setStatus(4);
            a.f59889d.setStatusMsg(null);
            if (a.f59889d.getCallback() != null) {
                a.f59889d.getCallback().onFileUpdateProgress(a.f59889d);
            }
            if (!d.b.i0.i1.o.k.a.e(a.f59890e)) {
                d.b.i0.i1.o.k.a.h(a.f59890e, 0);
            }
            DownloadData unused = a.f59889d = null;
            a.this.m();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            String string;
            super.onPostExecute((b) num);
            if (num == null) {
                return;
            }
            if (num.intValue() == 0) {
                a.f59889d.setStatus(0);
                if (a.f59889d.getCallback() != null) {
                    a.f59889d.getCallback().onFileUpdateProgress(a.f59889d);
                }
                if (a.f59889d.getCallback() != null) {
                    a.f59889d.getCallback().onFileDownloadSucceed(a.f59889d);
                }
            } else {
                int intValue = num.intValue();
                if (intValue == 1) {
                    string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                } else if (intValue == 2) {
                    string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                } else if (intValue == 3) {
                    string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_net);
                } else if (intValue == 4) {
                    string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                } else if (intValue != 6) {
                    string = intValue != 7 ? null : TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                } else {
                    string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                }
                a.f59889d.setStatusMsg(string);
                a.f59889d.setErrorCode(num.intValue());
                a.f59889d.setStatus(2);
                if (a.f59889d.getCallback() != null) {
                    a.f59889d.getCallback().onFileUpdateProgress(a.f59889d);
                }
                if (a.f59889d.getCallback() != null) {
                    a.f59889d.getCallback().onFileDownloadFailed(a.f59889d, num.intValue(), string);
                }
            }
            DownloadData unused = a.f59889d = null;
            if (d.b.i0.i1.o.k.a.e(a.f59890e)) {
                return;
            }
            d.b.i0.i1.o.k.a.h(a.f59890e, 0);
            a.this.m();
        }
    }

    public static a j() {
        return f59888c;
    }

    public void f(String str) {
        g(str, false);
    }

    public void g(String str, boolean z) {
        DownloadData downloadData = f59889d;
        if (downloadData != null && downloadData.getUrl().equals(str)) {
            if (z) {
                this.f59891a.b();
                return;
            } else {
                this.f59891a.cancel(true);
                return;
            }
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        Iterator<DownloadData> it = f59890e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DownloadData next = it.next();
            if (next.getUrl().equals(str)) {
                next.setStatus(4);
                if (next.getCallback() != null) {
                    next.getCallback().onFileUpdateProgress(next);
                }
                d.b.i0.i1.o.k.a.a(linkedList, next);
            }
        }
        for (DownloadData downloadData2 : linkedList) {
            d.b.i0.i1.o.k.a.i(f59890e, downloadData2);
        }
    }

    public void h(DownloadData downloadData) {
        if (downloadData != null) {
            g(downloadData.getUrl(), true);
            File e2 = d.b.i0.r2.b.e(d.b.i0.r2.b.i(downloadData.getId(), downloadData.getName()));
            if (e2 != null) {
                e2.delete();
            }
        }
    }

    public List<DownloadData> i() {
        return f59890e;
    }

    public void k(DownloadData downloadData) {
        if (downloadData == null) {
            return;
        }
        if (!d.b.i0.a.e().f() && !FileHelper.checkSD()) {
            downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_no_sd));
            downloadData.setStatus(2);
        }
        if (downloadData.getStatus() == 2) {
            if (downloadData.getCallback() != null) {
                downloadData.getCallback().onFileUpdateProgress(downloadData);
                return;
            }
            return;
        }
        for (int i = 0; i < d.b.i0.i1.o.k.a.j(f59890e); i++) {
            DownloadData downloadData2 = (DownloadData) d.b.i0.i1.o.k.a.d(f59890e, i);
            if (downloadData2 != null && downloadData2.getUrl().equals(downloadData.getUrl()) && downloadData2.getId().equals(downloadData.getId())) {
                return;
            }
        }
        downloadData.setStatus(5);
        d.b.i0.i1.o.k.a.a(f59890e, downloadData);
        m();
    }

    public void l(DownloadData downloadData, int i) {
        int type = downloadData.getType();
        int i2 = 0;
        for (DownloadData downloadData2 : f59890e) {
            if (downloadData2.getType() == type) {
                i2++;
            }
        }
        if (i2 >= i) {
            downloadData.setStatus(2);
            downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_over_max));
            if (downloadData.getCallback() != null) {
                downloadData.getCallback().onFileUpdateProgress(downloadData);
                return;
            }
            return;
        }
        k(downloadData);
    }

    public final void m() {
        if (f59889d != null || d.b.i0.i1.o.k.a.e(f59890e)) {
            return;
        }
        DownloadData downloadData = (DownloadData) d.b.i0.i1.o.k.a.d(f59890e, 0);
        f59889d = downloadData;
        if (downloadData != null) {
            b bVar = new b();
            this.f59891a = bVar;
            bVar.execute(f59889d);
        }
    }
}
