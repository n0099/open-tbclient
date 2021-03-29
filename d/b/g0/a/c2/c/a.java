package d.b.g0.a.c2.c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d.b.g0.a.c2.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0635a {

        /* renamed from: a  reason: collision with root package name */
        public int f43776a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f43777b;
    }

    @Nullable
    public static C0635a a(@NonNull Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return null;
        }
        C0635a c0635a = new C0635a();
        c0635a.f43776a = registerReceiver.getIntExtra("level", -1);
        c0635a.f43777b = registerReceiver.getIntExtra("plugged", 0) != 0;
        return c0635a;
    }
}
