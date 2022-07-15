package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.win.opensdk.core.Info;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class x1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "https://jau.xdplt.com/";
    public static final String b;
    public static final String c;
    public static String d;
    public static String e;
    public static String f;
    public static String g;
    public static String h;
    public static String i;
    public static String j;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1639692874, "Lcom/win/opensdk/x1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1639692874, "Lcom/win/opensdk/x1;");
                return;
            }
        }
        b = a + "behavior?";
        c = a + "report?";
        d = "https://cd.xdplt.com/";
        e = "jy/da?";
        f = "?";
        g = "jy/da?";
        h = "jy/da?";
        i = "jy/da?";
        j = "jy/da?";
    }

    public static /* synthetic */ void a(w1 w1Var) {
        String str;
        if (w1Var != null) {
            str = w1Var.c;
            if (TextUtils.isEmpty(str) || w1Var.a == null || TextUtils.isEmpty(w1Var.b)) {
                return;
            }
            b2.a(new v1(w1Var));
        }
    }

    public static /* synthetic */ void a(w1 w1Var, HashMap hashMap) {
        if (w1Var.b.startsWith("602")) {
            hashMap.put("lo_timeout", String.valueOf(Z1.d(w1Var.a)));
            float a2 = Z1.a(w1Var.a, "splash_width", 0.0f);
            if (a2 > 0.0f) {
                hashMap.put("sp_w", String.valueOf(a2));
            }
            float a3 = Z1.a(w1Var.a, "splash_height", 0.0f);
            if (a3 > 0.0f) {
                hashMap.put("sp_h", String.valueOf(a3));
            }
        }
    }

    public static /* synthetic */ J a(JSONObject jSONObject, Context context) {
        if (jSONObject != null) {
            try {
                if (jSONObject.length() != 0) {
                    J j2 = new J();
                    j2.c = jSONObject.optString("traceid", "");
                    j2.b = jSONObject.optString("pid", "");
                    jSONObject.optString("bt", "");
                    JSONArray optJSONArray = jSONObject.optJSONArray("list");
                    ArrayList arrayList = new ArrayList();
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                            if (optJSONObject != null && optJSONObject.length() > 0) {
                                Info info = new Info();
                                info.setTraceid(j2.b());
                                info.setPid(j2.a());
                                info.setId(optJSONObject.optString("id", ""));
                                info.setLoad(optJSONObject.optString("load", ""));
                                info.setLoad_type(optJSONObject.optString("load_type", ""));
                                info.setXn(optJSONObject.optInt("xn", 1));
                                info.setType(optJSONObject.optInt("type", 0));
                                info.setCache(optJSONObject.optInt("cache", 3600));
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
                                info.setDl_pkg(optJSONObject.isNull("dl_pkg") ? "" : optJSONObject.optString("dl_pkg", ""));
                                info.setDl_name(optJSONObject.isNull("dl_name") ? "" : optJSONObject.optString("dl_name", ""));
                                info.setDpl(optJSONObject.isNull("dpl") ? "" : optJSONObject.optString("dpl", ""));
                                info.setDl_vsc(optJSONObject.optInt("dl_vsc", 0));
                                info.setVvamount(optJSONObject.optLong("vvamount", 0L));
                                info.setSpet(optJSONObject.optLong("spet", 500L));
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
                                JSONArray optJSONArray2 = optJSONObject.optJSONArray("material");
                                ArrayList arrayList2 = new ArrayList();
                                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                                        String optString = optJSONArray2.optString(i3);
                                        if (!TextUtils.isEmpty(optString)) {
                                            arrayList2.add(optString);
                                        }
                                    }
                                }
                                info.setMaterial(arrayList2);
                                info.setMaterial_type(optJSONObject.isNull("material_type") ? "" : optJSONObject.optString("material_type", ""));
                                arrayList.add(info);
                            }
                        }
                    }
                    j2.a = arrayList;
                    return j2;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
