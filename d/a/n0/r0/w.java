package d.a.n0.r0;

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
import d.a.m0.r.s.a;
import tbclient.BawuThrones;
/* loaded from: classes4.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.r.s.a f59728a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f59729b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f59730c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f59731d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f59732e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f59733f;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            w wVar = w.this;
            wVar.f59733f = !wVar.f59733f;
            w.this.h();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f59735e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f59736f;

        public b(String str, String str2) {
            this.f59735e = str;
            this.f59736f = str2;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            d.a.m0.r.d0.b.j().t("key_frs_recommend_tip", !w.this.f59733f);
            d.a.n0.r0.c.c().d(this.f59735e, this.f59736f);
            w.this.f59728a.dismiss();
            w.this.f59728a = null;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            w.this.f59733f = false;
            w.this.f59728a.dismiss();
            w.this.f59728a = null;
        }
    }

    public final void f() {
        TextView textView = this.f59729b;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        }
        TextView textView2 = this.f59730c;
        if (textView2 != null) {
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0107);
        }
        h();
        TextView textView3 = this.f59732e;
        if (textView3 != null) {
            SkinManager.setViewTextColor(textView3, R.color.CAM_X0107);
        }
    }

    public void g() {
        this.f59728a = null;
        this.f59729b = null;
        this.f59730c = null;
        this.f59731d = null;
        this.f59732e = null;
    }

    public final void h() {
        Drawable maskDrawable;
        ImageView imageView = this.f59731d;
        if (imageView == null) {
            return;
        }
        if (this.f59733f) {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_complete16_svg, null);
        } else {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_check16_svg, null);
        }
        imageView.setImageDrawable(maskDrawable);
    }

    public void i(TbPageContext tbPageContext, String str, String str2) {
        d.a.m0.r.s.a aVar = this.f59728a;
        if (aVar == null || !aVar.isShowing()) {
            d.a.m0.r.s.a aVar2 = new d.a.m0.r.s.a(tbPageContext.getPageActivity());
            this.f59728a = aVar2;
            aVar2.setContentViewSize(1);
            this.f59728a.setNegativeTextColor(R.color.CAM_X0105);
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.title);
            this.f59729b = textView;
            textView.setText(R.string.frs_recommend_thread_sure_title);
            this.f59730c = (TextView) inflate.findViewById(R.id.call_fans_intro);
            BawuThrones b2 = d.a.n0.r0.c.c().b();
            if (b2 != null) {
                TextView textView2 = this.f59730c;
                String string = tbPageContext.getString(R.string.frs_recommend_thread_sure_content);
                Integer num = b2.total_recommend_num;
                textView2.setText(String.format(string, b2.bazhu_level, num, Integer.valueOf(num.intValue() - b2.used_recommend_num.intValue())));
            } else {
                this.f59730c.setText(String.format(tbPageContext.getString(R.string.frs_recommend_thread_sure_content), "D", 2, 2));
            }
            this.f59731d = (ImageView) inflate.findViewById(R.id.checkbox);
            this.f59732e = (TextView) inflate.findViewById(R.id.no_tip_again_text);
            inflate.findViewById(R.id.no_tip_again_group).setOnClickListener(new a());
            f();
            this.f59728a.setContentView(inflate);
            this.f59728a.setPositiveButton(tbPageContext.getString(R.string.frs_recommend_thread_confirm), new b(str, str2));
            this.f59728a.setNegativeButton(tbPageContext.getString(R.string.next_time), new c());
            this.f59728a.create(tbPageContext).show();
        }
    }
}
