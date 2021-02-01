package com.kwad.sdk.glide.load.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Queue;
/* loaded from: classes3.dex */
public class m<A, B> {

    /* renamed from: a  reason: collision with root package name */
    private final com.kwad.sdk.glide.g.g<a<A>, B> f10098a;

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    public static final class a<A> {

        /* renamed from: a  reason: collision with root package name */
        private static final Queue<a<?>> f10100a = com.kwad.sdk.glide.g.k.a(0);

        /* renamed from: b  reason: collision with root package name */
        private int f10101b;
        private int c;
        private A d;

        private a() {
        }

        static <A> a<A> a(A a2, int i, int i2) {
            a<A> aVar;
            synchronized (f10100a) {
                aVar = (a<A>) f10100a.poll();
            }
            if (aVar == null) {
                aVar = new a<>();
            }
            aVar.b(a2, i, i2);
            return aVar;
        }

        private void b(A a2, int i, int i2) {
            this.d = a2;
            this.c = i;
            this.f10101b = i2;
        }

        public void a() {
            synchronized (f10100a) {
                f10100a.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.c == aVar.c && this.f10101b == aVar.f10101b && this.d.equals(aVar.d);
            }
            return false;
        }

        public int hashCode() {
            return (((this.f10101b * 31) + this.c) * 31) + this.d.hashCode();
        }
    }

    public m() {
        this(250L);
    }

    public m(long j) {
        this.f10098a = new com.kwad.sdk.glide.g.g<a<A>, B>(j) { // from class: com.kwad.sdk.glide.load.b.m.1
            protected void a(@NonNull a<A> aVar, @Nullable B b2) {
                aVar.a();
            }

            @Override // com.kwad.sdk.glide.g.g
            protected /* bridge */ /* synthetic */ void a(@NonNull Object obj, @Nullable Object obj2) {
                a((a) ((a) obj), (a<A>) obj2);
            }
        };
    }

    @Nullable
    public B a(A a2, int i, int i2) {
        a<A> a3 = a.a(a2, i, i2);
        B b2 = this.f10098a.b(a3);
        a3.a();
        return b2;
    }

    public void a(A a2, int i, int i2, B b2) {
        this.f10098a.b(a.a(a2, i, i2), b2);
    }
}
