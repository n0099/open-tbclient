package d.b.j0.e1.v.a;

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
    public d.b.j0.e1.h.a f56007e;

    /* renamed from: f  reason: collision with root package name */
    public int f56008f;

    public c(d.b.j0.e1.h.a aVar, int i) {
        this.f56007e = aVar;
        this.f56008f = i;
    }

    public final LoadHistoryResponsedMessage a(int i) {
        LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(i);
        loadHistoryResponsedMessage.setError(-18);
        return loadHistoryResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<LoadHistoryMessage.a> customMessage) {
        if (customMessage != null && (customMessage instanceof LoadHistoryMessage) && this.f56007e != null) {
            LoadHistoryMessage.a data = customMessage.getData();
            LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(this.f56008f);
            LinkedList<ChatMessage> g2 = this.f56007e.g(d.b.c.e.m.b.f(data.f17728d, 0L), data.f17725a, data.f17726b, data.f17727c);
            if (g2 == null) {
                return a(this.f56008f);
            }
            LoadHistoryResponsedMessage.a aVar = new LoadHistoryResponsedMessage.a();
            if (data.f17725a == null) {
                aVar.f17731c = true;
            } else {
                aVar.f17731c = false;
            }
            aVar.f17729a = data.f17728d;
            aVar.f17730b = g2;
            try {
                loadHistoryResponsedMessage.decodeInBackGround(2001105, aVar);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return loadHistoryResponsedMessage;
        }
        return a(this.f56008f);
    }
}
