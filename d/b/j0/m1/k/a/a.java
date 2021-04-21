package d.b.j0.m1.k.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import d.b.j0.b0.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f58781a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<TransmitForumData> f58782b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public final CustomMessageListener f58783c = new C1415a(2016563);

    /* renamed from: d.b.j0.m1.k.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1415a extends CustomMessageListener {
        public C1415a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ArrayList)) {
                return;
            }
            a.this.f58782b.clear();
            a.this.f58782b.addAll((ArrayList) customResponsedMessage.getData());
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f58781a = tbPageContext;
        MessageManager.getInstance().registerListener(this.f58783c);
    }

    public List<TransmitForumData> b() {
        return this.f58782b;
    }

    public void c() {
        f.b().h();
    }

    public void d() {
        MessageManager.getInstance().unRegisterListener(this.f58783c);
    }

    public void e(long j) {
        if (j <= 0) {
            return;
        }
        SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.f58781a.getPageActivity(), 25018);
        CustomMessage customMessage = new CustomMessage(2002001, selectForumActivityConfig);
        selectForumActivityConfig.setFrom(1);
        selectForumActivityConfig.setForumList(this.f58782b);
        selectForumActivityConfig.setLiveId(j);
        MessageManager.getInstance().sendMessage(customMessage);
    }
}
