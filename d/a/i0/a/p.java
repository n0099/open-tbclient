package d.a.i0.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class p {

    /* renamed from: d  reason: collision with root package name */
    public static p f47891d;

    /* renamed from: a  reason: collision with root package name */
    public d.a.i0.a.b f47892a;

    /* renamed from: b  reason: collision with root package name */
    public CustomMessageListener f47893b = new a(2001437);

    /* renamed from: c  reason: collision with root package name */
    public CustomMessageListener f47894c = new b(this, 2005016);

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (p.this.f47892a == null || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if ((data instanceof d.a.j0.d3.q0.e) && ((d.a.j0.d3.q0.e) data).f53304b) {
                p.this.e();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(p pVar, int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
            }
        }
    }

    public static p c() {
        if (f47891d == null) {
            synchronized (p.class) {
                if (f47891d == null) {
                    f47891d = new p();
                }
            }
        }
        return f47891d;
    }

    public void d(BdUniqueId bdUniqueId) {
        this.f47893b.setTag(bdUniqueId);
        this.f47894c.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f47893b);
        MessageManager.getInstance().registerListener(this.f47894c);
    }

    public final void e() {
        d.a.i0.a.b bVar = this.f47892a;
        if (bVar == null || bVar.d() == 0 || this.f47892a.q() == 0 || this.f47892a.x() != 9) {
            return;
        }
        try {
            String valueOf = String.valueOf(this.f47892a.d());
            String valueOf2 = String.valueOf(this.f47892a.q());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(valueOf, valueOf2);
            CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(0);
            completeTaskReqMsg.completeId = jSONObject.toString();
            JSONObject a2 = d.a.i0.a.b0.c.a(null, this.f47892a.d(), this.f47892a.q(), this.f47892a.E());
            if (a2 != null) {
                completeTaskReqMsg.setToken(a2.toString());
            }
            completeTaskReqMsg.setNetType(NetMessage.NetType.HTTP);
            MessageManager.getInstance().sendMessage(completeTaskReqMsg);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void f(d.a.i0.a.b bVar) {
        this.f47892a = bVar;
    }
}
