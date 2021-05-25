package d.a.l0.a.p.d;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
/* loaded from: classes2.dex */
public interface n {

    /* loaded from: classes2.dex */
    public interface a {
        void onFinish();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(boolean z);

        void b(Exception exc);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(boolean z);

        void b();
    }

    void a(a aVar);

    void b(Activity activity, Bundle bundle, d.a.l0.a.m.a aVar);

    void c(d.a.l0.a.m.c cVar);

    String d(@NonNull Context context);

    boolean e(Context context);

    String f(@NonNull Context context);

    void g(c cVar);

    String h(Context context);

    String i(@NonNull Context context);

    void j(d.a.l0.a.m.a aVar);
}
