package d.b.c.b.d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: e  reason: collision with root package name */
    public static final Comparator<byte[]> f65018e = new a();

    /* renamed from: a  reason: collision with root package name */
    public final List<byte[]> f65019a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final List<byte[]> f65020b = new ArrayList(64);

    /* renamed from: c  reason: collision with root package name */
    public int f65021c = 0;

    /* renamed from: d  reason: collision with root package name */
    public final int f65022d;

    /* loaded from: classes5.dex */
    public static class a implements Comparator<byte[]> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    }

    public d(int i2) {
        this.f65022d = i2;
    }

    public final synchronized void a() {
        while (this.f65021c > this.f65022d) {
            byte[] remove = this.f65019a.remove(0);
            this.f65020b.remove(remove);
            this.f65021c -= remove.length;
        }
    }

    public synchronized void b(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f65022d) {
                this.f65019a.add(bArr);
                int binarySearch = Collections.binarySearch(this.f65020b, bArr, f65018e);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f65020b.add(binarySearch, bArr);
                this.f65021c += bArr.length;
                a();
            }
        }
    }

    public synchronized byte[] c(int i2) {
        for (int i3 = 0; i3 < this.f65020b.size(); i3++) {
            byte[] bArr = this.f65020b.get(i3);
            if (bArr.length >= i2) {
                this.f65021c -= bArr.length;
                this.f65020b.remove(i3);
                this.f65019a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i2];
    }
}
