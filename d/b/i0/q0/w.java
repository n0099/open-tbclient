package d.b.i0.q0;

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
import d.b.h0.r.s.a;
import tbclient.BawuThrones;
/* loaded from: classes4.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.r.s.a f60313a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f60314b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f60315c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f60316d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f60317e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f60318f;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            w wVar = w.this;
            wVar.f60318f = !wVar.f60318f;
            w.this.h();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f60320e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f60321f;

        public b(String str, String str2) {
            this.f60320e = str;
            this.f60321f = str2;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            d.b.h0.r.d0.b.j().t("key_frs_recommend_tip", !w.this.f60318f);
            d.b.i0.q0.c.c().d(this.f60320e, this.f60321f);
            w.this.f60313a.dismiss();
            w.this.f60313a = null;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            w.this.f60318f = false;
            w.this.f60313a.dismiss();
            w.this.f60313a = null;
        }
    }

    public final void f() {
        TextView textView = this.f60314b;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        }
        TextView textView2 = this.f60315c;
        if (textView2 != null) {
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0107);
        }
        h();
        TextView textView3 = this.f60317e;
        if (textView3 != null) {
            SkinManager.setViewTextColor(textView3, R.color.CAM_X0107);
        }
    }

    public void g() {
        this.f60313a = null;
        this.f60314b = null;
        this.f60315c = null;
        this.f60316d = null;
        this.f60317e = null;
    }

    public final void h() {
        Drawable maskDrawable;
        ImageView imageView = this.f60316d;
        if (imageView == null) {
            return;
        }
        if (this.f60318f) {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_complete16_svg, null);
        } else {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_check16_svg, null);
        }
        imageView.setImageDrawable(maskDrawable);
    }

    public void i(TbPageContext tbPageContext, String str, String str2) {
        d.b.h0.r.s.a aVar = this.f60313a;
        if (aVar == null || !aVar.isShowing()) {
            d.b.h0.r.s.a aVar2 = new d.b.h0.r.s.a(tbPageContext.getPageActivity());
            this.f60313a = aVar2;
            aVar2.setContentViewSize(1);
            this.f60313a.setNegativeTextColor(R.color.CAM_X0105);
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.title);
            this.f60314b = textView;
            textView.setText(R.string.frs_recommend_thread_sure_title);
            this.f60315c = (TextView) inflate.findViewById(R.id.call_fans_intro);
            BawuThrones b2 = d.b.i0.q0.c.c().b();
            if (b2 != null) {
                TextView textView2 = this.f60315c;
                String string = tbPageContext.getString(R.string.frs_recommend_thread_sure_content);
                Integer num = b2.total_recommend_num;
                textView2.setText(String.format(string, b2.bazhu_level, num, Integer.valueOf(num.intValue() - b2.used_recommend_num.intValue())));
            } else {
                this.f60315c.setText(String.format(tbPageContext.getString(R.string.frs_recommend_thread_sure_content), "D", 2, 2));
            }
            this.f60316d = (ImageView) inflate.findViewById(R.id.checkbox);
            this.f60317e = (TextView) inflate.findViewById(R.id.no_tip_again_text);
            inflate.findViewById(R.id.no_tip_again_group).setOnClickListener(new a());
            f();
            this.f60313a.setContentView(inflate);
            this.f60313a.setPositiveButton(tbPageContext.getString(R.string.frs_recommend_thread_confirm), new b(str, str2));
            this.f60313a.setNegativeButton(tbPageContext.getString(R.string.next_time), new c());
            this.f60313a.create(tbPageContext).show();
        }
    }
}
