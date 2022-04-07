package com.repackage;

import android.view.View;
import android.widget.LinearLayout;
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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.HotThread.tinfo;
/* loaded from: classes7.dex */
public class ry5 extends a75<tinfo, v65> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public LinearLayout l;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tinfo a;
        public final /* synthetic */ ry5 b;

        public a(ry5 ry5Var, tinfo tinfoVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry5Var, tinfoVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ry5Var;
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
    public ry5(TbPageContext<?> tbPageContext, View view2, ViewEventCenter viewEventCenter) {
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
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09062d);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09062b);
        this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090628);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09062a);
        this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09062c);
        this.l = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090629);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.e75
    /* renamed from: m */
    public void i(tinfo tinfoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tinfoVar) == null) {
            super.i(tinfoVar);
            if (StringUtils.isNull(tinfoVar.title)) {
                this.j.setVisibility(8);
            } else {
                this.j.setVisibility(0);
                this.j.setText(tinfoVar.title);
            }
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.l.setVisibility(8);
            } else {
                this.l.setVisibility(0);
                this.g.setVisibility(0);
                this.g.setText(UtilHelper.getFixedText(getContext().getString(R.string.obfuscated_res_0x7f0f03c7, tinfoVar.forum_name), 7, false));
                this.g.setOnClickListener(new a(this, tinfoVar));
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
            }
            if (StringUtils.isNull(tinfoVar._abstract)) {
                this.k.setVisibility(8);
                return;
            }
            this.k.setVisibility(0);
            this.k.setText(tinfoVar._abstract);
        }
    }

    @Override // com.repackage.sj8
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i)) == null) {
            tm4 layoutMode = d().getLayoutMode();
            layoutMode.k(i == 1);
            layoutMode.j(e());
            return true;
        }
        return invokeLI.booleanValue;
    }
}
