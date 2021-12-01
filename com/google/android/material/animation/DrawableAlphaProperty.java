package com.google.android.material.animation;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.WeakHashMap;
/* loaded from: classes2.dex */
public class DrawableAlphaProperty extends Property<Drawable, Integer> {
    public static /* synthetic */ Interceptable $ic;
    public static final Property<Drawable, Integer> DRAWABLE_ALPHA_COMPAT;
    public transient /* synthetic */ FieldHolder $fh;
    public final WeakHashMap<Drawable, Integer> alphaCache;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1962574237, "Lcom/google/android/material/animation/DrawableAlphaProperty;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1962574237, "Lcom/google/android/material/animation/DrawableAlphaProperty;");
                return;
            }
        }
        DRAWABLE_ALPHA_COMPAT = new DrawableAlphaProperty();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawableAlphaProperty() {
        super(Integer.class, "drawableAlphaCompat");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super((Class) objArr[0], (String) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.alphaCache = new WeakHashMap<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.Property
    @Nullable
    public Integer get(@NonNull Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, drawable)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return Integer.valueOf(drawable.getAlpha());
            }
            if (this.alphaCache.containsKey(drawable)) {
                return this.alphaCache.get(drawable);
            }
            return 255;
        }
        return (Integer) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.Property
    public void set(@NonNull Drawable drawable, @NonNull Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, drawable, num) == null) {
            if (Build.VERSION.SDK_INT < 19) {
                this.alphaCache.put(drawable, num);
            }
            drawable.setAlpha(num.intValue());
        }
    }
}
