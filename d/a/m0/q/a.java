package d.a.m0.q;

import android.content.Context;
import d.a.m0.e0.b;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<b> f49632a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public Context f49633b;

    public a(Context context) {
        this.f49633b = context;
    }

    public void a(b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        Iterator<b> it = this.f49632a.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && next.getFragmentTabStructure() != null && next.getFragmentTabStructure().f49338e == bVar.getFragmentTabStructure().f49338e) {
                return;
            }
        }
        this.f49632a.add(bVar);
    }

    public Context b() {
        return this.f49633b;
    }

    public ArrayList<b> c() {
        return this.f49632a;
    }
}
