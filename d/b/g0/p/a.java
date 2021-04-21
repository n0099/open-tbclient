package d.b.g0.p;

import android.database.ContentObserver;
/* loaded from: classes2.dex */
public final class a extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public c f43740a;

    public a(c cVar) {
        super(null);
        this.f43740a = cVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        c cVar = this.f43740a;
        if (cVar != null) {
            cVar.f43743b = cVar.f43742a.a();
        }
    }
}
