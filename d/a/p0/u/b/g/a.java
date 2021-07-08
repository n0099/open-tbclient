package d.a.p0.u.b.g;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.aiapps.apps.permission.PermissionActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static List<String> f62464a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1452355987, "Ld/a/p0/u/b/g/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1452355987, "Ld/a/p0/u/b/g/a;");
        }
    }

    @TargetApi(23)
    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            List<String> list = f62464a;
            if (list == null) {
                f62464a = new ArrayList();
            } else {
                list.clear();
            }
            if (context.checkSelfPermission(StorageUtils.EXTERNAL_STORAGE_PERMISSION) != 0) {
                f62464a.add(StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                f62464a.add("android.permission.READ_EXTERNAL_STORAGE");
            }
        }
    }

    @TargetApi(23)
    public static boolean b(Context context, int i2, String[] strArr, int[] iArr) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65538, null, context, i2, strArr, iArr)) == null) {
            if (strArr.length >= 1 || iArr.length >= 1) {
                if (!c(context)) {
                    d(context);
                    return true;
                } else if (context instanceof PermissionActivity) {
                    ((Activity) context).finish();
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }
        return invokeLILL.booleanValue;
    }

    @TargetApi(23)
    public static boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? context.checkSelfPermission(StorageUtils.EXTERNAL_STORAGE_PERMISSION) == 0 : invokeL.booleanValue;
    }

    @TargetApi(23)
    public static void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            if (!c(context)) {
                a(context);
                List<String> list = f62464a;
                ((Activity) context).requestPermissions((String[]) list.toArray(new String[list.size()]), 102);
            } else if (context instanceof PermissionActivity) {
                ((Activity) context).finish();
            }
        }
    }
}
