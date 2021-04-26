package d.a.h0.a.t.d;

import android.util.Log;
import d.a.h0.a.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f44320b = k.f43101a;

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f44321c;

    /* renamed from: a  reason: collision with root package name */
    public List<a> f44322a;

    public c() {
        ArrayList arrayList = new ArrayList();
        this.f44322a = arrayList;
        arrayList.add(new b());
    }

    public static c c() {
        if (f44321c == null) {
            synchronized (c.class) {
                if (f44321c == null) {
                    f44321c = new c();
                }
            }
        }
        return f44321c;
    }

    @Override // d.a.h0.a.t.d.a
    public void a(String str) {
        if (f44320b) {
            Log.d("Api-Marker", "markStart: " + str);
        }
        for (int i2 = 0; i2 < this.f44322a.size(); i2++) {
            this.f44322a.get(i2).a(str);
        }
    }

    @Override // d.a.h0.a.t.d.a
    public void b(String str) {
        if (f44320b) {
            Log.d("Api-Marker", "markEnd: " + str);
        }
        for (int i2 = 0; i2 < this.f44322a.size(); i2++) {
            this.f44322a.get(i2).b(str);
        }
    }

    public synchronized void d() {
        if (f44320b) {
            Log.d("Api-Marker", "release: ");
        }
        if (f44321c == null) {
            return;
        }
        f44321c = null;
    }
}
