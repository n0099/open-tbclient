package d.a.p0.u0.r2;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.s.o;
import tbclient.FrsTabInfo;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageView f63778e;

        public a(ImageView imageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63778e = imageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Drawable maskDrawable;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                view.setTag(Boolean.valueOf(!((Boolean) view.getTag()).booleanValue()));
                ImageView imageView = this.f63778e;
                if (((Boolean) view.getTag()).booleanValue()) {
                    maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_complete16_svg, null);
                } else {
                    maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_check16_svg, null);
                }
                imageView.setImageDrawable(maskDrawable);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageView f63779e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsTabInfo f63780f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ FrsTabInfo f63781g;

        public b(ImageView imageView, FrsTabInfo frsTabInfo, FrsTabInfo frsTabInfo2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageView, frsTabInfo, frsTabInfo2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63779e = imageView;
            this.f63780f = frsTabInfo;
            this.f63781g = frsTabInfo2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.a.o0.r.d0.b.j().t("key_frs_move_area_tip", !((Boolean) this.f63779e.getTag()).booleanValue());
                d.a.p0.u0.a.h().m(this.f63780f.tab_id.intValue(), this.f63781g.tab_id.intValue());
            }
        }
    }

    public static void a(TbPageContext tbPageContext, FrsTabInfo frsTabInfo, FrsTabInfo frsTabInfo2) {
        String format;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65536, null, tbPageContext, frsTabInfo, frsTabInfo2) == null) || frsTabInfo == null || frsTabInfo2 == null || tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        LinearLayout linearLayout = new LinearLayout(pageActivity);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X012), UtilHelper.getDimenPixelSize(R.dimen.M_H_X008), UtilHelper.getDimenPixelSize(R.dimen.M_W_X012), 0);
        ImageView imageView = new ImageView(pageActivity);
        imageView.setImageDrawable(SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_check16_svg, null));
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds39), UtilHelper.getDimenPixelSize(R.dimen.tbds39)));
        TextView textView = new TextView(pageActivity);
        textView.setText(R.string.no_tip_again);
        textView.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, 0, 0);
        d.a.o0.r.u.c d2 = d.a.o0.r.u.c.d(textView);
        d2.x(R.dimen.T_X07);
        d2.t(R.color.CAM_X0108);
        d2.y(R.string.F_X01);
        linearLayout.addView(textView);
        imageView.setTag(Boolean.FALSE);
        imageView.setOnClickListener(new a(imageView));
        o oVar = new o(tbPageContext.getPageActivity());
        oVar.p(R.string.frs_move_area_popup_title);
        if (frsTabInfo.is_general_tab.intValue() == 0) {
            String string = tbPageContext.getString(R.string.frs_move_area_popup_content_other);
            String str = frsTabInfo.tab_name;
            String str2 = frsTabInfo2.tab_name;
            format = String.format(string, str, str2, str, str2);
        } else {
            String string2 = tbPageContext.getString(R.string.frs_move_area_popup_content);
            String str3 = frsTabInfo.tab_name;
            format = String.format(string2, str3, frsTabInfo2.tab_name, str3);
        }
        oVar.m(format);
        oVar.k(3);
        oVar.l(true);
        oVar.h(linearLayout);
        oVar.o(new TBAlertConfig.a(R.string.next_time, TBAlertConfig.OperateBtnStyle.SECONDARY), new TBAlertConfig.a(R.string.frs_move_area_popup_confirm, TBAlertConfig.OperateBtnStyle.MAIN, new b(imageView, frsTabInfo, frsTabInfo2)));
        oVar.f();
        oVar.r();
    }
}
