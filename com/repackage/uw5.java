package com.repackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class uw5 extends rw5<n26> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout i;
    public RelativeLayout j;
    public TbImageView k;
    public ImageView l;
    public TextView m;
    public TextView n;
    public ClickableHeaderImageView o;
    public TextView p;
    public TextView q;
    public View r;
    public n26 s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uw5(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        s(k());
    }

    @Override // com.repackage.rw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d018d : invokeV.intValue;
    }

    @Override // com.repackage.rw5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            if (this.a != i) {
                SkinManager.setBackgroundResource(k(), R.color.CAM_X0201);
                SkinManager.setBackgroundResource(this.r, R.color.CAM_X0204);
                SkinManager.setViewTextColor(this.m, R.color.CAM_X0101, 1);
                yl8 readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                if (readThreadHistory != null && readThreadHistory.d(this.s.getThreadData().getId())) {
                    SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0108);
                } else {
                    SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0105);
                }
                SkinManager.setViewTextColor(this.p, R.color.CAM_X0109, 1);
                SkinManager.setViewTextColor(this.q, R.color.CAM_X0109, 1);
            }
            this.a = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view2) == null) || e() == null) {
            return;
        }
        e().a(k(), this.s);
    }

    public final void s(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            this.i = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090525);
            this.j = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090524);
            this.k = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090ed7);
            this.l = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090ec4);
            this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09052d);
            this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09052e);
            this.o = (ClickableHeaderImageView) view2.findViewById(R.id.obfuscated_res_0x7f09052b);
            this.p = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09050d);
            this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09050c);
            this.r = view2.findViewById(R.id.obfuscated_res_0x7f090505);
            this.k.setDefaultBgResource(R.drawable.obfuscated_res_0x7f08085c);
            int dimensionPixelSize = this.c.getResources().getDimensionPixelSize(R.dimen.tbds326);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            layoutParams.width = dimensionPixelSize;
            layoutParams.height = (dimensionPixelSize * 9) / 16;
            this.j.setLayoutParams(layoutParams);
            this.o.setDefaultResource(17170445);
            this.o.setDefaultBgResource(R.color.CAM_X0205);
            this.o.setIsRound(true);
            this.o.setDrawBorder(true);
            this.o.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
            this.o.setBorderWidth(this.c.getResources().getDimensionPixelSize(R.dimen.tbds1));
            k().setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.rw5
    /* renamed from: t */
    public void l(n26 n26Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, n26Var) == null) || n26Var == null || n26Var.getThreadData() == null) {
            return;
        }
        this.s = n26Var;
        String str = null;
        if (n26Var.getThreadData().isVideoThreadType()) {
            this.l.setVisibility(0);
            this.m.setVisibility(0);
            if (n26Var.getThreadData().getThreadVideoInfo() != null) {
                this.m.setText(StringHelper.stringForVideoTime(n26Var.getThreadData().getThreadVideoInfo().video_duration.intValue() * 1000));
                str = n26Var.getThreadData().getThreadVideoInfo().thumbnail_url;
            }
        } else {
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            if (n26Var.getThreadData().getMedias() != null && n26Var.getThreadData().getMedias().size() >= 1) {
                str = n26Var.getThreadData().getMedias().get(0).origin_pic;
            }
        }
        this.k.K(str, 10, false);
        this.n.setText(n26Var.getThreadData().getTitle());
        yl8 readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.d(n26Var.getThreadData().getId())) {
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0108);
        } else {
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0105);
        }
        this.o.setData(n26Var.getThreadData(), false);
        this.q.setText(StringHelper.getFormatTimeShort(n26Var.getThreadData().getAuditTime()));
        if ("news".equals(n26Var.getThreadData().getGameInformationSource())) {
            this.o.setVisibility(8);
            this.p.setText(this.b.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0e36, StringHelper.numberUniformFormat(n26Var.getThreadData().getView_num())));
            return;
        }
        this.o.setVisibility(0);
        y(n26Var.getThreadData());
    }

    public String u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? StringHelper.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE) : (String) invokeL.objValue;
    }

    public void v(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || (view2 = this.r) == null) {
            return;
        }
        view2.setVisibility(i);
    }

    public void w(int i, int i2, int i3, int i4) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3, i4) == null) || (linearLayout = this.i) == null) {
            return;
        }
        linearLayout.setPadding(i, i2, i3, i4);
    }

    public void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.o.setVisibility(i);
        }
    }

    public final void y(ThreadData threadData) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, threadData) == null) || (textView = this.p) == null || threadData == null) {
            return;
        }
        textView.setVisibility(0);
        if (StringUtils.isNull(threadData.getAuthor().getName_show())) {
            return;
        }
        this.p.setText(u(threadData.getAuthor().getName_show()));
    }
}
