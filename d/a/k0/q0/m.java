package d.a.k0.q0;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import tbclient.WindowToast;
/* loaded from: classes4.dex */
public class m {

    /* loaded from: classes4.dex */
    public static class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.r.s.a f58745e;

        public a(d.a.j0.r.s.a aVar) {
            this.f58745e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f58745e.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.r.s.a f58746e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f58747f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f58748g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f58749h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f58750i;

        public b(d.a.j0.r.s.a aVar, int i2, String str, String str2, TbPageContext tbPageContext) {
            this.f58746e = aVar;
            this.f58747f = i2;
            this.f58748g = str;
            this.f58749h = str2;
            this.f58750i = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f58746e.dismiss();
            if (this.f58747f == 1) {
                UrlManager.getInstance().dealOneLink(this.f58750i, new String[]{String.format("https://tieba.baidu.com/mo/q/bawu/taskinfoview?fn=%1$s&fid=%2$s&noshare=1", this.f58748g, this.f58749h)});
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.r.s.a f58751e;

        public c(d.a.j0.r.s.a aVar) {
            this.f58751e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f58751e.dismiss();
        }
    }

    public static void a(TbPageContext<?> tbPageContext, WindowToast windowToast, String str, String str2) {
        int k;
        if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        int intValue = windowToast.toast_type.intValue();
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_bazhu_exam_fail, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.bazhu_exam_top_image);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bazhu_exam_close_button);
        TextView textView = (TextView) inflate.findViewById(R.id.bazhu_exam_content);
        TextView textView2 = (TextView) inflate.findViewById(R.id.bazhu_exam_btn);
        textView.setText(windowToast.toast_content);
        if (windowToast.toast_type.intValue() == 0) {
            textView2.setText(TbadkCoreApplication.getInst().getString(R.string.know));
        } else if (windowToast.toast_type.intValue() != 1) {
            return;
        } else {
            textView2.setText(TbadkCoreApplication.getInst().getString(R.string.bazhu_exam_fail_btn_text));
        }
        d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(tbPageContext.getPageActivity());
        aVar.setContentView(inflate);
        aVar.setContentViewSize(2);
        aVar.setCanceledOnTouchOutside(false);
        aVar.setAutoNight(true);
        aVar.setCancelable(true);
        int g2 = d.a.c.e.p.l.g(tbPageContext.getPageActivity(), R.dimen.tbds31);
        int i2 = R.color.CAM_X0201;
        SkinManager.setBackgroundShapeDrawable(inflate, g2, i2, i2);
        tbImageView.setRadius(g2);
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
        int g3 = d.a.c.e.p.l.g(tbPageContext.getPageActivity(), R.dimen.tbds44);
        if (UtilHelper.getRealScreenOrientation(tbPageContext.getPageActivity()) == 2) {
            k = d.a.c.e.p.l.i(tbPageContext.getPageActivity());
        } else {
            k = d.a.c.e.p.l.k(tbPageContext.getPageActivity());
        }
        int i3 = k - (g3 * 2);
        ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = (i3 * PayBeanFactory.BEAN_ID_PAY_SORT_SAVE) / 992;
        tbImageView.setLayoutParams(layoutParams);
        SkinManager.setImageResource(tbImageView, R.drawable.backguard_mask_apity);
        SkinManager.setViewTextColor(textView, R.color.CAM_X0107);
        SkinManager.setViewTextColor(textView2, R.color.CAM_X0304);
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(imageView, R.drawable.ic_icon_popup_close_n, SvgManager.SvgResourceStateType.NORMAL);
        textView2.setOnClickListener(new b(aVar, intValue, str2, str, tbPageContext));
        imageView.setOnClickListener(new c(aVar));
        aVar.create(tbPageContext).show();
    }

    public static void b(Activity activity, TbPageContext<?> tbPageContext) {
        int k;
        if (activity == null || tbPageContext == null) {
            return;
        }
        View inflate = LayoutInflater.from(activity).inflate(R.layout.frs_general_tab_notify_dialog_layout, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.general_title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.general_content_1);
        TextView textView3 = (TextView) inflate.findViewById(R.id.general_content_2);
        TextView textView4 = (TextView) inflate.findViewById(R.id.general_content_3);
        TextView textView5 = (TextView) inflate.findViewById(R.id.general_btn);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.top_general_image);
        d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(activity);
        aVar.setContentView(inflate);
        aVar.setContentViewSize(2);
        aVar.setCanceledOnTouchOutside(true);
        aVar.setAutoNight(true);
        aVar.setCancelable(true);
        int g2 = d.a.c.e.p.l.g(activity, R.dimen.tbds31);
        SkinManager.setBackgroundShapeDrawable(inflate, g2, R.color.CAM_X0201, R.color.CAM_X0101);
        tbImageView.setRadius(g2);
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
        int g3 = d.a.c.e.p.l.g(activity, R.dimen.tbds44);
        if (UtilHelper.getRealScreenOrientation(activity) == 2) {
            k = d.a.c.e.p.l.i(activity);
        } else {
            k = d.a.c.e.p.l.k(activity);
        }
        int i2 = k - (g3 * 2);
        ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = (i2 * 556) / 988;
        tbImageView.setLayoutParams(layoutParams);
        SkinManager.setImageResource(tbImageView, R.drawable.frs_general_tab_notify_pic);
        SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        SkinManager.setViewTextColor(textView2, R.color.CAM_X0107);
        SkinManager.setViewTextColor(textView3, R.color.CAM_X0107);
        SkinManager.setViewTextColor(textView4, R.color.CAM_X0107);
        SkinManager.setViewTextColor(textView5, R.color.CAM_X0302);
        textView5.setOnClickListener(new a(aVar));
        aVar.create(tbPageContext).show();
    }
}
