package javassist.scopedpool;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class c extends AbstractMap implements Map {

    /* renamed from: a  reason: collision with root package name */
    private Map f2860a;
    private ReferenceQueue b;

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        a();
        return this.f2860a.entrySet();
    }

    private void a() {
        while (true) {
            d dVar = (d) this.b.poll();
            if (dVar != null) {
                if (dVar == ((d) this.f2860a.get(dVar.f2861a))) {
                    this.f2860a.remove(dVar.f2861a);
                }
            } else {
                return;
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        a();
        return this.f2860a.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        a();
        return this.f2860a.isEmpty();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        a();
        return this.f2860a.containsKey(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        a();
        SoftReference softReference = (SoftReference) this.f2860a.get(obj);
        if (softReference != null) {
            return softReference.get();
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        d b;
        a();
        Map map = this.f2860a;
        b = d.b(obj, obj2, this.b);
        Object put = map.put(obj, b);
        if (put != null) {
            return ((SoftReference) put).get();
        }
        return put;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        a();
        return this.f2860a.remove(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        a();
        this.f2860a.clear();
    }
}
