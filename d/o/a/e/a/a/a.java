package d.o.a.e.a.a;

import android.content.Context;
import android.util.Log;
/* loaded from: classes7.dex */
public abstract class a implements e {

    /* renamed from: a  reason: collision with root package name */
    public final Context f70899a;

    /* renamed from: b  reason: collision with root package name */
    public final d.o.a.e.b.j.a f70900b;

    /* renamed from: c  reason: collision with root package name */
    public final String f70901c;

    public a(Context context, d.o.a.e.b.j.a aVar, String str) {
        this.f70899a = context;
        this.f70900b = aVar;
        this.f70901c = str;
    }

    public boolean a() {
        if (this.f70899a == null) {
            return false;
        }
        try {
        } catch (Throwable th) {
            if (d.o.a.e.b.c.a.e()) {
                Log.e("AbsDevicePlan", "check is valid failed!", th);
            }
        }
        return b().resolveActivity(this.f70899a.getPackageManager()) != null;
    }
}
