package d.a.a.r;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import d.a.a.g;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class b {

    /* renamed from: e  reason: collision with root package name */
    public static final Object f41319e = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final Context f41320a;

    /* renamed from: b  reason: collision with root package name */
    public String f41321b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public d.a.a.b f41322c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, g> f41323d;

    public b(Drawable.Callback callback, String str, d.a.a.b bVar, Map<String, g> map) {
        String str2;
        this.f41321b = str;
        if (!TextUtils.isEmpty(str)) {
            if (this.f41321b.charAt(str2.length() - 1) != '/') {
                this.f41321b += '/';
            }
        }
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.f41323d = new HashMap();
            this.f41320a = null;
            return;
        }
        this.f41320a = ((View) callback).getContext();
        this.f41323d = map;
        e(bVar);
    }

    @Nullable
    public Bitmap a(String str) {
        g gVar = this.f41323d.get(str);
        if (gVar == null) {
            return null;
        }
        Bitmap a2 = gVar.a();
        if (a2 != null) {
            return a2;
        }
        d.a.a.b bVar = this.f41322c;
        if (bVar != null) {
            Bitmap a3 = bVar.a(gVar);
            if (a3 != null) {
                c(str, a3);
            }
            return a3;
        }
        String c2 = gVar.c();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (c2.startsWith(WebGLImageLoader.DATA_URL) && c2.indexOf("base64,") > 0) {
            try {
                byte[] decode = Base64.decode(c2.substring(c2.indexOf(44) + 1), 0);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
                c(str, decodeByteArray);
                return decodeByteArray;
            } catch (IllegalArgumentException e2) {
                Log.w("LOTTIE", "data URL did not have correct base64 format.", e2);
                return null;
            }
        }
        try {
            if (!TextUtils.isEmpty(this.f41321b)) {
                AssetManager assets = this.f41320a.getAssets();
                Bitmap decodeStream = BitmapFactory.decodeStream(assets.open(this.f41321b + c2), null, options);
                c(str, decodeStream);
                return decodeStream;
            }
            throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
        } catch (IOException e3) {
            Log.w("LOTTIE", "Unable to open asset.", e3);
            return null;
        }
    }

    public boolean b(Context context) {
        return (context == null && this.f41320a == null) || this.f41320a.equals(context);
    }

    public final Bitmap c(String str, @Nullable Bitmap bitmap) {
        synchronized (f41319e) {
            this.f41323d.get(str).e(bitmap);
        }
        return bitmap;
    }

    public void d() {
        synchronized (f41319e) {
            for (Map.Entry<String, g> entry : this.f41323d.entrySet()) {
                g value = entry.getValue();
                Bitmap a2 = value.a();
                if (a2 != null) {
                    a2.recycle();
                    value.e(null);
                }
            }
        }
    }

    public void e(@Nullable d.a.a.b bVar) {
        this.f41322c = bVar;
    }

    @Nullable
    public Bitmap f(String str, @Nullable Bitmap bitmap) {
        if (bitmap == null) {
            g gVar = this.f41323d.get(str);
            Bitmap a2 = gVar.a();
            gVar.e(null);
            return a2;
        }
        c(str, bitmap);
        return bitmap;
    }
}
