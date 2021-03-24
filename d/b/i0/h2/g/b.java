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
    public TbPageContext f55336a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.h2.e.a f55337b;

    /* renamed from: c  reason: collision with root package name */
    public UserData f55338c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.h2.g.a f55339d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f55340e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.h0.s.e.a f55341f;

    /* renamed from: g  reason: collision with root package name */
    public i f55342g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f55343h = new a();
    public CustomMessageListener i = new C1270b(2001115);

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String intro;
            if (view == b.this.f55339d.z()) {
                b.this.w();
            } else if (view == b.this.f55339d.r()) {
                b.this.r();
            } else if (view != b.this.f55339d.v()) {
                if (view == b.this.f55339d.D()) {
                    if (b.this.f55340e) {
                        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "7"));
                        b.this.E();
                    }
                } else if (view != b.this.f55339d.y() && view != b.this.f55339d.x()) {
                    if (view == b.this.f55339d.C()) {
                        b.this.z();
                    } else if (view == b.this.f55339d.s()) {
                        b.this.s();
                    } else if (view == b.this.f55339d.t()) {
                        b.this.t();
                    } else if (view == b.this.f55339d.u()) {
                        b.this.u();
                    } else if (view == b.this.f55339d.w()) {
                        b.this.v();
                    } else if (view == b.this.f55339d.B()) {
                        if (b.this.f55340e) {
                            TiebaStatic.log(new StatisticItem("c13613").param("obj_param1", "0"));
                        } else {
                            TiebaStatic.log(new StatisticItem("c13613").param("obj_param1", "1"));
                        }
                        b.this.y();
                    } else if (view == b.this.f55339d.A()) {
                        b.this.x();
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", Constants.VIA_REPORT_TYPE_MAKE_FRIEND));
                    if (b.this.f55340e) {
                        if (b.this.f55338c != null && b.this.f55338c.isBaijiahaoUser()) {
                            PersonIntroductionActivity.startPersonIntroductionActivity(b.this.f55336a.getPageActivity(), b.this.f55338c.getIntro());
                        }
                        b.this.E();
                        return;
                    }
                    BaijiahaoInfo baijiahaoInfo = b.this.f55338c.getBaijiahaoInfo();
                    if (baijiahaoInfo == null || k.isEmpty(baijiahaoInfo.auth_desc)) {
                        intro = b.this.f55338c.getIntro();
                    } else {
                        intro = baijiahaoInfo.auth_desc;
                    }
                    PersonIntroductionActivity.startPersonIntroductionActivity(b.this.f55336a.getPageActivity(), intro);
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
    public class C1270b extends CustomMessageListener {
        public C1270b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if (!(customResponsedMessage instanceof UpdateAttentionMessage) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f13694c)) {
                return;
            }
            if (updateAttentionMessage.getData().f13692a) {
                Message<?> message = updateAttentionMessage.getmOrginalMessage();
                if (message == null || message.getTag() == null || !message.getTag().equals(b.this.f55336a.getUniqueId())) {
                    return;
                }
                if (updateAttentionMessage.isAttention()) {
                    b.this.f55338c.setLike(true);
                    return;
                }
                if (!updateAttentionMessage.getData().i) {
                    b.this.f55336a.showToast(R.string.unlike_success);
                }
                b.this.f55338c.setLike(false);
                return;
            }
            Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
            if (message2 == null || message2.getTag() == null || !message2.getTag().equals(b.this.f55336a.getUniqueId())) {
                return;
            }
            b.this.f55339d.P(b.this.f55338c.isLike());
            if (updateAttentionMessage.getData() == null || k.isEmpty(updateAttentionMessage.getData().f13693b)) {
                if (b.this.f55338c.getIsLike()) {
                    b.this.f55336a.showToast(R.string.unlike_failure);
                    return;
                } else {
                    b.this.f55336a.showToast(R.string.attention_fail);
                    return;
                }
            }
            b.this.f55336a.showToast(updateAttentionMessage.getData().f13693b);
        }
    }

    public b(TbPageContext tbPageContext, boolean z) {
        this.f55336a = tbPageContext;
        this.f55340e = z;
        this.f55339d = new d.b.i0.h2.g.a(this.f55336a, this.f55340e, this.f55343h);
        this.f55336a.registerListener(this.i);
        TbPageContext tbPageContext2 = this.f55336a;
        this.f55342g = new i(tbPageContext2, tbPageContext2.getUniqueId(), z);
    }

    public void A(Intent intent) {
        i iVar = this.f55342g;
        if (iVar != null) {
            iVar.p(intent);
        }
    }

    public FollowUserSpinnerBtn B() {
        return this.f55339d.r();
    }

    public View C() {
        return this.f55339d.E();
    }

    public final void D() {
        if (ViewHelper.checkUpIsLogin(this.f55336a.getPageActivity())) {
            GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.f55336a.getPageActivity(), this.f55338c.getUserIdLong(), this.f55338c.getUserName(), this.f55338c.getName_show(), GiftTabActivityConfig.FROM_PERSON_CENTER, 24001);
            giftTabActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_HE_HER_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, giftTabActivityConfig));
        }
    }

    public final void E() {
        if (TbadkCoreApplication.getCurrentAccountInfo() == null) {
            return;
        }
        PersonChangeData personChangeData = new PersonChangeData();
        UserData userData = this.f55338c;
        if (userData != null) {
            personChangeData.setPortrait(userData.getPortrait());
            personChangeData.setName(this.f55338c.getUserName());
            personChangeData.setSex(this.f55338c.getSex());
            personChangeData.setIntro(this.f55338c.getIntro());
            personChangeData.setNameShow(this.f55338c.getName_show());
            personChangeData.setMem(this.f55338c.getIsMem());
            personChangeData.setForumAge(this.f55338c.getTb_age());
            personChangeData.setCanModifyAvatar(this.f55338c.canModifyAvatar());
            personChangeData.setCantModifyAvatarDesc(this.f55338c.getCantModifyAvatarDesc());
            AlaUserInfoData alaUserInfoData = this.f55338c.alaUserData;
            if (alaUserInfoData != null) {
                personChangeData.setAlaId(alaUserInfoData.ala_id);
            }
            NicknameInfo nicknameInfo = this.f55337b.A;
            if (nicknameInfo != null) {
                personChangeData.setNickNameLeftDays(nicknameInfo.left_days.intValue());
            }
            if (this.f55338c.getBirthdayInfo() != null) {
                personChangeData.setUserAge(this.f55338c.getBirthdayInfo().f50801c);
                personChangeData.setBirthdayTime(this.f55338c.getBirthdayInfo().f50799a);
                personChangeData.setBirthdayShowStatus(this.f55338c.getBirthdayInfo().f50802d);
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(this.f55336a.getPageActivity(), 101, personChangeData, Boolean.FALSE)));
    }

    public void F(int i) {
        d.b.i0.h2.g.a aVar = this.f55339d;
        if (aVar != null) {
            aVar.H(i);
        }
    }

    public void G() {
        i iVar = this.f55342g;
        if (iVar != null) {
            iVar.z();
        }
        d.b.i0.h2.g.a aVar = this.f55339d;
        if (aVar != null) {
            aVar.I();
        }
    }

    public void H() {
        this.f55339d.J();
    }

    public void I(d.b.i0.h2.d.a aVar) {
        this.f55339d.K(aVar);
    }

    public void J(boolean z) {
        this.f55339d.L(z);
    }

    public void K(boolean z) {
        this.f55339d.M(z);
    }

    public final void L(int i) {
        BdToast.i(this.f55336a.getPageActivity(), String.format(this.f55336a.getString(R.string.person_privacy_toast), StringHelper.getUserDescByGender(i)), R.drawable.icon_pure_toast_mistake40_svg, true).q();
    }

    public void M() {
        this.f55339d.N();
    }

    public void N(String str) {
        d.b.i0.h2.g.a aVar = this.f55339d;
        if (aVar != null) {
            aVar.Q(str);
        }
    }

    public void p(d.b.i0.h2.e.a aVar) {
        if (aVar == null || aVar.j() == null) {
            return;
        }
        this.f55337b = aVar;
        this.f55338c = aVar.j();
        this.f55339d.q(this.f55337b.j(), this.f55337b.g());
        this.f55342g.B(aVar);
    }

    public void q() {
        i iVar = this.f55342g;
        if (iVar != null) {
            iVar.o();
        }
    }

    public final void r() {
        if (ViewHelper.checkUpIsLogin(this.f55336a.getPageActivity())) {
            if (this.f55341f == null) {
                d.b.h0.s.e.a aVar = new d.b.h0.s.e.a(this.f55336a);
                this.f55341f = aVar;
                aVar.j(true);
            }
            this.f55341f.m(!this.f55338c.isLike(), this.f55338c.getPortrait(), this.f55338c.getUserId(), this.f55338c.isGod(), "2", this.f55336a.getUniqueId(), null, "0");
            this.f55339d.P(true ^ this.f55338c.isLike());
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_CONCERN_BTN_CLICK);
            statisticItem.param("obj_id", this.f55338c.getUserId());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TbPageContext tbPageContext = this.f55336a;
            if (tbPageContext != null && tbPageContext.getPageActivity() != null && this.f55336a.getPageActivity().getIntent() != null) {
                statisticItem.param("nid", this.f55336a.getPageActivity().getIntent().getStringExtra("nid"));
            }
            TbPageContext tbPageContext2 = this.f55336a;
            if (tbPageContext2 != null) {
                c.e(tbPageContext2.getPageActivity(), statisticItem);
            }
            TbPageContext tbPageContext3 = this.f55336a;
            if (tbPageContext3 != null && tbPageContext3.getPageActivity() != null && c.j(this.f55336a.getPageActivity()) != null && c.j(this.f55336a.getPageActivity()).b() != null && !TextUtils.isEmpty(c.j(this.f55336a.getPageActivity()).b().locatePage) && "a002".equals(c.j(this.f55336a.getPageActivity()).b().locatePage)) {
                statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, c.j(this.f55336a.getPageActivity()).b().locatePage);
                statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a011");
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void s() {
        StatisticItem statisticItem = new StatisticItem("c13575");
        statisticItem.param("obj_type", this.f55340e ? 1 : 0);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(statisticItem);
        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9));
        if (ViewHelper.checkUpIsLogin(this.f55336a.getPageActivity())) {
            TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 2).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f55338c.getUserId()) ? 1 : 2).param("obj_source", this.f55338c.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.f55336a.getPageActivity(), true, this.f55338c.getUserId(), this.f55338c.getSex()).updateFollowNum(this.f55338c.getConcernNum(), this.f55338c.getPortrait())));
        }
    }

    public final void t() {
        StatisticItem statisticItem = new StatisticItem("c13573");
        statisticItem.param("obj_type", this.f55340e ? 1 : 0);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(statisticItem);
        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "8"));
        if (ViewHelper.checkUpIsLogin(this.f55336a.getPageActivity())) {
            d.b.i0.s2.a.v().L(2, false, this.f55340e);
            TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 3).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f55338c.getUserId()) ? 1 : 2).param("obj_source", this.f55338c.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.f55336a.getPageActivity(), false, this.f55338c.getUserId(), this.f55338c.getSex())));
        }
    }

    public final void u() {
        StatisticItem statisticItem = new StatisticItem("c13574");
        statisticItem.param("obj_type", this.f55340e ? 1 : 0);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(statisticItem);
        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
        if (ViewHelper.checkUpIsLogin(this.f55336a.getPageActivity())) {
            boolean equals = TbadkCoreApplication.getCurrentAccount().equals(this.f55338c.getUserId());
            boolean z = this.f55338c.getIsFriend() == 1;
            if (this.f55338c.getPersonPrivate() == null) {
                L(this.f55338c.getSex());
            } else if (this.f55338c.getPersonPrivate().s() != 1 && !equals && (!z || this.f55338c.getPersonPrivate().s() != 2)) {
                L(this.f55338c.getSex());
            } else {
                TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 4).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f55338c.getUserId()) ? 1 : 2).param("obj_source", this.f55338c.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.f55336a.getPageActivity(), this.f55338c.getLike_bars(), this.f55338c.getUserId(), this.f55338c.getSex())));
            }
        }
    }

    public final void v() {
        AlaUserInfoData alaUserData = this.f55338c.getAlaUserData();
        if (!this.f55340e && alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
            TiebaStatic.log("c12542");
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = alaUserData.live_id;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.f55336a.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_ATTENTION, null, false, "")));
            return;
        }
        n nVar = new n();
        if (this.f55338c.getBaijiahaoInfo() != null && !TextUtils.isEmpty(this.f55338c.getBaijiahaoInfo().avatar)) {
            nVar.g(this.f55338c.getBaijiahaoInfo().avatar);
            nVar.k(this.f55338c.getBaijiahaoInfo().avatar);
            nVar.j(true);
        } else if (!StringUtils.isNull(this.f55338c.getPortrait()) && this.f55338c.getPortrait().startsWith("http")) {
            nVar.g(this.f55338c.getPortrait());
            nVar.k(HeadIconRefreshHelper.headPortraitFilter(this.f55338c.getPortrait()));
            nVar.j(true);
        } else {
            nVar.g(HeadIconRefreshHelper.headPortraitFilter(this.f55338c.getPortraitH()));
            nVar.k(HeadIconRefreshHelper.headPortraitFilter(this.f55338c.getPortrait()));
            nVar.j(true);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(nVar);
        this.f55342g.r(nVar, arrayList, 0);
    }

    public final void w() {
        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "6"));
        if (this.f55340e) {
            if (ViewHelper.checkUpIsLogin(this.f55336a.getPageActivity())) {
                UrlManager.getInstance().dealOneLink(this.f55336a, new String[]{TbConfig.URL_MEMBER_BUY});
                return;
            }
            return;
        }
        ArrayList<IconData> tShowInfo = this.f55338c.getTShowInfo();
        if (ListUtils.getItem(tShowInfo, 0) != null) {
            UrlManager.getInstance().dealOneLink(this.f55336a, new String[]{tShowInfo.get(0).getUrl()});
        }
    }

    public final void x() {
        UserData userData = this.f55338c;
        if (userData == null || userData.getLiveRoomInfo() == null || TextUtils.isEmpty(this.f55338c.getLiveRoomInfo().jump_url)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(this.f55336a, new String[]{this.f55338c.getLiveRoomInfo().jump_url}, true);
    }

    public final void y() {
        d.b.i0.h2.e.a aVar = this.f55337b;
        if (aVar == null || aVar.g() == null || TextUtils.isEmpty(this.f55337b.g().f61974b)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(this.f55336a, new String[]{this.f55337b.g().f61974b}, true);
    }

    public final void z() {
        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "4"));
        d.b.h0.l.a.o(this.f55336a.getPageActivity(), this.f55336a.getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + this.f55338c.getUserId(), true, true, true);
    }
}
