package d.l.a.e.a.f;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.l.a.e.a.d;
import d.l.a.e.a.l;
import d.l.a.e.b.g.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f74589a = "c";

    /* renamed from: b  reason: collision with root package name */
    public static List<d.p> f74590b;

    /* renamed from: c  reason: collision with root package name */
    public static com.ss.android.socialbase.appdownloader.view.a f74591c;

    /* renamed from: d  reason: collision with root package name */
    public static AlertDialog f74592d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static class a implements DialogInterface.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i2, keyEvent)) == null) {
                if (i2 == 4) {
                    if (keyEvent.getAction() == 1) {
                        c.c(false);
                    }
                    return true;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                c.c(false);
            }
        }
    }

    /* renamed from: d.l.a.e.a.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class DialogInterface$OnClickListenerC2070c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f74593e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.p f74594f;

        public DialogInterface$OnClickListenerC2070c(Activity activity, d.p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, pVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74593e = activity;
            this.f74594f = pVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                c.e(this.f74593e, this.f74594f);
                dialogInterface.cancel();
                AlertDialog unused = c.f74592d = null;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1770940129, "Ld/l/a/e/a/f/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1770940129, "Ld/l/a/e/a/f/c;");
                return;
            }
        }
        f74590b = new ArrayList();
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static synchronized void b(@NonNull Activity activity, @NonNull d.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, activity, pVar) == null) {
            synchronized (c.class) {
                if (pVar == null) {
                    return;
                }
                if (activity != null) {
                    try {
                    } catch (Throwable th) {
                        th.printStackTrace();
                        c(false);
                    }
                    if (!activity.isFinishing()) {
                        int a2 = l.a(e.n(), "tt_appdownloader_notification_request_title");
                        int a3 = l.a(e.n(), "tt_appdownloader_notification_request_message");
                        int a4 = l.a(e.n(), "tt_appdownloader_notification_request_btn_yes");
                        int a5 = l.a(e.n(), "tt_appdownloader_notification_request_btn_no");
                        f74590b.add(pVar);
                        if (f74592d == null || !f74592d.isShowing()) {
                            f74592d = new AlertDialog.Builder(activity).setTitle(a2).setMessage(a3).setPositiveButton(a4, new DialogInterface$OnClickListenerC2070c(activity, pVar)).setNegativeButton(a5, new b()).setOnKeyListener(new a()).setCancelable(false).show();
                        }
                        return;
                    }
                }
                pVar.b();
            }
        }
    }

    public static synchronized void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65540, null, z) == null) {
            synchronized (c.class) {
                try {
                    if (f74592d != null) {
                        f74592d.cancel();
                        f74592d = null;
                    }
                    for (d.p pVar : f74590b) {
                        if (pVar != null) {
                            if (z) {
                                pVar.a();
                            } else {
                                pVar.b();
                            }
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            try {
                return NotificationManagerCompat.from(e.n()).areNotificationsEnabled();
            } catch (Throwable th) {
                th.printStackTrace();
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public static void e(@NonNull Activity activity, @NonNull d.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, activity, pVar) == null) {
            if (activity != null) {
                try {
                    if (!activity.isFinishing()) {
                        FragmentManager fragmentManager = activity.getFragmentManager();
                        com.ss.android.socialbase.appdownloader.view.a aVar = (com.ss.android.socialbase.appdownloader.view.a) fragmentManager.findFragmentByTag(f74589a);
                        f74591c = aVar;
                        if (aVar == null) {
                            f74591c = new com.ss.android.socialbase.appdownloader.view.a();
                            fragmentManager.beginTransaction().add(f74591c, f74589a).commitAllowingStateLoss();
                            fragmentManager.executePendingTransactions();
                        }
                        f74591c.a();
                        return;
                    }
                } catch (Throwable th) {
                    try {
                        th.printStackTrace();
                        pVar.a();
                        return;
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                        return;
                    }
                }
            }
            pVar.a();
        }
    }
}
