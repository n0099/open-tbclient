package com.kwad.components.core.webview.kwai;

import android.graphics.Bitmap;
import android.webkit.WebChromeClient;
import androidx.annotation.Nullable;
/* loaded from: classes10.dex */
public class b extends WebChromeClient {
    @Override // android.webkit.WebChromeClient
    @Nullable
    public Bitmap getDefaultVideoPoster() {
        Bitmap defaultVideoPoster = super.getDefaultVideoPoster();
        if (defaultVideoPoster == null) {
            Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565);
            createBitmap.eraseColor(0);
            return createBitmap;
        }
        return defaultVideoPoster;
    }
}
