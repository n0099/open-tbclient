package com.kwad.sdk.glide.e;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final List<C1117a<?>> f9963a = new ArrayList();

    /* renamed from: com.kwad.sdk.glide.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static final class C1117a<T> {

        /* renamed from: a  reason: collision with root package name */
        final com.kwad.sdk.glide.load.a<T> f9964a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<T> f9965b;

        C1117a(@NonNull Class<T> cls, @NonNull com.kwad.sdk.glide.load.a<T> aVar) {
            this.f9965b = cls;
            this.f9964a = aVar;
        }

        boolean a(@NonNull Class<?> cls) {
            return this.f9965b.isAssignableFrom(cls);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
        r0 = (com.kwad.sdk.glide.load.a<T>) r0.f9964a;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized <T> com.kwad.sdk.glide.load.a<T> a(@NonNull Class<T> cls) {
        com.kwad.sdk.glide.load.a<T> aVar;
        Iterator<C1117a<?>> it = this.f9963a.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = null;
                break;
            }
            C1117a<?> next = it.next();
            if (next.a(cls)) {
                break;
            }
        }
        return aVar;
    }

    public synchronized <T> void a(@NonNull Class<T> cls, @NonNull com.kwad.sdk.glide.load.a<T> aVar) {
        this.f9963a.add(new C1117a<>(cls, aVar));
    }
}
