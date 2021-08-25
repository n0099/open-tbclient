package j.a.a.c.d;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes2.dex */
public class a implements Interceptor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f78807a;

    /* renamed from: b  reason: collision with root package name */
    public int f78808b;

    public a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f78808b = 0;
        this.f78807a = i2;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, chain)) == null) {
            Request request = chain.request();
            Response proceed = chain.proceed(request);
            while (!proceed.isSuccessful() && (i2 = this.f78808b) < this.f78807a) {
                this.f78808b = i2 + 1;
                proceed = chain.proceed(request);
                RLog.info("RetryInterceptor", "RetryInterceptor maxRetry=%s, retryCount=%s", Integer.valueOf(this.f78807a), Integer.valueOf(this.f78808b));
            }
            return proceed;
        }
        return (Response) invokeL.objValue;
    }
}
