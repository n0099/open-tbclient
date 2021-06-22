package d.a.o0.s1.h.a;

import tbclient.AddTail.ResData;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f64435a;

    public int a() {
        return this.f64435a;
    }

    public void b(ResData resData) {
        Long l;
        if (resData == null || (l = resData.tailId) == null) {
            return;
        }
        this.f64435a = l.intValue();
    }
}
