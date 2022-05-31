package com.repackage;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.core.ImageLoader;
import com.repackage.fu8;
import com.repackage.hu8;
import java.io.File;
import java.util.List;
import java.util.Vector;
/* loaded from: classes6.dex */
public class ju8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ju8 c;
    public transient /* synthetic */ FieldHolder $fh;
    public hu8 a;
    public List<ou8> b;

    /* loaded from: classes6.dex */
    public class a implements nu8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ju8 a;

        public a(ju8 ju8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ju8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ju8Var;
        }

        @Override // com.repackage.nu8
        public void a(fu8.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                fu8.a().c(bVar);
                if (u79.e(this.a.b)) {
                    return;
                }
                ju8 ju8Var = this.a;
                ju8Var.h((ou8) u79.c(ju8Var.b, 0));
                u79.g(this.a.b, 0);
            }
        }
    }

    public ju8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new Vector();
        this.a = new hu8.b().d();
    }

    public static ju8 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (c == null) {
                synchronized (ju8.class) {
                    if (c == null) {
                        c = new ju8();
                    }
                }
            }
            return c;
        }
        return (ju8) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a == null) {
            throw new IllegalStateException(ImageLoader.ERROR_NOT_INIT);
        }
    }

    public Bitmap d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Bitmap a2 = g().a(str);
            if (a2 == null || a2.isRecycled()) {
                Bitmap a3 = e().a(str);
                if (a3 == null || a3.isRecycled()) {
                    return null;
                }
                return a3;
            }
            return a2;
        }
        return (Bitmap) invokeL.objValue;
    }

    public cu8 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c();
            String str = FileHelper.getVideoTmpDir() + File.separator + "shaft_images";
            if (!TextUtils.equals(this.a.c.b(), str)) {
                this.a.c.d(str);
            }
            return this.a.c;
        }
        return (cu8) invokeV.objValue;
    }

    public mu8 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c();
            return this.a.b;
        }
        return (mu8) invokeV.objValue;
    }

    public final void h(ou8 ou8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ou8Var) == null) {
            c();
            fu8.b b = fu8.a().b();
            if (b != null) {
                b.p(this.a.a);
                b.setDataSource(ou8Var.a);
                b.h(ou8Var, new a(this));
                return;
            }
            this.b.add(ou8Var);
        }
    }

    public void i(pu8 pu8Var, gu8 gu8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, pu8Var, gu8Var) == null) {
            List<ou8> c2 = lu8.c(pu8Var, gu8Var);
            if (u79.e(c2)) {
                return;
            }
            for (ou8 ou8Var : c2) {
                h(ou8Var);
            }
        }
    }

    public void j(qu8 qu8Var, gu8 gu8Var) {
        ou8 b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, qu8Var, gu8Var) == null) || (b = lu8.b(qu8Var, gu8Var)) == null) {
            return;
        }
        h(b);
    }
}
