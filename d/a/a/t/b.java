package d.a.a.t;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import d.a.a.g;
import d.a.a.x.d;
import d.a.a.x.h;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class b {

    /* renamed from: e  reason: collision with root package name */
    public static final Object f41721e = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final Context f41722a;

    /* renamed from: b  reason: collision with root package name */
    public String f41723b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public d.a.a.b f41724c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, g> f41725d;

    public b(Drawable.Callback callback, String str, d.a.a.b bVar, Map<String, g> map) {
        String str2;
        this.f41723b = str;
        if (!TextUtils.isEmpty(str)) {
            if (this.f41723b.charAt(str2.length() - 1) != '/') {
                this.f41723b += '/';
            }
        }
        if (!(callback instanceof View)) {
            d.c("LottieDrawable must be inside of a view for images to work.");
            this.f41725d = new HashMap();
            this.f41722a = null;
            return;
        }
        this.f41722a = ((View) callback).getContext();
        this.f41725d = map;
        d(bVar);
    }

    @Nullable
    public Bitmap a(String str) {
        g gVar = this.f41725d.get(str);
        if (gVar == null) {
            return null;
        }
        Bitmap a2 = gVar.a();
        if (a2 != null) {
            return a2;
        }
        d.a.a.b bVar = this.f41724c;
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
                d.d("data URL did not have correct base64 format.", e2);
                return null;
            }
        }
        try {
            if (!TextUtils.isEmpty(this.f41723b)) {
                AssetManager assets = this.f41722a.getAssets();
                Bitmap l = h.l(BitmapFactory.decodeStream(assets.open(this.f41723b + c2), null, options), gVar.f(), gVar.d());
                c(str, l);
                return l;
            }
            throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
        } catch (IOException e3) {
            d.d("Unable to open asset.", e3);
            return null;
        }
    }

    public boolean b(Context context) {
        return (context == null && this.f41722a == null) || this.f41722a.equals(context);
    }

    public final Bitmap c(String str, @Nullable Bitmap bitmap) {
        synchronized (f41721e) {
            this.f41725d.get(str).g(bitmap);
        }
        return bitmap;
    }

    public void d(@Nullable d.a.a.b bVar) {
        this.f41724c = bVar;
    }

    @Nullable
    public Bitmap e(String str, @Nullable Bitmap bitmap) {
        if (bitmap == null) {
            g gVar = this.f41725d.get(str);
            Bitmap a2 = gVar.a();
            gVar.g(null);
            return a2;
        }
        Bitmap a3 = this.f41725d.get(str).a();
        c(str, bitmap);
        return a3;
    }
}
