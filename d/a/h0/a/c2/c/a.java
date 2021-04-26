package d.a.h0.a.c2.c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d.a.h0.a.c2.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0606a {

        /* renamed from: a  reason: collision with root package name */
        public int f41789a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f41790b;
    }

    @Nullable
    public static C0606a a(@NonNull Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return null;
        }
        C0606a c0606a = new C0606a();
        c0606a.f41789a = registerReceiver.getIntExtra("level", -1);
        c0606a.f41790b = registerReceiver.getIntExtra("plugged", 0) != 0;
        return c0606a;
    }
}
