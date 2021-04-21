package d.b.i0.r.y;

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
    public b f51830a = null;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Class<?> f51831a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f51832b;

        /* renamed from: c  reason: collision with root package name */
        public final Class<?> f51833c;

        /* renamed from: d  reason: collision with root package name */
        public final Method f51834d;

        /* renamed from: e  reason: collision with root package name */
        public final Object f51835e;

        /* renamed from: f  reason: collision with root package name */
        public final Method f51836f;

        /* renamed from: g  reason: collision with root package name */
        public final c f51837g;

        /* renamed from: h  reason: collision with root package name */
        public final int f51838h;
        public final j i;
        public int j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.i.a(b.this.f());
                b.this.f51837g.c();
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
            this.f51837g.c();
        }

        public final List<Long> h() {
            return this.f51837g.f51840e;
        }

        public final void i() throws InvocationTargetException, IllegalAccessException {
            this.f51836f.invoke(this.f51835e, this.f51832b);
        }

        public final void j() {
            int i = this.j;
            if (i >= this.f51838h) {
                d.b.c.e.m.e.a().post(new a());
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
            this.f51833c = Class.forName("android.view.Choreographer");
            this.f51831a = Class.forName("android.view.Choreographer$FrameCallback");
            this.f51837g = new c(this);
            this.f51832b = Proxy.newProxyInstance(this.f51831a.getClassLoader(), new Class[]{this.f51831a}, this.f51837g);
            Method method = this.f51833c.getMethod("getInstance", new Class[0]);
            this.f51834d = method;
            this.f51835e = method.invoke(null, new Object[0]);
            this.f51836f = this.f51833c.getMethod("postFrameCallback", this.f51831a);
            this.f51838h = i <= 0 ? 16 : i;
            this.i = jVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements InvocationHandler {

        /* renamed from: e  reason: collision with root package name */
        public final List<Long> f51840e = new ArrayList(240);

        /* renamed from: f  reason: collision with root package name */
        public final List<Integer> f51841f = new ArrayList(15);

        /* renamed from: g  reason: collision with root package name */
        public b f51842g;

        public c(b bVar) {
            this.f51842g = bVar;
        }

        public final void c() {
            this.f51842g = null;
            this.f51840e.clear();
            this.f51841f.clear();
        }

        public final void d(long j) {
            this.f51840e.add(Long.valueOf(j));
            this.f51842g.j();
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
        public static final g f51843a = new g();
    }

    public static g a() {
        return d.f51843a;
    }

    public void b(int i, j jVar) {
        if (Build.VERSION.SDK_INT < 16) {
            return;
        }
        try {
            b bVar = new b(i, jVar);
            this.f51830a = bVar;
            bVar.j();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
