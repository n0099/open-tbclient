package com.kwad.sdk.contentalliance.refreshview;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ao;
/* loaded from: classes5.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final float f9133a;

    public a(@NonNull Context context) {
        this.f9133a = ao.b(context);
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.b
    public float a(float f, float f2) {
        return this.f9133a - (((this.f9133a * this.f9133a) * 2.0f) / ((this.f9133a * 2.0f) + f));
    }
}
