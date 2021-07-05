package d.a.s0.m2.j;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.z0.j0;
/* loaded from: classes9.dex */
public class b extends d.a.s0.a0.b<d.a.s0.m2.e.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public BarImageView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public d.a.s0.m2.e.b v;
    public LikeModel w;
    public boolean x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f63602a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63602a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f63602a.x) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof d.a.s0.h3.q0.e) {
                d.a.s0.h3.q0.e eVar = (d.a.s0.h3.q0.e) data;
                if (eVar.f61442a == this.f63602a.v.j) {
                    if (eVar.f61443b) {
                        this.f63602a.v.m = true;
                        this.f63602a.u.setVisibility(0);
                        this.f63602a.z(true);
                        d.a.c.e.p.l.L(this.f63602a.f57033g, R.string.attention_success);
                    } else if (StringUtils.isNull(eVar.f61444c)) {
                        d.a.c.e.p.l.L(this.f63602a.f57033g, R.string.attention_fail);
                    } else {
                        d.a.c.e.p.l.M(this.f63602a.f57033g, eVar.f61444c);
                    }
                }
            }
        }
    }

    /* renamed from: d.a.s0.m2.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1594b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f63603a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1594b(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63603a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f63603a.x) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof d.a.s0.h3.q0.e) {
                d.a.s0.h3.q0.e eVar = (d.a.s0.h3.q0.e) data;
                if (eVar.f61442a == this.f63603a.v.j) {
                    if (eVar.f61443b) {
                        this.f63603a.v.m = false;
                        this.f63603a.u.setVisibility(0);
                        b bVar = this.f63603a;
                        bVar.z(bVar.v.m);
                        d.a.c.e.p.l.L(this.f63603a.f57033g, R.string.unlike_success);
                        return;
                    }
                    d.a.c.e.p.l.L(this.f63603a.f57033g, R.string.unlike_failure);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.y = new a(this, 2001437);
        this.z = new C1594b(this, 2001438);
        w(l());
    }

    @Override // d.a.s0.a0.b
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.card_polymeric_attention_bar_view : invokeV.intValue;
    }

    @Override // d.a.s0.a0.b
    public void n(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            if (this.f57031e != i2) {
                SkinManager.setBackgroundResource(this.m, R.drawable.item_person_header_attention_bg_selector);
                SkinManager.setViewTextColor(this.n, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.o, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.p, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.q, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.s, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(this.t, R.color.CAM_X0108, 1);
                d.a.s0.m2.e.b bVar = this.v;
                if (bVar != null) {
                    z(bVar.m);
                }
            }
            this.f57031e = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (this.m == view) {
                if (!this.x) {
                    TiebaStatic.log(new StatisticItem("c11595"));
                }
                this.f57032f.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f57033g).createNormalCfg(this.v.l, "")));
            } else if (this.u == view) {
                TiebaStatic.log(new StatisticItem("c11596"));
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ViewHelper.skipToLoginActivity(this.f57033g);
                } else if (d.a.c.e.p.k.isForumName(this.v.l)) {
                    d.a.s0.m2.e.b bVar = this.v;
                    if (bVar.m) {
                        return;
                    }
                    this.w.L(bVar.l, String.valueOf(bVar.j));
                }
            }
        }
    }

    public final void w(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            this.m = view.findViewById(R.id.card_polymeric_attention_bar_rootview);
            this.n = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_day);
            this.o = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_month);
            this.p = (TextView) view.findViewById(R.id.card_polymeric_attention_sex);
            this.q = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_des);
            this.r = (BarImageView) view.findViewById(R.id.card_polymeric_attention_icon);
            this.s = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_name);
            this.t = (TextView) view.findViewById(R.id.card_polymeric_attention_post_num);
            this.u = (TextView) view.findViewById(R.id.card_polymeric_attention_btn);
            this.m.setOnClickListener(this);
            this.u.setOnClickListener(this);
            this.f57032f.registerListener(this.y);
            this.f57032f.registerListener(this.z);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.s0.a0.b
    /* renamed from: x */
    public void m(d.a.s0.m2.e.b bVar) {
        Context context;
        int i2;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            if (bVar == null) {
                this.m.setVisibility(8);
                return;
            }
            if (this.m.getVisibility() != 0) {
                this.m.setVisibility(0);
            }
            this.v = bVar;
            this.x = bVar.f63469e;
            this.n.setVisibility(bVar.f63471g ? 0 : 4);
            this.o.setVisibility(bVar.f63471g ? 0 : 4);
            this.n.setText(bVar.f63473i);
            this.o.setText(bVar.f63472h);
            TextView textView = this.p;
            if (bVar.f63469e) {
                string = this.f57033g.getString(R.string.me);
            } else {
                if (bVar.f63470f == 2) {
                    context = this.f57033g;
                    i2 = R.string.she;
                } else {
                    context = this.f57033g;
                    i2 = R.string.he;
                }
                string = context.getString(i2);
            }
            textView.setText(string);
            this.r.M(bVar.k, 10, false);
            String str = bVar.l;
            if (j0.b(str) > 10) {
                str = j0.k(str, 0, 10) + StringHelper.STRING_MORE;
            }
            this.s.setText(String.format(this.f57033g.getString(R.string.person_polymeric_bar_suffix), str));
            String numFormatOverWanNa = StringHelper.numFormatOverWanNa(bVar.n);
            this.t.setText(bVar.f63469e ? String.format(this.f57033g.getString(R.string.person_polymeric_attention_post_host), numFormatOverWanNa, StringHelper.numFormatOverWanNa(bVar.o)) : String.format(this.f57033g.getString(R.string.person_polymeric_attention_post_guess), numFormatOverWanNa));
            if (!bVar.m && !bVar.f63469e) {
                this.u.setVisibility(0);
                z(bVar.m);
                return;
            }
            this.u.setVisibility(8);
        }
    }

    public void y(LikeModel likeModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, likeModel) == null) {
            this.w = likeModel;
        }
    }

    public final void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                this.u.setText(this.f57033g.getString(R.string.relate_forum_is_followed));
                SkinManager.setViewTextColor(this.u, R.color.CAM_X0110);
                SkinManager.setBackgroundResource(this.u, R.color.transparent);
                this.u.setClickable(false);
                return;
            }
            this.u.setText(this.f57033g.getString(R.string.focus_text));
            SkinManager.setViewTextColor(this.u, R.color.CAM_X0302, 1);
            SkinManager.setBackgroundResource(this.u, R.drawable.polymeric_attention_btn_bg);
            this.u.setClickable(true);
        }
    }
}
