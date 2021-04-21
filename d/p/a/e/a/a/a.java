package d.p.a.e.a.a;

import android.content.Context;
import android.util.Log;
/* loaded from: classes6.dex */
public abstract class a implements e {

    /* renamed from: a  reason: collision with root package name */
    public final Context f67929a;

    /* renamed from: b  reason: collision with root package name */
    public final d.p.a.e.b.j.a f67930b;

    /* renamed from: c  reason: collision with root package name */
    public final String f67931c;

    public a(Context context, d.p.a.e.b.j.a aVar, String str) {
        this.f67929a = context;
        this.f67930b = aVar;
        this.f67931c = str;
    }

    public boolean a() {
        if (this.f67929a == null) {
            return false;
        }
        try {
        } catch (Throwable th) {
            if (d.p.a.e.b.c.a.e()) {
                Log.e("AbsDevicePlan", "check is valid failed!", th);
            }
        }
        return b().resolveActivity(this.f67929a.getPackageManager()) != null;
    }
}
