package com.kwad.sdk.internal.api;

import android.text.TextUtils;
import com.kwad.sdk.api.KsImage;
/* loaded from: classes4.dex */
public class a implements KsImage {

    /* renamed from: a  reason: collision with root package name */
    private int f10400a;

    /* renamed from: b  reason: collision with root package name */
    private int f10401b;
    private String c;

    public a(int i, int i2, String str) {
        this.f10400a = i;
        this.f10401b = i2;
        this.c = str;
    }

    @Override // com.kwad.sdk.api.KsImage
    public int getHeight() {
        return this.f10401b;
    }

    @Override // com.kwad.sdk.api.KsImage
    public String getImageUrl() {
        return this.c;
    }

    @Override // com.kwad.sdk.api.KsImage
    public int getWidth() {
        return this.f10400a;
    }

    @Override // com.kwad.sdk.api.KsImage
    public boolean isValid() {
        return this.f10400a > 0 && this.f10401b > 0 && !TextUtils.isEmpty(this.c);
    }
}
