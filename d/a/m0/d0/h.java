package d.a.m0.d0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class h extends a {

    /* renamed from: i  reason: collision with root package name */
    public static final int f49290i = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds312);
    public static final int j = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds84);
    public static final int k = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
    public static final int l = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds32);
    public static final int m = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);

    /* renamed from: a  reason: collision with root package name */
    public ImageView f49291a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f49292b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f49293c;

    /* renamed from: d  reason: collision with root package name */
    public TBSpecificationBtn f49294d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f49295e;

    /* renamed from: f  reason: collision with root package name */
    public int f49296f;

    /* renamed from: g  reason: collision with root package name */
    public int f49297g;

    /* renamed from: h  reason: collision with root package name */
    public int f49298h;

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.net_refresh_view_layout, (ViewGroup) null));
        this.f49291a = (ImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.f49292b = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.f49293c = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.f49295e = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.f49294d = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        d.a.m0.r.f0.m.a aVar = new d.a.m0.r.f0.m.a();
        this.f49294d.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.f49294d.setTextSize(R.dimen.T_X05);
        this.f49294d.setConfig(aVar);
        this.f49296f = R.drawable.new_pic_emotion_08;
        this.f49297g = R.color.CAM_X0107;
        this.f49298h = R.color.CAM_X0109;
        this.f49294d.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
        k(0);
    }

    public final void a() {
        if (this.f49294d.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = this.f49295e.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = j;
                this.f49295e.setLayoutParams(marginLayoutParams);
            }
            this.f49292b.setVisibility(8);
            this.f49297g = R.color.CAM_X0107;
        } else if (this.f49292b.getVisibility() == 8) {
            ViewGroup.LayoutParams layoutParams2 = this.f49295e.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams2.topMargin = j;
                this.f49295e.setLayoutParams(marginLayoutParams2);
            }
            this.f49297g = R.color.CAM_X0107;
        } else if (this.f49293c.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams3 = this.f49295e.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                marginLayoutParams3.topMargin = l;
                this.f49295e.setLayoutParams(marginLayoutParams3);
            }
            ViewGroup.LayoutParams layoutParams4 = this.f49293c.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                marginLayoutParams4.topMargin = m;
                this.f49293c.setLayoutParams(marginLayoutParams4);
            }
            this.f49297g = R.color.CAM_X0107;
            this.f49298h = R.color.CAM_X0109;
        } else {
            ViewGroup.LayoutParams layoutParams5 = this.f49291a.getLayoutParams();
            int i2 = f49290i;
            layoutParams5.width = i2;
            layoutParams5.height = i2;
            this.f49291a.setLayoutParams(layoutParams5);
            ViewGroup.LayoutParams layoutParams6 = this.f49295e.getLayoutParams();
            if (layoutParams6 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams6;
                marginLayoutParams5.topMargin = k;
                this.f49295e.setLayoutParams(marginLayoutParams5);
            }
            this.f49298h = R.color.CAM_X0109;
        }
        onChangeSkinType();
    }

    public View b() {
        return this.attachedView;
    }

    public View c() {
        return this.f49294d;
    }

    public TextView d() {
        return this.f49293c;
    }

    public void e() {
        this.f49294d.setVisibility(8);
        this.f49293c.setVisibility(8);
        SkinManager.setViewTextColor(this.f49292b, R.color.CAM_X0109, 1);
        a();
    }

    public void f(int i2) {
        SkinManager.setBackgroundColor(this.attachedView, i2);
    }

    public void g(String str) {
        if (str == null) {
            return;
        }
        this.f49294d.setText(str);
    }

    public void h(int i2) {
        this.f49296f = i2;
        SkinManager.setImageResource(this.f49291a, i2);
    }

    public void i(int i2) {
        this.f49296f = i2;
    }

    public void j(int i2) {
        ViewGroup.LayoutParams layoutParams = this.f49291a.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i2;
            this.f49291a.setLayoutParams(marginLayoutParams);
        }
    }

    public void k(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        int i3 = l.i(TbadkCoreApplication.getInst());
        int dimensionPixelSize = i3 <= 0 ? TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds200) : (int) (i3 * 0.16d);
        ViewGroup.LayoutParams layoutParams = this.f49291a.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = dimensionPixelSize + i2;
            this.f49291a.setLayoutParams(marginLayoutParams);
        }
    }

    public void l(String str) {
        if (str == null) {
            this.f49292b.setVisibility(8);
        } else {
            this.f49292b.setVisibility(0);
            this.f49292b.setText(str);
        }
        a();
    }

    public void m(String str) {
        if (str == null) {
            return;
        }
        this.f49293c.setText(str);
    }

    public void n(String str) {
        if (str == null) {
            return;
        }
        this.f49293c.setText(str);
        this.f49293c.setVisibility(0);
        a();
    }

    public void o() {
        this.f49294d.setVisibility(0);
        this.f49293c.setVisibility(0);
        SkinManager.setViewTextColor(this.f49292b, R.color.CAM_X0109, 1);
        a();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        SkinManager.setImageResource(this.f49291a, this.f49296f);
        SkinManager.setViewTextColor(this.f49292b, this.f49298h, 1, skinType);
        SkinManager.setViewTextColor(this.f49293c, this.f49297g, 1, skinType);
        TBSpecificationBtn tBSpecificationBtn = this.f49294d;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.k();
        }
    }

    @Override // d.a.m0.d0.a
    public void onViewAttached() {
        super.onViewAttached();
        onChangeSkinType();
    }

    @Override // d.a.m0.d0.a
    public void onViewDettached() {
        super.onViewDettached();
        this.f49291a.setImageResource(0);
    }
}
