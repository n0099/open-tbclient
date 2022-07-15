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
/* loaded from: classes5.dex */
public class bb6 implements he6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public String b;
    public String c;
    public oh8 d;
    public List<MemberGroupInfo> e;
    public MemberGodInfo f;
    public ManagerApplyInfo g;
    public boolean h;
    public boolean i;
    public PriManagerApplyInfo j;
    public le6 k;
    public boolean l;
    public ve6 m;
    public za n;
    public CustomMessageListener o;
    public CustomMessageListener p;
    public CustomMessageListener q;

    /* loaded from: classes5.dex */
    public class a extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bb6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(bb6 bb6Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bb6Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = bb6Var;
        }

        @Override // com.repackage.za
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
                    le6 le6Var = this.a.k;
                    ve6 ve6Var = this.a.m;
                    bb6 bb6Var = this.a;
                    le6Var.a(3, 0, ve6Var, bb6Var.A(bb6Var.d, this.a.e, this.a.f, this.a.g, this.a.i, this.a.h, this.a.j));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001352, this.a.d));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bb6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(bb6 bb6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bb6Var, Integer.valueOf(i)};
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
            this.a = bb6Var;
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
                    bb6 bb6Var = this.a;
                    ArrayList<nn> A = bb6Var.A(bb6Var.d, this.a.e, this.a.f, this.a.g, this.a.i, this.a.h, this.a.j);
                    if (A == null || A.size() <= 0) {
                        if (!this.a.l) {
                            this.a.k.a(3, 0, this.a.m, A);
                        }
                    } else {
                        this.a.k.a(3, 0, this.a.m, A);
                    }
                }
                if (this.a.l) {
                    bb6 bb6Var2 = this.a;
                    bb6Var2.z(ng.g(bb6Var2.b, 0L), this.a.c);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bb6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(bb6 bb6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bb6Var, Integer.valueOf(i)};
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
            this.a = bb6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof oh8)) {
                this.a.m.e = customResponsedMessage.getError();
                this.a.m.f = customResponsedMessage.getErrorString();
                this.a.m.g = false;
                this.a.m.i = false;
                this.a.m.h = false;
                this.a.m.b = this.a.b;
                this.a.m.a = this.a.c;
                this.a.m.c = 1;
                oh8 oh8Var = (oh8) customResponsedMessage.getData();
                if (oh8Var != null && oh8Var.n() == 0 && this.a.d != null) {
                    oh8Var.u(this.a.d.c());
                    oh8Var.x(this.a.d.i());
                }
                this.a.d = oh8Var;
                if (this.a.k != null) {
                    le6 le6Var = this.a.k;
                    ve6 ve6Var = this.a.m;
                    bb6 bb6Var = this.a;
                    le6Var.a(3, 0, ve6Var, bb6Var.A(bb6Var.d, this.a.e, this.a.f, this.a.g, this.a.i, this.a.h, this.a.j));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bb6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(bb6 bb6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bb6Var, Integer.valueOf(i)};
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
            this.a = bb6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
                bb6 bb6Var = this.a;
                bb6Var.z(ng.g(bb6Var.b, 0L), this.a.c);
            }
        }
    }

    public bb6() {
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
        this.m = new ve6();
        this.n = new a(this, CmdConfigHttp.FRS_MEMBER_TAB_CMD, 301004);
        this.o = new b(this, 2003009);
        this.p = new c(this, 2001266);
        this.q = new d(this, 2001222);
    }

    public ArrayList<nn> A(oh8 oh8Var, List<MemberGroupInfo> list, MemberGodInfo memberGodInfo, ManagerApplyInfo managerApplyInfo, boolean z, boolean z2, PriManagerApplyInfo priManagerApplyInfo) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{oh8Var, list, memberGodInfo, managerApplyInfo, Boolean.valueOf(z), Boolean.valueOf(z2), priManagerApplyInfo})) == null) {
            if (oh8Var == null) {
                return null;
            }
            ArrayList<nn> arrayList = new ArrayList<>();
            if (oh8Var.n() == 1) {
                fb6 fb6Var = new fb6();
                fb6Var.h(oh8Var);
                fb6Var.d(this.b);
                fb6Var.g(this.c);
                arrayList.add(fb6Var);
            }
            if (list != null && list.size() > 0) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (list.get(i) != null && list.get(i).member_group_num != null && list.get(i).member_group_num.intValue() > 0 && ListUtils.getCount(list.get(i).member_group_list) > 0) {
                        hb6 hb6Var = new hb6();
                        hb6Var.c(this.b);
                        hb6Var.d(this.c);
                        hb6Var.g(list.get(i));
                        if (i == size - 1) {
                            hb6Var.h(true);
                        } else {
                            hb6Var.h(false);
                        }
                        arrayList.add(hb6Var);
                    }
                }
            }
            if (this.h) {
                if (this.i && priManagerApplyInfo != null) {
                    lb6 lb6Var = new lb6();
                    lb6Var.i(priManagerApplyInfo.assist_left_num.intValue());
                    lb6Var.h(priManagerApplyInfo.assist_apply_url);
                    lb6Var.g(priManagerApplyInfo.assist_apply_status.intValue());
                    arrayList.add(lb6Var);
                }
            } else {
                jb6 jb6Var = new jb6();
                if (managerApplyInfo != null) {
                    jb6Var.k(managerApplyInfo.manager_left_num.intValue());
                    jb6Var.i(managerApplyInfo.manager_apply_url);
                    jb6Var.g(managerApplyInfo.assist_left_num.intValue());
                    jb6Var.d(managerApplyInfo.assist_apply_url);
                    jb6Var.h(managerApplyInfo.manager_apply_status.intValue());
                }
                arrayList.add(jb6Var);
                za6 za6Var = new za6();
                za6Var.a = R.string.obfuscated_res_0x7f0f0417;
                za6Var.b = "https://tieba.baidu.com/tb/cms/redpacket/page/complain.html?id=" + this.b;
                arrayList.add(za6Var);
            }
            B(memberGodInfo, arrayList);
            nn w = w();
            if (w != null) {
                arrayList.add(w);
            }
            return arrayList;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public final void B(MemberGodInfo memberGodInfo, ArrayList<nn> arrayList) {
        List<User> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, memberGodInfo, arrayList) == null) || memberGodInfo == null || (list = memberGodInfo.forum_god_list) == null || list.size() <= 0 || arrayList == null) {
            return;
        }
        List<User> list2 = memberGodInfo.forum_god_list;
        if (memberGodInfo.forum_god_num.intValue() == 0 || list2.size() == 0) {
            return;
        }
        va6 va6Var = new va6();
        va6Var.c(memberGodInfo);
        arrayList.add(va6Var);
        boolean z = false;
        for (int i = 0; i < list2.size(); i++) {
            User user = list2.get(i);
            if (user != null && user.god_data.type.intValue() == 2) {
                xa6 xa6Var = new xa6();
                xa6Var.r(user, i);
                arrayList.add(xa6Var);
                if (!z) {
                    z = true;
                }
            }
        }
        if (z) {
            return;
        }
        arrayList.remove(va6Var);
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ve6 ve6Var = this.m;
            ve6Var.e = 0;
            ve6Var.g = false;
            ve6Var.i = false;
            ve6Var.h = false;
            ve6Var.b = this.b;
            ve6Var.a = this.c;
            ve6Var.c = 1;
            le6 le6Var = this.k;
            if (le6Var != null) {
                le6Var.a(3, 0, ve6Var, A(this.d, this.e, this.f, this.g, this.i, this.h, this.j));
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            wh8.h(301004, ForumMemberSocketResponseMessage.class, false, false);
            wh8.c(301004, CmdConfigHttp.FRS_MEMBER_TAB_CMD, TbConfig.GET_MEMBER_INFO, ForumMemberHttpResponseMessage.class, false, false, false, false);
            wh8.b(2003009, cb6.class);
        }
    }

    public void E(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        this.a = bdUniqueId;
    }

    @Override // com.repackage.he6
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

    @Override // com.repackage.he6
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.n);
            MessageManager.getInstance().unRegisterListener(this.o);
            MessageManager.getInstance().unRegisterListener(this.p);
            MessageManager.getInstance().unRegisterListener(this.q);
        }
    }

    @Override // com.repackage.he6
    public void u(int i, int i2, re6 re6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048583, this, i, i2, re6Var) == null) && i == 3 && re6Var != null) {
            String str = re6Var.b;
            this.b = str;
            String str2 = re6Var.a;
            this.c = str2;
            if (this.l) {
                y(str2);
            } else if (re6Var.c == -1) {
                z(ng.g(str, 0L), re6Var.a);
            } else {
                C();
            }
        }
    }

    public final fd6 w() {
        InterceptResult invokeV;
        int f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            List<MemberGroupInfo> list = this.e;
            if (list == null || list.size() <= 0) {
                return null;
            }
            fd6 fd6Var = new fd6();
            int i = pi.i(TbadkCoreApplication.getInst().getContext());
            int f2 = pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f07019a);
            int f3 = pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f07030a);
            int f4 = pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0702a0);
            int size = this.e.size();
            if (TbadkCoreApplication.isLogin()) {
                f = pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f07029b);
            } else {
                f = pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f07026e);
            }
            fd6Var.d(i - (((f2 + f3) + f) + (f4 * size)));
            fd6Var.c(R.drawable.obfuscated_res_0x7f0811a4);
            return fd6Var;
        }
        return (fd6) invokeV.objValue;
    }

    @Override // com.repackage.he6
    public void x(le6 le6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, le6Var) == null) {
            this.k = le6Var;
        }
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
