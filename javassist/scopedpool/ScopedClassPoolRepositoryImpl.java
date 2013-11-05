package javassist.scopedpool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import javassist.LoaderClassPath;
/* loaded from: classes.dex */
public class ScopedClassPoolRepositoryImpl implements b {
    private static final ScopedClassPoolRepositoryImpl d = new ScopedClassPoolRepositoryImpl();
    private boolean e = true;

    /* renamed from: a  reason: collision with root package name */
    protected Map f2811a = Collections.synchronizedMap(new WeakHashMap());
    protected a c = new ScopedClassPoolFactoryImpl();
    protected javassist.c b = javassist.c.a();

    private ScopedClassPoolRepositoryImpl() {
        this.b.a(new LoaderClassPath(Thread.currentThread().getContextClassLoader()));
    }

    @Override // javassist.scopedpool.b
    public boolean a() {
        return this.e;
    }

    @Override // javassist.scopedpool.b
    public Map b() {
        c();
        return this.f2811a;
    }

    public void c() {
        ArrayList arrayList;
        ArrayList arrayList2 = null;
        synchronized (this.f2811a) {
            Iterator it = this.f2811a.values().iterator();
            while (it.hasNext()) {
                ScopedClassPool scopedClassPool = (ScopedClassPool) it.next();
                if (scopedClassPool.j()) {
                    it.remove();
                    ClassLoader f = scopedClassPool.f();
                    if (f != null) {
                        arrayList = arrayList2 == null ? new ArrayList() : arrayList2;
                        arrayList.add(f);
                        arrayList2 = arrayList;
                    }
                }
                arrayList = arrayList2;
                arrayList2 = arrayList;
            }
            if (arrayList2 != null) {
                for (int i = 0; i < arrayList2.size(); i++) {
                    a((ClassLoader) arrayList2.get(i));
                }
            }
        }
    }

    @Override // javassist.scopedpool.b
    public void a(ClassLoader classLoader) {
        synchronized (this.f2811a) {
            ScopedClassPool scopedClassPool = (ScopedClassPool) this.f2811a.remove(classLoader);
            if (scopedClassPool != null) {
                scopedClassPool.i();
            }
        }
    }
}
