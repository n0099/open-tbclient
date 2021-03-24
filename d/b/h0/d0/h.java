package d.b.h0.d0;

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
import d.b.b.e.p.l;
/* loaded from: classes3.dex */
public class h extends a {
    public static final int i = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds312);
    public static final int j = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds84);
    public static final int k = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
    public static final int l = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds32);
    public static final int m = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);

    /* renamed from: a  reason: collision with root package name */
    public ImageView f50111a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f50112b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f50113c;

    /* renamed from: d  reason: collision with root package name */
    public TBSpecificationBtn f50114d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f50115e;

    /* renamed from: f  reason: collision with root package name */
    public int f50116f;

    /* renamed from: g  reason: collision with root package name */
    public int f50117g;

    /* renamed from: h  reason: collision with root package name */
    public int f50118h;

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.net_refresh_view_layout, (ViewGroup) null));
        this.f50111a = (ImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.f50112b = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.f50113c = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.f50115e = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.f50114d = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        d.b.h0.r.f0.m.a aVar = new d.b.h0.r.f0.m.a();
        this.f50114d.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.f50114d.setTextSize(R.dimen.T_X05);
        this.f50114d.setConfig(aVar);
        this.f50116f = R.drawable.new_pic_emotion_08;
        this.f50117g = R.color.CAM_X0107;
        this.f50118h = R.color.CAM_X0109;
        this.f50114d.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
        k(0);
    }

    public final void a() {
        if (this.f50114d.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = this.f50115e.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = j;
                this.f50115e.setLayoutParams(marginLayoutParams);
            }
            this.f50112b.setVisibility(8);
            this.f50117g = R.color.CAM_X0107;
        } else if (this.f50112b.getVisibility() == 8) {
            ViewGroup.LayoutParams layoutParams2 = this.f50115e.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams2.topMargin = j;
                this.f50115e.setLayoutParams(marginLayoutParams2);
            }
            this.f50117g = R.color.CAM_X0107;
        } else if (this.f50113c.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams3 = this.f50115e.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                marginLayoutParams3.topMargin = l;
                this.f50115e.setLayoutParams(marginLayoutParams3);
            }
            ViewGroup.LayoutParams layoutParams4 = this.f50113c.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                marginLayoutParams4.topMargin = m;
                this.f50113c.setLayoutParams(marginLayoutParams4);
            }
            this.f50117g = R.color.CAM_X0107;
            this.f50118h = R.color.CAM_X0109;
        } else {
            ViewGroup.LayoutParams layoutParams5 = this.f50111a.getLayoutParams();
            int i2 = i;
            layoutParams5.width = i2;
            layoutParams5.height = i2;
            this.f50111a.setLayoutParams(layoutParams5);
            ViewGroup.LayoutParams layoutParams6 = this.f50115e.getLayoutParams();
            if (layoutParams6 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams6;
                marginLayoutParams5.topMargin = k;
                this.f50115e.setLayoutParams(marginLayoutParams5);
            }
            this.f50118h = R.color.CAM_X0109;
        }
        onChangeSkinType();
    }

    public View b() {
        return this.attachedView;
    }

    public View c() {
        return this.f50114d;
    }

    public TextView d() {
        return this.f50113c;
    }

    public void e() {
        this.f50114d.setVisibility(8);
        this.f50113c.setVisibility(8);
        SkinManager.setViewTextColor(this.f50112b, R.color.CAM_X0109, 1);
        a();
    }

    public void f(int i2) {
        SkinManager.setBackgroundColor(this.attachedView, i2);
    }

    public void g(String str) {
        if (str == null) {
            return;
        }
        this.f50114d.setText(str);
    }

    public void h(int i2) {
        this.f50116f = i2;
        SkinManager.setImageResource(this.f50111a, i2);
    }

    public void i(int i2) {
        this.f50116f = i2;
    }

    public void j(int i2) {
        ViewGroup.LayoutParams layoutParams = this.f50111a.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i2;
            this.f50111a.setLayoutParams(marginLayoutParams);
        }
    }

    public void k(int i2) {
        int i3;
        if (i2 < 0) {
            i2 = 0;
        }
        int i4 = l.i(TbadkCoreApplication.getInst());
        if (i4 <= 0) {
            i3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds200);
        } else {
            double d2 = i4;
            Double.isNaN(d2);
            i3 = (int) (d2 * 0.16d);
        }
        ViewGroup.LayoutParams layoutParams = this.f50111a.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i3 + i2;
            this.f50111a.setLayoutParams(marginLayoutParams);
        }
    }

    public void l(String str) {
        if (str == null) {
            this.f50112b.setVisibility(8);
        } else {
            this.f50112b.setVisibility(0);
            this.f50112b.setText(str);
        }
        a();
    }

    public void m(String str) {
        if (str == null) {
            return;
        }
        this.f50113c.setText(str);
    }

    public void n(String str) {
        if (str == null) {
            return;
        }
        this.f50113c.setText(str);
        this.f50113c.setVisibility(0);
        a();
    }

    public void o() {
        this.f50114d.setVisibility(0);
        this.f50113c.setVisibility(0);
        SkinManager.setViewTextColor(this.f50112b, R.color.CAM_X0109, 1);
        a();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        SkinManager.setImageResource(this.f50111a, this.f50116f);
        SkinManager.setViewTextColor(this.f50112b, this.f50118h, 1, skinType);
        SkinManager.setViewTextColor(this.f50113c, this.f50117g, 1, skinType);
        TBSpecificationBtn tBSpecificationBtn = this.f50114d;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.k();
        }
    }

    @Override // d.b.h0.d0.a
    public void onViewAttached() {
        super.onViewAttached();
        onChangeSkinType();
    }

    @Override // d.b.h0.d0.a
    public void onViewDettached() {
        super.onViewDettached();
        this.f50111a.setImageResource(0);
    }
}
