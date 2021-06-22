package d.a.o0.f1.v.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.message.LoadHistoryMessage;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class f implements CustomMessageTask.CustomRunnable<LoadHistoryMessage.a> {

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.f1.h.c f58588e;

    /* renamed from: f  reason: collision with root package name */
    public int f58589f;

    public f() {
        b(d.a.o0.f1.h.c.h(), 2001145);
    }

    public final LoadHistoryResponsedMessage a(int i2) {
        LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(i2);
        loadHistoryResponsedMessage.setError(-18);
        return loadHistoryResponsedMessage;
    }

    public final void b(d.a.o0.f1.h.c cVar, int i2) {
        this.f58588e = cVar;
        this.f58589f = i2;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<LoadHistoryMessage.a> customMessage) {
        if (customMessage != null && (customMessage instanceof LoadHistoryMessage)) {
            if (this.f58588e == null) {
                return a(this.f58589f);
            }
            LoadHistoryMessage.a data = customMessage.getData();
            LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(this.f58589f);
            LinkedList<ChatMessage> g2 = this.f58588e.g(data.f17437d, data.f17434a, data.f17435b, data.f17436c);
            if (g2 == null) {
                return a(this.f58589f);
            }
            LoadHistoryResponsedMessage.a aVar = new LoadHistoryResponsedMessage.a();
            if (data.f17434a == null) {
                aVar.f17440c = true;
            } else {
                aVar.f17440c = false;
            }
            aVar.f17439b = g2;
            aVar.f17438a = data.f17437d;
            try {
                loadHistoryResponsedMessage.decodeInBackGround(2001105, aVar);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return loadHistoryResponsedMessage;
        }
        return a(this.f58589f);
    }
}
