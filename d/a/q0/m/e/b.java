package d.a.q0.m.e;

import androidx.annotation.NonNull;
import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import okhttp3.RequestBody;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @NonNull
    public static HttpRequestBuilder a(@NonNull d.a.q0.m.d.a aVar) {
        InterceptResult invokeL;
        char c2;
        HttpCommonRequestBuilder n;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, aVar)) == null) {
            String str = aVar.f53896b;
            switch (str.hashCode()) {
                case -531492226:
                    if (str.equals(HttpOptions.METHOD_NAME)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 70454:
                    if (str.equals("GET")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 79599:
                    if (str.equals(HttpPut.METHOD_NAME)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2213344:
                    if (str.equals("HEAD")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2461856:
                    if (str.equals("POST")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 80083237:
                    if (str.equals(HttpTrace.METHOD_NAME)) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1669334218:
                    if (str.equals("CONNECT")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2012838315:
                    if (str.equals(HttpDelete.METHOD_NAME)) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    return a.g().getRequest();
                case 1:
                    return a.g().headerRequest();
                case 2:
                    n = a.g().n();
                    break;
                case 3:
                    n = a.g().postRequest();
                    break;
                case 4:
                    n = a.g().putRequest();
                    break;
                case 5:
                    n = a.g().deleteRequest();
                    break;
                case 6:
                    n = a.g().x();
                    break;
                case 7:
                    n = a.g().a();
                    break;
                default:
                    return a.g().getRequest();
            }
            RequestBody requestBody = aVar.f53898d;
            if (requestBody != null) {
                n.requestBody(requestBody);
            }
            return n;
        }
        return (HttpRequestBuilder) invokeL.objValue;
    }
}
