package d.b.i0.s3;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import d.b.h0.s.c.g0;
import java.util.Date;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f60190a;

    /* renamed from: b  reason: collision with root package name */
    public long f60191b;

    /* renamed from: c  reason: collision with root package name */
    public long f60192c;

    /* renamed from: d  reason: collision with root package name */
    public long f60193d;

    /* renamed from: e  reason: collision with root package name */
    public g0 f60194e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f60195f = new C1535a(2001371);

    /* renamed from: d.b.i0.s3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1535a extends CustomMessageListener {
        public C1535a(int i) {
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
        if (this.f60190a != 0 && this.f60191b != 0 && this.f60192c != 0) {
            Date date = new Date();
            if (d(date) && e(date)) {
                return true;
            }
        }
        return false;
    }

    public final void c() {
        f();
        this.f60193d = d.b.h0.r.d0.b.i().k("key_video_splash_last_show_time", 0L);
        MessageManager.getInstance().registerListener(this.f60195f);
    }

    public final boolean d(Date date) {
        return date != null && date.getTime() >= this.f60190a && date.getTime() <= this.f60191b;
    }

    public final boolean e(Date date) {
        return date != null && date.getTime() - this.f60193d >= this.f60192c;
    }

    public final void f() {
        if (this.f60194e == null) {
            this.f60194e = new g0();
        }
        this.f60194e.g(d.b.h0.r.d0.b.i().o("key_video_splash_config", ""));
        this.f60190a = this.f60194e.e();
        this.f60191b = this.f60194e.a();
        this.f60192c = this.f60194e.d();
    }

    public void g(long j) {
        this.f60193d = j;
        d.b.h0.r.d0.b.i().v("key_video_splash_last_show_time", j);
    }
}
