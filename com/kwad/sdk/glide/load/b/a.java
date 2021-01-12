package com.kwad.sdk.glide.load.b;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.b.n;
import java.io.InputStream;
/* loaded from: classes4.dex */
public class a<Data> implements n<Uri, Data> {

    /* renamed from: a  reason: collision with root package name */
    private static final int f10057a = "file:///android_asset/".length();

    /* renamed from: b  reason: collision with root package name */
    private final AssetManager f10058b;
    private final InterfaceC1120a<Data> c;

    /* renamed from: com.kwad.sdk.glide.load.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1120a<Data> {
        com.kwad.sdk.glide.load.a.d<Data> a(AssetManager assetManager, String str);
    }

    /* loaded from: classes4.dex */
    public static class b implements InterfaceC1120a<ParcelFileDescriptor>, o<Uri, ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final AssetManager f10064a;

        public b(AssetManager assetManager) {
            this.f10064a = assetManager;
        }

        @Override // com.kwad.sdk.glide.load.b.a.InterfaceC1120a
        public com.kwad.sdk.glide.load.a.d<ParcelFileDescriptor> a(AssetManager assetManager, String str) {
            return new com.kwad.sdk.glide.load.a.h(assetManager, str);
        }

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<Uri, ParcelFileDescriptor> a(r rVar) {
            return new a(this.f10064a, this);
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements InterfaceC1120a<InputStream>, o<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final AssetManager f10066a;

        public c(AssetManager assetManager) {
            this.f10066a = assetManager;
        }

        @Override // com.kwad.sdk.glide.load.b.a.InterfaceC1120a
        public com.kwad.sdk.glide.load.a.d<InputStream> a(AssetManager assetManager, String str) {
            return new com.kwad.sdk.glide.load.a.m(assetManager, str);
        }

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<Uri, InputStream> a(r rVar) {
            return new a(this.f10066a, this);
        }
    }

    public a(AssetManager assetManager, InterfaceC1120a<Data> interfaceC1120a) {
        this.f10058b = assetManager;
        this.c = interfaceC1120a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public n.a<Data> a(@NonNull Uri uri, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return new n.a<>(new com.kwad.sdk.glide.f.b(uri), this.c.a(this.f10058b, uri.toString().substring(f10057a)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public boolean a(@NonNull Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }
}
