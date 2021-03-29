package d.b.h0.a;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class t {

    /* renamed from: b  reason: collision with root package name */
    public long f49639b;

    /* renamed from: c  reason: collision with root package name */
    public CustomMessageListener f49640c = new a(2001371);

    /* renamed from: a  reason: collision with root package name */
    public u f49638a = new u();

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            t.this.g();
        }
    }

    public t() {
        MessageManager.getInstance().registerListener(this.f49640c);
        g();
        this.f49639b = d.b.h0.r.d0.b.i().k("key_redpacket_pop_last_time", 0L);
    }

    public void b() {
        if (d() && e()) {
            f();
        }
    }

    public final boolean c(x xVar) {
        return xVar != null && this.f49639b >= xVar.b() && this.f49639b <= xVar.a();
    }

    public final boolean d() {
        Date date = new Date();
        return date.getTime() >= this.f49638a.b() && date.getTime() <= this.f49638a.a();
    }

    public final boolean e() {
        if (ListUtils.isEmpty(this.f49638a.c())) {
            return false;
        }
        Date date = new Date();
        Iterator<x> it = this.f49638a.c().iterator();
        while (it.hasNext()) {
            x next = it.next();
            if (date.getTime() >= next.b() && date.getTime() <= next.a() && !c(next)) {
                return true;
            }
        }
        return false;
    }

    public final void f() {
        if (d.b.b.e.p.k.isEmpty(this.f49638a.d())) {
            return;
        }
        this.f49639b = System.currentTimeMillis();
        d.b.h0.r.d0.b.i().v("key_redpacket_pop_last_time", this.f49639b);
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RED_PACKET_POP_WINDOW_SHOW));
        String str = this.f49638a.d() + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE;
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(currentActivity, "", str, true)));
        }
    }

    public final void g() {
        this.f49638a.e(d.b.h0.r.d0.b.i().o("key_redpacket_pop", ""));
    }
}
