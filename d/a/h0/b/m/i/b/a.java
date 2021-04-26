package d.a.h0.b.m.i.b;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.xiaomi.mipush.sdk.Constants;
import d.a.h0.a.i2.h0;
import d.a.h0.a.i2.k0;
import d.a.h0.a.r1.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f45626a;

    /* renamed from: b  reason: collision with root package name */
    public C0888a f45627b;

    /* renamed from: c  reason: collision with root package name */
    public c f45628c;

    /* renamed from: d  reason: collision with root package name */
    public b f45629d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f45630e;

    /* renamed from: d.a.h0.b.m.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0888a {

        /* renamed from: a  reason: collision with root package name */
        public String f45631a;

        /* renamed from: b  reason: collision with root package name */
        public String f45632b;

        /* renamed from: c  reason: collision with root package name */
        public int f45633c;

        /* renamed from: d  reason: collision with root package name */
        public int f45634d;

        /* renamed from: e  reason: collision with root package name */
        public String f45635e;

        /* renamed from: f  reason: collision with root package name */
        public String f45636f;

        /* renamed from: g  reason: collision with root package name */
        public int f45637g;

        /* renamed from: h  reason: collision with root package name */
        public int f45638h;

        /* renamed from: i  reason: collision with root package name */
        public String f45639i;
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f45640a;

        /* renamed from: b  reason: collision with root package name */
        public int f45641b;
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f45642a;

        /* renamed from: b  reason: collision with root package name */
        public double f45643b;

        /* renamed from: c  reason: collision with root package name */
        public double f45644c;
    }

    public a(@NonNull Context context, @NonNull JSONObject jSONObject) {
        C0888a c0888a = new C0888a();
        c cVar = new c();
        b bVar = new b();
        String T = e.T();
        String str = "";
        this.f45626a = TextUtils.isEmpty(T) ? "" : T;
        this.f45627b = c0888a;
        this.f45628c = cVar;
        this.f45629d = bVar;
        this.f45630e = jSONObject;
        String r = k0.r();
        c0888a.f45631a = "0".equals(r) ? "" : r;
        String a2 = a();
        c0888a.f45632b = "0".equals(a2) ? "" : a2;
        c0888a.f45633c = 2;
        c0888a.f45634d = d.a.h0.b.m.i.c.a.e(context) ? 3 : 2;
        String h2 = d.a.h0.a.b0.c.h();
        c0888a.f45635e = "NUL".equals(h2) ? "" : h2;
        String f2 = d.a.h0.a.b0.c.f();
        c0888a.f45636f = "NUL".equals(f2) ? "" : f2;
        c0888a.f45637g = h0.l(context);
        c0888a.f45638h = h0.m(context);
        String b2 = b();
        if (!TextUtils.isEmpty(b2) && !Config.DEF_MAC_ID.equals(b2)) {
            str = b2;
        }
        c0888a.f45639i = str;
        bVar.f45640a = d.a.h0.b.m.i.c.a.c();
        bVar.f45641b = d.a.h0.b.m.i.c.a.d(context);
    }

    public String a() {
        String string = Settings.Secure.getString(AppRuntime.getAppContext().getContentResolver(), IAdRequestParam.ANDROID_ID);
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
            jSONObject.put(Constants.APP_ID, this.f45626a);
            jSONObject2.put(DeviceUtils.KEY_OLD_NAME_STRING, this.f45627b.f45631a);
            jSONObject2.put("androidid", this.f45627b.f45632b);
            jSONObject2.put("os_type", this.f45627b.f45633c);
            jSONObject2.put("device_type", this.f45627b.f45634d);
            jSONObject2.put("device_vendor", this.f45627b.f45635e);
            jSONObject2.put("device_model", this.f45627b.f45636f);
            jSONObject2.put("screen_height", this.f45627b.f45637g);
            jSONObject2.put("screen_width", this.f45627b.f45638h);
            jSONObject2.put(IAdRequestParam.MAC, this.f45627b.f45639i);
            jSONObject.put("device", jSONObject2);
            jSONObject3.put("coord_type", this.f45628c.f45642a);
            jSONObject3.put("latitude", this.f45628c.f45643b);
            jSONObject3.put("longitude", this.f45628c.f45644c);
            jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
            jSONObject4.put("network", this.f45629d.f45640a);
            jSONObject4.put("operator", this.f45629d.f45641b);
            jSONObject.put("network", jSONObject4);
            jSONObject.put("data", this.f45630e);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public String d() {
        return c().toString();
    }
}
