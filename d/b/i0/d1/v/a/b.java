package d.b.i0.d1.v.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.SaveDraftMessage;
import com.baidu.tieba.im.pushNotify.ChatSetting;
/* loaded from: classes3.dex */
public abstract class b implements CustomMessageTask.CustomRunnable<SaveDraftMessage.a> {

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.d1.t.a f54062e;

    /* renamed from: f  reason: collision with root package name */
    public int f54063f;

    public b(d.b.i0.d1.t.a aVar, int i) {
        this.f54062e = aVar;
        this.f54063f = i;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<SaveDraftMessage.a> customMessage) {
        CustomResponsedMessage<?> customResponsedMessage = new CustomResponsedMessage<>(this.f54063f);
        if (customMessage == null || !(customMessage instanceof SaveDraftMessage)) {
            return null;
        }
        SaveDraftMessage.a data = customMessage.getData();
        ChatSetting a2 = this.f54062e.a(TbadkCoreApplication.getCurrentAccountObj() != null ? TbadkCoreApplication.getCurrentAccountObj().getID() : "", data.f18066b);
        if (a2 == null) {
            return null;
        }
        a2.setDraft(data.f18065a);
        this.f54062e.h(a2);
        return customResponsedMessage;
    }
}
