package com.google.android.material.animation;

import android.util.Property;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ChildrenAlphaProperty extends Property<ViewGroup, Float> {
    public static /* synthetic */ Interceptable $ic;
    public static final Property<ViewGroup, Float> CHILDREN_ALPHA;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(759488830, "Lcom/google/android/material/animation/ChildrenAlphaProperty;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(759488830, "Lcom/google/android/material/animation/ChildrenAlphaProperty;");
                return;
            }
        }
        CHILDREN_ALPHA = new ChildrenAlphaProperty("childrenAlpha");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChildrenAlphaProperty(String str) {
        super(Float.class, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Class) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.Property
    @NonNull
    public Float get(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            Float f = (Float) viewGroup.getTag(R.id.obfuscated_res_0x7f0914b4);
            return f != null ? f : Float.valueOf(1.0f);
        }
        return (Float) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.Property
    public void set(@NonNull ViewGroup viewGroup, @NonNull Float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, f) == null) {
            float floatValue = f.floatValue();
            viewGroup.setTag(R.id.obfuscated_res_0x7f0914b4, Float.valueOf(floatValue));
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                viewGroup.getChildAt(i).setAlpha(floatValue);
            }
        }
    }
}
