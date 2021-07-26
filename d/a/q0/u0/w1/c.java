package d.a.q0.u0.w1;

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
import d.a.d.e.g.d;
import d.a.d.e.p.l;
import d.a.q0.h3.h0.m;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.d.e.g.c f64606a;

    /* renamed from: b  reason: collision with root package name */
    public final Activity f64607b;

    /* renamed from: c  reason: collision with root package name */
    public final ViewGroup f64608c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f64609d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.d.e.g.b f64610e;

    /* renamed from: f  reason: collision with root package name */
    public String f64611f;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f64612g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f64613h;

    /* renamed from: i  reason: collision with root package name */
    public String f64614i;
    public String j;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f64615e;

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
            this.f64615e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f64615e.f64606a == null) {
                return;
            }
            this.f64615e.f64606a.e(this.f64615e.f64608c);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f64616a;

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
            this.f64616a = cVar;
        }

        @Override // d.a.d.e.g.d.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f64616a.f64606a = null;
                this.f64616a.f64612g.removeCallbacks(this.f64616a.f64613h);
            }
        }

        @Override // d.a.d.e.g.d.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* renamed from: d.a.q0.u0.w1.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1738c implements d.a.d.e.g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f64617a;

        /* renamed from: d.a.q0.u0.w1.c$c$a */
        /* loaded from: classes8.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.p0.s.f0.n.a f64618e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ FollowUserButton f64619f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ C1738c f64620g;

            public a(C1738c c1738c, d.a.p0.s.f0.n.a aVar, FollowUserButton followUserButton) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1738c, aVar, followUserButton};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f64620g = c1738c;
                this.f64618e = aVar;
                this.f64619f = followUserButton;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (this.f64620g.f64617a.f64609d != null) {
                        this.f64620g.f64617a.f64609d.onClick(view);
                    }
                    this.f64618e.o(R.color.CAM_X0109);
                    this.f64618e.i(0, 0, TBSpecificationButtonConfig.IconType.SVG);
                    this.f64619f.setText(TbadkCoreApplication.getInst().getString(R.string.followed));
                    this.f64619f.setClickable(false);
                    if (this.f64620g.f64617a.f64613h != null) {
                        this.f64620g.f64617a.f64612g.removeCallbacks(this.f64620g.f64617a.f64613h);
                        this.f64620g.f64617a.f64612g.postDelayed(this.f64620g.f64617a.f64613h, 1000L);
                    }
                }
            }
        }

        public C1738c(c cVar) {
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
            this.f64617a = cVar;
        }

        @Override // d.a.d.e.g.b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 3;
            }
            return invokeV.intValue;
        }

        @Override // d.a.d.e.g.b
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 32;
            }
            return invokeV.intValue;
        }

        @Override // d.a.d.e.g.b
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
                barImageView.setContentDescription(this.f64617a.f64607b.getResources().getString(R.string.bar_header));
                barImageView.setStrokeWith(l.g(this.f64617a.f64607b, R.dimen.tbds1));
                barImageView.setShowOval(true);
                barImageView.setPlaceHolder(1);
                barImageView.setShowOuterBorder(false);
                barImageView.setShowInnerBorder(true);
                barImageView.setStrokeColorResId(R.color.CAM_X0401);
                if (!StringUtils.isNull(this.f64617a.f64611f)) {
                    barImageView.M(this.f64617a.f64611f, 10, false);
                }
                d.a.p0.s.f0.n.a aVar = new d.a.p0.s.f0.n.a();
                aVar.o(R.color.CAM_X0302);
                aVar.g(UtilHelper.getDimenPixelSize(R.dimen.tbds28));
                aVar.i(R.drawable.icon_pure_add12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
                aVar.f(UtilHelper.getDimenPixelSize(R.dimen.tbds11));
                followUserButton.setConfig(aVar);
                followUserButton.setText(this.f64617a.f64607b.getString(R.string.attention));
                followUserButton.setOnClickListener(new a(this, aVar, followUserButton));
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0207).setShapeRadius(l.g(this.f64617a.f64607b, R.dimen.tbds21)).setShadowColor(R.color.CAM_X0803).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.f64617a.f64607b, R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(this.f64617a.f64607b, R.dimen.tbds5)).into(findViewById);
                return inflate;
            }
            return (View) invokeL.objValue;
        }

        @Override // d.a.d.e.g.b
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // d.a.d.e.g.b
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f64621e;

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
            this.f64621e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f64621e.f64606a == null) {
                return;
            }
            this.f64621e.f64606a.e(this.f64621e.f64608c);
            this.f64621e.f64608c.setVisibility(8);
        }
    }

    /* loaded from: classes8.dex */
    public class e implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f64622a;

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
            this.f64622a = cVar;
        }

        @Override // d.a.d.e.g.d.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f64622a.f64606a = null;
                this.f64622a.f64612g.removeCallbacks(this.f64622a.f64613h);
            }
        }

        @Override // d.a.d.e.g.d.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements d.a.d.e.g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f64623a;

        /* loaded from: classes8.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f64624e;

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
                this.f64624e = fVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (MessageManager.getInstance().findTask(2002015) != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("_forumId", this.f64624e.f64623a.j);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(TbadkCoreApplication.getInst().getApplicationContext(), "ForumAppealPage", hashMap)));
                    }
                    if (this.f64624e.f64623a.f64613h != null) {
                        this.f64624e.f64623a.f64612g.removeCallbacks(this.f64624e.f64623a.f64613h);
                        this.f64624e.f64623a.f64612g.postDelayed(this.f64624e.f64623a.f64613h, 1000L);
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
            this.f64623a = cVar;
        }

        @Override // d.a.d.e.g.b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 3;
            }
            return invokeV.intValue;
        }

        @Override // d.a.d.e.g.b
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 32;
            }
            return invokeV.intValue;
        }

        @Override // d.a.d.e.g.b
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                View inflate = layoutInflater.inflate(R.layout.frs_guide_delete_thread_tip, (ViewGroup) null);
                EMTextView eMTextView = (EMTextView) inflate.findViewById(R.id.frs_guide_delete_thread_tip_describe);
                SkinManager.setViewTextColor(eMTextView, R.color.CAM_X0302);
                eMTextView.setText(this.f64623a.f64614i);
                TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) inflate.findViewById(R.id.frs_guide_delete_thread_tip_button);
                d.a.p0.s.f0.n.b bVar = new d.a.p0.s.f0.n.b();
                bVar.o(R.color.CAM_X0302, R.color.CAM_X0101);
                tBSpecificationBtn.setConfig(bVar);
                tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getString(R.string.frs_guide_delete_thread_tip_button));
                tBSpecificationBtn.setOnClickListener(new a(this));
                return inflate;
            }
            return (View) invokeL.objValue;
        }

        @Override // d.a.d.e.g.b
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // d.a.d.e.g.b
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
        this.f64612g = new Handler();
        this.f64607b = activity;
        this.f64608c = (ViewGroup) activity.findViewById(i2);
    }

    public final d.a.d.e.g.b k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new C1738c(this) : (d.a.d.e.g.b) invokeV.objValue;
    }

    public final d.a.d.e.g.b l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new f(this) : (d.a.d.e.g.b) invokeV.objValue;
    }

    public void m() {
        d.a.d.e.g.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (cVar = this.f64606a) == null) {
            return;
        }
        cVar.e(this.f64608c);
        this.f64608c.setVisibility(8);
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f64611f = str;
        }
    }

    public void o(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f64609d = onClickListener;
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f64614i = str;
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
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (viewGroup = this.f64608c) == null) {
            return;
        }
        viewGroup.setVisibility(0);
        d.a.d.e.g.c cVar = this.f64606a;
        if (cVar != null) {
            cVar.e(this.f64608c);
        }
        this.f64613h = new d(this);
        d.a.d.e.g.d dVar = new d.a.d.e.g.d();
        dVar.d(true);
        dVar.g(new e(this));
        if (this.f64610e == null) {
            this.f64610e = l();
        }
        dVar.a(this.f64610e);
        dVar.e(R.anim.frs_guide_tip_enter);
        dVar.f(R.anim.frs_guide_tip_out);
        d.a.d.e.g.c b2 = dVar.b();
        this.f64606a = b2;
        b2.q(this.f64607b, this.f64608c, false);
        d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(this.f64608c);
        d2.n(R.string.J_X05);
        d2.s(R.array.S_O_X004);
        d2.f(R.color.CAM_X0207);
        this.f64612g.postDelayed(this.f64613h, 5000L);
    }

    public void s() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (viewGroup = this.f64608c) == null) {
            return;
        }
        viewGroup.setVisibility(0);
        d.a.d.e.g.c cVar = this.f64606a;
        if (cVar != null) {
            cVar.e(this.f64608c);
        }
        this.f64613h = new a(this);
        d.a.d.e.g.d dVar = new d.a.d.e.g.d();
        dVar.d(true);
        dVar.g(new b(this));
        if (this.f64610e == null) {
            this.f64610e = k();
        }
        dVar.a(this.f64610e);
        dVar.e(R.anim.frs_guide_tip_enter);
        dVar.f(R.anim.frs_guide_tip_out);
        d.a.d.e.g.c b2 = dVar.b();
        this.f64606a = b2;
        b2.q(this.f64607b, this.f64608c, false);
        this.f64612g.postDelayed(this.f64613h, PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
    }
}
