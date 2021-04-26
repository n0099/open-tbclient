package d.a.j0.t3;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import d.a.c.e.p.k;
import d.a.i0.s.c.i0;
import d.a.j0.t3.b;
import java.io.File;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f61243a;

    /* renamed from: b  reason: collision with root package name */
    public String f61244b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f61245c = false;

    /* renamed from: d  reason: collision with root package name */
    public b.a f61246d = new a();

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f61247e = new b(2001371);

    /* loaded from: classes5.dex */
    public class a implements b.a {
        public a() {
        }

        @Override // d.a.j0.t3.b.a
        public void a(boolean z, String str, String str2) {
            c.this.f61245c = false;
            if (z) {
                c.this.f61244b = str;
                d.a.i0.r.d0.b.j().x("key_video_splash_path", c.this.f61244b);
                c.this.f61243a = str2;
                d.a.i0.r.d0.b.j().x("key_video_splash_url", c.this.f61243a);
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
            String p = d.a.i0.r.d0.b.j().p("key_video_splash_config", "");
            i0 i0Var = new i0();
            i0Var.g(p);
            c.this.n(i0Var.f());
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
        this.f61244b = null;
        d.a.i0.r.d0.b.j().x("key_video_splash_path", this.f61244b);
        this.f61243a = null;
        d.a.i0.r.d0.b.j().x("key_video_splash_url", this.f61243a);
    }

    public final String h() {
        return TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/videosplash";
    }

    public String i() {
        return this.f61244b;
    }

    public final void j() {
        this.f61245c = false;
        this.f61243a = d.a.i0.r.d0.b.j().p("key_video_splash_url", null);
        this.f61244b = d.a.i0.r.d0.b.j().p("key_video_splash_path", null);
        MessageManager.getInstance().registerListener(this.f61247e);
    }

    public final boolean k(String str) {
        return (k.isEmpty(str) || str.equals(this.f61243a)) ? false : true;
    }

    public boolean l() {
        if (this.f61245c || k.isEmpty(i())) {
            return false;
        }
        if (new File(i()).exists()) {
            return true;
        }
        this.f61244b = null;
        d.a.i0.r.d0.b.j().x("key_video_splash_path", this.f61244b);
        this.f61243a = null;
        d.a.i0.r.d0.b.j().x("key_video_splash_url", this.f61243a);
        return false;
    }

    public final void m(String str) {
        this.f61245c = true;
        new d.a.j0.t3.b(h(), str, this.f61246d).execute(new Void[0]);
    }

    public final void n(String str) {
        if ((d.a.i0.r.d0.b.j().k("key_video_splash_switch", 0) == 1) && !this.f61245c && k(str)) {
            m(str);
        }
    }
}
