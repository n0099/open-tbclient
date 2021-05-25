package d.b.c.b.d;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.adnet.err.VAdError;
import d.b.c.b.f.b;
import java.util.Map;
/* loaded from: classes6.dex */
public class o<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f65809a;

    /* renamed from: b  reason: collision with root package name */
    public final b.a f65810b;

    /* renamed from: c  reason: collision with root package name */
    public final VAdError f65811c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f65812d;

    /* renamed from: e  reason: collision with root package name */
    public long f65813e;

    /* renamed from: f  reason: collision with root package name */
    public long f65814f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, Object> f65815g;

    /* renamed from: h  reason: collision with root package name */
    public long f65816h;

    /* loaded from: classes6.dex */
    public interface a<T> {
        void a(o<T> oVar);

        void b(o<T> oVar);
    }

    public o(T t, b.a aVar) {
        this.f65812d = false;
        this.f65813e = 0L;
        this.f65814f = 0L;
        this.f65816h = 0L;
        this.f65809a = t;
        this.f65810b = aVar;
        this.f65811c = null;
        if (aVar != null) {
            this.f65816h = aVar.f65833a;
        }
    }

    public static <T> o<T> b(VAdError vAdError) {
        return new o<>(vAdError);
    }

    public static <T> o<T> c(T t, b.a aVar) {
        return new o<>(t, aVar);
    }

    public o a(long j) {
        this.f65813e = j;
        return this;
    }

    @Nullable
    public Object d(String str) {
        Map<String, Object> map;
        if (TextUtils.isEmpty(str) || (map = this.f65815g) == null) {
            return null;
        }
        return map.get(str);
    }

    public String e(String str, @Nullable String str2) {
        Map<String, String> map;
        String str3;
        b.a aVar = this.f65810b;
        return (aVar == null || (map = aVar.f65840h) == null || (str3 = map.get(str)) == null) ? str2 : str3;
    }

    public boolean f() {
        return this.f65811c == null;
    }

    public o g(long j) {
        this.f65814f = j;
        return this;
    }

    public o(VAdError vAdError) {
        this.f65812d = false;
        this.f65813e = 0L;
        this.f65814f = 0L;
        this.f65816h = 0L;
        this.f65809a = null;
        this.f65810b = null;
        this.f65811c = vAdError;
        if (0 != 0 || vAdError == null) {
            return;
        }
        k kVar = vAdError.networkResponse;
        if (kVar != null) {
            this.f65816h = kVar.f65792a;
        } else {
            this.f65816h = vAdError.getErrorCode();
        }
        com.bytedance.sdk.adnet.d.d.c("Response", "Response error code = " + this.f65816h);
    }
}
