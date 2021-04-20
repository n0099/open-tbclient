package d.b.h0.a.a0;

import tbclient.BackUser.DataRes;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f49891a = false;

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f49891a = dataRes.is_back_user.intValue() == 1;
    }
}
