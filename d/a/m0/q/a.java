package d.a.m0.q;

import android.content.Context;
import d.a.m0.e0.b;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<b> f53307a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public Context f53308b;

    public a(Context context) {
        this.f53308b = context;
    }

    public void a(b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        Iterator<b> it = this.f53307a.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && next.getFragmentTabStructure() != null && next.getFragmentTabStructure().f53012e == bVar.getFragmentTabStructure().f53012e) {
                return;
            }
        }
        this.f53307a.add(bVar);
    }

    public Context b() {
        return this.f53308b;
    }

    public ArrayList<b> c() {
        return this.f53307a;
    }
}
