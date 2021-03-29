package com.xiaomi.push;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/* loaded from: classes7.dex */
public class as implements ar, InvocationHandler {

    /* renamed from: a  reason: collision with root package name */
    public static final String[][] f40236a = {new String[]{"com.bun.supplier.IIdentifierListener", "com.bun.supplier.IdSupplier"}, new String[]{"com.bun.miitmdid.core.IIdentifierListener", "com.bun.miitmdid.supplier.IdSupplier"}};

    /* renamed from: a  reason: collision with other field name */
    public Context f123a;

    /* renamed from: a  reason: collision with other field name */
    public Class f125a = null;

    /* renamed from: b  reason: collision with root package name */
    public Class f40237b = null;

    /* renamed from: a  reason: collision with other field name */
    public Method f127a = null;

    /* renamed from: b  reason: collision with other field name */
    public Method f128b = null;

    /* renamed from: c  reason: collision with root package name */
    public Method f40238c = null;

    /* renamed from: d  reason: collision with root package name */
    public Method f40239d = null;

    /* renamed from: e  reason: collision with root package name */
    public Method f40240e = null;

    /* renamed from: f  reason: collision with root package name */
    public Method f40241f = null;

    /* renamed from: g  reason: collision with root package name */
    public Method f40242g = null;

    /* renamed from: a  reason: collision with other field name */
    public final Object f126a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public volatile int f121a = 0;

    /* renamed from: a  reason: collision with other field name */
    public volatile long f122a = 0;

    /* renamed from: a  reason: collision with other field name */
    public volatile a f124a = null;

    /* loaded from: classes7.dex */
    public class a {

        /* renamed from: a  reason: collision with other field name */
        public Boolean f129a;

        /* renamed from: a  reason: collision with other field name */
        public String f130a;

        /* renamed from: b  reason: collision with root package name */
        public String f40244b;

        /* renamed from: c  reason: collision with root package name */
        public String f40245c;

        /* renamed from: d  reason: collision with root package name */
        public String f40246d;

        public a() {
            this.f129a = null;
            this.f130a = null;
            this.f40244b = null;
            this.f40245c = null;
            this.f40246d = null;
        }

        public boolean a() {
            if (!TextUtils.isEmpty(this.f130a) || !TextUtils.isEmpty(this.f40244b) || !TextUtils.isEmpty(this.f40245c) || !TextUtils.isEmpty(this.f40246d)) {
                this.f129a = Boolean.TRUE;
            }
            return this.f129a != null;
        }
    }

    public as(Context context) {
        this.f123a = context.getApplicationContext();
        a(context);
        b(context);
    }

