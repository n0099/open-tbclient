package d.a.l0.a.v1.a.a;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.l0.a.k;
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f45268e = k.f43199a;

    /* renamed from: b  reason: collision with root package name */
    public int f45270b;

    /* renamed from: a  reason: collision with root package name */
    public Bundle f45269a = new Bundle();

    /* renamed from: c  reason: collision with root package name */
    public String f45271c = "";

    /* renamed from: d  reason: collision with root package name */
    public Bundle f45272d = new Bundle();

    public abstract void b(@NonNull Bundle bundle);

    public void c() {
        d(this.f45272d);
    }

    public void d(@Nullable Bundle bundle) {
        if (f45268e) {
            Log.d("MDelegate-Delegation", "messenger delegation finish");
        }
        if (d.a.l0.a.v1.a.b.d.a.a(this.f45271c)) {
            return;
        }
        if (f45268e) {
            Log.d("MDelegate-Delegation", "messenger delegation finish with send result to client: " + this.f45270b + " observer: " + this.f45271c);
        }
        b.c(this.f45270b, this.f45271c, bundle);
    }
}
