package d.b.i0.c3.j0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, e> f53455a;

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
        f53455a = new HashMap<>();
    }

    public static void a(int i) {
        for (String str : f53455a.keySet()) {
            b(f53455a.get(str), i);
        }
    }

    public static void b(e eVar, int i) {
        d dVar = eVar.f53463d;
        d dVar2 = eVar.f53464e;
        d dVar3 = eVar.f53465f;
        if (dVar.f53457b + dVar2.f53457b + dVar3.f53457b >= i) {
            d.b.b.e.n.a aVar = new d.b.b.e.n.a("dbg");
            aVar.b("act", eVar.f53462c);
            aVar.b("httpTimeCost", String.valueOf(dVar.f53456a));
            aVar.b("httpNum", String.valueOf(dVar.f53457b));
            aVar.b("httpFailnum", String.valueOf(dVar.f53458c));
            aVar.b("httpSize", String.valueOf(dVar.f53459d));
            aVar.b("socketTimeCost", String.valueOf(dVar2.f53456a));
            aVar.b("socketNum", String.valueOf(dVar2.f53457b));
            aVar.b("socketFailnum", String.valueOf(dVar2.f53458c));
            aVar.b("socketSize", String.valueOf(dVar2.f53459d));
            aVar.b("abortTimeCost", String.valueOf(dVar3.f53456a));
            aVar.b("abortNum", String.valueOf(dVar3.f53457b));
            aVar.b("netType", eVar.f53461b);
            aVar.b("isJson", eVar.f53460a ? "1" : "0");
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
        if (f53455a.containsKey(str3)) {
            return;
        }
        f53455a.put(str3, new e(str, str2, z));
    }

    public static void d() {
    }

    public static e e(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = str + str2;
        if (!f53455a.containsKey(str3)) {
            f53455a.put(str3, new e(str, str2, z));
        }
        return f53455a.get(str3);
    }
}
