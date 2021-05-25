package d.a.m0.r.f0.n.c;

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
import d.a.n0.e3.w;
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f49746e;

    /* renamed from: f  reason: collision with root package name */
    public LikeModel f49747f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.m0.r.f0.n.b f49748g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.m0.r.f0.n.c.b f49749h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f49750i;
    public CustomMessageListener j = new C1135a(2001437);
    public CustomMessageListener k = new b(2001438);
    public e l = new c();

    /* renamed from: d.a.m0.r.f0.n.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1135a extends CustomMessageListener {
        public C1135a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.n0.e3.q0.e)) {
                return;
            }
            d.a.n0.e3.q0.e eVar = (d.a.n0.e3.q0.e) customResponsedMessage.getData();
            String l = Long.toString(eVar.f54223a);
            if (a.this.f49749h != null && l.equals(a.this.f49749h.h()) && eVar.f54224b) {
                a.this.f49749h.setIsLike(true);
                a.this.f49749h.i(true);
                a.this.f49748g.c(true);
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
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.n0.e3.q0.e)) {
                return;
            }
            d.a.n0.e3.q0.e eVar = (d.a.n0.e3.q0.e) customResponsedMessage.getData();
            String l = Long.toString(eVar.f54223a);
            if (a.this.f49749h != null && l.equals(a.this.f49749h.h()) && eVar.f54224b) {
                a.this.f49749h.setIsLike(false);
                a.this.f49749h.i(false);
                a.this.f49748g.c(false);
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
                if (AntiHelper.m(a.this.f49747f.getErrorCode(), a.this.f49747f.getErrorString())) {
                    AntiHelper.u(a.this.f49746e.getPageActivity(), a.this.f49747f.getErrorString());
                } else {
                    a.this.f49746e.showToast(a.this.f49747f.getErrorString());
                }
            }
        }
    }

    public a(TbPageContext tbPageContext, d.a.m0.r.f0.n.b bVar) {
        this.f49746e = tbPageContext;
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.f49747f = likeModel;
        likeModel.setLoadDataCallBack(this.l);
        this.f49748g = bVar;
        bVar.b(this);
        tbPageContext.registerListener(this.j);
        tbPageContext.registerListener(this.k);
    }

    public void e(View.OnClickListener onClickListener) {
        this.f49750i = onClickListener;
    }

    public void f(d.a.m0.r.f0.n.c.b bVar) {
        if (bVar == null) {
            return;
        }
        this.f49749h = bVar;
        this.f49748g.c(bVar.getIsLike());
    }

    public void g(BdUniqueId bdUniqueId) {
        this.j.setTag(bdUniqueId);
        this.k.setTag(bdUniqueId);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.a.m0.r.f0.n.b bVar = this.f49748g;
        if (bVar != null) {
            bVar.a(view);
        }
        if (!j.z()) {
            this.f49746e.showToast(R.string.neterror);
            return;
        }
        if (ViewHelper.checkUpIsLogin(this.f49746e.getPageActivity())) {
            d.a.m0.r.f0.n.c.b bVar2 = this.f49749h;
            if (bVar2 == null) {
                return;
            }
            this.f49747f.H(bVar2.g(), this.f49749h.h());
        }
        View.OnClickListener onClickListener = this.f49750i;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }
}
