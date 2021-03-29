package d.b.h0.f0;

import com.baidu.adp.BdUniqueId;
import d.b.h0.f0.a;
/* loaded from: classes3.dex */
public abstract class h<T extends a> extends d.b.b.c.d implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f50193a = false;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f50194b = null;

    public BdUniqueId getTag() {
        return this.f50194b;
    }

    public boolean isSelfListener() {
        return this.f50193a;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.f50194b = bdUniqueId;
    }
}
