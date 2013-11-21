package javassist.scopedpool;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class c extends AbstractMap implements Map {

    /* renamed from: a  reason: collision with root package name */
    private Map f2844a;
    private ReferenceQueue b;

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        a();
        return this.f2844a.entrySet();
    }

    private void a() {
        while (true) {
            d dVar = (d) this.b.poll();
            if (dVar != null) {
                if (dVar == ((d) this.f2844a.get(dVar.f2845a))) {
                    this.f2844a.remove(dVar.f2845a);
                }
            } else {
                return;
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        a();
        return this.f2844a.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        a();
        return this.f2844a.isEmpty();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        a();
        return this.f2844a.containsKey(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        a();
        SoftReference softReference = (SoftReference) this.f2844a.get(obj);
        if (softReference != null) {
            return softReference.get();
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        d b;
        a();
        Map map = this.f2844a;
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
        return this.f2844a.remove(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        a();
        this.f2844a.clear();
    }
}
