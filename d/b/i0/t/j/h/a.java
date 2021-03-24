package d.b.i0.t.j.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a extends d.b.i0.x.b<d.b.i0.t.j.d.b> {
    public View m;
    public TextView n;
    public TextView o;
    public HeadImageView p;
    public HeadImageView q;
    public HeadImageView r;
    public ImageView s;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        v(m());
    }

    public void A(String str) {
        TextView textView = this.n;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.ala_person_center_list_normal_item;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        if (i == 1) {
            this.s.setAlpha(0.7f);
        } else {
            this.s.setAlpha(1);
        }
        this.m.setBackgroundColor(SkinManager.getColor(i, R.color.CAM_X0204));
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0109);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public TextView u() {
        TextView textView = this.o;
        if (textView != null) {
            return textView;
        }
        return null;
    }

    public final void v(View view) {
        this.m = view.findViewById(R.id.ala_person_center_list_item_sep);
        this.n = (TextView) view.findViewById(R.id.ala_person_center_list_item_title_txt);
        this.o = (TextView) view.findViewById(R.id.ala_person_center_list_item_desc_txt);
        this.s = (ImageView) view.findViewById(R.id.ala_person_center_list_item_arrow_img);
        this.p = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img1);
        this.q = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img2);
        this.r = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: w */
    public void n(d.b.i0.t.j.d.b bVar) {
    }

    public void x(String str) {
        TextView textView = this.o;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void y(int i) {
        ImageView imageView = this.s;
        if (imageView != null) {
            imageView.setVisibility(i);
        }
    }

    public void z(int i) {
        View view = this.m;
        if (view != null) {
            view.setVisibility(i);
        }
    }
}
