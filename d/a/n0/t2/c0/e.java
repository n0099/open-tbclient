package d.a.n0.t2.c0;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: c  reason: collision with root package name */
    public static e f64635c;

    /* renamed from: d  reason: collision with root package name */
    public static DownloadData f64636d;

    /* renamed from: e  reason: collision with root package name */
    public static List<DownloadData> f64637e = new LinkedList();

    /* renamed from: f  reason: collision with root package name */
    public static HashMap<String, Integer> f64638f = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public b f64639a = null;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, g> f64640b = new HashMap<>();

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
            String str = id.replace(".", "_") + ".apk";
            String l = e.l(str);
            File GetFile = FileHelper.GetFile(str);
            if (!isForceDownload && GetFile != null) {
                DownloadData downloadData2 = new DownloadData(id);
                downloadData2.setName(str);
                downloadData2.setPath(l);
                downloadData2.setStatus(3);
                return downloadData2;
            }
            downloadData.setCallback(new d.a.m0.v.a());
            downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
            downloadData.setType(12);
            downloadData.setPath(l);
            return downloadData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(DownloadData downloadData) {
            super.onPostExecute(downloadData);
            e.this.f64639a = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    e.this.y(downloadData);
                    if (downloadData.isNeedInvokeApk()) {
                        Application app = TbadkCoreApplication.getInst().getApp();
                        UtilHelper.install_apk(app, downloadData.getId().replace(".", "_") + ".apk");
                    }
                } else {
                    f.j().l(downloadData, 5);
                    if (e.this.j(downloadData.getId(), downloadData.getName()) <= 0) {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("0");
                        }
                        if (downloadData.isNeedNotify()) {
                            String string = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.download_will_begin);
                            g gVar = new g(downloadData, 0);
                            e.this.f64640b.put(downloadData.getUrl(), gVar);
                            Application app2 = TbadkCoreApplication.getInst().getApp();
                            int notifyId = downloadData.getNotifyId();
                            NotificationHelper.showProgressNotification(app2, notifyId, downloadData.getUser_name() + string, 0, string, downloadData.getUser_name(), e.this.h(downloadData.getAction()), false, gVar.b(), false);
                        }
                    } else {
                        if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("1");
                        }
                        e.this.C(downloadData);
                    }
                }
                DownloadData unused = e.f64636d = null;
                if (e.f64637e.isEmpty()) {
                    return;
                }
                e.f64637e.remove(0);
                e.this.F();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<ArrayList<AdvertAppInfo>, List<DownloadData>, List<DownloadData>> {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<AdvertAppInfo> f64642a;

        public c() {
            this.f64642a = null;
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
            this.f64642a = arrayList;
            Iterator<AdvertAppInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                String downloadId = next.getDownloadId();
                if (FileHelper.GetFile(e.this.k(next.a4)) != null) {
                    DownloadData downloadData = new DownloadData(downloadId);
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
            for (DownloadData downloadData : f.j().i()) {
                Iterator<AdvertAppInfo> it = this.f64642a.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().getDownloadId(), downloadData.getId())) {
                        list.add(downloadData);
                    }
                }
            }
            e.this.x(list);
            this.f64642a = null;
        }
    }

    public static String l(String str) {
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

    public static e n() {
        synchronized (e.class) {
            if (f64635c == null) {
                f64635c = new e();
            }
        }
        return f64635c;
    }

    public static Integer o(String str) {
        if (f64638f.containsKey(str)) {
            return f64638f.get(str);
        }
        Integer valueOf = Integer.valueOf(BdUniqueId.gen().getId());
        f64638f.put(str, valueOf);
        return valueOf;
    }

    public static int p(DownloadData downloadData) {
        int i2;
        String id;
        if (n().t(downloadData.getId())) {
            i2 = 3;
        } else if (n().r(downloadData.getId())) {
            i2 = 5;
        } else if (n().u(downloadData.getId())) {
            i2 = 1;
        } else {
            i2 = n().q(downloadData.getId(), downloadData.getName()) ? 7 : 6;
        }
        DownloadStaticsData downloadStaticsData = downloadData.getDownloadStaticsData();
        if (downloadStaticsData != null) {
            id = downloadStaticsData.getApk_name();
        } else {
            id = downloadData.getId();
        }
        if (!TextUtils.isEmpty(id) && d.a.n0.a.h().v() && n().s(id)) {
            return 8;
        }
        return i2;
    }

    public void A(DownloadData downloadData) {
        if (downloadData != null) {
            g gVar = this.f64640b.get(downloadData.getUrl());
            int j = j(downloadData.getId(), downloadData.getName());
            if (gVar == null) {
                gVar = new g(downloadData, j);
            }
            gVar.e();
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, j(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), h(downloadData.getAction()), false, gVar.b(), false);
        }
    }

    public void B(DownloadData downloadData) {
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

    public void C(DownloadData downloadData) {
        if (downloadData == null || !downloadData.isNeedNotify()) {
            return;
        }
        int j = j(downloadData.getId(), downloadData.getName());
        String str = j + "%";
        g gVar = this.f64640b.get(downloadData.getUrl());
        if (gVar == null) {
            gVar = new g(downloadData, j);
        }
        int p = p(downloadData);
        if (p == 1) {
            gVar.e();
        } else if (p == 4 || p == 2 || p == 7) {
            gVar.d();
        } else if (p == 6) {
            NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
            return;
        }
        gVar.c(j);
        NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str, downloadData.getUser_name(), h(downloadData.getAction()), false, gVar.b(), false);
    }

    public void D(DownloadData downloadData) {
        if (downloadData == null) {
            return;
        }
        List<DownloadData> i2 = f.j().i();
        if (i2 != null && i2.size() >= 5) {
            downloadData.setStatus(2);
            downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_over_max));
            y(downloadData);
            UtilHelper.showToast(TbadkCoreApplication.getInst(), R.string.download_fail_over_max);
            return;
        }
        f64637e.add(downloadData);
        F();
    }

    public void E(String str, String str2, String str3, int i2, int i3, String[] strArr, boolean z, boolean z2, boolean z3, String str4, DownloadStaticsData downloadStaticsData, String str5) {
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
        D(downloadData);
    }

    public final void F() {
        if (f64636d != null || f64637e.isEmpty()) {
            return;
        }
        DownloadData downloadData = f64637e.get(0);
        f64636d = downloadData;
        if (downloadData != null) {
            b bVar = new b();
            this.f64639a = bVar;
            bVar.setPriority(3);
            this.f64639a.execute(f64636d);
        }
    }

    public void g(String str, String str2, boolean z) {
        if (StringUtils.isNull(str)) {
            return;
        }
        DownloadData downloadData = null;
        for (DownloadData downloadData2 : f.j().i()) {
            if (downloadData2.getId() != null && downloadData2.getId().equals(str2)) {
                downloadData = downloadData2;
            }
        }
        if (z) {
            f.j().g(str, true);
        } else {
            f.j().f(str);
        }
        if (downloadData != null) {
            int j = j(downloadData.getId(), downloadData.getName());
            String str3 = j + "%";
            if (downloadData == null || j < 0) {
                return;
            }
            g gVar = this.f64640b.get(downloadData.getUrl());
            if (gVar == null) {
                gVar = new g(downloadData, j);
            }
            gVar.d();
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str3, downloadData.getUser_name(), h(downloadData.getAction()), false, gVar.b(), false);
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
        f.j().h(downloadData);
        NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
        y(downloadData);
    }

    public int j(String str, String str2) {
        long m = m(str, str2);
        long j = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (m > j) {
            return 0;
        }
        return (int) ((m * 100) / j);
    }

    public String k(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.contains("?")) {
            str = str.substring(0, str.indexOf("?"));
        }
        String[] split = str.split("/");
        return split[split.length - 1];
    }

    public long m(String str, String str2) {
        File GetFile = FileHelper.GetFile(str + "_" + str2 + ".tmp");
        if (GetFile != null && GetFile.exists() && GetFile.isFile()) {
            return GetFile.length();
        }
        return -1L;
    }

    public boolean q(String str, String str2) {
        if (TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L) == 0) {
            return false;
        }
        File GetFile = FileHelper.GetFile(str + "_" + str2 + ".tmp");
        return GetFile != null && GetFile.exists() && GetFile.isFile();
    }

    public boolean r(String str) {
        for (DownloadData downloadData : f.j().i()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public final boolean s(String str) {
        TbadkApplication inst = TbadkApplication.getInst();
        if (inst != null) {
            try {
                if (inst.getPackageManager() != null) {
                    inst.getPackageManager().getPackageInfo(str, 64);
                    return true;
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }

    public boolean t(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str.replace(".", "_"));
        sb.append(".apk");
        return FileHelper.GetFile(sb.toString()) != null;
    }

    public boolean u(String str) {
        for (DownloadData downloadData : f.j().i()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public void v(DownloadData downloadData) {
        if (downloadData != null) {
            z(downloadData);
            g gVar = this.f64640b.get(downloadData.getUrl());
            if (gVar != null) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, j(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), h(downloadData.getAction()), false, gVar.b(), false);
            }
        }
    }

    public void w(ArrayList<AdvertAppInfo> arrayList) {
        try {
            new c().execute(arrayList);
        } catch (Exception unused) {
        }
    }

    public void x(List<DownloadData> list) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(list));
    }

    public void y(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
    }

    public void z(DownloadData downloadData) {
        if (downloadData != null) {
            g gVar = this.f64640b.get(downloadData.getUrl());
            int j = j(downloadData.getId(), downloadData.getName());
            if (gVar == null) {
                gVar = new g(downloadData, j);
            }
            gVar.d();
        }
    }
}
