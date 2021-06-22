package d.a.o0.f1.f.j;

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
import d.a.o0.f1.l.c.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f58247a;

    /* renamed from: b  reason: collision with root package name */
    public d f58248b;

    /* renamed from: c  reason: collision with root package name */
    public String f58249c;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f58250d = new a(0);

    /* renamed from: e  reason: collision with root package name */
    public Runnable f58251e = new b();

    /* renamed from: f  reason: collision with root package name */
    public d.a.c.c.g.a f58252f = new c(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_HISTORY, 309669);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
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
                d.a.c.e.m.e.a().removeCallbacks(g.this.f58251e);
                d.a.c.e.m.e.a().postDelayed(g.this.f58251e, 1000L);
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
            gVar.f(gVar.f58249c);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends d.a.c.c.g.a {
        public c(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        @RequiresApi(api = 16)
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d.a.o0.f1.i.a.b.a data;
            if (responsedMessage == null) {
                return;
            }
            LongSparseArray<d.a.o0.f1.i.a.b.b> longSparseArray = null;
            if (responsedMessage instanceof ResponseHttpMajorHistoryMessage) {
                data = ((ResponseHttpMajorHistoryMessage) responsedMessage).getData();
            } else {
                data = responsedMessage instanceof ResponseSocketMajorHistoryMessage ? ((ResponseSocketMajorHistoryMessage) responsedMessage).getData() : null;
            }
            if (data == null) {
                return;
            }
            List<d.a.o0.f1.i.a.b.b> b2 = data.b();
            if (b2 != null && b2.size() > 0) {
                longSparseArray = new LongSparseArray<>(b2.size());
                for (d.a.o0.f1.i.a.b.b bVar : b2) {
                    longSparseArray.put(bVar.b(), bVar);
                }
            }
            if (g.this.f58248b == null || longSparseArray == null) {
                return;
            }
            g.this.f58248b.onReadCountLoad(longSparseArray);
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(List<d.a.o0.f1.l.c.b> list);

        void onReadCountLoad(LongSparseArray<d.a.o0.f1.i.a.b.b> longSparseArray);
    }

    public g(TbPageContext tbPageContext) {
        this.f58247a = tbPageContext;
        tbPageContext.registerListener(2001147, this.f58250d);
        tbPageContext.registerListener(2012123, this.f58250d);
        tbPageContext.registerListener(this.f58252f);
    }

    public void e() {
        d.a.c.e.m.e.a().removeCallbacks(this.f58251e);
    }

    public void f(String str) {
        this.f58249c = str;
        LoadHistoryMessage.a aVar = new LoadHistoryMessage.a();
        aVar.f17436c = 150;
        aVar.f17437d = str;
        this.f58247a.sendMessage(new LoadOfficialHistoryMessage(aVar));
    }

    public final void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage instanceof LoadHistoryResponsedMessage)) {
            LoadHistoryResponsedMessage loadHistoryResponsedMessage = (LoadHistoryResponsedMessage) customResponsedMessage;
            if (loadHistoryResponsedMessage.getData() == null) {
                return;
            }
            List<ChatMessage> list = loadHistoryResponsedMessage.getData().f17439b;
            ArrayList arrayList = new ArrayList();
            for (ChatMessage chatMessage : list) {
                List<a.C1378a> b2 = d.a.o0.f1.l.c.a.b(chatMessage.getContent(), chatMessage.getUserInfo().getUserId(), chatMessage.getUserInfo(), chatMessage.getMsgId(), chatMessage.getStatTaskId(), chatMessage.getStatisticsServiceId());
                if (b2 != null && b2.size() > 0 && (chatMessage instanceof OfficialChatMessage)) {
                    int i2 = 0;
                    while (i2 < b2.size()) {
                        a.C1378a c1378a = b2.get(i2);
                        d.a.o0.f1.l.c.b a2 = d.a.o0.f1.l.c.b.a(chatMessage, c1378a);
                        if (a2 != null && a2.d() != null && !StringUtils.isNull(a2.d().f58421a)) {
                            a2.j(i2 == 0 && !StringUtils.isNull(c1378a.f58423c));
                            arrayList.add(a2);
                        }
                        i2++;
                    }
                }
            }
            h(arrayList);
            d dVar = this.f58248b;
            if (dVar != null) {
                dVar.a(arrayList);
            }
        }
    }

    public final void h(List<d.a.o0.f1.l.c.b> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (d.a.o0.f1.l.c.b bVar : list) {
            if (bVar.g()) {
                arrayList.add(Long.valueOf(bVar.d().f58428h));
            }
        }
        BroadcastMajorHistoryRequestMessage broadcastMajorHistoryRequestMessage = new BroadcastMajorHistoryRequestMessage();
        broadcastMajorHistoryRequestMessage.queryType = 2;
        broadcastMajorHistoryRequestMessage.bcastIds = arrayList;
        this.f58247a.sendMessage(broadcastMajorHistoryRequestMessage);
    }

    public void i(d dVar) {
        this.f58248b = dVar;
    }
}
