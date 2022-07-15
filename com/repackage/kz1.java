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
import com.repackage.dz1;
import com.repackage.el2;
import com.repackage.lz2;
import com.repackage.ot2;
import com.repackage.oy2;
import com.repackage.py2;
import com.repackage.qz1;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class kz1 extends nz1 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean Q0;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppRoundedImageView F0;
    public BdBaseImageView G0;
    public TextView H0;
    public ef3 I0;
    public long[] J0;
    public String K0;
    public String L0;
    public String M0;
    public Button N0;
    public RecyclerView O0;
    public SwanAppWebPopWindow P0;

    /* loaded from: classes6.dex */
    public class a implements pk3<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u83 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ kz1 c;

        /* renamed from: com.repackage.kz1$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class DialogInterface$OnClickListenerC0670a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public DialogInterface$OnClickListenerC0670a(a aVar) {
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
                    SwanAppActivity w = g03.K().w();
                    if (w != null && Build.VERSION.SDK_INT >= 21) {
                        w.finishAndRemoveTask();
                    }
                    System.exit(0);
                }
            }
        }

        public a(kz1 kz1Var, u83 u83Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz1Var, u83Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = kz1Var;
            this.a = u83Var;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.pk3
        /* renamed from: a */
        public void run(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool != null && bool.booleanValue()) {
                    this.a.putInt(this.b, 1);
                } else {
                    this.a.putInt(this.b, 0);
                }
                lz2.a aVar = new lz2.a(this.c.i0);
                aVar.U(R.string.obfuscated_res_0x7f0f1287);
                aVar.v(R.string.obfuscated_res_0x7f0f1286);
                aVar.n(new pf3());
                aVar.O(R.string.obfuscated_res_0x7f0f0115, new DialogInterface$OnClickListenerC0670a(this));
                aVar.X();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u83 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ pk3 c;
        public final /* synthetic */ kz1 d;

        /* loaded from: classes6.dex */
        public class a implements dz1.b {
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

            @Override // com.repackage.dz1.b
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
                    dz1.b(this.a.d.i0, R.string.obfuscated_res_0x7f0f1287, str);
                }
            }
        }

        public b(kz1 kz1Var, u83 u83Var, String str, pk3 pk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz1Var, u83Var, str, pk3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = kz1Var;
            this.a = u83Var;
            this.b = str;
            this.c = pk3Var;
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
                    h03 b0 = h03.b0();
                    if (b0 == null) {
                        return;
                    }
                    dz1.a(b0, this.d.i0, new a(this));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View.OnLongClickListener a;
        public final /* synthetic */ View b;
        public final /* synthetic */ kz1 c;

        public c(kz1 kz1Var, View.OnLongClickListener onLongClickListener, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz1Var, onLongClickListener, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = kz1Var;
            this.a = onLongClickListener;
            this.b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                wa3.d().g();
                this.a.onLongClick(this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Runnable a;
        public final /* synthetic */ long b;
        public final /* synthetic */ kz1 c;

        public d(kz1 kz1Var, Runnable runnable, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz1Var, runnable, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = kz1Var;
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

    /* loaded from: classes6.dex */
    public class e implements py2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppRelatedSwanListAdapter a;
        public final /* synthetic */ kz1 b;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ oy2 a;
            public final /* synthetic */ e b;

            public a(e eVar, oy2 oy2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, oy2Var};
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
                this.a = oy2Var;
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

        public e(kz1 kz1Var, SwanAppRelatedSwanListAdapter swanAppRelatedSwanListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz1Var, swanAppRelatedSwanListAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kz1Var;
            this.a = swanAppRelatedSwanListAdapter;
        }

        @Override // com.repackage.py2.b
        public void a(oy2 oy2Var) {
            List<oy2.a> list;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, oy2Var) == null) || oy2Var == null || (list = oy2Var.a) == null || list.size() <= 0) {
                return;
            }
            be3.e0(new a(this, oy2Var));
            SwanAppRelatedSwanListAdapter.d("aboutrelated", null, "show");
        }
    }

    /* loaded from: classes6.dex */
    public class f implements dz1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kz1 a;

        /* loaded from: classes6.dex */
        public class a implements af3<Boolean> {
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
            @Override // com.repackage.af3
            /* renamed from: b */
            public void a(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                    if (bool.booleanValue()) {
                        ex1.d(this.a.a.getContext());
                    } else {
                        pj2.h().a(this.a.a.i0, null);
                    }
                }
            }
        }

        public f(kz1 kz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kz1Var;
        }

        @Override // com.repackage.dz1.b
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (!z) {
                    dz1.c(this.a.i0, str);
                } else if (ex1.a()) {
                    ex1.d(this.a.getContext());
                } else {
                    pj2.h().f(new a(this));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements bc2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kz1 a;

        public g(kz1 kz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kz1Var;
        }

        @Override // com.repackage.bc2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                zz2 f = zz2.f(this.a.getContext(), R.string.obfuscated_res_0x7f0f131d);
                f.l(2);
                f.G();
            }
        }

        @Override // com.repackage.bc2
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                zz2 f = zz2.f(this.a.getContext(), R.string.obfuscated_res_0x7f0f010f);
                f.l(2);
                f.G();
            }
        }

        @Override // com.repackage.bc2
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || z) {
                return;
            }
            zz2 f = zz2.f(this.a.getContext(), R.string.obfuscated_res_0x7f0f010e);
            f.l(2);
            f.G();
        }
    }

    /* loaded from: classes6.dex */
    public class h implements ac2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ kz1 b;

        public h(kz1 kz1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kz1Var;
            this.a = str;
        }

        @Override // com.repackage.ac2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                zz2 f = zz2.f(this.b.getContext(), R.string.obfuscated_res_0x7f0f131d);
                f.l(2);
                f.G();
            }
        }

        @Override // com.repackage.ac2
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || z) {
                return;
            }
            zz2 f = zz2.f(this.b.getContext(), R.string.obfuscated_res_0x7f0f0157);
            f.l(2);
            f.G();
        }

        @Override // com.repackage.ac2
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                f72.t();
                if (xp2.k(this.b.getActivity())) {
                    xp2.p("aboutconcern", this.a);
                    return;
                }
                Context context = this.b.getContext();
                zz2 g = zz2.g(context, oj2.l0().f(context));
                g.l(2);
                g.q(2);
                g.G();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kz1 a;

        public i(kz1 kz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kz1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.x3();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FullScreenFloatView a;
        public final /* synthetic */ kz1 b;

        /* loaded from: classes6.dex */
        public class a implements af3<Boolean> {
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
            @Override // com.repackage.af3
            /* renamed from: b */
            public void a(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                    if (bool.booleanValue()) {
                        ex1.c(this.a.b.getContext(), true);
                    } else {
                        pj2.h().a(this.a.b.i0, null);
                    }
                }
            }
        }

        public j(kz1 kz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kz1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.b.i0 == null) {
                return;
            }
            if (kz1.Q0) {
                if (h42.f()) {
                    ex1.d(this.b.getContext());
                    return;
                }
                if (this.a == null) {
                    this.a = ul2.U().n(this.b.i0);
                }
                if (this.b.Y1()) {
                    if (ex1.a()) {
                        ex1.c(this.b.getContext(), false);
                        return;
                    } else {
                        pj2.h().f(new a(this));
                        return;
                    }
                }
                this.a.setVisibility(this.a.getVisibility() == 0 ? 8 : 0);
            } else if (this.b.Y1()) {
                this.b.y3();
            } else {
                ex1.d(this.b.getContext());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SwanAppPropertyWindow a;
        public final /* synthetic */ kz1 b;

        public k(kz1 kz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kz1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a == null) {
                    this.a = ul2.U().J(this.b.i0);
                }
                this.a.setVisibility(this.a.getVisibility() == 0 ? 8 : 0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ el2 a;
        public final /* synthetic */ h03 b;
        public final /* synthetic */ kz1 c;

        /* loaded from: classes6.dex */
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

        public l(kz1 kz1Var, el2 el2Var, h03 h03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz1Var, el2Var, h03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = kz1Var;
            this.a = el2Var;
            this.b = h03Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.c.i0 == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ENABLE V8: ");
            sb.append(b72.U().r0());
            sb.append("\n");
            sb.append("APS VERSION: ");
            sb.append(TextUtils.isEmpty(this.a.v1()) ? "" : this.a.v1());
            sb.append("\n");
            sb.append("APPID VERSION: ");
            sb.append(js1.c(this.b.b));
            sb.append("\n");
            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), this.a.i1());
            sb.append("小程序包大小: ");
            sb.append(TextUtils.isEmpty(formatFileSize) ? "" : formatFileSize);
            sb.append("(");
            sb.append(this.a.i1());
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            sb.append("\n");
            lz2.a aVar = new lz2.a(this.c.i0);
            aVar.V(this.c.i0.getResources().getString(R.string.obfuscated_res_0x7f0f01c6));
            aVar.x(sb.toString());
            aVar.n(new pf3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f0115, new a(this));
            aVar.X();
        }
    }

    /* loaded from: classes6.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kz1 a;

        /* loaded from: classes6.dex */
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

        public m(kz1 kz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kz1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.i0 == null) {
                return;
            }
            String e = l93.c().e(1);
            String string = this.a.i0.getResources().getString(R.string.obfuscated_res_0x7f0f00e8);
            lz2.a aVar = new lz2.a(this.a.i0);
            aVar.V(string);
            aVar.x(e);
            aVar.n(new pf3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f0115, new a(this));
            aVar.X();
        }
    }

    /* loaded from: classes6.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kz1 a;

        /* loaded from: classes6.dex */
        public class a extends ot2.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ n a;

            /* renamed from: com.repackage.kz1$n$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0671a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;
                public final /* synthetic */ a b;

                public RunnableC0671a(a aVar, String str) {
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
                        lz2.a aVar = new lz2.a(this.b.a.a.i0);
                        aVar.U(R.string.obfuscated_res_0x7f0f0149);
                        aVar.x(this.a);
                        aVar.n(new pf3());
                        aVar.m(false);
                        aVar.O(R.string.obfuscated_res_0x7f0f0115, null);
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

            @Override // com.repackage.ot2.a
            public void c(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.a.a.i0.runOnUiThread(new RunnableC0671a(this, str));
                }
            }
        }

        public n(kz1 kz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kz1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.i0 == null) {
                return;
            }
            ot2.e().g(new a(this));
        }
    }

    /* loaded from: classes6.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public iy1 a;
        public final /* synthetic */ kz1 b;

        /* loaded from: classes6.dex */
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
                    iy1.g(1);
                    this.a.a = new iy1(oj2.c());
                    this.a.a.h();
                }
            }
        }

        /* loaded from: classes6.dex */
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
                    iy1.g(2);
                    System.exit(0);
                }
            }
        }

        /* loaded from: classes6.dex */
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
                    iy1.g(0);
                }
            }
        }

        public o(kz1 kz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kz1Var;
        }

        public final void b() {
            iy1 iy1Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iy1Var = this.a) == null) {
                return;
            }
            iy1Var.i();
            this.a = null;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                lz2.a aVar = new lz2.a(this.b.i0);
                aVar.U(R.string.obfuscated_res_0x7f0f014b);
                aVar.v(R.string.obfuscated_res_0x7f0f0137);
                aVar.n(new pf3());
                aVar.m(true);
                if (iy1.e() == 0) {
                    aVar.O(R.string.obfuscated_res_0x7f0f0138, new a(this));
                }
                if (iy1.e() != 2) {
                    aVar.H(R.string.obfuscated_res_0x7f0f0136, new b(this));
                }
                if (iy1.e() != 0) {
                    aVar.B(R.string.obfuscated_res_0x7f0f12b2, new c(this));
                }
                aVar.X();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kz1 a;

        public p(kz1 kz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kz1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.c3();
                this.a.j3("click", "baozhang");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kz1 a;

        public q(kz1 kz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kz1Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                this.a.f3();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755541681, "Lcom/repackage/kz1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755541681, "Lcom/repackage/kz1;");
                return;
            }
        }
        Q0 = rg1.a;
    }

    public kz1() {
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

    public static kz1 q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? new kz1() : (kz1) invokeV.objValue;
    }

    @Override // com.repackage.nz1
    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.nz1
    public void M2() {
        qz1 V;
        pz1 pz1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (V = ul2.U().V()) == null || (pz1Var = (pz1) V.n(pz1.class)) == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, pz1Var.t3());
        ul2.U().u(new ia2("sharebtn", hashMap));
        j3("click", "aboutshare");
    }

    @Override // com.repackage.nz1
    public void U1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            V1(view2);
            if (!Y1()) {
                J2(false);
            }
            A2(true);
            t2(-1);
            C2(-16777216);
            v2(null);
            x2(true);
        }
    }

    @NonNull
    public final String b3(@NonNull String str, String str2) {
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

    @Override // com.repackage.nz1
    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void c3() {
        SwanAppActivity activity;
        h03 b0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (activity = ul2.U().getActivity()) == null || (b0 = h03.b0()) == null) {
            return;
        }
        SwanAppWebPopWindow swanAppWebPopWindow = this.P0;
        if (swanAppWebPopWindow == null || !swanAppWebPopWindow.x()) {
            SwanAppWebPopWindow swanAppWebPopWindow2 = new SwanAppWebPopWindow(activity, "https://baozhang.baidu.com/guarantee/baoshowdetail?appkey=" + b0.O());
            this.P0 = swanAppWebPopWindow2;
            swanAppWebPopWindow2.r0(R.string.obfuscated_res_0x7f0f1241);
            swanAppWebPopWindow2.n0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_BOTTOM);
            swanAppWebPopWindow2.o0();
            swanAppWebPopWindow2.m0();
            swanAppWebPopWindow2.t0();
        }
    }

    public final void d3() {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (activity = ul2.U().getActivity()) == null || h03.b0() == null) {
            return;
        }
        SwanAppWebPopWindow swanAppWebPopWindow = this.P0;
        if (swanAppWebPopWindow == null || !swanAppWebPopWindow.x()) {
            SwanAppWebPopWindow swanAppWebPopWindow2 = new SwanAppWebPopWindow(activity, this.M0);
            this.P0 = swanAppWebPopWindow2;
            swanAppWebPopWindow2.s0(G(R.string.obfuscated_res_0x7f0f126f));
            swanAppWebPopWindow2.p0(activity.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070697));
            swanAppWebPopWindow2.n0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_RIGHT);
            swanAppWebPopWindow2.m0();
            swanAppWebPopWindow2.t0();
            j3("click", "servicenote");
        }
    }

    @Override // com.repackage.nz1
    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void e3() {
        h03 b0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (b0 = h03.b0()) == null) {
            return;
        }
        el2.a W = b0.W();
        String J = W.J();
        String F = W.F();
        if (!TextUtils.isEmpty(J) && !TextUtils.isEmpty(F)) {
            String h2 = be3.h(J, F);
            UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
            unitedSchemeMainDispatcher.setDynamicDispatcher("swanAPI", new e13());
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

    public final void f3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.i0 == null) {
            return;
        }
        String str = g03.K().q().W().f0().webUrl;
        if (TextUtils.isEmpty(str)) {
            ce3.b(this.i0).c("");
            zz2.f(this.i0, R.string.obfuscated_res_0x7f0f133a).G();
            return;
        }
        String b3 = b3(str, hq2.b(be3.n()));
        int i2 = R.string.obfuscated_res_0x7f0f133b;
        if (b3.length() > 4000) {
            i2 = R.string.obfuscated_res_0x7f0f133c;
        } else {
            str = b3;
        }
        ce3.b(this.i0).c(str);
        zz2.f(this.i0, i2).G();
    }

    public final void g3() {
        SwanAppWebPopWindow swanAppWebPopWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && R() && (swanAppWebPopWindow = this.P0) != null) {
            swanAppWebPopWindow.r();
        }
    }

    public final void h3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            if (gw2.H()) {
                if (Q0) {
                    Log.d("SwanAppAboutFragment", "in debug mode cannot add favor");
                }
                zz2.f(getContext(), R.string.obfuscated_res_0x7f0f0129).G();
                return;
            }
            String e2 = be3.n().e();
            SwanFavorDataManager.h().b(str, new h(this, e2));
            xp2.p("aboutconcern", e2);
        }
    }

    public final void i3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            SwanFavorDataManager h2 = SwanFavorDataManager.h();
            g gVar = new g(this);
            ca2 l2 = ca2.l();
            l2.n(3);
            h2.c(str, gVar, l2.k());
            j3("click", "aboutmove");
        }
    }

    @Override // com.repackage.nz1
    public void j2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && Y1()) {
            m3();
            this.m0.s(oj2.M().a());
        }
    }

    public final void j3(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            k73 k73Var = new k73();
            if (!TextUtils.isEmpty(str)) {
                k73Var.b = str;
            }
            if (!TextUtils.isEmpty(str2)) {
                k73Var.e = str2;
            }
            A1(k73Var);
        }
    }

    public final void k3(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view2) == null) {
            String b2 = lz1.b();
            u83 a2 = lz1.a();
            Button button = (Button) view2.findViewById(R.id.obfuscated_res_0x7f090436);
            button.setVisibility(0);
            if (a2.getInt(b2, -1) == 1) {
                button.setText(R.string.obfuscated_res_0x7f0f1284);
            } else {
                button.setText(R.string.obfuscated_res_0x7f0f1285);
            }
            button.setOnClickListener(new b(this, a2, b2, new a(this, a2, b2)));
        }
    }

    public final void l3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            yd3.M(this.G0, this.H0, String.valueOf(i2));
        }
    }

    public void m3() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (activity = getActivity()) != null && this.m0 == null) {
            m64 m64Var = new m64(activity, this.l0, 13, oj2.K(), new qf3());
            this.m0 = m64Var;
            m64Var.p(be3.P());
            new xp2(this.m0, this).z();
        }
    }

    public final void n3(View view2) {
        h03 b0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, view2) == null) || (b0 = h03.b0()) == null || b0.W() == null) {
            return;
        }
        el2.a W = b0.W();
        this.F0 = (SwanAppRoundedImageView) view2.findViewById(R.id.obfuscated_res_0x7f090196);
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901a5);
        textView.setText(W.K());
        if (W.G() == 0) {
            kf3.a(textView, new i(this));
        }
        ut2.j().n().h(textView);
        TextView textView2 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09018d);
        textView2.setText(W.e1());
        Button button = (Button) view2.findViewById(R.id.obfuscated_res_0x7f091d3f);
        button.setOnClickListener(this);
        Button button2 = (Button) view2.findViewById(R.id.obfuscated_res_0x7f090109);
        this.N0 = button2;
        button2.setOnClickListener(this);
        z3();
        if (oj2.y0().d()) {
            button.setVisibility(8);
            this.N0.setVisibility(8);
        }
        if (!oj2.t().b()) {
            this.N0.setVisibility(8);
        }
        qz1 V = ul2.U().V();
        if (V == null) {
            return;
        }
        if (V.n(pj2.c().a()) != null) {
            button.setVisibility(8);
            this.N0.setVisibility(8);
        }
        ef4.b().a(textView2);
        ((TextView) view2.findViewById(R.id.obfuscated_res_0x7f091d22)).setText(W.s1());
        ((TextView) view2.findViewById(R.id.obfuscated_res_0x7f091e56)).setText(W.t1());
        String G = oj2.o().G();
        this.M0 = G;
        if (!TextUtils.isEmpty(G)) {
            View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f09015d);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(this);
        }
        this.O0 = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f091ac9);
        PMSAppInfo f0 = W.f0();
        if (p3(f0)) {
            u3(view2, f0.brandsInfo);
        }
        this.H0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09019a);
        this.G0 = (BdBaseImageView) view2.findViewById(R.id.obfuscated_res_0x7f090199);
        this.F0.setImageBitmap(be3.i(W, "SwanAppAboutFragment", false));
        this.F0.setOnClickListener(this);
        SwanAppBearInfo k1 = W.k1();
        if (k1 != null && k1.isValid()) {
            this.I0 = new ef3(this.i0, view2, k1, R.id.obfuscated_res_0x7f090353);
        }
        l3(W.getType());
        ((Button) view2.findViewById(R.id.obfuscated_res_0x7f091665)).setVisibility(8);
        if (Q0 || ul2.U().N()) {
            View inflate = ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f090165)).inflate();
            if (Y1() && (inflate instanceof Button)) {
                ((Button) inflate).setText(W.m0() ? R.string.obfuscated_res_0x7f0f0113 : R.string.obfuscated_res_0x7f0f019f);
            }
            inflate.setOnClickListener(new j(this));
            if (!Y1()) {
                ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f090166)).inflate().setOnClickListener(new k(this));
            }
            if (Y1()) {
                ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f090168)).inflate().setOnClickListener(new l(this, W, b0));
            }
            if (Y1()) {
                View inflate2 = ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f09016a)).inflate();
                if (inflate2 instanceof Button) {
                    Button button3 = (Button) inflate2;
                    button3.setText(R.string.obfuscated_res_0x7f0f00e8);
                    button3.setOnClickListener(new m(this));
                }
            }
            if (ot2.e().f()) {
                View inflate3 = ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f090167)).inflate();
                if (inflate3 instanceof Button) {
                    Button button4 = (Button) inflate3;
                    button4.setText(R.string.obfuscated_res_0x7f0f0149);
                    button4.setOnClickListener(new n(this));
                }
            }
            View inflate4 = ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f090169)).inflate();
            if (inflate4 instanceof Button) {
                ((Button) inflate4).setText(R.string.obfuscated_res_0x7f0f014b);
            }
            inflate4.setOnClickListener(new o(this));
            if (!Y1()) {
                k3(view2);
            }
        }
        if (o3(f0)) {
            ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09029b);
            imageView.setVisibility(0);
            imageView.setOnClickListener(new p(this));
        }
        if (Y1()) {
            return;
        }
        s3(this.F0, 2000L, new q(this));
    }

    public final boolean o3(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, pMSAppInfo)) == null) {
            return (pMSAppInfo == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : pMSAppInfo.payProtected) == PMSConstants.PayProtected.PAY_PROTECTED.type;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, view2) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f090196) {
                t3();
            } else if (id == R.id.obfuscated_res_0x7f091665) {
                e3();
            } else if (id == R.id.obfuscated_res_0x7f0903e7) {
                SchemeRouter.invoke(getContext(), this.K0);
                j3("click", com.xiaomi.mipush.sdk.Constants.PHONE_BRAND);
            } else if (id == R.id.obfuscated_res_0x7f09015d) {
                d3();
            } else if (id == R.id.obfuscated_res_0x7f091d3f) {
                M2();
            } else if (id == R.id.obfuscated_res_0x7f090109) {
                r3();
            }
        }
    }

    @Override // com.repackage.nz1, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onPause();
            g3();
        }
    }

    @Override // com.repackage.nz1, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onResume();
            ef3 ef3Var = this.I0;
            if (ef3Var != null) {
                ef3Var.c();
            }
            H2(1);
            m64 m64Var = this.m0;
            if (m64Var != null && m64Var.i()) {
                this.m0.B(oj2.M().a());
            }
            if (this.N0 != null) {
                z3();
            }
        }
    }

    public final boolean p3(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, pMSAppInfo)) == null) ? (g03.K().k() != 0 || pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.brandsInfo)) ? false : true : invokeL.booleanValue;
    }

    public final void r3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            String O = g03.K().q().O();
            if (TextUtils.isEmpty(O)) {
                return;
            }
            if (f72.n(O)) {
                i3(O);
            } else {
                h3(O);
            }
            z3();
        }
    }

    public final void s3(View view2, long j2, View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{view2, Long.valueOf(j2), onLongClickListener}) == null) || view2 == null || onLongClickListener == null || j2 <= 0) {
            return;
        }
        view2.setOnTouchListener(new d(this, new c(this, onLongClickListener, view2), j2));
    }

    public final void t3() {
        h03 b0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (b0 = h03.b0()) == null) {
            return;
        }
        long[] jArr = this.J0;
        System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
        long[] jArr2 = this.J0;
        jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
        if (this.J0[0] >= SystemClock.uptimeMillis() - 1000) {
            this.J0 = new long[5];
            if (b0.w0()) {
                v3();
            } else {
                x3();
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void u0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bundle) == null) {
            super.u0(bundle);
        }
    }

    public final void u3(View view2, String str) {
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, view2, str) == null) {
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
                    LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0903e7);
                    linearLayout.setOnClickListener(this);
                    linearLayout.setVisibility(0);
                    ((TextView) view2.findViewById(R.id.obfuscated_res_0x7f0903e5)).setText(this.L0);
                    SwanAppRelatedSwanListAdapter.d(com.xiaomi.mipush.sdk.Constants.PHONE_BRAND, null, "show");
                    w3();
                }
            } catch (JSONException e2) {
                if (Q0) {
                    Log.i("SwanAppAboutFragment", e2.getMessage());
                }
            }
        }
    }

    public final void v3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            String g2 = ad3.g(this.i0);
            zz2.g(AppRuntime.getAppContext(), g2).F();
            hx1.k("SwanAppAboutFragment", "showExtraInfo\n" + g2);
        }
    }

    public final void w3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(1);
            this.O0.setLayoutManager(linearLayoutManager);
            SwanAppRelatedSwanListAdapter swanAppRelatedSwanListAdapter = new SwanAppRelatedSwanListAdapter(getContext());
            this.O0.setAdapter(swanAppRelatedSwanListAdapter);
            py2.c(new e(this, swanAppRelatedSwanListAdapter));
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View x0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048607, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d008c, viewGroup, false);
            U1(inflate);
            n3(inflate);
            if (T1()) {
                inflate = W1(inflate);
            }
            return D1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    public final void x3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            if (Q0) {
                Log.d("SwanAppAboutFragment", "startAboutFragment");
            }
            qz1 V = ul2.U().V();
            if (V == null) {
                zz2.f(getContext(), R.string.obfuscated_res_0x7f0f01a1).G();
                return;
            }
            qz1.b i2 = V.i("navigateTo");
            i2.n(qz1.g, qz1.i);
            i2.k("running_info", null).a();
        }
    }

    public final void y3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || h03.b0() == null) {
            return;
        }
        dz1.a(h03.b0(), this.i0, new f(this));
    }

    public final void z3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            if (f72.n(g03.K().getAppId())) {
                this.N0.setText(R.string.obfuscated_res_0x7f0f12cb);
                this.N0.setTextColor(AppCompatResources.getColorStateList(getContext(), R.color.obfuscated_res_0x7f060a24));
                this.N0.setBackgroundResource(R.drawable.obfuscated_res_0x7f08109c);
                return;
            }
            this.N0.setText(R.string.obfuscated_res_0x7f0f1297);
            this.N0.setTextColor(-1);
            this.N0.setBackgroundResource(R.drawable.obfuscated_res_0x7f08109a);
        }
    }
}
