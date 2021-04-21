package d.b.i0.r.f0.n.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import d.b.c.a.e;
import d.b.c.e.p.j;
import d.b.j0.d3.w;
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f51263e;

    /* renamed from: f  reason: collision with root package name */
    public LikeModel f51264f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.r.f0.n.b f51265g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.r.f0.n.c.b f51266h;
    public View.OnClickListener i;
    public CustomMessageListener j = new C1111a(2001437);
    public CustomMessageListener k = new b(2001438);
    public e l = new c();

    /* renamed from: d.b.i0.r.f0.n.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1111a extends CustomMessageListener {
        public C1111a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.b.j0.d3.q0.e)) {
                return;
            }
            d.b.j0.d3.q0.e eVar = (d.b.j0.d3.q0.e) customResponsedMessage.getData();
            String l = Long.toString(eVar.f55459a);
            if (a.this.f51266h != null && l.equals(a.this.f51266h.h()) && eVar.f55460b) {
                a.this.f51266h.setIsLike(true);
                a.this.f51266h.j(true);
                a.this.f51265g.e(true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.b.j0.d3.q0.e)) {
                return;
            }
            d.b.j0.d3.q0.e eVar = (d.b.j0.d3.q0.e) customResponsedMessage.getData();
            String l = Long.toString(eVar.f55459a);
            if (a.this.f51266h != null && l.equals(a.this.f51266h.h()) && eVar.f55460b) {
                a.this.f51266h.setIsLike(false);
                a.this.f51266h.j(false);
                a.this.f51265g.e(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends e {
        public c() {
        }

        @Override // d.b.c.a.e
        public void c(Object obj) {
            if ((obj instanceof w) && ((w) obj).d() != 0) {
                if (AntiHelper.m(a.this.f51264f.getErrorCode(), a.this.f51264f.getErrorString())) {
                    AntiHelper.u(a.this.f51263e.getPageActivity(), a.this.f51264f.getErrorString());
                } else {
                    a.this.f51263e.showToast(a.this.f51264f.getErrorString());
                }
            }
        }
    }

    public a(TbPageContext tbPageContext, d.b.i0.r.f0.n.b bVar) {
        this.f51263e = tbPageContext;
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.f51264f = likeModel;
        likeModel.setLoadDataCallBack(this.l);
        this.f51265g = bVar;
        bVar.c(this);
        tbPageContext.registerListener(this.j);
        tbPageContext.registerListener(this.k);
    }

    public void e(View.OnClickListener onClickListener) {
        this.i = onClickListener;
    }

    public void f(d.b.i0.r.f0.n.c.b bVar) {
        if (bVar == null) {
            return;
        }
        this.f51266h = bVar;
        this.f51265g.e(bVar.getIsLike());
    }

    public void g(BdUniqueId bdUniqueId) {
        this.j.setTag(bdUniqueId);
        this.k.setTag(bdUniqueId);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.b.i0.r.f0.n.b bVar = this.f51265g;
        if (bVar != null) {
            bVar.b(view);
        }
        if (!j.z()) {
            this.f51263e.showToast(R.string.neterror);
            return;
        }
        if (ViewHelper.checkUpIsLogin(this.f51263e.getPageActivity())) {
            d.b.i0.r.f0.n.c.b bVar2 = this.f51266h;
            if (bVar2 == null) {
                return;
            }
            this.f51264f.H(bVar2.i(), this.f51266h.h());
        }
        View.OnClickListener onClickListener = this.i;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }
}
