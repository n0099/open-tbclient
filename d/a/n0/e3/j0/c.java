package d.a.n0.e3.j0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, e> f57769a;

    /* loaded from: classes5.dex */
    public static class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
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
        f57769a = new HashMap<>();
    }

    public static void a(int i2) {
        for (String str : f57769a.keySet()) {
            b(f57769a.get(str), i2);
        }
    }

    public static void b(e eVar, int i2) {
        d dVar = eVar.f57777d;
        d dVar2 = eVar.f57778e;
        d dVar3 = eVar.f57779f;
        if (dVar.f57771b + dVar2.f57771b + dVar3.f57771b >= i2) {
            d.a.c.e.n.a aVar = new d.a.c.e.n.a("dbg");
            aVar.b("act", eVar.f57776c);
            aVar.b("httpTimeCost", String.valueOf(dVar.f57770a));
            aVar.b("httpNum", String.valueOf(dVar.f57771b));
            aVar.b("httpFailnum", String.valueOf(dVar.f57772c));
            aVar.b("httpSize", String.valueOf(dVar.f57773d));
            aVar.b("socketTimeCost", String.valueOf(dVar2.f57770a));
            aVar.b("socketNum", String.valueOf(dVar2.f57771b));
            aVar.b("socketFailnum", String.valueOf(dVar2.f57772c));
            aVar.b("socketSize", String.valueOf(dVar2.f57773d));
            aVar.b("abortTimeCost", String.valueOf(dVar3.f57770a));
            aVar.b("abortNum", String.valueOf(dVar3.f57771b));
            aVar.b("netType", eVar.f57775b);
            aVar.b("isJson", eVar.f57774a ? "1" : "0");
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
        if (f57769a.containsKey(str3)) {
            return;
        }
        f57769a.put(str3, new e(str, str2, z));
    }

    public static void d() {
    }

    public static e e(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = str + str2;
        if (!f57769a.containsKey(str3)) {
            f57769a.put(str3, new e(str, str2, z));
        }
        return f57769a.get(str3);
    }
}
