package d.b.i0.c2.k.e.x0;

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
import d.b.b.e.p.l;
import d.b.i0.c2.k.e.p0;
import d.b.i0.t3.i;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f52900a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.c2.i.c f52901b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f52902c = null;

    /* renamed from: d  reason: collision with root package name */
    public TextView f52903d = null;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f52904e;

    /* loaded from: classes4.dex */
    public class a implements View.OnLongClickListener {
        public a(c cVar) {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return false;
        }
    }

    public c(PbFragment pbFragment, d.b.i0.c2.i.c cVar) {
        this.f52900a = pbFragment;
        this.f52901b = cVar;
        b();
    }

    public void a(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.f52902c.setVisibility(0);
            bdTypeListView.addHeaderView(this.f52902c);
        }
    }

    public final void b() {
        if (this.f52902c != null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f52900a.getContext()).inflate(R.layout.new_pb_title, (ViewGroup) null);
        this.f52902c = relativeLayout;
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
        this.f52904e = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -p0.e());
        this.f52904e.setImageMatrix(matrix);
        TextView textView = (TextView) this.f52902c.findViewById(R.id.tv_pb_title);
        this.f52903d = textView;
        d.b.h0.r.u.c a2 = d.b.h0.r.u.c.a(textView);
        a2.r(R.dimen.T_X03);
        a2.o(R.dimen.M_T_X003);
        a2.n(R.color.CAM_X0105);
        a2.s(R.string.F_X02);
        a2.k(R.color.CAM_X0304);
        this.f52903d.setVisibility(8);
        if (this.f52903d.getParent() == null) {
            this.f52902c.addView(this.f52903d);
        }
        this.f52902c.setOnTouchListener(this.f52901b);
        this.f52902c.setOnLongClickListener(new a(this));
    }

    public void c(int i) {
        TextView textView = this.f52903d;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
            this.f52903d.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.f52902c.setVisibility(8);
            bdTypeListView.removeHeaderView(this.f52902c);
        }
    }

    public void e(d.b.i0.c2.h.e eVar) {
        if (eVar == null || eVar.L() == null) {
            return;
        }
        SpannableStringBuilder l1 = eVar.L().l1();
        SpannableString b2 = p0.b(eVar.L());
        if (!StringUtils.isNull(eVar.L().x1())) {
            if (b2 != null) {
                l1.append((CharSequence) b2);
                this.f52903d.setText(l1, TextView.BufferType.SPANNABLE);
            } else {
                this.f52903d.setText(l1);
            }
            h(eVar);
            this.f52903d.setVisibility(0);
            this.f52903d.setMaxLines(3);
            this.f52903d.setEllipsize(TextUtils.TruncateAt.END);
            this.f52903d.invalidate();
            return;
        }
        this.f52903d.setVisibility(8);
    }

    public void f(d.b.i0.c2.h.e eVar) {
        if (eVar != null && !eVar.L().y2() && this.f52903d.getText() != null && this.f52903d.getText().length() > 0) {
            this.f52903d.setVisibility(0);
        } else {
            this.f52903d.setVisibility(8);
        }
    }

    public void g(d.b.i0.c2.h.e eVar) {
        if (eVar == null || eVar.L() == null) {
            return;
        }
        SpannableStringBuilder l1 = eVar.L().l1();
        this.f52903d.setOnTouchListener(new i(l1));
        this.f52903d.setText(l1);
        this.f52903d.setVisibility(0);
    }

    public void h(d.b.i0.c2.h.e eVar) {
        if (this.f52903d == null) {
            return;
        }
        int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds56);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f52903d.getLayoutParams();
        if (eVar.Z()) {
            g2 = 0;
        }
        layoutParams.bottomMargin = g2;
        this.f52903d.setLayoutParams(layoutParams);
    }
}
