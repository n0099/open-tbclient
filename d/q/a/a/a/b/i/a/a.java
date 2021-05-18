package d.q.a.a.a.b.i.a;

import android.database.ContentObserver;
/* loaded from: classes7.dex */
public final class a extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public String f67542a;

    /* renamed from: b  reason: collision with root package name */
    public int f67543b;

    /* renamed from: c  reason: collision with root package name */
    public b f67544c;

    public a(b bVar, int i2, String str) {
        super(null);
        this.f67544c = bVar;
        this.f67543b = i2;
        this.f67542a = str;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        b bVar = this.f67544c;
        if (bVar != null) {
            bVar.e(this.f67543b, this.f67542a);
        }
    }
}
