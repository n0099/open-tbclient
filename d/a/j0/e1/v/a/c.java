package d.a.j0.e1.v.a;

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
    public d.a.j0.e1.h.a f53875e;

    /* renamed from: f  reason: collision with root package name */
    public int f53876f;

    public c(d.a.j0.e1.h.a aVar, int i2) {
        this.f53875e = aVar;
        this.f53876f = i2;
    }

    public final LoadHistoryResponsedMessage a(int i2) {
        LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(i2);
        loadHistoryResponsedMessage.setError(-18);
        return loadHistoryResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<LoadHistoryMessage.a> customMessage) {
        if (customMessage != null && (customMessage instanceof LoadHistoryMessage) && this.f53875e != null) {
            LoadHistoryMessage.a data = customMessage.getData();
            LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(this.f53876f);
            LinkedList<ChatMessage> g2 = this.f53875e.g(d.a.c.e.m.b.f(data.f18054d, 0L), data.f18051a, data.f18052b, data.f18053c);
            if (g2 == null) {
                return a(this.f53876f);
            }
            LoadHistoryResponsedMessage.a aVar = new LoadHistoryResponsedMessage.a();
            if (data.f18051a == null) {
                aVar.f18057c = true;
            } else {
                aVar.f18057c = false;
            }
            aVar.f18055a = data.f18054d;
            aVar.f18056b = g2;
            try {
                loadHistoryResponsedMessage.decodeInBackGround(2001105, aVar);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return loadHistoryResponsedMessage;
        }
        return a(this.f53876f);
    }
}
