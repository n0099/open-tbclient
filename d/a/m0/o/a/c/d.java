package d.a.m0.o.a.c;

import android.util.Log;
import java.io.Writer;
/* loaded from: classes3.dex */
public class d extends Writer {

    /* renamed from: e  reason: collision with root package name */
    public final String f52067e;

    /* renamed from: f  reason: collision with root package name */
    public StringBuilder f52068f = new StringBuilder(128);

    public d(String str) {
        this.f52067e = str;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        n();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        n();
    }

    public final void n() {
        if (this.f52068f.length() > 0) {
            Log.d(this.f52067e, this.f52068f.toString());
            StringBuilder sb = this.f52068f;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            char c2 = cArr[i2 + i4];
            if (c2 == '\n') {
                n();
            } else {
                this.f52068f.append(c2);
            }
        }
    }
}
