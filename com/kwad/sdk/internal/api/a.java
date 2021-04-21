package com.kwad.sdk.internal.api;

import android.text.TextUtils;
import com.kwad.sdk.api.KsImage;
/* loaded from: classes6.dex */
public class a implements KsImage {

    /* renamed from: a  reason: collision with root package name */
    public int f36279a;

    /* renamed from: b  reason: collision with root package name */
    public int f36280b;

    /* renamed from: c  reason: collision with root package name */
    public String f36281c;

    public a(int i, int i2, String str) {
        this.f36279a = i;
        this.f36280b = i2;
        this.f36281c = str;
    }

    @Override // com.kwad.sdk.api.KsImage
    public int getHeight() {
        return this.f36280b;
    }

    @Override // com.kwad.sdk.api.KsImage
    public String getImageUrl() {
        return this.f36281c;
    }

    @Override // com.kwad.sdk.api.KsImage
    public int getWidth() {
        return this.f36279a;
    }

    @Override // com.kwad.sdk.api.KsImage
    public boolean isValid() {
        return this.f36279a > 0 && this.f36280b > 0 && !TextUtils.isEmpty(this.f36281c);
    }
}
