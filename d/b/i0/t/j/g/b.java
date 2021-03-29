package d.b.i0.t.j.g;

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
import d.b.b.e.p.l;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60881a;

    /* renamed from: b  reason: collision with root package name */
    public AlaRefreshScoreModel f60882b;

    /* renamed from: c  reason: collision with root package name */
    public c f60883c;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f60884d = new a(2001227);

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f60885e = new C1570b(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA);

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

    /* renamed from: d.b.i0.t.j.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1570b extends CustomMessageListener {
        public C1570b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.f60883c != null) {
                b.this.f60883c.a(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(boolean z);
    }

    public b(TbPageContext tbPageContext) {
        this.f60881a = tbPageContext;
        tbPageContext.registerListener(this.f60884d);
        this.f60881a.registerListener(this.f60885e);
    }

    public void c(long j) {
        long j2 = j - TbadkCoreApplication.getInst().currentAccountTdouNum;
        if (j2 <= 0) {
            return;
        }
        if (j2 > 200000000) {
            l.L(TbadkCoreApplication.getInst(), this.f60881a.getResources().getString(R.string.ala_toast_gift_exceeding_limit_msg, 20L));
            return;
        }
        if (j2 % 1000 != 0) {
            j2 = ((j2 / 1000) + 1) * 1000;
        }
        BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(this.f60881a.getPageActivity(), 0L);
        buyTBeanActivityConfig.setFromDecreaseGiftStepStrategy(2);
        buyTBeanActivityConfig.setTBeanLeftToBuyGift(j2);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, buyTBeanActivityConfig));
    }

    public final boolean d() {
        if (TbadkCoreApplication.isLogin()) {
            if (this.f60882b == null) {
                AlaRefreshScoreModel alaRefreshScoreModel = new AlaRefreshScoreModel();
                this.f60882b = alaRefreshScoreModel;
                alaRefreshScoreModel.initListener();
            }
            this.f60882b.refreshCurUserScores();
            return true;
        }
        return false;
    }

    public void e(c cVar) {
        this.f60883c = cVar;
    }
}
