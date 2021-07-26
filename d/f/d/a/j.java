package d.f.d.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes8.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f71278a;

        /* renamed from: b  reason: collision with root package name */
        public final a f71279b;

        /* renamed from: c  reason: collision with root package name */
        public a f71280c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f71281d;

        /* loaded from: classes8.dex */
        public static final class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public String f71282a;

            /* renamed from: b  reason: collision with root package name */
            public Object f71283b;

            /* renamed from: c  reason: collision with root package name */
            public a f71284c;

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

            public /* synthetic */ a(a aVar) {
                this();
            }
        }

        public /* synthetic */ b(String str, a aVar) {
            this(str);
        }

        public b a(String str, double d2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Double.valueOf(d2)})) == null) {
                g(str, String.valueOf(d2));
                return this;
            }
            return (b) invokeCommon.objValue;
        }

        public b b(String str, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2)) == null) {
                g(str, String.valueOf(i2));
                return this;
            }
            return (b) invokeLI.objValue;
        }

        public b c(String str, long j) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j)) == null) {
                g(str, String.valueOf(j));
                return this;
            }
            return (b) invokeLJ.objValue;
        }

        public b d(String str, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, obj)) == null) {
                g(str, obj);
                return this;
            }
            return (b) invokeLL.objValue;
        }

        public final a e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                a aVar = new a(null);
                this.f71280c.f71284c = aVar;
                this.f71280c = aVar;
                return aVar;
            }
            return (a) invokeV.objValue;
        }

        public final b f(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                e().f71283b = obj;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public final b g(String str, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, obj)) == null) {
                a e2 = e();
                e2.f71283b = obj;
                n.p(str);
                e2.f71282a = str;
                return this;
            }
            return (b) invokeLL.objValue;
        }

        public b h(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
                f(obj);
                return this;
            }
            return (b) invokeL.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                boolean z = this.f71281d;
                StringBuilder sb = new StringBuilder(32);
                sb.append(this.f71278a);
                sb.append('{');
                String str = "";
                for (a aVar = this.f71279b.f71284c; aVar != null; aVar = aVar.f71284c) {
                    Object obj = aVar.f71283b;
                    if (!z || obj != null) {
                        sb.append(str);
                        String str2 = aVar.f71282a;
                        if (str2 != null) {
                            sb.append(str2);
                            sb.append(com.alipay.sdk.encrypt.a.f1923h);
                        }
                        if (obj != null && obj.getClass().isArray()) {
                            String deepToString = Arrays.deepToString(new Object[]{obj});
                            sb.append((CharSequence) deepToString, 1, deepToString.length() - 1);
                        } else {
                            sb.append(obj);
                        }
                        str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
                    }
                }
                sb.append('}');
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }

        public b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            a aVar = new a(null);
            this.f71279b = aVar;
            this.f71280c = aVar;
            this.f71281d = false;
            n.p(str);
            this.f71278a = str;
        }
    }

    public static <T> T a(T t, T t2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, t, t2)) == null) {
            if (t != null) {
                return t;
            }
            if (t2 != null) {
                return t2;
            }
            throw new NullPointerException("Both parameters are null");
        }
        return (T) invokeLL.objValue;
    }

    public static b b(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cls)) == null) ? new b(cls.getSimpleName(), null) : (b) invokeL.objValue;
    }

    public static b c(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, obj)) == null) ? new b(obj.getClass().getSimpleName(), null) : (b) invokeL.objValue;
    }
}
