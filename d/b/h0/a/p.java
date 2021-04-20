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
    public static p f50003d;

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.a.b f50004a;

    /* renamed from: b  reason: collision with root package name */
    public CustomMessageListener f50005b = new a(2001437);

    /* renamed from: c  reason: collision with root package name */
    public CustomMessageListener f50006c = new b(this, 2005016);

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (p.this.f50004a == null || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if ((data instanceof d.b.i0.d3.q0.e) && ((d.b.i0.d3.q0.e) data).f55039b) {
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
        if (f50003d == null) {
            synchronized (p.class) {
                if (f50003d == null) {
                    f50003d = new p();
                }
            }
        }
        return f50003d;
    }

    public void d(BdUniqueId bdUniqueId) {
        this.f50005b.setTag(bdUniqueId);
        this.f50006c.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f50005b);
        MessageManager.getInstance().registerListener(this.f50006c);
    }

    public final void e() {
        d.b.h0.a.b bVar = this.f50004a;
        if (bVar == null || bVar.d() == 0 || this.f50004a.q() == 0 || this.f50004a.x() != 9) {
            return;
        }
        try {
            String valueOf = String.valueOf(this.f50004a.d());
            String valueOf2 = String.valueOf(this.f50004a.q());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(valueOf, valueOf2);
            CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(0);
            completeTaskReqMsg.completeId = jSONObject.toString();
            JSONObject a2 = d.b.h0.a.b0.c.a(null, this.f50004a.d(), this.f50004a.q(), this.f50004a.E());
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
        this.f50004a = bVar;
    }
}
