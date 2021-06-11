package d.a.n0.f1.v.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.message.LoadHistoryMessage;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public abstract class c implements CustomMessageTask.CustomRunnable<LoadHistoryMessage.a> {

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.f1.h.a f58461e;

    /* renamed from: f  reason: collision with root package name */
    public int f58462f;

    public c(d.a.n0.f1.h.a aVar, int i2) {
        this.f58461e = aVar;
        this.f58462f = i2;
    }

    public final LoadHistoryResponsedMessage a(int i2) {
        LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(i2);
        loadHistoryResponsedMessage.setError(-18);
        return loadHistoryResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<LoadHistoryMessage.a> customMessage) {
        if (customMessage != null && (customMessage instanceof LoadHistoryMessage) && this.f58461e != null) {
            LoadHistoryMessage.a data = customMessage.getData();
            LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(this.f58462f);
            LinkedList<ChatMessage> g2 = this.f58461e.g(d.a.c.e.m.b.f(data.f17355d, 0L), data.f17352a, data.f17353b, data.f17354c);
            if (g2 == null) {
                return a(this.f58462f);
            }
            LoadHistoryResponsedMessage.a aVar = new LoadHistoryResponsedMessage.a();
            if (data.f17352a == null) {
                aVar.f17358c = true;
            } else {
                aVar.f17358c = false;
            }
            aVar.f17356a = data.f17355d;
            aVar.f17357b = g2;
            try {
                loadHistoryResponsedMessage.decodeInBackGround(2001105, aVar);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return loadHistoryResponsedMessage;
        }
        return a(this.f58462f);
    }
}
