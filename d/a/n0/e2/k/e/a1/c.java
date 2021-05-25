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
    public PbFragment f53097a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.e2.i.c f53098b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f53099c = null;

    /* renamed from: d  reason: collision with root package name */
    public TextView f53100d = null;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f53101e;

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
        this.f53097a = pbFragment;
        this.f53098b = cVar;
        b();
    }

    public void a(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.f53099c.setVisibility(0);
            bdTypeListView.addHeaderView(this.f53099c);
        }
    }

    public final void b() {
        if (this.f53099c != null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f53097a.getContext()).inflate(R.layout.new_pb_title, (ViewGroup) null);
        this.f53099c = relativeLayout;
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
        this.f53101e = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -r0.f());
        this.f53101e.setImageMatrix(matrix);
        TextView textView = (TextView) this.f53099c.findViewById(R.id.tv_pb_title);
        this.f53100d = textView;
        d.a.m0.r.u.c d2 = d.a.m0.r.u.c.d(textView);
        d2.w(R.dimen.T_X03);
        d2.t(R.dimen.M_T_X003);
        d2.s(R.color.CAM_X0105);
        d2.x(R.string.F_X02);
        d2.p(R.color.CAM_X0304);
        this.f53100d.setVisibility(8);
        if (this.f53100d.getParent() == null) {
            this.f53099c.addView(this.f53100d);
        }
        this.f53099c.setOnTouchListener(this.f53098b);
        this.f53099c.setOnLongClickListener(new a(this));
    }

    public void c(int i2) {
        SkinManager.setBackgroundColor(this.f53099c, R.color.CAM_X0205);
        TextView textView = this.f53100d;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
            this.f53100d.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.f53099c.setVisibility(8);
            bdTypeListView.removeHeaderView(this.f53099c);
        }
    }

    public void e(d.a.n0.e2.h.e eVar) {
        if (eVar == null || eVar.L() == null) {
            return;
        }
        SpannableStringBuilder m1 = eVar.L().m1();
        SpannableString c2 = r0.c(eVar.L());
        if (!StringUtils.isNull(eVar.L().z1())) {
            if (c2 != null) {
                m1.append((CharSequence) c2);
                this.f53100d.setText(m1, TextView.BufferType.SPANNABLE);
            } else {
                this.f53100d.setText(m1);
            }
            h(eVar);
            this.f53100d.setVisibility(0);
            this.f53100d.setMaxLines(3);
            this.f53100d.setEllipsize(TextUtils.TruncateAt.END);
            this.f53100d.invalidate();
            return;
        }
        this.f53100d.setVisibility(8);
    }

    public void f(d.a.n0.e2.h.e eVar) {
        if (eVar != null && !eVar.L().C2() && this.f53100d.getText() != null && this.f53100d.getText().length() > 0) {
            this.f53100d.setVisibility(0);
        } else {
            this.f53100d.setVisibility(8);
        }
    }

    public void g(d.a.n0.e2.h.e eVar) {
        if (eVar == null || eVar.L() == null) {
            return;
        }
        SpannableStringBuilder m1 = eVar.L().m1();
        this.f53100d.setOnTouchListener(new i(m1));
        this.f53100d.setText(m1);
        this.f53100d.setVisibility(0);
    }

    public void h(d.a.n0.e2.h.e eVar) {
        if (this.f53100d == null) {
            return;
        }
        int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds56);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f53100d.getLayoutParams();
        if (eVar.a0()) {
            g2 = 0;
        }
        layoutParams.bottomMargin = g2;
        this.f53100d.setLayoutParams(layoutParams);
    }
}
