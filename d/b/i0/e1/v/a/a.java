package d.b.i0.e1.v.a;

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
    public d.b.i0.e1.t.a f55582e;

    /* renamed from: f  reason: collision with root package name */
    public int f55583f;

    public a(d.b.i0.e1.t.a aVar, int i) {
        this.f55582e = aVar;
        this.f55583f = i;
    }

    public final LoadDraftResponsedMessage a(int i) {
        LoadDraftResponsedMessage loadDraftResponsedMessage = new LoadDraftResponsedMessage(i);
        loadDraftResponsedMessage.setError(-18);
        return loadDraftResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<LoadDraftMessage.a> customMessage) {
        LoadDraftResponsedMessage loadDraftResponsedMessage = new LoadDraftResponsedMessage(this.f55583f);
        if (customMessage != null && (customMessage instanceof LoadDraftMessage)) {
            LoadDraftMessage loadDraftMessage = (LoadDraftMessage) customMessage;
            String id = TbadkCoreApplication.getCurrentAccountObj() != null ? TbadkCoreApplication.getCurrentAccountObj().getID() : "";
            LoadDraftMessage.a data = loadDraftMessage.getData();
            ChatSetting a2 = this.f55582e.a(id, data.f17715a);
            if (a2 == null) {
                return a(loadDraftMessage.getCmd());
            }
            String draft = a2.getDraft();
            LoadDraftResponsedMessage.a aVar = new LoadDraftResponsedMessage.a();
            aVar.f17716a = draft;
            String str = data.f17715a;
            try {
                loadDraftResponsedMessage.decodeInBackGround(this.f55583f, aVar);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return loadDraftResponsedMessage;
        }
        return a(this.f55583f);
    }
}
