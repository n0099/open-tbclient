package com.kwad.sdk.glide.e;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.load.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<?>> f10275a = new ArrayList();

    /* loaded from: classes5.dex */
    private static final class a<T> {

        /* renamed from: a  reason: collision with root package name */
        final g<T> f10276a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<T> f10277b;

        a(@NonNull Class<T> cls, @NonNull g<T> gVar) {
            this.f10277b = cls;
            this.f10276a = gVar;
        }

        boolean a(@NonNull Class<?> cls) {
            return this.f10277b.isAssignableFrom(cls);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
        r0 = (com.kwad.sdk.glide.load.g<Z>) r0.f10276a;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized <Z> g<Z> a(@NonNull Class<Z> cls) {
        g<Z> gVar;
        int size = this.f10275a.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                gVar = null;
                break;
            }
            a<?> aVar = this.f10275a.get(i);
            if (aVar.a(cls)) {
                break;
            }
            i++;
        }
        return gVar;
    }

    public synchronized <Z> void a(@NonNull Class<Z> cls, @NonNull g<Z> gVar) {
        this.f10275a.add(new a<>(cls, gVar));
    }

    public synchronized <Z> void b(@NonNull Class<Z> cls, @NonNull g<Z> gVar) {
        this.f10275a.add(0, new a<>(cls, gVar));
    }
}
