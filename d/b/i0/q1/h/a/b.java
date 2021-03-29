package d.b.i0.q1.h.a;

import tbclient.AddTail.ResData;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f59483a;

    public int a() {
        return this.f59483a;
    }

    public void b(ResData resData) {
        Long l;
        if (resData == null || (l = resData.tailId) == null) {
            return;
        }
        this.f59483a = l.intValue();
    }
}
