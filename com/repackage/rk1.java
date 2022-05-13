package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
/* loaded from: classes7.dex */
public interface rk1 {

    /* loaded from: classes7.dex */
    public interface a {
        void onFinish();
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(boolean z);

        void b(Exception exc);
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(boolean z);

        void b();
    }

    void a(a aVar);

    void b(Activity activity, Bundle bundle, gh1 gh1Var);

    void c(ih1 ih1Var);

    String d(@NonNull Context context);

    boolean e(Context context);

    String f(@NonNull Context context);

    void g(c cVar);

    String h(Context context);

    String i(@NonNull Context context);

    void j(gh1 gh1Var);
}
