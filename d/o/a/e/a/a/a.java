package d.o.a.e.a.a;

import android.content.Context;
import android.util.Log;
/* loaded from: classes6.dex */
public abstract class a implements e {

    /* renamed from: a  reason: collision with root package name */
    public final Context f67782a;

    /* renamed from: b  reason: collision with root package name */
    public final d.o.a.e.b.j.a f67783b;

    /* renamed from: c  reason: collision with root package name */
    public final String f67784c;

    public a(Context context, d.o.a.e.b.j.a aVar, String str) {
        this.f67782a = context;
        this.f67783b = aVar;
        this.f67784c = str;
    }

    public boolean a() {
        if (this.f67782a == null) {
            return false;
        }
        try {
        } catch (Throwable th) {
            if (d.o.a.e.b.c.a.e()) {
                Log.e("AbsDevicePlan", "check is valid failed!", th);
            }
        }
        return b().resolveActivity(this.f67782a.getPackageManager()) != null;
    }
}
