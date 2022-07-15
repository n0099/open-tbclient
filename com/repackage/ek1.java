package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public interface ek1 {

    /* loaded from: classes6.dex */
    public interface a {
        void onFinish();
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(boolean z);

        void b(Exception exc);
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(boolean z);

        void b();
    }

    void a(a aVar);

    void b(Activity activity, Bundle bundle, tg1 tg1Var);

    void c(vg1 vg1Var);

    String d(@NonNull Context context);

    boolean e(Context context);

    String f(@NonNull Context context);

    void g(c cVar);

    String h(Context context);

    String i(@NonNull Context context);

    void j(tg1 tg1Var);
}
