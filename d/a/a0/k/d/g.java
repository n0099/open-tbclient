package d.a.a0.k.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import java.io.IOException;
/* loaded from: classes2.dex */
public class g implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public Context f39133e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f39134f;

    /* renamed from: g  reason: collision with root package name */
    public String f39135g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f39136h;

    /* renamed from: i  reason: collision with root package name */
    public int f39137i;
    public int j;

    public g(Context context, Handler handler, String str, ImageView imageView, int i2, int i3) {
        this.f39133e = context.getApplicationContext();
        this.f39134f = handler;
        this.f39135g = str;
        this.f39136h = imageView;
        this.f39137i = i2;
        this.j = i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Bitmap a(String str, int i2, int i3) {
        Bitmap bitmap;
        Bitmap bitmap2;
        try {
            bitmap = a.c(this.f39133e).a(str, i2, i3);
        } catch (IOException e2) {
            e = e2;
            bitmap = null;
        }
        try {
        } catch (IOException e3) {
            e = e3;
            e.printStackTrace();
            bitmap2 = bitmap;
            if (bitmap2 != null) {
            }
        }
        if (bitmap != null) {
            a.b().a(str, bitmap);
            return bitmap;
        }
        a.c(this.f39133e).c(str);
        bitmap2 = a.c(this.f39133e).a(str, i2, i3);
        return bitmap2 != null ? d.b(str) : bitmap2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Bitmap a2 = a(this.f39135g, this.f39137i, this.j);
        if (this.f39134f != null) {
            this.f39134f.obtainMessage(1, new f(this.f39136h, this.f39135g, a2)).sendToTarget();
        }
    }
}
