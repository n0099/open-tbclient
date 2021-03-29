package d.b.i0.s3;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import d.b.b.e.p.k;
import d.b.h0.s.c.g0;
import d.b.i0.s3.b;
import java.io.File;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f60201a;

    /* renamed from: b  reason: collision with root package name */
    public String f60202b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f60203c = false;

    /* renamed from: d  reason: collision with root package name */
    public b.a f60204d = new a();

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f60205e = new b(2001371);

    /* loaded from: classes5.dex */
    public class a implements b.a {
        public a() {
        }

        @Override // d.b.i0.s3.b.a
        public void a(boolean z, String str, String str2) {
            c.this.f60203c = false;
            if (z) {
                c.this.f60202b = str;
                d.b.h0.r.d0.b.i().w("key_video_splash_path", c.this.f60202b);
                c.this.f60201a = str2;
                d.b.h0.r.d0.b.i().w("key_video_splash_url", c.this.f60201a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            String o = d.b.h0.r.d0.b.i().o("key_video_splash_config", "");
            g0 g0Var = new g0();
            g0Var.g(o);
            c.this.n(g0Var.f());
        }
    }

    public c() {
        j();
    }

    public void g() {
        if (k.isEmpty(h())) {
            return;
        }
        FileHelper.deleteFileOrDir(new File(h()));
        this.f60202b = null;
        d.b.h0.r.d0.b.i().w("key_video_splash_path", this.f60202b);
        this.f60201a = null;
        d.b.h0.r.d0.b.i().w("key_video_splash_url", this.f60201a);
    }

    public final String h() {
        return TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/videosplash";
    }

    public String i() {
        return this.f60202b;
    }

    public final void j() {
        this.f60203c = false;
        this.f60201a = d.b.h0.r.d0.b.i().o("key_video_splash_url", null);
        this.f60202b = d.b.h0.r.d0.b.i().o("key_video_splash_path", null);
        MessageManager.getInstance().registerListener(this.f60205e);
    }

    public final boolean k(String str) {
        return (k.isEmpty(str) || str.equals(this.f60201a)) ? false : true;
    }

    public boolean l() {
        if (this.f60203c || k.isEmpty(i())) {
            return false;
        }
        if (new File(i()).exists()) {
            return true;
        }
        this.f60202b = null;
        d.b.h0.r.d0.b.i().w("key_video_splash_path", this.f60202b);
        this.f60201a = null;
        d.b.h0.r.d0.b.i().w("key_video_splash_url", this.f60201a);
        return false;
    }

    public final void m(String str) {
        this.f60203c = true;
        new d.b.i0.s3.b(h(), str, this.f60204d).execute(new Void[0]);
    }

    public final void n(String str) {
        if ((d.b.h0.r.d0.b.i().j("key_video_splash_switch", 0) == 1) && !this.f60203c && k(str)) {
            m(str);
        }
    }
}
