package d.b.i0.q;

import android.content.Context;
import d.b.i0.e0.b;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<b> f51154a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public Context f51155b;

    public a(Context context) {
        this.f51155b = context;
    }

    public void a(b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        Iterator<b> it = this.f51154a.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && next.getFragmentTabStructure() != null && next.getFragmentTabStructure().f50888e == bVar.getFragmentTabStructure().f50888e) {
                return;
            }
        }
        this.f51154a.add(bVar);
    }

    public Context b() {
        return this.f51155b;
    }

    public ArrayList<b> c() {
        return this.f51154a;
    }
}
