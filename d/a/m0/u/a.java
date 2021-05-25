package d.a.m0.u;

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
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.n0.t2.i0.e;
import d.a.n0.t2.i0.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.LogTogether.AdReq;
/* loaded from: classes3.dex */
public class a {
    public static String o;
    public static a p = new a();

    /* renamed from: f  reason: collision with root package name */
    public Handler f50811f = new HandlerC1164a(Looper.getMainLooper());

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.c.g.a f50812g = new b(CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, 303101);

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f50813h = new c(2000994);

    /* renamed from: i  reason: collision with root package name */
    public final CustomMessageListener f50814i = new d(2001118);
    public HashMap<String, AdvertAppInfo> l = new HashMap<>();
    public HashMap<String, AdvertAppInfo> m = new HashMap<>();
    public HashMap<String, DownloadStaticsData> n = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<AdReq> f50807b = new ArrayList<>();
    public ArrayList<AdvertAppInfo> j = new ArrayList<>();
    public ArrayList<AdvertAppInfo> k = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public boolean f50808c = true;

    /* renamed from: d  reason: collision with root package name */
    public long f50809d = 60000;

    /* renamed from: e  reason: collision with root package name */
    public int f50810e = 10;

    /* renamed from: a  reason: collision with root package name */
    public boolean f50806a = j.z();

