package d.a.q0.h2.k.e.b1;

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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
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
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
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
import d.a.d.e.p.j;
import d.a.d.e.p.k;
import d.a.d.e.p.l;
import d.a.p0.b1.n0;
import d.a.p0.s.q.b2;
import d.a.p0.t.c.i0;
import d.a.q0.a0.m;
import d.a.q0.h2.k.e.b1.f;
import d.a.q0.h2.k.e.q0;
import d.a.q0.h2.k.e.r0;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public TextView B;
    public int C;

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f57665a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.q0.h2.i.c f57666b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f57667c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnLongClickListener f57668d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.e0.e f57669e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f57670f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f57671g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.q0.h2.k.e.h f57672h;

    /* renamed from: i  reason: collision with root package name */
    public ColumnLayout f57673i;
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
    public c x;
    public TextView y;
    public TextView z;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f57674e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f57675f;

        public a(f fVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57675f = fVar;
            this.f57674e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int measuredWidth = this.f57675f.t.getMeasuredWidth();
                int measuredWidth2 = this.f57675f.y.getMeasuredWidth();
                int measuredWidth3 = this.f57675f.B.getMeasuredWidth();
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                int i2 = (measuredWidth - measuredWidth2) - measuredWidth3;
                int i3 = this.f57674e;
                if (i2 < i3) {
                    this.f57675f.A.setVisibility(8);
                    this.f57675f.z.setVisibility(8);
                } else if (i2 - i3 < dimenPixelSize) {
                    this.f57675f.z.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f57676e;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57676e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f57676e.o.playAnimation();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final TextView f57677a;

        /* renamed from: b  reason: collision with root package name */
        public final TBSpecificationBtn f57678b;

        /* renamed from: c  reason: collision with root package name */
        public String f57679c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f f57680d;

        public c(@NonNull f fVar, @NonNull TextView textView, TBSpecificationBtn tBSpecificationBtn) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, textView, tBSpecificationBtn};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57680d = fVar;
            this.f57677a = textView;
            this.f57678b = tBSpecificationBtn;
            c();
        }

        public void a(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f57679c = str;
            }
        }

        @NonNull
        public final i0 b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                i0 tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                return tiebaPlusConfigData == null ? i0.f53772c : tiebaPlusConfigData;
            }
            return (i0) invokeV.objValue;
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                d.a.p0.s.f0.n.b bVar = new d.a.p0.s.f0.n.b();
                bVar.q(R.color.CAM_X0302);
                this.f57678b.setConfig(bVar);
                this.f57678b.setOnClickListener(new View.OnClickListener() { // from class: d.a.q0.h2.k.e.b1.a
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            f.c.this.d(view);
                        }
                    }
                });
            }
        }

        public /* synthetic */ void d(View view) {
            if (!j.A()) {
                l.L(this.f57680d.f57665a.getContext(), R.string.neterror);
            } else {
                UrlManager.getInstance().dealOneLink(this.f57680d.f57665a.getPageContext(), new String[]{b().b(this.f57679c)});
            }
        }

        public void e(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                if (b().c()) {
                    this.f57678b.l(i2);
                } else {
                    SkinManager.setViewTextColor(this.f57677a, R.color.CAM_X0109);
                }
            }
        }

        public void f(@Nullable CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, charSequence) == null) {
                if (b().c()) {
                    this.f57678b.setText(charSequence.toString());
                } else {
                    this.f57677a.setText(charSequence);
                }
            }
        }

        public void g(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
                if (b().c()) {
                    this.f57678b.setVisibility(i2);
                    this.f57677a.setVisibility(8);
                    return;
                }
                this.f57678b.setVisibility(8);
                this.f57677a.setVisibility(i2);
            }
        }
    }

    public f(PbFragment pbFragment, d.a.q0.h2.i.c cVar, View.OnClickListener onClickListener) {
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
        this.f57667c = null;
        this.f57668d = null;
        this.f57670f = null;
        this.f57673i = null;
        this.k = null;
        this.l = null;
        this.r = null;
        this.u = null;
        this.v = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = 0;
        this.f57665a = pbFragment;
        this.f57666b = cVar;
        this.f57667c = onClickListener;
        p();
    }

    public final void A(d.a.q0.h2.h.e eVar) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || (tBLottieAnimationView = this.o) == null) {
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

    public void B(PostData postData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, postData, z) == null) {
            if (this.f57665a.isSimpleForum()) {
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

    public void C(d.a.q0.h2.h.e eVar, PostData postData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, eVar, postData, z) == null) || eVar == null || postData == null) {
            return;
        }
        if (3 != eVar.g()) {
            this.v.setVisibility(0);
        }
        if (z) {
            this.v.setVisibility(8);
            if (eVar != null && eVar.N() != null && eVar.N().J() != null && eVar.N().J().oriUgcType == 3) {
                this.x.g(8);
            } else {
                this.x.g(0);
            }
            this.x.a(eVar.P());
            this.x.f(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), StringHelper.numberUniformFormatExtra(eVar.O())));
        } else if (PbNormalLikeButtonSwitch.getIsOn() && !postData.t().hadConcerned()) {
            this.x.g(8);
        } else {
            this.v.setVisibility(8);
            this.x.g(8);
        }
        if (eVar.f57445i || 3 == eVar.g()) {
            this.v.setVisibility(8);
        }
    }

    public void h(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.addHeaderView(this.f57670f);
    }

    public void i(BdTypeListView bdTypeListView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, bdTypeListView, i2) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.x(this.f57670f, i2);
    }

    public void j(d.a.q0.h2.h.e eVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{eVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (eVar != null && eVar.j) {
                this.f57671g.setImageResource(R.drawable.pic_frs_headlines_n);
                this.f57671g.setVisibility(0);
            } else if (z && z2) {
                this.f57671g.setImageResource(R.drawable.pic_pb_stick_refined_n);
                this.f57671g.setVisibility(0);
            } else if (z) {
                this.f57671g.setImageResource(R.drawable.pic_pb_refined_n);
                this.f57671g.setVisibility(0);
            } else if (z2) {
                this.f57671g.setImageResource(R.drawable.pic_pb_stick_n);
                this.f57671g.setVisibility(0);
            } else {
                this.f57671g.setVisibility(8);
            }
        }
    }

    public void k() {
        d.a.q0.e0.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (eVar = this.f57669e) == null) {
            return;
        }
        eVar.I();
    }

    public TextView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f57672h.e() : (TextView) invokeV.objValue;
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f57670f : (View) invokeV.objValue;
    }

    public final SpannableStringBuilder n(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null || str == null) {
                return spannableStringBuilder;
            }
            arrayList.add(new m.a(str));
            return m.h(this.f57665a.getActivity(), str2, arrayList, true);
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public SparseArray<Object> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            SparseArray<Object> sparseArray = (SparseArray) this.f57673i.getTag();
            if (sparseArray == null) {
                SparseArray<Object> sparseArray2 = new SparseArray<>();
                this.f57673i.setTag(sparseArray2);
                return sparseArray2;
            }
            return sparseArray;
        }
        return (SparseArray) invokeV.objValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f57665a.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
            this.f57670f = relativeLayout;
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.pb_thread_type_stamp_top_part);
            this.f57671g = imageView;
            imageView.getLayoutParams().height = r0.f();
            d.a.q0.h2.k.e.h hVar = new d.a.q0.h2.k.e.h(this.f57665a.getBaseFragmentActivity(), this.f57670f);
            this.f57672h = hVar;
            hVar.a();
            d.a.q0.h2.k.e.h hVar2 = this.f57672h;
            hVar2.d(hVar2.e(), this.f57667c);
            this.f57673i = (ColumnLayout) this.f57670f.findViewById(R.id.pb_head_owner_root);
            this.j = (ThreadSkinView) this.f57670f.findViewById(R.id.pb_thread_skin);
            this.k = (TextView) this.f57673i.findViewById(R.id.pb_head_owner_info_user_name);
            this.l = (TextView) this.f57673i.findViewById(R.id.floor_owner);
            this.m = (ImageView) this.f57673i.findViewById(R.id.icon_forum_level);
            this.r = (FrameLayout) this.f57673i.findViewById(R.id.pb_head_headImage_container);
            HeadPendantView headPendantView = (HeadPendantView) this.f57673i.findViewById(R.id.pb_pendant_head_owner_photo);
            this.n = headPendantView;
            headPendantView.setHasPendantStyle();
            this.o = (TBLottieAnimationView) this.f57673i.findViewById(R.id.pb_head_living_lottie);
            this.f57673i.setOnLongClickListener(this.f57668d);
            this.f57673i.setOnTouchListener(this.f57666b);
            this.f57673i.setVisibility(8);
            if (this.n.getHeadView() != null) {
                this.n.getHeadView().setIsRound(true);
                this.n.getHeadView().setDrawBorder(true);
                this.n.getHeadView().setPlaceHolder(1);
            }
            this.p = (UserIconBox) this.f57673i.findViewById(R.id.show_icon_vip);
            this.q = (UserIconBox) this.f57673i.findViewById(R.id.show_icon_yinji);
            this.s = (LinearLayout) this.f57670f.findViewById(R.id.pb_head_owner_info_root);
            this.t = (LinearLayout) this.f57673i.findViewById(R.id.pb_first_floor_location_container);
            this.v = (PbFirstFloorUserLikeButton) this.f57673i.findViewById(R.id.pb_like_button);
            this.x = new c(this, (TextView) this.f57673i.findViewById(R.id.pb_views), (TBSpecificationBtn) this.f57673i.findViewById(R.id.pb_views_btn));
            this.y = (TextView) this.f57673i.findViewById(R.id.pb_item_first_floor_reply_time);
            this.z = (TextView) this.f57673i.findViewById(R.id.pb_item_first_floor_location_address);
            this.A = (TextView) this.f57673i.findViewById(R.id.pb_item_first_floor_distance);
            this.B = (TextView) this.f57673i.findViewById(R.id.pb_item_first_floor_general_desc);
        }
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f57670f, R.color.CAM_X0205);
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
            c cVar = this.x;
            if (cVar != null) {
                cVar.e(i2);
            }
            TextView textView3 = this.B;
            if (textView3 != null) {
                SkinManager.setViewTextColor(textView3, R.color.CAM_X0109);
            }
            TextView textView4 = this.A;
            if (textView4 != null) {
                SkinManager.setViewTextColor(textView4, R.color.CAM_X0109);
            }
            TBLottieAnimationView tBLottieAnimationView = this.o;
            if (tBLottieAnimationView != null) {
                SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            d.a.q0.e0.e eVar = this.f57669e;
            if (eVar != null) {
                eVar.I();
            }
            ColumnLayout columnLayout = this.f57673i;
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

    public void s(d.a.q0.h2.h.e eVar, PostData postData, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{eVar, postData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || eVar == null || postData == null) {
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
                if (N.F1()) {
                    i2 = 4;
                } else if (N.I1()) {
                    i2 = 6;
                } else if (N.H1()) {
                    i2 = 7;
                } else if (N.G1()) {
                    i2 = 5;
                } else if (N.t2()) {
                    i2 = 8;
                }
            }
            q0 q0Var = new q0(this.f57665a.getPageContext(), this.v, i2);
            this.w = q0Var;
            q0Var.l(this.f57665a.getUniqueId());
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

    public void t(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.removeHeaderView(this.f57670f);
    }

    public void u(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onLongClickListener) == null) {
            this.f57668d = onLongClickListener;
            this.f57673i.setOnLongClickListener(onLongClickListener);
        }
    }

    public void v(PostData postData, d.a.q0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, postData, eVar) == null) || postData == null || eVar == null) {
            return;
        }
        if (postData.L() != null) {
            this.j.setData(this.f57665a.getPageContext(), eVar.E().get(0).L(), d.a.q0.h3.j0.a.a("PB", "c0132", eVar.m().getId(), eVar.m().getName(), eVar.N().d0(), this.f57665a.m5() ? "FRS" : null));
            ColumnLayout columnLayout = this.f57673i;
            columnLayout.setPadding(columnLayout.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds20), this.f57673i.getPaddingRight(), this.f57673i.getPaddingBottom());
            return;
        }
        this.j.setData(null, null, null);
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.f57672h.g(z);
        }
    }

    public void x(d.a.q0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, eVar) == null) {
            if (eVar != null && eVar.l0()) {
                int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.ds45);
                int paddingBottom = this.f57673i.getPaddingBottom();
                if (eVar.e0()) {
                    g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                    paddingBottom = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds8);
                }
                ColumnLayout columnLayout = this.f57673i;
                columnLayout.setPadding(columnLayout.getPaddingLeft(), g2, this.f57673i.getPaddingRight(), paddingBottom);
                return;
            }
            int g3 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds60);
            int paddingBottom2 = this.f57673i.getPaddingBottom();
            if (eVar != null && !eVar.N().s2() && eVar.e0() && (!StringUtils.isNull(eVar.N().getTitle()) || eVar.N().c1() != null)) {
                g3 = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);
            }
            ColumnLayout columnLayout2 = this.f57673i;
            columnLayout2.setPadding(columnLayout2.getPaddingLeft(), g3, this.f57673i.getPaddingRight(), paddingBottom2);
        }
    }

    public void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.f57673i.setVisibility(i2);
        }
    }

    public void z(int i2, d.a.q0.h2.h.e eVar, PostData postData, View.OnClickListener onClickListener) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i2), eVar, postData, onClickListener}) == null) {
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
                    if (this.f57665a.z() != null) {
                        this.q.setOnClickListener(this.f57665a.z().mEvent.f57758c);
                    }
                    int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    this.q.g(iconInfo, 4, g2, g2, l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                }
                if (this.p != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        this.p.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.f57665a.z() != null) {
                        this.p.setOnClickListener(this.f57665a.z().mEvent.f57759d);
                    }
                    int g3 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    this.p.h(tShowInfoNew, 3, g3, g3, l.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                this.k.setText(n(t.getSealPrefix(), string));
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
                    d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(this.l);
                    d2.t(R.color.CAM_X0101);
                    d2.n(R.string.J_X04);
                    d2.f(R.color.CAM_X0302);
                    this.l.setVisibility(0);
                    this.l.setText(R.string.brand_official);
                } else if (t.getIs_bawu() == 1 && "manager".equals(t.getBawu_type())) {
                    this.l.setText(R.string.bawu_member_bazhu_tip);
                    this.l.setVisibility(0);
                    d.a.p0.s.u.c d3 = d.a.p0.s.u.c.d(this.l);
                    d3.t(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                } else if (t.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(t.getBawu_type())) {
                    this.l.setText(R.string.bawu_member_xbazhu_tip);
                    this.l.setVisibility(0);
                    d.a.p0.s.u.c d4 = d.a.p0.s.u.c.d(this.l);
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
                    this.f57673i.setSpacingRight(0);
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
                    this.f57673i.setSpacingRight(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                    d.a.p0.u.f I = postData.I();
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
                    A(eVar);
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
                    this.k.setText(d.a.q0.h2.c.b(this.f57665a.getPageContext().getPageActivity(), this.k.getText().toString()));
                    this.k.setGravity(16);
                    this.k.setTag(R.id.tag_nick_name_activity, d.a.q0.h2.c.a());
                    SkinManager.setViewTextColor(this.k, R.color.CAM_X0312, 1);
                }
            }
            if (eVar != null) {
                this.f57672h.f(eVar.N());
            }
        }
    }
}
