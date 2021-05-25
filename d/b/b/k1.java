package d.b.b;

import android.content.Context;
import android.os.SystemProperties;
import android.util.Base64;
import android.util.Log;
import d.b.b.g1;
/* loaded from: classes6.dex */
public final class k1 implements g1 {

    /* renamed from: b  reason: collision with root package name */
    public static final String f65057b = a("cGVyc2lzdC5zeXMuaWRlbnRpZmllcmlkLnN1cHBvcnRlZA==");

    /* renamed from: c  reason: collision with root package name */
    public static final t0<Boolean> f65058c = new a();

    /* renamed from: a  reason: collision with root package name */
    public d.b.a.a f65059a;

    /* loaded from: classes6.dex */
    public static class a extends t0<Boolean> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.t0
        /* renamed from: c */
        public Boolean a(Object... objArr) {
            return Boolean.valueOf("1".equals(k1.e(k1.f65057b, "0")));
        }
    }

    public k1(Context context) {
        try {
            o1.a(context);
        } catch (Throwable unused) {
        }
        try {
            d.b.a.a aVar = new d.b.a.a();
            this.f65059a = aVar;
            aVar.c(context);
        } catch (Throwable th) {
            y0.e("OaidVivo", Log.getStackTraceString(th));
        }
    }

    public static boolean c() {
        return f65058c.b(new Object[0]).booleanValue();
    }

    public static String e(String str, String str2) {
        try {
            return SystemProperties.get(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    @Override // d.b.b.g1
    public boolean a(Context context) {
        return c();
    }

    public static String a(String str) {
        try {
            return new String(Base64.decode(str.getBytes("UTF-8"), 2));
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // d.b.b.g1
    public g1.a b(Context context) {
        d.b.a.a aVar = this.f65059a;
        if (aVar == null) {
            return null;
        }
        return aVar.b(context);
    }
}
