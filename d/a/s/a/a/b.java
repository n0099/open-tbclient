package d.a.s.a.a;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class b implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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
            Object b2 = d.a.r.a.a.b.b(d.a.r.a.a.b.b(context.getClassLoader(), "pathList"), "nativeLibraryDirectories");
            if (b2 instanceof File[]) {
                return d.a.r.a.a.a.a((File[]) b2, file);
            }
            return ((ArrayList) b2).contains(file);
        }
        return invokeLL.booleanValue;
    }

    @Override // d.a.s.a.a.a
    public void b(Context context, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, file) == null) {
            Object b2 = d.a.r.a.a.b.b(context.getClassLoader(), "pathList");
            Object b3 = d.a.r.a.a.b.b(b2, "nativeLibraryDirectories");
            if (b3 instanceof File[]) {
                d.a.r.a.a.b.d(b2, "nativeLibraryDirectories", d.a.r.a.a.a.d(File.class, (File[]) b3, file));
            } else {
                ((ArrayList) b3).add(file);
            }
        }
    }
}
