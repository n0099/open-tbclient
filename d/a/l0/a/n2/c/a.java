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
    public static class C0826a {

        /* renamed from: a  reason: collision with root package name */
        public int f47468a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f47469b;
    }

    @Nullable
    public static C0826a a(@NonNull Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return null;
        }
        C0826a c0826a = new C0826a();
        c0826a.f47468a = registerReceiver.getIntExtra("level", -1);
        c0826a.f47469b = registerReceiver.getIntExtra("plugged", 0) != 0;
        return c0826a;
    }
}
