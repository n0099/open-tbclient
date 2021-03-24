package d.b.g0.b.m.i.b;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.xiaomi.mipush.sdk.Constants;
import d.b.g0.a.i2.h0;
import d.b.g0.a.i2.k0;
import d.b.g0.a.r1.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f47456a;

    /* renamed from: b  reason: collision with root package name */
    public C0916a f47457b;

    /* renamed from: c  reason: collision with root package name */
    public c f47458c;

    /* renamed from: d  reason: collision with root package name */
    public b f47459d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f47460e;

    /* renamed from: d.b.g0.b.m.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0916a {

        /* renamed from: a  reason: collision with root package name */
        public String f47461a;

        /* renamed from: b  reason: collision with root package name */
        public String f47462b;

        /* renamed from: c  reason: collision with root package name */
        public int f47463c;

        /* renamed from: d  reason: collision with root package name */
        public int f47464d;

        /* renamed from: e  reason: collision with root package name */
        public String f47465e;

        /* renamed from: f  reason: collision with root package name */
        public String f47466f;

        /* renamed from: g  reason: collision with root package name */
        public int f47467g;

        /* renamed from: h  reason: collision with root package name */
        public int f47468h;
        public String i;
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f47469a;

        /* renamed from: b  reason: collision with root package name */
        public int f47470b;
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f47471a;

        /* renamed from: b  reason: collision with root package name */
        public double f47472b;

        /* renamed from: c  reason: collision with root package name */
        public double f47473c;
    }

    public a(@NonNull Context context, @NonNull JSONObject jSONObject) {
        C0916a c0916a = new C0916a();
        c cVar = new c();
        b bVar = new b();
        String T = e.T();
        String str = "";
        this.f47456a = TextUtils.isEmpty(T) ? "" : T;
        this.f47457b = c0916a;
        this.f47458c = cVar;
        this.f47459d = bVar;
        this.f47460e = jSONObject;
        String r = k0.r();
        c0916a.f47461a = "0".equals(r) ? "" : r;
        String a2 = a();
        c0916a.f47462b = "0".equals(a2) ? "" : a2;
        c0916a.f47463c = 2;
        c0916a.f47464d = d.b.g0.b.m.i.c.a.e(context) ? 3 : 2;
        String h2 = d.b.g0.a.b0.c.h();
        c0916a.f47465e = "NUL".equals(h2) ? "" : h2;
        String f2 = d.b.g0.a.b0.c.f();
        c0916a.f47466f = "NUL".equals(f2) ? "" : f2;
        c0916a.f47467g = h0.l(context);
        c0916a.f47468h = h0.m(context);
        String b2 = b();
        if (!TextUtils.isEmpty(b2) && !Config.DEF_MAC_ID.equals(b2)) {
            str = b2;
        }
        c0916a.i = str;
        bVar.f47469a = d.b.g0.b.m.i.c.a.c();
        bVar.f47470b = d.b.g0.b.m.i.c.a.d(context);
    }

    public String a() {
        String string = Settings.Secure.getString(AppRuntime.getAppContext().getContentResolver(), "android_id");
        return TextUtils.isEmpty(string) ? "0" : string;
    }

    public String b() {
        String str;
        try {
            str = ((WifiManager) AppRuntime.getAppContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
        } catch (Exception unused) {
            str = null;
        }
        return TextUtils.isEmpty(str) ? "" : str;
    }

    @NonNull
    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject.put(Constants.APP_ID, this.f47456a);
            jSONObject2.put("deviceid", this.f47457b.f47461a);
            jSONObject2.put("androidid", this.f47457b.f47462b);
            jSONObject2.put("os_type", this.f47457b.f47463c);
            jSONObject2.put("device_type", this.f47457b.f47464d);
            jSONObject2.put("device_vendor", this.f47457b.f47465e);
            jSONObject2.put("device_model", this.f47457b.f47466f);
            jSONObject2.put("screen_height", this.f47457b.f47467g);
            jSONObject2.put("screen_width", this.f47457b.f47468h);
            jSONObject2.put("mac", this.f47457b.i);
            jSONObject.put("device", jSONObject2);
            jSONObject3.put("coord_type", this.f47458c.f47471a);
            jSONObject3.put("latitude", this.f47458c.f47472b);
            jSONObject3.put("longitude", this.f47458c.f47473c);
            jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
            jSONObject4.put("network", this.f47459d.f47469a);
            jSONObject4.put("operator", this.f47459d.f47470b);
            jSONObject.put("network", jSONObject4);
            jSONObject.put("data", this.f47460e);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public String d() {
        return c().toString();
    }
}
