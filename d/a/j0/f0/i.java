package d.a.j0.f0;

import com.baidu.adp.BdUniqueId;
import d.a.j0.f0.a;
/* loaded from: classes3.dex */
public abstract class i<T extends a> extends d.a.c.c.d implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f49343a = false;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f49344b = null;

    public BdUniqueId getTag() {
        return this.f49344b;
    }

    public boolean isSelfListener() {
        return this.f49343a;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.f49344b = bdUniqueId;
    }
}
