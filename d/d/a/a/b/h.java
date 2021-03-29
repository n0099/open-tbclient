package d.d.a.a.b;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f65923a;

    /* renamed from: b  reason: collision with root package name */
    public int f65924b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f65925c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f65926d;

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f65927a;

        /* renamed from: b  reason: collision with root package name */
        public String f65928b;
    }

    /* loaded from: classes6.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static h f65929a = new h();
    }

    public static h a() {
        return c.f65929a;
    }

    public void b(int i, String str) {
        if ("normal_log".equals(str)) {
            this.f65924b = i;
        }
    }

    public void c(j jVar) {
        if (jVar == null) {
            return;
        }
        synchronized (this.f65925c) {
            try {
                this.f65923a.put(this.f65923a.length(), jVar.b());
            } catch (JSONException unused) {
            }
            e(d.d.a.a.a.e().f().isForceToSend(jVar.f65933a));
        }
    }

    public void d(String str) {
        if ("normal_log".equals(str)) {
            synchronized (this.f65925c) {
                i();
            }
            e(false);
        }
    }

    public final void e(boolean z) {
        int i;
        synchronized (this.f65925c) {
            if (this.f65923a.length() == 0) {
                e.g(false, d.d.a.a.a.c(), "f509cd1137cc45e510496d1c174306a6.json", "", false);
                return;
            }
            String jSONArray = this.f65923a.toString();
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
                e.g(false, d.d.a.a.a.c(), "f509cd1137cc45e510496d1c174306a6.json", jSONArray, false);
            }
            if (i >= 204800 || z) {
                d.h().i("normal_log");
            }
        }
    }

    public b f(String str) {
        JSONObject jSONObject;
        b bVar = new b();
        synchronized (this.f65926d) {
            try {
                d.d.a.a.b.a f2 = d.d.a.a.a.e().f();
                jSONObject = f2 != null ? new JSONObject(f2.getHeader()) : null;
            } catch (JSONException unused) {
                return bVar;
            }
        }
        if (jSONObject == null) {
            return bVar;
        }
        synchronized (this.f65925c) {
            try {
                jSONObject.put("array", this.f65923a);
                bVar.f65927a = this.f65923a.length();
                bVar.f65928b = jSONObject.toString();
            } catch (JSONException unused2) {
            }
        }
        return bVar;
    }

    public boolean g() {
        boolean z;
        synchronized (this.f65925c) {
            z = this.f65923a.length() == 0;
        }
        return z;
    }

    public void h() {
        if (e.i(d.d.a.a.a.c(), false, "f509cd1137cc45e510496d1c174306a6.json")) {
            String c2 = e.c(false, d.d.a.a.a.c(), "f509cd1137cc45e510496d1c174306a6.json");
            if (TextUtils.isEmpty(c2) || c2.getBytes().length > 409600) {
                return;
            }
            try {
                synchronized (this.f65925c) {
                    this.f65923a = new JSONArray(c2);
                }
            } catch (JSONException unused) {
            }
        }
    }

    @SuppressLint({"NewApi"})
    public final void i() {
        int i = this.f65924b;
        if (i <= 0) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            while (true) {
                int i2 = i - 1;
                if (i > 0) {
                    this.f65923a.remove(0);
                    i = i2;
                } else {
                    this.f65924b = 0;
                    return;
                }
            }
        } else {
            try {
                Field declaredField = JSONArray.class.getDeclaredField("values");
                declaredField.setAccessible(true);
                List list = (List) declaredField.get(this.f65923a);
                int i3 = this.f65924b;
                while (true) {
                    int i4 = i3 - 1;
                    if (i3 > 0) {
                        if (list.size() > 0) {
                            list.remove(0);
                        }
                        i3 = i4;
                    } else {
                        this.f65924b = 0;
                        return;
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public h() {
        this.f65923a = new JSONArray();
        this.f65924b = 0;
        this.f65925c = new byte[0];
        this.f65926d = new byte[0];
    }
}
