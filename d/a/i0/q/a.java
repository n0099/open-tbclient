package d.a.i0.q;

import android.content.Context;
import d.a.i0.e0.b;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<b> f48759a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public Context f48760b;

    public a(Context context) {
        this.f48760b = context;
    }

    public void a(b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        Iterator<b> it = this.f48759a.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && next.getFragmentTabStructure() != null && next.getFragmentTabStructure().f48466e == bVar.getFragmentTabStructure().f48466e) {
                return;
            }
        }
        this.f48759a.add(bVar);
    }

    public Context b() {
        return this.f48760b;
    }

    public ArrayList<b> c() {
        return this.f48759a;
    }
}
