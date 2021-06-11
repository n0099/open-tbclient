package d.a.n0.j2.d;

import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.personPolymeric.constant.PersonStatus;
/* loaded from: classes5.dex */
public abstract class e {

    /* renamed from: e  reason: collision with root package name */
    public boolean f60014e;

    public e(boolean z) {
        this.f60014e = z;
    }

    public PersonStatus g(UserData userData) {
        if (userData == null) {
            if (this.f60014e) {
                return PersonStatus.HOST_DEFAULT;
            }
            return PersonStatus.GUEST_DEFAULT;
        } else if (userData.isBaijiahaoUser()) {
            if (this.f60014e) {
                return PersonStatus.HOST_BJH;
            }
            return PersonStatus.GUEST_BJH;
        } else if (this.f60014e) {
            return PersonStatus.HOST_DEFAULT;
        } else {
            return PersonStatus.GUEST_DEFAULT;
        }
    }

    public PersonStatus i(d.a.n0.j2.e.a aVar) {
        if (aVar != null && aVar.j() != null) {
            return g(aVar.j());
        }
        if (this.f60014e) {
            return PersonStatus.HOST_DEFAULT;
        }
        return PersonStatus.GUEST_DEFAULT;
    }
}
