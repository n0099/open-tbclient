package d.b.h0.g.k0.i.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import d.b.h0.a.f;
import d.b.h0.a.g;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public View f49015a;

    /* renamed from: b  reason: collision with root package name */
    public SimpleDraweeView f49016b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f49017c;

    public b(Context context) {
        View inflate = LayoutInflater.from(context).inflate(g.swangame_recommend_button, (ViewGroup) null);
        this.f49015a = inflate;
        this.f49016b = (SimpleDraweeView) inflate.findViewById(f.swangame_recommend_button_icon);
        this.f49017c = (TextView) this.f49015a.findViewById(f.swangame_recommend_button_name);
    }
}
