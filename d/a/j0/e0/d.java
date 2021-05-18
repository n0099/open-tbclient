package d.a.j0.e0;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<b> f49299a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public Context f49300b;

    public d(Context context) {
        this.f49300b = context;
    }

    public void a(b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        Iterator<b> it = this.f49299a.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && next.getFragmentTabStructure() != null && next.getFragmentTabStructure().f49294e == bVar.getFragmentTabStructure().f49294e) {
                return;
            }
        }
        this.f49299a.add(bVar);
    }

    public Context b() {
        return this.f49300b;
    }

    public ArrayList<b> c() {
        return this.f49299a;
    }
}
