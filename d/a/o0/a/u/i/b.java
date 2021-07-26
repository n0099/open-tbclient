package d.a.o0.a.u.i;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.o0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48374a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-998114800, "Ld/a/o0/a/u/i/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-998114800, "Ld/a/o0/a/u/i/b;");
                return;
            }
        }
        f48374a = k.f46335a;
    }

    @NonNull
    public static Pair<d.a.o0.a.u.h.b, JSONObject> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? b("Api-Utils", str) : (Pair) invokeL.objValue;
    }

    @NonNull
    public static Pair<d.a.o0.a.u.h.b, JSONObject> b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "Api-Utils";
            }
            if (TextUtils.isEmpty(str2)) {
                if (f48374a) {
                    Log.e(str, "parseJson: json str is empty");
                }
                return new Pair<>(new d.a.o0.a.u.h.b(202, "parseJson: json str is empty"), new JSONObject());
            }
            try {
                return new Pair<>(new d.a.o0.a.u.h.b(0), new JSONObject(str2));
            } catch (JSONException e2) {
                if (f48374a) {
                    e2.printStackTrace();
                    Log.e(str, "parseJson: with exception ", e2);
                }
                return new Pair<>(new d.a.o0.a.u.h.b(202, "parseJson: with exception "), new JSONObject());
            }
        }
        return (Pair) invokeLL.objValue;
    }
}
