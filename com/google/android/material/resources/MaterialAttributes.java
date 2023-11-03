package com.google.android.material.resources;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.baidu.tieba.R;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes9.dex */
public class MaterialAttributes {
    @Nullable
    public static TypedValue resolve(@NonNull Context context, @AttrRes int i) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static int resolveOrThrow(@NonNull View view2, @AttrRes int i) {
        return resolveOrThrow(view2.getContext(), i, view2.getClass().getCanonicalName());
    }

    public static boolean resolveBoolean(@NonNull Context context, @AttrRes int i, boolean z) {
        TypedValue resolve = resolve(context, i);
        if (resolve != null && resolve.type == 18) {
            if (resolve.data != 0) {
                return true;
            }
            return false;
        }
        return z;
    }

    public static boolean resolveBooleanOrThrow(@NonNull Context context, @AttrRes int i, @NonNull String str) {
        if (resolveOrThrow(context, i, str) != 0) {
            return true;
        }
        return false;
    }

    @Px
    public static int resolveDimension(@NonNull Context context, @AttrRes int i, @DimenRes int i2) {
        float dimension;
        TypedValue resolve = resolve(context, i);
        if (resolve != null && resolve.type == 5) {
            dimension = resolve.getDimension(context.getResources().getDisplayMetrics());
        } else {
            dimension = context.getResources().getDimension(i2);
        }
        return (int) dimension;
    }

    public static int resolveOrThrow(@NonNull Context context, @AttrRes int i, @NonNull String str) {
        TypedValue resolve = resolve(context, i);
        if (resolve != null) {
            return resolve.data;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i)));
    }

    @Px
    public static int resolveMinimumAccessibleTouchTarget(@NonNull Context context) {
        return resolveDimension(context, R.attr.obfuscated_res_0x7f040509, R.dimen.obfuscated_res_0x7f070617);
    }
}
