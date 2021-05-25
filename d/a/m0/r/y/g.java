package d.a.m0.r.y;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public b f50361a = null;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Class<?> f50362a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f50363b;

        /* renamed from: c  reason: collision with root package name */
        public final Class<?> f50364c;

        /* renamed from: d  reason: collision with root package name */
        public final Method f50365d;

        /* renamed from: e  reason: collision with root package name */
        public final Object f50366e;

        /* renamed from: f  reason: collision with root package name */
        public final Method f50367f;

        /* renamed from: g  reason: collision with root package name */
        public final c f50368g;

        /* renamed from: h  reason: collision with root package name */
        public final int f50369h;

        /* renamed from: i  reason: collision with root package name */
        public final j f50370i;
        public int j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f50370i.a(b.this.f());
                b.this.f50368g.c();
                b.this.g();
            }
        }

        public final List<Long> f() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> h2 = h();
            int size = h2.size();
            int i2 = 0;
            while (i2 < size - 1) {
                long longValue = h2.get(i2).longValue();
                i2++;
                arrayList.add(Long.valueOf(h2.get(i2).longValue() - longValue));
            }
            return arrayList;
        }

        public final void g() {
            this.f50368g.c();
        }

        public final List<Long> h() {
            return this.f50368g.f50372e;
        }

        public final void i() throws InvocationTargetException, IllegalAccessException {
            this.f50367f.invoke(this.f50366e, this.f50363b);
        }

        public final void j() {
            int i2 = this.j;
            if (i2 >= this.f50369h) {
                d.a.c.e.m.e.a().post(new a());
                return;
            }
            this.j = i2 + 1;
            try {
                i();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        public b(int i2, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.j = 0;
            this.f50364c = Class.forName("android.view.Choreographer");
            this.f50362a = Class.forName("android.view.Choreographer$FrameCallback");
            this.f50368g = new c(this);
            this.f50363b = Proxy.newProxyInstance(this.f50362a.getClassLoader(), new Class[]{this.f50362a}, this.f50368g);
            Method method = this.f50364c.getMethod("getInstance", new Class[0]);
            this.f50365d = method;
            this.f50366e = method.invoke(null, new Object[0]);
            this.f50367f = this.f50364c.getMethod("postFrameCallback", this.f50362a);
            this.f50369h = i2 <= 0 ? 16 : i2;
            this.f50370i = jVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements InvocationHandler {

        /* renamed from: e  reason: collision with root package name */
        public final List<Long> f50372e = new ArrayList(240);

        /* renamed from: f  reason: collision with root package name */
        public final List<Integer> f50373f = new ArrayList(15);

        /* renamed from: g  reason: collision with root package name */
        public b f50374g;

        public c(b bVar) {
            this.f50374g = bVar;
        }

        public final void c() {
            this.f50374g = null;
            this.f50372e.clear();
            this.f50373f.clear();
        }

        public final void d(long j) {
            this.f50372e.add(Long.valueOf(j));
            this.f50374g.j();
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            if ("doFrame".equals(name) && parameterTypes.length == 1 && parameterTypes[0] == Long.TYPE) {
                d(((Long) objArr[0]).longValue());
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public static final g f50375a = new g();
    }

    public static g a() {
        return d.f50375a;
    }

    public void b(int i2, j jVar) {
        if (Build.VERSION.SDK_INT < 16) {
            return;
        }
        try {
            b bVar = new b(i2, jVar);
            this.f50361a = bVar;
            bVar.j();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
