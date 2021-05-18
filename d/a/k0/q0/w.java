package d.a.k0.q0;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import d.a.j0.r.s.a;
import tbclient.BawuThrones;
/* loaded from: classes4.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    public d.a.j0.r.s.a f59587a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f59588b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f59589c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f59590d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f59591e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f59592f;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            w wVar = w.this;
            wVar.f59592f = !wVar.f59592f;
            w.this.h();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f59594e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f59595f;

        public b(String str, String str2) {
            this.f59594e = str;
            this.f59595f = str2;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            d.a.j0.r.d0.b.j().t("key_frs_recommend_tip", !w.this.f59592f);
            d.a.k0.q0.c.c().d(this.f59594e, this.f59595f);
            w.this.f59587a.dismiss();
            w.this.f59587a = null;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            w.this.f59592f = false;
            w.this.f59587a.dismiss();
            w.this.f59587a = null;
        }
    }

    public final void f() {
        TextView textView = this.f59588b;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        }
        TextView textView2 = this.f59589c;
        if (textView2 != null) {
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0107);
        }
        h();
        TextView textView3 = this.f59591e;
        if (textView3 != null) {
            SkinManager.setViewTextColor(textView3, R.color.CAM_X0107);
        }
    }

    public void g() {
        this.f59587a = null;
        this.f59588b = null;
        this.f59589c = null;
        this.f59590d = null;
        this.f59591e = null;
    }

    public final void h() {
        Drawable maskDrawable;
        ImageView imageView = this.f59590d;
        if (imageView == null) {
            return;
        }
        if (this.f59592f) {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_complete16_svg, null);
        } else {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_check16_svg, null);
        }
        imageView.setImageDrawable(maskDrawable);
    }

    public void i(TbPageContext tbPageContext, String str, String str2) {
        d.a.j0.r.s.a aVar = this.f59587a;
        if (aVar == null || !aVar.isShowing()) {
            d.a.j0.r.s.a aVar2 = new d.a.j0.r.s.a(tbPageContext.getPageActivity());
            this.f59587a = aVar2;
            aVar2.setContentViewSize(1);
            this.f59587a.setNegativeTextColor(R.color.CAM_X0105);
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.title);
            this.f59588b = textView;
            textView.setText(R.string.frs_recommend_thread_sure_title);
            this.f59589c = (TextView) inflate.findViewById(R.id.call_fans_intro);
            BawuThrones b2 = d.a.k0.q0.c.c().b();
            if (b2 != null) {
                TextView textView2 = this.f59589c;
                String string = tbPageContext.getString(R.string.frs_recommend_thread_sure_content);
                Integer num = b2.total_recommend_num;
                textView2.setText(String.format(string, b2.bazhu_level, num, Integer.valueOf(num.intValue() - b2.used_recommend_num.intValue())));
            } else {
                this.f59589c.setText(String.format(tbPageContext.getString(R.string.frs_recommend_thread_sure_content), "D", 2, 2));
            }
            this.f59590d = (ImageView) inflate.findViewById(R.id.checkbox);
            this.f59591e = (TextView) inflate.findViewById(R.id.no_tip_again_text);
            inflate.findViewById(R.id.no_tip_again_group).setOnClickListener(new a());
            f();
            this.f59587a.setContentView(inflate);
            this.f59587a.setPositiveButton(tbPageContext.getString(R.string.frs_recommend_thread_confirm), new b(str, str2));
            this.f59587a.setNegativeButton(tbPageContext.getString(R.string.next_time), new c());
            this.f59587a.create(tbPageContext).show();
        }
    }
}
