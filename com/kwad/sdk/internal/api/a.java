package com.kwad.sdk.internal.api;

import android.text.TextUtils;
import com.kwad.sdk.api.KsImage;
/* loaded from: classes3.dex */
public class a implements KsImage {

    /* renamed from: a  reason: collision with root package name */
    private int f6859a;
    private int b;
    private String c;

    public a(int i, int i2, String str) {
        this.f6859a = i;
        this.b = i2;
        this.c = str;
    }

    @Override // com.kwad.sdk.api.KsImage
    public int getHeight() {
        return this.b;
    }

    @Override // com.kwad.sdk.api.KsImage
    public String getImageUrl() {
        return this.c;
    }

    @Override // com.kwad.sdk.api.KsImage
    public int getWidth() {
        return this.f6859a;
    }

    @Override // com.kwad.sdk.api.KsImage
    public boolean isValid() {
        return this.f6859a > 0 && this.b > 0 && !TextUtils.isEmpty(this.c);
    }
}
