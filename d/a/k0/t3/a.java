package d.a.k0.t3;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import d.a.j0.s.c.i0;
import java.util.Date;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f61956a;

    /* renamed from: b  reason: collision with root package name */
    public long f61957b;

    /* renamed from: c  reason: collision with root package name */
    public long f61958c;

    /* renamed from: d  reason: collision with root package name */
    public long f61959d;

    /* renamed from: e  reason: collision with root package name */
    public i0 f61960e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f61961f = new C1661a(2001371);

    /* renamed from: d.a.k0.t3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1661a extends CustomMessageListener {
        public C1661a(int i2) {
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
        if (this.f61956a != 0 && this.f61957b != 0 && this.f61958c != 0) {
            Date date = new Date();
            if (d(date) && e(date)) {
                return true;
            }
        }
        return false;
    }

    public final void c() {
        f();
        this.f61959d = d.a.j0.r.d0.b.j().l("key_video_splash_last_show_time", 0L);
        MessageManager.getInstance().registerListener(this.f61961f);
    }

    public final boolean d(Date date) {
        return date != null && date.getTime() >= this.f61956a && date.getTime() <= this.f61957b;
    }

    public final boolean e(Date date) {
        return date != null && date.getTime() - this.f61959d >= this.f61958c;
    }

    public final void f() {
        if (this.f61960e == null) {
            this.f61960e = new i0();
        }
        this.f61960e.g(d.a.j0.r.d0.b.j().p("key_video_splash_config", ""));
        this.f61956a = this.f61960e.e();
        this.f61957b = this.f61960e.a();
        this.f61958c = this.f61960e.d();
    }

    public void g(long j) {
        this.f61959d = j;
        d.a.j0.r.d0.b.j().w("key_video_splash_last_show_time", j);
    }
}
