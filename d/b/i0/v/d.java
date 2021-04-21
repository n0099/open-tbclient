package d.b.i0.v;

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
import d.b.c.e.p.f;
import d.b.c.e.p.k;
import d.b.c.e.p.q;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    public static d f52271c = new d();

    /* renamed from: d  reason: collision with root package name */
    public static DownloadData f52272d = null;

    /* renamed from: e  reason: collision with root package name */
    public static List<DownloadData> f52273e = new LinkedList();

    /* renamed from: a  reason: collision with root package name */
    public b f52274a = null;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: b  reason: collision with root package name */
    public Handler f52275b = new a(this, Looper.getMainLooper());

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a(d dVar, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 900002 || message.arg2 <= 0 || d.f52272d == null) {
                return;
            }
            d.f52272d.setLength(message.arg1);
            d.f52272d.setSize(message.arg2);
            d.f52272d.setStatus(1);
            if (d.f52272d.getCallback() != null) {
                d.f52272d.getCallback().onFileUpdateProgress(d.f52272d);
            }
        }
    }

    @SuppressLint({"DefaultLocale"})
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<DownloadData, DownloadData, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f52276a = new NetWork();

        public b() {
        }

        public void b() {
            NetWork netWork = this.f52276a;
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
            if (downloadDataArr[0] == null) {
                return 1;
            }
            if (downloadDataArr[0].getCallback() != null && !downloadDataArr[0].getCallback().onPreDownload(downloadDataArr[0])) {
                return 0;
            }
            File file = new File(downloadDataArr[0].getPath());
            if (file.exists()) {
                file.delete();
            }
            if (!file.exists()) {
                this.f52276a.setUrl(downloadDataArr[0].getUrl());
                NetWork netWork = this.f52276a;
                if (Boolean.valueOf(netWork.downloadFile(downloadDataArr[0].getId() + "_" + downloadDataArr[0].getName() + ".tmp", d.this.f52275b, TbConfig.NET_MSG_GETLENTH, 3, 3000)).booleanValue()) {
                    File GetFileInCache = FileHelper.GetFileInCache(downloadDataArr[0].getId() + "_" + downloadDataArr[0].getName() + ".tmp");
                    if (GetFileInCache == null) {
                        return 1;
                    }
                    try {
                        try {
                            String parent = GetFileInCache.getParent();
                            String parent2 = file.getParent();
                            if (parent.equals(parent2)) {
                                GetFileInCache.renameTo(new File(parent2, file.getName()));
                            } else {
                                f.f(GetFileInCache, file);
                                f.n(GetFileInCache);
                            }
                        } catch (IOException unused) {
                            f.n(file);
                            return 7;
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return 7;
                    }
                } else {
                    return 3;
                }
            }
            if (!k.isEmpty(downloadDataArr[0].getCheck())) {
                FileInputStream fileInputStream2 = null;
                try {
                    try {
                        fileInputStream = new FileInputStream(downloadDataArr[0].getPath());
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                }
                try {
                    if (!q.b(fileInputStream).equalsIgnoreCase(downloadDataArr[0].getCheck())) {
                        f.n(new File(downloadDataArr[0].getPath()));
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
                } catch (Throwable th2) {
                    th = th2;
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
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            this.f52276a.setCancel();
            if (d.f52272d == null) {
                return;
            }
            d.f52272d.setStatus(4);
            d.f52272d.setStatusMsg(null);
            if (d.f52272d.getCallback() != null) {
                d.f52272d.getCallback().onFileUpdateProgress(d.f52272d);
            }
            if (!d.f52273e.isEmpty()) {
                d.f52273e.remove(0);
            }
            DownloadData unused = d.f52272d = null;
            d.this.m();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            String string;
            super.onPostExecute((b) num);
            if (d.f52272d == null || num == null) {
                return;
            }
            if (num.intValue() == 0) {
                d.f52272d.setStatus(0);
                if (d.f52272d.getCallback() != null) {
                    d.f52272d.getCallback().onFileUpdateProgress(d.f52272d);
                }
                if (d.f52272d.getCallback() != null) {
                    d.f52272d.getCallback().onFileDownloadSucceed(d.f52272d);
                }
            } else {
                int intValue = num.intValue();
                if (intValue == 1) {
                    string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                } else if (intValue == 2) {
                    string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                } else if (intValue == 3) {
                    string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_error);
                } else if (intValue == 4) {
                    string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                } else if (intValue != 6) {
                    string = intValue != 7 ? null : TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                } else {
                    string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                }
                d.f52272d.setStatusMsg(string);
                d.f52272d.setErrorCode(num.intValue());
                d.f52272d.setStatus(2);
                if (d.f52272d.getCallback() != null) {
                    d.f52272d.getCallback().onFileUpdateProgress(d.f52272d);
                }
                if (d.f52272d.getCallback() != null) {
                    d.f52272d.getCallback().onFileDownloadFailed(d.f52272d, num.intValue(), string);
                }
            }
            DownloadData unused = d.f52272d = null;
            if (d.f52273e.isEmpty()) {
                return;
            }
            d.f52273e.remove(0);
            d.this.m();
        }
    }

    public static d j() {
        return f52271c;
    }

    public void f(String str, int i) {
        DownloadData downloadData = f52272d;
        if (downloadData != null && downloadData.getId().equals(str) && f52272d.getType() == i) {
            this.f52274a.cancel(true);
            return;
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        Iterator<DownloadData> it = f52273e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DownloadData next = it.next();
            if (next.getId().equals(str) && next.getType() == i) {
                next.setStatus(4);
                next.setStatusMsg(null);
                if (next.getCallback() != null) {
                    next.getCallback().onFileUpdateProgress(next);
                }
                linkedList.add(next);
            }
        }
        for (DownloadData downloadData2 : linkedList) {
            f52273e.remove(downloadData2);
        }
    }

    public void g(String str, boolean z) {
        DownloadData downloadData = f52272d;
        if (downloadData != null && downloadData.getUrl().equals(str)) {
            if (z) {
                this.f52274a.b();
                return;
            } else {
                this.f52274a.cancel(true);
                return;
            }
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        Iterator<DownloadData> it = f52273e.iterator();
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
            f52273e.remove(downloadData2);
        }
    }

    public void h(int i) {
        DownloadData downloadData = f52272d;
        if (downloadData != null && downloadData.getType() == i) {
            this.f52274a.cancel(true);
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        for (DownloadData downloadData2 : f52273e) {
            if (downloadData2.getType() == i) {
                downloadData2.setStatus(4);
                downloadData2.setStatusMsg(null);
                if (downloadData2.getCallback() != null) {
                    downloadData2.getCallback().onFileUpdateProgress(downloadData2);
                }
                linkedList.add(downloadData2);
            }
        }
        for (DownloadData downloadData3 : linkedList) {
            f52273e.remove(downloadData3);
        }
    }

    public List<DownloadData> i() {
        return f52273e;
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
        for (int i = 0; i < f52273e.size(); i++) {
            DownloadData downloadData2 = null;
            try {
                downloadData2 = f52273e.get(i);
            } catch (Exception unused) {
            }
            if (downloadData2 != null && downloadData2.getUrl() != null && downloadData.getUrl() != null && downloadData2.getUrl().equals(downloadData.getUrl()) && downloadData2.getId() != null && downloadData.getId() != null && downloadData2.getId().equals(downloadData.getId())) {
                return;
            }
        }
        downloadData.setStatus(5);
        f52273e.add(downloadData);
        m();
    }

    public void l(DownloadData downloadData, int i) {
        int type = downloadData.getType();
        int i2 = 0;
        for (DownloadData downloadData2 : f52273e) {
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
        if (f52272d != null || f52273e.isEmpty()) {
            return;
        }
        try {
            f52272d = f52273e.get(0);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        if (f52272d != null) {
            b bVar = new b();
            this.f52274a = bVar;
            bVar.execute(f52272d);
        }
    }
}
