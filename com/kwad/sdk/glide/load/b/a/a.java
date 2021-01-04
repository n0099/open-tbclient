package com.kwad.sdk.glide.load.b.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.TbConfig;
import com.kwad.sdk.glide.load.a.j;
import com.kwad.sdk.glide.load.b.g;
import com.kwad.sdk.glide.load.b.m;
import com.kwad.sdk.glide.load.b.n;
import com.kwad.sdk.glide.load.b.o;
import com.kwad.sdk.glide.load.b.r;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class a implements n<g, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Integer> f10358a = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.load.model.stream.HttpGlideUrlLoader.Timeout", Integer.valueOf((int) TbConfig.NOTIFY_YUN_PUSH));
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final m<g, g> f10359b;

    /* renamed from: com.kwad.sdk.glide.load.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1097a implements o<g, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final m<g, g> f10360a = new m<>(500);

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<g, InputStream> a(r rVar) {
            return new a(this.f10360a);
        }
    }

    public a() {
        this(null);
    }

    public a(@Nullable m<g, g> mVar) {
        this.f10359b = mVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public n.a<InputStream> a(@NonNull g gVar, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        if (this.f10359b != null) {
            g a2 = this.f10359b.a(gVar, 0, 0);
            if (a2 == null) {
                this.f10359b.a(gVar, 0, 0, gVar);
            } else {
                gVar = a2;
            }
        }
        return new n.a<>(gVar, new j(gVar, ((Integer) eVar.a(f10358a)).intValue()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public boolean a(@NonNull g gVar) {
        return true;
    }
}
