package d.a.c0.k.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import java.io.IOException;
/* loaded from: classes2.dex */
public class g implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public Context f43182e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f43183f;

    /* renamed from: g  reason: collision with root package name */
    public String f43184g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f43185h;

    /* renamed from: i  reason: collision with root package name */
    public int f43186i;
    public int j;

    public g(Context context, Handler handler, String str, ImageView imageView, int i2, int i3) {
        this.f43182e = context.getApplicationContext();
        this.f43183f = handler;
        this.f43184g = str;
        this.f43185h = imageView;
        this.f43186i = i2;
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
            bitmap = a.c(this.f43182e).a(str, i2, i3);
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
        a.c(this.f43182e).c(str);
        bitmap2 = a.c(this.f43182e).a(str, i2, i3);
        return bitmap2 != null ? d.b(str) : bitmap2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Bitmap a2 = a(this.f43184g, this.f43186i, this.j);
        if (this.f43183f != null) {
            this.f43183f.obtainMessage(1, new f(this.f43185h, this.f43184g, a2)).sendToTarget();
        }
    }
}
