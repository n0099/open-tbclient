package com.kwad.sdk.glide.e;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final List<C1093a<?>> f10262a = new ArrayList();

    /* renamed from: com.kwad.sdk.glide.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private static final class C1093a<T> {

        /* renamed from: a  reason: collision with root package name */
        final com.kwad.sdk.glide.load.a<T> f10263a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<T> f10264b;

        C1093a(@NonNull Class<T> cls, @NonNull com.kwad.sdk.glide.load.a<T> aVar) {
            this.f10264b = cls;
            this.f10263a = aVar;
        }

        boolean a(@NonNull Class<?> cls) {
            return this.f10264b.isAssignableFrom(cls);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
        r0 = (com.kwad.sdk.glide.load.a<T>) r0.f10263a;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized <T> com.kwad.sdk.glide.load.a<T> a(@NonNull Class<T> cls) {
        com.kwad.sdk.glide.load.a<T> aVar;
        Iterator<C1093a<?>> it = this.f10262a.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = null;
                break;
            }
            C1093a<?> next = it.next();
            if (next.a(cls)) {
                break;
            }
        }
        return aVar;
    }

    public synchronized <T> void a(@NonNull Class<T> cls, @NonNull com.kwad.sdk.glide.load.a<T> aVar) {
        this.f10262a.add(new C1093a<>(cls, aVar));
    }
}
