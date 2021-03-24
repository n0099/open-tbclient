package d.b.i0.d1.v.a;

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
    public d.b.i0.d1.t.a f54059e;

    /* renamed from: f  reason: collision with root package name */
    public int f54060f;

    public a(d.b.i0.d1.t.a aVar, int i) {
        this.f54059e = aVar;
        this.f54060f = i;
    }

    public final LoadDraftResponsedMessage a(int i) {
        LoadDraftResponsedMessage loadDraftResponsedMessage = new LoadDraftResponsedMessage(i);
        loadDraftResponsedMessage.setError(-18);
        return loadDraftResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<LoadDraftMessage.a> customMessage) {
        LoadDraftResponsedMessage loadDraftResponsedMessage = new LoadDraftResponsedMessage(this.f54060f);
        if (customMessage != null && (customMessage instanceof LoadDraftMessage)) {
            LoadDraftMessage loadDraftMessage = (LoadDraftMessage) customMessage;
            String id = TbadkCoreApplication.getCurrentAccountObj() != null ? TbadkCoreApplication.getCurrentAccountObj().getID() : "";
            LoadDraftMessage.a data = loadDraftMessage.getData();
            ChatSetting a2 = this.f54059e.a(id, data.f18037a);
            if (a2 == null) {
                return a(loadDraftMessage.getCmd());
            }
            String draft = a2.getDraft();
            LoadDraftResponsedMessage.a aVar = new LoadDraftResponsedMessage.a();
            aVar.f18038a = draft;
            String str = data.f18037a;
            try {
                loadDraftResponsedMessage.decodeInBackGround(this.f54060f, aVar);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return loadDraftResponsedMessage;
        }
        return a(this.f54060f);
    }
}
