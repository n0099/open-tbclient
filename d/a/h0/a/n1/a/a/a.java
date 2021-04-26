package d.a.h0.a.n1.a.a;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.h0.a.k;
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f43400e = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public int f43402b;

    /* renamed from: a  reason: collision with root package name */
    public Bundle f43401a = new Bundle();

    /* renamed from: c  reason: collision with root package name */
    public String f43403c = "";

    /* renamed from: d  reason: collision with root package name */
    public Bundle f43404d = new Bundle();

    public abstract void b(@NonNull Bundle bundle);

    public void c() {
        d(this.f43404d);
    }

    public void d(@Nullable Bundle bundle) {
        if (f43400e) {
            Log.d("MDelegate-Delegation", "messenger delegation finish");
        }
        if (d.a.h0.a.n1.a.b.d.a.a(this.f43403c)) {
            return;
        }
        if (f43400e) {
            Log.d("MDelegate-Delegation", "messenger delegation finish with send result to client: " + this.f43402b + " observer: " + this.f43403c);
        }
        b.c(this.f43402b, this.f43403c, bundle);
    }
}
