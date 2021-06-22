package d.a.n0.a.d0;

import tbclient.BackUser.DataRes;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f52438a = false;

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f52438a = dataRes.is_back_user.intValue() == 1;
    }
}
