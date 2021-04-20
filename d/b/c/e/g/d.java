package d.b.c.e.g;

import android.view.View;
import com.baidu.adp.lib.guide.BuildException;
import com.baidu.adp.lib.guide.Configuration;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public boolean f42244b;

    /* renamed from: d  reason: collision with root package name */
    public a f42246d;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f42245c = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public Configuration f42243a = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void onDismiss();

        void onShown();
    }

    public d a(b bVar) {
        if (!this.f42244b) {
            this.f42245c.add(bVar);
            return this;
        }
        throw new BuildException("Already created, rebuild a new one.");
    }

    public c b() {
        c cVar = new c();
        cVar.j((b[]) this.f42245c.toArray(new b[this.f42245c.size()]));
        cVar.k(this.f42243a);
        cVar.i(this.f42246d);
        this.f42245c = null;
        this.f42243a = null;
        this.f42246d = null;
        this.f42244b = true;
        return cVar;
    }

    public d c(int i) {
        if (this.f42244b) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i >= 0 && i <= 255) {
            this.f42243a.f2196g = i;
            return this;
        }
        throw new BuildException("Illegal alpha value, should between [0-255]");
    }

    public d d(boolean z) {
        if (!this.f42244b) {
            this.f42243a.k = z;
            return this;
        }
        throw new BuildException("Already created, rebuild a new one.");
    }

    public d e(int i) {
        if (this.f42244b) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i > 0) {
            this.f42243a.m = i;
            return this;
        }
        throw new BuildException("Illegal animation resource id.");
    }

    public d f(int i) {
        if (this.f42244b) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i > 0) {
            this.f42243a.n = i;
            return this;
        }
        throw new BuildException("Illegal animation resource id.");
    }

    public d g(a aVar) {
        if (!this.f42244b) {
            this.f42246d = aVar;
            return this;
        }
        throw new BuildException("Already created, rebuild a new one.");
    }

    public d h(boolean z) {
        this.f42243a.f2195f = z;
        return this;
    }

    public d i(boolean z) {
        if (!this.f42244b) {
            this.f42243a.l = z;
            return this;
        }
        throw new BuildException("Already created, rebuild a new one.");
    }

    public d j(View view) {
        if (this.f42244b) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view != null) {
            this.f42243a.f2194e = view;
            return this;
        }
        throw new BuildException("Illegal view.");
    }

    public d k(int i) {
        if (this.f42244b) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i > 0) {
            this.f42243a.i = i;
            return this;
        }
        throw new BuildException("Illegal view id.");
    }
}
