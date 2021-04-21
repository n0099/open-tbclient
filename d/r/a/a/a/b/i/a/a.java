package d.r.a.a.a.b.i.a;

import android.database.ContentObserver;
/* loaded from: classes7.dex */
public final class a extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public String f68477a;

    /* renamed from: b  reason: collision with root package name */
    public int f68478b;

    /* renamed from: c  reason: collision with root package name */
    public b f68479c;

    public a(b bVar, int i, String str) {
        super(null);
        this.f68479c = bVar;
        this.f68478b = i;
        this.f68477a = str;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        b bVar = this.f68479c;
        if (bVar != null) {
            bVar.e(this.f68478b, this.f68477a);
        }
    }
}
