package com.repackage;

import android.graphics.Bitmap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public class w45 {
    public static /* synthetic */ Interceptable $ic;
    public static w45 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, Class<? extends v45>> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755251335, "Lcom/repackage/w45;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755251335, "Lcom/repackage/w45;");
                return;
            }
        }
        b = new w45();
    }

    public w45() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
        f(x45.class);
        f(z45.class);
        f(u45.class);
        f(y45.class);
        f(a55.class);
    }

    public static w45 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b : (w45) invokeV.objValue;
    }

    public v45 a(ImageOperation imageOperation) {
        InterceptResult invokeL;
        v45 e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imageOperation)) == null) {
            Class<? extends v45> cls = this.a.get(imageOperation.actionName);
            if (cls == null || (e = e(cls)) == null) {
                return null;
            }
            e.d(imageOperation.actionParam);
            return e;
        }
        return (v45) invokeL.objValue;
    }

    public Bitmap b(Bitmap bitmap, boolean z, List<ImageOperation> list, ImageFileInfo imageFileInfo) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bitmap, Boolean.valueOf(z), list, imageFileInfo})) == null) {
            if (bitmap == null || ListUtils.isEmpty(list)) {
                return bitmap;
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                v45 a = a(list.get(i));
                if ((a instanceof a55) && imageFileInfo != null) {
                    ((a55) a).e(imageFileInfo.getFilePath());
                    return a.b(bitmap, z);
                }
            }
            x45 x45Var = null;
            int i2 = 0;
            while (i2 < size) {
                ImageOperation imageOperation = list.get(i2);
                if ("resize".equals(imageOperation.actionName)) {
                    x45 x45Var2 = (x45) a(imageOperation);
                    if (x45Var == null || x45Var2.f() <= x45Var.f() || x45Var2.e() <= x45Var.e()) {
                        x45Var = x45Var2;
                    }
                    list.remove(i2);
                    i2--;
                }
                i2++;
            }
            Bitmap b2 = x45Var != null ? x45Var.b(bitmap, z) : null;
            if (list != null) {
                for (int i3 = 0; i3 < size; i3++) {
                    v45 a2 = a(list.get(i3));
                    if (a2 != null) {
                        if (b2 == null) {
                            return null;
                        }
                        b2 = a2.b(bitmap, z);
                    }
                }
            }
            return b2;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public Bitmap c(String str, List<ImageOperation> list, ImageFileInfo imageFileInfo) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, list, imageFileInfo)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                v45 a = a(list.get(i));
                if ((a instanceof a55) && imageFileInfo != null) {
                    return a.c(imageFileInfo.getFilePath());
                }
            }
            x45 x45Var = null;
            int i2 = 0;
            while (i2 < list.size()) {
                ImageOperation imageOperation = list.get(i2);
                if ("resize".equals(imageOperation.actionName)) {
                    x45 x45Var2 = (x45) a(imageOperation);
                    if (x45Var == null || x45Var2.f() <= x45Var.f() || x45Var2.e() <= x45Var.e()) {
                        x45Var = x45Var2;
                    }
                    list.remove(i2);
                    i2--;
                }
                i2++;
            }
            Bitmap c = x45Var != null ? x45Var.c(str) : null;
            if (list != null) {
                for (int i3 = 0; i3 < list.size(); i3++) {
                    v45 a2 = a(list.get(i3));
                    if (a2 != null) {
                        if (c == null) {
                            c = a2.c(str);
                        } else {
                            c = a2.b(c, true);
                        }
                    }
                }
            }
            return c;
        }
        return (Bitmap) invokeLLL.objValue;
    }

    public final v45 e(Class<? extends v45> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cls)) == null) {
            try {
                return cls.newInstance();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (InstantiationException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (v45) invokeL.objValue;
    }

    public final void f(Class<? extends v45> cls) {
        v45 e;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, cls) == null) || (e = e(cls)) == null) {
            return;
        }
        this.a.put(e.a(), cls);
    }
}
