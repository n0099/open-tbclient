package d.a.n0.r0.e2;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.a.n0.e3.w;
/* loaded from: classes4.dex */
public class b extends j {

    /* renamed from: h  reason: collision with root package name */
    public final CustomMessageListener f58461h;

    /* renamed from: i  reason: collision with root package name */
    public final d.a.c.a.e f58462i;
    public final d.a.c.a.e j;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof w)) {
                return;
            }
            b.this.b((w) customResponsedMessage.getData());
        }
    }

    /* renamed from: d.a.n0.r0.e2.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1492b extends d.a.c.a.e {
        public C1492b(b bVar) {
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            if (obj instanceof Boolean) {
                ((Boolean) obj).booleanValue();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends d.a.c.a.e {
        public c() {
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            if (obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false) {
                return;
            }
            b.this.f58538b.refresh();
        }
    }

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.f58461h = new a(2001266);
        this.f58462i = new C1492b(this);
        this.j = new c();
        frsFragment.registerListener(this.f58461h);
    }

    public final void b(w wVar) {
        if (wVar == null) {
            return;
        }
        FrsViewData g0 = this.f58538b.g0();
        if (this.f58541e == null || this.f58540d == null || this.f58537a == null || g0 == null || g0.getForum() == null || wVar.g() == null) {
            return;
        }
        boolean z = wVar.l() == 1;
        if (wVar.g().equals(g0.getForum().getId())) {
            g0.getForum().setLike(wVar.l());
            if (!StringUtils.isNULL(wVar.h())) {
                g0.getForum().setLevelName(wVar.h());
            }
            if (wVar.k() >= 0) {
                g0.getForum().setUser_level(wVar.k());
            }
            if (z) {
                this.f58540d.h0(g0, false);
                TbadkCoreApplication.getInst().addLikeForum(this.f58538b.g());
                return;
            }
            d.a.n0.e3.e.i().n(this.f58538b.g(), false);
            g0.getForum().setLike(0);
            this.f58540d.m0();
            TbadkCoreApplication.getInst().delLikeForum(this.f58538b.g());
            return;
        }
        if (wVar.l() == 1) {
            g0.deleteLikeFeedForum(wVar.g());
            this.f58540d.R(g0);
            this.f58539c.d(g0, this.f58541e.N());
        }
        if (g0.getForum().getBannerListData() != null) {
            g0.getForum().getBannerListData().setFeedForumLiked(wVar.g(), wVar.l());
        }
        this.f58537a.D0();
    }
}
