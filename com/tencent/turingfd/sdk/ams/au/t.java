package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
/* loaded from: classes4.dex */
public class t extends aq {

    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Context f13846a;

        /* renamed from: b  reason: collision with root package name */
        public com.tencent.turingfd.sdk.a.a f13847b;
        public String c = "";
        public int d = 5000;
        public int e = 3;
        public String f = "";
        public String g = "";
        public int h = 0;
        public String i = "";
        public int j = 0;
        public boolean k = true;
        public String l = "";
        public boolean m = true;
        public s n;

        /* JADX DEBUG: Marked for inline */
        /* JADX DEBUG: Method not inlined, still used in: [com.tencent.turingfd.sdk.ams.au.t.a(android.content.Context):com.tencent.turingfd.sdk.ams.au.t$a] */
        public /* synthetic */ a(Context context, b bVar) {
            this.f13846a = context.getApplicationContext();
        }

        public final a a(s sVar) {
            this.n = sVar;
            return this;
        }

        public final a a(String str) {
            this.l = str;
            return this;
        }

        public final a a(boolean z) {
            this.k = z;
            return this;
        }

        public final t a() {
            return new t(this, null);
        }

        public final a b(boolean z) {
            this.m = z;
            return this;
        }
    }

    public /* synthetic */ t(a aVar, b bVar) {
        this.f13787a = aVar.f13846a;
        this.k = aVar.f13847b;
        this.c = aVar.c;
        this.l = aVar.d;
        this.m = aVar.e;
        this.h = aVar.g;
        this.g = aVar.f;
        this.i = aVar.h;
        this.j = aVar.i;
        this.f13788b = aVar.j;
        this.d = aVar.k;
        this.n = aVar.l;
        this.o = aVar.m;
        this.p = aVar.n;
    }

    public static a a(Context context) {
        return new a(context, null);
    }
}
