package d.a.j0.b1.i.c;

import android.content.Context;
import android.graphics.BitmapRegionDecoder;
import java.io.IOException;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final int[] f49038a = new int[2];

    /* renamed from: b  reason: collision with root package name */
    public Context f49039b;

    public a(Context context) {
        this.f49039b = context;
    }

    public BitmapRegionDecoder a(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, false);
        this.f49038a[0] = newInstance.getWidth();
        this.f49038a[1] = newInstance.getHeight();
        return newInstance;
    }

    public int[] b() {
        return this.f49038a;
    }
}
