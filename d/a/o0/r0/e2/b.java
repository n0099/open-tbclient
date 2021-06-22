package d.a.o0.r0.e2;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.a.o0.e3.w;
/* loaded from: classes4.dex */
public class b extends j {

    /* renamed from: h  reason: collision with root package name */
    public final CustomMessageListener f62277h;

    /* renamed from: i  reason: collision with root package name */
    public final d.a.c.a.e f62278i;
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

    /* renamed from: d.a.o0.r0.e2.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1552b extends d.a.c.a.e {
        public C1552b(b bVar) {
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
            b.this.f62354b.refresh();
        }
    }

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.f62277h = new a(2001266);
        this.f62278i = new C1552b(this);
        this.j = new c();
        frsFragment.registerListener(this.f62277h);
    }

    public final void b(w wVar) {
        if (wVar == null) {
            return;
        }
        FrsViewData j0 = this.f62354b.j0();
        if (this.f62357e == null || this.f62356d == null || this.f62353a == null || j0 == null || j0.getForum() == null || wVar.g() == null) {
            return;
        }
        boolean z = wVar.l() == 1;
        if (wVar.g().equals(j0.getForum().getId())) {
            j0.getForum().setLike(wVar.l());
            if (!StringUtils.isNULL(wVar.h())) {
                j0.getForum().setLevelName(wVar.h());
            }
            if (wVar.k() >= 0) {
                j0.getForum().setUser_level(wVar.k());
            }
            if (z) {
                this.f62356d.h0(j0, false);
                TbadkCoreApplication.getInst().addLikeForum(this.f62354b.h());
                return;
            }
            d.a.o0.e3.e.i().n(this.f62354b.h(), false);
            j0.getForum().setLike(0);
            this.f62356d.k0();
            TbadkCoreApplication.getInst().delLikeForum(this.f62354b.h());
            return;
        }
        if (wVar.l() == 1) {
            j0.deleteLikeFeedForum(wVar.g());
            this.f62356d.R(j0);
            this.f62355c.d(j0, this.f62357e.R());
        }
        if (j0.getForum().getBannerListData() != null) {
            j0.getForum().getBannerListData().setFeedForumLiked(wVar.g(), wVar.l());
        }
        this.f62353a.D0();
    }
}
