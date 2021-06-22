package d.a.n0.q;

import android.content.Context;
import d.a.n0.e0.b;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<b> f53414a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public Context f53415b;

    public a(Context context) {
        this.f53415b = context;
    }

    public void a(b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        Iterator<b> it = this.f53414a.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && next.getFragmentTabStructure() != null && next.getFragmentTabStructure().f53119e == bVar.getFragmentTabStructure().f53119e) {
                return;
            }
        }
        this.f53414a.add(bVar);
    }

    public Context b() {
        return this.f53415b;
    }

    public ArrayList<b> c() {
        return this.f53414a;
    }
}
