package d.a.i0.r.y;

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
    public b f49478a = null;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Class<?> f49479a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f49480b;

        /* renamed from: c  reason: collision with root package name */
        public final Class<?> f49481c;

        /* renamed from: d  reason: collision with root package name */
        public final Method f49482d;

        /* renamed from: e  reason: collision with root package name */
        public final Object f49483e;

        /* renamed from: f  reason: collision with root package name */
        public final Method f49484f;

        /* renamed from: g  reason: collision with root package name */
        public final c f49485g;

        /* renamed from: h  reason: collision with root package name */
        public final int f49486h;

        /* renamed from: i  reason: collision with root package name */
        public final j f49487i;
        public int j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f49487i.a(b.this.f());
                b.this.f49485g.c();
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
            this.f49485g.c();
        }

        public final List<Long> h() {
            return this.f49485g.f49489e;
        }

        public final void i() throws InvocationTargetException, IllegalAccessException {
            this.f49484f.invoke(this.f49483e, this.f49480b);
        }

        public final void j() {
            int i2 = this.j;
            if (i2 >= this.f49486h) {
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
            this.f49481c = Class.forName("android.view.Choreographer");
            this.f49479a = Class.forName("android.view.Choreographer$FrameCallback");
            this.f49485g = new c(this);
            this.f49480b = Proxy.newProxyInstance(this.f49479a.getClassLoader(), new Class[]{this.f49479a}, this.f49485g);
            Method method = this.f49481c.getMethod("getInstance", new Class[0]);
            this.f49482d = method;
            this.f49483e = method.invoke(null, new Object[0]);
            this.f49484f = this.f49481c.getMethod("postFrameCallback", this.f49479a);
            this.f49486h = i2 <= 0 ? 16 : i2;
            this.f49487i = jVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements InvocationHandler {

        /* renamed from: e  reason: collision with root package name */
        public final List<Long> f49489e = new ArrayList(240);

        /* renamed from: f  reason: collision with root package name */
        public final List<Integer> f49490f = new ArrayList(15);

        /* renamed from: g  reason: collision with root package name */
        public b f49491g;

        public c(b bVar) {
            this.f49491g = bVar;
        }

        public final void c() {
            this.f49491g = null;
            this.f49489e.clear();
            this.f49490f.clear();
        }

        public final void d(long j) {
            this.f49489e.add(Long.valueOf(j));
            this.f49491g.j();
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
        public static final g f49492a = new g();
    }

    public static g a() {
        return d.f49492a;
    }

    public void b(int i2, j jVar) {
        if (Build.VERSION.SDK_INT < 16) {
            return;
        }
        try {
            b bVar = new b(i2, jVar);
            this.f49478a = bVar;
            bVar.j();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
