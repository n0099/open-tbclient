package d.b.c0.a.c;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
import java.io.File;
/* loaded from: classes2.dex */
public class c<T> {

    /* renamed from: a  reason: collision with root package name */
    public T f42982a;

    public c(T t) {
        this.f42982a = t;
    }

    public T a() {
        return this.f42982a;
    }

    public byte[] b() {
        T t = this.f42982a;
        if (t instanceof Bitmap) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ((Bitmap) this.f42982a).compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } else if (t instanceof File) {
            return d.b.c0.a.k.d.a((File) t);
        } else {
            if (t instanceof byte[]) {
                return (byte[]) t;
            }
            return null;
        }
    }

    public Class<?> c() {
        return this.f42982a.getClass();
    }

    public boolean d(long j) {
        return (this.f42982a instanceof File) && System.currentTimeMillis() - ((File) this.f42982a).lastModified() > j;
    }

    public boolean e() {
        boolean delete;
        T t = this.f42982a;
        if (t instanceof Bitmap) {
            if (!((Bitmap) t).isRecycled()) {
                ((Bitmap) this.f42982a).recycle();
            }
        } else if (t instanceof File) {
            delete = ((File) t).delete();
            this.f42982a = null;
            return delete;
        }
        delete = true;
        this.f42982a = null;
        return delete;
    }

    public int f() {
        T t = this.f42982a;
        if (t instanceof Bitmap) {
            return ((Bitmap) t).getByteCount();
        }
        if (t instanceof File) {
            return (int) ((File) t).length();
        }
        if (t instanceof byte[]) {
            return ((byte[]) t).length;
        }
        return 1;
    }
}
