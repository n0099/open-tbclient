package com.qq.e.comm.plugin.util;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class bf<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private Map<K, List<WeakReference<V>>> f12876a = new HashMap();

    public Collection<V> a(K k) {
        List emptyList;
        synchronized (this) {
            List<WeakReference<V>> list = this.f12876a.get(k);
            if (list == null || list.isEmpty()) {
                emptyList = Collections.emptyList();
            } else {
                Iterator<WeakReference<V>> it = list.iterator();
                ArrayList arrayList = new ArrayList();
                while (it.hasNext()) {
                    V v = it.next().get();
                    if (v == null) {
                        it.remove();
                    } else {
                        arrayList.add(v);
                    }
                }
                if (arrayList.isEmpty()) {
                    this.f12876a.remove(k);
                }
                emptyList = arrayList;
            }
        }
        return emptyList;
    }

    public void a(K k, V v) {
        synchronized (this) {
            List<WeakReference<V>> list = this.f12876a.get(k);
            if (list == null) {
                list = new ArrayList<>();
                this.f12876a.put(k, list);
            }
            list.add(new WeakReference<>(v));
        }
    }

    public void a(String str, V v) {
        synchronized (this) {
            List<WeakReference<V>> list = this.f12876a.get(str);
            if (list != null) {
                Iterator<WeakReference<V>> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next().get() == v) {
                        it.remove();
                    }
                }
            }
        }
    }
}
