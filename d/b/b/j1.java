package d.b.b;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
/* loaded from: classes6.dex */
public final class j1 {

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f65055a;

    @WorkerThread
    public j1(Context context) {
        this.f65055a = context.getSharedPreferences("device_register_oaid_refine", 0);
    }

    @Nullable
    @WorkerThread
    public i1 a() {
        return i1.a(this.f65055a.getString("oaid", ""));
    }

    @WorkerThread
    public void b(@Nullable i1 i1Var) {
        if (i1Var == null) {
            return;
        }
        this.f65055a.edit().putString("oaid", i1Var.c().toString()).apply();
    }
}
