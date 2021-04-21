package d.b.j0.t3;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import d.b.c.e.p.k;
import d.b.i0.s.c.i0;
import d.b.j0.t3.b;
import java.io.File;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f63036a;

    /* renamed from: b  reason: collision with root package name */
    public String f63037b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f63038c = false;

    /* renamed from: d  reason: collision with root package name */
    public b.a f63039d = new a();

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f63040e = new b(2001371);

    /* loaded from: classes5.dex */
    public class a implements b.a {
        public a() {
        }

        @Override // d.b.j0.t3.b.a
        public void a(boolean z, String str, String str2) {
            c.this.f63038c = false;
            if (z) {
                c.this.f63037b = str;
                d.b.i0.r.d0.b.j().x("key_video_splash_path", c.this.f63037b);
                c.this.f63036a = str2;
                d.b.i0.r.d0.b.j().x("key_video_splash_url", c.this.f63036a);
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
            String p = d.b.i0.r.d0.b.j().p("key_video_splash_config", "");
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
        this.f63037b = null;
        d.b.i0.r.d0.b.j().x("key_video_splash_path", this.f63037b);
        this.f63036a = null;
        d.b.i0.r.d0.b.j().x("key_video_splash_url", this.f63036a);
    }

    public final String h() {
        return TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/videosplash";
    }

    public String i() {
        return this.f63037b;
    }

    public final void j() {
        this.f63038c = false;
        this.f63036a = d.b.i0.r.d0.b.j().p("key_video_splash_url", null);
        this.f63037b = d.b.i0.r.d0.b.j().p("key_video_splash_path", null);
        MessageManager.getInstance().registerListener(this.f63040e);
    }

    public final boolean k(String str) {
        return (k.isEmpty(str) || str.equals(this.f63036a)) ? false : true;
    }

    public boolean l() {
        if (this.f63038c || k.isEmpty(i())) {
            return false;
        }
        if (new File(i()).exists()) {
            return true;
        }
        this.f63037b = null;
        d.b.i0.r.d0.b.j().x("key_video_splash_path", this.f63037b);
        this.f63036a = null;
        d.b.i0.r.d0.b.j().x("key_video_splash_url", this.f63036a);
        return false;
    }

    public final void m(String str) {
        this.f63038c = true;
        new d.b.j0.t3.b(h(), str, this.f63039d).execute(new Void[0]);
    }

    public final void n(String str) {
        if ((d.b.i0.r.d0.b.j().k("key_video_splash_switch", 0) == 1) && !this.f63038c && k(str)) {
            m(str);
        }
    }
}
