package d.b.h0.s.e;

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
import d.b.h0.s.c.a0;
import d.b.h0.s.c.h0;
import d.b.h0.s.c.q;
import d.b.h0.s.c.r;
import d.b.h0.s.c.s;
import d.b.h0.s.c.u;
import d.b.h0.s.c.y;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: d  reason: collision with root package name */
    public String f51319d;
    public int l;
    public int n;
    public int o;
    public JSONArray s;
    public JSONArray t;
    public JSONArray u;
    public int m = 0;

    /* renamed from: a  reason: collision with root package name */
    public VersionData f51316a = new VersionData();

    /* renamed from: b  reason: collision with root package name */
    public q f51317b = new q();

    /* renamed from: c  reason: collision with root package name */
    public r f51318c = new r();

    /* renamed from: e  reason: collision with root package name */
    public CombineDownload f51320e = new CombineDownload();

    /* renamed from: f  reason: collision with root package name */
    public y f51321f = new y();

    /* renamed from: g  reason: collision with root package name */
    public h0 f51322g = new h0();
    public s p = new s();

    /* renamed from: h  reason: collision with root package name */
    public d.b.h0.s.c.f f51323h = new d.b.h0.s.c.f();
    public d.b.h0.s.c.d i = new d.b.h0.s.c.d();
    public final d.b.h0.s.c.c j = new d.b.h0.s.c.c();
    public d.b.h0.s.c.a q = new d.b.h0.s.c.a();
    public a0 k = new a0();
    public ABTestExtraData r = new ABTestExtraData();
    public NewGodData v = new NewGodData();
    public u w = new u();
    public d.b.h0.s.c.e x = new d.b.h0.s.c.e();

    public d.b.h0.s.c.a a() {
        return this.q;
    }

    public ABTestExtraData b() {
        return this.r;
    }

    public JSONArray c() {
        return this.s;
    }

    public d.b.h0.s.c.c d() {
        return this.j;
    }

    public d.b.h0.s.c.d e() {
        return this.i;
    }

    public d.b.h0.s.c.f f() {
        return this.f51323h;
    }

    public q g() {
        return this.f51317b;
    }

    public CombineDownload h() {
        return this.f51320e;
    }

    public r i() {
        return this.f51318c;
    }

    public boolean j() {
        return this.n == 1;
    }

    public int k() {
        return this.o;
    }

    public int l() {
        return this.m;
    }

    public NewGodData m() {
        return this.v;
    }

    public a0 n() {
        return this.k;
    }

    public JSONArray o() {
        return this.t;
    }

    public VersionData p() {
        return this.f51316a;
    }

    public h0 q() {
        return this.f51322g;
    }

    public String r() {
        return this.f51319d;
    }

    public final JSONArray s(JSONObject jSONObject, String str) {
        try {
            return jSONObject.optJSONArray(str);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return null;
        }
    }

    public final JSONObject t(JSONObject jSONObject, String str) {
        try {
            return jSONObject.optJSONObject(str);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return null;
        }
    }

    public void u(String str) {
        try {
            v(new JSONObject(str));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void v(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return;
        }
        try {
            this.w.a(s(jSONObject, "index_tab_info"));
            this.f51316a.parserJson(jSONObject.optJSONObject("version"));
            this.f51317b.b(jSONObject.optJSONObject("client"));
            CommonHelper.setIp(jSONObject.optString("client_ip", null));
            d.b.b.e.n.f.g(jSONObject.optString("client_ip", null));
            this.f51318c.f(jSONObject.optJSONObject("config"));
            this.f51322g.X(jSONObject.optJSONObject("wl_config"));
            jSONObject.optJSONObject("channel_icon_config");
            String optString = jSONObject.optString("new_god_data", "");
            if (!StringUtils.isNull(optString)) {
                this.v.parserJson(optString);
            }
            this.p.c(jSONObject.optJSONObject("consume_path"));
            TbadkCoreApplication.getInst().setConsumePathData(this.p);
            this.f51319d = jSONObject.optString("config_version");
            this.m = jSONObject.optInt("is_uninterest");
            this.n = jSONObject.optInt("first_time_motivate");
            this.o = jSONObject.optInt("needNewUserLead");
            this.f51320e.parserJson(jSONObject.optJSONObject("combine_download"));
            this.f51321f.a(jSONObject.optJSONObject("mainbar"));
            jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001141, jSONObject));
            this.l = jSONObject.optInt("faceshop_version");
            if (this.l > TbadkCoreApplication.getInst().getFaceShopVersion()) {
                TbadkCoreApplication.getInst().setTempFaceShopVersion(this.l);
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
            d.b.h0.s.c.g.c(jSONObject.optJSONArray("scheme_whitelist"));
            this.f51323h.a(jSONObject.optJSONObject("app_entrance"));
            this.i.k(jSONObject.optJSONObject("ad_adsense"));
            TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
            g.d(jSONObject.optJSONObject("video_report_config"));
            this.j.b(jSONObject.optJSONObject("activity_switch"));
            this.q.b(t(jSONObject, "abtest_config"));
            this.r.parseJson(t(jSONObject, "new_abtest_entra"));
            this.s = s(jSONObject, "new_abtest_config");
            this.t = s(jSONObject, "ubs_abtest_config");
            this.u = jSONObject.optJSONArray("windowStrategyList");
            this.x.d(t(jSONObject, "ad_density"));
            d.b.h0.r.o.b.b().f(this.u);
            this.k.d(jSONObject.optJSONObject("profile_icon"));
            TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
            d.b.h0.r.d0.b.i().s("key_live_forum_enter_switch", jSONObject.optInt("ala_channel_white", 0) == 1);
            TbSingleton.getInstance().setPcdnConfigData(jSONObject.optJSONObject("pcdn_config"));
            JSONArray s = s(jSONObject, "offpack");
            if (s != null && s.length() > 0 && (jSONObject2 = s.getJSONObject(0)) != null) {
                d.b.i0.p2.d.b bVar = new d.b.i0.p2.d.b();
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
                if (StringUtils.isNull(optString4) || !"2".equals(optString4)) {
                    return;
                }
                TbSingleton.getInstance().setLFUserTaskId(optJSONObject2.optString(LowFlowsActivityConfig.LF_USER_TASKID));
                TbSingleton.getInstance().setBannerText(optJSONObject2.optString(LowFlowsActivityConfig.LF_BANNER_TEXT));
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
