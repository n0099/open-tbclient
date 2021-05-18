package d.a.i0.a.h0.o.h.g;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes2.dex */
public final class d implements d.a.i0.a.h0.o.h.e.a {

    /* renamed from: b  reason: collision with root package name */
    public a f42318b;

    /* renamed from: c  reason: collision with root package name */
    public OutputStream f42319c;

    /* renamed from: d  reason: collision with root package name */
    public File f42320d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42321e;

    /* loaded from: classes2.dex */
    public interface a {
        void a(File file);

        void b(File file);
    }

    public d(File file, a aVar) {
        this.f42320d = file;
        this.f42318b = aVar;
        b(file);
    }

    public void a() {
        if (this.f42319c == null) {
            return;
        }
        a aVar = this.f42318b;
        if (aVar != null) {
            if (this.f42321e) {
                aVar.a(this.f42320d);
            } else {
                aVar.b(this.f42320d);
            }
        }
        d.a.i0.t.d.d(this.f42319c);
    }

    public final void b(File file) {
        try {
            if (this.f42319c != null || file == null) {
                return;
            }
            d.a.i0.t.d.h(this.f42320d);
            this.f42319c = new FileOutputStream(file);
        } catch (Exception e2) {
            if (d.a.i0.a.h0.o.h.e.a.f42292a) {
                Log.e("HybridIntercept", Log.getStackTraceString(e2));
            }
        }
    }

    public void c(byte[] bArr, int i2, int i3) {
        OutputStream outputStream = this.f42319c;
        if (outputStream != null) {
            try {
                if (i3 > 0) {
                    outputStream.write(bArr, i2, i3);
                } else {
                    this.f42321e = true;
                }
            } catch (IOException unused) {
                d.a.i0.t.d.d(this.f42319c);
                this.f42319c = null;
                a aVar = this.f42318b;
                if (aVar != null) {
                    aVar.b(this.f42320d);
                }
            }
        }
    }
}
