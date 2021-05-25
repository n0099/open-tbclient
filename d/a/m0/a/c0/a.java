package d.a.m0.a.c0;

import tbclient.BackUser.DataRes;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f48655a = false;

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f48655a = dataRes.is_back_user.intValue() == 1;
    }
}
