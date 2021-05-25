package d.a.l0.a.n2.c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d.a.l0.a.n2.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0770a {

        /* renamed from: a  reason: collision with root package name */
        public int f43792a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f43793b;
    }

    @Nullable
    public static C0770a a(@NonNull Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return null;
        }
        C0770a c0770a = new C0770a();
        c0770a.f43792a = registerReceiver.getIntExtra("level", -1);
        c0770a.f43793b = registerReceiver.getIntExtra("plugged", 0) != 0;
        return c0770a;
    }
}
