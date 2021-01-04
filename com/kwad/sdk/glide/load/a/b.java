package com.kwad.sdk.glide.load.a;

import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import java.io.IOException;
/* loaded from: classes5.dex */
public abstract class b<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    private final String f10340a;

    /* renamed from: b  reason: collision with root package name */
    private final AssetManager f10341b;
    private T c;

    public b(AssetManager assetManager, String str) {
        this.f10341b = assetManager;
        this.f10340a = str;
    }

    protected abstract T a(AssetManager assetManager, String str);

    /* JADX DEBUG: Type inference failed for r0v3. Raw type applied. Possible types: T, ? super T */
    @Override // com.kwad.sdk.glide.load.a.d
    public void a(@NonNull Priority priority, @NonNull d.a<? super T> aVar) {
        try {
            this.c = a(this.f10341b, this.f10340a);
            aVar.a((d.a<? super T>) ((T) this.c));
        } catch (IOException e) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e);
            }
            aVar.a((Exception) e);
        }
    }

    protected abstract void a(T t);

    @Override // com.kwad.sdk.glide.load.a.d
    public void b() {
        if (this.c == null) {
            return;
        }
        try {
            a(this.c);
        } catch (IOException e) {
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
