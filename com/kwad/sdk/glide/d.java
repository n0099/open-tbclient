package com.kwad.sdk.glide;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.kwad.sdk.glide.c.k;
import com.kwad.sdk.glide.load.engine.a.a;
import com.kwad.sdk.glide.load.engine.a.i;
import com.kwad.sdk.glide.load.engine.bitmap_recycle.j;
import com.kwad.sdk.glide.load.engine.i;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public final class d {
    private i b;
    private com.kwad.sdk.glide.load.engine.bitmap_recycle.e c;
    private com.kwad.sdk.glide.load.engine.bitmap_recycle.b d;
    private com.kwad.sdk.glide.load.engine.a.h e;
    private com.kwad.sdk.glide.load.engine.b.a f;
    private com.kwad.sdk.glide.load.engine.b.a g;
    private a.InterfaceC1149a h;
    private com.kwad.sdk.glide.load.engine.a.i i;
    private com.kwad.sdk.glide.c.d j;
    @Nullable
    private k.a m;
    private com.kwad.sdk.glide.load.engine.b.a n;
    private boolean o;
    @Nullable
    private List<com.kwad.sdk.glide.request.e<Object>> p;
    private boolean q;

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, h<?, ?>> f6594a = new ArrayMap();
    private int k = 4;
    private com.kwad.sdk.glide.request.f l = new com.kwad.sdk.glide.request.f();

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public c a(@NonNull Context context) {
        if (this.f == null) {
            this.f = com.kwad.sdk.glide.load.engine.b.a.b();
        }
        if (this.g == null) {
            this.g = com.kwad.sdk.glide.load.engine.b.a.a();
        }
        if (this.n == null) {
            this.n = com.kwad.sdk.glide.load.engine.b.a.d();
        }
        if (this.i == null) {
            this.i = new i.a(context).a();
        }
        if (this.j == null) {
            this.j = new com.kwad.sdk.glide.c.f();
        }
        if (this.c == null) {
            int b = this.i.b();
            if (b > 0) {
                this.c = new com.kwad.sdk.glide.load.engine.bitmap_recycle.k(b);
            } else {
                this.c = new com.kwad.sdk.glide.load.engine.bitmap_recycle.f();
            }
        }
        if (this.d == null) {
            this.d = new j(this.i.c());
        }
        if (this.e == null) {
            this.e = new com.kwad.sdk.glide.load.engine.a.g(this.i.a());
        }
        if (this.h == null) {
            this.h = new com.kwad.sdk.glide.load.engine.a.f(context);
        }
        if (this.b == null) {
            this.b = new com.kwad.sdk.glide.load.engine.i(this.e, this.h, this.g, this.f, com.kwad.sdk.glide.load.engine.b.a.c(), com.kwad.sdk.glide.load.engine.b.a.d(), this.o);
        }
        if (this.p == null) {
            this.p = Collections.emptyList();
        } else {
            this.p = Collections.unmodifiableList(this.p);
        }
        return new c(context, this.b, this.e, this.c, this.d, new k(this.m), this.j, this.k, this.l.i(), this.f6594a, this.p, this.q);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@Nullable k.a aVar) {
        this.m = aVar;
    }
}
