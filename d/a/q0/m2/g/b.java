package d.a.q0.m2.g;

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
import d.a.d.e.p.k;
import d.a.p0.l0.c;
import d.a.p0.u.m;
import d.a.q0.m2.d.i;
import java.util.ArrayList;
import tbclient.BaijiahaoInfo;
import tbclient.Profile.NicknameInfo;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60921a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.q0.m2.e.a f60922b;

    /* renamed from: c  reason: collision with root package name */
    public UserData f60923c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.q0.m2.g.a f60924d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f60925e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.p0.t.e.a f60926f;

    /* renamed from: g  reason: collision with root package name */
    public i f60927g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f60928h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f60929i;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f60930e;

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
            this.f60930e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String intro;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f60930e.f60924d.z()) {
                    this.f60930e.w();
                } else if (view == this.f60930e.f60924d.r()) {
                    this.f60930e.r();
                } else if (view != this.f60930e.f60924d.v()) {
                    if (view == this.f60930e.f60924d.D()) {
                        if (this.f60930e.f60925e) {
                            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "7"));
                            this.f60930e.E();
                        }
                    } else if (view != this.f60930e.f60924d.y() && view != this.f60930e.f60924d.x()) {
                        if (view == this.f60930e.f60924d.C()) {
                            this.f60930e.z();
                        } else if (view == this.f60930e.f60924d.s()) {
                            this.f60930e.s();
                        } else if (view == this.f60930e.f60924d.t()) {
                            this.f60930e.t();
                        } else if (view == this.f60930e.f60924d.u()) {
                            this.f60930e.u();
                        } else if (view == this.f60930e.f60924d.w()) {
                            this.f60930e.v();
                        } else if (view == this.f60930e.f60924d.B()) {
                            if (this.f60930e.f60925e) {
                                TiebaStatic.log(new StatisticItem("c13613").param("obj_param1", "0"));
                            } else {
                                TiebaStatic.log(new StatisticItem("c13613").param("obj_param1", "1"));
                            }
                            this.f60930e.y();
                        } else if (view == this.f60930e.f60924d.A()) {
                            this.f60930e.x();
                        }
                    } else {
                        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "14"));
                        if (this.f60930e.f60925e) {
                            if (this.f60930e.f60923c != null && this.f60930e.f60923c.isBaijiahaoUser()) {
                                PersonIntroductionActivity.startPersonIntroductionActivity(this.f60930e.f60921a.getPageActivity(), this.f60930e.f60923c.getIntro());
                            }
                            this.f60930e.E();
                            return;
                        }
                        BaijiahaoInfo baijiahaoInfo = this.f60930e.f60923c.getBaijiahaoInfo();
                        if (baijiahaoInfo == null || k.isEmpty(baijiahaoInfo.auth_desc)) {
                            intro = this.f60930e.f60923c.getIntro();
                        } else {
                            intro = baijiahaoInfo.auth_desc;
                        }
                        PersonIntroductionActivity.startPersonIntroductionActivity(this.f60930e.f60921a.getPageActivity(), intro);
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12503").param("obj_locate", "3"));
                    TiebaStatic.log("igift_icon_ck");
                    this.f60930e.D();
                }
            }
        }
    }

    /* renamed from: d.a.q0.m2.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1549b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f60931a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1549b(b bVar, int i2) {
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
            this.f60931a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || !(customResponsedMessage instanceof UpdateAttentionMessage) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f12868c)) {
                return;
            }
            if (updateAttentionMessage.getData().f12866a) {
                Message<?> message = updateAttentionMessage.getmOrginalMessage();
                if (message == null || message.getTag() == null || !message.getTag().equals(this.f60931a.f60921a.getUniqueId())) {
                    return;
                }
                if (updateAttentionMessage.isAttention()) {
                    this.f60931a.f60923c.setLike(true);
                    return;
                }
                if (!updateAttentionMessage.getData().j) {
                    this.f60931a.f60921a.showToast(R.string.unlike_success);
                }
                this.f60931a.f60923c.setLike(false);
                return;
            }
            Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
            if (message2 == null || message2.getTag() == null || !message2.getTag().equals(this.f60931a.f60921a.getUniqueId())) {
                return;
            }
            this.f60931a.f60924d.N(this.f60931a.f60923c.isLike());
            if (updateAttentionMessage.getData() == null || k.isEmpty(updateAttentionMessage.getData().f12867b)) {
                if (this.f60931a.f60923c.getIsLike()) {
                    this.f60931a.f60921a.showToast(R.string.unlike_failure);
                    return;
                } else {
                    this.f60931a.f60921a.showToast(R.string.attention_fail);
                    return;
                }
            }
            this.f60931a.f60921a.showToast(updateAttentionMessage.getData().f12867b);
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
        this.f60928h = new a(this);
        this.f60929i = new C1549b(this, 2001115);
        this.f60921a = tbPageContext;
        this.f60925e = z;
        this.f60924d = new d.a.q0.m2.g.a(this.f60921a, this.f60925e, this.f60928h);
        this.f60921a.registerListener(this.f60929i);
        TbPageContext tbPageContext2 = this.f60921a;
        this.f60927g = new i(tbPageContext2, tbPageContext2.getUniqueId(), z);
    }

    public void A(Intent intent) {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, intent) == null) || (iVar = this.f60927g) == null) {
            return;
        }
        iVar.p(intent);
    }

    public FollowUserSpinnerBtn B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f60924d.r() : (FollowUserSpinnerBtn) invokeV.objValue;
    }

    public View C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f60924d.E() : (View) invokeV.objValue;
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && ViewHelper.checkUpIsLogin(this.f60921a.getPageActivity())) {
            GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.f60921a.getPageActivity(), this.f60923c.getUserIdLong(), this.f60923c.getUserName(), this.f60923c.getName_show(), GiftTabActivityConfig.FROM_PERSON_CENTER, 24001);
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
        UserData userData = this.f60923c;
        if (userData != null) {
            personChangeData.setPortrait(userData.getPortrait());
            personChangeData.setName(this.f60923c.getUserName());
            personChangeData.setSex(this.f60923c.getSex());
            personChangeData.setIntro(this.f60923c.getIntro());
            personChangeData.setNameShow(this.f60923c.getName_show());
            personChangeData.setMem(this.f60923c.getIsMem());
            personChangeData.setForumAge(this.f60923c.getTb_age());
            personChangeData.setCanModifyAvatar(this.f60923c.canModifyAvatar());
            personChangeData.setCantModifyAvatarDesc(this.f60923c.getCantModifyAvatarDesc());
            personChangeData.setTiebaId(this.f60923c.getmTiebaUid());
            AlaUserInfoData alaUserInfoData = this.f60923c.alaUserData;
            if (alaUserInfoData != null) {
                personChangeData.setAlaId(alaUserInfoData.ala_id);
            }
            NicknameInfo nicknameInfo = this.f60922b.A;
            if (nicknameInfo != null) {
                personChangeData.setNickNameLeftDays(nicknameInfo.left_days.intValue());
            }
            if (this.f60923c.getBirthdayInfo() != null) {
                personChangeData.setUserAge(this.f60923c.getBirthdayInfo().f53353c);
                personChangeData.setBirthdayTime(this.f60923c.getBirthdayInfo().f53351a);
                personChangeData.setBirthdayShowStatus(this.f60923c.getBirthdayInfo().f53354d);
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(this.f60921a.getPageActivity(), 101, personChangeData, Boolean.FALSE)));
    }

    public void F(int i2) {
        d.a.q0.m2.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (aVar = this.f60924d) == null) {
            return;
        }
        aVar.H(i2);
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            i iVar = this.f60927g;
            if (iVar != null) {
                iVar.y();
            }
            d.a.q0.m2.g.a aVar = this.f60924d;
            if (aVar != null) {
                aVar.I();
            }
        }
    }

    public void H(d.a.q0.m2.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f60924d.K(aVar);
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f60924d.L(z);
        }
    }

    public final void J(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            BdToast.i(this.f60921a.getPageActivity(), String.format(this.f60921a.getString(R.string.person_privacy_toast), StringHelper.getUserDescByGender(i2)), R.drawable.icon_pure_toast_mistake40_svg, true).q();
        }
    }

    public void K(String str) {
        d.a.q0.m2.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || (aVar = this.f60924d) == null) {
            return;
        }
        aVar.O(str);
    }

    public void p(d.a.q0.m2.e.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) || aVar == null || aVar.j() == null) {
            return;
        }
        this.f60922b = aVar;
        this.f60923c = aVar.j();
        this.f60924d.q(this.f60922b.j(), this.f60922b.g());
        this.f60927g.A(aVar);
    }

    public void q() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (iVar = this.f60927g) == null) {
            return;
        }
        iVar.o();
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && ViewHelper.checkUpIsLogin(this.f60921a.getPageActivity())) {
            if (this.f60926f == null) {
                d.a.p0.t.e.a aVar = new d.a.p0.t.e.a(this.f60921a);
                this.f60926f = aVar;
                aVar.j(true);
            }
            this.f60926f.m(!this.f60923c.isLike(), this.f60923c.getPortrait(), this.f60923c.getUserId(), this.f60923c.isGod(), "2", this.f60921a.getUniqueId(), null, "0");
            this.f60924d.N(true ^ this.f60923c.isLike());
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_CONCERN_BTN_CLICK);
            statisticItem.param("obj_id", this.f60923c.getUserId());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TbPageContext tbPageContext = this.f60921a;
            if (tbPageContext != null && tbPageContext.getPageActivity() != null && this.f60921a.getPageActivity().getIntent() != null) {
                statisticItem.param("nid", this.f60921a.getPageActivity().getIntent().getStringExtra("nid"));
            }
            TbPageContext tbPageContext2 = this.f60921a;
            if (tbPageContext2 != null) {
                c.e(tbPageContext2.getPageActivity(), statisticItem);
            }
            TbPageContext tbPageContext3 = this.f60921a;
            if (tbPageContext3 != null && tbPageContext3.getPageActivity() != null && c.j(this.f60921a.getPageActivity()) != null && c.j(this.f60921a.getPageActivity()).b() != null && !TextUtils.isEmpty(c.j(this.f60921a.getPageActivity()).b().locatePage) && "a002".equals(c.j(this.f60921a.getPageActivity()).b().locatePage)) {
                statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, c.j(this.f60921a.getPageActivity()).b().locatePage);
                statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a011");
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13575");
            statisticItem.param("obj_type", this.f60925e ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "9"));
            if (ViewHelper.checkUpIsLogin(this.f60921a.getPageActivity())) {
                TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 2).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f60923c.getUserId()) ? 1 : 2).param("obj_source", this.f60923c.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.f60921a.getPageActivity(), true, this.f60923c.getUserId(), this.f60923c.getSex()).updateFollowNum(this.f60923c.getConcernNum(), this.f60923c.getPortrait())));
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13573");
            statisticItem.param("obj_type", this.f60925e ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "8"));
            if (ViewHelper.checkUpIsLogin(this.f60921a.getPageActivity())) {
                d.a.q0.x2.a.v().L(2, false, this.f60925e);
                TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 3).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f60923c.getUserId()) ? 1 : 2).param("obj_source", this.f60923c.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.f60921a.getPageActivity(), false, this.f60923c.getUserId(), this.f60923c.getSex())));
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13574");
            statisticItem.param("obj_type", this.f60925e ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "10"));
            if (ViewHelper.checkUpIsLogin(this.f60921a.getPageActivity())) {
                boolean equals = TbadkCoreApplication.getCurrentAccount().equals(this.f60923c.getUserId());
                boolean z = this.f60923c.getIsFriend() == 1;
                if (this.f60923c.getPersonPrivate() == null) {
                    J(this.f60923c.getSex());
                } else if (this.f60923c.getPersonPrivate().w() != 1 && !equals && (!z || this.f60923c.getPersonPrivate().w() != 2)) {
                    J(this.f60923c.getSex());
                } else {
                    TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 4).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f60923c.getUserId()) ? 1 : 2).param("obj_source", this.f60923c.isGod() ? 1 : 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.f60921a.getPageActivity(), this.f60923c.getLike_bars(), this.f60923c.getUserId(), this.f60923c.getSex())));
                }
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            AlaUserInfoData alaUserData = this.f60923c.getAlaUserData();
            if (!this.f60925e && alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                TiebaStatic.log("c12542");
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = alaUserData.live_id;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.f60921a.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_ATTENTION, null, false, "")));
                return;
            }
            m mVar = new m();
            if (this.f60923c.getBaijiahaoInfo() != null && !TextUtils.isEmpty(this.f60923c.getBaijiahaoInfo().avatar)) {
                mVar.e(this.f60923c.getBaijiahaoInfo().avatar);
                mVar.i(this.f60923c.getBaijiahaoInfo().avatar);
                mVar.h(true);
            } else if (!StringUtils.isNull(this.f60923c.getPortrait()) && this.f60923c.getPortrait().startsWith("http")) {
                mVar.e(this.f60923c.getPortrait());
                mVar.i(HeadIconRefreshHelper.headPortraitFilter(this.f60923c.getPortrait()));
                mVar.h(true);
            } else {
                mVar.e(HeadIconRefreshHelper.headPortraitFilter(this.f60923c.getPortraitH()));
                mVar.i(HeadIconRefreshHelper.headPortraitFilter(this.f60923c.getPortrait()));
                mVar.h(true);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(mVar);
            this.f60927g.r(mVar, arrayList, 0);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "6"));
            if (this.f60925e) {
                if (ViewHelper.checkUpIsLogin(this.f60921a.getPageActivity())) {
                    UrlManager.getInstance().dealOneLink(this.f60921a, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            ArrayList<IconData> tShowInfo = this.f60923c.getTShowInfo();
            if (ListUtils.getItem(tShowInfo, 0) != null) {
                UrlManager.getInstance().dealOneLink(this.f60921a, new String[]{tShowInfo.get(0).getUrl()});
            }
        }
    }

    public final void x() {
        UserData userData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (userData = this.f60923c) == null || userData.getLiveRoomInfo() == null || TextUtils.isEmpty(this.f60923c.getLiveRoomInfo().jump_url)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(this.f60921a, new String[]{this.f60923c.getLiveRoomInfo().jump_url}, true);
    }

    public final void y() {
        d.a.q0.m2.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (aVar = this.f60922b) == null || aVar.g() == null || TextUtils.isEmpty(this.f60922b.g().f54479b)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(this.f60921a, new String[]{this.f60922b.g().f54479b}, true);
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "4"));
            d.a.p0.m.a.o(this.f60921a.getPageActivity(), this.f60921a.getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + this.f60923c.getUserId(), true, true, true);
        }
    }
}
