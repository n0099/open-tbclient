package d.a.h0.k.d;

import com.baidu.searchbox.http.callback.ResponseCallback;
import java.util.Map;
import okhttp3.RequestBody;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f47106a;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f47108c;

    /* renamed from: d  reason: collision with root package name */
    public RequestBody f47109d;

    /* renamed from: e  reason: collision with root package name */
    public ResponseCallback f47110e;

    /* renamed from: i  reason: collision with root package name */
    public Object f47114i;

    /* renamed from: b  reason: collision with root package name */
    public String f47107b = "GET";

    /* renamed from: f  reason: collision with root package name */
    public boolean f47111f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f47112g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f47113h = false;

    public a() {
    }

    public a(String str, ResponseCallback responseCallback) {
        this.f47106a = str;
        this.f47110e = responseCallback;
    }

    public a(String str, RequestBody requestBody, ResponseCallback responseCallback) {
        this.f47106a = str;
        this.f47109d = requestBody;
        this.f47110e = responseCallback;
    }
}
