package d.b.i0.s3;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import d.b.h0.s.c.g0;
import java.util.Date;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f60189a;

    /* renamed from: b  reason: collision with root package name */
    public long f60190b;

    /* renamed from: c  reason: collision with root package name */
    public long f60191c;

    /* renamed from: d  reason: collision with root package name */
    public long f60192d;

    /* renamed from: e  reason: collision with root package name */
    public g0 f60193e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f60194f = new C1534a(2001371);

    /* renamed from: d.b.i0.s3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1534a extends CustomMessageListener {
        public C1534a(int i) {
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
        if (this.f60189a != 0 && this.f60190b != 0 && this.f60191c != 0) {
            Date date = new Date();
            if (d(date) && e(date)) {
                return true;
            }
        }
        return false;
    }

    public final void c() {
        f();
        this.f60192d = d.b.h0.r.d0.b.i().k("key_video_splash_last_show_time", 0L);
        MessageManager.getInstance().registerListener(this.f60194f);
    }

    public final boolean d(Date date) {
        return date != null && date.getTime() >= this.f60189a && date.getTime() <= this.f60190b;
    }

    public final boolean e(Date date) {
        return date != null && date.getTime() - this.f60192d >= this.f60191c;
    }

    public final void f() {
        if (this.f60193e == null) {
            this.f60193e = new g0();
        }
        this.f60193e.g(d.b.h0.r.d0.b.i().o("key_video_splash_config", ""));
        this.f60189a = this.f60193e.e();
        this.f60190b = this.f60193e.a();
        this.f60191c = this.f60193e.d();
    }

    public void g(long j) {
        this.f60192d = j;
        d.b.h0.r.d0.b.i().v("key_video_splash_last_show_time", j);
    }
}
