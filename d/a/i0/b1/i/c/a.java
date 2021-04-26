package d.a.i0.b1.i.c;

import android.content.Context;
import android.graphics.BitmapRegionDecoder;
import java.io.IOException;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final int[] f48210a = new int[2];

    /* renamed from: b  reason: collision with root package name */
    public Context f48211b;

    public a(Context context) {
        this.f48211b = context;
    }

    public BitmapRegionDecoder a(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, false);
        this.f48210a[0] = newInstance.getWidth();
        this.f48210a[1] = newInstance.getHeight();
        return newInstance;
    }

    public int[] b() {
        return this.f48210a;
    }
}
