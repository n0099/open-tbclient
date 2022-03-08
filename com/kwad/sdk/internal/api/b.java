package com.kwad.sdk.internal.api;

import android.text.TextUtils;
import com.kwad.sdk.api.KsImage;
/* loaded from: classes8.dex */
public class b implements KsImage {
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f55562b;

    /* renamed from: c  reason: collision with root package name */
    public String f55563c;

    public b(int i2, int i3, String str) {
        this.a = i2;
        this.f55562b = i3;
        this.f55563c = str;
    }

    @Override // com.kwad.sdk.api.KsImage
    public int getHeight() {
        return this.f55562b;
    }

    @Override // com.kwad.sdk.api.KsImage
    public String getImageUrl() {
        return this.f55563c;
    }

    @Override // com.kwad.sdk.api.KsImage
    public int getWidth() {
        return this.a;
    }

    @Override // com.kwad.sdk.api.KsImage
    public boolean isValid() {
        return this.a > 0 && this.f55562b > 0 && !TextUtils.isEmpty(this.f55563c);
    }
}
