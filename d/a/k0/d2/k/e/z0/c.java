package d.a.k0.d2.k.e.z0;

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
import d.a.k0.d2.k.e.r0;
import d.a.k0.u3.i;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f53336a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.k0.d2.i.c f53337b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f53338c = null;

    /* renamed from: d  reason: collision with root package name */
    public TextView f53339d = null;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f53340e;

    /* loaded from: classes5.dex */
    public class a implements View.OnLongClickListener {
        public a(c cVar) {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return false;
        }
    }

    public c(PbFragment pbFragment, d.a.k0.d2.i.c cVar) {
        this.f53336a = pbFragment;
        this.f53337b = cVar;
        b();
    }

    public void a(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.f53338c.setVisibility(0);
            bdTypeListView.addHeaderView(this.f53338c);
        }
    }

    public final void b() {
        if (this.f53338c != null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f53336a.getContext()).inflate(R.layout.new_pb_title, (ViewGroup) null);
        this.f53338c = relativeLayout;
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
        this.f53340e = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -r0.f());
        this.f53340e.setImageMatrix(matrix);
        TextView textView = (TextView) this.f53338c.findViewById(R.id.tv_pb_title);
        this.f53339d = textView;
        d.a.j0.r.u.c d2 = d.a.j0.r.u.c.d(textView);
        d2.u(R.dimen.T_X03);
        d2.r(R.dimen.M_T_X003);
        d2.q(R.color.CAM_X0105);
        d2.v(R.string.F_X02);
        d2.n(R.color.CAM_X0304);
        this.f53339d.setVisibility(8);
        if (this.f53339d.getParent() == null) {
            this.f53338c.addView(this.f53339d);
        }
        this.f53338c.setOnTouchListener(this.f53337b);
        this.f53338c.setOnLongClickListener(new a(this));
    }

    public void c(int i2) {
        TextView textView = this.f53339d;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
            this.f53339d.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.f53338c.setVisibility(8);
            bdTypeListView.removeHeaderView(this.f53338c);
        }
    }

    public void e(d.a.k0.d2.h.e eVar) {
        if (eVar == null || eVar.L() == null) {
            return;
        }
        SpannableStringBuilder l1 = eVar.L().l1();
        SpannableString c2 = r0.c(eVar.L());
        if (!StringUtils.isNull(eVar.L().y1())) {
            if (c2 != null) {
                l1.append((CharSequence) c2);
                this.f53339d.setText(l1, TextView.BufferType.SPANNABLE);
            } else {
                this.f53339d.setText(l1);
            }
            h(eVar);
            this.f53339d.setVisibility(0);
            this.f53339d.setMaxLines(3);
            this.f53339d.setEllipsize(TextUtils.TruncateAt.END);
            this.f53339d.invalidate();
            return;
        }
        this.f53339d.setVisibility(8);
    }

    public void f(d.a.k0.d2.h.e eVar) {
        if (eVar != null && !eVar.L().B2() && this.f53339d.getText() != null && this.f53339d.getText().length() > 0) {
            this.f53339d.setVisibility(0);
        } else {
            this.f53339d.setVisibility(8);
        }
    }

    public void g(d.a.k0.d2.h.e eVar) {
        if (eVar == null || eVar.L() == null) {
            return;
        }
        SpannableStringBuilder l1 = eVar.L().l1();
        this.f53339d.setOnTouchListener(new i(l1));
        this.f53339d.setText(l1);
        this.f53339d.setVisibility(0);
    }

    public void h(d.a.k0.d2.h.e eVar) {
        if (this.f53339d == null) {
            return;
        }
        int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds56);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f53339d.getLayoutParams();
        if (eVar.a0()) {
            g2 = 0;
        }
        layoutParams.bottomMargin = g2;
        this.f53339d.setLayoutParams(layoutParams);
    }
}
