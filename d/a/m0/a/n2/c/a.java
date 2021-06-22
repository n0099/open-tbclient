package d.a.m0.a.n2.c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d.a.m0.a.n2.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0829a {

        /* renamed from: a  reason: collision with root package name */
        public int f47576a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f47577b;
    }

    @Nullable
    public static C0829a a(@NonNull Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return null;
        }
        C0829a c0829a = new C0829a();
        c0829a.f47576a = registerReceiver.getIntExtra("level", -1);
        c0829a.f47577b = registerReceiver.getIntExtra("plugged", 0) != 0;
        return c0829a;
    }
}
