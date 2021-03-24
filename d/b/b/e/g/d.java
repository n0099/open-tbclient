package d.b.b.e.g;

import android.view.View;
import com.baidu.adp.lib.guide.BuildException;
import com.baidu.adp.lib.guide.Configuration;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public boolean f41746b;

    /* renamed from: d  reason: collision with root package name */
    public a f41748d;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f41747c = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public Configuration f41745a = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void onDismiss();

        void onShown();
    }

    public d a(b bVar) {
        if (!this.f41746b) {
            this.f41747c.add(bVar);
            return this;
        }
        throw new BuildException("Already created, rebuild a new one.");
    }

    public c b() {
        c cVar = new c();
        cVar.j((b[]) this.f41747c.toArray(new b[this.f41747c.size()]));
        cVar.k(this.f41745a);
        cVar.i(this.f41748d);
        this.f41747c = null;
        this.f41745a = null;
        this.f41748d = null;
        this.f41746b = true;
        return cVar;
    }

    public d c(int i) {
        if (this.f41746b) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i >= 0 && i <= 255) {
            this.f41745a.f2160g = i;
            return this;
        }
        throw new BuildException("Illegal alpha value, should between [0-255]");
    }

    public d d(boolean z) {
        if (!this.f41746b) {
            this.f41745a.k = z;
            return this;
        }
        throw new BuildException("Already created, rebuild a new one.");
    }

    public d e(int i) {
        if (this.f41746b) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i > 0) {
            this.f41745a.m = i;
            return this;
        }
        throw new BuildException("Illegal animation resource id.");
    }

    public d f(int i) {
        if (this.f41746b) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i > 0) {
            this.f41745a.n = i;
            return this;
        }
        throw new BuildException("Illegal animation resource id.");
    }

    public d g(a aVar) {
        if (!this.f41746b) {
            this.f41748d = aVar;
            return this;
        }
        throw new BuildException("Already created, rebuild a new one.");
    }

    public d h(boolean z) {
        this.f41745a.f2159f = z;
        return this;
    }

    public d i(boolean z) {
        if (!this.f41746b) {
            this.f41745a.l = z;
            return this;
        }
        throw new BuildException("Already created, rebuild a new one.");
    }

    public d j(View view) {
        if (this.f41746b) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view != null) {
            this.f41745a.f2158e = view;
            return this;
        }
        throw new BuildException("Illegal view.");
    }

    public d k(int i) {
        if (this.f41746b) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i > 0) {
            this.f41745a.i = i;
            return this;
        }
        throw new BuildException("Illegal view id.");
    }
}
