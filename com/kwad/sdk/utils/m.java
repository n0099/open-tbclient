package com.kwad.sdk.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.engine.GlideException;
/* loaded from: classes4.dex */
public class m {
    public static void a(Context context, String str) {
        com.kwad.sdk.core.d.a.a("GlideUtils", "preloadImage imageUrl=" + str);
        try {
            com.kwad.sdk.glide.c.b(context).a(str).b(new com.kwad.sdk.glide.request.e<Drawable>() { // from class: com.kwad.sdk.utils.m.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.glide.request.e
                public boolean a(Drawable drawable, Object obj, com.kwad.sdk.glide.request.a.j<Drawable> jVar, DataSource dataSource, boolean z) {
                    return false;
                }

                @Override // com.kwad.sdk.glide.request.e
                public boolean a(@Nullable GlideException glideException, Object obj, com.kwad.sdk.glide.request.a.j<Drawable> jVar, boolean z) {
                    return false;
                }
            }).b();
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.b(e);
        }
    }
}
