package d.q.a.a.a.b.i.a;

import android.database.ContentObserver;
/* loaded from: classes7.dex */
public final class a extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public String f67332a;

    /* renamed from: b  reason: collision with root package name */
    public int f67333b;

    /* renamed from: c  reason: collision with root package name */
    public b f67334c;

    public a(b bVar, int i, String str) {
        super(null);
        this.f67334c = bVar;
        this.f67333b = i;
        this.f67332a = str;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        b bVar = this.f67334c;
        if (bVar != null) {
            bVar.e(this.f67333b, this.f67332a);
        }
    }
}
