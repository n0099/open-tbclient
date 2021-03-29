package d.b.g0.g.k0.i.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import d.b.g0.a.f;
import d.b.g0.a.g;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public View f48294a;

    /* renamed from: b  reason: collision with root package name */
    public SimpleDraweeView f48295b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f48296c;

    public b(Context context) {
        View inflate = LayoutInflater.from(context).inflate(g.swangame_recommend_button, (ViewGroup) null);
        this.f48294a = inflate;
        this.f48295b = (SimpleDraweeView) inflate.findViewById(f.swangame_recommend_button_icon);
        this.f48296c = (TextView) this.f48294a.findViewById(f.swangame_recommend_button_name);
    }
}
