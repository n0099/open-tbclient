package d.o.a.e.a.a;

import android.content.Context;
import android.util.Log;
/* loaded from: classes7.dex */
public abstract class a implements e {

    /* renamed from: a  reason: collision with root package name */
    public final Context f66784a;

    /* renamed from: b  reason: collision with root package name */
    public final d.o.a.e.b.j.a f66785b;

    /* renamed from: c  reason: collision with root package name */
    public final String f66786c;

    public a(Context context, d.o.a.e.b.j.a aVar, String str) {
        this.f66784a = context;
        this.f66785b = aVar;
        this.f66786c = str;
    }

    public boolean a() {
        if (this.f66784a == null) {
            return false;
        }
        try {
        } catch (Throwable th) {
            if (d.o.a.e.b.c.a.e()) {
                Log.e("AbsDevicePlan", "check is valid failed!", th);
            }
        }
        return b().resolveActivity(this.f66784a.getPackageManager()) != null;
    }
}
