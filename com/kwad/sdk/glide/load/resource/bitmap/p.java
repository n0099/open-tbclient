package com.kwad.sdk.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.kwad.sdk.glide.load.DecodeFormat;
import java.io.File;
/* loaded from: classes6.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static final File f35969a = new File("/proc/self/fd");

    /* renamed from: d  reason: collision with root package name */
    public static volatile p f35970d;

    /* renamed from: b  reason: collision with root package name */
    public volatile int f35971b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f35972c = true;

    public static p a() {
        if (f35970d == null) {
            synchronized (p.class) {
                if (f35970d == null) {
                    f35970d = new p();
                }
            }
        }
        return f35970d;
    }

    private synchronized boolean b() {
        boolean z = true;
        int i = this.f35971b + 1;
        this.f35971b = i;
        if (i >= 50) {
            this.f35971b = 0;
            int length = f35969a.list().length;
            if (length >= 700) {
                z = false;
            }
            this.f35972c = z;
            if (!this.f35972c && Log.isLoggable(Downsampler.TAG, 5)) {
                Log.w(Downsampler.TAG, "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit 700");
            }
        }
        return this.f35972c;
    }

    @TargetApi(26)
    public boolean a(int i, int i2, BitmapFactory.Options options, DecodeFormat decodeFormat, boolean z, boolean z2) {
        if (!z || Build.VERSION.SDK_INT < 26 || z2) {
            return false;
        }
        boolean z3 = i >= 128 && i2 >= 128 && b();
        if (z3) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return z3;
    }
}
