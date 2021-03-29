package d.a.a.r;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import d.a.a.s.h;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public final AssetManager f41317d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public d.a.a.a f41318e;

    /* renamed from: a  reason: collision with root package name */
    public final h<String> f41314a = new h<>();

    /* renamed from: b  reason: collision with root package name */
    public final Map<h<String>, Typeface> f41315b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, Typeface> f41316c = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public String f41319f = ".ttf";

    public a(Drawable.Callback callback, @Nullable d.a.a.a aVar) {
        this.f41318e = aVar;
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.f41317d = null;
            return;
        }
        this.f41317d = ((View) callback).getContext().getAssets();
    }

    public final Typeface a(String str) {
        String b2;
        Typeface typeface = this.f41316c.get(str);
        if (typeface != null) {
            return typeface;
        }
        d.a.a.a aVar = this.f41318e;
        Typeface a2 = aVar != null ? aVar.a(str) : null;
        d.a.a.a aVar2 = this.f41318e;
        if (aVar2 != null && a2 == null && (b2 = aVar2.b(str)) != null) {
            a2 = Typeface.createFromAsset(this.f41317d, b2);
        }
        if (a2 == null) {
            a2 = Typeface.createFromAsset(this.f41317d, "fonts/" + str + this.f41319f);
        }
        this.f41316c.put(str, a2);
        return a2;
    }

    public Typeface b(String str, String str2) {
        this.f41314a.b(str, str2);
        Typeface typeface = this.f41315b.get(this.f41314a);
        if (typeface != null) {
            return typeface;
        }
        Typeface d2 = d(a(str), str2);
        this.f41315b.put(this.f41314a, d2);
        return d2;
    }

    public void c(@Nullable d.a.a.a aVar) {
        this.f41318e = aVar;
    }

    public final Typeface d(Typeface typeface, String str) {
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        int i = (contains && contains2) ? 3 : contains ? 2 : contains2 ? 1 : 0;
        return typeface.getStyle() == i ? typeface : Typeface.create(typeface, i);
    }
}
