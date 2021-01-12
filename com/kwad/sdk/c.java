package com.kwad.sdk;

import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.engine.GlideException;
import com.kwad.sdk.glide.request.a.j;
/* loaded from: classes4.dex */
public class c implements com.kwad.sdk.glide.request.e<Drawable> {

    /* renamed from: a  reason: collision with root package name */
    private String f8244a;

    /* renamed from: b  reason: collision with root package name */
    private AdTemplate f8245b;

    public c(String str, AdTemplate adTemplate) {
        this.f8244a = str;
        this.f8245b = adTemplate;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.e
    public boolean a(Drawable drawable, Object obj, j<Drawable> jVar, DataSource dataSource, boolean z) {
        return false;
    }

    @Override // com.kwad.sdk.glide.request.e
    public boolean a(@Nullable GlideException glideException, Object obj, j<Drawable> jVar, boolean z) {
        StringBuilder sb = new StringBuilder("KS_Glide:");
        if (glideException != null) {
            sb.append(glideException.getMessage());
        }
        com.kwad.sdk.core.report.e.c(this.f8245b, this.f8244a, sb.toString());
        return false;
    }
}
