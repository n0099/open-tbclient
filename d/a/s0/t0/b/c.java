package d.a.s0.t0.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f65528a;

    /* renamed from: b  reason: collision with root package name */
    public final View f65529b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f65530c;

    /* renamed from: d  reason: collision with root package name */
    public final EditText f65531d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f65532e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f65533f;

    /* renamed from: g  reason: collision with root package name */
    public final BdTypeListView f65534g;

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f65535h;

    /* renamed from: i  reason: collision with root package name */
    public int f65536i;

    public c(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65536i = 3;
        this.f65528a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.forum_search_main, (ViewGroup) null);
        this.f65529b = inflate;
        this.f65530c = (RelativeLayout) inflate.findViewById(R.id.search_area_root);
        this.f65535h = (ImageView) this.f65529b.findViewById(R.id.search_bar_icon);
        this.f65531d = (EditText) this.f65529b.findViewById(R.id.home_et_search);
        this.f65532e = (ImageView) this.f65529b.findViewById(R.id.home_bt_search_del);
        this.f65531d.setHint(R.string.search_bar_you_want_post_to_share);
        TextView textView = (TextView) this.f65529b.findViewById(R.id.home_bt_search_cancel_s);
        this.f65533f = textView;
        textView.setText(tbPageContext.getString(R.string.cancel));
        this.f65534g = (BdTypeListView) this.f65529b.findViewById(R.id.search_bar_list);
        a();
        b(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f65530c.getLayoutParams();
            layoutParams.height = l.g(this.f65528a.getPageActivity(), R.dimen.ds88);
            int g2 = l.g(this.f65528a.getPageActivity(), R.dimen.ds8);
            layoutParams.rightMargin = g2;
            layoutParams.leftMargin = g2;
            int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
            if (immersiveStickyBarHeight > 0) {
                layoutParams.topMargin = immersiveStickyBarHeight;
            }
            this.f65530c.setLayoutParams(layoutParams);
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f65536i == i2) {
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f65535h, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
        SkinManager.setViewTextColor(this.f65533f, R.color.CAM_X0302, 1);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f65532e, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (i2 == 2) {
            this.f65531d.setHintTextColor(SkinManager.getColor(R.color.s_navbar_title_color));
        } else {
            this.f65531d.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        }
        SkinManager.setNavbarTitleColor(this.f65531d, R.color.CAM_X0105, R.color.s_navbar_title_color);
        this.f65536i = i2;
    }
}
