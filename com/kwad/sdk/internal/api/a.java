package com.kwad.sdk.internal.api;

import android.text.TextUtils;
import com.kwad.sdk.api.KsImage;
/* loaded from: classes6.dex */
public class a implements KsImage {

    /* renamed from: a  reason: collision with root package name */
    public int f33324a;

    /* renamed from: b  reason: collision with root package name */
    public int f33325b;

    /* renamed from: c  reason: collision with root package name */
    public String f33326c;

    public a(int i2, int i3, String str) {
        this.f33324a = i2;
        this.f33325b = i3;
        this.f33326c = str;
    }

    @Override // com.kwad.sdk.api.KsImage
    public int getHeight() {
        return this.f33325b;
    }

    @Override // com.kwad.sdk.api.KsImage
    public String getImageUrl() {
        return this.f33326c;
    }

    @Override // com.kwad.sdk.api.KsImage
    public int getWidth() {
        return this.f33324a;
    }

    @Override // com.kwad.sdk.api.KsImage
    public boolean isValid() {
        return this.f33324a > 0 && this.f33325b > 0 && !TextUtils.isEmpty(this.f33326c);
    }
}
