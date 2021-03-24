package d.b.g0.m.a.c;

import android.util.Log;
import java.io.Writer;
/* loaded from: classes3.dex */
public class d extends Writer {

    /* renamed from: e  reason: collision with root package name */
    public final String f49147e;

    /* renamed from: f  reason: collision with root package name */
    public StringBuilder f49148f = new StringBuilder(128);

    public d(String str) {
        this.f49147e = str;
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
        if (this.f49148f.length() > 0) {
            Log.d(this.f49147e, this.f49148f.toString());
            StringBuilder sb = this.f49148f;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c2 = cArr[i + i3];
            if (c2 == '\n') {
                n();
            } else {
                this.f49148f.append(c2);
            }
        }
    }
}
