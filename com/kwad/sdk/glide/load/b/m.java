package com.kwad.sdk.glide.load.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Queue;
/* loaded from: classes6.dex */
public class m<A, B> {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.glide.g.g<a<A>, B> f35617a;

    @VisibleForTesting
    /* loaded from: classes6.dex */
    public static final class a<A> {

        /* renamed from: a  reason: collision with root package name */
        public static final Queue<a<?>> f35619a = com.kwad.sdk.glide.g.k.a(0);

        /* renamed from: b  reason: collision with root package name */
        public int f35620b;

        /* renamed from: c  reason: collision with root package name */
        public int f35621c;

        /* renamed from: d  reason: collision with root package name */
        public A f35622d;

        public static <A> a<A> a(A a2, int i, int i2) {
            a<A> aVar;
            synchronized (f35619a) {
                aVar = (a<A>) f35619a.poll();
            }
            if (aVar == null) {
                aVar = new a<>();
            }
            aVar.b(a2, i, i2);
            return aVar;
        }

        private void b(A a2, int i, int i2) {
            this.f35622d = a2;
            this.f35621c = i;
            this.f35620b = i2;
        }

        public void a() {
            synchronized (f35619a) {
                f35619a.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f35621c == aVar.f35621c && this.f35620b == aVar.f35620b && this.f35622d.equals(aVar.f35622d);
            }
            return false;
        }

        public int hashCode() {
            return (((this.f35620b * 31) + this.f35621c) * 31) + this.f35622d.hashCode();
        }
    }

    public m() {
        this(250L);
    }

    public m(long j) {
        this.f35617a = new com.kwad.sdk.glide.g.g<a<A>, B>(j) { // from class: com.kwad.sdk.glide.load.b.m.1
            public void a(@NonNull a<A> aVar, @Nullable B b2) {
                aVar.a();
            }

            @Override // com.kwad.sdk.glide.g.g
            public /* bridge */ /* synthetic */ void a(@NonNull Object obj, @Nullable Object obj2) {
                a((a) ((a) obj), (a<A>) obj2);
            }
        };
    }

    @Nullable
    public B a(A a2, int i, int i2) {
        a<A> a3 = a.a(a2, i, i2);
        B b2 = this.f35617a.b(a3);
        a3.a();
        return b2;
    }

    public void a(A a2, int i, int i2, B b2) {
        this.f35617a.b(a.a(a2, i, i2), b2);
    }
}
