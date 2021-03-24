package d.c.c.b.b;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.LruCache;
import android.util.Pair;
import android.widget.ImageView;
import d.c.c.b.b.d;
import d.c.c.b.d.q;
/* loaded from: classes5.dex */
public class a implements d.h {

    /* renamed from: a  reason: collision with root package name */
    public LruCache<String, Pair<Bitmap, byte[]>> f65597a = new C1794a(this, Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16);

    /* renamed from: d.c.c.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1794a extends LruCache<String, Pair<Bitmap, byte[]>> {
        public C1794a(a aVar, int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.LruCache
        /* renamed from: a */
        public int sizeOf(String str, Pair<Bitmap, byte[]> pair) {
            Bitmap bitmap = (Bitmap) pair.first;
            Object obj = pair.second;
            int length = obj != null ? ((byte[]) obj).length : 0;
            return bitmap != null ? length + (bitmap.getRowBytes() * bitmap.getHeight()) : length;
        }
    }

    @Override // d.c.c.b.b.d.h
    public String a(String str, int i, int i2, ImageView.ScaleType scaleType) {
        return null;
    }

    @Override // d.c.c.b.b.d.h
    public byte[] a(String str) {
        try {
            Pair<Bitmap, byte[]> pair = this.f65597a.get(str);
            byte[] bArr = pair != null ? (byte[]) pair.second : new byte[0];
            return bArr == null ? new byte[0] : bArr;
        } catch (Throwable th) {
            q.b(th, "DefaultImageCache get bitmap error", new Object[0]);
            return new byte[0];
        }
    }

    @Override // d.c.c.b.b.d.h
    public Bitmap b(String str) {
        try {
            Pair<Bitmap, byte[]> pair = this.f65597a.get(str);
            if (pair != null) {
                return (Bitmap) pair.first;
            }
            return null;
        } catch (Throwable th) {
            q.b(th, "DefaultImageCache get bitmap error", new Object[0]);
            return null;
        }
    }

    @Override // d.c.c.b.b.d.h
    public void a(String str, Bitmap bitmap, byte[] bArr) {
        if (TextUtils.isEmpty(str) || bitmap == null) {
            return;
        }
        try {
            this.f65597a.put(str, new Pair<>(bitmap, bArr));
        } catch (Throwable th) {
            q.b(th, "DefaultImageCache put bitmap error", new Object[0]);
        }
    }
}
