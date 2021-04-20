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
    public b f51494a = null;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Class<?> f51495a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f51496b;

        /* renamed from: c  reason: collision with root package name */
        public final Class<?> f51497c;

        /* renamed from: d  reason: collision with root package name */
        public final Method f51498d;

        /* renamed from: e  reason: collision with root package name */
        public final Object f51499e;

        /* renamed from: f  reason: collision with root package name */
        public final Method f51500f;

        /* renamed from: g  reason: collision with root package name */
        public final c f51501g;

        /* renamed from: h  reason: collision with root package name */
        public final int f51502h;
        public final j i;
        public int j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.i.a(b.this.f());
                b.this.f51501g.c();
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
            this.f51501g.c();
        }

        public final List<Long> h() {
            return this.f51501g.f51504e;
        }

        public final void i() throws InvocationTargetException, IllegalAccessException {
            this.f51500f.invoke(this.f51499e, this.f51496b);
        }

        public final void j() {
            int i = this.j;
            if (i >= this.f51502h) {
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
            this.f51497c = Class.forName("android.view.Choreographer");
            this.f51495a = Class.forName("android.view.Choreographer$FrameCallback");
            this.f51501g = new c(this);
            this.f51496b = Proxy.newProxyInstance(this.f51495a.getClassLoader(), new Class[]{this.f51495a}, this.f51501g);
            Method method = this.f51497c.getMethod("getInstance", new Class[0]);
            this.f51498d = method;
            this.f51499e = method.invoke(null, new Object[0]);
            this.f51500f = this.f51497c.getMethod("postFrameCallback", this.f51495a);
            this.f51502h = i <= 0 ? 16 : i;
            this.i = jVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements InvocationHandler {

        /* renamed from: e  reason: collision with root package name */
        public final List<Long> f51504e = new ArrayList(240);

        /* renamed from: f  reason: collision with root package name */
        public final List<Integer> f51505f = new ArrayList(15);

        /* renamed from: g  reason: collision with root package name */
        public b f51506g;

        public c(b bVar) {
            this.f51506g = bVar;
        }

        public final void c() {
            this.f51506g = null;
            this.f51504e.clear();
            this.f51505f.clear();
        }

        public final void d(long j) {
            this.f51504e.add(Long.valueOf(j));
            this.f51506g.j();
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
        public static final g f51507a = new g();
    }

    public static g a() {
        return d.f51507a;
    }

    public void b(int i, j jVar) {
        if (Build.VERSION.SDK_INT < 16) {
            return;
        }
        try {
            b bVar = new b(i, jVar);
            this.f51494a = bVar;
            bVar.j();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
