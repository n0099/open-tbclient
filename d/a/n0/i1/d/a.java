package d.a.n0.i1.d;

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
    public ViewGroup f59379e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f59380f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f59381g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f59382h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f59383i;
    public ImageView j;
    public TextView k;
    public int l;
    public int m;
    public int n;

    public a(Context context) {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.label_recommend_header, (ViewGroup) null);
        this.f59379e = viewGroup;
        this.f59380f = (TextView) viewGroup.findViewById(R.id.choose_like_label);
        this.f59381g = (TextView) this.f59379e.findViewById(R.id.recommend_interest_thread);
        this.f59382h = (ImageView) this.f59379e.findViewById(R.id.male_icon);
        this.f59383i = (TextView) this.f59379e.findViewById(R.id.male_text);
        this.j = (ImageView) this.f59379e.findViewById(R.id.female_icon);
        this.k = (TextView) this.f59379e.findViewById(R.id.female_text);
        this.f59382h.setOnClickListener(this);
        this.j.setOnClickListener(this);
        c();
    }

    public ViewGroup a() {
        return this.f59379e;
    }

    public int b() {
        return this.n;
    }

    public final void c() {
        SkinManager.setViewTextColor(this.f59380f, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f59381g, R.color.CAM_X0109);
        SkinManager.setImageResource(this.f59382h, R.drawable.img_lable_boy_n);
        SkinManager.setViewTextColor(this.f59383i, R.color.CAM_X0109);
        SkinManager.setImageResource(this.j, R.drawable.img_lable_girl_n);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0109);
    }

    public void d(List<d.a.n0.i1.b.a> list) {
        if (ListUtils.getCount(list) == 2) {
            this.l = list.get(0).f59373a;
            this.m = list.get(1).f59373a;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.f59382h) {
            z = true;
        } else {
            ImageView imageView = this.j;
        }
        this.n = z ? this.l : this.m;
        SkinManager.setImageResource(this.f59382h, z ? R.drawable.img_lable_boy_s : R.drawable.img_lable_boy_n);
        SkinManager.setViewTextColor(this.f59383i, z ? R.color.CAM_X0302 : R.color.CAM_X0109);
        SkinManager.setImageResource(this.j, z ? R.drawable.img_lable_girl_n : R.drawable.img_lable_girl_s);
        SkinManager.setViewTextColor(this.k, z ? R.color.CAM_X0109 : R.color.CAM_X0301);
    }
}
