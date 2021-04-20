package d.b.i0.e1.v.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.SaveDraftMessage;
import com.baidu.tieba.im.pushNotify.ChatSetting;
/* loaded from: classes4.dex */
public abstract class b implements CustomMessageTask.CustomRunnable<SaveDraftMessage.a> {

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.e1.t.a f55584e;

    /* renamed from: f  reason: collision with root package name */
    public int f55585f;

    public b(d.b.i0.e1.t.a aVar, int i) {
        this.f55584e = aVar;
        this.f55585f = i;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<SaveDraftMessage.a> customMessage) {
        CustomResponsedMessage<?> customResponsedMessage = new CustomResponsedMessage<>(this.f55585f);
        if (customMessage == null || !(customMessage instanceof SaveDraftMessage)) {
            return null;
        }
        SaveDraftMessage.a data = customMessage.getData();
        ChatSetting a2 = this.f55584e.a(TbadkCoreApplication.getCurrentAccountObj() != null ? TbadkCoreApplication.getCurrentAccountObj().getID() : "", data.f17743b);
        if (a2 == null) {
            return null;
        }
        a2.setDraft(data.f17742a);
        this.f55584e.h(a2);
        return customResponsedMessage;
    }
}
