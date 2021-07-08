package d.a.p0.h2.k.e.a1;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.switchs.PbNormalLikeButtonSwitch;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.o0.r.q.b2;
import d.a.o0.z0.n0;
import d.a.p0.a0.m;
import d.a.p0.h2.k.e.h;
import d.a.p0.h2.k.e.q0;
import d.a.p0.h2.k.e.r0;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public TextView B;
    public int C;

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f57085a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.p0.h2.i.c f57086b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f57087c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnLongClickListener f57088d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.p0.e0.e f57089e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f57090f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f57091g;

    /* renamed from: h  reason: collision with root package name */
    public h f57092h;

    /* renamed from: i  reason: collision with root package name */
    public ColumnLayout f57093i;
    public ThreadSkinView j;
    public TextView k;
    public TextView l;
    public ImageView m;
    public HeadPendantView n;
    public TBLottieAnimationView o;
    public UserIconBox p;
    public UserIconBox q;
    public FrameLayout r;
    public LinearLayout s;
    public LinearLayout t;
    public ClickableHeaderImageView u;
    public PbFirstFloorUserLikeButton v;
    public q0 w;
    public TextView x;
    public TextView y;
    public TextView z;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f57094e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f57095f;

        public a(e eVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57095f = eVar;
            this.f57094e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int measuredWidth = this.f57095f.t.getMeasuredWidth();
                int measuredWidth2 = this.f57095f.y.getMeasuredWidth();
                int measuredWidth3 = this.f57095f.B.getMeasuredWidth();
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                int i2 = (measuredWidth - measuredWidth2) - measuredWidth3;
                int i3 = this.f57094e;
                if (i2 < i3) {
                    this.f57095f.A.setVisibility(8);
                    this.f57095f.z.setVisibility(8);
                } else if (i2 - i3 < dimenPixelSize) {
                    this.f57095f.z.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f57096e;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57096e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f57096e.o.playAnimation();
            }
        }
    }

    public e(PbFragment pbFragment, d.a.p0.h2.i.c cVar, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, cVar, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57087c = null;
        this.f57088d = null;
        this.f57090f = null;
        this.f57093i = null;
        this.k = null;
        this.l = null;
        this.r = null;
        this.u = null;
        this.v = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = 0;
        this.f57085a = pbFragment;
        this.f57086b = cVar;
        this.f57087c = onClickListener;
        o();
    }

    public void A(PostData postData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, postData, z) == null) {
            if (this.f57085a.isSimpleForum()) {
                this.C = 0;
                if (postData != null && postData.t() != null) {
                    this.C = postData.t().getLevel_id();
                }
                if (this.C > 0 && !z) {
                    this.m.setVisibility(0);
                    SkinManager.setImageResource(this.m, BitmapHelper.getGradeResourceIdInEnterForum(this.C));
                    return;
                }
                this.m.setVisibility(8);
                return;
            }
            this.m.setVisibility(8);
        }
    }

    public void B(d.a.p0.h2.h.e eVar, PostData postData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, postData, z) == null) || eVar == null || postData == null) {
            return;
        }
        if (3 != eVar.g()) {
            this.v.setVisibility(0);
        }
        if (z) {
            this.v.setVisibility(8);
            if (eVar != null && eVar.N() != null && eVar.N().J() != null && eVar.N().J().oriUgcType == 3) {
                this.x.setVisibility(8);
            } else {
                this.x.setVisibility(0);
            }
            this.x.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), StringHelper.numberUniformFormatExtra(eVar.O())));
        } else if (PbNormalLikeButtonSwitch.getIsOn() && !postData.t().hadConcerned()) {
            this.x.setVisibility(8);
        } else {
            this.v.setVisibility(8);
            this.x.setVisibility(8);
        }
        if (eVar.f56901i || 3 == eVar.g()) {
            this.v.setVisibility(8);
        }
    }

    public void g(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.addHeaderView(this.f57090f);
    }

    public void h(BdTypeListView bdTypeListView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, bdTypeListView, i2) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.x(this.f57090f, i2);
    }

    public void i(d.a.p0.h2.h.e eVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{eVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (eVar != null && eVar.j) {
                this.f57091g.setImageResource(R.drawable.pic_frs_headlines_n);
                this.f57091g.setVisibility(0);
            } else if (z && z2) {
                this.f57091g.setImageResource(R.drawable.pic_pb_stick_refined_n);
                this.f57091g.setVisibility(0);
            } else if (z) {
                this.f57091g.setImageResource(R.drawable.pic_pb_refined_n);
                this.f57091g.setVisibility(0);
            } else if (z2) {
                this.f57091g.setImageResource(R.drawable.pic_pb_stick_n);
                this.f57091g.setVisibility(0);
            } else {
                this.f57091g.setVisibility(8);
            }
        }
    }

    public void j() {
        d.a.p0.e0.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (eVar = this.f57089e) == null) {
            return;
        }
        eVar.I();
    }

    public TextView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f57092h.e() : (TextView) invokeV.objValue;
    }

    public View l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f57090f : (View) invokeV.objValue;
    }

    public final SpannableStringBuilder m(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null || str == null) {
                return spannableStringBuilder;
            }
            arrayList.add(new m.a(str));
            return m.h(this.f57085a.getActivity(), str2, arrayList, true);
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public SparseArray<Object> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            SparseArray<Object> sparseArray = (SparseArray) this.f57093i.getTag();
            if (sparseArray == null) {
                SparseArray<Object> sparseArray2 = new SparseArray<>();
                this.f57093i.setTag(sparseArray2);
                return sparseArray2;
            }
            return sparseArray;
        }
        return (SparseArray) invokeV.objValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f57085a.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
            this.f57090f = relativeLayout;
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.pb_thread_type_stamp_top_part);
            this.f57091g = imageView;
            imageView.getLayoutParams().height = r0.f();
            h hVar = new h(this.f57085a.getBaseFragmentActivity(), this.f57090f);
            this.f57092h = hVar;
            hVar.a();
            h hVar2 = this.f57092h;
            hVar2.d(hVar2.e(), this.f57087c);
            this.f57093i = (ColumnLayout) this.f57090f.findViewById(R.id.pb_head_owner_root);
            this.j = (ThreadSkinView) this.f57090f.findViewById(R.id.pb_thread_skin);
            this.k = (TextView) this.f57093i.findViewById(R.id.pb_head_owner_info_user_name);
            this.l = (TextView) this.f57093i.findViewById(R.id.floor_owner);
            this.m = (ImageView) this.f57093i.findViewById(R.id.icon_forum_level);
            this.r = (FrameLayout) this.f57093i.findViewById(R.id.pb_head_headImage_container);
            HeadPendantView headPendantView = (HeadPendantView) this.f57093i.findViewById(R.id.pb_pendant_head_owner_photo);
            this.n = headPendantView;
            headPendantView.setHasPendantStyle();
            this.o = (TBLottieAnimationView) this.f57093i.findViewById(R.id.pb_head_living_lottie);
            this.f57093i.setOnLongClickListener(this.f57088d);
            this.f57093i.setOnTouchListener(this.f57086b);
            this.f57093i.setVisibility(8);
            if (this.n.getHeadView() != null) {
                this.n.getHeadView().setIsRound(true);
                this.n.getHeadView().setDrawBorder(true);
                this.n.getHeadView().setPlaceHolder(1);
            }
            this.p = (UserIconBox) this.f57093i.findViewById(R.id.show_icon_vip);
            this.q = (UserIconBox) this.f57093i.findViewById(R.id.show_icon_yinji);
            this.s = (LinearLayout) this.f57090f.findViewById(R.id.pb_head_owner_info_root);
            this.t = (LinearLayout) this.f57093i.findViewById(R.id.pb_first_floor_location_container);
            this.v = (PbFirstFloorUserLikeButton) this.f57093i.findViewById(R.id.pb_like_button);
            this.x = (TextView) this.f57093i.findViewById(R.id.pb_views);
            this.y = (TextView) this.f57093i.findViewById(R.id.pb_item_first_floor_reply_time);
            this.z = (TextView) this.f57093i.findViewById(R.id.pb_item_first_floor_location_address);
            this.A = (TextView) this.f57093i.findViewById(R.id.pb_item_first_floor_distance);
            this.B = (TextView) this.f57093i.findViewById(R.id.pb_item_first_floor_general_desc);
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f57090f, R.color.CAM_X0205);
            ImageView imageView = this.m;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, BitmapHelper.getGradeResourceIdInEnterForum(this.C));
            }
            PbFirstFloorUserLikeButton pbFirstFloorUserLikeButton = this.v;
            if (pbFirstFloorUserLikeButton != null) {
                pbFirstFloorUserLikeButton.r(i2);
            }
            TextView textView = this.z;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
            }
            TextView textView2 = this.y;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0109);
            }
            TextView textView3 = this.x;
            if (textView3 != null) {
                SkinManager.setViewTextColor(textView3, R.color.CAM_X0109);
            }
            TextView textView4 = this.B;
            if (textView4 != null) {
                SkinManager.setViewTextColor(textView4, R.color.CAM_X0109);
            }
            TextView textView5 = this.A;
            if (textView5 != null) {
                SkinManager.setViewTextColor(textView5, R.color.CAM_X0109);
            }
            TBLottieAnimationView tBLottieAnimationView = this.o;
            if (tBLottieAnimationView != null) {
                SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            d.a.p0.e0.e eVar = this.f57089e;
            if (eVar != null) {
                eVar.I();
            }
            ColumnLayout columnLayout = this.f57093i;
            if (columnLayout != null && this.u != null) {
                columnLayout.removeView(this.r);
                this.u = null;
            }
            TBLottieAnimationView tBLottieAnimationView = this.o;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.cancelAnimation();
            }
        }
    }

    public void r(d.a.p0.h2.h.e eVar, PostData postData, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{eVar, postData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || eVar == null || postData == null) {
            return;
        }
        String P = eVar != null ? eVar.P() : "";
        int h2 = r0.h(eVar);
        if (z && postData != null && postData.t() != null) {
            postData.t().setIsLike(postData.t().hadConcerned());
        }
        if (this.w == null) {
            b2 N = eVar.N();
            int i2 = 1;
            if (N != null) {
                if (N.E1()) {
                    i2 = 4;
                } else if (N.H1()) {
                    i2 = 6;
                } else if (N.G1()) {
                    i2 = 7;
                } else if (N.F1()) {
                    i2 = 5;
                } else if (N.r2()) {
                    i2 = 8;
                }
            }
            q0 q0Var = new q0(this.f57085a.getPageContext(), this.v, i2);
            this.w = q0Var;
            q0Var.l(this.f57085a.getUniqueId());
            this.w.u(N);
        }
        if (postData != null && postData.t() != null) {
            postData.t().setIsLike(postData.t().hadConcerned());
            this.w.n(postData.t());
            this.w.w(P);
        }
        q0 q0Var2 = this.w;
        q0Var2.s = z2;
        q0Var2.v(h2);
    }

    public void s(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.removeHeaderView(this.f57090f);
    }

    public void t(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onLongClickListener) == null) {
            this.f57088d = onLongClickListener;
            this.f57093i.setOnLongClickListener(onLongClickListener);
        }
    }

    public void u(PostData postData, d.a.p0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, postData, eVar) == null) || postData == null || eVar == null) {
            return;
        }
        if (postData.L() != null) {
            this.j.setData(this.f57085a.getPageContext(), eVar.E().get(0).L(), d.a.p0.h3.j0.a.a("PB", "c0132", eVar.m().getId(), eVar.m().getName(), eVar.N().c0(), this.f57085a.g5() ? "FRS" : null));
            ColumnLayout columnLayout = this.f57093i;
            columnLayout.setPadding(columnLayout.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds20), this.f57093i.getPaddingRight(), this.f57093i.getPaddingBottom());
            return;
        }
        this.j.setData(null, null, null);
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f57092h.g(z);
        }
    }

    public void w(d.a.p0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, eVar) == null) {
            if (eVar != null && eVar.l0()) {
                int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.ds45);
                int paddingBottom = this.f57093i.getPaddingBottom();
                if (eVar.e0()) {
                    g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                    paddingBottom = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds8);
                }
                ColumnLayout columnLayout = this.f57093i;
                columnLayout.setPadding(columnLayout.getPaddingLeft(), g2, this.f57093i.getPaddingRight(), paddingBottom);
                return;
            }
            int g3 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds60);
            int paddingBottom2 = this.f57093i.getPaddingBottom();
            if (eVar != null && !eVar.N().q2() && eVar.e0() && (!StringUtils.isNull(eVar.N().getTitle()) || eVar.N().b1() != null)) {
                g3 = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);
            }
            ColumnLayout columnLayout2 = this.f57093i;
            columnLayout2.setPadding(columnLayout2.getPaddingLeft(), g3, this.f57093i.getPaddingRight(), paddingBottom2);
        }
    }

    public void x(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.f57093i.setVisibility(i2);
        }
    }

    public void y(int i2, d.a.p0.h2.h.e eVar, PostData postData, View.OnClickListener onClickListener) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i2), eVar, postData, onClickListener}) == null) {
            if (postData != null && postData.t() != null) {
                MetaData t = postData.t();
                String string = t.getName_show() == null ? StringUtils.string(t.getUserName()) : StringUtils.string(t.getName_show());
                if ((!StringUtils.isNull(postData.t().getSealPrefix()) ? k.byteLength(t.getSealPrefix()) + 2 : 0) > 0) {
                    if (k.byteLength(string) > 12) {
                        string = StringHelper.cutChineseAndEnglishWithSuffix(string, 12, StringHelper.STRING_MORE);
                    }
                } else if (k.byteLength(string) > 14) {
                    string = StringHelper.cutChineseAndEnglishWithSuffix(string, 14, StringHelper.STRING_MORE);
                }
                ArrayList<IconData> iconInfo = t.getIconInfo();
                ArrayList<IconData> tShowInfoNew = t.getTShowInfoNew();
                UserIconBox userIconBox = this.q;
                if (userIconBox != null) {
                    userIconBox.setTag(R.id.tag_user_id, t.getUserId());
                    if (this.f57085a.z() != null) {
                        this.q.setOnClickListener(this.f57085a.z().mEvent.f57171c);
                    }
                    int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    this.q.g(iconInfo, 4, g2, g2, l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                }
                if (this.p != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        this.p.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.f57085a.z() != null) {
                        this.p.setOnClickListener(this.f57085a.z().mEvent.f57172d);
                    }
                    int g3 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    this.p.h(tShowInfoNew, 3, g3, g3, l.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                this.k.setText(m(t.getSealPrefix(), string));
                this.k.setTag(R.id.tag_user_id, t.getUserId());
                this.k.setTag(R.id.tag_user_name, t.getName_show());
                if (ListUtils.isEmpty(tShowInfoNew) && !t.isBigV()) {
                    SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1);
                } else {
                    SkinManager.setViewTextColor(this.k, R.color.CAM_X0301, 1);
                }
                if (eVar.e0()) {
                    this.l.setVisibility(8);
                } else if (t.getIs_bawu() == 1 && postData.X()) {
                    d.a.o0.r.u.c d2 = d.a.o0.r.u.c.d(this.l);
                    d2.t(R.color.CAM_X0101);
                    d2.n(R.string.J_X04);
                    d2.f(R.color.CAM_X0302);
                    this.l.setVisibility(0);
                    this.l.setText(R.string.brand_official);
                } else if (t.getIs_bawu() == 1 && "manager".equals(t.getBawu_type())) {
                    this.l.setText(R.string.bawu_member_bazhu_tip);
                    this.l.setVisibility(0);
                    d.a.o0.r.u.c d3 = d.a.o0.r.u.c.d(this.l);
                    d3.t(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                } else if (t.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(t.getBawu_type())) {
                    this.l.setText(R.string.bawu_member_xbazhu_tip);
                    this.l.setVisibility(0);
                    d.a.o0.r.u.c d4 = d.a.o0.r.u.c.d(this.l);
                    d4.t(R.color.CAM_X0101);
                    d4.n(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                } else {
                    this.l.setVisibility(8);
                }
                if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.R()), "yyyy"))) {
                    this.y.setText(StringHelper.getFormatTimeShort(postData.R()));
                } else {
                    this.y.setText(StringHelper.getFormatTime(postData.R()));
                }
                if (eVar.e0()) {
                    this.z.setVisibility(8);
                    if (this.t.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                        ((FrameLayout.LayoutParams) ((ColumnLayout.LayoutParams) this.t.getLayoutParams())).rightMargin = 0;
                    }
                    this.f57093i.setSpacingRight(0);
                    String str = t.getBaijiahaoInfo() != null ? t.getBaijiahaoInfo().auth_desc : null;
                    if (t.isNewGod()) {
                        this.B.setVisibility(0);
                        this.B.setText(t.getNewGodData().getFieldName() + n0.d(t.isVideoGod()));
                    } else if (t.showBazhuGrade()) {
                        this.B.setVisibility(0);
                        this.B.setText(StringHelper.cutChineseAndEnglishWithSuffix(t.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                    } else if (!StringUtils.isNull(str)) {
                        this.B.setVisibility(0);
                        this.B.setText(str);
                    } else {
                        this.B.setVisibility(8);
                    }
                } else {
                    if (t.isNewGod()) {
                        this.B.setVisibility(0);
                        this.B.setText(t.getNewGodData().getFieldName() + n0.a(t.getNewGodData().getType()));
                    } else if (t.showBazhuGrade()) {
                        this.B.setVisibility(0);
                        this.B.setText(StringHelper.cutChineseAndEnglishWithSuffix(t.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                    } else {
                        this.B.setVisibility(8);
                    }
                    if (this.t.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                        ((FrameLayout.LayoutParams) ((ColumnLayout.LayoutParams) this.t.getLayoutParams())).rightMargin = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    }
                    this.f57093i.setSpacingRight(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                    d.a.o0.t.g I = postData.I();
                    if (I != null && !TextUtils.isEmpty(I.b()) && !TextUtils.isEmpty(I.b().trim())) {
                        this.z.setVisibility(0);
                        this.z.setText(I.b());
                    } else {
                        this.z.setVisibility(8);
                    }
                    if (I != null && !TextUtils.isEmpty(I.a())) {
                        this.A.setText(I.a());
                        this.A.setVisibility(0);
                        this.t.post(new a(this, (int) this.A.getPaint().measureText(I.a(), 0, I.a().length())));
                    } else {
                        this.A.setVisibility(8);
                    }
                }
                if (eVar.N().H() == null || eVar.N().H().getAlaInfo() == null || eVar.N().H().getAlaInfo().live_status != 1) {
                    z = false;
                } else {
                    z(eVar);
                    z = true;
                }
                this.n.setBigVDimenSize(R.dimen.tbds32);
                if (!z) {
                    this.n.i(t, 4);
                    this.n.setIsclearmode(false);
                } else {
                    this.n.setIsclearmode(true);
                }
                this.n.setVisibility(0);
                ClickableHeaderImageView clickableHeaderImageView = this.u;
                if (clickableHeaderImageView != null) {
                    clickableHeaderImageView.setVisibility(8);
                }
                this.k.setOnClickListener(onClickListener);
                this.n.getHeadView().setUserId(t.getUserId());
                this.n.getHeadView().setUserName(t.getUserName());
                this.n.getHeadView().setTid(postData.E());
                this.n.getHeadView().setFid(eVar != null ? eVar.n() : "");
                this.n.getHeadView().setFName(eVar.o());
                this.n.getHeadView().setOnClickListener(onClickListener);
                if (z) {
                    this.n.k(t.getAvater());
                } else {
                    this.n.m(t);
                }
                String name_show = t.getName_show();
                String userName = t.getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    this.k.setText(d.a.p0.h2.c.b(this.f57085a.getPageContext().getPageActivity(), this.k.getText().toString()));
                    this.k.setGravity(16);
                    this.k.setTag(R.id.tag_nick_name_activity, d.a.p0.h2.c.a());
                    SkinManager.setViewTextColor(this.k, R.color.CAM_X0312, 1);
                }
            }
            if (eVar != null) {
                this.f57092h.f(eVar.N());
            }
        }
    }

    public final void z(d.a.p0.h2.h.e eVar) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, eVar) == null) || (tBLottieAnimationView = this.o) == null) {
            return;
        }
        if (tBLottieAnimationView.getVisibility() != 0 && eVar != null && eVar.N() != null && eVar.N().H() != null) {
            StatisticItem statisticItem = new StatisticItem("c13714");
            statisticItem.param("fid", eVar.n());
            statisticItem.param("fname", eVar.o());
            statisticItem.param("obj_param1", eVar.N().H().getUserId());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", eVar.P());
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
            if (eVar.N().H().getAlaInfo() != null) {
                AlaInfoData alaInfo = eVar.N().H().getAlaInfo();
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
                if (alaInfo.mYyExtData != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                }
            }
            TiebaStatic.log(statisticItem);
        }
        this.o.setVisibility(0);
        this.o.setSpeed(0.8f);
        this.o.loop(true);
        this.o.post(new b(this));
    }
}
