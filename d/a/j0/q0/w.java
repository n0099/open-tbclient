package d.a.j0.q0;

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
import d.a.i0.r.s.a;
import tbclient.BawuThrones;
/* loaded from: classes4.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    public d.a.i0.r.s.a f58845a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f58846b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f58847c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f58848d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f58849e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f58850f;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            w wVar = w.this;
            wVar.f58850f = !wVar.f58850f;
            w.this.h();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f58852e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f58853f;

        public b(String str, String str2) {
            this.f58852e = str;
            this.f58853f = str2;
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            d.a.i0.r.d0.b.j().t("key_frs_recommend_tip", !w.this.f58850f);
            d.a.j0.q0.c.c().d(this.f58852e, this.f58853f);
            w.this.f58845a.dismiss();
            w.this.f58845a = null;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            w.this.f58850f = false;
            w.this.f58845a.dismiss();
            w.this.f58845a = null;
        }
    }

    public final void f() {
        TextView textView = this.f58846b;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        }
        TextView textView2 = this.f58847c;
        if (textView2 != null) {
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0107);
        }
        h();
        TextView textView3 = this.f58849e;
        if (textView3 != null) {
            SkinManager.setViewTextColor(textView3, R.color.CAM_X0107);
        }
    }

    public void g() {
        this.f58845a = null;
        this.f58846b = null;
        this.f58847c = null;
        this.f58848d = null;
        this.f58849e = null;
    }

    public final void h() {
        Drawable maskDrawable;
        ImageView imageView = this.f58848d;
        if (imageView == null) {
            return;
        }
        if (this.f58850f) {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_complete16_svg, null);
        } else {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_check16_svg, null);
        }
        imageView.setImageDrawable(maskDrawable);
    }

    public void i(TbPageContext tbPageContext, String str, String str2) {
        d.a.i0.r.s.a aVar = this.f58845a;
        if (aVar == null || !aVar.isShowing()) {
            d.a.i0.r.s.a aVar2 = new d.a.i0.r.s.a(tbPageContext.getPageActivity());
            this.f58845a = aVar2;
            aVar2.setContentViewSize(1);
            this.f58845a.setNegativeTextColor(R.color.CAM_X0105);
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.title);
            this.f58846b = textView;
            textView.setText(R.string.frs_recommend_thread_sure_title);
            this.f58847c = (TextView) inflate.findViewById(R.id.call_fans_intro);
            BawuThrones b2 = d.a.j0.q0.c.c().b();
            if (b2 != null) {
                TextView textView2 = this.f58847c;
                String string = tbPageContext.getString(R.string.frs_recommend_thread_sure_content);
                Integer num = b2.total_recommend_num;
                textView2.setText(String.format(string, b2.bazhu_level, num, Integer.valueOf(num.intValue() - b2.used_recommend_num.intValue())));
            } else {
                this.f58847c.setText(String.format(tbPageContext.getString(R.string.frs_recommend_thread_sure_content), "D", 2, 2));
            }
            this.f58848d = (ImageView) inflate.findViewById(R.id.checkbox);
            this.f58849e = (TextView) inflate.findViewById(R.id.no_tip_again_text);
            inflate.findViewById(R.id.no_tip_again_group).setOnClickListener(new a());
            f();
            this.f58845a.setContentView(inflate);
            this.f58845a.setPositiveButton(tbPageContext.getString(R.string.frs_recommend_thread_confirm), new b(str, str2));
            this.f58845a.setNegativeButton(tbPageContext.getString(R.string.next_time), new c());
            this.f58845a.create(tbPageContext).show();
        }
    }
}
