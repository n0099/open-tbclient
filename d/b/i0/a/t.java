package d.b.i0.a;

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
    public long f50367b;

    /* renamed from: c  reason: collision with root package name */
    public CustomMessageListener f50368c = new a(2001371);

    /* renamed from: a  reason: collision with root package name */
    public u f50366a = new u();

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
        MessageManager.getInstance().registerListener(this.f50368c);
        g();
        this.f50367b = d.b.i0.r.d0.b.j().l("key_redpacket_pop_last_time", 0L);
    }

    public void b() {
        if (d() && e()) {
            f();
        }
    }

    public final boolean c(x xVar) {
        return xVar != null && this.f50367b >= xVar.b() && this.f50367b <= xVar.a();
    }

    public final boolean d() {
        Date date = new Date();
        return date.getTime() >= this.f50366a.b() && date.getTime() <= this.f50366a.a();
    }

    public final boolean e() {
        if (ListUtils.isEmpty(this.f50366a.c())) {
            return false;
        }
        Date date = new Date();
        Iterator<x> it = this.f50366a.c().iterator();
        while (it.hasNext()) {
            x next = it.next();
            if (date.getTime() >= next.b() && date.getTime() <= next.a() && !c(next)) {
                return true;
            }
        }
        return false;
    }

    public final void f() {
        if (d.b.c.e.p.k.isEmpty(this.f50366a.d())) {
            return;
        }
        this.f50367b = System.currentTimeMillis();
        d.b.i0.r.d0.b.j().w("key_redpacket_pop_last_time", this.f50367b);
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RED_PACKET_POP_WINDOW_SHOW));
        String str = this.f50366a.d() + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE;
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(currentActivity, "", str, true)));
        }
    }

    public final void g() {
        this.f50366a.e(d.b.i0.r.d0.b.j().p("key_redpacket_pop", ""));
    }
}
