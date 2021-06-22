package com.bytedance.sdk.openadsdk.preload.b;

import com.bytedance.sdk.openadsdk.preload.b.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public abstract class l<IN, OUT> extends d<IN, OUT> {

    /* renamed from: d  reason: collision with root package name */
    public Map<String, a> f30137d;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public List<h> f30138a = new ArrayList();

        public a a(h hVar) {
            this.f30138a.add(hVar);
            return this;
        }

        public a a(List<h> list) {
            this.f30138a.addAll(list);
            return this;
        }
    }

    public Map<String, a> a() {
        return this.f30137d;
    }

    public boolean a(List<h> list) {
        return !list.isEmpty() && list.get(list.size() - 1).f30125a == f.class;
    }

    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public Map<String, a> f30139a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.preload.b.b.a f30140b;

        public a a(String str) {
            if (!this.f30139a.containsKey(str)) {
                a aVar = new a();
                this.f30139a.put(str, aVar);
                return aVar;
            }
            throw new IllegalArgumentException("duplicated branch name");
        }

        public h a(Class<? extends l> cls) {
            return h.a.a().a(cls).a(this.f30139a).a(this.f30140b).b();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    public final void a(Object... objArr) {
        super.a(objArr);
        if (objArr != null && objArr.length == 1 && objArr[0] != null) {
            try {
                this.f30137d = (Map) objArr[0];
                return;
            } catch (ClassCastException e2) {
                throw new IllegalArgumentException(e2);
            }
        }
        throw new IllegalStateException("args error");
    }
}
