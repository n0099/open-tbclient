package d.a.q0.a.h0.h;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.SystemClock;
import android.text.ClipboardManager;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.h0.h.a;
import d.a.q0.a.h0.h.c;
import d.a.q0.a.h0.h.d;
import d.a.q0.a.z1.b.b.b;
import d.a.q0.a.z1.b.b.h;
import java.util.Date;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f48049c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f48050a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.q0.a.h0.h.a f48051b;

    /* loaded from: classes8.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f48052e;

        public a(b bVar, s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48052e = sVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            s sVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (sVar = this.f48052e) == null) {
                return;
            }
            sVar.onCancel();
        }
    }

    /* renamed from: d.a.q0.a.h0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class DialogInterface$OnClickListenerC0783b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f48053e;

        public DialogInterface$OnClickListenerC0783b(b bVar, s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48053e = sVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            s sVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) || (sVar = this.f48053e) == null) {
                return;
            }
            sVar.b("");
        }
    }

    /* loaded from: classes8.dex */
    public class c implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f48054e;

        public c(b bVar, s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48054e = sVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            s sVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (sVar = this.f48054e) == null) {
                return;
            }
            sVar.onCancel();
        }
    }

    /* loaded from: classes8.dex */
    public class d implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f48055e;

        public d(b bVar, s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48055e = sVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            s sVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) || (sVar = this.f48055e) == null) {
                return;
            }
            sVar.onCancel();
        }
    }

    /* loaded from: classes8.dex */
    public class e implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f48056e;

        public e(b bVar, s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48056e = sVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            s sVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) || (sVar = this.f48056e) == null) {
                return;
            }
            sVar.b("");
        }
    }

    /* loaded from: classes8.dex */
    public class f implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f48057e;

        public f(b bVar, s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48057e = sVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            s sVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (sVar = this.f48057e) == null) {
                return;
            }
            sVar.onCancel();
        }
    }

    /* loaded from: classes8.dex */
    public class g implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f48058e;

        public g(b bVar, s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48058e = sVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            s sVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) || (sVar = this.f48058e) == null) {
                return;
            }
            sVar.onCancel();
        }
    }

    /* loaded from: classes8.dex */
    public class h implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f48059e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditText f48060f;

        public h(b bVar, s sVar, EditText editText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, sVar, editText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48059e = sVar;
            this.f48060f = editText;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            s sVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) || (sVar = this.f48059e) == null) {
                return;
            }
            sVar.b(this.f48060f.getText().toString());
        }
    }

    /* loaded from: classes8.dex */
    public class i implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r f48061a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f48062b;

        public i(b bVar, r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48062b = bVar;
            this.f48061a = rVar;
        }

        @Override // d.a.q0.a.h0.h.a.f
        public void a(String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, str3, str4) == null) {
                r rVar = this.f48061a;
                if (rVar != null) {
                    rVar.b(str3, str4);
                }
                this.f48062b.f48051b = null;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r f48063a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f48064b;

        public j(b bVar, r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48064b = bVar;
            this.f48063a = rVar;
        }

        @Override // d.a.q0.a.h0.h.a.e
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                r rVar = this.f48063a;
                if (rVar != null) {
                    rVar.a();
                }
                this.f48064b.f48051b = null;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SslErrorHandler f48065e;

        public k(b bVar, SslErrorHandler sslErrorHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, sslErrorHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48065e = sslErrorHandler;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f48065e.cancel();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f48066a;

        public l(b bVar, t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48066a = tVar;
        }

        @Override // d.a.q0.a.z1.b.b.b.c
        public void a(View view) {
            t tVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (tVar = this.f48066a) == null) {
                return;
            }
            tVar.c();
        }
    }

    /* loaded from: classes8.dex */
    public class m implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f48067a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SslErrorHandler f48068b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SslError f48069c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f48070d;

        public m(b bVar, t tVar, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, tVar, sslErrorHandler, sslError};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48070d = bVar;
            this.f48067a = tVar;
            this.f48068b = sslErrorHandler;
            this.f48069c = sslError;
        }

        @Override // d.a.q0.a.z1.b.b.b.c
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f48070d.o(this.f48067a, this.f48068b, this.f48069c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class n implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f48071a;

        public n(b bVar, t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48071a = tVar;
        }

        @Override // d.a.q0.a.z1.b.b.b.c
        public void a(View view) {
            t tVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (tVar = this.f48071a) == null) {
                return;
            }
            tVar.b();
        }
    }

    /* loaded from: classes8.dex */
    public class o implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long[] f48072a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SslError f48073b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f48074c;

        public o(b bVar, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, sslError};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48074c = bVar;
            this.f48073b = sslError;
            this.f48072a = null;
        }

        @Override // d.a.q0.a.z1.b.b.b.c
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f48072a == null) {
                    this.f48072a = new long[5];
                }
                long[] jArr = this.f48072a;
                System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
                long[] jArr2 = this.f48072a;
                jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
                if (this.f48072a[0] >= SystemClock.uptimeMillis() - 3000) {
                    this.f48072a = null;
                    this.f48074c.g(this.f48073b.toString());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class p implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t f48075e;

        public p(b bVar, t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48075e = tVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            t tVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (tVar = this.f48075e) == null) {
                return;
            }
            tVar.a();
        }
    }

    /* loaded from: classes8.dex */
    public class q implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f48076a;

        public q(b bVar, t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48076a = tVar;
        }

        @Override // d.a.q0.a.z1.b.b.b.c
        public void a(View view) {
            t tVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (tVar = this.f48076a) == null) {
                return;
            }
            tVar.a();
        }
    }

    /* loaded from: classes8.dex */
    public interface r {
        void a();

        void b(String str, String str2);
    }

    /* loaded from: classes8.dex */
    public interface s {
        void a();

        void b(String str);

        void onCancel();
    }

    /* loaded from: classes8.dex */
    public interface t {
        void a();

        void b();

        void c();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(705447022, "Ld/a/q0/a/h0/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(705447022, "Ld/a/q0/a/h0/h/b;");
                return;
            }
        }
        f48049c = d.a.q0.a.k.f49133a;
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f48050a = context;
    }

    public final void c(LinearLayout linearLayout, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, linearLayout, i2) == null) {
            d(linearLayout, i2, d.a.q0.a.e.aiapps_dialog_browser_security_good);
        }
    }

    public final void d(LinearLayout linearLayout, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linearLayout, i2, i3) == null) {
            View inflate = LayoutInflater.from(this.f48050a).inflate(d.a.q0.a.g.aiapps_ssl_content_header, (ViewGroup) linearLayout, false);
            TextView textView = (TextView) inflate.findViewById(d.a.q0.a.f.ssl_header_text);
            textView.setTextColor(inflate.getContext().getResources().getColor(d.a.q0.a.c.aiapps_safe_dialog_message));
            textView.setText(i2);
            ((BdBaseImageView) inflate.findViewById(d.a.q0.a.f.ssl_header_icon)).setImageResource(i3);
            linearLayout.addView(inflate);
        }
    }

    public final void e(LinearLayout linearLayout, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, linearLayout, i2) == null) {
            d(linearLayout, i2, d.a.q0.a.e.aiapps_dialog_browser_security_bad);
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Context context = this.f48050a;
            return (context instanceof Activity) && !((Activity) context).isFinishing();
        }
        return invokeV.booleanValue;
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            ((ClipboardManager) this.f48050a.getSystemService("clipboard")).setText(str);
            d.a.q0.a.z1.b.f.e.f(this.f48050a, d.a.q0.a.h.aiapps_ssl_copy_error).F();
        }
    }

    public final d.a h(SslCertificate sslCertificate, SslError sslError) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, sslCertificate, sslError)) == null) {
            View j2 = j(sslCertificate);
            LinearLayout linearLayout = (LinearLayout) j2.findViewById(d.a.q0.a.f.placeholder);
            j2.findViewById(d.a.q0.a.f.ssl_divider).setBackgroundColor(this.f48050a.getResources().getColor(d.a.q0.a.c.aiapps_dialog_gray));
            if (sslError == null) {
                c(linearLayout, d.a.q0.a.h.aiapps_ssl_certificate_is_valid);
            } else {
                if (sslError.hasError(3)) {
                    e(linearLayout, d.a.q0.a.h.aiapps_ssl_untrusted);
                }
                if (sslError.hasError(2)) {
                    e(linearLayout, d.a.q0.a.h.aiapps_ssl_mismatch);
                }
                if (sslError.hasError(1)) {
                    e(linearLayout, d.a.q0.a.h.aiapps_ssl_expired);
                }
                if (sslError.hasError(0)) {
                    e(linearLayout, d.a.q0.a.h.aiapps_ssl_not_yet_valid);
                }
                if (sslError.hasError(4)) {
                    e(linearLayout, d.a.q0.a.h.aiapps_ssl_date_invalid);
                }
                if (sslError.hasError(5)) {
                    e(linearLayout, d.a.q0.a.h.aiapps_ssl_invalid);
                }
                if (linearLayout.getChildCount() == 0) {
                    e(linearLayout, d.a.q0.a.h.aiapps_ssl_unknown);
                }
            }
            d.a aVar = new d.a(this.f48050a);
            aVar.d0(d.a.q0.a.h.aiapps_ssl_certificate);
            aVar.c0(j2);
            return aVar;
        }
        return (d.a) invokeLL.objValue;
    }

    public final String i(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, date)) == null) ? date == null ? "" : DateFormat.getDateFormat(this.f48050a).format(date) : (String) invokeL.objValue;
    }

    public final View j(SslCertificate sslCertificate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, sslCertificate)) == null) {
            View inflate = LayoutInflater.from(this.f48050a).inflate(d.a.q0.a.g.aiapps_ssl_certificate, (ViewGroup) null);
            int color = this.f48050a.getResources().getColor(d.a.q0.a.c.aiapps_safe_dialog_message);
            ViewGroup viewGroup = (ViewGroup) inflate.findViewById(d.a.q0.a.f.body);
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextColor(color);
                    textView.setTextSize(14.0f);
                }
            }
            SslCertificate.DName issuedTo = sslCertificate.getIssuedTo();
            if (issuedTo != null) {
                ((TextView) inflate.findViewById(d.a.q0.a.f.to_common)).setText(issuedTo.getCName());
                ((TextView) inflate.findViewById(d.a.q0.a.f.to_org)).setText(issuedTo.getOName());
                ((TextView) inflate.findViewById(d.a.q0.a.f.to_org_unit)).setText(issuedTo.getUName());
            }
            SslCertificate.DName issuedBy = sslCertificate.getIssuedBy();
            if (issuedBy != null) {
                ((TextView) inflate.findViewById(d.a.q0.a.f.by_common)).setText(issuedBy.getCName());
                ((TextView) inflate.findViewById(d.a.q0.a.f.by_org)).setText(issuedBy.getOName());
                ((TextView) inflate.findViewById(d.a.q0.a.f.by_org_unit)).setText(issuedBy.getUName());
            }
            ((TextView) inflate.findViewById(d.a.q0.a.f.issued_on)).setText(i(sslCertificate.getValidNotBeforeDate()));
            ((TextView) inflate.findViewById(d.a.q0.a.f.expires_on)).setText(i(sslCertificate.getValidNotAfterDate()));
            return inflate;
        }
        return (View) invokeL.objValue;
    }

    public void k(r rVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rVar, str, str2) == null) {
            d.a.q0.a.h0.h.a aVar = new d.a.q0.a.h0.h.a(this.f48050a, str, str2);
            this.f48051b = aVar;
            aVar.h(new i(this, rVar));
            this.f48051b.g(new j(this, rVar));
            this.f48051b.i();
        }
    }

    public boolean l(String str, String str2, s sVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, str, str2, sVar)) == null) {
            if (!f()) {
                if (f48049c) {
                    Log.e("PageDialogsHandler", "can not showJsAlert");
                }
                if (sVar != null) {
                    sVar.a();
                }
                return false;
            }
            h.a aVar = new h.a(this.f48050a);
            aVar.U(d.a.q0.a.h.aiapps_dialog_webcall_common_title);
            aVar.x(str2);
            aVar.O(d.a.q0.a.h.aiapps_confirm, new DialogInterface$OnClickListenerC0783b(this, sVar));
            aVar.K(new a(this, sVar));
            if (d.a.q0.a.c1.a.H().a()) {
                aVar.Y(false);
            } else {
                aVar.Y(true);
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public boolean m(String str, String str2, s sVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, str, str2, sVar)) == null) {
            if (!f()) {
                if (f48049c) {
                    Log.e("PageDialogsHandler", "can not showJsConfirm");
                }
                if (sVar != null) {
                    sVar.a();
                }
                return false;
            }
            h.a aVar = new h.a(this.f48050a);
            aVar.U(d.a.q0.a.h.aiapps_dialog_webcall_common_title);
            aVar.x(str2);
            aVar.O(d.a.q0.a.h.aiapps_confirm, new e(this, sVar));
            aVar.B(d.a.q0.a.h.aiapps_cancel, new d(this, sVar));
            aVar.K(new c(this, sVar));
            if (d.a.q0.a.c1.a.H().a()) {
                aVar.Y(false);
            } else {
                aVar.Y(true);
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public boolean n(String str, String str2, String str3, s sVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, str, str2, str3, sVar)) == null) {
            if (!f()) {
                if (sVar != null) {
                    sVar.a();
                }
                return false;
            }
            View inflate = LayoutInflater.from(this.f48050a).inflate(d.a.q0.a.g.aiapps_js_prompt, (ViewGroup) null);
            EditText editText = (EditText) inflate.findViewById(d.a.q0.a.f.value);
            editText.setText(str3);
            ((TextView) inflate.findViewById(d.a.q0.a.f.message)).setText(str2);
            h.a aVar = new h.a(this.f48050a);
            aVar.U(d.a.q0.a.h.aiapps_dialog_webcall_common_title);
            aVar.W(inflate);
            aVar.O(d.a.q0.a.h.aiapps_confirm, new h(this, sVar, editText));
            aVar.B(d.a.q0.a.h.aiapps_cancel, new g(this, sVar));
            aVar.K(new f(this, sVar));
            if (d.a.q0.a.c1.a.H().a()) {
                aVar.Y(false);
            } else {
                aVar.Y(true);
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(t tVar, SslErrorHandler sslErrorHandler, SslError sslError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, tVar, sslErrorHandler, sslError) == null) {
            if (!f()) {
                sslErrorHandler.cancel();
                return;
            }
            SslCertificate certificate = sslError.getCertificate();
            if (certificate == null) {
                return;
            }
            d.a h2 = h(certificate, sslError);
            h2.a0(new b.a(this.f48050a.getText(d.a.q0.a.h.aiapps_confirm_text), d.a.q0.a.c.aiapps_safe_dialog_btn_black, new q(this, tVar)));
            h2.K(new p(this, tVar));
            h2.X();
        }
    }

    public void p(t tVar, SslErrorHandler sslErrorHandler, SslError sslError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, tVar, sslErrorHandler, sslError) == null) {
            if (!f()) {
                sslErrorHandler.cancel();
                return;
            }
            c.C0784c c0784c = new c.C0784c(this.f48050a);
            c0784c.g0(d.a.q0.a.h.aiapps_security_warning);
            c0784c.f0(d.a.q0.a.h.aiapps_ssl_warnings_header, new o(this, sslError));
            c0784c.a0(new b.a(this.f48050a.getText(d.a.q0.a.h.aiapps_ssl_continue), d.a.q0.a.c.aiapps_ssl_dialog_go_on_text_color, new n(this, tVar)));
            c0784c.a0(new b.a(this.f48050a.getText(d.a.q0.a.h.aiapps_view_certificate), d.a.q0.a.c.aiapps_safe_dialog_btn_black, new m(this, tVar, sslErrorHandler, sslError)));
            c0784c.a0(new b.a(this.f48050a.getText(d.a.q0.a.h.aiapps_ssl_go_back), d.a.q0.a.c.aiapps_safe_dialog_btn_black, new l(this, tVar)));
            c0784c.K(new k(this, sslErrorHandler));
            c0784c.X();
        }
    }
}
