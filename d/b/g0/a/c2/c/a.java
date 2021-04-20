package d.b.g0.a.c2.c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d.b.g0.a.c2.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0647a {

        /* renamed from: a  reason: collision with root package name */
        public int f44168a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f44169b;
    }

    @Nullable
    public static C0647a a(@NonNull Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return null;
        }
        C0647a c0647a = new C0647a();
        c0647a.f44168a = registerReceiver.getIntExtra("level", -1);
        c0647a.f44169b = registerReceiver.getIntExtra("plugged", 0) != 0;
        return c0647a;
    }
}
