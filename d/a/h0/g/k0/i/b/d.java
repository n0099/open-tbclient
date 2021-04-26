package d.a.h0.g.k0.i.b;

import android.content.res.Resources;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes3.dex */
public class d {
    @V8JavascriptField
    public volatile float height;
    @V8JavascriptField
    public volatile float left;
    @V8JavascriptField
    public volatile float top;
    @V8JavascriptField
    public volatile float width;

    /* loaded from: classes3.dex */
    public interface a {
    }

    public d() {
        Resources resources = d.a.h0.a.w0.a.c() != null ? d.a.h0.a.w0.a.c().getResources() : null;
        this.left = a(resources, d.a.h0.a.d.swangame_recommend_button_default_left);
        this.top = a(resources, d.a.h0.a.d.swangame_recommend_button_default_top);
        this.width = a(resources, d.a.h0.a.d.swangame_recommend_button_default_width);
        this.height = a(resources, d.a.h0.a.d.swangame_recommend_button_default_height);
    }

    public final float a(Resources resources, int i2) {
        if (resources == null || i2 == 0) {
            return 0.0f;
        }
        return d.a.h0.g.i0.e.b(resources.getDimension(i2));
    }

    public void b(a aVar) {
    }

    public String toString() {
        return "{left=" + this.left + ", top=" + this.top + ", width=" + this.width + ", height=" + this.height + "}";
    }
}
