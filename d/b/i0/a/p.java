package d.b.i0.a;

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
    public static p f50339d;

    /* renamed from: a  reason: collision with root package name */
    public d.b.i0.a.b f50340a;

    /* renamed from: b  reason: collision with root package name */
    public CustomMessageListener f50341b = new a(2001437);

    /* renamed from: c  reason: collision with root package name */
    public CustomMessageListener f50342c = new b(this, 2005016);

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (p.this.f50340a == null || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if ((data instanceof d.b.j0.d3.q0.e) && ((d.b.j0.d3.q0.e) data).f55460b) {
                p.this.e();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(p pVar, int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
            }
        }
    }

    public static p c() {
        if (f50339d == null) {
            synchronized (p.class) {
                if (f50339d == null) {
                    f50339d = new p();
                }
            }
        }
        return f50339d;
    }

    public void d(BdUniqueId bdUniqueId) {
        this.f50341b.setTag(bdUniqueId);
        this.f50342c.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f50341b);
        MessageManager.getInstance().registerListener(this.f50342c);
    }

    public final void e() {
        d.b.i0.a.b bVar = this.f50340a;
        if (bVar == null || bVar.d() == 0 || this.f50340a.q() == 0 || this.f50340a.x() != 9) {
            return;
        }
        try {
            String valueOf = String.valueOf(this.f50340a.d());
            String valueOf2 = String.valueOf(this.f50340a.q());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(valueOf, valueOf2);
            CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(0);
            completeTaskReqMsg.completeId = jSONObject.toString();
            JSONObject a2 = d.b.i0.a.b0.c.a(null, this.f50340a.d(), this.f50340a.q(), this.f50340a.E());
            if (a2 != null) {
                completeTaskReqMsg.setToken(a2.toString());
            }
            completeTaskReqMsg.setNetType(NetMessage.NetType.HTTP);
            MessageManager.getInstance().sendMessage(completeTaskReqMsg);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void f(d.b.i0.a.b bVar) {
        this.f50340a = bVar;
    }
}
