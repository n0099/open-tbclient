package d.c.c.b.d;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.adnet.err.VAdError;
import d.c.c.b.f.b;
import java.util.Map;
/* loaded from: classes5.dex */
public class o<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f65738a;

    /* renamed from: b  reason: collision with root package name */
    public final b.a f65739b;

    /* renamed from: c  reason: collision with root package name */
    public final VAdError f65740c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f65741d;

    /* renamed from: e  reason: collision with root package name */
    public long f65742e;

    /* renamed from: f  reason: collision with root package name */
    public long f65743f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, Object> f65744g;

    /* renamed from: h  reason: collision with root package name */
    public long f65745h;

    /* loaded from: classes5.dex */
    public interface a<T> {
        void a(o<T> oVar);

        void b(o<T> oVar);
    }

    public o(T t, b.a aVar) {
        this.f65741d = false;
        this.f65742e = 0L;
        this.f65743f = 0L;
        this.f65745h = 0L;
        this.f65738a = t;
        this.f65739b = aVar;
        this.f65740c = null;
        if (aVar != null) {
            this.f65745h = aVar.f65762a;
        }
    }

    public static <T> o<T> b(VAdError vAdError) {
        return new o<>(vAdError);
    }

    public static <T> o<T> c(T t, b.a aVar) {
        return new o<>(t, aVar);
    }

    public o a(long j) {
        this.f65742e = j;
        return this;
    }

    @Nullable
    public Object d(String str) {
        Map<String, Object> map;
        if (TextUtils.isEmpty(str) || (map = this.f65744g) == null) {
            return null;
        }
        return map.get(str);
    }

    public String e(String str, @Nullable String str2) {
        Map<String, String> map;
        String str3;
        b.a aVar = this.f65739b;
        return (aVar == null || (map = aVar.f65769h) == null || (str3 = map.get(str)) == null) ? str2 : str3;
    }

    public boolean f() {
        return this.f65740c == null;
    }

    public o g(long j) {
        this.f65743f = j;
        return this;
    }

    public o(VAdError vAdError) {
        this.f65741d = false;
        this.f65742e = 0L;
        this.f65743f = 0L;
        this.f65745h = 0L;
        this.f65738a = null;
        this.f65739b = null;
        this.f65740c = vAdError;
        if (0 != 0 || vAdError == null) {
            return;
        }
        k kVar = vAdError.networkResponse;
        if (kVar != null) {
            this.f65745h = kVar.f65722a;
        } else {
            this.f65745h = vAdError.getErrorCode();
        }
        com.bytedance.sdk.adnet.d.d.c("Response", "Response error code = " + this.f65745h);
    }
}
