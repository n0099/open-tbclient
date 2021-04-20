package d.b.g0.k.e;

import androidx.annotation.NonNull;
import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import okhttp3.RequestBody;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
/* loaded from: classes3.dex */
public class b {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @NonNull
    public static HttpRequestBuilder a(@NonNull d.b.g0.k.d.a aVar) {
        char c2;
        HttpCommonRequestBuilder m;
        String str = aVar.f49272b;
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
                return a.f().getRequest();
            case 1:
                return a.f().headerRequest();
            case 2:
                m = a.f().m();
                break;
            case 3:
                m = a.f().postRequest();
                break;
            case 4:
                m = a.f().putRequest();
                break;
            case 5:
                m = a.f().deleteRequest();
                break;
            case 6:
                m = a.f().v();
                break;
            case 7:
                m = a.f().b();
                break;
            default:
                return a.f().getRequest();
        }
        RequestBody requestBody = aVar.f49274d;
        if (requestBody != null) {
            m.requestBody(requestBody);
        }
        return m;
    }
}
