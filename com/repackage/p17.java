package com.repackage;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.view.CellTopicLinearLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class p17 extends uw5<h17> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int i;
    public CellTopicLinearLayout j;
    public TextView k;
    public TbImageView l;
    public TextView m;
    public TextView n;
    public h17 o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p17(TbPageContext<?> tbPageContext) {
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
        this.i = 3;
        View k = k();
        this.j = (CellTopicLinearLayout) k.findViewById(R.id.obfuscated_res_0x7f09215a);
        this.k = (TextView) k.findViewById(R.id.obfuscated_res_0x7f09215e);
        this.l = (TbImageView) k.findViewById(R.id.obfuscated_res_0x7f09215c);
        this.m = (TextView) k.findViewById(R.id.obfuscated_res_0x7f09215d);
        this.n = (TextView) k.findViewById(R.id.obfuscated_res_0x7f09215b);
        this.l.setRadius(mi.f(this.c, R.dimen.tbds10));
        this.l.setConrers(15);
        this.l.setPlaceHolder(2);
        this.j.setTopicOnClickListener(this);
    }

    @Override // com.repackage.uw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01be : invokeV.intValue;
    }

    @Override // com.repackage.uw5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) || i == this.i) {
            return;
        }
        this.i = i;
        SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0105);
        this.l.setSkinType(this.i);
        SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        h17 h17Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view2) == null) || (h17Var = this.o) == null || h17Var.e == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c13354").param("tid", this.o.e.tid).param("topic_id", this.o.c).param("obj_locate", this.o.b));
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.b.getPageActivity()).createFromThreadCfg(this.o.e, null, "", 18005, true, false, false);
        if (this.o.e.getForumData() == null) {
            createFromThreadCfg.setForumId(String.valueOf(this.o.e.getFid()));
            createFromThreadCfg.setForumName(this.o.e.getForum_name());
        } else {
            createFromThreadCfg.setForumId(this.o.e.getForumData().b());
            createFromThreadCfg.setForumName(this.o.e.getForumData().a());
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.uw5
    /* renamed from: s */
    public void l(h17 h17Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, h17Var) == null) || h17Var == null || h17Var.e == null) {
            return;
        }
        this.o = h17Var;
        if (h17Var.a) {
            if (StringUtils.isNull(h17Var.d)) {
                this.k.setText(R.string.obfuscated_res_0x7f0f143b);
            } else {
                this.k.setText(h17Var.d);
            }
        }
        this.k.setVisibility(h17Var.a ? 0 : 8);
        String str = null;
        if (!ListUtils.isEmpty(h17Var.e.getMedias())) {
            Iterator<MediaData> it = h17Var.e.getMedias().iterator();
            while (it.hasNext()) {
                MediaData next = it.next();
                if (next != null && next.getType() == 3) {
                    str = next.getPicUrl();
                    if (StringUtils.isNull(str)) {
                        str = next.getSmallUrl();
                    }
                    if (StringUtils.isNull(str)) {
                        str = next.getThumbnails_url();
                    }
                    if (StringUtils.isNull(str)) {
                        str = next.getSrc_pic();
                    }
                    if (!StringUtils.isNull(str)) {
                        break;
                    }
                }
            }
        }
        if (!StringHelper.equals(str, this.l.getUrl())) {
            this.l.G();
        }
        this.l.K(str, 10, false);
        if (StringUtils.isNull(h17Var.e.getTitle())) {
            this.m.setVisibility(8);
        } else {
            this.m.setVisibility(0);
            this.m.setText(h17Var.e.getTitle());
        }
        this.n.setText(String.format(this.c.getString(R.string.obfuscated_res_0x7f0f1433), Integer.valueOf(h17Var.e.getReply_num())));
    }
}
