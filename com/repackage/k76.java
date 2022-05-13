package com.repackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes6.dex */
public class k76 implements r76 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m76 a;
    public boolean b;
    public boolean c;
    public j76 d;
    public boolean e;

    public k76(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = false;
        this.e = false;
        this.a = new m76();
        this.e = z;
    }

    @Override // com.repackage.r76
    public void a(String str, s76 s76Var) {
        j76 j76Var;
        j76 j76Var2;
        float f;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, s76Var) == null) || s76Var == null) {
            return;
        }
        if (this.b) {
            File file = new File(s76Var.a);
            Bitmap decodeFile = BitmapFactory.decodeFile(s76Var.a);
            if (file.exists() && decodeFile != null) {
                float height = decodeFile.getHeight();
                float width = decodeFile.getWidth();
                float f2 = height * 1.0f;
                float f3 = f2 / width;
                float f4 = f3 > 1.0f ? 1.7777778f : 0.75f;
                float f5 = 0.0f;
                if (f3 > f4) {
                    float f6 = f4 * width;
                    f = (height - f6) * 0.5f;
                    height = f6;
                } else {
                    float f7 = f2 / f4;
                    f5 = (width - f7) * 0.5f;
                    width = f7;
                    f = 0.0f;
                }
                s76Var.a = FileHelper.saveBitmapByAbsolutelyPath(file.getPath(), file.getName(), Bitmap.createBitmap(decodeFile, (int) f5, (int) f, (int) width, (int) height), 95);
            }
        }
        if ("default".equals(str)) {
            if (this.c || (j76Var2 = this.d) == null) {
                return;
            }
            j76Var2.onCoverPathCallBack(s76Var.a);
        } else if (!"manual".equals(str) || (j76Var = this.d) == null) {
        } else {
            j76Var.onCoverPathCallBack(s76Var.a);
        }
    }

    public void b(t76 t76Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t76Var, str) == null) {
            this.a.a(str, this.e).a(t76Var, this);
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.c = z;
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.b = z;
        }
    }

    public void e(j76 j76Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, j76Var) == null) {
            this.d = j76Var;
        }
    }

    @Override // com.repackage.r76
    public void onError(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            BdLog.e("get cover error ! type : " + str + ", err : " + str2);
        }
    }
}
