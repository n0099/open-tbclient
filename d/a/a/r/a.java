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
    public final AssetManager f41316d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public d.a.a.a f41317e;

    /* renamed from: a  reason: collision with root package name */
    public final h<String> f41313a = new h<>();

    /* renamed from: b  reason: collision with root package name */
    public final Map<h<String>, Typeface> f41314b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, Typeface> f41315c = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public String f41318f = ".ttf";

    public a(Drawable.Callback callback, @Nullable d.a.a.a aVar) {
        this.f41317e = aVar;
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.f41316d = null;
            return;
        }
        this.f41316d = ((View) callback).getContext().getAssets();
    }

    public final Typeface a(String str) {
        Typeface typeface = this.f41315c.get(str);
        if (typeface != null) {
            return typeface;
        }
        d.a.a.a aVar = this.f41317e;
        if (aVar != null) {
            aVar.a(str);
            throw null;
        } else if (aVar != null) {
            aVar.b(str);
            throw null;
        } else {
            Typeface createFromAsset = Typeface.createFromAsset(this.f41316d, "fonts/" + str + this.f41318f);
            this.f41315c.put(str, createFromAsset);
            return createFromAsset;
        }
    }

    public Typeface b(String str, String str2) {
        this.f41313a.b(str, str2);
        Typeface typeface = this.f41314b.get(this.f41313a);
        if (typeface != null) {
            return typeface;
        }
        Typeface d2 = d(a(str), str2);
        this.f41314b.put(this.f41313a, d2);
        return d2;
    }

    public void c(@Nullable d.a.a.a aVar) {
        this.f41317e = aVar;
    }

    public final Typeface d(Typeface typeface, String str) {
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        int i = (contains && contains2) ? 3 : contains ? 2 : contains2 ? 1 : 0;
        return typeface.getStyle() == i ? typeface : Typeface.create(typeface, i);
    }
}
