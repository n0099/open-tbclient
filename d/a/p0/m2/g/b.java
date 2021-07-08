package d.a.p0.m2.g;

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
import d.a.o0.j0.c;
import d.a.o0.t.o;
import d.a.p0.m2.d.i;
import java.util.ArrayList;
import tbclient.BaijiahaoInfo;
import tbclient.Profile.NicknameInfo;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60307a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.p0.m2.e.a f60308b;

    /* renamed from: c  reason: collision with root package name */
    public UserData f60309c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.p0.m2.g.a f60310d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f60311e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.o0.s.e.a f60312f;

    /* renamed from: g  reason: collision with root package name */
    public i f60313g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f60314h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f60315i;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f60316e;

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
            this.f60316e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String intro;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f60316e.f60310d.z()) {
                    this.f60316e.w();
                } else if (view == this.f60316e.f60310d.r()) {
                    this.f60316e.r();
                } else if (view != this.f60316e.f60310d.v()) {
                    if (view == this.f60316e.f60310d.D()) {
                        if (this.f60316e.f60311e) {
                            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "7"));
                            this.f60316e.E();
                        }
                    } else if (view != this.f60316e.f60310d.y() && view != this.f60316e.f60310d.x()) {
                        if (view == this.f60316e.f60310d.C()) {
                            this.f60316e.z();
                        } else if (view == this.f60316e.f60310d.s()) {
                            this.f60316e.s();
                        } else if (view == this.f60316e.f60310d.t()) {
                            this.f60316e.t();
                        } else if (view == this.f60316e.f60310d.u()) {
                            this.f60316e.u();
                        } else if (view == this.f60316e.f60310d.w()) {
                            this.f60316e.v();
                        } else if (view == this.f60316e.f60310d.B()) {
                            if (this.f60316e.f60311e) {
                                TiebaStatic.log(new StatisticItem("c13613").param("obj_param1", "0"));
                            } else {
                                TiebaStatic.log(new StatisticItem("c13613").param("obj_param1", "1"));
                            }
                            this.f60316e.y();
                        } else if (view == this.f60316e.f60310d.A()) {
                            this.f60316e.x();
                        }
                    } else {
                        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "14"));
                        if (this.f60316e.f60311e) {
                            if (this.f60316e.f60309c != null && this.f60316e.f60309c.isBaijiahaoUser()) {
                                PersonIntroductionActivity.startPersonIntroductionActivity(this.f60316e.f60307a.getPageActivity(), this.f60316e.f60309c.getIntro());
                            }
                            this.f60316e.E();
                            return;
                        }
                        BaijiahaoInfo baijiahaoInfo = this.f60316e.f60309c.getBaijiahaoInfo();
                        if (baijiahaoInfo == null || k.isEmpty(baijiahaoInfo.auth_desc)) {
                            intro = this.f60316e.f60309c.getIntro();
                        } else {
                            intro = baijiahaoInfo.auth_desc;
                        }
                        PersonIntroductionActivity.startPersonIntroductionActivity(this.f60316e.f60307a.getPageActivity(), intro);
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12503").param("obj_locate", "3"));
                    TiebaStatic.log("igift_icon_ck");
                    this.f60316e.D();
                }
            }
        }
    }

    /* renamed from: d.a.p0.m2.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1544b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f60317a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1544b(b bVar, int i2) {
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
            this.f60317a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || !(customResponsedMessage instanceof UpdateAttentionMessage) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f12819c)) {
                return;
            }
            if (updateAttentionMessage.getData().f12817a) {
                Message<?> message = updateAttentionMessage.getmOrginalMessage();
                if (message == null || message.getTag() == null || !message.getTag().equals(this.f60317a.f60307a.getUniqueId())) {
                    return;
                }
                if (updateAttentionMessage.isAttention()) {
                    this.f60317a.f60309c.setLike(true);
                    return;
                }
                if (!updateAttentionMessage.getData().j) {
                    this.f60317a.f60307a.showToast(R.string.unlike_success);
                }
                this.f60317a.f60309c.setLike(false);
                return;
            }
            Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
            if (message2 == null || message2.getTag() == null || !message2.getTag().equals(this.f60317a.f60307a.getUniqueId())) {
                return;
            }
            this.f60317a.f60310d.N(this.f60317a.f60309c.isLike());
            if (updateAttentionMessage.getData() == null || k.isEmpty(updateAttentionMessage.getData().f12818b)) {
                if (this.f60317a.f60309c.getIsLike()) {
                    this.f60317a.f60307a.showToast(R.string.unlike_failure);
                    return;
                } else {
                    this.f60317a.f60307a.showToast(R.string.attention_fail);
                    return;
                }
            }
            this.f60317a.f60307a.showToast(updateAttentionMessage.getData().f12818b);
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
        this.f60314h = new a(this);
        this.f60315i = new C1544b(this, 2001115);
        this.f60307a = tbPageContext;
        this.f60311e = z;
        this.f60310d = new d.a.p0.m2.g.a(this.f60307a, this.f60311e, this.f60314h);
        this.f60307a.registerListener(this.f60315i);
        TbPageContext tbPageContext2 = this.f60307a;
        this.f60313g = new i(tbPageContext2, tbPageContext2.getUniqueId(), z);
    }

    public void A(Intent intent) {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, intent) == null) || (iVar = this.f60313g) == null) {
            return;
        }
        iVar.p(intent);
    }

    public FollowUserSpinnerBtn B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f60310d.r() : (FollowUserSpinnerBtn) invokeV.objValue;
    }

    public View C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f60310d.E() : (View) invokeV.objValue;
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && ViewHelper.checkUpIsLogin(this.f60307a.getPageActivity())) {
            GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.f60307a.getPageActivity(), this.f60309c.getUserIdLong(), this.f60309c.getUserName(), this.f60309c.getName_show(), GiftTabActivityConfig.FROM_PERSON_CENTER, 24001);
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
        UserData userData = this.f60309c;
        if (userData != null) {
            personChangeData.setPortrait(userData.getPortrait());
            personChangeData.setName(this.f60309c.getUserName());
            personChangeData.setSex(this.f60309c.getSex());
            personChangeData.setIntro(this.f60309c.getIntro());
            personChangeData.setNameShow(this.f60309c.getName_show());
            personChangeData.setMem(this.f60309c.getIsMem());
            personChangeData.setForumAge(this.f60309c.getTb_age());
            personChangeData.setCanModifyAvatar(this.f60309c.canModifyAvatar());
            personChangeData.setCantModifyAvatarDesc(this.f60309c.getCantModifyAvatarDesc());
            personChangeData.setTiebaId(this.f60309c.getmTiebaUid());
            AlaUserInfoData alaUserInfoData = this.f60309c.alaUserData;
            if (alaUserInfoData != null) {
                personChangeData.setAlaId(alaUserInfoData.ala_id);
            }
            NicknameInfo nicknameInfo = this.f60308b.A;
            if (nicknameInfo != null) {
                personChangeData.setNickNameLeftDays(nicknameInfo.left_days.intValue());
            }
            if (this.f60309c.getBirthdayInfo() != null) {
                personChangeData.setUserAge(this.f60309c.getBirthdayInfo().f52689c);
                personChangeData.setBirthdayTime(this.f60309c.getBirthdayInfo().f52687a);
                personChangeData.setBirthdayShowStatus(this.f60309c.getBirthdayInfo().f52690d);
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(this.f60307a.getPageActivity(), 101, personChangeData, Boolean.FALSE)));
    }

    public void F(int i2) {
        d.a.p0.m2.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (aVar = this.f60310d) == null) {
            return;
        }
        aVar.H(i2);
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            i iVar = this.f60313g;
            if (iVar != null) {
                iVar.y();
            }
            d.a.p0.m2.g.a aVar = this.f60310d;
            if (aVar != null) {
                aVar.I();
            }
        }
    }

    public void H(d.a.p0.m2.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f60310d.K(aVar);
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f60310d.L(z);
        }
    }

    public final void J(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            BdToast.i(this.f60307a.getPageActivity(), String.format(this.f60307a.getString(R.string.person_privacy_toast), StringHelper.getUserDescByGender(i2)), R.drawable.icon_pure_toast_mistake40_svg, true).q();
        }
    }

    public void K(String str) {
        d.a.p0.m2.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || (aVar = this.f60310d) == null) {
            return;
        }
        aVar.O(str);
    }

    public void p(d.a.p0.m2.e.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) || aVar == null || aVar.j() == null) {
            return;
        }
        this.f60308b = aVar;
        this.f60309c = aVar.j();
        this.f60310d.q(this.f60308b.j(), this.f60308b.g());
        this.f60313g.A(aVar);
    }

    public void q() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (iVar = this.f60313g) == null) {
            return;
        }
        iVar.o();
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && ViewHelper.checkUpIsLogin(this.f60307a.getPageActivity())) {
            if (this.f60312f == null) {
                d.a.o0.s.e.a aVar = new d.a.o0.s.e.a(this.f60307a);
                this.f60312f = aVar;
                aVar.j(true);
            }
            this.f60312f.m(!this.f60309c.isLike(), this.f60309c.getPortrait(), this.f60309c.getUserId(), this.f60309c.isGod(), "2", this.f60307a.getUniqueId(), null, "0");
            this.f60310d.N(true ^ this.f60309c.isLike());
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_CONCERN_BTN_CLICK);
            statisticItem.param("obj_id", this.f60309c.getUserId());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TbPageContext tbPageContext = this.f60307a;
            if (tbPageContext != null && tbPageContext.getPageActivity() != null && this.f60307a.getPageActivity().getIntent() != null) {
                statisticItem.param("nid", this.f60307a.getPageActivity().getIntent().getStringExtra("nid"));
            }
            TbPageContext tbPageContext2 = this.f60307a;
            if (tbPageContext2 != null) {
                c.e(tbPageContext2.getPageActivity(), statisticItem);
            }
            TbPageContext tbPageContext3 = this.f60307a;
            if (tbPageContext3 != null && tbPageContext3.getPageActivity() != null && c.j(this.f60307a.getPageActivity()) != null && c.j(this.f60307a.getPageActivity()).b() != null && !TextUtils.isEmpty(c.j(this.f60307a.getPageActivity()).b().locatePage) && "a002".equals(c.j(this.f60307a.getPageActivity()).b().locatePage)) {
                statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, c.j(this.f60307a.getPageActivity()).b().locatePage);
                statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a011");
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13575");
            statisticItem.param("obj_type", this.f60311e ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "9"));
            if (ViewHelper.checkUpIsLogin(this.f60307a.getPageActivity())) {
                TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 2).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f60309c.getUserId()) ? 1 : 2).param("obj_source", this.f60309c.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.f60307a.getPageActivity(), true, this.f60309c.getUserId(), this.f60309c.getSex()).updateFollowNum(this.f60309c.getConcernNum(), this.f60309c.getPortrait())));
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13573");
            statisticItem.param("obj_type", this.f60311e ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "8"));
            if (ViewHelper.checkUpIsLogin(this.f60307a.getPageActivity())) {
                d.a.p0.x2.a.v().L(2, false, this.f60311e);
                TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 3).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f60309c.getUserId()) ? 1 : 2).param("obj_source", this.f60309c.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.f60307a.getPageActivity(), false, this.f60309c.getUserId(), this.f60309c.getSex())));
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13574");
            statisticItem.param("obj_type", this.f60311e ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "10"));
            if (ViewHelper.checkUpIsLogin(this.f60307a.getPageActivity())) {
                boolean equals = TbadkCoreApplication.getCurrentAccount().equals(this.f60309c.getUserId());
                boolean z = this.f60309c.getIsFriend() == 1;
                if (this.f60309c.getPersonPrivate() == null) {
                    J(this.f60309c.getSex());
                } else if (this.f60309c.getPersonPrivate().w() != 1 && !equals && (!z || this.f60309c.getPersonPrivate().w() != 2)) {
                    J(this.f60309c.getSex());
                } else {
                    TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 4).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f60309c.getUserId()) ? 1 : 2).param("obj_source", this.f60309c.isGod() ? 1 : 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.f60307a.getPageActivity(), this.f60309c.getLike_bars(), this.f60309c.getUserId(), this.f60309c.getSex())));
                }
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            AlaUserInfoData alaUserData = this.f60309c.getAlaUserData();
            if (!this.f60311e && alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                TiebaStatic.log("c12542");
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = alaUserData.live_id;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.f60307a.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_ATTENTION, null, false, "")));
                return;
            }
            o oVar = new o();
            if (this.f60309c.getBaijiahaoInfo() != null && !TextUtils.isEmpty(this.f60309c.getBaijiahaoInfo().avatar)) {
                oVar.e(this.f60309c.getBaijiahaoInfo().avatar);
                oVar.i(this.f60309c.getBaijiahaoInfo().avatar);
                oVar.h(true);
            } else if (!StringUtils.isNull(this.f60309c.getPortrait()) && this.f60309c.getPortrait().startsWith("http")) {
                oVar.e(this.f60309c.getPortrait());
                oVar.i(HeadIconRefreshHelper.headPortraitFilter(this.f60309c.getPortrait()));
                oVar.h(true);
            } else {
                oVar.e(HeadIconRefreshHelper.headPortraitFilter(this.f60309c.getPortraitH()));
                oVar.i(HeadIconRefreshHelper.headPortraitFilter(this.f60309c.getPortrait()));
                oVar.h(true);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(oVar);
            this.f60313g.r(oVar, arrayList, 0);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "6"));
            if (this.f60311e) {
                if (ViewHelper.checkUpIsLogin(this.f60307a.getPageActivity())) {
                    UrlManager.getInstance().dealOneLink(this.f60307a, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            ArrayList<IconData> tShowInfo = this.f60309c.getTShowInfo();
            if (ListUtils.getItem(tShowInfo, 0) != null) {
                UrlManager.getInstance().dealOneLink(this.f60307a, new String[]{tShowInfo.get(0).getUrl()});
            }
        }
    }

    public final void x() {
        UserData userData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (userData = this.f60309c) == null || userData.getLiveRoomInfo() == null || TextUtils.isEmpty(this.f60309c.getLiveRoomInfo().jump_url)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(this.f60307a, new String[]{this.f60309c.getLiveRoomInfo().jump_url}, true);
    }

    public final void y() {
        d.a.p0.m2.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (aVar = this.f60308b) == null || aVar.g() == null || TextUtils.isEmpty(this.f60308b.g().f53935b)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(this.f60307a, new String[]{this.f60308b.g().f53935b}, true);
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "4"));
            d.a.o0.l.a.o(this.f60307a.getPageActivity(), this.f60307a.getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + this.f60309c.getUserId(), true, true, true);
        }
    }
}
