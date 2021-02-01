package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.ad.AdFilterReporter;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile Boolean f12578a = null;

    public static Pair<JSONArray, Pair<Integer, Integer>> a(JSONObject jSONObject, String str) {
        if (jSONObject.optInt(Constants.KEYS.RET) != 0) {
            return new Pair<>(null, new Pair(501, 2001));
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject == null) {
            return new Pair<>(null, new Pair(501, 2002));
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject(str);
        if (optJSONObject2 == null) {
            return new Pair<>(null, new Pair(501, 2003));
        }
        int optInt = optJSONObject2.optInt(Constants.KEYS.RET);
        if (optInt != 0) {
            return new Pair<>(null, new Pair(Integer.valueOf(optInt), 2004));
        }
        JSONArray optJSONArray = optJSONObject2.optJSONArray("list");
        return (optJSONArray == null || optJSONArray.length() <= 0) ? new Pair<>(null, new Pair(501, 2005)) : new Pair<>(optJSONArray, new Pair(2000, 2000));
    }

    public static String a() {
        return "com.jingdong.app.mall";
    }

    public static String a(Context context) {
        if (context == null || GDTADManager.getInstance().getSM().getInteger("cookieForLastAds", 0) != 1) {
            return null;
        }
        return at.b("last_ads", "");
    }

    public static List<JSONObject> a(JSONArray jSONArray, @NonNull com.qq.e.comm.plugin.ad.m mVar, String str) {
        return a(jSONArray, mVar, str, null);
    }

    public static List<JSONObject> a(JSONArray jSONArray, @NonNull com.qq.e.comm.plugin.ad.m mVar, String str, boolean[] zArr) {
        String str2;
        boolean a2;
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray2 = new JSONArray();
        if (jSONArray != null) {
            if (zArr != null && jSONArray.length() != zArr.length) {
                GDTLogger.e("ad.len != filter.len!!");
                return arrayList;
            }
            GDTLogger.d("filterInstalledApp before size:" + jSONArray.length());
            AdFilterReporter adFilterReporter = new AdFilterReporter();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                boolean a3 = d.a(optJSONObject);
                boolean b2 = b(optJSONObject);
                boolean a4 = a(optJSONObject);
                if (a3 || b2 || a4) {
                    if (a3) {
                        com.qq.e.comm.plugin.ad.j d = d.d(optJSONObject);
                        str2 = d.d();
                        a2 = com.qq.e.comm.plugin.a.d.d.a(d.h());
                    } else {
                        if (b2) {
                            str2 = "com.jingdong.app.mall";
                        } else if (a4) {
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject("ext");
                            str2 = optJSONObject2 != null ? optJSONObject2.optString("pkg_name") : null;
                            if (TextUtils.isEmpty(str2)) {
                                arrayList.add(optJSONObject);
                                if (zArr != null) {
                                    zArr[i] = false;
                                }
                            }
                        } else {
                            str2 = null;
                        }
                        a2 = com.qq.e.comm.plugin.a.e.a.a(GDTADManager.getInstance().getAppContext(), str2);
                    }
                    int optInt = optJSONObject.optInt("reltarget");
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("muidtype", "imei");
                        String a5 = com.qq.e.comm.plugin.h.b.IMEI.a(GDTADManager.getInstance().getAppContext());
                        jSONObject.put("muid", a5);
                        jSONObject.put("package_name", str2);
                        jSONObject.put("timestamp", System.currentTimeMillis() + "");
                        if (a2 && optInt == 1) {
                            jSONObject.put("install_status", "1");
                            adFilterReporter.a(optJSONObject.optString("fl"), 2);
                        } else if (a2 || optInt != 2) {
                            arrayList.add(optJSONObject);
                        } else {
                            jSONObject.put("install_status", "0");
                            adFilterReporter.a(optJSONObject.optString("fl"), 1);
                        }
                        boolean has = jSONObject.has("install_status");
                        if (zArr != null) {
                            zArr[i] = has;
                        }
                        if (has) {
                            if (a5 != null) {
                                com.qq.e.comm.plugin.w.h.a(1006, jSONObject, mVar, str);
                            }
                            com.qq.e.comm.plugin.y.d dVar = new com.qq.e.comm.plugin.y.d(new JSONObject(jSONObject, new String[]{"package_name", "timestamp", "install_status"}));
                            dVar.a(WriteImageActivityConfig.THREADID, str);
                            dVar.a(Constants.KEYS.PLCINFO, com.qq.e.comm.plugin.w.h.a(mVar));
                            jSONArray2.put(dVar);
                            com.qq.e.comm.plugin.y.c cVar = new com.qq.e.comm.plugin.y.c();
                            cVar.a(mVar.a());
                            cVar.b(optJSONObject.optString(Config.CELL_LOCATION));
                            cVar.c(optJSONObject.optString("traceid"));
                            com.qq.e.comm.plugin.y.u.a(100202, optInt, cVar, dVar);
                            if (mVar.b() != null) {
                                com.qq.e.comm.plugin.y.u.a(100212, mVar.b().b(), cVar, dVar);
                            }
                        }
                    } catch (Exception e) {
                        GDTLogger.d("get exception. " + e.getMessage());
                    }
                } else {
                    arrayList.add(optJSONObject);
                    if (zArr != null) {
                        zArr[i] = false;
                    }
                }
            }
            int size = arrayList.size();
            if (mVar.b() == com.qq.e.comm.plugin.ad.e.SPLASH && size > 1) {
                for (int i2 = 1; i2 < size; i2++) {
                    adFilterReporter.a(((JSONObject) arrayList.get(i2)).optString("fl"), 3);
                }
            }
            adFilterReporter.a();
        }
        if (jSONArray != null && jSONArray.length() > 0 && arrayList != null && arrayList.size() == 0) {
            com.qq.e.comm.plugin.y.d dVar2 = new com.qq.e.comm.plugin.y.d();
            dVar2.a("filters", jSONArray2);
            com.qq.e.comm.plugin.y.u.a(100222, mVar.b().b(), new com.qq.e.comm.plugin.y.c().a(mVar.a()), dVar2);
        }
        GDTLogger.d("filterInstalledApp after size:" + arrayList.size());
        return arrayList;
    }

    public static void a(JSONObject jSONObject, Context context) throws JSONException {
        if (jSONObject == null || TextUtils.isEmpty(jSONObject.optString("last_ads")) || context == null || GDTADManager.getInstance().getSM().getInteger("cookieForLastAds", 0) != 1) {
            return;
        }
        at.a("last_ads", jSONObject.optString("last_ads"));
    }

    public static boolean a(int i) {
        return i == 12 || i == 1000 || i == 48 || i == 38 || i == 25;
    }

    public static boolean a(Context context, com.qq.e.comm.plugin.s.a aVar) {
        if (aVar.v()) {
            if (com.qq.e.comm.plugin.a.d.b.a().a(context, aVar.z().d()) == 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(com.qq.e.comm.plugin.s.a aVar) {
        return aVar != null && aVar.a_() == 25;
    }

    public static boolean a(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.optInt("producttype") == 1000;
    }

    public static void b(Context context) {
        if (context != null) {
            int i = context.getApplicationInfo().targetSdkVersion;
            if (Build.VERSION.SDK_INT < 30 || i < 30 || c(context)) {
                return;
            }
            ai.a("miss android.permission.QUERY_ALL_PACKAGES", new Object[0]);
            com.qq.e.comm.plugin.y.u.a(1130005, 0, null);
        }
    }

    private static boolean b(int i) {
        return i == 46;
    }

    public static boolean b(com.qq.e.comm.plugin.s.a aVar) {
        if (aVar == null) {
            return false;
        }
        return b(aVar.a_());
    }

    public static boolean b(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.optInt("producttype") == 25;
    }

    private static boolean c(int i) {
        return i == 3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0036, code lost:
        com.qq.e.comm.plugin.util.b.f12578a = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean c(Context context) {
        int i = 0;
        if (context == null) {
            return false;
        }
        if (f12578a == null) {
            synchronized (b.class) {
                try {
                    if (f12578a == null) {
                        f12578a = false;
                        try {
                            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
                            if (strArr != null) {
                                int length = strArr.length;
                                while (true) {
                                    if (i >= length) {
                                        break;
                                    } else if ("android.permission.QUERY_ALL_PACKAGES".equals(strArr[i])) {
                                        break;
                                    } else {
                                        i++;
                                    }
                                }
                            }
                        } catch (PackageManager.NameNotFoundException e) {
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f12578a.booleanValue();
    }

    public static boolean c(com.qq.e.comm.plugin.s.a aVar) {
        if (aVar == null) {
            return false;
        }
        return c(aVar.ae());
    }

    public static boolean c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return b(jSONObject.optInt("producttype"));
    }

    public static String d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.optString(Config.CELL_LOCATION);
    }

    public static boolean d(com.qq.e.comm.plugin.s.a aVar) {
        if (aVar == null) {
            return false;
        }
        return g(aVar.E());
    }

    public static String e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("customized_invoke_url");
        if (StringUtil.isEmpty(optString)) {
            return null;
        }
        return optString;
    }

    public static boolean f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return c(jSONObject.optInt("mini_program_type"));
    }

    public static boolean g(JSONObject jSONObject) {
        return c(jSONObject) || f(jSONObject);
    }
}
