package d.b.i0.l1.k.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import d.b.i0.b0.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f56731a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<TransmitForumData> f56732b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public final CustomMessageListener f56733c = new C1336a(2016563);

    /* renamed from: d.b.i0.l1.k.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1336a extends CustomMessageListener {
        public C1336a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ArrayList)) {
                return;
            }
            a.this.f56732b.clear();
            a.this.f56732b.addAll((ArrayList) customResponsedMessage.getData());
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f56731a = tbPageContext;
        MessageManager.getInstance().registerListener(this.f56733c);
    }

    public List<TransmitForumData> b() {
        return this.f56732b;
    }

    public void c() {
        f.b().h();
    }

    public void d() {
        MessageManager.getInstance().unRegisterListener(this.f56733c);
    }

    public void e(long j) {
        if (j <= 0) {
            return;
        }
        SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.f56731a.getPageActivity(), 25018);
        CustomMessage customMessage = new CustomMessage(2002001, selectForumActivityConfig);
        selectForumActivityConfig.setFrom(1);
        selectForumActivityConfig.setForumList(this.f56732b);
        selectForumActivityConfig.setLiveId(j);
        MessageManager.getInstance().sendMessage(customMessage);
    }
}
