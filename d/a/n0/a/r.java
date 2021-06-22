package d.a.n0.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class r {

    /* renamed from: d  reason: collision with root package name */
    public static r f52535d;

    /* renamed from: a  reason: collision with root package name */
    public c f52536a;

    /* renamed from: b  reason: collision with root package name */
    public CustomMessageListener f52537b = new a(2001437);

    /* renamed from: c  reason: collision with root package name */
    public CustomMessageListener f52538c = new b(this, 2005016);

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (r.this.f52536a == null || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if ((data instanceof d.a.o0.e3.q0.e) && ((d.a.o0.e3.q0.e) data).f58038b) {
                r.this.e();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(r rVar, int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
            }
        }
    }

    public static r c() {
        if (f52535d == null) {
            synchronized (r.class) {
                if (f52535d == null) {
                    f52535d = new r();
                }
            }
        }
        return f52535d;
    }

    public void d(BdUniqueId bdUniqueId) {
        this.f52537b.setTag(bdUniqueId);
        this.f52538c.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f52537b);
        MessageManager.getInstance().registerListener(this.f52538c);
    }

    public final void e() {
        c cVar = this.f52536a;
        if (cVar == null || cVar.d() == 0 || this.f52536a.q() == 0 || this.f52536a.x() != 9) {
            return;
        }
        try {
            String valueOf = String.valueOf(this.f52536a.d());
            String valueOf2 = String.valueOf(this.f52536a.q());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(valueOf, valueOf2);
            CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(0);
            completeTaskReqMsg.completeId = jSONObject.toString();
            JSONObject a2 = d.a.n0.a.e0.c.a(null, this.f52536a.d(), this.f52536a.q(), this.f52536a.E());
            if (a2 != null) {
                completeTaskReqMsg.setToken(a2.toString());
            }
            completeTaskReqMsg.setNetType(NetMessage.NetType.HTTP);
            MessageManager.getInstance().sendMessage(completeTaskReqMsg);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void f(c cVar) {
        this.f52536a = cVar;
    }
}
