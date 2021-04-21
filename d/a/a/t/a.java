package d.a.a.t;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Nullable;
import d.a.a.u.h;
import d.a.a.x.d;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public final AssetManager f41718d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public d.a.a.a f41719e;

    /* renamed from: a  reason: collision with root package name */
    public final h<String> f41715a = new h<>();

    /* renamed from: b  reason: collision with root package name */
    public final Map<h<String>, Typeface> f41716b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, Typeface> f41717c = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public String f41720f = ".ttf";

    public a(Drawable.Callback callback, @Nullable d.a.a.a aVar) {
        this.f41719e = aVar;
        if (!(callback instanceof View)) {
            d.c("LottieDrawable must be inside of a view for images to work.");
            this.f41718d = null;
            return;
        }
        this.f41718d = ((View) callback).getContext().getAssets();
    }

    public final Typeface a(String str) {
        String b2;
        Typeface typeface = this.f41717c.get(str);
        if (typeface != null) {
            return typeface;
        }
        d.a.a.a aVar = this.f41719e;
        Typeface a2 = aVar != null ? aVar.a(str) : null;
        d.a.a.a aVar2 = this.f41719e;
        if (aVar2 != null && a2 == null && (b2 = aVar2.b(str)) != null) {
            a2 = Typeface.createFromAsset(this.f41718d, b2);
        }
        if (a2 == null) {
            a2 = Typeface.createFromAsset(this.f41718d, "fonts/" + str + this.f41720f);
        }
        this.f41717c.put(str, a2);
        return a2;
    }

    public Typeface b(String str, String str2) {
        this.f41715a.b(str, str2);
        Typeface typeface = this.f41716b.get(this.f41715a);
        if (typeface != null) {
            return typeface;
        }
        Typeface d2 = d(a(str), str2);
        this.f41716b.put(this.f41715a, d2);
        return d2;
    }

    public void c(@Nullable d.a.a.a aVar) {
        this.f41719e = aVar;
    }

    public final Typeface d(Typeface typeface, String str) {
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        int i = (contains && contains2) ? 3 : contains ? 2 : contains2 ? 1 : 0;
        return typeface.getStyle() == i ? typeface : Typeface.create(typeface, i);
    }
}
