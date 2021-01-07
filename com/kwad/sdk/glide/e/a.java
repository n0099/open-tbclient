package com.kwad.sdk.glide.e;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final List<C1134a<?>> f10263a = new ArrayList();

    /* renamed from: com.kwad.sdk.glide.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private static final class C1134a<T> {

        /* renamed from: a  reason: collision with root package name */
        final com.kwad.sdk.glide.load.a<T> f10264a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<T> f10265b;

        C1134a(@NonNull Class<T> cls, @NonNull com.kwad.sdk.glide.load.a<T> aVar) {
            this.f10265b = cls;
            this.f10264a = aVar;
        }

        boolean a(@NonNull Class<?> cls) {
            return this.f10265b.isAssignableFrom(cls);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
        r0 = (com.kwad.sdk.glide.load.a<T>) r0.f10264a;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized <T> com.kwad.sdk.glide.load.a<T> a(@NonNull Class<T> cls) {
        com.kwad.sdk.glide.load.a<T> aVar;
        Iterator<C1134a<?>> it = this.f10263a.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = null;
                break;
            }
            C1134a<?> next = it.next();
            if (next.a(cls)) {
                break;
            }
        }
        return aVar;
    }

    public synchronized <T> void a(@NonNull Class<T> cls, @NonNull com.kwad.sdk.glide.load.a<T> aVar) {
        this.f10263a.add(new C1134a<>(cls, aVar));
    }
}
