package d.a.i0.r.f0.n.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import d.a.c.a.e;
import d.a.c.e.p.j;
import d.a.j0.d3.w;
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f48873e;

    /* renamed from: f  reason: collision with root package name */
    public LikeModel f48874f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.i0.r.f0.n.b f48875g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.i0.r.f0.n.c.b f48876h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f48877i;
    public CustomMessageListener j = new C1050a(2001437);
    public CustomMessageListener k = new b(2001438);
    public e l = new c();

    /* renamed from: d.a.i0.r.f0.n.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1050a extends CustomMessageListener {
        public C1050a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.j0.d3.q0.e)) {
                return;
            }
            d.a.j0.d3.q0.e eVar = (d.a.j0.d3.q0.e) customResponsedMessage.getData();
            String l = Long.toString(eVar.f53303a);
            if (a.this.f48876h != null && l.equals(a.this.f48876h.h()) && eVar.f53304b) {
                a.this.f48876h.setIsLike(true);
                a.this.f48876h.i(true);
                a.this.f48875g.e(true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.j0.d3.q0.e)) {
                return;
            }
            d.a.j0.d3.q0.e eVar = (d.a.j0.d3.q0.e) customResponsedMessage.getData();
            String l = Long.toString(eVar.f53303a);
            if (a.this.f48876h != null && l.equals(a.this.f48876h.h()) && eVar.f53304b) {
                a.this.f48876h.setIsLike(false);
                a.this.f48876h.i(false);
                a.this.f48875g.e(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends e {
        public c() {
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            if ((obj instanceof w) && ((w) obj).d() != 0) {
                if (AntiHelper.m(a.this.f48874f.getErrorCode(), a.this.f48874f.getErrorString())) {
                    AntiHelper.u(a.this.f48873e.getPageActivity(), a.this.f48874f.getErrorString());
                } else {
                    a.this.f48873e.showToast(a.this.f48874f.getErrorString());
                }
            }
        }
    }

    public a(TbPageContext tbPageContext, d.a.i0.r.f0.n.b bVar) {
        this.f48873e = tbPageContext;
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.f48874f = likeModel;
        likeModel.setLoadDataCallBack(this.l);
        this.f48875g = bVar;
        bVar.c(this);
        tbPageContext.registerListener(this.j);
        tbPageContext.registerListener(this.k);
    }

    public void e(View.OnClickListener onClickListener) {
        this.f48877i = onClickListener;
    }

    public void f(d.a.i0.r.f0.n.c.b bVar) {
        if (bVar == null) {
            return;
        }
        this.f48876h = bVar;
        this.f48875g.e(bVar.getIsLike());
    }

    public void g(BdUniqueId bdUniqueId) {
        this.j.setTag(bdUniqueId);
        this.k.setTag(bdUniqueId);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.a.i0.r.f0.n.b bVar = this.f48875g;
        if (bVar != null) {
            bVar.b(view);
        }
        if (!j.z()) {
            this.f48873e.showToast(R.string.neterror);
            return;
        }
        if (ViewHelper.checkUpIsLogin(this.f48873e.getPageActivity())) {
            d.a.i0.r.f0.n.c.b bVar2 = this.f48876h;
            if (bVar2 == null) {
                return;
            }
            this.f48874f.H(bVar2.g(), this.f48876h.h());
        }
        View.OnClickListener onClickListener = this.f48877i;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }
}
