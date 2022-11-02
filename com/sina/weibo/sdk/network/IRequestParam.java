package com.sina.weibo.sdk.network;

import android.content.Context;
import android.os.Bundle;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.client.methods.HttpDelete;
/* loaded from: classes8.dex */
public interface IRequestParam {
    void addInterceptResult(String str, Object obj);

    Map<String, byte[]> byteArrays();

    Map<String, ValuePart<File>> files();

    Context getContext();

    Bundle getExtraBundle();

    Bundle getGetBundle();

    Bundle getHeader();

    ArrayList<IRequestIntercept> getIntercept();

    Object getInterceptResult(String str);

    RequestType getMethod();

    Bundle getPostBundle();

    int getRequestTimeout();

    int getResponseTimeout();

    String getUrl();

    boolean needGzip();

    boolean needIntercept();

    void setUrl(String str);

    boolean useDefaultHost();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class RequestType {
        public static final /* synthetic */ RequestType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final RequestType DELETE;
        public static final RequestType GET;
        public static final RequestType PATCH;
        public static final RequestType POST;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-157758504, "Lcom/sina/weibo/sdk/network/IRequestParam$RequestType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-157758504, "Lcom/sina/weibo/sdk/network/IRequestParam$RequestType;");
                    return;
                }
            }
            POST = new RequestType("POST", 0);
            GET = new RequestType("GET", 1);
            DELETE = new RequestType(HttpDelete.METHOD_NAME, 2);
            RequestType requestType = new RequestType("PATCH", 3);
            PATCH = requestType;
            $VALUES = new RequestType[]{POST, GET, DELETE, requestType};
        }

        public RequestType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static RequestType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (RequestType) Enum.valueOf(RequestType.class, str);
            }
            return (RequestType) invokeL.objValue;
        }

        public static RequestType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (RequestType[]) $VALUES.clone();
            }
            return (RequestType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class ValuePart<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String mimeType;
        public T value;

        public ValuePart() {
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
    }
}
