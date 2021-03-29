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
import com.baidu.tbadk.core.util.NetWork;
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
public class f {

    /* renamed from: c  reason: collision with root package name */
    public static f f59918c = new f();

    /* renamed from: d  reason: collision with root package name */
    public static DownloadData f59919d = null;

    /* renamed from: e  reason: collision with root package name */
    public static List<DownloadData> f59920e = new LinkedList();

    /* renamed from: a  reason: collision with root package name */
    public b f59921a = null;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: b  reason: collision with root package name */
    public Handler f59922b = new a(this, Looper.getMainLooper());

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public a(f fVar, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 900002 || message.arg2 <= 0 || f.f59919d == null) {
                return;
            }
            f.f59919d.setLength(message.arg1);
            f.f59919d.setSize(message.arg2);
            f.f59919d.setStatus(1);
            if (f.f59919d.getCallback() != null) {
                f.f59919d.getCallback().onFileUpdateProgress(f.f59919d);
            }
        }
    }

    @SuppressLint({"DefaultLocale"})
    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<DownloadData, DownloadData, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f59923a = new NetWork();

        public b() {
        }

        public void b() {
            NetWork netWork = this.f59923a;
            if (netWork != null) {
                netWork.setCancel();
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
                this.f59923a.setUrl(downloadDataArr[0].getUrl());
                NetWork netWork = this.f59923a;
                if (Boolean.valueOf(netWork.downloadFile(downloadDataArr[0].getId() + "_" + downloadDataArr[0].getName() + ".tmp", f.this.f59922b, TbConfig.NET_MSG_GETLENTH, 3, 3000)).booleanValue()) {
                    File GetFile = FileHelper.GetFile(downloadDataArr[0].getId() + "_" + downloadDataArr[0].getName() + ".tmp");
                    if (GetFile != null) {
                        try {
                            try {
                                String parent = GetFile.getParent();
                                String parent2 = file.getParent();
                                if (parent.equals(parent2)) {
                                    GetFile.renameTo(new File(parent2, file.getName()));
                                } else {
                                    d.b.b.e.p.f.f(GetFile, file);
                                    d.b.b.e.p.f.n(GetFile);
                                }
                            } catch (IOException unused) {
                                d.b.b.e.p.f.n(file);
                                return 7;
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return 7;
                        }
                    } else {
                        return 1;
                    }
                } else {
                    return 3;
                }
            }
            try {
                if (!d.b.b.e.p.k.isEmpty(downloadDataArr[0].getCheck())) {
                    try {
                        fileInputStream = new FileInputStream(downloadDataArr[0].getPath());
                    } catch (FileNotFoundException e3) {
                        e = e3;
                    }
                    try {
                        if (!q.b(fileInputStream).equalsIgnoreCase(downloadDataArr[0].getCheck())) {
                            d.b.b.e.p.f.n(new File(downloadDataArr[0].getPath()));
                            try {
                                fileInputStream.close();
                            } catch (IOException e4) {
                                BdLog.d(e4.getMessage());
                            }
                            return 4;
                        }
                        try {
                            fileInputStream.close();
                        } catch (IOException e5) {
                            BdLog.d(e5.getMessage());
                        }
                    } catch (FileNotFoundException e6) {
                        e = e6;
                        fileInputStream2 = fileInputStream;
                        BdLog.d(e.getMessage());
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e7) {
                                BdLog.d(e7.getMessage());
                            }
                        }
                        return 6;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e8) {
                                BdLog.d(e8.getMessage());
                            }
                        }
                        throw th;
                    }
                }
                if (downloadDataArr[0].getCallback() == null || downloadDataArr[0].getCallback().onFileDownloaded(downloadDataArr[0])) {
                    return 0;
                }
                return 2;
            } catch (Throwable th2) {
                th = th2;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            this.f59923a.setCancel();
            f.f59919d.setStatus(4);
            f.f59919d.setStatusMsg(null);
            if (f.f59919d.getCallback() != null) {
                f.f59919d.getCallback().onFileUpdateProgress(f.f59919d);
            }
            if (!f.f59920e.isEmpty()) {
                f.f59920e.remove(0);
            }
            DownloadData unused = f.f59919d = null;
            f.this.m();
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
                f.f59919d.setStatus(0);
                if (f.f59919d.getCallback() != null) {
                    f.f59919d.getCallback().onFileUpdateProgress(f.f59919d);
                }
                if (f.f59919d.getCallback() != null) {
                    f.f59919d.getCallback().onFileDownloadSucceed(f.f59919d);
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
                f.f59919d.setStatusMsg(string);
                f.f59919d.setErrorCode(num.intValue());
                f.f59919d.setStatus(2);
                if (f.f59919d.getCallback() != null) {
                    f.f59919d.getCallback().onFileUpdateProgress(f.f59919d);
                }
                if (f.f59919d.getCallback() != null) {
                    f.f59919d.getCallback().onFileDownloadFailed(f.f59919d, num.intValue(), string);
                }
            }
            DownloadData unused = f.f59919d = null;
            if (f.f59920e.isEmpty()) {
                return;
            }
            f.f59920e.remove(0);
            f.this.m();
        }
    }

    public static f j() {
        return f59918c;
    }

    public void f(String str) {
        g(str, false);
    }

    public void g(String str, boolean z) {
        DownloadData downloadData = f59919d;
        if (downloadData != null && downloadData.getUrl().equals(str)) {
            if (z) {
                this.f59921a.b();
                return;
            } else {
                this.f59921a.cancel(true);
                return;
            }
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        Iterator<DownloadData> it = f59920e.iterator();
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
                linkedList.add(next);
            }
        }
        for (DownloadData downloadData2 : linkedList) {
            f59920e.remove(downloadData2);
        }
    }

    public void h(DownloadData downloadData) {
        if (downloadData != null) {
            g(downloadData.getUrl(), true);
            File GetFile = FileHelper.GetFile(downloadData.getId() + "_" + downloadData.getName() + ".tmp");
            if (GetFile != null) {
                GetFile.delete();
            }
        }
    }

    public List<DownloadData> i() {
        return f59920e;
    }

    public void k(DownloadData downloadData) {
        if (downloadData == null) {
            return;
        }
        if (!FileHelper.checkSD()) {
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
        for (int i = 0; i < f59920e.size(); i++) {
            DownloadData downloadData2 = f59920e.get(i);
            if (downloadData2 != null && downloadData2.getUrl().equals(downloadData.getUrl()) && downloadData2.getId().equals(downloadData.getId())) {
                return;
            }
        }
        downloadData.setStatus(5);
        f59920e.add(downloadData);
        m();
    }

    public void l(DownloadData downloadData, int i) {
        int type = downloadData.getType();
        int i2 = 0;
        for (DownloadData downloadData2 : f59920e) {
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
        if (f59919d != null || f59920e.isEmpty()) {
            return;
        }
        DownloadData downloadData = f59920e.get(0);
        f59919d = downloadData;
        if (downloadData != null) {
            b bVar = new b();
            this.f59921a = bVar;
            bVar.execute(f59919d);
        }
    }
}
