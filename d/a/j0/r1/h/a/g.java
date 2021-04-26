package d.a.j0.r1.h.a;

import tbclient.UpdateTail.ResData;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public int f59758a;

    public int a() {
        return this.f59758a;
    }

    public void b(ResData resData) {
        Long l;
        if (resData == null || (l = resData.tailId) == null) {
            return;
        }
        this.f59758a = l.intValue();
    }
}
