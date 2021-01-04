package com.kwad.sdk.internal.api;

import android.text.TextUtils;
import com.kwad.sdk.api.KsImage;
/* loaded from: classes5.dex */
public class a implements KsImage {

    /* renamed from: a  reason: collision with root package name */
    private int f10699a;

    /* renamed from: b  reason: collision with root package name */
    private int f10700b;
    private String c;

    public a(int i, int i2, String str) {
        this.f10699a = i;
        this.f10700b = i2;
        this.c = str;
    }

    @Override // com.kwad.sdk.api.KsImage
    public int getHeight() {
        return this.f10700b;
    }

    @Override // com.kwad.sdk.api.KsImage
    public String getImageUrl() {
        return this.c;
    }

    @Override // com.kwad.sdk.api.KsImage
    public int getWidth() {
        return this.f10699a;
    }

    @Override // com.kwad.sdk.api.KsImage
    public boolean isValid() {
        return this.f10699a > 0 && this.f10700b > 0 && !TextUtils.isEmpty(this.c);
    }
}
