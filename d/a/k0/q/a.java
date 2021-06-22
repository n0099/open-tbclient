package d.a.k0.q;

import android.database.ContentObserver;
/* loaded from: classes2.dex */
public class a extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public c f44320a;

    public a(c cVar) {
        super(null);
        this.f44320a = cVar;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        c cVar = this.f44320a;
        if (cVar != null) {
            cVar.f44323b = cVar.f44322a.a(0, null);
        }
    }
}
