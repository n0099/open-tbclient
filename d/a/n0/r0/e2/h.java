package d.a.n0.r0.e2;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.z1;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class h extends j {

    /* renamed from: h  reason: collision with root package name */
    public a2 f58533h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f58534i;
    public String j;
    public PraiseModel k;
    public final CustomMessageListener l;

    /* loaded from: classes4.dex */
    public class a implements PraiseModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void a(String str) {
            if (h.this.f58534i) {
                int i2 = 1;
                if (h.this.f58533h != null && h.this.f58533h.Q0().getIsLike() == 1) {
                    i2 = 0;
                }
                h.this.h(i2);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void b(int i2, String str) {
            FrsFragment frsFragment = h.this.f58538b;
            if (frsFragment == null || frsFragment.getPageContext() == null || !h.this.f58534i || TextUtils.isEmpty(str)) {
                return;
            }
            if (AntiHelper.m(i2, str)) {
                AntiHelper.u(h.this.f58538b.getPageContext().getPageActivity(), str);
            } else {
                h.this.f58538b.showToast(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof a2)) {
                return;
            }
            a2 a2Var = (a2) customResponsedMessage.getData();
            h.this.j = a2Var.o0();
            if (TextUtils.isEmpty(h.this.j) || a2Var.Q0() == null) {
                return;
            }
            h.this.h(a2Var.Q0().getIsLike());
        }
    }

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        b bVar = new b(2004004);
        this.l = bVar;
        this.f58538b.registerListener(bVar);
        this.k = e();
    }

    public final PraiseModel e() {
        if (this.k == null) {
            this.k = new PraiseModel(this.f58538b.getPageContext(), new a());
        }
        return this.k;
    }

    public void f(boolean z) {
        this.f58534i = z;
    }

    public void g(a2 a2Var, int i2) {
        if (a2Var == null) {
            return;
        }
        if (i2 == 1) {
            PraiseData Q0 = a2Var.Q0();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (Q0 == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i2);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    a2Var.b4(praiseData);
                    return;
                }
                a2Var.Q0().getUser().add(0, metaData);
                a2Var.Q0().setNum(a2Var.Q0().getNum() + 1);
                a2Var.Q0().setIsLike(i2);
            }
        } else if (a2Var.Q0() != null) {
            a2Var.Q0().setIsLike(i2);
            a2Var.Q0().setNum(a2Var.Q0().getNum() - 1);
            ArrayList<MetaData> user = a2Var.Q0().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        a2Var.Q0().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    public void h(int i2) {
        ArrayList<d.a.c.j.e.n> threadList;
        FrsViewData g0 = this.f58538b.g0();
        if (g0 == null || this.f58537a == null || (threadList = g0.getThreadList()) == null) {
            return;
        }
        Iterator<d.a.c.j.e.n> it = threadList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d.a.c.j.e.n next = it.next();
            if (next instanceof z1) {
                a2 a2Var = ((z1) next).w;
                if (a2Var == this.f58533h) {
                    g(a2Var, i2);
                    this.f58533h = null;
                    break;
                } else if (a2Var.o0() != null && a2Var.o0().equals(this.j)) {
                    g(a2Var, i2);
                    this.j = null;
                    break;
                }
            }
        }
        this.f58537a.U().g(threadList, g0);
        this.f58537a.U().notifyDataSetChanged();
    }
}
