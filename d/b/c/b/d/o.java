package d.b.c.b.d;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.adnet.err.VAdError;
import d.b.c.b.f.b;
import java.util.Map;
/* loaded from: classes5.dex */
public class o<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f65080a;

    /* renamed from: b  reason: collision with root package name */
    public final b.a f65081b;

    /* renamed from: c  reason: collision with root package name */
    public final VAdError f65082c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f65083d;

    /* renamed from: e  reason: collision with root package name */
    public long f65084e;

    /* renamed from: f  reason: collision with root package name */
    public long f65085f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, Object> f65086g;

    /* renamed from: h  reason: collision with root package name */
    public long f65087h;

    /* loaded from: classes5.dex */
    public interface a<T> {
        void a(o<T> oVar);

        void b(o<T> oVar);
    }

    public o(T t, b.a aVar) {
        this.f65083d = false;
        this.f65084e = 0L;
        this.f65085f = 0L;
        this.f65087h = 0L;
        this.f65080a = t;
        this.f65081b = aVar;
        this.f65082c = null;
        if (aVar != null) {
            this.f65087h = aVar.f65104a;
        }
    }

    public static <T> o<T> b(VAdError vAdError) {
        return new o<>(vAdError);
    }

    public static <T> o<T> c(T t, b.a aVar) {
        return new o<>(t, aVar);
    }

    public o a(long j) {
        this.f65084e = j;
        return this;
    }

    @Nullable
    public Object d(String str) {
        Map<String, Object> map;
        if (TextUtils.isEmpty(str) || (map = this.f65086g) == null) {
            return null;
        }
        return map.get(str);
    }

    public String e(String str, @Nullable String str2) {
        Map<String, String> map;
        String str3;
        b.a aVar = this.f65081b;
        return (aVar == null || (map = aVar.f65111h) == null || (str3 = map.get(str)) == null) ? str2 : str3;
    }

    public boolean f() {
        return this.f65082c == null;
    }

    public o g(long j) {
        this.f65085f = j;
        return this;
    }

    public o(VAdError vAdError) {
        this.f65083d = false;
        this.f65084e = 0L;
        this.f65085f = 0L;
        this.f65087h = 0L;
        this.f65080a = null;
        this.f65081b = null;
        this.f65082c = vAdError;
        if (0 != 0 || vAdError == null) {
            return;
        }
        k kVar = vAdError.networkResponse;
        if (kVar != null) {
            this.f65087h = kVar.f65063a;
        } else {
            this.f65087h = vAdError.getErrorCode();
        }
        com.bytedance.sdk.adnet.d.d.c("Response", "Response error code = " + this.f65087h);
    }
}
