package d.a.n0.v.j.g;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.gift.AlaRefreshScoreModel;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.wallet.CurrencyJumpHelper;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f65792a;

    /* renamed from: b  reason: collision with root package name */
    public AlaRefreshScoreModel f65793b;

    /* renamed from: c  reason: collision with root package name */
    public c f65794c;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f65795d = new a(2001227);

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f65796e = new C1728b(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.d();
        }
    }

    /* renamed from: d.a.n0.v.j.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1728b extends CustomMessageListener {
        public C1728b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.f65794c != null) {
                b.this.f65794c.a(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(boolean z);
    }

    public b(TbPageContext tbPageContext) {
        this.f65792a = tbPageContext;
        tbPageContext.registerListener(this.f65795d);
        this.f65792a.registerListener(this.f65796e);
    }

    public void c(long j) {
        long j2 = j - TbadkCoreApplication.getInst().currentAccountTdouNum;
        if (j2 <= 0) {
            return;
        }
        if (j2 > 200000000) {
            l.M(TbadkCoreApplication.getInst(), this.f65792a.getResources().getString(R.string.ala_toast_gift_exceeding_limit_msg, 20L));
            return;
        }
        if (j2 % 1000 != 0) {
            j2 = ((j2 / 1000) + 1) * 1000;
        }
        CurrencyJumpHelper.gotoBuyTBeanPage(this.f65792a.getPageActivity(), j2);
    }

    public final boolean d() {
        if (TbadkCoreApplication.isLogin()) {
            if (this.f65793b == null) {
                AlaRefreshScoreModel alaRefreshScoreModel = new AlaRefreshScoreModel();
                this.f65793b = alaRefreshScoreModel;
                alaRefreshScoreModel.initListener();
            }
            this.f65793b.refreshCurUserScores();
            return true;
        }
        return false;
    }

    public void e(c cVar) {
        this.f65794c = cVar;
    }
}
