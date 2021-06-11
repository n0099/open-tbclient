package d.a.l0.a.v1.a.a;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.l0.a.k;
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f48942e = k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public int f48944b;

    /* renamed from: a  reason: collision with root package name */
    public Bundle f48943a = new Bundle();

    /* renamed from: c  reason: collision with root package name */
    public String f48945c = "";

    /* renamed from: d  reason: collision with root package name */
    public Bundle f48946d = new Bundle();

    public abstract void b(@NonNull Bundle bundle);

    public void c() {
        d(this.f48946d);
    }

    public void d(@Nullable Bundle bundle) {
        if (f48942e) {
            Log.d("MDelegate-Delegation", "messenger delegation finish");
        }
        if (d.a.l0.a.v1.a.b.d.a.a(this.f48945c)) {
            return;
        }
        if (f48942e) {
            Log.d("MDelegate-Delegation", "messenger delegation finish with send result to client: " + this.f48944b + " observer: " + this.f48945c);
        }
        b.c(this.f48944b, this.f48945c, bundle);
    }
}
