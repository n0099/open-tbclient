package d.b.h0.q;

import android.content.Context;
import d.b.h0.e0.b;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<b> f50410a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public Context f50411b;

    public a(Context context) {
        this.f50411b = context;
    }

    public void a(b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        Iterator<b> it = this.f50410a.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && next.getFragmentTabStructure() != null && next.getFragmentTabStructure().f50158e == bVar.getFragmentTabStructure().f50158e) {
                return;
            }
        }
        this.f50410a.add(bVar);
    }

    public Context b() {
        return this.f50411b;
    }

    public ArrayList<b> c() {
        return this.f50410a;
    }
}
