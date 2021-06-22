package d.a.m0.m.d;

import com.baidu.searchbox.http.callback.ResponseCallback;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f51751a;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f51753c;

    /* renamed from: d  reason: collision with root package name */
    public RequestBody f51754d;

    /* renamed from: e  reason: collision with root package name */
    public ResponseCallback f51755e;

    /* renamed from: i  reason: collision with root package name */
    public Object f51759i;
    public C1132a l;

    /* renamed from: b  reason: collision with root package name */
    public String f51752b = "GET";

    /* renamed from: f  reason: collision with root package name */
    public boolean f51756f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51757g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f51758h = false;
    public int j = 6;
    public int k = 0;

    /* renamed from: d.a.m0.m.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1132a {

        /* renamed from: a  reason: collision with root package name */
        public int f51760a;

        /* renamed from: b  reason: collision with root package name */
        public int f51761b;

        /* renamed from: c  reason: collision with root package name */
        public int f51762c;
    }

    public a() {
    }

    public a a(MediaType mediaType, String str) {
        if (mediaType != null && str != null) {
            this.f51754d = RequestBody.create(mediaType, str);
        }
        return this;
    }

    public C1132a b() {
        return this.l;
    }

    public a(String str, ResponseCallback responseCallback) {
        this.f51751a = str;
        this.f51755e = responseCallback;
    }

    public a(String str, RequestBody requestBody, ResponseCallback responseCallback) {
        this.f51751a = str;
        this.f51754d = requestBody;
        this.f51755e = responseCallback;
    }
}
