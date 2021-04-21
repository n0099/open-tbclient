package com.kwad.sdk.glide.load.a.a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.data.mediastore.ThumbFetcher;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import com.kwad.sdk.glide.load.a.g;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class c implements com.kwad.sdk.glide.load.a.d<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f35617a;

    /* renamed from: b  reason: collision with root package name */
    public final e f35618b;

    /* renamed from: c  reason: collision with root package name */
    public InputStream f35619c;

    /* loaded from: classes6.dex */
    public static class a implements d {

        /* renamed from: b  reason: collision with root package name */
        public static final String[] f35620b = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        public final ContentResolver f35621a;

        public a(ContentResolver contentResolver) {
            this.f35621a = contentResolver;
        }

        @Override // com.kwad.sdk.glide.load.a.a.d
        public Cursor a(Uri uri) {
            return this.f35621a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f35620b, ThumbFetcher.ImageThumbnailQuery.PATH_SELECTION, new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements d {

        /* renamed from: b  reason: collision with root package name */
        public static final String[] f35622b = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        public final ContentResolver f35623a;

        public b(ContentResolver contentResolver) {
            this.f35623a = contentResolver;
        }

        @Override // com.kwad.sdk.glide.load.a.a.d
        public Cursor a(Uri uri) {
            return this.f35623a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f35622b, ThumbFetcher.VideoThumbnailQuery.PATH_SELECTION, new String[]{uri.getLastPathSegment()}, null);
        }
    }

    @VisibleForTesting
    public c(Uri uri, e eVar) {
        this.f35617a = uri;
        this.f35618b = eVar;
    }

    public static c a(Context context, Uri uri) {
        return a(context, uri, new a(context.getContentResolver()));
    }

    public static c a(Context context, Uri uri, d dVar) {
        return new c(uri, new e(com.kwad.sdk.glide.c.a(context).h().a(), dVar, com.kwad.sdk.glide.c.a(context).b(), context.getContentResolver()));
    }

    public static c b(Context context, Uri uri) {
        return a(context, uri, new b(context.getContentResolver()));
    }

    private InputStream e() {
        InputStream b2 = this.f35618b.b(this.f35617a);
        int a2 = b2 != null ? this.f35618b.a(this.f35617a) : -1;
        return a2 != -1 ? new g(b2, a2) : b2;
    }

    @Override // com.kwad.sdk.glide.load.a.d
    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.kwad.sdk.glide.load.a.d
    public void a(@NonNull Priority priority, @NonNull d.a<? super InputStream> aVar) {
        try {
            InputStream e2 = e();
            this.f35619c = e2;
            aVar.a((d.a<? super InputStream>) e2);
        } catch (FileNotFoundException e3) {
            if (Log.isLoggable(ThumbFetcher.TAG, 3)) {
                Log.d(ThumbFetcher.TAG, "Failed to find thumbnail file", e3);
            }
            aVar.a((Exception) e3);
        }
    }

    @Override // com.kwad.sdk.glide.load.a.d
    public void b() {
        InputStream inputStream = this.f35619c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.kwad.sdk.glide.load.a.d
    public void c() {
    }

    @Override // com.kwad.sdk.glide.load.a.d
    @NonNull
    public DataSource d() {
        return DataSource.LOCAL;
    }
}
