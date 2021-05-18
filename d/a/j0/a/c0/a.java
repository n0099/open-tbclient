package d.a.j0.a.c0;

import tbclient.BackUser.DataRes;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f48633a = false;

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f48633a = dataRes.is_back_user.intValue() == 1;
    }
}
