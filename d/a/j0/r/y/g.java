package d.a.j0.r.y;

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
    public b f50297a = null;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Class<?> f50298a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f50299b;

        /* renamed from: c  reason: collision with root package name */
        public final Class<?> f50300c;

        /* renamed from: d  reason: collision with root package name */
        public final Method f50301d;

        /* renamed from: e  reason: collision with root package name */
        public final Object f50302e;

        /* renamed from: f  reason: collision with root package name */
        public final Method f50303f;

        /* renamed from: g  reason: collision with root package name */
        public final c f50304g;

        /* renamed from: h  reason: collision with root package name */
        public final int f50305h;

        /* renamed from: i  reason: collision with root package name */
        public final j f50306i;
        public int j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f50306i.a(b.this.f());
                b.this.f50304g.c();
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
            this.f50304g.c();
        }

        public final List<Long> h() {
            return this.f50304g.f50308e;
        }

        public final void i() throws InvocationTargetException, IllegalAccessException {
            this.f50303f.invoke(this.f50302e, this.f50299b);
        }

        public final void j() {
            int i2 = this.j;
            if (i2 >= this.f50305h) {
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
            this.f50300c = Class.forName("android.view.Choreographer");
            this.f50298a = Class.forName("android.view.Choreographer$FrameCallback");
            this.f50304g = new c(this);
            this.f50299b = Proxy.newProxyInstance(this.f50298a.getClassLoader(), new Class[]{this.f50298a}, this.f50304g);
            Method method = this.f50300c.getMethod("getInstance", new Class[0]);
            this.f50301d = method;
            this.f50302e = method.invoke(null, new Object[0]);
            this.f50303f = this.f50300c.getMethod("postFrameCallback", this.f50298a);
            this.f50305h = i2 <= 0 ? 16 : i2;
            this.f50306i = jVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements InvocationHandler {

        /* renamed from: e  reason: collision with root package name */
        public final List<Long> f50308e = new ArrayList(240);

        /* renamed from: f  reason: collision with root package name */
        public final List<Integer> f50309f = new ArrayList(15);

        /* renamed from: g  reason: collision with root package name */
        public b f50310g;

        public c(b bVar) {
            this.f50310g = bVar;
        }

        public final void c() {
            this.f50310g = null;
            this.f50308e.clear();
            this.f50309f.clear();
        }

        public final void d(long j) {
            this.f50308e.add(Long.valueOf(j));
            this.f50310g.j();
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
        public static final g f50311a = new g();
    }

    public static g a() {
        return d.f50311a;
    }

    public void b(int i2, j jVar) {
        if (Build.VERSION.SDK_INT < 16) {
            return;
        }
        try {
            b bVar = new b(i2, jVar);
            this.f50297a = bVar;
            bVar.j();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
