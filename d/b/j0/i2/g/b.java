package d.b.j0.i2.g;

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
import d.b.c.e.p.k;
import d.b.i0.j0.c;
import d.b.i0.t.o;
import d.b.j0.i2.d.i;
import java.util.ArrayList;
import tbclient.BaijiahaoInfo;
import tbclient.Profile.NicknameInfo;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f57616a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.j0.i2.e.a f57617b;

    /* renamed from: c  reason: collision with root package name */
    public UserData f57618c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.j0.i2.g.a f57619d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f57620e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.s.e.a f57621f;

    /* renamed from: g  reason: collision with root package name */
    public i f57622g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f57623h = new a();
    public CustomMessageListener i = new C1369b(2001115);

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String intro;
            if (view == b.this.f57619d.z()) {
                b.this.w();
            } else if (view == b.this.f57619d.r()) {
                b.this.r();
            } else if (view != b.this.f57619d.v()) {
                if (view == b.this.f57619d.D()) {
                    if (b.this.f57620e) {
                        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "7"));
                        b.this.E();
                    }
                } else if (view != b.this.f57619d.y() && view != b.this.f57619d.x()) {
                    if (view == b.this.f57619d.C()) {
                        b.this.z();
                    } else if (view == b.this.f57619d.s()) {
                        b.this.s();
                    } else if (view == b.this.f57619d.t()) {
                        b.this.t();
                    } else if (view == b.this.f57619d.u()) {
                        b.this.u();
                    } else if (view == b.this.f57619d.w()) {
                        b.this.v();
                    } else if (view == b.this.f57619d.B()) {
                        if (b.this.f57620e) {
                            TiebaStatic.log(new StatisticItem("c13613").param("obj_param1", "0"));
                        } else {
                            TiebaStatic.log(new StatisticItem("c13613").param("obj_param1", "1"));
                        }
                        b.this.y();
                    } else if (view == b.this.f57619d.A()) {
                        b.this.x();
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", Constants.VIA_REPORT_TYPE_MAKE_FRIEND));
                    if (b.this.f57620e) {
                        if (b.this.f57618c != null && b.this.f57618c.isBaijiahaoUser()) {
                            PersonIntroductionActivity.startPersonIntroductionActivity(b.this.f57616a.getPageActivity(), b.this.f57618c.getIntro());
                        }
                        b.this.E();
                        return;
                    }
                    BaijiahaoInfo baijiahaoInfo = b.this.f57618c.getBaijiahaoInfo();
                    if (baijiahaoInfo == null || k.isEmpty(baijiahaoInfo.auth_desc)) {
                        intro = b.this.f57618c.getIntro();
                    } else {
                        intro = baijiahaoInfo.auth_desc;
                    }
                    PersonIntroductionActivity.startPersonIntroductionActivity(b.this.f57616a.getPageActivity(), intro);
                }
            } else {
                TiebaStatic.log(new StatisticItem("c12503").param("obj_locate", "3"));
                TiebaStatic.log("igift_icon_ck");
                b.this.D();
            }
        }
    }

    /* renamed from: d.b.j0.i2.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1369b extends CustomMessageListener {
        public C1369b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if (!(customResponsedMessage instanceof UpdateAttentionMessage) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f13364c)) {
                return;
            }
            if (updateAttentionMessage.getData().f13362a) {
                Message<?> message = updateAttentionMessage.getmOrginalMessage();
                if (message == null || message.getTag() == null || !message.getTag().equals(b.this.f57616a.getUniqueId())) {
                    return;
                }
                if (updateAttentionMessage.isAttention()) {
                    b.this.f57618c.setLike(true);
                    return;
                }
                if (!updateAttentionMessage.getData().i) {
                    b.this.f57616a.showToast(R.string.unlike_success);
                }
                b.this.f57618c.setLike(false);
                return;
            }
            Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
            if (message2 == null || message2.getTag() == null || !message2.getTag().equals(b.this.f57616a.getUniqueId())) {
                return;
            }
            b.this.f57619d.P(b.this.f57618c.isLike());
            if (updateAttentionMessage.getData() == null || k.isEmpty(updateAttentionMessage.getData().f13363b)) {
                if (b.this.f57618c.getIsLike()) {
                    b.this.f57616a.showToast(R.string.unlike_failure);
                    return;
                } else {
                    b.this.f57616a.showToast(R.string.attention_fail);
                    return;
                }
            }
            b.this.f57616a.showToast(updateAttentionMessage.getData().f13363b);
        }
    }

    public b(TbPageContext tbPageContext, boolean z) {
        this.f57616a = tbPageContext;
        this.f57620e = z;
        this.f57619d = new d.b.j0.i2.g.a(this.f57616a, this.f57620e, this.f57623h);
        this.f57616a.registerListener(this.i);
        TbPageContext tbPageContext2 = this.f57616a;
        this.f57622g = new i(tbPageContext2, tbPageContext2.getUniqueId(), z);
    }

    public void A(Intent intent) {
        i iVar = this.f57622g;
        if (iVar != null) {
            iVar.p(intent);
        }
    }

    public FollowUserSpinnerBtn B() {
        return this.f57619d.r();
    }

    public View C() {
        return this.f57619d.E();
    }

    public final void D() {
        if (ViewHelper.checkUpIsLogin(this.f57616a.getPageActivity())) {
            GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.f57616a.getPageActivity(), this.f57618c.getUserIdLong(), this.f57618c.getUserName(), this.f57618c.getName_show(), GiftTabActivityConfig.FROM_PERSON_CENTER, 24001);
            giftTabActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_HE_HER_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, giftTabActivityConfig));
        }
    }

    public final void E() {
        if (TbadkCoreApplication.getCurrentAccountInfo() == null) {
            return;
        }
        PersonChangeData personChangeData = new PersonChangeData();
        UserData userData = this.f57618c;
        if (userData != null) {
            personChangeData.setPortrait(userData.getPortrait());
            personChangeData.setName(this.f57618c.getUserName());
            personChangeData.setSex(this.f57618c.getSex());
            personChangeData.setIntro(this.f57618c.getIntro());
            personChangeData.setNameShow(this.f57618c.getName_show());
            personChangeData.setMem(this.f57618c.getIsMem());
            personChangeData.setForumAge(this.f57618c.getTb_age());
            personChangeData.setCanModifyAvatar(this.f57618c.canModifyAvatar());
            personChangeData.setCantModifyAvatarDesc(this.f57618c.getCantModifyAvatarDesc());
            AlaUserInfoData alaUserInfoData = this.f57618c.alaUserData;
            if (alaUserInfoData != null) {
                personChangeData.setAlaId(alaUserInfoData.ala_id);
            }
            NicknameInfo nicknameInfo = this.f57617b.A;
            if (nicknameInfo != null) {
                personChangeData.setNickNameLeftDays(nicknameInfo.left_days.intValue());
            }
            if (this.f57618c.getBirthdayInfo() != null) {
                personChangeData.setUserAge(this.f57618c.getBirthdayInfo().f51545c);
                personChangeData.setBirthdayTime(this.f57618c.getBirthdayInfo().f51543a);
                personChangeData.setBirthdayShowStatus(this.f57618c.getBirthdayInfo().f51546d);
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(this.f57616a.getPageActivity(), 101, personChangeData, Boolean.FALSE)));
    }

    public void F(int i) {
        d.b.j0.i2.g.a aVar = this.f57619d;
        if (aVar != null) {
            aVar.H(i);
        }
    }

    public void G() {
        i iVar = this.f57622g;
        if (iVar != null) {
            iVar.z();
        }
        d.b.j0.i2.g.a aVar = this.f57619d;
        if (aVar != null) {
            aVar.I();
        }
    }

    public void H() {
        this.f57619d.J();
    }

    public void I(d.b.j0.i2.d.a aVar) {
        this.f57619d.K(aVar);
    }

    public void J(boolean z) {
        this.f57619d.L(z);
    }

    public void K(boolean z) {
        this.f57619d.M(z);
    }

    public final void L(int i) {
        BdToast.i(this.f57616a.getPageActivity(), String.format(this.f57616a.getString(R.string.person_privacy_toast), StringHelper.getUserDescByGender(i)), R.drawable.icon_pure_toast_mistake40_svg, true).q();
    }

    public void M() {
        this.f57619d.N();
    }

    public void N(String str) {
        d.b.j0.i2.g.a aVar = this.f57619d;
        if (aVar != null) {
            aVar.Q(str);
        }
    }

    public void p(d.b.j0.i2.e.a aVar) {
        if (aVar == null || aVar.j() == null) {
            return;
        }
        this.f57617b = aVar;
        this.f57618c = aVar.j();
        this.f57619d.q(this.f57617b.j(), this.f57617b.g());
        this.f57622g.B(aVar);
    }

    public void q() {
        i iVar = this.f57622g;
        if (iVar != null) {
            iVar.o();
        }
    }

    public final void r() {
        if (ViewHelper.checkUpIsLogin(this.f57616a.getPageActivity())) {
            if (this.f57621f == null) {
                d.b.i0.s.e.a aVar = new d.b.i0.s.e.a(this.f57616a);
                this.f57621f = aVar;
                aVar.j(true);
            }
            this.f57621f.m(!this.f57618c.isLike(), this.f57618c.getPortrait(), this.f57618c.getUserId(), this.f57618c.isGod(), "2", this.f57616a.getUniqueId(), null, "0");
            this.f57619d.P(true ^ this.f57618c.isLike());
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_CONCERN_BTN_CLICK);
            statisticItem.param("obj_id", this.f57618c.getUserId());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TbPageContext tbPageContext = this.f57616a;
            if (tbPageContext != null && tbPageContext.getPageActivity() != null && this.f57616a.getPageActivity().getIntent() != null) {
                statisticItem.param("nid", this.f57616a.getPageActivity().getIntent().getStringExtra("nid"));
            }
            TbPageContext tbPageContext2 = this.f57616a;
            if (tbPageContext2 != null) {
                c.e(tbPageContext2.getPageActivity(), statisticItem);
            }
            TbPageContext tbPageContext3 = this.f57616a;
            if (tbPageContext3 != null && tbPageContext3.getPageActivity() != null && c.j(this.f57616a.getPageActivity()) != null && c.j(this.f57616a.getPageActivity()).b() != null && !TextUtils.isEmpty(c.j(this.f57616a.getPageActivity()).b().locatePage) && "a002".equals(c.j(this.f57616a.getPageActivity()).b().locatePage)) {
                statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, c.j(this.f57616a.getPageActivity()).b().locatePage);
                statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a011");
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void s() {
        StatisticItem statisticItem = new StatisticItem("c13575");
        statisticItem.param("obj_type", this.f57620e ? 1 : 0);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(statisticItem);
        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9));
        if (ViewHelper.checkUpIsLogin(this.f57616a.getPageActivity())) {
            TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 2).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f57618c.getUserId()) ? 1 : 2).param("obj_source", this.f57618c.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.f57616a.getPageActivity(), true, this.f57618c.getUserId(), this.f57618c.getSex()).updateFollowNum(this.f57618c.getConcernNum(), this.f57618c.getPortrait())));
        }
    }

    public final void t() {
        StatisticItem statisticItem = new StatisticItem("c13573");
        statisticItem.param("obj_type", this.f57620e ? 1 : 0);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(statisticItem);
        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "8"));
        if (ViewHelper.checkUpIsLogin(this.f57616a.getPageActivity())) {
            d.b.j0.t2.a.v().L(2, false, this.f57620e);
            TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 3).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f57618c.getUserId()) ? 1 : 2).param("obj_source", this.f57618c.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.f57616a.getPageActivity(), false, this.f57618c.getUserId(), this.f57618c.getSex())));
        }
    }

    public final void u() {
        StatisticItem statisticItem = new StatisticItem("c13574");
        statisticItem.param("obj_type", this.f57620e ? 1 : 0);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(statisticItem);
        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "10"));
        if (ViewHelper.checkUpIsLogin(this.f57616a.getPageActivity())) {
            boolean equals = TbadkCoreApplication.getCurrentAccount().equals(this.f57618c.getUserId());
            boolean z = this.f57618c.getIsFriend() == 1;
            if (this.f57618c.getPersonPrivate() == null) {
                L(this.f57618c.getSex());
            } else if (this.f57618c.getPersonPrivate().s() != 1 && !equals && (!z || this.f57618c.getPersonPrivate().s() != 2)) {
                L(this.f57618c.getSex());
            } else {
                TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 4).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f57618c.getUserId()) ? 1 : 2).param("obj_source", this.f57618c.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.f57616a.getPageActivity(), this.f57618c.getLike_bars(), this.f57618c.getUserId(), this.f57618c.getSex())));
            }
        }
    }

    public final void v() {
        AlaUserInfoData alaUserData = this.f57618c.getAlaUserData();
        if (!this.f57620e && alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
            TiebaStatic.log("c12542");
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = alaUserData.live_id;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.f57616a.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_ATTENTION, null, false, "")));
            return;
        }
        o oVar = new o();
        if (this.f57618c.getBaijiahaoInfo() != null && !TextUtils.isEmpty(this.f57618c.getBaijiahaoInfo().avatar)) {
            oVar.g(this.f57618c.getBaijiahaoInfo().avatar);
            oVar.k(this.f57618c.getBaijiahaoInfo().avatar);
            oVar.j(true);
        } else if (!StringUtils.isNull(this.f57618c.getPortrait()) && this.f57618c.getPortrait().startsWith("http")) {
            oVar.g(this.f57618c.getPortrait());
            oVar.k(HeadIconRefreshHelper.headPortraitFilter(this.f57618c.getPortrait()));
            oVar.j(true);
        } else {
            oVar.g(HeadIconRefreshHelper.headPortraitFilter(this.f57618c.getPortraitH()));
            oVar.k(HeadIconRefreshHelper.headPortraitFilter(this.f57618c.getPortrait()));
            oVar.j(true);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(oVar);
        this.f57622g.r(oVar, arrayList, 0);
    }

    public final void w() {
        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "6"));
        if (this.f57620e) {
            if (ViewHelper.checkUpIsLogin(this.f57616a.getPageActivity())) {
                UrlManager.getInstance().dealOneLink(this.f57616a, new String[]{TbConfig.URL_MEMBER_BUY});
                return;
            }
            return;
        }
        ArrayList<IconData> tShowInfo = this.f57618c.getTShowInfo();
        if (ListUtils.getItem(tShowInfo, 0) != null) {
            UrlManager.getInstance().dealOneLink(this.f57616a, new String[]{tShowInfo.get(0).getUrl()});
        }
    }

    public final void x() {
        UserData userData = this.f57618c;
        if (userData == null || userData.getLiveRoomInfo() == null || TextUtils.isEmpty(this.f57618c.getLiveRoomInfo().jump_url)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(this.f57616a, new String[]{this.f57618c.getLiveRoomInfo().jump_url}, true);
    }

    public final void y() {
        d.b.j0.i2.e.a aVar = this.f57617b;
        if (aVar == null || aVar.g() == null || TextUtils.isEmpty(this.f57617b.g().f64062b)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(this.f57616a, new String[]{this.f57617b.g().f64062b}, true);
    }

    public final void z() {
        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "4"));
        d.b.i0.l.a.o(this.f57616a.getPageActivity(), this.f57616a.getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + this.f57618c.getUserId(), true, true, true);
    }
}
