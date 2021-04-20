package d.b.i0.t3;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import d.b.h0.s.c.i0;
import java.util.Date;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f62604a;

    /* renamed from: b  reason: collision with root package name */
    public long f62605b;

    /* renamed from: c  reason: collision with root package name */
    public long f62606c;

    /* renamed from: d  reason: collision with root package name */
    public long f62607d;

    /* renamed from: e  reason: collision with root package name */
    public i0 f62608e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f62609f = new C1633a(2001371);

    /* renamed from: d.b.i0.t3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1633a extends CustomMessageListener {
        public C1633a(int i) {
            super(i);
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
        if (this.f62604a != 0 && this.f62605b != 0 && this.f62606c != 0) {
            Date date = new Date();
            if (d(date) && e(date)) {
                return true;
            }
        }
        return false;
    }

    public final void c() {
        f();
        this.f62607d = d.b.h0.r.d0.b.j().l("key_video_splash_last_show_time", 0L);
        MessageManager.getInstance().registerListener(this.f62609f);
    }

    public final boolean d(Date date) {
        return date != null && date.getTime() >= this.f62604a && date.getTime() <= this.f62605b;
    }

    public final boolean e(Date date) {
        return date != null && date.getTime() - this.f62607d >= this.f62606c;
    }

    public final void f() {
        if (this.f62608e == null) {
            this.f62608e = new i0();
        }
        this.f62608e.g(d.b.h0.r.d0.b.j().p("key_video_splash_config", ""));
        this.f62604a = this.f62608e.e();
        this.f62605b = this.f62608e.a();
        this.f62606c = this.f62608e.d();
    }

    public void g(long j) {
        this.f62607d = j;
        d.b.h0.r.d0.b.j().w("key_video_splash_last_show_time", j);
    }
}
