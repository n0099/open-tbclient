package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewCommonUtil;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.imMessageCenter.mention.base.MessageCardBottomView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.NewFloorInfo;
/* loaded from: classes5.dex */
public class bb7 extends uw5<wa7> {
    public static /* synthetic */ Interceptable $ic;
    public static wd5<String> C;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public OriginalThreadCardView.b B;
    public HeadImageView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public OriginalThreadCardView o;
    public LinearLayout p;
    public TextView q;
    public MessageCardBottomView r;
    public View s;
    public TbPageContext t;
    public int u;
    public wa7 v;
    public String w;
    public View x;
    public List<NewFloorInfo> y;
    public int z;

    /* loaded from: classes5.dex */
    public class a implements OriginalThreadCardView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bb7 a;

        public a(bb7 bb7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bb7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bb7Var;
        }

        @Override // com.baidu.tieba.card.OriginalThreadCardView.b
        public void a(OriginalThreadInfo originalThreadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, originalThreadInfo) == null) {
                gb7.a(this.a.v, 13);
                if (this.a.e() != null) {
                    ux5<wa7> e = this.a.e();
                    bb7 bb7Var = this.a;
                    e.a(bb7Var.o, bb7Var.v);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755832678, "Lcom/repackage/bb7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755832678, "Lcom/repackage/bb7;");
                return;
            }
        }
        C = new wd5<>();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bb7(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (ViewGroup) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.u = 3;
        this.A = null;
        this.B = new a(this);
        this.t = tbPageContext;
        u();
    }

    @Override // com.repackage.uw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01b9 : invokeV.intValue;
    }

    @Override // com.repackage.uw5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) || this.u == i) {
            return;
        }
        this.u = i;
        SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0105);
        OriginalThreadCardView originalThreadCardView = this.o;
        if (originalThreadCardView != null) {
            if (this.z == 3) {
                originalThreadCardView.s(R.color.CAM_X0201, R.color.CAM_X0107, R.color.CAM_X0107);
            } else {
                originalThreadCardView.s(R.color.CAM_X0204, R.color.CAM_X0107, R.color.CAM_X0107);
            }
        }
        MessageCardBottomView messageCardBottomView = this.r;
        if (messageCardBottomView != null) {
            messageCardBottomView.b();
        }
        SkinManager.setBackgroundResource(this.s, R.drawable.icon_news_red_dot);
        gs4 d = gs4.d(this.k);
        d.n(R.string.J_X04);
        d.v(R.color.CAM_X0108);
        d.A(R.string.F_X01);
        d.f(R.color.CAM_X0204);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        wa7 wa7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view2) == null) || (wa7Var = this.v) == null || this.t == null) {
            return;
        }
        this.y = wa7Var.k();
        if (view2 != this.i && view2 != this.j) {
            if (view2 == this.q) {
                gb7.a(this.v, 12);
            } else if (view2 == this.r.getReplyContainer()) {
                gb7.a(this.v, 15);
            }
        } else if (this.v.y() == null) {
            return;
        } else {
            gb7.a(this.v, 14);
            String userId = this.v.y().getUserId();
            String userName = this.v.y().getUserName();
            if (userId != null && userId.length() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.t.getContext(), userId, userName)));
            }
        }
        if (e() != null) {
            e().a(view2, this.v);
        }
    }

    public final void t(@NonNull View view2, @NonNull wa7 wa7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, view2, wa7Var) == null) {
            if (StringHelper.equals(C.a(), wa7Var.r())) {
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0313);
            } else {
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0205);
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            View k = k();
            this.x = k;
            this.i = (HeadImageView) k.findViewById(R.id.obfuscated_res_0x7f09187a);
            this.j = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f0922f3);
            this.k = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f090975);
            this.l = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f0918fc);
            this.m = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f092045);
            this.n = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f09055d);
            this.o = (OriginalThreadCardView) this.x.findViewById(R.id.obfuscated_res_0x7f09163d);
            this.r = (MessageCardBottomView) this.x.findViewById(R.id.obfuscated_res_0x7f090559);
            this.s = this.x.findViewById(R.id.obfuscated_res_0x7f091565);
            this.p = (LinearLayout) this.x.findViewById(R.id.obfuscated_res_0x7f091566);
            this.q = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f09055e);
            ViewCommonUtil.setViewPadding(this.o, mi.f(getContext(), R.dimen.M_W_X004), mi.f(getContext(), R.dimen.M_H_X003), mi.f(getContext(), R.dimen.M_W_X004), mi.f(getContext(), R.dimen.M_H_X003));
            this.o.setUsePlaceHolder(false);
            this.i.setOnClickListener(this);
            this.j.setOnClickListener(this);
            this.r.getReplyContainer().setOnClickListener(this);
            this.q.setOnClickListener(this);
        }
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? VideoRecommentPlayActivityConfig.FROM_AT_PAGE.equals(this.w) : invokeV.booleanValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE.equals(this.w) : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.uw5
    /* renamed from: x */
    public void l(wa7 wa7Var) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, wa7Var) == null) || wa7Var == null || wa7Var.y() == null) {
            return;
        }
        this.v = wa7Var;
        MetaData y = wa7Var.y();
        this.i.setVisibility(0);
        boolean z = true;
        this.i.setPlaceHolder(1);
        this.i.setIsRound(true);
        UtilHelper.showHeadImageViewBigV(this.i, y, 0);
        this.i.setTag(null);
        this.i.setPageId(this.t.getUniqueId());
        this.i.K(this.v.y().getAvater(), 12, false);
        this.j.setText(StringHelper.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(y), 14, StringHelper.STRING_MORE));
        if (this.v.y().getIsMyFans() == 1) {
            this.k.setVisibility(0);
        } else {
            this.k.setVisibility(8);
        }
        if (this.v.getCardType() != 2 && this.v.getCardType() != 3) {
            if (this.v.getCardType() == 1) {
                this.l.setVisibility(0);
                if (v()) {
                    this.l.setText(getContext().getString(R.string.obfuscated_res_0x7f0f02a1));
                } else if (w()) {
                    this.l.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0fa2));
                }
            } else {
                this.l.setVisibility(8);
            }
        } else {
            this.l.setVisibility(0);
            if (v()) {
                this.l.setText(getContext().getString(R.string.obfuscated_res_0x7f0f02a0));
            } else if (w()) {
                this.l.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0fa3));
            }
        }
        this.m.setText(StringHelper.getFormatTime(this.v.getTime()));
        if (this.v.k() != null) {
            List<NewFloorInfo> k = this.v.k();
            this.y = k;
            if (k.size() <= 2 && this.n != null) {
                if (this.v.k().size() > 1 && this.y.get(1) != null) {
                    this.n.setVisibility(0);
                    this.n.setOnTouchListener(new uv8(xf5.E(this.y.get(1).content)));
                    this.n.setText(xf5.E(this.y.get(1).content));
                    this.z = 2;
                } else if (this.v.k().size() == 1) {
                    this.z = 1;
                    this.n.setVisibility(8);
                } else if (this.v.k().size() == 0) {
                    this.z = 1;
                    this.n.setVisibility(8);
                    this.q.setVisibility(8);
                    gs4 d = gs4.d(this.p);
                    d.n(R.string.J_X05);
                    d.f(R.color.CAM_X0201);
                    gs4 d2 = gs4.d(this.o);
                    d2.n(R.string.J_X05);
                    d2.f(R.color.CAM_X0204);
                    ViewCommonUtil.setViewMargin(this.p, 0, mi.f(getContext(), R.dimen.M_H_X004), 0, mi.f(getContext(), R.dimen.M_H_X005));
                    this.p.setPadding(0, 0, 0, 0);
                    ViewCommonUtil.setViewMargin(this.o, 0, 0, 0, 0);
                }
                this.q.setVisibility(8);
                gs4 d3 = gs4.d(this.p);
                d3.n(R.string.J_X05);
                d3.f(R.color.CAM_X0201);
                gs4 d4 = gs4.d(this.o);
                d4.n(R.string.J_X05);
                d4.f(R.color.CAM_X0204);
                ViewCommonUtil.setViewMargin(this.p, 0, mi.f(getContext(), R.dimen.M_H_X004), 0, mi.f(getContext(), R.dimen.M_H_X005));
                this.p.setPadding(0, 0, 0, 0);
                ViewCommonUtil.setViewMargin(this.o, 0, 0, 0, 0);
            } else {
                if (this.y.get(2) != null && (textView = this.n) != null) {
                    textView.setVisibility(0);
                    this.n.setOnTouchListener(new uv8(xf5.E(this.y.get(2).content)));
                    this.n.setText(xf5.E(this.y.get(2).content));
                }
                this.z = 3;
                this.q.setVisibility(0);
                ViewCommonUtil.setViewMargin(this.q, mi.f(getContext(), R.dimen.M_W_X005), mi.f(getContext(), R.dimen.M_H_X004), mi.f(getContext(), R.dimen.M_W_X005), 0);
                ViewCommonUtil.setViewMargin(this.p, 0, mi.f(getContext(), R.dimen.M_H_X004), 0, mi.f(getContext(), R.dimen.M_H_X005));
                ViewCommonUtil.setViewMargin(this.o, mi.f(getContext(), R.dimen.M_W_X005), mi.f(getContext(), R.dimen.M_H_X004), mi.f(getContext(), R.dimen.M_W_X005), mi.f(getContext(), R.dimen.M_H_X004));
                this.p.setPadding(0, 0, 0, 0);
                gs4 d5 = gs4.d(this.p);
                d5.n(R.string.J_X05);
                d5.f(R.color.CAM_X0204);
                gs4 d6 = gs4.d(this.o);
                d6.n(R.string.J_X05);
                d6.f(R.color.CAM_X0201);
                if (this.y.get(1) != null) {
                    this.q.setOnTouchListener(new uv8(xf5.E(this.y.get(1).content)));
                    this.q.setText(xf5.E(this.y.get(1).content));
                    this.v.J(TbRichTextView.X(this.y.get(1).content, false));
                    this.q.setTag(R.id.obfuscated_res_0x7f090f6c, Boolean.valueOf(this.y.get(1).is_floor.intValue() == 1));
                }
            }
            if (this.v.k().size() != 0 && this.y.get(0) != null) {
                this.v.I(TbRichTextView.X(this.y.get(0).content, false));
                this.A = this.v.g().toString();
            }
        }
        if (this.v.k().size() != 0) {
            this.o.setCardFrom(this.w);
            this.o.i(this.v.m(), this.A);
            this.o.setSubClickListener(this.B);
            this.r.setData(this.v.e(), (this.v.getType() == wa7.x || this.v.getType() == wa7.y) ? false : false);
        } else {
            this.o.i(null, "");
            this.r.setData("", (this.v.getType() == wa7.x || this.v.getType() == wa7.y) ? false : false);
        }
        if (this.v.D()) {
            this.s.setVisibility(0);
        } else {
            this.s.setVisibility(8);
        }
        t(k(), this.v);
        m(this.t, TbadkCoreApplication.getInst().getSkinType());
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.w = str;
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && this.n != null && v()) {
            if (z) {
                this.n.setMaxLines(5);
            } else {
                this.n.setMaxLines(2);
            }
        }
    }
}
