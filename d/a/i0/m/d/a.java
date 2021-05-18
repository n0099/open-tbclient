package d.a.i0.m.d;

import com.baidu.searchbox.http.callback.ResponseCallback;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f47793a;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f47795c;

    /* renamed from: d  reason: collision with root package name */
    public RequestBody f47796d;

    /* renamed from: e  reason: collision with root package name */
    public ResponseCallback f47797e;

    /* renamed from: i  reason: collision with root package name */
    public Object f47801i;
    public C1062a l;

    /* renamed from: b  reason: collision with root package name */
    public String f47794b = "GET";

    /* renamed from: f  reason: collision with root package name */
    public boolean f47798f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f47799g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f47800h = false;
    public int j = 6;
    public int k = 0;

    /* renamed from: d.a.i0.m.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1062a {

        /* renamed from: a  reason: collision with root package name */
        public int f47802a;

        /* renamed from: b  reason: collision with root package name */
        public int f47803b;

        /* renamed from: c  reason: collision with root package name */
        public int f47804c;
    }

    public a() {
    }

    public a a(MediaType mediaType, String str) {
        if (mediaType != null && str != null) {
            this.f47796d = RequestBody.create(mediaType, str);
        }
        return this;
    }

    public C1062a b() {
        return this.l;
    }

    public a(String str, ResponseCallback responseCallback) {
        this.f47793a = str;
        this.f47797e = responseCallback;
    }

    public a(String str, RequestBody requestBody, ResponseCallback responseCallback) {
        this.f47793a = str;
        this.f47796d = requestBody;
        this.f47797e = responseCallback;
    }
}
