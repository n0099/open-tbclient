package d.a.i0.a.o0.d;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
/* loaded from: classes2.dex */
public class h extends a {

    /* renamed from: c  reason: collision with root package name */
    public final String f43752c;

    /* renamed from: d  reason: collision with root package name */
    public final String f43753d;

    public h(@Nullable String str, @Nullable String str2) {
        this.f43752c = str;
        this.f43753d = str2;
        this.f43731a = "firstMeaningfulPainted";
    }

    @Override // d.a.i0.a.o0.d.a
    public String f(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(d.a.i0.a.o0.a.c(str, PrefetchEvent.EVENT_DATA_WEBVIEW_ID, TextUtils.isEmpty(this.f43752c) ? "" : this.f43752c));
        sb.append(d.a.i0.a.o0.a.c(str, "pageUrl", TextUtils.isEmpty(this.f43753d) ? "" : this.f43753d));
        return sb.toString();
    }
}
