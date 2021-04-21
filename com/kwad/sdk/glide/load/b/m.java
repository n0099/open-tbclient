package com.kwad.sdk.glide.load.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Queue;
/* loaded from: classes6.dex */
public class m<A, B> {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.glide.g.g<a<A>, B> f35712a;

    @VisibleForTesting
    /* loaded from: classes6.dex */
    public static final class a<A> {

        /* renamed from: a  reason: collision with root package name */
        public static final Queue<a<?>> f35714a = com.kwad.sdk.glide.g.k.a(0);

        /* renamed from: b  reason: collision with root package name */
        public int f35715b;

        /* renamed from: c  reason: collision with root package name */
        public int f35716c;

        /* renamed from: d  reason: collision with root package name */
        public A f35717d;

        public static <A> a<A> a(A a2, int i, int i2) {
            a<A> aVar;
            synchronized (f35714a) {
                aVar = (a<A>) f35714a.poll();
            }
            if (aVar == null) {
                aVar = new a<>();
            }
            aVar.b(a2, i, i2);
            return aVar;
        }

        private void b(A a2, int i, int i2) {
            this.f35717d = a2;
            this.f35716c = i;
            this.f35715b = i2;
        }

        public void a() {
            synchronized (f35714a) {
                f35714a.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f35716c == aVar.f35716c && this.f35715b == aVar.f35715b && this.f35717d.equals(aVar.f35717d);
            }
            return false;
        }

        public int hashCode() {
            return (((this.f35715b * 31) + this.f35716c) * 31) + this.f35717d.hashCode();
        }
    }

    public m() {
        this(250L);
    }

    public m(long j) {
        this.f35712a = new com.kwad.sdk.glide.g.g<a<A>, B>(j) { // from class: com.kwad.sdk.glide.load.b.m.1
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
        B b2 = this.f35712a.b(a3);
        a3.a();
        return b2;
    }

    public void a(A a2, int i, int i2, B b2) {
        this.f35712a.b(a.a(a2, i, i2), b2);
    }
}
