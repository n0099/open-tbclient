package com.win.opensdk;

import android.text.TextUtils;
import com.baidu.adp.widget.VerticalTranslateLayout;
import com.baidu.sapi2.SapiOptions;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.win.opensdk.core.Info;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class s1 {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a */
    public static String f77516a = "https://pp.xdplt.com/";

    /* renamed from: b */
    public static final String f77517b;

    /* renamed from: c */
    public static final String f77518c;

    /* renamed from: d */
    public static String f77519d;

    /* renamed from: e */
    public static String f77520e;

    /* renamed from: f */
    public static String f77521f;

    /* renamed from: g */
    public static String f77522g;

    /* renamed from: h */
    public static String f77523h;

    /* renamed from: i */
    public static String f77524i;

    /* renamed from: j */
    public static String f77525j;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1639697679, "Lcom/win/opensdk/s1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1639697679, "Lcom/win/opensdk/s1;");
                return;
            }
        }
        f77517b = f77516a + "behavior?";
        f77518c = f77516a + "report?";
        f77519d = "https://cd.xdplt.com/";
        f77520e = "jy/da?";
        f77521f = "?";
        f77522g = "jy/da?";
        f77523h = "jy/da?";
        f77524i = "jy/da?";
        f77525j = "jy/da?";
    }

    public static /* synthetic */ void a(r1 r1Var) {
        String str;
        if (r1Var != null) {
            str = r1Var.f77512c;
            if (TextUtils.isEmpty(str) || r1Var.f77510a == null || TextUtils.isEmpty(r1Var.f77511b)) {
                return;
            }
            W1.a(new q1(r1Var));
        }
    }

    public static /* synthetic */ void a(r1 r1Var, HashMap hashMap) {
        if (r1Var.f77511b.startsWith(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE602)) {
            hashMap.put("lo_timeout", String.valueOf(U1.d(r1Var.f77510a)));
            float a2 = U1.a(r1Var.f77510a, "splash_width", 0.0f);
            if (a2 > 0.0f) {
                hashMap.put("sp_w", String.valueOf(a2));
            }
            float a3 = U1.a(r1Var.f77510a, "splash_height", 0.0f);
            if (a3 > 0.0f) {
                hashMap.put("sp_h", String.valueOf(a3));
            }
        }
    }

    public static /* synthetic */ K a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.length() != 0) {
                    K k = new K();
                    k.f77163c = jSONObject.optString("traceid", "");
                    k.f77162b = jSONObject.optString("pid", "");
                    jSONObject.optString("bt", "");
                    JSONArray optJSONArray = jSONObject.optJSONArray("list");
                    ArrayList arrayList = new ArrayList();
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                            if (optJSONObject != null && optJSONObject.length() > 0) {
                                Info info = new Info();
                                info.setTraceid(k.f77163c);
                                info.setPid(k.a());
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
                                info.setVertical(optJSONObject.optBoolean(VerticalTranslateLayout.VERTICAL, true));
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
                    k.f77161a = arrayList;
                    return k;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
