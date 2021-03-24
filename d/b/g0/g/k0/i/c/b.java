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
    public View f48293a;

    /* renamed from: b  reason: collision with root package name */
    public SimpleDraweeView f48294b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f48295c;

    public b(Context context) {
        View inflate = LayoutInflater.from(context).inflate(g.swangame_recommend_button, (ViewGroup) null);
        this.f48293a = inflate;
        this.f48294b = (SimpleDraweeView) inflate.findViewById(f.swangame_recommend_button_icon);
        this.f48295c = (TextView) this.f48293a.findViewById(f.swangame_recommend_button_name);
    }
}
