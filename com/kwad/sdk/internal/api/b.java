package com.kwad.sdk.internal.api;

import android.text.TextUtils;
import com.kwad.sdk.api.KsImage;
/* loaded from: classes7.dex */
public class b implements KsImage {
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f40587b;

    /* renamed from: c  reason: collision with root package name */
    public String f40588c;

    public b(int i, int i2, String str) {
        this.a = i;
        this.f40587b = i2;
        this.f40588c = str;
    }

    @Override // com.kwad.sdk.api.KsImage
    public int getHeight() {
        return this.f40587b;
    }

    @Override // com.kwad.sdk.api.KsImage
    public String getImageUrl() {
        return this.f40588c;
    }

    @Override // com.kwad.sdk.api.KsImage
    public int getWidth() {
        return this.a;
    }

    @Override // com.kwad.sdk.api.KsImage
    public boolean isValid() {
        return this.a > 0 && this.f40587b > 0 && !TextUtils.isEmpty(this.f40588c);
    }
}
