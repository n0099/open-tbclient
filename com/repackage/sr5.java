package com.repackage;

import android.text.TextUtils;
import android.view.View;
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
/* loaded from: classes7.dex */
public class sr5 extends uw5<wn5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int i;
    public TbPageContext<?> j;
    public c k;
    public wr5 l;
    public ThreadData m;
    public int n;
    public String o;
    public boolean p;
    public View.OnClickListener q;
    public View.OnClickListener r;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sr5 a;

        public a(sr5 sr5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sr5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sr5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (ki.z()) {
                    if (this.a.m == null || this.a.m.getThreadAlaInfo() == null || this.a.l == null) {
                        return;
                    }
                    this.a.l.a(this.a.n, this.a.o, this.a.m);
                    return;
                }
                mi.K(this.a.j.getPageActivity(), this.a.j.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0c65));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sr5 a;

        public b(sr5 sr5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sr5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sr5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.m == null || this.a.m.getAuthor() == null || StringUtils.isNull(this.a.m.getAuthor().getUserId())) {
                return;
            }
            long g = kg.g(this.a.m.getAuthor().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.a.j.getPageActivity()).createNormalConfig(g, g == kg.g(TbadkCoreApplication.getCurrentAccount(), 0L), this.a.m.getAuthor().isBigV())));
        }
    }

    /* loaded from: classes7.dex */
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

        public c(sr5 sr5Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sr5Var, view2};
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
            this.b = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e9a);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921a8);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921a7);
            this.e = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091b00);
            this.f = (ClickableHeaderImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e9b);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921b4);
            this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921b1);
            this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921ae);
            view2.setOnClickListener(sr5Var.q);
            this.b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.b.setDrawerType(0);
            this.f.setIsRound(true);
            this.f.setDrawBorder(true);
            this.f.setBorderColor(sr5Var.j.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f.setBorderWidth(sr5Var.j.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070198));
            this.f.setIsGod(false);
            this.f.setIsBigV(false);
            this.f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.e.getLayoutParams();
            int k = (mi.k(view2.getContext()) - view2.getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224)) / 2;
            layoutParams.width = k;
            layoutParams.height = (k * 9) / 16;
            this.e.setLayoutParams(layoutParams);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sr5(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
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
        this.i = 3;
        this.p = false;
        this.q = new a(this);
        this.r = new b(this);
        this.j = tbPageContext;
        this.k = new c(this, k());
        this.p = z;
    }

    @Override // com.repackage.uw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d010c : invokeV.intValue;
    }

    @Override // com.repackage.uw5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) || this.i == i) {
            return;
        }
        SkinManager.setBackgroundResource(this.k.e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.k.d, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.k.g, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.k.h, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.k.i, (int) R.color.CAM_X0109);
        this.i = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.uw5
    /* renamed from: y */
    public void l(wn5 wn5Var) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, wn5Var) == null) {
            if (wn5Var != null && (threadData = wn5Var.d) != null && threadData.getThreadAlaInfo() != null) {
                k().setVisibility(0);
                this.m = wn5Var.d;
                this.n = wn5Var.a;
                this.o = !TextUtils.isEmpty(wn5Var.c) ? wn5Var.c : wn5Var.b;
                this.k.b.K(this.m.getThreadAlaInfo().cover, 10, false);
                this.k.d.setText(this.j.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f11d8, StringHelper.numberUniformFormatExtra(this.m.getThreadAlaInfo().audience_count)));
                this.k.f.setData(this.m, false);
                this.k.h.setText(this.m.getTitle());
                if (this.m.getAuthor() != null) {
                    String name_show = this.m.getAuthor().getName_show();
                    if (xd5.d(name_show) > 10) {
                        name_show = xd5.n(name_show, 10) + StringHelper.STRING_MORE;
                    }
                    this.k.g.setText(name_show);
                }
                String str = this.m.getThreadAlaInfo().label_name;
                if (this.p && !StringUtils.isNull(str)) {
                    this.k.c.setText(str);
                    this.k.c.setVisibility(0);
                } else {
                    this.k.c.setVisibility(8);
                }
                if (wn5Var.e) {
                    this.k.i.setText(this.j.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f11d7, StringHelper.numberUniformFormatExtra((long) (this.m.getThreadAlaInfo().distance / 1000.0d))));
                    this.k.i.setVisibility(0);
                } else {
                    this.k.i.setVisibility(8);
                }
                this.k.g.setOnClickListener(this.r);
                m(this.j, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            k().setVisibility(4);
        }
    }

    public void z(wr5 wr5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, wr5Var) == null) {
            this.l = wr5Var;
        }
    }
}
