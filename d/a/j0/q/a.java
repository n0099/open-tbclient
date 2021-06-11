package d.a.j0.q;

import android.database.ContentObserver;
/* loaded from: classes2.dex */
public class a extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public c f44180a;

    public a(c cVar) {
        super(null);
        this.f44180a = cVar;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        c cVar = this.f44180a;
        if (cVar != null) {
            cVar.f44183b = cVar.f44182a.a(0, null);
        }
    }
}
