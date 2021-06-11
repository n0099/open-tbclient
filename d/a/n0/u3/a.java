package d.a.n0.u3;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import d.a.m0.s.c.j0;
import java.util.Date;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f65076a;

    /* renamed from: b  reason: collision with root package name */
    public long f65077b;

    /* renamed from: c  reason: collision with root package name */
    public long f65078c;

    /* renamed from: d  reason: collision with root package name */
    public long f65079d;

    /* renamed from: e  reason: collision with root package name */
    public j0 f65080e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f65081f = new C1693a(2001371);

    /* renamed from: d.a.n0.u3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1693a extends CustomMessageListener {
        public C1693a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            a.this.f();
        }
    }

    public a() {
        c();
    }

    public boolean b() {
        if (this.f65076a != 0 && this.f65077b != 0 && this.f65078c != 0) {
            Date date = new Date();
            if (d(date) && e(date)) {
                return true;
            }
        }
        return false;
    }

    public final void c() {
        f();
        this.f65079d = d.a.m0.r.d0.b.j().l("key_video_splash_last_show_time", 0L);
        MessageManager.getInstance().registerListener(this.f65081f);
    }

    public final boolean d(Date date) {
        return date != null && date.getTime() >= this.f65076a && date.getTime() <= this.f65077b;
    }

    public final boolean e(Date date) {
        return date != null && date.getTime() - this.f65079d >= this.f65078c;
    }

    public final void f() {
        if (this.f65080e == null) {
            this.f65080e = new j0();
        }
        this.f65080e.g(d.a.m0.r.d0.b.j().p("key_video_splash_config", ""));
        this.f65076a = this.f65080e.e();
        this.f65077b = this.f65080e.a();
        this.f65078c = this.f65080e.d();
    }

    public void g(long j) {
        this.f65079d = j;
        d.a.m0.r.d0.b.j().w("key_video_splash_last_show_time", j);
    }
}
