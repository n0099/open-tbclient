package d.a.m0.a;

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
public class v {

    /* renamed from: b  reason: collision with root package name */
    public long f52457b;

    /* renamed from: c  reason: collision with root package name */
    public CustomMessageListener f52458c = new a(2001371);

    /* renamed from: a  reason: collision with root package name */
    public w f52456a = new w();

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
            v.this.g();
        }
    }

    public v() {
        MessageManager.getInstance().registerListener(this.f52458c);
        g();
        this.f52457b = d.a.m0.r.d0.b.j().l("key_redpacket_pop_last_time", 0L);
    }

    public void b() {
        if (d() && e()) {
            f();
        }
    }

    public final boolean c(a0 a0Var) {
        return a0Var != null && this.f52457b >= a0Var.b() && this.f52457b <= a0Var.a();
    }

    public final boolean d() {
        Date date = new Date();
        return date.getTime() >= this.f52456a.b() && date.getTime() <= this.f52456a.a();
    }

    public final boolean e() {
        if (ListUtils.isEmpty(this.f52456a.c())) {
            return false;
        }
        Date date = new Date();
        Iterator<a0> it = this.f52456a.c().iterator();
        while (it.hasNext()) {
            a0 next = it.next();
            if (date.getTime() >= next.b() && date.getTime() <= next.a() && !c(next)) {
                return true;
            }
        }
        return false;
    }

    public final void f() {
        if (d.a.c.e.p.k.isEmpty(this.f52456a.d())) {
            return;
        }
        this.f52457b = System.currentTimeMillis();
        d.a.m0.r.d0.b.j().w("key_redpacket_pop_last_time", this.f52457b);
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RED_PACKET_POP_WINDOW_SHOW));
        String str = this.f52456a.d() + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE;
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(currentActivity, "", str, true)));
        }
    }

    public final void g() {
        this.f52456a.e(d.a.m0.r.d0.b.j().p("key_redpacket_pop", ""));
    }
}
