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
    public i f35509b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.glide.load.engine.bitmap_recycle.e f35510c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.glide.load.engine.bitmap_recycle.b f35511d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.glide.load.engine.a.h f35512e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.glide.load.engine.b.a f35513f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.glide.load.engine.b.a f35514g;

    /* renamed from: h  reason: collision with root package name */
    public a.InterfaceC0434a f35515h;
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
    public final Map<Class<?>, h<?, ?>> f35508a = new ArrayMap();
    public int k = 4;
    public com.kwad.sdk.glide.request.f l = new com.kwad.sdk.glide.request.f();

    @NonNull
    public c a(@NonNull Context context) {
        if (this.f35513f == null) {
            this.f35513f = com.kwad.sdk.glide.load.engine.b.a.b();
        }
        if (this.f35514g == null) {
            this.f35514g = com.kwad.sdk.glide.load.engine.b.a.a();
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
        if (this.f35510c == null) {
            int b2 = this.i.b();
            if (b2 > 0) {
                this.f35510c = new com.kwad.sdk.glide.load.engine.bitmap_recycle.k(b2);
            } else {
                this.f35510c = new com.kwad.sdk.glide.load.engine.bitmap_recycle.f();
            }
        }
        if (this.f35511d == null) {
            this.f35511d = new j(this.i.c());
        }
        if (this.f35512e == null) {
            this.f35512e = new com.kwad.sdk.glide.load.engine.a.g(this.i.a());
        }
        if (this.f35515h == null) {
            this.f35515h = new com.kwad.sdk.glide.load.engine.a.f(context);
        }
        if (this.f35509b == null) {
            this.f35509b = new com.kwad.sdk.glide.load.engine.i(this.f35512e, this.f35515h, this.f35514g, this.f35513f, com.kwad.sdk.glide.load.engine.b.a.c(), com.kwad.sdk.glide.load.engine.b.a.d(), this.o);
        }
        List<com.kwad.sdk.glide.request.e<Object>> list = this.p;
        this.p = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        return new c(context, this.f35509b, this.f35512e, this.f35510c, this.f35511d, new k(this.m), this.j, this.k, this.l.i(), this.f35508a, this.p, this.q);
    }

    public void a(@Nullable k.a aVar) {
        this.m = aVar;
    }
}
