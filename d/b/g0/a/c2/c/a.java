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
    public static class C0634a {

        /* renamed from: a  reason: collision with root package name */
        public int f43775a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f43776b;
    }

    @Nullable
    public static C0634a a(@NonNull Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return null;
        }
        C0634a c0634a = new C0634a();
        c0634a.f43775a = registerReceiver.getIntExtra("level", -1);
        c0634a.f43776b = registerReceiver.getIntExtra("plugged", 0) != 0;
        return c0634a;
    }
}
