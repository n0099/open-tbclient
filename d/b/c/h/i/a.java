package d.b.c.h.i;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.message.PluginLoadedMessage;
import d.b.c.h.j.g.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f42749b;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, ArrayList<Message<?>>> f42750a = null;

    /* renamed from: d.b.c.h.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0564a extends CustomMessageListener {
        public C0564a(int i) {
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
            if (aVar.f2234b == 0 && a.this.f42750a.size() > 0 && (arrayList = (ArrayList) a.this.f42750a.get(aVar.f2233a)) != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    MessageManager.getInstance().sendMessage((Message) it.next());
                }
            }
            a.this.f42750a.remove(aVar.f2233a);
        }
    }

    /* loaded from: classes.dex */
    public class b implements d.b.c.c.g.b<Message<?>> {
        public b() {
        }

        @Override // d.b.c.c.g.b
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
                return PluginCenter.getInstance().launch(g2).f2221a;
            } else if (PluginCenter.getInstance().isLoaded(g2)) {
                return false;
            } else {
                a.this.c(g2, message);
                return true;
            }
        }
    }

    public static a d() {
        if (f42749b == null) {
            synchronized (a.class) {
                if (f42749b == null) {
                    f42749b = new a();
                }
            }
        }
        return f42749b;
    }

    public final void c(String str, Message<?> message) {
        if (TextUtils.isEmpty(str) || message == null) {
            return;
        }
        ArrayList<Message<?>> arrayList = this.f42750a.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f42750a.put(str, arrayList);
        }
        arrayList.add(message);
    }

    public void e() {
        this.f42750a = new HashMap<>();
        f();
        g();
    }

    public final void f() {
        MessageManager.getInstance().setNotFindTaskListener(new b());
    }

    public final void g() {
        MessageManager.getInstance().registerListener(2000997, new C0564a(0));
    }
}
