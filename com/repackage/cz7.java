package com.repackage;

import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pbextra.adapter.PbInterviewLiveNormalItemViewHolder;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class cz7 extends lt7<PostData, PbInterviewLiveNormalItemViewHolder> implements View.OnClickListener, gs7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean A;
    public int o;
    public boolean p;
    public boolean q;
    public rq7 r;
    public boolean s;
    public View.OnClickListener t;
    public TbRichTextView.y u;
    public tr7 v;
    public View.OnLongClickListener w;
    public int x;
    public int y;
    public boolean z;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(cz7 cz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cz7(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((wx7) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        boolean z = false;
        this.o = 0;
        this.p = true;
        this.q = true;
        this.r = null;
        this.s = true;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.z = false;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 14 && i3 <= 16) {
            z = true;
        }
        this.A = z;
        a0(pbFragment);
    }

    @Override // com.repackage.lt7, com.repackage.an
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        f0(i, view2, viewGroup, (PostData) obj, (PbInterviewLiveNormalItemViewHolder) viewHolder);
        return view2;
    }

    @Override // com.repackage.lt7
    public void a0(wx7 wx7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wx7Var) == null) {
            super.a0(wx7Var);
            if (wx7Var != null) {
                this.x = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070201);
                this.y = pi.k(this.a) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070253);
            }
        }
    }

    public final void b0(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, pbInterviewLiveNormalItemViewHolder, postData) == null) {
            if (!TextUtils.isEmpty(postData.t()) && this.p) {
                pbInterviewLiveNormalItemViewHolder.b.setOnClickListener(this.t);
            } else {
                pbInterviewLiveNormalItemViewHolder.b.setOnClickListener(null);
            }
            pbInterviewLiveNormalItemViewHolder.b.setTextViewCheckSelection(false);
            pbInterviewLiveNormalItemViewHolder.b.setTextViewOnClickListener(new a(this));
        }
    }

    @Override // com.repackage.gs7
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.p = z;
        }
    }

    public final void c0(TbRichTextView tbRichTextView, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, tbRichTextView, i) == null) || tbRichTextView == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
        layoutParams.leftMargin = i;
        tbRichTextView.getLayoutStrategy().q(this.y - (i - this.x));
        tbRichTextView.setLayoutParams(layoutParams);
    }

    @Override // com.repackage.gs7
    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onLongClickListener) == null) {
            this.w = onLongClickListener;
        }
    }

    public final void d0(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder, PostData postData) {
        zp4 taskInfoData;
        String str;
        String str2;
        long j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, pbInterviewLiveNormalItemViewHolder, postData) == null) || pbInterviewLiveNormalItemViewHolder == null || postData == null) {
            return;
        }
        c0(pbInterviewLiveNormalItemViewHolder.b, (int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f070201));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbInterviewLiveNormalItemViewHolder.b.getLayoutParams();
        layoutParams.bottomMargin = 0;
        layoutParams.topMargin = 0;
        pbInterviewLiveNormalItemViewHolder.b.setLayoutParams(layoutParams);
        pbInterviewLiveNormalItemViewHolder.b.setPadding(0, 0, 0, 0);
        pbInterviewLiveNormalItemViewHolder.b.k0(null);
        postData.M0();
        if (postData.B() == 1) {
            pbInterviewLiveNormalItemViewHolder.d.setVisibility(0);
            if (postData.s() != null) {
                long userIdLong = postData.s().getUserIdLong();
                String userName = postData.s().getUserName();
                str2 = postData.s().getName_show();
                str = userName;
                j = userIdLong;
            } else {
                str = null;
                str2 = null;
                j = 0;
            }
            pbInterviewLiveNormalItemViewHolder.d.g(postData.I(), str, str2, j, ng.g(this.r.O().getId(), 0L), ng.g(postData.J(), 0L));
            pbInterviewLiveNormalItemViewHolder.d.i();
            if (this.s) {
                PraiseData praise = this.r.O().getPraise();
                if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                    pbInterviewLiveNormalItemViewHolder.e.setVisibility(0);
                    pbInterviewLiveNormalItemViewHolder.c.setVisibility(0);
                    pbInterviewLiveNormalItemViewHolder.f.setVisibility(0);
                    pbInterviewLiveNormalItemViewHolder.e.setIsFromPb(true);
                    pbInterviewLiveNormalItemViewHolder.e.setData(praise, this.r.O().getId(), praise.getPostId(), true);
                    pbInterviewLiveNormalItemViewHolder.e.i(this.l);
                } else {
                    pbInterviewLiveNormalItemViewHolder.e.setVisibility(8);
                    pbInterviewLiveNormalItemViewHolder.c.setVisibility(8);
                    pbInterviewLiveNormalItemViewHolder.f.setVisibility(8);
                }
            } else {
                pbInterviewLiveNormalItemViewHolder.e.setVisibility(8);
                pbInterviewLiveNormalItemViewHolder.c.setVisibility(8);
                pbInterviewLiveNormalItemViewHolder.f.setVisibility(8);
            }
            pbInterviewLiveNormalItemViewHolder.e.setVisibility(0);
            pbInterviewLiveNormalItemViewHolder.c.setVisibility(0);
            pbInterviewLiveNormalItemViewHolder.f.setVisibility(0);
            c0(pbInterviewLiveNormalItemViewHolder.b, (int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f070201));
        } else {
            pbInterviewLiveNormalItemViewHolder.d.setVisibility(8);
        }
        pbInterviewLiveNormalItemViewHolder.b.getLayoutStrategy().x(R.drawable.pic_video);
        pbInterviewLiveNormalItemViewHolder.b.setTextColor(SkinManager.getColor(R.color.common_color_10039));
        pbInterviewLiveNormalItemViewHolder.b.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        pbInterviewLiveNormalItemViewHolder.b.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        if (this.p) {
            pbInterviewLiveNormalItemViewHolder.b.getLayoutStrategy().g(R.drawable.obfuscated_res_0x7f081224);
        } else {
            pbInterviewLiveNormalItemViewHolder.b.getLayoutStrategy().g(R.drawable.icon_click);
        }
        pbInterviewLiveNormalItemViewHolder.b.setIsFromCDN(this.m);
        TbRichText Q = postData.Q();
        if (!this.z && this.A) {
            pbInterviewLiveNormalItemViewHolder.b.setText(Q, true);
        } else {
            pbInterviewLiveNormalItemViewHolder.b.setText(Q, false);
        }
        if (this.r.O().getTaskInfoData() != null) {
            pbInterviewLiveNormalItemViewHolder.a.J(this.r.O().getTaskInfoData().i(), this.m ? 17 : 18, false);
            int k = pi.k(this.a);
            float h = taskInfoData.h() / taskInfoData.j();
            int i = (int) (h > 1.0f ? k * 1.0f : h < 0.2f ? k * 0.2f : k * h);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbInterviewLiveNormalItemViewHolder.a.getLayoutParams();
            layoutParams2.height = i;
            layoutParams2.width = k;
            pbInterviewLiveNormalItemViewHolder.a.setLayoutParams(layoutParams2);
        } else {
            pbInterviewLiveNormalItemViewHolder.a.setVisibility(8);
        }
        b0(pbInterviewLiveNormalItemViewHolder, postData);
    }

    @Override // com.repackage.gs7
    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.t = onClickListener;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: e0 */
    public PbInterviewLiveNormalItemViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, viewGroup)) == null) ? new PbInterviewLiveNormalItemViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0668, viewGroup, false), this.q, this.p, this.o, false) : (PbInterviewLiveNormalItemViewHolder) invokeL.objValue;
    }

    @Override // com.repackage.gs7
    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.s = z;
        }
    }

    public View f0(int i, View view2, ViewGroup viewGroup, PostData postData, PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), view2, viewGroup, postData, pbInterviewLiveNormalItemViewHolder})) == null) {
            super.S(i, view2, viewGroup, postData, pbInterviewLiveNormalItemViewHolder);
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
            g0(pbInterviewLiveNormalItemViewHolder);
            d0(pbInterviewLiveNormalItemViewHolder, postData);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void g0(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, pbInterviewLiveNormalItemViewHolder) == null) {
            pbInterviewLiveNormalItemViewHolder.b.setOnLongClickListener(this.w);
            pbInterviewLiveNormalItemViewHolder.b.setOnTouchListener(this.v);
            pbInterviewLiveNormalItemViewHolder.b.setOnImageClickListener(this.u);
            wx7 wx7Var = this.i;
            if (wx7Var == null || wx7Var.N() == null) {
                return;
            }
            pbInterviewLiveNormalItemViewHolder.b.setOnEmotionClickListener(this.i.N().d.e);
        }
    }

    @Override // com.repackage.gs7
    public void l(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onClickListener) == null) {
        }
    }

    @Override // com.repackage.gs7
    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.o = i;
        }
    }

    @Override // com.repackage.gs7
    public void o(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, yVar) == null) {
            this.u = yVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, view2) == null) {
        }
    }

    @Override // com.repackage.gs7
    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
        }
    }

    @Override // com.repackage.gs7
    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
        }
    }

    @Override // com.repackage.gs7
    public void s(rq7 rq7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, rq7Var) == null) {
            this.r = rq7Var;
        }
    }
}
