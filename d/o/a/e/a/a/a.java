package d.o.a.e.a.a;

import android.content.Context;
import android.util.Log;
/* loaded from: classes7.dex */
public abstract class a implements e {

    /* renamed from: a  reason: collision with root package name */
    public final Context f66789a;

    /* renamed from: b  reason: collision with root package name */
    public final d.o.a.e.b.j.a f66790b;

    /* renamed from: c  reason: collision with root package name */
    public final String f66791c;

    public a(Context context, d.o.a.e.b.j.a aVar, String str) {
        this.f66789a = context;
        this.f66790b = aVar;
        this.f66791c = str;
    }

    public boolean a() {
        if (this.f66789a == null) {
            return false;
        }
        try {
        } catch (Throwable th) {
            if (d.o.a.e.b.c.a.e()) {
                Log.e("AbsDevicePlan", "check is valid failed!", th);
            }
        }
        return b().resolveActivity(this.f66789a.getPackageManager()) != null;
    }
}
