package d.a.i0.a;

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
    public long f47920b;

    /* renamed from: c  reason: collision with root package name */
    public CustomMessageListener f47921c = new a(2001371);

    /* renamed from: a  reason: collision with root package name */
    public u f47919a = new u();

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
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
        MessageManager.getInstance().registerListener(this.f47921c);
        g();
        this.f47920b = d.a.i0.r.d0.b.j().l("key_redpacket_pop_last_time", 0L);
    }

    public void b() {
        if (d() && e()) {
            f();
        }
    }

    public final boolean c(x xVar) {
        return xVar != null && this.f47920b >= xVar.b() && this.f47920b <= xVar.a();
    }

    public final boolean d() {
        Date date = new Date();
        return date.getTime() >= this.f47919a.b() && date.getTime() <= this.f47919a.a();
    }

    public final boolean e() {
        if (ListUtils.isEmpty(this.f47919a.c())) {
            return false;
        }
        Date date = new Date();
        Iterator<x> it = this.f47919a.c().iterator();
        while (it.hasNext()) {
            x next = it.next();
            if (date.getTime() >= next.b() && date.getTime() <= next.a() && !c(next)) {
                return true;
            }
        }
        return false;
    }

    public final void f() {
        if (d.a.c.e.p.k.isEmpty(this.f47919a.d())) {
            return;
        }
        this.f47920b = System.currentTimeMillis();
        d.a.i0.r.d0.b.j().w("key_redpacket_pop_last_time", this.f47920b);
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RED_PACKET_POP_WINDOW_SHOW));
        String str = this.f47919a.d() + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE;
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(currentActivity, "", str, true)));
        }
    }

    public final void g() {
        this.f47919a.e(d.a.i0.r.d0.b.j().p("key_redpacket_pop", ""));
    }
}
