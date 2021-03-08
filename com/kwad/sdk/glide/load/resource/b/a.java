package com.kwad.sdk.glide.load.resource.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f6778a = true;

    public static Drawable a(Context context, @DrawableRes int i, @Nullable Resources.Theme theme) {
        return a(context, context, i, theme);
    }

    public static Drawable a(Context context, Context context2, @DrawableRes int i) {
        return a(context, context2, i, null);
    }

    private static Drawable a(Context context, Context context2, @DrawableRes int i, @Nullable Resources.Theme theme) {
        try {
            return context2.getResources().getDrawable(i);
        } catch (Resources.NotFoundException e) {
            return context2.getResources().getDrawable(i);
        } catch (IllegalStateException e2) {
            if (context.getPackageName().equals(context2.getPackageName())) {
                throw e2;
            }
            return ContextCompat.getDrawable(context2, i);
        } catch (NoClassDefFoundError e3) {
            f6778a = false;
            return context2.getResources().getDrawable(i);
        }
    }
}
