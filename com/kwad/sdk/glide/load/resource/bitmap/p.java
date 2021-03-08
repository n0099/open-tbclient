package com.kwad.sdk.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import com.kwad.sdk.glide.load.DecodeFormat;
import java.io.File;
/* loaded from: classes3.dex */
final class p {

    /* renamed from: a  reason: collision with root package name */
    private static final File f6794a = new File("/proc/self/fd");
    private static volatile p d;
    private volatile int b;
    private volatile boolean c = true;

    private p() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static p a() {
        if (d == null) {
            synchronized (p.class) {
                if (d == null) {
                    d = new p();
                }
            }
        }
        return d;
    }

    private synchronized boolean b() {
        boolean z;
        synchronized (this) {
            int i = this.b + 1;
            this.b = i;
            if (i >= 50) {
                this.b = 0;
                int length = f6794a.list().length;
                this.c = length < 700;
                if (!this.c && Log.isLoggable("Downsampler", 5)) {
                    Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit 700");
                }
            }
            z = this.c;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(26)
    public boolean a(int i, int i2, BitmapFactory.Options options, DecodeFormat decodeFormat, boolean z, boolean z2) {
        if (!z || Build.VERSION.SDK_INT < 26 || z2) {
            return false;
        }
        boolean z3 = i >= 128 && i2 >= 128 && b();
        if (z3) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
            return z3;
        }
        return z3;
    }
}
