package com.kwad.sdk.glide.load.b;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import com.kwad.sdk.glide.load.b.n;
import java.io.File;
import java.io.FileNotFoundException;
/* loaded from: classes7.dex */
public final class k implements n<Uri, File> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f36104a;

    /* loaded from: classes7.dex */
    public static final class a implements o<Uri, File> {

        /* renamed from: a  reason: collision with root package name */
        public final Context f36105a;

        public a(Context context) {
            this.f36105a = context;
        }

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<Uri, File> a(r rVar) {
            return new k(this.f36105a);
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements com.kwad.sdk.glide.load.a.d<File> {

        /* renamed from: a  reason: collision with root package name */
        public static final String[] f36106a = {"_data"};

        /* renamed from: b  reason: collision with root package name */
        public final Context f36107b;

        /* renamed from: c  reason: collision with root package name */
        public final Uri f36108c;

        public b(Context context, Uri uri) {
            this.f36107b = context;
            this.f36108c = uri;
        }

        @Override // com.kwad.sdk.glide.load.a.d
        @NonNull
        public Class<File> a() {
            return File.class;
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public void a(@NonNull Priority priority, @NonNull d.a<? super File> aVar) {
            Cursor query = this.f36107b.getContentResolver().query(this.f36108c, f36106a, null, null, null);
            if (query != null) {
                try {
                    r0 = query.moveToFirst() ? query.getString(query.getColumnIndexOrThrow("_data")) : null;
                } finally {
                    query.close();
                }
            }
            if (!TextUtils.isEmpty(r0)) {
                aVar.a((d.a<? super File>) new File(r0));
                return;
            }
            aVar.a((Exception) new FileNotFoundException("Failed to find file path for: " + this.f36108c));
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public void b() {
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

    public k(Context context) {
        this.f36104a = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public n.a<File> a(@NonNull Uri uri, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return new n.a<>(new com.kwad.sdk.glide.f.b(uri), new b(this.f36104a, uri));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public boolean a(@NonNull Uri uri) {
        return com.kwad.sdk.glide.load.a.a.b.a(uri);
    }
}
