package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import com.baidu.swan.apps.view.SwanAppWebPopWindow;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bu2;
import com.repackage.bz2;
import com.repackage.cz2;
import com.repackage.d02;
import com.repackage.qz1;
import com.repackage.rl2;
import com.repackage.yz2;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class xz1 extends a02 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean Q0;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppRoundedImageView F0;
    public BdBaseImageView G0;
    public TextView H0;
    public rf3 I0;
    public long[] J0;
    public String K0;
    public String L0;
    public String M0;
    public Button N0;
    public RecyclerView O0;
    public SwanAppWebPopWindow P0;

    /* loaded from: classes7.dex */
    public class a implements cl3<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h93 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ xz1 c;

        /* renamed from: com.repackage.xz1$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class DialogInterface$OnClickListenerC0555a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public DialogInterface$OnClickListenerC0555a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                    SwanAppActivity x = t03.J().x();
                    if (x != null && Build.VERSION.SDK_INT >= 21) {
                        x.finishAndRemoveTask();
                    }
                    System.exit(0);
                }
            }
        }

        public a(xz1 xz1Var, h93 h93Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz1Var, h93Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xz1Var;
            this.a = h93Var;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.cl3
        /* renamed from: a */
        public void run(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool != null && bool.booleanValue()) {
                    this.a.putInt(this.b, 1);
                } else {
                    this.a.putInt(this.b, 0);
                }
                yz2.a aVar = new yz2.a(this.c.i0);
                aVar.U(R.string.obfuscated_res_0x7f0f126f);
                aVar.v(R.string.obfuscated_res_0x7f0f126e);
                aVar.n(new cg3());
                aVar.O(R.string.obfuscated_res_0x7f0f0112, new DialogInterface$OnClickListenerC0555a(this));
                aVar.X();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h93 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cl3 c;
        public final /* synthetic */ xz1 d;

        /* loaded from: classes7.dex */
        public class a implements qz1.b {
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

            @Override // com.repackage.qz1.b
            public void a(boolean z, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                    if (z) {
                        this.a.c.run(Boolean.TRUE);
                        return;
                    }
                    Activity activity = this.a.d.i0;
                    if (activity == null || activity.isDestroyed()) {
                        return;
                    }
                    qz1.b(this.a.d.i0, R.string.obfuscated_res_0x7f0f126f, str);
                }
            }
        }

        public b(xz1 xz1Var, h93 h93Var, String str, cl3 cl3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz1Var, h93Var, str, cl3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = xz1Var;
            this.a = h93Var;
            this.b = str;
            this.c = cl3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int i = this.a.getInt(this.b, -1);
                if (i == 1) {
                    this.c.run(Boolean.FALSE);
                } else if (i == 0) {
                    this.c.run(Boolean.TRUE);
                } else {
                    u03 a0 = u03.a0();
                    if (a0 == null) {
                        return;
                    }
                    qz1.a(a0, this.d.i0, new a(this));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View.OnLongClickListener a;
        public final /* synthetic */ View b;
        public final /* synthetic */ xz1 c;

        public c(xz1 xz1Var, View.OnLongClickListener onLongClickListener, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz1Var, onLongClickListener, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xz1Var;
            this.a = onLongClickListener;
            this.b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                jb3.d().g();
                this.a.onLongClick(this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Runnable a;
        public final /* synthetic */ long b;
        public final /* synthetic */ xz1 c;

        public d(xz1 xz1Var, Runnable runnable, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz1Var, runnable, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xz1Var;
            this.a = runnable;
            this.b = j;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    view2.postDelayed(this.a, this.b);
                    return false;
                } else if (action == 1 || action == 3) {
                    view2.removeCallbacks(this.a);
                    return false;
                } else {
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e implements cz2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppRelatedSwanListAdapter a;
        public final /* synthetic */ xz1 b;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ bz2 a;
            public final /* synthetic */ e b;

            public a(e eVar, bz2 bz2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, bz2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = eVar;
                this.a = bz2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.b.O0.setVisibility(0);
                    this.b.a.e(this.a);
                }
            }
        }

        public e(xz1 xz1Var, SwanAppRelatedSwanListAdapter swanAppRelatedSwanListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz1Var, swanAppRelatedSwanListAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xz1Var;
            this.a = swanAppRelatedSwanListAdapter;
        }

        @Override // com.repackage.cz2.b
        public void a(bz2 bz2Var) {
            List<bz2.a> list;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bz2Var) == null) || bz2Var == null || (list = bz2Var.a) == null || list.size() <= 0) {
                return;
            }
            oe3.e0(new a(this, bz2Var));
            SwanAppRelatedSwanListAdapter.d("aboutrelated", null, "show");
        }
    }

    /* loaded from: classes7.dex */
    public class f implements qz1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz1 a;

        /* loaded from: classes7.dex */
        public class a implements nf3<Boolean> {
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

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.nf3
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    if (bool.booleanValue()) {
                        rx1.d(this.a.a.getContext());
                    } else {
                        ck2.h().a(this.a.a.i0, null);
                    }
                }
            }
        }

        public f(xz1 xz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz1Var;
        }

        @Override // com.repackage.qz1.b
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (!z) {
                    qz1.c(this.a.i0, str);
                } else if (rx1.a()) {
                    rx1.d(this.a.getContext());
                } else {
                    ck2.h().f(new a(this));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements oc2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz1 a;

        public g(xz1 xz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz1Var;
        }

        @Override // com.repackage.oc2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                m03 f = m03.f(this.a.getContext(), R.string.obfuscated_res_0x7f0f1305);
                f.l(2);
                f.G();
            }
        }

        @Override // com.repackage.oc2
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                m03 f = m03.f(this.a.getContext(), R.string.obfuscated_res_0x7f0f010c);
                f.l(2);
                f.G();
            }
        }

        @Override // com.repackage.oc2
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || z) {
                return;
            }
            m03 f = m03.f(this.a.getContext(), R.string.obfuscated_res_0x7f0f010b);
            f.l(2);
            f.G();
        }
    }

    /* loaded from: classes7.dex */
    public class h implements nc2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ xz1 b;

        public h(xz1 xz1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xz1Var;
            this.a = str;
        }

        @Override // com.repackage.nc2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                m03 f = m03.f(this.b.getContext(), R.string.obfuscated_res_0x7f0f1305);
                f.l(2);
                f.G();
            }
        }

        @Override // com.repackage.nc2
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || z) {
                return;
            }
            m03 f = m03.f(this.b.getContext(), R.string.obfuscated_res_0x7f0f0154);
            f.l(2);
            f.G();
        }

        @Override // com.repackage.nc2
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                s72.t();
                if (kq2.k(this.b.getActivity())) {
                    kq2.p("aboutconcern", this.a);
                    return;
                }
                Context context = this.b.getContext();
                m03 g = m03.g(context, bk2.l0().f(context));
                g.l(2);
                g.q(2);
                g.G();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz1 a;

        public i(xz1 xz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.w3();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FullScreenFloatView a;
        public final /* synthetic */ xz1 b;

        /* loaded from: classes7.dex */
        public class a implements nf3<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ j a;

            public a(j jVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = jVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.nf3
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    if (bool.booleanValue()) {
                        rx1.c(this.a.b.getContext(), true);
                    } else {
                        ck2.h().a(this.a.b.i0, null);
                    }
                }
            }
        }

        public j(xz1 xz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xz1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.b.i0 == null) {
                return;
            }
            if (xz1.Q0) {
                if (u42.f()) {
                    rx1.d(this.b.getContext());
                    return;
                }
                if (this.a == null) {
                    this.a = hm2.U().n(this.b.i0);
                }
                if (this.b.X1()) {
                    if (rx1.a()) {
                        rx1.c(this.b.getContext(), false);
                        return;
                    } else {
                        ck2.h().f(new a(this));
                        return;
                    }
                }
                this.a.setVisibility(this.a.getVisibility() == 0 ? 8 : 0);
            } else if (this.b.X1()) {
                this.b.x3();
            } else {
                rx1.d(this.b.getContext());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SwanAppPropertyWindow a;
        public final /* synthetic */ xz1 b;

        public k(xz1 xz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xz1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a == null) {
                    this.a = hm2.U().J(this.b.i0);
                }
                this.a.setVisibility(this.a.getVisibility() == 0 ? 8 : 0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl2 a;
        public final /* synthetic */ u03 b;
        public final /* synthetic */ xz1 c;

        /* loaded from: classes7.dex */
        public class a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                }
            }
        }

        public l(xz1 xz1Var, rl2 rl2Var, u03 u03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz1Var, rl2Var, u03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xz1Var;
            this.a = rl2Var;
            this.b = u03Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.c.i0 == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ENABLE V8: ");
            sb.append(o72.U().r0());
            sb.append("\n");
            sb.append("APS VERSION: ");
            sb.append(TextUtils.isEmpty(this.a.v1()) ? "" : this.a.v1());
            sb.append("\n");
            sb.append("APPID VERSION: ");
            sb.append(ws1.c(this.b.b));
            sb.append("\n");
            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), this.a.i1());
            sb.append("小程序包大小: ");
            sb.append(TextUtils.isEmpty(formatFileSize) ? "" : formatFileSize);
            sb.append("(");
            sb.append(this.a.i1());
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            sb.append("\n");
            yz2.a aVar = new yz2.a(this.c.i0);
            aVar.V(this.c.i0.getResources().getString(R.string.obfuscated_res_0x7f0f01c3));
            aVar.x(sb.toString());
            aVar.n(new cg3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f0112, new a(this));
            aVar.X();
        }
    }

    /* loaded from: classes7.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz1 a;

        /* loaded from: classes7.dex */
        public class a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(m mVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                }
            }
        }

        public m(xz1 xz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.i0 == null) {
                return;
            }
            String e = y93.c().e(1);
            String string = this.a.i0.getResources().getString(R.string.obfuscated_res_0x7f0f00e5);
            yz2.a aVar = new yz2.a(this.a.i0);
            aVar.V(string);
            aVar.x(e);
            aVar.n(new cg3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f0112, new a(this));
            aVar.X();
        }
    }

    /* loaded from: classes7.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz1 a;

        /* loaded from: classes7.dex */
        public class a extends bu2.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ n a;

            /* renamed from: com.repackage.xz1$n$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class RunnableC0556a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;
                public final /* synthetic */ a b;

                public RunnableC0556a(a aVar, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, str};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = aVar;
                    this.a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        yz2.a aVar = new yz2.a(this.b.a.a.i0);
                        aVar.U(R.string.obfuscated_res_0x7f0f0146);
                        aVar.x(this.a);
                        aVar.n(new cg3());
                        aVar.m(false);
                        aVar.O(R.string.obfuscated_res_0x7f0f0112, null);
                        aVar.X();
                    }
                }
            }

            public a(n nVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = nVar;
            }

            @Override // com.repackage.bu2.a
            public void c(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.a.a.i0.runOnUiThread(new RunnableC0556a(this, str));
                }
            }
        }

        public n(xz1 xz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.i0 == null) {
                return;
            }
            bu2.e().g(new a(this));
        }
    }

    /* loaded from: classes7.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public vy1 a;
        public final /* synthetic */ xz1 b;

        /* loaded from: classes7.dex */
        public class a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ o a;

            public a(o oVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = oVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                    vy1.g(1);
                    this.a.a = new vy1(bk2.c());
                    this.a.a.h();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ o a;

            public b(o oVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = oVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                    this.a.b();
                    vy1.g(2);
                    System.exit(0);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ o a;

            public c(o oVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = oVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                    this.a.b();
                    vy1.g(0);
                }
            }
        }

        public o(xz1 xz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xz1Var;
        }

        public final void b() {
            vy1 vy1Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (vy1Var = this.a) == null) {
                return;
            }
            vy1Var.i();
            this.a = null;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                yz2.a aVar = new yz2.a(this.b.i0);
                aVar.U(R.string.obfuscated_res_0x7f0f0148);
                aVar.v(R.string.obfuscated_res_0x7f0f0134);
                aVar.n(new cg3());
                aVar.m(true);
                if (vy1.e() == 0) {
                    aVar.O(R.string.obfuscated_res_0x7f0f0135, new a(this));
                }
                if (vy1.e() != 2) {
                    aVar.H(R.string.obfuscated_res_0x7f0f0133, new b(this));
                }
                if (vy1.e() != 0) {
                    aVar.B(R.string.obfuscated_res_0x7f0f129a, new c(this));
                }
                aVar.X();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz1 a;

        public p(xz1 xz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.b3();
                this.a.i3("click", "baozhang");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz1 a;

        public q(xz1 xz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz1Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                this.a.e3();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755154398, "Lcom/repackage/xz1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755154398, "Lcom/repackage/xz1;");
                return;
            }
        }
        Q0 = eh1.a;
    }

    public xz1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.J0 = new long[5];
    }

    public static xz1 p3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? new xz1() : (xz1) invokeV.objValue;
    }

    @Override // com.repackage.a02
    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.a02
    public void L2() {
        d02 V;
        c02 c02Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (V = hm2.U().V()) == null || (c02Var = (c02) V.n(c02.class)) == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, c02Var.s3());
        hm2.U().u(new va2("sharebtn", hashMap));
        i3("click", "aboutshare");
    }

    @Override // com.repackage.a02
    public void T1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            U1(view2);
            if (!X1()) {
                I2(false);
            }
            z2(true);
            s2(-1);
            B2(-16777216);
            u2(null);
            w2(true);
        }
    }

    @NonNull
    public final String a3(@NonNull String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            if (str.endsWith(File.separator)) {
                str = str.substring(0, str.length() - 1);
            }
            if (str2.startsWith(File.separator)) {
                str2 = str2.substring(1);
            }
            return str + File.separator + str2;
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.repackage.a02
    public boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void b3() {
        SwanAppActivity activity;
        u03 a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (activity = hm2.U().getActivity()) == null || (a0 = u03.a0()) == null) {
            return;
        }
        SwanAppWebPopWindow swanAppWebPopWindow = this.P0;
        if (swanAppWebPopWindow == null || !swanAppWebPopWindow.y()) {
            SwanAppWebPopWindow swanAppWebPopWindow2 = new SwanAppWebPopWindow(activity, "https://baozhang.baidu.com/guarantee/baoshowdetail?appkey=" + a0.N());
            this.P0 = swanAppWebPopWindow2;
            swanAppWebPopWindow2.r0(R.string.obfuscated_res_0x7f0f1229);
            swanAppWebPopWindow2.n0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_BOTTOM);
            swanAppWebPopWindow2.o0();
            swanAppWebPopWindow2.m0();
            swanAppWebPopWindow2.t0();
        }
    }

    public final void c3() {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (activity = hm2.U().getActivity()) == null || u03.a0() == null) {
            return;
        }
        SwanAppWebPopWindow swanAppWebPopWindow = this.P0;
        if (swanAppWebPopWindow == null || !swanAppWebPopWindow.y()) {
            SwanAppWebPopWindow swanAppWebPopWindow2 = new SwanAppWebPopWindow(activity, this.M0);
            this.P0 = swanAppWebPopWindow2;
            swanAppWebPopWindow2.s0(H(R.string.obfuscated_res_0x7f0f1257));
            swanAppWebPopWindow2.p0(activity.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07063c));
            swanAppWebPopWindow2.n0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_RIGHT);
            swanAppWebPopWindow2.m0();
            swanAppWebPopWindow2.t0();
            i3("click", "servicenote");
        }
    }

    @Override // com.repackage.a02
    public boolean d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void d3() {
        u03 a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (a0 = u03.a0()) == null) {
            return;
        }
        rl2.a V = a0.V();
        String J = V.J();
        String F = V.F();
        if (!TextUtils.isEmpty(J) && !TextUtils.isEmpty(F)) {
            String h2 = oe3.h(J, F);
            UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
            unitedSchemeMainDispatcher.setDynamicDispatcher("swanAPI", new r13());
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(h2), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            unitedSchemeEntity.setOnlyVerify(false);
            unitedSchemeMainDispatcher.dispatch(this.i0, unitedSchemeEntity);
            if (Q0) {
                Log.d("SwanAppAboutFragment", "Open or download app");
            }
        } else if (Q0) {
            Log.d("SwanAppAboutFragment", "appOpenUrl or appDownloadUrl is empty, click no response");
        }
    }

    public final void e3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.i0 == null) {
            return;
        }
        String str = t03.J().r().V().f0().webUrl;
        if (TextUtils.isEmpty(str)) {
            pe3.b(this.i0).c("");
            m03.f(this.i0, R.string.obfuscated_res_0x7f0f1322).G();
            return;
        }
        String a3 = a3(str, uq2.b(oe3.n()));
        int i2 = R.string.obfuscated_res_0x7f0f1323;
        if (a3.length() > PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL) {
            i2 = R.string.obfuscated_res_0x7f0f1324;
        } else {
            str = a3;
        }
        pe3.b(this.i0).c(str);
        m03.f(this.i0, i2).G();
    }

    public final void f3() {
        SwanAppWebPopWindow swanAppWebPopWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && Q() && (swanAppWebPopWindow = this.P0) != null) {
            swanAppWebPopWindow.s();
        }
    }

    public final void g3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            if (tw2.H()) {
                if (Q0) {
                    Log.d("SwanAppAboutFragment", "in debug mode cannot add favor");
                }
                m03.f(getContext(), R.string.obfuscated_res_0x7f0f0126).G();
                return;
            }
            String e2 = oe3.n().e();
            SwanFavorDataManager.h().b(str, new h(this, e2));
            kq2.p("aboutconcern", e2);
        }
    }

    public final void h3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            SwanFavorDataManager h2 = SwanFavorDataManager.h();
            g gVar = new g(this);
            pa2 l2 = pa2.l();
            l2.n(3);
            h2.c(str, gVar, l2.k());
            i3("click", "aboutmove");
        }
    }

    @Override // com.repackage.a02
    public void i2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && X1()) {
            l3();
            this.m0.s(bk2.M().a());
        }
    }

    public final void i3(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            x73 x73Var = new x73();
            if (!TextUtils.isEmpty(str)) {
                x73Var.b = str;
            }
            if (!TextUtils.isEmpty(str2)) {
                x73Var.e = str2;
            }
            z1(x73Var);
        }
    }

    public final void j3(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view2) == null) {
            String b2 = yz1.b();
            h93 a2 = yz1.a();
            Button button = (Button) view2.findViewById(R.id.obfuscated_res_0x7f09043e);
            button.setVisibility(0);
            if (a2.getInt(b2, -1) == 1) {
                button.setText(R.string.obfuscated_res_0x7f0f126c);
            } else {
                button.setText(R.string.obfuscated_res_0x7f0f126d);
            }
            button.setOnClickListener(new b(this, a2, b2, new a(this, a2, b2)));
        }
    }

    public final void k3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            le3.M(this.G0, this.H0, String.valueOf(i2));
        }
    }

    public void l3() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (activity = getActivity()) != null && this.m0 == null) {
            z64 z64Var = new z64(activity, this.l0, 13, bk2.K(), new dg3());
            this.m0 = z64Var;
            z64Var.q(oe3.P());
            new kq2(this.m0, this).z();
        }
    }

    public final void m3(View view2) {
        u03 a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, view2) == null) || (a0 = u03.a0()) == null || a0.V() == null) {
            return;
        }
        rl2.a V = a0.V();
        this.F0 = (SwanAppRoundedImageView) view2.findViewById(R.id.obfuscated_res_0x7f090198);
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901a7);
        textView.setText(V.K());
        if (V.G() == 0) {
            xf3.a(textView, new i(this));
        }
        hu2.j().n().h(textView);
        TextView textView2 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09018f);
        textView2.setText(V.e1());
        Button button = (Button) view2.findViewById(R.id.obfuscated_res_0x7f091cf9);
        button.setOnClickListener(this);
        Button button2 = (Button) view2.findViewById(R.id.obfuscated_res_0x7f090109);
        this.N0 = button2;
        button2.setOnClickListener(this);
        y3();
        if (bk2.y0().d()) {
            button.setVisibility(8);
            this.N0.setVisibility(8);
        }
        if (!bk2.t().b()) {
            this.N0.setVisibility(8);
        }
        d02 V2 = hm2.U().V();
        if (V2 == null) {
            return;
        }
        if (V2.n(ck2.c().a()) != null) {
            button.setVisibility(8);
            this.N0.setVisibility(8);
        }
        sf4.b().a(textView2);
        ((TextView) view2.findViewById(R.id.obfuscated_res_0x7f091cdc)).setText(V.s1());
        ((TextView) view2.findViewById(R.id.obfuscated_res_0x7f091e12)).setText(V.t1());
        String G = bk2.o().G();
        this.M0 = G;
        if (!TextUtils.isEmpty(G)) {
            View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f09015f);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(this);
        }
        this.O0 = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f091a79);
        PMSAppInfo f0 = V.f0();
        if (o3(f0)) {
            t3(view2, f0.brandsInfo);
        }
        this.H0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09019c);
        this.G0 = (BdBaseImageView) view2.findViewById(R.id.obfuscated_res_0x7f09019b);
        this.F0.setImageBitmap(oe3.i(V, "SwanAppAboutFragment", false));
        this.F0.setOnClickListener(this);
        SwanAppBearInfo k1 = V.k1();
        if (k1 != null && k1.isValid()) {
            this.I0 = new rf3(this.i0, view2, k1, R.id.obfuscated_res_0x7f090352);
        }
        k3(V.getType());
        ((Button) view2.findViewById(R.id.obfuscated_res_0x7f091615)).setVisibility(8);
        if (Q0 || hm2.U().N()) {
            View inflate = ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f090167)).inflate();
            if (X1() && (inflate instanceof Button)) {
                ((Button) inflate).setText(V.m0() ? R.string.obfuscated_res_0x7f0f0110 : R.string.obfuscated_res_0x7f0f019c);
            }
            inflate.setOnClickListener(new j(this));
            if (!X1()) {
                ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f090168)).inflate().setOnClickListener(new k(this));
            }
            if (X1()) {
                ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f09016a)).inflate().setOnClickListener(new l(this, V, a0));
            }
            if (X1()) {
                View inflate2 = ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f09016c)).inflate();
                if (inflate2 instanceof Button) {
                    Button button3 = (Button) inflate2;
                    button3.setText(R.string.obfuscated_res_0x7f0f00e5);
                    button3.setOnClickListener(new m(this));
                }
            }
            if (bu2.e().f()) {
                View inflate3 = ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f090169)).inflate();
                if (inflate3 instanceof Button) {
                    Button button4 = (Button) inflate3;
                    button4.setText(R.string.obfuscated_res_0x7f0f0146);
                    button4.setOnClickListener(new n(this));
                }
            }
            View inflate4 = ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f09016b)).inflate();
            if (inflate4 instanceof Button) {
                ((Button) inflate4).setText(R.string.obfuscated_res_0x7f0f0148);
            }
            inflate4.setOnClickListener(new o(this));
            if (!X1()) {
                j3(view2);
            }
        }
        if (n3(f0)) {
            ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09029c);
            imageView.setVisibility(0);
            imageView.setOnClickListener(new p(this));
        }
        if (X1()) {
            return;
        }
        r3(this.F0, 2000L, new q(this));
    }

    public final boolean n3(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, pMSAppInfo)) == null) {
            return (pMSAppInfo == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : pMSAppInfo.payProtected) == PMSConstants.PayProtected.PAY_PROTECTED.type;
        }
        return invokeL.booleanValue;
    }

    public final boolean o3(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, pMSAppInfo)) == null) ? (t03.J().l() != 0 || pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.brandsInfo)) ? false : true : invokeL.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, view2) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f090198) {
                s3();
            } else if (id == R.id.obfuscated_res_0x7f091615) {
                d3();
            } else if (id == R.id.obfuscated_res_0x7f0903f0) {
                SchemeRouter.invoke(getContext(), this.K0);
                i3("click", com.xiaomi.mipush.sdk.Constants.PHONE_BRAND);
            } else if (id == R.id.obfuscated_res_0x7f09015f) {
                c3();
            } else if (id == R.id.obfuscated_res_0x7f091cf9) {
                L2();
            } else if (id == R.id.obfuscated_res_0x7f090109) {
                q3();
            }
        }
    }

    @Override // com.repackage.a02, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onPause();
            f3();
        }
    }

    @Override // com.repackage.a02, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onResume();
            rf3 rf3Var = this.I0;
            if (rf3Var != null) {
                rf3Var.c();
            }
            G2(1);
            z64 z64Var = this.m0;
            if (z64Var != null && z64Var.j()) {
                this.m0.C(bk2.M().a());
            }
            if (this.N0 != null) {
                y3();
            }
        }
    }

    public final void q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            String N = t03.J().r().N();
            if (TextUtils.isEmpty(N)) {
                return;
            }
            if (s72.n(N)) {
                h3(N);
            } else {
                g3(N);
            }
            y3();
        }
    }

    public final void r3(View view2, long j2, View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{view2, Long.valueOf(j2), onLongClickListener}) == null) || view2 == null || onLongClickListener == null || j2 <= 0) {
            return;
        }
        view2.setOnTouchListener(new d(this, new c(this, onLongClickListener, view2), j2));
    }

    public final void s3() {
        u03 a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (a0 = u03.a0()) == null) {
            return;
        }
        long[] jArr = this.J0;
        System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
        long[] jArr2 = this.J0;
        jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
        if (this.J0[0] >= SystemClock.uptimeMillis() - 1000) {
            this.J0 = new long[5];
            if (a0.v0()) {
                u3();
            } else {
                w3();
            }
        }
    }

    public final void t3(View view2, String str) {
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, view2, str) == null) {
            if (Q0) {
                Log.i("SwanAppAboutFragment", str + "");
            }
            if (TextUtils.isEmpty(str) || view2 == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.K0 = jSONObject.optString("scheme");
                this.L0 = jSONObject.optString("description");
                if (!TextUtils.isEmpty(this.K0) && !TextUtils.isEmpty(this.L0) && (length = this.L0.length()) >= 20) {
                    if (length > 100) {
                        this.L0 = this.L0.substring(0, 100);
                    }
                    LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0903f0);
                    linearLayout.setOnClickListener(this);
                    linearLayout.setVisibility(0);
                    ((TextView) view2.findViewById(R.id.obfuscated_res_0x7f0903ee)).setText(this.L0);
                    SwanAppRelatedSwanListAdapter.d(com.xiaomi.mipush.sdk.Constants.PHONE_BRAND, null, "show");
                    v3();
                }
            } catch (JSONException e2) {
                if (Q0) {
                    Log.i("SwanAppAboutFragment", e2.getMessage());
                }
            }
        }
    }

    public final void u3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            String g2 = nd3.g(this.i0);
            m03.g(AppRuntime.getAppContext(), g2).F();
            ux1.k("SwanAppAboutFragment", "showExtraInfo\n" + g2);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void v0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, bundle) == null) {
            super.v0(bundle);
        }
    }

    public final void v3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(1);
            this.O0.setLayoutManager(linearLayoutManager);
            SwanAppRelatedSwanListAdapter swanAppRelatedSwanListAdapter = new SwanAppRelatedSwanListAdapter(getContext());
            this.O0.setAdapter(swanAppRelatedSwanListAdapter);
            cz2.c(new e(this, swanAppRelatedSwanListAdapter));
        }
    }

    public final void w3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            if (Q0) {
                Log.d("SwanAppAboutFragment", "startAboutFragment");
            }
            d02 V = hm2.U().V();
            if (V == null) {
                m03.f(getContext(), R.string.obfuscated_res_0x7f0f019e).G();
                return;
            }
            d02.b i2 = V.i("navigateTo");
            i2.n(d02.g, d02.i);
            i2.k("running_info", null).a();
        }
    }

    public final void x3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || u03.a0() == null) {
            return;
        }
        qz1.a(u03.a0(), this.i0, new f(this));
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View y0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048609, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0091, viewGroup, false);
            T1(inflate);
            m3(inflate);
            if (S1()) {
                inflate = V1(inflate);
            }
            return C1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    public final void y3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            if (s72.n(t03.J().getAppId())) {
                this.N0.setText(R.string.obfuscated_res_0x7f0f12b3);
                this.N0.setTextColor(AppCompatResources.getColorStateList(getContext(), R.color.obfuscated_res_0x7f060a2f));
                this.N0.setBackgroundResource(R.drawable.obfuscated_res_0x7f081119);
                return;
            }
            this.N0.setText(R.string.obfuscated_res_0x7f0f127f);
            this.N0.setTextColor(-1);
            this.N0.setBackgroundResource(R.drawable.obfuscated_res_0x7f081117);
        }
    }
}
