package com.kwad.sdk.glide.load.a.a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import com.kwad.sdk.glide.load.a.g;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class c implements com.kwad.sdk.glide.load.a.d<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f6640a;
    private final e b;
    private InputStream c;

    /* loaded from: classes3.dex */
    static class a implements d {
        private static final String[] b = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f6641a;

        a(ContentResolver contentResolver) {
            this.f6641a = contentResolver;
        }

        @Override // com.kwad.sdk.glide.load.a.a.d
        public Cursor a(Uri uri) {
            return this.f6641a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, b, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* loaded from: classes3.dex */
    static class b implements d {
        private static final String[] b = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f6642a;

        b(ContentResolver contentResolver) {
            this.f6642a = contentResolver;
        }

        @Override // com.kwad.sdk.glide.load.a.a.d
        public Cursor a(Uri uri) {
            return this.f6642a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, b, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    @VisibleForTesting
    c(Uri uri, e eVar) {
        this.f6640a = uri;
        this.b = eVar;
    }

    public static c a(Context context, Uri uri) {
        return a(context, uri, new a(context.getContentResolver()));
    }

    private static c a(Context context, Uri uri, d dVar) {
        return new c(uri, new e(com.kwad.sdk.glide.c.a(context).h().a(), dVar, com.kwad.sdk.glide.c.a(context).b(), context.getContentResolver()));
    }

    public static c b(Context context, Uri uri) {
        return a(context, uri, new b(context.getContentResolver()));
    }

    private InputStream e() {
        InputStream b2 = this.b.b(this.f6640a);
        int a2 = b2 != null ? this.b.a(this.f6640a) : -1;
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
            this.c = e();
            aVar.a((d.a<? super InputStream>) this.c);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e);
            }
            aVar.a((Exception) e);
        }
    }

    @Override // com.kwad.sdk.glide.load.a.d
    public void b() {
        if (this.c != null) {
            try {
                this.c.close();
            } catch (IOException e) {
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
