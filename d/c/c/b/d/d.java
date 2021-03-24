package d.c.c.b.d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: e  reason: collision with root package name */
    public static final Comparator<byte[]> f65679e = new a();

    /* renamed from: a  reason: collision with root package name */
    public final List<byte[]> f65680a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final List<byte[]> f65681b = new ArrayList(64);

    /* renamed from: c  reason: collision with root package name */
    public int f65682c = 0;

    /* renamed from: d  reason: collision with root package name */
    public final int f65683d;

    /* loaded from: classes5.dex */
    public static class a implements Comparator<byte[]> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    }

    public d(int i) {
        this.f65683d = i;
    }

    public final synchronized void a() {
        while (this.f65682c > this.f65683d) {
            byte[] remove = this.f65680a.remove(0);
            this.f65681b.remove(remove);
            this.f65682c -= remove.length;
        }
    }

    public synchronized void b(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f65683d) {
                this.f65680a.add(bArr);
                int binarySearch = Collections.binarySearch(this.f65681b, bArr, f65679e);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f65681b.add(binarySearch, bArr);
                this.f65682c += bArr.length;
                a();
            }
        }
    }

    public synchronized byte[] c(int i) {
        for (int i2 = 0; i2 < this.f65681b.size(); i2++) {
            byte[] bArr = this.f65681b.get(i2);
            if (bArr.length >= i) {
                this.f65682c -= bArr.length;
                this.f65681b.remove(i2);
                this.f65680a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }
}
