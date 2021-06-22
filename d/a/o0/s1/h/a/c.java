package d.a.o0.s1.h.a;

import tbclient.DeleteTail.ResData;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f64436a;

    public int a() {
        return this.f64436a;
    }

    public void b(ResData resData) {
        Long l;
        if (resData == null || (l = resData.tailId) == null) {
            return;
        }
        this.f64436a = l.intValue();
    }
}
