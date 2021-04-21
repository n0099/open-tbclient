package d.b.j0.e1.v.a;

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
    public d.b.j0.e1.h.c f56009e;

    /* renamed from: f  reason: collision with root package name */
    public int f56010f;

    public f() {
        b(d.b.j0.e1.h.c.h(), 2001145);
    }

    public final LoadHistoryResponsedMessage a(int i) {
        LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(i);
        loadHistoryResponsedMessage.setError(-18);
        return loadHistoryResponsedMessage;
    }

    public final void b(d.b.j0.e1.h.c cVar, int i) {
        this.f56009e = cVar;
        this.f56010f = i;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<LoadHistoryMessage.a> customMessage) {
        if (customMessage != null && (customMessage instanceof LoadHistoryMessage)) {
            if (this.f56009e == null) {
                return a(this.f56010f);
            }
            LoadHistoryMessage.a data = customMessage.getData();
            LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(this.f56010f);
            LinkedList<ChatMessage> g2 = this.f56009e.g(data.f17728d, data.f17725a, data.f17726b, data.f17727c);
            if (g2 == null) {
                return a(this.f56010f);
            }
            LoadHistoryResponsedMessage.a aVar = new LoadHistoryResponsedMessage.a();
            if (data.f17725a == null) {
                aVar.f17731c = true;
            } else {
                aVar.f17731c = false;
            }
            aVar.f17730b = g2;
            aVar.f17729a = data.f17728d;
            try {
                loadHistoryResponsedMessage.decodeInBackGround(2001105, aVar);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return loadHistoryResponsedMessage;
        }
        return a(this.f56010f);
    }
}
