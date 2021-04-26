package com.kwad.sdk.internal.api;

import android.text.TextUtils;
import com.kwad.sdk.api.KsImage;
/* loaded from: classes6.dex */
public class a implements KsImage {

    /* renamed from: a  reason: collision with root package name */
    public int f34150a;

    /* renamed from: b  reason: collision with root package name */
    public int f34151b;

    /* renamed from: c  reason: collision with root package name */
    public String f34152c;

    public a(int i2, int i3, String str) {
        this.f34150a = i2;
        this.f34151b = i3;
        this.f34152c = str;
    }

    @Override // com.kwad.sdk.api.KsImage
    public int getHeight() {
        return this.f34151b;
    }

    @Override // com.kwad.sdk.api.KsImage
    public String getImageUrl() {
        return this.f34152c;
    }

    @Override // com.kwad.sdk.api.KsImage
    public int getWidth() {
        return this.f34150a;
    }

    @Override // com.kwad.sdk.api.KsImage
    public boolean isValid() {
        return this.f34150a > 0 && this.f34151b > 0 && !TextUtils.isEmpty(this.f34152c);
    }
}
