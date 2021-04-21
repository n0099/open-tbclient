package d.b.j0.d3.j0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, e> f55321a;

    /* loaded from: classes5.dex */
    public static class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                c.a(1);
            }
        }
    }

    static {
        MessageManager.getInstance().registerListener(new a(2001011));
        f55321a = new HashMap<>();
    }

    public static void a(int i) {
        for (String str : f55321a.keySet()) {
            b(f55321a.get(str), i);
        }
    }

    public static void b(e eVar, int i) {
        d dVar = eVar.f55329d;
        d dVar2 = eVar.f55330e;
        d dVar3 = eVar.f55331f;
        if (dVar.f55323b + dVar2.f55323b + dVar3.f55323b >= i) {
            d.b.c.e.n.a aVar = new d.b.c.e.n.a("dbg");
            aVar.b("act", eVar.f55328c);
            aVar.b("httpTimeCost", String.valueOf(dVar.f55322a));
            aVar.b("httpNum", String.valueOf(dVar.f55323b));
            aVar.b("httpFailnum", String.valueOf(dVar.f55324c));
            aVar.b("httpSize", String.valueOf(dVar.f55325d));
            aVar.b("socketTimeCost", String.valueOf(dVar2.f55322a));
            aVar.b("socketNum", String.valueOf(dVar2.f55323b));
            aVar.b("socketFailnum", String.valueOf(dVar2.f55324c));
            aVar.b("socketSize", String.valueOf(dVar2.f55325d));
            aVar.b("abortTimeCost", String.valueOf(dVar3.f55322a));
            aVar.b("abortNum", String.valueOf(dVar3.f55323b));
            aVar.b("netType", eVar.f55327b);
            aVar.b("isJson", eVar.f55326a ? "1" : "0");
            BdStatisticsManager.getInstance().debug("frs", aVar);
            dVar.a();
            dVar2.a();
            dVar3.a();
        }
    }

    public static void c(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = str + str2;
        if (f55321a.containsKey(str3)) {
            return;
        }
        f55321a.put(str3, new e(str, str2, z));
    }

    public static void d() {
    }

    public static e e(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = str + str2;
        if (!f55321a.containsKey(str3)) {
            f55321a.put(str3, new e(str, str2, z));
        }
        return f55321a.get(str3);
    }
}
