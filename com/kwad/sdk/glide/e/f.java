package com.kwad.sdk.glide.e;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.load.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<?>> f6603a = new ArrayList();

    /* loaded from: classes3.dex */
    private static final class a<T> {

        /* renamed from: a  reason: collision with root package name */
        final g<T> f6604a;
        private final Class<T> b;

        a(@NonNull Class<T> cls, @NonNull g<T> gVar) {
            this.b = cls;
            this.f6604a = gVar;
        }

        boolean a(@NonNull Class<?> cls) {
            return this.b.isAssignableFrom(cls);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
        r0 = (com.kwad.sdk.glide.load.g<Z>) r0.f6604a;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized <Z> g<Z> a(@NonNull Class<Z> cls) {
        g<Z> gVar;
        int size = this.f6603a.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                gVar = null;
                break;
            }
            a<?> aVar = this.f6603a.get(i);
            if (aVar.a(cls)) {
                break;
            }
            i++;
        }
        return gVar;
    }

    public synchronized <Z> void a(@NonNull Class<Z> cls, @NonNull g<Z> gVar) {
        this.f6603a.add(new a<>(cls, gVar));
    }

    public synchronized <Z> void b(@NonNull Class<Z> cls, @NonNull g<Z> gVar) {
        this.f6603a.add(0, new a<>(cls, gVar));
    }
}
