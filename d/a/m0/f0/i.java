package d.a.m0.f0;

import com.baidu.adp.BdUniqueId;
import d.a.m0.f0.a;
/* loaded from: classes3.dex */
public abstract class i<T extends a> extends d.a.c.c.d implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f53061a = false;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f53062b = null;

    public BdUniqueId getTag() {
        return this.f53062b;
    }

    public boolean isSelfListener() {
        return this.f53061a;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.f53062b = bdUniqueId;
    }
}
