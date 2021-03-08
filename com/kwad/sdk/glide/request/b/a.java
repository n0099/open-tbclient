package com.kwad.sdk.glide.request.b;

import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.request.b.b;
/* loaded from: classes3.dex */
public class a<R> implements b<R> {

    /* renamed from: a  reason: collision with root package name */
    static final a<?> f6831a = new a<>();
    private static final c<?> b = new C1154a();

    /* renamed from: com.kwad.sdk.glide.request.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1154a<R> implements c<R> {
        @Override // com.kwad.sdk.glide.request.b.c
        public b<R> a(DataSource dataSource, boolean z) {
            return a.f6831a;
        }
    }

    public static <R> c<R> a() {
        return (c<R>) b;
    }

    @Override // com.kwad.sdk.glide.request.b.b
    public boolean a(Object obj, b.a aVar) {
        return false;
    }
}
