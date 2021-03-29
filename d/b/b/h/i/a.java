package d.b.b.h.i;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.message.PluginLoadedMessage;
import d.b.b.h.j.g.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f42252b;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, ArrayList<Message<?>>> f42253a = null;

    /* renamed from: d.b.b.h.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0546a extends CustomMessageListener {
        public C0546a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            ArrayList arrayList;
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2000997 || (data = customResponsedMessage.getData()) == null || !(data instanceof PluginLoadedMessage.a)) {
                return;
            }
            PluginLoadedMessage.a aVar = (PluginLoadedMessage.a) data;
            if (aVar.f2199b == 0 && a.this.f42253a.size() > 0 && (arrayList = (ArrayList) a.this.f42253a.get(aVar.f2198a)) != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    MessageManager.getInstance().sendMessage((Message) it.next());
                }
            }
            a.this.f42253a.remove(aVar.f2198a);
        }
    }

    /* loaded from: classes.dex */
    public class b implements d.b.b.c.g.b<Message<?>> {
        public b() {
        }

        @Override // d.b.b.c.g.b
        public boolean a(Message<?> message) {
            if (message == null) {
                return false;
            }
            String g2 = d.k().g(message.getCmd());
            if (TextUtils.isEmpty(g2) || d.k().n(g2)) {
                return false;
            }
            if (!PluginCenter.getInstance().hasInstance(g2)) {
                a.this.c(g2, message);
                return PluginCenter.getInstance().launch(g2).f2186a;
            } else if (PluginCenter.getInstance().isLoaded(g2)) {
                return false;
            } else {
                a.this.c(g2, message);
                return true;
            }
        }
    }

    public static a d() {
        if (f42252b == null) {
            synchronized (a.class) {
                if (f42252b == null) {
                    f42252b = new a();
                }
            }
        }
        return f42252b;
    }

    public final void c(String str, Message<?> message) {
        if (TextUtils.isEmpty(str) || message == null) {
            return;
        }
        ArrayList<Message<?>> arrayList = this.f42253a.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f42253a.put(str, arrayList);
        }
        arrayList.add(message);
    }

    public void e() {
        this.f42253a = new HashMap<>();
        f();
        g();
    }

    public final void f() {
        MessageManager.getInstance().setNotFindTaskListener(new b());
    }

    public final void g() {
        MessageManager.getInstance().registerListener(2000997, new C0546a(0));
    }
}
