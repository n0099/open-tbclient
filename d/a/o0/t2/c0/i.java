package d.a.o0.t2.c0;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
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
import d.a.o0.t2.y;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: c  reason: collision with root package name */
    public static i f64778c;

    /* renamed from: d  reason: collision with root package name */
    public static DownloadData f64779d;

    /* renamed from: e  reason: collision with root package name */
    public static List<DownloadData> f64780e = new LinkedList();

    /* renamed from: f  reason: collision with root package name */
    public static HashMap<String, Integer> f64781f = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public b f64782a = null;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, k> f64783b = new HashMap<>();

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
            if (d.a.c.e.p.k.isEmpty(id) || d.a.c.e.p.k.isEmpty(name)) {
                return downloadData;
            }
            boolean isForceDownload = downloadData.isForceDownload();
            String f2 = d.a.o0.t2.b.f(id);
            String h2 = d.a.o0.t2.b.h(id);
            File e2 = d.a.o0.t2.b.e(f2);
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
            i.this.f64782a = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    String a2 = d.a.o0.q.d.a.a(TbadkCoreApplication.getInst(), downloadData.getPath());
                    d.a.o0.q.d.i.a.f62048a.get().c().onSuccess(downloadData.getId(), downloadData.getPath());
                    i.this.r(downloadData);
                    if (downloadData.isNeedInvokeApk() && !d.a.o0.q.d.a.b(TbadkCoreApplication.getInst(), a2) && !y.b(d.a.o0.t2.b.h(downloadData.getId()))) {
                        d.a.o0.t2.b.c(new File(d.a.o0.t2.b.h(downloadData.getId())));
                    }
                } else {
                    d.a.o0.q.d.i.a.f62048a.get().c().c(downloadData.getId());
                    d.a.o0.t2.c0.a.j().l(downloadData, 5);
                    if (i.this.j(downloadData.getId(), downloadData.getName()) <= 0) {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("0");
                        }
                        if (downloadData.isNeedNotify()) {
                            String string = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.download_will_begin);
                            k kVar = new k(downloadData, 0);
                            i.this.f64783b.put(downloadData.getUrl(), kVar);
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
                DownloadData unused = i.f64779d = null;
                if (d.a.o0.k1.o.k.a.e(i.f64780e)) {
                    return;
                }
                d.a.o0.k1.o.k.a.i(i.f64780e, 0);
                i.this.y();
            }
        }
    }

    public static i l() {
        synchronized (i.class) {
            if (f64778c == null) {
                f64778c = new i();
            }
        }
        return f64778c;
    }

    public static Integer m(String str) {
        if (f64781f.containsKey(str)) {
            return f64781f.get(str);
        }
        Integer valueOf = Integer.valueOf(BdUniqueId.gen().getId());
        f64781f.put(str, valueOf);
        return valueOf;
    }

    public static int n(DownloadData downloadData) {
        int i2;
        String id;
        if (d.a.o0.t2.b.j(downloadData.getId())) {
            i2 = 3;
        } else if (l().o(downloadData.getId())) {
            i2 = 5;
        } else if (l().p(downloadData.getId())) {
            i2 = 1;
        } else {
            i2 = d.a.o0.t2.b.k(downloadData.getId(), downloadData.getName()) ? 7 : 6;
        }
        DownloadStaticsData downloadStaticsData = downloadData.getDownloadStaticsData();
        if (downloadStaticsData != null) {
            id = downloadStaticsData.getApk_name();
        } else {
            id = downloadData.getId();
        }
        if (!TextUtils.isEmpty(id) && d.a.o0.a.h().v() && y.q(id)) {
            return 8;
        }
        return i2;
    }

    public void g(String str, String str2, boolean z) {
        if (StringUtils.isNull(str)) {
            return;
        }
        DownloadData downloadData = null;
        for (DownloadData downloadData2 : d.a.o0.t2.c0.a.j().i()) {
            if (downloadData2.getId() != null && downloadData2.getId().equals(str2)) {
                downloadData = downloadData2;
            }
        }
        if (z) {
            d.a.o0.t2.c0.a.j().g(str, true);
        } else {
            d.a.o0.t2.c0.a.j().f(str);
        }
        if (downloadData != null) {
            int j = j(downloadData.getId(), downloadData.getName());
            d.a.o0.q.d.i.a.f62048a.get().c().a(str2, j);
            String str3 = j + "%";
            if (downloadData == null || j < 0) {
                return;
            }
            k kVar = this.f64783b.get(downloadData.getUrl());
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
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        return PendingIntent.getActivity(TbadkCoreApplication.getInst(), 0, intent, 0);
    }

    public void i(DownloadData downloadData) {
        d.a.o0.t2.c0.a.j().h(downloadData);
        NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
        d.a.o0.q.d.i.a.f62048a.get().c().b(downloadData.getId(), StopStatus.DOWNLOAD_UNSTART);
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
        File e2 = d.a.o0.t2.b.e(d.a.o0.t2.b.i(str, str2));
        if (e2 != null && e2.exists() && e2.isFile()) {
            return e2.length();
        }
        return -1L;
    }

    public boolean o(String str) {
        for (DownloadData downloadData : d.a.o0.t2.c0.a.j().i()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public boolean p(String str) {
        for (DownloadData downloadData : d.a.o0.t2.c0.a.j().i()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public void q(DownloadData downloadData) {
        if (downloadData != null) {
            s(downloadData);
            d.a.o0.q.d.i.a.f62048a.get().c().b(downloadData.getId(), StopStatus.DOWNLOAD_FAIL);
            k kVar = this.f64783b.get(downloadData.getUrl());
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
            k kVar = this.f64783b.get(downloadData.getUrl());
            int j = j(downloadData.getId(), downloadData.getName());
            if (kVar == null) {
                kVar = new k(downloadData, j);
            }
            kVar.d();
        }
    }

    public void t(DownloadData downloadData) {
        if (downloadData != null) {
            k kVar = this.f64783b.get(downloadData.getUrl());
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
        d.a.o0.q.d.i.a.f62048a.get().c().d(downloadData.getId(), j);
        String str = j + "%";
        k kVar = this.f64783b.get(downloadData.getUrl());
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
        List<DownloadData> i2 = d.a.o0.t2.c0.a.j().i();
        if (i2 != null && i2.size() >= 5) {
            downloadData.setStatus(2);
            downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_over_max));
            r(downloadData);
            UtilHelper.showToast(TbadkCoreApplication.getInst(), R.string.download_fail_over_max);
            return;
        }
        d.a.o0.k1.o.k.a.a(f64780e, downloadData);
        y();
    }

    public void x(String str, String str2, String str3, int i2, int i3, String[] strArr, boolean z, boolean z2, boolean z3, String str4, DownloadStaticsData downloadStaticsData, String str5) {
        DownloadData downloadData = new DownloadData(str);
        downloadData.setType(12);
        downloadData.setId(str);
        downloadData.setUrl(str2);
        downloadData.setName(str3);
        downloadData.setTag(strArr);
        downloadData.setPosition(i2);
        downloadData.setNotifyId(i3);
        downloadData.setNeedInvokeApk(z);
        downloadData.setForceDownload(z2);
        downloadData.setNeedNotify(z3);
        downloadData.setApp_icon(str4);
        downloadData.setDownloadStaticsData(downloadStaticsData);
        downloadData.setUser_name(str5);
        w(downloadData);
    }

    public final void y() {
        if (f64779d != null || d.a.o0.k1.o.k.a.e(f64780e)) {
            return;
        }
        DownloadData downloadData = (DownloadData) d.a.o0.k1.o.k.a.d(f64780e, 0);
        f64779d = downloadData;
        if (downloadData != null) {
            b bVar = new b();
            this.f64782a = bVar;
            bVar.setPriority(3);
            this.f64782a.execute(f64779d);
        }
    }
}
