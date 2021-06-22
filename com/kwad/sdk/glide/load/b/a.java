package com.kwad.sdk.glide.load.b;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.model.AssetUriLoader;
import com.kwad.sdk.glide.load.b.n;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class a<Data> implements n<Uri, Data> {

    /* renamed from: a  reason: collision with root package name */
    public static final int f36055a = 22;

    /* renamed from: b  reason: collision with root package name */
    public final AssetManager f36056b;

    /* renamed from: c  reason: collision with root package name */
    public final InterfaceC0414a<Data> f36057c;

    /* renamed from: com.kwad.sdk.glide.load.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0414a<Data> {
        com.kwad.sdk.glide.load.a.d<Data> a(AssetManager assetManager, String str);
    }

    /* loaded from: classes7.dex */
    public static class b implements InterfaceC0414a<ParcelFileDescriptor>, o<Uri, ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        public final AssetManager f36063a;

        public b(AssetManager assetManager) {
            this.f36063a = assetManager;
        }

        @Override // com.kwad.sdk.glide.load.b.a.InterfaceC0414a
        public com.kwad.sdk.glide.load.a.d<ParcelFileDescriptor> a(AssetManager assetManager, String str) {
            return new com.kwad.sdk.glide.load.a.h(assetManager, str);
        }

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<Uri, ParcelFileDescriptor> a(r rVar) {
            return new a(this.f36063a, this);
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements InterfaceC0414a<InputStream>, o<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final AssetManager f36065a;

        public c(AssetManager assetManager) {
            this.f36065a = assetManager;
        }

        @Override // com.kwad.sdk.glide.load.b.a.InterfaceC0414a
        public com.kwad.sdk.glide.load.a.d<InputStream> a(AssetManager assetManager, String str) {
            return new com.kwad.sdk.glide.load.a.m(assetManager, str);
        }

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<Uri, InputStream> a(r rVar) {
            return new a(this.f36065a, this);
        }
    }

    public a(AssetManager assetManager, InterfaceC0414a<Data> interfaceC0414a) {
        this.f36056b = assetManager;
        this.f36057c = interfaceC0414a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public n.a<Data> a(@NonNull Uri uri, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return new n.a<>(new com.kwad.sdk.glide.f.b(uri), this.f36057c.a(this.f36056b, uri.toString().substring(f36055a)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public boolean a(@NonNull Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && AssetUriLoader.ASSET_PATH_SEGMENT.equals(uri.getPathSegments().get(0));
    }
}
