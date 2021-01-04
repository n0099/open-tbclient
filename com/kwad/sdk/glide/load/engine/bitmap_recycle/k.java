package com.kwad.sdk.glide.load.engine.bitmap_recycle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public class k implements e {

    /* renamed from: a  reason: collision with root package name */
    private static final Bitmap.Config f10499a = Bitmap.Config.ARGB_8888;

    /* renamed from: b  reason: collision with root package name */
    private final l f10500b;
    private final Set<Bitmap.Config> c;
    private final long d;
    private final a e;
    private long f;
    private long g;
    private int h;
    private int i;
    private int j;
    private int k;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    /* loaded from: classes5.dex */
    private static final class b implements a {
        b() {
        }

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

    k(long j, l lVar, Set<Bitmap.Config> set) {
        this.d = j;
        this.f = j;
        this.f10500b = lVar;
        this.c = set;
        this.e = new b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0025, code lost:
        r7.g = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
        if (android.util.Log.isLoggable("LruBitmapPool", 5) == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
        android.util.Log.w("LruBitmapPool", "Size mismatch, resetting");
        e();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized void a(long j) {
        while (true) {
            if (this.g <= j) {
                break;
            }
            Bitmap a2 = this.f10500b.a();
            if (a2 == null) {
                break;
            }
            this.e.b(a2);
            this.g -= this.f10500b.c(a2);
            this.k++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Evicting bitmap=" + this.f10500b.b(a2));
            }
            d();
            a2.recycle();
        }
    }

    @TargetApi(26)
    private static void a(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    private static void b(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        c(bitmap);
    }

    @NonNull
    private static Bitmap c(int i, int i2, @Nullable Bitmap.Config config) {
        if (config == null) {
            config = f10499a;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    private void c() {
        a(this.f);
    }

    @TargetApi(19)
    private static void c(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    @Nullable
    private synchronized Bitmap d(int i, int i2, @Nullable Bitmap.Config config) {
        Bitmap a2;
        a(config);
        a2 = this.f10500b.a(i, i2, config != null ? config : f10499a);
        if (a2 == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Missing bitmap=" + this.f10500b.b(i, i2, config));
            }
            this.i++;
        } else {
            this.h++;
            this.g -= this.f10500b.c(a2);
            this.e.b(a2);
            b(a2);
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Log.v("LruBitmapPool", "Get bitmap=" + this.f10500b.b(i, i2, config));
        }
        d();
        return a2;
    }

    private void d() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            e();
        }
    }

    private void e() {
        Log.v("LruBitmapPool", "Hits=" + this.h + ", misses=" + this.i + ", puts=" + this.j + ", evictions=" + this.k + ", currentSize=" + this.g + ", maxSize=" + this.f + "\nStrategy=" + this.f10500b);
    }

    private static l f() {
        return Build.VERSION.SDK_INT >= 19 ? new n() : new c();
    }

    @TargetApi(26)
    private static Set<Bitmap.Config> g() {
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
        Bitmap d = d(i, i2, config);
        if (d != null) {
            d.eraseColor(0);
            return d;
        }
        return c(i, i2, config);
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.e
    public void a() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        a(0L);
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.e
    @SuppressLint({"InlinedApi"})
    public void a(int i) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i);
        }
        if (i >= 40) {
            a();
        } else if (i >= 20 || i == 15) {
            a(b() / 2);
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.e
    public synchronized void a(Bitmap bitmap) {
        if (bitmap == null) {
            throw new NullPointerException("Bitmap must not be null");
        }
        if (bitmap.isRecycled()) {
            throw new IllegalStateException("Cannot pool recycled bitmap");
        }
        if (bitmap.isMutable() && this.f10500b.c(bitmap) <= this.f && this.c.contains(bitmap.getConfig())) {
            int c = this.f10500b.c(bitmap);
            this.f10500b.a(bitmap);
            this.e.a(bitmap);
            this.j++;
            this.g = c + this.g;
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Put bitmap in pool=" + this.f10500b.b(bitmap));
            }
            d();
            c();
        } else {
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.f10500b.b(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.c.contains(bitmap.getConfig()));
            }
            bitmap.recycle();
        }
    }

    public long b() {
        return this.f;
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.e
    @NonNull
    public Bitmap b(int i, int i2, Bitmap.Config config) {
        Bitmap d = d(i, i2, config);
        return d == null ? c(i, i2, config) : d;
    }
}
