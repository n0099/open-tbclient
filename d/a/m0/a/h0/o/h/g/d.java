package d.a.m0.a.h0.o.h.g;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes3.dex */
public final class d implements d.a.m0.a.h0.o.h.e.a {

    /* renamed from: b  reason: collision with root package name */
    public a f46276b;

    /* renamed from: c  reason: collision with root package name */
    public OutputStream f46277c;

    /* renamed from: d  reason: collision with root package name */
    public File f46278d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f46279e;

    /* loaded from: classes3.dex */
    public interface a {
        void a(File file);

        void b(File file);
    }

    public d(File file, a aVar) {
        this.f46278d = file;
        this.f46276b = aVar;
        b(file);
    }

    public void a() {
        if (this.f46277c == null) {
            return;
        }
        a aVar = this.f46276b;
        if (aVar != null) {
            if (this.f46279e) {
                aVar.a(this.f46278d);
            } else {
                aVar.b(this.f46278d);
            }
        }
        d.a.m0.t.d.d(this.f46277c);
    }

    public final void b(File file) {
        try {
            if (this.f46277c != null || file == null) {
                return;
            }
            d.a.m0.t.d.h(this.f46278d);
            this.f46277c = new FileOutputStream(file);
        } catch (Exception e2) {
            if (d.a.m0.a.h0.o.h.e.a.f46250a) {
                Log.e("HybridIntercept", Log.getStackTraceString(e2));
            }
        }
    }

    public void c(byte[] bArr, int i2, int i3) {
        OutputStream outputStream = this.f46277c;
        if (outputStream != null) {
            try {
                if (i3 > 0) {
                    outputStream.write(bArr, i2, i3);
                } else {
                    this.f46279e = true;
                }
            } catch (IOException unused) {
                d.a.m0.t.d.d(this.f46277c);
                this.f46277c = null;
                a aVar = this.f46276b;
                if (aVar != null) {
                    aVar.b(this.f46278d);
                }
            }
        }
    }
}
