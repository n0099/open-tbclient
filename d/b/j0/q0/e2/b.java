package d.b.j0.q0.e2;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.b.j0.d3.w;
/* loaded from: classes4.dex */
public class b extends j {

    /* renamed from: h  reason: collision with root package name */
    public final CustomMessageListener f59533h;
    public final d.b.c.a.e i;
    public final d.b.c.a.e j;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
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

    /* renamed from: d.b.j0.q0.e2.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1466b extends d.b.c.a.e {
        public C1466b(b bVar) {
        }

        @Override // d.b.c.a.e
        public void c(Object obj) {
            if (obj instanceof Boolean) {
                ((Boolean) obj).booleanValue();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends d.b.c.a.e {
        public c() {
        }

        @Override // d.b.c.a.e
        public void c(Object obj) {
            if (obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false) {
                return;
            }
            b.this.f59598b.refresh();
        }
    }

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.f59533h = new a(2001266);
        this.i = new C1466b(this);
        this.j = new c();
        frsFragment.registerListener(this.f59533h);
    }

    public final void b(w wVar) {
        if (wVar == null) {
            return;
        }
        FrsViewData S = this.f59598b.S();
        if (this.f59601e == null || this.f59600d == null || this.f59597a == null || S == null || S.getForum() == null || wVar.g() == null) {
            return;
        }
        boolean z = wVar.l() == 1;
        if (wVar.g().equals(S.getForum().getId())) {
            S.getForum().setLike(wVar.l());
            if (!StringUtils.isNULL(wVar.h())) {
                S.getForum().setLevelName(wVar.h());
            }
            if (wVar.k() >= 0) {
                S.getForum().setUser_level(wVar.k());
            }
            if (z) {
                this.f59600d.j0(S, false);
                TbadkCoreApplication.getInst().addLikeForum(this.f59598b.i());
                return;
            }
            d.b.j0.d3.e.i().n(this.f59598b.i(), false);
            S.getForum().setLike(0);
            this.f59600d.o0();
            TbadkCoreApplication.getInst().delLikeForum(this.f59598b.i());
            return;
        }
        if (wVar.l() == 1) {
            S.deleteLikeFeedForum(wVar.g());
            this.f59600d.T(S);
            this.f59599c.e(S, this.f59601e.N());
        }
        if (S.getForum().getBannerListData() != null) {
            S.getForum().getBannerListData().setFeedForumLiked(wVar.g(), wVar.l());
        }
        this.f59597a.D0();
    }
}
