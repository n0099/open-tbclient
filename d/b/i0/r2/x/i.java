package d.b.i0.r2.x;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.state.StopStatus;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import d.b.i0.r2.t;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: c  reason: collision with root package name */
    public static i f59926c;

    /* renamed from: d  reason: collision with root package name */
    public static DownloadData f59927d;

    /* renamed from: e  reason: collision with root package name */
    public static List<DownloadData> f59928e = new LinkedList();

    /* renamed from: f  reason: collision with root package name */
    public static HashMap<String, Integer> f59929f = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public b f59930a = null;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, k> f59931b = new HashMap<>();

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<DownloadData, DownloadData, DownloadData> {
        public b() {
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
            if (d.b.b.e.p.k.isEmpty(id) || d.b.b.e.p.k.isEmpty(name)) {
                return downloadData;
            }
            boolean isForceDownload = downloadData.isForceDownload();
            String f2 = d.b.i0.r2.b.f(id);
            String h2 = d.b.i0.r2.b.h(id);
            File e2 = d.b.i0.r2.b.e(f2);
            if (!isForceDownload && e2 != null) {
                DownloadData downloadData2 = new DownloadData(id);
                downloadData2.setName(f2);
                downloadData2.setPath(h2);
                downloadData2.setStatus(3);
                return downloadData2;
            }
            downloadData.setCallback(new j());
            downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
            downloadData.setType(12);
            downloadData.setPath(h2);
            return downloadData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(DownloadData downloadData) {
            super.onPostExecute(downloadData);
            i.this.f59930a = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    String a2 = d.b.i0.o.c.a.a(TbadkCoreApplication.getInst(), downloadData.getPath());
                    d.b.i0.o.c.g.a.f57194a.get().a().onSuccess(downloadData.getId(), downloadData.getPath());
                    i.this.r(downloadData);
                    if (downloadData.isNeedInvokeApk() && !d.b.i0.o.c.a.b(TbadkCoreApplication.getInst(), a2) && !t.b(d.b.i0.r2.b.h(downloadData.getId()))) {
                        d.b.i0.r2.b.c(new File(d.b.i0.r2.b.h(downloadData.getId())));
                    }
                } else {
                    d.b.i0.o.c.g.a.f57194a.get().a().b(downloadData.getId());
                    d.b.i0.r2.x.a.j().l(downloadData, 5);
                    if (i.this.j(downloadData.getId(), downloadData.getName()) <= 0) {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("0");
                        }
                        if (downloadData.isNeedNotify()) {
                            String string = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.download_will_begin);
                            k kVar = new k(downloadData, 0);
                            i.this.f59931b.put(downloadData.getUrl(), kVar);
                            Application app = TbadkCoreApplication.getInst().getApp();
                            int notifyId = downloadData.getNotifyId();
                            NotificationHelper.showProgressNotification(app, notifyId, downloadData.getUser_name() + string, 0, string, downloadData.getUser_name(), i.this.h(downloadData.getAction()), false, kVar.b(), false);
                        }
                    } else {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("1");
                        }
                        i.this.v(downloadData);
                    }
                }
                DownloadData unused = i.f59927d = null;
                if (d.b.i0.i1.o.k.a.e(i.f59928e)) {
                    return;
                }
                d.b.i0.i1.o.k.a.h(i.f59928e, 0);
                i.this.y();
            }
        }
    }

    public static i l() {
        synchronized (i.class) {
            if (f59926c == null) {
                f59926c = new i();
            }
        }
        return f59926c;
    }

    public static Integer m(String str) {
        if (f59929f.containsKey(str)) {
            return f59929f.get(str);
        }
        Integer valueOf = Integer.valueOf(BdUniqueId.gen().getId());
        f59929f.put(str, valueOf);
        return valueOf;
    }

    public static int n(DownloadData downloadData) {
        int i;
        String id;
        if (d.b.i0.r2.b.j(downloadData.getId())) {
            i = 3;
        } else if (l().o(downloadData.getId())) {
            i = 5;
        } else if (l().p(downloadData.getId())) {
            i = 1;
        } else {
            i = d.b.i0.r2.b.k(downloadData.getId(), downloadData.getName()) ? 7 : 6;
        }
        DownloadStaticsData downloadStaticsData = downloadData.getDownloadStaticsData();
        if (downloadStaticsData != null) {
            id = downloadStaticsData.getApk_name();
        } else {
            id = downloadData.getId();
        }
        if (!TextUtils.isEmpty(id) && d.b.i0.a.e().g() && t.q(id)) {
            return 8;
        }
        return i;
    }

    public void g(String str, String str2, boolean z) {
        if (StringUtils.isNull(str)) {
            return;
        }
        DownloadData downloadData = null;
        for (DownloadData downloadData2 : d.b.i0.r2.x.a.j().i()) {
            if (downloadData2.getId() != null && downloadData2.getId().equals(str2)) {
                downloadData = downloadData2;
            }
        }
        if (z) {
            d.b.i0.r2.x.a.j().g(str, true);
        } else {
            d.b.i0.r2.x.a.j().f(str);
        }
        if (downloadData != null) {
            int j = j(downloadData.getId(), downloadData.getName());
            d.b.i0.o.c.g.a.f57194a.get().a().a(str2, j);
            String str3 = j + "%";
            if (downloadData == null || j < 0) {
                return;
            }
            k kVar = this.f59931b.get(downloadData.getUrl());
            if (kVar == null) {
                kVar = new k(downloadData, j);
            }
            kVar.d();
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str3, downloadData.getUser_name(), h(downloadData.getAction()), false, kVar.b(), false);
        }
    }

    public final PendingIntent h(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(str);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setFlags(268435456);
        return PendingIntent.getActivity(TbadkCoreApplication.getInst(), 0, intent, 0);
    }

    public void i(DownloadData downloadData) {
        d.b.i0.r2.x.a.j().h(downloadData);
        NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
        d.b.i0.o.c.g.a.f57194a.get().a().d(downloadData.getId(), StopStatus.DOWNLOAD_UNSTART);
        r(downloadData);
    }

    public int j(String str, String str2) {
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

    public long k(String str, String str2) {
        File e2 = d.b.i0.r2.b.e(d.b.i0.r2.b.i(str, str2));
        if (e2 != null && e2.exists() && e2.isFile()) {
            return e2.length();
        }
        return -1L;
    }

    public boolean o(String str) {
        for (DownloadData downloadData : d.b.i0.r2.x.a.j().i()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public boolean p(String str) {
        for (DownloadData downloadData : d.b.i0.r2.x.a.j().i()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public void q(DownloadData downloadData) {
        if (downloadData != null) {
            s(downloadData);
            d.b.i0.o.c.g.a.f57194a.get().a().d(downloadData.getId(), StopStatus.DOWNLOAD_FAIL);
            k kVar = this.f59931b.get(downloadData.getUrl());
            if (kVar != null) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, j(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), h(downloadData.getAction()), false, kVar.b(), false);
            }
        }
    }

    public void r(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
    }

    public void s(DownloadData downloadData) {
        if (downloadData != null) {
            k kVar = this.f59931b.get(downloadData.getUrl());
            int j = j(downloadData.getId(), downloadData.getName());
            if (kVar == null) {
                kVar = new k(downloadData, j);
            }
            kVar.d();
        }
    }

    public void t(DownloadData downloadData) {
        if (downloadData != null) {
            k kVar = this.f59931b.get(downloadData.getUrl());
            int j = j(downloadData.getId(), downloadData.getName());
            if (kVar == null) {
                kVar = new k(downloadData, j);
            }
            kVar.e();
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, j(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), h(downloadData.getAction()), false, kVar.b(), false);
        }
    }

    public void u(DownloadData downloadData) {
        String string;
        if (downloadData == null) {
            return;
        }
        int errorCode = downloadData.getErrorCode();
        if (errorCode == 1) {
            string = TbadkCoreApplication.getInst().getString(R.string.download_fail_tip_sdcrad);
        } else if (errorCode != 3) {
            string = TbadkCoreApplication.getInst().getString(R.string.download_fail_tip);
        } else {
            string = TbadkCoreApplication.getInst().getString(R.string.download_fail_tip_net);
        }
        String str = string;
        if (downloadData.isNeedNotify()) {
            int process = downloadData.getProcess();
            Application app = TbadkCoreApplication.getInst().getApp();
            int notifyId = downloadData.getNotifyId();
            NotificationHelper.showProgressNotification(app, notifyId, downloadData.getUser_name() + TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.download_fail_tip), process, process + "%", str, h(downloadData.getAction()), false);
        }
    }

    public void v(DownloadData downloadData) {
        if (downloadData == null || !downloadData.isNeedNotify()) {
            return;
        }
        int j = j(downloadData.getId(), downloadData.getName());
        d.b.i0.o.c.g.a.f57194a.get().a().c(downloadData.getId(), j);
        String str = j + "%";
        k kVar = this.f59931b.get(downloadData.getUrl());
        if (kVar == null) {
            kVar = new k(downloadData, j);
        }
        int n = n(downloadData);
        if (n == 1) {
            kVar.e();
        } else if (n == 4 || n == 2 || n == 7) {
            kVar.d();
        } else if (n == 6) {
            NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
            return;
        }
        kVar.c(j);
        NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str, downloadData.getUser_name(), h(downloadData.getAction()), false, kVar.b(), false);
    }

    public void w(DownloadData downloadData) {
        if (downloadData == null) {
            return;
        }
        List<DownloadData> i = d.b.i0.r2.x.a.j().i();
        if (i != null && i.size() >= 5) {
            downloadData.setStatus(2);
            downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_over_max));
            r(downloadData);
            UtilHelper.showToast(TbadkCoreApplication.getInst(), R.string.download_fail_over_max);
            return;
        }
        d.b.i0.i1.o.k.a.a(f59928e, downloadData);
        y();
    }

    public void x(String str, String str2, String str3, int i, int i2, String[] strArr, boolean z, boolean z2, boolean z3, String str4, DownloadStaticsData downloadStaticsData, String str5) {
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
        downloadData.setApp_icon(str4);
        downloadData.setDownloadStaticsData(downloadStaticsData);
        downloadData.setUser_name(str5);
        w(downloadData);
    }

    public final void y() {
        if (f59927d != null || d.b.i0.i1.o.k.a.e(f59928e)) {
            return;
        }
        DownloadData downloadData = (DownloadData) d.b.i0.i1.o.k.a.d(f59928e, 0);
        f59927d = downloadData;
        if (downloadData != null) {
            b bVar = new b();
            this.f59930a = bVar;
            bVar.setPriority(3);
            this.f59930a.execute(f59927d);
        }
    }
}
