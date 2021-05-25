package d.b.c.b.d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: e  reason: collision with root package name */
    public static final Comparator<byte[]> f65747e = new a();

    /* renamed from: a  reason: collision with root package name */
    public final List<byte[]> f65748a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final List<byte[]> f65749b = new ArrayList(64);

    /* renamed from: c  reason: collision with root package name */
    public int f65750c = 0;

    /* renamed from: d  reason: collision with root package name */
    public final int f65751d;

    /* loaded from: classes6.dex */
    public static class a implements Comparator<byte[]> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    }

    public d(int i2) {
        this.f65751d = i2;
    }

    public final synchronized void a() {
        while (this.f65750c > this.f65751d) {
            byte[] remove = this.f65748a.remove(0);
            this.f65749b.remove(remove);
            this.f65750c -= remove.length;
        }
    }

    public synchronized void b(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f65751d) {
                this.f65748a.add(bArr);
                int binarySearch = Collections.binarySearch(this.f65749b, bArr, f65747e);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f65749b.add(binarySearch, bArr);
                this.f65750c += bArr.length;
                a();
            }
        }
    }

    public synchronized byte[] c(int i2) {
        for (int i3 = 0; i3 < this.f65749b.size(); i3++) {
            byte[] bArr = this.f65749b.get(i3);
            if (bArr.length >= i2) {
                this.f65750c -= bArr.length;
                this.f65749b.remove(i3);
                this.f65748a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i2];
    }
}
