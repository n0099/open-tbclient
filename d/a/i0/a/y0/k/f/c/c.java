package d.a.i0.a.y0.k.f.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import kotlinx.coroutines.DebugKt;
/* loaded from: classes3.dex */
public class c extends a {

    /* renamed from: b  reason: collision with root package name */
    public String f45722b;

    public c(String str) {
        super(str);
    }

    @Override // d.a.i0.a.y0.k.f.c.f, d.a.i0.a.y0.k.f.c.e
    public void a(String str, String str2) {
        if (e(str)) {
            boolean equals = TextUtils.equals(str2, DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
            boolean equals2 = TextUtils.equals(str2, RetrieveTaskManager.KEY);
            this.f45720a.g("autoPlay", equals ? "1" : "0");
            this.f45720a.g("playMethod", equals2 ? "1" : "0");
        }
    }

    @Override // d.a.i0.a.y0.k.f.c.f, d.a.i0.a.y0.k.f.c.e
    public void c() {
        if (this.f45720a.d("video_will_play")) {
            this.f45720a.h("video_play_cancel");
        }
        d();
    }

    public final boolean e(String str) {
        return TextUtils.equals(this.f45722b, str);
    }
}
