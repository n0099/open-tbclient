package d.b.h0.a.n1.a.a;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.b.h0.a.k;
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f46057e = k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public int f46059b;

    /* renamed from: a  reason: collision with root package name */
    public Bundle f46058a = new Bundle();

    /* renamed from: c  reason: collision with root package name */
    public String f46060c = "";

    /* renamed from: d  reason: collision with root package name */
    public Bundle f46061d = new Bundle();

    public abstract void b(@NonNull Bundle bundle);

    public void c() {
        d(this.f46061d);
    }

    public void d(@Nullable Bundle bundle) {
        if (f46057e) {
            Log.d("MDelegate-Delegation", "messenger delegation finish");
        }
        if (d.b.h0.a.n1.a.b.d.a.a(this.f46060c)) {
            return;
        }
        if (f46057e) {
            Log.d("MDelegate-Delegation", "messenger delegation finish with send result to client: " + this.f46059b + " observer: " + this.f46060c);
        }
        b.c(this.f46059b, this.f46060c, bundle);
    }
}
