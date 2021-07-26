package d.a.q0.s0.c;

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
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.member.FrsMemberHeaderViewHolder;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.h3.w;
/* loaded from: classes8.dex */
public class g extends d.a.q0.u0.k<h, FrsMemberHeaderViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener A;
    public LikeModel x;
    public int y;
    public int z;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f62666e;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62666e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Object tag = view.getTag();
                if (tag instanceof Integer) {
                    d.a.d.k.e.n z = this.f62666e.z(((Integer) tag).intValue());
                    if (z instanceof h) {
                        h hVar = (h) z;
                        if (view.getId() == R.id.like_btn) {
                            if (ViewHelper.checkUpIsLogin(this.f62666e.o.getPageActivity())) {
                                if (!d.a.d.e.p.j.z()) {
                                    this.f62666e.o.showToast(R.string.neterror);
                                    return;
                                }
                                String b2 = hVar.b();
                                this.f62666e.x.L(hVar.c(), b2);
                            }
                        } else if (view.getId() == R.id.user_level_name) {
                            String b3 = hVar.b();
                            this.f62666e.o.sendMessage(new CustomMessage(2003006, new TbTitleActivityConfig(this.f62666e.f42341e, hVar.c(), b3)));
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends d.a.d.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f62667a;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62667a = gVar;
        }

        @Override // d.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!(obj instanceof w) || this.f62667a.x.getErrorCode() != 0) {
                    if (AntiHelper.m(this.f62667a.x.getErrorCode(), this.f62667a.x.getErrorString())) {
                        AntiHelper.u(this.f62667a.o.getPageActivity(), this.f62667a.x.getErrorString());
                        return;
                    } else {
                        this.f62667a.o.showToast(this.f62667a.x.getErrorString());
                        return;
                    }
                }
                w wVar = (w) obj;
                wVar.v(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.y = 0;
        this.z = 0;
        this.A = new a(this);
    }

    public final int[] C0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? i2 <= 3 ? new int[]{-8331843, -10499102} : i2 <= 9 ? new int[]{-10499102, -154262} : i2 <= 15 ? new int[]{-154262, -148180} : new int[]{-148180, -100818} : (int[]) invokeI.objValue;
    }

    public final void D0() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (tbPageContext = this.o) == null) {
            return;
        }
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.x = likeModel;
        likeModel.setLoadDataCallBack(new b(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: E0 */
    public FrsMemberHeaderViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            if (this.x == null) {
                D0();
            }
            return new FrsMemberHeaderViewHolder(LayoutInflater.from(this.f42341e).inflate(R.layout.forum_member_head_user_view, (ViewGroup) null), this.A);
        }
        return (FrsMemberHeaderViewHolder) invokeL.objValue;
    }

    public View F0(int i2, View view, ViewGroup viewGroup, h hVar, FrsMemberHeaderViewHolder frsMemberHeaderViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, hVar, frsMemberHeaderViewHolder})) == null) {
            super.X(i2, view, viewGroup, hVar, frsMemberHeaderViewHolder);
            if (hVar != null && hVar.d() != null) {
                int parseColor = Color.parseColor("#56cfa1");
                int color = SkinManager.getColor(R.color.CAM_X0109);
                w d2 = hVar.d();
                if (TbadkCoreApplication.isLogin()) {
                    if (d2.l() == 1) {
                        frsMemberHeaderViewHolder.f15287a.setVisibility(8);
                        frsMemberHeaderViewHolder.f15288b.setVisibility(0);
                        frsMemberHeaderViewHolder.f15288b.setText(R.string.mydegree);
                        SkinManager.setImageResource(frsMemberHeaderViewHolder.f15289c, BitmapHelper.getSmallGradeResourceIdNew(d2.k()));
                        if (StringUtils.isNull(d2.h())) {
                            frsMemberHeaderViewHolder.f15290d.setVisibility(8);
                        } else {
                            frsMemberHeaderViewHolder.f15290d.setText(d2.h());
                            frsMemberHeaderViewHolder.f15290d.setVisibility(0);
                        }
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        SpannableString spannableString = new SpannableString(d2.c() + "");
                        spannableString.setSpan(new ForegroundColorSpan(parseColor), 0, spannableString.length(), 17);
                        SpannableString spannableString2 = new SpannableString("/" + d2.i());
                        spannableString2.setSpan(new ForegroundColorSpan(color), 0, spannableString2.length(), 17);
                        spannableStringBuilder.append((CharSequence) spannableString);
                        spannableStringBuilder.append((CharSequence) spannableString2);
                        frsMemberHeaderViewHolder.f15293g.setText(spannableStringBuilder);
                        frsMemberHeaderViewHolder.f15293g.setVisibility(0);
                        frsMemberHeaderViewHolder.k.setVisibility(0);
                        frsMemberHeaderViewHolder.l.setVisibility(0);
                    } else {
                        frsMemberHeaderViewHolder.f15287a.setVisibility(0);
                        frsMemberHeaderViewHolder.f15288b.setVisibility(8);
                        frsMemberHeaderViewHolder.f15289c.setVisibility(8);
                        frsMemberHeaderViewHolder.f15290d.setVisibility(8);
                        frsMemberHeaderViewHolder.f15293g.setVisibility(8);
                        frsMemberHeaderViewHolder.k.setVisibility(8);
                        frsMemberHeaderViewHolder.l.setVisibility(8);
                    }
                } else {
                    frsMemberHeaderViewHolder.f15287a.setVisibility(8);
                    frsMemberHeaderViewHolder.f15288b.setVisibility(8);
                    frsMemberHeaderViewHolder.f15289c.setVisibility(8);
                    frsMemberHeaderViewHolder.f15290d.setVisibility(8);
                    frsMemberHeaderViewHolder.f15293g.setVisibility(8);
                    frsMemberHeaderViewHolder.k.setVisibility(8);
                    frsMemberHeaderViewHolder.l.setVisibility(8);
                }
                frsMemberHeaderViewHolder.f15287a.setTag(Integer.valueOf(i2));
                frsMemberHeaderViewHolder.f15290d.setTag(Integer.valueOf(i2));
                frsMemberHeaderViewHolder.f15290d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                SkinManager.setBackgroundColor(frsMemberHeaderViewHolder.f15294h, R.color.CAM_X0201);
                SkinManager.setBackgroundColor(frsMemberHeaderViewHolder.f15291e, R.color.CAM_X0204);
                SkinManager.setBackgroundColor(frsMemberHeaderViewHolder.f15295i, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(frsMemberHeaderViewHolder.f15287a, R.drawable.frs_btn_like);
                SkinManager.setViewTextColor(frsMemberHeaderViewHolder.f15287a, R.color.white_alpha100, 1);
                SkinManager.setViewTextColor(frsMemberHeaderViewHolder.f15288b, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(frsMemberHeaderViewHolder.f15290d, R.color.CAM_X0109, 1);
                SkinManager.setViewTextColor(frsMemberHeaderViewHolder.j, R.color.CAM_X0105, 1);
                SkinManager.setBackgroundResource(frsMemberHeaderViewHolder.k, R.drawable.forum_member_exp_progress);
                SkinManager.setBackgroundColor(frsMemberHeaderViewHolder.l, R.color.CAM_X0204);
                if (this.y != d2.k() || this.z != d2.c()) {
                    this.y = d2.k();
                    this.z = d2.c();
                    frsMemberHeaderViewHolder.k.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, C0(this.y)));
                    int c2 = d2.c();
                    this.z = c2;
                    if (c2 > d2.i()) {
                        this.z = d2.i();
                    }
                    float i3 = d2.i() != 0 ? this.z / d2.i() : 0.0f;
                    if (i3 > 0.999f) {
                        i3 = 1.0f;
                    }
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, i3, 1.0f, 1.0f);
                    scaleAnimation.setFillAfter(true);
                    scaleAnimation.setDuration(1000L);
                    d.a.q0.h3.a.b((TbPageContextSupport) this.o.getPageActivity(), frsMemberHeaderViewHolder.k, scaleAnimation, null);
                }
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // d.a.q0.u0.k, d.a.d.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        F0(i2, view, viewGroup, (h) obj, (FrsMemberHeaderViewHolder) viewHolder);
        return view;
    }
}
