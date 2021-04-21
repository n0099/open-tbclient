package d.b.h0.k.d;

import com.baidu.searchbox.http.callback.ResponseCallback;
import java.util.Map;
import okhttp3.RequestBody;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f49600a;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f49602c;

    /* renamed from: d  reason: collision with root package name */
    public RequestBody f49603d;

    /* renamed from: e  reason: collision with root package name */
    public ResponseCallback f49604e;
    public Object i;

    /* renamed from: b  reason: collision with root package name */
    public String f49601b = "GET";

    /* renamed from: f  reason: collision with root package name */
    public boolean f49605f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f49606g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f49607h = false;

    public a() {
    }

    public a(String str, ResponseCallback responseCallback) {
        this.f49600a = str;
        this.f49604e = responseCallback;
    }

    public a(String str, RequestBody requestBody, ResponseCallback responseCallback) {
        this.f49600a = str;
        this.f49603d = requestBody;
        this.f49604e = responseCallback;
    }
}
