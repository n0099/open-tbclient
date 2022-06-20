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
public class ba7 extends mw5<w97> {
    public static /* synthetic */ Interceptable $ic;
    public static fd5<String> C;
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
    public w97 v;
    public String w;
    public View x;
    public List<NewFloorInfo> y;
    public int z;

    /* loaded from: classes5.dex */
    public class a implements OriginalThreadCardView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba7 a;

        public a(ba7 ba7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ba7Var;
        }

        @Override // com.baidu.tieba.card.OriginalThreadCardView.b
        public void a(OriginalThreadInfo originalThreadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, originalThreadInfo) == null) {
                fa7.a(this.a.v, 13);
                if (this.a.e() != null) {
                    mx5<w97> e = this.a.e();
                    ba7 ba7Var = this.a;
                    e.a(ba7Var.o, ba7Var.v);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755833639, "Lcom/repackage/ba7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755833639, "Lcom/repackage/ba7;");
                return;
            }
        }
        C = new fd5<>();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba7(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
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
        t();
    }

    @Override // com.repackage.mw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01b3 : invokeV.intValue;
    }

    @Override // com.repackage.mw5
    public void j(TbPageContext<?> tbPageContext, int i) {
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
        fr4 d = fr4.d(this.k);
        d.n(R.string.J_X04);
        d.v(R.color.CAM_X0108);
        d.A(R.string.F_X01);
        d.f(R.color.CAM_X0204);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        w97 w97Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view2) == null) || (w97Var = this.v) == null || this.t == null) {
            return;
        }
        this.y = w97Var.j();
        if (view2 != this.i && view2 != this.j) {
            if (view2 == this.q) {
                fa7.a(this.v, 12);
            } else if (view2 == this.r.getReplyContainer()) {
                fa7.a(this.v, 15);
            }
        } else if (this.v.w() == null) {
            return;
        } else {
            fa7.a(this.v, 14);
            String userId = this.v.w().getUserId();
            String userName = this.v.w().getUserName();
            if (userId != null && userId.length() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.t.getContext(), userId, userName)));
            }
        }
        if (e() != null) {
            e().a(view2, this.v);
        }
    }

    public final void s(@NonNull View view2, @NonNull w97 w97Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, view2, w97Var) == null) {
            if (StringHelper.equals(C.a(), w97Var.r())) {
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0313);
            } else {
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0205);
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            View h = h();
            this.x = h;
            this.i = (HeadImageView) h.findViewById(R.id.obfuscated_res_0x7f091825);
            this.j = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f092285);
            this.k = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f09094d);
            this.l = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f0918a8);
            this.m = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f091feb);
            this.n = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f090537);
            this.o = (OriginalThreadCardView) this.x.findViewById(R.id.obfuscated_res_0x7f0915e5);
            this.r = (MessageCardBottomView) this.x.findViewById(R.id.obfuscated_res_0x7f090533);
            this.s = this.x.findViewById(R.id.obfuscated_res_0x7f091515);
            this.p = (LinearLayout) this.x.findViewById(R.id.obfuscated_res_0x7f091516);
            this.q = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f090538);
            ViewCommonUtil.setViewPadding(this.o, pi.f(getContext(), R.dimen.M_W_X004), pi.f(getContext(), R.dimen.M_H_X003), pi.f(getContext(), R.dimen.M_W_X004), pi.f(getContext(), R.dimen.M_H_X003));
            this.o.setUsePlaceHolder(false);
            this.i.setOnClickListener(this);
            this.j.setOnClickListener(this);
            this.r.getReplyContainer().setOnClickListener(this);
            this.q.setOnClickListener(this);
        }
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? VideoRecommentPlayActivityConfig.FROM_AT_PAGE.equals(this.w) : invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE.equals(this.w) : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.mw5
    /* renamed from: w */
    public void i(w97 w97Var) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, w97Var) == null) || w97Var == null || w97Var.w() == null) {
            return;
        }
        this.v = w97Var;
        MetaData w = w97Var.w();
        this.i.setVisibility(0);
        boolean z = true;
        this.i.setPlaceHolder(1);
        this.i.setIsRound(true);
        UtilHelper.showHeadImageViewBigV(this.i, w, 0);
        this.i.setTag(null);
        this.i.setPageId(this.t.getUniqueId());
        this.i.J(this.v.w().getAvater(), 12, false);
        this.j.setText(StringHelper.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(w), 14, StringHelper.STRING_MORE));
        if (this.v.w().getIsMyFans() == 1) {
            this.k.setVisibility(0);
        } else {
            this.k.setVisibility(8);
        }
        if (this.v.getCardType() != 2 && this.v.getCardType() != 3) {
            if (this.v.getCardType() == 1) {
                this.l.setVisibility(0);
                if (u()) {
                    this.l.setText(getContext().getString(R.string.obfuscated_res_0x7f0f02a3));
                } else if (v()) {
                    this.l.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0fbe));
                }
            } else {
                this.l.setVisibility(8);
            }
        } else {
            this.l.setVisibility(0);
            if (u()) {
                this.l.setText(getContext().getString(R.string.obfuscated_res_0x7f0f02a2));
            } else if (v()) {
                this.l.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0fbf));
            }
        }
        this.m.setText(StringHelper.getFormatTime(this.v.getTime()));
        if (this.v.j() != null) {
            List<NewFloorInfo> j = this.v.j();
            this.y = j;
            if (j.size() <= 2 && this.n != null) {
                if (this.v.j().size() > 1 && this.y.get(1) != null) {
                    this.n.setVisibility(0);
                    this.n.setOnTouchListener(new et8(of5.E(this.y.get(1).content)));
                    this.n.setText(of5.E(this.y.get(1).content));
                    this.z = 2;
                } else if (this.v.j().size() == 1) {
                    this.z = 1;
                    this.n.setVisibility(8);
                } else if (this.v.j().size() == 0) {
                    this.z = 1;
                    this.n.setVisibility(8);
                    this.q.setVisibility(8);
                    fr4 d = fr4.d(this.p);
                    d.n(R.string.J_X05);
                    d.f(R.color.CAM_X0201);
                    fr4 d2 = fr4.d(this.o);
                    d2.n(R.string.J_X05);
                    d2.f(R.color.CAM_X0204);
                    ViewCommonUtil.setViewMargin(this.p, 0, pi.f(getContext(), R.dimen.M_H_X004), 0, pi.f(getContext(), R.dimen.M_H_X005));
                    this.p.setPadding(0, 0, 0, 0);
                    ViewCommonUtil.setViewMargin(this.o, 0, 0, 0, 0);
                }
                this.q.setVisibility(8);
                fr4 d3 = fr4.d(this.p);
                d3.n(R.string.J_X05);
                d3.f(R.color.CAM_X0201);
                fr4 d4 = fr4.d(this.o);
                d4.n(R.string.J_X05);
                d4.f(R.color.CAM_X0204);
                ViewCommonUtil.setViewMargin(this.p, 0, pi.f(getContext(), R.dimen.M_H_X004), 0, pi.f(getContext(), R.dimen.M_H_X005));
                this.p.setPadding(0, 0, 0, 0);
                ViewCommonUtil.setViewMargin(this.o, 0, 0, 0, 0);
            } else {
                if (this.y.get(2) != null && (textView = this.n) != null) {
                    textView.setVisibility(0);
                    this.n.setOnTouchListener(new et8(of5.E(this.y.get(2).content)));
                    this.n.setText(of5.E(this.y.get(2).content));
                }
                this.z = 3;
                this.q.setVisibility(0);
                ViewCommonUtil.setViewMargin(this.q, pi.f(getContext(), R.dimen.M_W_X005), pi.f(getContext(), R.dimen.M_H_X004), pi.f(getContext(), R.dimen.M_W_X005), 0);
                ViewCommonUtil.setViewMargin(this.p, 0, pi.f(getContext(), R.dimen.M_H_X004), 0, pi.f(getContext(), R.dimen.M_H_X005));
                ViewCommonUtil.setViewMargin(this.o, pi.f(getContext(), R.dimen.M_W_X005), pi.f(getContext(), R.dimen.M_H_X004), pi.f(getContext(), R.dimen.M_W_X005), pi.f(getContext(), R.dimen.M_H_X004));
                this.p.setPadding(0, 0, 0, 0);
                fr4 d5 = fr4.d(this.p);
                d5.n(R.string.J_X05);
                d5.f(R.color.CAM_X0204);
                fr4 d6 = fr4.d(this.o);
                d6.n(R.string.J_X05);
                d6.f(R.color.CAM_X0201);
                if (this.y.get(1) != null) {
                    this.q.setOnTouchListener(new et8(of5.E(this.y.get(1).content)));
                    this.q.setText(of5.E(this.y.get(1).content));
                    this.v.J(TbRichTextView.X(this.y.get(1).content, false));
                    this.q.setTag(R.id.obfuscated_res_0x7f090f20, Boolean.valueOf(this.y.get(1).is_floor.intValue() == 1));
                }
            }
            if (this.v.j().size() != 0 && this.y.get(0) != null) {
                this.v.I(TbRichTextView.X(this.y.get(0).content, false));
                this.A = this.v.f().toString();
            }
        }
        if (this.v.j().size() != 0) {
            this.o.setCardFrom(this.w);
            this.o.i(this.v.l(), this.A);
            this.o.setSubClickListener(this.B);
            this.r.setData(this.v.c(), (this.v.getType() == w97.x || this.v.getType() == w97.y) ? false : false);
        } else {
            this.o.i(null, "");
            this.r.setData("", (this.v.getType() == w97.x || this.v.getType() == w97.y) ? false : false);
        }
        if (this.v.D()) {
            this.s.setVisibility(0);
        } else {
            this.s.setVisibility(8);
        }
        s(h(), this.v);
        j(this.t, TbadkCoreApplication.getInst().getSkinType());
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.w = str;
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && this.n != null && u()) {
            if (z) {
                this.n.setMaxLines(5);
            } else {
                this.n.setMaxLines(2);
            }
        }
    }
}
