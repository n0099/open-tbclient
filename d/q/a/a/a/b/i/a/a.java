package d.q.a.a.a.b.i.a;

import android.database.ContentObserver;
/* loaded from: classes7.dex */
public final class a extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public String f67585a;

    /* renamed from: b  reason: collision with root package name */
    public int f67586b;

    /* renamed from: c  reason: collision with root package name */
    public b f67587c;

    public a(b bVar, int i2, String str) {
        super(null);
        this.f67587c = bVar;
        this.f67586b = i2;
        this.f67585a = str;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        b bVar = this.f67587c;
        if (bVar != null) {
            bVar.e(this.f67586b, this.f67585a);
        }
    }
}
