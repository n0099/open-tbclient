package d.q.a.a.a.b.i.a;

import android.database.ContentObserver;
/* loaded from: classes7.dex */
public final class a extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public String f71475a;

    /* renamed from: b  reason: collision with root package name */
    public int f71476b;

    /* renamed from: c  reason: collision with root package name */
    public b f71477c;

    public a(b bVar, int i2, String str) {
        super(null);
        this.f71477c = bVar;
        this.f71476b = i2;
        this.f71475a = str;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        b bVar = this.f71477c;
        if (bVar != null) {
            bVar.e(this.f71476b, this.f71475a);
        }
    }
}
