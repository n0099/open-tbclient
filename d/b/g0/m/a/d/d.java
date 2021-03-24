package d.b.g0.m.a.d;

import android.view.LayoutInflater;
import d.b.g0.m.a.d.c;
/* loaded from: classes3.dex */
public class d {
    public static void a(LayoutInflater layoutInflater, e eVar) {
        layoutInflater.setFactory2(eVar != null ? new c.a(eVar) : null);
    }
}
