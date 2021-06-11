package d.b.c.b.d;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.adnet.err.VAdError;
import d.b.c.b.f.b;
import java.util.Map;
/* loaded from: classes6.dex */
public class o<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f69540a;

    /* renamed from: b  reason: collision with root package name */
    public final b.a f69541b;

    /* renamed from: c  reason: collision with root package name */
    public final VAdError f69542c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f69543d;

    /* renamed from: e  reason: collision with root package name */
    public long f69544e;

    /* renamed from: f  reason: collision with root package name */
    public long f69545f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, Object> f69546g;

    /* renamed from: h  reason: collision with root package name */
    public long f69547h;

    /* loaded from: classes6.dex */
    public interface a<T> {
        void a(o<T> oVar);

        void b(o<T> oVar);
    }

    public o(T t, b.a aVar) {
        this.f69543d = false;
        this.f69544e = 0L;
        this.f69545f = 0L;
        this.f69547h = 0L;
        this.f69540a = t;
        this.f69541b = aVar;
        this.f69542c = null;
        if (aVar != null) {
            this.f69547h = aVar.f69564a;
        }
    }

    public static <T> o<T> b(VAdError vAdError) {
        return new o<>(vAdError);
    }

    public static <T> o<T> c(T t, b.a aVar) {
        return new o<>(t, aVar);
    }

    public o a(long j) {
        this.f69544e = j;
        return this;
    }

    @Nullable
    public Object d(String str) {
        Map<String, Object> map;
        if (TextUtils.isEmpty(str) || (map = this.f69546g) == null) {
            return null;
        }
        return map.get(str);
    }

    public String e(String str, @Nullable String str2) {
        Map<String, String> map;
        String str3;
        b.a aVar = this.f69541b;
        return (aVar == null || (map = aVar.f69571h) == null || (str3 = map.get(str)) == null) ? str2 : str3;
    }

    public boolean f() {
        return this.f69542c == null;
    }

    public o g(long j) {
        this.f69545f = j;
        return this;
    }

    public o(VAdError vAdError) {
        this.f69543d = false;
        this.f69544e = 0L;
        this.f69545f = 0L;
        this.f69547h = 0L;
        this.f69540a = null;
        this.f69541b = null;
        this.f69542c = vAdError;
        if (0 != 0 || vAdError == null) {
            return;
        }
        k kVar = vAdError.networkResponse;
        if (kVar != null) {
            this.f69547h = kVar.f69523a;
        } else {
            this.f69547h = vAdError.getErrorCode();
        }
        com.bytedance.sdk.adnet.d.d.c("Response", "Response error code = " + this.f69547h);
    }
}
