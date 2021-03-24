package d.b.i0.d1.m;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import androidx.collection.LongSparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tieba.im.message.MessageSyncMessage;
import com.baidu.tieba.im.message.PushCountMessage;
import com.baidu.tieba.im.util.MessageUtils;
import d.b.b.e.r.k;
import d.b.h0.m0.i;
import d.b.h0.s.j.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import protobuf.NewpushRepair;
/* loaded from: classes4.dex */
public class b {
    public static b r;

    /* renamed from: e  reason: collision with root package name */
    public List<GroupUpdateMessage> f53922e;
    public boolean n;

    /* renamed from: a  reason: collision with root package name */
    public int f53918a = 900000;

    /* renamed from: b  reason: collision with root package name */
    public int f53919b = 360000;

    /* renamed from: c  reason: collision with root package name */
    public int f53920c = 360000;

    /* renamed from: d  reason: collision with root package name */
    public int f53921d = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f53923f = 0;

    /* renamed from: g  reason: collision with root package name */
    public long f53924g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f53925h = 0;
    public final BdUniqueId i = BdUniqueId.gen();
    public final Handler j = new g(null);
    public LongSparseArray<Long> k = null;
    public LongSparseArray<Long> l = null;
    public final d.b.b.c.e.c.k.a m = new c();
    public final d.b.b.c.g.c o = new d(0);
    public final CustomMessageListener p = new e(2001011);
    public final CustomMessageListener q = new f(2005016);

