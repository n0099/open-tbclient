package d.a.j0.d2.k.e.z0;

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
import d.a.j0.d2.k.e.r0;
import d.a.j0.u3.i;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f52633a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.j0.d2.i.c f52634b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f52635c = null;

    /* renamed from: d  reason: collision with root package name */
    public TextView f52636d = null;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f52637e;

    /* loaded from: classes3.dex */
    public class a implements View.OnLongClickListener {
        public a(c cVar) {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return false;
        }
    }

    public c(PbFragment pbFragment, d.a.j0.d2.i.c cVar) {
        this.f52633a = pbFragment;
        this.f52634b = cVar;
        b();
    }

    public void a(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.f52635c.setVisibility(0);
            bdTypeListView.addHeaderView(this.f52635c);
        }
    }

    public final void b() {
        if (this.f52635c != null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f52633a.getContext()).inflate(R.layout.new_pb_title, (ViewGroup) null);
        this.f52635c = relativeLayout;
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
        this.f52637e = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -r0.f());
        this.f52637e.setImageMatrix(matrix);
        TextView textView = (TextView) this.f52635c.findViewById(R.id.tv_pb_title);
        this.f52636d = textView;
        d.a.i0.r.u.c d2 = d.a.i0.r.u.c.d(textView);
        d2.u(R.dimen.T_X03);
        d2.r(R.dimen.M_T_X003);
        d2.q(R.color.CAM_X0105);
        d2.v(R.string.F_X02);
        d2.n(R.color.CAM_X0304);
        this.f52636d.setVisibility(8);
        if (this.f52636d.getParent() == null) {
            this.f52635c.addView(this.f52636d);
        }
        this.f52635c.setOnTouchListener(this.f52634b);
        this.f52635c.setOnLongClickListener(new a(this));
    }

    public void c(int i2) {
        TextView textView = this.f52636d;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
            this.f52636d.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.f52635c.setVisibility(8);
            bdTypeListView.removeHeaderView(this.f52635c);
        }
    }

    public void e(d.a.j0.d2.h.e eVar) {
        if (eVar == null || eVar.L() == null) {
            return;
        }
        SpannableStringBuilder l1 = eVar.L().l1();
        SpannableString c2 = r0.c(eVar.L());
        if (!StringUtils.isNull(eVar.L().x1())) {
            if (c2 != null) {
                l1.append((CharSequence) c2);
                this.f52636d.setText(l1, TextView.BufferType.SPANNABLE);
            } else {
                this.f52636d.setText(l1);
            }
            h(eVar);
            this.f52636d.setVisibility(0);
            this.f52636d.setMaxLines(3);
            this.f52636d.setEllipsize(TextUtils.TruncateAt.END);
            this.f52636d.invalidate();
            return;
        }
        this.f52636d.setVisibility(8);
    }

    public void f(d.a.j0.d2.h.e eVar) {
        if (eVar != null && !eVar.L().z2() && this.f52636d.getText() != null && this.f52636d.getText().length() > 0) {
            this.f52636d.setVisibility(0);
        } else {
            this.f52636d.setVisibility(8);
        }
    }

    public void g(d.a.j0.d2.h.e eVar) {
        if (eVar == null || eVar.L() == null) {
            return;
        }
        SpannableStringBuilder l1 = eVar.L().l1();
        this.f52636d.setOnTouchListener(new i(l1));
        this.f52636d.setText(l1);
        this.f52636d.setVisibility(0);
    }

    public void h(d.a.j0.d2.h.e eVar) {
        if (this.f52636d == null) {
            return;
        }
        int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds56);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f52636d.getLayoutParams();
        if (eVar.a0()) {
            g2 = 0;
        }
        layoutParams.bottomMargin = g2;
        this.f52636d.setLayoutParams(layoutParams);
    }
}
