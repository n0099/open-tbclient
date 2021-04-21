package d.b.i0.s.e;

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
import d.b.i0.s.c.a0;
import d.b.i0.s.c.c0;
import d.b.i0.s.c.h;
import d.b.i0.s.c.i;
import d.b.i0.s.c.j0;
import d.b.i0.s.c.s;
import d.b.i0.s.c.t;
import d.b.i0.s.c.u;
import d.b.i0.s.c.w;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: d  reason: collision with root package name */
    public String f52072d;
    public int m;
    public int o;
    public int p;
    public JSONArray t;
    public JSONArray u;
    public JSONArray v;
    public JSONObject w;
    public int n = 0;

    /* renamed from: a  reason: collision with root package name */
    public VersionData f52069a = new VersionData();

    /* renamed from: b  reason: collision with root package name */
    public s f52070b = new s();

    /* renamed from: c  reason: collision with root package name */
    public t f52071c = new t();

    /* renamed from: e  reason: collision with root package name */
    public CombineDownload f52073e = new CombineDownload();

    /* renamed from: f  reason: collision with root package name */
    public a0 f52074f = new a0();

    /* renamed from: g  reason: collision with root package name */
    public j0 f52075g = new j0();
    public u q = new u();

    /* renamed from: h  reason: collision with root package name */
    public h f52076h = new h();
    public d.b.i0.s.c.d i = new d.b.i0.s.c.d();
    public final d.b.i0.s.c.c k = new d.b.i0.s.c.c();
    public d.b.i0.s.c.a r = new d.b.i0.s.c.a();
    public c0 l = new c0();
    public ABTestExtraData s = new ABTestExtraData();
    public NewGodData x = new NewGodData();
    public w y = new w();
    public d.b.i0.s.c.f j = new d.b.i0.s.c.f();
    public d.b.i0.s.c.g z = new d.b.i0.s.c.g();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a(e eVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.i0.e0.e.c.d().g();
        }
    }

    public d.b.i0.s.c.a a() {
        return this.r;
    }

    public ABTestExtraData b() {
        return this.s;
    }

    public JSONArray c() {
        return this.t;
    }

    public d.b.i0.s.c.c d() {
        return this.k;
    }

    public d.b.i0.s.c.d e() {
        return this.i;
    }

    public d.b.i0.s.c.f f() {
        return this.j;
    }

    public d.b.i0.s.c.g g() {
        return this.z;
    }

    public h h() {
        return this.f52076h;
    }

    public s i() {
        return this.f52070b;
    }

    public CombineDownload j() {
        return this.f52073e;
    }

    public t k() {
        return this.f52071c;
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
        return this.x;
    }

    public c0 q() {
        return this.l;
    }

    public JSONArray r() {
        return this.u;
    }

    public VersionData s() {
        return this.f52069a;
    }

    public j0 t() {
        return this.f52075g;
    }

    public String u() {
        return this.f52072d;
    }

    public final JSONArray v(JSONObject jSONObject, String str) {
        try {
            return jSONObject.optJSONArray(str);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return null;
        }
    }

    public final JSONObject w(JSONObject jSONObject, String str) {
        try {
            return jSONObject.optJSONObject(str);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return null;
        }
    }

    public void x(String str) {
        try {
            y(new JSONObject(str));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void y(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return;
        }
        try {
            this.y.a(v(jSONObject, "index_tab_info"));
            this.f52069a.parserJson(jSONObject.optJSONObject("version"));
            this.f52070b.b(jSONObject.optJSONObject("client"));
            CommonHelper.setIp(jSONObject.optString("client_ip", null));
            d.b.c.e.n.f.g(jSONObject.optString("client_ip", null));
            this.f52071c.f(jSONObject.optJSONObject("config"));
            this.f52075g.X(jSONObject.optJSONObject("wl_config"));
            jSONObject.optJSONObject("channel_icon_config");
            this.j.e(jSONObject.optJSONObject("floating_icon"));
            TbSingleton.getInstance().setAdFloatViewData(this.j);
            String optString = jSONObject.optString("new_god_data", "");
            if (!StringUtils.isNull(optString)) {
                this.x.parserJson(optString);
            }
            this.q.c(jSONObject.optJSONObject("consume_path"));
            TbadkCoreApplication.getInst().setConsumePathData(this.q);
            this.f52072d = jSONObject.optString("config_version");
            this.n = jSONObject.optInt("is_uninterest");
            this.o = jSONObject.optInt("first_time_motivate");
            this.p = jSONObject.optInt("needNewUserLead");
            this.f52073e.parserJson(jSONObject.optJSONObject("combine_download"));
            this.f52074f.a(jSONObject.optJSONObject("mainbar"));
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
            this.f52076h.a(jSONObject.optJSONObject("app_entrance"));
            this.i.k(jSONObject.optJSONObject("ad_adsense"));
            TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
            g.d(jSONObject.optJSONObject("video_report_config"));
            this.k.b(jSONObject.optJSONObject("activity_switch"));
            this.r.b(w(jSONObject, "abtest_config"));
            this.s.parseJson(w(jSONObject, "new_abtest_entra"));
            this.t = v(jSONObject, "new_abtest_config");
            this.u = v(jSONObject, "ubs_abtest_config");
            v(jSONObject, "outside_callback_icon");
            this.v = jSONObject.optJSONArray("windowStrategyList");
            this.w = w(jSONObject, "bear_sdk_config");
            if (w(jSONObject, "advertisement_config") != null) {
                this.z.d(w(jSONObject, "advertisement_config"));
            }
            d.b.i0.r.o.b.b().f(this.v);
            this.l.d(jSONObject.optJSONObject("profile_icon"));
            TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
            d.b.i0.r.d0.b.j().t("key_live_forum_enter_switch", jSONObject.optInt("ala_channel_white", 0) == 1);
            TbSingleton.getInstance().setPcdnConfigData(jSONObject.optJSONObject("pcdn_config"));
            JSONArray v = v(jSONObject, "offpack");
            if (v != null && v.length() > 0 && (jSONObject2 = v.getJSONObject(0)) != null) {
                d.b.j0.q2.d.b bVar = new d.b.j0.q2.d.b();
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
                d.b.i0.e0.e.c.d().h(optJSONObject3);
                d.b.c.e.m.e.a().post(new a(this));
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
