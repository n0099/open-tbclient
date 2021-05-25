package d.a.n0.f1.v.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.SaveDraftMessage;
import com.baidu.tieba.im.pushNotify.ChatSetting;
/* loaded from: classes4.dex */
public abstract class b implements CustomMessageTask.CustomRunnable<SaveDraftMessage.a> {

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.f1.t.a f54770e;

    /* renamed from: f  reason: collision with root package name */
    public int f54771f;

    public b(d.a.n0.f1.t.a aVar, int i2) {
        this.f54770e = aVar;
        this.f54771f = i2;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<SaveDraftMessage.a> customMessage) {
        CustomResponsedMessage<?> customResponsedMessage = new CustomResponsedMessage<>(this.f54771f);
        if (customMessage == null || !(customMessage instanceof SaveDraftMessage)) {
            return null;
        }
        SaveDraftMessage.a data = customMessage.getData();
        ChatSetting a2 = this.f54770e.a(TbadkCoreApplication.getCurrentAccountObj() != null ? TbadkCoreApplication.getCurrentAccountObj().getID() : "", data.f17302b);
        if (a2 == null) {
            return null;
        }
        a2.setDraft(data.f17301a);
        this.f54770e.h(a2);
        return customResponsedMessage;
    }
}
