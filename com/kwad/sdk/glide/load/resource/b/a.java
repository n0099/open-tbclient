package com.kwad.sdk.glide.load.resource.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f35922a = true;

    public static Drawable a(Context context, @DrawableRes int i, @Nullable Resources.Theme theme) {
        return a(context, context, i, theme);
    }

    public static Drawable a(Context context, Context context2, @DrawableRes int i) {
        return a(context, context2, i, null);
    }

    public static Drawable a(Context context, Context context2, @DrawableRes int i, @Nullable Resources.Theme theme) {
        try {
            return context2.getResources().getDrawable(i);
        } catch (Resources.NotFoundException unused) {
            return context2.getResources().getDrawable(i);
        } catch (IllegalStateException e2) {
            if (context.getPackageName().equals(context2.getPackageName())) {
                throw e2;
            }
            return ContextCompat.getDrawable(context2, i);
        } catch (NoClassDefFoundError unused2) {
            f35922a = false;
            return context2.getResources().getDrawable(i);
        }
    }
}
