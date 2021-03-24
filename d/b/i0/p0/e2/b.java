package d.b.i0.p0.e2;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.b.i0.c3.w;
/* loaded from: classes4.dex */
public class b extends j {

    /* renamed from: h  reason: collision with root package name */
    public final CustomMessageListener f57412h;
    public final d.b.b.a.e i;
    public final d.b.b.a.e j;

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

    /* renamed from: d.b.i0.p0.e2.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1380b extends d.b.b.a.e {
        public C1380b(b bVar) {
        }

        @Override // d.b.b.a.e
        public void c(Object obj) {
            if (obj instanceof Boolean) {
                ((Boolean) obj).booleanValue();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends d.b.b.a.e {
        public c() {
        }

        @Override // d.b.b.a.e
        public void c(Object obj) {
            if (obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false) {
                return;
            }
            b.this.f57477b.refresh();
        }
    }

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.f57412h = new a(2001266);
        this.i = new C1380b(this);
        this.j = new c();
        frsFragment.registerListener(this.f57412h);
    }

    public final void b(w wVar) {
        if (wVar == null) {
            return;
        }
        FrsViewData S = this.f57477b.S();
        if (this.f57480e == null || this.f57479d == null || this.f57476a == null || S == null || S.getForum() == null || wVar.g() == null) {
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
                this.f57479d.j0(S, false);
                TbadkCoreApplication.getInst().addLikeForum(this.f57477b.i());
                return;
            }
            d.b.i0.c3.e.i().n(this.f57477b.i(), false);
            S.getForum().setLike(0);
            this.f57479d.o0();
            TbadkCoreApplication.getInst().delLikeForum(this.f57477b.i());
            return;
        }
        if (wVar.l() == 1) {
            S.deleteLikeFeedForum(wVar.g());
            this.f57479d.T(S);
            this.f57478c.e(S, this.f57480e.N());
        }
        if (S.getForum().getBannerListData() != null) {
            S.getForum().getBannerListData().setFeedForumLiked(wVar.g(), wVar.l());
        }
        this.f57476a.D0();
    }
}
