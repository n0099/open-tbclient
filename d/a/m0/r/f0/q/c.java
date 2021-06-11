package d.a.m0.r.f0.q;

import android.content.DialogInterface;
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
import d.a.m0.r.s.h;
import d.a.m0.r.s.j;
import d.a.m0.r.s.l;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public d.a.m0.r.f0.q.a f53462e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.m0.r.f0.q.b f53463f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f53464g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.m0.s.e.a f53465h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f53466i;
    public boolean k;
    public boolean l;
    public j m;
    public boolean n;
    public d.a.m0.m.d o;
    public f p;
    public String j = "0";
    public CustomMessageListener q = new a(2921560);
    public CustomMessageListener r = new b(2001115);

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(c.this.f53462e.getUserId()) && c.this.f53462e.getUserId().equals(str)) {
                    c.this.n = true;
                }
                g.a(c.this.m, TbadkCoreApplication.getInst().getCurrentActivity());
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
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                d.a.m0.r.f0.q.a aVar = c.this.f53462e;
                if (aVar == null || StringUtils.isNull(aVar.getUserId()) || data == null || !c.this.f53462e.getUserId().equals(data.f12638c)) {
                    return;
                }
                boolean z = (updateAttentionMessage.getOrginalMessage() == null || c.this.f53466i == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(c.this.f53466i)) ? false : true;
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
                    c.this.f53464g.showToast(str);
                } else if (!data.f12636a) {
                    c.this.n = false;
                    String str2 = updateAttentionMessage.getData() != null ? updateAttentionMessage.getData().f12637b : "";
                    if (TextUtils.isEmpty(str2)) {
                        str2 = TbadkCoreApplication.getInst().getString(R.string.operation_failed);
                    }
                    BdToast.h(TbadkCoreApplication.getInst().getContext(), str2, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).q();
                    if (c.this.f53463f == null) {
                        return;
                    }
                    if (z) {
                        c.this.f53463f.c(c.this.f53462e.getIsLike(), c.this.f53462e.getLikeStatus(), z);
                    } else {
                        c.this.f53463f.e(c.this.f53462e.getIsLike(), c.this.f53462e.getLikeStatus());
                    }
                } else {
                    int fansNum = c.this.f53462e.getFansNum();
                    boolean isLike = c.this.f53462e.getIsLike();
                    if (data.f12639d && !isLike) {
                        fansNum++;
                    } else if (!data.f12639d && isLike) {
                        if (!c.this.l || c.this.n) {
                            fansNum--;
                            if (!c.this.k) {
                                c.this.f53464g.showToast(R.string.un_attention_success);
                            }
                        } else {
                            c.this.n = false;
                            c.this.r();
                            return;
                        }
                    }
                    c.this.f53462e.setLikeStatus(data.m);
                    c.this.f53462e.setIsLike(data.f12639d);
                    c.this.f53462e.setIsFromNetWork(false);
                    c.this.f53462e.setFansNum(fansNum);
                    c.this.n = false;
                    if (c.this.f53463f != null) {
                        c.this.f53463f.d(fansNum);
                        if (z) {
                            if (c.this.p != null) {
                                c.this.p.a(data.f12639d);
                            }
                            c.this.f53463f.c(data.f12639d, data.m, true);
                            return;
                        }
                        c.this.f53463f.e(data.f12639d, data.m);
                    }
                }
            }
        }
    }

    /* renamed from: d.a.m0.r.f0.q.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1193c implements l.d {
        public C1193c() {
        }

        @Override // d.a.m0.r.s.l.d
        public void onClick() {
            if (c.this.f53463f instanceof View) {
                c.this.n = true;
                MessageManager messageManager = MessageManager.getInstance();
                d.a.m0.r.f0.q.a aVar = c.this.f53462e;
                messageManager.dispatchResponsedMessage(new CustomResponsedMessage(2921560, aVar != null ? aVar.getUserId() : "0"));
                c cVar = c.this;
                cVar.onClick((View) cVar.f53463f);
            }
            g.a(c.this.m, TbadkCoreApplication.getInst().getCurrentActivity());
        }
    }

    /* loaded from: classes3.dex */
    public class d implements l.c {
        public d() {
        }

        @Override // d.a.m0.r.s.l.c
        public void onClick() {
            if (c.this.m == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921560, "0"));
        }
    }

    /* loaded from: classes3.dex */
    public class e implements DialogInterface.OnCancelListener {
        public e(c cVar) {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921560, "0"));
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a(boolean z);
    }

    public c(TbPageContext tbPageContext, d.a.m0.r.f0.q.b bVar) {
        this.f53464g = tbPageContext;
        this.f53465h = new d.a.m0.s.e.a(tbPageContext);
        this.f53466i = this.f53464g.getUniqueId();
        tbPageContext.registerListener(this.r);
        tbPageContext.registerListener(this.q);
        q(bVar);
    }

    public d.a.m0.r.f0.q.a j() {
        return this.f53462e;
    }

    public void k(boolean z) {
        this.k = z;
        this.f53465h.j(z);
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return;
        }
        this.f53466i = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(this.r);
        MessageManager.getInstance().unRegisterListener(this.q);
        this.r.setTag(this.f53466i);
        this.q.setTag(this.f53466i);
        MessageManager.getInstance().registerListener(this.r);
        MessageManager.getInstance().registerListener(this.q);
    }

    public void m(String str) {
        this.j = str;
    }

    public void n(d.a.m0.r.f0.q.a aVar) {
        this.f53462e = aVar;
        d.a.m0.r.f0.q.b bVar = this.f53463f;
        if (bVar == null || aVar == null) {
            return;
        }
        bVar.e(aVar.getIsLike(), aVar.getLikeStatus());
        this.f53463f.d(aVar.getFansNum());
    }

    public void o(f fVar) {
        this.p = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.a.m0.r.f0.q.a aVar;
        d.a.m0.m.d dVar = this.o;
        if (dVar == null || !dVar.a(view)) {
            if (!d.a.c.e.p.j.A()) {
                this.f53464g.showToast(R.string.neterror);
                return;
            }
            d.a.m0.r.f0.q.b bVar = this.f53463f;
            if (bVar != null) {
                bVar.a(view);
            }
            if (!ViewHelper.checkUpIsLogin(this.f53464g.getPageActivity()) || (aVar = this.f53462e) == null) {
                return;
            }
            boolean z = !aVar.getIsLike();
            if (this.f53466i == null) {
                this.f53465h.m(z, this.f53462e.getPortrait(), this.f53462e.getUserId(), this.f53462e.isGod(), this.j, this.f53464g.getUniqueId(), null, "0");
            } else {
                this.f53465h.m(z, this.f53462e.getPortrait(), this.f53462e.getUserId(), this.f53462e.isGod(), this.j, this.f53466i, null, "0");
            }
        }
    }

    public void p(boolean z) {
        this.l = z;
    }

    public void q(d.a.m0.r.f0.q.b bVar) {
        this.f53463f = bVar;
        if (bVar != null) {
            bVar.b(this);
        }
    }

    public void r() {
        if (this.m == null) {
            l lVar = new l(TbadkCoreApplication.getInst().getCurrentActivity());
            lVar.q(TbadkCoreApplication.getInst().getString(R.string.confirm_unlike));
            ArrayList arrayList = new ArrayList();
            h hVar = new h(TbadkCoreApplication.getInst().getString(R.string.confirm), lVar);
            hVar.m(new C1193c());
            arrayList.add(hVar);
            lVar.m(new d());
            lVar.k(arrayList);
            j jVar = new j(UtilHelper.getTbPageContext(TbadkCoreApplication.getInst().getCurrentActivity()), lVar);
            this.m = jVar;
            jVar.k(0.7f);
        }
        this.m.setOnCancelListener(new e(this));
        g.i(this.m, TbadkCoreApplication.getInst().getCurrentActivity());
    }

    public void s(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.r);
        MessageManager.getInstance().unRegisterListener(this.q);
    }
}
