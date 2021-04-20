package d.b.h0.v;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.R;
import d.b.c.e.p.k;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f51928b;

    /* renamed from: c  reason: collision with root package name */
    public static DownloadData f51929c;

    /* renamed from: d  reason: collision with root package name */
    public static List<DownloadData> f51930d = new LinkedList();

    /* renamed from: a  reason: collision with root package name */
    public C1121b f51931a = null;

    /* renamed from: d.b.h0.v.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1121b extends BdAsyncTask<DownloadData, DownloadData, DownloadData> {
        public C1121b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public DownloadData doInBackground(DownloadData... downloadDataArr) {
            DownloadData downloadData = downloadDataArr[0];
            if (downloadData == null) {
                return downloadData;
            }
            String id = downloadData.getId();
            String name = downloadData.getName();
            if (k.isEmpty(id) || k.isEmpty(name)) {
                return downloadData;
            }
            boolean isForceDownload = downloadData.isForceDownload();
            String str = id.replace(".", "_") + ".apk";
            String j = b.this.j(str);
            File GetFile = FileHelper.GetFile(str);
            if (!isForceDownload && GetFile != null) {
                DownloadData downloadData2 = new DownloadData(id);
                downloadData2.setName(str);
                downloadData2.setPath(j);
                downloadData2.setStatus(3);
                return downloadData2;
            }
            downloadData.setCallback(new d.b.h0.v.a());
            downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
            downloadData.setType(12);
            downloadData.setPath(j);
            return downloadData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(DownloadData downloadData) {
            super.onPostExecute(downloadData);
            b.this.f51931a = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    b.this.o(downloadData);
                    if (downloadData.isNeedInvokeApk()) {
                        Application app = TbadkCoreApplication.getInst().getApp();
                        UtilHelper.install_apk(app, downloadData.getId().replace(".", "_") + ".apk");
                    }
                } else {
                    d.j().l(downloadData, 5);
                    int h2 = b.this.h(downloadData.getId(), downloadData.getName());
                    if (downloadData.isNeedNotify() && h2 <= 0) {
                        String string = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.download_will_begin);
                        Application app2 = TbadkCoreApplication.getInst().getApp();
                        int notifyId = downloadData.getNotifyId();
                        NotificationHelper.showProgressNotification(app2, notifyId, downloadData.getName() + string, 0, string, downloadData.getName(), b.this.g(downloadData.getAction()), false);
                    } else {
                        b.this.p(downloadData);
                    }
                }
                DownloadData unused = b.f51929c = null;
                if (b.f51930d.isEmpty()) {
                    return;
                }
                b.f51930d.remove(0);
                b.this.u();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<ArrayList<AdvertAppInfo>, List<DownloadData>, List<DownloadData>> {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<AdvertAppInfo> f51933a;

        public c() {
            this.f51933a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<DownloadData> doInBackground(ArrayList<AdvertAppInfo>... arrayListArr) {
            ArrayList<AdvertAppInfo> arrayList = arrayListArr[0];
            LinkedList linkedList = new LinkedList();
            if (arrayList == null) {
                return linkedList;
            }
            this.f51933a = arrayList;
            Iterator<AdvertAppInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                String str = next.J3;
                if (FileHelper.GetFile(b.this.i(next.I3)) != null) {
                    DownloadData downloadData = new DownloadData(str);
                    downloadData.setStatus(3);
                    linkedList.add(downloadData);
                }
            }
            return linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<DownloadData> list) {
            super.onPostExecute(list);
            if (list == null) {
                list = new LinkedList<>();
            }
            for (DownloadData downloadData : d.j().i()) {
                Iterator<AdvertAppInfo> it = this.f51933a.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().J3, downloadData.getId())) {
                        list.add(downloadData);
                    }
                }
            }
            b.this.n(list);
            this.f51933a = null;
        }
    }

    public static b l() {
        synchronized (b.class) {
            if (f51928b == null) {
                f51928b = new b();
            }
        }
        return f51928b;
    }

    public final PendingIntent g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(str);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        return PendingIntent.getActivity(TbadkCoreApplication.getInst(), 0, intent, 0);
    }

    public int h(String str, String str2) {
        long k = k(str, str2);
        long j = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (k > j) {
            return 0;
        }
        return (int) ((k * 100) / j);
    }

    public String i(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.contains("?")) {
            str = str.substring(0, str.indexOf("?"));
        }
        String[] split = str.split("/");
        return split[split.length - 1];
    }

    public final String j(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(FileHelper.getCacheDir());
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        sb.append("/");
        sb.append(str);
        return sb.toString();
    }

    public long k(String str, String str2) {
        File GetFile = FileHelper.GetFile(str + "_" + str2 + ".tmp");
        if (GetFile != null && GetFile.exists() && GetFile.isFile()) {
            return GetFile.length();
        }
        return -1L;
    }

    public void m(ArrayList<AdvertAppInfo> arrayList) {
        try {
            new c().execute(arrayList);
        } catch (Exception unused) {
        }
    }

    public void n(List<DownloadData> list) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(list));
    }

    public void o(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
    }

    public void p(DownloadData downloadData) {
        if (downloadData == null || !downloadData.isNeedNotify()) {
            return;
        }
        int h2 = h(downloadData.getId(), downloadData.getName());
        NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, h2, h2 + "%", downloadData.getName(), g(downloadData.getAction()), false);
    }

    public void q(DownloadData downloadData) {
        if (downloadData == null) {
            return;
        }
        List<DownloadData> i = d.j().i();
        if (i != null && i.size() >= 5) {
            downloadData.setStatus(2);
            downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_over_max));
            o(downloadData);
            UtilHelper.showToast(TbadkCoreApplication.getInst(), R.string.download_fail_over_max);
            return;
        }
        f51930d.add(downloadData);
        u();
    }

    public void r(String str, String str2, String str3, int i, int i2) {
        s(str, str2, str3, i, i2, null, true, false, true);
    }

    public void s(String str, String str2, String str3, int i, int i2, String[] strArr, boolean z, boolean z2, boolean z3) {
        DownloadData downloadData = new DownloadData(str);
        downloadData.setType(12);
        downloadData.setId(str);
        downloadData.setUrl(str2);
        downloadData.setName(str3);
        downloadData.setTag(strArr);
        downloadData.setPosition(i);
        downloadData.setNotifyId(i2);
        downloadData.setNeedInvokeApk(z);
        downloadData.setForceDownload(z2);
        downloadData.setNeedNotify(z3);
        q(downloadData);
    }

    public void t(String str, String str2, String str3, String[] strArr) {
        s(str, str2, str3, -1, (int) d.b.c.e.m.b.f(str, 0L), null, true, false, true);
    }

    public final void u() {
        if (f51929c == null) {
            DownloadData downloadData = (DownloadData) ListUtils.getItem(f51930d, 0);
            f51929c = downloadData;
            if (downloadData != null) {
                C1121b c1121b = new C1121b();
                this.f51931a = c1121b;
                c1121b.setPriority(3);
                this.f51931a.execute(f51929c);
            }
        }
    }
}
