package com.repackage;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
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
public class ty5 extends q75<tinfo, l75> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public View l;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tinfo a;
        public final /* synthetic */ ty5 b;

        public a(ty5 ty5Var, tinfo tinfoVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ty5Var, tinfoVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ty5Var;
            this.a = tinfoVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String str = this.a.forum_name;
                if (li.isForumName(str)) {
                    TiebaStatic.eventStat(this.b.getActivity(), "kantie_6", null, 1, new Object[0]);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.b.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ty5(TbPageContext<?> tbPageContext, View view2, ViewEventCenter viewEventCenter) {
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
        this.g = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f09061d);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09061f);
        this.l = view2.findViewById(R.id.obfuscated_res_0x7f09061b);
        this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09061c);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09061e);
        this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090619);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.u75
    /* renamed from: m */
    public void i(tinfo tinfoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tinfoVar) == null) {
            super.i(tinfoVar);
            if (tinfoVar == null) {
                return;
            }
            String str = null;
            List<Pic> list = tinfoVar.pics;
            if (list != null && list.size() > 0) {
                str = tinfoVar.pics.get(0).small_pic;
            }
            this.g.K(str, 10, false);
            this.h.setText(tinfoVar.title);
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.i.setVisibility(8);
            } else {
                this.i.setVisibility(0);
                this.i.setText(UtilHelper.getFixedText(getContext().getString(R.string.obfuscated_res_0x7f0f03cc, tinfoVar.forum_name), 7, false));
                this.i.setOnClickListener(new a(this, tinfoVar));
            }
            Integer num = tinfoVar.zan_num;
            if (num != null) {
                this.j.setText(String.valueOf(num));
            }
            Integer num2 = tinfoVar.reply_num;
            if (num2 != null) {
                this.k.setText(String.valueOf(num2));
            }
            this.l.setVisibility(0);
            cl8 readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.d(String.valueOf(tinfoVar.forum_id))) {
                SkinManager.setViewTextColor(this.h, R.color.CAM_X0109, 1);
            } else {
                SkinManager.setViewTextColor(this.h, R.color.CAM_X0105, 1);
            }
        }
    }

    @Override // com.repackage.wi8
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i)) == null) {
            w95.a(tbPageContext, e());
            return true;
        }
        return invokeLI.booleanValue;
    }
}
