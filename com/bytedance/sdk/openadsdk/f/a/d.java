package com.bytedance.sdk.openadsdk.f.a;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public abstract class d<P, R> extends com.bytedance.sdk.openadsdk.f.a.b<P, R> {

    /* renamed from: a  reason: collision with root package name */
    private boolean f7116a = true;

    /* renamed from: b  reason: collision with root package name */
    private a f7117b;
    private f c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface a {
        void a(@Nullable Object obj);

        void a(@Nullable Throwable th);
    }

    /* loaded from: classes6.dex */
    public interface b {
        d a();
    }

    protected abstract void a(@NonNull P p, @NonNull f fVar) throws Exception;

    @Override // com.bytedance.sdk.openadsdk.f.a.b
    public /* bridge */ /* synthetic */ String a() {
        return super.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(@Nullable R r) {
        if (e()) {
            this.f7117b.a(r);
            d();
        }
    }

    protected final void a(Throwable th) {
        if (e()) {
            this.f7117b.a(th);
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c() {
        a((Throwable) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void d() {
        this.f7116a = false;
        this.c = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull P p, @NonNull f fVar, @NonNull a aVar) throws Exception {
        this.c = fVar;
        this.f7117b = aVar;
        a(p, fVar);
    }

    private boolean e() {
        if (this.f7116a) {
            return true;
        }
        i.a(new IllegalStateException("Jsb async call already finished: " + a() + ", hashcode: " + hashCode()));
        return false;
    }
}
