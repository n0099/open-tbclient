package d.b.i0.h2.g;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.HeadIconRefreshHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.header.PersonIntroductionActivity;
import com.baidu.tieba.view.FollowUserSpinnerBtn;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.tencent.connect.common.Constants;
import d.b.b.e.p.k;
import d.b.h0.j0.c;
import d.b.h0.t.n;
import d.b.i0.h2.d.i;
import java.util.ArrayList;
import tbclient.BaijiahaoInfo;
import tbclient.Profile.NicknameInfo;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55337a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.h2.e.a f55338b;

    /* renamed from: c  reason: collision with root package name */
    public UserData f55339c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.h2.g.a f55340d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f55341e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.h0.s.e.a f55342f;

    /* renamed from: g  reason: collision with root package name */
    public i f55343g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f55344h = new a();
    public CustomMessageListener i = new C1271b(2001115);

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String intro;
            if (view == b.this.f55340d.z()) {
                b.this.w();
            } else if (view == b.this.f55340d.r()) {
                b.this.r();
            } else if (view != b.this.f55340d.v()) {
                if (view == b.this.f55340d.D()) {
                    if (b.this.f55341e) {
                        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "7"));
                        b.this.E();
                    }
                } else if (view != b.this.f55340d.y() && view != b.this.f55340d.x()) {
                    if (view == b.this.f55340d.C()) {
                        b.this.z();
                    } else if (view == b.this.f55340d.s()) {
                        b.this.s();
                    } else if (view == b.this.f55340d.t()) {
                        b.this.t();
                    } else if (view == b.this.f55340d.u()) {
                        b.this.u();
                    } else if (view == b.this.f55340d.w()) {
                        b.this.v();
                    } else if (view == b.this.f55340d.B()) {
                        if (b.this.f55341e) {
                            TiebaStatic.log(new StatisticItem("c13613").param("obj_param1", "0"));
                        } else {
                            TiebaStatic.log(new StatisticItem("c13613").param("obj_param1", "1"));
                        }
                        b.this.y();
                    } else if (view == b.this.f55340d.A()) {
                        b.this.x();
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", Constants.VIA_REPORT_TYPE_MAKE_FRIEND));
                    if (b.this.f55341e) {
                        if (b.this.f55339c != null && b.this.f55339c.isBaijiahaoUser()) {
                            PersonIntroductionActivity.startPersonIntroductionActivity(b.this.f55337a.getPageActivity(), b.this.f55339c.getIntro());
                        }
                        b.this.E();
                        return;
                    }
                    BaijiahaoInfo baijiahaoInfo = b.this.f55339c.getBaijiahaoInfo();
                    if (baijiahaoInfo == null || k.isEmpty(baijiahaoInfo.auth_desc)) {
                        intro = b.this.f55339c.getIntro();
                    } else {
                        intro = baijiahaoInfo.auth_desc;
                    }
                    PersonIntroductionActivity.startPersonIntroductionActivity(b.this.f55337a.getPageActivity(), intro);
                }
            } else {
                TiebaStatic.log(new StatisticItem("c12503").param("obj_locate", "3"));
                TiebaStatic.log("igift_icon_ck");
                b.this.D();
            }
        }
    }

    /* renamed from: d.b.i0.h2.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1271b extends CustomMessageListener {
        public C1271b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if (!(customResponsedMessage instanceof UpdateAttentionMessage) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f13695c)) {
                return;
            }
            if (updateAttentionMessage.getData().f13693a) {
                Message<?> message = updateAttentionMessage.getmOrginalMessage();
                if (message == null || message.getTag() == null || !message.getTag().equals(b.this.f55337a.getUniqueId())) {
                    return;
                }
                if (updateAttentionMessage.isAttention()) {
                    b.this.f55339c.setLike(true);
                    return;
                }
                if (!updateAttentionMessage.getData().i) {
                    b.this.f55337a.showToast(R.string.unlike_success);
                }
                b.this.f55339c.setLike(false);
                return;
            }
            Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
            if (message2 == null || message2.getTag() == null || !message2.getTag().equals(b.this.f55337a.getUniqueId())) {
                return;
            }
            b.this.f55340d.P(b.this.f55339c.isLike());
            if (updateAttentionMessage.getData() == null || k.isEmpty(updateAttentionMessage.getData().f13694b)) {
                if (b.this.f55339c.getIsLike()) {
                    b.this.f55337a.showToast(R.string.unlike_failure);
                    return;
                } else {
                    b.this.f55337a.showToast(R.string.attention_fail);
                    return;
                }
            }
            b.this.f55337a.showToast(updateAttentionMessage.getData().f13694b);
        }
    }

    public b(TbPageContext tbPageContext, boolean z) {
        this.f55337a = tbPageContext;
        this.f55341e = z;
        this.f55340d = new d.b.i0.h2.g.a(this.f55337a, this.f55341e, this.f55344h);
        this.f55337a.registerListener(this.i);
        TbPageContext tbPageContext2 = this.f55337a;
        this.f55343g = new i(tbPageContext2, tbPageContext2.getUniqueId(), z);
    }

    public void A(Intent intent) {
        i iVar = this.f55343g;
        if (iVar != null) {
            iVar.p(intent);
        }
    }

    public FollowUserSpinnerBtn B() {
        return this.f55340d.r();
    }

    public View C() {
        return this.f55340d.E();
    }

    public final void D() {
        if (ViewHelper.checkUpIsLogin(this.f55337a.getPageActivity())) {
            GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.f55337a.getPageActivity(), this.f55339c.getUserIdLong(), this.f55339c.getUserName(), this.f55339c.getName_show(), GiftTabActivityConfig.FROM_PERSON_CENTER, 24001);
            giftTabActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_HE_HER_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, giftTabActivityConfig));
        }
    }

    public final void E() {
        if (TbadkCoreApplication.getCurrentAccountInfo() == null) {
            return;
        }
        PersonChangeData personChangeData = new PersonChangeData();
        UserData userData = this.f55339c;
        if (userData != null) {
            personChangeData.setPortrait(userData.getPortrait());
            personChangeData.setName(this.f55339c.getUserName());
            personChangeData.setSex(this.f55339c.getSex());
            personChangeData.setIntro(this.f55339c.getIntro());
            personChangeData.setNameShow(this.f55339c.getName_show());
            personChangeData.setMem(this.f55339c.getIsMem());
            personChangeData.setForumAge(this.f55339c.getTb_age());
            personChangeData.setCanModifyAvatar(this.f55339c.canModifyAvatar());
            personChangeData.setCantModifyAvatarDesc(this.f55339c.getCantModifyAvatarDesc());
            AlaUserInfoData alaUserInfoData = this.f55339c.alaUserData;
            if (alaUserInfoData != null) {
                personChangeData.setAlaId(alaUserInfoData.ala_id);
            }
            NicknameInfo nicknameInfo = this.f55338b.A;
            if (nicknameInfo != null) {
                personChangeData.setNickNameLeftDays(nicknameInfo.left_days.intValue());
            }
            if (this.f55339c.getBirthdayInfo() != null) {
                personChangeData.setUserAge(this.f55339c.getBirthdayInfo().f50802c);
                personChangeData.setBirthdayTime(this.f55339c.getBirthdayInfo().f50800a);
                personChangeData.setBirthdayShowStatus(this.f55339c.getBirthdayInfo().f50803d);
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(this.f55337a.getPageActivity(), 101, personChangeData, Boolean.FALSE)));
    }

    public void F(int i) {
        d.b.i0.h2.g.a aVar = this.f55340d;
        if (aVar != null) {
            aVar.H(i);
        }
    }

    public void G() {
        i iVar = this.f55343g;
        if (iVar != null) {
            iVar.z();
        }
        d.b.i0.h2.g.a aVar = this.f55340d;
        if (aVar != null) {
            aVar.I();
        }
    }

    public void H() {
        this.f55340d.J();
    }

    public void I(d.b.i0.h2.d.a aVar) {
        this.f55340d.K(aVar);
    }

    public void J(boolean z) {
        this.f55340d.L(z);
    }

    public void K(boolean z) {
        this.f55340d.M(z);
    }

    public final void L(int i) {
        BdToast.i(this.f55337a.getPageActivity(), String.format(this.f55337a.getString(R.string.person_privacy_toast), StringHelper.getUserDescByGender(i)), R.drawable.icon_pure_toast_mistake40_svg, true).q();
    }

    public void M() {
        this.f55340d.N();
    }

    public void N(String str) {
        d.b.i0.h2.g.a aVar = this.f55340d;
        if (aVar != null) {
            aVar.Q(str);
        }
    }

    public void p(d.b.i0.h2.e.a aVar) {
        if (aVar == null || aVar.j() == null) {
            return;
        }
        this.f55338b = aVar;
        this.f55339c = aVar.j();
        this.f55340d.q(this.f55338b.j(), this.f55338b.g());
        this.f55343g.B(aVar);
    }

    public void q() {
        i iVar = this.f55343g;
        if (iVar != null) {
            iVar.o();
        }
    }

    public final void r() {
        if (ViewHelper.checkUpIsLogin(this.f55337a.getPageActivity())) {
            if (this.f55342f == null) {
                d.b.h0.s.e.a aVar = new d.b.h0.s.e.a(this.f55337a);
                this.f55342f = aVar;
                aVar.j(true);
            }
            this.f55342f.m(!this.f55339c.isLike(), this.f55339c.getPortrait(), this.f55339c.getUserId(), this.f55339c.isGod(), "2", this.f55337a.getUniqueId(), null, "0");
            this.f55340d.P(true ^ this.f55339c.isLike());
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_CONCERN_BTN_CLICK);
            statisticItem.param("obj_id", this.f55339c.getUserId());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TbPageContext tbPageContext = this.f55337a;
            if (tbPageContext != null && tbPageContext.getPageActivity() != null && this.f55337a.getPageActivity().getIntent() != null) {
                statisticItem.param("nid", this.f55337a.getPageActivity().getIntent().getStringExtra("nid"));
            }
            TbPageContext tbPageContext2 = this.f55337a;
            if (tbPageContext2 != null) {
                c.e(tbPageContext2.getPageActivity(), statisticItem);
            }
            TbPageContext tbPageContext3 = this.f55337a;
            if (tbPageContext3 != null && tbPageContext3.getPageActivity() != null && c.j(this.f55337a.getPageActivity()) != null && c.j(this.f55337a.getPageActivity()).b() != null && !TextUtils.isEmpty(c.j(this.f55337a.getPageActivity()).b().locatePage) && "a002".equals(c.j(this.f55337a.getPageActivity()).b().locatePage)) {
                statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, c.j(this.f55337a.getPageActivity()).b().locatePage);
                statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a011");
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void s() {
        StatisticItem statisticItem = new StatisticItem("c13575");
        statisticItem.param("obj_type", this.f55341e ? 1 : 0);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(statisticItem);
        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9));
        if (ViewHelper.checkUpIsLogin(this.f55337a.getPageActivity())) {
            TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 2).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f55339c.getUserId()) ? 1 : 2).param("obj_source", this.f55339c.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.f55337a.getPageActivity(), true, this.f55339c.getUserId(), this.f55339c.getSex()).updateFollowNum(this.f55339c.getConcernNum(), this.f55339c.getPortrait())));
        }
    }

    public final void t() {
        StatisticItem statisticItem = new StatisticItem("c13573");
        statisticItem.param("obj_type", this.f55341e ? 1 : 0);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(statisticItem);
        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "8"));
        if (ViewHelper.checkUpIsLogin(this.f55337a.getPageActivity())) {
            d.b.i0.s2.a.v().L(2, false, this.f55341e);
            TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 3).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f55339c.getUserId()) ? 1 : 2).param("obj_source", this.f55339c.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.f55337a.getPageActivity(), false, this.f55339c.getUserId(), this.f55339c.getSex())));
        }
    }

    public final void u() {
        StatisticItem statisticItem = new StatisticItem("c13574");
        statisticItem.param("obj_type", this.f55341e ? 1 : 0);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(statisticItem);
        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
        if (ViewHelper.checkUpIsLogin(this.f55337a.getPageActivity())) {
            boolean equals = TbadkCoreApplication.getCurrentAccount().equals(this.f55339c.getUserId());
            boolean z = this.f55339c.getIsFriend() == 1;
            if (this.f55339c.getPersonPrivate() == null) {
                L(this.f55339c.getSex());
            } else if (this.f55339c.getPersonPrivate().s() != 1 && !equals && (!z || this.f55339c.getPersonPrivate().s() != 2)) {
                L(this.f55339c.getSex());
            } else {
                TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 4).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f55339c.getUserId()) ? 1 : 2).param("obj_source", this.f55339c.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.f55337a.getPageActivity(), this.f55339c.getLike_bars(), this.f55339c.getUserId(), this.f55339c.getSex())));
            }
        }
    }

    public final void v() {
        AlaUserInfoData alaUserData = this.f55339c.getAlaUserData();
        if (!this.f55341e && alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
            TiebaStatic.log("c12542");
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = alaUserData.live_id;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.f55337a.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_ATTENTION, null, false, "")));
            return;
        }
        n nVar = new n();
        if (this.f55339c.getBaijiahaoInfo() != null && !TextUtils.isEmpty(this.f55339c.getBaijiahaoInfo().avatar)) {
            nVar.g(this.f55339c.getBaijiahaoInfo().avatar);
            nVar.k(this.f55339c.getBaijiahaoInfo().avatar);
            nVar.j(true);
        } else if (!StringUtils.isNull(this.f55339c.getPortrait()) && this.f55339c.getPortrait().startsWith("http")) {
            nVar.g(this.f55339c.getPortrait());
            nVar.k(HeadIconRefreshHelper.headPortraitFilter(this.f55339c.getPortrait()));
            nVar.j(true);
        } else {
            nVar.g(HeadIconRefreshHelper.headPortraitFilter(this.f55339c.getPortraitH()));
            nVar.k(HeadIconRefreshHelper.headPortraitFilter(this.f55339c.getPortrait()));
            nVar.j(true);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(nVar);
        this.f55343g.r(nVar, arrayList, 0);
    }

    public final void w() {
        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "6"));
        if (this.f55341e) {
            if (ViewHelper.checkUpIsLogin(this.f55337a.getPageActivity())) {
                UrlManager.getInstance().dealOneLink(this.f55337a, new String[]{TbConfig.URL_MEMBER_BUY});
                return;
            }
            return;
        }
        ArrayList<IconData> tShowInfo = this.f55339c.getTShowInfo();
        if (ListUtils.getItem(tShowInfo, 0) != null) {
            UrlManager.getInstance().dealOneLink(this.f55337a, new String[]{tShowInfo.get(0).getUrl()});
        }
    }

    public final void x() {
        UserData userData = this.f55339c;
        if (userData == null || userData.getLiveRoomInfo() == null || TextUtils.isEmpty(this.f55339c.getLiveRoomInfo().jump_url)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(this.f55337a, new String[]{this.f55339c.getLiveRoomInfo().jump_url}, true);
    }

    public final void y() {
        d.b.i0.h2.e.a aVar = this.f55338b;
        if (aVar == null || aVar.g() == null || TextUtils.isEmpty(this.f55338b.g().f61975b)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(this.f55337a, new String[]{this.f55338b.g().f61975b}, true);
    }

    public final void z() {
        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "4"));
        d.b.h0.l.a.o(this.f55337a.getPageActivity(), this.f55337a.getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + this.f55339c.getUserId(), true, true, true);
    }
}
