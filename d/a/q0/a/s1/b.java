package d.a.q0.a.s1;

import android.content.Context;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppBaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.FreeSpaceBox;
import d.a.q0.a.k2.g.h;
import d.a.q0.a.s1.g;
import d.a.q0.a.v2.a0;
import d.a.q0.a.v2.q0;
import d.a.q0.a.z1.b.b.f;
/* loaded from: classes8.dex */
public final class b implements g.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f50596a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f50597b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f50598c;

    /* renamed from: d  reason: collision with root package name */
    public final int f50599d;

    /* renamed from: e  reason: collision with root package name */
    public final f f50600e;

    /* renamed from: f  reason: collision with root package name */
    public final Context f50601f;

    /* loaded from: classes8.dex */
    public class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50602e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f50603f;

        public a(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50603f = bVar;
            this.f50602e = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) && this.f50603f.f50596a) {
                if (!this.f50603f.f50597b) {
                    this.f50603f.h(this.f50602e, i2, dialogInterface);
                } else {
                    dialogInterface.dismiss();
                }
            }
        }
    }

    /* renamed from: d.a.q0.a.s1.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class DialogInterface$OnClickListenerC0938b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50604e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f50605f;

        public DialogInterface$OnClickListenerC0938b(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50605f = bVar;
            this.f50604e = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f50605f.i(this.f50604e, i2, dialogInterface);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50606e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f50607f;

        public c(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50607f = bVar;
            this.f50606e = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f50607f.h(this.f50606e, i2, dialogInterface);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements DialogInterface.OnShowListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f50608a;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50608a = bVar;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f50608a.f50596a = true;
                this.f50608a.j("show");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50609e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f50610f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f50611g;

        public e(b bVar, String str, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50611g = bVar;
            this.f50609e = str;
            this.f50610f = fVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f50611g.p(this.f50609e, this.f50610f);
                this.f50611g.f50596a = false;
            }
        }
    }

    public b(Context context, int i2, @NonNull f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f50596a = false;
        this.f50597b = false;
        this.f50598c = false;
        this.f50601f = context;
        this.f50599d = i2;
        this.f50600e = fVar;
    }

    public final void h(String str, int i2, DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, dialogInterface) == null) {
            boolean z = i2 == 1;
            r(str, z);
            if (z) {
                j("deny_mute");
            } else {
                j("deny");
            }
            dialogInterface.dismiss();
        }
    }

    public final void i(String str, int i2, DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2, dialogInterface) == null) {
            boolean z = i2 == 1;
            r(str, z);
            if (z) {
                j("skip_mute");
            } else {
                j(FreeSpaceBox.TYPE);
            }
            this.f50597b = true;
            dialogInterface.dismiss();
            a0.g(this.f50601f);
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            d.a.q0.a.a2.d g2 = d.a.q0.a.a2.d.g();
            String appId = g2.getAppId();
            d.a.q0.a.j2.p.e eVar = new d.a.q0.a.j2.p.e();
            eVar.f49124f = appId;
            eVar.f49119a = "swan";
            eVar.f49121c = d.a.q0.a.s1.c.a(this.f50599d);
            eVar.f49125g = "minipnl";
            eVar.f49120b = str;
            eVar.f49123e = d.a.q0.a.s1.c.b(this.f50598c);
            eVar.a("appid", appId);
            eVar.a("appname", g2.r().O());
            eVar.a("host", d.a.q0.a.c1.a.m().a());
            d.a.q0.a.j2.g.onEvent(eVar);
        }
    }

    public final boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? h.a().getBoolean(str, false) : invokeL.booleanValue;
    }

    public final String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            String D = d.a.q0.a.a2.d.g().r().D();
            return "permission/" + str + "/" + D;
        }
        return (String) invokeL.objValue;
    }

    public final String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            Context applicationContext = d.a.q0.a.a2.d.g().getApplicationContext();
            return applicationContext.getString(d.a.q0.a.h.swanapp_perm_hover_dialog_tip, q0.l(applicationContext), str);
        }
        return (String) invokeL.objValue;
    }

    public final String n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? d.a.q0.a.a2.d.g().getApplicationContext().getString(d.a.q0.a.h.swanapp_perm_hover_dialog_title, str) : (String) invokeL.objValue;
    }

    public final d.a.q0.a.z1.b.b.f o(Context context, String str, String str2, String str3, String str4, f fVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{context, str, str2, str3, str4, fVar})) == null) {
            f.a aVar = new f.a(context);
            aVar.f0(str);
            aVar.e0(str2);
            aVar.i0(new e(this, str4, fVar));
            aVar.j0(new d(this));
            aVar.g0(new c(this, str3));
            aVar.k0(new DialogInterface$OnClickListenerC0938b(this, str3));
            aVar.h0(new a(this, str3));
            return aVar.c();
        }
        return (d.a.q0.a.z1.b.b.f) invokeCommon.objValue;
    }

    @Override // d.a.q0.a.s1.g.a
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, strArr, iArr) == null) {
            if (i2 != this.f50599d) {
                this.f50600e.b(2, "request permission fail");
            } else if (strArr.length == 0 && iArr.length == 0) {
                this.f50600e.a("permission granted successful");
            } else if (strArr.length != iArr.length) {
                this.f50600e.b(2, "request permission fail");
            } else if (!(this.f50601f instanceof SwanAppBaseActivity)) {
                this.f50600e.b(2, "request permission fail");
            } else {
                for (int i3 = 0; i3 < iArr.length; i3++) {
                    String str = strArr[i3];
                    if (iArr[i3] == -1) {
                        if (!d.a.q0.o.a.a.a.k((SwanAppBaseActivity) this.f50601f, str)) {
                            q(str, this.f50600e);
                            return;
                        } else {
                            this.f50600e.b(1, "user denied");
                            return;
                        }
                    }
                }
                this.f50600e.a("permission granted successful");
            }
        }
    }

    public final void p(String str, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, fVar) == null) {
            Context context = this.f50601f;
            boolean z = context != null && d.a.q0.u.d.c.a(context, str);
            this.f50598c = z;
            if (z) {
                fVar.a("permission granted successful");
            } else {
                fVar.b(1, "user denied");
            }
        }
    }

    public final void q(String str, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, fVar) == null) {
            if (!(this.f50601f instanceof SwanAppBaseActivity)) {
                this.f50600e.b(2, "request permission fail");
                return;
            }
            String l = l(str);
            if (k(l)) {
                this.f50600e.b(2, "request permission fail");
                return;
            }
            String n = a0.n(str);
            if (n != null && n.trim().length() != 0) {
                o(this.f50601f, n(n), m(n), l, str, fVar).show();
                return;
            }
            this.f50600e.b(2, "request permission fail");
        }
    }

    public final void r(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048587, this, str, z) == null) || str == null) {
            return;
        }
        h.a().putBoolean(str, z);
    }

    public g.a s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? new d.a.q0.a.s1.a(this.f50599d, this.f50600e) : (g.a) invokeV.objValue;
    }
}
