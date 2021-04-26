package d.a.j0.a1.g.j;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.j0.x.e0.p;
import tbclient.Personalized.CardForum;
import tbclient.Personalized.PersonalForum;
/* loaded from: classes4.dex */
public class b extends d.a.j0.x.e0.i implements p {

    /* renamed from: i  reason: collision with root package name */
    public CardForum f50939i;

    public static boolean t(int i2) {
        return i2 == 1;
    }

    @Override // d.a.j0.x.e0.p
    public void a(boolean z) {
        this.showTopDivider = z;
    }

    @Override // d.a.j0.x.e0.p
    public boolean g() {
        return true;
    }

    @Override // d.a.j0.x.e0.p
    public int getPosition() {
        CardForum cardForum = this.f50939i;
        if (cardForum != null) {
            return cardForum.position.intValue();
        }
        return 0;
    }

    @Override // d.a.j0.x.e0.p
    public void n(boolean z) {
        this.showBottomDivider = z;
    }

    public boolean u() {
        return ListUtils.getCount(getDataList()) > 0;
    }

    public void v(CardForum cardForum) {
        if (cardForum != null) {
            this.f50939i = cardForum;
            this.mGroupTitle = cardForum.card_title;
            if (cardForum.position != null) {
                s(m() + cardForum.position.intValue());
            } else {
                s(m() + 0);
            }
            if (ListUtils.getCount(cardForum.forum_list) > 0) {
                for (PersonalForum personalForum : cardForum.forum_list) {
                    if (personalForum != null && !TextUtils.isEmpty(personalForum.forum_name) && personalForum.forum_id.longValue() > 0) {
                        d.a.j0.x.e0.g gVar = new d.a.j0.x.e0.g();
                        gVar.f62465b = personalForum.avatar;
                        gVar.f62466c = personalForum.forum_name;
                        gVar.f62467d = d.a.c.e.m.b.d("" + personalForum.forum_id, -1);
                        gVar.f62468e = personalForum.is_like.intValue() == 1;
                        h(gVar);
                    }
                }
            }
        }
    }
}
