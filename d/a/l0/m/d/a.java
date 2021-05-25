package d.a.l0.m.d;

import com.baidu.searchbox.http.callback.ResponseCallback;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f47969a;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f47971c;

    /* renamed from: d  reason: collision with root package name */
    public RequestBody f47972d;

    /* renamed from: e  reason: collision with root package name */
    public ResponseCallback f47973e;

    /* renamed from: i  reason: collision with root package name */
    public Object f47977i;
    public C1073a l;

    /* renamed from: b  reason: collision with root package name */
    public String f47970b = "GET";

    /* renamed from: f  reason: collision with root package name */
    public boolean f47974f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f47975g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f47976h = false;
    public int j = 6;
    public int k = 0;

    /* renamed from: d.a.l0.m.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1073a {

        /* renamed from: a  reason: collision with root package name */
        public int f47978a;

        /* renamed from: b  reason: collision with root package name */
        public int f47979b;

        /* renamed from: c  reason: collision with root package name */
        public int f47980c;
    }

    public a() {
    }

    public a a(MediaType mediaType, String str) {
        if (mediaType != null && str != null) {
            this.f47972d = RequestBody.create(mediaType, str);
        }
        return this;
    }

    public C1073a b() {
        return this.l;
    }

    public a(String str, ResponseCallback responseCallback) {
        this.f47969a = str;
        this.f47973e = responseCallback;
    }

    public a(String str, RequestBody requestBody, ResponseCallback responseCallback) {
        this.f47969a = str;
        this.f47972d = requestBody;
        this.f47973e = responseCallback;
    }
}
