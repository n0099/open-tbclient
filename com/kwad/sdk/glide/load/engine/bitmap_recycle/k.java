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
/* loaded from: classes7.dex */
public class k implements e {

    /* renamed from: a  reason: collision with root package name */
    public static final Bitmap.Config f36278a = Bitmap.Config.ARGB_8888;

    /* renamed from: b  reason: collision with root package name */
    public final l f36279b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<Bitmap.Config> f36280c;

    /* renamed from: d  reason: collision with root package name */
    public final long f36281d;

    /* renamed from: e  reason: collision with root package name */
    public final a f36282e;

    /* renamed from: f  reason: collision with root package name */
    public long f36283f;

    /* renamed from: g  reason: collision with root package name */
    public long f36284g;

    /* renamed from: h  reason: collision with root package name */
    public int f36285h;

    /* renamed from: i  reason: collision with root package name */
    public int f36286i;
    public int j;
    public int k;

    /* loaded from: classes7.dex */
    public interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    /* loaded from: classes7.dex */
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
        this.f36281d = j;
        this.f36283f = j;
        this.f36279b = lVar;
        this.f36280c = set;
        this.f36282e = new b();
    }

    private synchronized void a(long j) {
        while (this.f36284g > j) {
            Bitmap a2 = this.f36279b.a();
            if (a2 == null) {
                if (Log.isLoggable(LruBitmapPool.TAG, 5)) {
                    Log.w(LruBitmapPool.TAG, "Size mismatch, resetting");
                    e();
                }
                this.f36284g = 0L;
                return;
            }
            this.f36282e.b(a2);
            this.f36284g -= this.f36279b.c(a2);
            this.k++;
            if (Log.isLoggable(LruBitmapPool.TAG, 3)) {
                Log.d(LruBitmapPool.TAG, "Evicting bitmap=" + this.f36279b.b(a2));
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
    public static Bitmap c(int i2, int i3, @Nullable Bitmap.Config config) {
        if (config == null) {
            config = f36278a;
        }
        return Bitmap.createBitmap(i2, i3, config);
    }

    private void c() {
        a(this.f36283f);
    }

    @TargetApi(19)
    public static void c(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    @Nullable
    private synchronized Bitmap d(int i2, int i3, @Nullable Bitmap.Config config) {
        Bitmap a2;
        a(config);
        a2 = this.f36279b.a(i2, i3, config != null ? config : f36278a);
        if (a2 == null) {
            if (Log.isLoggable(LruBitmapPool.TAG, 3)) {
                Log.d(LruBitmapPool.TAG, "Missing bitmap=" + this.f36279b.b(i2, i3, config));
            }
            this.f36286i++;
        } else {
            this.f36285h++;
            this.f36284g -= this.f36279b.c(a2);
            this.f36282e.b(a2);
            b(a2);
        }
        if (Log.isLoggable(LruBitmapPool.TAG, 2)) {
            Log.v(LruBitmapPool.TAG, "Get bitmap=" + this.f36279b.b(i2, i3, config));
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
        Log.v(LruBitmapPool.TAG, "Hits=" + this.f36285h + ", misses=" + this.f36286i + ", puts=" + this.j + ", evictions=" + this.k + ", currentSize=" + this.f36284g + ", maxSize=" + this.f36283f + "\nStrategy=" + this.f36279b);
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
    public Bitmap a(int i2, int i3, Bitmap.Config config) {
        Bitmap d2 = d(i2, i3, config);
        if (d2 != null) {
            d2.eraseColor(0);
            return d2;
        }
        return c(i2, i3, config);
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
    public void a(int i2) {
        if (Log.isLoggable(LruBitmapPool.TAG, 3)) {
            Log.d(LruBitmapPool.TAG, "trimMemory, level=" + i2);
        }
        if (i2 >= 40) {
            a();
        } else if (i2 >= 20 || i2 == 15) {
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
            if (bitmap.isMutable() && this.f36279b.c(bitmap) <= this.f36283f && this.f36280c.contains(bitmap.getConfig())) {
                int c2 = this.f36279b.c(bitmap);
                this.f36279b.a(bitmap);
                this.f36282e.a(bitmap);
                this.j++;
                this.f36284g += c2;
                if (Log.isLoggable(LruBitmapPool.TAG, 2)) {
                    Log.v(LruBitmapPool.TAG, "Put bitmap in pool=" + this.f36279b.b(bitmap));
                }
                d();
                c();
                return;
            }
            if (Log.isLoggable(LruBitmapPool.TAG, 2)) {
                Log.v(LruBitmapPool.TAG, "Reject bitmap from pool, bitmap: " + this.f36279b.b(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f36280c.contains(bitmap.getConfig()));
            }
            bitmap.recycle();
        } catch (Throwable th) {
            throw th;
        }
    }

    public long b() {
        return this.f36283f;
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.e
    @NonNull
    public Bitmap b(int i2, int i3, Bitmap.Config config) {
        Bitmap d2 = d(i2, i3, config);
        return d2 == null ? c(i2, i3, config) : d2;
    }
}
