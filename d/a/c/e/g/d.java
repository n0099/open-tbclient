package d.a.c.e.g;

import android.view.View;
import com.baidu.adp.lib.guide.BuildException;
import com.baidu.adp.lib.guide.Configuration;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public boolean f38924b;

    /* renamed from: d  reason: collision with root package name */
    public a f38926d;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f38925c = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public Configuration f38923a = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void onDismiss();

        void onShown();
    }

    public d a(b bVar) {
        if (!this.f38924b) {
            this.f38925c.add(bVar);
            return this;
        }
        throw new BuildException("Already created, rebuild a new one.");
    }

    public c b() {
        c cVar = new c();
        cVar.i((b[]) this.f38925c.toArray(new b[this.f38925c.size()]));
        cVar.j(this.f38923a);
        cVar.h(this.f38926d);
        this.f38925c = null;
        this.f38923a = null;
        this.f38926d = null;
        this.f38924b = true;
        return cVar;
    }

    public d c(int i2) {
        if (this.f38924b) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i2 >= 0 && i2 <= 255) {
            this.f38923a.f2160g = i2;
            return this;
        }
        throw new BuildException("Illegal alpha value, should between [0-255]");
    }

    public d d(boolean z) {
        if (!this.f38924b) {
            this.f38923a.k = z;
            return this;
        }
        throw new BuildException("Already created, rebuild a new one.");
    }

    public d e(int i2) {
        if (this.f38924b) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i2 > 0) {
            this.f38923a.m = i2;
            return this;
        }
        throw new BuildException("Illegal animation resource id.");
    }

    public d f(int i2) {
        if (this.f38924b) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i2 > 0) {
            this.f38923a.n = i2;
            return this;
        }
        throw new BuildException("Illegal animation resource id.");
    }

    public d g(a aVar) {
        if (!this.f38924b) {
            this.f38926d = aVar;
            return this;
        }
        throw new BuildException("Already created, rebuild a new one.");
    }

    public d h(boolean z) {
        this.f38923a.f2159f = z;
        return this;
    }

    public d i(boolean z) {
        if (!this.f38924b) {
            this.f38923a.l = z;
            return this;
        }
        throw new BuildException("Already created, rebuild a new one.");
    }

    public d j(View view) {
        if (this.f38924b) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view != null) {
            this.f38923a.f2158e = view;
            return this;
        }
        throw new BuildException("Illegal view.");
    }

    public d k(int i2) {
        if (this.f38924b) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i2 > 0) {
            this.f38923a.f2162i = i2;
            return this;
        }
        throw new BuildException("Illegal view id.");
    }
}
