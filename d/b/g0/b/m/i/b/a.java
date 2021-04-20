package d.b.g0.b.m.i.b;

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
import d.b.g0.a.i2.h0;
import d.b.g0.a.i2.k0;
import d.b.g0.a.r1.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f47849a;

    /* renamed from: b  reason: collision with root package name */
    public C0929a f47850b;

    /* renamed from: c  reason: collision with root package name */
    public c f47851c;

    /* renamed from: d  reason: collision with root package name */
    public b f47852d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f47853e;

    /* renamed from: d.b.g0.b.m.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0929a {

        /* renamed from: a  reason: collision with root package name */
        public String f47854a;

        /* renamed from: b  reason: collision with root package name */
        public String f47855b;

        /* renamed from: c  reason: collision with root package name */
        public int f47856c;

        /* renamed from: d  reason: collision with root package name */
        public int f47857d;

        /* renamed from: e  reason: collision with root package name */
        public String f47858e;

        /* renamed from: f  reason: collision with root package name */
        public String f47859f;

        /* renamed from: g  reason: collision with root package name */
        public int f47860g;

        /* renamed from: h  reason: collision with root package name */
        public int f47861h;
        public String i;
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f47862a;

        /* renamed from: b  reason: collision with root package name */
        public int f47863b;
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f47864a;

        /* renamed from: b  reason: collision with root package name */
        public double f47865b;

        /* renamed from: c  reason: collision with root package name */
        public double f47866c;
    }

    public a(@NonNull Context context, @NonNull JSONObject jSONObject) {
        C0929a c0929a = new C0929a();
        c cVar = new c();
        b bVar = new b();
        String T = e.T();
        String str = "";
        this.f47849a = TextUtils.isEmpty(T) ? "" : T;
        this.f47850b = c0929a;
        this.f47851c = cVar;
        this.f47852d = bVar;
        this.f47853e = jSONObject;
        String r = k0.r();
        c0929a.f47854a = "0".equals(r) ? "" : r;
        String a2 = a();
        c0929a.f47855b = "0".equals(a2) ? "" : a2;
        c0929a.f47856c = 2;
        c0929a.f47857d = d.b.g0.b.m.i.c.a.e(context) ? 3 : 2;
        String h2 = d.b.g0.a.b0.c.h();
        c0929a.f47858e = "NUL".equals(h2) ? "" : h2;
        String f2 = d.b.g0.a.b0.c.f();
        c0929a.f47859f = "NUL".equals(f2) ? "" : f2;
        c0929a.f47860g = h0.l(context);
        c0929a.f47861h = h0.m(context);
        String b2 = b();
        if (!TextUtils.isEmpty(b2) && !Config.DEF_MAC_ID.equals(b2)) {
            str = b2;
        }
        c0929a.i = str;
        bVar.f47862a = d.b.g0.b.m.i.c.a.c();
        bVar.f47863b = d.b.g0.b.m.i.c.a.d(context);
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
            jSONObject.put(Constants.APP_ID, this.f47849a);
            jSONObject2.put(DeviceUtils.KEY_OLD_NAME_STRING, this.f47850b.f47854a);
            jSONObject2.put("androidid", this.f47850b.f47855b);
            jSONObject2.put("os_type", this.f47850b.f47856c);
            jSONObject2.put("device_type", this.f47850b.f47857d);
            jSONObject2.put("device_vendor", this.f47850b.f47858e);
            jSONObject2.put("device_model", this.f47850b.f47859f);
            jSONObject2.put("screen_height", this.f47850b.f47860g);
            jSONObject2.put("screen_width", this.f47850b.f47861h);
            jSONObject2.put(IAdRequestParam.MAC, this.f47850b.i);
            jSONObject.put("device", jSONObject2);
            jSONObject3.put("coord_type", this.f47851c.f47864a);
            jSONObject3.put("latitude", this.f47851c.f47865b);
            jSONObject3.put("longitude", this.f47851c.f47866c);
            jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
            jSONObject4.put("network", this.f47852d.f47862a);
            jSONObject4.put("operator", this.f47852d.f47863b);
            jSONObject.put("network", jSONObject4);
            jSONObject.put("data", this.f47853e);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public String d() {
        return c().toString();
    }
}
