package d.b.b.c.e.c;

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
import d.b.b.c.e.c.d;
import d.b.b.e.p.l;
import d.b.b.e.r.k;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class g extends d.b.b.c.e.a<SocketMessage, SocketMessageTask> implements d.b.b.c.e.c.k.a {

    /* renamed from: b  reason: collision with root package name */
    public d.a f41505b;

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<e> f41506c;

    /* renamed from: d  reason: collision with root package name */
    public final LinkedList<e> f41507d;

    /* renamed from: e  reason: collision with root package name */
    public final LinkedList<e> f41508e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.b.c.e.c.k.a f41509f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f41510g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.b.c.e.c.b f41511h;
    public long i;
    public int j;

    /* loaded from: classes.dex */
    public class a implements d.a {
        public a() {
        }

        @Override // d.b.b.c.e.c.d.a
        public void a(d.b bVar) {
            g.this.x(bVar);
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f41513a;

        static {
            int[] iArr = new int[SocketMessageTask.DupLicateMode.values().length];
            f41513a = iArr;
            try {
                iArr[SocketMessageTask.DupLicateMode.REMOVE_ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41513a[SocketMessageTask.DupLicateMode.REMOVE_WAITING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41513a[SocketMessageTask.DupLicateMode.REMOVE_ME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public g(MessageManager messageManager) {
        super(messageManager);
        this.f41505b = null;
        this.f41506c = new LinkedList<>();
        this.f41507d = new LinkedList<>();
        this.f41508e = new LinkedList<>();
        this.f41509f = null;
        this.f41510g = true;
        this.f41511h = null;
        this.i = 0L;
        this.j = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.f41505b = new a();
    }

    public void A(e eVar) {
        if (eVar == null) {
            return;
        }
        if (eVar.v()) {
            eVar.h();
            c.j(this.f41507d, this.f41506c, eVar);
            return;
        }
        c.n(eVar, this.f41507d);
    }

    public void B(e eVar) {
        if (eVar != null && eVar.i() && eVar.p() < eVar.l()) {
            c.j(this.f41506c, this.f41508e, eVar);
            d.b.b.c.e.c.b bVar = this.f41511h;
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
        c.n(eVar, this.f41506c);
        c.n(eVar, this.f41507d);
        c.n(eVar, this.f41508e);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.c.b
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
            c.h(eVar, this.f41507d);
            F();
        }
    }

    public final void F() {
        e f2 = c.f(this.f41507d);
        if (f2 == null) {
            return;
        }
        if (BdSocketLinkService.isClose()) {
            i.c("queue", f2.m(), 0, "sendNext", h.r, "");
            BdSocketLinkService.startService(false, "send message");
        } else if (!this.f41510g || f2.n() <= -3) {
            BdSocketLinkService.sendMessage(f2);
        }
    }

    public void G(d.b.b.c.e.c.k.a aVar) {
        this.f41509f = aVar;
    }

    public void H(d.b.b.c.e.c.b bVar) {
        this.f41511h = bVar;
    }

    public void I() {
        boolean z = this.f41510g;
        this.f41510g = false;
        i.a("queue", 0, 0, "unBlockMessageQueue", h.s, "Queue block has release");
        if (z) {
            F();
        }
    }

    @Override // d.b.b.c.e.c.k.a
    public boolean a(int i, String str) {
        d.b.b.c.e.c.k.a aVar = this.f41509f;
        if (aVar != null) {
            aVar.a(i, str);
        }
        d.b.b.c.e.c.b bVar = this.f41511h;
        if (bVar != null) {
            bVar.b();
        }
        if (l.C() && !c.a(this.f41508e) && !c.a(this.f41507d) && !c.a(this.f41506c) && BdSocketLinkService.isAvailable()) {
            c.b(this.f41506c);
            c.i(this.f41507d, this.f41508e);
            c.i(this.f41507d, this.f41506c);
            while (true) {
                e k = c.k(this.f41507d);
                if (k == null) {
                    break;
                }
                k.w();
                w(k, h.o, null);
            }
            if (c.q(this.f41507d) > 0) {
                i.a("queue", 0, 0, "onClose", h.u, "have retry message, MessageQueue:reconnect");
                BdSocketLinkService.startService(false, "have retry message");
                return true;
            }
            return false;
        }
        j();
        return false;
    }

    @Override // d.b.b.c.e.c.k.a
    public void b(d.b.b.e.r.c cVar) {
        F();
        d.b.b.c.e.c.k.a aVar = this.f41509f;
        if (aVar != null) {
            aVar.b(cVar);
        }
    }

    @Override // d.b.b.c.e.c.k.a
    public void c(String str) {
        d.b.b.c.e.c.k.a aVar = this.f41509f;
        if (aVar != null) {
            aVar.c(str);
        }
    }

    @Override // d.b.b.c.e.c.k.a
    public void d(k kVar) {
        byte[] bArr;
        if (kVar == null || (bArr = kVar.f42121a) == null) {
            return;
        }
        this.i = System.currentTimeMillis();
        try {
            d.b.b.c.e.c.j.c c2 = d.b.b.c.e.c.j.b.f().c(bArr);
            this.j = 0;
            int b2 = c2.f41531a.b();
            int h2 = c2.f41531a.h();
            i.a("queue", b2, h2, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
            e p = p(b2, h2);
            if (p != null) {
                p.m = kVar.f42122b;
                p.n = kVar.f42123c;
            }
            if (this.f41511h != null) {
                if (c2.f41531a.b() == this.f41511h.d() && c.i(this.f41507d, this.f41508e)) {
                    F();
                }
                this.f41511h.e();
            }
            if (h2 == 0 || (p != null && p.k() == b2)) {
                new d(c2, p, this.f41505b, h2).execute(new String[0]);
            } else if (p != null) {
                w(p, h.A, null);
            }
            d.b.b.c.e.c.k.a aVar = this.f41509f;
            if (aVar != null) {
                aVar.d(kVar);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
        } catch (CoderException unused) {
            int q = d.b.b.e.n.k.a.o().q("alert_protobuf", 2);
            int i = this.j + 1;
            this.j = i;
            if (i >= q) {
                BdStatisticsManager.getInstance().alert("alert_protobuf", "protbuf");
            }
            i.a("queue", 0, 0, "onBinaryMesssage", h.j, "onBinaryMesssage decodeHeader error");
        }
    }

    @Override // d.b.b.c.b
    public LinkedList<SocketMessage> e(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // d.b.b.c.e.c.k.a
    public void g(Map<String, String> map) {
        f.a().c(map);
        d.b.b.c.e.c.b bVar = this.f41511h;
        if (bVar != null) {
            bVar.e();
        }
        this.f41510g = true;
        i.a("queue", 0, 0, "onConnected", h.y, "Queue blocked");
        d.b.b.c.e.c.k.a aVar = this.f41509f;
        if (aVar != null) {
            aVar.g(map);
        }
    }

    @Override // d.b.b.c.b
    public void h(int i, BdUniqueId bdUniqueId) {
        c.m(this.f41506c, i, bdUniqueId);
        c.m(this.f41507d, i, bdUniqueId);
        c.m(this.f41508e, i, bdUniqueId);
    }

    public void j() {
        k(this.f41506c);
        k(this.f41507d);
        k(this.f41508e);
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
        this.f41484a.dispatchResponsedMessage(socketResponsedMessage);
    }

    public final boolean m(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            int i = b.f41513a[dupLicateMode.ordinal()];
            if (i == 1) {
                c.o(this.f41507d, cmd);
                c.o(this.f41506c, cmd);
                c.o(this.f41508e, cmd);
                return false;
            } else if (i == 2) {
                c.o(this.f41507d, cmd);
                return false;
            } else if (i != 3) {
                return false;
            } else {
                return c.e(this.f41507d, cmd) || c.e(this.f41506c, cmd) || c.e(this.f41508e, cmd);
            }
        }
        return false;
    }

    public LinkedList<SocketMessage> n(BdUniqueId bdUniqueId) {
        return null;
    }

    public boolean o(SocketMessage socketMessage) {
        if (socketMessage == null || !(socketMessage instanceof d.b.b.c.e.c.a)) {
            return false;
        }
        d.b.b.c.e.c.a aVar = (d.b.b.c.e.c.a) socketMessage;
        return c.d(this.f41507d, aVar, socketMessage.getCmd()) || c.d(this.f41506c, aVar, socketMessage.getCmd()) || c.d(this.f41508e, aVar, socketMessage.getCmd());
    }

    public final e p(int i, int i2) {
        if (i2 != 0) {
            e p = c.p(i2, this.f41506c);
            if (p == null && (p = c.p(i2, this.f41508e)) == null && (p = c.p(i2, this.f41507d)) == null) {
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

    public d.b.b.c.e.c.b r() {
        return this.f41511h;
    }

    public int s() {
        return BdAsyncTask.getTaskNum(d.e());
    }

    public int t(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), d.e());
    }

    public boolean u(int i, BdUniqueId bdUniqueId) {
        return c.c(this.f41507d, i, bdUniqueId) || c.c(this.f41506c, i, bdUniqueId) || c.c(this.f41508e, i, bdUniqueId);
    }

    public boolean v() {
        return BdSocketLinkService.isOpen() && !this.f41510g && BdSocketLinkService.isAvailable();
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
            t = (SocketMessageTask) this.f41484a.findTask(cmd);
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
            this.f41484a.dispatchResponsedMessage(socketResponsedMessage);
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
        e eVar = bVar.f41495b;
        if (eVar != null) {
            w(eVar, h.f41516c, null);
            return;
        }
        SocketResponsedMessage socketResponsedMessage = bVar.f41494a;
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
