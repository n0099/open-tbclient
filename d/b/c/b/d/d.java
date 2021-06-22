package d.b.c.b.d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: e  reason: collision with root package name */
    public static final Comparator<byte[]> f69582e = new a();

    /* renamed from: a  reason: collision with root package name */
    public final List<byte[]> f69583a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final List<byte[]> f69584b = new ArrayList(64);

    /* renamed from: c  reason: collision with root package name */
    public int f69585c = 0;

    /* renamed from: d  reason: collision with root package name */
    public final int f69586d;

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
        this.f69586d = i2;
    }

    public final synchronized void a() {
        while (this.f69585c > this.f69586d) {
            byte[] remove = this.f69583a.remove(0);
            this.f69584b.remove(remove);
            this.f69585c -= remove.length;
        }
    }

    public synchronized void b(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f69586d) {
                this.f69583a.add(bArr);
                int binarySearch = Collections.binarySearch(this.f69584b, bArr, f69582e);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f69584b.add(binarySearch, bArr);
                this.f69585c += bArr.length;
                a();
            }
        }
    }

    public synchronized byte[] c(int i2) {
        for (int i3 = 0; i3 < this.f69584b.size(); i3++) {
            byte[] bArr = this.f69584b.get(i3);
            if (bArr.length >= i2) {
                this.f69585c -= bArr.length;
                this.f69584b.remove(i3);
                this.f69583a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i2];
    }
}
