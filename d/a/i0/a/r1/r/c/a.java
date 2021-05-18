package d.a.i0.a.r1.r.c;

import androidx.annotation.AnyThread;
import androidx.annotation.UiThread;
/* loaded from: classes3.dex */
public interface a {
    @UiThread
    void a(String str);

    @UiThread
    void b();

    @UiThread
    void c(boolean z);

    @AnyThread
    void d(String str);

    String getName();
}
