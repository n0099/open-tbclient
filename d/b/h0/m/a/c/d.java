package d.b.h0.m.a.c;

import android.util.Log;
import java.io.Writer;
/* loaded from: classes3.dex */
public class d extends Writer {

    /* renamed from: e  reason: collision with root package name */
    public final String f49869e;

    /* renamed from: f  reason: collision with root package name */
    public StringBuilder f49870f = new StringBuilder(128);

    public d(String str) {
        this.f49869e = str;
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
        if (this.f49870f.length() > 0) {
            Log.d(this.f49869e, this.f49870f.toString());
            StringBuilder sb = this.f49870f;
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
                this.f49870f.append(c2);
            }
        }
    }
}
