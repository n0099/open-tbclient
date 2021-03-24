package d.b.c0.k.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import java.io.IOException;
/* loaded from: classes2.dex */
public class g implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public Context f42584e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f42585f;

    /* renamed from: g  reason: collision with root package name */
    public String f42586g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f42587h;
    public int i;
    public int j;

    public g(Context context, Handler handler, String str, ImageView imageView, int i, int i2) {
        this.f42584e = context.getApplicationContext();
        this.f42585f = handler;
        this.f42586g = str;
        this.f42587h = imageView;
        this.i = i;
        this.j = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Bitmap a(String str, int i, int i2) {
        Bitmap bitmap;
        Bitmap bitmap2;
        try {
            bitmap = a.c(this.f42584e).a(str, i, i2);
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
        a.c(this.f42584e).c(str);
        bitmap2 = a.c(this.f42584e).a(str, i, i2);
        return bitmap2 != null ? d.b(str) : bitmap2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Bitmap a2 = a(this.f42586g, this.i, this.j);
        if (this.f42585f != null) {
            this.f42585f.obtainMessage(1, new f(this.f42587h, this.f42586g, a2)).sendToTarget();
        }
    }
}