    /* loaded from: classes4.dex */
    public static class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                d.b.h0.s.j.e.j().m();
                b.l().w();
            }
        }
    }

    /* renamed from: d.b.i0.d1.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1203b extends CustomMessageListener {
        public C1203b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                b.l().o();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.b.b.c.e.c.k.a {
        public c() {
        }

        @Override // d.b.b.c.e.c.k.a
        public boolean a(int i, String str) {
            b.this.C();
            return false;
        }

        @Override // d.b.b.c.e.c.k.a
        public void b(d.b.b.e.r.c cVar) {
        }

        @Override // d.b.b.c.e.c.k.a
        public void c(String str) {
        }

        @Override // d.b.b.c.e.c.k.a
        public void d(k kVar) {
        }

        @Override // d.b.b.c.e.c.k.a
        public void g(Map<String, String> map) {
            b.this.B();
            d.b.b.c.e.c.f.a().c(map);
        }
    }

    /* loaded from: classes4.dex */
    public class d extends d.b.b.c.g.c {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage == null) {
                return;
            }
            if (socketResponsedMessage.getCmd() == 1003) {
                if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                    b.this.x();
                }
            } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                if (responseOnlineMessage.getError() != 0) {
                    return;
                }
                b.this.f53922e = responseOnlineMessage.getGroupInfos();
                if (d.b.i0.d1.k.b.o().z()) {
                    b.this.o();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    b.this.D();
                } else {
                    b.this.E();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public f(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016) {
                return;
            }
            if (b.this.k != null) {
                b.this.k.clear();
            }
            if (b.this.l != null) {
                b.this.l.clear();
            }
            b.this.f53922e = null;
        }
    }

    /* loaded from: classes4.dex */
    public static class g extends Handler {
        public g() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 2) {
                b.l().j.removeMessages(2);
                b.l().u();
            } else if (i != 3) {
            } else {
                b.l().j.removeMessages(3);
                if (b.l().f53925h == 3) {
                    b.l().t();
                } else {
                    b.l().u();
                }
                b.l().j.sendMessageDelayed(b.l().j.obtainMessage(3), b.l().f53920c);
            }
        }

        public /* synthetic */ g(a aVar) {
            this();
        }
    }

    static {
        MessageManager.getInstance().registerListener(new a(2008017));
        MessageManager.getInstance().registerListener(new C1203b(2016002));
        r = null;
    }

    public static synchronized b l() {
        b bVar;
        synchronized (b.class) {
            if (r == null) {
                r = new b();
            }
            bVar = r;
        }
        return bVar;
    }

    public final void A(int i) {
        if (i == 1) {
            if (this.f53921d != 2) {
                this.f53921d = 1;
            }
        } else if (i == 3 || i == 2) {
            this.f53921d = 2;
        }
    }

    public void B() {
        j();
    }

    public void C() {
        j();
        i();
    }

    public void D() {
        l().f53920c = l().f53918a;
    }

    public void E() {
        this.f53920c = this.f53919b;
    }

    public final void h() {
        int i = this.f53921d;
        if (i != 0) {
            if (i == 1) {
                r(0L, 0L, 0L);
            } else {
                u();
            }
        }
    }

    public final void i() {
        this.j.removeMessages(3);
        this.j.removeMessages(2);
    }

    public final void j() {
        this.f53921d = 0;
    }

    public final MessageSyncMessage k(LongSparseArray<Long> longSparseArray, int i) {
        MessageSyncMessage messageSyncMessage = new MessageSyncMessage();
        messageSyncMessage.setTag(this.i);
        if (longSparseArray != null && longSparseArray.size() > 0) {
            messageSyncMessage.setGroupMids(longSparseArray);
            NewpushRepair makeNewpushRepair = MessageUtils.makeNewpushRepair(longSparseArray);
            if (makeNewpushRepair != null) {
                messageSyncMessage.setNewpushRepire(makeNewpushRepair);
            }
        } else {
            messageSyncMessage.setGroupMids(d.b.i0.d1.k.b.o().r());
        }
        messageSyncMessage.setForTimer(this.n);
        LocalViewSize.ImageSize msgBPicMaxSize = LocalViewSize.getInstance().getMsgBPicMaxSize();
        if (msgBPicMaxSize != null) {
            messageSyncMessage.setWidth(msgBPicMaxSize.width);
            messageSyncMessage.setHeight(msgBPicMaxSize.height);
        }
        LocalViewSize.ImageSize msgSPicMaxSize = LocalViewSize.getInstance().getMsgSPicMaxSize();
        if (msgSPicMaxSize != null) {
            messageSyncMessage.setSmallHeight(msgSPicMaxSize.height);
            messageSyncMessage.setSmallWidth(msgSPicMaxSize.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void m(Context context) {
        if (context != null) {
            MessageManager.getInstance().registerListener(this.p);
            MessageManager.getInstance().registerListener(this.q);
            h.j().p(this.m);
            MessageManager.getInstance().registerListener(1003, this.o);
            MessageManager.getInstance().registerListener(1001, this.o);
            MessageManager.getInstance().registerListener(202101, this.o);
            w();
            return;
        }
        throw new IllegalArgumentException("MessageSync init param illegal");
    }

    public void n() {
        h();
    }

    public void o() {
        if (this.f53922e == null) {
            return;
        }
        boolean z = false;
        LongSparseArray<Long> r2 = d.b.i0.d1.k.b.o().r();
        if (r2 == null) {
            this.f53922e = null;
            return;
        }
        Iterator<GroupUpdateMessage> it = this.f53922e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            GroupUpdateMessage next = it.next();
            if (next != null && r2.get(next.getGroupId()) != null) {
                if (r2.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                    z = true;
                    break;
                }
            }
        }
        this.f53925h = 3;
        if (z) {
            Handler handler = this.j;
            handler.sendMessage(handler.obtainMessage(3));
        } else {
            l().j.sendMessageDelayed(l().j.obtainMessage(3), l().f53920c);
        }
        this.f53922e = null;
    }

    public final void p(LongSparseArray<Long> longSparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().s() > 10) {
            i.b(false, true, false);
            Handler handler = this.j;
            handler.sendMessageDelayed(handler.obtainMessage(2), 2000L);
            return;
        }
        boolean u = MessageManager.getInstance().getSocketClient().u(202003, this.i);
        int t = MessageManager.getInstance().getSocketClient().t(202003);
        if (!u && t <= 0) {
            j();
            LongSparseArray<Long> longSparseArray2 = null;
            if (longSparseArray != null && longSparseArray.size() > 0) {
                longSparseArray2 = new LongSparseArray<>();
                for (int i2 = 0; i2 < longSparseArray.size(); i2++) {
                    long keyAt = longSparseArray.keyAt(i2);
                    longSparseArray2.put(keyAt, Long.valueOf(longSparseArray.get(keyAt).longValue()));
                }
            }
            MessageSyncMessage k = k(longSparseArray2, i);
            if (i == 3 || i == 2) {
                k.setNewpushRepire(d.b.i0.d1.k.b.o().s());
            }
            MessageManager.getInstance().sendMessage(k);
            i.b(true, false, false);
            if (i == 3 || i == 1 || i == 2) {
                LongSparseArray<Long> longSparseArray3 = this.k;
                if (longSparseArray3 != null) {
                    longSparseArray3.clear();
                }
                LongSparseArray<Long> longSparseArray4 = this.l;
                if (longSparseArray4 != null) {
                    longSparseArray4.clear();
                    return;
                }
                return;
            }
            return;
        }
        i.b(false, false, true);
        A(i);
    }

    public synchronized void q(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.n = false;
                this.f53925h = 4;
                this.j.removeMessages(3);
                l().j.sendMessageDelayed(l().j.obtainMessage(3), l().f53920c);
                p(longSparseArray, 4);
            }
        }
    }

    public void r(long j, long j2, long j3) {
        s(j, j2, j3, false);
    }

    public synchronized void s(long j, long j2, long j3, boolean z) {
        long longValue;
        this.f53923f++;
        this.n = false;
        this.f53925h = 1;
        this.j.removeMessages(3);
        l().j.sendMessageDelayed(l().j.obtainMessage(3), l().f53920c);
        if (this.k == null) {
            LongSparseArray<Long> longSparseArray = new LongSparseArray<>();
            this.k = longSparseArray;
            longSparseArray.clear();
        }
        if (this.l == null) {
            this.l = new LongSparseArray<>();
        }
        LongSparseArray<Long> r2 = d.b.i0.d1.k.b.o().r();
        if (0 != j) {
            Long l = r2.get(j);
            Long l2 = this.k.get(j);
            if (l == null) {
                longValue = (l2 != null && l2.longValue() < j2) ? l2.longValue() : j2;
            } else {
                longValue = l.longValue();
            }
            if (longValue > 0) {
                this.k.put(j, Long.valueOf(longValue));
            }
        }
        if (this.k != null && this.k.size() > 0) {
            for (int i = 0; i < this.k.size(); i++) {
                long keyAt = this.k.keyAt(i);
                Long l3 = r2.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.k.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.l.get(j) == null) {
                    this.l.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.l.get(j).longValue();
                    if (longValue2 <= j2) {
                        longValue2 = j2;
                    }
                    this.l.put(j, Long.valueOf(longValue2));
                }
            }
            int size = this.k.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.k.keyAt(i2);
                if (this.k.valueAt(i2).longValue() >= (this.l.get(keyAt2) != null ? this.l.get(keyAt2).longValue() : 0L)) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.k.remove(((Long) it.next()).longValue());
            }
        }
        if (this.k.size() == 0) {
            j();
            this.l.clear();
            return;
        }
        p(this.k, 1);
    }

    public synchronized void t() {
        v(3);
    }

    public synchronized void u() {
        v(2);
    }

    public final synchronized void v(int i) {
        this.n = true;
        this.f53925h = i;
        p(null, i);
    }

    public void w() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            z(socketGetMsgStratgy[0] * 1000);
            y(socketGetMsgStratgy[1] * 1000);
        }
    }

    public final synchronized void x() {
        if (System.currentTimeMillis() - this.f53924g < 180000) {
            return;
        }
        PushCountMessage pushCountMessage = new PushCountMessage();
        pushCountMessage.setPusherCount(this.f53923f);
        pushCountMessage.setUpFlowSize(d.b.b.e.r.h.j().p());
        pushCountMessage.setDownFlowSize(d.b.b.e.r.h.j().i());
        pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
        MessageManager.getInstance().sendMessage(pushCountMessage);
        this.f53924g = System.currentTimeMillis();
        this.f53923f = 0;
        d.b.b.e.r.h.j().d();
        d.b.b.e.r.h.j().e();
        TbadkCoreApplication.getInst().clearEnterForeCount();
    }

    public void y(int i) {
        if (i <= 0) {
            return;
        }
        this.f53918a = i;
    }

    public void z(int i) {
        if (i <= 0) {
            return;
        }
        this.f53919b = i;
    }
}
