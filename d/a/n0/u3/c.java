package d.a.n0.u3;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import d.a.c.e.p.k;
import d.a.m0.s.c.j0;
import d.a.n0.u3.b;
import java.io.File;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f65087a;

    /* renamed from: b  reason: collision with root package name */
    public String f65088b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f65089c = false;

    /* renamed from: d  reason: collision with root package name */
    public b.a f65090d = new a();

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f65091e = new b(2001371);

    /* loaded from: classes5.dex */
    public class a implements b.a {
        public a() {
        }

        @Override // d.a.n0.u3.b.a
        public void a(boolean z, String str, String str2) {
            c.this.f65089c = false;
            if (z) {
                c.this.f65088b = str;
                d.a.m0.r.d0.b.j().x("key_video_splash_path", c.this.f65088b);
                c.this.f65087a = str2;
                d.a.m0.r.d0.b.j().x("key_video_splash_url", c.this.f65087a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            String p = d.a.m0.r.d0.b.j().p("key_video_splash_config", "");
            j0 j0Var = new j0();
            j0Var.g(p);
            c.this.n(j0Var.f());
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
        this.f65088b = null;
        d.a.m0.r.d0.b.j().x("key_video_splash_path", this.f65088b);
        this.f65087a = null;
        d.a.m0.r.d0.b.j().x("key_video_splash_url", this.f65087a);
    }

    public final String h() {
        return TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/videosplash";
    }

    public String i() {
        return this.f65088b;
    }

    public final void j() {
        this.f65089c = false;
        this.f65087a = d.a.m0.r.d0.b.j().p("key_video_splash_url", null);
        this.f65088b = d.a.m0.r.d0.b.j().p("key_video_splash_path", null);
        MessageManager.getInstance().registerListener(this.f65091e);
    }

    public final boolean k(String str) {
        return (k.isEmpty(str) || str.equals(this.f65087a)) ? false : true;
    }

    public boolean l() {
        if (this.f65089c || k.isEmpty(i())) {
            return false;
        }
        if (new File(i()).exists()) {
            return true;
        }
        this.f65088b = null;
        d.a.m0.r.d0.b.j().x("key_video_splash_path", this.f65088b);
        this.f65087a = null;
        d.a.m0.r.d0.b.j().x("key_video_splash_url", this.f65087a);
        return false;
    }

    public final void m(String str) {
        this.f65089c = true;
        new d.a.n0.u3.b(h(), str, this.f65090d).execute(new Void[0]);
    }

    public final void n(String str) {
        if ((d.a.m0.r.d0.b.j().k("key_video_splash_switch", 0) == 1) && !this.f65089c && k(str)) {
            m(str);
        }
    }
}
