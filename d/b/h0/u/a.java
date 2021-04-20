package d.b.h0.u;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.FieldBuilder;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.distribute.DistributeHttpResponse;
import com.baidu.tbadk.distribute.DistributeRequest;
import com.baidu.tbadk.distribute.DistributeSocketResponse;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.baidu.webkit.internal.ETAG;
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.i0.s2.f0.e;
import d.b.i0.s2.f0.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.LogTogether.AdReq;
/* loaded from: classes3.dex */
public class a {
    public static String o;
    public static a p = new a();

    /* renamed from: f  reason: collision with root package name */
    public Handler f51914f = new HandlerC1119a(Looper.getMainLooper());

    /* renamed from: g  reason: collision with root package name */
    public d.b.c.c.g.a f51915g = new b(CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, 303101);

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f51916h = new c(2000994);
    public final CustomMessageListener i = new d(2001118);
    public HashMap<String, AdvertAppInfo> l = new HashMap<>();
    public HashMap<String, AdvertAppInfo> m = new HashMap<>();
    public HashMap<String, DownloadStaticsData> n = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<AdReq> f51910b = new ArrayList<>();
    public ArrayList<AdvertAppInfo> j = new ArrayList<>();
    public ArrayList<AdvertAppInfo> k = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public boolean f51911c = true;

    /* renamed from: d  reason: collision with root package name */
    public long f51912d = 60000;

    /* renamed from: e  reason: collision with root package name */
    public int f51913e = 10;

    /* renamed from: a  reason: collision with root package name */
    public boolean f51909a = j.z();

