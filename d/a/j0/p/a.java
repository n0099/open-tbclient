package d.a.j0.p;

import android.database.ContentObserver;
/* loaded from: classes2.dex */
public final class a extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public c f40503a;

    public a(c cVar) {
        super(null);
        this.f40503a = cVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        c cVar = this.f40503a;
        if (cVar != null) {
            cVar.f40506b = cVar.f40505a.a();
        }
    }
}
