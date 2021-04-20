package d.b.i0.r1.h.a;

import tbclient.UpdateTail.ResData;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public int f61184a;

    public int a() {
        return this.f61184a;
    }

    public void b(ResData resData) {
        Long l;
        if (resData == null || (l = resData.tailId) == null) {
            return;
        }
        this.f61184a = l.intValue();
    }
}
