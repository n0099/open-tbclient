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
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: b  reason: collision with root package name */
    public i f35414b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.glide.load.engine.bitmap_recycle.e f35415c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.glide.load.engine.bitmap_recycle.b f35416d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.glide.load.engine.a.h f35417e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.glide.load.engine.b.a f35418f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.glide.load.engine.b.a f35419g;

    /* renamed from: h  reason: collision with root package name */
    public a.InterfaceC0431a f35420h;
    public com.kwad.sdk.glide.load.engine.a.i i;
    public com.kwad.sdk.glide.c.d j;
    @Nullable
    public k.a m;
    public com.kwad.sdk.glide.load.engine.b.a n;
    public boolean o;
    @Nullable
    public List<com.kwad.sdk.glide.request.e<Object>> p;
    public boolean q;

    /* renamed from: a  reason: collision with root package name */
    public final Map<Class<?>, h<?, ?>> f35413a = new ArrayMap();
    public int k = 4;
    public com.kwad.sdk.glide.request.f l = new com.kwad.sdk.glide.request.f();

    @NonNull
    public c a(@NonNull Context context) {
        if (this.f35418f == null) {
            this.f35418f = com.kwad.sdk.glide.load.engine.b.a.b();
        }
        if (this.f35419g == null) {
            this.f35419g = com.kwad.sdk.glide.load.engine.b.a.a();
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
        if (this.f35415c == null) {
            int b2 = this.i.b();
            if (b2 > 0) {
                this.f35415c = new com.kwad.sdk.glide.load.engine.bitmap_recycle.k(b2);
            } else {
                this.f35415c = new com.kwad.sdk.glide.load.engine.bitmap_recycle.f();
            }
        }
        if (this.f35416d == null) {
            this.f35416d = new j(this.i.c());
        }
        if (this.f35417e == null) {
            this.f35417e = new com.kwad.sdk.glide.load.engine.a.g(this.i.a());
        }
        if (this.f35420h == null) {
            this.f35420h = new com.kwad.sdk.glide.load.engine.a.f(context);
        }
        if (this.f35414b == null) {
            this.f35414b = new com.kwad.sdk.glide.load.engine.i(this.f35417e, this.f35420h, this.f35419g, this.f35418f, com.kwad.sdk.glide.load.engine.b.a.c(), com.kwad.sdk.glide.load.engine.b.a.d(), this.o);
        }
        List<com.kwad.sdk.glide.request.e<Object>> list = this.p;
        this.p = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        return new c(context, this.f35414b, this.f35417e, this.f35415c, this.f35416d, new k(this.m), this.j, this.k, this.l.i(), this.f35413a, this.p, this.q);
    }

    public void a(@Nullable k.a aVar) {
        this.m = aVar;
    }
}
