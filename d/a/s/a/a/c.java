package d.a.s.a.a;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import dalvik.system.DexFile;
import java.io.File;
/* loaded from: classes9.dex */
public class c implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // d.a.s.a.a.a
    public boolean a(Context context, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, file)) == null) {
            Object b2 = d.a.r.a.a.b.b(context.getClassLoader(), "pathList");
            if (d() != null) {
                for (Object obj : (Object[]) d.a.r.a.a.b.b(b2, "nativeLibraryPathElements")) {
                    if (obj.toString().contains(file.toString())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // d.a.s.a.a.a
    public void b(Context context, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, file) == null) {
            Object b2 = d.a.r.a.a.b.b(context.getClassLoader(), "pathList");
            Class d2 = d();
            if (d2 != null) {
                Object[] objArr = (Object[]) d.a.r.a.a.b.b(b2, "nativeLibraryPathElements");
                Object c2 = c(d2, file);
                if (objArr == null || c2 == null) {
                    return;
                }
                d.a.r.a.a.b.d(b2, "nativeLibraryPathElements", d.a.r.a.a.a.d(d2, objArr, c2));
            }
        }
    }

    public Object c(Class cls, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cls, file)) == null) ? d.a.r.a.a.b.c(cls, new Class[]{File.class, Boolean.TYPE, File.class, DexFile.class}, new Object[]{file, Boolean.TRUE, null, null}) : invokeLL.objValue;
    }

    public Class d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                return Class.forName("dalvik.system.DexPathList$Element");
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (Class) invokeV.objValue;
    }
}
