package com.kwad.sdk.glide.load.resource.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f38187a = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1242089796, "Lcom/kwad/sdk/glide/load/resource/b/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1242089796, "Lcom/kwad/sdk/glide/load/resource/b/a;");
        }
    }

    public static Drawable a(Context context, @DrawableRes int i2, @Nullable Resources.Theme theme) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(65537, null, context, i2, theme)) == null) ? a(context, context, i2, theme) : (Drawable) invokeLIL.objValue;
    }

    public static Drawable a(Context context, Context context2, @DrawableRes int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, context, context2, i2)) == null) ? a(context, context2, i2, null) : (Drawable) invokeLLI.objValue;
    }

    public static Drawable a(Context context, Context context2, @DrawableRes int i2, @Nullable Resources.Theme theme) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65539, null, context, context2, i2, theme)) == null) {
            try {
                return context2.getResources().getDrawable(i2);
            } catch (Resources.NotFoundException unused) {
                return context2.getResources().getDrawable(i2);
            } catch (IllegalStateException e2) {
                if (context.getPackageName().equals(context2.getPackageName())) {
                    throw e2;
                }
                return ContextCompat.getDrawable(context2, i2);
            } catch (NoClassDefFoundError unused2) {
                f38187a = false;
                return context2.getResources().getDrawable(i2);
            }
        }
        return (Drawable) invokeLLIL.objValue;
    }
}
