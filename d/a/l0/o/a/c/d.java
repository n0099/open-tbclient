package d.a.l0.o.a.c;

import android.util.Log;
import java.io.Writer;
/* loaded from: classes3.dex */
public class d extends Writer {

    /* renamed from: e  reason: collision with root package name */
    public final String f51959e;

    /* renamed from: f  reason: collision with root package name */
    public StringBuilder f51960f = new StringBuilder(128);

    public d(String str) {
        this.f51959e = str;
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
        if (this.f51960f.length() > 0) {
            Log.d(this.f51959e, this.f51960f.toString());
            StringBuilder sb = this.f51960f;
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
                this.f51960f.append(c2);
            }
        }
    }
}
