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
import com.repackage.kv8;
import com.repackage.mv8;
import java.io.File;
import java.util.List;
import java.util.Vector;
/* loaded from: classes6.dex */
public class ov8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ov8 c;
    public transient /* synthetic */ FieldHolder $fh;
    public mv8 a;
    public List<tv8> b;

    /* loaded from: classes6.dex */
    public class a implements sv8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ov8 a;

        public a(ov8 ov8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ov8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ov8Var;
        }

        @Override // com.repackage.sv8
        public void a(kv8.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                kv8.a().c(bVar);
                if (b99.e(this.a.b)) {
                    return;
                }
                ov8 ov8Var = this.a;
                ov8Var.h((tv8) b99.c(ov8Var.b, 0));
                b99.g(this.a.b, 0);
            }
        }
    }

    public ov8() {
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
        this.a = new mv8.b().d();
    }

    public static ov8 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (c == null) {
                synchronized (ov8.class) {
                    if (c == null) {
                        c = new ov8();
                    }
                }
            }
            return c;
        }
        return (ov8) invokeV.objValue;
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

    public hv8 e() {
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
        return (hv8) invokeV.objValue;
    }

    public rv8 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c();
            return this.a.b;
        }
        return (rv8) invokeV.objValue;
    }

    public final void h(tv8 tv8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tv8Var) == null) {
            c();
            kv8.b b = kv8.a().b();
            if (b != null) {
                b.m(this.a.a);
                b.setDataSource(tv8Var.a);
                b.h(tv8Var, new a(this));
                return;
            }
            this.b.add(tv8Var);
        }
    }

    public void i(uv8 uv8Var, lv8 lv8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, uv8Var, lv8Var) == null) {
            List<tv8> c2 = qv8.c(uv8Var, lv8Var);
            if (b99.e(c2)) {
                return;
            }
            for (tv8 tv8Var : c2) {
                h(tv8Var);
            }
        }
    }

    public void j(vv8 vv8Var, lv8 lv8Var) {
        tv8 b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, vv8Var, lv8Var) == null) || (b = qv8.b(vv8Var, lv8Var)) == null) {
            return;
        }
        h(b);
    }
}
