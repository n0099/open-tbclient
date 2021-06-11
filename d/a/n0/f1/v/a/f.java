package d.a.n0.f1.v.a;

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
    public d.a.n0.f1.h.c f58463e;

    /* renamed from: f  reason: collision with root package name */
    public int f58464f;

    public f() {
        b(d.a.n0.f1.h.c.h(), 2001145);
    }

    public final LoadHistoryResponsedMessage a(int i2) {
        LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(i2);
        loadHistoryResponsedMessage.setError(-18);
        return loadHistoryResponsedMessage;
    }

    public final void b(d.a.n0.f1.h.c cVar, int i2) {
        this.f58463e = cVar;
        this.f58464f = i2;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<LoadHistoryMessage.a> customMessage) {
        if (customMessage != null && (customMessage instanceof LoadHistoryMessage)) {
            if (this.f58463e == null) {
                return a(this.f58464f);
            }
            LoadHistoryMessage.a data = customMessage.getData();
            LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(this.f58464f);
            LinkedList<ChatMessage> g2 = this.f58463e.g(data.f17355d, data.f17352a, data.f17353b, data.f17354c);
            if (g2 == null) {
                return a(this.f58464f);
            }
            LoadHistoryResponsedMessage.a aVar = new LoadHistoryResponsedMessage.a();
            if (data.f17352a == null) {
                aVar.f17358c = true;
            } else {
                aVar.f17358c = false;
            }
            aVar.f17357b = g2;
            aVar.f17356a = data.f17355d;
            try {
                loadHistoryResponsedMessage.decodeInBackGround(2001105, aVar);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return loadHistoryResponsedMessage;
        }
        return a(this.f58464f);
    }
}
