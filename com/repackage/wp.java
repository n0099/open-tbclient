package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.afd.videopaster.data.VideoPasterRequestData;
import com.baidu.afd.videopaster.data.VideoPasterResponseData;
import com.baidu.afd.videopaster.view.VideoPasterContentView;
import com.baidu.afd.videopaster.view.VideoPasterOverlayView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.zp;
/* loaded from: classes7.dex */
public class wp {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup a;
    public VideoPasterContentView b;
    public View c;
    public zp d;
    public d e;
    public bq f;
    public xp g;
    public Context h;
    public String i;
    public int j;
    public int k;
    public int l;
    public int m;
    public boolean n;
    public boolean o;

    /* loaded from: classes7.dex */
    public class a implements zp.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wp a;

        public a(wp wpVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wpVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wpVar;
        }

        @Override // com.repackage.zp.b
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                this.a.g = null;
            }
        }

        @Override // com.repackage.zp.b
        public void b(xp xpVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xpVar) == null) {
                this.a.g = xpVar;
                this.a.w(xpVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements VideoPasterOverlayView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wp a;

        public b(wp wpVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wpVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wpVar;
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f.b(this.a.p());
                ed7.h(this.a.g);
                if (this.a.g != null) {
                    int d = na8.d(this.a.h, this.a.g.e, this.a.g.c, this.a.g.m, null);
                    wp wpVar = this.a;
                    wpVar.x(wpVar.p(), d);
                }
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.f.k(this.a.p());
                if (this.a.e != null) {
                    this.a.e.b();
                }
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.f.j(this.a.p());
                ed7.h(this.a.g);
                if (this.a.g != null) {
                    int d = na8.d(this.a.h, this.a.g.e, this.a.g.c, this.a.g.m, null);
                    wp wpVar = this.a;
                    wpVar.x(wpVar.p(), d);
                }
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.a.n = true;
                this.a.t();
                this.a.f.g(this.a.p());
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.a.f.e(this.a.p());
                ed7.h(this.a.g);
                if (this.a.g != null) {
                    int d = na8.d(this.a.h, this.a.g.e, this.a.g.c, this.a.g.m, null);
                    wp wpVar = this.a;
                    wpVar.x(wpVar.p(), d);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements VideoPasterContentView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wp a;

        public c(wp wpVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wpVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wpVar;
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.u();
                if (this.a.e != null) {
                    this.a.e.a();
                }
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.g
        public void onDetachedFromWindow() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                boolean z = true;
                if (this.a.b.s()) {
                    i = 0;
                } else if (this.a.n) {
                    this.a.n = false;
                    i = 1;
                } else {
                    i = 2;
                }
                if (this.a.e != null) {
                    if (i == 0 || i == 1) {
                        this.a.H(i);
                    } else {
                        z = false;
                    }
                    if (this.a.e.d()) {
                        return;
                    }
                    if (this.a.o) {
                        this.a.o = false;
                    } else if (z) {
                    } else {
                        this.a.H(i);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface d {
        void a();

        void b();

        void c();

        boolean d();
    }

    public wp(Context context, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = false;
        this.o = false;
        this.h = context;
        this.a = viewGroup;
        this.f = new bq();
        zp zpVar = new zp();
        this.d = zpVar;
        zpVar.j(new a(this));
        VideoPasterContentView videoPasterContentView = new VideoPasterContentView(context);
        this.b = videoPasterContentView;
        videoPasterContentView.setOverlayViewCallback(new b(this));
        this.b.setContentViewCallback(new c(this));
        View view2 = new View(this.h);
        this.c = view2;
        view2.setBackgroundResource(R.color.black_alpha100);
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.x();
            if (r()) {
                int curDuration = this.b.getCurDuration();
                this.j = curDuration;
                this.l = curDuration;
                this.f.h(p());
            }
        }
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.o = z;
        }
    }

    public void C(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.e = dVar;
        }
    }

    public final boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            VideoPasterContentView videoPasterContentView = this.b;
            if (videoPasterContentView != null) {
                int[] iArr = new int[2];
                videoPasterContentView.getLocationOnScreen(iArr);
                int i = iArr[1];
                if (UtilHelper.getRealScreenOrientation(this.h) == 1 && i == 0 && TextUtils.equals(this.i, "VIDEO_LIST")) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean E(boolean z, boolean z2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str})) == null) {
            if (this.d.f()) {
                return false;
            }
            this.i = str;
            VideoPasterResponseData e = this.d.e();
            if (e == null) {
                return false;
            }
            xp pasterData = e.getPasterData();
            if (pasterData == null) {
                this.d.i();
                return false;
            } else if (pasterData.c()) {
                this.f.i(p());
                this.d.i();
                return false;
            } else if (!pasterData.d()) {
                this.d.i();
                return false;
            } else {
                this.a.removeView(this.c);
                this.a.addView(this.c);
                this.a.removeView(this.b);
                this.a.addView(this.b);
                ViewGroup viewGroup = this.a;
                if (viewGroup instanceof FrameLayout) {
                    this.b.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                } else if (viewGroup instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    this.b.setLayoutParams(layoutParams);
                }
                this.b.setData(pasterData);
                this.j = this.b.getCurDuration();
                if (!q()) {
                    this.f.i(p());
                    ed7.g(this.g);
                }
                this.b.A(z, z2, str);
                d dVar = this.e;
                if (dVar != null) {
                    dVar.c();
                    return true;
                }
                return true;
            }
        }
        return invokeCommon.booleanValue;
    }

    public void F(tp tpVar) {
        zp zpVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, tpVar) == null) || (zpVar = this.d) == null || zpVar.f() || this.d.e() != null || tpVar == null) {
            return;
        }
        this.m = tpVar.a() + 1;
        this.d.g(new VideoPasterRequestData(tpVar));
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.k = this.b.getCurDuration();
            if (r() && !D()) {
                this.f.g(p());
            }
            this.b.z();
        }
    }

    public final void H(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.f.c(p(), i);
            if (TextUtils.equals(this.i, "VIDEO_LIST") && i == 2) {
                this.f.g(p());
            }
        }
    }

    public aq p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            aq aqVar = new aq();
            aqVar.g = this.j;
            aqVar.e = this.b.getTotalDuration();
            aqVar.f = this.b.getCurDuration();
            aqVar.c = this.m;
            if (UtilHelper.getRealScreenOrientation(this.h) == 1) {
                aqVar.h = 0;
            } else if (UtilHelper.getRealScreenOrientation(this.h) == 2) {
                aqVar.h = 1;
            } else if (UtilHelper.getRealScreenOrientation(this.h) == 0) {
                aqVar.h = 2;
            } else {
                aqVar.h = -1;
            }
            xp xpVar = this.g;
            if (xpVar != null) {
                aqVar.i = xpVar.a();
                xp xpVar2 = this.g;
                aqVar.j = xpVar2.b;
                aqVar.d = xpVar2.m;
                aqVar.k = xpVar2.o;
                aqVar.l = xpVar2.p;
            }
            return aqVar;
        }
        return (aq) invokeV.objValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.b.q() : invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.b.r() : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            VideoPasterContentView videoPasterContentView = this.b;
            return videoPasterContentView != null && videoPasterContentView.t();
        }
        return invokeV.booleanValue;
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            z();
            d dVar = this.e;
            if (dVar != null) {
                dVar.a();
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f.f(p());
            z();
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.d.h();
        }
    }

    public final void w(xp xpVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, xpVar) == null) && xpVar != null && xpVar.n) {
            this.f.d(p());
        }
    }

    public final void x(aq aqVar, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048592, this, aqVar, i) == null) && na8.q(i)) {
            this.f.l(aqVar, i);
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            z();
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.d.i();
            this.b.v();
            this.a.removeView(this.b);
            this.a.removeView(this.c);
        }
    }
}
