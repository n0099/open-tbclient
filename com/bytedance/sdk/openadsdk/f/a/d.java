package com.bytedance.sdk.openadsdk.f.a;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes5.dex */
public abstract class d<P, R> extends com.bytedance.sdk.openadsdk.f.a.b<P, R> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f28989a = true;

    /* renamed from: b  reason: collision with root package name */
    public a f28990b;

    /* renamed from: c  reason: collision with root package name */
    public f f28991c;

    /* loaded from: classes5.dex */
    public interface a {
        void a(@Nullable Object obj);

        void a(@Nullable Throwable th);
    }

    /* loaded from: classes5.dex */
    public interface b {
        d a();
    }

    private boolean e() {
        if (this.f28989a) {
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
        this.f28989a = false;
        this.f28991c = null;
    }

    public final void a(@Nullable R r) {
        if (e()) {
            this.f28990b.a(r);
            d();
        }
    }

    public final void a(Throwable th) {
        if (e()) {
            this.f28990b.a(th);
            d();
        }
    }

    public void a(@NonNull P p, @NonNull f fVar, @NonNull a aVar) throws Exception {
        this.f28991c = fVar;
        this.f28990b = aVar;
        a(p, fVar);
    }
}
