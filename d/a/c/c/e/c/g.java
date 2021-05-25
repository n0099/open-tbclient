package d.a.c.c.e.c;

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
import d.a.c.c.e.c.d;
import d.a.c.e.p.l;
import d.a.c.e.r.k;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class g extends d.a.c.c.e.a<SocketMessage, SocketMessageTask> implements d.a.c.c.e.c.k.a {

    /* renamed from: b  reason: collision with root package name */
    public d.a f38338b;

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<e> f38339c;

    /* renamed from: d  reason: collision with root package name */
    public final LinkedList<e> f38340d;

    /* renamed from: e  reason: collision with root package name */
    public final LinkedList<e> f38341e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.c.c.e.c.k.a f38342f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f38343g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.c.e.c.b f38344h;

    /* renamed from: i  reason: collision with root package name */
    public long f38345i;
    public int j;

    /* loaded from: classes.dex */
    public class a implements d.a {
        public a() {
        }

        @Override // d.a.c.c.e.c.d.a
        public void a(d.b bVar) {
            g.this.x(bVar);
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f38347a;

        static {
            int[] iArr = new int[SocketMessageTask.DupLicateMode.values().length];
            f38347a = iArr;
            try {
                iArr[SocketMessageTask.DupLicateMode.REMOVE_ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f38347a[SocketMessageTask.DupLicateMode.REMOVE_WAITING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f38347a[SocketMessageTask.DupLicateMode.REMOVE_ME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public g(MessageManager messageManager) {
        super(messageManager);
        this.f38338b = null;
        this.f38339c = new LinkedList<>();
        this.f38340d = new LinkedList<>();
        this.f38341e = new LinkedList<>();
        this.f38342f = null;
        this.f38343g = true;
        this.f38344h = null;
        this.f38345i = 0L;
        this.j = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.f38338b = new a();
    }

    public void A(e eVar) {
        if (eVar == null) {
            return;
        }
        if (eVar.v()) {
            eVar.h();
            c.j(this.f38340d, this.f38339c, eVar);
            return;
        }
        c.n(eVar, this.f38340d);
    }

    public void B(e eVar) {
        if (eVar != null && eVar.i() && eVar.p() < eVar.l()) {
            c.j(this.f38339c, this.f38341e, eVar);
            d.a.c.c.e.c.b bVar = this.f38344h;
            if (bVar != null) {
                bVar.b(true, "timeout seq = " + eVar.q());
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
        c.n(eVar, this.f38339c);
        c.n(eVar, this.f38340d);
        c.n(eVar, this.f38341e);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.c.b
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
            c.h(eVar, this.f38340d);
            F();
        }
    }

    public final void F() {
        e f2 = c.f(this.f38340d);
        if (f2 == null) {
            return;
        }
        if (BdSocketLinkService.isClose()) {
            i.c("queue", f2.m(), 0, "sendNext", h.r, "");
            BdSocketLinkService.startService(false, "send message");
        } else if (!this.f38343g || f2.n() <= -3) {
            BdSocketLinkService.sendMessage(f2);
        }
    }

    public void G(d.a.c.c.e.c.k.a aVar) {
        this.f38342f = aVar;
    }

    public void H(d.a.c.c.e.c.b bVar) {
        this.f38344h = bVar;
    }

    public void I() {
        boolean z = this.f38343g;
        this.f38343g = false;
        i.a("queue", 0, 0, "unBlockMessageQueue", h.s, "Queue block has release");
        if (z) {
            F();
        }
    }

    @Override // d.a.c.c.e.c.k.a
    public void a(String str) {
        d.a.c.c.e.c.k.a aVar = this.f38342f;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    @Override // d.a.c.c.e.c.k.a
    public boolean b(int i2, String str) {
        d.a.c.c.e.c.k.a aVar = this.f38342f;
        if (aVar != null) {
            aVar.b(i2, str);
        }
        d.a.c.c.e.c.b bVar = this.f38344h;
        if (bVar != null) {
            bVar.a();
        }
        if (l.D() && !c.a(this.f38341e) && !c.a(this.f38340d) && !c.a(this.f38339c) && BdSocketLinkService.isAvailable()) {
            c.b(this.f38339c);
            c.i(this.f38340d, this.f38341e);
            c.i(this.f38340d, this.f38339c);
            while (true) {
                e k = c.k(this.f38340d);
                if (k == null) {
                    break;
                }
                k.w();
                w(k, h.o, null);
            }
            if (c.q(this.f38340d) > 0) {
                i.a("queue", 0, 0, "onClose", h.u, "have retry message, MessageQueue:reconnect");
                BdSocketLinkService.startService(false, "have retry message");
                return true;
            }
            return false;
        }
        j();
        return false;
    }

    @Override // d.a.c.c.e.c.k.a
    public void c(d.a.c.e.r.c cVar) {
        F();
        d.a.c.c.e.c.k.a aVar = this.f38342f;
        if (aVar != null) {
            aVar.c(cVar);
        }
    }

    @Override // d.a.c.c.e.c.k.a
    public void d(k kVar) {
        byte[] bArr;
        if (kVar == null || (bArr = kVar.f38984a) == null) {
            return;
        }
        this.f38345i = System.currentTimeMillis();
        try {
            d.a.c.c.e.c.j.c c2 = d.a.c.c.e.c.j.b.f().c(bArr);
            this.j = 0;
            int b2 = c2.f38367a.b();
            int h2 = c2.f38367a.h();
            i.a("queue", b2, h2, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
            e p = p(b2, h2);
            if (p != null) {
                p.m = kVar.f38985b;
                p.n = kVar.f38986c;
            }
            if (this.f38344h != null) {
                if (c2.f38367a.b() == this.f38344h.c() && c.i(this.f38340d, this.f38341e)) {
                    F();
                }
                this.f38344h.e();
            }
            if (h2 == 0 || (p != null && p.k() == b2)) {
                new d(c2, p, this.f38338b, h2).execute(new String[0]);
            } else if (p != null) {
                w(p, h.A, null);
            }
            d.a.c.c.e.c.k.a aVar = this.f38342f;
            if (aVar != null) {
                aVar.d(kVar);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
        } catch (CoderException unused) {
            int q = d.a.c.e.n.k.a.o().q("alert_protobuf", 2);
            int i2 = this.j + 1;
            this.j = i2;
            if (i2 >= q) {
                BdStatisticsManager.getInstance().alert("alert_protobuf", "protbuf");
            }
            i.a("queue", 0, 0, "onBinaryMesssage", h.j, "onBinaryMesssage decodeHeader error");
        }
    }

    @Override // d.a.c.c.b
    public LinkedList<SocketMessage> e(int i2, BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // d.a.c.c.e.c.k.a
    public void g(Map<String, String> map) {
        f.a().c(map);
        d.a.c.c.e.c.b bVar = this.f38344h;
        if (bVar != null) {
            bVar.e();
        }
        this.f38343g = true;
        i.a("queue", 0, 0, "onConnected", h.y, "Queue blocked");
        d.a.c.c.e.c.k.a aVar = this.f38342f;
        if (aVar != null) {
            aVar.g(map);
        }
    }

    @Override // d.a.c.c.b
    public void h(int i2, BdUniqueId bdUniqueId) {
        c.m(this.f38339c, i2, bdUniqueId);
        c.m(this.f38340d, i2, bdUniqueId);
        c.m(this.f38341e, i2, bdUniqueId);
    }

    public void j() {
        k(this.f38339c);
        k(this.f38340d);
        k(this.f38341e);
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
        this.f38316a.dispatchResponsedMessage(socketResponsedMessage);
    }

    public final boolean m(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            int i2 = b.f38347a[dupLicateMode.ordinal()];
            if (i2 == 1) {
                c.o(this.f38340d, cmd);
                c.o(this.f38339c, cmd);
                c.o(this.f38341e, cmd);
                return false;
            } else if (i2 == 2) {
                c.o(this.f38340d, cmd);
                return false;
            } else if (i2 != 3) {
                return false;
            } else {
                return c.e(this.f38340d, cmd) || c.e(this.f38339c, cmd) || c.e(this.f38341e, cmd);
            }
        }
        return false;
    }

    public LinkedList<SocketMessage> n(BdUniqueId bdUniqueId) {
        return null;
    }

    public boolean o(SocketMessage socketMessage) {
        if (socketMessage == null || !(socketMessage instanceof d.a.c.c.e.c.a)) {
            return false;
        }
        d.a.c.c.e.c.a aVar = (d.a.c.c.e.c.a) socketMessage;
        return c.d(this.f38340d, aVar, socketMessage.getCmd()) || c.d(this.f38339c, aVar, socketMessage.getCmd()) || c.d(this.f38341e, aVar, socketMessage.getCmd());
    }

    public final e p(int i2, int i3) {
        if (i3 != 0) {
            e p = c.p(i3, this.f38339c);
            if (p == null && (p = c.p(i3, this.f38341e)) == null && (p = c.p(i3, this.f38340d)) == null) {
                i.a("queue", i2, i3, "findSenderData", h.w, "original message removed , responsedMessage not dispatchMessage");
                return p;
            }
            i.a("queue", i2, i3, "findSenderData", h.v, "received ack message");
            return p;
        }
        return null;
    }

    public long q() {
        return this.f38345i;
    }

    public d.a.c.c.e.c.b r() {
        return this.f38344h;
    }

    public int s() {
        return BdAsyncTask.getTaskNum(d.e());
    }

    public int t(int i2) {
        return BdAsyncTask.getTaskNum(String.valueOf(i2), d.e());
    }

    public boolean u(int i2, BdUniqueId bdUniqueId) {
        return c.c(this.f38340d, i2, bdUniqueId) || c.c(this.f38339c, i2, bdUniqueId) || c.c(this.f38341e, i2, bdUniqueId);
    }

    public boolean v() {
        return BdSocketLinkService.isOpen() && !this.f38343g && BdSocketLinkService.isAvailable();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0094 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void w(e eVar, int i2, String str) {
        SocketResponsedMessage socketResponsedMessage;
        if (eVar == null || eVar.m() == null) {
            return;
        }
        int cmd = eVar.m().getCmd();
        int q = eVar.q();
        i.c("queue", eVar.m(), q, "onMessageSendFail", i2, str + " retryTime-" + eVar.p());
        SocketMessageTask t = eVar != null ? eVar.t() : null;
        if (t == null) {
            t = (SocketMessageTask) this.f38316a.findTask(cmd);
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
            socketResponsedMessage.setError(i2);
            if (str == null) {
                socketResponsedMessage.setErrorString(h.i(i2));
            } else {
                socketResponsedMessage.setErrorString(str);
            }
            socketResponsedMessage.setOrginalMessage(eVar.m());
            i.c("queue", eVar.m(), q, "onMessageSendFail", i2, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
            this.f38316a.dispatchResponsedMessage(socketResponsedMessage);
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
        e eVar = bVar.f38327b;
        if (eVar != null) {
            w(eVar, h.f38350c, null);
            return;
        }
        SocketResponsedMessage socketResponsedMessage = bVar.f38326a;
        if (socketResponsedMessage == null) {
            return;
        }
        i.c("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
        l(socketResponsedMessage);
    }

    public void y(int i2, e eVar) {
        int i3;
        if (i2 == 2) {
            if (eVar.r() != null) {
                i3 = eVar.r().getErrorCode();
            } else {
                i3 = h.f38356i;
            }
        } else {
            i3 = h.n;
        }
        String i4 = h.i(i3);
        D(eVar);
        w(eVar, i3, i4);
    }

    public void z(e eVar) {
    }
}
