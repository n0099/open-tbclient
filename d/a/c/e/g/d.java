package d.a.c.e.g;

import android.view.View;
import com.baidu.adp.lib.guide.BuildException;
import com.baidu.adp.lib.guide.Configuration;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public boolean f42241b;

    /* renamed from: d  reason: collision with root package name */
    public a f42243d;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f42242c = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public Configuration f42240a = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void onDismiss();

        void onShown();
    }

    public d a(b bVar) {
        if (!this.f42241b) {
            this.f42242c.add(bVar);
            return this;
        }
        throw new BuildException("Already created, rebuild a new one.");
    }

    public c b() {
        c cVar = new c();
        cVar.j((b[]) this.f42242c.toArray(new b[this.f42242c.size()]));
        cVar.k(this.f42240a);
        cVar.i(this.f42243d);
        this.f42242c = null;
        this.f42240a = null;
        this.f42243d = null;
        this.f42241b = true;
        return cVar;
    }

    public d c(int i2) {
        if (this.f42241b) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i2 >= 0 && i2 <= 255) {
            this.f42240a.f2178g = i2;
            return this;
        }
        throw new BuildException("Illegal alpha value, should between [0-255]");
    }

    public d d(boolean z) {
        if (!this.f42241b) {
            this.f42240a.k = z;
            return this;
        }
        throw new BuildException("Already created, rebuild a new one.");
    }

    public d e(int i2) {
        if (this.f42241b) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i2 > 0) {
            this.f42240a.m = i2;
            return this;
        }
        throw new BuildException("Illegal animation resource id.");
    }

    public d f(int i2) {
        if (this.f42241b) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i2 > 0) {
            this.f42240a.n = i2;
            return this;
        }
        throw new BuildException("Illegal animation resource id.");
    }

    public d g(a aVar) {
        if (!this.f42241b) {
            this.f42243d = aVar;
            return this;
        }
        throw new BuildException("Already created, rebuild a new one.");
    }

    public d h(boolean z) {
        this.f42240a.f2177f = z;
        return this;
    }

    public d i(boolean z) {
        if (!this.f42241b) {
            this.f42240a.l = z;
            return this;
        }
        throw new BuildException("Already created, rebuild a new one.");
    }

    public d j(View view) {
        if (this.f42241b) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view != null) {
            this.f42240a.f2176e = view;
            return this;
        }
        throw new BuildException("Illegal view.");
    }

    public d k(int i2) {
        if (this.f42241b) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i2 > 0) {
            this.f42240a.f2180i = i2;
            return this;
        }
        throw new BuildException("Illegal view id.");
    }
}
