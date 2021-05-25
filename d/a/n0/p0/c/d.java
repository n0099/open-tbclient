package d.a.n0.p0.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
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
import d.a.n0.e3.w;
import d.a.n0.r0.c1;
import d.a.n0.r0.p0;
import d.a.n0.r0.t0;
import d.a.n0.r0.z0;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMemberInfo.ManagerApplyInfo;
import tbclient.GetMemberInfo.MemberGodInfo;
import tbclient.MemberGroupInfo;
import tbclient.PriManagerApplyInfo;
import tbclient.User;
/* loaded from: classes4.dex */
public class d implements p0 {

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f57988e;

    /* renamed from: f  reason: collision with root package name */
    public String f57989f;

    /* renamed from: g  reason: collision with root package name */
    public String f57990g;

    /* renamed from: h  reason: collision with root package name */
    public w f57991h;

    /* renamed from: i  reason: collision with root package name */
    public List<MemberGroupInfo> f57992i;
    public MemberGodInfo j;
    public ManagerApplyInfo k;
    public PriManagerApplyInfo n;
    public t0 o;
    public boolean l = false;
    public boolean m = false;
    public boolean p = true;
    public c1 q = new c1();
    public d.a.c.c.g.a r = new a(CmdConfigHttp.FRS_MEMBER_TAB_CMD, 301004);
    public CustomMessageListener s = new b(2003009);
    public CustomMessageListener t = new c(2001266);
    public CustomMessageListener u = new C1461d(2001222);

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof ForumMemberHttpResponseMessage;
            if (z || (responsedMessage instanceof ForumMemberSocketResponseMessage)) {
                if (responsedMessage.getError() == 0) {
                    if (z) {
                        ForumMemberHttpResponseMessage forumMemberHttpResponseMessage = (ForumMemberHttpResponseMessage) responsedMessage;
                        d.this.f57991h = forumMemberHttpResponseMessage.getUserInfo();
                        d.this.f57992i = forumMemberHttpResponseMessage.getMemberGroupInfoList();
                        d.this.j = forumMemberHttpResponseMessage.getMemberGodInfo();
                        d.this.k = forumMemberHttpResponseMessage.getManagerApplyInfo();
                        d.this.m = forumMemberHttpResponseMessage.isBawuShow();
                        d.this.l = forumMemberHttpResponseMessage.isPrivateForum();
                        d.this.n = forumMemberHttpResponseMessage.getPrivateMgrApplyInfo();
                    } else if (responsedMessage instanceof ForumMemberSocketResponseMessage) {
                        ForumMemberSocketResponseMessage forumMemberSocketResponseMessage = (ForumMemberSocketResponseMessage) responsedMessage;
                        d.this.f57991h = forumMemberSocketResponseMessage.getUserInfo();
                        d.this.f57992i = forumMemberSocketResponseMessage.getMemberGroupInfoList();
                        d.this.j = forumMemberSocketResponseMessage.getMemberGodInfo();
                        d.this.k = forumMemberSocketResponseMessage.getManagerApplyInfo();
                        d.this.m = forumMemberSocketResponseMessage.isBawuShow();
                        d.this.l = forumMemberSocketResponseMessage.isPrivateForum();
                        d.this.n = forumMemberSocketResponseMessage.getPrivateMgrApplyInfo();
                    }
                }
                d.this.p = false;
                d.this.q.f58407e = responsedMessage.getError();
                d.this.q.f58408f = responsedMessage.getErrorString();
                d.this.q.f58409g = false;
                d.this.q.f58411i = false;
                d.this.q.f58410h = false;
                d.this.q.f59870b = d.this.f57989f;
                d.this.q.f59869a = d.this.f57990g;
                d.this.q.f59871c = 1;
                if (d.this.o != null) {
                    t0 t0Var = d.this.o;
                    c1 c1Var = d.this.q;
                    d dVar = d.this;
                    t0Var.a(3, 0, c1Var, dVar.A(dVar.f57991h, d.this.f57992i, d.this.j, d.this.k, d.this.m, d.this.l, d.this.n));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001352, d.this.f57991h));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ForumMemberReadCacheResponseMessage) {
                ForumMemberReadCacheResponseMessage forumMemberReadCacheResponseMessage = (ForumMemberReadCacheResponseMessage) customResponsedMessage;
                if (customResponsedMessage.getError() == 0) {
                    d.this.f57991h = forumMemberReadCacheResponseMessage.getUserInfo();
                    d.this.f57992i = forumMemberReadCacheResponseMessage.getMemberGroupInfoList();
                    d.this.j = forumMemberReadCacheResponseMessage.getMemberGodInfo();
                    d.this.k = forumMemberReadCacheResponseMessage.getManagerApplyInfo();
                    d.this.m = forumMemberReadCacheResponseMessage.isBawuShow();
                    d.this.l = forumMemberReadCacheResponseMessage.isPrivateForum();
                    d.this.n = forumMemberReadCacheResponseMessage.getPrivateMgrApplyInfo();
                }
                d.this.q.f58407e = customResponsedMessage.getError();
                d.this.q.f58408f = customResponsedMessage.getErrorString();
                d.this.q.f58409g = false;
                d.this.q.f58411i = false;
                d.this.q.f58410h = false;
                d.this.q.f59870b = d.this.f57989f;
                d.this.q.f59869a = d.this.f57990g;
                d.this.q.f59871c = 1;
                if (d.this.o != null) {
                    d dVar = d.this;
                    ArrayList<d.a.c.j.e.n> A = dVar.A(dVar.f57991h, d.this.f57992i, d.this.j, d.this.k, d.this.m, d.this.l, d.this.n);
                    if (A == null || A.size() <= 0) {
                        if (!d.this.p) {
                            d.this.o.a(3, 0, d.this.q, A);
                        }
                    } else {
                        d.this.o.a(3, 0, d.this.q, A);
                    }
                }
                if (d.this.p) {
                    d dVar2 = d.this;
                    dVar2.z(d.a.c.e.m.b.f(dVar2.f57989f, 0L), d.this.f57990g);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof w)) {
                return;
            }
            d.this.q.f58407e = customResponsedMessage.getError();
            d.this.q.f58408f = customResponsedMessage.getErrorString();
            d.this.q.f58409g = false;
            d.this.q.f58411i = false;
            d.this.q.f58410h = false;
            d.this.q.f59870b = d.this.f57989f;
            d.this.q.f59869a = d.this.f57990g;
            d.this.q.f59871c = 1;
            w wVar = (w) customResponsedMessage.getData();
            if (wVar != null && wVar.l() == 0 && d.this.f57991h != null) {
                wVar.r(d.this.f57991h.c());
                wVar.u(d.this.f57991h.i());
            }
            d.this.f57991h = wVar;
            if (d.this.o != null) {
                t0 t0Var = d.this.o;
                c1 c1Var = d.this.q;
                d dVar = d.this;
                t0Var.a(3, 0, c1Var, dVar.A(dVar.f57991h, d.this.f57992i, d.this.j, d.this.k, d.this.m, d.this.l, d.this.n));
            }
        }
    }

    /* renamed from: d.a.n0.p0.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1461d extends CustomMessageListener {
        public C1461d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof SignData)) {
                return;
            }
            d dVar = d.this;
            dVar.z(d.a.c.e.m.b.f(dVar.f57989f, 0L), d.this.f57990g);
        }
    }

    public ArrayList<d.a.c.j.e.n> A(w wVar, List<MemberGroupInfo> list, MemberGodInfo memberGodInfo, ManagerApplyInfo managerApplyInfo, boolean z, boolean z2, PriManagerApplyInfo priManagerApplyInfo) {
        if (wVar == null) {
            return null;
        }
        ArrayList<d.a.c.j.e.n> arrayList = new ArrayList<>();
        if (wVar.l() == 1) {
            h hVar = new h();
            hVar.k(wVar);
            hVar.h(this.f57989f);
            hVar.i(this.f57990g);
            arrayList.add(hVar);
        }
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (list.get(i2) != null && list.get(i2).member_group_num != null && list.get(i2).member_group_num.intValue() > 0 && ListUtils.getCount(list.get(i2).member_group_list) > 0) {
                    j jVar = new j();
                    jVar.f(this.f57989f);
                    jVar.h(this.f57990g);
                    jVar.i(list.get(i2));
                    if (i2 == size - 1) {
                        jVar.k(true);
                    } else {
                        jVar.k(false);
                    }
                    arrayList.add(jVar);
                }
            }
        }
        if (this.l) {
            if (this.m && priManagerApplyInfo != null) {
                n nVar = new n();
                nVar.l(priManagerApplyInfo.assist_left_num.intValue());
                nVar.k(priManagerApplyInfo.assist_apply_url);
                nVar.i(priManagerApplyInfo.assist_apply_status.intValue());
                arrayList.add(nVar);
            }
        } else {
            l lVar = new l();
            if (managerApplyInfo != null) {
                lVar.m(managerApplyInfo.manager_left_num.intValue());
                lVar.l(managerApplyInfo.manager_apply_url);
                lVar.i(managerApplyInfo.assist_left_num.intValue());
                lVar.h(managerApplyInfo.assist_apply_url);
                lVar.k(managerApplyInfo.manager_apply_status.intValue());
            }
            arrayList.add(lVar);
            d.a.n0.p0.c.b bVar = new d.a.n0.p0.c.b();
            bVar.f57985e = R.string.complaint_bar_lord;
            bVar.f57986f = "https://tieba.baidu.com/tb/cms/redpacket/page/complain.html?id=" + this.f57989f;
            arrayList.add(bVar);
        }
        B(memberGodInfo, arrayList);
        d.a.c.j.e.n x = x();
        if (x != null) {
            arrayList.add(x);
        }
        return arrayList;
    }

    public final void B(MemberGodInfo memberGodInfo, ArrayList<d.a.c.j.e.n> arrayList) {
        List<User> list;
        if (memberGodInfo == null || (list = memberGodInfo.forum_god_list) == null || list.size() <= 0 || arrayList == null) {
            return;
        }
        List<User> list2 = memberGodInfo.forum_god_list;
        if (memberGodInfo.forum_god_num.intValue() == 0 || list2.size() == 0) {
            return;
        }
        d.a.n0.p0.b.b bVar = new d.a.n0.p0.b.b();
        bVar.f(memberGodInfo);
        arrayList.add(bVar);
        boolean z = false;
        for (int i2 = 0; i2 < list2.size(); i2++) {
            User user = list2.get(i2);
            if (user != null && user.god_data.type.intValue() == 2) {
                d.a.n0.p0.b.d dVar = new d.a.n0.p0.b.d();
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
        c1 c1Var = this.q;
        c1Var.f58407e = 0;
        c1Var.f58409g = false;
        c1Var.f58411i = false;
        c1Var.f58410h = false;
        c1Var.f59870b = this.f57989f;
        c1Var.f59869a = this.f57990g;
        c1Var.f59871c = 1;
        t0 t0Var = this.o;
        if (t0Var != null) {
            t0Var.a(3, 0, c1Var, A(this.f57991h, this.f57992i, this.j, this.k, this.m, this.l, this.n));
        }
    }

    public void D() {
        d.a.n0.e3.d0.a.h(301004, ForumMemberSocketResponseMessage.class, false, false);
        d.a.n0.e3.d0.a.c(301004, CmdConfigHttp.FRS_MEMBER_TAB_CMD, TbConfig.GET_MEMBER_INFO, ForumMemberHttpResponseMessage.class, false, false, false, false);
        d.a.n0.e3.d0.a.b(2003009, e.class);
    }

    public void E(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return;
        }
        this.f57988e = bdUniqueId;
    }

    @Override // d.a.n0.r0.p0
    public void e() {
        MessageManager.getInstance().unRegisterListener(this.r);
        MessageManager.getInstance().unRegisterListener(this.s);
        MessageManager.getInstance().unRegisterListener(this.t);
        MessageManager.getInstance().unRegisterListener(this.u);
    }

    @Override // d.a.n0.r0.p0
    public void init() {
        D();
        BdUniqueId bdUniqueId = this.f57988e;
        if (bdUniqueId != null) {
            this.s.setTag(bdUniqueId);
            this.r.setTag(this.f57988e);
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

    @Override // d.a.n0.r0.p0
    public void m(int i2, int i3, z0 z0Var) {
        if (i2 != 3 || z0Var == null) {
            return;
        }
        String str = z0Var.f59870b;
        this.f57989f = str;
        String str2 = z0Var.f59869a;
        this.f57990g = str2;
        if (this.p) {
            y(str2);
        } else if (z0Var.f59871c == -1) {
            z(d.a.c.e.m.b.f(str, 0L), z0Var.f59869a);
        } else {
            C();
        }
    }

    @Override // d.a.n0.r0.p0
    public void p(t0 t0Var) {
        this.o = t0Var;
    }

    public final d.a.n0.r0.n x() {
        int g2;
        List<MemberGroupInfo> list = this.f57992i;
        if (list == null || list.size() <= 0) {
            return null;
        }
        d.a.n0.r0.n nVar = new d.a.n0.r0.n();
        int i2 = d.a.c.e.p.l.i(TbadkCoreApplication.getInst().getContext());
        int g3 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds100);
        int g4 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds90);
        int g5 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320);
        int size = this.f57992i.size();
        if (TbadkCoreApplication.isLogin()) {
            g2 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds300);
        } else {
            g2 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds200);
        }
        nVar.h(i2 - (((g3 + g4) + g2) + (g5 * size)));
        nVar.f(R.drawable.transparent_bg);
        return nVar;
    }

    public void y(String str) {
        ForumMemberReadCacheRequestMessage forumMemberReadCacheRequestMessage = new ForumMemberReadCacheRequestMessage();
        BdUniqueId bdUniqueId = this.f57988e;
        if (bdUniqueId != null) {
            forumMemberReadCacheRequestMessage.setTag(bdUniqueId);
        }
        forumMemberReadCacheRequestMessage.setForumName(str);
        MessageManager.getInstance().sendMessage(forumMemberReadCacheRequestMessage);
    }

    public void z(long j, String str) {
        if (j <= 0 || StringUtils.isNull(str)) {
            return;
        }
        ForumMemberRequestMessage forumMemberRequestMessage = new ForumMemberRequestMessage();
        BdUniqueId bdUniqueId = this.f57988e;
        if (bdUniqueId != null) {
            forumMemberRequestMessage.setTag(bdUniqueId);
        }
        forumMemberRequestMessage.setForumId(j);
        forumMemberRequestMessage.setForumName(str);
        MessageManager.getInstance().sendMessage(forumMemberRequestMessage);
    }
}
