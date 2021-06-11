package d.a.n0.s1.h.a;

import tbclient.DeleteTail.ResData;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f64311a;

    public int a() {
        return this.f64311a;
    }

    public void b(ResData resData) {
        Long l;
        if (resData == null || (l = resData.tailId) == null) {
            return;
        }
        this.f64311a = l.intValue();
    }
}
