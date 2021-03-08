package com.kwad.sdk.contentalliance.refreshview;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ao;
/* loaded from: classes3.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final float f5886a;

    public a(@NonNull Context context) {
        this.f5886a = ao.b(context);
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.b
    public float a(float f, float f2) {
        return this.f5886a - (((this.f5886a * this.f5886a) * 2.0f) / ((this.f5886a * 2.0f) + f));
    }
}
