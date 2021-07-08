package d.a.p0.h2.n;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.video.PbVideoFullUserInfoLikeButton;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.o0.r.q.b2;
import d.a.p0.h2.h.p;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f57675a;

    /* renamed from: b  reason: collision with root package name */
    public View f57676b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f57677c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f57678d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f57679e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f57680f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f57681g;

    /* renamed from: h  reason: collision with root package name */
    public PbVideoFullUserInfoLikeButton f57682h;

    /* renamed from: i  reason: collision with root package name */
    public d f57683i;
    public View.OnClickListener j;
    public LinearLayout k;
    public View.OnClickListener l;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f57684e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57684e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f57684e.f57677c || view == this.f57684e.f57678d || view == this.f57684e.f57681g) {
                    this.f57684e.l(view);
                }
            }
        }
    }

    public e(TbPageContext tbPageContext, FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, frameLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new a(this);
        this.f57675a = tbPageContext;
        this.f57676b = g(tbPageContext);
        h();
        frameLayout.addView(this.f57676b);
    }

    public final void e(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
            this.f57681g.setVisibility(8);
            this.f57677c.setUserId(postData.t().getUserId());
            this.f57677c.setUserName(postData.t().getUserName());
            this.f57677c.setIsBigV(postData.t().isBigV());
            this.f57678d.setText(postData.t().getName_show());
            this.f57678d.setTag(postData.t().getUserId());
            this.f57677c.M(postData.t().getAvater(), 28, false);
            this.f57683i.n(postData.t());
        }
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f57679e : (View) invokeV.objValue;
    }

    public final View g(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext)) == null) {
            if (tbPageContext == null) {
                return null;
            }
            return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
        }
        return (View) invokeL.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f57679e = (RelativeLayout) this.f57676b.findViewById(R.id.pbVideoFullUserInfoPanel);
            HeadImageView headImageView = (HeadImageView) this.f57676b.findViewById(R.id.pbVideoFullPhoto);
            this.f57677c = headImageView;
            headImageView.setOnClickListener(this.l);
            LinearLayout linearLayout = (LinearLayout) this.f57676b.findViewById(R.id.pbVideoFullNameLayout);
            this.k = linearLayout;
            SkinManager.setBackgroundResource(linearLayout, R.drawable.video_author_bg);
            TextView textView = (TextView) this.f57676b.findViewById(R.id.pbVideoFullUserName);
            this.f57678d = textView;
            textView.setOnClickListener(this.l);
            TextView textView2 = (TextView) this.f57676b.findViewById(R.id.pbVideoFullAttention);
            this.f57680f = textView2;
            textView2.setOnClickListener(this.l);
            this.f57681g = (ImageView) this.f57676b.findViewById(R.id.pbVideoFullChannelIcon);
            PbVideoFullUserInfoLikeButton pbVideoFullUserInfoLikeButton = (PbVideoFullUserInfoLikeButton) this.f57676b.findViewById(R.id.pbVideoFullLikeButton);
            this.f57682h = pbVideoFullUserInfoLikeButton;
            pbVideoFullUserInfoLikeButton.setTextSize(0, l.g(this.f57675a.getPageActivity(), R.dimen.tbds30));
            this.f57683i = new d(this.f57675a, this.f57682h);
            this.f57677c.setRadius(l.g(this.f57675a.getPageActivity(), R.dimen.ds40));
        }
    }

    public final boolean i(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, b2Var)) == null) {
            if (b2Var == null || b2Var.H() == null || b2Var.H().getUserId() == null) {
                return false;
            }
            return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), b2Var.H().getUserId());
        }
        return invokeL.booleanValue;
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            PbVideoFullUserInfoLikeButton pbVideoFullUserInfoLikeButton = this.f57682h;
            if (pbVideoFullUserInfoLikeButton != null) {
                pbVideoFullUserInfoLikeButton.g(i2);
            }
            SkinManager.setViewTextColor(this.f57680f, R.color.CAM_X0101);
            TextView textView = this.f57678d;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
            }
            ImageView imageView = this.f57681g;
            if (imageView != null) {
                SkinManager.setBackgroundResource(imageView, R.drawable.icon_weiba);
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public final void l(View view) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, view) == null) || (onClickListener = this.j) == null) {
            return;
        }
        onClickListener.onClick(view);
    }

    public void m(PostData postData, b2 b2Var, p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, postData, b2Var, pVar) == null) {
            this.f57682h.setVisibility(0);
            this.f57680f.setVisibility(8);
            e(postData);
            if (i(b2Var)) {
                this.f57680f.setVisibility(8);
                this.f57682h.setVisibility(8);
            }
        }
    }

    public void n(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f2) == null) {
            this.f57679e.setAlpha(f2);
        }
    }

    public void o(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.j = onClickListener;
        }
    }
}
