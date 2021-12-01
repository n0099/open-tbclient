package com.ss.android.socialbase.appdownloader.e;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.appdownloader.c.n;
import com.ss.android.socialbase.appdownloader.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "d";

    /* renamed from: b  reason: collision with root package name */
    public static List<n> f61527b;

    /* renamed from: c  reason: collision with root package name */
    public static com.ss.android.socialbase.appdownloader.view.a f61528c;

    /* renamed from: d  reason: collision with root package name */
    public static AlertDialog f61529d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1108220522, "Lcom/ss/android/socialbase/appdownloader/e/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1108220522, "Lcom/ss/android/socialbase/appdownloader/e/d;");
                return;
            }
        }
        f61527b = new ArrayList();
    }

    public d() {
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

    public static void b(@NonNull Activity activity, @NonNull n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, activity, nVar) == null) {
            if (activity != null) {
                try {
                    if (!activity.isFinishing()) {
                        FragmentManager fragmentManager = activity.getFragmentManager();
                        com.ss.android.socialbase.appdownloader.view.a aVar = (com.ss.android.socialbase.appdownloader.view.a) fragmentManager.findFragmentByTag(a);
                        f61528c = aVar;
                        if (aVar == null) {
                            f61528c = new com.ss.android.socialbase.appdownloader.view.a();
                            fragmentManager.beginTransaction().add(f61528c, a).commitAllowingStateLoss();
                            fragmentManager.executePendingTransactions();
                        }
                        f61528c.a();
                        return;
                    }
                } catch (Throwable th) {
                    try {
                        th.printStackTrace();
                        nVar.a();
                        return;
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                        return;
                    }
                }
            }
            nVar.a();
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            try {
                return NotificationManagerCompat.from(com.ss.android.socialbase.downloader.downloader.c.N()).areNotificationsEnabled();
            } catch (Throwable th) {
                th.printStackTrace();
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public static synchronized void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z) == null) {
            synchronized (d.class) {
                try {
                    if (f61529d != null) {
                        f61529d.cancel();
                        f61529d = null;
                    }
                    for (n nVar : f61527b) {
                        if (nVar != null) {
                            if (z) {
                                nVar.a();
                            } else {
                                nVar.b();
                            }
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static synchronized void a(@NonNull Activity activity, @NonNull n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, activity, nVar) == null) {
            synchronized (d.class) {
                if (nVar == null) {
                    return;
                }
                if (activity != null) {
                    try {
                    } catch (Throwable th) {
                        th.printStackTrace();
                        a(false);
                    }
                    if (!activity.isFinishing()) {
                        int a2 = i.a(com.ss.android.socialbase.downloader.downloader.c.N(), "tt_appdownloader_notification_request_title");
                        int a3 = i.a(com.ss.android.socialbase.downloader.downloader.c.N(), "tt_appdownloader_notification_request_message");
                        int a4 = i.a(com.ss.android.socialbase.downloader.downloader.c.N(), "tt_appdownloader_notification_request_btn_yes");
                        int a5 = i.a(com.ss.android.socialbase.downloader.downloader.c.N(), "tt_appdownloader_notification_request_btn_no");
                        f61527b.add(nVar);
                        if (f61529d == null || !f61529d.isShowing()) {
                            f61529d = new AlertDialog.Builder(activity).setTitle(a2).setMessage(a3).setPositiveButton(a4, new DialogInterface.OnClickListener(activity, nVar) { // from class: com.ss.android.socialbase.appdownloader.e.d.3
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ Activity a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ n f61530b;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {activity, nVar};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.a = activity;
                                    this.f61530b = nVar;
                                }

                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i2) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i2) == null) {
                                        d.b(this.a, this.f61530b);
                                        dialogInterface.cancel();
                                        AlertDialog unused = d.f61529d = null;
                                    }
                                }
                            }).setNegativeButton(a5, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.e.d.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                        }
                                    }
                                }

                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i2) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i2) == null) {
                                        d.a(false);
                                    }
                                }
                            }).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.ss.android.socialbase.appdownloader.e.d.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                        }
                                    }
                                }

                                @Override // android.content.DialogInterface.OnKeyListener
                                public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                                    InterceptResult invokeLIL;
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048576, this, dialogInterface, i2, keyEvent)) == null) {
                                        if (i2 == 4) {
                                            if (keyEvent.getAction() == 1) {
                                                d.a(false);
                                            }
                                            return true;
                                        }
                                        return false;
                                    }
                                    return invokeLIL.booleanValue;
                                }
                            }).setCancelable(false).show();
                        }
                        return;
                    }
                }
                nVar.b();
            }
        }
    }
}
