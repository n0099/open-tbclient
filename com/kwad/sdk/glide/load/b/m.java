package com.kwad.sdk.glide.load.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Queue;
/* loaded from: classes7.dex */
public class m<A, B> {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.glide.g.g<a<A>, B> f36109a;

    @VisibleForTesting
    /* loaded from: classes7.dex */
    public static final class a<A> {

        /* renamed from: a  reason: collision with root package name */
        public static final Queue<a<?>> f36111a = com.kwad.sdk.glide.g.k.a(0);

        /* renamed from: b  reason: collision with root package name */
        public int f36112b;

        /* renamed from: c  reason: collision with root package name */
        public int f36113c;

        /* renamed from: d  reason: collision with root package name */
        public A f36114d;

        public static <A> a<A> a(A a2, int i2, int i3) {
            a<A> aVar;
            synchronized (f36111a) {
                aVar = (a<A>) f36111a.poll();
            }
            if (aVar == null) {
                aVar = new a<>();
            }
            aVar.b(a2, i2, i3);
            return aVar;
        }

        private void b(A a2, int i2, int i3) {
            this.f36114d = a2;
            this.f36113c = i2;
            this.f36112b = i3;
        }

        public void a() {
            synchronized (f36111a) {
                f36111a.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f36113c == aVar.f36113c && this.f36112b == aVar.f36112b && this.f36114d.equals(aVar.f36114d);
            }
            return false;
        }

        public int hashCode() {
            return (((this.f36112b * 31) + this.f36113c) * 31) + this.f36114d.hashCode();
        }
    }

    public m() {
        this(250L);
    }

    public m(long j) {
        this.f36109a = new com.kwad.sdk.glide.g.g<a<A>, B>(j) { // from class: com.kwad.sdk.glide.load.b.m.1
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
    public B a(A a2, int i2, int i3) {
        a<A> a3 = a.a(a2, i2, i3);
        B b2 = this.f36109a.b(a3);
        a3.a();
        return b2;
    }

    public void a(A a2, int i2, int i3, B b2) {
        this.f36109a.b(a.a(a2, i2, i3), b2);
    }
}
