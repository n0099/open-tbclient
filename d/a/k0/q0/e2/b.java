package d.a.k0.q0.e2;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.a.k0.d3.w;
/* loaded from: classes4.dex */
public class b extends j {

    /* renamed from: h  reason: collision with root package name */
    public final CustomMessageListener f58320h;

    /* renamed from: i  reason: collision with root package name */
    public final d.a.c.a.e f58321i;
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

    /* renamed from: d.a.k0.q0.e2.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1479b extends d.a.c.a.e {
        public C1479b(b bVar) {
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
            b.this.f58397b.refresh();
        }
    }

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.f58320h = new a(2001266);
        this.f58321i = new C1479b(this);
        this.j = new c();
        frsFragment.registerListener(this.f58320h);
    }

    public final void b(w wVar) {
        if (wVar == null) {
            return;
        }
        FrsViewData g0 = this.f58397b.g0();
        if (this.f58400e == null || this.f58399d == null || this.f58396a == null || g0 == null || g0.getForum() == null || wVar.g() == null) {
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
                this.f58399d.h0(g0, false);
                TbadkCoreApplication.getInst().addLikeForum(this.f58397b.g());
                return;
            }
            d.a.k0.d3.e.i().n(this.f58397b.g(), false);
            g0.getForum().setLike(0);
            this.f58399d.m0();
            TbadkCoreApplication.getInst().delLikeForum(this.f58397b.g());
            return;
        }
        if (wVar.l() == 1) {
            g0.deleteLikeFeedForum(wVar.g());
            this.f58399d.R(g0);
            this.f58398c.d(g0, this.f58400e.N());
        }
        if (g0.getForum().getBannerListData() != null) {
            g0.getForum().getBannerListData().setFeedForumLiked(wVar.g(), wVar.l());
        }
        this.f58396a.D0();
    }
}
