package com.win.opensdk;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.win.opensdk.by;
/* loaded from: classes3.dex */
final class cc implements by.a {
    @Override // com.win.opensdk.by.a
    @NonNull
    public final Bitmap j(int i, int i2, Bitmap.Config config) {
        return Bitmap.createBitmap(i, i2, config);
    }

    @Override // com.win.opensdk.by.a
    public final byte[] Sg(int i) {
        return new byte[i];
    }

    @Override // com.win.opensdk.by.a
    public final int[] Sh(int i) {
        return new int[i];
    }
}
