package d.a.m0.e0;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<b> f49343a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public Context f49344b;

    public d(Context context) {
        this.f49344b = context;
    }

    public void a(b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        Iterator<b> it = this.f49343a.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && next.getFragmentTabStructure() != null && next.getFragmentTabStructure().f49338e == bVar.getFragmentTabStructure().f49338e) {
                return;
            }
        }
        this.f49343a.add(bVar);
    }

    public Context b() {
        return this.f49344b;
    }

    public ArrayList<b> c() {
        return this.f49343a;
    }
}
