package d.b.h0.f0;

import com.baidu.adp.BdUniqueId;
import d.b.h0.f0.a;
/* loaded from: classes3.dex */
public abstract class h<T extends a> extends d.b.b.c.d implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f50192a = false;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f50193b = null;

    public BdUniqueId getTag() {
        return this.f50193b;
    }

    public boolean isSelfListener() {
        return this.f50192a;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.f50193b = bdUniqueId;
    }
}
