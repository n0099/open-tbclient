package d.a.k0.a1.g.j;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.k0.x.e0.p;
import tbclient.Personalized.CardForum;
import tbclient.Personalized.PersonalForum;
/* loaded from: classes4.dex */
public class b extends d.a.k0.x.e0.i implements p {

    /* renamed from: i  reason: collision with root package name */
    public CardForum f51638i;

    public static boolean t(int i2) {
        return i2 == 1;
    }

    @Override // d.a.k0.x.e0.p
    public void a(boolean z) {
        this.showTopDivider = z;
    }

    @Override // d.a.k0.x.e0.p
    public boolean g() {
        return true;
    }

    @Override // d.a.k0.x.e0.p
    public int getPosition() {
        CardForum cardForum = this.f51638i;
        if (cardForum != null) {
            return cardForum.position.intValue();
        }
        return 0;
    }

    @Override // d.a.k0.x.e0.p
    public void n(boolean z) {
        this.showBottomDivider = z;
    }

    public boolean u() {
        return ListUtils.getCount(getDataList()) > 0;
    }

    public void v(CardForum cardForum) {
        if (cardForum != null) {
            this.f51638i = cardForum;
            this.mGroupTitle = cardForum.card_title;
            if (cardForum.position != null) {
                s(m() + cardForum.position.intValue());
            } else {
                s(m() + 0);
            }
            if (ListUtils.getCount(cardForum.forum_list) > 0) {
                for (PersonalForum personalForum : cardForum.forum_list) {
                    if (personalForum != null && !TextUtils.isEmpty(personalForum.forum_name) && personalForum.forum_id.longValue() > 0) {
                        d.a.k0.x.e0.g gVar = new d.a.k0.x.e0.g();
                        gVar.f63189b = personalForum.avatar;
                        gVar.f63190c = personalForum.forum_name;
                        gVar.f63191d = d.a.c.e.m.b.d("" + personalForum.forum_id, -1);
                        gVar.f63192e = personalForum.is_like.intValue() == 1;
                        h(gVar);
                    }
                }
            }
        }
    }
}
