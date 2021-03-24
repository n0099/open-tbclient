package d.b.h0.a;

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
    public static p f49610d;

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.a.b f49611a;

    /* renamed from: b  reason: collision with root package name */
    public CustomMessageListener f49612b = new a(2001437);

    /* renamed from: c  reason: collision with root package name */
    public CustomMessageListener f49613c = new b(this, 2005016);

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (p.this.f49611a == null || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if ((data instanceof d.b.i0.c3.q0.e) && ((d.b.i0.c3.q0.e) data).f53594b) {
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
        if (f49610d == null) {
            synchronized (p.class) {
                if (f49610d == null) {
                    f49610d = new p();
                }
            }
        }
        return f49610d;
    }

    public void d(BdUniqueId bdUniqueId) {
        this.f49612b.setTag(bdUniqueId);
        this.f49613c.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f49612b);
        MessageManager.getInstance().registerListener(this.f49613c);
    }

    public final void e() {
        d.b.h0.a.b bVar = this.f49611a;
        if (bVar == null || bVar.d() == 0 || this.f49611a.q() == 0 || this.f49611a.x() != 9) {
            return;
        }
        try {
            String valueOf = String.valueOf(this.f49611a.d());
            String valueOf2 = String.valueOf(this.f49611a.q());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(valueOf, valueOf2);
            CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(0);
            completeTaskReqMsg.completeId = jSONObject.toString();
            JSONObject a2 = d.b.h0.a.b0.c.a(null, this.f49611a.d(), this.f49611a.q(), this.f49611a.E());
            if (a2 != null) {
                completeTaskReqMsg.setToken(a2.toString());
            }
            completeTaskReqMsg.setNetType(NetMessage.NetType.HTTP);
            MessageManager.getInstance().sendMessage(completeTaskReqMsg);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void f(d.b.h0.a.b bVar) {
        this.f49611a = bVar;
    }
}
