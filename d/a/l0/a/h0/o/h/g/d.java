package d.a.l0.a.h0.o.h.g;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes2.dex */
public final class d implements d.a.l0.a.h0.o.h.e.a {

    /* renamed from: b  reason: collision with root package name */
    public a f46168b;

    /* renamed from: c  reason: collision with root package name */
    public OutputStream f46169c;

    /* renamed from: d  reason: collision with root package name */
    public File f46170d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f46171e;

    /* loaded from: classes2.dex */
    public interface a {
        void a(File file);

        void b(File file);
    }

    public d(File file, a aVar) {
        this.f46170d = file;
        this.f46168b = aVar;
        b(file);
    }

    public void a() {
        if (this.f46169c == null) {
            return;
        }
        a aVar = this.f46168b;
        if (aVar != null) {
            if (this.f46171e) {
                aVar.a(this.f46170d);
            } else {
                aVar.b(this.f46170d);
            }
        }
        d.a.l0.t.d.d(this.f46169c);
    }

    public final void b(File file) {
        try {
            if (this.f46169c != null || file == null) {
                return;
            }
            d.a.l0.t.d.h(this.f46170d);
            this.f46169c = new FileOutputStream(file);
        } catch (Exception e2) {
            if (d.a.l0.a.h0.o.h.e.a.f46142a) {
                Log.e("HybridIntercept", Log.getStackTraceString(e2));
            }
        }
    }

    public void c(byte[] bArr, int i2, int i3) {
        OutputStream outputStream = this.f46169c;
        if (outputStream != null) {
            try {
                if (i3 > 0) {
                    outputStream.write(bArr, i2, i3);
                } else {
                    this.f46171e = true;
                }
            } catch (IOException unused) {
                d.a.l0.t.d.d(this.f46169c);
                this.f46169c = null;
                a aVar = this.f46168b;
                if (aVar != null) {
                    aVar.b(this.f46170d);
                }
            }
        }
    }
}
