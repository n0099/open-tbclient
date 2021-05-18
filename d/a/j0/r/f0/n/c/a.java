package d.a.j0.r.f0.n.c;

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
import d.a.k0.d3.w;
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f49702e;

    /* renamed from: f  reason: collision with root package name */
    public LikeModel f49703f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.r.f0.n.b f49704g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.j0.r.f0.n.c.b f49705h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f49706i;
    public CustomMessageListener j = new C1126a(2001437);
    public CustomMessageListener k = new b(2001438);
    public e l = new c();

    /* renamed from: d.a.j0.r.f0.n.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1126a extends CustomMessageListener {
        public C1126a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.k0.d3.q0.e)) {
                return;
            }
            d.a.k0.d3.q0.e eVar = (d.a.k0.d3.q0.e) customResponsedMessage.getData();
            String l = Long.toString(eVar.f54010a);
            if (a.this.f49705h != null && l.equals(a.this.f49705h.h()) && eVar.f54011b) {
                a.this.f49705h.setIsLike(true);
                a.this.f49705h.i(true);
                a.this.f49704g.e(true);
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
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.k0.d3.q0.e)) {
                return;
            }
            d.a.k0.d3.q0.e eVar = (d.a.k0.d3.q0.e) customResponsedMessage.getData();
            String l = Long.toString(eVar.f54010a);
            if (a.this.f49705h != null && l.equals(a.this.f49705h.h()) && eVar.f54011b) {
                a.this.f49705h.setIsLike(false);
                a.this.f49705h.i(false);
                a.this.f49704g.e(false);
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
                if (AntiHelper.m(a.this.f49703f.getErrorCode(), a.this.f49703f.getErrorString())) {
                    AntiHelper.u(a.this.f49702e.getPageActivity(), a.this.f49703f.getErrorString());
                } else {
                    a.this.f49702e.showToast(a.this.f49703f.getErrorString());
                }
            }
        }
    }

    public a(TbPageContext tbPageContext, d.a.j0.r.f0.n.b bVar) {
        this.f49702e = tbPageContext;
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.f49703f = likeModel;
        likeModel.setLoadDataCallBack(this.l);
        this.f49704g = bVar;
        bVar.c(this);
        tbPageContext.registerListener(this.j);
        tbPageContext.registerListener(this.k);
    }

    public void e(View.OnClickListener onClickListener) {
        this.f49706i = onClickListener;
    }

    public void f(d.a.j0.r.f0.n.c.b bVar) {
        if (bVar == null) {
            return;
        }
        this.f49705h = bVar;
        this.f49704g.e(bVar.getIsLike());
    }

    public void g(BdUniqueId bdUniqueId) {
        this.j.setTag(bdUniqueId);
        this.k.setTag(bdUniqueId);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.a.j0.r.f0.n.b bVar = this.f49704g;
        if (bVar != null) {
            bVar.b(view);
        }
        if (!j.z()) {
            this.f49702e.showToast(R.string.neterror);
            return;
        }
        if (ViewHelper.checkUpIsLogin(this.f49702e.getPageActivity())) {
            d.a.j0.r.f0.n.c.b bVar2 = this.f49705h;
            if (bVar2 == null) {
                return;
            }
            this.f49703f.H(bVar2.g(), this.f49705h.h());
        }
        View.OnClickListener onClickListener = this.f49706i;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }
}
