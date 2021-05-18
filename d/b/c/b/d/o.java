package d.b.c.b.d;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.adnet.err.VAdError;
import d.b.c.b.f.b;
import java.util.Map;
/* loaded from: classes6.dex */
public class o<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f65766a;

    /* renamed from: b  reason: collision with root package name */
    public final b.a f65767b;

    /* renamed from: c  reason: collision with root package name */
    public final VAdError f65768c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f65769d;

    /* renamed from: e  reason: collision with root package name */
    public long f65770e;

    /* renamed from: f  reason: collision with root package name */
    public long f65771f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, Object> f65772g;

    /* renamed from: h  reason: collision with root package name */
    public long f65773h;

    /* loaded from: classes6.dex */
    public interface a<T> {
        void a(o<T> oVar);

        void b(o<T> oVar);
    }

    public o(T t, b.a aVar) {
        this.f65769d = false;
        this.f65770e = 0L;
        this.f65771f = 0L;
        this.f65773h = 0L;
        this.f65766a = t;
        this.f65767b = aVar;
        this.f65768c = null;
        if (aVar != null) {
            this.f65773h = aVar.f65790a;
        }
    }

    public static <T> o<T> b(VAdError vAdError) {
        return new o<>(vAdError);
    }

    public static <T> o<T> c(T t, b.a aVar) {
        return new o<>(t, aVar);
    }

    public o a(long j) {
        this.f65770e = j;
        return this;
    }

    @Nullable
    public Object d(String str) {
        Map<String, Object> map;
        if (TextUtils.isEmpty(str) || (map = this.f65772g) == null) {
            return null;
        }
        return map.get(str);
    }

    public String e(String str, @Nullable String str2) {
        Map<String, String> map;
        String str3;
        b.a aVar = this.f65767b;
        return (aVar == null || (map = aVar.f65797h) == null || (str3 = map.get(str)) == null) ? str2 : str3;
    }

    public boolean f() {
        return this.f65768c == null;
    }

    public o g(long j) {
        this.f65771f = j;
        return this;
    }

    public o(VAdError vAdError) {
        this.f65769d = false;
        this.f65770e = 0L;
        this.f65771f = 0L;
        this.f65773h = 0L;
        this.f65766a = null;
        this.f65767b = null;
        this.f65768c = vAdError;
        if (0 != 0 || vAdError == null) {
            return;
        }
        k kVar = vAdError.networkResponse;
        if (kVar != null) {
            this.f65773h = kVar.f65749a;
        } else {
            this.f65773h = vAdError.getErrorCode();
        }
        com.bytedance.sdk.adnet.d.d.c("Response", "Response error code = " + this.f65773h);
    }
}
