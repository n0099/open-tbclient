package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.others.lang.StringUtil;
import com.bytedance.sdk.openadsdk.preload.a.o;
import com.bytedance.sdk.openadsdk.preload.a.q;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes5.dex */
public final class e extends com.bytedance.sdk.openadsdk.preload.a.d.a {

    /* renamed from: b  reason: collision with root package name */
    public static final Reader f29607b = new Reader() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.e.1
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public static final Object f29608c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public Object[] f29609d;

    /* renamed from: e  reason: collision with root package name */
    public int f29610e;

    /* renamed from: f  reason: collision with root package name */
    public String[] f29611f;

    /* renamed from: g  reason: collision with root package name */
    public int[] f29612g;

    private Object t() {
        return this.f29609d[this.f29610e - 1];
    }

    private Object u() {
        Object[] objArr = this.f29609d;
        int i = this.f29610e - 1;
        this.f29610e = i;
        Object obj = objArr[i];
        objArr[i] = null;
        return obj;
    }

    private String v() {
        return " at path " + p();
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public void a() throws IOException {
        a(com.bytedance.sdk.openadsdk.preload.a.d.b.BEGIN_ARRAY);
        a(((com.bytedance.sdk.openadsdk.preload.a.i) t()).iterator());
        this.f29612g[this.f29610e - 1] = 0;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public void b() throws IOException {
        a(com.bytedance.sdk.openadsdk.preload.a.d.b.END_ARRAY);
        u();
        u();
        int i = this.f29610e;
        if (i > 0) {
            int[] iArr = this.f29612g;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public void c() throws IOException {
        a(com.bytedance.sdk.openadsdk.preload.a.d.b.BEGIN_OBJECT);
        a(((o) t()).n().iterator());
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f29609d = new Object[]{f29608c};
        this.f29610e = 1;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public void d() throws IOException {
        a(com.bytedance.sdk.openadsdk.preload.a.d.b.END_OBJECT);
        u();
        u();
        int i = this.f29610e;
        if (i > 0) {
            int[] iArr = this.f29612g;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public boolean e() throws IOException {
        com.bytedance.sdk.openadsdk.preload.a.d.b f2 = f();
        return (f2 == com.bytedance.sdk.openadsdk.preload.a.d.b.END_OBJECT || f2 == com.bytedance.sdk.openadsdk.preload.a.d.b.END_ARRAY) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public com.bytedance.sdk.openadsdk.preload.a.d.b f() throws IOException {
        if (this.f29610e == 0) {
            return com.bytedance.sdk.openadsdk.preload.a.d.b.END_DOCUMENT;
        }
        Object t = t();
        if (t instanceof Iterator) {
            boolean z = this.f29609d[this.f29610e - 2] instanceof o;
            Iterator it = (Iterator) t;
            if (!it.hasNext()) {
                return z ? com.bytedance.sdk.openadsdk.preload.a.d.b.END_OBJECT : com.bytedance.sdk.openadsdk.preload.a.d.b.END_ARRAY;
            } else if (z) {
                return com.bytedance.sdk.openadsdk.preload.a.d.b.NAME;
            } else {
                a(it.next());
                return f();
            }
        } else if (t instanceof o) {
            return com.bytedance.sdk.openadsdk.preload.a.d.b.BEGIN_OBJECT;
        } else {
            if (t instanceof com.bytedance.sdk.openadsdk.preload.a.i) {
                return com.bytedance.sdk.openadsdk.preload.a.d.b.BEGIN_ARRAY;
            }
            if (t instanceof q) {
                q qVar = (q) t;
                if (qVar.p()) {
                    return com.bytedance.sdk.openadsdk.preload.a.d.b.STRING;
                }
                if (qVar.n()) {
                    return com.bytedance.sdk.openadsdk.preload.a.d.b.BOOLEAN;
                }
                if (qVar.o()) {
                    return com.bytedance.sdk.openadsdk.preload.a.d.b.NUMBER;
                }
                throw new AssertionError();
            } else if (t instanceof com.bytedance.sdk.openadsdk.preload.a.n) {
                return com.bytedance.sdk.openadsdk.preload.a.d.b.NULL;
            } else {
                if (t == f29608c) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public String g() throws IOException {
        a(com.bytedance.sdk.openadsdk.preload.a.d.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) t()).next();
        String str = (String) entry.getKey();
        this.f29611f[this.f29610e - 1] = str;
        a(entry.getValue());
        return str;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public String h() throws IOException {
        com.bytedance.sdk.openadsdk.preload.a.d.b f2 = f();
        if (f2 != com.bytedance.sdk.openadsdk.preload.a.d.b.STRING && f2 != com.bytedance.sdk.openadsdk.preload.a.d.b.NUMBER) {
            throw new IllegalStateException("Expected " + com.bytedance.sdk.openadsdk.preload.a.d.b.STRING + " but was " + f2 + v());
        }
        String b2 = ((q) u()).b();
        int i = this.f29610e;
        if (i > 0) {
            int[] iArr = this.f29612g;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return b2;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public boolean i() throws IOException {
        a(com.bytedance.sdk.openadsdk.preload.a.d.b.BOOLEAN);
        boolean f2 = ((q) u()).f();
        int i = this.f29610e;
        if (i > 0) {
            int[] iArr = this.f29612g;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return f2;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public void j() throws IOException {
        a(com.bytedance.sdk.openadsdk.preload.a.d.b.NULL);
        u();
        int i = this.f29610e;
        if (i > 0) {
            int[] iArr = this.f29612g;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public double k() throws IOException {
        com.bytedance.sdk.openadsdk.preload.a.d.b f2 = f();
        if (f2 != com.bytedance.sdk.openadsdk.preload.a.d.b.NUMBER && f2 != com.bytedance.sdk.openadsdk.preload.a.d.b.STRING) {
            throw new IllegalStateException("Expected " + com.bytedance.sdk.openadsdk.preload.a.d.b.NUMBER + " but was " + f2 + v());
        }
        double c2 = ((q) t()).c();
        if (!q() && (Double.isNaN(c2) || Double.isInfinite(c2))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + c2);
        }
        u();
        int i = this.f29610e;
        if (i > 0) {
            int[] iArr = this.f29612g;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return c2;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public long l() throws IOException {
        com.bytedance.sdk.openadsdk.preload.a.d.b f2 = f();
        if (f2 != com.bytedance.sdk.openadsdk.preload.a.d.b.NUMBER && f2 != com.bytedance.sdk.openadsdk.preload.a.d.b.STRING) {
            throw new IllegalStateException("Expected " + com.bytedance.sdk.openadsdk.preload.a.d.b.NUMBER + " but was " + f2 + v());
        }
        long d2 = ((q) t()).d();
        u();
        int i = this.f29610e;
        if (i > 0) {
            int[] iArr = this.f29612g;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return d2;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public int m() throws IOException {
        com.bytedance.sdk.openadsdk.preload.a.d.b f2 = f();
        if (f2 != com.bytedance.sdk.openadsdk.preload.a.d.b.NUMBER && f2 != com.bytedance.sdk.openadsdk.preload.a.d.b.STRING) {
            throw new IllegalStateException("Expected " + com.bytedance.sdk.openadsdk.preload.a.d.b.NUMBER + " but was " + f2 + v());
        }
        int e2 = ((q) t()).e();
        u();
        int i = this.f29610e;
        if (i > 0) {
            int[] iArr = this.f29612g;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return e2;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public void n() throws IOException {
        if (f() == com.bytedance.sdk.openadsdk.preload.a.d.b.NAME) {
            g();
            this.f29611f[this.f29610e - 2] = StringUtil.NULL_STRING;
        } else {
            u();
            int i = this.f29610e;
            if (i > 0) {
                this.f29611f[i - 1] = StringUtil.NULL_STRING;
            }
        }
        int i2 = this.f29610e;
        if (i2 > 0) {
            int[] iArr = this.f29612g;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    public void o() throws IOException {
        a(com.bytedance.sdk.openadsdk.preload.a.d.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) t()).next();
        a(entry.getValue());
        a(new q((String) entry.getKey()));
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public String p() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i = 0;
        while (i < this.f29610e) {
            Object[] objArr = this.f29609d;
            if (objArr[i] instanceof com.bytedance.sdk.openadsdk.preload.a.i) {
                i++;
                if (objArr[i] instanceof Iterator) {
                    sb.append('[');
                    sb.append(this.f29612g[i]);
                    sb.append(']');
                }
            } else if (objArr[i] instanceof o) {
                i++;
                if (objArr[i] instanceof Iterator) {
                    sb.append(IStringUtil.EXTENSION_SEPARATOR);
                    String[] strArr = this.f29611f;
                    if (strArr[i] != null) {
                        sb.append(strArr[i]);
                    }
                }
            }
            i++;
        }
        return sb.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public String toString() {
        return e.class.getSimpleName();
    }

    private void a(com.bytedance.sdk.openadsdk.preload.a.d.b bVar) throws IOException {
        if (f() == bVar) {
            return;
        }
        throw new IllegalStateException("Expected " + bVar + " but was " + f() + v());
    }

    private void a(Object obj) {
        int i = this.f29610e;
        Object[] objArr = this.f29609d;
        if (i == objArr.length) {
            int i2 = i * 2;
            this.f29609d = Arrays.copyOf(objArr, i2);
            this.f29612g = Arrays.copyOf(this.f29612g, i2);
            this.f29611f = (String[]) Arrays.copyOf(this.f29611f, i2);
        }
        Object[] objArr2 = this.f29609d;
        int i3 = this.f29610e;
        this.f29610e = i3 + 1;
        objArr2[i3] = obj;
    }
}
