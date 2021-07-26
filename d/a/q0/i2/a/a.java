package d.a.q0.i2.a;

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
import d.a.d.e.p.l;
import d.a.p0.s.q.z1;
import d.a.q0.h2.h.e;
import d.a.q0.h2.i.c;
import d.a.q0.h2.k.e.o;
import d.a.q0.h2.o.b;
/* loaded from: classes8.dex */
public class a extends o<PostData, PbInterviewLiveNormalItemViewHolder> implements View.OnClickListener, d.a.q0.h2.k.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnLongClickListener A;
    public int B;
    public int C;
    public boolean D;
    public final boolean E;
    public int s;
    public boolean t;
    public boolean u;
    public e v;
    public boolean w;
    public View.OnClickListener x;
    public TbRichTextView.z y;
    public c z;

    /* renamed from: d.a.q0.i2.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1488a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public View$OnClickListenerC1488a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((b) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        boolean z = false;
        this.s = 0;
        this.t = true;
        this.u = true;
        this.v = null;
        this.w = true;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.D = false;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 14 && i4 <= 16) {
            z = true;
        }
        this.E = z;
        f0(pbFragment);
    }

    @Override // d.a.q0.h2.k.e.o, d.a.d.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        l0(i2, view, viewGroup, (PostData) obj, (PbInterviewLiveNormalItemViewHolder) viewHolder);
        return view;
    }

    @Override // d.a.q0.h2.k.c.a
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.t = z;
        }
    }

    @Override // d.a.q0.h2.k.c.a
    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onLongClickListener) == null) {
            this.A = onLongClickListener;
        }
    }

    @Override // d.a.q0.h2.k.c.a
    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.x = onClickListener;
        }
    }

    @Override // d.a.q0.h2.k.c.a
    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.w = z;
        }
    }

    @Override // d.a.q0.h2.k.e.o
    public void f0(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            super.f0(bVar);
            if (bVar != null) {
                this.B = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
                this.C = l.k(this.f42341e) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
            }
        }
    }

    public final void g0(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, pbInterviewLiveNormalItemViewHolder, postData) == null) {
            if (!TextUtils.isEmpty(postData.u()) && this.t) {
                pbInterviewLiveNormalItemViewHolder.f20046f.setOnClickListener(this.x);
            } else {
                pbInterviewLiveNormalItemViewHolder.f20046f.setOnClickListener(null);
            }
            pbInterviewLiveNormalItemViewHolder.f20046f.setTextViewCheckSelection(false);
            pbInterviewLiveNormalItemViewHolder.f20046f.setTextViewOnClickListener(new View$OnClickListenerC1488a(this));
        }
    }

    public final void i0(TbRichTextView tbRichTextView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbRichTextView, i2) == null) || tbRichTextView == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
        layoutParams.leftMargin = i2;
        tbRichTextView.getLayoutStrategy().q(this.C - (i2 - this.B));
        tbRichTextView.setLayoutParams(layoutParams);
    }

    public final void j0(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder, PostData postData) {
        z1 f1;
        String str;
        String str2;
        long j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, pbInterviewLiveNormalItemViewHolder, postData) == null) || pbInterviewLiveNormalItemViewHolder == null || postData == null) {
            return;
        }
        i0(pbInterviewLiveNormalItemViewHolder.f20046f, (int) this.f42341e.getResources().getDimension(R.dimen.ds30));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbInterviewLiveNormalItemViewHolder.f20046f.getLayoutParams();
        layoutParams.bottomMargin = 0;
        layoutParams.topMargin = 0;
        pbInterviewLiveNormalItemViewHolder.f20046f.setLayoutParams(layoutParams);
        pbInterviewLiveNormalItemViewHolder.f20046f.setPadding(0, 0, 0, 0);
        pbInterviewLiveNormalItemViewHolder.f20046f.h0(null);
        postData.B0();
        if (postData.A() == 1) {
            pbInterviewLiveNormalItemViewHolder.f20048h.setVisibility(0);
            if (postData.t() != null) {
                long userIdLong = postData.t().getUserIdLong();
                String userName = postData.t().getUserName();
                str2 = postData.t().getName_show();
                str = userName;
                j = userIdLong;
            } else {
                str = null;
                str2 = null;
                j = 0;
            }
            pbInterviewLiveNormalItemViewHolder.f20048h.g(postData.D(), str, str2, j, d.a.d.e.m.b.f(this.v.N().d0(), 0L), d.a.d.e.m.b.f(postData.E(), 0L));
            pbInterviewLiveNormalItemViewHolder.f20048h.i();
            if (this.w) {
                PraiseData H0 = this.v.N().H0();
                if (H0 != null && H0.getUser() != null && H0.getUser().size() > 0) {
                    pbInterviewLiveNormalItemViewHolder.f20049i.setVisibility(0);
                    pbInterviewLiveNormalItemViewHolder.f20047g.setVisibility(0);
                    pbInterviewLiveNormalItemViewHolder.j.setVisibility(0);
                    pbInterviewLiveNormalItemViewHolder.f20049i.setIsFromPb(true);
                    pbInterviewLiveNormalItemViewHolder.f20049i.setData(H0, this.v.N().d0(), H0.getPostId(), true);
                    pbInterviewLiveNormalItemViewHolder.f20049i.i(this.p);
                } else {
                    pbInterviewLiveNormalItemViewHolder.f20049i.setVisibility(8);
                    pbInterviewLiveNormalItemViewHolder.f20047g.setVisibility(8);
                    pbInterviewLiveNormalItemViewHolder.j.setVisibility(8);
                }
            } else {
                pbInterviewLiveNormalItemViewHolder.f20049i.setVisibility(8);
                pbInterviewLiveNormalItemViewHolder.f20047g.setVisibility(8);
                pbInterviewLiveNormalItemViewHolder.j.setVisibility(8);
            }
            pbInterviewLiveNormalItemViewHolder.f20049i.setVisibility(0);
            pbInterviewLiveNormalItemViewHolder.f20047g.setVisibility(0);
            pbInterviewLiveNormalItemViewHolder.j.setVisibility(0);
            i0(pbInterviewLiveNormalItemViewHolder.f20046f, (int) this.f42341e.getResources().getDimension(R.dimen.ds30));
        } else {
            pbInterviewLiveNormalItemViewHolder.f20048h.setVisibility(8);
        }
        pbInterviewLiveNormalItemViewHolder.f20046f.getLayoutStrategy().x(R.drawable.pic_video);
        pbInterviewLiveNormalItemViewHolder.f20046f.setTextColor(SkinManager.getColor(R.color.common_color_10039));
        pbInterviewLiveNormalItemViewHolder.f20046f.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        pbInterviewLiveNormalItemViewHolder.f20046f.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        if (this.t) {
            pbInterviewLiveNormalItemViewHolder.f20046f.getLayoutStrategy().g(R.drawable.transparent_bg);
        } else {
            pbInterviewLiveNormalItemViewHolder.f20046f.getLayoutStrategy().g(R.drawable.icon_click);
        }
        pbInterviewLiveNormalItemViewHolder.f20046f.setIsFromCDN(this.q);
        TbRichText K = postData.K();
        if (!this.D && this.E) {
            pbInterviewLiveNormalItemViewHolder.f20046f.setText(K, true);
        } else {
            pbInterviewLiveNormalItemViewHolder.f20046f.setText(K, false);
        }
        if (this.v.N().f1() != null) {
            pbInterviewLiveNormalItemViewHolder.f20045e.M(this.v.N().f1().i(), this.q ? 17 : 18, false);
            int k = l.k(this.f42341e);
            float h2 = f1.h() / f1.j();
            int i2 = (int) (h2 > 1.0f ? k * 1.0f : h2 < 0.2f ? k * 0.2f : k * h2);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbInterviewLiveNormalItemViewHolder.f20045e.getLayoutParams();
            layoutParams2.height = i2;
            layoutParams2.width = k;
            pbInterviewLiveNormalItemViewHolder.f20045e.setLayoutParams(layoutParams2);
        } else {
            pbInterviewLiveNormalItemViewHolder.f20045e.setVisibility(8);
        }
        g0(pbInterviewLiveNormalItemViewHolder, postData);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: k0 */
    public PbInterviewLiveNormalItemViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, viewGroup)) == null) ? new PbInterviewLiveNormalItemViewHolder(LayoutInflater.from(this.f42341e).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.u, this.t, this.s, false) : (PbInterviewLiveNormalItemViewHolder) invokeL.objValue;
    }

    public View l0(int i2, View view, ViewGroup viewGroup, PostData postData, PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), view, viewGroup, postData, pbInterviewLiveNormalItemViewHolder})) == null) {
            super.X(i2, view, viewGroup, postData, pbInterviewLiveNormalItemViewHolder);
            SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
            m0(pbInterviewLiveNormalItemViewHolder);
            j0(pbInterviewLiveNormalItemViewHolder, postData);
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // d.a.q0.h2.k.c.a
    public void m(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onClickListener) == null) {
        }
    }

    public final void m0(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, pbInterviewLiveNormalItemViewHolder) == null) {
            pbInterviewLiveNormalItemViewHolder.f20046f.setOnLongClickListener(this.A);
            pbInterviewLiveNormalItemViewHolder.f20046f.setOnTouchListener(this.z);
            pbInterviewLiveNormalItemViewHolder.f20046f.setOnImageClickListener(this.y);
            b bVar = this.m;
            if (bVar == null || bVar.z() == null) {
                return;
            }
            pbInterviewLiveNormalItemViewHolder.f20046f.setOnEmotionClickListener(this.m.z().mEvent.f57760e);
        }
    }

    @Override // d.a.q0.h2.k.c.a
    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.s = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view) == null) {
        }
    }

    @Override // d.a.q0.h2.k.c.a
    public void p(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, zVar) == null) {
            this.y = zVar;
        }
    }

    @Override // d.a.q0.h2.k.c.a
    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
        }
    }

    @Override // d.a.q0.h2.k.c.a
    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
        }
    }

    @Override // d.a.q0.h2.k.c.a
    public void t(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, eVar) == null) {
            this.v = eVar;
        }
    }
}
