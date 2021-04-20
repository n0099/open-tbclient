package com.kwad.sdk.internal.api;

import android.text.TextUtils;
import com.kwad.sdk.api.KsImage;
/* loaded from: classes6.dex */
public class a implements KsImage {

    /* renamed from: a  reason: collision with root package name */
    public int f36184a;

    /* renamed from: b  reason: collision with root package name */
    public int f36185b;

    /* renamed from: c  reason: collision with root package name */
    public String f36186c;

    public a(int i, int i2, String str) {
        this.f36184a = i;
        this.f36185b = i2;
        this.f36186c = str;
    }

    @Override // com.kwad.sdk.api.KsImage
    public int getHeight() {
        return this.f36185b;
    }

    @Override // com.kwad.sdk.api.KsImage
    public String getImageUrl() {
        return this.f36186c;
    }

    @Override // com.kwad.sdk.api.KsImage
    public int getWidth() {
        return this.f36184a;
    }

    @Override // com.kwad.sdk.api.KsImage
    public boolean isValid() {
        return this.f36184a > 0 && this.f36185b > 0 && !TextUtils.isEmpty(this.f36186c);
    }
}
