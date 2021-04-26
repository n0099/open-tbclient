package d.a.g0.p;

import android.database.ContentObserver;
/* loaded from: classes2.dex */
public final class a extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public c f40997a;

    public a(c cVar) {
        super(null);
        this.f40997a = cVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        c cVar = this.f40997a;
        if (cVar != null) {
            cVar.f41000b = cVar.f40999a.a();
        }
    }
}
