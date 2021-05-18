package d.a.k0.h1.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f55502e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f55503f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f55504g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f55505h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f55506i;
    public ImageView j;
    public TextView k;
    public int l;
    public int m;
    public int n;

    public a(Context context) {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.label_recommend_header, (ViewGroup) null);
        this.f55502e = viewGroup;
        this.f55503f = (TextView) viewGroup.findViewById(R.id.choose_like_label);
        this.f55504g = (TextView) this.f55502e.findViewById(R.id.recommend_interest_thread);
        this.f55505h = (ImageView) this.f55502e.findViewById(R.id.male_icon);
        this.f55506i = (TextView) this.f55502e.findViewById(R.id.male_text);
        this.j = (ImageView) this.f55502e.findViewById(R.id.female_icon);
        this.k = (TextView) this.f55502e.findViewById(R.id.female_text);
        this.f55505h.setOnClickListener(this);
        this.j.setOnClickListener(this);
        c();
    }

    public ViewGroup a() {
        return this.f55502e;
    }

    public int b() {
        return this.n;
    }

    public final void c() {
        SkinManager.setViewTextColor(this.f55503f, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f55504g, R.color.CAM_X0109);
        SkinManager.setImageResource(this.f55505h, R.drawable.img_lable_boy_n);
        SkinManager.setViewTextColor(this.f55506i, R.color.CAM_X0109);
        SkinManager.setImageResource(this.j, R.drawable.img_lable_girl_n);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0109);
    }

    public void d(List<d.a.k0.h1.b.a> list) {
        if (ListUtils.getCount(list) == 2) {
            this.l = list.get(0).f55496a;
            this.m = list.get(1).f55496a;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.f55505h) {
            z = true;
        } else {
            ImageView imageView = this.j;
        }
        this.n = z ? this.l : this.m;
        SkinManager.setImageResource(this.f55505h, z ? R.drawable.img_lable_boy_s : R.drawable.img_lable_boy_n);
        SkinManager.setViewTextColor(this.f55506i, z ? R.color.CAM_X0302 : R.color.CAM_X0109);
        SkinManager.setImageResource(this.j, z ? R.drawable.img_lable_girl_n : R.drawable.img_lable_girl_s);
        SkinManager.setViewTextColor(this.k, z ? R.color.CAM_X0109 : R.color.CAM_X0301);
    }
}
