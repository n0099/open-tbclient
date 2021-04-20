package d.q.a.a.a.b.i.a;

import android.database.ContentObserver;
/* loaded from: classes7.dex */
public final class a extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public String f68330a;

    /* renamed from: b  reason: collision with root package name */
    public int f68331b;

    /* renamed from: c  reason: collision with root package name */
    public b f68332c;

    public a(b bVar, int i, String str) {
        super(null);
        this.f68332c = bVar;
        this.f68331b = i;
        this.f68330a = str;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        b bVar = this.f68332c;
        if (bVar != null) {
            bVar.e(this.f68331b, this.f68330a);
        }
    }
}
