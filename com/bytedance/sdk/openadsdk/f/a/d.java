package com.bytedance.sdk.openadsdk.f.a;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public abstract class d<P, R> extends com.bytedance.sdk.openadsdk.f.a.b<P, R> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f29124a = true;

    /* renamed from: b  reason: collision with root package name */
    public a f29125b;

    /* renamed from: c  reason: collision with root package name */
    public f f29126c;

    /* loaded from: classes6.dex */
    public interface a {
        void a(@Nullable Object obj);

        void a(@Nullable Throwable th);
    }

    /* loaded from: classes6.dex */
    public interface b {
        d a();
    }

    private boolean e() {
        if (this.f29124a) {
            return true;
        }
        i.a(new IllegalStateException("Jsb async call already finished: " + a() + ", hashcode: " + hashCode()));
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.f.a.b
    public /* bridge */ /* synthetic */ String a() {
        return super.a();
    }

    public abstract void a(@NonNull P p, @NonNull f fVar) throws Exception;

    public final void c() {
        a((Throwable) null);
    }

    @CallSuper
    public void d() {
        this.f29124a = false;
        this.f29126c = null;
    }

    public final void a(@Nullable R r) {
        if (e()) {
            this.f29125b.a(r);
            d();
        }
    }

    public final void a(Throwable th) {
        if (e()) {
            this.f29125b.a(th);
            d();
        }
    }

    public void a(@NonNull P p, @NonNull f fVar, @NonNull a aVar) throws Exception {
        this.f29126c = fVar;
        this.f29125b = aVar;
        a(p, fVar);
    }
}
