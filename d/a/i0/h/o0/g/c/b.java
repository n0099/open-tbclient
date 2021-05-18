package d.a.i0.h.o0.g.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import d.a.i0.f.e;
import d.a.i0.f.f;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public View f47422a;

    /* renamed from: b  reason: collision with root package name */
    public SimpleDraweeView f47423b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f47424c;

    @SuppressLint({"InflateParams"})
    public b(Context context) {
        View inflate = LayoutInflater.from(context).inflate(f.swangame_recommend_button, (ViewGroup) null);
        this.f47422a = inflate;
        this.f47423b = (SimpleDraweeView) inflate.findViewById(e.swangame_recommend_button_icon);
        this.f47424c = (TextView) this.f47422a.findViewById(e.swangame_recommend_button_name);
    }
}
