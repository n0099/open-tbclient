package d.b.f0.p;

import android.database.ContentObserver;
/* loaded from: classes3.dex */
public final class a extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public c f43050a;

    public a(c cVar) {
        super(null);
        this.f43050a = cVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        c cVar = this.f43050a;
        if (cVar != null) {
            cVar.f43053b = cVar.f43052a.a();
        }
    }
}
