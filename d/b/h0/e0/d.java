package d.b.h0.e0;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<b> f50556a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public Context f50557b;

    public d(Context context) {
        this.f50557b = context;
    }

    public void a(b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        Iterator<b> it = this.f50556a.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && next.getFragmentTabStructure() != null && next.getFragmentTabStructure().f50552e == bVar.getFragmentTabStructure().f50552e) {
                return;
            }
        }
        this.f50556a.add(bVar);
    }

    public Context b() {
        return this.f50557b;
    }

    public ArrayList<b> c() {
        return this.f50556a;
    }
}
