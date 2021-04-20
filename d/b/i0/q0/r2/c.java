package d.b.i0.q0.r2;

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
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.r.s.a f60157a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f60158b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f60159c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f60160d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f60161e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f60162f;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar = c.this;
            cVar.f60162f = !cVar.f60162f;
            c.this.g();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabInfo f60164e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsTabInfo f60165f;

        public b(FrsTabInfo frsTabInfo, FrsTabInfo frsTabInfo2) {
            this.f60164e = frsTabInfo;
            this.f60165f = frsTabInfo2;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            d.b.h0.r.d0.b.j().t("key_frs_move_area_tip", !c.this.f60162f);
            d.b.i0.q0.a.h().m(this.f60164e.tab_id.intValue(), this.f60165f.tab_id.intValue());
            c.this.f60157a.dismiss();
            c.this.f60157a = null;
        }
    }

    /* renamed from: d.b.i0.q0.r2.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1499c implements a.e {
        public C1499c() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            c.this.f60157a.dismiss();
            c.this.f60157a = null;
        }
    }

    public final void f() {
        TextView textView = this.f60158b;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        }
        TextView textView2 = this.f60159c;
        if (textView2 != null) {
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0107);
        }
        g();
        TextView textView3 = this.f60161e;
        if (textView3 != null) {
            SkinManager.setViewTextColor(textView3, R.color.CAM_X0107);
        }
    }

    public final void g() {
        Drawable maskDrawable;
        ImageView imageView = this.f60160d;
        if (imageView == null) {
            return;
        }
        if (this.f60162f) {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_complete16_svg, null);
        } else {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_check16_svg, null);
        }
        imageView.setImageDrawable(maskDrawable);
    }

    public void h(TbPageContext tbPageContext, FrsTabInfo frsTabInfo, FrsTabInfo frsTabInfo2) {
        if (frsTabInfo == null || frsTabInfo2 == null) {
            return;
        }
        d.b.h0.r.s.a aVar = this.f60157a;
        if (aVar == null || !aVar.isShowing()) {
            d.b.h0.r.s.a aVar2 = new d.b.h0.r.s.a(tbPageContext.getPageActivity());
            this.f60157a = aVar2;
            aVar2.setContentViewSize(1);
            this.f60157a.setNegativeTextColor(R.color.CAM_X0105);
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.title);
            this.f60158b = textView;
            textView.setText(R.string.frs_move_area_popup_title);
            this.f60159c = (TextView) inflate.findViewById(R.id.call_fans_intro);
            if (frsTabInfo.is_general_tab.intValue() == 0) {
                TextView textView2 = this.f60159c;
                String string = tbPageContext.getString(R.string.frs_move_area_popup_content_other);
                String str = frsTabInfo.tab_name;
                String str2 = frsTabInfo2.tab_name;
                textView2.setText(String.format(string, str, str2, str, str2));
            } else {
                TextView textView3 = this.f60159c;
                String string2 = tbPageContext.getString(R.string.frs_move_area_popup_content);
                String str3 = frsTabInfo.tab_name;
                textView3.setText(String.format(string2, str3, frsTabInfo2.tab_name, str3));
            }
            this.f60160d = (ImageView) inflate.findViewById(R.id.checkbox);
            this.f60161e = (TextView) inflate.findViewById(R.id.no_tip_again_text);
            inflate.findViewById(R.id.no_tip_again_group).setOnClickListener(new a());
            f();
            this.f60157a.setContentView(inflate);
            this.f60157a.setPositiveButton(tbPageContext.getString(R.string.frs_move_area_popup_confirm), new b(frsTabInfo, frsTabInfo2));
            this.f60157a.setNegativeButton(tbPageContext.getString(R.string.next_time), new C1499c());
            this.f60157a.create(tbPageContext).show();
        }
    }
}
