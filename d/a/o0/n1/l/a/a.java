package d.a.o0.n1.l.a;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import d.a.o0.d0.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f61494a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<TransmitForumData> f61495b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public final CustomMessageListener f61496c = new C1504a(2016563);

    /* renamed from: d.a.o0.n1.l.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1504a extends CustomMessageListener {
        public C1504a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ArrayList)) {
                return;
            }
            a.this.f61495b.clear();
            a.this.f61495b.addAll((ArrayList) customResponsedMessage.getData());
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f61494a = tbPageContext;
        MessageManager.getInstance().registerListener(this.f61496c);
    }

    public List<TransmitForumData> b() {
        return this.f61495b;
    }

    public void c() {
        f.b().h();
    }

    public void d() {
        MessageManager.getInstance().unRegisterListener(this.f61496c);
    }

    public void e(long j, String str, ShareItem shareItem) {
        if (j > 0 || !TextUtils.isEmpty(str)) {
            SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.f61494a.getPageActivity(), 24007);
            CustomMessage customMessage = new CustomMessage(2002001, selectForumActivityConfig);
            selectForumActivityConfig.setFrom(1);
            selectForumActivityConfig.setForumList(this.f61495b);
            selectForumActivityConfig.setLiveId(j);
            selectForumActivityConfig.setYyAnchorBdUid(str);
            shareItem.j(true);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }
}
