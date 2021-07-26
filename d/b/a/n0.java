package d.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.embedapplog.IOaidObserver;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class n0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f69265a;

    /* renamed from: b  reason: collision with root package name */
    public static j0<u0> f69266b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a extends j0<u0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.a.j0
        /* renamed from: c */
        public u0 a(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr)) == null) ? new u0((Context) objArr[0]) : (u0) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(413436647, "Ld/b/a/n0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(413436647, "Ld/b/a/n0;");
                return;
            }
        }
        f69265a = n0.class.getSimpleName() + "#";
        f69266b = new a();
    }

    public n0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @WorkerThread
    public static String a(SharedPreferences sharedPreferences) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, sharedPreferences)) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            String a2 = l0.a(sharedPreferences);
            o0.e("TrackerDr", f69265a + "getCdid takes " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ms");
            return a2;
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    @AnyThread
    public static String b(@Nullable JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            if (jSONObject != null) {
                return jSONObject.optString("id", null);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    @WorkerThread
    public static Map<String, String> c(@NonNull Context context, @NonNull SharedPreferences sharedPreferences) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, sharedPreferences)) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Map<String, String> b2 = f69266b.b(context).b(100L);
            o0.e("TrackerDr", f69265a + "getOaid takes " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ms");
            return b2;
        }
        return (Map) invokeLL.objValue;
    }

    @AnyThread
    public static void d(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context) == null) {
            f69266b.b(context).c();
        }
    }

    @AnyThread
    public static void e(@Nullable IOaidObserver iOaidObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, iOaidObserver) == null) {
            u0.e(iOaidObserver);
        }
    }
}
