package com.kwad.sdk.contentalliance.refreshview;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ao;
/* loaded from: classes3.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final float f8835a;

    public a(@NonNull Context context) {
        this.f8835a = ao.b(context);
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.b
    public float a(float f, float f2) {
        return this.f8835a - (((this.f8835a * this.f8835a) * 2.0f) / ((this.f8835a * 2.0f) + f));
    }
}
