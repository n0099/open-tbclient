package d.a.n0.r.y;

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
    public b f54144a = null;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Class<?> f54145a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f54146b;

        /* renamed from: c  reason: collision with root package name */
        public final Class<?> f54147c;

        /* renamed from: d  reason: collision with root package name */
        public final Method f54148d;

        /* renamed from: e  reason: collision with root package name */
        public final Object f54149e;

        /* renamed from: f  reason: collision with root package name */
        public final Method f54150f;

        /* renamed from: g  reason: collision with root package name */
        public final c f54151g;

        /* renamed from: h  reason: collision with root package name */
        public final int f54152h;

        /* renamed from: i  reason: collision with root package name */
        public final j f54153i;
        public int j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f54153i.a(b.this.f());
                b.this.f54151g.c();
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
            this.f54151g.c();
        }

        public final List<Long> h() {
            return this.f54151g.f54155e;
        }

        public final void i() throws InvocationTargetException, IllegalAccessException {
            this.f54150f.invoke(this.f54149e, this.f54146b);
        }

        public final void j() {
            int i2 = this.j;
            if (i2 >= this.f54152h) {
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
            this.f54147c = Class.forName("android.view.Choreographer");
            this.f54145a = Class.forName("android.view.Choreographer$FrameCallback");
            this.f54151g = new c(this);
            this.f54146b = Proxy.newProxyInstance(this.f54145a.getClassLoader(), new Class[]{this.f54145a}, this.f54151g);
            Method method = this.f54147c.getMethod("getInstance", new Class[0]);
            this.f54148d = method;
            this.f54149e = method.invoke(null, new Object[0]);
            this.f54150f = this.f54147c.getMethod("postFrameCallback", this.f54145a);
            this.f54152h = i2 <= 0 ? 16 : i2;
            this.f54153i = jVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements InvocationHandler {

        /* renamed from: e  reason: collision with root package name */
        public final List<Long> f54155e = new ArrayList(240);

        /* renamed from: f  reason: collision with root package name */
        public final List<Integer> f54156f = new ArrayList(15);

        /* renamed from: g  reason: collision with root package name */
        public b f54157g;

        public c(b bVar) {
            this.f54157g = bVar;
        }

        public final void c() {
            this.f54157g = null;
            this.f54155e.clear();
            this.f54156f.clear();
        }

        public final void d(long j) {
            this.f54155e.add(Long.valueOf(j));
            this.f54157g.j();
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
        public static final g f54158a = new g();
    }

    public static g a() {
        return d.f54158a;
    }

    public void b(int i2, j jVar) {
        if (Build.VERSION.SDK_INT < 16) {
            return;
        }
        try {
            b bVar = new b(i2, jVar);
            this.f54144a = bVar;
            bVar.j();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
