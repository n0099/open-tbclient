package d.a.q0.s0.c;

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
import d.a.q0.h3.w;
import d.a.q0.u0.b1;
import d.a.q0.u0.o0;
import d.a.q0.u0.s0;
import d.a.q0.u0.y0;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMemberInfo.ManagerApplyInfo;
import tbclient.GetMemberInfo.MemberGodInfo;
import tbclient.MemberGroupInfo;
import tbclient.PriManagerApplyInfo;
import tbclient.User;
/* loaded from: classes8.dex */
public class d implements o0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f62657e;

    /* renamed from: f  reason: collision with root package name */
    public String f62658f;

    /* renamed from: g  reason: collision with root package name */
    public String f62659g;

    /* renamed from: h  reason: collision with root package name */
    public w f62660h;

    /* renamed from: i  reason: collision with root package name */
    public List<MemberGroupInfo> f62661i;
    public MemberGodInfo j;
    public ManagerApplyInfo k;
    public boolean l;
    public boolean m;
    public PriManagerApplyInfo n;
    public s0 o;
    public boolean p;
    public b1 q;
    public d.a.d.c.g.a r;
    public CustomMessageListener s;
    public CustomMessageListener t;
    public CustomMessageListener u;

    /* loaded from: classes8.dex */
    public class a extends d.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f62662a;

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
            this.f62662a = dVar;
        }

        @Override // d.a.d.c.g.a
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
                        this.f62662a.f62660h = forumMemberHttpResponseMessage.getUserInfo();
                        this.f62662a.f62661i = forumMemberHttpResponseMessage.getMemberGroupInfoList();
                        this.f62662a.j = forumMemberHttpResponseMessage.getMemberGodInfo();
                        this.f62662a.k = forumMemberHttpResponseMessage.getManagerApplyInfo();
                        this.f62662a.m = forumMemberHttpResponseMessage.isBawuShow();
                        this.f62662a.l = forumMemberHttpResponseMessage.isPrivateForum();
                        this.f62662a.n = forumMemberHttpResponseMessage.getPrivateMgrApplyInfo();
                    } else if (responsedMessage instanceof ForumMemberSocketResponseMessage) {
                        ForumMemberSocketResponseMessage forumMemberSocketResponseMessage = (ForumMemberSocketResponseMessage) responsedMessage;
                        this.f62662a.f62660h = forumMemberSocketResponseMessage.getUserInfo();
                        this.f62662a.f62661i = forumMemberSocketResponseMessage.getMemberGroupInfoList();
                        this.f62662a.j = forumMemberSocketResponseMessage.getMemberGodInfo();
                        this.f62662a.k = forumMemberSocketResponseMessage.getManagerApplyInfo();
                        this.f62662a.m = forumMemberSocketResponseMessage.isBawuShow();
                        this.f62662a.l = forumMemberSocketResponseMessage.isPrivateForum();
                        this.f62662a.n = forumMemberSocketResponseMessage.getPrivateMgrApplyInfo();
                    }
                }
                this.f62662a.p = false;
                this.f62662a.q.f63212e = responsedMessage.getError();
                this.f62662a.q.f63213f = responsedMessage.getErrorString();
                this.f62662a.q.f63214g = false;
                this.f62662a.q.f63216i = false;
                this.f62662a.q.f63215h = false;
                this.f62662a.q.f64659b = this.f62662a.f62658f;
                this.f62662a.q.f64658a = this.f62662a.f62659g;
                this.f62662a.q.f64660c = 1;
                if (this.f62662a.o != null) {
                    s0 s0Var = this.f62662a.o;
                    b1 b1Var = this.f62662a.q;
                    d dVar = this.f62662a;
                    s0Var.a(3, 0, b1Var, dVar.A(dVar.f62660h, this.f62662a.f62661i, this.f62662a.j, this.f62662a.k, this.f62662a.m, this.f62662a.l, this.f62662a.n));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001352, this.f62662a.f62660h));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f62663a;

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
            this.f62663a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ForumMemberReadCacheResponseMessage)) {
                ForumMemberReadCacheResponseMessage forumMemberReadCacheResponseMessage = (ForumMemberReadCacheResponseMessage) customResponsedMessage;
                if (customResponsedMessage.getError() == 0) {
                    this.f62663a.f62660h = forumMemberReadCacheResponseMessage.getUserInfo();
                    this.f62663a.f62661i = forumMemberReadCacheResponseMessage.getMemberGroupInfoList();
                    this.f62663a.j = forumMemberReadCacheResponseMessage.getMemberGodInfo();
                    this.f62663a.k = forumMemberReadCacheResponseMessage.getManagerApplyInfo();
                    this.f62663a.m = forumMemberReadCacheResponseMessage.isBawuShow();
                    this.f62663a.l = forumMemberReadCacheResponseMessage.isPrivateForum();
                    this.f62663a.n = forumMemberReadCacheResponseMessage.getPrivateMgrApplyInfo();
                }
                this.f62663a.q.f63212e = customResponsedMessage.getError();
                this.f62663a.q.f63213f = customResponsedMessage.getErrorString();
                this.f62663a.q.f63214g = false;
                this.f62663a.q.f63216i = false;
                this.f62663a.q.f63215h = false;
                this.f62663a.q.f64659b = this.f62663a.f62658f;
                this.f62663a.q.f64658a = this.f62663a.f62659g;
                this.f62663a.q.f64660c = 1;
                if (this.f62663a.o != null) {
                    d dVar = this.f62663a;
                    ArrayList<d.a.d.k.e.n> A = dVar.A(dVar.f62660h, this.f62663a.f62661i, this.f62663a.j, this.f62663a.k, this.f62663a.m, this.f62663a.l, this.f62663a.n);
                    if (A == null || A.size() <= 0) {
                        if (!this.f62663a.p) {
                            this.f62663a.o.a(3, 0, this.f62663a.q, A);
                        }
                    } else {
                        this.f62663a.o.a(3, 0, this.f62663a.q, A);
                    }
                }
                if (this.f62663a.p) {
                    d dVar2 = this.f62663a;
                    dVar2.z(d.a.d.e.m.b.f(dVar2.f62658f, 0L), this.f62663a.f62659g);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f62664a;

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
            this.f62664a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof w)) {
                this.f62664a.q.f63212e = customResponsedMessage.getError();
                this.f62664a.q.f63213f = customResponsedMessage.getErrorString();
                this.f62664a.q.f63214g = false;
                this.f62664a.q.f63216i = false;
                this.f62664a.q.f63215h = false;
                this.f62664a.q.f64659b = this.f62664a.f62658f;
                this.f62664a.q.f64658a = this.f62664a.f62659g;
                this.f62664a.q.f64660c = 1;
                w wVar = (w) customResponsedMessage.getData();
                if (wVar != null && wVar.l() == 0 && this.f62664a.f62660h != null) {
                    wVar.r(this.f62664a.f62660h.c());
                    wVar.u(this.f62664a.f62660h.i());
                }
                this.f62664a.f62660h = wVar;
                if (this.f62664a.o != null) {
                    s0 s0Var = this.f62664a.o;
                    b1 b1Var = this.f62664a.q;
                    d dVar = this.f62664a;
                    s0Var.a(3, 0, b1Var, dVar.A(dVar.f62660h, this.f62664a.f62661i, this.f62664a.j, this.f62664a.k, this.f62664a.m, this.f62664a.l, this.f62664a.n));
                }
            }
        }
    }

    /* renamed from: d.a.q0.s0.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1630d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f62665a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1630d(d dVar, int i2) {
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
            this.f62665a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
                d dVar = this.f62665a;
                dVar.z(d.a.d.e.m.b.f(dVar.f62658f, 0L), this.f62665a.f62659g);
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
        this.u = new C1630d(this, 2001222);
    }

    public ArrayList<d.a.d.k.e.n> A(w wVar, List<MemberGroupInfo> list, MemberGodInfo memberGodInfo, ManagerApplyInfo managerApplyInfo, boolean z, boolean z2, PriManagerApplyInfo priManagerApplyInfo) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{wVar, list, memberGodInfo, managerApplyInfo, Boolean.valueOf(z), Boolean.valueOf(z2), priManagerApplyInfo})) == null) {
            if (wVar == null) {
                return null;
            }
            ArrayList<d.a.d.k.e.n> arrayList = new ArrayList<>();
            if (wVar.l() == 1) {
                h hVar = new h();
                hVar.i(wVar);
                hVar.e(this.f62658f);
                hVar.h(this.f62659g);
                arrayList.add(hVar);
            }
            if (list != null && list.size() > 0) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (list.get(i2) != null && list.get(i2).member_group_num != null && list.get(i2).member_group_num.intValue() > 0 && ListUtils.getCount(list.get(i2).member_group_list) > 0) {
                        j jVar = new j();
                        jVar.d(this.f62658f);
                        jVar.e(this.f62659g);
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
                d.a.q0.s0.c.b bVar = new d.a.q0.s0.c.b();
                bVar.f62654e = R.string.complaint_bar_lord;
                bVar.f62655f = "https://tieba.baidu.com/tb/cms/redpacket/page/complain.html?id=" + this.f62658f;
                arrayList.add(bVar);
            }
            B(memberGodInfo, arrayList);
            d.a.d.k.e.n x = x();
            if (x != null) {
                arrayList.add(x);
            }
            return arrayList;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public final void B(MemberGodInfo memberGodInfo, ArrayList<d.a.d.k.e.n> arrayList) {
        List<User> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, memberGodInfo, arrayList) == null) || memberGodInfo == null || (list = memberGodInfo.forum_god_list) == null || list.size() <= 0 || arrayList == null) {
            return;
        }
        List<User> list2 = memberGodInfo.forum_god_list;
        if (memberGodInfo.forum_god_num.intValue() == 0 || list2.size() == 0) {
            return;
        }
        d.a.q0.s0.b.b bVar = new d.a.q0.s0.b.b();
        bVar.d(memberGodInfo);
        arrayList.add(bVar);
        boolean z = false;
        for (int i2 = 0; i2 < list2.size(); i2++) {
            User user = list2.get(i2);
            if (user != null && user.god_data.type.intValue() == 2) {
                d.a.q0.s0.b.d dVar = new d.a.q0.s0.b.d();
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
            b1Var.f63212e = 0;
            b1Var.f63214g = false;
            b1Var.f63216i = false;
            b1Var.f63215h = false;
            b1Var.f64659b = this.f62658f;
            b1Var.f64658a = this.f62659g;
            b1Var.f64660c = 1;
            s0 s0Var = this.o;
            if (s0Var != null) {
                s0Var.a(3, 0, b1Var, A(this.f62660h, this.f62661i, this.j, this.k, this.m, this.l, this.n));
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d.a.q0.h3.d0.a.h(301004, ForumMemberSocketResponseMessage.class, false, false);
            d.a.q0.h3.d0.a.c(301004, CmdConfigHttp.FRS_MEMBER_TAB_CMD, TbConfig.GET_MEMBER_INFO, ForumMemberHttpResponseMessage.class, false, false, false, false);
            d.a.q0.h3.d0.a.b(2003009, e.class);
        }
    }

    public void E(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        this.f62657e = bdUniqueId;
    }

    @Override // d.a.q0.u0.o0
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.r);
            MessageManager.getInstance().unRegisterListener(this.s);
            MessageManager.getInstance().unRegisterListener(this.t);
            MessageManager.getInstance().unRegisterListener(this.u);
        }
    }

    @Override // d.a.q0.u0.o0
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            D();
            BdUniqueId bdUniqueId = this.f62657e;
            if (bdUniqueId != null) {
                this.s.setTag(bdUniqueId);
                this.r.setTag(this.f62657e);
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

    @Override // d.a.q0.u0.o0
    public void q(int i2, int i3, y0 y0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048583, this, i2, i3, y0Var) == null) && i2 == 3 && y0Var != null) {
            String str = y0Var.f64659b;
            this.f62658f = str;
            String str2 = y0Var.f64658a;
            this.f62659g = str2;
            if (this.p) {
                y(str2);
            } else if (y0Var.f64660c == -1) {
                z(d.a.d.e.m.b.f(str, 0L), y0Var.f64658a);
            } else {
                C();
            }
        }
    }

    @Override // d.a.q0.u0.o0
    public void t(s0 s0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, s0Var) == null) {
            this.o = s0Var;
        }
    }

    public final d.a.q0.u0.n x() {
        InterceptResult invokeV;
        int g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            List<MemberGroupInfo> list = this.f62661i;
            if (list == null || list.size() <= 0) {
                return null;
            }
            d.a.q0.u0.n nVar = new d.a.q0.u0.n();
            int i2 = d.a.d.e.p.l.i(TbadkCoreApplication.getInst().getContext());
            int g3 = d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds100);
            int g4 = d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds90);
            int g5 = d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320);
            int size = this.f62661i.size();
            if (TbadkCoreApplication.isLogin()) {
                g2 = d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds300);
            } else {
                g2 = d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds200);
            }
            nVar.e(i2 - (((g3 + g4) + g2) + (g5 * size)));
            nVar.d(R.drawable.transparent_bg);
            return nVar;
        }
        return (d.a.q0.u0.n) invokeV.objValue;
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            ForumMemberReadCacheRequestMessage forumMemberReadCacheRequestMessage = new ForumMemberReadCacheRequestMessage();
            BdUniqueId bdUniqueId = this.f62657e;
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
        BdUniqueId bdUniqueId = this.f62657e;
        if (bdUniqueId != null) {
            forumMemberRequestMessage.setTag(bdUniqueId);
        }
        forumMemberRequestMessage.setForumId(j);
        forumMemberRequestMessage.setForumName(str);
        MessageManager.getInstance().sendMessage(forumMemberRequestMessage);
    }
}
