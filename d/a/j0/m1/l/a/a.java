package d.a.j0.m1.l.a;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import d.a.j0.b0.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f56793a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<TransmitForumData> f56794b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public final CustomMessageListener f56795c = new C1354a(2016563);

    /* renamed from: d.a.j0.m1.l.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1354a extends CustomMessageListener {
        public C1354a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ArrayList)) {
                return;
            }
            a.this.f56794b.clear();
            a.this.f56794b.addAll((ArrayList) customResponsedMessage.getData());
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f56793a = tbPageContext;
        MessageManager.getInstance().registerListener(this.f56795c);
    }

    public List<TransmitForumData> b() {
        return this.f56794b;
    }

    public void c() {
        f.b().h();
    }

    public void d() {
        MessageManager.getInstance().unRegisterListener(this.f56795c);
    }

    public void e(long j, String str, ShareItem shareItem) {
        if (j > 0 || !TextUtils.isEmpty(str)) {
            SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.f56793a.getPageActivity(), 24007);
            CustomMessage customMessage = new CustomMessage(2002001, selectForumActivityConfig);
            selectForumActivityConfig.setFrom(1);
            selectForumActivityConfig.setForumList(this.f56794b);
            selectForumActivityConfig.setLiveId(j);
            selectForumActivityConfig.setYyAnchorBdUid(str);
            shareItem.j(true);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }
}
