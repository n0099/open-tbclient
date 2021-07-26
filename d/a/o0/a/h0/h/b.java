package d.a.o0.a.h0.h;

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
import d.a.o0.a.h0.h.a;
import d.a.o0.a.h0.h.c;
import d.a.o0.a.h0.h.d;
import d.a.o0.a.z1.b.b.b;
import d.a.o0.a.z1.b.b.h;
import java.util.Date;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f45251c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f45252a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.a.h0.h.a f45253b;

    /* loaded from: classes7.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f45254e;

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
            this.f45254e = sVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            s sVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (sVar = this.f45254e) == null) {
                return;
            }
            sVar.onCancel();
        }
    }

    /* renamed from: d.a.o0.a.h0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class DialogInterface$OnClickListenerC0741b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f45255e;

        public DialogInterface$OnClickListenerC0741b(b bVar, s sVar) {
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
            this.f45255e = sVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            s sVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) || (sVar = this.f45255e) == null) {
                return;
            }
            sVar.b("");
        }
    }

    /* loaded from: classes7.dex */
    public class c implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f45256e;

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
            this.f45256e = sVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            s sVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (sVar = this.f45256e) == null) {
                return;
            }
            sVar.onCancel();
        }
    }

    /* loaded from: classes7.dex */
    public class d implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f45257e;

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
            this.f45257e = sVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            s sVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) || (sVar = this.f45257e) == null) {
                return;
            }
            sVar.onCancel();
        }
    }

    /* loaded from: classes7.dex */
    public class e implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f45258e;

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
            this.f45258e = sVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            s sVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) || (sVar = this.f45258e) == null) {
                return;
            }
            sVar.b("");
        }
    }

    /* loaded from: classes7.dex */
    public class f implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f45259e;

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
            this.f45259e = sVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            s sVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (sVar = this.f45259e) == null) {
                return;
            }
            sVar.onCancel();
        }
    }

    /* loaded from: classes7.dex */
    public class g implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f45260e;

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
            this.f45260e = sVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            s sVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) || (sVar = this.f45260e) == null) {
                return;
            }
            sVar.onCancel();
        }
    }

    /* loaded from: classes7.dex */
    public class h implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f45261e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditText f45262f;

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
            this.f45261e = sVar;
            this.f45262f = editText;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            s sVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) || (sVar = this.f45261e) == null) {
                return;
            }
            sVar.b(this.f45262f.getText().toString());
        }
    }

    /* loaded from: classes7.dex */
    public class i implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r f45263a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f45264b;

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
            this.f45264b = bVar;
            this.f45263a = rVar;
        }

        @Override // d.a.o0.a.h0.h.a.f
        public void a(String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, str3, str4) == null) {
                r rVar = this.f45263a;
                if (rVar != null) {
                    rVar.b(str3, str4);
                }
                this.f45264b.f45253b = null;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r f45265a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f45266b;

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
            this.f45266b = bVar;
            this.f45265a = rVar;
        }

        @Override // d.a.o0.a.h0.h.a.e
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                r rVar = this.f45265a;
                if (rVar != null) {
                    rVar.a();
                }
                this.f45266b.f45253b = null;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SslErrorHandler f45267e;

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
            this.f45267e = sslErrorHandler;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f45267e.cancel();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f45268a;

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
            this.f45268a = tVar;
        }

        @Override // d.a.o0.a.z1.b.b.b.c
        public void a(View view) {
            t tVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (tVar = this.f45268a) == null) {
                return;
            }
            tVar.c();
        }
    }

    /* loaded from: classes7.dex */
    public class m implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f45269a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SslErrorHandler f45270b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SslError f45271c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f45272d;

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
            this.f45272d = bVar;
            this.f45269a = tVar;
            this.f45270b = sslErrorHandler;
            this.f45271c = sslError;
        }

        @Override // d.a.o0.a.z1.b.b.b.c
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f45272d.o(this.f45269a, this.f45270b, this.f45271c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f45273a;

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
            this.f45273a = tVar;
        }

        @Override // d.a.o0.a.z1.b.b.b.c
        public void a(View view) {
            t tVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (tVar = this.f45273a) == null) {
                return;
            }
            tVar.b();
        }
    }

    /* loaded from: classes7.dex */
    public class o implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long[] f45274a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SslError f45275b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f45276c;

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
            this.f45276c = bVar;
            this.f45275b = sslError;
            this.f45274a = null;
        }

        @Override // d.a.o0.a.z1.b.b.b.c
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f45274a == null) {
                    this.f45274a = new long[5];
                }
                long[] jArr = this.f45274a;
                System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
                long[] jArr2 = this.f45274a;
                jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
                if (this.f45274a[0] >= SystemClock.uptimeMillis() - 3000) {
                    this.f45274a = null;
                    this.f45276c.g(this.f45275b.toString());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t f45277e;

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
            this.f45277e = tVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            t tVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (tVar = this.f45277e) == null) {
                return;
            }
            tVar.a();
        }
    }

    /* loaded from: classes7.dex */
    public class q implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f45278a;

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
            this.f45278a = tVar;
        }

        @Override // d.a.o0.a.z1.b.b.b.c
        public void a(View view) {
            t tVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (tVar = this.f45278a) == null) {
                return;
            }
            tVar.a();
        }
    }

    /* loaded from: classes7.dex */
    public interface r {
        void a();

        void b(String str, String str2);
    }

    /* loaded from: classes7.dex */
    public interface s {
        void a();

        void b(String str);

        void onCancel();
    }

    /* loaded from: classes7.dex */
    public interface t {
        void a();

        void b();

        void c();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(447281584, "Ld/a/o0/a/h0/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(447281584, "Ld/a/o0/a/h0/h/b;");
                return;
            }
        }
        f45251c = d.a.o0.a.k.f46335a;
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
        this.f45252a = context;
    }

    public final void c(LinearLayout linearLayout, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, linearLayout, i2) == null) {
            d(linearLayout, i2, d.a.o0.a.e.aiapps_dialog_browser_security_good);
        }
    }

    public final void d(LinearLayout linearLayout, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linearLayout, i2, i3) == null) {
            View inflate = LayoutInflater.from(this.f45252a).inflate(d.a.o0.a.g.aiapps_ssl_content_header, (ViewGroup) linearLayout, false);
            TextView textView = (TextView) inflate.findViewById(d.a.o0.a.f.ssl_header_text);
            textView.setTextColor(inflate.getContext().getResources().getColor(d.a.o0.a.c.aiapps_safe_dialog_message));
            textView.setText(i2);
            ((BdBaseImageView) inflate.findViewById(d.a.o0.a.f.ssl_header_icon)).setImageResource(i3);
            linearLayout.addView(inflate);
        }
    }

    public final void e(LinearLayout linearLayout, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, linearLayout, i2) == null) {
            d(linearLayout, i2, d.a.o0.a.e.aiapps_dialog_browser_security_bad);
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Context context = this.f45252a;
            return (context instanceof Activity) && !((Activity) context).isFinishing();
        }
        return invokeV.booleanValue;
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            ((ClipboardManager) this.f45252a.getSystemService("clipboard")).setText(str);
            d.a.o0.a.z1.b.f.e.f(this.f45252a, d.a.o0.a.h.aiapps_ssl_copy_error).F();
        }
    }

    public final d.a h(SslCertificate sslCertificate, SslError sslError) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, sslCertificate, sslError)) == null) {
            View j2 = j(sslCertificate);
            LinearLayout linearLayout = (LinearLayout) j2.findViewById(d.a.o0.a.f.placeholder);
            j2.findViewById(d.a.o0.a.f.ssl_divider).setBackgroundColor(this.f45252a.getResources().getColor(d.a.o0.a.c.aiapps_dialog_gray));
            if (sslError == null) {
                c(linearLayout, d.a.o0.a.h.aiapps_ssl_certificate_is_valid);
            } else {
                if (sslError.hasError(3)) {
                    e(linearLayout, d.a.o0.a.h.aiapps_ssl_untrusted);
                }
                if (sslError.hasError(2)) {
                    e(linearLayout, d.a.o0.a.h.aiapps_ssl_mismatch);
                }
                if (sslError.hasError(1)) {
                    e(linearLayout, d.a.o0.a.h.aiapps_ssl_expired);
                }
                if (sslError.hasError(0)) {
                    e(linearLayout, d.a.o0.a.h.aiapps_ssl_not_yet_valid);
                }
                if (sslError.hasError(4)) {
                    e(linearLayout, d.a.o0.a.h.aiapps_ssl_date_invalid);
                }
                if (sslError.hasError(5)) {
                    e(linearLayout, d.a.o0.a.h.aiapps_ssl_invalid);
                }
                if (linearLayout.getChildCount() == 0) {
                    e(linearLayout, d.a.o0.a.h.aiapps_ssl_unknown);
                }
            }
            d.a aVar = new d.a(this.f45252a);
            aVar.d0(d.a.o0.a.h.aiapps_ssl_certificate);
            aVar.c0(j2);
            return aVar;
        }
        return (d.a) invokeLL.objValue;
    }

    public final String i(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, date)) == null) ? date == null ? "" : DateFormat.getDateFormat(this.f45252a).format(date) : (String) invokeL.objValue;
    }

    public final View j(SslCertificate sslCertificate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, sslCertificate)) == null) {
            View inflate = LayoutInflater.from(this.f45252a).inflate(d.a.o0.a.g.aiapps_ssl_certificate, (ViewGroup) null);
            int color = this.f45252a.getResources().getColor(d.a.o0.a.c.aiapps_safe_dialog_message);
            ViewGroup viewGroup = (ViewGroup) inflate.findViewById(d.a.o0.a.f.body);
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
                ((TextView) inflate.findViewById(d.a.o0.a.f.to_common)).setText(issuedTo.getCName());
                ((TextView) inflate.findViewById(d.a.o0.a.f.to_org)).setText(issuedTo.getOName());
                ((TextView) inflate.findViewById(d.a.o0.a.f.to_org_unit)).setText(issuedTo.getUName());
            }
            SslCertificate.DName issuedBy = sslCertificate.getIssuedBy();
            if (issuedBy != null) {
                ((TextView) inflate.findViewById(d.a.o0.a.f.by_common)).setText(issuedBy.getCName());
                ((TextView) inflate.findViewById(d.a.o0.a.f.by_org)).setText(issuedBy.getOName());
                ((TextView) inflate.findViewById(d.a.o0.a.f.by_org_unit)).setText(issuedBy.getUName());
            }
            ((TextView) inflate.findViewById(d.a.o0.a.f.issued_on)).setText(i(sslCertificate.getValidNotBeforeDate()));
            ((TextView) inflate.findViewById(d.a.o0.a.f.expires_on)).setText(i(sslCertificate.getValidNotAfterDate()));
            return inflate;
        }
        return (View) invokeL.objValue;
    }

    public void k(r rVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rVar, str, str2) == null) {
            d.a.o0.a.h0.h.a aVar = new d.a.o0.a.h0.h.a(this.f45252a, str, str2);
            this.f45253b = aVar;
            aVar.h(new i(this, rVar));
            this.f45253b.g(new j(this, rVar));
            this.f45253b.i();
        }
    }

    public boolean l(String str, String str2, s sVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, str, str2, sVar)) == null) {
            if (!f()) {
                if (f45251c) {
                    Log.e("PageDialogsHandler", "can not showJsAlert");
                }
                if (sVar != null) {
                    sVar.a();
                }
                return false;
            }
            h.a aVar = new h.a(this.f45252a);
            aVar.U(d.a.o0.a.h.aiapps_dialog_webcall_common_title);
            aVar.x(str2);
            aVar.O(d.a.o0.a.h.aiapps_confirm, new DialogInterface$OnClickListenerC0741b(this, sVar));
            aVar.K(new a(this, sVar));
            if (d.a.o0.a.c1.a.H().a()) {
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
                if (f45251c) {
                    Log.e("PageDialogsHandler", "can not showJsConfirm");
                }
                if (sVar != null) {
                    sVar.a();
                }
                return false;
            }
            h.a aVar = new h.a(this.f45252a);
            aVar.U(d.a.o0.a.h.aiapps_dialog_webcall_common_title);
            aVar.x(str2);
            aVar.O(d.a.o0.a.h.aiapps_confirm, new e(this, sVar));
            aVar.B(d.a.o0.a.h.aiapps_cancel, new d(this, sVar));
            aVar.K(new c(this, sVar));
            if (d.a.o0.a.c1.a.H().a()) {
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
            View inflate = LayoutInflater.from(this.f45252a).inflate(d.a.o0.a.g.aiapps_js_prompt, (ViewGroup) null);
            EditText editText = (EditText) inflate.findViewById(d.a.o0.a.f.value);
            editText.setText(str3);
            ((TextView) inflate.findViewById(d.a.o0.a.f.message)).setText(str2);
            h.a aVar = new h.a(this.f45252a);
            aVar.U(d.a.o0.a.h.aiapps_dialog_webcall_common_title);
            aVar.W(inflate);
            aVar.O(d.a.o0.a.h.aiapps_confirm, new h(this, sVar, editText));
            aVar.B(d.a.o0.a.h.aiapps_cancel, new g(this, sVar));
            aVar.K(new f(this, sVar));
            if (d.a.o0.a.c1.a.H().a()) {
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
            h2.a0(new b.a(this.f45252a.getText(d.a.o0.a.h.aiapps_confirm_text), d.a.o0.a.c.aiapps_safe_dialog_btn_black, new q(this, tVar)));
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
            c.C0742c c0742c = new c.C0742c(this.f45252a);
            c0742c.g0(d.a.o0.a.h.aiapps_security_warning);
            c0742c.f0(d.a.o0.a.h.aiapps_ssl_warnings_header, new o(this, sslError));
            c0742c.a0(new b.a(this.f45252a.getText(d.a.o0.a.h.aiapps_ssl_continue), d.a.o0.a.c.aiapps_ssl_dialog_go_on_text_color, new n(this, tVar)));
            c0742c.a0(new b.a(this.f45252a.getText(d.a.o0.a.h.aiapps_view_certificate), d.a.o0.a.c.aiapps_safe_dialog_btn_black, new m(this, tVar, sslErrorHandler, sslError)));
            c0742c.a0(new b.a(this.f45252a.getText(d.a.o0.a.h.aiapps_ssl_go_back), d.a.o0.a.c.aiapps_safe_dialog_btn_black, new l(this, tVar)));
            c0742c.K(new k(this, sslErrorHandler));
            c0742c.X();
        }
    }
}
