package d.a.z.f;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Context f69181a;

    /* renamed from: b  reason: collision with root package name */
    public static String f69182b;
    public transient /* synthetic */ FieldHolder $fh;

    public static Context a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? f69181a : (Context) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f69182b : (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? "1.1.2.11" : (String) invokeV.objValue;
    }

    public static void d(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, str) == null) {
            if (context == null) {
                throw new NullPointerException("context is null");
            }
            if (TextUtils.isEmpty(str)) {
                throw new NullPointerException("clienID is null");
            }
            f69181a = context.getApplicationContext();
            f69182b = str;
            context.getPackageName();
        }
    }
}
