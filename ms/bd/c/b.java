package ms.bd.c;

import android.util.SparseArray;
import androidx.annotation.Keep;
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
import com.bytedance.JProtect;
@Keep
@JProtect
/* loaded from: classes2.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static SparseArray<a> f78832a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static abstract class a {
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

        public Object a(int i2, int i3, long j2, String str, Object obj) throws Throwable {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), str, obj})) == null) ? b(i3, j2, str, obj) : invokeCommon.objValue;
        }

        public Object b(int i2, long j2, String str, Object obj) throws Throwable {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), str, obj})) == null) {
                return null;
            }
            return invokeCommon.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-775245611, "Lms/bd/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-775245611, "Lms/bd/c/b;");
                return;
            }
        }
        f78832a = new SparseArray<>();
    }

    public static Object a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            while (true) {
                char c2 = '^';
                char c3 = 'K';
                while (true) {
                    switch (c2) {
                        case '\\':
                            switch (c3) {
                                case 22:
                                case 23:
                                    c2 = ']';
                                    c3 = ']';
                            }
                            break;
                        case ']':
                            break;
                        case '^':
                            c2 = ']';
                            c3 = ']';
                        default:
                            c2 = ']';
                            c3 = ']';
                    }
                }
                while (true) {
                    switch (c3) {
                        case '[':
                            break;
                        case '\\':
                        case ']':
                            break;
                        default:
                            c3 = '[';
                    }
                }
            }
            return h.a(i2, 0, 0L, null, null);
        }
        return invokeI.objValue;
    }

    public static Object a(int i2, int i3, long j2, String str, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), str, obj})) == null) ? h.a(i2, i3, j2, str, obj) : invokeCommon.objValue;
    }

    public static Object a(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            while (true) {
                char c2 = ']';
                char c3 = ']';
                while (true) {
                    switch (c2) {
                        case '\\':
                            switch (c3) {
                            }
                            c2 = '^';
                            c3 = 'K';
                            break;
                        case ']':
                            while (true) {
                                switch (c3) {
                                    case '[':
                                    case ']':
                                        break;
                                    case '\\':
                                        break;
                                    default:
                                        c3 = '[';
                                }
                            }
                            c2 = '^';
                            c3 = 'K';
                            break;
                        case '^':
                            if (c3 > 4) {
                                break;
                            } else {
                                break;
                            }
                    }
                }
            }
            return h.a(i2, 0, j2, null, null);
        }
        return invokeCommon.objValue;
    }

    public static Object a(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, str)) == null) ? h.a(i2, 0, 0L, str, null) : invokeIL.objValue;
    }

    public static void a(int i2, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeIL(AdIconUtil.AD_TEXT_ID, null, i2, aVar) != null) {
            return;
        }
        a aVar2 = f78832a.get(i2);
        if (aVar2 != null) {
            throw new RuntimeException(String.format((String) h.a(16777217, 0, 0L, "0148cc", new byte[]{100, 32, 7, 68, 93, 112, 115, 18, 96, 109, 47, 115, 85, 73, 91, 125, 32, 4, 96, 122, 111}), aVar2.toString()));
        }
        f78832a.put(i2, aVar);
        while (true) {
            char c2 = 'R';
            while (true) {
                switch (c2) {
                    case 'P':
                        return;
                    case 'Q':
                        break;
                    case 'R':
                    default:
                        c2 = 'P';
                }
            }
        }
    }

    public static Object b(int i2, int i3, long j2, String str, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), str, obj})) == null) {
            a aVar = f78832a.get(i2);
            if (aVar != null) {
                try {
                    return aVar.a(i2, i3, j2, str, obj);
                } catch (Throwable th) {
                    throw new RuntimeException(th);
                }
            }
            throw new RuntimeException(String.format((String) h.a(16777217, 0, 0L, "b02905", new byte[]{124, 34, 1, 78, 0, 38, 100, 81, 38, 109, 51, 59, 82, 13, 6, 44, 119, 16, 111, 96, 119}), Integer.valueOf(i2)));
        }
        return invokeCommon.objValue;
    }
}
