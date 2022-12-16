package okhttp3;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public interface Authenticator {
    public static final Authenticator NONE = new Authenticator() { // from class: okhttp3.Authenticator.1
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // okhttp3.Authenticator
        public Request authenticate(@Nullable Route route, Response response) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, route, response)) == null) {
                return null;
            }
            return (Request) invokeLL.objValue;
        }

        {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    };

    @Nullable
    Request authenticate(@Nullable Route route, Response response) throws IOException;
}