    /* renamed from: d.b.h0.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class HandlerC1119a extends Handler {
        public HandlerC1119a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            a.this.j(true);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.b.c.c.g.a {
        public b(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.hasError()) {
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof DistributeRequest) {
                    a.this.g(((DistributeRequest) extra).getAdReqList());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (j.H() || j.x()) {
                    a.this.v(true);
                } else {
                    a.this.v(false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<DownloadData> data;
            if (!(customResponsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) customResponsedMessage).getData()) == null || data.isEmpty()) {
                return;
            }
            for (int i = 0; i < data.size(); i++) {
                DownloadData downloadData = data.get(i);
                if (downloadData.getType() == 12) {
                    int status = downloadData.getStatus();
                    if (status != 0) {
                        if (status == 1) {
                            a.this.r(downloadData.getId(), downloadData.getDownloadStaticsData());
                        } else if (status != 2 && status != 4) {
                            if (status == 5) {
                                a.this.q(downloadData.getDownloadStaticsData());
                            }
                        }
                    }
                    a.this.s(downloadData.getId(), downloadData.getStatus());
                }
            }
        }
    }

    public static a l() {
        return p;
    }

    public void A(Context context, String str, String str2, long j) {
        if (TextUtils.equals(str, "frs")) {
            B(context, this.j, str, str2, j);
        } else if (TextUtils.equals(str, "pb")) {
            B(context, this.k, str, str2, j);
        }
    }

    public final void B(Context context, ArrayList<AdvertAppInfo> arrayList, String str, String str2, long j) {
        ArrayList<AdvertAppInfo> arrayList2 = arrayList;
        if (arrayList2 == null || arrayList.size() <= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();
        StringBuilder sb5 = new StringBuilder();
        StringBuilder sb6 = new StringBuilder();
        StringBuilder sb7 = new StringBuilder();
        StringBuilder sb8 = new StringBuilder();
        StringBuilder sb9 = new StringBuilder();
        StringBuilder sb10 = new StringBuilder();
        StringBuilder sb11 = new StringBuilder();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            AdvertAppInfo advertAppInfo = arrayList2.get(i);
            if (advertAppInfo != null) {
                if (i == size - 1) {
                    sb.append(advertAppInfo.S3);
                    sb2.append(advertAppInfo.K3);
                    sb3.append(advertAppInfo.E3);
                    sb4.append(advertAppInfo.U3.f12864a);
                    sb5.append(advertAppInfo.T3);
                    sb6.append(advertAppInfo.O3);
                    sb7.append(advertAppInfo.F3);
                    sb8.append(advertAppInfo.L3);
                    sb9.append(advertAppInfo.M3);
                    sb10.append(advertAppInfo.N3);
                    sb11.append(advertAppInfo.P3);
                } else {
                    sb.append(advertAppInfo.S3);
                    sb.append(FieldBuilder.SE);
                    sb2.append(advertAppInfo.K3);
                    sb2.append(FieldBuilder.SE);
                    sb3.append(advertAppInfo.E3);
                    sb3.append(FieldBuilder.SE);
                    sb4.append(advertAppInfo.U3.f12864a);
                    sb4.append(FieldBuilder.SE);
                    sb5.append(advertAppInfo.T3);
                    sb5.append(FieldBuilder.SE);
                    sb6.append(advertAppInfo.O3);
                    sb6.append(FieldBuilder.SE);
                    sb7.append(advertAppInfo.F3);
                    sb7.append(FieldBuilder.SE);
                    sb8.append(advertAppInfo.L3);
                    sb8.append(FieldBuilder.SE);
                    sb9.append(advertAppInfo.M3);
                    sb9.append(FieldBuilder.SE);
                    sb10.append(advertAppInfo.N3);
                    sb10.append(FieldBuilder.SE);
                    sb11.append(advertAppInfo.P3);
                    sb11.append(FieldBuilder.SE);
                }
            }
            i++;
            arrayList2 = arrayList;
        }
        StringBuilder sb12 = new StringBuilder(15);
        sb12.append(String.valueOf(l.k(context)));
        sb12.append(",");
        sb12.append(String.valueOf(l.i(context)));
        TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str, "da_locate", sb2, "da_type", "show", "da_obj_id", sb3, "fid", str2, "tid", Long.valueOf(j), "da_good_id", sb4, "da_ext_info", sb5, "da_price", sb6, "da_verify", sb, "cuid", TbadkCoreApplication.getInst().getCuid(), "uid", TbadkCoreApplication.getCurrentAccount(), ETAG.KEY_BAIDU_ID, TbadkCoreApplication.getCurrentBduss(), "da_obj_name", sb7, "da_first_name", sb8, "da_second_name", sb9, "da_cpid", sb10, "da_abtest", sb11, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb12.toString(), "model", Build.MODEL);
        arrayList.clear();
    }

    public final synchronized void g(List<AdReq> list) {
        if (this.f51910b != null) {
            this.f51910b.addAll(list);
        }
    }

    public final synchronized void h(AdReq adReq) {
        if (this.f51910b != null && this.f51910b.size() < 20) {
            this.f51910b.add(adReq);
        }
    }

    public void i(AdvertAppInfo advertAppInfo) {
        this.l.put(advertAppInfo.J3, advertAppInfo);
    }

    public final void j(boolean z) {
        if (this.f51909a && this.f51911c) {
            List<AdReq> m = m(z);
            if (z || !p()) {
                t();
            }
            if (m == null || m.size() == 0) {
                return;
            }
            if (!z) {
                t();
            }
            MessageManager.getInstance().sendMessage(new DistributeRequest(m));
        }
    }

    public final HttpMessageTask k() {
        HttpMessageTask httpMessageTask = new HttpMessageTask(CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, TbConfig.SERVER_ADDRESS + TbConfig.LOG_TOGETHER + "?cmd=303101");
        httpMessageTask.setResponsedClass(DistributeHttpResponse.class);
        return httpMessageTask;
    }

    public final synchronized List<AdReq> m(boolean z) {
        if (!z) {
            if (this.f51910b.size() < this.f51913e) {
                return null;
            }
        }
        if (this.f51910b.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f51910b);
        this.f51910b.clear();
        return arrayList;
    }

    public final SocketMessageTask n() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(303101);
        socketMessageTask.g(true);
        socketMessageTask.setResponsedClass(DistributeSocketResponse.class);
        return socketMessageTask;
    }

    public void o(boolean z) {
        MessageManager messageManager = MessageManager.getInstance();
        if (z) {
            messageManager.registerTask(n());
        }
        messageManager.registerTask(k());
        messageManager.registerListener(this.f51915g);
        messageManager.registerListener(this.f51916h);
        messageManager.registerListener(this.i);
    }

    public final boolean p() {
        return this.f51914f.hasMessages(1);
    }

    public final void q(DownloadStaticsData downloadStaticsData) {
        if (downloadStaticsData != null) {
            d.b.i0.s2.f0.c d2 = h.d(downloadStaticsData, 101, 0);
            d2.s(null);
            d2.a("dl", "delete");
            e.b().d(d2);
        }
    }

    public final void r(String str, DownloadStaticsData downloadStaticsData) {
        AdvertAppInfo remove = this.l.remove(str);
        if (remove != null) {
            this.m.put(str, remove);
        } else if (downloadStaticsData == null || !"1".equals(downloadStaticsData.getDa_range_nt())) {
            return;
        } else {
            this.n.put(str, downloadStaticsData);
            downloadStaticsData.setDa_page(null);
            downloadStaticsData.setFid(null);
        }
        d.b.i0.s2.f0.c d2 = h.d(downloadStaticsData, 101, 0);
        d2.a("dl", IntentConfig.START);
        e.b().d(d2);
        if (downloadStaticsData == null || !"1".equals(downloadStaticsData.getDa_range_nt())) {
            return;
        }
        downloadStaticsData.setDa_range_nt("0");
    }

    public final void s(String str, int i) {
        d.b.i0.s2.f0.c d2;
        String str2;
        AdvertAppInfo remove = this.m.remove(str);
        DownloadStaticsData remove2 = this.n.remove(str);
        if (remove != null) {
            d2 = h.b(remove, 101, 0);
        } else if (remove2 == null) {
            return;
        } else {
            d2 = h.d(remove2, 101, 0);
            d2.s(null);
        }
        if (remove == null && remove2 == null) {
            return;
        }
        if (i == 0) {
            str2 = "success";
        } else if (i == 2) {
            str2 = "fail";
        } else if (i != 4) {
            return;
        } else {
            str2 = QueryResponse.Options.CANCEL;
        }
        d2.a("dl", str2);
        e.b().d(d2);
    }

    public final void t() {
        this.f51914f.removeMessages(1);
        this.f51914f.sendEmptyMessageDelayed(1, this.f51912d);
    }

    public void u(AdvertAppInfo advertAppInfo, String str, long j, String str2, String str3, int i) {
        if (advertAppInfo == null) {
            return;
        }
        AdReq A4 = advertAppInfo.A4(str, j, str2, str3, i);
        if (TextUtils.equals(str3, "show")) {
            h(A4);
        }
        if (TextUtils.equals(str3, PrefetchEvent.STATE_CLICK) || TextUtils.equals(str3, "download")) {
            if (this.f51909a) {
                MessageManager.getInstance().sendMessage(new DistributeRequest(A4));
            } else {
                h(A4);
            }
        }
        j(false);
    }

    public final void v(boolean z) {
        if (this.f51909a == z) {
            return;
        }
        this.f51909a = z;
        if (z) {
            j(true);
        } else {
            z();
        }
    }

    public void w(int i) {
        if (i > 3600) {
            this.f51912d = 300000L;
        } else if (i <= 0) {
            this.f51912d = 60000L;
        } else {
            this.f51912d = i * 1000;
        }
    }

    public void x(int i) {
        if (i > 20) {
            this.f51913e = 10;
        } else if (i <= 0) {
            this.f51913e = 5;
        } else {
            this.f51913e = i;
        }
    }

    public void y(boolean z) {
        this.f51911c = z;
    }

    public final void z() {
        this.f51914f.removeMessages(1);
    }
}
