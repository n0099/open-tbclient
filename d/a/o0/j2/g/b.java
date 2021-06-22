package d.a.o0.j2.g;

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
import d.a.c.e.p.k;
import d.a.n0.j0.c;
import d.a.n0.t.o;
import d.a.o0.j2.d.i;
import java.util.ArrayList;
import tbclient.BaijiahaoInfo;
import tbclient.Profile.NicknameInfo;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60277a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.j2.e.a f60278b;

    /* renamed from: c  reason: collision with root package name */
    public UserData f60279c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.o0.j2.g.a f60280d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f60281e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.s.e.a f60282f;

    /* renamed from: g  reason: collision with root package name */
    public i f60283g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f60284h = new a();

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f60285i = new C1458b(2001115);

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String intro;
            if (view == b.this.f60280d.z()) {
                b.this.w();
            } else if (view == b.this.f60280d.r()) {
                b.this.r();
            } else if (view != b.this.f60280d.v()) {
                if (view == b.this.f60280d.D()) {
                    if (b.this.f60281e) {
                        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "7"));
                        b.this.E();
                    }
                } else if (view != b.this.f60280d.y() && view != b.this.f60280d.x()) {
                    if (view == b.this.f60280d.C()) {
                        b.this.z();
                    } else if (view == b.this.f60280d.s()) {
                        b.this.s();
                    } else if (view == b.this.f60280d.t()) {
                        b.this.t();
                    } else if (view == b.this.f60280d.u()) {
                        b.this.u();
                    } else if (view == b.this.f60280d.w()) {
                        b.this.v();
                    } else if (view == b.this.f60280d.B()) {
                        if (b.this.f60281e) {
                            TiebaStatic.log(new StatisticItem("c13613").param("obj_param1", "0"));
                        } else {
                            TiebaStatic.log(new StatisticItem("c13613").param("obj_param1", "1"));
                        }
                        b.this.y();
                    } else if (view == b.this.f60280d.A()) {
                        b.this.x();
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "14"));
                    if (b.this.f60281e) {
                        if (b.this.f60279c != null && b.this.f60279c.isBaijiahaoUser()) {
                            PersonIntroductionActivity.startPersonIntroductionActivity(b.this.f60277a.getPageActivity(), b.this.f60279c.getIntro());
                        }
                        b.this.E();
                        return;
                    }
                    BaijiahaoInfo baijiahaoInfo = b.this.f60279c.getBaijiahaoInfo();
                    if (baijiahaoInfo == null || k.isEmpty(baijiahaoInfo.auth_desc)) {
                        intro = b.this.f60279c.getIntro();
                    } else {
                        intro = baijiahaoInfo.auth_desc;
                    }
                    PersonIntroductionActivity.startPersonIntroductionActivity(b.this.f60277a.getPageActivity(), intro);
                }
            } else {
                TiebaStatic.log(new StatisticItem("c12503").param("obj_locate", "3"));
                TiebaStatic.log("igift_icon_ck");
                b.this.D();
            }
        }
    }

    /* renamed from: d.a.o0.j2.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1458b extends CustomMessageListener {
        public C1458b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if (!(customResponsedMessage instanceof UpdateAttentionMessage) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f12720c)) {
                return;
            }
            if (updateAttentionMessage.getData().f12718a) {
                Message<?> message = updateAttentionMessage.getmOrginalMessage();
                if (message == null || message.getTag() == null || !message.getTag().equals(b.this.f60277a.getUniqueId())) {
                    return;
                }
                if (updateAttentionMessage.isAttention()) {
                    b.this.f60279c.setLike(true);
                    return;
                }
                if (!updateAttentionMessage.getData().j) {
                    b.this.f60277a.showToast(R.string.unlike_success);
                }
                b.this.f60279c.setLike(false);
                return;
            }
            Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
            if (message2 == null || message2.getTag() == null || !message2.getTag().equals(b.this.f60277a.getUniqueId())) {
                return;
            }
            b.this.f60280d.P(b.this.f60279c.isLike());
            if (updateAttentionMessage.getData() == null || k.isEmpty(updateAttentionMessage.getData().f12719b)) {
                if (b.this.f60279c.getIsLike()) {
                    b.this.f60277a.showToast(R.string.unlike_failure);
                    return;
                } else {
                    b.this.f60277a.showToast(R.string.attention_fail);
                    return;
                }
            }
            b.this.f60277a.showToast(updateAttentionMessage.getData().f12719b);
        }
    }

    public b(TbPageContext tbPageContext, boolean z) {
        this.f60277a = tbPageContext;
        this.f60281e = z;
        this.f60280d = new d.a.o0.j2.g.a(this.f60277a, this.f60281e, this.f60284h);
        this.f60277a.registerListener(this.f60285i);
        TbPageContext tbPageContext2 = this.f60277a;
        this.f60283g = new i(tbPageContext2, tbPageContext2.getUniqueId(), z);
    }

    public void A(Intent intent) {
        i iVar = this.f60283g;
        if (iVar != null) {
            iVar.p(intent);
        }
    }

    public FollowUserSpinnerBtn B() {
        return this.f60280d.r();
    }

    public View C() {
        return this.f60280d.E();
    }

    public final void D() {
        if (ViewHelper.checkUpIsLogin(this.f60277a.getPageActivity())) {
            GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.f60277a.getPageActivity(), this.f60279c.getUserIdLong(), this.f60279c.getUserName(), this.f60279c.getName_show(), GiftTabActivityConfig.FROM_PERSON_CENTER, 24001);
            giftTabActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_HE_HER_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, giftTabActivityConfig));
        }
    }

    public final void E() {
        if (TbadkCoreApplication.getCurrentAccountInfo() == null) {
            return;
        }
        PersonChangeData personChangeData = new PersonChangeData();
        UserData userData = this.f60279c;
        if (userData != null) {
            personChangeData.setPortrait(userData.getPortrait());
            personChangeData.setName(this.f60279c.getUserName());
            personChangeData.setSex(this.f60279c.getSex());
            personChangeData.setIntro(this.f60279c.getIntro());
            personChangeData.setNameShow(this.f60279c.getName_show());
            personChangeData.setMem(this.f60279c.getIsMem());
            personChangeData.setForumAge(this.f60279c.getTb_age());
            personChangeData.setCanModifyAvatar(this.f60279c.canModifyAvatar());
            personChangeData.setCantModifyAvatarDesc(this.f60279c.getCantModifyAvatarDesc());
            personChangeData.setTiebaId(this.f60279c.getmTiebaUid());
            AlaUserInfoData alaUserInfoData = this.f60279c.alaUserData;
            if (alaUserInfoData != null) {
                personChangeData.setAlaId(alaUserInfoData.ala_id);
            }
            NicknameInfo nicknameInfo = this.f60278b.A;
            if (nicknameInfo != null) {
                personChangeData.setNickNameLeftDays(nicknameInfo.left_days.intValue());
            }
            if (this.f60279c.getBirthdayInfo() != null) {
                personChangeData.setUserAge(this.f60279c.getBirthdayInfo().f53819c);
                personChangeData.setBirthdayTime(this.f60279c.getBirthdayInfo().f53817a);
                personChangeData.setBirthdayShowStatus(this.f60279c.getBirthdayInfo().f53820d);
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(this.f60277a.getPageActivity(), 101, personChangeData, Boolean.FALSE)));
    }

    public void F(int i2) {
        d.a.o0.j2.g.a aVar = this.f60280d;
        if (aVar != null) {
            aVar.H(i2);
        }
    }

    public void G() {
        i iVar = this.f60283g;
        if (iVar != null) {
            iVar.y();
        }
        d.a.o0.j2.g.a aVar = this.f60280d;
        if (aVar != null) {
            aVar.I();
        }
    }

    public void H() {
        this.f60280d.J();
    }

    public void I(d.a.o0.j2.d.a aVar) {
        this.f60280d.K(aVar);
    }

    public void J(boolean z) {
        this.f60280d.L(z);
    }

    public void K(boolean z) {
        this.f60280d.M(z);
    }

    public final void L(int i2) {
        BdToast.i(this.f60277a.getPageActivity(), String.format(this.f60277a.getString(R.string.person_privacy_toast), StringHelper.getUserDescByGender(i2)), R.drawable.icon_pure_toast_mistake40_svg, true).q();
    }

    public void M() {
        this.f60280d.N();
    }

    public void N(String str) {
        d.a.o0.j2.g.a aVar = this.f60280d;
        if (aVar != null) {
            aVar.Q(str);
        }
    }

    public void p(d.a.o0.j2.e.a aVar) {
        if (aVar == null || aVar.j() == null) {
            return;
        }
        this.f60278b = aVar;
        this.f60279c = aVar.j();
        this.f60280d.q(this.f60278b.j(), this.f60278b.g());
        this.f60283g.A(aVar);
    }

    public void q() {
        i iVar = this.f60283g;
        if (iVar != null) {
            iVar.o();
        }
    }

    public final void r() {
        if (ViewHelper.checkUpIsLogin(this.f60277a.getPageActivity())) {
            if (this.f60282f == null) {
                d.a.n0.s.e.a aVar = new d.a.n0.s.e.a(this.f60277a);
                this.f60282f = aVar;
                aVar.j(true);
            }
            this.f60282f.m(!this.f60279c.isLike(), this.f60279c.getPortrait(), this.f60279c.getUserId(), this.f60279c.isGod(), "2", this.f60277a.getUniqueId(), null, "0");
            this.f60280d.P(true ^ this.f60279c.isLike());
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_CONCERN_BTN_CLICK);
            statisticItem.param("obj_id", this.f60279c.getUserId());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TbPageContext tbPageContext = this.f60277a;
            if (tbPageContext != null && tbPageContext.getPageActivity() != null && this.f60277a.getPageActivity().getIntent() != null) {
                statisticItem.param("nid", this.f60277a.getPageActivity().getIntent().getStringExtra("nid"));
            }
            TbPageContext tbPageContext2 = this.f60277a;
            if (tbPageContext2 != null) {
                c.e(tbPageContext2.getPageActivity(), statisticItem);
            }
            TbPageContext tbPageContext3 = this.f60277a;
            if (tbPageContext3 != null && tbPageContext3.getPageActivity() != null && c.j(this.f60277a.getPageActivity()) != null && c.j(this.f60277a.getPageActivity()).b() != null && !TextUtils.isEmpty(c.j(this.f60277a.getPageActivity()).b().locatePage) && "a002".equals(c.j(this.f60277a.getPageActivity()).b().locatePage)) {
                statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, c.j(this.f60277a.getPageActivity()).b().locatePage);
                statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a011");
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void s() {
        StatisticItem statisticItem = new StatisticItem("c13575");
        statisticItem.param("obj_type", this.f60281e ? 1 : 0);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(statisticItem);
        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "9"));
        if (ViewHelper.checkUpIsLogin(this.f60277a.getPageActivity())) {
            TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 2).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f60279c.getUserId()) ? 1 : 2).param("obj_source", this.f60279c.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.f60277a.getPageActivity(), true, this.f60279c.getUserId(), this.f60279c.getSex()).updateFollowNum(this.f60279c.getConcernNum(), this.f60279c.getPortrait())));
        }
    }

    public final void t() {
        StatisticItem statisticItem = new StatisticItem("c13573");
        statisticItem.param("obj_type", this.f60281e ? 1 : 0);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(statisticItem);
        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "8"));
        if (ViewHelper.checkUpIsLogin(this.f60277a.getPageActivity())) {
            d.a.o0.u2.a.v().L(2, false, this.f60281e);
            TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 3).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f60279c.getUserId()) ? 1 : 2).param("obj_source", this.f60279c.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.f60277a.getPageActivity(), false, this.f60279c.getUserId(), this.f60279c.getSex())));
        }
    }

    public final void u() {
        StatisticItem statisticItem = new StatisticItem("c13574");
        statisticItem.param("obj_type", this.f60281e ? 1 : 0);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(statisticItem);
        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "10"));
        if (ViewHelper.checkUpIsLogin(this.f60277a.getPageActivity())) {
            boolean equals = TbadkCoreApplication.getCurrentAccount().equals(this.f60279c.getUserId());
            boolean z = this.f60279c.getIsFriend() == 1;
            if (this.f60279c.getPersonPrivate() == null) {
                L(this.f60279c.getSex());
            } else if (this.f60279c.getPersonPrivate().w() != 1 && !equals && (!z || this.f60279c.getPersonPrivate().w() != 2)) {
                L(this.f60279c.getSex());
            } else {
                TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 4).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f60279c.getUserId()) ? 1 : 2).param("obj_source", this.f60279c.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.f60277a.getPageActivity(), this.f60279c.getLike_bars(), this.f60279c.getUserId(), this.f60279c.getSex())));
            }
        }
    }

    public final void v() {
        AlaUserInfoData alaUserData = this.f60279c.getAlaUserData();
        if (!this.f60281e && alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
            TiebaStatic.log("c12542");
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = alaUserData.live_id;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.f60277a.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_ATTENTION, null, false, "")));
            return;
        }
        o oVar = new o();
        if (this.f60279c.getBaijiahaoInfo() != null && !TextUtils.isEmpty(this.f60279c.getBaijiahaoInfo().avatar)) {
            oVar.g(this.f60279c.getBaijiahaoInfo().avatar);
            oVar.i(this.f60279c.getBaijiahaoInfo().avatar);
            oVar.h(true);
        } else if (!StringUtils.isNull(this.f60279c.getPortrait()) && this.f60279c.getPortrait().startsWith("http")) {
            oVar.g(this.f60279c.getPortrait());
            oVar.i(HeadIconRefreshHelper.headPortraitFilter(this.f60279c.getPortrait()));
            oVar.h(true);
        } else {
            oVar.g(HeadIconRefreshHelper.headPortraitFilter(this.f60279c.getPortraitH()));
            oVar.i(HeadIconRefreshHelper.headPortraitFilter(this.f60279c.getPortrait()));
            oVar.h(true);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(oVar);
        this.f60283g.r(oVar, arrayList, 0);
    }

    public final void w() {
        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "6"));
        if (this.f60281e) {
            if (ViewHelper.checkUpIsLogin(this.f60277a.getPageActivity())) {
                UrlManager.getInstance().dealOneLink(this.f60277a, new String[]{TbConfig.URL_MEMBER_BUY});
                return;
            }
            return;
        }
        ArrayList<IconData> tShowInfo = this.f60279c.getTShowInfo();
        if (ListUtils.getItem(tShowInfo, 0) != null) {
            UrlManager.getInstance().dealOneLink(this.f60277a, new String[]{tShowInfo.get(0).getUrl()});
        }
    }

    public final void x() {
        UserData userData = this.f60279c;
        if (userData == null || userData.getLiveRoomInfo() == null || TextUtils.isEmpty(this.f60279c.getLiveRoomInfo().jump_url)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(this.f60277a, new String[]{this.f60279c.getLiveRoomInfo().jump_url}, true);
    }

    public final void y() {
        d.a.o0.j2.e.a aVar = this.f60278b;
        if (aVar == null || aVar.g() == null || TextUtils.isEmpty(this.f60278b.g().f67061b)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(this.f60277a, new String[]{this.f60278b.g().f67061b}, true);
    }

    public final void z() {
        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "4"));
        d.a.n0.l.a.o(this.f60277a.getPageActivity(), this.f60277a.getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + this.f60279c.getUserId(), true, true, true);
    }
}
