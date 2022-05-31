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
import com.repackage.dy1;
import com.repackage.ek2;
import com.repackage.ly2;
import com.repackage.os2;
import com.repackage.ox2;
import com.repackage.px2;
import com.repackage.qy1;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ky1 extends ny1 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean Q0;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppRoundedImageView F0;
    public BdBaseImageView G0;
    public TextView H0;
    public ee3 I0;
    public long[] J0;
    public String K0;
    public String L0;
    public String M0;
    public Button N0;
    public RecyclerView O0;
    public SwanAppWebPopWindow P0;

    /* loaded from: classes6.dex */
    public class a implements pj3<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u73 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ky1 c;

        /* renamed from: com.repackage.ky1$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class DialogInterface$OnClickListenerC0462a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public DialogInterface$OnClickListenerC0462a(a aVar) {
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
                    SwanAppActivity x = gz2.J().x();
                    if (x != null && Build.VERSION.SDK_INT >= 21) {
                        x.finishAndRemoveTask();
                    }
                    System.exit(0);
                }
            }
        }

        public a(ky1 ky1Var, u73 u73Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky1Var, u73Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ky1Var;
            this.a = u73Var;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.pj3
        /* renamed from: a */
        public void run(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool != null && bool.booleanValue()) {
                    this.a.putInt(this.b, 1);
                } else {
                    this.a.putInt(this.b, 0);
                }
                ly2.a aVar = new ly2.a(this.c.i0);
                aVar.U(R.string.obfuscated_res_0x7f0f1281);
                aVar.v(R.string.obfuscated_res_0x7f0f1280);
                aVar.n(new pe3());
                aVar.O(R.string.obfuscated_res_0x7f0f0113, new DialogInterface$OnClickListenerC0462a(this));
                aVar.X();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u73 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ pj3 c;
        public final /* synthetic */ ky1 d;

        /* loaded from: classes6.dex */
        public class a implements dy1.b {
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

            @Override // com.repackage.dy1.b
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
                    dy1.b(this.a.d.i0, R.string.obfuscated_res_0x7f0f1281, str);
                }
            }
        }

        public b(ky1 ky1Var, u73 u73Var, String str, pj3 pj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky1Var, u73Var, str, pj3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ky1Var;
            this.a = u73Var;
            this.b = str;
            this.c = pj3Var;
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
                    hz2 a0 = hz2.a0();
                    if (a0 == null) {
                        return;
                    }
                    dy1.a(a0, this.d.i0, new a(this));
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
        public final /* synthetic */ ky1 c;

        public c(ky1 ky1Var, View.OnLongClickListener onLongClickListener, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky1Var, onLongClickListener, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ky1Var;
            this.a = onLongClickListener;
            this.b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                w93.d().g();
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
        public final /* synthetic */ ky1 c;

        public d(ky1 ky1Var, Runnable runnable, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky1Var, runnable, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ky1Var;
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
    public class e implements px2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppRelatedSwanListAdapter a;
        public final /* synthetic */ ky1 b;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ox2 a;
            public final /* synthetic */ e b;

            public a(e eVar, ox2 ox2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, ox2Var};
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
                this.a = ox2Var;
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

        public e(ky1 ky1Var, SwanAppRelatedSwanListAdapter swanAppRelatedSwanListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky1Var, swanAppRelatedSwanListAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ky1Var;
            this.a = swanAppRelatedSwanListAdapter;
        }

        @Override // com.repackage.px2.b
        public void a(ox2 ox2Var) {
            List<ox2.a> list;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, ox2Var) == null) || ox2Var == null || (list = ox2Var.a) == null || list.size() <= 0) {
                return;
            }
            bd3.e0(new a(this, ox2Var));
            SwanAppRelatedSwanListAdapter.d("aboutrelated", null, "show");
        }
    }

    /* loaded from: classes6.dex */
    public class f implements dy1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky1 a;

        /* loaded from: classes6.dex */
        public class a implements ae3<Boolean> {
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
            @Override // com.repackage.ae3
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    if (bool.booleanValue()) {
                        ew1.d(this.a.a.getContext());
                    } else {
                        pi2.h().a(this.a.a.i0, null);
                    }
                }
            }
        }

        public f(ky1 ky1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ky1Var;
        }

        @Override // com.repackage.dy1.b
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (!z) {
                    dy1.c(this.a.i0, str);
                } else if (ew1.a()) {
                    ew1.d(this.a.getContext());
                } else {
                    pi2.h().f(new a(this));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements bb2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky1 a;

        public g(ky1 ky1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ky1Var;
        }

        @Override // com.repackage.bb2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                zy2 f = zy2.f(this.a.getContext(), R.string.obfuscated_res_0x7f0f1317);
                f.l(2);
                f.G();
            }
        }

        @Override // com.repackage.bb2
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                zy2 f = zy2.f(this.a.getContext(), R.string.obfuscated_res_0x7f0f010d);
                f.l(2);
                f.G();
            }
        }

        @Override // com.repackage.bb2
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || z) {
                return;
            }
            zy2 f = zy2.f(this.a.getContext(), R.string.obfuscated_res_0x7f0f010c);
            f.l(2);
            f.G();
        }
    }

    /* loaded from: classes6.dex */
    public class h implements ab2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ky1 b;

        public h(ky1 ky1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ky1Var;
            this.a = str;
        }

        @Override // com.repackage.ab2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                zy2 f = zy2.f(this.b.getContext(), R.string.obfuscated_res_0x7f0f1317);
                f.l(2);
                f.G();
            }
        }

        @Override // com.repackage.ab2
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || z) {
                return;
            }
            zy2 f = zy2.f(this.b.getContext(), R.string.obfuscated_res_0x7f0f0155);
            f.l(2);
            f.G();
        }

        @Override // com.repackage.ab2
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                f62.t();
                if (xo2.k(this.b.getActivity())) {
                    xo2.p("aboutconcern", this.a);
                    return;
                }
                Context context = this.b.getContext();
                zy2 g = zy2.g(context, oi2.l0().f(context));
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
        public final /* synthetic */ ky1 a;

        public i(ky1 ky1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ky1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.w3();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FullScreenFloatView a;
        public final /* synthetic */ ky1 b;

        /* loaded from: classes6.dex */
        public class a implements ae3<Boolean> {
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
            @Override // com.repackage.ae3
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    if (bool.booleanValue()) {
                        ew1.c(this.a.b.getContext(), true);
                    } else {
                        pi2.h().a(this.a.b.i0, null);
                    }
                }
            }
        }

        public j(ky1 ky1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ky1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.b.i0 == null) {
                return;
            }
            if (ky1.Q0) {
                if (h32.f()) {
                    ew1.d(this.b.getContext());
                    return;
                }
                if (this.a == null) {
                    this.a = uk2.U().n(this.b.i0);
                }
                if (this.b.X1()) {
                    if (ew1.a()) {
                        ew1.c(this.b.getContext(), false);
                        return;
                    } else {
                        pi2.h().f(new a(this));
                        return;
                    }
                }
                this.a.setVisibility(this.a.getVisibility() == 0 ? 8 : 0);
            } else if (this.b.X1()) {
                this.b.x3();
            } else {
                ew1.d(this.b.getContext());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SwanAppPropertyWindow a;
        public final /* synthetic */ ky1 b;

        public k(ky1 ky1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ky1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a == null) {
                    this.a = uk2.U().J(this.b.i0);
                }
                this.a.setVisibility(this.a.getVisibility() == 0 ? 8 : 0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ek2 a;
        public final /* synthetic */ hz2 b;
        public final /* synthetic */ ky1 c;

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

        public l(ky1 ky1Var, ek2 ek2Var, hz2 hz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky1Var, ek2Var, hz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ky1Var;
            this.a = ek2Var;
            this.b = hz2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.c.i0 == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ENABLE V8: ");
            sb.append(b62.U().r0());
            sb.append("\n");
            sb.append("APS VERSION: ");
            sb.append(TextUtils.isEmpty(this.a.v1()) ? "" : this.a.v1());
            sb.append("\n");
            sb.append("APPID VERSION: ");
            sb.append(jr1.c(this.b.b));
            sb.append("\n");
            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), this.a.i1());
            sb.append("小程序包大小: ");
            sb.append(TextUtils.isEmpty(formatFileSize) ? "" : formatFileSize);
            sb.append("(");
            sb.append(this.a.i1());
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            sb.append("\n");
            ly2.a aVar = new ly2.a(this.c.i0);
            aVar.V(this.c.i0.getResources().getString(R.string.obfuscated_res_0x7f0f01c4));
            aVar.x(sb.toString());
            aVar.n(new pe3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f0113, new a(this));
            aVar.X();
        }
    }

    /* loaded from: classes6.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky1 a;

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

        public m(ky1 ky1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ky1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.i0 == null) {
                return;
            }
            String e = l83.c().e(1);
            String string = this.a.i0.getResources().getString(R.string.obfuscated_res_0x7f0f00e6);
            ly2.a aVar = new ly2.a(this.a.i0);
            aVar.V(string);
            aVar.x(e);
            aVar.n(new pe3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f0113, new a(this));
            aVar.X();
        }
    }

    /* loaded from: classes6.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky1 a;

        /* loaded from: classes6.dex */
        public class a extends os2.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ n a;

            /* renamed from: com.repackage.ky1$n$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0463a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;
                public final /* synthetic */ a b;

                public RunnableC0463a(a aVar, String str) {
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
                        ly2.a aVar = new ly2.a(this.b.a.a.i0);
                        aVar.U(R.string.obfuscated_res_0x7f0f0147);
                        aVar.x(this.a);
                        aVar.n(new pe3());
                        aVar.m(false);
                        aVar.O(R.string.obfuscated_res_0x7f0f0113, null);
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

            @Override // com.repackage.os2.a
            public void c(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.a.a.i0.runOnUiThread(new RunnableC0463a(this, str));
                }
            }
        }

        public n(ky1 ky1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ky1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.i0 == null) {
                return;
            }
            os2.e().g(new a(this));
        }
    }

    /* loaded from: classes6.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ix1 a;
        public final /* synthetic */ ky1 b;

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
                    ix1.g(1);
                    this.a.a = new ix1(oi2.c());
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
                    ix1.g(2);
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
                    ix1.g(0);
                }
            }
        }

        public o(ky1 ky1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ky1Var;
        }

        public final void b() {
            ix1 ix1Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (ix1Var = this.a) == null) {
                return;
            }
            ix1Var.i();
            this.a = null;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                ly2.a aVar = new ly2.a(this.b.i0);
                aVar.U(R.string.obfuscated_res_0x7f0f0149);
                aVar.v(R.string.obfuscated_res_0x7f0f0135);
                aVar.n(new pe3());
                aVar.m(true);
                if (ix1.e() == 0) {
                    aVar.O(R.string.obfuscated_res_0x7f0f0136, new a(this));
                }
                if (ix1.e() != 2) {
                    aVar.H(R.string.obfuscated_res_0x7f0f0134, new b(this));
                }
                if (ix1.e() != 0) {
                    aVar.B(R.string.obfuscated_res_0x7f0f12ac, new c(this));
                }
                aVar.X();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky1 a;

        public p(ky1 ky1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ky1Var;
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

    /* loaded from: classes6.dex */
    public class q implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky1 a;

        public q(ky1 ky1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ky1Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755542642, "Lcom/repackage/ky1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755542642, "Lcom/repackage/ky1;");
                return;
            }
        }
        Q0 = rf1.a;
    }

    public ky1() {
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

    public static ky1 p3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? new ky1() : (ky1) invokeV.objValue;
    }

    @Override // com.repackage.ny1
    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.ny1
    public void L2() {
        qy1 V;
        py1 py1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (V = uk2.U().V()) == null || (py1Var = (py1) V.n(py1.class)) == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, py1Var.s3());
        uk2.U().u(new i92("sharebtn", hashMap));
        i3("click", "aboutshare");
    }

    @Override // com.repackage.ny1
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

    @Override // com.repackage.ny1
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
        hz2 a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (activity = uk2.U().getActivity()) == null || (a0 = hz2.a0()) == null) {
            return;
        }
        SwanAppWebPopWindow swanAppWebPopWindow = this.P0;
        if (swanAppWebPopWindow == null || !swanAppWebPopWindow.y()) {
            SwanAppWebPopWindow swanAppWebPopWindow2 = new SwanAppWebPopWindow(activity, "https://baozhang.baidu.com/guarantee/baoshowdetail?appkey=" + a0.N());
            this.P0 = swanAppWebPopWindow2;
            swanAppWebPopWindow2.r0(R.string.obfuscated_res_0x7f0f123b);
            swanAppWebPopWindow2.n0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_BOTTOM);
            swanAppWebPopWindow2.o0();
            swanAppWebPopWindow2.m0();
            swanAppWebPopWindow2.t0();
        }
    }

    public final void c3() {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (activity = uk2.U().getActivity()) == null || hz2.a0() == null) {
            return;
        }
        SwanAppWebPopWindow swanAppWebPopWindow = this.P0;
        if (swanAppWebPopWindow == null || !swanAppWebPopWindow.y()) {
            SwanAppWebPopWindow swanAppWebPopWindow2 = new SwanAppWebPopWindow(activity, this.M0);
            this.P0 = swanAppWebPopWindow2;
            swanAppWebPopWindow2.s0(H(R.string.obfuscated_res_0x7f0f1269));
            swanAppWebPopWindow2.p0(activity.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07063c));
            swanAppWebPopWindow2.n0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_RIGHT);
            swanAppWebPopWindow2.m0();
            swanAppWebPopWindow2.t0();
            i3("click", "servicenote");
        }
    }

    @Override // com.repackage.ny1
    public boolean d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void d3() {
        hz2 a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (a0 = hz2.a0()) == null) {
            return;
        }
        ek2.a V = a0.V();
        String J = V.J();
        String F = V.F();
        if (!TextUtils.isEmpty(J) && !TextUtils.isEmpty(F)) {
            String h2 = bd3.h(J, F);
            UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
            unitedSchemeMainDispatcher.setDynamicDispatcher("swanAPI", new e03());
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
        String str = gz2.J().r().V().f0().webUrl;
        if (TextUtils.isEmpty(str)) {
            cd3.b(this.i0).c("");
            zy2.f(this.i0, R.string.obfuscated_res_0x7f0f1334).G();
            return;
        }
        String a3 = a3(str, hp2.b(bd3.n()));
        int i2 = R.string.obfuscated_res_0x7f0f1335;
        if (a3.length() > 4000) {
            i2 = R.string.obfuscated_res_0x7f0f1336;
        } else {
            str = a3;
        }
        cd3.b(this.i0).c(str);
        zy2.f(this.i0, i2).G();
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
            if (gv2.H()) {
                if (Q0) {
                    Log.d("SwanAppAboutFragment", "in debug mode cannot add favor");
                }
                zy2.f(getContext(), R.string.obfuscated_res_0x7f0f0127).G();
                return;
            }
            String e2 = bd3.n().e();
            SwanFavorDataManager.h().b(str, new h(this, e2));
            xo2.p("aboutconcern", e2);
        }
    }

    public final void h3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            SwanFavorDataManager h2 = SwanFavorDataManager.h();
            g gVar = new g(this);
            c92 l2 = c92.l();
            l2.n(3);
            h2.c(str, gVar, l2.k());
            i3("click", "aboutmove");
        }
    }

    @Override // com.repackage.ny1
    public void i2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && X1()) {
            l3();
            this.m0.s(oi2.M().a());
        }
    }

    public final void i3(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            k63 k63Var = new k63();
            if (!TextUtils.isEmpty(str)) {
                k63Var.b = str;
            }
            if (!TextUtils.isEmpty(str2)) {
                k63Var.e = str2;
            }
            z1(k63Var);
        }
    }

    public final void j3(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view2) == null) {
            String b2 = ly1.b();
            u73 a2 = ly1.a();
            Button button = (Button) view2.findViewById(R.id.obfuscated_res_0x7f090439);
            button.setVisibility(0);
            if (a2.getInt(b2, -1) == 1) {
                button.setText(R.string.obfuscated_res_0x7f0f127e);
            } else {
                button.setText(R.string.obfuscated_res_0x7f0f127f);
            }
            button.setOnClickListener(new b(this, a2, b2, new a(this, a2, b2)));
        }
    }

    public final void k3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            yc3.M(this.G0, this.H0, String.valueOf(i2));
        }
    }

    public void l3() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (activity = getActivity()) != null && this.m0 == null) {
            m54 m54Var = new m54(activity, this.l0, 13, oi2.K(), new qe3());
            this.m0 = m54Var;
            m54Var.q(bd3.P());
            new xo2(this.m0, this).z();
        }
    }

    public final void m3(View view2) {
        hz2 a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, view2) == null) || (a0 = hz2.a0()) == null || a0.V() == null) {
            return;
        }
        ek2.a V = a0.V();
        this.F0 = (SwanAppRoundedImageView) view2.findViewById(R.id.obfuscated_res_0x7f090195);
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901a4);
        textView.setText(V.K());
        if (V.G() == 0) {
            ke3.a(textView, new i(this));
        }
        us2.j().n().h(textView);
        TextView textView2 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09018c);
        textView2.setText(V.e1());
        Button button = (Button) view2.findViewById(R.id.obfuscated_res_0x7f091ca4);
        button.setOnClickListener(this);
        Button button2 = (Button) view2.findViewById(R.id.obfuscated_res_0x7f090108);
        this.N0 = button2;
        button2.setOnClickListener(this);
        y3();
        if (oi2.y0().d()) {
            button.setVisibility(8);
            this.N0.setVisibility(8);
        }
        if (!oi2.t().b()) {
            this.N0.setVisibility(8);
        }
        qy1 V2 = uk2.U().V();
        if (V2 == null) {
            return;
        }
        if (V2.n(pi2.c().a()) != null) {
            button.setVisibility(8);
            this.N0.setVisibility(8);
        }
        fe4.b().a(textView2);
        ((TextView) view2.findViewById(R.id.obfuscated_res_0x7f091c87)).setText(V.s1());
        ((TextView) view2.findViewById(R.id.obfuscated_res_0x7f091dbc)).setText(V.t1());
        String G = oi2.o().G();
        this.M0 = G;
        if (!TextUtils.isEmpty(G)) {
            View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f09015c);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(this);
        }
        this.O0 = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f091a2a);
        PMSAppInfo f0 = V.f0();
        if (o3(f0)) {
            t3(view2, f0.brandsInfo);
        }
        this.H0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090199);
        this.G0 = (BdBaseImageView) view2.findViewById(R.id.obfuscated_res_0x7f090198);
        this.F0.setImageBitmap(bd3.i(V, "SwanAppAboutFragment", false));
        this.F0.setOnClickListener(this);
        SwanAppBearInfo k1 = V.k1();
        if (k1 != null && k1.isValid()) {
            this.I0 = new ee3(this.i0, view2, k1, R.id.obfuscated_res_0x7f09034e);
        }
        k3(V.getType());
        ((Button) view2.findViewById(R.id.obfuscated_res_0x7f0915ca)).setVisibility(8);
        if (Q0 || uk2.U().N()) {
            View inflate = ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f090164)).inflate();
            if (X1() && (inflate instanceof Button)) {
                ((Button) inflate).setText(V.m0() ? R.string.obfuscated_res_0x7f0f0111 : R.string.obfuscated_res_0x7f0f019d);
            }
            inflate.setOnClickListener(new j(this));
            if (!X1()) {
                ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f090165)).inflate().setOnClickListener(new k(this));
            }
            if (X1()) {
                ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f090167)).inflate().setOnClickListener(new l(this, V, a0));
            }
            if (X1()) {
                View inflate2 = ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f090169)).inflate();
                if (inflate2 instanceof Button) {
                    Button button3 = (Button) inflate2;
                    button3.setText(R.string.obfuscated_res_0x7f0f00e6);
                    button3.setOnClickListener(new m(this));
                }
            }
            if (os2.e().f()) {
                View inflate3 = ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f090166)).inflate();
                if (inflate3 instanceof Button) {
                    Button button4 = (Button) inflate3;
                    button4.setText(R.string.obfuscated_res_0x7f0f0147);
                    button4.setOnClickListener(new n(this));
                }
            }
            View inflate4 = ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f090168)).inflate();
            if (inflate4 instanceof Button) {
                ((Button) inflate4).setText(R.string.obfuscated_res_0x7f0f0149);
            }
            inflate4.setOnClickListener(new o(this));
            if (!X1()) {
                j3(view2);
            }
        }
        if (n3(f0)) {
            ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090299);
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, pMSAppInfo)) == null) ? (gz2.J().l() != 0 || pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.brandsInfo)) ? false : true : invokeL.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, view2) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f090195) {
                s3();
            } else if (id == R.id.obfuscated_res_0x7f0915ca) {
                d3();
            } else if (id == R.id.obfuscated_res_0x7f0903eb) {
                SchemeRouter.invoke(getContext(), this.K0);
                i3("click", com.xiaomi.mipush.sdk.Constants.PHONE_BRAND);
            } else if (id == R.id.obfuscated_res_0x7f09015c) {
                c3();
            } else if (id == R.id.obfuscated_res_0x7f091ca4) {
                L2();
            } else if (id == R.id.obfuscated_res_0x7f090108) {
                q3();
            }
        }
    }

    @Override // com.repackage.ny1, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onPause();
            f3();
        }
    }

    @Override // com.repackage.ny1, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onResume();
            ee3 ee3Var = this.I0;
            if (ee3Var != null) {
                ee3Var.c();
            }
            G2(1);
            m54 m54Var = this.m0;
            if (m54Var != null && m54Var.j()) {
                this.m0.C(oi2.M().a());
            }
            if (this.N0 != null) {
                y3();
            }
        }
    }

    public final void q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            String N = gz2.J().r().N();
            if (TextUtils.isEmpty(N)) {
                return;
            }
            if (f62.n(N)) {
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
        hz2 a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (a0 = hz2.a0()) == null) {
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
                    LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0903eb);
                    linearLayout.setOnClickListener(this);
                    linearLayout.setVisibility(0);
                    ((TextView) view2.findViewById(R.id.obfuscated_res_0x7f0903e9)).setText(this.L0);
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
            String g2 = ac3.g(this.i0);
            zy2.g(AppRuntime.getAppContext(), g2).F();
            hw1.k("SwanAppAboutFragment", "showExtraInfo\n" + g2);
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
            px2.c(new e(this, swanAppRelatedSwanListAdapter));
        }
    }

    public final void w3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            if (Q0) {
                Log.d("SwanAppAboutFragment", "startAboutFragment");
            }
            qy1 V = uk2.U().V();
            if (V == null) {
                zy2.f(getContext(), R.string.obfuscated_res_0x7f0f019f).G();
                return;
            }
            qy1.b i2 = V.i("navigateTo");
            i2.n(qy1.g, qy1.i);
            i2.k("running_info", null).a();
        }
    }

    public final void x3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || hz2.a0() == null) {
            return;
        }
        dy1.a(hz2.a0(), this.i0, new f(this));
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View y0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048609, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d008d, viewGroup, false);
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
            if (f62.n(gz2.J().getAppId())) {
                this.N0.setText(R.string.obfuscated_res_0x7f0f12c5);
                this.N0.setTextColor(AppCompatResources.getColorStateList(getContext(), R.color.obfuscated_res_0x7f060a2f));
                this.N0.setBackgroundResource(R.drawable.obfuscated_res_0x7f08112b);
                return;
            }
            this.N0.setText(R.string.obfuscated_res_0x7f0f1291);
            this.N0.setTextColor(-1);
            this.N0.setBackgroundResource(R.drawable.obfuscated_res_0x7f081129);
        }
    }
}
