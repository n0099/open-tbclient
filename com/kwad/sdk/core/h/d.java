package com.kwad.sdk.core.h;

import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f34576a;

    /* renamed from: b  reason: collision with root package name */
    public volatile List<WeakReference<Object>> f34577b = new CopyOnWriteArrayList();

    public static d a() {
        if (f34576a == null) {
            synchronized (d.class) {
                if (f34576a == null) {
                    f34576a = c();
                }
            }
        }
        return f34576a;
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

    public static d c() {
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
        if (a(this.f34577b, obj)) {
            return;
        }
        b(this.f34577b, obj);
        d();
    }

    public int b() {
        Iterator<WeakReference<Object>> it = this.f34577b.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (it.next().get() == null) {
                it.remove();
            } else {
                i2++;
            }
        }
        return i2;
    }

    public void b(Object obj) {
        c(this.f34577b, obj);
        d();
    }
}
