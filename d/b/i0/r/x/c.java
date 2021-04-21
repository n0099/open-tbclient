package d.b.i0.r.x;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import d.b.c.c.f.j;
import d.b.c.c.f.k;
/* loaded from: classes3.dex */
public class c {

    /* loaded from: classes3.dex */
    public static class a extends k {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.c.f.f
        /* renamed from: a */
        public SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
            if (socketMessage == null || socketMessage.getExtra() == null || !(socketMessage.getExtra() instanceof NetMessage) || d.b.i0.s.j.c.a().c(socketMessage.getCmd())) {
                return socketMessage;
            }
            ((NetMessage) socketMessage.getExtra()).setSocketErrNo(d.b.i0.s.j.c.a().b());
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends j {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.ResponsedMessage' to match base method */
        @Override // d.b.c.c.f.g
        public /* bridge */ /* synthetic */ SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
            SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
            c(socketResponsedMessage2);
            return socketResponsedMessage2;
        }

        public SocketResponsedMessage c(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                d.b.i0.s.j.c.a().e(socketResponsedMessage.getCmd());
            }
            return socketResponsedMessage;
        }
    }

    /* renamed from: d.b.i0.r.x.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1128c extends CustomMessageListener {
        public C1128c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            d.b.i0.s.j.c.a().d(((Integer) customResponsedMessage.getData()).intValue());
        }
    }

    public static void a() {
        a aVar = new a(0);
        aVar.setPriority(Integer.MIN_VALUE);
        MessageManager.getInstance().addMessageRule(aVar);
        MessageManager.getInstance().addResponsedMessageRule(new b(0));
        C1128c c1128c = new C1128c(2000999);
        c1128c.setPriority(Integer.MIN_VALUE);
        MessageManager.getInstance().registerListener(c1128c);
    }
}
