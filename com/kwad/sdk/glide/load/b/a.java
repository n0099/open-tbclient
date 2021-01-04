package com.kwad.sdk.glide.load.b;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.b.n;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class a<Data> implements n<Uri, Data> {

    /* renamed from: a  reason: collision with root package name */
    private static final int f10356a = "file:///android_asset/".length();

    /* renamed from: b  reason: collision with root package name */
    private final AssetManager f10357b;
    private final InterfaceC1096a<Data> c;

    /* renamed from: com.kwad.sdk.glide.load.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1096a<Data> {
        com.kwad.sdk.glide.load.a.d<Data> a(AssetManager assetManager, String str);
    }

    /* loaded from: classes5.dex */
    public static class b implements InterfaceC1096a<ParcelFileDescriptor>, o<Uri, ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final AssetManager f10363a;

        public b(AssetManager assetManager) {
            this.f10363a = assetManager;
        }

        @Override // com.kwad.sdk.glide.load.b.a.InterfaceC1096a
        public com.kwad.sdk.glide.load.a.d<ParcelFileDescriptor> a(AssetManager assetManager, String str) {
            return new com.kwad.sdk.glide.load.a.h(assetManager, str);
        }

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<Uri, ParcelFileDescriptor> a(r rVar) {
            return new a(this.f10363a, this);
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements InterfaceC1096a<InputStream>, o<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final AssetManager f10365a;

        public c(AssetManager assetManager) {
            this.f10365a = assetManager;
        }

        @Override // com.kwad.sdk.glide.load.b.a.InterfaceC1096a
        public com.kwad.sdk.glide.load.a.d<InputStream> a(AssetManager assetManager, String str) {
            return new com.kwad.sdk.glide.load.a.m(assetManager, str);
        }

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<Uri, InputStream> a(r rVar) {
            return new a(this.f10365a, this);
        }
    }

    public a(AssetManager assetManager, InterfaceC1096a<Data> interfaceC1096a) {
        this.f10357b = assetManager;
        this.c = interfaceC1096a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public n.a<Data> a(@NonNull Uri uri, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return new n.a<>(new com.kwad.sdk.glide.f.b(uri), this.c.a(this.f10357b, uri.toString().substring(f10356a)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public boolean a(@NonNull Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }
}
