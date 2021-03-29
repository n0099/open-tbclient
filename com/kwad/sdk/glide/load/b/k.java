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
/* loaded from: classes6.dex */
public final class k implements n<Uri, File> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f35323a;

    /* loaded from: classes6.dex */
    public static final class a implements o<Uri, File> {

        /* renamed from: a  reason: collision with root package name */
        public final Context f35324a;

        public a(Context context) {
            this.f35324a = context;
        }

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<Uri, File> a(r rVar) {
            return new k(this.f35324a);
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements com.kwad.sdk.glide.load.a.d<File> {

        /* renamed from: a  reason: collision with root package name */
        public static final String[] f35325a = {"_data"};

        /* renamed from: b  reason: collision with root package name */
        public final Context f35326b;

        /* renamed from: c  reason: collision with root package name */
        public final Uri f35327c;

        public b(Context context, Uri uri) {
            this.f35326b = context;
            this.f35327c = uri;
        }

        @Override // com.kwad.sdk.glide.load.a.d
        @NonNull
        public Class<File> a() {
            return File.class;
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public void a(@NonNull Priority priority, @NonNull d.a<? super File> aVar) {
            Cursor query = this.f35326b.getContentResolver().query(this.f35327c, f35325a, null, null, null);
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
            aVar.a((Exception) new FileNotFoundException("Failed to find file path for: " + this.f35327c));
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
        this.f35323a = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public n.a<File> a(@NonNull Uri uri, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return new n.a<>(new com.kwad.sdk.glide.f.b(uri), new b(this.f35323a, uri));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public boolean a(@NonNull Uri uri) {
        return com.kwad.sdk.glide.load.a.a.b.a(uri);
    }
}
