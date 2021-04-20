package d.b.i0.t3;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import d.b.c.e.p.k;
import d.b.h0.s.c.i0;
import d.b.i0.t3.b;
import java.io.File;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f62615a;

    /* renamed from: b  reason: collision with root package name */
    public String f62616b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f62617c = false;

    /* renamed from: d  reason: collision with root package name */
    public b.a f62618d = new a();

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f62619e = new b(2001371);

    /* loaded from: classes5.dex */
    public class a implements b.a {
        public a() {
        }

        @Override // d.b.i0.t3.b.a
        public void a(boolean z, String str, String str2) {
            c.this.f62617c = false;
            if (z) {
                c.this.f62616b = str;
                d.b.h0.r.d0.b.j().x("key_video_splash_path", c.this.f62616b);
                c.this.f62615a = str2;
                d.b.h0.r.d0.b.j().x("key_video_splash_url", c.this.f62615a);
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
            String p = d.b.h0.r.d0.b.j().p("key_video_splash_config", "");
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
        this.f62616b = null;
        d.b.h0.r.d0.b.j().x("key_video_splash_path", this.f62616b);
        this.f62615a = null;
        d.b.h0.r.d0.b.j().x("key_video_splash_url", this.f62615a);
    }

    public final String h() {
        return TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/videosplash";
    }

    public String i() {
        return this.f62616b;
    }

    public final void j() {
        this.f62617c = false;
        this.f62615a = d.b.h0.r.d0.b.j().p("key_video_splash_url", null);
        this.f62616b = d.b.h0.r.d0.b.j().p("key_video_splash_path", null);
        MessageManager.getInstance().registerListener(this.f62619e);
    }

    public final boolean k(String str) {
        return (k.isEmpty(str) || str.equals(this.f62615a)) ? false : true;
    }

    public boolean l() {
        if (this.f62617c || k.isEmpty(i())) {
            return false;
        }
        if (new File(i()).exists()) {
            return true;
        }
        this.f62616b = null;
        d.b.h0.r.d0.b.j().x("key_video_splash_path", this.f62616b);
        this.f62615a = null;
        d.b.h0.r.d0.b.j().x("key_video_splash_url", this.f62615a);
        return false;
    }

    public final void m(String str) {
        this.f62617c = true;
        new d.b.i0.t3.b(h(), str, this.f62618d).execute(new Void[0]);
    }

    public final void n(String str) {
        if ((d.b.h0.r.d0.b.j().k("key_video_splash_switch", 0) == 1) && !this.f62617c && k(str)) {
            m(str);
        }
    }
}
