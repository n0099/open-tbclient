package d.a.s0.m2.g;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.r0.j0.c;
import d.a.r0.t.o;
import d.a.s0.m2.d.i;
import java.util.ArrayList;
import tbclient.BaijiahaoInfo;
import tbclient.Profile.NicknameInfo;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f63544a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.s0.m2.e.a f63545b;

    /* renamed from: c  reason: collision with root package name */
    public UserData f63546c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.s0.m2.g.a f63547d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f63548e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.r0.s.e.a f63549f;

    /* renamed from: g  reason: collision with root package name */
    public i f63550g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f63551h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f63552i;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f63553e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63553e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String intro;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f63553e.f63547d.z()) {
                    this.f63553e.w();
                } else if (view == this.f63553e.f63547d.r()) {
                    this.f63553e.r();
                } else if (view != this.f63553e.f63547d.v()) {
                    if (view == this.f63553e.f63547d.D()) {
                        if (this.f63553e.f63548e) {
                            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "7"));
                            this.f63553e.E();
                        }
                    } else if (view != this.f63553e.f63547d.y() && view != this.f63553e.f63547d.x()) {
                        if (view == this.f63553e.f63547d.C()) {
                            this.f63553e.z();
                        } else if (view == this.f63553e.f63547d.s()) {
                            this.f63553e.s();
                        } else if (view == this.f63553e.f63547d.t()) {
                            this.f63553e.t();
                        } else if (view == this.f63553e.f63547d.u()) {
                            this.f63553e.u();
                        } else if (view == this.f63553e.f63547d.w()) {
                            this.f63553e.v();
                        } else if (view == this.f63553e.f63547d.B()) {
                            if (this.f63553e.f63548e) {
                                TiebaStatic.log(new StatisticItem("c13613").param("obj_param1", "0"));
                            } else {
                                TiebaStatic.log(new StatisticItem("c13613").param("obj_param1", "1"));
                            }
                            this.f63553e.y();
                        } else if (view == this.f63553e.f63547d.A()) {
                            this.f63553e.x();
                        }
                    } else {
                        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "14"));
                        if (this.f63553e.f63548e) {
                            if (this.f63553e.f63546c != null && this.f63553e.f63546c.isBaijiahaoUser()) {
                                PersonIntroductionActivity.startPersonIntroductionActivity(this.f63553e.f63544a.getPageActivity(), this.f63553e.f63546c.getIntro());
                            }
                            this.f63553e.E();
                            return;
                        }
                        BaijiahaoInfo baijiahaoInfo = this.f63553e.f63546c.getBaijiahaoInfo();
                        if (baijiahaoInfo == null || k.isEmpty(baijiahaoInfo.auth_desc)) {
                            intro = this.f63553e.f63546c.getIntro();
                        } else {
                            intro = baijiahaoInfo.auth_desc;
                        }
                        PersonIntroductionActivity.startPersonIntroductionActivity(this.f63553e.f63544a.getPageActivity(), intro);
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12503").param("obj_locate", "3"));
                    TiebaStatic.log("igift_icon_ck");
                    this.f63553e.D();
                }
            }
        }
    }

    /* renamed from: d.a.s0.m2.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1588b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f63554a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1588b(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63554a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || !(customResponsedMessage instanceof UpdateAttentionMessage) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f12802c)) {
                return;
            }
            if (updateAttentionMessage.getData().f12800a) {
                Message<?> message = updateAttentionMessage.getmOrginalMessage();
                if (message == null || message.getTag() == null || !message.getTag().equals(this.f63554a.f63544a.getUniqueId())) {
                    return;
                }
                if (updateAttentionMessage.isAttention()) {
                    this.f63554a.f63546c.setLike(true);
                    return;
                }
                if (!updateAttentionMessage.getData().j) {
                    this.f63554a.f63544a.showToast(R.string.unlike_success);
                }
                this.f63554a.f63546c.setLike(false);
                return;
            }
            Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
            if (message2 == null || message2.getTag() == null || !message2.getTag().equals(this.f63554a.f63544a.getUniqueId())) {
                return;
            }
            this.f63554a.f63547d.N(this.f63554a.f63546c.isLike());
            if (updateAttentionMessage.getData() == null || k.isEmpty(updateAttentionMessage.getData().f12801b)) {
                if (this.f63554a.f63546c.getIsLike()) {
                    this.f63554a.f63544a.showToast(R.string.unlike_failure);
                    return;
                } else {
                    this.f63554a.f63544a.showToast(R.string.attention_fail);
                    return;
                }
            }
            this.f63554a.f63544a.showToast(updateAttentionMessage.getData().f12801b);
        }
    }

    public b(TbPageContext tbPageContext, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63551h = new a(this);
        this.f63552i = new C1588b(this, 2001115);
        this.f63544a = tbPageContext;
        this.f63548e = z;
        this.f63547d = new d.a.s0.m2.g.a(this.f63544a, this.f63548e, this.f63551h);
        this.f63544a.registerListener(this.f63552i);
        TbPageContext tbPageContext2 = this.f63544a;
        this.f63550g = new i(tbPageContext2, tbPageContext2.getUniqueId(), z);
    }

    public void A(Intent intent) {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, intent) == null) || (iVar = this.f63550g) == null) {
            return;
        }
        iVar.p(intent);
    }

    public FollowUserSpinnerBtn B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f63547d.r() : (FollowUserSpinnerBtn) invokeV.objValue;
    }

    public View C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f63547d.E() : (View) invokeV.objValue;
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && ViewHelper.checkUpIsLogin(this.f63544a.getPageActivity())) {
            GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.f63544a.getPageActivity(), this.f63546c.getUserIdLong(), this.f63546c.getUserName(), this.f63546c.getName_show(), GiftTabActivityConfig.FROM_PERSON_CENTER, 24001);
            giftTabActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_HE_HER_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, giftTabActivityConfig));
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || TbadkCoreApplication.getCurrentAccountInfo() == null) {
            return;
        }
        PersonChangeData personChangeData = new PersonChangeData();
        UserData userData = this.f63546c;
        if (userData != null) {
            personChangeData.setPortrait(userData.getPortrait());
            personChangeData.setName(this.f63546c.getUserName());
            personChangeData.setSex(this.f63546c.getSex());
            personChangeData.setIntro(this.f63546c.getIntro());
            personChangeData.setNameShow(this.f63546c.getName_show());
            personChangeData.setMem(this.f63546c.getIsMem());
            personChangeData.setForumAge(this.f63546c.getTb_age());
            personChangeData.setCanModifyAvatar(this.f63546c.canModifyAvatar());
            personChangeData.setCantModifyAvatarDesc(this.f63546c.getCantModifyAvatarDesc());
            personChangeData.setTiebaId(this.f63546c.getmTiebaUid());
            AlaUserInfoData alaUserInfoData = this.f63546c.alaUserData;
            if (alaUserInfoData != null) {
                personChangeData.setAlaId(alaUserInfoData.ala_id);
            }
            NicknameInfo nicknameInfo = this.f63545b.A;
            if (nicknameInfo != null) {
                personChangeData.setNickNameLeftDays(nicknameInfo.left_days.intValue());
            }
            if (this.f63546c.getBirthdayInfo() != null) {
                personChangeData.setUserAge(this.f63546c.getBirthdayInfo().f55974c);
                personChangeData.setBirthdayTime(this.f63546c.getBirthdayInfo().f55972a);
                personChangeData.setBirthdayShowStatus(this.f63546c.getBirthdayInfo().f55975d);
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(this.f63544a.getPageActivity(), 101, personChangeData, Boolean.FALSE)));
    }

    public void F(int i2) {
        d.a.s0.m2.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (aVar = this.f63547d) == null) {
            return;
        }
        aVar.H(i2);
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            i iVar = this.f63550g;
            if (iVar != null) {
                iVar.y();
            }
            d.a.s0.m2.g.a aVar = this.f63547d;
            if (aVar != null) {
                aVar.I();
            }
        }
    }

    public void H(d.a.s0.m2.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f63547d.K(aVar);
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f63547d.L(z);
        }
    }

    public final void J(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            BdToast.i(this.f63544a.getPageActivity(), String.format(this.f63544a.getString(R.string.person_privacy_toast), StringHelper.getUserDescByGender(i2)), R.drawable.icon_pure_toast_mistake40_svg, true).q();
        }
    }

    public void K(String str) {
        d.a.s0.m2.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || (aVar = this.f63547d) == null) {
            return;
        }
        aVar.O(str);
    }

    public void p(d.a.s0.m2.e.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) || aVar == null || aVar.j() == null) {
            return;
        }
        this.f63545b = aVar;
        this.f63546c = aVar.j();
        this.f63547d.q(this.f63545b.j(), this.f63545b.g());
        this.f63550g.A(aVar);
    }

    public void q() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (iVar = this.f63550g) == null) {
            return;
        }
        iVar.o();
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && ViewHelper.checkUpIsLogin(this.f63544a.getPageActivity())) {
            if (this.f63549f == null) {
                d.a.r0.s.e.a aVar = new d.a.r0.s.e.a(this.f63544a);
                this.f63549f = aVar;
                aVar.j(true);
            }
            this.f63549f.m(!this.f63546c.isLike(), this.f63546c.getPortrait(), this.f63546c.getUserId(), this.f63546c.isGod(), "2", this.f63544a.getUniqueId(), null, "0");
            this.f63547d.N(true ^ this.f63546c.isLike());
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_CONCERN_BTN_CLICK);
            statisticItem.param("obj_id", this.f63546c.getUserId());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TbPageContext tbPageContext = this.f63544a;
            if (tbPageContext != null && tbPageContext.getPageActivity() != null && this.f63544a.getPageActivity().getIntent() != null) {
                statisticItem.param("nid", this.f63544a.getPageActivity().getIntent().getStringExtra("nid"));
            }
            TbPageContext tbPageContext2 = this.f63544a;
            if (tbPageContext2 != null) {
                c.e(tbPageContext2.getPageActivity(), statisticItem);
            }
            TbPageContext tbPageContext3 = this.f63544a;
            if (tbPageContext3 != null && tbPageContext3.getPageActivity() != null && c.j(this.f63544a.getPageActivity()) != null && c.j(this.f63544a.getPageActivity()).b() != null && !TextUtils.isEmpty(c.j(this.f63544a.getPageActivity()).b().locatePage) && "a002".equals(c.j(this.f63544a.getPageActivity()).b().locatePage)) {
                statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, c.j(this.f63544a.getPageActivity()).b().locatePage);
                statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a011");
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13575");
            statisticItem.param("obj_type", this.f63548e ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "9"));
            if (ViewHelper.checkUpIsLogin(this.f63544a.getPageActivity())) {
                TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 2).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f63546c.getUserId()) ? 1 : 2).param("obj_source", this.f63546c.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.f63544a.getPageActivity(), true, this.f63546c.getUserId(), this.f63546c.getSex()).updateFollowNum(this.f63546c.getConcernNum(), this.f63546c.getPortrait())));
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13573");
            statisticItem.param("obj_type", this.f63548e ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "8"));
            if (ViewHelper.checkUpIsLogin(this.f63544a.getPageActivity())) {
                d.a.s0.x2.a.v().L(2, false, this.f63548e);
                TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 3).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f63546c.getUserId()) ? 1 : 2).param("obj_source", this.f63546c.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.f63544a.getPageActivity(), false, this.f63546c.getUserId(), this.f63546c.getSex())));
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13574");
            statisticItem.param("obj_type", this.f63548e ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "10"));
            if (ViewHelper.checkUpIsLogin(this.f63544a.getPageActivity())) {
                boolean equals = TbadkCoreApplication.getCurrentAccount().equals(this.f63546c.getUserId());
                boolean z = this.f63546c.getIsFriend() == 1;
                if (this.f63546c.getPersonPrivate() == null) {
                    J(this.f63546c.getSex());
                } else if (this.f63546c.getPersonPrivate().w() != 1 && !equals && (!z || this.f63546c.getPersonPrivate().w() != 2)) {
                    J(this.f63546c.getSex());
                } else {
                    TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 4).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f63546c.getUserId()) ? 1 : 2).param("obj_source", this.f63546c.isGod() ? 1 : 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.f63544a.getPageActivity(), this.f63546c.getLike_bars(), this.f63546c.getUserId(), this.f63546c.getSex())));
                }
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            AlaUserInfoData alaUserData = this.f63546c.getAlaUserData();
            if (!this.f63548e && alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                TiebaStatic.log("c12542");
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = alaUserData.live_id;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.f63544a.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_ATTENTION, null, false, "")));
                return;
            }
            o oVar = new o();
            if (this.f63546c.getBaijiahaoInfo() != null && !TextUtils.isEmpty(this.f63546c.getBaijiahaoInfo().avatar)) {
                oVar.e(this.f63546c.getBaijiahaoInfo().avatar);
                oVar.i(this.f63546c.getBaijiahaoInfo().avatar);
                oVar.h(true);
            } else if (!StringUtils.isNull(this.f63546c.getPortrait()) && this.f63546c.getPortrait().startsWith("http")) {
                oVar.e(this.f63546c.getPortrait());
                oVar.i(HeadIconRefreshHelper.headPortraitFilter(this.f63546c.getPortrait()));
                oVar.h(true);
            } else {
                oVar.e(HeadIconRefreshHelper.headPortraitFilter(this.f63546c.getPortraitH()));
                oVar.i(HeadIconRefreshHelper.headPortraitFilter(this.f63546c.getPortrait()));
                oVar.h(true);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(oVar);
            this.f63550g.r(oVar, arrayList, 0);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "6"));
            if (this.f63548e) {
                if (ViewHelper.checkUpIsLogin(this.f63544a.getPageActivity())) {
                    UrlManager.getInstance().dealOneLink(this.f63544a, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            ArrayList<IconData> tShowInfo = this.f63546c.getTShowInfo();
            if (ListUtils.getItem(tShowInfo, 0) != null) {
                UrlManager.getInstance().dealOneLink(this.f63544a, new String[]{tShowInfo.get(0).getUrl()});
            }
        }
    }

    public final void x() {
        UserData userData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (userData = this.f63546c) == null || userData.getLiveRoomInfo() == null || TextUtils.isEmpty(this.f63546c.getLiveRoomInfo().jump_url)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(this.f63544a, new String[]{this.f63546c.getLiveRoomInfo().jump_url}, true);
    }

    public final void y() {
        d.a.s0.m2.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (aVar = this.f63545b) == null || aVar.g() == null || TextUtils.isEmpty(this.f63545b.g().f57190b)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(this.f63544a, new String[]{this.f63545b.g().f57190b}, true);
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "4"));
            d.a.r0.l.a.o(this.f63544a.getPageActivity(), this.f63544a.getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + this.f63546c.getUserId(), true, true, true);
        }
    }
}
