package d.b.i0.f0;

import com.baidu.adp.BdUniqueId;
import d.b.i0.f0.a;
/* loaded from: classes3.dex */
public abstract class i<T extends a> extends d.b.c.c.d implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f50936a = false;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f50937b = null;

    public BdUniqueId getTag() {
        return this.f50937b;
    }

    public boolean isSelfListener() {
        return this.f50936a;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.f50937b = bdUniqueId;
    }
}
