package com.kwad.sdk.glide.load.b;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.b.n;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class w<Data> implements n<Uri, Data> {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f10127a = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "android.resource", "content")));

    /* renamed from: b  reason: collision with root package name */
    private final c<Data> f10128b;

    /* loaded from: classes3.dex */
    public static final class a implements o<Uri, AssetFileDescriptor>, c<AssetFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f10129a;

        public a(ContentResolver contentResolver) {
            this.f10129a = contentResolver;
        }

        @Override // com.kwad.sdk.glide.load.b.w.c
        public com.kwad.sdk.glide.load.a.d<AssetFileDescriptor> a(Uri uri) {
            return new com.kwad.sdk.glide.load.a.a(this.f10129a, uri);
        }

        @Override // com.kwad.sdk.glide.load.b.o
        public n<Uri, AssetFileDescriptor> a(r rVar) {
            return new w(this);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements o<Uri, ParcelFileDescriptor>, c<ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f10130a;

        public b(ContentResolver contentResolver) {
            this.f10130a = contentResolver;
        }

        @Override // com.kwad.sdk.glide.load.b.w.c
        public com.kwad.sdk.glide.load.a.d<ParcelFileDescriptor> a(Uri uri) {
            return new com.kwad.sdk.glide.load.a.i(this.f10130a, uri);
        }

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<Uri, ParcelFileDescriptor> a(r rVar) {
            return new w(this);
        }
    }

    /* loaded from: classes3.dex */
    public interface c<Data> {
        com.kwad.sdk.glide.load.a.d<Data> a(Uri uri);
    }

    /* loaded from: classes3.dex */
    public static class d implements o<Uri, InputStream>, c<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f10131a;

        public d(ContentResolver contentResolver) {
            this.f10131a = contentResolver;
        }

        @Override // com.kwad.sdk.glide.load.b.w.c
        public com.kwad.sdk.glide.load.a.d<InputStream> a(Uri uri) {
            return new com.kwad.sdk.glide.load.a.n(this.f10131a, uri);
        }

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<Uri, InputStream> a(r rVar) {
            return new w(this);
        }
    }

    public w(c<Data> cVar) {
        this.f10128b = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public n.a<Data> a(@NonNull Uri uri, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return new n.a<>(new com.kwad.sdk.glide.f.b(uri), this.f10128b.a(uri));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public boolean a(@NonNull Uri uri) {
        return f10127a.contains(uri.getScheme());
    }
}
