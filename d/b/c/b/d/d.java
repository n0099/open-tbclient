package d.b.c.b.d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: e  reason: collision with root package name */
    public static final Comparator<byte[]> f69478e = new a();

    /* renamed from: a  reason: collision with root package name */
    public final List<byte[]> f69479a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final List<byte[]> f69480b = new ArrayList(64);

    /* renamed from: c  reason: collision with root package name */
    public int f69481c = 0;

    /* renamed from: d  reason: collision with root package name */
    public final int f69482d;

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
        this.f69482d = i2;
    }

    public final synchronized void a() {
        while (this.f69481c > this.f69482d) {
            byte[] remove = this.f69479a.remove(0);
            this.f69480b.remove(remove);
            this.f69481c -= remove.length;
        }
    }

    public synchronized void b(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f69482d) {
                this.f69479a.add(bArr);
                int binarySearch = Collections.binarySearch(this.f69480b, bArr, f69478e);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f69480b.add(binarySearch, bArr);
                this.f69481c += bArr.length;
                a();
            }
        }
    }

    public synchronized byte[] c(int i2) {
        for (int i3 = 0; i3 < this.f69480b.size(); i3++) {
            byte[] bArr = this.f69480b.get(i3);
            if (bArr.length >= i2) {
                this.f69481c -= bArr.length;
                this.f69480b.remove(i3);
                this.f69479a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i2];
    }
}
