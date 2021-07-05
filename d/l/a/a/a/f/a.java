package d.l.a.a.a.f;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.l.a.a.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C2043a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f74039a;

        /* renamed from: b  reason: collision with root package name */
        public String f74040b;

        /* renamed from: c  reason: collision with root package name */
        public String f74041c;

        /* renamed from: d  reason: collision with root package name */
        public String f74042d;

        /* renamed from: e  reason: collision with root package name */
        public String f74043e;

        public C2043a() {
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

        public C2043a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                this.f74039a = str;
                return this;
            }
            return (C2043a) invokeL.objValue;
        }

        public a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(this) : (a) invokeV.objValue;
        }

        public C2043a d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f74040b = str;
                return this;
            }
            return (C2043a) invokeL.objValue;
        }

        public C2043a f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f74042d = str;
                return this;
            }
            return (C2043a) invokeL.objValue;
        }

        public C2043a h(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f74043e = str;
                return this;
            }
            return (C2043a) invokeL.objValue;
        }
    }

    public a(C2043a c2043a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c2043a};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        String unused = c2043a.f74039a;
        String unused2 = c2043a.f74040b;
        String unused3 = c2043a.f74041c;
        String unused4 = c2043a.f74042d;
        String unused5 = c2043a.f74043e;
    }
}
