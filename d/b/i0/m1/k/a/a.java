package d.b.i0.m1.k.a;

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
    public TbPageContext f58360a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<TransmitForumData> f58361b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public final CustomMessageListener f58362c = new C1392a(2016563);

    /* renamed from: d.b.i0.m1.k.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1392a extends CustomMessageListener {
        public C1392a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ArrayList)) {
                return;
            }
            a.this.f58361b.clear();
            a.this.f58361b.addAll((ArrayList) customResponsedMessage.getData());
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f58360a = tbPageContext;
        MessageManager.getInstance().registerListener(this.f58362c);
    }

    public List<TransmitForumData> b() {
        return this.f58361b;
    }

    public void c() {
        f.b().h();
    }

    public void d() {
        MessageManager.getInstance().unRegisterListener(this.f58362c);
    }

    public void e(long j) {
        if (j <= 0) {
            return;
        }
        SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.f58360a.getPageActivity(), 25018);
        CustomMessage customMessage = new CustomMessage(2002001, selectForumActivityConfig);
        selectForumActivityConfig.setFrom(1);
        selectForumActivityConfig.setForumList(this.f58361b);
        selectForumActivityConfig.setLiveId(j);
        MessageManager.getInstance().sendMessage(customMessage);
    }
}
