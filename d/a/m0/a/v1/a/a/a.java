package d.a.m0.a.v1.a.a;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.m0.a.k;
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f49050e = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public int f49052b;

    /* renamed from: a  reason: collision with root package name */
    public Bundle f49051a = new Bundle();

    /* renamed from: c  reason: collision with root package name */
    public String f49053c = "";

    /* renamed from: d  reason: collision with root package name */
    public Bundle f49054d = new Bundle();

    public abstract void b(@NonNull Bundle bundle);

    public void c() {
        d(this.f49054d);
    }

    public void d(@Nullable Bundle bundle) {
        if (f49050e) {
            Log.d("MDelegate-Delegation", "messenger delegation finish");
        }
        if (d.a.m0.a.v1.a.b.d.a.a(this.f49053c)) {
            return;
        }
        if (f49050e) {
            Log.d("MDelegate-Delegation", "messenger delegation finish with send result to client: " + this.f49052b + " observer: " + this.f49053c);
        }
        b.c(this.f49052b, this.f49053c, bundle);
    }
}
