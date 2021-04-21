package d.c.c.b.d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: e  reason: collision with root package name */
    public static final Comparator<byte[]> f66620e = new a();

    /* renamed from: a  reason: collision with root package name */
    public final List<byte[]> f66621a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final List<byte[]> f66622b = new ArrayList(64);

    /* renamed from: c  reason: collision with root package name */
    public int f66623c = 0;

    /* renamed from: d  reason: collision with root package name */
    public final int f66624d;

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
        this.f66624d = i;
    }

    public final synchronized void a() {
        while (this.f66623c > this.f66624d) {
            byte[] remove = this.f66621a.remove(0);
            this.f66622b.remove(remove);
            this.f66623c -= remove.length;
        }
    }

    public synchronized void b(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f66624d) {
                this.f66621a.add(bArr);
                int binarySearch = Collections.binarySearch(this.f66622b, bArr, f66620e);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f66622b.add(binarySearch, bArr);
                this.f66623c += bArr.length;
                a();
            }
        }
    }

    public synchronized byte[] c(int i) {
        for (int i2 = 0; i2 < this.f66622b.size(); i2++) {
            byte[] bArr = this.f66622b.get(i2);
            if (bArr.length >= i) {
                this.f66623c -= bArr.length;
                this.f66622b.remove(i2);
                this.f66621a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }
}
