package d.a.l0.a.h0.o.h.g;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes2.dex */
public final class d implements d.a.l0.a.h0.o.h.e.a {

    /* renamed from: b  reason: collision with root package name */
    public a f42492b;

    /* renamed from: c  reason: collision with root package name */
    public OutputStream f42493c;

    /* renamed from: d  reason: collision with root package name */
    public File f42494d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42495e;

    /* loaded from: classes2.dex */
    public interface a {
        void a(File file);

        void b(File file);
    }

    public d(File file, a aVar) {
        this.f42494d = file;
        this.f42492b = aVar;
        b(file);
    }

    public void a() {
        if (this.f42493c == null) {
            return;
        }
        a aVar = this.f42492b;
        if (aVar != null) {
            if (this.f42495e) {
                aVar.a(this.f42494d);
            } else {
                aVar.b(this.f42494d);
            }
        }
        d.a.l0.t.d.d(this.f42493c);
    }

    public final void b(File file) {
        try {
            if (this.f42493c != null || file == null) {
                return;
            }
            d.a.l0.t.d.h(this.f42494d);
            this.f42493c = new FileOutputStream(file);
        } catch (Exception e2) {
            if (d.a.l0.a.h0.o.h.e.a.f42466a) {
                Log.e("HybridIntercept", Log.getStackTraceString(e2));
            }
        }
    }

    public void c(byte[] bArr, int i2, int i3) {
        OutputStream outputStream = this.f42493c;
        if (outputStream != null) {
            try {
                if (i3 > 0) {
                    outputStream.write(bArr, i2, i3);
                } else {
                    this.f42495e = true;
                }
            } catch (IOException unused) {
                d.a.l0.t.d.d(this.f42493c);
                this.f42493c = null;
                a aVar = this.f42492b;
                if (aVar != null) {
                    aVar.b(this.f42494d);
                }
            }
        }
    }
}
