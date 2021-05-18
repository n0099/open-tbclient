package com.win.opensdk;

import android.text.TextUtils;
import com.baidu.sapi2.SapiOptions;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.win.opensdk.core.Info;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class Q0 {

    /* renamed from: a */
    public static String f36988a = "https://pp.xdplt.com/";

    /* renamed from: b */
    public static final String f36989b = f36988a + "behavior?";

    /* renamed from: c */
    public static final String f36990c = f36988a + "report?";

    /* renamed from: d */
    public static String f36991d = "https://cd.xdplt.com/";

    /* renamed from: e */
    public static String f36992e = "jy/da?";

    /* renamed from: f */
    public static String f36993f = "?";

    /* renamed from: g */
    public static String f36994g = "jy/da?";

    /* renamed from: h */
    public static String f36995h = "jy/da?";

    /* renamed from: i */
    public static String f36996i = "jy/da?";

    public static /* synthetic */ void a(P0 p0) {
        String str;
        if (p0 != null) {
            str = p0.f36964c;
            if (TextUtils.isEmpty(str) || p0.f36962a == null || TextUtils.isEmpty(p0.f36963b)) {
                return;
            }
            u1.a(new O0(p0));
        }
    }

    public static /* synthetic */ w a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.length() != 0) {
                    w wVar = new w();
                    wVar.f37227c = jSONObject.optString("traceid", "");
                    wVar.f37226b = jSONObject.optString("pid", "");
                    jSONObject.optString("bt", "");
                    JSONArray optJSONArray = jSONObject.optJSONArray("list");
                    ArrayList arrayList = new ArrayList();
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                            if (optJSONObject != null && optJSONObject.length() > 0) {
                                Info info = new Info();
                                info.setTraceid(wVar.f37227c);
                                info.setPid(wVar.a());
                                info.setId(optJSONObject.optString("id", ""));
                                info.setLoad(optJSONObject.optString("load", ""));
                                info.setLoad_type(optJSONObject.optString("load_type", ""));
                                info.setXn(optJSONObject.optInt("xn", 1));
                                info.setType(optJSONObject.optInt("type", 0));
                                info.setCache(optJSONObject.optInt(SapiOptions.KEY_CACHE, 3600));
                                info.setCb(optJSONObject.optInt("cb", 0));
                                int optInt = optJSONObject.optInt("cdt", 0);
                                if (optInt > 30) {
                                    optInt = 30;
                                }
                                info.setCdt(optInt);
                                int optInt2 = optJSONObject.optInt("wt", 10);
                                if (optInt2 < 5) {
                                    optInt2 = 5;
                                }
                                info.setWt(optInt2);
                                info.setPs(optJSONObject.optInt("ps", 0));
                                info.setVertical(optJSONObject.optBoolean("vertical", true));
                                info.setNat(optJSONObject.optBoolean("nat", true));
                                info.setHo_c_sw(optJSONObject.optBoolean("ho_c_sw", true));
                                info.setOpen(optJSONObject.optString("open", ""));
                                info.setTitle(optJSONObject.optString("title", ""));
                                info.setDesc(optJSONObject.optString("desc", ""));
                                info.setIcon(optJSONObject.optString("icon", ""));
                                info.setImage(optJSONObject.optString("image", ""));
                                info.setBtndesc(optJSONObject.optString("btndesc", ""));
                                info.setOpent(optJSONObject.optInt("opent", 0));
                                info.setDl_pkg(optJSONObject.optString("dl_pkg", ""));
                                info.setDl_name(optJSONObject.optString("dl_name", ""));
                                info.setDpl(optJSONObject.optString("dpl", ""));
                                info.setDl_vsc(optJSONObject.optInt("dl_vsc", 0));
                                info.setVvamount(optJSONObject.optLong("vvamount", 0L));
                                info.setSpet(optJSONObject.optLong("spet", 1100L));
                                info.setCountdown(optJSONObject.optLong("countdown", 5000L));
                                info.setLo_timeout(optJSONObject.optLong("lo_timeout", 1000L));
                                info.setVvt(optJSONObject.optInt("vvt", 0));
                                info.setSper(optJSONObject.optDouble("sper", 0.5d));
                                info.setImp_urls(optJSONObject.optString("imp_urls"));
                                info.setClick_urls(optJSONObject.optString("click_urls"));
                                info.setVv_click_urls(optJSONObject.optString("vv_click_urls"));
                                info.setVv_downf_urls(optJSONObject.optString("vv_downf_urls"));
                                info.setVv_downs_urls(optJSONObject.optString("vv_downs_urls"));
                                info.setVv_finish_urls(optJSONObject.optString("vv_finish_urls"));
                                info.setVv_ins_urls(optJSONObject.optString("vv_ins_urls"));
                                info.setVv_show_urls(optJSONObject.optString("vv_show_urls"));
                                info.setVv_start_urls(optJSONObject.optString("vv_start_urls"));
                                info.setW(optJSONObject.optInt("w", 0));
                                info.setH(optJSONObject.optInt("h", 0));
                                info.setEvents(optJSONObject.optString("events"));
                                arrayList.add(info);
                            }
                        }
                    }
                    wVar.f37225a = arrayList;
                    return wVar;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static /* synthetic */ void a(P0 p0, HashMap hashMap) {
        if (p0.f36963b.startsWith(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE602)) {
            hashMap.put("lo_timeout", String.valueOf(s1.d(p0.f36962a)));
        }
    }
}
