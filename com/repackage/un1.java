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
import com.repackage.ny1;
import com.repackage.sn1;
import com.repackage.xo2;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes7.dex */
public class un1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile un1 i;
    public transient /* synthetic */ FieldHolder $fh;
    public PopupWindow a;
    public Timer b;
    public SwanAppActivity c;
    public ny1 d;
    public ContentObserver e;
    public ec2 f;
    public sn1 g;
    public j h;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType a;
        public final /* synthetic */ un1 b;

        public a(un1 un1Var, ShowFavoriteGuideApi.GuideType guideType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {un1Var, guideType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = un1Var;
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
        public final /* synthetic */ un1 c;

        /* loaded from: classes7.dex */
        public class a implements xo2.h {
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

            @Override // com.repackage.xo2.h
            public void onFail() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.a.c.h != null) {
                        this.a.c.h.e(false);
                    }
                    hw1.i("FavoriteGuideHelper", "add favorite result=false");
                }
            }

            @Override // com.repackage.xo2.h
            public void onSuccess() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    if (this.a.c.h != null) {
                        this.a.c.h.e(true);
                    }
                    hw1.i("FavoriteGuideHelper", "add favorite result=true");
                }
            }
        }

        public b(un1 un1Var, ShowFavoriteGuideApi.GuideType guideType, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {un1Var, guideType, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = un1Var;
            this.a = guideType;
            this.b = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                xo2.h(this.b, new a(this));
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
        public final /* synthetic */ qy1 b;
        public final /* synthetic */ py1 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ hz2 e;
        public final /* synthetic */ un1 f;

        public c(un1 un1Var, ViewTreeObserver viewTreeObserver, qy1 qy1Var, py1 py1Var, String str, hz2 hz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {un1Var, viewTreeObserver, qy1Var, py1Var, str, hz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = un1Var;
            this.a = viewTreeObserver;
            this.b = qy1Var;
            this.c = py1Var;
            this.d = str;
            this.e = hz2Var;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            py1 py1Var;
            ViewTreeObserver viewTreeObserver;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f.a != null || (viewTreeObserver = this.a) == null || !viewTreeObserver.isAlive()) {
                    if (this.f.d != this.b.m() || (!((py1Var = this.c) == null || TextUtils.equals(this.d, py1Var.s3())) || (!this.e.v0() && yc3.J()))) {
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
        public final /* synthetic */ hz2 a;
        public final /* synthetic */ un1 b;

        public d(un1 un1Var, hz2 hz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {un1Var, hz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = un1Var;
            this.a = hz2Var;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.k();
                if (this.b.h != null) {
                    this.b.h.e(f62.n(this.a.b));
                }
                if (this.b.b != null) {
                    this.b.b.cancel();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements sn1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ un1 a;

        public e(un1 un1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {un1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = un1Var;
        }

        @Override // com.repackage.sn1.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.k();
            }
        }

        @Override // com.repackage.sn1.a
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
        public final /* synthetic */ hz2 a;
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType b;
        public final /* synthetic */ un1 c;

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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && f62.n(this.a.a.b)) {
                    f fVar = this.a;
                    if (fVar.b == ShowFavoriteGuideApi.GuideType.NORMAL && fVar.c.h != null) {
                        this.a.c.h.e(true);
                    }
                    this.a.c.k();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(un1 un1Var, Handler handler, hz2 hz2Var, ShowFavoriteGuideApi.GuideType guideType) {
            super(handler);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {un1Var, handler, hz2Var, guideType};
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
            this.c = un1Var;
            this.a = hz2Var;
            this.b = guideType;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.onChange(z);
                bc3.h().execute(new a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends ec2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hz2 a;
        public final /* synthetic */ un1 b;

        public g(un1 un1Var, hz2 hz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {un1Var, hz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = un1Var;
            this.a = hz2Var;
        }

        @Override // com.repackage.ec2, com.repackage.fc2
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a != null && this.b.a.y()) {
                this.b.k();
            }
        }

        @Override // com.repackage.ec2, com.repackage.fc2
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                hw1.i("FavoriteGuideHelper", "call onActivityDestroyed");
                this.b.k();
                if (this.b.c == null || this.b.f == null) {
                    return;
                }
                this.b.c.unregisterCallback(this.b.f);
            }
        }

        @Override // com.repackage.ec2, com.repackage.fc2
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.e();
                hw1.i("FavoriteGuideHelper", "swanId=" + this.a.b + ", nowId=" + hz2.f0());
                if (TextUtils.equals(this.a.b, hz2.f0())) {
                    return;
                }
                this.b.k();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements ny1.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ un1 a;

        public h(un1 un1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {un1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = un1Var;
        }

        @Override // com.repackage.ny1.p
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
        public final /* synthetic */ un1 a;

        public i(un1 un1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {un1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = un1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.a != null) {
                    this.a.a.s();
                    this.a.a = null;
                }
                if (this.a.e != null) {
                    AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(this.a.e);
                    this.a.e = null;
                }
                if (this.a.c != null && this.a.f != null) {
                    this.a.c.unregisterCallback(this.a.f);
                }
                if (this.a.d != null) {
                    this.a.d.E2(null);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface j {
        void e(boolean z);
    }

    public un1() {
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

    public static un1 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (i == null) {
                synchronized (un1.class) {
                    if (i == null) {
                        i = new un1();
                    }
                }
            }
            return i;
        }
        return (un1) invokeV.objValue;
    }

    @AnyThread
    public final synchronized void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                bd3.e0(new i(this));
            }
        }
    }

    public final void m() {
        tg1 k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.g == null && (k = pi2.k()) != null) {
            sn1 a2 = k.a();
            this.g = a2;
            if (a2 != null) {
                a2.b(new e(this));
            }
        }
    }

    public boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? TextUtils.isEmpty(str) || ShowFavoriteGuideApi.GuideType.parse(str) == ShowFavoriteGuideApi.GuideType.NORMAL : invokeL.booleanValue;
    }

    public final synchronized void o(@NonNull Activity activity, @NonNull hz2 hz2Var, ShowFavoriteGuideApi.GuideType guideType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, activity, hz2Var, guideType) == null) {
            synchronized (this) {
                this.e = new f(this, null, hz2Var, guideType);
                AppRuntime.getAppContext().getContentResolver().registerContentObserver(f62.d(), false, this.e);
                if (activity instanceof SwanAppActivity) {
                    SwanAppActivity swanAppActivity = (SwanAppActivity) activity;
                    this.c = swanAppActivity;
                    if (this.f != null) {
                        swanAppActivity.unregisterCallback(this.f);
                    }
                    g gVar = new g(this, hz2Var);
                    this.f = gVar;
                    this.c.registerCallback(gVar);
                }
                qy1 swanAppFragmentManager = this.c.getSwanAppFragmentManager();
                if (swanAppFragmentManager == null) {
                    return;
                }
                ny1 m = swanAppFragmentManager.m();
                this.d = m;
                if (m == null) {
                    return;
                }
                m.E2(new h(this));
            }
        }
    }

    @UiThread
    public void p(@Nullable j jVar, @NonNull Activity activity, @NonNull hz2 hz2Var, @NonNull ShowFavoriteGuideApi.GuideType guideType, @Nullable String str, @Nullable String str2, long j2) {
        SwanAppActivity swanAppActivity;
        qy1 swanAppFragmentManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{jVar, activity, hz2Var, guideType, str, str2, Long.valueOf(j2)}) == null) {
            String str3 = str;
            this.h = jVar;
            k();
            if (hz2Var.v0()) {
                m();
                sn1 sn1Var = this.g;
                if (sn1Var != null) {
                    sn1Var.c(0);
                }
            }
            o(activity, hz2Var, guideType);
            View inflate = LayoutInflater.from(activity).inflate(guideType == ShowFavoriteGuideApi.GuideType.TIPS ? R.layout.obfuscated_res_0x7f0d00a3 : R.layout.obfuscated_res_0x7f0d00a2, (ViewGroup) null, false);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090966);
            if (textView != null && str3 != null) {
                if (guideType.limit != -1 && str.length() > guideType.limit) {
                    str3 = str3.substring(0, guideType.limit - 1) + StringHelper.STRING_MORE;
                }
                textView.setText(str3);
            }
            View findViewById = activity.findViewById(R.id.obfuscated_res_0x7f09205b);
            if (guideType != ShowFavoriteGuideApi.GuideType.TIPS) {
                RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090965);
                ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
                int i2 = guideType.showWidth4px;
                int g2 = yc3.g(7.0f);
                int o = yc3.o(null);
                int i3 = g2 * 2;
                if (o - i2 < i3) {
                    i2 = o - i3;
                }
                layoutParams.width = i2;
                relativeLayout.setLayoutParams(layoutParams);
                bd3.X((ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090967), str2, R.drawable.obfuscated_res_0x7f08013f);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090964);
                if (guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
                    imageView.setVisibility(8);
                } else {
                    imageView.setOnClickListener(new a(this, guideType));
                }
                ((Button) inflate.findViewById(R.id.obfuscated_res_0x7f090962)).setOnClickListener(new b(this, guideType, activity));
                PopupWindow popupWindow = new PopupWindow(inflate, -1, -2);
                this.a = popupWindow;
                popupWindow.L(16);
                this.a.O(activity.getWindow().getDecorView(), 81, 0, (int) yc3.h(50.0f));
            } else if (findViewById != null) {
                int[] iArr = new int[2];
                findViewById.getLocationOnScreen(iArr);
                inflate.findViewById(R.id.obfuscated_res_0x7f090963).setPadding(0, 0, ((yc3.o(null) - iArr[0]) - (findViewById.getWidth() / 2)) - yc3.g(7.0f), 0);
                this.a = new PopupWindow(inflate, -2, -2);
                SwanAppActivity swanAppActivity2 = this.c;
                if (swanAppActivity2 != null && !swanAppActivity2.isFinishing() && !this.c.isDestroyed() && findViewById.isAttachedToWindow()) {
                    try {
                        this.a.N(findViewById, 0, -yc3.g(3.0f));
                    } catch (WindowManager.BadTokenException e2) {
                        if (rf1.a) {
                            Log.e("FavoriteGuideHelper", "Bad token when showing fav guide popup!");
                            e2.printStackTrace();
                        }
                    }
                }
            }
            if ((guideType == ShowFavoriteGuideApi.GuideType.NORMAL || guideType == ShowFavoriteGuideApi.GuideType.TIPS) && (swanAppActivity = this.c) != null && (swanAppFragmentManager = swanAppActivity.getSwanAppFragmentManager()) != null && findViewById != null) {
                py1 l = swanAppFragmentManager.l();
                String s3 = l == null ? "" : l.s3();
                ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
                viewTreeObserver.addOnGlobalLayoutListener(new c(this, viewTreeObserver, swanAppFragmentManager, l, s3, hz2Var));
            }
            if (guideType == ShowFavoriteGuideApi.GuideType.TIPS || guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
                Timer timer = this.b;
                if (timer != null) {
                    timer.cancel();
                }
                Timer timer2 = new Timer();
                this.b = timer2;
                timer2.schedule(new d(this, hz2Var), 1000 * j2);
            }
            ShowFavoriteGuideApi.F(guideType, "", "show");
        }
    }
}
