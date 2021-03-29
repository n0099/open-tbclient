package d.b.h0.r.y;

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
    public b f51084a = null;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Class<?> f51085a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f51086b;

        /* renamed from: c  reason: collision with root package name */
        public final Class<?> f51087c;

        /* renamed from: d  reason: collision with root package name */
        public final Method f51088d;

        /* renamed from: e  reason: collision with root package name */
        public final Object f51089e;

        /* renamed from: f  reason: collision with root package name */
        public final Method f51090f;

        /* renamed from: g  reason: collision with root package name */
        public final c f51091g;

        /* renamed from: h  reason: collision with root package name */
        public final int f51092h;
        public final j i;
        public int j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.i.a(b.this.f());
                b.this.f51091g.c();
                b.this.g();
            }
        }

        public final List<Long> f() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> h2 = h();
            int size = h2.size();
            int i = 0;
            while (i < size - 1) {
                long longValue = h2.get(i).longValue();
                i++;
                arrayList.add(Long.valueOf(h2.get(i).longValue() - longValue));
            }
            return arrayList;
        }

        public final void g() {
            this.f51091g.c();
        }

        public final List<Long> h() {
            return this.f51091g.f51094e;
        }

        public final void i() throws InvocationTargetException, IllegalAccessException {
            this.f51090f.invoke(this.f51089e, this.f51086b);
        }

        public final void j() {
            int i = this.j;
            if (i >= this.f51092h) {
                d.b.b.e.m.e.a().post(new a());
                return;
            }
            this.j = i + 1;
            try {
                i();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        public b(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.j = 0;
            this.f51087c = Class.forName("android.view.Choreographer");
            this.f51085a = Class.forName("android.view.Choreographer$FrameCallback");
            this.f51091g = new c(this);
            this.f51086b = Proxy.newProxyInstance(this.f51085a.getClassLoader(), new Class[]{this.f51085a}, this.f51091g);
            Method method = this.f51087c.getMethod("getInstance", new Class[0]);
            this.f51088d = method;
            this.f51089e = method.invoke(null, new Object[0]);
            this.f51090f = this.f51087c.getMethod("postFrameCallback", this.f51085a);
            this.f51092h = i <= 0 ? 16 : i;
            this.i = jVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements InvocationHandler {

        /* renamed from: e  reason: collision with root package name */
        public final List<Long> f51094e = new ArrayList(240);

        /* renamed from: f  reason: collision with root package name */
        public final List<Integer> f51095f = new ArrayList(15);

        /* renamed from: g  reason: collision with root package name */
        public b f51096g;

        public c(b bVar) {
            this.f51096g = bVar;
        }

        public final void c() {
            this.f51096g = null;
            this.f51094e.clear();
            this.f51095f.clear();
        }

        public final void d(long j) {
            this.f51094e.add(Long.valueOf(j));
            this.f51096g.j();
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
        public static final g f51097a = new g();
    }

    public static g a() {
        return d.f51097a;
    }

    public void b(int i, j jVar) {
        if (Build.VERSION.SDK_INT < 16) {
            return;
        }
        try {
            b bVar = new b(i, jVar);
            this.f51084a = bVar;
            bVar.j();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
