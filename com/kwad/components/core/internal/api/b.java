package com.kwad.components.core.internal.api;

import android.text.TextUtils;
import com.kwad.sdk.api.KsImage;
/* loaded from: classes10.dex */
public class b implements KsImage {
    public String EA;
    public int height;
    public int width;

    public b(int i, int i2, String str) {
        this.width = i;
        this.height = i2;
        this.EA = str;
    }

    @Override // com.kwad.sdk.api.KsImage
    public int getHeight() {
        return this.height;
    }

    @Override // com.kwad.sdk.api.KsImage
    public String getImageUrl() {
        return this.EA;
    }

    @Override // com.kwad.sdk.api.KsImage
    public int getWidth() {
        return this.width;
    }

    @Override // com.kwad.sdk.api.KsImage
    public boolean isValid() {
        return this.width > 0 && this.height > 0 && !TextUtils.isEmpty(this.EA);
    }
}
