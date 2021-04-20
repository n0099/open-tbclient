package d.b.g0.k.d;

import com.baidu.searchbox.http.callback.ResponseCallback;
import java.util.Map;
import okhttp3.RequestBody;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f49271a;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f49273c;

    /* renamed from: d  reason: collision with root package name */
    public RequestBody f49274d;

    /* renamed from: e  reason: collision with root package name */
    public ResponseCallback f49275e;
    public Object i;

    /* renamed from: b  reason: collision with root package name */
    public String f49272b = "GET";

    /* renamed from: f  reason: collision with root package name */
    public boolean f49276f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f49277g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f49278h = false;

    public a() {
    }

    public a(String str, ResponseCallback responseCallback) {
        this.f49271a = str;
        this.f49275e = responseCallback;
    }

    public a(String str, RequestBody requestBody, ResponseCallback responseCallback) {
        this.f49271a = str;
        this.f49274d = requestBody;
        this.f49275e = responseCallback;
    }
}
