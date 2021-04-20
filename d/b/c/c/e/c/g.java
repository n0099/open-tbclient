package d.b.c.c.e.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import d.b.c.c.e.c.d;
import d.b.c.e.p.l;
import d.b.c.e.r.k;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class g extends d.b.c.c.e.a<SocketMessage, SocketMessageTask> implements d.b.c.c.e.c.k.a {

    /* renamed from: b  reason: collision with root package name */
    public d.a f42003b;

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<e> f42004c;

    /* renamed from: d  reason: collision with root package name */
    public final LinkedList<e> f42005d;

    /* renamed from: e  reason: collision with root package name */
    public final LinkedList<e> f42006e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.c.c.e.c.k.a f42007f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f42008g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.c.c.e.c.b f42009h;
    public long i;
    public int j;

    /* loaded from: classes.dex */
    public class a implements d.a {
        public a() {
        }

        @Override // d.b.c.c.e.c.d.a
        public void a(d.b bVar) {
            g.this.x(bVar);
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f42011a;

        static {
            int[] iArr = new int[SocketMessageTask.DupLicateMode.values().length];
            f42011a = iArr;
            try {
                iArr[SocketMessageTask.DupLicateMode.REMOVE_ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f42011a[SocketMessageTask.DupLicateMode.REMOVE_WAITING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f42011a[SocketMessageTask.DupLicateMode.REMOVE_ME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public g(MessageManager messageManager) {
        super(messageManager);
        this.f42003b = null;
        this.f42004c = new LinkedList<>();
        this.f42005d = new LinkedList<>();
        this.f42006e = new LinkedList<>();
        this.f42007f = null;
        this.f42008g = true;
        this.f42009h = null;
        this.i = 0L;
        this.j = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.f42003b = new a();
    }

    public void A(e eVar) {
        if (eVar == null) {
            return;
        }
        if (eVar.v()) {
            eVar.h();
            c.j(this.f42005d, this.f42004c, eVar);
            return;
        }
        c.n(eVar, this.f42005d);
    }

    public void B(e eVar) {
        if (eVar != null && eVar.i() && eVar.p() < eVar.l()) {
            c.j(this.f42004c, this.f42006e, eVar);
            d.b.c.c.e.c.b bVar = this.f42009h;
            if (bVar != null) {
                bVar.c(true, "timeout seq = " + eVar.q());
            }
            i.c("queue", eVar.m(), eVar.q(), "onSendTimeOut", h.t, String.valueOf(eVar.p()));
            return;
        }
        D(eVar);
        w(eVar, h.m, null);
        F();
    }

    public void C(BdUniqueId bdUniqueId) {
        h(0, bdUniqueId);
    }

    public final void D(e eVar) {
        if (eVar == null) {
            return;
        }
        eVar.w();
        c.n(eVar, this.f42004c);
        c.n(eVar, this.f42005d);
        c.n(eVar, this.f42006e);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.c.b
    /* renamed from: E */
    public void f(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        l.d();
        if (socketMessage == null || socketMessageTask == null) {
            return;
        }
        if (m(socketMessage, socketMessageTask.a())) {
            i.c("queue", socketMessage, 0, "sendMessage", h.q, "duplicate message be removed");
            return;
        }
        e eVar = new e(socketMessage, socketMessageTask, this);
        if (BdSocketLinkService.hasAbsoluteClose()) {
            i.c("queue", socketMessage, 0, "sendMessage", h.z, "user manual close socket");
            eVar.a(h.z);
        } else if (!BdSocketLinkService.isAvailable()) {
            i.c("queue", socketMessage, 0, "sendMessage", h.p, "isManualBlock message be removed");
            eVar.a(h.p);
        } else {
            i.c("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
            c.h(eVar, this.f42005d);
            F();
        }
    }

    public final void F() {
        e f2 = c.f(this.f42005d);
        if (f2 == null) {
            return;
        }
        if (BdSocketLinkService.isClose()) {
            i.c("queue", f2.m(), 0, "sendNext", h.r, "");
            BdSocketLinkService.startService(false, "send message");
        } else if (!this.f42008g || f2.n() <= -3) {
            BdSocketLinkService.sendMessage(f2);
        }
    }

    public void G(d.b.c.c.e.c.k.a aVar) {
        this.f42007f = aVar;
    }

    public void H(d.b.c.c.e.c.b bVar) {
        this.f42009h = bVar;
    }

    public void I() {
        boolean z = this.f42008g;
        this.f42008g = false;
        i.a("queue", 0, 0, "unBlockMessageQueue", h.s, "Queue block has release");
        if (z) {
            F();
        }
    }

    @Override // d.b.c.c.e.c.k.a
    public boolean a(int i, String str) {
        d.b.c.c.e.c.k.a aVar = this.f42007f;
        if (aVar != null) {
            aVar.a(i, str);
        }
        d.b.c.c.e.c.b bVar = this.f42009h;
        if (bVar != null) {
            bVar.b();
        }
        if (l.C() && !c.a(this.f42006e) && !c.a(this.f42005d) && !c.a(this.f42004c) && BdSocketLinkService.isAvailable()) {
            c.b(this.f42004c);
            c.i(this.f42005d, this.f42006e);
            c.i(this.f42005d, this.f42004c);
            while (true) {
                e k = c.k(this.f42005d);
                if (k == null) {
                    break;
                }
                k.w();
                w(k, h.o, null);
            }
            if (c.q(this.f42005d) > 0) {
                i.a("queue", 0, 0, "onClose", h.u, "have retry message, MessageQueue:reconnect");
                BdSocketLinkService.startService(false, "have retry message");
                return true;
            }
            return false;
        }
        j();
        return false;
    }

    @Override // d.b.c.c.e.c.k.a
    public void b(d.b.c.e.r.c cVar) {
        F();
        d.b.c.c.e.c.k.a aVar = this.f42007f;
        if (aVar != null) {
            aVar.b(cVar);
        }
    }

    @Override // d.b.c.c.e.c.k.a
    public void c(String str) {
        d.b.c.c.e.c.k.a aVar = this.f42007f;
        if (aVar != null) {
            aVar.c(str);
        }
    }

    @Override // d.b.c.c.e.c.k.a
    public void d(k kVar) {
        byte[] bArr;
        if (kVar == null || (bArr = kVar.f42619a) == null) {
            return;
        }
        this.i = System.currentTimeMillis();
        try {
            d.b.c.c.e.c.j.c c2 = d.b.c.c.e.c.j.b.f().c(bArr);
            this.j = 0;
            int b2 = c2.f42029a.b();
            int h2 = c2.f42029a.h();
            i.a("queue", b2, h2, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
            e p = p(b2, h2);
            if (p != null) {
                p.m = kVar.f42620b;
                p.n = kVar.f42621c;
            }
            if (this.f42009h != null) {
                if (c2.f42029a.b() == this.f42009h.d() && c.i(this.f42005d, this.f42006e)) {
                    F();
                }
                this.f42009h.e();
            }
            if (h2 == 0 || (p != null && p.k() == b2)) {
                new d(c2, p, this.f42003b, h2).execute(new String[0]);
            } else if (p != null) {
                w(p, h.A, null);
            }
            d.b.c.c.e.c.k.a aVar = this.f42007f;
            if (aVar != null) {
                aVar.d(kVar);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
        } catch (CoderException unused) {
            int q = d.b.c.e.n.k.a.o().q("alert_protobuf", 2);
            int i = this.j + 1;
            this.j = i;
            if (i >= q) {
                BdStatisticsManager.getInstance().alert("alert_protobuf", "protbuf");
            }
            i.a("queue", 0, 0, "onBinaryMesssage", h.j, "onBinaryMesssage decodeHeader error");
        }
    }

    @Override // d.b.c.c.b
    public LinkedList<SocketMessage> e(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // d.b.c.c.e.c.k.a
    public void g(Map<String, String> map) {
        f.a().c(map);
        d.b.c.c.e.c.b bVar = this.f42009h;
        if (bVar != null) {
            bVar.e();
        }
        this.f42008g = true;
        i.a("queue", 0, 0, "onConnected", h.y, "Queue blocked");
        d.b.c.c.e.c.k.a aVar = this.f42007f;
        if (aVar != null) {
            aVar.g(map);
        }
    }

    @Override // d.b.c.c.b
    public void h(int i, BdUniqueId bdUniqueId) {
        c.m(this.f42004c, i, bdUniqueId);
        c.m(this.f42005d, i, bdUniqueId);
        c.m(this.f42006e, i, bdUniqueId);
    }

    public void j() {
        k(this.f42004c);
        k(this.f42005d);
        k(this.f42006e);
    }

    public final void k(LinkedList<e> linkedList) {
        while (true) {
            e l = c.l(linkedList);
            if (l == null) {
                return;
            }
            l.w();
            w(l, h.o, null);
        }
    }

    public final void l(SocketResponsedMessage socketResponsedMessage) {
        this.f41982a.dispatchResponsedMessage(socketResponsedMessage);
    }

    public final boolean m(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            int i = b.f42011a[dupLicateMode.ordinal()];
            if (i == 1) {
                c.o(this.f42005d, cmd);
                c.o(this.f42004c, cmd);
                c.o(this.f42006e, cmd);
                return false;
            } else if (i == 2) {
                c.o(this.f42005d, cmd);
                return false;
            } else if (i != 3) {
                return false;
            } else {
                return c.e(this.f42005d, cmd) || c.e(this.f42004c, cmd) || c.e(this.f42006e, cmd);
            }
        }
        return false;
    }

    public LinkedList<SocketMessage> n(BdUniqueId bdUniqueId) {
        return null;
    }

    public boolean o(SocketMessage socketMessage) {
        if (socketMessage == null || !(socketMessage instanceof d.b.c.c.e.c.a)) {
            return false;
        }
        d.b.c.c.e.c.a aVar = (d.b.c.c.e.c.a) socketMessage;
        return c.d(this.f42005d, aVar, socketMessage.getCmd()) || c.d(this.f42004c, aVar, socketMessage.getCmd()) || c.d(this.f42006e, aVar, socketMessage.getCmd());
    }

    public final e p(int i, int i2) {
        if (i2 != 0) {
            e p = c.p(i2, this.f42004c);
            if (p == null && (p = c.p(i2, this.f42006e)) == null && (p = c.p(i2, this.f42005d)) == null) {
                i.a("queue", i, i2, "findSenderData", h.w, "original message removed , responsedMessage not dispatchMessage");
                return p;
            }
            i.a("queue", i, i2, "findSenderData", h.v, "received ack message");
            return p;
        }
        return null;
    }

    public long q() {
        return this.i;
    }

    public d.b.c.c.e.c.b r() {
        return this.f42009h;
    }

    public int s() {
        return BdAsyncTask.getTaskNum(d.e());
    }

    public int t(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), d.e());
    }

    public boolean u(int i, BdUniqueId bdUniqueId) {
        return c.c(this.f42005d, i, bdUniqueId) || c.c(this.f42004c, i, bdUniqueId) || c.c(this.f42006e, i, bdUniqueId);
    }

    public boolean v() {
        return BdSocketLinkService.isOpen() && !this.f42008g && BdSocketLinkService.isAvailable();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0094 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void w(e eVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage;
        if (eVar == null || eVar.m() == null) {
            return;
        }
        int cmd = eVar.m().getCmd();
        int q = eVar.q();
        i.c("queue", eVar.m(), q, "onMessageSendFail", i, str + " retryTime-" + eVar.p());
        SocketMessageTask t = eVar != null ? eVar.t() : null;
        if (t == null) {
            t = (SocketMessageTask) this.f41982a.findTask(cmd);
        }
        if (t != null && t.getResponsedClass() != null) {
            try {
                socketResponsedMessage = t.getResponsedClass().newInstance();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                try {
                    socketResponsedMessage = t.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(cmd));
                } catch (Exception e3) {
                    BdLog.e(e3.getMessage());
                }
            }
            if (socketResponsedMessage != null) {
                return;
            }
            socketResponsedMessage.setError(i);
            if (str == null) {
                socketResponsedMessage.setErrorString(h.i(i));
            } else {
                socketResponsedMessage.setErrorString(str);
            }
            socketResponsedMessage.setOrginalMessage(eVar.m());
            i.c("queue", eVar.m(), q, "onMessageSendFail", i, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
            this.f41982a.dispatchResponsedMessage(socketResponsedMessage);
            return;
        }
        socketResponsedMessage = null;
        if (socketResponsedMessage != null) {
        }
    }

    public final void x(d.b bVar) {
        if (bVar == null) {
            return;
        }
        e eVar = bVar.f41993b;
        if (eVar != null) {
            w(eVar, h.f42014c, null);
            return;
        }
        SocketResponsedMessage socketResponsedMessage = bVar.f41992a;
        if (socketResponsedMessage == null) {
            return;
        }
        i.c("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
        l(socketResponsedMessage);
    }

    public void y(int i, e eVar) {
        int i2;
        if (i == 2) {
            if (eVar.r() != null) {
                i2 = eVar.r().getErrorCode();
            } else {
                i2 = h.i;
            }
        } else {
            i2 = h.n;
        }
        String i3 = h.i(i2);
        D(eVar);
        w(eVar, i2, i3);
    }

    public void z(e eVar) {
    }
}
