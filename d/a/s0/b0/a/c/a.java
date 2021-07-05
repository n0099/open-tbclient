package d.a.s0.b0.a.c;

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
import d.a.c.e.p.k;
import java.util.List;
import tbclient.HotThread.Pic;
import tbclient.HotThread.tinfo;
/* loaded from: classes9.dex */
public class a extends d.a.r0.g0.f.a<tinfo, d.a.r0.g0.d.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public View p;

    /* renamed from: d.a.s0.b0.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1333a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ tinfo f57781e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f57782f;

        public View$OnClickListenerC1333a(a aVar, tinfo tinfoVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, tinfoVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57782f = aVar;
            this.f57781e = tinfoVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                String str = this.f57781e.forum_name;
                if (k.isForumName(str)) {
                    TiebaStatic.eventStat(this.f57782f.a(), "kantie_6", null, 1, new Object[0]);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f57782f.a()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, viewEventCenter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (View) objArr2[1], (ViewEventCenter) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = (TbImageView) view.findViewById(R.id.chosen_image_text_img);
        this.l = (TextView) view.findViewById(R.id.chosen_image_text_title);
        this.p = view.findViewById(R.id.chosen_image_text_divider);
        this.m = (TextView) view.findViewById(R.id.chosen_image_text_forum);
        this.n = (TextView) view.findViewById(R.id.chosen_image_text_praise);
        this.o = (TextView) view.findViewById(R.id.chosen_image_text_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.r0.g0.f.e
    /* renamed from: o */
    public void k(tinfo tinfoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tinfoVar) == null) {
            super.k(tinfoVar);
            if (tinfoVar == null) {
                return;
            }
            String str = null;
            List<Pic> list = tinfoVar.pics;
            if (list != null && list.size() > 0) {
                str = tinfoVar.pics.get(0).small_pic;
            }
            this.k.M(str, 10, false);
            this.l.setText(tinfoVar.title);
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.m.setVisibility(8);
            } else {
                this.m.setVisibility(0);
                this.m.setText(UtilHelper.getFixedText(b().getString(R.string.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.m.setOnClickListener(new View$OnClickListenerC1333a(this, tinfoVar));
            }
            Integer num = tinfoVar.zan_num;
            if (num != null) {
                this.n.setText(String.valueOf(num));
            }
            Integer num2 = tinfoVar.reply_num;
            if (num2 != null) {
                this.o.setText(String.valueOf(num2));
            }
            this.p.setVisibility(0);
            d.a.s0.h3.n0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.d(String.valueOf(tinfoVar.forum_id))) {
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0109, 1);
            } else {
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0105, 1);
            }
        }
    }

    @Override // d.a.s0.h3.t
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2)) == null) {
            d.a.r0.s0.a.a(tbPageContext, g());
            return true;
        }
        return invokeLI.booleanValue;
    }
}
