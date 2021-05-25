package d.a.m0.a;

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
    public static q f48752d;

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.a.b f48753a;

    /* renamed from: b  reason: collision with root package name */
    public CustomMessageListener f48754b = new a(2001437);

    /* renamed from: c  reason: collision with root package name */
    public CustomMessageListener f48755c = new b(this, 2005016);

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (q.this.f48753a == null || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if ((data instanceof d.a.n0.e3.q0.e) && ((d.a.n0.e3.q0.e) data).f54224b) {
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
        if (f48752d == null) {
            synchronized (q.class) {
                if (f48752d == null) {
                    f48752d = new q();
                }
            }
        }
        return f48752d;
    }

    public void d(BdUniqueId bdUniqueId) {
        this.f48754b.setTag(bdUniqueId);
        this.f48755c.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f48754b);
        MessageManager.getInstance().registerListener(this.f48755c);
    }

    public final void e() {
        d.a.m0.a.b bVar = this.f48753a;
        if (bVar == null || bVar.d() == 0 || this.f48753a.q() == 0 || this.f48753a.x() != 9) {
            return;
        }
        try {
            String valueOf = String.valueOf(this.f48753a.d());
            String valueOf2 = String.valueOf(this.f48753a.q());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(valueOf, valueOf2);
            CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(0);
            completeTaskReqMsg.completeId = jSONObject.toString();
            JSONObject a2 = d.a.m0.a.d0.c.a(null, this.f48753a.d(), this.f48753a.q(), this.f48753a.E());
            if (a2 != null) {
                completeTaskReqMsg.setToken(a2.toString());
            }
            completeTaskReqMsg.setNetType(NetMessage.NetType.HTTP);
            MessageManager.getInstance().sendMessage(completeTaskReqMsg);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void f(d.a.m0.a.b bVar) {
        this.f48753a = bVar;
    }
}
