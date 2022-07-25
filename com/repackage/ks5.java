package com.repackage;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
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
/* loaded from: classes6.dex */
public class ks5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbPageContext<?> b;
    public c c;
    public View d;
    public int e;
    public String f;
    public ThreadData g;
    public ls5 h;
    public boolean i;
    public View.OnClickListener j;
    public View.OnClickListener k;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ks5 a;

        public a(ks5 ks5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ks5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ks5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (ni.z()) {
                    if (this.a.g == null || this.a.g.getThreadAlaInfo() == null || this.a.h == null) {
                        return;
                    }
                    this.a.h.a(this.a.e, this.a.f, this.a.g);
                    return;
                }
                pi.L(this.a.b.getPageActivity(), this.a.b.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0c50));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ks5 a;

        public b(ks5 ks5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ks5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ks5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.g == null || this.a.g.getAuthor() == null || StringUtils.isNull(this.a.g.getAuthor().getUserId())) {
                return;
            }
            long g = ng.g(this.a.g.getAuthor().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.a.b.getPageActivity()).createNormalConfig(g, g == ng.g(TbadkCoreApplication.getCurrentAccount(), 0L), this.a.g.getAuthor().isBigV())));
        }
    }

    /* loaded from: classes6.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public TbImageView b;
        public TextView c;
        public TextView d;
        public RelativeLayout e;
        public ClickableHeaderImageView f;
        public TextView g;
        public TextView h;
        public TextView i;

        public c(ks5 ks5Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ks5Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
            this.b = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e57);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921ef);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921ee);
            this.e = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091b20);
            this.f = (ClickableHeaderImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e58);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921fb);
            this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921f8);
            this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921f5);
            view2.setOnClickListener(ks5Var.j);
            this.b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.b.setDrawerType(0);
            this.f.setIsRound(true);
            this.f.setDrawBorder(true);
            this.f.setBorderColor(ks5Var.b.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f.setBorderWidth(ks5Var.b.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070198));
            this.f.setIsGod(false);
            this.f.setIsBigV(false);
            this.f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.e.getLayoutParams();
            int k = (pi.k(view2.getContext()) - view2.getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d4)) / 2;
            layoutParams.width = k;
            layoutParams.height = k;
            this.e.setLayoutParams(layoutParams);
        }
    }

    public ks5(TbPageContext<?> tbPageContext, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.j = new a(this);
        this.k = new b(this);
        this.b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d010a, (ViewGroup) null, false);
        this.d = inflate;
        this.c = new c(this, inflate);
        this.i = z;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.d : (View) invokeV.objValue;
    }

    public void h(qo5 qo5Var) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qo5Var) == null) {
            if (qo5Var != null && (threadData = qo5Var.d) != null && threadData.getThreadAlaInfo() != null) {
                g().setVisibility(0);
                this.g = qo5Var.d;
                this.e = qo5Var.a;
                this.f = !TextUtils.isEmpty(qo5Var.c) ? qo5Var.c : qo5Var.b;
                this.c.b.setDrawerType(0);
                this.c.b.setBorderSurroundContent(true);
                this.c.b.setDrawBorder(true);
                this.c.b.J(this.g.getThreadAlaInfo().cover, 10, false);
                this.c.d.setText(this.b.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f119f, StringHelper.numberUniformFormatExtra(this.g.getThreadAlaInfo().audience_count)));
                this.c.f.setData(this.g, false);
                this.c.h.setText(this.g.getTitle());
                if (this.g.getAuthor() != null) {
                    String name_show = this.g.getAuthor().getName_show();
                    if (je5.d(name_show) > 10) {
                        name_show = je5.n(name_show, 10) + StringHelper.STRING_MORE;
                    }
                    this.c.g.setText(name_show);
                }
                String str = this.g.getThreadAlaInfo().label_name;
                if (this.i && !StringUtils.isNull(str)) {
                    this.c.c.setText(str);
                    this.c.c.setVisibility(0);
                } else {
                    this.c.c.setVisibility(8);
                }
                if (qo5Var.e) {
                    this.c.i.setText(this.b.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f119e, StringHelper.numberUniformFormatExtra((long) (this.g.getThreadAlaInfo().distance / 1000.0d))));
                    this.c.i.setVisibility(0);
                } else {
                    this.c.i.setVisibility(8);
                }
                this.c.g.setOnClickListener(this.k);
                i(this.b, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            g().setVisibility(4);
        }
    }

    public void i(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) || this.a == i) {
            return;
        }
        SkinManager.setBackgroundResource(this.c.e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.c.d, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.c.g, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.c.h, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.c.i, (int) R.color.CAM_X0109);
        this.a = i;
    }

    public void j(ls5 ls5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ls5Var) == null) {
            this.h = ls5Var;
        }
    }
}
