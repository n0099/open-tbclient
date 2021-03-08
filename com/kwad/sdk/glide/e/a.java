package com.kwad.sdk.glide.e;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final List<C1140a<?>> f6596a = new ArrayList();

    /* renamed from: com.kwad.sdk.glide.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static final class C1140a<T> {

        /* renamed from: a  reason: collision with root package name */
        final com.kwad.sdk.glide.load.a<T> f6597a;
        private final Class<T> b;

        C1140a(@NonNull Class<T> cls, @NonNull com.kwad.sdk.glide.load.a<T> aVar) {
            this.b = cls;
            this.f6597a = aVar;
        }

        boolean a(@NonNull Class<?> cls) {
            return this.b.isAssignableFrom(cls);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
        r0 = (com.kwad.sdk.glide.load.a<T>) r0.f6597a;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized <T> com.kwad.sdk.glide.load.a<T> a(@NonNull Class<T> cls) {
        com.kwad.sdk.glide.load.a<T> aVar;
        Iterator<C1140a<?>> it = this.f6596a.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = null;
                break;
            }
            C1140a<?> next = it.next();
            if (next.a(cls)) {
                break;
            }
        }
        return aVar;
    }

    public synchronized <T> void a(@NonNull Class<T> cls, @NonNull com.kwad.sdk.glide.load.a<T> aVar) {
        this.f6596a.add(new C1140a<>(cls, aVar));
    }
}
