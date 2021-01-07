package com.tencent.turingfd.sdk.ams.au;
/* loaded from: classes4.dex */
public class ap implements x {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f13783a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    public final String f13784b;
    public final long c;
    public final int d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;

    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public String f13785a;

        /* renamed from: b  reason: collision with root package name */
        public long f13786b;
        public int c;
        public byte[] d;
        public String e;
        public String f;
        public String g;
        public String h;

        /* JADX DEBUG: Marked for inline */
        /* JADX DEBUG: Method not inlined, still used in: [com.tencent.turingfd.sdk.ams.au.ap.b(int):com.tencent.turingfd.sdk.ams.au.ap$b] */
        public /* synthetic */ b(int i, a aVar) {
            this.c = i;
        }

        public b a(long j) {
            this.f13786b = j;
            return this;
        }

        public b a(String str) {
            this.f13785a = str;
            return this;
        }

        public ap a() {
            return new ap(this);
        }

        public b b(String str) {
            this.e = str;
            return this;
        }

        public b c(String str) {
            this.f = str;
            return this;
        }

        public b d(String str) {
            this.g = str;
            return this;
        }

        public b e(String str) {
            this.h = str;
            return this;
        }
    }

    public ap(int i, byte[] bArr) {
        this.f13784b = "";
        this.c = 0L;
        this.d = i;
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
    }

    public ap(b bVar) {
        this.f13784b = bVar.f13785a;
        this.c = bVar.f13786b;
        this.d = bVar.c;
        byte[] bArr = bVar.d;
        this.e = bVar.e;
        this.f = bVar.f;
        this.g = bVar.g;
        this.h = bVar.h;
    }

    public static ap a(int i) {
        return new ap(i, f13783a);
    }

    public static b b(int i) {
        return new b(i, null);
    }
}
