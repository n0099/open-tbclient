package com.kwad.sdk.glide.load.a;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.LocalUriFetcher;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import java.io.FileNotFoundException;
import java.io.IOException;
/* loaded from: classes6.dex */
public abstract class l<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f35270a;

    /* renamed from: b  reason: collision with root package name */
    public final ContentResolver f35271b;

    /* renamed from: c  reason: collision with root package name */
    public T f35272c;

    public l(ContentResolver contentResolver, Uri uri) {
        this.f35271b = contentResolver;
        this.f35270a = uri;
    }

    @Override // com.kwad.sdk.glide.load.a.d
    public final void a(@NonNull Priority priority, @NonNull d.a<? super T> aVar) {
        try {
            T b2 = b(this.f35270a, this.f35271b);
            this.f35272c = b2;
            aVar.a((d.a<? super T>) b2);
        } catch (FileNotFoundException e2) {
            if (Log.isLoggable(LocalUriFetcher.TAG, 3)) {
                Log.d(LocalUriFetcher.TAG, "Failed to open Uri", e2);
            }
            aVar.a((Exception) e2);
        }
    }

    public abstract void a(T t);

    public abstract T b(Uri uri, ContentResolver contentResolver);

    @Override // com.kwad.sdk.glide.load.a.d
    public void b() {
        T t = this.f35272c;
        if (t != null) {
            try {
                a(t);
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
