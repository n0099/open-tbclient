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
    public String f47457a;

    /* renamed from: b  reason: collision with root package name */
    public C0917a f47458b;

    /* renamed from: c  reason: collision with root package name */
    public c f47459c;

    /* renamed from: d  reason: collision with root package name */
    public b f47460d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f47461e;

    /* renamed from: d.b.g0.b.m.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0917a {

        /* renamed from: a  reason: collision with root package name */
        public String f47462a;

        /* renamed from: b  reason: collision with root package name */
        public String f47463b;

        /* renamed from: c  reason: collision with root package name */
        public int f47464c;

        /* renamed from: d  reason: collision with root package name */
        public int f47465d;

        /* renamed from: e  reason: collision with root package name */
        public String f47466e;

        /* renamed from: f  reason: collision with root package name */
        public String f47467f;

        /* renamed from: g  reason: collision with root package name */
        public int f47468g;

        /* renamed from: h  reason: collision with root package name */
        public int f47469h;
        public String i;
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f47470a;

        /* renamed from: b  reason: collision with root package name */
        public int f47471b;
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f47472a;

        /* renamed from: b  reason: collision with root package name */
        public double f47473b;

        /* renamed from: c  reason: collision with root package name */
        public double f47474c;
    }

    public a(@NonNull Context context, @NonNull JSONObject jSONObject) {
        C0917a c0917a = new C0917a();
        c cVar = new c();
        b bVar = new b();
        String T = e.T();
        String str = "";
        this.f47457a = TextUtils.isEmpty(T) ? "" : T;
        this.f47458b = c0917a;
        this.f47459c = cVar;
        this.f47460d = bVar;
        this.f47461e = jSONObject;
        String r = k0.r();
        c0917a.f47462a = "0".equals(r) ? "" : r;
        String a2 = a();
        c0917a.f47463b = "0".equals(a2) ? "" : a2;
        c0917a.f47464c = 2;
        c0917a.f47465d = d.b.g0.b.m.i.c.a.e(context) ? 3 : 2;
        String h2 = d.b.g0.a.b0.c.h();
        c0917a.f47466e = "NUL".equals(h2) ? "" : h2;
        String f2 = d.b.g0.a.b0.c.f();
        c0917a.f47467f = "NUL".equals(f2) ? "" : f2;
        c0917a.f47468g = h0.l(context);
        c0917a.f47469h = h0.m(context);
        String b2 = b();
        if (!TextUtils.isEmpty(b2) && !Config.DEF_MAC_ID.equals(b2)) {
            str = b2;
        }
        c0917a.i = str;
        bVar.f47470a = d.b.g0.b.m.i.c.a.c();
        bVar.f47471b = d.b.g0.b.m.i.c.a.d(context);
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
            jSONObject.put(Constants.APP_ID, this.f47457a);
            jSONObject2.put("deviceid", this.f47458b.f47462a);
            jSONObject2.put("androidid", this.f47458b.f47463b);
            jSONObject2.put("os_type", this.f47458b.f47464c);
            jSONObject2.put("device_type", this.f47458b.f47465d);
            jSONObject2.put("device_vendor", this.f47458b.f47466e);
            jSONObject2.put("device_model", this.f47458b.f47467f);
            jSONObject2.put("screen_height", this.f47458b.f47468g);
            jSONObject2.put("screen_width", this.f47458b.f47469h);
            jSONObject2.put("mac", this.f47458b.i);
            jSONObject.put("device", jSONObject2);
            jSONObject3.put("coord_type", this.f47459c.f47472a);
            jSONObject3.put("latitude", this.f47459c.f47473b);
            jSONObject3.put("longitude", this.f47459c.f47474c);
            jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
            jSONObject4.put("network", this.f47460d.f47470a);
            jSONObject4.put("operator", this.f47460d.f47471b);
            jSONObject.put("network", jSONObject4);
            jSONObject.put("data", this.f47461e);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public String d() {
        return c().toString();
    }
}
