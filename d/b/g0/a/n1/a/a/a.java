package d.b.g0.a.n1.a.a;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.b.g0.a.k;
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f45335e = k.f45050a;

    /* renamed from: b  reason: collision with root package name */
    public int f45337b;

    /* renamed from: a  reason: collision with root package name */
    public Bundle f45336a = new Bundle();

    /* renamed from: c  reason: collision with root package name */
    public String f45338c = "";

    /* renamed from: d  reason: collision with root package name */
    public Bundle f45339d = new Bundle();

    public abstract void b(@NonNull Bundle bundle);

    public void c() {
        d(this.f45339d);
    }

    public void d(@Nullable Bundle bundle) {
        if (f45335e) {
            Log.d("MDelegate-Delegation", "messenger delegation finish");
        }
        if (d.b.g0.a.n1.a.b.d.a.a(this.f45338c)) {
            return;
        }
        if (f45335e) {
            Log.d("MDelegate-Delegation", "messenger delegation finish with send result to client: " + this.f45337b + " observer: " + this.f45338c);
        }
        b.c(this.f45337b, this.f45338c, bundle);
    }
}
