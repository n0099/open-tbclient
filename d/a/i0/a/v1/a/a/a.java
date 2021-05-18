package d.a.i0.a.v1.a.a;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.i0.a.k;
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f45092e = k.f43025a;

    /* renamed from: b  reason: collision with root package name */
    public int f45094b;

    /* renamed from: a  reason: collision with root package name */
    public Bundle f45093a = new Bundle();

    /* renamed from: c  reason: collision with root package name */
    public String f45095c = "";

    /* renamed from: d  reason: collision with root package name */
    public Bundle f45096d = new Bundle();

    public abstract void b(@NonNull Bundle bundle);

    public void c() {
        d(this.f45096d);
    }

    public void d(@Nullable Bundle bundle) {
        if (f45092e) {
            Log.d("MDelegate-Delegation", "messenger delegation finish");
        }
        if (d.a.i0.a.v1.a.b.d.a.a(this.f45095c)) {
            return;
        }
        if (f45092e) {
            Log.d("MDelegate-Delegation", "messenger delegation finish with send result to client: " + this.f45094b + " observer: " + this.f45095c);
        }
        b.c(this.f45094b, this.f45095c, bundle);
    }
}
