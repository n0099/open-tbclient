package d.b.h0.a.c2.c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d.b.h0.a.c2.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0667a {

        /* renamed from: a  reason: collision with root package name */
        public int f44497a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f44498b;
    }

    @Nullable
    public static C0667a a(@NonNull Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return null;
        }
        C0667a c0667a = new C0667a();
        c0667a.f44497a = registerReceiver.getIntExtra("level", -1);
        c0667a.f44498b = registerReceiver.getIntExtra("plugged", 0) != 0;
        return c0667a;
    }
}
