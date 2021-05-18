package d.a.i0.a.n2.c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d.a.i0.a.n2.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0759a {

        /* renamed from: a  reason: collision with root package name */
        public int f43618a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f43619b;
    }

    @Nullable
    public static C0759a a(@NonNull Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return null;
        }
        C0759a c0759a = new C0759a();
        c0759a.f43618a = registerReceiver.getIntExtra("level", -1);
        c0759a.f43619b = registerReceiver.getIntExtra("plugged", 0) != 0;
        return c0759a;
    }
}
