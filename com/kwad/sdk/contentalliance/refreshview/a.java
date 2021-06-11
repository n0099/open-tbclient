package com.kwad.sdk.contentalliance.refreshview;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ao;
/* loaded from: classes6.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final float f33581a;

    public a(@NonNull Context context) {
        this.f33581a = ao.b(context);
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.b
    public float a(float f2, float f3) {
        float f4 = this.f33581a;
        return f4 - (((f4 * f4) * 2.0f) / (f2 + (2.0f * f4)));
    }
}
