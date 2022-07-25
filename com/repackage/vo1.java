package com.repackage;

import android.app.Activity;
import android.database.ContentObserver;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.oz1;
import com.repackage.to1;
import com.repackage.yp2;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes7.dex */
public class vo1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vo1 i;
    public transient /* synthetic */ FieldHolder $fh;
    public PopupWindow a;
    public Timer b;
    public SwanAppActivity c;
    public oz1 d;
    public ContentObserver e;
    public fd2 f;
    public to1 g;
    public j h;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType a;
        public final /* synthetic */ vo1 b;

        public a(vo1 vo1Var, ShowFavoriteGuideApi.GuideType guideType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vo1Var, guideType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vo1Var;
            this.a = guideType;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.k();
                if (this.b.h != null) {
                    this.b.h.e(false);
                }
                ShowFavoriteGuideApi.F(this.a, "flow_close_close", "click");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ vo1 c;

        /* loaded from: classes7.dex */
        public class a implements yp2.h {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // com.repackage.yp2.h
            public void onFail() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.a.c.h != null) {
                        this.a.c.h.e(false);
                    }
                    ix1.i("FavoriteGuideHelper", "add favorite result=false");
                }
            }

            @Override // com.repackage.yp2.h
            public void onSuccess() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    if (this.a.c.h != null) {
                        this.a.c.h.e(true);
                    }
                    ix1.i("FavoriteGuideHelper", "add favorite result=true");
                }
            }
        }

        public b(vo1 vo1Var, ShowFavoriteGuideApi.GuideType guideType, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vo1Var, guideType, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = vo1Var;
            this.a = guideType;
            this.b = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                yp2.h(this.b, new a(this));
                this.c.k();
                if (this.c.b != null) {
                    this.c.b.cancel();
                }
                ShowFavoriteGuideApi.GuideType guideType = this.a;
                ShowFavoriteGuideApi.F(guideType, guideType == ShowFavoriteGuideApi.GuideType.WEAK ? "flow_add" : "flow_close_add", "click");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewTreeObserver a;
        public final /* synthetic */ rz1 b;
        public final /* synthetic */ qz1 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ i03 e;
        public final /* synthetic */ vo1 f;

        public c(vo1 vo1Var, ViewTreeObserver viewTreeObserver, rz1 rz1Var, qz1 qz1Var, String str, i03 i03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vo1Var, viewTreeObserver, rz1Var, qz1Var, str, i03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = vo1Var;
            this.a = viewTreeObserver;
            this.b = rz1Var;
            this.c = qz1Var;
            this.d = str;
            this.e = i03Var;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            qz1 qz1Var;
            ViewTreeObserver viewTreeObserver;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f.a != null || (viewTreeObserver = this.a) == null || !viewTreeObserver.isAlive()) {
                    if (this.f.d != this.b.m() || (!((qz1Var = this.c) == null || TextUtils.equals(this.d, qz1Var.t3())) || (!this.e.w0() && zd3.J()))) {
                        this.f.k();
                        ViewTreeObserver viewTreeObserver2 = this.a;
                        if (viewTreeObserver2 == null || !viewTreeObserver2.isAlive()) {
                            return;
                        }
                        this.a.removeOnGlobalLayoutListener(this);
                        return;
                    }
                    return;
                }
                this.a.removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i03 a;
        public final /* synthetic */ vo1 b;

        public d(vo1 vo1Var, i03 i03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vo1Var, i03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vo1Var;
            this.a = i03Var;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.k();
                if (this.b.h != null) {
                    this.b.h.e(g72.n(this.a.b));
                }
                if (this.b.b != null) {
                    this.b.b.cancel();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements to1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vo1 a;

        public e(vo1 vo1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vo1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vo1Var;
        }

        @Override // com.repackage.to1.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.k();
            }
        }

        @Override // com.repackage.to1.a
        public void b(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && i == 1) {
                this.a.k();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i03 a;
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType b;
        public final /* synthetic */ vo1 c;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && g72.n(this.a.a.b)) {
                    f fVar = this.a;
                    if (fVar.b == ShowFavoriteGuideApi.GuideType.NORMAL && fVar.c.h != null) {
                        this.a.c.h.e(true);
                    }
                    this.a.c.k();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(vo1 vo1Var, Handler handler, i03 i03Var, ShowFavoriteGuideApi.GuideType guideType) {
            super(handler);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vo1Var, handler, i03Var, guideType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Handler) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = vo1Var;
            this.a = i03Var;
            this.b = guideType;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.onChange(z);
                cd3.h().execute(new a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends fd2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i03 a;
        public final /* synthetic */ vo1 b;

        public g(vo1 vo1Var, i03 i03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vo1Var, i03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vo1Var;
            this.a = i03Var;
        }

        @Override // com.repackage.fd2, com.repackage.gd2
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a != null && this.b.a.x()) {
                this.b.k();
            }
        }

        @Override // com.repackage.fd2, com.repackage.gd2
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ix1.i("FavoriteGuideHelper", "call onActivityDestroyed");
                this.b.k();
                if (this.b.c == null || this.b.f == null) {
                    return;
                }
                this.b.c.F0(this.b.f);
            }
        }

        @Override // com.repackage.fd2, com.repackage.gd2
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.e();
                ix1.i("FavoriteGuideHelper", "swanId=" + this.a.b + ", nowId=" + i03.g0());
                if (TextUtils.equals(this.a.b, i03.g0())) {
                    return;
                }
                this.b.k();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements oz1.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vo1 a;

        public h(vo1 vo1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vo1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vo1Var;
        }

        @Override // com.repackage.oz1.p
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.k();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vo1 a;

        public i(vo1 vo1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vo1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vo1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.a != null) {
                    this.a.a.r();
                    this.a.a = null;
                }
                if (this.a.e != null) {
                    AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(this.a.e);
                    this.a.e = null;
                }
                if (this.a.c != null && this.a.f != null) {
                    this.a.c.F0(this.a.f);
                }
                if (this.a.d != null) {
                    this.a.d.F2(null);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface j {
        void e(boolean z);
    }

    public vo1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static vo1 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (i == null) {
                synchronized (vo1.class) {
                    if (i == null) {
                        i = new vo1();
                    }
                }
            }
            return i;
        }
        return (vo1) invokeV.objValue;
    }

    @AnyThread
    public final synchronized void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                ce3.e0(new i(this));
            }
        }
    }

    public final void m() {
        uh1 k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.g == null && (k = qj2.k()) != null) {
            to1 uh1Var = k.getInstance();
            this.g = uh1Var;
            if (uh1Var != null) {
                uh1Var.a(new e(this));
            }
        }
    }

    public boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? TextUtils.isEmpty(str) || ShowFavoriteGuideApi.GuideType.parse(str) == ShowFavoriteGuideApi.GuideType.NORMAL : invokeL.booleanValue;
    }

    public final synchronized void o(@NonNull Activity activity, @NonNull i03 i03Var, ShowFavoriteGuideApi.GuideType guideType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, activity, i03Var, guideType) == null) {
            synchronized (this) {
                this.e = new f(this, null, i03Var, guideType);
                AppRuntime.getAppContext().getContentResolver().registerContentObserver(g72.d(), false, this.e);
                if (activity instanceof SwanAppActivity) {
                    SwanAppActivity swanAppActivity = (SwanAppActivity) activity;
                    this.c = swanAppActivity;
                    if (this.f != null) {
                        swanAppActivity.F0(this.f);
                    }
                    g gVar = new g(this, i03Var);
                    this.f = gVar;
                    this.c.t0(gVar);
                }
                rz1 X = this.c.X();
                if (X == null) {
                    return;
                }
                oz1 m = X.m();
                this.d = m;
                if (m == null) {
                    return;
                }
                m.F2(new h(this));
            }
        }
    }

    @UiThread
    public void p(@Nullable j jVar, @NonNull Activity activity, @NonNull i03 i03Var, @NonNull ShowFavoriteGuideApi.GuideType guideType, @Nullable String str, @Nullable String str2, long j2) {
        SwanAppActivity swanAppActivity;
        rz1 X;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{jVar, activity, i03Var, guideType, str, str2, Long.valueOf(j2)}) == null) {
            String str3 = str;
            this.h = jVar;
            k();
            if (i03Var.w0()) {
                m();
                to1 to1Var = this.g;
                if (to1Var != null) {
                    to1Var.b(0);
                }
            }
            o(activity, i03Var, guideType);
            View inflate = LayoutInflater.from(activity).inflate(guideType == ShowFavoriteGuideApi.GuideType.TIPS ? R.layout.obfuscated_res_0x7f0d00a2 : R.layout.obfuscated_res_0x7f0d00a1, (ViewGroup) null, false);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090954);
            if (textView != null && str3 != null) {
                if (guideType.limit != -1 && str.length() > guideType.limit) {
                    str3 = str3.substring(0, guideType.limit - 1) + StringHelper.STRING_MORE;
                }
                textView.setText(str3);
            }
            View findViewById = activity.findViewById(R.id.obfuscated_res_0x7f092103);
            if (guideType != ShowFavoriteGuideApi.GuideType.TIPS) {
                RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090953);
                ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
                int i2 = guideType.showWidth4px;
                int g2 = zd3.g(7.0f);
                int o = zd3.o(null);
                int i3 = g2 * 2;
                if (o - i2 < i3) {
                    i2 = o - i3;
                }
                layoutParams.width = i2;
                relativeLayout.setLayoutParams(layoutParams);
                ce3.X((ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090955), str2, R.drawable.obfuscated_res_0x7f08013e);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090952);
                if (guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
                    imageView.setVisibility(8);
                } else {
                    imageView.setOnClickListener(new a(this, guideType));
                }
                ((Button) inflate.findViewById(R.id.obfuscated_res_0x7f090950)).setOnClickListener(new b(this, guideType, activity));
                PopupWindow popupWindow = new PopupWindow(inflate, -1, -2);
                this.a = popupWindow;
                popupWindow.L(16);
                this.a.O(activity.getWindow().getDecorView(), 81, 0, (int) zd3.h(50.0f));
            } else if (findViewById != null) {
                int[] iArr = new int[2];
                findViewById.getLocationOnScreen(iArr);
                inflate.findViewById(R.id.obfuscated_res_0x7f090951).setPadding(0, 0, ((zd3.o(null) - iArr[0]) - (findViewById.getWidth() / 2)) - zd3.g(7.0f), 0);
                this.a = new PopupWindow(inflate, -2, -2);
                SwanAppActivity swanAppActivity2 = this.c;
                if (swanAppActivity2 != null && !swanAppActivity2.isFinishing() && !this.c.isDestroyed() && findViewById.isAttachedToWindow()) {
                    try {
                        this.a.N(findViewById, 0, -zd3.g(3.0f));
                    } catch (WindowManager.BadTokenException e2) {
                        if (sg1.a) {
                            Log.e("FavoriteGuideHelper", "Bad token when showing fav guide popup!");
                            e2.printStackTrace();
                        }
                    }
                }
            }
            if ((guideType == ShowFavoriteGuideApi.GuideType.NORMAL || guideType == ShowFavoriteGuideApi.GuideType.TIPS) && (swanAppActivity = this.c) != null && (X = swanAppActivity.X()) != null && findViewById != null) {
                qz1 l = X.l();
                String t3 = l == null ? "" : l.t3();
                ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
                viewTreeObserver.addOnGlobalLayoutListener(new c(this, viewTreeObserver, X, l, t3, i03Var));
            }
            if (guideType == ShowFavoriteGuideApi.GuideType.TIPS || guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
                Timer timer = this.b;
                if (timer != null) {
                    timer.cancel();
                }
                Timer timer2 = new Timer();
                this.b = timer2;
                timer2.schedule(new d(this, i03Var), 1000 * j2);
            }
            ShowFavoriteGuideApi.F(guideType, "", "show");
        }
    }
}
