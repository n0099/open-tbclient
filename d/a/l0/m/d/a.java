package d.a.l0.m.d;

import com.baidu.searchbox.http.callback.ResponseCallback;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f51643a;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f51645c;

    /* renamed from: d  reason: collision with root package name */
    public RequestBody f51646d;

    /* renamed from: e  reason: collision with root package name */
    public ResponseCallback f51647e;

    /* renamed from: i  reason: collision with root package name */
    public Object f51651i;
    public C1129a l;

    /* renamed from: b  reason: collision with root package name */
    public String f51644b = "GET";

    /* renamed from: f  reason: collision with root package name */
    public boolean f51648f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51649g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f51650h = false;
    public int j = 6;
    public int k = 0;

    /* renamed from: d.a.l0.m.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1129a {

        /* renamed from: a  reason: collision with root package name */
        public int f51652a;

        /* renamed from: b  reason: collision with root package name */
        public int f51653b;

        /* renamed from: c  reason: collision with root package name */
        public int f51654c;
    }

    public a() {
    }

    public a a(MediaType mediaType, String str) {
        if (mediaType != null && str != null) {
            this.f51646d = RequestBody.create(mediaType, str);
        }
        return this;
    }

    public C1129a b() {
        return this.l;
    }

    public a(String str, ResponseCallback responseCallback) {
        this.f51643a = str;
        this.f51647e = responseCallback;
    }

    public a(String str, RequestBody requestBody, ResponseCallback responseCallback) {
        this.f51643a = str;
        this.f51646d = requestBody;
        this.f51647e = responseCallback;
    }
}
