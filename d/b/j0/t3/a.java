package d.b.j0.t3;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import d.b.i0.s.c.i0;
import java.util.Date;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f63025a;

    /* renamed from: b  reason: collision with root package name */
    public long f63026b;

    /* renamed from: c  reason: collision with root package name */
    public long f63027c;

    /* renamed from: d  reason: collision with root package name */
    public long f63028d;

    /* renamed from: e  reason: collision with root package name */
    public i0 f63029e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f63030f = new C1656a(2001371);

    /* renamed from: d.b.j0.t3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1656a extends CustomMessageListener {
        public C1656a(int i) {
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
        if (this.f63025a != 0 && this.f63026b != 0 && this.f63027c != 0) {
            Date date = new Date();
            if (d(date) && e(date)) {
                return true;
            }
        }
        return false;
    }

    public final void c() {
        f();
        this.f63028d = d.b.i0.r.d0.b.j().l("key_video_splash_last_show_time", 0L);
        MessageManager.getInstance().registerListener(this.f63030f);
    }

    public final boolean d(Date date) {
        return date != null && date.getTime() >= this.f63025a && date.getTime() <= this.f63026b;
    }

    public final boolean e(Date date) {
        return date != null && date.getTime() - this.f63028d >= this.f63027c;
    }

    public final void f() {
        if (this.f63029e == null) {
            this.f63029e = new i0();
        }
        this.f63029e.g(d.b.i0.r.d0.b.j().p("key_video_splash_config", ""));
        this.f63025a = this.f63029e.e();
        this.f63026b = this.f63029e.a();
        this.f63027c = this.f63029e.d();
    }

    public void g(long j) {
        this.f63028d = j;
        d.b.i0.r.d0.b.j().w("key_video_splash_last_show_time", j);
    }
}
