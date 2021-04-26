package d.a.j0.t3;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import d.a.i0.s.c.i0;
import java.util.Date;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f61232a;

    /* renamed from: b  reason: collision with root package name */
    public long f61233b;

    /* renamed from: c  reason: collision with root package name */
    public long f61234c;

    /* renamed from: d  reason: collision with root package name */
    public long f61235d;

    /* renamed from: e  reason: collision with root package name */
    public i0 f61236e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f61237f = new C1596a(2001371);

    /* renamed from: d.a.j0.t3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1596a extends CustomMessageListener {
        public C1596a(int i2) {
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
        if (this.f61232a != 0 && this.f61233b != 0 && this.f61234c != 0) {
            Date date = new Date();
            if (d(date) && e(date)) {
                return true;
            }
        }
        return false;
    }

    public final void c() {
        f();
        this.f61235d = d.a.i0.r.d0.b.j().l("key_video_splash_last_show_time", 0L);
        MessageManager.getInstance().registerListener(this.f61237f);
    }

    public final boolean d(Date date) {
        return date != null && date.getTime() >= this.f61232a && date.getTime() <= this.f61233b;
    }

    public final boolean e(Date date) {
        return date != null && date.getTime() - this.f61235d >= this.f61234c;
    }

    public final void f() {
        if (this.f61236e == null) {
            this.f61236e = new i0();
        }
        this.f61236e.g(d.a.i0.r.d0.b.j().p("key_video_splash_config", ""));
        this.f61232a = this.f61236e.e();
        this.f61233b = this.f61236e.a();
        this.f61234c = this.f61236e.d();
    }

    public void g(long j) {
        this.f61235d = j;
        d.a.i0.r.d0.b.j().w("key_video_splash_last_show_time", j);
    }
}
