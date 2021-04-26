package d.a.j0.e1.v.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
import com.baidu.tieba.im.message.OfficialFeedHeadResponsedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class j implements CustomMessageTask.CustomRunnable<OfficialFeedHeadResponsedMessage.a> {

    /* renamed from: e  reason: collision with root package name */
    public int f53879e = 2001154;

    /* renamed from: f  reason: collision with root package name */
    public d.a.j0.e1.h.l f53880f = d.a.j0.e1.h.l.t();

    public final LoadHistoryResponsedMessage a(int i2) {
        LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(i2);
        loadHistoryResponsedMessage.setError(-18);
        return loadHistoryResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<OfficialFeedHeadResponsedMessage.a> customMessage) {
        if (this.f53880f == null) {
            return a(this.f53879e);
        }
        List<d.a.j0.e1.h.o.a> u = d.a.j0.e1.h.l.u();
        if (u != null && u.size() > 0) {
            HashMap hashMap = new HashMap(u.size());
            for (d.a.j0.e1.h.o.a aVar : u) {
                hashMap.put(aVar.b(), aVar);
            }
            LinkedList<ChatMessage> k = this.f53880f.k(hashMap, 80);
            if (k == null) {
                return a(this.f53879e);
            }
            OfficialFeedHeadResponsedMessage.a aVar2 = new OfficialFeedHeadResponsedMessage.a();
            OfficialFeedHeadResponsedMessage officialFeedHeadResponsedMessage = new OfficialFeedHeadResponsedMessage(this.f53879e);
            aVar2.f18073b = k;
            aVar2.f18072a = u;
            try {
                officialFeedHeadResponsedMessage.decodeInBackGround(2001105, aVar2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return officialFeedHeadResponsedMessage;
        }
        return a(this.f53879e);
    }
}
