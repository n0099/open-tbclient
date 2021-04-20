package d.c.c.b.d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: e  reason: collision with root package name */
    public static final Comparator<byte[]> f66525e = new a();

    /* renamed from: a  reason: collision with root package name */
    public final List<byte[]> f66526a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final List<byte[]> f66527b = new ArrayList(64);

    /* renamed from: c  reason: collision with root package name */
    public int f66528c = 0;

    /* renamed from: d  reason: collision with root package name */
    public final int f66529d;

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
        this.f66529d = i;
    }

    public final synchronized void a() {
        while (this.f66528c > this.f66529d) {
            byte[] remove = this.f66526a.remove(0);
            this.f66527b.remove(remove);
            this.f66528c -= remove.length;
        }
    }

    public synchronized void b(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f66529d) {
                this.f66526a.add(bArr);
                int binarySearch = Collections.binarySearch(this.f66527b, bArr, f66525e);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f66527b.add(binarySearch, bArr);
                this.f66528c += bArr.length;
                a();
            }
        }
    }

    public synchronized byte[] c(int i) {
        for (int i2 = 0; i2 < this.f66527b.size(); i2++) {
            byte[] bArr = this.f66527b.get(i2);
            if (bArr.length >= i) {
                this.f66528c -= bArr.length;
                this.f66527b.remove(i2);
                this.f66526a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }
}
