package com.kwad.sdk.glide.load.a;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import java.io.FileNotFoundException;
import java.io.IOException;
/* loaded from: classes5.dex */
public abstract class l<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f10354a;

    /* renamed from: b  reason: collision with root package name */
    private final ContentResolver f10355b;
    private T c;

    public l(ContentResolver contentResolver, Uri uri) {
        this.f10355b = contentResolver;
        this.f10354a = uri;
    }

    /* JADX DEBUG: Type inference failed for r0v3. Raw type applied. Possible types: T, ? super T */
    @Override // com.kwad.sdk.glide.load.a.d
    public final void a(@NonNull Priority priority, @NonNull d.a<? super T> aVar) {
        try {
            this.c = b(this.f10354a, this.f10355b);
            aVar.a((d.a<? super T>) ((T) this.c));
        } catch (FileNotFoundException e) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e);
            }
            aVar.a((Exception) e);
        }
    }

    protected abstract void a(T t);

    protected abstract T b(Uri uri, ContentResolver contentResolver);

    @Override // com.kwad.sdk.glide.load.a.d
    public void b() {
        if (this.c != null) {
            try {
                a(this.c);
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
