package com.repackage;

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
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes7.dex */
public class wy7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public View b;
    public HeadImageView c;
    public TextView d;
    public RelativeLayout e;
    public TextView f;
    public ImageView g;
    public PbVideoFullUserInfoLikeButton h;
    public vy7 i;
    public View.OnClickListener j;
    public LinearLayout k;
    public View.OnClickListener l;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wy7 a;

        public a(wy7 wy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wy7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2 == this.a.c || view2 == this.a.d || view2 == this.a.g) {
                    this.a.l(view2);
                }
            }
        }
    }

    public wy7(TbPageContext tbPageContext, FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, frameLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new a(this);
        this.a = tbPageContext;
        this.b = g(tbPageContext);
        h();
        frameLayout.addView(this.b);
    }

    public final void e(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
            this.g.setVisibility(8);
            this.c.setUserId(postData.s().getUserId());
            this.c.setUserName(postData.s().getUserName());
            this.c.setIsBigV(postData.s().isBigV());
            this.d.setText(postData.s().getName_show());
            this.d.setTag(postData.s().getUserId());
            this.c.K(postData.s().getAvater(), 28, false);
            this.i.n(postData.s());
        }
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.e : (View) invokeV.objValue;
    }

    public final View g(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext)) == null) {
            if (tbPageContext == null) {
                return null;
            }
            return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0882, (ViewGroup) null);
        }
        return (View) invokeL.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.e = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091682);
            HeadImageView headImageView = (HeadImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091681);
            this.c = headImageView;
            headImageView.setOnClickListener(this.l);
            LinearLayout linearLayout = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091680);
            this.k = linearLayout;
            SkinManager.setBackgroundResource(linearLayout, R.drawable.video_author_bg);
            TextView textView = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091683);
            this.d = textView;
            textView.setOnClickListener(this.l);
            TextView textView2 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09167d);
            this.f = textView2;
            textView2.setOnClickListener(this.l);
            this.g = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f09167e);
            PbVideoFullUserInfoLikeButton pbVideoFullUserInfoLikeButton = (PbVideoFullUserInfoLikeButton) this.b.findViewById(R.id.obfuscated_res_0x7f09167f);
            this.h = pbVideoFullUserInfoLikeButton;
            pbVideoFullUserInfoLikeButton.setTextSize(0, oi.f(this.a.getPageActivity(), R.dimen.tbds30));
            this.i = new vy7(this.a, this.h);
            this.c.setRadius(oi.f(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f070225));
        }
    }

    public final boolean i(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, threadData)) == null) {
            if (threadData == null || threadData.getAuthor() == null || threadData.getAuthor().getUserId() == null) {
                return false;
            }
            return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), threadData.getAuthor().getUserId());
        }
        return invokeL.booleanValue;
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            PbVideoFullUserInfoLikeButton pbVideoFullUserInfoLikeButton = this.h;
            if (pbVideoFullUserInfoLikeButton != null) {
                pbVideoFullUserInfoLikeButton.g(i);
            }
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0101);
            TextView textView = this.d;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
            }
            ImageView imageView = this.g;
            if (imageView != null) {
                SkinManager.setBackgroundResource(imageView, R.drawable.obfuscated_res_0x7f080ae7);
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public final void l(View view2) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, view2) == null) || (onClickListener = this.j) == null) {
            return;
        }
        onClickListener.onClick(view2);
    }

    public void m(PostData postData, ThreadData threadData, ms7 ms7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, postData, threadData, ms7Var) == null) {
            this.h.setVisibility(0);
            this.f.setVisibility(8);
            e(postData);
            if (i(threadData)) {
                this.f.setVisibility(8);
                this.h.setVisibility(8);
            }
        }
    }

    public void n(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f) == null) {
            this.e.setAlpha(f);
        }
    }

    public void o(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.j = onClickListener;
        }
    }
}
