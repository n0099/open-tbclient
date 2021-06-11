package d.a.n0.e2.k.e.a1;

import android.graphics.Matrix;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import d.a.c.e.p.l;
import d.a.n0.e2.k.e.r0;
import d.a.n0.v3.i;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f56786a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.e2.i.c f56787b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f56788c = null;

    /* renamed from: d  reason: collision with root package name */
    public TextView f56789d = null;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f56790e;

    /* loaded from: classes5.dex */
    public class a implements View.OnLongClickListener {
        public a(c cVar) {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return false;
        }
    }

    public c(PbFragment pbFragment, d.a.n0.e2.i.c cVar) {
        this.f56786a = pbFragment;
        this.f56787b = cVar;
        b();
    }

    public void a(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.f56788c.setVisibility(0);
            bdTypeListView.addHeaderView(this.f56788c);
        }
    }

    public final void b() {
        if (this.f56788c != null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f56786a.getContext()).inflate(R.layout.new_pb_title, (ViewGroup) null);
        this.f56788c = relativeLayout;
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
        this.f56790e = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -r0.f());
        this.f56790e.setImageMatrix(matrix);
        TextView textView = (TextView) this.f56788c.findViewById(R.id.tv_pb_title);
        this.f56789d = textView;
        d.a.m0.r.u.c d2 = d.a.m0.r.u.c.d(textView);
        d2.w(R.dimen.T_X03);
        d2.t(R.dimen.M_T_X003);
        d2.s(R.color.CAM_X0105);
        d2.x(R.string.F_X02);
        d2.p(R.color.CAM_X0304);
        this.f56789d.setVisibility(8);
        if (this.f56789d.getParent() == null) {
            this.f56788c.addView(this.f56789d);
        }
        this.f56788c.setOnTouchListener(this.f56787b);
        this.f56788c.setOnLongClickListener(new a(this));
    }

    public void c(int i2) {
        SkinManager.setBackgroundColor(this.f56788c, R.color.CAM_X0205);
        TextView textView = this.f56789d;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
            this.f56789d.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.f56788c.setVisibility(8);
            bdTypeListView.removeHeaderView(this.f56788c);
        }
    }

    public void e(d.a.n0.e2.h.e eVar) {
        if (eVar == null || eVar.L() == null) {
            return;
        }
        SpannableStringBuilder n1 = eVar.L().n1();
        SpannableString c2 = r0.c(eVar.L());
        if (!StringUtils.isNull(eVar.L().A1())) {
            if (c2 != null) {
                n1.append((CharSequence) c2);
                this.f56789d.setText(n1, TextView.BufferType.SPANNABLE);
            } else {
                this.f56789d.setText(n1);
            }
            h(eVar);
            this.f56789d.setVisibility(0);
            this.f56789d.setMaxLines(3);
            this.f56789d.setEllipsize(TextUtils.TruncateAt.END);
            this.f56789d.invalidate();
            return;
        }
        this.f56789d.setVisibility(8);
    }

    public void f(d.a.n0.e2.h.e eVar) {
        if (eVar != null && !eVar.L().D2() && this.f56789d.getText() != null && this.f56789d.getText().length() > 0) {
            this.f56789d.setVisibility(0);
        } else {
            this.f56789d.setVisibility(8);
        }
    }

    public void g(d.a.n0.e2.h.e eVar) {
        if (eVar == null || eVar.L() == null) {
            return;
        }
        SpannableStringBuilder n1 = eVar.L().n1();
        this.f56789d.setOnTouchListener(new i(n1));
        this.f56789d.setText(n1);
        this.f56789d.setVisibility(0);
    }

    public void h(d.a.n0.e2.h.e eVar) {
        if (this.f56789d == null) {
            return;
        }
        int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds56);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f56789d.getLayoutParams();
        if (eVar.a0()) {
            g2 = 0;
        }
        layoutParams.bottomMargin = g2;
        this.f56789d.setLayoutParams(layoutParams);
    }
}