    public static Class<?> a(Context context, String str) {
        try {
            return t.a(context, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static <T> T a(Method method, Object obj, Object... objArr) {
        if (method != null) {
            try {
                T t = (T) method.invoke(obj, objArr);
                if (t != null) {
                    return t;
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls != null) {
            try {
                return cls.getMethod(str, clsArr);
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    private void a() {
        synchronized (this.f126a) {
            try {
                this.f126a.notifyAll();
            } catch (Exception unused) {
            }
        }
    }

    private void a(Context context) {
        Class<?> a2 = a(context, "com.bun.miitmdid.core.MdidSdk");
        Class<?> cls = null;
        Class<?> cls2 = null;
        int i = 0;
        while (true) {
            String[][] strArr = f40236a;
            if (i >= strArr.length) {
                break;
            }
            String[] strArr2 = strArr[i];
            Class<?> a3 = a(context, strArr2[0]);
            Class<?> a4 = a(context, strArr2[1]);
            if (a3 != null && a4 != null) {
                b("found class in index " + i);
                cls2 = a4;
                cls = a3;
                break;
            }
            i++;
            cls2 = a4;
            cls = a3;
        }
        this.f125a = a2;
        this.f127a = a(a2, "InitSdk", Context.class, cls);
        this.f40237b = cls;
        this.f128b = a(cls2, "getUDID", new Class[0]);
        this.f40238c = a(cls2, "getOAID", new Class[0]);
        this.f40239d = a(cls2, "getVAID", new Class[0]);
        this.f40240e = a(cls2, "getAAID", new Class[0]);
        this.f40241f = a(cls2, "isSupported", new Class[0]);
        this.f40242g = a(cls2, "shutDown", new Class[0]);
    }

    private void a(String str) {
        if (this.f124a != null) {
            return;
        }
        long j = this.f122a;
        long elapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j);
        int i = this.f121a;
        if (elapsedRealtime > 3000 && i < 3) {
            synchronized (this.f126a) {
                if (this.f122a == j && this.f121a == i) {
                    b("retry, current count is " + i);
                    this.f121a = this.f121a + 1;
                    b(this.f123a);
                    j = this.f122a;
                    elapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j);
                }
            }
        }
        if (this.f124a != null || j < 0 || elapsedRealtime > 3000 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f126a) {
            if (this.f124a == null) {
                try {
                    b(str + " wait...");
                    this.f126a.wait(3000L);
                } catch (Exception unused) {
                }
            }
        }
    }

    public static boolean a(Object obj) {
        return (obj instanceof Boolean) || (obj instanceof Character) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Double);
    }

    private void b(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = -elapsedRealtime;
        Class cls = this.f40237b;
        if (cls != null) {
            try {
                ClassLoader classLoader = cls.getClassLoader();
                if (classLoader == null) {
                    classLoader = context.getClassLoader();
                }
                a(this.f127a, this.f125a.newInstance(), context, Proxy.newProxyInstance(classLoader, new Class[]{this.f40237b}, this));
            } catch (Throwable th) {
                b("call init sdk error:" + th);
            }
            this.f122a = elapsedRealtime;
        }
        elapsedRealtime = j;
        this.f122a = elapsedRealtime;
    }

    public static void b(String str) {
        com.xiaomi.channel.commonutils.logger.b.m51a("mdid:" + str);
    }

    @Override // com.xiaomi.push.ar
    public String a() {
        a("getUDID");
        if (this.f124a == null) {
            return null;
        }
        return this.f124a.f130a;
    }

    @Override // com.xiaomi.push.ar
    public boolean a() {
        a("isSupported");
        return this.f124a != null && Boolean.TRUE.equals(this.f124a.f129a);
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: b */
    public String mo130b() {
        a("getOAID");
        if (this.f124a == null) {
            return null;
        }
        return this.f124a.f40244b;
    }

    @Override // com.xiaomi.push.ar
    public String c() {
        a("getVAID");
        if (this.f124a == null) {
            return null;
        }
        return this.f124a.f40245c;
    }

    @Override // com.xiaomi.push.ar
    public String d() {
        a("getAAID");
        if (this.f124a == null) {
            return null;
        }
        return this.f124a.f40246d;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        this.f122a = SystemClock.elapsedRealtime();
        if (objArr != null) {
            a aVar = new a();
            int length = objArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Object obj2 = objArr[i];
                if (obj2 != null && !a(obj2)) {
                    aVar.f130a = (String) a(this.f128b, obj2, new Object[0]);
                    aVar.f40244b = (String) a(this.f40238c, obj2, new Object[0]);
                    aVar.f40245c = (String) a(this.f40239d, obj2, new Object[0]);
                    aVar.f40246d = (String) a(this.f40240e, obj2, new Object[0]);
                    aVar.f129a = (Boolean) a(this.f40241f, obj2, new Object[0]);
                    a(this.f40242g, obj2, new Object[0]);
                    if (aVar.a()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("has get succ, check duplicate:");
                        sb.append(this.f124a != null);
                        b(sb.toString());
                        synchronized (as.class) {
                            if (this.f124a == null) {
                                this.f124a = aVar;
                            }
                        }
                    }
                }
                i++;
            }
        }
        a();
        return null;
    }
}
