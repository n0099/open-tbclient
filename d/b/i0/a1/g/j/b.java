package d.b.i0.a1.g.j;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.i0.x.e0.p;
import tbclient.Personalized.CardForum;
import tbclient.Personalized.PersonalForum;
/* loaded from: classes4.dex */
public class b extends d.b.i0.x.e0.i implements p {
    public CardForum i;

    public static boolean t(int i) {
        return i == 1;
    }

    @Override // d.b.i0.x.e0.p
    public void b(boolean z) {
        this.showTopDivider = z;
    }

    @Override // d.b.i0.x.e0.p
    public int getPosition() {
        CardForum cardForum = this.i;
        if (cardForum != null) {
            return cardForum.position.intValue();
        }
        return 0;
    }

    @Override // d.b.i0.x.e0.p
    public void h(boolean z) {
        this.showBottomDivider = z;
    }

    @Override // d.b.i0.x.e0.p
    public boolean m() {
        return true;
    }

    public boolean u() {
        return ListUtils.getCount(getDataList()) > 0;
    }

    public void v(CardForum cardForum) {
        if (cardForum != null) {
            this.i = cardForum;
            this.mGroupTitle = cardForum.card_title;
            if (cardForum.position != null) {
                s(n() + cardForum.position.intValue());
            } else {
                s(n() + 0);
            }
            if (ListUtils.getCount(cardForum.forum_list) > 0) {
                for (PersonalForum personalForum : cardForum.forum_list) {
                    if (personalForum != null && !TextUtils.isEmpty(personalForum.forum_name) && personalForum.forum_id.longValue() > 0) {
                        d.b.i0.x.e0.g gVar = new d.b.i0.x.e0.g();
                        gVar.f63781b = personalForum.avatar;
                        gVar.f63782c = personalForum.forum_name;
                        gVar.f63783d = d.b.c.e.m.b.d("" + personalForum.forum_id, -1);
                        gVar.f63784e = personalForum.is_like.intValue() == 1;
                        g(gVar);
                    }
                }
            }
        }
    }
}
