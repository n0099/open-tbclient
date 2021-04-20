package d.b.a0.b.f;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g {
    public static final boolean C = d.b.a0.a.a.a.f41815a;
    public int A;
    public String B;

    /* renamed from: a  reason: collision with root package name */
    public int f41872a;

    /* renamed from: b  reason: collision with root package name */
    public String f41873b;

    /* renamed from: c  reason: collision with root package name */
    public String f41874c;

    /* renamed from: d  reason: collision with root package name */
    public String f41875d;

    /* renamed from: e  reason: collision with root package name */
    public String f41876e;

    /* renamed from: f  reason: collision with root package name */
    public int f41877f;

    /* renamed from: g  reason: collision with root package name */
    public String f41878g;

    /* renamed from: h  reason: collision with root package name */
    public int f41879h;
    public int i;
    public String j;
    public String k;
    public String l;
    public int m;
    public int n;
    public String o;
    public String[] p;
    public String[] q;
    public long r;
    public long s;
    public int t;
    public int u;
    public int v;
    public int w = 0;
    public boolean x = false;
    public String y;
    public int z;

    /* loaded from: classes2.dex */
    public static class a {
        public static void a(JSONObject jSONObject, g gVar) {
            try {
                gVar.f41872a = jSONObject.optInt("advisible");
                gVar.f41873b = jSONObject.optString("id");
                gVar.f41874c = jSONObject.optString("ukey");
                gVar.f41875d = jSONObject.optString("extra");
                gVar.f41876e = jSONObject.optString("layout");
                gVar.f41877f = jSONObject.optInt("type");
                gVar.k = jSONObject.optString("jump_url");
                gVar.o = jSONObject.optString("action");
                gVar.l = jSONObject.optString("flag_name");
                gVar.m = jSONObject.optInt("logo_type");
                gVar.n = jSONObject.optInt("display");
                if (gVar.g()) {
                    b.a(jSONObject, gVar);
                } else {
                    c.a(jSONObject, gVar);
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("show_urls");
                if (optJSONArray != null) {
                    gVar.p = new String[optJSONArray.length()];
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        gVar.p[i] = optJSONArray.optString(i);
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("click_urls");
                if (optJSONArray2 != null) {
                    gVar.q = new String[optJSONArray2.length()];
                    int length2 = optJSONArray2.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        gVar.q[i2] = optJSONArray2.optString(i2);
                    }
                }
                gVar.r = jSONObject.optLong(IntentConfig.START);
                gVar.s = jSONObject.optLong(ProgressInfo.JSON_KEY_END);
                gVar.t = jSONObject.optInt("expose_interval");
                gVar.u = jSONObject.optInt("expose_times");
                gVar.v = jSONObject.optInt("preload_type");
                gVar.y = jSONObject.optString("click_float_lottie_url");
                gVar.z = jSONObject.optInt("float_bar_show", 1);
                gVar.A = jSONObject.optInt("click_float_opt", 1);
                gVar.B = jSONObject.optString("style_desc");
                gVar.w = jSONObject.optInt("curRate");
            } catch (Exception e2) {
                if (g.C) {
                    Log.d("SplashData", "createFromJson() Exception e: ");
                    e2.printStackTrace();
                }
            }
        }

        public static void b(JSONObject jSONObject, g gVar) {
            JSONObject optJSONObject;
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("adInfo");
                if (optJSONArray != null) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(0);
                    if (optJSONObject2 == null) {
                        return;
                    }
                    gVar.f41872a = optJSONObject2.optInt("advisible", 1);
                    gVar.f41873b = optJSONObject2.optString("id");
                    gVar.f41874c = optJSONObject2.optString("ukey");
                    JSONArray optJSONArray2 = optJSONObject2.optJSONArray("extra");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        int i = 0;
                        while (true) {
                            if (i >= optJSONArray2.length()) {
                                break;
                            }
                            JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i);
                            if (optJSONObject3 != null) {
                                String optString = optJSONObject3.optString(Config.APP_KEY);
                                String optString2 = optJSONObject3.optString("v");
                                if (!TextUtils.isEmpty(optString2) && TextUtils.equals("extraParam", optString)) {
                                    gVar.f41875d = optString2;
                                    break;
                                }
                            }
                            i++;
                        }
                    }
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("material");
                    if (optJSONArray3 == null || (optJSONObject = optJSONArray3.optJSONObject(0)) == null) {
                        return;
                    }
                    JSONArray optJSONArray4 = optJSONObject.optJSONArray("info");
                    if (optJSONArray4 == null) {
                        String optString3 = optJSONObject.optString("info");
                        if (!TextUtils.isEmpty(optString3)) {
                            optJSONArray4 = new JSONArray(optString3);
                        }
                    }
                    if (optJSONArray4 != null) {
                        JSONObject optJSONObject4 = optJSONArray4.optJSONObject(0);
                        gVar.f41876e = optJSONObject4.optString("layout");
                        JSONObject optJSONObject5 = optJSONObject4.optJSONObject("common");
                        if (optJSONObject5 != null) {
                            gVar.f41877f = optJSONObject5.optInt("type");
                            gVar.k = optJSONObject5.optString("jump_url");
                            gVar.o = optJSONObject5.optString("action");
                            gVar.l = optJSONObject5.optString("flag_name");
                            gVar.m = optJSONObject5.optInt("logo_type");
                            gVar.n = optJSONObject5.optInt("display");
                            JSONArray optJSONArray5 = optJSONObject5.optJSONArray("image_list");
                            gVar.y = optJSONObject5.optString("click_float_lottie_url");
                            if (gVar.g() && optJSONArray5 != null && optJSONArray5.length() > 0) {
                                b.a(optJSONArray5.optJSONObject(0), gVar);
                            } else {
                                c.a(optJSONObject5, gVar);
                            }
                        }
                        JSONArray optJSONArray6 = optJSONObject4.optJSONArray("show_urls");
                        if (optJSONArray6 != null) {
                            gVar.p = new String[optJSONArray6.length()];
                            int length = optJSONArray6.length();
                            for (int i2 = 0; i2 < length; i2++) {
                                gVar.p[i2] = optJSONArray6.optString(i2);
                            }
                        }
                        JSONArray optJSONArray7 = optJSONObject4.optJSONArray("click_urls");
                        if (optJSONArray7 != null) {
                            gVar.q = new String[optJSONArray7.length()];
                            int length2 = optJSONArray7.length();
                            for (int i3 = 0; i3 < length2; i3++) {
                                gVar.q[i3] = optJSONArray7.optString(i3);
                            }
                        }
                        JSONObject optJSONObject6 = optJSONObject4.optJSONObject("policy");
                        if (optJSONObject6 != null) {
                            JSONObject jSONObject2 = optJSONObject6.getJSONObject("expire_time");
                            gVar.r = jSONObject2.optLong(IntentConfig.START);
                            gVar.s = jSONObject2.optLong(ProgressInfo.JSON_KEY_END);
                            gVar.t = optJSONObject6.optInt("expose_interval");
                            gVar.u = optJSONObject6.optInt("expose_times");
                            gVar.v = optJSONObject6.optInt("preload_type");
                            gVar.z = optJSONObject6.optInt("float_bar_show", 1);
                            gVar.A = optJSONObject6.optInt("click_float_opt", 1);
                            gVar.B = optJSONObject6.optString("style_desc");
                        }
                    }
                }
            } catch (Exception e2) {
                if (g.C) {
                    Log.d("SplashData", "createFromJson() Exception e: ");
                    e2.printStackTrace();
                }
            }
        }

        public static void c(JSONObject jSONObject, g gVar) {
            try {
                jSONObject.put("advisible", gVar.f41872a);
                jSONObject.put("id", gVar.f41873b);
                jSONObject.put("ukey", gVar.f41874c);
                jSONObject.put("extra", gVar.f41875d);
                jSONObject.put("layout", gVar.f41876e);
                jSONObject.put("type", gVar.f41877f);
                jSONObject.put("jump_url", gVar.k);
                jSONObject.put("action", gVar.o);
                jSONObject.put("flag_name", gVar.l);
                jSONObject.put("logo_type", gVar.m);
                jSONObject.put("display", gVar.n);
                jSONObject.put(IntentConfig.START, gVar.r);
                jSONObject.put(ProgressInfo.JSON_KEY_END, gVar.s);
                jSONObject.put("expose_times", gVar.u);
                jSONObject.put("expose_interval", gVar.t);
                jSONObject.put("preload_type", gVar.v);
                jSONObject.put("curRate", gVar.w);
                jSONObject.put("click_float_lottie_url", gVar.y);
                jSONObject.put("float_bar_show", gVar.z);
                jSONObject.put("click_float_opt", gVar.A);
                jSONObject.put("style_desc", gVar.B);
                if (gVar.p != null) {
                    if (d.b.a0.a.c.d.a()) {
                        jSONObject.put("show_urls", new JSONArray(gVar.p));
                    } else {
                        jSONObject.put("show_urls", new JSONArray((Collection) Arrays.asList(gVar.p)));
                    }
                }
                if (gVar.q != null) {
                    if (d.b.a0.a.c.d.a()) {
                        jSONObject.put("click_urls", new JSONArray(gVar.q));
                    } else {
                        jSONObject.put("click_urls", new JSONArray((Collection) Arrays.asList(gVar.q)));
                    }
                }
                if (gVar.g()) {
                    b.b(jSONObject, gVar);
                } else {
                    c.b(jSONObject, gVar);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }

        public static void d(g gVar, g gVar2) {
            gVar.f41872a = gVar2.f41872a;
            gVar.f41873b = gVar2.f41873b;
            gVar.f41874c = gVar2.f41874c;
            gVar.f41875d = gVar2.f41875d;
            gVar.f41876e = gVar2.f41876e;
            gVar.f41877f = gVar2.f41877f;
            gVar.f41878g = gVar2.f41878g;
            gVar.f41879h = gVar2.f41879h;
            gVar.i = gVar2.i;
            gVar.j = gVar2.j;
            gVar.k = gVar2.k;
            gVar.l = gVar2.l;
            gVar.m = gVar2.m;
            gVar.n = gVar2.n;
            gVar.o = gVar2.o;
            gVar.p = gVar2.p;
            gVar.q = gVar2.q;
            gVar.r = gVar2.r;
            gVar.s = gVar2.s;
            gVar.t = gVar2.t;
            gVar.u = gVar2.u;
            gVar.w = gVar2.w;
            gVar.y = gVar2.y;
            gVar.z = gVar2.z;
            gVar.A = gVar2.A;
            gVar.B = gVar2.B;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static void a(JSONObject jSONObject, g gVar) {
            if (jSONObject != null) {
                try {
                    gVar.f41878g = jSONObject.optString("url");
                    gVar.f41879h = jSONObject.optInt("width");
                    gVar.i = jSONObject.optInt("height");
                    gVar.j = jSONObject.optString("imageMd5");
                } catch (Exception e2) {
                    if (g.C) {
                        Log.d("SplashData", "createFromJson() Exception e: ");
                        e2.printStackTrace();
                    }
                }
            }
        }

        public static void b(JSONObject jSONObject, g gVar) {
            try {
                jSONObject.put("url", gVar.f41878g);
                jSONObject.put("imageMd5", gVar.j);
                jSONObject.put("width", gVar.f41879h);
                jSONObject.put("height", gVar.i);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
        public static void a(JSONObject jSONObject, g gVar) {
            if (jSONObject != null) {
                try {
                    gVar.f41878g = jSONObject.optString("url");
                    gVar.f41879h = jSONObject.optInt("width");
                    gVar.i = jSONObject.optInt("height");
                    gVar.j = jSONObject.optString(PackageTable.MD5);
                } catch (Exception e2) {
                    if (g.C) {
                        Log.d("SplashData", "createFromJson() Exception e: ");
                        e2.printStackTrace();
                    }
                }
            }
        }

        public static void b(JSONObject jSONObject, g gVar) {
            try {
                jSONObject.put("url", gVar.f41878g);
                jSONObject.put(PackageTable.MD5, gVar.j);
                jSONObject.put("width", gVar.f41879h);
                jSONObject.put("height", gVar.i);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean a(g gVar) {
        String str;
        boolean z;
        if (TextUtils.isEmpty(gVar.f41875d)) {
            str = "7";
            z = false;
        } else {
            str = "";
            z = true;
        }
        if (z && TextUtils.isEmpty(gVar.f41878g)) {
            str = "66";
            z = false;
        }
        if (z && TextUtils.isEmpty(gVar.j)) {
            str = "67";
            z = false;
        }
        if (z && System.currentTimeMillis() / 1000 > gVar.s) {
            str = "68";
            z = false;
        }
        if (z) {
            return true;
        }
        new d.b.a0.b.f.b(gVar).e(gVar.g() ? "BC0263" : "BC0265", str);
        return false;
    }

    public static g b(JSONObject jSONObject) {
        g gVar = new g();
        try {
            a.a(jSONObject, gVar);
            if (C) {
                Log.d("SplashData", "createFromJson() item.toString(): " + gVar.toString());
            }
            return gVar;
        } catch (Exception e2) {
            if (C) {
                Log.d("SplashData", "createFromJson() Exception e: ");
                e2.printStackTrace();
            }
            return gVar;
        }
    }

    public static g c(JSONObject jSONObject) {
        try {
            g gVar = new g();
            a.b(jSONObject, gVar);
            if (C) {
                Log.d("SplashData", "createFromJson() item.toString(): " + gVar.toString());
            }
            return gVar;
        } catch (Exception e2) {
            if (C) {
                Log.d("SplashData", "createFromJson() Exception e: ");
                e2.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public static List<g> h(JSONArray jSONArray) {
        g c2;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                c2 = c((JSONObject) jSONArray.get(i));
            } catch (JSONException e2) {
                e2.printStackTrace();
                if (C) {
                    Log.d("SplashData", "wqd--->splash parser JSONException: ");
                    e2.printStackTrace();
                }
            }
            if (c2 == null) {
                break;
            }
            if (c2.f41872a == 1 && !a(c2)) {
                if (C) {
                    Log.d("SplashData", "物料不合法抛弃： splashDataItem:  i=" + i + ",content" + c2.toString());
                }
            } else {
                arrayList.add(c2);
                if (C) {
                    Log.d("SplashData", "splashDataItem:  i=" + i + ",content" + c2.toString());
                }
            }
        }
        return arrayList;
    }

    public static void j(g gVar, g gVar2) {
        a.d(gVar, gVar2);
    }

    public JSONObject d() {
        if (!TextUtils.isEmpty(this.B)) {
            try {
                return new JSONObject(this.B);
            } catch (JSONException e2) {
                e2.printStackTrace();
                return new JSONObject();
            }
        }
        return new JSONObject();
    }

    @NonNull
    public String e() {
        return TextUtils.equals(this.f41876e, "splash_image") ? "image" : TextUtils.equals(this.f41876e, "splash_video") ? "video" : "";
    }

    public boolean f() {
        return this.f41877f == 1;
    }

    public boolean g() {
        return TextUtils.equals(this.f41876e, "splash_image");
    }

    public String i() {
        JSONObject jSONObject = new JSONObject();
        a.c(jSONObject, this);
        return jSONObject.toString();
    }
}
