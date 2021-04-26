package d.a.i0.f0;

import com.baidu.adp.BdUniqueId;
import d.a.i0.f0.a;
/* loaded from: classes3.dex */
public abstract class i<T extends a> extends d.a.c.c.d implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f48515a = false;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f48516b = null;

    public BdUniqueId getTag() {
        return this.f48516b;
    }

    public boolean isSelfListener() {
        return this.f48515a;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.f48516b = bdUniqueId;
    }
}
