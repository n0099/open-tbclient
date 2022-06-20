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
import com.repackage.nu8;
import com.repackage.pu8;
import java.io.File;
import java.util.List;
import java.util.Vector;
/* loaded from: classes7.dex */
public class ru8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ru8 c;
    public transient /* synthetic */ FieldHolder $fh;
    public pu8 a;
    public List<wu8> b;

    /* loaded from: classes7.dex */
    public class a implements vu8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ru8 a;

        public a(ru8 ru8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ru8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ru8Var;
        }

        @Override // com.repackage.vu8
        public void a(nu8.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                nu8.a().c(bVar);
                if (c89.e(this.a.b)) {
                    return;
                }
                ru8 ru8Var = this.a;
                ru8Var.h((wu8) c89.c(ru8Var.b, 0));
                c89.g(this.a.b, 0);
            }
        }
    }

    public ru8() {
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
        this.a = new pu8.b().d();
    }

    public static ru8 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (c == null) {
                synchronized (ru8.class) {
                    if (c == null) {
                        c = new ru8();
                    }
                }
            }
            return c;
        }
        return (ru8) invokeV.objValue;
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

    public ku8 e() {
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
        return (ku8) invokeV.objValue;
    }

    public uu8 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c();
            return this.a.b;
        }
        return (uu8) invokeV.objValue;
    }

    public final void h(wu8 wu8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, wu8Var) == null) {
            c();
            nu8.b b = nu8.a().b();
            if (b != null) {
                b.m(this.a.a);
                b.setDataSource(wu8Var.a);
                b.h(wu8Var, new a(this));
                return;
            }
            this.b.add(wu8Var);
        }
    }

    public void i(xu8 xu8Var, ou8 ou8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, xu8Var, ou8Var) == null) {
            List<wu8> c2 = tu8.c(xu8Var, ou8Var);
            if (c89.e(c2)) {
                return;
            }
            for (wu8 wu8Var : c2) {
                h(wu8Var);
            }
        }
    }

    public void j(yu8 yu8Var, ou8 ou8Var) {
        wu8 b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, yu8Var, ou8Var) == null) || (b = tu8.b(yu8Var, ou8Var)) == null) {
            return;
        }
        h(b);
    }
}
