package d.a.d0.k.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class a implements c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static a f42069b;

    /* renamed from: c  reason: collision with root package name */
    public static e f42070c;

    /* renamed from: d  reason: collision with root package name */
    public static d.a.d0.k.e.b f42071d;

    /* renamed from: e  reason: collision with root package name */
    public static d.a.d0.k.e.a f42072e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f42073a;

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42073a = context.getApplicationContext();
        f42071d = new d.a.d0.k.e.b();
        f42072e = new d.a.d0.k.e.a(context);
        f42070c = new e();
    }

    public static d.a.d0.k.e.b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f42071d == null) {
                f42071d = new d.a.d0.k.e.b();
            }
            return f42071d;
        }
        return (d.a.d0.k.e.b) invokeV.objValue;
    }

    public static d.a.d0.k.e.a c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f42072e == null) {
                f42072e = new d.a.d0.k.e.a(context);
            }
            return f42072e;
        }
        return (d.a.d0.k.e.a) invokeL.objValue;
    }

    public static a e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f42069b == null) {
                synchronized (a.class) {
                    if (f42069b == null) {
                        f42069b = new a(context);
                    }
                }
            }
            return f42069b;
        }
        return (a) invokeL.objValue;
    }

    @Override // d.a.d0.k.d.c
    public void a(ImageView imageView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, imageView, str) == null) {
            d(imageView, str, 0, 0);
        }
    }

    public void d(ImageView imageView, String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageView, str, i2, i3) == null) {
            imageView.setTag(str);
            Bitmap b2 = f42071d.b(str);
            if (b2 != null) {
                imageView.setImageBitmap(b2);
            } else {
                d.a.d0.m.a.a(new g(this.f42073a, f42070c, str, imageView, i2, i3));
            }
        }
    }
}
