package com.kwad.sdk.glide.load.b;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.model.AssetUriLoader;
import com.kwad.sdk.glide.load.b.n;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class a<Data> implements n<Uri, Data> {

    /* renamed from: a  reason: collision with root package name */
    public static final int f35658a = 22;

    /* renamed from: b  reason: collision with root package name */
    public final AssetManager f35659b;

    /* renamed from: c  reason: collision with root package name */
    public final InterfaceC0428a<Data> f35660c;

    /* renamed from: com.kwad.sdk.glide.load.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0428a<Data> {
        com.kwad.sdk.glide.load.a.d<Data> a(AssetManager assetManager, String str);
    }

    /* loaded from: classes6.dex */
    public static class b implements InterfaceC0428a<ParcelFileDescriptor>, o<Uri, ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        public final AssetManager f35666a;

        public b(AssetManager assetManager) {
            this.f35666a = assetManager;
        }

        @Override // com.kwad.sdk.glide.load.b.a.InterfaceC0428a
        public com.kwad.sdk.glide.load.a.d<ParcelFileDescriptor> a(AssetManager assetManager, String str) {
            return new com.kwad.sdk.glide.load.a.h(assetManager, str);
        }

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<Uri, ParcelFileDescriptor> a(r rVar) {
            return new a(this.f35666a, this);
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements InterfaceC0428a<InputStream>, o<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final AssetManager f35668a;

        public c(AssetManager assetManager) {
            this.f35668a = assetManager;
        }

        @Override // com.kwad.sdk.glide.load.b.a.InterfaceC0428a
        public com.kwad.sdk.glide.load.a.d<InputStream> a(AssetManager assetManager, String str) {
            return new com.kwad.sdk.glide.load.a.m(assetManager, str);
        }

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<Uri, InputStream> a(r rVar) {
            return new a(this.f35668a, this);
        }
    }

    public a(AssetManager assetManager, InterfaceC0428a<Data> interfaceC0428a) {
        this.f35659b = assetManager;
        this.f35660c = interfaceC0428a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public n.a<Data> a(@NonNull Uri uri, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return new n.a<>(new com.kwad.sdk.glide.f.b(uri), this.f35660c.a(this.f35659b, uri.toString().substring(f35658a)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public boolean a(@NonNull Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && AssetUriLoader.ASSET_PATH_SEGMENT.equals(uri.getPathSegments().get(0));
    }
}
