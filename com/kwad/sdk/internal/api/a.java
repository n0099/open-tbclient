package com.kwad.sdk.internal.api;

import android.text.TextUtils;
import com.kwad.sdk.api.KsImage;
/* loaded from: classes6.dex */
public class a implements KsImage {

    /* renamed from: a  reason: collision with root package name */
    public int f33395a;

    /* renamed from: b  reason: collision with root package name */
    public int f33396b;

    /* renamed from: c  reason: collision with root package name */
    public String f33397c;

    public a(int i2, int i3, String str) {
        this.f33395a = i2;
        this.f33396b = i3;
        this.f33397c = str;
    }

    @Override // com.kwad.sdk.api.KsImage
    public int getHeight() {
        return this.f33396b;
    }

    @Override // com.kwad.sdk.api.KsImage
    public String getImageUrl() {
        return this.f33397c;
    }

    @Override // com.kwad.sdk.api.KsImage
    public int getWidth() {
        return this.f33395a;
    }

    @Override // com.kwad.sdk.api.KsImage
    public boolean isValid() {
        return this.f33395a > 0 && this.f33396b > 0 && !TextUtils.isEmpty(this.f33397c);
    }
}
