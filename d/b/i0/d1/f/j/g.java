package d.b.i0.d1.f.j;

import android.util.LongSparseArray;
import androidx.annotation.RequiresApi;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.im.forum.broadcast.data.BroadcastMajorHistoryRequestMessage;
import com.baidu.tieba.im.forum.broadcast.data.ResponseHttpMajorHistoryMessage;
import com.baidu.tieba.im.forum.broadcast.data.ResponseSocketMajorHistoryMessage;
import com.baidu.tieba.im.message.LoadHistoryMessage;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
import com.baidu.tieba.im.message.LoadOfficialHistoryMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import d.b.i0.d1.l.c.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f53738a;

    /* renamed from: b  reason: collision with root package name */
    public d f53739b;

    /* renamed from: c  reason: collision with root package name */
    public String f53740c;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f53741d = new a(0);

    /* renamed from: e  reason: collision with root package name */
    public Runnable f53742e = new b();

    /* renamed from: f  reason: collision with root package name */
    public d.b.b.c.g.a f53743f = new c(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_HISTORY, 309669);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2001147) {
                g.this.g(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2012123) {
                d.b.b.e.m.e.a().removeCallbacks(g.this.f53742e);
                d.b.b.e.m.e.a().postDelayed(g.this.f53742e, 1000L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = g.this;
            gVar.f(gVar.f53740c);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends d.b.b.c.g.a {
        public c(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        @RequiresApi(api = 16)
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d.b.i0.d1.i.a.b.a data;
            if (responsedMessage == null) {
                return;
            }
            LongSparseArray<d.b.i0.d1.i.a.b.b> longSparseArray = null;
            if (responsedMessage instanceof ResponseHttpMajorHistoryMessage) {
                data = ((ResponseHttpMajorHistoryMessage) responsedMessage).getData();
            } else {
                data = responsedMessage instanceof ResponseSocketMajorHistoryMessage ? ((ResponseSocketMajorHistoryMessage) responsedMessage).getData() : null;
            }
            if (data == null) {
                return;
            }
            List<d.b.i0.d1.i.a.b.b> b2 = data.b();
            if (b2 != null && b2.size() > 0) {
                longSparseArray = new LongSparseArray<>(b2.size());
                for (d.b.i0.d1.i.a.b.b bVar : b2) {
                    longSparseArray.put(bVar.b(), bVar);
                }
            }
            if (g.this.f53739b == null || longSparseArray == null) {
                return;
            }
            g.this.f53739b.onReadCountLoad(longSparseArray);
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(List<d.b.i0.d1.l.c.b> list);

        void onReadCountLoad(LongSparseArray<d.b.i0.d1.i.a.b.b> longSparseArray);
    }

    public g(TbPageContext tbPageContext) {
        this.f53738a = tbPageContext;
        tbPageContext.registerListener(2001147, this.f53741d);
        tbPageContext.registerListener(2012123, this.f53741d);
        tbPageContext.registerListener(this.f53743f);
    }

    public void e() {
        d.b.b.e.m.e.a().removeCallbacks(this.f53742e);
    }

    public void f(String str) {
        this.f53740c = str;
        LoadHistoryMessage.a aVar = new LoadHistoryMessage.a();
        aVar.f18041c = 150;
        aVar.f18042d = str;
        this.f53738a.sendMessage(new LoadOfficialHistoryMessage(aVar));
    }

    public final void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage instanceof LoadHistoryResponsedMessage)) {
            LoadHistoryResponsedMessage loadHistoryResponsedMessage = (LoadHistoryResponsedMessage) customResponsedMessage;
            if (loadHistoryResponsedMessage.getData() == null) {
                return;
            }
            List<ChatMessage> list = loadHistoryResponsedMessage.getData().f18044b;
            ArrayList arrayList = new ArrayList();
            for (ChatMessage chatMessage : list) {
                List<a.C1202a> b2 = d.b.i0.d1.l.c.a.b(chatMessage.getContent(), chatMessage.getUserInfo().getUserId(), chatMessage.getUserInfo(), chatMessage.getMsgId(), chatMessage.getStatTaskId(), chatMessage.getStatisticsServiceId());
                if (b2 != null && b2.size() > 0 && (chatMessage instanceof OfficialChatMessage)) {
                    int i = 0;
                    while (i < b2.size()) {
                        a.C1202a c1202a = b2.get(i);
                        d.b.i0.d1.l.c.b b3 = d.b.i0.d1.l.c.b.b(chatMessage, c1202a);
                        if (b3 != null && b3.f() != null && !StringUtils.isNull(b3.f().f53906a)) {
                            b3.j(i == 0 && !StringUtils.isNull(c1202a.f53908c));
                            arrayList.add(b3);
                        }
                        i++;
                    }
                }
            }
            h(arrayList);
            d dVar = this.f53739b;
            if (dVar != null) {
                dVar.a(arrayList);
            }
        }
    }

    public final void h(List<d.b.i0.d1.l.c.b> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (d.b.i0.d1.l.c.b bVar : list) {
            if (bVar.h()) {
                arrayList.add(Long.valueOf(bVar.f().f53913h));
            }
        }
        BroadcastMajorHistoryRequestMessage broadcastMajorHistoryRequestMessage = new BroadcastMajorHistoryRequestMessage();
        broadcastMajorHistoryRequestMessage.queryType = 2;
        broadcastMajorHistoryRequestMessage.bcastIds = arrayList;
        this.f53738a.sendMessage(broadcastMajorHistoryRequestMessage);
    }

    public void i(d dVar) {
        this.f53739b = dVar;
    }
}
