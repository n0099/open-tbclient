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
    public TbPageContext f53421e;

    /* renamed from: f  reason: collision with root package name */
    public LikeModel f53422f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.m0.r.f0.n.b f53423g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.m0.r.f0.n.c.b f53424h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f53425i;
    public CustomMessageListener j = new C1191a(2001437);
    public CustomMessageListener k = new b(2001438);
    public e l = new c();

    /* renamed from: d.a.m0.r.f0.n.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1191a extends CustomMessageListener {
        public C1191a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.n0.e3.q0.e)) {
                return;
            }
            d.a.n0.e3.q0.e eVar = (d.a.n0.e3.q0.e) customResponsedMessage.getData();
            String l = Long.toString(eVar.f57912a);
            if (a.this.f53424h != null && l.equals(a.this.f53424h.i()) && eVar.f57913b) {
                a.this.f53424h.setIsLike(true);
                a.this.f53424h.j(true);
                a.this.f53423g.c(true);
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
            String l = Long.toString(eVar.f57912a);
            if (a.this.f53424h != null && l.equals(a.this.f53424h.i()) && eVar.f57913b) {
                a.this.f53424h.setIsLike(false);
                a.this.f53424h.j(false);
                a.this.f53423g.c(false);
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
                if (AntiHelper.m(a.this.f53422f.getErrorCode(), a.this.f53422f.getErrorString())) {
                    AntiHelper.u(a.this.f53421e.getPageActivity(), a.this.f53422f.getErrorString());
                } else {
                    a.this.f53421e.showToast(a.this.f53422f.getErrorString());
                }
            }
        }
    }

    public a(TbPageContext tbPageContext, d.a.m0.r.f0.n.b bVar) {
        this.f53421e = tbPageContext;
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.f53422f = likeModel;
        likeModel.setLoadDataCallBack(this.l);
        this.f53423g = bVar;
        bVar.b(this);
        tbPageContext.registerListener(this.j);
        tbPageContext.registerListener(this.k);
    }

    public void e(View.OnClickListener onClickListener) {
        this.f53425i = onClickListener;
    }

    public void f(d.a.m0.r.f0.n.c.b bVar) {
        if (bVar == null) {
            return;
        }
        this.f53424h = bVar;
        this.f53423g.c(bVar.getIsLike());
    }

    public void g(BdUniqueId bdUniqueId) {
        this.j.setTag(bdUniqueId);
        this.k.setTag(bdUniqueId);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.a.m0.r.f0.n.b bVar = this.f53423g;
        if (bVar != null) {
            bVar.a(view);
        }
        if (!j.z()) {
            this.f53421e.showToast(R.string.neterror);
            return;
        }
        if (ViewHelper.checkUpIsLogin(this.f53421e.getPageActivity())) {
            d.a.m0.r.f0.n.c.b bVar2 = this.f53424h;
            if (bVar2 == null) {
                return;
            }
            this.f53422f.L(bVar2.h(), this.f53424h.i());
        }
        View.OnClickListener onClickListener = this.f53425i;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }
}
