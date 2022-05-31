package com.repackage;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbTitleActivityConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.member.FrsMemberHeaderViewHolder;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class h96 extends fb6<i96, FrsMemberHeaderViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LikeModel t;
    public int u;
    public int v;
    public View.OnClickListener w;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h96 a;

        public a(h96 h96Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h96Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h96Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Object tag = view2.getTag();
                if (tag instanceof Integer) {
                    jn z = this.a.z(((Integer) tag).intValue());
                    if (z instanceof i96) {
                        i96 i96Var = (i96) z;
                        if (view2.getId() == R.id.obfuscated_res_0x7f091212) {
                            if (ViewHelper.checkUpIsLogin(this.a.k.getPageActivity())) {
                                if (!ji.z()) {
                                    this.a.k.showToast(R.string.obfuscated_res_0x7f0f0c33);
                                    return;
                                }
                                String a = i96Var.a();
                                this.a.t.P(i96Var.b(), a);
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f092295) {
                            String a2 = i96Var.a();
                            this.a.k.sendMessage(new CustomMessage(2003006, new TbTitleActivityConfig(this.a.a, i96Var.b(), a2)));
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends a9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h96 a;

        public b(h96 h96Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h96Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h96Var;
        }

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!(obj instanceof ag8) || this.a.t.getErrorCode() != 0) {
                    if (AntiHelper.m(this.a.t.getErrorCode(), this.a.t.getErrorString())) {
                        AntiHelper.u(this.a.k.getPageActivity(), this.a.t.getErrorString());
                        return;
                    } else {
                        this.a.k.showToast(this.a.t.getErrorString());
                        return;
                    }
                }
                ag8 ag8Var = (ag8) obj;
                ag8Var.y(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, ag8Var));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h96(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = 0;
        this.v = 0;
        this.w = new a(this);
    }

    @Override // com.repackage.fb6, com.repackage.wm
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        v0(i, view2, viewGroup, (i96) obj, (FrsMemberHeaderViewHolder) viewHolder);
        return view2;
    }

    public final int[] s0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? i <= 3 ? new int[]{-8331843, -10499102} : i <= 9 ? new int[]{-10499102, -154262} : i <= 15 ? new int[]{-154262, -148180} : new int[]{-148180, -100818} : (int[]) invokeI.objValue;
    }

    public final void t0() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (tbPageContext = this.k) == null) {
            return;
        }
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.t = likeModel;
        likeModel.setLoadDataCallBack(new b(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: u0 */
    public FrsMemberHeaderViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            if (this.t == null) {
                t0();
            }
            return new FrsMemberHeaderViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d02b5, (ViewGroup) null), this.w);
        }
        return (FrsMemberHeaderViewHolder) invokeL.objValue;
    }

    public View v0(int i, View view2, ViewGroup viewGroup, i96 i96Var, FrsMemberHeaderViewHolder frsMemberHeaderViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, i96Var, frsMemberHeaderViewHolder})) == null) {
            super.S(i, view2, viewGroup, i96Var, frsMemberHeaderViewHolder);
            if (i96Var != null && i96Var.e() != null) {
                int parseColor = Color.parseColor("#56cfa1");
                int color = SkinManager.getColor(R.color.CAM_X0109);
                ag8 e = i96Var.e();
                if (TbadkCoreApplication.isLogin()) {
                    if (e.n() == 1) {
                        frsMemberHeaderViewHolder.a.setVisibility(8);
                        frsMemberHeaderViewHolder.b.setVisibility(0);
                        frsMemberHeaderViewHolder.b.setText(R.string.obfuscated_res_0x7f0f0b55);
                        SkinManager.setImageResource(frsMemberHeaderViewHolder.c, BitmapHelper.getSmallGradeResourceIdNew(e.m()));
                        if (StringUtils.isNull(e.h())) {
                            frsMemberHeaderViewHolder.d.setVisibility(8);
                        } else {
                            frsMemberHeaderViewHolder.d.setText(e.h());
                            frsMemberHeaderViewHolder.d.setVisibility(0);
                        }
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        SpannableString spannableString = new SpannableString(e.c() + "");
                        spannableString.setSpan(new ForegroundColorSpan(parseColor), 0, spannableString.length(), 17);
                        SpannableString spannableString2 = new SpannableString("/" + e.i());
                        spannableString2.setSpan(new ForegroundColorSpan(color), 0, spannableString2.length(), 17);
                        spannableStringBuilder.append((CharSequence) spannableString);
                        spannableStringBuilder.append((CharSequence) spannableString2);
                        frsMemberHeaderViewHolder.g.setText(spannableStringBuilder);
                        frsMemberHeaderViewHolder.g.setVisibility(0);
                        frsMemberHeaderViewHolder.k.setVisibility(0);
                        frsMemberHeaderViewHolder.l.setVisibility(0);
                    } else {
                        frsMemberHeaderViewHolder.a.setVisibility(0);
                        frsMemberHeaderViewHolder.b.setVisibility(8);
                        frsMemberHeaderViewHolder.c.setVisibility(8);
                        frsMemberHeaderViewHolder.d.setVisibility(8);
                        frsMemberHeaderViewHolder.g.setVisibility(8);
                        frsMemberHeaderViewHolder.k.setVisibility(8);
                        frsMemberHeaderViewHolder.l.setVisibility(8);
                    }
                } else {
                    frsMemberHeaderViewHolder.a.setVisibility(8);
                    frsMemberHeaderViewHolder.b.setVisibility(8);
                    frsMemberHeaderViewHolder.c.setVisibility(8);
                    frsMemberHeaderViewHolder.d.setVisibility(8);
                    frsMemberHeaderViewHolder.g.setVisibility(8);
                    frsMemberHeaderViewHolder.k.setVisibility(8);
                    frsMemberHeaderViewHolder.l.setVisibility(8);
                }
                frsMemberHeaderViewHolder.a.setTag(Integer.valueOf(i));
                frsMemberHeaderViewHolder.d.setTag(Integer.valueOf(i));
                frsMemberHeaderViewHolder.d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                SkinManager.setBackgroundColor(frsMemberHeaderViewHolder.h, R.color.CAM_X0201);
                SkinManager.setBackgroundColor(frsMemberHeaderViewHolder.e, R.color.CAM_X0204);
                SkinManager.setBackgroundColor(frsMemberHeaderViewHolder.i, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(frsMemberHeaderViewHolder.a, R.drawable.frs_btn_like);
                SkinManager.setViewTextColor(frsMemberHeaderViewHolder.a, R.color.white_alpha100, 1);
                SkinManager.setViewTextColor(frsMemberHeaderViewHolder.b, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(frsMemberHeaderViewHolder.d, R.color.CAM_X0109, 1);
                SkinManager.setViewTextColor(frsMemberHeaderViewHolder.j, R.color.CAM_X0105, 1);
                SkinManager.setBackgroundResource(frsMemberHeaderViewHolder.k, R.drawable.obfuscated_res_0x7f080572);
                SkinManager.setBackgroundColor(frsMemberHeaderViewHolder.l, R.color.CAM_X0204);
                if (this.u != e.m() || this.v != e.c()) {
                    this.u = e.m();
                    this.v = e.c();
                    frsMemberHeaderViewHolder.k.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, s0(this.u)));
                    int c = e.c();
                    this.v = c;
                    if (c > e.i()) {
                        this.v = e.i();
                    }
                    float i2 = e.i() != 0 ? this.v / e.i() : 0.0f;
                    if (i2 > 0.999f) {
                        i2 = 1.0f;
                    }
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, i2, 1.0f, 1.0f);
                    scaleAnimation.setFillAfter(true);
                    scaleAnimation.setDuration(1000L);
                    cf8.c((TbPageContextSupport) this.k.getPageActivity(), frsMemberHeaderViewHolder.k, scaleAnimation, null);
                }
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
