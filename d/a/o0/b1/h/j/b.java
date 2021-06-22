package d.a.o0.b1.h.j;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.o0.z.e0.p;
import tbclient.Personalized.CardForum;
import tbclient.Personalized.PersonalForum;
/* loaded from: classes4.dex */
public class b extends d.a.o0.z.e0.i implements p {

    /* renamed from: i  reason: collision with root package name */
    public CardForum f55613i;

    public static boolean p(int i2) {
        return i2 == 1;
    }

    @Override // d.a.o0.z.e0.p
    public void a(boolean z) {
        this.showTopDivider = z;
    }

    @Override // d.a.o0.z.e0.p
    public int getPosition() {
        CardForum cardForum = this.f55613i;
        if (cardForum != null) {
            return cardForum.position.intValue();
        }
        return 0;
    }

    @Override // d.a.o0.z.e0.p
    public boolean j() {
        return true;
    }

    public boolean q() {
        return ListUtils.getCount(getDataList()) > 0;
    }

    @Override // d.a.o0.z.e0.p
    public void r(boolean z) {
        this.showBottomDivider = z;
    }

    public void t(CardForum cardForum) {
        if (cardForum != null) {
            this.f55613i = cardForum;
            this.mGroupTitle = cardForum.card_title;
            if (cardForum.position != null) {
                o(i() + cardForum.position.intValue());
            } else {
                o(i() + 0);
            }
            if (ListUtils.getCount(cardForum.forum_list) > 0) {
                for (PersonalForum personalForum : cardForum.forum_list) {
                    if (personalForum != null && !TextUtils.isEmpty(personalForum.forum_name) && personalForum.forum_id.longValue() > 0) {
                        d.a.o0.z.e0.g gVar = new d.a.o0.z.e0.g();
                        gVar.f67312b = personalForum.avatar;
                        gVar.f67313c = personalForum.forum_name;
                        gVar.f67314d = d.a.c.e.m.b.d("" + personalForum.forum_id, -1);
                        gVar.f67315e = personalForum.is_like.intValue() == 1;
                        c(gVar);
                    }
                }
            }
        }
    }
}
