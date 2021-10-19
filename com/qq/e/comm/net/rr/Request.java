package com.qq.e.comm.net.rr;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.HttpURLConnection;
import java.util.Map;
/* loaded from: classes10.dex */
public interface Request {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class Method {
        public static /* synthetic */ Interceptable $ic;
        public static final Method GET;
        public static final Method POST;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Method[] f75764a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1734153428, "Lcom/qq/e/comm/net/rr/Request$Method;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1734153428, "Lcom/qq/e/comm/net/rr/Request$Method;");
                    return;
                }
            }
            GET = new Method("GET", 0);
            Method method = new Method("POST", 1);
            POST = method;
            f75764a = new Method[]{GET, method};
        }

        public Method(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Method valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Method) Enum.valueOf(Method.class, str) : (Method) invokeL.objValue;
        }

        public static Method[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Method[]) f75764a.clone() : (Method[]) invokeV.objValue;
        }
    }

    void addHeader(String str, String str2);

    void addQuery(String str, String str2);

    int getConnectionTimeOut();

    Map<String, String> getHeaders();

    Method getMethod();

    byte[] getPostData() throws Exception;

    int getPriority();

    Map<String, String> getQuerys();

    int getSocketTimeOut();

    String getUrl();

    String getUrlWithParas();

    Response initResponse(HttpURLConnection httpURLConnection);

    boolean isAutoClose();

    void setConnectionTimeOut(int i2);

    void setSocketTimeOut(int i2);
}
