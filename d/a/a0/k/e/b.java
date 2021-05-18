package d.a.a0.k.e;

import android.graphics.Bitmap;
import android.util.LruCache;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public LruCache<String, Bitmap> f38384a = new a(this, ((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8);

    /* loaded from: classes2.dex */
    public class a extends LruCache<String, Bitmap> {
        public a(b bVar, int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.LruCache
        /* renamed from: a */
        public int sizeOf(String str, Bitmap bitmap) {
            return bitmap.getByteCount() / 1024;
        }
    }

    public void a(String str, Bitmap bitmap) {
        String b2 = d.a.a0.k.g.b.b(str);
        if (c(b2) == null) {
            this.f38384a.put(b2, bitmap);
        }
    }

    public Bitmap b(String str) {
        return c(d.a.a0.k.g.b.b(str));
    }

    public final Bitmap c(String str) {
        return this.f38384a.get(str);
    }
}
