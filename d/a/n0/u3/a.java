package d.a.n0.u3;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import d.a.m0.s.c.j0;
import java.util.Date;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f61363a;

    /* renamed from: b  reason: collision with root package name */
    public long f61364b;

    /* renamed from: c  reason: collision with root package name */
    public long f61365c;

    /* renamed from: d  reason: collision with root package name */
    public long f61366d;

    /* renamed from: e  reason: collision with root package name */
    public j0 f61367e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f61368f = new C1636a(2001371);

    /* renamed from: d.a.n0.u3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1636a extends CustomMessageListener {
        public C1636a(int i2) {
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
        if (this.f61363a != 0 && this.f61364b != 0 && this.f61365c != 0) {
            Date date = new Date();
            if (d(date) && e(date)) {
                return true;
            }
        }
        return false;
    }

    public final void c() {
        f();
        this.f61366d = d.a.m0.r.d0.b.j().l("key_video_splash_last_show_time", 0L);
        MessageManager.getInstance().registerListener(this.f61368f);
    }

    public final boolean d(Date date) {
        return date != null && date.getTime() >= this.f61363a && date.getTime() <= this.f61364b;
    }

    public final boolean e(Date date) {
        return date != null && date.getTime() - this.f61366d >= this.f61365c;
    }

    public final void f() {
        if (this.f61367e == null) {
            this.f61367e = new j0();
        }
        this.f61367e.g(d.a.m0.r.d0.b.j().p("key_video_splash_config", ""));
        this.f61363a = this.f61367e.e();
        this.f61364b = this.f61367e.a();
        this.f61365c = this.f61367e.d();
    }

    public void g(long j) {
        this.f61366d = j;
        d.a.m0.r.d0.b.j().w("key_video_splash_last_show_time", j);
    }
}
