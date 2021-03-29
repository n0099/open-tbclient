package d.q.a.a.a.b.i.a;

import android.database.ContentObserver;
/* loaded from: classes7.dex */
public final class a extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public String f67337a;

    /* renamed from: b  reason: collision with root package name */
    public int f67338b;

    /* renamed from: c  reason: collision with root package name */
    public b f67339c;

    public a(b bVar, int i, String str) {
        super(null);
        this.f67339c = bVar;
        this.f67338b = i;
        this.f67337a = str;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        b bVar = this.f67339c;
        if (bVar != null) {
            bVar.e(this.f67338b, this.f67337a);
        }
    }
}
