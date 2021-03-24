package d.b.g0.k.d;

import com.baidu.searchbox.http.callback.ResponseCallback;
import java.util.Map;
import okhttp3.RequestBody;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f48878a;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f48880c;

    /* renamed from: d  reason: collision with root package name */
    public RequestBody f48881d;

    /* renamed from: e  reason: collision with root package name */
    public ResponseCallback f48882e;
    public Object i;

    /* renamed from: b  reason: collision with root package name */
    public String f48879b = "GET";

    /* renamed from: f  reason: collision with root package name */
    public boolean f48883f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f48884g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f48885h = false;

    public a() {
    }

    public a(String str, ResponseCallback responseCallback) {
        this.f48878a = str;
        this.f48882e = responseCallback;
    }

    public a(String str, RequestBody requestBody, ResponseCallback responseCallback) {
        this.f48878a = str;
        this.f48881d = requestBody;
        this.f48882e = responseCallback;
    }
}
