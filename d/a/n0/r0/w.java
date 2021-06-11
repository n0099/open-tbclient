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
    public d.a.m0.r.s.a f63419a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f63420b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f63421c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f63422d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f63423e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f63424f;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            w wVar = w.this;
            wVar.f63424f = !wVar.f63424f;
            w.this.h();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f63426e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f63427f;

        public b(String str, String str2) {
            this.f63426e = str;
            this.f63427f = str2;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            d.a.m0.r.d0.b.j().t("key_frs_recommend_tip", !w.this.f63424f);
            d.a.n0.r0.c.c().d(this.f63426e, this.f63427f);
            w.this.f63419a.dismiss();
            w.this.f63419a = null;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            w.this.f63424f = false;
            w.this.f63419a.dismiss();
            w.this.f63419a = null;
        }
    }

    public final void f() {
        TextView textView = this.f63420b;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        }
        TextView textView2 = this.f63421c;
        if (textView2 != null) {
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0107);
        }
        h();
        TextView textView3 = this.f63423e;
        if (textView3 != null) {
            SkinManager.setViewTextColor(textView3, R.color.CAM_X0107);
        }
    }

    public void g() {
        this.f63419a = null;
        this.f63420b = null;
        this.f63421c = null;
        this.f63422d = null;
        this.f63423e = null;
    }

    public final void h() {
        Drawable maskDrawable;
        ImageView imageView = this.f63422d;
        if (imageView == null) {
            return;
        }
        if (this.f63424f) {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_complete16_svg, null);
        } else {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_check16_svg, null);
        }
        imageView.setImageDrawable(maskDrawable);
    }

    public void i(TbPageContext tbPageContext, String str, String str2) {
        d.a.m0.r.s.a aVar = this.f63419a;
        if (aVar == null || !aVar.isShowing()) {
            d.a.m0.r.s.a aVar2 = new d.a.m0.r.s.a(tbPageContext.getPageActivity());
            this.f63419a = aVar2;
            aVar2.setContentViewSize(1);
            this.f63419a.setNegativeTextColor(R.color.CAM_X0105);
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.title);
            this.f63420b = textView;
            textView.setText(R.string.frs_recommend_thread_sure_title);
            this.f63421c = (TextView) inflate.findViewById(R.id.call_fans_intro);
            BawuThrones b2 = d.a.n0.r0.c.c().b();
            if (b2 != null) {
                TextView textView2 = this.f63421c;
                String string = tbPageContext.getString(R.string.frs_recommend_thread_sure_content);
                Integer num = b2.total_recommend_num;
                textView2.setText(String.format(string, b2.bazhu_level, num, Integer.valueOf(num.intValue() - b2.used_recommend_num.intValue())));
            } else {
                this.f63421c.setText(String.format(tbPageContext.getString(R.string.frs_recommend_thread_sure_content), "D", 2, 2));
            }
            this.f63422d = (ImageView) inflate.findViewById(R.id.checkbox);
            this.f63423e = (TextView) inflate.findViewById(R.id.no_tip_again_text);
            inflate.findViewById(R.id.no_tip_again_group).setOnClickListener(new a());
            f();
            this.f63419a.setContentView(inflate);
            this.f63419a.setPositiveButton(tbPageContext.getString(R.string.frs_recommend_thread_confirm), new b(str, str2));
            this.f63419a.setNegativeButton(tbPageContext.getString(R.string.next_time), new c());
            this.f63419a.create(tbPageContext).show();
        }
    }
}
