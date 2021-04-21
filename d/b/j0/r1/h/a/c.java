package d.b.j0.r1.h.a;

import tbclient.DeleteTail.ResData;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f61599a;

    public int a() {
        return this.f61599a;
    }

    public void b(ResData resData) {
        Long l;
        if (resData == null || (l = resData.tailId) == null) {
            return;
        }
        this.f61599a = l.intValue();
    }
}
