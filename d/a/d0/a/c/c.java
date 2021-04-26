package d.a.d0.a.c;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
import java.io.File;
/* loaded from: classes2.dex */
public class c<T> {

    /* renamed from: a  reason: collision with root package name */
    public T f40542a;

    public c(T t) {
        this.f40542a = t;
    }

    public T a() {
        return this.f40542a;
    }

    public byte[] b() {
        T t = this.f40542a;
        if (t instanceof Bitmap) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ((Bitmap) this.f40542a).compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } else if (t instanceof File) {
            return d.a.d0.a.k.d.a((File) t);
        } else {
            if (t instanceof byte[]) {
                return (byte[]) t;
            }
            return null;
        }
    }

    public Class<?> c() {
        return this.f40542a.getClass();
    }

    public boolean d(long j) {
        return (this.f40542a instanceof File) && System.currentTimeMillis() - ((File) this.f40542a).lastModified() > j;
    }

    public boolean e() {
        boolean delete;
        T t = this.f40542a;
        if (t instanceof Bitmap) {
            if (!((Bitmap) t).isRecycled()) {
                ((Bitmap) this.f40542a).recycle();
            }
        } else if (t instanceof File) {
            delete = ((File) t).delete();
            this.f40542a = null;
            return delete;
        }
        delete = true;
        this.f40542a = null;
        return delete;
    }

    public int f() {
        T t = this.f40542a;
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
