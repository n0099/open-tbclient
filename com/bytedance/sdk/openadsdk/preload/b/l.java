package com.bytedance.sdk.openadsdk.preload.b;

import com.bytedance.sdk.openadsdk.preload.b.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public abstract class l<IN, OUT> extends d<IN, OUT> {

    /* renamed from: d  reason: collision with root package name */
    public Map<String, a> f30171d;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public List<h> f30172a = new ArrayList();

        public a a(h hVar) {
            this.f30172a.add(hVar);
            return this;
        }

        public a a(List<h> list) {
            this.f30172a.addAll(list);
            return this;
        }
    }

    public Map<String, a> a() {
        return this.f30171d;
    }

    public boolean a(List<h> list) {
        return !list.isEmpty() && list.get(list.size() - 1).f30159a == f.class;
    }

    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public Map<String, a> f30173a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.preload.b.b.a f30174b;

        public a a(String str) {
            if (!this.f30173a.containsKey(str)) {
                a aVar = new a();
                this.f30173a.put(str, aVar);
                return aVar;
            }
            throw new IllegalArgumentException("duplicated branch name");
        }

        public h a(Class<? extends l> cls) {
            return h.a.a().a(cls).a(this.f30173a).a(this.f30174b).b();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    public final void a(Object... objArr) {
        super.a(objArr);
        if (objArr != null && objArr.length == 1 && objArr[0] != null) {
            try {
                this.f30171d = (Map) objArr[0];
                return;
            } catch (ClassCastException e2) {
                throw new IllegalArgumentException(e2);
            }
        }
        throw new IllegalStateException("args error");
    }
}
