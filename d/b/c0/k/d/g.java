package d.b.c0.k.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import java.io.IOException;
/* loaded from: classes2.dex */
public class g implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public Context f42585e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f42586f;

    /* renamed from: g  reason: collision with root package name */
    public String f42587g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f42588h;
    public int i;
    public int j;

    public g(Context context, Handler handler, String str, ImageView imageView, int i, int i2) {
        this.f42585e = context.getApplicationContext();
        this.f42586f = handler;
        this.f42587g = str;
        this.f42588h = imageView;
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
            bitmap = a.c(this.f42585e).a(str, i, i2);
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
        a.c(this.f42585e).c(str);
        bitmap2 = a.c(this.f42585e).a(str, i, i2);
        return bitmap2 != null ? d.b(str) : bitmap2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Bitmap a2 = a(this.f42587g, this.i, this.j);
        if (this.f42586f != null) {
            this.f42586f.obtainMessage(1, new f(this.f42588h, this.f42587g, a2)).sendToTarget();
        }
    }
}
