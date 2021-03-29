package d.b.g0.k.d;

import com.baidu.searchbox.http.callback.ResponseCallback;
import java.util.Map;
import okhttp3.RequestBody;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f48879a;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f48881c;

    /* renamed from: d  reason: collision with root package name */
    public RequestBody f48882d;

    /* renamed from: e  reason: collision with root package name */
    public ResponseCallback f48883e;
    public Object i;

    /* renamed from: b  reason: collision with root package name */
    public String f48880b = "GET";

    /* renamed from: f  reason: collision with root package name */
    public boolean f48884f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f48885g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f48886h = false;

    public a() {
    }

    public a(String str, ResponseCallback responseCallback) {
        this.f48879a = str;
        this.f48883e = responseCallback;
    }

    public a(String str, RequestBody requestBody, ResponseCallback responseCallback) {
        this.f48879a = str;
        this.f48882d = requestBody;
        this.f48883e = responseCallback;
    }
}
