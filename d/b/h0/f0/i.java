package d.b.h0.f0;

import com.baidu.adp.BdUniqueId;
import d.b.h0.f0.a;
/* loaded from: classes3.dex */
public abstract class i<T extends a> extends d.b.c.c.d implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f50600a = false;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f50601b = null;

    public BdUniqueId getTag() {
        return this.f50601b;
    }

    public boolean isSelfListener() {
        return this.f50600a;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.f50601b = bdUniqueId;
    }
}
