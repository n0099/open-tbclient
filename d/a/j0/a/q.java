package d.a.j0.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class q {

    /* renamed from: d  reason: collision with root package name */
    public static q f48730d;

    /* renamed from: a  reason: collision with root package name */
    public d.a.j0.a.b f48731a;

    /* renamed from: b  reason: collision with root package name */
    public CustomMessageListener f48732b = new a(2001437);

    /* renamed from: c  reason: collision with root package name */
    public CustomMessageListener f48733c = new b(this, 2005016);

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (q.this.f48731a == null || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if ((data instanceof d.a.k0.d3.q0.e) && ((d.a.k0.d3.q0.e) data).f54011b) {
                q.this.e();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(q qVar, int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
            }
        }
    }

    public static q c() {
        if (f48730d == null) {
            synchronized (q.class) {
                if (f48730d == null) {
                    f48730d = new q();
                }
            }
        }
        return f48730d;
    }

    public void d(BdUniqueId bdUniqueId) {
        this.f48732b.setTag(bdUniqueId);
        this.f48733c.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f48732b);
        MessageManager.getInstance().registerListener(this.f48733c);
    }

    public final void e() {
        d.a.j0.a.b bVar = this.f48731a;
        if (bVar == null || bVar.d() == 0 || this.f48731a.q() == 0 || this.f48731a.x() != 9) {
            return;
        }
        try {
            String valueOf = String.valueOf(this.f48731a.d());
            String valueOf2 = String.valueOf(this.f48731a.q());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(valueOf, valueOf2);
            CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(0);
            completeTaskReqMsg.completeId = jSONObject.toString();
            JSONObject a2 = d.a.j0.a.d0.c.a(null, this.f48731a.d(), this.f48731a.q(), this.f48731a.E());
            if (a2 != null) {
                completeTaskReqMsg.setToken(a2.toString());
            }
            completeTaskReqMsg.setNetType(NetMessage.NetType.HTTP);
            MessageManager.getInstance().sendMessage(completeTaskReqMsg);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void f(d.a.j0.a.b bVar) {
        this.f48731a = bVar;
    }
}
