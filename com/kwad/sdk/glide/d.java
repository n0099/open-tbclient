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
    public i f35902b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.glide.load.engine.bitmap_recycle.e f35903c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.glide.load.engine.bitmap_recycle.b f35904d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.glide.load.engine.a.h f35905e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.glide.load.engine.b.a f35906f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.glide.load.engine.b.a f35907g;

    /* renamed from: h  reason: collision with root package name */
    public a.InterfaceC0420a f35908h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.glide.load.engine.a.i f35909i;
    public com.kwad.sdk.glide.c.d j;
    @Nullable
    public k.a m;
    public com.kwad.sdk.glide.load.engine.b.a n;
    public boolean o;
    @Nullable
    public List<com.kwad.sdk.glide.request.e<Object>> p;
    public boolean q;

    /* renamed from: a  reason: collision with root package name */
    public final Map<Class<?>, h<?, ?>> f35901a = new ArrayMap();
    public int k = 4;
    public com.kwad.sdk.glide.request.f l = new com.kwad.sdk.glide.request.f();

    @NonNull
    public c a(@NonNull Context context) {
        if (this.f35906f == null) {
            this.f35906f = com.kwad.sdk.glide.load.engine.b.a.b();
        }
        if (this.f35907g == null) {
            this.f35907g = com.kwad.sdk.glide.load.engine.b.a.a();
        }
        if (this.n == null) {
            this.n = com.kwad.sdk.glide.load.engine.b.a.d();
        }
        if (this.f35909i == null) {
            this.f35909i = new i.a(context).a();
        }
        if (this.j == null) {
            this.j = new com.kwad.sdk.glide.c.f();
        }
        if (this.f35903c == null) {
            int b2 = this.f35909i.b();
            if (b2 > 0) {
                this.f35903c = new com.kwad.sdk.glide.load.engine.bitmap_recycle.k(b2);
            } else {
                this.f35903c = new com.kwad.sdk.glide.load.engine.bitmap_recycle.f();
            }
        }
        if (this.f35904d == null) {
            this.f35904d = new j(this.f35909i.c());
        }
        if (this.f35905e == null) {
            this.f35905e = new com.kwad.sdk.glide.load.engine.a.g(this.f35909i.a());
        }
        if (this.f35908h == null) {
            this.f35908h = new com.kwad.sdk.glide.load.engine.a.f(context);
        }
        if (this.f35902b == null) {
            this.f35902b = new com.kwad.sdk.glide.load.engine.i(this.f35905e, this.f35908h, this.f35907g, this.f35906f, com.kwad.sdk.glide.load.engine.b.a.c(), com.kwad.sdk.glide.load.engine.b.a.d(), this.o);
        }
        List<com.kwad.sdk.glide.request.e<Object>> list = this.p;
        this.p = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        return new c(context, this.f35902b, this.f35905e, this.f35903c, this.f35904d, new k(this.m), this.j, this.k, this.l.i(), this.f35901a, this.p, this.q);
    }

    public void a(@Nullable k.a aVar) {
        this.m = aVar;
    }
}
