package d.o.a.e.a.a;

import android.content.Context;
import android.util.Log;
/* loaded from: classes7.dex */
public abstract class a implements e {

    /* renamed from: a  reason: collision with root package name */
    public final Context f70795a;

    /* renamed from: b  reason: collision with root package name */
    public final d.o.a.e.b.j.a f70796b;

    /* renamed from: c  reason: collision with root package name */
    public final String f70797c;

    public a(Context context, d.o.a.e.b.j.a aVar, String str) {
        this.f70795a = context;
        this.f70796b = aVar;
        this.f70797c = str;
    }

    public boolean a() {
        if (this.f70795a == null) {
            return false;
        }
        try {
        } catch (Throwable th) {
            if (d.o.a.e.b.c.a.e()) {
                Log.e("AbsDevicePlan", "check is valid failed!", th);
            }
        }
        return b().resolveActivity(this.f70795a.getPackageManager()) != null;
    }
}
