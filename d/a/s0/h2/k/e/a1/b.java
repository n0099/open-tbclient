package d.a.s0.h2.k.e.a1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import tbclient.SmartApp;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f60309a;

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f60310b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f60311c;

    /* renamed from: d  reason: collision with root package name */
    public HeadImageView f60312d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f60313e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f60314f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f60315g;

    public b(PbFragment pbFragment, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60310b = null;
        this.f60309a = pbFragment;
        this.f60310b = onClickListener;
        b();
    }

    public void a(BdTypeListView bdTypeListView, int i2) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, bdTypeListView, i2) == null) || bdTypeListView == null || (relativeLayout = this.f60311c) == null) {
            return;
        }
        bdTypeListView.x(relativeLayout, i2);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f60311c == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f60309a.getContext()).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.f60311c = relativeLayout;
            HeadImageView headImageView = (HeadImageView) relativeLayout.findViewById(R.id.iv_pb_video_smart_app_head);
            this.f60312d = headImageView;
            headImageView.setIsRound(true);
            this.f60312d.setPlaceHolder(1);
            this.f60313e = (TextView) this.f60311c.findViewById(R.id.tv_pb_video_smart_app_title);
            this.f60314f = (TextView) this.f60311c.findViewById(R.id.tv_pb_video_smart_app_abstract);
            this.f60315g = (ImageView) this.f60311c.findViewById(R.id.iv_pb_video_smart_app_arrow);
            this.f60311c.setOnClickListener(this.f60310b);
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            RelativeLayout relativeLayout = this.f60311c;
            if (relativeLayout != null) {
                SkinManager.setBackgroundColor(relativeLayout, R.color.CAM_X0204);
            }
            HeadImageView headImageView = this.f60312d;
            if (headImageView != null) {
                headImageView.setIsNight(i2 == 1);
            }
            TextView textView = this.f60313e;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
            }
            TextView textView2 = this.f60314f;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0107);
            }
            ImageView imageView = this.f60315g;
            if (imageView != null) {
                SkinManager.setBackgroundResource(imageView, R.drawable.icon_common_arrow16_right_n);
            }
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bdTypeListView) == null) || bdTypeListView == null || (relativeLayout = this.f60311c) == null) {
            return;
        }
        bdTypeListView.removeHeaderView(relativeLayout);
    }

    public void e(d.a.s0.h2.h.e eVar, BdTypeListView bdTypeListView) {
        String charSequence;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, eVar, bdTypeListView) == null) || eVar == null || bdTypeListView == null) {
            return;
        }
        if (eVar.N().q2() && eVar.N().Z0() != null) {
            SmartApp Z0 = eVar.N().Z0();
            this.f60311c.setVisibility(0);
            d(bdTypeListView);
            a(bdTypeListView, 1);
            if (!k.isEmpty(Z0.avatar)) {
                this.f60312d.N(Z0.avatar, 10, false, false);
            }
            if (!k.isEmpty(Z0.name)) {
                charSequence = Z0.name + " " + ((Object) this.f60309a.getText(R.string.smart_app_suffix));
            } else {
                charSequence = this.f60309a.getText(R.string.intelligent_smart_app).toString();
            }
            this.f60313e.setText(charSequence);
            if (!k.isEmpty(Z0._abstract)) {
                this.f60314f.setText(Z0._abstract);
            } else {
                this.f60314f.setText(this.f60309a.getText(R.string.smart_app_default_abstract));
            }
            this.f60311c.setTag(Z0);
            return;
        }
        this.f60311c.setVisibility(8);
        d(bdTypeListView);
    }
}
