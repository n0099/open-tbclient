package d.a.n0.f1.v.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.LoadDraftMessage;
import com.baidu.tieba.im.message.LoadDraftResponsedMessage;
import com.baidu.tieba.im.pushNotify.ChatSetting;
/* loaded from: classes4.dex */
public class a implements CustomMessageTask.CustomRunnable<LoadDraftMessage.a> {

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.f1.t.a f54768e;

    /* renamed from: f  reason: collision with root package name */
    public int f54769f;

    public a(d.a.n0.f1.t.a aVar, int i2) {
        this.f54768e = aVar;
        this.f54769f = i2;
    }

    public final LoadDraftResponsedMessage a(int i2) {
        LoadDraftResponsedMessage loadDraftResponsedMessage = new LoadDraftResponsedMessage(i2);
        loadDraftResponsedMessage.setError(-18);
        return loadDraftResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<LoadDraftMessage.a> customMessage) {
        LoadDraftResponsedMessage loadDraftResponsedMessage = new LoadDraftResponsedMessage(this.f54769f);
        if (customMessage != null && (customMessage instanceof LoadDraftMessage)) {
            LoadDraftMessage loadDraftMessage = (LoadDraftMessage) customMessage;
            String id = TbadkCoreApplication.getCurrentAccountObj() != null ? TbadkCoreApplication.getCurrentAccountObj().getID() : "";
            LoadDraftMessage.a data = loadDraftMessage.getData();
            ChatSetting a2 = this.f54768e.a(id, data.f17274a);
            if (a2 == null) {
                return a(loadDraftMessage.getCmd());
            }
            String draft = a2.getDraft();
            LoadDraftResponsedMessage.a aVar = new LoadDraftResponsedMessage.a();
            aVar.f17275a = draft;
            String str = data.f17274a;
            try {
                loadDraftResponsedMessage.decodeInBackGround(this.f54769f, aVar);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return loadDraftResponsedMessage;
        }
        return a(this.f54769f);
    }
}
