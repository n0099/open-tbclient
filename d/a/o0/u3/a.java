package d.a.o0.u3;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import d.a.n0.s.c.j0;
import java.util.Date;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f65201a;

    /* renamed from: b  reason: collision with root package name */
    public long f65202b;

    /* renamed from: c  reason: collision with root package name */
    public long f65203c;

    /* renamed from: d  reason: collision with root package name */
    public long f65204d;

    /* renamed from: e  reason: collision with root package name */
    public j0 f65205e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f65206f = new C1697a(2001371);

    /* renamed from: d.a.o0.u3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1697a extends CustomMessageListener {
        public C1697a(int i2) {
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
        if (this.f65201a != 0 && this.f65202b != 0 && this.f65203c != 0) {
            Date date = new Date();
            if (d(date) && e(date)) {
                return true;
            }
        }
        return false;
    }

    public final void c() {
        f();
        this.f65204d = d.a.n0.r.d0.b.j().l("key_video_splash_last_show_time", 0L);
        MessageManager.getInstance().registerListener(this.f65206f);
    }

    public final boolean d(Date date) {
        return date != null && date.getTime() >= this.f65201a && date.getTime() <= this.f65202b;
    }

    public final boolean e(Date date) {
        return date != null && date.getTime() - this.f65204d >= this.f65203c;
    }

    public final void f() {
        if (this.f65205e == null) {
            this.f65205e = new j0();
        }
        this.f65205e.g(d.a.n0.r.d0.b.j().p("key_video_splash_config", ""));
        this.f65201a = this.f65205e.e();
        this.f65202b = this.f65205e.a();
        this.f65203c = this.f65205e.d();
    }

    public void g(long j) {
        this.f65204d = j;
        d.a.n0.r.d0.b.j().w("key_video_splash_last_show_time", j);
    }
}
