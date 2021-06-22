package d.b.c.b.d;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.adnet.err.VAdError;
import d.b.c.b.f.b;
import java.util.Map;
/* loaded from: classes6.dex */
public class o<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f69644a;

    /* renamed from: b  reason: collision with root package name */
    public final b.a f69645b;

    /* renamed from: c  reason: collision with root package name */
    public final VAdError f69646c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f69647d;

    /* renamed from: e  reason: collision with root package name */
    public long f69648e;

    /* renamed from: f  reason: collision with root package name */
    public long f69649f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, Object> f69650g;

    /* renamed from: h  reason: collision with root package name */
    public long f69651h;

    /* loaded from: classes6.dex */
    public interface a<T> {
        void a(o<T> oVar);

        void b(o<T> oVar);
    }

    public o(T t, b.a aVar) {
        this.f69647d = false;
        this.f69648e = 0L;
        this.f69649f = 0L;
        this.f69651h = 0L;
        this.f69644a = t;
        this.f69645b = aVar;
        this.f69646c = null;
        if (aVar != null) {
            this.f69651h = aVar.f69668a;
        }
    }

    public static <T> o<T> b(VAdError vAdError) {
        return new o<>(vAdError);
    }

    public static <T> o<T> c(T t, b.a aVar) {
        return new o<>(t, aVar);
    }

    public o a(long j) {
        this.f69648e = j;
        return this;
    }

    @Nullable
    public Object d(String str) {
        Map<String, Object> map;
        if (TextUtils.isEmpty(str) || (map = this.f69650g) == null) {
            return null;
        }
        return map.get(str);
    }

    public String e(String str, @Nullable String str2) {
        Map<String, String> map;
        String str3;
        b.a aVar = this.f69645b;
        return (aVar == null || (map = aVar.f69675h) == null || (str3 = map.get(str)) == null) ? str2 : str3;
    }

    public boolean f() {
        return this.f69646c == null;
    }

    public o g(long j) {
        this.f69649f = j;
        return this;
    }

    public o(VAdError vAdError) {
        this.f69647d = false;
        this.f69648e = 0L;
        this.f69649f = 0L;
        this.f69651h = 0L;
        this.f69644a = null;
        this.f69645b = null;
        this.f69646c = vAdError;
        if (0 != 0 || vAdError == null) {
            return;
        }
        k kVar = vAdError.networkResponse;
        if (kVar != null) {
            this.f69651h = kVar.f69627a;
        } else {
            this.f69651h = vAdError.getErrorCode();
        }
        com.bytedance.sdk.adnet.d.d.c("Response", "Response error code = " + this.f69651h);
    }
}
