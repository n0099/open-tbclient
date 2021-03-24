package d.b.h0.e0;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<b> f50162a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public Context f50163b;

    public d(Context context) {
        this.f50163b = context;
    }

    public void a(b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        Iterator<b> it = this.f50162a.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && next.getFragmentTabStructure() != null && next.getFragmentTabStructure().f50158e == bVar.getFragmentTabStructure().f50158e) {
                return;
            }
        }
        this.f50162a.add(bVar);
    }

    public Context b() {
        return this.f50163b;
    }

    public ArrayList<b> c() {
        return this.f50162a;
    }
}
