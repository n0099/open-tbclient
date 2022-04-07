package com.repackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class f81 implements h81 {
    public static /* synthetic */ Interceptable $ic;
    public static f81 b;
    public static j81 c;
    public static n81 d;
    public static m81 e;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public f81(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context.getApplicationContext();
        d = new n81();
        e = new m81(context);
        c = new j81();
    }

    public static m81 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (e == null) {
                e = new m81(context);
            }
            return e;
        }
        return (m81) invokeL.objValue;
    }

    public static n81 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                d = new n81();
            }
            return d;
        }
        return (n81) invokeV.objValue;
    }

    public static f81 d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (b == null) {
                synchronized (f81.class) {
                    if (b == null) {
                        b = new f81(context);
                    }
                }
            }
            return b;
        }
        return (f81) invokeL.objValue;
    }

    @Override // com.repackage.h81
    public void a(ImageView imageView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, imageView, str) == null) {
            e(imageView, str, 0, 0);
        }
    }

    public void e(ImageView imageView, String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageView, str, i, i2) == null) {
            imageView.setTag(str);
            Bitmap c2 = d.c(str);
            if (c2 != null) {
                imageView.setImageBitmap(c2);
            } else {
                d91.a(new l81(this.a, c, str, imageView, i, i2));
            }
        }
    }
}
