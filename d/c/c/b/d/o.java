package d.c.c.b.d;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.adnet.err.VAdError;
import d.c.c.b.f.b;
import java.util.Map;
/* loaded from: classes5.dex */
public class o<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f66679a;

    /* renamed from: b  reason: collision with root package name */
    public final b.a f66680b;

    /* renamed from: c  reason: collision with root package name */
    public final VAdError f66681c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f66682d;

    /* renamed from: e  reason: collision with root package name */
    public long f66683e;

    /* renamed from: f  reason: collision with root package name */
    public long f66684f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, Object> f66685g;

    /* renamed from: h  reason: collision with root package name */
    public long f66686h;

    /* loaded from: classes5.dex */
    public interface a<T> {
        void a(o<T> oVar);

        void b(o<T> oVar);
    }

    public o(T t, b.a aVar) {
        this.f66682d = false;
        this.f66683e = 0L;
        this.f66684f = 0L;
        this.f66686h = 0L;
        this.f66679a = t;
        this.f66680b = aVar;
        this.f66681c = null;
        if (aVar != null) {
            this.f66686h = aVar.f66703a;
        }
    }

    public static <T> o<T> b(VAdError vAdError) {
        return new o<>(vAdError);
    }

    public static <T> o<T> c(T t, b.a aVar) {
        return new o<>(t, aVar);
    }

    public o a(long j) {
        this.f66683e = j;
        return this;
    }

    @Nullable
    public Object d(String str) {
        Map<String, Object> map;
        if (TextUtils.isEmpty(str) || (map = this.f66685g) == null) {
            return null;
        }
        return map.get(str);
    }

    public String e(String str, @Nullable String str2) {
        Map<String, String> map;
        String str3;
        b.a aVar = this.f66680b;
        return (aVar == null || (map = aVar.f66710h) == null || (str3 = map.get(str)) == null) ? str2 : str3;
    }

    public boolean f() {
        return this.f66681c == null;
    }

    public o g(long j) {
        this.f66684f = j;
        return this;
    }

    public o(VAdError vAdError) {
        this.f66682d = false;
        this.f66683e = 0L;
        this.f66684f = 0L;
        this.f66686h = 0L;
        this.f66679a = null;
        this.f66680b = null;
        this.f66681c = vAdError;
        if (0 != 0 || vAdError == null) {
            return;
        }
        k kVar = vAdError.networkResponse;
        if (kVar != null) {
            this.f66686h = kVar.f66663a;
        } else {
            this.f66686h = vAdError.getErrorCode();
        }
        com.bytedance.sdk.adnet.d.d.c("Response", "Response error code = " + this.f66686h);
    }
}
