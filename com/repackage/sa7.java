package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
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
/* loaded from: classes7.dex */
public class sa7 extends tw5<oa7> {
    public static /* synthetic */ Interceptable $ic;
    public static ed5<String> C;
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
    public oa7 v;
    public String w;
    public View x;
    public List<NewFloorInfo> y;
    public int z;

    /* loaded from: classes7.dex */
    public class a implements OriginalThreadCardView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sa7 a;

        public a(sa7 sa7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sa7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sa7Var;
        }

        @Override // com.baidu.tieba.card.OriginalThreadCardView.b
        public void a(OriginalThreadInfo originalThreadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, originalThreadInfo) == null) {
                xa7.a(this.a.v, 13);
                if (this.a.e() != null) {
                    tx5<oa7> e = this.a.e();
                    sa7 sa7Var = this.a;
                    e.a(sa7Var.o, sa7Var.v);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755327192, "Lcom/repackage/sa7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755327192, "Lcom/repackage/sa7;");
                return;
            }
        }
        C = new ed5<>();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sa7(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
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

    @Override // com.repackage.tw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01be : invokeV.intValue;
    }

    @Override // com.repackage.tw5
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
                originalThreadCardView.r(R.color.CAM_X0201, R.color.CAM_X0107, R.color.CAM_X0107);
            } else {
                originalThreadCardView.r(R.color.CAM_X0204, R.color.CAM_X0107, R.color.CAM_X0107);
            }
        }
        MessageCardBottomView messageCardBottomView = this.r;
        if (messageCardBottomView != null) {
            messageCardBottomView.b();
        }
        SkinManager.setBackgroundResource(this.s, R.drawable.icon_news_red_dot);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        oa7 oa7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view2) == null) || (oa7Var = this.v) == null || this.t == null) {
            return;
        }
        this.y = oa7Var.k();
        if (view2 != this.i && view2 != this.j) {
            if (view2 == this.q) {
                xa7.a(this.v, 12);
            } else if (view2 == this.r.getReplyContainer()) {
                xa7.a(this.v, 15);
            }
        } else if (this.v.y() == null) {
            return;
        } else {
            xa7.a(this.v, 14);
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

    public final void t(@NonNull View view2, @NonNull oa7 oa7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, view2, oa7Var) == null) {
            if (StringHelper.equals(C.a(), oa7Var.r())) {
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
            this.i = (HeadImageView) k.findViewById(R.id.obfuscated_res_0x7f091824);
            this.j = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f09229d);
            this.k = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f09097c);
            this.l = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f0918a4);
            this.m = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f091fe7);
            this.n = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f090560);
            this.o = (OriginalThreadCardView) this.x.findViewById(R.id.obfuscated_res_0x7f09161d);
            this.r = (MessageCardBottomView) this.x.findViewById(R.id.obfuscated_res_0x7f09055c);
            this.s = this.x.findViewById(R.id.obfuscated_res_0x7f091548);
            this.p = (LinearLayout) this.x.findViewById(R.id.obfuscated_res_0x7f091549);
            this.q = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f090561);
            vr4 d = vr4.d(this.k);
            d.n(R.string.J_X04);
            d.f(R.color.CAM_X0204);
            ViewCommonUtil.setViewPadding(this.o, oi.f(getContext(), R.dimen.M_W_X004), oi.f(getContext(), R.dimen.M_H_X003), oi.f(getContext(), R.dimen.M_W_X004), oi.f(getContext(), R.dimen.M_H_X003));
            this.o.setUsePlaceHolder(false);
            this.i.setOnClickListener(this);
            this.j.setOnClickListener(this);
            this.r.getReplyContainer().setOnClickListener(this);
            this.q.setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.tw5
    /* renamed from: v */
    public void l(oa7 oa7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, oa7Var) == null) || oa7Var == null || oa7Var.y() == null) {
            return;
        }
        this.v = oa7Var;
        MetaData y = oa7Var.y();
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
        if (this.v.getCardType() == 2) {
            this.l.setVisibility(0);
            this.l.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0f8b));
        } else if (this.v.getCardType() == 1) {
            this.l.setVisibility(0);
            this.l.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0f8a));
        } else {
            this.l.setVisibility(8);
        }
        this.m.setText(StringHelper.getFormatTime(this.v.getTime()));
        if (this.v.k() != null && this.v.k().size() > 1) {
            List<NewFloorInfo> k = this.v.k();
            this.y = k;
            if (k.size() <= 2) {
                if (this.y.get(1) != null) {
                    this.n.setOnTouchListener(new xw8(ef5.E(this.y.get(1).content)));
                    this.n.setText(ef5.E(this.y.get(1).content));
                }
                this.z = 2;
                this.q.setVisibility(8);
                vr4 d = vr4.d(this.p);
                d.n(R.string.J_X05);
                d.f(R.color.CAM_X0201);
                vr4 d2 = vr4.d(this.o);
                d2.n(R.string.J_X05);
                d2.f(R.color.CAM_X0204);
                ViewCommonUtil.setViewMargin(this.p, 0, oi.f(getContext(), R.dimen.M_H_X004), 0, oi.f(getContext(), R.dimen.M_H_X005));
                this.p.setPadding(0, 0, 0, 0);
                ViewCommonUtil.setViewMargin(this.o, 0, 0, 0, 0);
            } else {
                if (this.y.get(2) != null) {
                    this.n.setOnTouchListener(new xw8(ef5.E(this.y.get(2).content)));
                    this.n.setText(ef5.E(this.y.get(2).content));
                }
                this.z = 3;
                this.q.setVisibility(0);
                ViewCommonUtil.setViewMargin(this.q, oi.f(getContext(), R.dimen.M_W_X005), oi.f(getContext(), R.dimen.M_H_X004), oi.f(getContext(), R.dimen.M_W_X005), 0);
                ViewCommonUtil.setViewMargin(this.p, 0, oi.f(getContext(), R.dimen.M_H_X004), 0, oi.f(getContext(), R.dimen.M_H_X005));
                ViewCommonUtil.setViewMargin(this.o, oi.f(getContext(), R.dimen.M_W_X005), oi.f(getContext(), R.dimen.M_H_X004), oi.f(getContext(), R.dimen.M_W_X005), oi.f(getContext(), R.dimen.M_H_X004));
                this.p.setPadding(0, 0, 0, 0);
                vr4 d3 = vr4.d(this.p);
                d3.n(R.string.J_X05);
                d3.f(R.color.CAM_X0204);
                vr4 d4 = vr4.d(this.o);
                d4.n(R.string.J_X05);
                d4.f(R.color.CAM_X0201);
                if (this.y.get(1) != null) {
                    this.q.setOnTouchListener(new xw8(ef5.E(this.y.get(1).content)));
                    this.q.setText(ef5.E(this.y.get(1).content));
                    this.v.J(TbRichTextView.X(this.y.get(1).content, false));
                    this.q.setTag(R.id.obfuscated_res_0x7f090f60, Boolean.valueOf(this.y.get(1).is_floor.intValue() == 1));
                }
            }
            if (this.y.get(0) != null) {
                this.v.I(TbRichTextView.X(this.y.get(0).content, false));
                this.A = this.v.g().toString();
            }
        }
        this.o.setCardFrom(this.w);
        this.o.h(this.v.m(), this.A);
        this.o.setSubClickListener(this.B);
        this.r.setData(this.v.e(), (this.v.getType() == oa7.x || this.v.getType() == oa7.y) ? false : false);
        if (this.v.D()) {
            this.s.setVisibility(0);
        } else {
            this.s.setVisibility(8);
        }
        t(k(), this.v);
        m(this.t, TbadkCoreApplication.getInst().getSkinType());
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.w = str;
        }
    }
}
