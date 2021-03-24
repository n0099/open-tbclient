package d.b.h0.r.f0.n.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import d.b.b.a.e;
import d.b.b.e.p.j;
import d.b.i0.c3.w;
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f50519e;

    /* renamed from: f  reason: collision with root package name */
    public LikeModel f50520f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.r.f0.n.b f50521g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.h0.r.f0.n.c.b f50522h;
    public View.OnClickListener i;
    public CustomMessageListener j = new C1075a(2001437);
    public CustomMessageListener k = new b(2001438);
    public e l = new c();

    /* renamed from: d.b.h0.r.f0.n.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1075a extends CustomMessageListener {
        public C1075a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.b.i0.c3.q0.e)) {
                return;
            }
            d.b.i0.c3.q0.e eVar = (d.b.i0.c3.q0.e) customResponsedMessage.getData();
            String l = Long.toString(eVar.f53593a);
            if (a.this.f50522h != null && l.equals(a.this.f50522h.h()) && eVar.f53594b) {
                a.this.f50522h.setIsLike(true);
                a.this.f50522h.j(true);
                a.this.f50521g.e(true);
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
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.b.i0.c3.q0.e)) {
                return;
            }
            d.b.i0.c3.q0.e eVar = (d.b.i0.c3.q0.e) customResponsedMessage.getData();
            String l = Long.toString(eVar.f53593a);
            if (a.this.f50522h != null && l.equals(a.this.f50522h.h()) && eVar.f53594b) {
                a.this.f50522h.setIsLike(false);
                a.this.f50522h.j(false);
                a.this.f50521g.e(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends e {
        public c() {
        }

        @Override // d.b.b.a.e
        public void c(Object obj) {
            if ((obj instanceof w) && ((w) obj).d() != 0) {
                if (AntiHelper.m(a.this.f50520f.getErrorCode(), a.this.f50520f.getErrorString())) {
                    AntiHelper.u(a.this.f50519e.getPageActivity(), a.this.f50520f.getErrorString());
                } else {
                    a.this.f50519e.showToast(a.this.f50520f.getErrorString());
                }
            }
        }
    }

    public a(TbPageContext tbPageContext, d.b.h0.r.f0.n.b bVar) {
        this.f50519e = tbPageContext;
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.f50520f = likeModel;
        likeModel.setLoadDataCallBack(this.l);
        this.f50521g = bVar;
        bVar.c(this);
        tbPageContext.registerListener(this.j);
        tbPageContext.registerListener(this.k);
    }

    public void e(View.OnClickListener onClickListener) {
        this.i = onClickListener;
    }

    public void f(d.b.h0.r.f0.n.c.b bVar) {
        if (bVar == null) {
            return;
        }
        this.f50522h = bVar;
        this.f50521g.e(bVar.getIsLike());
    }

    public void g(BdUniqueId bdUniqueId) {
        this.j.setTag(bdUniqueId);
        this.k.setTag(bdUniqueId);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.b.h0.r.f0.n.b bVar = this.f50521g;
        if (bVar != null) {
            bVar.b(view);
        }
        if (!j.z()) {
            this.f50519e.showToast(R.string.neterror);
            return;
        }
        if (ViewHelper.checkUpIsLogin(this.f50519e.getPageActivity())) {
            d.b.h0.r.f0.n.c.b bVar2 = this.f50522h;
            if (bVar2 == null) {
                return;
            }
            this.f50520f.H(bVar2.i(), this.f50522h.h());
        }
        View.OnClickListener onClickListener = this.i;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }
}
