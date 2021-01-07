package com.bytedance.sdk.openadsdk.preload.a;

import com.bytedance.sdk.openadsdk.preload.a.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
abstract class l<IN, OUT> extends d<IN, OUT> {
    private Map<String, a> d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, a> a() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(List<h> list) {
        if (list.isEmpty()) {
            return false;
        }
        return list.get(list.size() + (-1)).f7722a == f.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.preload.a.d
    public final void a(Object... objArr) {
        super.a(objArr);
        if (objArr == null || objArr.length != 1 || objArr[0] == null) {
            throw new IllegalStateException("args error");
        }
        try {
            this.d = (Map) objArr[0];
        } catch (ClassCastException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private Map<String, a> f7729a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        private com.bytedance.sdk.openadsdk.preload.a.b.a f7730b;

        public a a(String str) {
            if (this.f7729a.containsKey(str)) {
                throw new IllegalArgumentException("duplicated branch name");
            }
            a aVar = new a();
            this.f7729a.put(str, aVar);
            return aVar;
        }

        public h a(Class<? extends l> cls) {
            return h.a.a().a(cls).a(this.f7729a).a(this.f7730b).b();
        }
    }

    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        List<h> f7728a = new ArrayList();

        public a a(h hVar) {
            this.f7728a.add(hVar);
            return this;
        }

        public a a(List<h> list) {
            this.f7728a.addAll(list);
            return this;
        }
    }
}
