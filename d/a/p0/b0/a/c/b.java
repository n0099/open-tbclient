package d.a.p0.b0.a.c;

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
import d.a.c.e.p.k;
import tbclient.HotThread.tinfo;
/* loaded from: classes7.dex */
public class b extends d.a.o0.g0.f.a<tinfo, d.a.o0.g0.d.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public LinearLayout p;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ tinfo f54528e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f54529f;

        public a(b bVar, tinfo tinfoVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, tinfoVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54529f = bVar;
            this.f54528e = tinfoVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                String str = this.f54528e.forum_name;
                if (k.isForumName(str)) {
                    TiebaStatic.eventStat(this.f54529f.a(), "kantie_6", null, 1, new Object[0]);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f54529f.a()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
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
        this.k = (TextView) view.findViewById(R.id.chosen_no_picture_title);
        this.l = (TextView) view.findViewById(R.id.chosen_no_picture_praise);
        this.m = (TextView) view.findViewById(R.id.chosen_no_picture_comment);
        this.n = (TextView) view.findViewById(R.id.chosen_no_picture_head);
        this.o = (TextView) view.findViewById(R.id.chosen_no_picture_sub);
        this.p = (LinearLayout) view.findViewById(R.id.chosen_no_picture_comment_line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.g0.f.e
    /* renamed from: o */
    public void k(tinfo tinfoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tinfoVar) == null) {
            super.k(tinfoVar);
            if (StringUtils.isNull(tinfoVar.title)) {
                this.n.setVisibility(8);
            } else {
                this.n.setVisibility(0);
                this.n.setText(tinfoVar.title);
            }
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.p.setVisibility(8);
            } else {
                this.p.setVisibility(0);
                this.k.setVisibility(0);
                this.k.setText(UtilHelper.getFixedText(b().getString(R.string.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.k.setOnClickListener(new a(this, tinfoVar));
                if (tinfoVar.zan_num == null) {
                    this.l.setVisibility(8);
                } else {
                    this.l.setVisibility(0);
                    TextView textView = this.l;
                    textView.setText(tinfoVar.zan_num + "");
                }
                if (tinfoVar.reply_num == null) {
                    this.m.setVisibility(8);
                } else {
                    this.m.setVisibility(0);
                    TextView textView2 = this.m;
                    textView2.setText(tinfoVar.reply_num + "");
                }
            }
            if (StringUtils.isNull(tinfoVar._abstract)) {
                this.o.setVisibility(8);
                return;
            }
            this.o.setVisibility(0);
            this.o.setText(tinfoVar._abstract);
        }
    }

    @Override // d.a.p0.h3.t
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2)) == null) {
            d.a.o0.r.c layoutMode = e().getLayoutMode();
            layoutMode.k(i2 == 1);
            layoutMode.j(g());
            return true;
        }
        return invokeLI.booleanValue;
    }
}
