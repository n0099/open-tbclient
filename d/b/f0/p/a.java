package d.b.f0.p;

import android.database.ContentObserver;
/* loaded from: classes2.dex */
public final class a extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public c f43443a;

    public a(c cVar) {
        super(null);
        this.f43443a = cVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        c cVar = this.f43443a;
        if (cVar != null) {
            cVar.f43446b = cVar.f43445a.a();
        }
    }
}
