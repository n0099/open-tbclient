package d.a.s0.u0.w1;

import android.app.Activity;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.FollowUserButton;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.g.d;
import d.a.c.e.p.l;
import d.a.s0.h3.h0.m;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.e.g.c f67178a;

    /* renamed from: b  reason: collision with root package name */
    public final Activity f67179b;

    /* renamed from: c  reason: collision with root package name */
    public final ViewGroup f67180c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f67181d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.e.g.b f67182e;

    /* renamed from: f  reason: collision with root package name */
    public String f67183f;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f67184g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f67185h;

    /* renamed from: i  reason: collision with root package name */
    public String f67186i;
    public String j;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f67187e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67187e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f67187e.f67178a == null) {
                return;
            }
            this.f67187e.f67178a.e(this.f67187e.f67180c);
        }
    }

    /* loaded from: classes9.dex */
    public class b implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f67188a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67188a = cVar;
        }

        @Override // d.a.c.e.g.d.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f67188a.f67178a = null;
                this.f67188a.f67184g.removeCallbacks(this.f67188a.f67185h);
            }
        }

        @Override // d.a.c.e.g.d.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* renamed from: d.a.s0.u0.w1.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1776c implements d.a.c.e.g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f67189a;

        /* renamed from: d.a.s0.u0.w1.c$c$a */
        /* loaded from: classes9.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.r0.r.f0.m.a f67190e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ FollowUserButton f67191f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ C1776c f67192g;

            public a(C1776c c1776c, d.a.r0.r.f0.m.a aVar, FollowUserButton followUserButton) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1776c, aVar, followUserButton};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f67192g = c1776c;
                this.f67190e = aVar;
                this.f67191f = followUserButton;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (this.f67192g.f67189a.f67181d != null) {
                        this.f67192g.f67189a.f67181d.onClick(view);
                    }
                    this.f67190e.o(R.color.CAM_X0109);
                    this.f67190e.i(0, 0, TBSpecificationButtonConfig.IconType.SVG);
                    this.f67191f.setText(TbadkCoreApplication.getInst().getString(R.string.followed));
                    this.f67191f.setClickable(false);
                    if (this.f67192g.f67189a.f67185h != null) {
                        this.f67192g.f67189a.f67184g.removeCallbacks(this.f67192g.f67189a.f67185h);
                        this.f67192g.f67189a.f67184g.postDelayed(this.f67192g.f67189a.f67185h, 1000L);
                    }
                }
            }
        }

        public C1776c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67189a = cVar;
        }

        @Override // d.a.c.e.g.b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 3;
            }
            return invokeV.intValue;
        }

        @Override // d.a.c.e.g.b
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 32;
            }
            return invokeV.intValue;
        }

        @Override // d.a.c.e.g.b
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                View inflate = layoutInflater.inflate(R.layout.frs_guide_tip, (ViewGroup) null);
                View findViewById = inflate.findViewById(R.id.frs_guide_bg);
                BarImageView barImageView = (BarImageView) inflate.findViewById(R.id.frs_guide_bar_icon);
                FollowUserButton followUserButton = (FollowUserButton) inflate.findViewById(R.id.frs_guide_concern_btn);
                SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.frs_guide_text), R.color.CAM_X0302);
                barImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                barImageView.setContentDescription(this.f67189a.f67179b.getResources().getString(R.string.bar_header));
                barImageView.setStrokeWith(l.g(this.f67189a.f67179b, R.dimen.tbds1));
                barImageView.setShowOval(true);
                barImageView.setPlaceHolder(1);
                barImageView.setShowOuterBorder(false);
                barImageView.setShowInnerBorder(true);
                barImageView.setStrokeColorResId(R.color.CAM_X0401);
                if (!StringUtils.isNull(this.f67189a.f67183f)) {
                    barImageView.M(this.f67189a.f67183f, 10, false);
                }
                d.a.r0.r.f0.m.a aVar = new d.a.r0.r.f0.m.a();
                aVar.o(R.color.CAM_X0302);
                aVar.g(UtilHelper.getDimenPixelSize(R.dimen.tbds28));
                aVar.i(R.drawable.icon_pure_add12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
                aVar.f(UtilHelper.getDimenPixelSize(R.dimen.tbds11));
                followUserButton.setConfig(aVar);
                followUserButton.setText(this.f67189a.f67179b.getString(R.string.attention));
                followUserButton.setOnClickListener(new a(this, aVar, followUserButton));
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0207).setShapeRadius(l.g(this.f67189a.f67179b, R.dimen.tbds21)).setShadowColor(R.color.CAM_X0803).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.f67189a.f67179b, R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(this.f67189a.f67179b, R.dimen.tbds5)).into(findViewById);
                return inflate;
            }
            return (View) invokeL.objValue;
        }

        @Override // d.a.c.e.g.b
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // d.a.c.e.g.b
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f67193e;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67193e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f67193e.f67178a == null) {
                return;
            }
            this.f67193e.f67178a.e(this.f67193e.f67180c);
            this.f67193e.f67180c.setVisibility(8);
        }
    }

    /* loaded from: classes9.dex */
    public class e implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f67194a;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67194a = cVar;
        }

        @Override // d.a.c.e.g.d.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f67194a.f67178a = null;
                this.f67194a.f67184g.removeCallbacks(this.f67194a.f67185h);
            }
        }

        @Override // d.a.c.e.g.d.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements d.a.c.e.g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f67195a;

        /* loaded from: classes9.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f67196e;

            public a(f fVar) {
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
                this.f67196e = fVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (MessageManager.getInstance().findTask(2002015) != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("_forumId", this.f67196e.f67195a.j);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(TbadkCoreApplication.getInst().getApplicationContext(), "ForumAppealPage", hashMap)));
                    }
                    if (this.f67196e.f67195a.f67185h != null) {
                        this.f67196e.f67195a.f67184g.removeCallbacks(this.f67196e.f67195a.f67185h);
                        this.f67196e.f67195a.f67184g.postDelayed(this.f67196e.f67195a.f67185h, 1000L);
                    }
                }
            }
        }

        public f(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67195a = cVar;
        }

        @Override // d.a.c.e.g.b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 3;
            }
            return invokeV.intValue;
        }

        @Override // d.a.c.e.g.b
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 32;
            }
            return invokeV.intValue;
        }

        @Override // d.a.c.e.g.b
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                View inflate = layoutInflater.inflate(R.layout.frs_guide_delete_thread_tip, (ViewGroup) null);
                EMTextView eMTextView = (EMTextView) inflate.findViewById(R.id.frs_guide_delete_thread_tip_describe);
                SkinManager.setViewTextColor(eMTextView, R.color.CAM_X0302);
                eMTextView.setText(this.f67195a.f67186i);
                TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) inflate.findViewById(R.id.frs_guide_delete_thread_tip_button);
                d.a.r0.r.f0.m.b bVar = new d.a.r0.r.f0.m.b();
                bVar.o(R.color.CAM_X0302, R.color.CAM_X0101);
                tBSpecificationBtn.setConfig(bVar);
                tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getString(R.string.frs_guide_delete_thread_tip_button));
                tBSpecificationBtn.setOnClickListener(new a(this));
                return inflate;
            }
            return (View) invokeL.objValue;
        }

        @Override // d.a.c.e.g.b
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // d.a.c.e.g.b
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }
    }

    public c(Activity activity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67184g = new Handler();
        this.f67179b = activity;
        this.f67180c = (ViewGroup) activity.findViewById(i2);
    }

    public final d.a.c.e.g.b k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new C1776c(this) : (d.a.c.e.g.b) invokeV.objValue;
    }

    public final d.a.c.e.g.b l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new f(this) : (d.a.c.e.g.b) invokeV.objValue;
    }

    public void m() {
        d.a.c.e.g.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (cVar = this.f67178a) == null) {
            return;
        }
        cVar.e(this.f67180c);
        this.f67180c.setVisibility(8);
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f67183f = str;
        }
    }

    public void o(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f67181d = onClickListener;
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f67186i = str;
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.j = str;
        }
    }

    public void r() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (viewGroup = this.f67180c) == null) {
            return;
        }
        viewGroup.setVisibility(0);
        d.a.c.e.g.c cVar = this.f67178a;
        if (cVar != null) {
            cVar.e(this.f67180c);
        }
        this.f67185h = new d(this);
        d.a.c.e.g.d dVar = new d.a.c.e.g.d();
        dVar.d(true);
        dVar.g(new e(this));
        if (this.f67182e == null) {
            this.f67182e = l();
        }
        dVar.a(this.f67182e);
        dVar.e(R.anim.frs_guide_tip_enter);
        dVar.f(R.anim.frs_guide_tip_out);
        d.a.c.e.g.c b2 = dVar.b();
        this.f67178a = b2;
        b2.r(this.f67179b, this.f67180c, false);
        d.a.r0.r.u.c d2 = d.a.r0.r.u.c.d(this.f67180c);
        d2.n(R.string.J_X05);
        d2.s(R.array.S_O_X004);
        d2.f(R.color.CAM_X0207);
        this.f67184g.postDelayed(this.f67185h, 5000L);
    }

    public void s() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (viewGroup = this.f67180c) == null) {
            return;
        }
        viewGroup.setVisibility(0);
        d.a.c.e.g.c cVar = this.f67178a;
        if (cVar != null) {
            cVar.e(this.f67180c);
        }
        this.f67185h = new a(this);
        d.a.c.e.g.d dVar = new d.a.c.e.g.d();
        dVar.d(true);
        dVar.g(new b(this));
        if (this.f67182e == null) {
            this.f67182e = k();
        }
        dVar.a(this.f67182e);
        dVar.e(R.anim.frs_guide_tip_enter);
        dVar.f(R.anim.frs_guide_tip_out);
        d.a.c.e.g.c b2 = dVar.b();
        this.f67178a = b2;
        b2.r(this.f67179b, this.f67180c, false);
        this.f67184g.postDelayed(this.f67185h, PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
    }
}
