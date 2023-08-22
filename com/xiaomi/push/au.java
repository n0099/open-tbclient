package com.xiaomi.push;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/* loaded from: classes10.dex */
public class au implements at, InvocationHandler {
    public static final String[][] a = {new String[]{"com.bun.supplier.IIdentifierListener", "com.bun.supplier.IdSupplier"}, new String[]{"com.bun.miitmdid.core.IIdentifierListener", "com.bun.miitmdid.supplier.IdSupplier"}};

    /* renamed from: a  reason: collision with other field name */
    public Context f119a;

    /* renamed from: a  reason: collision with other field name */
    public Class f121a = null;
    public Class b = null;

    /* renamed from: a  reason: collision with other field name */
    public Method f123a = null;

    /* renamed from: b  reason: collision with other field name */
    public Method f124b = null;
    public Method c = null;
    public Method d = null;
    public Method e = null;
    public Method f = null;
    public Method g = null;

    /* renamed from: a  reason: collision with other field name */
    public final Object f122a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public volatile int f117a = 0;

    /* renamed from: a  reason: collision with other field name */
    public volatile long f118a = 0;

    /* renamed from: a  reason: collision with other field name */
    public volatile a f120a = null;

    /* loaded from: classes10.dex */
    public class a {

        /* renamed from: a  reason: collision with other field name */
        public Boolean f125a;

        /* renamed from: a  reason: collision with other field name */
        public String f126a;
        public String b;
        public String c;
        public String d;

        public a() {
            this.f125a = null;
            this.f126a = null;
            this.b = null;
            this.c = null;
            this.d = null;
        }

        public boolean a() {
            if (!TextUtils.isEmpty(this.f126a) || !TextUtils.isEmpty(this.b) || !TextUtils.isEmpty(this.c) || !TextUtils.isEmpty(this.d)) {
                this.f125a = Boolean.TRUE;
            }
            return this.f125a != null;
        }
    }

    public au(Context context) {
        this.f119a = context.getApplicationContext();
        a(context);
        b(context);
    }

    public static Class<?> a(Context context, String str) {
        try {
            return s.a(context, str);
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
        synchronized (this.f122a) {
            try {
                this.f122a.notifyAll();
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
            String[][] strArr = a;
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
        this.f121a = a2;
        this.f123a = a(a2, "InitSdk", Context.class, cls);
        this.b = cls;
        this.c = a(cls2, "getOAID", new Class[0]);
        this.f = a(cls2, "isSupported", new Class[0]);
        this.g = a(cls2, "shutDown", new Class[0]);
    }

    private void a(String str) {
        if (this.f120a != null) {
            return;
        }
        long j = this.f118a;
        long elapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j);
        int i = this.f117a;
        if (elapsedRealtime > 3000 && i < 3) {
            synchronized (this.f122a) {
                if (this.f118a == j && this.f117a == i) {
                    b("retry, current count is " + i);
                    this.f117a = this.f117a + 1;
                    b(this.f119a);
                    j = this.f118a;
                    elapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j);
                }
            }
        }
        if (this.f120a != null || j < 0 || elapsedRealtime > 3000 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f122a) {
            if (this.f120a == null) {
                try {
                    b(str + " wait...");
                    this.f122a.wait(3000L);
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
        Class cls = this.b;
        if (cls != null) {
            try {
                ClassLoader classLoader = cls.getClassLoader();
                if (classLoader == null) {
                    classLoader = context.getClassLoader();
                }
                a(this.f123a, this.f121a.newInstance(), context, Proxy.newProxyInstance(classLoader, new Class[]{this.b}, this));
            } catch (Throwable th) {
                b("call init sdk error:" + th);
            }
            this.f118a = elapsedRealtime;
        }
        elapsedRealtime = j;
        this.f118a = elapsedRealtime;
    }

    public static void b(String str) {
        com.xiaomi.channel.commonutils.logger.b.m180a("mdid:" + str);
    }

    @Override // com.xiaomi.push.at
    /* renamed from: a */
    public String mo265a() {
        a("getOAID");
        if (this.f120a == null) {
            return null;
        }
        return this.f120a.b;
    }

    @Override // com.xiaomi.push.at
    /* renamed from: a */
    public boolean mo266a() {
        a("isSupported");
        return this.f120a != null && Boolean.TRUE.equals(this.f120a.f125a);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        this.f118a = SystemClock.elapsedRealtime();
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
                    aVar.b = (String) a(this.c, obj2, new Object[0]);
                    aVar.f125a = (Boolean) a(this.f, obj2, new Object[0]);
                    a(this.g, obj2, new Object[0]);
                    if (aVar.a()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("has get succ, check duplicate:");
                        sb.append(this.f120a != null);
                        b(sb.toString());
                        synchronized (au.class) {
                            if (this.f120a == null) {
                                this.f120a = aVar;
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
