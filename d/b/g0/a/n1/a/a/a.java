package d.b.g0.a.n1.a.a;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.b.g0.a.k;
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f45728e = k.f45443a;

    /* renamed from: b  reason: collision with root package name */
    public int f45730b;

    /* renamed from: a  reason: collision with root package name */
    public Bundle f45729a = new Bundle();

    /* renamed from: c  reason: collision with root package name */
    public String f45731c = "";

    /* renamed from: d  reason: collision with root package name */
    public Bundle f45732d = new Bundle();

    public abstract void b(@NonNull Bundle bundle);

    public void c() {
        d(this.f45732d);
    }

    public void d(@Nullable Bundle bundle) {
        if (f45728e) {
            Log.d("MDelegate-Delegation", "messenger delegation finish");
        }
        if (d.b.g0.a.n1.a.b.d.a.a(this.f45731c)) {
            return;
        }
        if (f45728e) {
            Log.d("MDelegate-Delegation", "messenger delegation finish with send result to client: " + this.f45730b + " observer: " + this.f45731c);
        }
        b.c(this.f45730b, this.f45731c, bundle);
    }
}
