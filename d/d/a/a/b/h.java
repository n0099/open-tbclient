package d.d.a.a.b;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import androidx.lifecycle.SavedStateHandle;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f69889a;

    /* renamed from: b  reason: collision with root package name */
    public int f69890b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f69891c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f69892d;

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f69893a;

        /* renamed from: b  reason: collision with root package name */
        public String f69894b;
    }

    /* loaded from: classes6.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static h f69895a = new h();
    }

    public static h a() {
        return c.f69895a;
    }

    public void b(int i2, String str) {
        if ("normal_log".equals(str)) {
            this.f69890b = i2;
        }
    }

    public void c(j jVar) {
        if (jVar == null) {
            return;
        }
        synchronized (this.f69891c) {
            try {
                this.f69889a.put(this.f69889a.length(), jVar.b());
            } catch (JSONException unused) {
            }
            e(d.d.a.a.a.e().f().isForceToSend(jVar.f69899a));
        }
    }

    public void d(String str) {
        if ("normal_log".equals(str)) {
            synchronized (this.f69891c) {
                i();
            }
            e(false);
        }
    }

    public final void e(boolean z) {
        int i2;
        synchronized (this.f69891c) {
            if (this.f69889a.length() == 0) {
                e.g(false, d.d.a.a.a.c(), "f509cd1137cc45e510496d1c174306a6.json", "", false);
                return;
            }
            String jSONArray = this.f69889a.toString();
            try {
                i2 = jSONArray.getBytes().length;
            } catch (Throwable th) {
                if (th instanceof OutOfMemoryError) {
                    System.gc();
                    return;
                }
                i2 = 0;
            }
            if (i2 == 0) {
                return;
            }
            if (204800 > i2) {
                e.g(false, d.d.a.a.a.c(), "f509cd1137cc45e510496d1c174306a6.json", jSONArray, false);
            }
            if (i2 >= 204800 || z) {
                d.h().i("normal_log");
            }
        }
    }

    public b f(String str) {
        JSONObject jSONObject;
        b bVar = new b();
        synchronized (this.f69892d) {
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
        synchronized (this.f69891c) {
            try {
                jSONObject.put("array", this.f69889a);
                bVar.f69893a = this.f69889a.length();
                bVar.f69894b = jSONObject.toString();
            } catch (JSONException unused2) {
            }
        }
        return bVar;
    }

    public boolean g() {
        boolean z;
        synchronized (this.f69891c) {
            z = this.f69889a.length() == 0;
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
                synchronized (this.f69891c) {
                    this.f69889a = new JSONArray(c2);
                }
            } catch (JSONException unused) {
            }
        }
    }

    @SuppressLint({"NewApi"})
    public final void i() {
        int i2 = this.f69890b;
        if (i2 <= 0) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            while (true) {
                int i3 = i2 - 1;
                if (i2 > 0) {
                    this.f69889a.remove(0);
                    i2 = i3;
                } else {
                    this.f69890b = 0;
                    return;
                }
            }
        } else {
            try {
                Field declaredField = JSONArray.class.getDeclaredField(SavedStateHandle.VALUES);
                declaredField.setAccessible(true);
                List list = (List) declaredField.get(this.f69889a);
                int i4 = this.f69890b;
                while (true) {
                    int i5 = i4 - 1;
                    if (i4 > 0) {
                        if (list.size() > 0) {
                            list.remove(0);
                        }
                        i4 = i5;
                    } else {
                        this.f69890b = 0;
                        return;
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public h() {
        this.f69889a = new JSONArray();
        this.f69890b = 0;
        this.f69891c = new byte[0];
        this.f69892d = new byte[0];
    }
}
