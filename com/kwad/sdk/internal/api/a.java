package com.kwad.sdk.internal.api;

import android.text.TextUtils;
import com.kwad.sdk.api.KsImage;
/* loaded from: classes6.dex */
public class a implements KsImage {

    /* renamed from: a  reason: collision with root package name */
    public int f35895a;

    /* renamed from: b  reason: collision with root package name */
    public int f35896b;

    /* renamed from: c  reason: collision with root package name */
    public String f35897c;

    public a(int i, int i2, String str) {
        this.f35895a = i;
        this.f35896b = i2;
        this.f35897c = str;
    }

    @Override // com.kwad.sdk.api.KsImage
    public int getHeight() {
        return this.f35896b;
    }

    @Override // com.kwad.sdk.api.KsImage
    public String getImageUrl() {
        return this.f35897c;
    }

    @Override // com.kwad.sdk.api.KsImage
    public int getWidth() {
        return this.f35895a;
    }

    @Override // com.kwad.sdk.api.KsImage
    public boolean isValid() {
        return this.f35895a > 0 && this.f35896b > 0 && !TextUtils.isEmpty(this.f35897c);
    }
}
