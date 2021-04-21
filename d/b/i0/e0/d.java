package d.b.i0.e0;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<b> f50892a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public Context f50893b;

    public d(Context context) {
        this.f50893b = context;
    }

    public void a(b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        Iterator<b> it = this.f50892a.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && next.getFragmentTabStructure() != null && next.getFragmentTabStructure().f50888e == bVar.getFragmentTabStructure().f50888e) {
                return;
            }
        }
        this.f50892a.add(bVar);
    }

    public Context b() {
        return this.f50893b;
    }

    public ArrayList<b> c() {
        return this.f50892a;
    }
}
