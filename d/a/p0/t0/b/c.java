package d.a.p0.t0.b;

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
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62309a;

    /* renamed from: b  reason: collision with root package name */
    public final View f62310b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f62311c;

    /* renamed from: d  reason: collision with root package name */
    public final EditText f62312d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f62313e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f62314f;

    /* renamed from: g  reason: collision with root package name */
    public final BdTypeListView f62315g;

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f62316h;

    /* renamed from: i  reason: collision with root package name */
    public int f62317i;

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
        this.f62317i = 3;
        this.f62309a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.forum_search_main, (ViewGroup) null);
        this.f62310b = inflate;
        this.f62311c = (RelativeLayout) inflate.findViewById(R.id.search_area_root);
        this.f62316h = (ImageView) this.f62310b.findViewById(R.id.search_bar_icon);
        this.f62312d = (EditText) this.f62310b.findViewById(R.id.home_et_search);
        this.f62313e = (ImageView) this.f62310b.findViewById(R.id.home_bt_search_del);
        this.f62312d.setHint(R.string.search_bar_you_want_post_to_share);
        TextView textView = (TextView) this.f62310b.findViewById(R.id.home_bt_search_cancel_s);
        this.f62314f = textView;
        textView.setText(tbPageContext.getString(R.string.cancel));
        this.f62315g = (BdTypeListView) this.f62310b.findViewById(R.id.search_bar_list);
        a();
        b(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f62311c.getLayoutParams();
            layoutParams.height = l.g(this.f62309a.getPageActivity(), R.dimen.ds88);
            int g2 = l.g(this.f62309a.getPageActivity(), R.dimen.ds8);
            layoutParams.rightMargin = g2;
            layoutParams.leftMargin = g2;
            int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
            if (immersiveStickyBarHeight > 0) {
                layoutParams.topMargin = immersiveStickyBarHeight;
            }
            this.f62311c.setLayoutParams(layoutParams);
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f62317i == i2) {
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f62316h, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
        SkinManager.setViewTextColor(this.f62314f, R.color.CAM_X0302, 1);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f62313e, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (i2 == 2) {
            this.f62312d.setHintTextColor(SkinManager.getColor(R.color.s_navbar_title_color));
        } else {
            this.f62312d.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        }
        SkinManager.setNavbarTitleColor(this.f62312d, R.color.CAM_X0105, R.color.s_navbar_title_color);
        this.f62317i = i2;
    }
}
