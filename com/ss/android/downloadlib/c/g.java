package com.ss.android.downloadlib.c;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.download.api.model.b;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.socialbase.appdownloader.c.k;
import com.ss.android.socialbase.appdownloader.c.l;
/* loaded from: classes2.dex */
public class g extends com.ss.android.socialbase.appdownloader.c.a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f68741a = "g";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Dialog f68749a;

        public a(Dialog dialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (dialog != null) {
                this.f68749a = dialog;
                a();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.k
        public void a() {
            Dialog dialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (dialog = this.f68749a) == null) {
                return;
            }
            dialog.show();
        }

        @Override // com.ss.android.socialbase.appdownloader.c.k
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                Dialog dialog = this.f68749a;
                if (dialog != null) {
                    return dialog.isShowing();
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1671022279, "Lcom/ss/android/downloadlib/c/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1671022279, "Lcom/ss/android/downloadlib/c/g;");
        }
    }

    public g() {
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

    @Override // com.ss.android.socialbase.appdownloader.c.a, com.ss.android.socialbase.appdownloader.c.c
    public l a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? new l(this, context) { // from class: com.ss.android.downloadlib.c.g.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f68742a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ g f68743b;

            /* renamed from: c  reason: collision with root package name */
            public b.a f68744c;

            /* renamed from: d  reason: collision with root package name */
            public DialogInterface.OnClickListener f68745d;

            /* renamed from: e  reason: collision with root package name */
            public DialogInterface.OnClickListener f68746e;

            /* renamed from: f  reason: collision with root package name */
            public DialogInterface.OnCancelListener f68747f;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, context};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f68743b = this;
                this.f68742a = context;
                this.f68744c = new b.a(this.f68742a);
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                    this.f68744c.a(this.f68742a.getResources().getString(i2));
                    return this;
                }
                return (l) invokeI.objValue;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l b(int i2, DialogInterface.OnClickListener onClickListener) {
                InterceptResult invokeIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeIL = interceptable2.invokeIL(1048582, this, i2, onClickListener)) == null) {
                    this.f68744c.d(this.f68742a.getResources().getString(i2));
                    this.f68746e = onClickListener;
                    return this;
                }
                return (l) invokeIL.objValue;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(String str) {
                InterceptResult invokeL2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                    this.f68744c.b(str);
                    return this;
                }
                return (l) invokeL2.objValue;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(int i2, DialogInterface.OnClickListener onClickListener) {
                InterceptResult invokeIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeIL = interceptable2.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, onClickListener)) == null) {
                    this.f68744c.c(this.f68742a.getResources().getString(i2));
                    this.f68745d = onClickListener;
                    return this;
                }
                return (l) invokeIL.objValue;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(DialogInterface.OnCancelListener onCancelListener) {
                InterceptResult invokeL2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, onCancelListener)) == null) {
                    this.f68747f = onCancelListener;
                    return this;
                }
                return (l) invokeL2.objValue;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(boolean z) {
                InterceptResult invokeZ;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeZ = interceptable2.invokeZ(1048581, this, z)) == null) {
                    this.f68744c.a(z);
                    return this;
                }
                return (l) invokeZ.objValue;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public k a() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    this.f68744c.a(new b.InterfaceC1965b(this) { // from class: com.ss.android.downloadlib.c.g.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass1 f68748a;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f68748a = this;
                        }

                        @Override // com.ss.android.download.api.model.b.InterfaceC1965b
                        public void a(DialogInterface dialogInterface) {
                            Interceptable interceptable3 = $ic;
                            if (!(interceptable3 == null || interceptable3.invokeL(1048576, this, dialogInterface) == null) || this.f68748a.f68745d == null) {
                                return;
                            }
                            this.f68748a.f68745d.onClick(dialogInterface, -1);
                        }

                        @Override // com.ss.android.download.api.model.b.InterfaceC1965b
                        public void b(DialogInterface dialogInterface) {
                            Interceptable interceptable3 = $ic;
                            if (!(interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface) == null) || this.f68748a.f68746e == null) {
                                return;
                            }
                            this.f68748a.f68746e.onClick(dialogInterface, -2);
                        }

                        @Override // com.ss.android.download.api.model.b.InterfaceC1965b
                        public void c(DialogInterface dialogInterface) {
                            Interceptable interceptable3 = $ic;
                            if (!(interceptable3 == null || interceptable3.invokeL(Constants.METHOD_SEND_USER_MSG, this, dialogInterface) == null) || this.f68748a.f68747f == null || dialogInterface == null) {
                                return;
                            }
                            this.f68748a.f68747f.onCancel(dialogInterface);
                        }
                    });
                    com.ss.android.downloadlib.g.k.a(g.f68741a, "getThemedAlertDlgBuilder", null);
                    this.f68744c.a(3);
                    return new a(j.c().b(this.f68744c.a()));
                }
                return (k) invokeV.objValue;
            }
        } : (l) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.a, com.ss.android.socialbase.appdownloader.c.c
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }
}
