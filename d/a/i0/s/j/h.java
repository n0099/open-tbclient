package d.a.i0.s.j;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.coreExtra.message.UpdateClientInfoMessage;
import com.baidu.tbadk.switchs.NetDeleteSwitch;
import com.baidu.tbadk.switchs.NetTypeFixedSwitch;
import com.baidu.tieba.recapp.report.AdUploadHttpRequest;
import com.baidu.tieba.yunpush.BaiduYunPushMessageReceiver;
import d.a.c.c.f.j;
import d.a.c.e.p.l;
import d.a.c.e.r.k;
import d.a.i0.r.l.a;
import java.util.Map;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: f  reason: collision with root package name */
    public static h f49868f;

    /* renamed from: a  reason: collision with root package name */
    public int f49869a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.c.c.e.c.k.a f49870b = null;

    /* renamed from: c  reason: collision with root package name */
    public UpdateClientInfoMessage f49871c = null;

    /* renamed from: d  reason: collision with root package name */
    public int f49872d = 0;

    /* renamed from: e  reason: collision with root package name */
    public final d.a.c.c.e.c.k.a f49873e = new a();

    /* loaded from: classes3.dex */
    public class a implements d.a.c.c.e.c.k.a {
        public a() {
        }

        @Override // d.a.c.c.e.c.k.a
        public void a(String str) {
            if (h.this.f49870b != null) {
                h.this.f49870b.a(str);
            }
        }

        @Override // d.a.c.c.e.c.k.a
        public boolean b(int i2, String str) {
            d.a.i0.c0.a.b(0, 2, 0, 0, 0);
            if (h.this.f49870b != null) {
                h.this.f49870b.b(i2, str);
            }
            return false;
        }

        @Override // d.a.c.c.e.c.k.a
        public void c(d.a.c.e.r.c cVar) {
            if (h.this.f49870b != null) {
                h.this.f49870b.c(cVar);
            }
        }

        @Override // d.a.c.c.e.c.k.a
        public void d(k kVar) {
            if (h.this.f49870b != null) {
                h.this.f49870b.d(kVar);
            }
        }

        @Override // d.a.c.c.e.c.k.a
        public void g(Map<String, String> map) {
            d.a.i0.c0.a.b(0, 1, 0, 0, 0);
            if (h.this.f49870b != null) {
                h.this.f49870b.g(map);
            }
            d.a.c.c.e.c.i.a("TbOnline", 1001, 0, "begin_online", 0, "begin online");
            if (d.a.i0.m0.k.d().g() && h.b(h.this) < 10) {
                d.a.c.c.e.c.i.e();
            }
            d.a.i0.c0.a.b(1001, 0, 0, 3, 0);
            h hVar = h.this;
            hVar.f49871c = hVar.i();
            MessageManager.getInstance().sendMessage(h.this.f49871c);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends j {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.c.f.g
        /* renamed from: c */
        public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
            long j;
            int i2;
            if (!(socketResponsedMessage instanceof ResponseOnlineMessage)) {
                h.this.o(socketResponsedMessage.getCmd(), -1, null);
                return null;
            }
            ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
            if (responseOnlineMessage.getOrginalMessage() == null || !(responseOnlineMessage.getOrginalMessage() instanceof SocketMessage)) {
                j = 0;
                i2 = 0;
            } else {
                i2 = ((SocketMessage) responseOnlineMessage.getOrginalMessage()).getSquencedId();
                j = ((SocketMessage) responseOnlineMessage.getOrginalMessage()).getClientLogID();
            }
            if (responseOnlineMessage.getError() != 0) {
                h.this.o(socketResponsedMessage.getCmd(), responseOnlineMessage.getError(), responseOnlineMessage.getErrorString());
                d.a.c.c.e.c.i.b("TbOnline", socketResponsedMessage.getCmd(), j, i2, "online_failed", responseOnlineMessage.getError(), responseOnlineMessage.getErrorString() + "online failed. count-" + h.this.f49869a);
                return null;
            }
            h.this.m();
            d.a.c.c.e.c.i.b("TbOnline", socketResponsedMessage.getCmd(), j, i2, "online_succ", 0, "online succ. retry count-" + h.this.f49869a);
            return socketResponsedMessage;
        }
    }

    public h() {
        MessageManager.getInstance().addResponsedMessageRule(new b(1001));
    }

    public static /* synthetic */ int b(h hVar) {
        int i2 = hVar.f49872d + 1;
        hVar.f49872d = i2;
        return i2;
    }

    public static synchronized h j() {
        h hVar;
        synchronized (h.class) {
            if (f49868f == null) {
                synchronized (h.class) {
                    if (f49868f == null) {
                        f49868f = new h();
                    }
                }
            }
            hVar = f49868f;
        }
        return hVar;
    }

    public final UpdateClientInfoMessage i() {
        String valueOf;
        UpdateClientInfoMessage updateClientInfoMessage = new UpdateClientInfoMessage();
        updateClientInfoMessage.addUserInfo(HttpRequest.CLIENT_TYPE, "2");
        updateClientInfoMessage.addUserInfo(HttpRequest.CLIENT_VERSION, TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            updateClientInfoMessage.addUserInfo(HttpRequest.PHONE_IMEI, TbadkCoreApplication.getInst().getImei());
        }
        String clientId = TbadkCoreApplication.getClientId();
        if (clientId != null) {
            updateClientInfoMessage.addUserInfo(HttpRequest.CLIENT_ID, clientId);
        }
        if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
            updateClientInfoMessage.addUserInfo(HttpRequest.SUBAPP_TYPE, TbConfig.getSubappType());
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            updateClientInfoMessage.addUserInfo("from", from);
        }
        if (NetTypeFixedSwitch.isOn()) {
            updateClientInfoMessage.addUserInfo("net_type", String.valueOf(d.a.c.e.p.j.I()));
        } else {
            String str = new NetWork().getNetContext().getRequest().getNetWorkParam().mNetType;
            if (str != null) {
                updateClientInfoMessage.addUserInfo("net_type", str);
            }
        }
        if (!NetDeleteSwitch.isOn() && (valueOf = String.valueOf(d.a.c.e.p.j.I())) != null) {
            updateClientInfoMessage.addUserInfo("net", valueOf);
        }
        updateClientInfoMessage.addUserInfo("cuid", TbadkCoreApplication.getInst().getCuid());
        updateClientInfoMessage.addUserInfo(TiebaStatic.Params.CUID_GALAXY2, TbadkCoreApplication.getInst().getCuidGalaxy2());
        updateClientInfoMessage.addUserInfo("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
        updateClientInfoMessage.addUserInfo(TiebaStatic.Params.CUID_GID, TbadkCoreApplication.getInst().getCuidGid());
        updateClientInfoMessage.addUserInfo("timestamp", Long.toString(System.currentTimeMillis()));
        updateClientInfoMessage.addUserInfo("model", Build.MODEL);
        updateClientInfoMessage.addUserInfo(TiebaStatic.Params.SAMPLE_ID, TbSingleton.getInstance().getSampleId());
        updateClientInfoMessage.addUserInfo("sdk_ver", TbadkCoreApplication.getInst().getSdk_ver());
        updateClientInfoMessage.addUserInfo("framework_ver", TbadkCoreApplication.getInst().getFramework_ver());
        updateClientInfoMessage.addUserInfo("swan_game_ver", TbadkCoreApplication.getInst().getSwan_game_ver());
        updateClientInfoMessage.addUserInfo(AdUploadHttpRequest.KEY_OS_VERSION, Build.VERSION.RELEASE);
        StringBuffer stringBuffer = new StringBuffer(15);
        stringBuffer.append(String.valueOf(l.k(TbadkCoreApplication.getInst().getApp())));
        stringBuffer.append(",");
        stringBuffer.append(String.valueOf(l.i(TbadkCoreApplication.getInst().getApp())));
        updateClientInfoMessage.addUserInfo("_phone_screen", stringBuffer.toString());
        if (d.a.i0.s.d.d.d().e() > 0) {
            updateClientInfoMessage.addUserInfo("_msg_status", "0");
        } else {
            updateClientInfoMessage.addUserInfo("_msg_status", "1");
        }
        updateClientInfoMessage.addUserInfo("_pic_quality", String.valueOf(d.a.i0.r.k.c().e()));
        String yunpushChannelId = TbadkCoreApplication.getInst().getYunpushChannelId();
        Log.i(BaiduYunPushMessageReceiver.TAG, "channel_id " + yunpushChannelId);
        if (!TextUtils.isEmpty(yunpushChannelId)) {
            updateClientInfoMessage.addUserInfo("channel_id", yunpushChannelId);
        }
        try {
            if (TbadkCoreApplication.isLogin()) {
                a.b d2 = d.a.i0.r.l.a.b().d(TbadkCoreApplication.getCurrentBduss());
                String a2 = d.a.i0.r.l.e.a(TbadkCoreApplication.getCurrentAccountInfo());
                if (d2 != null) {
                    updateClientInfoMessage.setBduss(d2.f48989a, a2);
                } else {
                    updateClientInfoMessage.setBduss(TbadkCoreApplication.getCurrentBduss(), a2);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        int e3 = l.e(TbadkCoreApplication.getInst().getContext(), 70.0f);
        updateClientInfoMessage.setHeight(l.e(TbadkCoreApplication.getInst().getContext(), 70.0f));
        updateClientInfoMessage.setWidth(e3);
        if (d.a.i0.s.b.a.b().d()) {
            updateClientInfoMessage.setPub_env(Integer.valueOf(d.a.i0.s.b.a.b().c()));
        }
        if (TbSingleton.getInstance().isVisitPreviewServer()) {
            updateClientInfoMessage.setPub_env(Integer.valueOf(d.a.c.e.m.b.d(TbSingleton.getInstance().getPubEnvValue(), 0)));
        }
        updateClientInfoMessage.setSecretKey(d.a.c.c.e.c.j.d.a().c());
        updateClientInfoMessage.addUserInfo("pversion", "1.0.3");
        if (TbadkCoreApplication.getInst().getCustomizedFilter() != null) {
            updateClientInfoMessage = TbadkCoreApplication.getInst().getCustomizedFilter().c(updateClientInfoMessage);
        }
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        updateClientInfoMessage.addUserInfo("q_type", String.valueOf(d.a.i0.r.k.c().e()));
        updateClientInfoMessage.addUserInfo("scr_h", String.valueOf(l.i(inst)));
        updateClientInfoMessage.addUserInfo("scr_w", String.valueOf(l.k(inst)));
        updateClientInfoMessage.addUserInfo("scr_dip", String.valueOf(Double.valueOf(l.h(inst))));
        updateClientInfoMessage.addUserInfo("active_timestamp", TbSingleton.getInstance().getActiveTimeStamp() + "");
        updateClientInfoMessage.addUserInfo("first_install_time", TbSingleton.getInstance().getAppFirstInstallTime() + "");
        updateClientInfoMessage.addUserInfo(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, TbSingleton.getInstance().getAppLastUpdateTime() + "");
        updateClientInfoMessage.addUserInfo("event_day", TbSingleton.getInstance().getData());
        updateClientInfoMessage.addUserInfo(IAdRequestParam.ANDROID_ID, TbadkCoreApplication.getInst().getAndroidId());
        return updateClientInfoMessage;
    }

    public void k() {
        MessageManager.getInstance().getSocketClient().G(this.f49873e);
    }

    public boolean l() {
        return this.f49869a >= 5;
    }

    public final void m() {
        this.f49869a = 0;
        MessageManager.getInstance().getSocketClient().I();
        NoNetworkView.f();
        BdSocketLinkService.stopReConnStrategy("online succ");
    }

    public void n() {
        this.f49869a++;
        if (l()) {
            BdSocketLinkService.setAvailable(false);
            NoNetworkView.f();
        }
    }

    public final void o(int i2, int i3, String str) {
        n();
        BdSocketLinkService.close(8, "online error = " + i3);
    }

    public void p(d.a.c.c.e.c.k.a aVar) {
        this.f49870b = aVar;
    }
}
