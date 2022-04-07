package com.repackage;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.HotThread.Pic;
import tbclient.HotThread.tinfo;
/* loaded from: classes7.dex */
public class sy5 extends a75<tinfo, v65> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public RelativeLayout k;
    public TbImageView l;
    public TbImageView m;
    public TbImageView n;
    public View.OnClickListener o;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sy5 a;

        public a(sy5 sy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sy5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sy5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Object tag = view2.getTag();
                if (tag instanceof Integer) {
                    s65 s65Var = new s65(4096, new ty5(((Integer) tag).intValue(), this.a.b()), null, null);
                    s65Var.i(this.a.h());
                    this.a.c().dispatchMvcEvent(s65Var);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tinfo a;
        public final /* synthetic */ sy5 b;

        public b(sy5 sy5Var, tinfo tinfoVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sy5Var, tinfoVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sy5Var;
            this.a = tinfoVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String str = this.a.forum_name;
                if (ni.isForumName(str)) {
                    TiebaStatic.eventStat(this.b.getActivity(), "kantie_6", null, 1, new Object[0]);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.b.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sy5(TbPageContext<?> tbPageContext, View view2, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view2, viewEventCenter);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, viewEventCenter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (View) objArr2[1], (ViewEventCenter) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new a(this);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09064d);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09064c);
        this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090646);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090647);
        this.k = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090648);
        this.l = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090649);
        this.m = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f09064b);
        this.n = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f09064a);
        this.l.setOnClickListener(this.o);
        this.m.setOnClickListener(this.o);
        this.n.setOnClickListener(this.o);
    }

    public final void n(tinfo tinfoVar) {
        List<Pic> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tinfoVar) == null) || tinfoVar == null) {
            return;
        }
        if (cn4.c().g() && (list = tinfoVar.pics) != null && list.size() > 0) {
            this.k.setVisibility(0);
            int size = tinfoVar.pics.size();
            if (size != 1) {
                if (size != 2) {
                    if (size != 3) {
                        return;
                    }
                    String str = tinfoVar.pics.get(2).small_pic;
                    this.n.setVisibility(0);
                    this.n.K(str, 10, false);
                    this.n.setTag(2);
                }
                String str2 = tinfoVar.pics.get(1).small_pic;
                this.m.setVisibility(0);
                this.m.K(str2, 10, false);
                this.m.setTag(1);
            }
            String str3 = tinfoVar.pics.get(0).small_pic;
            this.l.setVisibility(0);
            this.l.K(str3, 10, false);
            this.l.setTag(0);
            return;
        }
        this.k.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.e75
    /* renamed from: o */
    public void i(tinfo tinfoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tinfoVar) == null) {
            super.i(tinfoVar);
            if (tinfoVar == null) {
                return;
            }
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.g.setVisibility(8);
            } else {
                this.g.setVisibility(0);
                this.g.setText(UtilHelper.getFixedText(getContext().getString(R.string.obfuscated_res_0x7f0f03c7, tinfoVar.forum_name), 7, false));
                this.g.setOnClickListener(new b(this, tinfoVar));
            }
            if (StringUtils.isNull(tinfoVar.title)) {
                this.j.setVisibility(8);
            } else {
                this.j.setVisibility(0);
                this.j.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.h.setVisibility(8);
            } else {
                this.h.setVisibility(0);
                TextView textView = this.h;
                textView.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.i.setVisibility(8);
            } else {
                this.i.setVisibility(0);
                TextView textView2 = this.i;
                textView2.setText(tinfoVar.reply_num + "");
            }
            n(tinfoVar);
        }
    }

    @Override // com.repackage.sj8
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, tbPageContext, i)) == null) {
            tm4 layoutMode = d().getLayoutMode();
            layoutMode.k(i == 1);
            layoutMode.j(e());
            return true;
        }
        return invokeLI.booleanValue;
    }
}
