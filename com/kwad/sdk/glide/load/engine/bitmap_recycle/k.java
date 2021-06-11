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
    public static final Bitmap.Config f36180a = Bitmap.Config.ARGB_8888;

    /* renamed from: b  reason: collision with root package name */
    public final l f36181b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<Bitmap.Config> f36182c;

    /* renamed from: d  reason: collision with root package name */
    public final long f36183d;

    /* renamed from: e  reason: collision with root package name */
    public final a f36184e;

    /* renamed from: f  reason: collision with root package name */
    public long f36185f;

    /* renamed from: g  reason: collision with root package name */
    public long f36186g;

    /* renamed from: h  reason: collision with root package name */
    public int f36187h;

    /* renamed from: i  reason: collision with root package name */
    public int f36188i;
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
        this.f36183d = j;
        this.f36185f = j;
        this.f36181b = lVar;
        this.f36182c = set;
        this.f36184e = new b();
    }

    private synchronized void a(long j) {
        while (this.f36186g > j) {
            Bitmap a2 = this.f36181b.a();
            if (a2 == null) {
                if (Log.isLoggable(LruBitmapPool.TAG, 5)) {
                    Log.w(LruBitmapPool.TAG, "Size mismatch, resetting");
                    e();
                }
                this.f36186g = 0L;
                return;
            }
            this.f36184e.b(a2);
            this.f36186g -= this.f36181b.c(a2);
            this.k++;
            if (Log.isLoggable(LruBitmapPool.TAG, 3)) {
                Log.d(LruBitmapPool.TAG, "Evicting bitmap=" + this.f36181b.b(a2));
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
            config = f36180a;
        }
        return Bitmap.createBitmap(i2, i3, config);
    }

    private void c() {
        a(this.f36185f);
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
        a2 = this.f36181b.a(i2, i3, config != null ? config : f36180a);
        if (a2 == null) {
            if (Log.isLoggable(LruBitmapPool.TAG, 3)) {
                Log.d(LruBitmapPool.TAG, "Missing bitmap=" + this.f36181b.b(i2, i3, config));
            }
            this.f36188i++;
        } else {
            this.f36187h++;
            this.f36186g -= this.f36181b.c(a2);
            this.f36184e.b(a2);
            b(a2);
        }
        if (Log.isLoggable(LruBitmapPool.TAG, 2)) {
            Log.v(LruBitmapPool.TAG, "Get bitmap=" + this.f36181b.b(i2, i3, config));
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
        Log.v(LruBitmapPool.TAG, "Hits=" + this.f36187h + ", misses=" + this.f36188i + ", puts=" + this.j + ", evictions=" + this.k + ", currentSize=" + this.f36186g + ", maxSize=" + this.f36185f + "\nStrategy=" + this.f36181b);
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
            if (bitmap.isMutable() && this.f36181b.c(bitmap) <= this.f36185f && this.f36182c.contains(bitmap.getConfig())) {
                int c2 = this.f36181b.c(bitmap);
                this.f36181b.a(bitmap);
                this.f36184e.a(bitmap);
                this.j++;
                this.f36186g += c2;
                if (Log.isLoggable(LruBitmapPool.TAG, 2)) {
                    Log.v(LruBitmapPool.TAG, "Put bitmap in pool=" + this.f36181b.b(bitmap));
                }
                d();
                c();
                return;
            }
            if (Log.isLoggable(LruBitmapPool.TAG, 2)) {
                Log.v(LruBitmapPool.TAG, "Reject bitmap from pool, bitmap: " + this.f36181b.b(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f36182c.contains(bitmap.getConfig()));
            }
            bitmap.recycle();
        } catch (Throwable th) {
            throw th;
        }
    }

    public long b() {
        return this.f36185f;
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.e
    @NonNull
    public Bitmap b(int i2, int i3, Bitmap.Config config) {
        Bitmap d2 = d(i2, i3, config);
        return d2 == null ? c(i2, i3, config) : d2;
    }
}
