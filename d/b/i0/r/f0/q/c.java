package d.b.i0.r.f0.q;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import d.b.c.e.m.g;
import d.b.i0.r.s.h;
import d.b.i0.r.s.j;
import d.b.i0.r.s.l;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.r.f0.q.a f51300e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.r.f0.q.b f51301f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f51302g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.s.e.a f51303h;
    public BdUniqueId i;
    public boolean k;
    public boolean l;
    public j m;
    public boolean n;
    public d.b.i0.m.d o;
    public d p;
    public String j = "0";
    public CustomMessageListener q = new a(2001115);

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                d.b.i0.r.f0.q.a aVar = c.this.f51300e;
                if (aVar == null || StringUtils.isNull(aVar.getUserId()) || data == null || !c.this.f51300e.getUserId().equals(data.f13364c)) {
                    return;
                }
                boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.i == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.i)) ? false : true;
                BlockPopInfoData blockPopInfoData = data.k;
                if (blockPopInfoData != null) {
                    String str = blockPopInfoData.appeal_msg;
                    if (blockPopInfoData.appeal_status == 1) {
                        if (TextUtils.isEmpty(str)) {
                            str = TbadkCoreApplication.getInst().getString(R.string.anti_account_exception_appealing);
                        }
                    } else if (TextUtils.isEmpty(str)) {
                        str = TbadkCoreApplication.getInst().getString(R.string.anti_no_chance_com_tip);
                    }
                    c.this.f51302g.showToast(str);
                } else if (!data.f13362a) {
                    c.this.n = false;
                    String str2 = updateAttentionMessage.getData() != null ? updateAttentionMessage.getData().f13363b : "";
                    if (TextUtils.isEmpty(str2)) {
                        str2 = TbadkCoreApplication.getInst().getString(R.string.operation_failed);
                    }
                    BdToast.h(TbadkCoreApplication.getInst().getContext(), str2, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).q();
                    if (c.this.f51301f == null) {
                        return;
                    }
                    if (z) {
                        c.this.f51301f.d(c.this.f51300e.getIsLike(), c.this.f51300e.getLikeStatus(), z);
                    } else {
                        c.this.f51301f.a(c.this.f51300e.getIsLike(), c.this.f51300e.getLikeStatus());
                    }
                } else {
                    int fansNum = c.this.f51300e.getFansNum();
                    boolean isLike = c.this.f51300e.getIsLike();
                    if (data.f13365d && !isLike) {
                        fansNum++;
                    } else if (!data.f13365d && isLike) {
                        if (!c.this.l || c.this.n) {
                            fansNum--;
                            if (!c.this.k) {
                                c.this.f51302g.showToast(R.string.un_attention_success);
                            }
                        } else {
                            c.this.n = false;
                            c.this.r();
                            return;
                        }
                    }
                    c.this.f51300e.setLikeStatus(data.l);
                    c.this.f51300e.setIsLike(data.f13365d);
                    c.this.f51300e.setIsFromNetWork(false);
                    c.this.f51300e.setFansNum(fansNum);
                    c.this.n = false;
                    if (c.this.f51301f != null) {
                        c.this.f51301f.e(fansNum);
                        if (z) {
                            if (c.this.p != null) {
                                c.this.p.a(data.f13365d);
                            }
                            c.this.f51301f.d(data.f13365d, data.l, true);
                            return;
                        }
                        c.this.f51301f.a(data.f13365d, data.l);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements l.d {
        public b() {
        }

        @Override // d.b.i0.r.s.l.d
        public void onClick() {
            if (c.this.f51301f instanceof View) {
                c.this.n = true;
                c cVar = c.this;
                cVar.onClick((View) cVar.f51301f);
            }
            g.a(c.this.m, TbadkCoreApplication.getInst().getCurrentActivity());
        }
    }

    /* renamed from: d.b.i0.r.f0.q.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1113c implements l.c {
        public C1113c() {
        }

        @Override // d.b.i0.r.s.l.c
        public void onClick() {
            if (c.this.m == null) {
                return;
            }
            g.a(c.this.m, TbadkCoreApplication.getInst().getCurrentActivity());
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(boolean z);
    }

    public c(TbPageContext tbPageContext, d.b.i0.r.f0.q.b bVar) {
        this.f51302g = tbPageContext;
        this.f51303h = new d.b.i0.s.e.a(tbPageContext);
        this.i = this.f51302g.getUniqueId();
        tbPageContext.registerListener(this.q);
        q(bVar);
    }

    public d.b.i0.r.f0.q.a j() {
        return this.f51300e;
    }

    public void k(boolean z) {
        this.k = z;
        this.f51303h.j(z);
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return;
        }
        this.i = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(this.q);
        this.q.setTag(this.i);
        MessageManager.getInstance().registerListener(this.q);
    }

    public void m(String str) {
        this.j = str;
    }

    public void n(d.b.i0.r.f0.q.a aVar) {
        this.f51300e = aVar;
        d.b.i0.r.f0.q.b bVar = this.f51301f;
        if (bVar == null || aVar == null) {
            return;
        }
        bVar.a(aVar.getIsLike(), aVar.getLikeStatus());
        this.f51301f.e(aVar.getFansNum());
    }

    public void o(d dVar) {
        this.p = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.b.i0.r.f0.q.a aVar;
        d.b.i0.m.d dVar = this.o;
        if (dVar == null || !dVar.b(view)) {
            if (!d.b.c.e.p.j.A()) {
                this.f51302g.showToast(R.string.neterror);
                return;
            }
            d.b.i0.r.f0.q.b bVar = this.f51301f;
            if (bVar != null) {
                bVar.b(view);
            }
            if (!ViewHelper.checkUpIsLogin(this.f51302g.getPageActivity()) || (aVar = this.f51300e) == null) {
                return;
            }
            boolean z = !aVar.getIsLike();
            if (this.i == null) {
                this.f51303h.m(z, this.f51300e.getPortrait(), this.f51300e.getUserId(), this.f51300e.isGod(), this.j, this.f51302g.getUniqueId(), null, "0");
            } else {
                this.f51303h.m(z, this.f51300e.getPortrait(), this.f51300e.getUserId(), this.f51300e.isGod(), this.j, this.i, null, "0");
            }
        }
    }

    public void p(boolean z) {
        this.l = z;
    }

    public void q(d.b.i0.r.f0.q.b bVar) {
        this.f51301f = bVar;
        if (bVar != null) {
            bVar.c(this);
        }
    }

    public void r() {
        if (this.m == null) {
            l lVar = new l(TbadkCoreApplication.getInst().getCurrentActivity());
            lVar.q(TbadkCoreApplication.getInst().getString(R.string.confirm_unlike));
            ArrayList arrayList = new ArrayList();
            h hVar = new h(TbadkCoreApplication.getInst().getString(R.string.confirm), lVar);
            hVar.m(new b());
            arrayList.add(hVar);
            lVar.m(new C1113c());
            lVar.k(arrayList);
            j jVar = new j(UtilHelper.getTbPageContext(TbadkCoreApplication.getInst().getCurrentActivity()), lVar);
            this.m = jVar;
            jVar.k(0.7f);
        }
        g.i(this.m, TbadkCoreApplication.getInst().getCurrentActivity());
    }

    public void s(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.q);
    }
}
