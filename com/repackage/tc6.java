package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.member.ForumMemberHttpResponseMessage;
import com.baidu.tieba.forumMember.member.ForumMemberReadCacheRequestMessage;
import com.baidu.tieba.forumMember.member.ForumMemberReadCacheResponseMessage;
import com.baidu.tieba.forumMember.member.ForumMemberRequestMessage;
import com.baidu.tieba.forumMember.member.ForumMemberSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMemberInfo.ManagerApplyInfo;
import tbclient.GetMemberInfo.MemberGodInfo;
import tbclient.MemberGroupInfo;
import tbclient.PriManagerApplyInfo;
import tbclient.User;
/* loaded from: classes7.dex */
public class tc6 implements zf6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public String b;
    public String c;
    public ck8 d;
    public List<MemberGroupInfo> e;
    public MemberGodInfo f;
    public ManagerApplyInfo g;
    public boolean h;
    public boolean i;
    public PriManagerApplyInfo j;
    public dg6 k;
    public boolean l;
    public ng6 m;
    public ab n;
    public CustomMessageListener o;
    public CustomMessageListener p;
    public CustomMessageListener q;

    /* loaded from: classes7.dex */
    public class a extends ab {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tc6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(tc6 tc6Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tc6Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tc6Var;
        }

        @Override // com.repackage.ab
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof ForumMemberHttpResponseMessage;
            if (z || (responsedMessage instanceof ForumMemberSocketResponseMessage)) {
                if (responsedMessage.getError() == 0) {
                    if (z) {
                        ForumMemberHttpResponseMessage forumMemberHttpResponseMessage = (ForumMemberHttpResponseMessage) responsedMessage;
                        this.a.d = forumMemberHttpResponseMessage.getUserInfo();
                        this.a.e = forumMemberHttpResponseMessage.getMemberGroupInfoList();
                        this.a.f = forumMemberHttpResponseMessage.getMemberGodInfo();
                        this.a.g = forumMemberHttpResponseMessage.getManagerApplyInfo();
                        this.a.i = forumMemberHttpResponseMessage.isBawuShow();
                        this.a.h = forumMemberHttpResponseMessage.isPrivateForum();
                        this.a.j = forumMemberHttpResponseMessage.getPrivateMgrApplyInfo();
                    } else if (responsedMessage instanceof ForumMemberSocketResponseMessage) {
                        ForumMemberSocketResponseMessage forumMemberSocketResponseMessage = (ForumMemberSocketResponseMessage) responsedMessage;
                        this.a.d = forumMemberSocketResponseMessage.getUserInfo();
                        this.a.e = forumMemberSocketResponseMessage.getMemberGroupInfoList();
                        this.a.f = forumMemberSocketResponseMessage.getMemberGodInfo();
                        this.a.g = forumMemberSocketResponseMessage.getManagerApplyInfo();
                        this.a.i = forumMemberSocketResponseMessage.isBawuShow();
                        this.a.h = forumMemberSocketResponseMessage.isPrivateForum();
                        this.a.j = forumMemberSocketResponseMessage.getPrivateMgrApplyInfo();
                    }
                }
                this.a.l = false;
                this.a.m.e = responsedMessage.getError();
                this.a.m.f = responsedMessage.getErrorString();
                this.a.m.g = false;
                this.a.m.i = false;
                this.a.m.h = false;
                this.a.m.b = this.a.b;
                this.a.m.a = this.a.c;
                this.a.m.c = 1;
                if (this.a.k != null) {
                    dg6 dg6Var = this.a.k;
                    ng6 ng6Var = this.a.m;
                    tc6 tc6Var = this.a;
                    dg6Var.a(3, 0, ng6Var, tc6Var.A(tc6Var.d, this.a.e, this.a.f, this.a.g, this.a.i, this.a.h, this.a.j));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001352, this.a.d));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tc6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(tc6 tc6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tc6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tc6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ForumMemberReadCacheResponseMessage)) {
                ForumMemberReadCacheResponseMessage forumMemberReadCacheResponseMessage = (ForumMemberReadCacheResponseMessage) customResponsedMessage;
                if (customResponsedMessage.getError() == 0) {
                    this.a.d = forumMemberReadCacheResponseMessage.getUserInfo();
                    this.a.e = forumMemberReadCacheResponseMessage.getMemberGroupInfoList();
                    this.a.f = forumMemberReadCacheResponseMessage.getMemberGodInfo();
                    this.a.g = forumMemberReadCacheResponseMessage.getManagerApplyInfo();
                    this.a.i = forumMemberReadCacheResponseMessage.isBawuShow();
                    this.a.h = forumMemberReadCacheResponseMessage.isPrivateForum();
                    this.a.j = forumMemberReadCacheResponseMessage.getPrivateMgrApplyInfo();
                }
                this.a.m.e = customResponsedMessage.getError();
                this.a.m.f = customResponsedMessage.getErrorString();
                this.a.m.g = false;
                this.a.m.i = false;
                this.a.m.h = false;
                this.a.m.b = this.a.b;
                this.a.m.a = this.a.c;
                this.a.m.c = 1;
                if (this.a.k != null) {
                    tc6 tc6Var = this.a;
                    ArrayList<on> A = tc6Var.A(tc6Var.d, this.a.e, this.a.f, this.a.g, this.a.i, this.a.h, this.a.j);
                    if (A == null || A.size() <= 0) {
                        if (!this.a.l) {
                            this.a.k.a(3, 0, this.a.m, A);
                        }
                    } else {
                        this.a.k.a(3, 0, this.a.m, A);
                    }
                }
                if (this.a.l) {
                    tc6 tc6Var2 = this.a;
                    tc6Var2.z(og.g(tc6Var2.b, 0L), this.a.c);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tc6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(tc6 tc6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tc6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tc6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ck8)) {
                this.a.m.e = customResponsedMessage.getError();
                this.a.m.f = customResponsedMessage.getErrorString();
                this.a.m.g = false;
                this.a.m.i = false;
                this.a.m.h = false;
                this.a.m.b = this.a.b;
                this.a.m.a = this.a.c;
                this.a.m.c = 1;
                ck8 ck8Var = (ck8) customResponsedMessage.getData();
                if (ck8Var != null && ck8Var.n() == 0 && this.a.d != null) {
                    ck8Var.u(this.a.d.c());
                    ck8Var.x(this.a.d.i());
                }
                this.a.d = ck8Var;
                if (this.a.k != null) {
                    dg6 dg6Var = this.a.k;
                    ng6 ng6Var = this.a.m;
                    tc6 tc6Var = this.a;
                    dg6Var.a(3, 0, ng6Var, tc6Var.A(tc6Var.d, this.a.e, this.a.f, this.a.g, this.a.i, this.a.h, this.a.j));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tc6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(tc6 tc6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tc6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tc6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
                tc6 tc6Var = this.a;
                tc6Var.z(og.g(tc6Var.b, 0L), this.a.c);
            }
        }
    }

    public tc6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = false;
        this.i = false;
        this.l = true;
        this.m = new ng6();
        this.n = new a(this, CmdConfigHttp.FRS_MEMBER_TAB_CMD, 301004);
        this.o = new b(this, 2003009);
        this.p = new c(this, 2001266);
        this.q = new d(this, 2001222);
    }

    public ArrayList<on> A(ck8 ck8Var, List<MemberGroupInfo> list, MemberGodInfo memberGodInfo, ManagerApplyInfo managerApplyInfo, boolean z, boolean z2, PriManagerApplyInfo priManagerApplyInfo) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{ck8Var, list, memberGodInfo, managerApplyInfo, Boolean.valueOf(z), Boolean.valueOf(z2), priManagerApplyInfo})) == null) {
            if (ck8Var == null) {
                return null;
            }
            ArrayList<on> arrayList = new ArrayList<>();
            if (ck8Var.n() == 1) {
                xc6 xc6Var = new xc6();
                xc6Var.h(ck8Var);
                xc6Var.f(this.b);
                xc6Var.g(this.c);
                arrayList.add(xc6Var);
            }
            if (list != null && list.size() > 0) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (list.get(i) != null && list.get(i).member_group_num != null && list.get(i).member_group_num.intValue() > 0 && ListUtils.getCount(list.get(i).member_group_list) > 0) {
                        zc6 zc6Var = new zc6();
                        zc6Var.c(this.b);
                        zc6Var.f(this.c);
                        zc6Var.g(list.get(i));
                        if (i == size - 1) {
                            zc6Var.h(true);
                        } else {
                            zc6Var.h(false);
                        }
                        arrayList.add(zc6Var);
                    }
                }
            }
            if (this.h) {
                if (this.i && priManagerApplyInfo != null) {
                    dd6 dd6Var = new dd6();
                    dd6Var.j(priManagerApplyInfo.assist_left_num.intValue());
                    dd6Var.h(priManagerApplyInfo.assist_apply_url);
                    dd6Var.g(priManagerApplyInfo.assist_apply_status.intValue());
                    arrayList.add(dd6Var);
                }
            } else {
                bd6 bd6Var = new bd6();
                if (managerApplyInfo != null) {
                    bd6Var.k(managerApplyInfo.manager_left_num.intValue());
                    bd6Var.j(managerApplyInfo.manager_apply_url);
                    bd6Var.g(managerApplyInfo.assist_left_num.intValue());
                    bd6Var.f(managerApplyInfo.assist_apply_url);
                    bd6Var.h(managerApplyInfo.manager_apply_status.intValue());
                }
                arrayList.add(bd6Var);
                rc6 rc6Var = new rc6();
                rc6Var.a = R.string.obfuscated_res_0x7f0f0421;
                rc6Var.b = "https://tieba.baidu.com/tb/cms/redpacket/page/complain.html?id=" + this.b;
                arrayList.add(rc6Var);
            }
            B(memberGodInfo, arrayList);
            on x = x();
            if (x != null) {
                arrayList.add(x);
            }
            return arrayList;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public final void B(MemberGodInfo memberGodInfo, ArrayList<on> arrayList) {
        List<User> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, memberGodInfo, arrayList) == null) || memberGodInfo == null || (list = memberGodInfo.forum_god_list) == null || list.size() <= 0 || arrayList == null) {
            return;
        }
        List<User> list2 = memberGodInfo.forum_god_list;
        if (memberGodInfo.forum_god_num.intValue() == 0 || list2.size() == 0) {
            return;
        }
        nc6 nc6Var = new nc6();
        nc6Var.c(memberGodInfo);
        arrayList.add(nc6Var);
        boolean z = false;
        for (int i = 0; i < list2.size(); i++) {
            User user = list2.get(i);
            if (user != null && user.god_data.type.intValue() == 2) {
                pc6 pc6Var = new pc6();
                pc6Var.r(user, i);
                arrayList.add(pc6Var);
                if (!z) {
                    z = true;
                }
            }
        }
        if (z) {
            return;
        }
        arrayList.remove(nc6Var);
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ng6 ng6Var = this.m;
            ng6Var.e = 0;
            ng6Var.g = false;
            ng6Var.i = false;
            ng6Var.h = false;
            ng6Var.b = this.b;
            ng6Var.a = this.c;
            ng6Var.c = 1;
            dg6 dg6Var = this.k;
            if (dg6Var != null) {
                dg6Var.a(3, 0, ng6Var, A(this.d, this.e, this.f, this.g, this.i, this.h, this.j));
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            kk8.h(301004, ForumMemberSocketResponseMessage.class, false, false);
            kk8.c(301004, CmdConfigHttp.FRS_MEMBER_TAB_CMD, TbConfig.GET_MEMBER_INFO, ForumMemberHttpResponseMessage.class, false, false, false, false);
            kk8.b(2003009, uc6.class);
        }
    }

    public void E(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        this.a = bdUniqueId;
    }

    @Override // com.repackage.zf6
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            D();
            BdUniqueId bdUniqueId = this.a;
            if (bdUniqueId != null) {
                this.o.setTag(bdUniqueId);
                this.n.setTag(this.a);
                this.o.setSelfListener(true);
                if (this.n.getHttpMessageListener() != null) {
                    this.n.getHttpMessageListener().setSelfListener(true);
                }
                if (this.n.getSocketMessageListener() != null) {
                    this.n.getSocketMessageListener().setSelfListener(true);
                }
            }
            MessageManager.getInstance().registerListener(this.o);
            MessageManager.getInstance().registerListener(this.n);
            MessageManager.getInstance().registerListener(this.p);
            MessageManager.getInstance().registerListener(this.q);
        }
    }

    @Override // com.repackage.zf6
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.n);
            MessageManager.getInstance().unRegisterListener(this.o);
            MessageManager.getInstance().unRegisterListener(this.p);
            MessageManager.getInstance().unRegisterListener(this.q);
        }
    }

    @Override // com.repackage.zf6
    public void t(int i, int i2, jg6 jg6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048583, this, i, i2, jg6Var) == null) && i == 3 && jg6Var != null) {
            String str = jg6Var.b;
            this.b = str;
            String str2 = jg6Var.a;
            this.c = str2;
            if (this.l) {
                y(str2);
            } else if (jg6Var.c == -1) {
                z(og.g(str, 0L), jg6Var.a);
            } else {
                C();
            }
        }
    }

    @Override // com.repackage.zf6
    public void w(dg6 dg6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dg6Var) == null) {
            this.k = dg6Var;
        }
    }

    public final xe6 x() {
        InterceptResult invokeV;
        int f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            List<MemberGroupInfo> list = this.e;
            if (list == null || list.size() <= 0) {
                return null;
            }
            xe6 xe6Var = new xe6();
            int i = qi.i(TbadkCoreApplication.getInst().getContext());
            int f2 = qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f07019a);
            int f3 = qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070308);
            int f4 = qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f07029e);
            int size = this.e.size();
            if (TbadkCoreApplication.isLogin()) {
                f = qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070299);
            } else {
                f = qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f07026c);
            }
            xe6Var.f(i - (((f2 + f3) + f) + (f4 * size)));
            xe6Var.c(R.drawable.obfuscated_res_0x7f08120f);
            return xe6Var;
        }
        return (xe6) invokeV.objValue;
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            ForumMemberReadCacheRequestMessage forumMemberReadCacheRequestMessage = new ForumMemberReadCacheRequestMessage();
            BdUniqueId bdUniqueId = this.a;
            if (bdUniqueId != null) {
                forumMemberReadCacheRequestMessage.setTag(bdUniqueId);
            }
            forumMemberReadCacheRequestMessage.setForumName(str);
            MessageManager.getInstance().sendMessage(forumMemberReadCacheRequestMessage);
        }
    }

    public void z(long j, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(1048587, this, j, str) == null) || j <= 0 || StringUtils.isNull(str)) {
            return;
        }
        ForumMemberRequestMessage forumMemberRequestMessage = new ForumMemberRequestMessage();
        BdUniqueId bdUniqueId = this.a;
        if (bdUniqueId != null) {
            forumMemberRequestMessage.setTag(bdUniqueId);
        }
        forumMemberRequestMessage.setForumId(j);
        forumMemberRequestMessage.setForumName(str);
        MessageManager.getInstance().sendMessage(forumMemberRequestMessage);
    }
}
