package com.kwad.sdk.glide.load.a;

import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.AssetPathFetcher;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import java.io.IOException;
/* loaded from: classes6.dex */
public abstract class b<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    public final String f35630a;

    /* renamed from: b  reason: collision with root package name */
    public final AssetManager f35631b;

    /* renamed from: c  reason: collision with root package name */
    public T f35632c;

    public b(AssetManager assetManager, String str) {
        this.f35631b = assetManager;
        this.f35630a = str;
    }

    public abstract T a(AssetManager assetManager, String str);

    @Override // com.kwad.sdk.glide.load.a.d
    public void a(@NonNull Priority priority, @NonNull d.a<? super T> aVar) {
        try {
            T a2 = a(this.f35631b, this.f35630a);
            this.f35632c = a2;
            aVar.a((d.a<? super T>) a2);
        } catch (IOException e2) {
            if (Log.isLoggable(AssetPathFetcher.TAG, 3)) {
                Log.d(AssetPathFetcher.TAG, "Failed to load data from asset manager", e2);
            }
            aVar.a((Exception) e2);
        }
    }

    public abstract void a(T t);

    @Override // com.kwad.sdk.glide.load.a.d
    public void b() {
        T t = this.f35632c;
        if (t == null) {
            return;
        }
        try {
            a(t);
        } catch (IOException unused) {
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
