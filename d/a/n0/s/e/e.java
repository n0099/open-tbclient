package d.a.n0.s.e;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import com.baidu.tbadk.core.util.CommonHelper;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.WhiteListData;
import com.baidu.tieba.wallet.YYLiveConfig;
import d.a.n0.s.c.b0;
import d.a.n0.s.c.d0;
import d.a.n0.s.c.h;
import d.a.n0.s.c.i;
import d.a.n0.s.c.k0;
import d.a.n0.s.c.s;
import d.a.n0.s.c.t;
import d.a.n0.s.c.u;
import d.a.n0.s.c.x;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: d  reason: collision with root package name */
    public String f54407d;
    public int m;
    public int o;
    public int p;
    public JSONArray t;
    public JSONArray u;
    public JSONArray v;
    public JSONObject w;
    public YYLiveConfig x;
    public d.a.o0.y3.a y;
    public int n = 0;

    /* renamed from: a  reason: collision with root package name */
    public VersionData f54404a = new VersionData();

    /* renamed from: b  reason: collision with root package name */
    public s f54405b = new s();

    /* renamed from: c  reason: collision with root package name */
    public t f54406c = new t();

    /* renamed from: e  reason: collision with root package name */
    public CombineDownload f54408e = new CombineDownload();

    /* renamed from: f  reason: collision with root package name */
    public b0 f54409f = new b0();

    /* renamed from: g  reason: collision with root package name */
    public k0 f54410g = new k0();
    public u q = new u();

    /* renamed from: h  reason: collision with root package name */
    public h f54411h = new h();

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.s.c.d f54412i = new d.a.n0.s.c.d();
    public final d.a.n0.s.c.c k = new d.a.n0.s.c.c();
    public d.a.n0.s.c.a r = new d.a.n0.s.c.a();
    public d0 l = new d0();
    public ABTestExtraData s = new ABTestExtraData();
    public NewGodData z = new NewGodData();
    public x A = new x();
    public d.a.n0.s.c.f j = new d.a.n0.s.c.f();
    public d.a.n0.s.c.g B = new d.a.n0.s.c.g();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a(e eVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.n0.e0.e.c.d().g();
        }
    }

    public void A(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return;
        }
        try {
            this.A.a(x(jSONObject, "index_tab_info"));
            this.f54404a.parserJson(jSONObject.optJSONObject("version"));
            this.f54405b.b(jSONObject.optJSONObject("client"));
            CommonHelper.setIp(jSONObject.optString("client_ip", null));
            d.a.c.e.n.f.g(jSONObject.optString("client_ip", null));
            this.f54406c.f(jSONObject.optJSONObject("config"));
            this.f54410g.X(jSONObject.optJSONObject("wl_config"));
            jSONObject.optJSONObject("channel_icon_config");
            this.j.e(jSONObject.optJSONObject("floating_icon"));
            TbSingleton.getInstance().setAdFloatViewData(this.j);
            String optString = jSONObject.optString("new_god_data", "");
            if (!StringUtils.isNull(optString)) {
                this.z.parserJson(optString);
            }
            this.q.c(jSONObject.optJSONObject("consume_path"));
            TbadkCoreApplication.getInst().setConsumePathData(this.q);
            this.f54407d = jSONObject.optString("config_version");
            this.n = jSONObject.optInt("is_uninterest");
            this.o = jSONObject.optInt("first_time_motivate");
            this.p = jSONObject.optInt("needNewUserLead");
            this.f54408e.parserJson(jSONObject.optJSONObject("combine_download"));
            this.f54409f.a(jSONObject.optJSONObject("mainbar"));
            jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001141, jSONObject));
            this.m = jSONObject.optInt("faceshop_version");
            if (this.m > TbadkCoreApplication.getInst().getFaceShopVersion()) {
                TbadkCoreApplication.getInst().setTempFaceShopVersion(this.m);
                TbadkCoreApplication.getInst().setFaceShopNew(true);
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("lcs_strategy");
            if (optJSONObject != null) {
                TbadkCoreApplication.getInst().setLcsSwitchStratgy(optJSONObject.toString());
            }
            new c().c(jSONObject.optJSONObject("dis_adv_config"));
            WhiteListData whiteListData = new WhiteListData();
            whiteListData.saveJson(jSONObject.optJSONArray("whitelist"));
            TbSingleton.getInstance().setHostWhiteList(whiteListData);
            i.c(jSONObject.optJSONArray("scheme_whitelist"));
            this.f54411h.a(jSONObject.optJSONObject("app_entrance"));
            this.f54412i.k(jSONObject.optJSONObject("ad_adsense"));
            TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
            g.d(jSONObject.optJSONObject("video_report_config"));
            this.k.b(jSONObject.optJSONObject("activity_switch"));
            this.r.b(y(jSONObject, "abtest_config"));
            this.s.parseJson(y(jSONObject, "new_abtest_entra"));
            this.t = x(jSONObject, "new_abtest_config");
            this.u = x(jSONObject, "ubs_abtest_config");
            x(jSONObject, "outside_callback_icon");
            this.v = jSONObject.optJSONArray("windowStrategyList");
            this.w = y(jSONObject, "bear_sdk_config");
            if (y(jSONObject, "advertisement_config") != null) {
                this.B.d(y(jSONObject, "advertisement_config"));
            }
            YYLiveConfig yYLiveConfig = new YYLiveConfig();
            this.x = yYLiveConfig;
            yYLiveConfig.parseJson(y(jSONObject, "yy_live_config"));
            d.a.o0.y3.a aVar = new d.a.o0.y3.a();
            this.y = aVar;
            aVar.c(x(jSONObject, "yy_live_tab"));
            d.a.n0.r.o.a.b().f(this.v);
            this.l.d(jSONObject.optJSONObject("profile_icon"));
            TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
            d.a.n0.r.d0.b.j().t("key_live_forum_enter_switch", jSONObject.optInt("ala_channel_white", 0) == 1);
            TbSingleton.getInstance().setPcdnConfigData(jSONObject.optJSONObject("pcdn_config"));
            JSONArray x = x(jSONObject, "offpack");
            if (x != null && x.length() > 0 && (jSONObject2 = x.getJSONObject(0)) != null) {
                d.a.o0.r2.d.b bVar = new d.a.o0.r2.d.b();
                bVar.e(jSONObject2.optString("mod_name"));
                bVar.f(jSONObject2.optInt("upload_offline_web_cache") == 1);
                bVar.d(jSONObject2.optInt("clear_offline_web_cache") == 1);
                if (!TextUtils.isEmpty(bVar.a())) {
                    TbSingleton.getInstance().setUploadAndClearModule(bVar);
                }
            }
            String optString2 = jSONObject.optString("proxy_ip");
            String optString3 = jSONObject.optString("proxy_port");
            TbadkCoreApplication.getInst().setProxyIp(optString2);
            TbadkCoreApplication.getInst().setProxyPort(optString3);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ad_sdk_priority", jSONObject.optString("ad_sdk_priority", null));
            jSONObject3.put("bear_sid_type", jSONObject.optString("bear_sid_type", null));
            MessageManager.getInstance().runTask(2016552, null, jSONObject3);
            TbSingleton.getInstance().setSyncYYSwitch(jSONObject.optInt("is_yy_user", 1) == 1);
            JSONObject optJSONObject2 = jSONObject.optJSONObject(LowFlowsActivityConfig.LF_USER_INFO);
            if (optJSONObject2 != null) {
                String optString4 = optJSONObject2.optString(LowFlowsActivityConfig.LF_USER);
                TbSingleton.getInstance().setLFUser(optString4);
                if (!StringUtils.isNull(optString4) && "2".equals(optString4)) {
                    TbSingleton.getInstance().setLFUserTaskId(optJSONObject2.optString(LowFlowsActivityConfig.LF_USER_TASKID));
                    TbSingleton.getInstance().setBannerText(optJSONObject2.optString(LowFlowsActivityConfig.LF_BANNER_TEXT));
                }
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("bottom_bubble_config");
            if (optJSONObject3 != null) {
                d.a.n0.e0.e.c.d().h(optJSONObject3);
                d.a.c.e.m.e.a().post(new a(this));
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public d.a.n0.s.c.a a() {
        return this.r;
    }

    public ABTestExtraData b() {
        return this.s;
    }

    public JSONArray c() {
        return this.t;
    }

    public d.a.n0.s.c.c d() {
        return this.k;
    }

    public d.a.n0.s.c.d e() {
        return this.f54412i;
    }

    public d.a.n0.s.c.f f() {
        return this.j;
    }

    public d.a.n0.s.c.g g() {
        return this.B;
    }

    public h h() {
        return this.f54411h;
    }

    public s i() {
        return this.f54405b;
    }

    public CombineDownload j() {
        return this.f54408e;
    }

    public t k() {
        return this.f54406c;
    }

    public JSONObject l() {
        return this.w;
    }

    public boolean m() {
        return this.o == 1;
    }

    public int n() {
        return this.p;
    }

    public int o() {
        return this.n;
    }

    public NewGodData p() {
        return this.z;
    }

    public d0 q() {
        return this.l;
    }

    public JSONArray r() {
        return this.u;
    }

    public VersionData s() {
        return this.f54404a;
    }

    public k0 t() {
        return this.f54410g;
    }

    public YYLiveConfig u() {
        return this.x;
    }

    public d.a.o0.y3.a v() {
        return this.y;
    }

    public String w() {
        return this.f54407d;
    }

    public final JSONArray x(JSONObject jSONObject, String str) {
        try {
            return jSONObject.optJSONArray(str);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return null;
        }
    }

    public final JSONObject y(JSONObject jSONObject, String str) {
        try {
            return jSONObject.optJSONObject(str);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return null;
        }
    }

    public void z(String str) {
        try {
            A(new JSONObject(str));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
