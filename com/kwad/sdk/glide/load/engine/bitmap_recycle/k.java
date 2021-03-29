package com.kwad.sdk.glide.load.engine.bitmap_recycle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class k implements e {

    /* renamed from: a  reason: collision with root package name */
    public static final Bitmap.Config f35494a = Bitmap.Config.ARGB_8888;

    /* renamed from: b  reason: collision with root package name */
    public final l f35495b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<Bitmap.Config> f35496c;

    /* renamed from: d  reason: collision with root package name */
    public final long f35497d;

    /* renamed from: e  reason: collision with root package name */
    public final a f35498e;

    /* renamed from: f  reason: collision with root package name */
    public long f35499f;

    /* renamed from: g  reason: collision with root package name */
    public long f35500g;

    /* renamed from: h  reason: collision with root package name */
    public int f35501h;
    public int i;
    public int j;
    public int k;

    /* loaded from: classes6.dex */
    public interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    /* loaded from: classes6.dex */
    public static final class b implements a {
        @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.k.a
        public void a(Bitmap bitmap) {
        }

        @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.k.a
        public void b(Bitmap bitmap) {
        }
    }

    public k(long j) {
        this(j, f(), g());
    }

    public k(long j, l lVar, Set<Bitmap.Config> set) {
        this.f35497d = j;
        this.f35499f = j;
        this.f35495b = lVar;
        this.f35496c = set;
        this.f35498e = new b();
    }

    private synchronized void a(long j) {
        while (this.f35500g > j) {
            Bitmap a2 = this.f35495b.a();
            if (a2 == null) {
                if (Log.isLoggable(LruBitmapPool.TAG, 5)) {
                    Log.w(LruBitmapPool.TAG, "Size mismatch, resetting");
                    e();
                }
                this.f35500g = 0L;
                return;
            }
            this.f35498e.b(a2);
            this.f35500g -= this.f35495b.c(a2);
            this.k++;
            if (Log.isLoggable(LruBitmapPool.TAG, 3)) {
                Log.d(LruBitmapPool.TAG, "Evicting bitmap=" + this.f35495b.b(a2));
            }
            d();
            a2.recycle();
        }
    }

    @TargetApi(26)
    public static void a(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    public static void b(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        c(bitmap);
    }

    @NonNull
    public static Bitmap c(int i, int i2, @Nullable Bitmap.Config config) {
        if (config == null) {
            config = f35494a;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    private void c() {
        a(this.f35499f);
    }

    @TargetApi(19)
    public static void c(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    @Nullable
    private synchronized Bitmap d(int i, int i2, @Nullable Bitmap.Config config) {
        Bitmap a2;
        a(config);
        a2 = this.f35495b.a(i, i2, config != null ? config : f35494a);
        if (a2 == null) {
            if (Log.isLoggable(LruBitmapPool.TAG, 3)) {
                Log.d(LruBitmapPool.TAG, "Missing bitmap=" + this.f35495b.b(i, i2, config));
            }
            this.i++;
        } else {
            this.f35501h++;
            this.f35500g -= this.f35495b.c(a2);
            this.f35498e.b(a2);
            b(a2);
        }
        if (Log.isLoggable(LruBitmapPool.TAG, 2)) {
            Log.v(LruBitmapPool.TAG, "Get bitmap=" + this.f35495b.b(i, i2, config));
        }
        d();
        return a2;
    }

    private void d() {
        if (Log.isLoggable(LruBitmapPool.TAG, 2)) {
            e();
        }
    }

    private void e() {
        Log.v(LruBitmapPool.TAG, "Hits=" + this.f35501h + ", misses=" + this.i + ", puts=" + this.j + ", evictions=" + this.k + ", currentSize=" + this.f35500g + ", maxSize=" + this.f35499f + "\nStrategy=" + this.f35495b);
    }

    public static l f() {
        return Build.VERSION.SDK_INT >= 19 ? new n() : new c();
    }

    @TargetApi(26)
    public static Set<Bitmap.Config> g() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        if (Build.VERSION.SDK_INT >= 19) {
            hashSet.add(null);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.e
    @NonNull
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        Bitmap d2 = d(i, i2, config);
        if (d2 != null) {
            d2.eraseColor(0);
            return d2;
        }
        return c(i, i2, config);
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.e
    public void a() {
        if (Log.isLoggable(LruBitmapPool.TAG, 3)) {
            Log.d(LruBitmapPool.TAG, "clearMemory");
        }
        a(0L);
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.e
    @SuppressLint({"InlinedApi"})
    public void a(int i) {
        if (Log.isLoggable(LruBitmapPool.TAG, 3)) {
            Log.d(LruBitmapPool.TAG, "trimMemory, level=" + i);
        }
        if (i >= 40) {
            a();
        } else if (i >= 20 || i == 15) {
            a(b() / 2);
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.e
    public synchronized void a(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            if (bitmap.isMutable() && this.f35495b.c(bitmap) <= this.f35499f && this.f35496c.contains(bitmap.getConfig())) {
                int c2 = this.f35495b.c(bitmap);
                this.f35495b.a(bitmap);
                this.f35498e.a(bitmap);
                this.j++;
                this.f35500g += c2;
                if (Log.isLoggable(LruBitmapPool.TAG, 2)) {
                    Log.v(LruBitmapPool.TAG, "Put bitmap in pool=" + this.f35495b.b(bitmap));
                }
                d();
                c();
                return;
            }
            if (Log.isLoggable(LruBitmapPool.TAG, 2)) {
                Log.v(LruBitmapPool.TAG, "Reject bitmap from pool, bitmap: " + this.f35495b.b(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f35496c.contains(bitmap.getConfig()));
            }
            bitmap.recycle();
        } catch (Throwable th) {
            throw th;
        }
    }

    public long b() {
        return this.f35499f;
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.e
    @NonNull
    public Bitmap b(int i, int i2, Bitmap.Config config) {
        Bitmap d2 = d(i, i2, config);
        return d2 == null ? c(i, i2, config) : d2;
    }
}
