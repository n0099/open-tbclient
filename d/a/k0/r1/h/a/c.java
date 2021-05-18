package d.a.k0.r1.h.a;

import tbclient.DeleteTail.ResData;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f60497a;

    public int a() {
        return this.f60497a;
    }

    public void b(ResData resData) {
        Long l;
        if (resData == null || (l = resData.tailId) == null) {
            return;
        }
        this.f60497a = l.intValue();
    }
}
