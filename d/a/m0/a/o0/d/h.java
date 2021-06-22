package d.a.m0.a.o0.d;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
/* loaded from: classes3.dex */
public class h extends a {

    /* renamed from: c  reason: collision with root package name */
    public final String f47710c;

    /* renamed from: d  reason: collision with root package name */
    public final String f47711d;

    public h(@Nullable String str, @Nullable String str2) {
        this.f47710c = str;
        this.f47711d = str2;
        this.f47689a = "firstMeaningfulPainted";
    }

    @Override // d.a.m0.a.o0.d.a
    public String f(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(d.a.m0.a.o0.a.c(str, PrefetchEvent.EVENT_DATA_WEBVIEW_ID, TextUtils.isEmpty(this.f47710c) ? "" : this.f47710c));
        sb.append(d.a.m0.a.o0.a.c(str, "pageUrl", TextUtils.isEmpty(this.f47711d) ? "" : this.f47711d));
        return sb.toString();
    }
}
