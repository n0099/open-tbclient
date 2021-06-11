package d.a.d0.b.g;

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
public class h {
    public static final boolean C = d.a.d0.a.a.a.f43269a;
    public int A;
    public String B;

    /* renamed from: a  reason: collision with root package name */
    public int f43339a;

    /* renamed from: b  reason: collision with root package name */
    public String f43340b;

    /* renamed from: c  reason: collision with root package name */
    public String f43341c;

    /* renamed from: d  reason: collision with root package name */
    public String f43342d;

    /* renamed from: e  reason: collision with root package name */
    public String f43343e;

    /* renamed from: f  reason: collision with root package name */
    public int f43344f;

    /* renamed from: g  reason: collision with root package name */
    public String f43345g;

    /* renamed from: h  reason: collision with root package name */
    public int f43346h;

    /* renamed from: i  reason: collision with root package name */
    public int f43347i;
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
        public static void a(JSONObject jSONObject, h hVar) {
            try {
                hVar.f43339a = jSONObject.optInt("advisible");
                hVar.f43340b = jSONObject.optString("id");
                hVar.f43341c = jSONObject.optString("ukey");
                hVar.f43342d = jSONObject.optString("extra");
                hVar.f43343e = jSONObject.optString("layout");
                hVar.f43344f = jSONObject.optInt("type");
                hVar.k = jSONObject.optString("jump_url");
                hVar.o = jSONObject.optString("action");
                hVar.l = jSONObject.optString("flag_name");
                hVar.m = jSONObject.optInt("logo_type");
                hVar.n = jSONObject.optInt("display");
                if (hVar.g()) {
                    b.a(jSONObject, hVar);
                } else {
                    c.a(jSONObject, hVar);
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("show_urls");
                if (optJSONArray != null) {
                    hVar.p = new String[optJSONArray.length()];
                    int length = optJSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        hVar.p[i2] = optJSONArray.optString(i2);
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("click_urls");
                if (optJSONArray2 != null) {
                    hVar.q = new String[optJSONArray2.length()];
                    int length2 = optJSONArray2.length();
                    for (int i3 = 0; i3 < length2; i3++) {
                        hVar.q[i3] = optJSONArray2.optString(i3);
                    }
                }
                hVar.r = jSONObject.optLong(IntentConfig.START);
                hVar.s = jSONObject.optLong(ProgressInfo.JSON_KEY_END);
                hVar.t = jSONObject.optInt("expose_interval");
                hVar.u = jSONObject.optInt("expose_times");
                hVar.v = jSONObject.optInt("preload_type");
                hVar.y = jSONObject.optString("click_float_lottie_url");
                hVar.z = jSONObject.optInt("float_bar_show", 1);
                hVar.A = jSONObject.optInt("click_float_opt", 1);
                hVar.B = jSONObject.optString("style_desc");
                hVar.w = jSONObject.optInt("curRate");
            } catch (Exception e2) {
                if (h.C) {
                    Log.d("SplashData", "createFromJson() Exception e: ");
                    e2.printStackTrace();
                }
            }
        }

        public static void b(JSONObject jSONObject, h hVar) {
            JSONObject optJSONObject;
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("adInfo");
                if (optJSONArray != null) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(0);
                    if (optJSONObject2 == null) {
                        return;
                    }
                    hVar.f43339a = optJSONObject2.optInt("advisible", 1);
                    hVar.f43340b = optJSONObject2.optString("id");
                    hVar.f43341c = optJSONObject2.optString("ukey");
                    JSONArray optJSONArray2 = optJSONObject2.optJSONArray("extra");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= optJSONArray2.length()) {
                                break;
                            }
                            JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i2);
                            if (optJSONObject3 != null) {
                                String optString = optJSONObject3.optString(Config.APP_KEY);
                                String optString2 = optJSONObject3.optString("v");
                                if (!TextUtils.isEmpty(optString2) && TextUtils.equals("extraParam", optString)) {
                                    hVar.f43342d = optString2;
                                    break;
                                }
                            }
                            i2++;
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
                        hVar.f43343e = optJSONObject4.optString("layout");
                        JSONObject optJSONObject5 = optJSONObject4.optJSONObject("common");
                        if (optJSONObject5 != null) {
                            hVar.f43344f = optJSONObject5.optInt("type");
                            hVar.k = optJSONObject5.optString("jump_url");
                            hVar.o = optJSONObject5.optString("action");
                            hVar.l = optJSONObject5.optString("flag_name");
                            hVar.m = optJSONObject5.optInt("logo_type");
                            hVar.n = optJSONObject5.optInt("display");
                            JSONArray optJSONArray5 = optJSONObject5.optJSONArray("image_list");
                            hVar.y = optJSONObject5.optString("click_float_lottie_url");
                            if (hVar.g() && optJSONArray5 != null && optJSONArray5.length() > 0) {
                                b.a(optJSONArray5.optJSONObject(0), hVar);
                            } else {
                                c.a(optJSONObject5, hVar);
                            }
                        }
                        JSONArray optJSONArray6 = optJSONObject4.optJSONArray("show_urls");
                        if (optJSONArray6 != null) {
                            hVar.p = new String[optJSONArray6.length()];
                            int length = optJSONArray6.length();
                            for (int i3 = 0; i3 < length; i3++) {
                                hVar.p[i3] = optJSONArray6.optString(i3);
                            }
                        }
                        JSONArray optJSONArray7 = optJSONObject4.optJSONArray("click_urls");
                        if (optJSONArray7 != null) {
                            hVar.q = new String[optJSONArray7.length()];
                            int length2 = optJSONArray7.length();
                            for (int i4 = 0; i4 < length2; i4++) {
                                hVar.q[i4] = optJSONArray7.optString(i4);
                            }
                        }
                        JSONObject optJSONObject6 = optJSONObject4.optJSONObject("policy");
                        if (optJSONObject6 != null) {
                            JSONObject jSONObject2 = optJSONObject6.getJSONObject("expire_time");
                            hVar.r = jSONObject2.optLong(IntentConfig.START);
                            hVar.s = jSONObject2.optLong(ProgressInfo.JSON_KEY_END);
                            hVar.t = optJSONObject6.optInt("expose_interval");
                            hVar.u = optJSONObject6.optInt("expose_times");
                            hVar.v = optJSONObject6.optInt("preload_type");
                            hVar.z = optJSONObject6.optInt("float_bar_show", 1);
                            hVar.A = optJSONObject6.optInt("click_float_opt", 1);
                            hVar.B = optJSONObject6.optString("style_desc");
                        }
                    }
                }
            } catch (Exception e2) {
                if (h.C) {
                    Log.d("SplashData", "createFromJson() Exception e: ");
                    e2.printStackTrace();
                }
            }
        }

        public static void c(JSONObject jSONObject, h hVar) {
            try {
                jSONObject.put("advisible", hVar.f43339a);
                jSONObject.put("id", hVar.f43340b);
                jSONObject.put("ukey", hVar.f43341c);
                jSONObject.put("extra", hVar.f43342d);
                jSONObject.put("layout", hVar.f43343e);
                jSONObject.put("type", hVar.f43344f);
                jSONObject.put("jump_url", hVar.k);
                jSONObject.put("action", hVar.o);
                jSONObject.put("flag_name", hVar.l);
                jSONObject.put("logo_type", hVar.m);
                jSONObject.put("display", hVar.n);
                jSONObject.put(IntentConfig.START, hVar.r);
                jSONObject.put(ProgressInfo.JSON_KEY_END, hVar.s);
                jSONObject.put("expose_times", hVar.u);
                jSONObject.put("expose_interval", hVar.t);
                jSONObject.put("preload_type", hVar.v);
                jSONObject.put("curRate", hVar.w);
                jSONObject.put("click_float_lottie_url", hVar.y);
                jSONObject.put("float_bar_show", hVar.z);
                jSONObject.put("click_float_opt", hVar.A);
                jSONObject.put("style_desc", hVar.B);
                if (hVar.p != null) {
                    if (d.a.d0.a.c.d.a()) {
                        jSONObject.put("show_urls", new JSONArray(hVar.p));
                    } else {
                        jSONObject.put("show_urls", new JSONArray((Collection) Arrays.asList(hVar.p)));
                    }
                }
                if (hVar.q != null) {
                    if (d.a.d0.a.c.d.a()) {
                        jSONObject.put("click_urls", new JSONArray(hVar.q));
                    } else {
                        jSONObject.put("click_urls", new JSONArray((Collection) Arrays.asList(hVar.q)));
                    }
                }
                if (hVar.g()) {
                    b.b(jSONObject, hVar);
                } else {
                    c.b(jSONObject, hVar);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }

        public static void d(h hVar, h hVar2) {
            hVar.f43339a = hVar2.f43339a;
            hVar.f43340b = hVar2.f43340b;
            hVar.f43341c = hVar2.f43341c;
            hVar.f43342d = hVar2.f43342d;
            hVar.f43343e = hVar2.f43343e;
            hVar.f43344f = hVar2.f43344f;
            hVar.f43345g = hVar2.f43345g;
            hVar.f43346h = hVar2.f43346h;
            hVar.f43347i = hVar2.f43347i;
            hVar.j = hVar2.j;
            hVar.k = hVar2.k;
            hVar.l = hVar2.l;
            hVar.m = hVar2.m;
            hVar.n = hVar2.n;
            hVar.o = hVar2.o;
            hVar.p = hVar2.p;
            hVar.q = hVar2.q;
            hVar.r = hVar2.r;
            hVar.s = hVar2.s;
            hVar.t = hVar2.t;
            hVar.u = hVar2.u;
            hVar.w = hVar2.w;
            hVar.y = hVar2.y;
            hVar.z = hVar2.z;
            hVar.A = hVar2.A;
            hVar.B = hVar2.B;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static void a(JSONObject jSONObject, h hVar) {
            if (jSONObject != null) {
                try {
                    hVar.f43345g = jSONObject.optString("url");
                    hVar.f43346h = jSONObject.optInt("width");
                    hVar.f43347i = jSONObject.optInt("height");
                    hVar.j = jSONObject.optString("imageMd5");
                } catch (Exception e2) {
                    if (h.C) {
                        Log.d("SplashData", "createFromJson() Exception e: ");
                        e2.printStackTrace();
                    }
                }
            }
        }

        public static void b(JSONObject jSONObject, h hVar) {
            try {
                jSONObject.put("url", hVar.f43345g);
                jSONObject.put("imageMd5", hVar.j);
                jSONObject.put("width", hVar.f43346h);
                jSONObject.put("height", hVar.f43347i);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
        public static void a(JSONObject jSONObject, h hVar) {
            if (jSONObject != null) {
                try {
                    hVar.f43345g = jSONObject.optString("url");
                    hVar.f43346h = jSONObject.optInt("width");
                    hVar.f43347i = jSONObject.optInt("height");
                    hVar.j = jSONObject.optString(PackageTable.MD5);
                } catch (Exception e2) {
                    if (h.C) {
                        Log.d("SplashData", "createFromJson() Exception e: ");
                        e2.printStackTrace();
                    }
                }
            }
        }

        public static void b(JSONObject jSONObject, h hVar) {
            try {
                jSONObject.put("url", hVar.f43345g);
                jSONObject.put(PackageTable.MD5, hVar.j);
                jSONObject.put("width", hVar.f43346h);
                jSONObject.put("height", hVar.f43347i);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean a(h hVar) {
        String str;
        boolean z;
        if (TextUtils.isEmpty(hVar.f43342d)) {
            str = "7";
            z = false;
        } else {
            str = "";
            z = true;
        }
        if (z && TextUtils.isEmpty(hVar.f43345g)) {
            str = "66";
            z = false;
        }
        if (z && TextUtils.isEmpty(hVar.j)) {
            str = "67";
            z = false;
        }
        if (z && System.currentTimeMillis() / 1000 > hVar.s) {
            str = "68";
            z = false;
        }
        if (z) {
            return true;
        }
        new d.a.d0.b.g.b(hVar).e(hVar.g() ? "BC0263" : "BC0265", str);
        return false;
    }

    public static h b(JSONObject jSONObject) {
        h hVar = new h();
        try {
            a.a(jSONObject, hVar);
            if (C) {
                Log.d("SplashData", "createFromJson() item.toString(): " + hVar.toString());
            }
            return hVar;
        } catch (Exception e2) {
            if (C) {
                Log.d("SplashData", "createFromJson() Exception e: ");
                e2.printStackTrace();
            }
            return hVar;
        }
    }

    public static h c(JSONObject jSONObject) {
        try {
            h hVar = new h();
            a.b(jSONObject, hVar);
            if (C) {
                Log.d("SplashData", "createFromJson() item.toString(): " + hVar.toString());
            }
            return hVar;
        } catch (Exception e2) {
            if (C) {
                Log.d("SplashData", "createFromJson() Exception e: ");
                e2.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public static List<h> h(JSONArray jSONArray) {
        h c2;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                c2 = c((JSONObject) jSONArray.get(i2));
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
            if (c2.f43339a != 0 && a(c2)) {
                arrayList.add(c2);
                if (C) {
                    Log.d("SplashData", "splashDataItem:  i=" + i2 + ",content" + c2.toString());
                }
            }
            if (C) {
                Log.d("SplashData", "空订单|物料不合法抛弃： splashDataItem:  i=" + i2 + ",content" + c2.toString());
            }
        }
        return arrayList;
    }

    public static void j(h hVar, h hVar2) {
        a.d(hVar, hVar2);
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
        return TextUtils.equals(this.f43343e, "splash_image") ? "image" : TextUtils.equals(this.f43343e, "splash_video") ? "video" : "";
    }

    public boolean f() {
        return this.f43344f == 1;
    }

    public boolean g() {
        return TextUtils.equals(this.f43343e, "splash_image");
    }

    public String i() {
        JSONObject jSONObject = new JSONObject();
        a.c(jSONObject, this);
        return jSONObject.toString();
    }
}
