package d.a.i0.e0;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<b> f48471a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public Context f48472b;

    public d(Context context) {
        this.f48472b = context;
    }

    public void a(b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        Iterator<b> it = this.f48471a.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && next.getFragmentTabStructure() != null && next.getFragmentTabStructure().f48466e == bVar.getFragmentTabStructure().f48466e) {
                return;
            }
        }
        this.f48471a.add(bVar);
    }

    public Context b() {
        return this.f48472b;
    }

    public ArrayList<b> c() {
        return this.f48471a;
    }
}
