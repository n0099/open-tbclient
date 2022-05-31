package com.repackage;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.imageManager.TbFaceManager;
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
/* loaded from: classes6.dex */
public class o87 extends nv5<l87> {
    public static /* synthetic */ Interceptable $ic;
    public static qc5<String> B;
    public transient /* synthetic */ FieldHolder $fh;
    public OriginalThreadCardView.b A;
    public HeadImageView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public View m;
    public TextView n;
    public TextView o;
    public View p;
    public TextView q;
    public OriginalThreadCardView r;
    public MessageCardBottomView s;
    public View t;
    public TbPageContext u;
    public int v;
    public l87 w;
    public String x;
    public int y;
    public int z;

    /* loaded from: classes6.dex */
    public class a implements OriginalThreadCardView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o87 a;

        public a(o87 o87Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o87Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o87Var;
        }

        @Override // com.baidu.tieba.card.OriginalThreadCardView.b
        public void a(OriginalThreadInfo originalThreadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, originalThreadInfo) == null) {
                if (this.a.w != null && this.a.w.z() != null) {
                    StatisticItem param = new StatisticItem(this.a.w.z()).param("obj_locate", 2);
                    if (this.a.w.getType() != l87.B && this.a.w.getType() != l87.x) {
                        param.param("obj_type", 2);
                    } else {
                        param.param("obj_type", 1);
                    }
                    TiebaStatic.log(param);
                }
                if (this.a.e() != null) {
                    nw5<l87> e = this.a.e();
                    o87 o87Var = this.a;
                    e.a(o87Var.r, o87Var.w);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755485757, "Lcom/repackage/o87;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755485757, "Lcom/repackage/o87;");
                return;
            }
        }
        B = new qc5<>();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o87(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
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
        this.v = 3;
        this.A = new a(this);
        this.u = tbPageContext;
        this.y = li.f(tbPageContext.getContext(), R.dimen.tbds42);
        this.z = li.f(this.u.getContext(), R.dimen.tbds48);
        v();
    }

    @Override // com.repackage.nv5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01a5 : invokeV.intValue;
    }

    @Override // com.repackage.nv5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) || this.v == i) {
            return;
        }
        this.v = i;
        k().setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
        SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0109);
        SkinManager.setBackgroundResource(this.k, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
        SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
        SkinManager.setBackgroundColor(this.m, R.color.CAM_X0110);
        SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0105);
        SkinManager.setBackgroundColor(this.p, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0107);
        OriginalThreadCardView originalThreadCardView = this.r;
        if (originalThreadCardView != null) {
            originalThreadCardView.r();
        }
        MessageCardBottomView messageCardBottomView = this.s;
        if (messageCardBottomView != null) {
            messageCardBottomView.b();
        }
        SkinManager.setBackgroundResource(this.t, R.drawable.icon_news_red_dot);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            if (this.w == null && this.u == null) {
                return;
            }
            if (view2 == this.i || view2 == this.j) {
                if (this.w.y() == null) {
                    return;
                }
                String userId = this.w.y().getUserId();
                String userName = this.w.y().getUserName();
                if (userId != null && userId.length() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.u.getContext(), userId, userName)));
                }
            }
            if (e() != null) {
                e().a(view2, this.w);
            }
        }
    }

    public final CharSequence t(TextView textView, SpannableString spannableString) {
        InterceptResult invokeLL;
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, textView, spannableString)) == null) {
            if (textView == null || spannableString == null || (tbPageContext = this.u) == null) {
                return null;
            }
            return TextUtils.ellipsize(spannableString, textView.getPaint(), ((li.k(tbPageContext.getPageActivity()) - (this.u.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070201) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
        }
        return (CharSequence) invokeLL.objValue;
    }

    public final void u(@NonNull View view2, @NonNull l87 l87Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view2, l87Var) == null) {
            if (StringHelper.equals(B.a(), l87Var.r())) {
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0313);
            } else {
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0205);
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            View k = k();
            this.i = (HeadImageView) k.findViewById(R.id.obfuscated_res_0x7f09182f);
            this.j = (TextView) k.findViewById(R.id.obfuscated_res_0x7f092298);
            this.k = (TextView) k.findViewById(R.id.obfuscated_res_0x7f09095f);
            this.l = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0918b1);
            this.m = k.findViewById(R.id.obfuscated_res_0x7f0907cd);
            this.n = (TextView) k.findViewById(R.id.obfuscated_res_0x7f091feb);
            this.o = (TextView) k.findViewById(R.id.obfuscated_res_0x7f090557);
            this.p = k.findViewById(R.id.obfuscated_res_0x7f090554);
            this.q = (TextView) k.findViewById(R.id.obfuscated_res_0x7f090556);
            this.r = (OriginalThreadCardView) k.findViewById(R.id.obfuscated_res_0x7f0915f2);
            this.s = (MessageCardBottomView) k.findViewById(R.id.obfuscated_res_0x7f090553);
            this.t = k.findViewById(R.id.obfuscated_res_0x7f091523);
            this.r.setUsePlaceHolder(false);
            this.i.setOnClickListener(this);
            this.j.setOnClickListener(this);
            this.s.getReplyContainer().setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.nv5
    /* renamed from: w */
    public void l(l87 l87Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, l87Var) == null) || l87Var == null || l87Var.y() == null) {
            return;
        }
        this.w = l87Var;
        MetaData y = l87Var.y();
        this.i.setVisibility(0);
        boolean z = true;
        this.i.setPlaceHolder(1);
        this.i.setIsRound(true);
        UtilHelper.showHeadImageViewBigV(this.i, y, 0);
        this.i.setTag(null);
        this.i.setPageId(this.u.getUniqueId());
        this.i.K(l87Var.y().getAvater(), 12, false);
        this.j.setText(StringHelper.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(y), 14, StringHelper.STRING_MORE));
        if (l87Var.y().getIsMyFans() == 1) {
            this.k.setVisibility(0);
        } else {
            this.k.setVisibility(8);
        }
        if (!ki.isEmpty(l87Var.q())) {
            this.m.setVisibility(0);
            this.l.setVisibility(0);
            this.l.setText(l87Var.q());
        } else {
            this.m.setVisibility(8);
            this.l.setVisibility(8);
        }
        this.n.setText(StringHelper.getFormatTime(l87Var.getTime()));
        TextView textView = this.o;
        TbFaceManager i = TbFaceManager.i();
        Context applicationContext = this.u.getPageActivity().getApplicationContext();
        String title = l87Var.getTitle();
        int i2 = this.z;
        textView.setText(t(textView, i.s(applicationContext, title, i2, i2)));
        if (ki.isEmpty(l87Var.A())) {
            this.p.setVisibility(8);
            this.q.setVisibility(8);
        } else {
            TextView textView2 = this.q;
            TbFaceManager i3 = TbFaceManager.i();
            Context applicationContext2 = this.u.getPageActivity().getApplicationContext();
            String A = l87Var.A();
            int i4 = this.y;
            textView2.setText(t(textView2, i3.s(applicationContext2, A, i4, i4)));
            this.q.setVisibility(0);
            this.p.setVisibility(0);
        }
        this.r.setCardFrom(this.x);
        this.r.h(l87Var.m());
        this.r.setSubClickListener(this.A);
        this.s.setData(l87Var.e(), (l87Var.getType() == l87.x || l87Var.getType() == l87.y) ? false : false);
        if (l87Var.D()) {
            this.t.setVisibility(0);
        } else {
            this.t.setVisibility(8);
        }
        u(k(), l87Var);
        m(this.u, TbadkCoreApplication.getInst().getSkinType());
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.x = str;
        }
    }
}