    /* renamed from: d.a.m0.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class HandlerC1164a extends Handler {
        public HandlerC1164a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            a.this.i(true);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.a.c.c.g.a {
        public b(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
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
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (j.H() || j.x()) {
                    a.this.t(true);
                } else {
                    a.this.t(false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<DownloadData> data;
            if (!(customResponsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) customResponsedMessage).getData()) == null || data.isEmpty()) {
                return;
            }
            for (int i2 = 0; i2 < data.size(); i2++) {
                DownloadData downloadData = data.get(i2);
                if (downloadData.getType() == 12) {
                    int status = downloadData.getStatus();
                    if (status != 0) {
                        if (status == 1) {
                            a.this.q(downloadData.getId(), downloadData.getDownloadStaticsData());
                        } else if (status != 2 && status != 4) {
                            if (status == 5) {
                                a.this.p(downloadData.getDownloadStaticsData());
                            }
                        }
                    }
                    a.this.r(downloadData.getId(), downloadData.getStatus());
                }
            }
        }
    }

    public static a k() {
        return p;
    }

    public final synchronized void g(List<AdReq> list) {
        if (this.f50807b != null) {
            this.f50807b.addAll(list);
        }
    }

    public void h(AdvertAppInfo advertAppInfo) {
        this.l.put(advertAppInfo.Y3, advertAppInfo);
    }

    public final void i(boolean z) {
        if (this.f50806a && this.f50808c) {
            List<AdReq> l = l(z);
            if (z || !o()) {
                s();
            }
            if (l == null || l.size() == 0) {
                return;
            }
            if (!z) {
                s();
            }
            MessageManager.getInstance().sendMessage(new DistributeRequest(l));
        }
    }

    public final HttpMessageTask j() {
        HttpMessageTask httpMessageTask = new HttpMessageTask(CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, TbConfig.SERVER_ADDRESS + TbConfig.LOG_TOGETHER + "?cmd=303101");
        httpMessageTask.setResponsedClass(DistributeHttpResponse.class);
        return httpMessageTask;
    }

    public final synchronized List<AdReq> l(boolean z) {
        if (!z) {
            if (this.f50807b.size() < this.f50810e) {
                return null;
            }
        }
        if (this.f50807b.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f50807b);
        this.f50807b.clear();
        return arrayList;
    }

    public final SocketMessageTask m() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(303101);
        socketMessageTask.g(true);
        socketMessageTask.setResponsedClass(DistributeSocketResponse.class);
        return socketMessageTask;
    }

    public void n(boolean z) {
        MessageManager messageManager = MessageManager.getInstance();
        if (z) {
            messageManager.registerTask(m());
        }
        messageManager.registerTask(j());
        messageManager.registerListener(this.f50812g);
        messageManager.registerListener(this.f50813h);
        messageManager.registerListener(this.f50814i);
    }

    public final boolean o() {
        return this.f50811f.hasMessages(1);
    }

    public final void p(DownloadStaticsData downloadStaticsData) {
        if (downloadStaticsData != null) {
            d.a.n0.t2.i0.c d2 = g.d(downloadStaticsData, 101, 0);
            d2.r(null);
            d2.a("dl", "delete");
            e.b().d(d2);
        }
    }

    public final void q(String str, DownloadStaticsData downloadStaticsData) {
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
        d.a.n0.t2.i0.c d2 = g.d(downloadStaticsData, 101, 0);
        d2.a("dl", IntentConfig.START);
        e.b().d(d2);
        if (downloadStaticsData == null || !"1".equals(downloadStaticsData.getDa_range_nt())) {
            return;
        }
        downloadStaticsData.setDa_range_nt("0");
    }

    public final void r(String str, int i2) {
        d.a.n0.t2.i0.c d2;
        String str2;
        AdvertAppInfo remove = this.m.remove(str);
        DownloadStaticsData remove2 = this.n.remove(str);
        if (remove != null) {
            d2 = g.b(remove, 101, 0);
        } else if (remove2 == null) {
            return;
        } else {
            d2 = g.d(remove2, 101, 0);
            d2.r(null);
        }
        if (remove == null && remove2 == null) {
            return;
        }
        if (i2 == 0) {
            str2 = "success";
        } else if (i2 == 2) {
            str2 = "fail";
        } else if (i2 != 4) {
            return;
        } else {
            str2 = QueryResponse.Options.CANCEL;
        }
        d2.a("dl", str2);
        e.b().d(d2);
    }

    public final void s() {
        this.f50811f.removeMessages(1);
        this.f50811f.sendEmptyMessageDelayed(1, this.f50809d);
    }

    public final void t(boolean z) {
        if (this.f50806a == z) {
            return;
        }
        this.f50806a = z;
        if (z) {
            i(true);
        } else {
            x();
        }
    }

    public void u(int i2) {
        if (i2 > 3600) {
            this.f50809d = 300000L;
        } else if (i2 <= 0) {
            this.f50809d = 60000L;
        } else {
            this.f50809d = i2 * 1000;
        }
    }

    public void v(int i2) {
        if (i2 > 20) {
            this.f50810e = 10;
        } else if (i2 <= 0) {
            this.f50810e = 5;
        } else {
            this.f50810e = i2;
        }
    }

    public void w(boolean z) {
        this.f50808c = z;
    }

    public final void x() {
        this.f50811f.removeMessages(1);
    }

    public void y(Context context, String str, String str2, long j) {
        if (TextUtils.equals(str, "frs")) {
            z(context, this.j, str, str2, j);
        } else if (TextUtils.equals(str, "pb")) {
            z(context, this.k, str, str2, j);
        }
    }

    public final void z(Context context, ArrayList<AdvertAppInfo> arrayList, String str, String str2, long j) {
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
        int i2 = 0;
        while (i2 < size) {
            AdvertAppInfo advertAppInfo = arrayList2.get(i2);
            if (advertAppInfo != null) {
                if (i2 == size - 1) {
                    sb2.append(advertAppInfo.M3);
                    sb3.append(advertAppInfo.G3);
                    sb5.append(advertAppInfo.N3);
                    sb7.append(advertAppInfo.T3);
                } else {
                    sb2.append(advertAppInfo.M3);
                    sb2.append(FieldBuilder.SE);
                    sb3.append(advertAppInfo.G3);
                    sb3.append(FieldBuilder.SE);
                    sb5.append(advertAppInfo.N3);
                    sb5.append(FieldBuilder.SE);
                    sb7.append(advertAppInfo.T3);
                    sb7.append(FieldBuilder.SE);
                }
            }
            i2++;
            arrayList2 = arrayList;
        }
        StringBuilder sb12 = new StringBuilder(15);
        sb12.append(String.valueOf(l.k(context)));
        sb12.append(",");
        sb12.append(String.valueOf(l.i(context)));
        TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str, "da_locate", sb2, "da_type", "show", "da_obj_id", sb3, "fid", str2, "tid", Long.valueOf(j), "da_good_id", sb4, "da_ext_info", sb5, "da_price", sb6, "da_verify", sb, "cuid", TbadkCoreApplication.getInst().getCuid(), "uid", TbadkCoreApplication.getCurrentAccount(), "baiduid", TbadkCoreApplication.getCurrentBduss(), "da_obj_name", sb7, "da_first_name", sb8, "da_second_name", sb9, "da_cpid", sb10, "da_abtest", sb11, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb12.toString(), "model", Build.MODEL);
        arrayList.clear();
    }
}
