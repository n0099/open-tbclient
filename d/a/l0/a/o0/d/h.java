package d.a.l0.a.o0.d;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
/* loaded from: classes2.dex */
public class h extends a {

    /* renamed from: c  reason: collision with root package name */
    public final String f43926c;

    /* renamed from: d  reason: collision with root package name */
    public final String f43927d;

    public h(@Nullable String str, @Nullable String str2) {
        this.f43926c = str;
        this.f43927d = str2;
        this.f43905a = "firstMeaningfulPainted";
    }

    @Override // d.a.l0.a.o0.d.a
    public String f(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(d.a.l0.a.o0.a.c(str, PrefetchEvent.EVENT_DATA_WEBVIEW_ID, TextUtils.isEmpty(this.f43926c) ? "" : this.f43926c));
        sb.append(d.a.l0.a.o0.a.c(str, "pageUrl", TextUtils.isEmpty(this.f43927d) ? "" : this.f43927d));
        return sb.toString();
    }
}
