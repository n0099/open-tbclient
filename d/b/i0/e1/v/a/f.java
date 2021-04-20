package d.b.i0.e1.v.a;

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
    public d.b.i0.e1.h.c f55588e;

    /* renamed from: f  reason: collision with root package name */
    public int f55589f;

    public f() {
        b(d.b.i0.e1.h.c.h(), 2001145);
    }

    public final LoadHistoryResponsedMessage a(int i) {
        LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(i);
        loadHistoryResponsedMessage.setError(-18);
        return loadHistoryResponsedMessage;
    }

    public final void b(d.b.i0.e1.h.c cVar, int i) {
        this.f55588e = cVar;
        this.f55589f = i;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<LoadHistoryMessage.a> customMessage) {
        if (customMessage != null && (customMessage instanceof LoadHistoryMessage)) {
            if (this.f55588e == null) {
                return a(this.f55589f);
            }
            LoadHistoryMessage.a data = customMessage.getData();
            LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(this.f55589f);
            LinkedList<ChatMessage> g2 = this.f55588e.g(data.f17720d, data.f17717a, data.f17718b, data.f17719c);
            if (g2 == null) {
                return a(this.f55589f);
            }
            LoadHistoryResponsedMessage.a aVar = new LoadHistoryResponsedMessage.a();
            if (data.f17717a == null) {
                aVar.f17723c = true;
            } else {
                aVar.f17723c = false;
            }
            aVar.f17722b = g2;
            aVar.f17721a = data.f17720d;
            try {
                loadHistoryResponsedMessage.decodeInBackGround(2001105, aVar);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return loadHistoryResponsedMessage;
        }
        return a(this.f55589f);
    }
}
