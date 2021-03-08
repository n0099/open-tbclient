package com.bytedance.sdk.openadsdk.preload.b;

import com.bytedance.sdk.openadsdk.preload.b.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
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
        return list.get(list.size() + (-1)).f5043a == f.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.preload.b.d
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

    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private Map<String, a> f5047a = new HashMap();
        private com.bytedance.sdk.openadsdk.preload.b.b.a b;

        public a a(String str) {
            if (this.f5047a.containsKey(str)) {
                throw new IllegalArgumentException("duplicated branch name");
            }
            a aVar = new a();
            this.f5047a.put(str, aVar);
            return aVar;
        }

        public h a(Class<? extends l> cls) {
            return h.a.a().a(cls).a(this.f5047a).a(this.b).b();
        }
    }

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        List<h> f5046a = new ArrayList();

        public a a(h hVar) {
            this.f5046a.add(hVar);
            return this;
        }

        public a a(List<h> list) {
            this.f5046a.addAll(list);
            return this;
        }
    }
}
