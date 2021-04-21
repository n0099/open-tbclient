package d.e.a.a.b;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f66915a;

    /* renamed from: b  reason: collision with root package name */
    public int f66916b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f66917c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f66918d;

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f66919a;

        /* renamed from: b  reason: collision with root package name */
        public String f66920b;
    }

    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static h f66921a = new h();
    }

    public static h a() {
        return c.f66921a;
    }

    public void b(int i, String str) {
        if ("normal_log".equals(str)) {
            this.f66916b = i;
        }
    }

    public void c(j jVar) {
        if (jVar == null) {
            return;
        }
        synchronized (this.f66917c) {
            try {
                this.f66915a.put(this.f66915a.length(), jVar.b());
            } catch (JSONException unused) {
            }
            e(d.e.a.a.a.e().f().isForceToSend(jVar.f66925a));
        }
    }

    public void d(String str) {
        if ("normal_log".equals(str)) {
            synchronized (this.f66917c) {
                i();
            }
            e(false);
        }
    }

    public final void e(boolean z) {
        int i;
        synchronized (this.f66917c) {
            if (this.f66915a.length() == 0) {
                e.g(false, d.e.a.a.a.c(), "f509cd1137cc45e510496d1c174306a6.json", "", false);
                return;
            }
            String jSONArray = this.f66915a.toString();
            try {
                i = jSONArray.getBytes().length;
            } catch (Throwable th) {
                if (th instanceof OutOfMemoryError) {
                    System.gc();
                    return;
                }
                i = 0;
            }
            if (i == 0) {
                return;
            }
            if (204800 > i) {
                e.g(false, d.e.a.a.a.c(), "f509cd1137cc45e510496d1c174306a6.json", jSONArray, false);
            }
            if (i >= 204800 || z) {
                d.h().i("normal_log");
            }
        }
    }

    public b f(String str) {
        JSONObject jSONObject;
        b bVar = new b();
        synchronized (this.f66918d) {
            try {
                d.e.a.a.b.a f2 = d.e.a.a.a.e().f();
                jSONObject = f2 != null ? new JSONObject(f2.getHeader()) : null;
            } catch (JSONException unused) {
                return bVar;
            }
        }
        if (jSONObject == null) {
            return bVar;
        }
        synchronized (this.f66917c) {
            try {
                jSONObject.put("array", this.f66915a);
                bVar.f66919a = this.f66915a.length();
                bVar.f66920b = jSONObject.toString();
            } catch (JSONException unused2) {
            }
        }
        return bVar;
    }

    public boolean g() {
        boolean z;
        synchronized (this.f66917c) {
            z = this.f66915a.length() == 0;
        }
        return z;
    }

    public void h() {
        if (e.i(d.e.a.a.a.c(), false, "f509cd1137cc45e510496d1c174306a6.json")) {
            String c2 = e.c(false, d.e.a.a.a.c(), "f509cd1137cc45e510496d1c174306a6.json");
            if (TextUtils.isEmpty(c2) || c2.getBytes().length > 409600) {
                return;
            }
            try {
                synchronized (this.f66917c) {
                    this.f66915a = new JSONArray(c2);
                }
            } catch (JSONException unused) {
            }
        }
    }

    @SuppressLint({"NewApi"})
    public final void i() {
        int i = this.f66916b;
        if (i <= 0) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            while (true) {
                int i2 = i - 1;
                if (i > 0) {
                    this.f66915a.remove(0);
                    i = i2;
                } else {
                    this.f66916b = 0;
                    return;
                }
            }
        } else {
            try {
                Field declaredField = JSONArray.class.getDeclaredField("values");
                declaredField.setAccessible(true);
                List list = (List) declaredField.get(this.f66915a);
                int i3 = this.f66916b;
                while (true) {
                    int i4 = i3 - 1;
                    if (i3 > 0) {
                        if (list.size() > 0) {
                            list.remove(0);
                        }
                        i3 = i4;
                    } else {
                        this.f66916b = 0;
                        return;
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public h() {
        this.f66915a = new JSONArray();
        this.f66916b = 0;
        this.f66917c = new byte[0];
        this.f66918d = new byte[0];
    }
}
