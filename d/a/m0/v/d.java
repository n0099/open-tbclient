package d.a.m0.v;

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
import d.a.c.e.p.f;
import d.a.c.e.p.k;
import d.a.c.e.p.q;
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
    public static d f54511c = new d();

    /* renamed from: d  reason: collision with root package name */
    public static DownloadData f54512d = null;

    /* renamed from: e  reason: collision with root package name */
    public static List<DownloadData> f54513e = new LinkedList();

    /* renamed from: a  reason: collision with root package name */
    public b f54514a = null;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: b  reason: collision with root package name */
    public Handler f54515b = new a(this, Looper.getMainLooper());

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a(d dVar, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 900002 || message.arg2 <= 0 || d.f54512d == null) {
                return;
            }
            d.f54512d.setLength(message.arg1);
            d.f54512d.setSize(message.arg2);
            d.f54512d.setStatus(1);
            if (d.f54512d.getCallback() != null) {
                d.f54512d.getCallback().onFileUpdateProgress(d.f54512d);
            }
        }
    }

    @SuppressLint({"DefaultLocale"})
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<DownloadData, DownloadData, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f54516a = new NetWork();

        public b() {
        }

        public void b() {
            NetWork netWork = this.f54516a;
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
                this.f54516a.setUrl(downloadDataArr[0].getUrl());
                NetWork netWork = this.f54516a;
                if (Boolean.valueOf(netWork.downloadFile(downloadDataArr[0].getId() + "_" + downloadDataArr[0].getName() + ".tmp", d.this.f54515b, TbConfig.NET_MSG_GETLENTH, 3, 3000)).booleanValue()) {
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
            this.f54516a.setCancel();
            if (d.f54512d == null) {
                return;
            }
            d.f54512d.setStatus(4);
            d.f54512d.setStatusMsg(null);
            if (d.f54512d.getCallback() != null) {
                d.f54512d.getCallback().onFileUpdateProgress(d.f54512d);
            }
            if (!d.f54513e.isEmpty()) {
                d.f54513e.remove(0);
            }
            DownloadData unused = d.f54512d = null;
            d.this.m();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            String string;
            super.onPostExecute((b) num);
            if (d.f54512d == null || num == null) {
                return;
            }
            if (num.intValue() == 0) {
                d.f54512d.setStatus(0);
                if (d.f54512d.getCallback() != null) {
                    d.f54512d.getCallback().onFileUpdateProgress(d.f54512d);
                }
                if (d.f54512d.getCallback() != null) {
                    d.f54512d.getCallback().onFileDownloadSucceed(d.f54512d);
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
                d.f54512d.setStatusMsg(string);
                d.f54512d.setErrorCode(num.intValue());
                d.f54512d.setStatus(2);
                if (d.f54512d.getCallback() != null) {
                    d.f54512d.getCallback().onFileUpdateProgress(d.f54512d);
                }
                if (d.f54512d.getCallback() != null) {
                    d.f54512d.getCallback().onFileDownloadFailed(d.f54512d, num.intValue(), string);
                }
            }
            DownloadData unused = d.f54512d = null;
            if (d.f54513e.isEmpty()) {
                return;
            }
            d.f54513e.remove(0);
            d.this.m();
        }
    }

    public static d j() {
        return f54511c;
    }

    public void f(String str, int i2) {
        DownloadData downloadData = f54512d;
        if (downloadData != null && downloadData.getId().equals(str) && f54512d.getType() == i2) {
            this.f54514a.cancel(true);
            return;
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        Iterator<DownloadData> it = f54513e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DownloadData next = it.next();
            if (next.getId().equals(str) && next.getType() == i2) {
                next.setStatus(4);
                next.setStatusMsg(null);
                if (next.getCallback() != null) {
                    next.getCallback().onFileUpdateProgress(next);
                }
                linkedList.add(next);
            }
        }
        for (DownloadData downloadData2 : linkedList) {
            f54513e.remove(downloadData2);
        }
    }

    public void g(String str, boolean z) {
        DownloadData downloadData = f54512d;
        if (downloadData != null && downloadData.getUrl().equals(str)) {
            if (z) {
                this.f54514a.b();
                return;
            } else {
                this.f54514a.cancel(true);
                return;
            }
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        Iterator<DownloadData> it = f54513e.iterator();
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
            f54513e.remove(downloadData2);
        }
    }

    public void h(int i2) {
        DownloadData downloadData = f54512d;
        if (downloadData != null && downloadData.getType() == i2) {
            this.f54514a.cancel(true);
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        for (DownloadData downloadData2 : f54513e) {
            if (downloadData2.getType() == i2) {
                downloadData2.setStatus(4);
                downloadData2.setStatusMsg(null);
                if (downloadData2.getCallback() != null) {
                    downloadData2.getCallback().onFileUpdateProgress(downloadData2);
                }
                linkedList.add(downloadData2);
            }
        }
        for (DownloadData downloadData3 : linkedList) {
            f54513e.remove(downloadData3);
        }
    }

    public List<DownloadData> i() {
        return f54513e;
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
        for (int i2 = 0; i2 < f54513e.size(); i2++) {
            DownloadData downloadData2 = null;
            try {
                downloadData2 = f54513e.get(i2);
            } catch (Exception unused) {
            }
            if (downloadData2 != null && downloadData2.getUrl() != null && downloadData.getUrl() != null && downloadData2.getUrl().equals(downloadData.getUrl()) && downloadData2.getId() != null && downloadData.getId() != null && downloadData2.getId().equals(downloadData.getId())) {
                return;
            }
        }
        downloadData.setStatus(5);
        f54513e.add(downloadData);
        m();
    }

    public void l(DownloadData downloadData, int i2) {
        int type = downloadData.getType();
        int i3 = 0;
        for (DownloadData downloadData2 : f54513e) {
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
        if (f54512d != null || f54513e.isEmpty()) {
            return;
        }
        try {
            f54512d = f54513e.get(0);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        if (f54512d != null) {
            b bVar = new b();
            this.f54514a = bVar;
            bVar.execute(f54512d);
        }
    }
}
