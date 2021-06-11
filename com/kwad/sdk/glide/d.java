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
/* loaded from: classes7.dex */
public final class d {

    /* renamed from: b  reason: collision with root package name */
    public i f35804b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.glide.load.engine.bitmap_recycle.e f35805c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.glide.load.engine.bitmap_recycle.b f35806d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.glide.load.engine.a.h f35807e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.glide.load.engine.b.a f35808f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.glide.load.engine.b.a f35809g;

    /* renamed from: h  reason: collision with root package name */
    public a.InterfaceC0417a f35810h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.glide.load.engine.a.i f35811i;
    public com.kwad.sdk.glide.c.d j;
    @Nullable
    public k.a m;
    public com.kwad.sdk.glide.load.engine.b.a n;
    public boolean o;
    @Nullable
    public List<com.kwad.sdk.glide.request.e<Object>> p;
    public boolean q;

    /* renamed from: a  reason: collision with root package name */
    public final Map<Class<?>, h<?, ?>> f35803a = new ArrayMap();
    public int k = 4;
    public com.kwad.sdk.glide.request.f l = new com.kwad.sdk.glide.request.f();

    @NonNull
    public c a(@NonNull Context context) {
        if (this.f35808f == null) {
            this.f35808f = com.kwad.sdk.glide.load.engine.b.a.b();
        }
        if (this.f35809g == null) {
            this.f35809g = com.kwad.sdk.glide.load.engine.b.a.a();
        }
        if (this.n == null) {
            this.n = com.kwad.sdk.glide.load.engine.b.a.d();
        }
        if (this.f35811i == null) {
            this.f35811i = new i.a(context).a();
        }
        if (this.j == null) {
            this.j = new com.kwad.sdk.glide.c.f();
        }
        if (this.f35805c == null) {
            int b2 = this.f35811i.b();
            if (b2 > 0) {
                this.f35805c = new com.kwad.sdk.glide.load.engine.bitmap_recycle.k(b2);
            } else {
                this.f35805c = new com.kwad.sdk.glide.load.engine.bitmap_recycle.f();
            }
        }
        if (this.f35806d == null) {
            this.f35806d = new j(this.f35811i.c());
        }
        if (this.f35807e == null) {
            this.f35807e = new com.kwad.sdk.glide.load.engine.a.g(this.f35811i.a());
        }
        if (this.f35810h == null) {
            this.f35810h = new com.kwad.sdk.glide.load.engine.a.f(context);
        }
        if (this.f35804b == null) {
            this.f35804b = new com.kwad.sdk.glide.load.engine.i(this.f35807e, this.f35810h, this.f35809g, this.f35808f, com.kwad.sdk.glide.load.engine.b.a.c(), com.kwad.sdk.glide.load.engine.b.a.d(), this.o);
        }
        List<com.kwad.sdk.glide.request.e<Object>> list = this.p;
        this.p = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        return new c(context, this.f35804b, this.f35807e, this.f35805c, this.f35806d, new k(this.m), this.j, this.k, this.l.i(), this.f35803a, this.p, this.q);
    }

    public void a(@Nullable k.a aVar) {
        this.m = aVar;
    }
}
