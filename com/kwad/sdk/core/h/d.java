package com.kwad.sdk.core.h;

import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile d f9307a;

    /* renamed from: b  reason: collision with root package name */
    private volatile List<WeakReference<Object>> f9308b = new CopyOnWriteArrayList();

    public static d a() {
        if (f9307a == null) {
            synchronized (d.class) {
                if (f9307a == null) {
                    f9307a = c();
                }
            }
        }
        return f9307a;
    }

    private boolean a(@NonNull Collection<WeakReference<Object>> collection, Object obj) {
        if (obj == null) {
            return false;
        }
        for (WeakReference<Object> weakReference : collection) {
            if (weakReference != null && weakReference.get() != null && weakReference.get().equals(obj)) {
                return true;
            }
        }
        return false;
    }

    private void b(@NonNull Collection<WeakReference<Object>> collection, Object obj) {
        if (obj == null) {
            return;
        }
        collection.add(new WeakReference<>(obj));
    }

    private static d c() {
        return new d();
    }

    private boolean c(@NonNull Collection<WeakReference<Object>> collection, Object obj) {
        if (obj == null) {
            return false;
        }
        for (WeakReference<Object> weakReference : collection) {
            if (weakReference != null && weakReference.get() != null && weakReference.get().equals(obj)) {
                return collection.remove(weakReference);
            }
        }
        return false;
    }

    private void d() {
        b.a().a(b() > 0);
    }

    public void a(Object obj) {
        if (a(this.f9308b, obj)) {
            return;
        }
        b(this.f9308b, obj);
        d();
    }

    public int b() {
        Iterator<WeakReference<Object>> it = this.f9308b.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().get() == null) {
                it.remove();
            } else {
                i++;
            }
        }
        return i;
    }

    public void b(Object obj) {
        c(this.f9308b, obj);
        d();
    }
}
