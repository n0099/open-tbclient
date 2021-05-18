package d.a.k0.i2.g;

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
import d.a.c.e.p.k;
import d.a.j0.j0.c;
import d.a.j0.t.o;
import d.a.k0.i2.d.i;
import java.util.ArrayList;
import tbclient.BaijiahaoInfo;
import tbclient.Profile.NicknameInfo;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f56279a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.k0.i2.e.a f56280b;

    /* renamed from: c  reason: collision with root package name */
    public UserData f56281c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.k0.i2.g.a f56282d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f56283e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.j0.s.e.a f56284f;

    /* renamed from: g  reason: collision with root package name */
    public i f56285g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f56286h = new a();

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f56287i = new C1380b(2001115);

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String intro;
            if (view == b.this.f56282d.z()) {
                b.this.w();
            } else if (view == b.this.f56282d.r()) {
                b.this.r();
            } else if (view != b.this.f56282d.v()) {
                if (view == b.this.f56282d.D()) {
                    if (b.this.f56283e) {
                        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "7"));
                        b.this.E();
                    }
                } else if (view != b.this.f56282d.y() && view != b.this.f56282d.x()) {
                    if (view == b.this.f56282d.C()) {
                        b.this.z();
                    } else if (view == b.this.f56282d.s()) {
                        b.this.s();
                    } else if (view == b.this.f56282d.t()) {
                        b.this.t();
                    } else if (view == b.this.f56282d.u()) {
                        b.this.u();
                    } else if (view == b.this.f56282d.w()) {
                        b.this.v();
                    } else if (view == b.this.f56282d.B()) {
                        if (b.this.f56283e) {
                            TiebaStatic.log(new StatisticItem("c13613").param("obj_param1", "0"));
                        } else {
                            TiebaStatic.log(new StatisticItem("c13613").param("obj_param1", "1"));
                        }
                        b.this.y();
                    } else if (view == b.this.f56282d.A()) {
                        b.this.x();
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", Constants.VIA_REPORT_TYPE_MAKE_FRIEND));
                    if (b.this.f56283e) {
                        if (b.this.f56281c != null && b.this.f56281c.isBaijiahaoUser()) {
                            PersonIntroductionActivity.startPersonIntroductionActivity(b.this.f56279a.getPageActivity(), b.this.f56281c.getIntro());
                        }
                        b.this.E();
                        return;
                    }
                    BaijiahaoInfo baijiahaoInfo = b.this.f56281c.getBaijiahaoInfo();
                    if (baijiahaoInfo == null || k.isEmpty(baijiahaoInfo.auth_desc)) {
                        intro = b.this.f56281c.getIntro();
                    } else {
                        intro = baijiahaoInfo.auth_desc;
                    }
                    PersonIntroductionActivity.startPersonIntroductionActivity(b.this.f56279a.getPageActivity(), intro);
                }
            } else {
                TiebaStatic.log(new StatisticItem("c12503").param("obj_locate", "3"));
                TiebaStatic.log("igift_icon_ck");
                b.this.D();
            }
        }
    }

    /* renamed from: d.a.k0.i2.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1380b extends CustomMessageListener {
        public C1380b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if (!(customResponsedMessage instanceof UpdateAttentionMessage) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f12668c)) {
                return;
            }
            if (updateAttentionMessage.getData().f12666a) {
                Message<?> message = updateAttentionMessage.getmOrginalMessage();
                if (message == null || message.getTag() == null || !message.getTag().equals(b.this.f56279a.getUniqueId())) {
                    return;
                }
                if (updateAttentionMessage.isAttention()) {
                    b.this.f56281c.setLike(true);
                    return;
                }
                if (!updateAttentionMessage.getData().j) {
                    b.this.f56279a.showToast(R.string.unlike_success);
                }
                b.this.f56281c.setLike(false);
                return;
            }
            Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
            if (message2 == null || message2.getTag() == null || !message2.getTag().equals(b.this.f56279a.getUniqueId())) {
                return;
            }
            b.this.f56282d.P(b.this.f56281c.isLike());
            if (updateAttentionMessage.getData() == null || k.isEmpty(updateAttentionMessage.getData().f12667b)) {
                if (b.this.f56281c.getIsLike()) {
                    b.this.f56279a.showToast(R.string.unlike_failure);
                    return;
                } else {
                    b.this.f56279a.showToast(R.string.attention_fail);
                    return;
                }
            }
            b.this.f56279a.showToast(updateAttentionMessage.getData().f12667b);
        }
    }

    public b(TbPageContext tbPageContext, boolean z) {
        this.f56279a = tbPageContext;
        this.f56283e = z;
        this.f56282d = new d.a.k0.i2.g.a(this.f56279a, this.f56283e, this.f56286h);
        this.f56279a.registerListener(this.f56287i);
        TbPageContext tbPageContext2 = this.f56279a;
        this.f56285g = new i(tbPageContext2, tbPageContext2.getUniqueId(), z);
    }

    public void A(Intent intent) {
        i iVar = this.f56285g;
        if (iVar != null) {
            iVar.p(intent);
        }
    }

    public FollowUserSpinnerBtn B() {
        return this.f56282d.r();
    }

    public View C() {
        return this.f56282d.E();
    }

    public final void D() {
        if (ViewHelper.checkUpIsLogin(this.f56279a.getPageActivity())) {
            GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.f56279a.getPageActivity(), this.f56281c.getUserIdLong(), this.f56281c.getUserName(), this.f56281c.getName_show(), GiftTabActivityConfig.FROM_PERSON_CENTER, 24001);
            giftTabActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_HE_HER_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, giftTabActivityConfig));
        }
    }

    public final void E() {
        if (TbadkCoreApplication.getCurrentAccountInfo() == null) {
            return;
        }
        PersonChangeData personChangeData = new PersonChangeData();
        UserData userData = this.f56281c;
        if (userData != null) {
            personChangeData.setPortrait(userData.getPortrait());
            personChangeData.setName(this.f56281c.getUserName());
            personChangeData.setSex(this.f56281c.getSex());
            personChangeData.setIntro(this.f56281c.getIntro());
            personChangeData.setNameShow(this.f56281c.getName_show());
            personChangeData.setMem(this.f56281c.getIsMem());
            personChangeData.setForumAge(this.f56281c.getTb_age());
            personChangeData.setCanModifyAvatar(this.f56281c.canModifyAvatar());
            personChangeData.setCantModifyAvatarDesc(this.f56281c.getCantModifyAvatarDesc());
            personChangeData.setTiebaId(this.f56281c.getmTiebaUid());
            AlaUserInfoData alaUserInfoData = this.f56281c.alaUserData;
            if (alaUserInfoData != null) {
                personChangeData.setAlaId(alaUserInfoData.ala_id);
            }
            NicknameInfo nicknameInfo = this.f56280b.A;
            if (nicknameInfo != null) {
                personChangeData.setNickNameLeftDays(nicknameInfo.left_days.intValue());
            }
            if (this.f56281c.getBirthdayInfo() != null) {
                personChangeData.setUserAge(this.f56281c.getBirthdayInfo().f49992c);
                personChangeData.setBirthdayTime(this.f56281c.getBirthdayInfo().f49990a);
                personChangeData.setBirthdayShowStatus(this.f56281c.getBirthdayInfo().f49993d);
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(this.f56279a.getPageActivity(), 101, personChangeData, Boolean.FALSE)));
    }

    public void F(int i2) {
        d.a.k0.i2.g.a aVar = this.f56282d;
        if (aVar != null) {
            aVar.H(i2);
        }
    }

    public void G() {
        i iVar = this.f56285g;
        if (iVar != null) {
            iVar.y();
        }
        d.a.k0.i2.g.a aVar = this.f56282d;
        if (aVar != null) {
            aVar.I();
        }
    }

    public void H() {
        this.f56282d.J();
    }

    public void I(d.a.k0.i2.d.a aVar) {
        this.f56282d.K(aVar);
    }

    public void J(boolean z) {
        this.f56282d.L(z);
    }

    public void K(boolean z) {
        this.f56282d.M(z);
    }

    public final void L(int i2) {
        BdToast.i(this.f56279a.getPageActivity(), String.format(this.f56279a.getString(R.string.person_privacy_toast), StringHelper.getUserDescByGender(i2)), R.drawable.icon_pure_toast_mistake40_svg, true).q();
    }

    public void M() {
        this.f56282d.N();
    }

    public void N(String str) {
        d.a.k0.i2.g.a aVar = this.f56282d;
        if (aVar != null) {
            aVar.Q(str);
        }
    }

    public void p(d.a.k0.i2.e.a aVar) {
        if (aVar == null || aVar.j() == null) {
            return;
        }
        this.f56280b = aVar;
        this.f56281c = aVar.j();
        this.f56282d.q(this.f56280b.j(), this.f56280b.g());
        this.f56285g.A(aVar);
    }

    public void q() {
        i iVar = this.f56285g;
        if (iVar != null) {
            iVar.o();
        }
    }

    public final void r() {
        if (ViewHelper.checkUpIsLogin(this.f56279a.getPageActivity())) {
            if (this.f56284f == null) {
                d.a.j0.s.e.a aVar = new d.a.j0.s.e.a(this.f56279a);
                this.f56284f = aVar;
                aVar.j(true);
            }
            this.f56284f.m(!this.f56281c.isLike(), this.f56281c.getPortrait(), this.f56281c.getUserId(), this.f56281c.isGod(), "2", this.f56279a.getUniqueId(), null, "0");
            this.f56282d.P(true ^ this.f56281c.isLike());
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_CONCERN_BTN_CLICK);
            statisticItem.param("obj_id", this.f56281c.getUserId());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TbPageContext tbPageContext = this.f56279a;
            if (tbPageContext != null && tbPageContext.getPageActivity() != null && this.f56279a.getPageActivity().getIntent() != null) {
                statisticItem.param("nid", this.f56279a.getPageActivity().getIntent().getStringExtra("nid"));
            }
            TbPageContext tbPageContext2 = this.f56279a;
            if (tbPageContext2 != null) {
                c.e(tbPageContext2.getPageActivity(), statisticItem);
            }
            TbPageContext tbPageContext3 = this.f56279a;
            if (tbPageContext3 != null && tbPageContext3.getPageActivity() != null && c.j(this.f56279a.getPageActivity()) != null && c.j(this.f56279a.getPageActivity()).b() != null && !TextUtils.isEmpty(c.j(this.f56279a.getPageActivity()).b().locatePage) && "a002".equals(c.j(this.f56279a.getPageActivity()).b().locatePage)) {
                statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, c.j(this.f56279a.getPageActivity()).b().locatePage);
                statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a011");
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void s() {
        StatisticItem statisticItem = new StatisticItem("c13575");
        statisticItem.param("obj_type", this.f56283e ? 1 : 0);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(statisticItem);
        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9));
        if (ViewHelper.checkUpIsLogin(this.f56279a.getPageActivity())) {
            TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 2).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f56281c.getUserId()) ? 1 : 2).param("obj_source", this.f56281c.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.f56279a.getPageActivity(), true, this.f56281c.getUserId(), this.f56281c.getSex()).updateFollowNum(this.f56281c.getConcernNum(), this.f56281c.getPortrait())));
        }
    }

    public final void t() {
        StatisticItem statisticItem = new StatisticItem("c13573");
        statisticItem.param("obj_type", this.f56283e ? 1 : 0);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(statisticItem);
        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "8"));
        if (ViewHelper.checkUpIsLogin(this.f56279a.getPageActivity())) {
            d.a.k0.t2.a.v().L(2, false, this.f56283e);
            TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 3).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f56281c.getUserId()) ? 1 : 2).param("obj_source", this.f56281c.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.f56279a.getPageActivity(), false, this.f56281c.getUserId(), this.f56281c.getSex())));
        }
    }

    public final void u() {
        StatisticItem statisticItem = new StatisticItem("c13574");
        statisticItem.param("obj_type", this.f56283e ? 1 : 0);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(statisticItem);
        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "10"));
        if (ViewHelper.checkUpIsLogin(this.f56279a.getPageActivity())) {
            boolean equals = TbadkCoreApplication.getCurrentAccount().equals(this.f56281c.getUserId());
            boolean z = this.f56281c.getIsFriend() == 1;
            if (this.f56281c.getPersonPrivate() == null) {
                L(this.f56281c.getSex());
            } else if (this.f56281c.getPersonPrivate().s() != 1 && !equals && (!z || this.f56281c.getPersonPrivate().s() != 2)) {
                L(this.f56281c.getSex());
            } else {
                TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 4).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f56281c.getUserId()) ? 1 : 2).param("obj_source", this.f56281c.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.f56279a.getPageActivity(), this.f56281c.getLike_bars(), this.f56281c.getUserId(), this.f56281c.getSex())));
            }
        }
    }

    public final void v() {
        AlaUserInfoData alaUserData = this.f56281c.getAlaUserData();
        if (!this.f56283e && alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
            TiebaStatic.log("c12542");
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = alaUserData.live_id;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.f56279a.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_ATTENTION, null, false, "")));
            return;
        }
        o oVar = new o();
        if (this.f56281c.getBaijiahaoInfo() != null && !TextUtils.isEmpty(this.f56281c.getBaijiahaoInfo().avatar)) {
            oVar.h(this.f56281c.getBaijiahaoInfo().avatar);
            oVar.k(this.f56281c.getBaijiahaoInfo().avatar);
            oVar.i(true);
        } else if (!StringUtils.isNull(this.f56281c.getPortrait()) && this.f56281c.getPortrait().startsWith("http")) {
            oVar.h(this.f56281c.getPortrait());
            oVar.k(HeadIconRefreshHelper.headPortraitFilter(this.f56281c.getPortrait()));
            oVar.i(true);
        } else {
            oVar.h(HeadIconRefreshHelper.headPortraitFilter(this.f56281c.getPortraitH()));
            oVar.k(HeadIconRefreshHelper.headPortraitFilter(this.f56281c.getPortrait()));
            oVar.i(true);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(oVar);
        this.f56285g.r(oVar, arrayList, 0);
    }

    public final void w() {
        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "6"));
        if (this.f56283e) {
            if (ViewHelper.checkUpIsLogin(this.f56279a.getPageActivity())) {
                UrlManager.getInstance().dealOneLink(this.f56279a, new String[]{TbConfig.URL_MEMBER_BUY});
                return;
            }
            return;
        }
        ArrayList<IconData> tShowInfo = this.f56281c.getTShowInfo();
        if (ListUtils.getItem(tShowInfo, 0) != null) {
            UrlManager.getInstance().dealOneLink(this.f56279a, new String[]{tShowInfo.get(0).getUrl()});
        }
    }

    public final void x() {
        UserData userData = this.f56281c;
        if (userData == null || userData.getLiveRoomInfo() == null || TextUtils.isEmpty(this.f56281c.getLiveRoomInfo().jump_url)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(this.f56279a, new String[]{this.f56281c.getLiveRoomInfo().jump_url}, true);
    }

    public final void y() {
        d.a.k0.i2.e.a aVar = this.f56280b;
        if (aVar == null || aVar.g() == null || TextUtils.isEmpty(this.f56280b.g().f63036b)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(this.f56279a, new String[]{this.f56280b.g().f63036b}, true);
    }

    public final void z() {
        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "4"));
        d.a.j0.l.a.o(this.f56279a.getPageActivity(), this.f56279a.getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + this.f56281c.getUserId(), true, true, true);
    }
}
