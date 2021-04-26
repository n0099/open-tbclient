package d.q.a.a.a.b.i.a;

import android.database.ContentObserver;
/* loaded from: classes7.dex */
public final class a extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public String f66856a;

    /* renamed from: b  reason: collision with root package name */
    public int f66857b;

    /* renamed from: c  reason: collision with root package name */
    public b f66858c;

    public a(b bVar, int i2, String str) {
        super(null);
        this.f66858c = bVar;
        this.f66857b = i2;
        this.f66856a = str;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        b bVar = this.f66858c;
        if (bVar != null) {
            bVar.e(this.f66857b, this.f66856a);
        }
    }
}
