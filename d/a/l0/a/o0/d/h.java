package d.a.l0.a.o0.d;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
/* loaded from: classes3.dex */
public class h extends a {

    /* renamed from: c  reason: collision with root package name */
    public final String f47602c;

    /* renamed from: d  reason: collision with root package name */
    public final String f47603d;

    public h(@Nullable String str, @Nullable String str2) {
        this.f47602c = str;
        this.f47603d = str2;
        this.f47581a = "firstMeaningfulPainted";
    }

    @Override // d.a.l0.a.o0.d.a
    public String f(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(d.a.l0.a.o0.a.c(str, PrefetchEvent.EVENT_DATA_WEBVIEW_ID, TextUtils.isEmpty(this.f47602c) ? "" : this.f47602c));
        sb.append(d.a.l0.a.o0.a.c(str, "pageUrl", TextUtils.isEmpty(this.f47603d) ? "" : this.f47603d));
        return sb.toString();
    }
}
