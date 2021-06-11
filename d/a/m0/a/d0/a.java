package d.a.m0.a.d0;

import tbclient.BackUser.DataRes;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f52331a = false;

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f52331a = dataRes.is_back_user.intValue() == 1;
    }
}
