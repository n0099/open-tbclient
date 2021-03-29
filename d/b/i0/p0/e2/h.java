package d.b.i0.p0.e2;

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
import d.b.h0.r.q.a2;
import d.b.h0.r.q.z1;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class h extends j {

    /* renamed from: h  reason: collision with root package name */
    public a2 f57474h;
    public boolean i;
    public String j;
    public PraiseModel k;
    public final CustomMessageListener l;

    /* loaded from: classes4.dex */
    public class a implements PraiseModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void a(String str) {
            if (h.this.i) {
                int i = 1;
                if (h.this.f57474h != null && h.this.f57474h.P0().getIsLike() == 1) {
                    i = 0;
                }
                h.this.h(i);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void b(int i, String str) {
            FrsFragment frsFragment = h.this.f57478b;
            if (frsFragment == null || frsFragment.getPageContext() == null || !h.this.i || TextUtils.isEmpty(str)) {
                return;
            }
            if (AntiHelper.m(i, str)) {
                AntiHelper.u(h.this.f57478b.getPageContext().getPageActivity(), str);
            } else {
                h.this.f57478b.showToast(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof a2)) {
                return;
            }
            a2 a2Var = (a2) customResponsedMessage.getData();
            h.this.j = a2Var.o0();
            if (TextUtils.isEmpty(h.this.j) || a2Var.P0() == null) {
                return;
            }
            h.this.h(a2Var.P0().getIsLike());
        }
    }

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        b bVar = new b(2004004);
        this.l = bVar;
        this.f57478b.registerListener(bVar);
        this.k = e();
    }

    public final PraiseModel e() {
        if (this.k == null) {
            this.k = new PraiseModel(this.f57478b.getPageContext(), new a());
        }
        return this.k;
    }

    public void f(boolean z) {
        this.i = z;
    }

    public void g(a2 a2Var, int i) {
        if (a2Var == null) {
            return;
        }
        if (i == 1) {
            PraiseData P0 = a2Var.P0();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (P0 == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    a2Var.X3(praiseData);
                    return;
                }
                a2Var.P0().getUser().add(0, metaData);
                a2Var.P0().setNum(a2Var.P0().getNum() + 1);
                a2Var.P0().setIsLike(i);
            }
        } else if (a2Var.P0() != null) {
            a2Var.P0().setIsLike(i);
            a2Var.P0().setNum(a2Var.P0().getNum() - 1);
            ArrayList<MetaData> user = a2Var.P0().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        a2Var.P0().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    public void h(int i) {
        ArrayList<d.b.b.j.e.n> threadList;
        FrsViewData S = this.f57478b.S();
        if (S == null || this.f57477a == null || (threadList = S.getThreadList()) == null) {
            return;
        }
        Iterator<d.b.b.j.e.n> it = threadList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d.b.b.j.e.n next = it.next();
            if (next instanceof z1) {
                a2 a2Var = ((z1) next).w;
                if (a2Var == this.f57474h) {
                    g(a2Var, i);
                    this.f57474h = null;
                    break;
                } else if (a2Var.o0() != null && a2Var.o0().equals(this.j)) {
                    g(a2Var, i);
                    this.j = null;
                    break;
                }
            }
        }
        this.f57477a.U().b(threadList, S);
        this.f57477a.U().notifyDataSetChanged();
    }
}
