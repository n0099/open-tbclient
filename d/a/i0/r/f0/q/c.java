package d.a.i0.r.f0.q;

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
import d.a.c.e.m.g;
import d.a.i0.r.s.h;
import d.a.i0.r.s.j;
import d.a.i0.r.s.l;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public d.a.i0.r.f0.q.a f48914e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.i0.r.f0.q.b f48915f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f48916g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.i0.s.e.a f48917h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f48918i;
    public boolean k;
    public boolean l;
    public j m;
    public boolean n;
    public d.a.i0.m.d o;
    public d p;
    public String j = "0";
    public CustomMessageListener q = new a(2001115);

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                d.a.i0.r.f0.q.a aVar = c.this.f48914e;
                if (aVar == null || StringUtils.isNull(aVar.getUserId()) || data == null || !c.this.f48914e.getUserId().equals(data.f13332c)) {
                    return;
                }
                boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.f48918i == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.f48918i)) ? false : true;
                BlockPopInfoData blockPopInfoData = data.l;
                if (blockPopInfoData != null) {
                    String str = blockPopInfoData.appeal_msg;
                    if (blockPopInfoData.appeal_status == 1) {
                        if (TextUtils.isEmpty(str)) {
                            str = TbadkCoreApplication.getInst().getString(R.string.anti_account_exception_appealing);
                        }
                    } else if (TextUtils.isEmpty(str)) {
                        str = TbadkCoreApplication.getInst().getString(R.string.anti_no_chance_com_tip);
                    }
                    c.this.f48916g.showToast(str);
                } else if (!data.f13330a) {
                    c.this.n = false;
                    String str2 = updateAttentionMessage.getData() != null ? updateAttentionMessage.getData().f13331b : "";
                    if (TextUtils.isEmpty(str2)) {
                        str2 = TbadkCoreApplication.getInst().getString(R.string.operation_failed);
                    }
                    BdToast.h(TbadkCoreApplication.getInst().getContext(), str2, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).q();
                    if (c.this.f48915f == null) {
                        return;
                    }
                    if (z) {
                        c.this.f48915f.a(c.this.f48914e.getIsLike(), c.this.f48914e.getLikeStatus(), z);
                    } else {
                        c.this.f48915f.e(c.this.f48914e.getIsLike(), c.this.f48914e.getLikeStatus());
                    }
                } else {
                    int fansNum = c.this.f48914e.getFansNum();
                    boolean isLike = c.this.f48914e.getIsLike();
                    if (data.f13333d && !isLike) {
                        fansNum++;
                    } else if (!data.f13333d && isLike) {
                        if (!c.this.l || c.this.n) {
                            fansNum--;
                            if (!c.this.k) {
                                c.this.f48916g.showToast(R.string.un_attention_success);
                            }
                        } else {
                            c.this.n = false;
                            c.this.r();
                            return;
                        }
                    }
                    c.this.f48914e.setLikeStatus(data.m);
                    c.this.f48914e.setIsLike(data.f13333d);
                    c.this.f48914e.setIsFromNetWork(false);
                    c.this.f48914e.setFansNum(fansNum);
                    c.this.n = false;
                    if (c.this.f48915f != null) {
                        c.this.f48915f.d(fansNum);
                        if (z) {
                            if (c.this.p != null) {
                                c.this.p.a(data.f13333d);
                            }
                            c.this.f48915f.a(data.f13333d, data.m, true);
                            return;
                        }
                        c.this.f48915f.e(data.f13333d, data.m);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements l.d {
        public b() {
        }

        @Override // d.a.i0.r.s.l.d
        public void onClick() {
            if (c.this.f48915f instanceof View) {
                c.this.n = true;
                c cVar = c.this;
                cVar.onClick((View) cVar.f48915f);
            }
            g.a(c.this.m, TbadkCoreApplication.getInst().getCurrentActivity());
        }
    }

    /* renamed from: d.a.i0.r.f0.q.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1052c implements l.c {
        public C1052c() {
        }

        @Override // d.a.i0.r.s.l.c
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

    public c(TbPageContext tbPageContext, d.a.i0.r.f0.q.b bVar) {
        this.f48916g = tbPageContext;
        this.f48917h = new d.a.i0.s.e.a(tbPageContext);
        this.f48918i = this.f48916g.getUniqueId();
        tbPageContext.registerListener(this.q);
        q(bVar);
    }

    public d.a.i0.r.f0.q.a j() {
        return this.f48914e;
    }

    public void k(boolean z) {
        this.k = z;
        this.f48917h.j(z);
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return;
        }
        this.f48918i = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(this.q);
        this.q.setTag(this.f48918i);
        MessageManager.getInstance().registerListener(this.q);
    }

    public void m(String str) {
        this.j = str;
    }

    public void n(d.a.i0.r.f0.q.a aVar) {
        this.f48914e = aVar;
        d.a.i0.r.f0.q.b bVar = this.f48915f;
        if (bVar == null || aVar == null) {
            return;
        }
        bVar.e(aVar.getIsLike(), aVar.getLikeStatus());
        this.f48915f.d(aVar.getFansNum());
    }

    public void o(d dVar) {
        this.p = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.a.i0.r.f0.q.a aVar;
        d.a.i0.m.d dVar = this.o;
        if (dVar == null || !dVar.b(view)) {
            if (!d.a.c.e.p.j.A()) {
                this.f48916g.showToast(R.string.neterror);
                return;
            }
            d.a.i0.r.f0.q.b bVar = this.f48915f;
            if (bVar != null) {
                bVar.b(view);
            }
            if (!ViewHelper.checkUpIsLogin(this.f48916g.getPageActivity()) || (aVar = this.f48914e) == null) {
                return;
            }
            boolean z = !aVar.getIsLike();
            if (this.f48918i == null) {
                this.f48917h.m(z, this.f48914e.getPortrait(), this.f48914e.getUserId(), this.f48914e.isGod(), this.j, this.f48916g.getUniqueId(), null, "0");
            } else {
                this.f48917h.m(z, this.f48914e.getPortrait(), this.f48914e.getUserId(), this.f48914e.isGod(), this.j, this.f48918i, null, "0");
            }
        }
    }

    public void p(boolean z) {
        this.l = z;
    }

    public void q(d.a.i0.r.f0.q.b bVar) {
        this.f48915f = bVar;
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
            lVar.m(new C1052c());
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
