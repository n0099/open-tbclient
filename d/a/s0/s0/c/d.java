package d.a.s0.s0.c;

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
import d.a.s0.h3.w;
import d.a.s0.u0.b1;
import d.a.s0.u0.o0;
import d.a.s0.u0.s0;
import d.a.s0.u0.y0;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMemberInfo.ManagerApplyInfo;
import tbclient.GetMemberInfo.MemberGodInfo;
import tbclient.MemberGroupInfo;
import tbclient.PriManagerApplyInfo;
import tbclient.User;
/* loaded from: classes9.dex */
public class d implements o0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f65265e;

    /* renamed from: f  reason: collision with root package name */
    public String f65266f;

    /* renamed from: g  reason: collision with root package name */
    public String f65267g;

    /* renamed from: h  reason: collision with root package name */
    public w f65268h;

    /* renamed from: i  reason: collision with root package name */
    public List<MemberGroupInfo> f65269i;
    public MemberGodInfo j;
    public ManagerApplyInfo k;
    public boolean l;
    public boolean m;
    public PriManagerApplyInfo n;
    public s0 o;
    public boolean p;
    public b1 q;
    public d.a.c.c.g.a r;
    public CustomMessageListener s;
    public CustomMessageListener t;
    public CustomMessageListener u;

    /* loaded from: classes9.dex */
    public class a extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f65270a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65270a = dVar;
        }

        @Override // d.a.c.c.g.a
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
                        this.f65270a.f65268h = forumMemberHttpResponseMessage.getUserInfo();
                        this.f65270a.f65269i = forumMemberHttpResponseMessage.getMemberGroupInfoList();
                        this.f65270a.j = forumMemberHttpResponseMessage.getMemberGodInfo();
                        this.f65270a.k = forumMemberHttpResponseMessage.getManagerApplyInfo();
                        this.f65270a.m = forumMemberHttpResponseMessage.isBawuShow();
                        this.f65270a.l = forumMemberHttpResponseMessage.isPrivateForum();
                        this.f65270a.n = forumMemberHttpResponseMessage.getPrivateMgrApplyInfo();
                    } else if (responsedMessage instanceof ForumMemberSocketResponseMessage) {
                        ForumMemberSocketResponseMessage forumMemberSocketResponseMessage = (ForumMemberSocketResponseMessage) responsedMessage;
                        this.f65270a.f65268h = forumMemberSocketResponseMessage.getUserInfo();
                        this.f65270a.f65269i = forumMemberSocketResponseMessage.getMemberGroupInfoList();
                        this.f65270a.j = forumMemberSocketResponseMessage.getMemberGodInfo();
                        this.f65270a.k = forumMemberSocketResponseMessage.getManagerApplyInfo();
                        this.f65270a.m = forumMemberSocketResponseMessage.isBawuShow();
                        this.f65270a.l = forumMemberSocketResponseMessage.isPrivateForum();
                        this.f65270a.n = forumMemberSocketResponseMessage.getPrivateMgrApplyInfo();
                    }
                }
                this.f65270a.p = false;
                this.f65270a.q.f65788e = responsedMessage.getError();
                this.f65270a.q.f65789f = responsedMessage.getErrorString();
                this.f65270a.q.f65790g = false;
                this.f65270a.q.f65792i = false;
                this.f65270a.q.f65791h = false;
                this.f65270a.q.f67231b = this.f65270a.f65266f;
                this.f65270a.q.f67230a = this.f65270a.f65267g;
                this.f65270a.q.f67232c = 1;
                if (this.f65270a.o != null) {
                    s0 s0Var = this.f65270a.o;
                    b1 b1Var = this.f65270a.q;
                    d dVar = this.f65270a;
                    s0Var.a(3, 0, b1Var, dVar.A(dVar.f65268h, this.f65270a.f65269i, this.f65270a.j, this.f65270a.k, this.f65270a.m, this.f65270a.l, this.f65270a.n));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001352, this.f65270a.f65268h));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f65271a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
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
            this.f65271a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ForumMemberReadCacheResponseMessage)) {
                ForumMemberReadCacheResponseMessage forumMemberReadCacheResponseMessage = (ForumMemberReadCacheResponseMessage) customResponsedMessage;
                if (customResponsedMessage.getError() == 0) {
                    this.f65271a.f65268h = forumMemberReadCacheResponseMessage.getUserInfo();
                    this.f65271a.f65269i = forumMemberReadCacheResponseMessage.getMemberGroupInfoList();
                    this.f65271a.j = forumMemberReadCacheResponseMessage.getMemberGodInfo();
                    this.f65271a.k = forumMemberReadCacheResponseMessage.getManagerApplyInfo();
                    this.f65271a.m = forumMemberReadCacheResponseMessage.isBawuShow();
                    this.f65271a.l = forumMemberReadCacheResponseMessage.isPrivateForum();
                    this.f65271a.n = forumMemberReadCacheResponseMessage.getPrivateMgrApplyInfo();
                }
                this.f65271a.q.f65788e = customResponsedMessage.getError();
                this.f65271a.q.f65789f = customResponsedMessage.getErrorString();
                this.f65271a.q.f65790g = false;
                this.f65271a.q.f65792i = false;
                this.f65271a.q.f65791h = false;
                this.f65271a.q.f67231b = this.f65271a.f65266f;
                this.f65271a.q.f67230a = this.f65271a.f65267g;
                this.f65271a.q.f67232c = 1;
                if (this.f65271a.o != null) {
                    d dVar = this.f65271a;
                    ArrayList<d.a.c.k.e.n> A = dVar.A(dVar.f65268h, this.f65271a.f65269i, this.f65271a.j, this.f65271a.k, this.f65271a.m, this.f65271a.l, this.f65271a.n);
                    if (A == null || A.size() <= 0) {
                        if (!this.f65271a.p) {
                            this.f65271a.o.a(3, 0, this.f65271a.q, A);
                        }
                    } else {
                        this.f65271a.o.a(3, 0, this.f65271a.q, A);
                    }
                }
                if (this.f65271a.p) {
                    d dVar2 = this.f65271a;
                    dVar2.z(d.a.c.e.m.b.f(dVar2.f65266f, 0L), this.f65271a.f65267g);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f65272a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
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
            this.f65272a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof w)) {
                this.f65272a.q.f65788e = customResponsedMessage.getError();
                this.f65272a.q.f65789f = customResponsedMessage.getErrorString();
                this.f65272a.q.f65790g = false;
                this.f65272a.q.f65792i = false;
                this.f65272a.q.f65791h = false;
                this.f65272a.q.f67231b = this.f65272a.f65266f;
                this.f65272a.q.f67230a = this.f65272a.f65267g;
                this.f65272a.q.f67232c = 1;
                w wVar = (w) customResponsedMessage.getData();
                if (wVar != null && wVar.l() == 0 && this.f65272a.f65268h != null) {
                    wVar.r(this.f65272a.f65268h.c());
                    wVar.u(this.f65272a.f65268h.i());
                }
                this.f65272a.f65268h = wVar;
                if (this.f65272a.o != null) {
                    s0 s0Var = this.f65272a.o;
                    b1 b1Var = this.f65272a.q;
                    d dVar = this.f65272a;
                    s0Var.a(3, 0, b1Var, dVar.A(dVar.f65268h, this.f65272a.f65269i, this.f65272a.j, this.f65272a.k, this.f65272a.m, this.f65272a.l, this.f65272a.n));
                }
            }
        }
    }

    /* renamed from: d.a.s0.s0.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1667d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f65273a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1667d(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
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
            this.f65273a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
                d dVar = this.f65273a;
                dVar.z(d.a.c.e.m.b.f(dVar.f65266f, 0L), this.f65273a.f65267g);
            }
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = false;
        this.m = false;
        this.p = true;
        this.q = new b1();
        this.r = new a(this, CmdConfigHttp.FRS_MEMBER_TAB_CMD, 301004);
        this.s = new b(this, 2003009);
        this.t = new c(this, 2001266);
        this.u = new C1667d(this, 2001222);
    }

    public ArrayList<d.a.c.k.e.n> A(w wVar, List<MemberGroupInfo> list, MemberGodInfo memberGodInfo, ManagerApplyInfo managerApplyInfo, boolean z, boolean z2, PriManagerApplyInfo priManagerApplyInfo) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{wVar, list, memberGodInfo, managerApplyInfo, Boolean.valueOf(z), Boolean.valueOf(z2), priManagerApplyInfo})) == null) {
            if (wVar == null) {
                return null;
            }
            ArrayList<d.a.c.k.e.n> arrayList = new ArrayList<>();
            if (wVar.l() == 1) {
                h hVar = new h();
                hVar.i(wVar);
                hVar.e(this.f65266f);
                hVar.h(this.f65267g);
                arrayList.add(hVar);
            }
            if (list != null && list.size() > 0) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (list.get(i2) != null && list.get(i2).member_group_num != null && list.get(i2).member_group_num.intValue() > 0 && ListUtils.getCount(list.get(i2).member_group_list) > 0) {
                        j jVar = new j();
                        jVar.d(this.f65266f);
                        jVar.e(this.f65267g);
                        jVar.h(list.get(i2));
                        if (i2 == size - 1) {
                            jVar.i(true);
                        } else {
                            jVar.i(false);
                        }
                        arrayList.add(jVar);
                    }
                }
            }
            if (this.l) {
                if (this.m && priManagerApplyInfo != null) {
                    n nVar = new n();
                    nVar.j(priManagerApplyInfo.assist_left_num.intValue());
                    nVar.i(priManagerApplyInfo.assist_apply_url);
                    nVar.h(priManagerApplyInfo.assist_apply_status.intValue());
                    arrayList.add(nVar);
                }
            } else {
                l lVar = new l();
                if (managerApplyInfo != null) {
                    lVar.l(managerApplyInfo.manager_left_num.intValue());
                    lVar.j(managerApplyInfo.manager_apply_url);
                    lVar.h(managerApplyInfo.assist_left_num.intValue());
                    lVar.e(managerApplyInfo.assist_apply_url);
                    lVar.i(managerApplyInfo.manager_apply_status.intValue());
                }
                arrayList.add(lVar);
                d.a.s0.s0.c.b bVar = new d.a.s0.s0.c.b();
                bVar.f65262e = R.string.complaint_bar_lord;
                bVar.f65263f = "https://tieba.baidu.com/tb/cms/redpacket/page/complain.html?id=" + this.f65266f;
                arrayList.add(bVar);
            }
            B(memberGodInfo, arrayList);
            d.a.c.k.e.n x = x();
            if (x != null) {
                arrayList.add(x);
            }
            return arrayList;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public final void B(MemberGodInfo memberGodInfo, ArrayList<d.a.c.k.e.n> arrayList) {
        List<User> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, memberGodInfo, arrayList) == null) || memberGodInfo == null || (list = memberGodInfo.forum_god_list) == null || list.size() <= 0 || arrayList == null) {
            return;
        }
        List<User> list2 = memberGodInfo.forum_god_list;
        if (memberGodInfo.forum_god_num.intValue() == 0 || list2.size() == 0) {
            return;
        }
        d.a.s0.s0.b.b bVar = new d.a.s0.s0.b.b();
        bVar.d(memberGodInfo);
        arrayList.add(bVar);
        boolean z = false;
        for (int i2 = 0; i2 < list2.size(); i2++) {
            User user = list2.get(i2);
            if (user != null && user.god_data.type.intValue() == 2) {
                d.a.s0.s0.b.d dVar = new d.a.s0.s0.b.d();
                dVar.s(user, i2);
                arrayList.add(dVar);
                if (!z) {
                    z = true;
                }
            }
        }
        if (z) {
            return;
        }
        arrayList.remove(bVar);
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b1 b1Var = this.q;
            b1Var.f65788e = 0;
            b1Var.f65790g = false;
            b1Var.f65792i = false;
            b1Var.f65791h = false;
            b1Var.f67231b = this.f65266f;
            b1Var.f67230a = this.f65267g;
            b1Var.f67232c = 1;
            s0 s0Var = this.o;
            if (s0Var != null) {
                s0Var.a(3, 0, b1Var, A(this.f65268h, this.f65269i, this.j, this.k, this.m, this.l, this.n));
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d.a.s0.h3.d0.a.h(301004, ForumMemberSocketResponseMessage.class, false, false);
            d.a.s0.h3.d0.a.c(301004, CmdConfigHttp.FRS_MEMBER_TAB_CMD, TbConfig.GET_MEMBER_INFO, ForumMemberHttpResponseMessage.class, false, false, false, false);
            d.a.s0.h3.d0.a.b(2003009, e.class);
        }
    }

    public void E(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        this.f65265e = bdUniqueId;
    }

    @Override // d.a.s0.u0.o0
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.r);
            MessageManager.getInstance().unRegisterListener(this.s);
            MessageManager.getInstance().unRegisterListener(this.t);
            MessageManager.getInstance().unRegisterListener(this.u);
        }
    }

    @Override // d.a.s0.u0.o0
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            D();
            BdUniqueId bdUniqueId = this.f65265e;
            if (bdUniqueId != null) {
                this.s.setTag(bdUniqueId);
                this.r.setTag(this.f65265e);
                this.s.setSelfListener(true);
                if (this.r.getHttpMessageListener() != null) {
                    this.r.getHttpMessageListener().setSelfListener(true);
                }
                if (this.r.getSocketMessageListener() != null) {
                    this.r.getSocketMessageListener().setSelfListener(true);
                }
            }
            MessageManager.getInstance().registerListener(this.s);
            MessageManager.getInstance().registerListener(this.r);
            MessageManager.getInstance().registerListener(this.t);
            MessageManager.getInstance().registerListener(this.u);
        }
    }

    @Override // d.a.s0.u0.o0
    public void q(int i2, int i3, y0 y0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048583, this, i2, i3, y0Var) == null) && i2 == 3 && y0Var != null) {
            String str = y0Var.f67231b;
            this.f65266f = str;
            String str2 = y0Var.f67230a;
            this.f65267g = str2;
            if (this.p) {
                y(str2);
            } else if (y0Var.f67232c == -1) {
                z(d.a.c.e.m.b.f(str, 0L), y0Var.f67230a);
            } else {
                C();
            }
        }
    }

    @Override // d.a.s0.u0.o0
    public void t(s0 s0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, s0Var) == null) {
            this.o = s0Var;
        }
    }

    public final d.a.s0.u0.n x() {
        InterceptResult invokeV;
        int g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            List<MemberGroupInfo> list = this.f65269i;
            if (list == null || list.size() <= 0) {
                return null;
            }
            d.a.s0.u0.n nVar = new d.a.s0.u0.n();
            int i2 = d.a.c.e.p.l.i(TbadkCoreApplication.getInst().getContext());
            int g3 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds100);
            int g4 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds90);
            int g5 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320);
            int size = this.f65269i.size();
            if (TbadkCoreApplication.isLogin()) {
                g2 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds300);
            } else {
                g2 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds200);
            }
            nVar.e(i2 - (((g3 + g4) + g2) + (g5 * size)));
            nVar.d(R.drawable.transparent_bg);
            return nVar;
        }
        return (d.a.s0.u0.n) invokeV.objValue;
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            ForumMemberReadCacheRequestMessage forumMemberReadCacheRequestMessage = new ForumMemberReadCacheRequestMessage();
            BdUniqueId bdUniqueId = this.f65265e;
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
        BdUniqueId bdUniqueId = this.f65265e;
        if (bdUniqueId != null) {
            forumMemberRequestMessage.setTag(bdUniqueId);
        }
        forumMemberRequestMessage.setForumId(j);
        forumMemberRequestMessage.setForumName(str);
        MessageManager.getInstance().sendMessage(forumMemberRequestMessage);
    }
}
