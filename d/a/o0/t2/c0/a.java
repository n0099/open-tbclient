package d.a.o0.t2.c0;

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
import d.a.c.e.p.q;
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
    public static a f64739c = new a();

    /* renamed from: d  reason: collision with root package name */
    public static DownloadData f64740d = null;

    /* renamed from: e  reason: collision with root package name */
    public static List<DownloadData> f64741e = new LinkedList();

    /* renamed from: a  reason: collision with root package name */
    public b f64742a = null;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: b  reason: collision with root package name */
    public Handler f64743b = new HandlerC1676a(this, Looper.getMainLooper());

    /* renamed from: d.a.o0.t2.c0.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class HandlerC1676a extends Handler {
        public HandlerC1676a(a aVar, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 900002 || message.arg2 <= 0 || a.f64740d == null) {
                return;
            }
            a.f64740d.setLength(message.arg1);
            a.f64740d.setSize(message.arg2);
            a.f64740d.setStatus(1);
            if (a.f64740d.getCallback() != null) {
                a.f64740d.getCallback().onFileUpdateProgress(a.f64740d);
            }
        }
    }

    @SuppressLint({"DefaultLocale"})
    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<DownloadData, DownloadData, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public c f64744a = new c();

        public b() {
        }

        public void b() {
            c cVar = this.f64744a;
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
                this.f64744a.f(downloadDataArr[0].getUrl());
                if (Boolean.valueOf(this.f64744a.a(d.a.o0.t2.b.i(downloadDataArr[0].getId(), downloadDataArr[0].getName()), a.this.f64743b, TbConfig.NET_MSG_GETLENTH, 1, 3000)).booleanValue()) {
                    File e2 = d.a.o0.t2.b.e(d.a.o0.t2.b.i(downloadDataArr[0].getId(), downloadDataArr[0].getName()));
                    if (e2 != null) {
                        try {
                            try {
                                String parent = e2.getParent();
                                String parent2 = file.getParent();
                                if (parent.equals(parent2)) {
                                    e2.renameTo(new File(parent2, file.getName()));
                                } else {
                                    d.a.c.e.p.f.f(e2, file);
                                    d.a.c.e.p.f.n(e2);
                                }
                            } catch (Exception e3) {
                                e3.printStackTrace();
                                return 7;
                            }
                        } catch (IOException unused) {
                            d.a.c.e.p.f.n(file);
                            return 7;
                        }
                    } else {
                        return 1;
                    }
                } else {
                    return 3;
                }
            }
            if (!d.a.c.e.p.k.isEmpty(downloadDataArr[0].getCheck())) {
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
                        d.a.c.e.p.f.n(new File(downloadDataArr[0].getPath()));
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
            this.f64744a.e();
            a.f64740d.setStatus(4);
            a.f64740d.setStatusMsg(null);
            if (a.f64740d.getCallback() != null) {
                a.f64740d.getCallback().onFileUpdateProgress(a.f64740d);
            }
            if (!d.a.o0.k1.o.k.a.e(a.f64741e)) {
                d.a.o0.k1.o.k.a.i(a.f64741e, 0);
            }
            DownloadData unused = a.f64740d = null;
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
                a.f64740d.setStatus(0);
                if (a.f64740d.getCallback() != null) {
                    a.f64740d.getCallback().onFileUpdateProgress(a.f64740d);
                }
                if (a.f64740d.getCallback() != null) {
                    a.f64740d.getCallback().onFileDownloadSucceed(a.f64740d);
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
                a.f64740d.setStatusMsg(string);
                a.f64740d.setErrorCode(num.intValue());
                a.f64740d.setStatus(2);
                if (a.f64740d.getCallback() != null) {
                    a.f64740d.getCallback().onFileUpdateProgress(a.f64740d);
                }
                if (a.f64740d.getCallback() != null) {
                    a.f64740d.getCallback().onFileDownloadFailed(a.f64740d, num.intValue(), string);
                }
            }
            DownloadData unused = a.f64740d = null;
            if (d.a.o0.k1.o.k.a.e(a.f64741e)) {
                return;
            }
            d.a.o0.k1.o.k.a.i(a.f64741e, 0);
            a.this.m();
        }
    }

    public static a j() {
        return f64739c;
    }

    public void f(String str) {
        g(str, false);
    }

    public void g(String str, boolean z) {
        DownloadData downloadData = f64740d;
        if (downloadData != null && downloadData.getUrl().equals(str)) {
            if (z) {
                this.f64742a.b();
                return;
            } else {
                this.f64742a.cancel(true);
                return;
            }
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        Iterator<DownloadData> it = f64741e.iterator();
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
                d.a.o0.k1.o.k.a.a(linkedList, next);
            }
        }
        for (DownloadData downloadData2 : linkedList) {
            d.a.o0.k1.o.k.a.j(f64741e, downloadData2);
        }
    }

    public void h(DownloadData downloadData) {
        if (downloadData != null) {
            g(downloadData.getUrl(), true);
            File e2 = d.a.o0.t2.b.e(d.a.o0.t2.b.i(downloadData.getId(), downloadData.getName()));
            if (e2 != null) {
                e2.delete();
            }
        }
    }

    public List<DownloadData> i() {
        return f64741e;
    }

    public void k(DownloadData downloadData) {
        if (downloadData == null) {
            return;
        }
        if (!d.a.o0.a.h().r() && !FileHelper.checkSD()) {
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
        for (int i2 = 0; i2 < d.a.o0.k1.o.k.a.k(f64741e); i2++) {
            DownloadData downloadData2 = (DownloadData) d.a.o0.k1.o.k.a.d(f64741e, i2);
            if (downloadData2 != null && downloadData2.getUrl().equals(downloadData.getUrl()) && downloadData2.getId().equals(downloadData.getId())) {
                return;
            }
        }
        downloadData.setStatus(5);
        d.a.o0.k1.o.k.a.a(f64741e, downloadData);
        m();
    }

    public void l(DownloadData downloadData, int i2) {
        int type = downloadData.getType();
        int i3 = 0;
        for (DownloadData downloadData2 : f64741e) {
            if (downloadData2.getType() == type) {
                i3++;
            }
        }
        if (i3 >= i2) {
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
        if (f64740d != null || d.a.o0.k1.o.k.a.e(f64741e)) {
            return;
        }
        DownloadData downloadData = (DownloadData) d.a.o0.k1.o.k.a.d(f64741e, 0);
        f64740d = downloadData;
        if (downloadData != null) {
            b bVar = new b();
            this.f64742a = bVar;
            bVar.execute(f64740d);
        }
    }
}
