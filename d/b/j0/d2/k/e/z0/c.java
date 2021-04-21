package d.b.j0.d2.k.e.z0;

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
import d.b.c.e.p.l;
import d.b.j0.d2.k.e.r0;
import d.b.j0.u3.i;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f54817a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.j0.d2.i.c f54818b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f54819c = null;

    /* renamed from: d  reason: collision with root package name */
    public TextView f54820d = null;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f54821e;

    /* loaded from: classes3.dex */
    public class a implements View.OnLongClickListener {
        public a(c cVar) {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return false;
        }
    }

    public c(PbFragment pbFragment, d.b.j0.d2.i.c cVar) {
        this.f54817a = pbFragment;
        this.f54818b = cVar;
        b();
    }

    public void a(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.f54819c.setVisibility(0);
            bdTypeListView.addHeaderView(this.f54819c);
        }
    }

    public final void b() {
        if (this.f54819c != null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f54817a.getContext()).inflate(R.layout.new_pb_title, (ViewGroup) null);
        this.f54819c = relativeLayout;
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
        this.f54821e = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -r0.f());
        this.f54821e.setImageMatrix(matrix);
        TextView textView = (TextView) this.f54819c.findViewById(R.id.tv_pb_title);
        this.f54820d = textView;
        d.b.i0.r.u.c d2 = d.b.i0.r.u.c.d(textView);
        d2.u(R.dimen.T_X03);
        d2.r(R.dimen.M_T_X003);
        d2.q(R.color.CAM_X0105);
        d2.v(R.string.F_X02);
        d2.n(R.color.CAM_X0304);
        this.f54820d.setVisibility(8);
        if (this.f54820d.getParent() == null) {
            this.f54819c.addView(this.f54820d);
        }
        this.f54819c.setOnTouchListener(this.f54818b);
        this.f54819c.setOnLongClickListener(new a(this));
    }

    public void c(int i) {
        TextView textView = this.f54820d;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
            this.f54820d.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.f54819c.setVisibility(8);
            bdTypeListView.removeHeaderView(this.f54819c);
        }
    }

    public void e(d.b.j0.d2.h.e eVar) {
        if (eVar == null || eVar.L() == null) {
            return;
        }
        SpannableStringBuilder l1 = eVar.L().l1();
        SpannableString c2 = r0.c(eVar.L());
        if (!StringUtils.isNull(eVar.L().x1())) {
            if (c2 != null) {
                l1.append((CharSequence) c2);
                this.f54820d.setText(l1, TextView.BufferType.SPANNABLE);
            } else {
                this.f54820d.setText(l1);
            }
            h(eVar);
            this.f54820d.setVisibility(0);
            this.f54820d.setMaxLines(3);
            this.f54820d.setEllipsize(TextUtils.TruncateAt.END);
            this.f54820d.invalidate();
            return;
        }
        this.f54820d.setVisibility(8);
    }

    public void f(d.b.j0.d2.h.e eVar) {
        if (eVar != null && !eVar.L().z2() && this.f54820d.getText() != null && this.f54820d.getText().length() > 0) {
            this.f54820d.setVisibility(0);
        } else {
            this.f54820d.setVisibility(8);
        }
    }

    public void g(d.b.j0.d2.h.e eVar) {
        if (eVar == null || eVar.L() == null) {
            return;
        }
        SpannableStringBuilder l1 = eVar.L().l1();
        this.f54820d.setOnTouchListener(new i(l1));
        this.f54820d.setText(l1);
        this.f54820d.setVisibility(0);
    }

    public void h(d.b.j0.d2.h.e eVar) {
        if (this.f54820d == null) {
            return;
        }
        int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds56);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f54820d.getLayoutParams();
        if (eVar.a0()) {
            g2 = 0;
        }
        layoutParams.bottomMargin = g2;
        this.f54820d.setLayoutParams(layoutParams);
    }
}
