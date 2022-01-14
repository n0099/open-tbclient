package com.kwad.sdk.internal.api;

import android.text.TextUtils;
import com.kwad.sdk.api.KsImage;
/* loaded from: classes3.dex */
public class b implements KsImage {
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f57000b;

    /* renamed from: c  reason: collision with root package name */
    public String f57001c;

    public b(int i2, int i3, String str) {
        this.a = i2;
        this.f57000b = i3;
        this.f57001c = str;
    }

    @Override // com.kwad.sdk.api.KsImage
    public int getHeight() {
        return this.f57000b;
    }

    @Override // com.kwad.sdk.api.KsImage
    public String getImageUrl() {
        return this.f57001c;
    }

    @Override // com.kwad.sdk.api.KsImage
    public int getWidth() {
        return this.a;
    }

    @Override // com.kwad.sdk.api.KsImage
    public boolean isValid() {
        return this.a > 0 && this.f57000b > 0 && !TextUtils.isEmpty(this.f57001c);
    }
}
