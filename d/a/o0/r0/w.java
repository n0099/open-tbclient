package d.a.o0.r0;

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
import d.a.n0.r.s.a;
import tbclient.BawuThrones;
/* loaded from: classes4.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    public d.a.n0.r.s.a f63544a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f63545b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f63546c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f63547d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f63548e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f63549f;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            w wVar = w.this;
            wVar.f63549f = !wVar.f63549f;
            w.this.h();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f63551e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f63552f;

        public b(String str, String str2) {
            this.f63551e = str;
            this.f63552f = str2;
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            d.a.n0.r.d0.b.j().t("key_frs_recommend_tip", !w.this.f63549f);
            d.a.o0.r0.c.c().d(this.f63551e, this.f63552f);
            w.this.f63544a.dismiss();
            w.this.f63544a = null;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            w.this.f63549f = false;
            w.this.f63544a.dismiss();
            w.this.f63544a = null;
        }
    }

    public final void f() {
        TextView textView = this.f63545b;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        }
        TextView textView2 = this.f63546c;
        if (textView2 != null) {
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0107);
        }
        h();
        TextView textView3 = this.f63548e;
        if (textView3 != null) {
            SkinManager.setViewTextColor(textView3, R.color.CAM_X0107);
        }
    }

    public void g() {
        this.f63544a = null;
        this.f63545b = null;
        this.f63546c = null;
        this.f63547d = null;
        this.f63548e = null;
    }

    public final void h() {
        Drawable maskDrawable;
        ImageView imageView = this.f63547d;
        if (imageView == null) {
            return;
        }
        if (this.f63549f) {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_complete16_svg, null);
        } else {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_check16_svg, null);
        }
        imageView.setImageDrawable(maskDrawable);
    }

    public void i(TbPageContext tbPageContext, String str, String str2) {
        d.a.n0.r.s.a aVar = this.f63544a;
        if (aVar == null || !aVar.isShowing()) {
            d.a.n0.r.s.a aVar2 = new d.a.n0.r.s.a(tbPageContext.getPageActivity());
            this.f63544a = aVar2;
            aVar2.setContentViewSize(1);
            this.f63544a.setNegativeTextColor(R.color.CAM_X0105);
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.title);
            this.f63545b = textView;
            textView.setText(R.string.frs_recommend_thread_sure_title);
            this.f63546c = (TextView) inflate.findViewById(R.id.call_fans_intro);
            BawuThrones b2 = d.a.o0.r0.c.c().b();
            if (b2 != null) {
                TextView textView2 = this.f63546c;
                String string = tbPageContext.getString(R.string.frs_recommend_thread_sure_content);
                Integer num = b2.total_recommend_num;
                textView2.setText(String.format(string, b2.bazhu_level, num, Integer.valueOf(num.intValue() - b2.used_recommend_num.intValue())));
            } else {
                this.f63546c.setText(String.format(tbPageContext.getString(R.string.frs_recommend_thread_sure_content), "D", 2, 2));
            }
            this.f63547d = (ImageView) inflate.findViewById(R.id.checkbox);
            this.f63548e = (TextView) inflate.findViewById(R.id.no_tip_again_text);
            inflate.findViewById(R.id.no_tip_again_group).setOnClickListener(new a());
            f();
            this.f63544a.setContentView(inflate);
            this.f63544a.setPositiveButton(tbPageContext.getString(R.string.frs_recommend_thread_confirm), new b(str, str2));
            this.f63544a.setNegativeButton(tbPageContext.getString(R.string.next_time), new c());
            this.f63544a.create(tbPageContext).show();
        }
    }
}
