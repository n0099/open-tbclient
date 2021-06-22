package com.kwad.sdk.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.kwad.sdk.glide.load.DecodeFormat;
import java.io.File;
/* loaded from: classes7.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static final File f36472a = new File("/proc/self/fd");

    /* renamed from: d  reason: collision with root package name */
    public static volatile p f36473d;

    /* renamed from: b  reason: collision with root package name */
    public volatile int f36474b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f36475c = true;

    public static p a() {
        if (f36473d == null) {
            synchronized (p.class) {
                if (f36473d == null) {
                    f36473d = new p();
                }
            }
        }
        return f36473d;
    }

    private synchronized boolean b() {
        boolean z = true;
        int i2 = this.f36474b + 1;
        this.f36474b = i2;
        if (i2 >= 50) {
            this.f36474b = 0;
            int length = f36472a.list().length;
            if (length >= 700) {
                z = false;
            }
            this.f36475c = z;
            if (!this.f36475c && Log.isLoggable(Downsampler.TAG, 5)) {
                Log.w(Downsampler.TAG, "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit 700");
            }
        }
        return this.f36475c;
    }

    @TargetApi(26)
    public boolean a(int i2, int i3, BitmapFactory.Options options, DecodeFormat decodeFormat, boolean z, boolean z2) {
        if (!z || Build.VERSION.SDK_INT < 26 || z2) {
            return false;
        }
        boolean z3 = i2 >= 128 && i3 >= 128 && b();
        if (z3) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return z3;
    }
}
