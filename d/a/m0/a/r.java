package d.a.m0.a;

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
    public static r f52428d;

    /* renamed from: a  reason: collision with root package name */
    public c f52429a;

    /* renamed from: b  reason: collision with root package name */
    public CustomMessageListener f52430b = new a(2001437);

    /* renamed from: c  reason: collision with root package name */
    public CustomMessageListener f52431c = new b(this, 2005016);

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (r.this.f52429a == null || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if ((data instanceof d.a.n0.e3.q0.e) && ((d.a.n0.e3.q0.e) data).f57913b) {
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
        if (f52428d == null) {
            synchronized (r.class) {
                if (f52428d == null) {
                    f52428d = new r();
                }
            }
        }
        return f52428d;
    }

    public void d(BdUniqueId bdUniqueId) {
        this.f52430b.setTag(bdUniqueId);
        this.f52431c.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f52430b);
        MessageManager.getInstance().registerListener(this.f52431c);
    }

    public final void e() {
        c cVar = this.f52429a;
        if (cVar == null || cVar.d() == 0 || this.f52429a.q() == 0 || this.f52429a.x() != 9) {
            return;
        }
        try {
            String valueOf = String.valueOf(this.f52429a.d());
            String valueOf2 = String.valueOf(this.f52429a.q());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(valueOf, valueOf2);
            CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(0);
            completeTaskReqMsg.completeId = jSONObject.toString();
            JSONObject a2 = d.a.m0.a.e0.c.a(null, this.f52429a.d(), this.f52429a.q(), this.f52429a.E());
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
        this.f52429a = cVar;
    }
}
