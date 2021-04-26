package d.o.a.e.a.a;

import android.content.Context;
import android.util.Log;
/* loaded from: classes6.dex */
public abstract class a implements e {

    /* renamed from: a  reason: collision with root package name */
    public final Context f66280a;

    /* renamed from: b  reason: collision with root package name */
    public final d.o.a.e.b.j.a f66281b;

    /* renamed from: c  reason: collision with root package name */
    public final String f66282c;

    public a(Context context, d.o.a.e.b.j.a aVar, String str) {
        this.f66280a = context;
        this.f66281b = aVar;
        this.f66282c = str;
    }

    public boolean a() {
        if (this.f66280a == null) {
            return false;
        }
        try {
        } catch (Throwable th) {
            if (d.o.a.e.b.c.a.e()) {
                Log.e("AbsDevicePlan", "check is valid failed!", th);
            }
        }
        return b().resolveActivity(this.f66280a.getPackageManager()) != null;
    }
}
