package d.a.q0.c0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.core.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public interface a {

    /* renamed from: d.a.q0.c0.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1305a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1305a() {
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

        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) && i2 != 1 && i2 != 2 && i2 != 3 && BdLog.e()) {
                throw new IllegalArgumentException("invalid source code");
            }
        }

        public void b(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && i2 != 1 && i2 != 2 && i2 != 3 && BdLog.e()) {
                throw new IllegalArgumentException("invalid source code");
            }
        }
    }

    void a(int i2, C1305a c1305a);

    void b(int i2, String str, C1305a c1305a);
}
