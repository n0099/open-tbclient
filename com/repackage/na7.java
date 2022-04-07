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
public class na7 extends rw5<la7> {
    public static /* synthetic */ Interceptable $ic;
    public static ed5<String> B;
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
    public la7 w;
    public String x;
    public int y;
    public int z;

    /* loaded from: classes6.dex */
    public class a implements OriginalThreadCardView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ na7 a;

        public a(na7 na7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {na7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = na7Var;
        }

        @Override // com.baidu.tieba.card.OriginalThreadCardView.b
        public void a(OriginalThreadInfo originalThreadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, originalThreadInfo) == null) {
                if (this.a.w != null && this.a.w.z() != null) {
                    StatisticItem param = new StatisticItem(this.a.w.z()).param("obj_locate", 2);
                    if (this.a.w.getType() != la7.B && this.a.w.getType() != la7.x) {
                        param.param("obj_type", 2);
                    } else {
                        param.param("obj_type", 1);
                    }
                    TiebaStatic.log(param);
                }
                if (this.a.e() != null) {
                    rx5<la7> e = this.a.e();
                    na7 na7Var = this.a;
                    e.a(na7Var.r, na7Var.w);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755476147, "Lcom/repackage/na7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755476147, "Lcom/repackage/na7;");
                return;
            }
        }
        B = new ed5<>();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public na7(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
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
        this.y = oi.f(tbPageContext.getContext(), R.dimen.tbds42);
        this.z = oi.f(this.u.getContext(), R.dimen.tbds48);
        v();
    }

    @Override // com.repackage.rw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01ad : invokeV.intValue;
    }

    @Override // com.repackage.rw5
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
            originalThreadCardView.q();
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
            return TextUtils.ellipsize(spannableString, textView.getPaint(), ((oi.k(tbPageContext.getPageActivity()) - (this.u.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070201) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
        }
        return (CharSequence) invokeLL.objValue;
    }

    public final void u(@NonNull View view2, @NonNull la7 la7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view2, la7Var) == null) {
            if (StringHelper.equals(B.a(), la7Var.r())) {
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
            this.i = (HeadImageView) k.findViewById(R.id.obfuscated_res_0x7f091823);
            this.j = (TextView) k.findViewById(R.id.obfuscated_res_0x7f09229c);
            this.k = (TextView) k.findViewById(R.id.obfuscated_res_0x7f09097b);
            this.l = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0918a3);
            this.m = k.findViewById(R.id.obfuscated_res_0x7f0907f2);
            this.n = (TextView) k.findViewById(R.id.obfuscated_res_0x7f091fe6);
            this.o = (TextView) k.findViewById(R.id.obfuscated_res_0x7f090560);
            this.p = k.findViewById(R.id.obfuscated_res_0x7f09055d);
            this.q = (TextView) k.findViewById(R.id.obfuscated_res_0x7f09055f);
            this.r = (OriginalThreadCardView) k.findViewById(R.id.obfuscated_res_0x7f09161c);
            this.s = (MessageCardBottomView) k.findViewById(R.id.obfuscated_res_0x7f09055c);
            this.t = k.findViewById(R.id.obfuscated_res_0x7f091547);
            this.r.setUsePlaceHolder(false);
            this.i.setOnClickListener(this);
            this.j.setOnClickListener(this);
            this.s.getReplyContainer().setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.rw5
    /* renamed from: w */
    public void l(la7 la7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, la7Var) == null) || la7Var == null || la7Var.y() == null) {
            return;
        }
        this.w = la7Var;
        MetaData y = la7Var.y();
        this.i.setVisibility(0);
        boolean z = true;
        this.i.setPlaceHolder(1);
        this.i.setIsRound(true);
        UtilHelper.showHeadImageViewBigV(this.i, y, 0);
        this.i.setTag(null);
        this.i.setPageId(this.u.getUniqueId());
        this.i.K(la7Var.y().getAvater(), 12, false);
        this.j.setText(StringHelper.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(y), 14, StringHelper.STRING_MORE));
        if (la7Var.y().getIsMyFans() == 1) {
            this.k.setVisibility(0);
        } else {
            this.k.setVisibility(8);
        }
        if (!ni.isEmpty(la7Var.q())) {
            this.m.setVisibility(0);
            this.l.setVisibility(0);
            this.l.setText(la7Var.q());
        } else {
            this.m.setVisibility(8);
            this.l.setVisibility(8);
        }
        this.n.setText(StringHelper.getFormatTime(la7Var.getTime()));
        TextView textView = this.o;
        TbFaceManager e = TbFaceManager.e();
        Context applicationContext = this.u.getPageActivity().getApplicationContext();
        String title = la7Var.getTitle();
        int i = this.z;
        textView.setText(t(textView, e.k(applicationContext, title, i, i)));
        if (ni.isEmpty(la7Var.A())) {
            this.p.setVisibility(8);
            this.q.setVisibility(8);
        } else {
            TextView textView2 = this.q;
            TbFaceManager e2 = TbFaceManager.e();
            Context applicationContext2 = this.u.getPageActivity().getApplicationContext();
            String A = la7Var.A();
            int i2 = this.y;
            textView2.setText(t(textView2, e2.k(applicationContext2, A, i2, i2)));
            this.q.setVisibility(0);
            this.p.setVisibility(0);
        }
        this.r.setCardFrom(this.x);
        this.r.g(la7Var.m());
        this.r.setSubClickListener(this.A);
        this.s.setData(la7Var.e(), (la7Var.getType() == la7.x || la7Var.getType() == la7.y) ? false : false);
        if (la7Var.D()) {
            this.t.setVisibility(0);
        } else {
            this.t.setVisibility(8);
        }
        u(k(), la7Var);
        m(this.u, TbadkCoreApplication.getInst().getSkinType());
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.x = str;
        }
    }
}
