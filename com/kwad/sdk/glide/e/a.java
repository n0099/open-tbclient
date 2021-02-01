package com.kwad.sdk.glide.e;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final List<C1121a<?>> f9965a = new ArrayList();

    /* renamed from: com.kwad.sdk.glide.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static final class C1121a<T> {

        /* renamed from: a  reason: collision with root package name */
        final com.kwad.sdk.glide.load.a<T> f9966a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<T> f9967b;

        C1121a(@NonNull Class<T> cls, @NonNull com.kwad.sdk.glide.load.a<T> aVar) {
            this.f9967b = cls;
            this.f9966a = aVar;
        }

        boolean a(@NonNull Class<?> cls) {
            return this.f9967b.isAssignableFrom(cls);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
        r0 = (com.kwad.sdk.glide.load.a<T>) r0.f9966a;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized <T> com.kwad.sdk.glide.load.a<T> a(@NonNull Class<T> cls) {
        com.kwad.sdk.glide.load.a<T> aVar;
        Iterator<C1121a<?>> it = this.f9965a.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = null;
                break;
            }
            C1121a<?> next = it.next();
            if (next.a(cls)) {
                break;
            }
        }
        return aVar;
    }

    public synchronized <T> void a(@NonNull Class<T> cls, @NonNull com.kwad.sdk.glide.load.a<T> aVar) {
        this.f9965a.add(new C1121a<>(cls, aVar));
    }
}
