package d.a.o0.v.j.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a extends d.a.o0.z.b<d.a.o0.v.j.d.b> {
    public View m;
    public TextView n;
    public TextView o;
    public HeadImageView p;
    public HeadImageView q;
    public HeadImageView r;
    public ImageView s;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        u(m());
    }

    @Override // d.a.o0.z.b
    public int h() {
        return R.layout.ala_person_center_list_normal_item;
    }

    @Override // d.a.o0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        if (i2 == 1) {
            this.s.setAlpha(0.7f);
        } else {
            this.s.setAlpha(1);
        }
        this.m.setBackgroundColor(SkinManager.getColor(i2, R.color.CAM_X0204));
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0109);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public TextView t() {
        TextView textView = this.o;
        if (textView != null) {
            return textView;
        }
        return null;
    }

    public final void u(View view) {
        this.m = view.findViewById(R.id.ala_person_center_list_item_sep);
        this.n = (TextView) view.findViewById(R.id.ala_person_center_list_item_title_txt);
        this.o = (TextView) view.findViewById(R.id.ala_person_center_list_item_desc_txt);
        this.s = (ImageView) view.findViewById(R.id.ala_person_center_list_item_arrow_img);
        this.p = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img1);
        this.q = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img2);
        this.r = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.z.b
    /* renamed from: v */
    public void n(d.a.o0.v.j.d.b bVar) {
    }

    public void w(String str) {
        TextView textView = this.o;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void x(int i2) {
        ImageView imageView = this.s;
        if (imageView != null) {
            imageView.setVisibility(i2);
        }
    }

    public void y(int i2) {
        View view = this.m;
        if (view != null) {
            view.setVisibility(i2);
        }
    }

    public void z(String str) {
        TextView textView = this.n;
        if (textView != null) {
            textView.setText(str);
        }
    }
}
