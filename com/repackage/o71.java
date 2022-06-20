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
public class o71 implements q71 {
    public static /* synthetic */ Interceptable $ic;
    public static o71 b;
    public static s71 c;
    public static w71 d;
    public static v71 e;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public o71(Context context) {
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
        d = new w71();
        e = new v71(context);
        c = new s71();
    }

    public static v71 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (e == null) {
                e = new v71(context);
            }
            return e;
        }
        return (v71) invokeL.objValue;
    }

    public static w71 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                d = new w71();
            }
            return d;
        }
        return (w71) invokeV.objValue;
    }

    public static o71 d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (b == null) {
                synchronized (o71.class) {
                    if (b == null) {
                        b = new o71(context);
                    }
                }
            }
            return b;
        }
        return (o71) invokeL.objValue;
    }

    @Override // com.repackage.q71
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
                m81.a(new u71(this.a, c, str, imageView, i, i2));
            }
        }
    }
}
