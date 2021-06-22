package com.kwad.sdk.internal.api;

import android.text.TextUtils;
import com.kwad.sdk.api.KsImage;
/* loaded from: classes7.dex */
public class a implements KsImage {

    /* renamed from: a  reason: collision with root package name */
    public int f36695a;

    /* renamed from: b  reason: collision with root package name */
    public int f36696b;

    /* renamed from: c  reason: collision with root package name */
    public String f36697c;

    public a(int i2, int i3, String str) {
        this.f36695a = i2;
        this.f36696b = i3;
        this.f36697c = str;
    }

    @Override // com.kwad.sdk.api.KsImage
    public int getHeight() {
        return this.f36696b;
    }

    @Override // com.kwad.sdk.api.KsImage
    public String getImageUrl() {
        return this.f36697c;
    }

    @Override // com.kwad.sdk.api.KsImage
    public int getWidth() {
        return this.f36695a;
    }

    @Override // com.kwad.sdk.api.KsImage
    public boolean isValid() {
        return this.f36695a > 0 && this.f36696b > 0 && !TextUtils.isEmpty(this.f36697c);
    }
}
