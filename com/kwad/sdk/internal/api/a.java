package com.kwad.sdk.internal.api;

import android.text.TextUtils;
import com.kwad.sdk.api.KsImage;
/* loaded from: classes7.dex */
public class a implements KsImage {

    /* renamed from: a  reason: collision with root package name */
    public int f36597a;

    /* renamed from: b  reason: collision with root package name */
    public int f36598b;

    /* renamed from: c  reason: collision with root package name */
    public String f36599c;

    public a(int i2, int i3, String str) {
        this.f36597a = i2;
        this.f36598b = i3;
        this.f36599c = str;
    }

    @Override // com.kwad.sdk.api.KsImage
    public int getHeight() {
        return this.f36598b;
    }

    @Override // com.kwad.sdk.api.KsImage
    public String getImageUrl() {
        return this.f36599c;
    }

    @Override // com.kwad.sdk.api.KsImage
    public int getWidth() {
        return this.f36597a;
    }

    @Override // com.kwad.sdk.api.KsImage
    public boolean isValid() {
        return this.f36597a > 0 && this.f36598b > 0 && !TextUtils.isEmpty(this.f36599c);
    }
}
