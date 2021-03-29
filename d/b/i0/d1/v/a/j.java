package d.b.i0.d1.v.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
import com.baidu.tieba.im.message.OfficialFeedHeadResponsedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class j implements CustomMessageTask.CustomRunnable<OfficialFeedHeadResponsedMessage.a> {

    /* renamed from: e  reason: collision with root package name */
    public int f54068e = 2001154;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.d1.h.l f54069f = d.b.i0.d1.h.l.t();

    public final LoadHistoryResponsedMessage a(int i) {
        LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(i);
        loadHistoryResponsedMessage.setError(-18);
        return loadHistoryResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<OfficialFeedHeadResponsedMessage.a> customMessage) {
        if (this.f54069f == null) {
            return a(this.f54068e);
        }
        List<d.b.i0.d1.h.o.a> u = d.b.i0.d1.h.l.u();
        if (u != null && u.size() > 0) {
            HashMap hashMap = new HashMap(u.size());
            for (d.b.i0.d1.h.o.a aVar : u) {
                hashMap.put(aVar.b(), aVar);
            }
            LinkedList<ChatMessage> k = this.f54069f.k(hashMap, 80);
            if (k == null) {
                return a(this.f54068e);
            }
            OfficialFeedHeadResponsedMessage.a aVar2 = new OfficialFeedHeadResponsedMessage.a();
            OfficialFeedHeadResponsedMessage officialFeedHeadResponsedMessage = new OfficialFeedHeadResponsedMessage(this.f54068e);
            aVar2.f18062b = k;
            aVar2.f18061a = u;
            try {
                officialFeedHeadResponsedMessage.decodeInBackGround(2001105, aVar2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return officialFeedHeadResponsedMessage;
        }
        return a(this.f54068e);
    }
}
