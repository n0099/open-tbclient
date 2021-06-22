package d.a.n0.e0;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<b> f53124a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public Context f53125b;

    public d(Context context) {
        this.f53125b = context;
    }

    public void a(b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        Iterator<b> it = this.f53124a.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && next.getFragmentTabStructure() != null && next.getFragmentTabStructure().f53119e == bVar.getFragmentTabStructure().f53119e) {
                return;
            }
        }
        this.f53124a.add(bVar);
    }

    public Context b() {
        return this.f53125b;
    }

    public ArrayList<b> c() {
        return this.f53124a;
    }
}
