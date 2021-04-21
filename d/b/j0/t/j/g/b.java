package d.b.j0.t.j.g;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.gift.AlaRefreshScoreModel;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62866a;

    /* renamed from: b  reason: collision with root package name */
    public AlaRefreshScoreModel f62867b;

    /* renamed from: c  reason: collision with root package name */
    public c f62868c;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f62869d = new a(2001227);

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f62870e = new C1646b(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.d();
        }
    }

    /* renamed from: d.b.j0.t.j.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1646b extends CustomMessageListener {
        public C1646b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.f62868c != null) {
                b.this.f62868c.a(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(boolean z);
    }

    public b(TbPageContext tbPageContext) {
        this.f62866a = tbPageContext;
        tbPageContext.registerListener(this.f62869d);
        this.f62866a.registerListener(this.f62870e);
    }

    public void c(long j) {
        long j2 = j - TbadkCoreApplication.getInst().currentAccountTdouNum;
        if (j2 <= 0) {
            return;
        }
        if (j2 > 200000000) {
            l.L(TbadkCoreApplication.getInst(), this.f62866a.getResources().getString(R.string.ala_toast_gift_exceeding_limit_msg, 20L));
            return;
        }
        if (j2 % 1000 != 0) {
            j2 = ((j2 / 1000) + 1) * 1000;
        }
        BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(this.f62866a.getPageActivity(), 0L);
        buyTBeanActivityConfig.setFromDecreaseGiftStepStrategy(2);
        buyTBeanActivityConfig.setTBeanLeftToBuyGift(j2);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, buyTBeanActivityConfig));
    }

    public final boolean d() {
        if (TbadkCoreApplication.isLogin()) {
            if (this.f62867b == null) {
                AlaRefreshScoreModel alaRefreshScoreModel = new AlaRefreshScoreModel();
                this.f62867b = alaRefreshScoreModel;
                alaRefreshScoreModel.initListener();
            }
            this.f62867b.refreshCurUserScores();
            return true;
        }
        return false;
    }

    public void e(c cVar) {
        this.f62868c = cVar;
    }
}
