package d.b.i0.d2.k.e.z0;

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
import d.b.i0.d2.k.e.r0;
import d.b.i0.u3.i;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f54396a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.d2.i.c f54397b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f54398c = null;

    /* renamed from: d  reason: collision with root package name */
    public TextView f54399d = null;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f54400e;

    /* loaded from: classes3.dex */
    public class a implements View.OnLongClickListener {
        public a(c cVar) {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return false;
        }
    }

    public c(PbFragment pbFragment, d.b.i0.d2.i.c cVar) {
        this.f54396a = pbFragment;
        this.f54397b = cVar;
        b();
    }

    public void a(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.f54398c.setVisibility(0);
            bdTypeListView.addHeaderView(this.f54398c);
        }
    }

    public final void b() {
        if (this.f54398c != null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f54396a.getContext()).inflate(R.layout.new_pb_title, (ViewGroup) null);
        this.f54398c = relativeLayout;
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
        this.f54400e = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -r0.f());
        this.f54400e.setImageMatrix(matrix);
        TextView textView = (TextView) this.f54398c.findViewById(R.id.tv_pb_title);
        this.f54399d = textView;
        d.b.h0.r.u.c d2 = d.b.h0.r.u.c.d(textView);
        d2.u(R.dimen.T_X03);
        d2.r(R.dimen.M_T_X003);
        d2.q(R.color.CAM_X0105);
        d2.v(R.string.F_X02);
        d2.n(R.color.CAM_X0304);
        this.f54399d.setVisibility(8);
        if (this.f54399d.getParent() == null) {
            this.f54398c.addView(this.f54399d);
        }
        this.f54398c.setOnTouchListener(this.f54397b);
        this.f54398c.setOnLongClickListener(new a(this));
    }

    public void c(int i) {
        TextView textView = this.f54399d;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
            this.f54399d.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.f54398c.setVisibility(8);
            bdTypeListView.removeHeaderView(this.f54398c);
        }
    }

    public void e(d.b.i0.d2.h.e eVar) {
        if (eVar == null || eVar.L() == null) {
            return;
        }
        SpannableStringBuilder l1 = eVar.L().l1();
        SpannableString c2 = r0.c(eVar.L());
        if (!StringUtils.isNull(eVar.L().x1())) {
            if (c2 != null) {
                l1.append((CharSequence) c2);
                this.f54399d.setText(l1, TextView.BufferType.SPANNABLE);
            } else {
                this.f54399d.setText(l1);
            }
            h(eVar);
            this.f54399d.setVisibility(0);
            this.f54399d.setMaxLines(3);
            this.f54399d.setEllipsize(TextUtils.TruncateAt.END);
            this.f54399d.invalidate();
            return;
        }
        this.f54399d.setVisibility(8);
    }

    public void f(d.b.i0.d2.h.e eVar) {
        if (eVar != null && !eVar.L().z2() && this.f54399d.getText() != null && this.f54399d.getText().length() > 0) {
            this.f54399d.setVisibility(0);
        } else {
            this.f54399d.setVisibility(8);
        }
    }

    public void g(d.b.i0.d2.h.e eVar) {
        if (eVar == null || eVar.L() == null) {
            return;
        }
        SpannableStringBuilder l1 = eVar.L().l1();
        this.f54399d.setOnTouchListener(new i(l1));
        this.f54399d.setText(l1);
        this.f54399d.setVisibility(0);
    }

    public void h(d.b.i0.d2.h.e eVar) {
        if (this.f54399d == null) {
            return;
        }
        int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds56);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f54399d.getLayoutParams();
        if (eVar.a0()) {
            g2 = 0;
        }
        layoutParams.bottomMargin = g2;
        this.f54399d.setLayoutParams(layoutParams);
    }
}
