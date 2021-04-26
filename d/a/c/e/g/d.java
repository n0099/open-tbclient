package d.a.c.e.g;

import android.view.View;
import com.baidu.adp.lib.guide.BuildException;
import com.baidu.adp.lib.guide.Configuration;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public boolean f39679b;

    /* renamed from: d  reason: collision with root package name */
    public a f39681d;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f39680c = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public Configuration f39678a = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void onDismiss();

        void onShown();
    }

    public d a(b bVar) {
        if (!this.f39679b) {
            this.f39680c.add(bVar);
            return this;
        }
        throw new BuildException("Already created, rebuild a new one.");
    }

    public c b() {
        c cVar = new c();
        cVar.i((b[]) this.f39680c.toArray(new b[this.f39680c.size()]));
        cVar.j(this.f39678a);
        cVar.h(this.f39681d);
        this.f39680c = null;
        this.f39678a = null;
        this.f39681d = null;
        this.f39679b = true;
        return cVar;
    }

    public d c(int i2) {
        if (this.f39679b) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i2 >= 0 && i2 <= 255) {
            this.f39678a.f2160g = i2;
            return this;
        }
        throw new BuildException("Illegal alpha value, should between [0-255]");
    }

    public d d(boolean z) {
        if (!this.f39679b) {
            this.f39678a.k = z;
            return this;
        }
        throw new BuildException("Already created, rebuild a new one.");
    }

    public d e(int i2) {
        if (this.f39679b) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i2 > 0) {
            this.f39678a.m = i2;
            return this;
        }
        throw new BuildException("Illegal animation resource id.");
    }

    public d f(int i2) {
        if (this.f39679b) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i2 > 0) {
            this.f39678a.n = i2;
            return this;
        }
        throw new BuildException("Illegal animation resource id.");
    }

    public d g(a aVar) {
        if (!this.f39679b) {
            this.f39681d = aVar;
            return this;
        }
        throw new BuildException("Already created, rebuild a new one.");
    }

    public d h(boolean z) {
        this.f39678a.f2159f = z;
        return this;
    }

    public d i(boolean z) {
        if (!this.f39679b) {
            this.f39678a.l = z;
            return this;
        }
        throw new BuildException("Already created, rebuild a new one.");
    }

    public d j(View view) {
        if (this.f39679b) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view != null) {
            this.f39678a.f2158e = view;
            return this;
        }
        throw new BuildException("Illegal view.");
    }

    public d k(int i2) {
        if (this.f39679b) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i2 > 0) {
            this.f39678a.f2162i = i2;
            return this;
        }
        throw new BuildException("Illegal view id.");
    }
}
