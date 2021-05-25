package d.a.l0.h.o0.g.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import d.a.l0.f.e;
import d.a.l0.f.f;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public View f47598a;

    /* renamed from: b  reason: collision with root package name */
    public SimpleDraweeView f47599b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f47600c;

    @SuppressLint({"InflateParams"})
    public b(Context context) {
        View inflate = LayoutInflater.from(context).inflate(f.swangame_recommend_button, (ViewGroup) null);
        this.f47598a = inflate;
        this.f47599b = (SimpleDraweeView) inflate.findViewById(e.swangame_recommend_button_icon);
        this.f47600c = (TextView) this.f47598a.findViewById(e.swangame_recommend_button_name);
    }
}
