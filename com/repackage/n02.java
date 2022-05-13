package com.repackage;

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
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.m02;
import com.repackage.o02;
import com.repackage.p02;
import com.repackage.sz2;
import com.repackage.yz2;
import java.util.Date;
/* loaded from: classes6.dex */
public class n02 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public m02 b;

    /* loaded from: classes6.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s a;

        public a(n02 n02Var, s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n02Var, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            s sVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (sVar = this.a) == null) {
                return;
            }
            sVar.onCancel();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s a;

        public b(n02 n02Var, s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n02Var, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            s sVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) || (sVar = this.a) == null) {
                return;
            }
            sVar.b("");
        }
    }

    /* loaded from: classes6.dex */
    public class c implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s a;

        public c(n02 n02Var, s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n02Var, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            s sVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (sVar = this.a) == null) {
                return;
            }
            sVar.onCancel();
        }
    }

    /* loaded from: classes6.dex */
    public class d implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s a;

        public d(n02 n02Var, s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n02Var, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            s sVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) || (sVar = this.a) == null) {
                return;
            }
            sVar.onCancel();
        }
    }

    /* loaded from: classes6.dex */
    public class e implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s a;

        public e(n02 n02Var, s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n02Var, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            s sVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) || (sVar = this.a) == null) {
                return;
            }
            sVar.b("");
        }
    }

    /* loaded from: classes6.dex */
    public class f implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s a;

        public f(n02 n02Var, s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n02Var, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            s sVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (sVar = this.a) == null) {
                return;
            }
            sVar.onCancel();
        }
    }

    /* loaded from: classes6.dex */
    public class g implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s a;

        public g(n02 n02Var, s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n02Var, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            s sVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) || (sVar = this.a) == null) {
                return;
            }
            sVar.onCancel();
        }
    }

    /* loaded from: classes6.dex */
    public class h implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s a;
        public final /* synthetic */ EditText b;

        public h(n02 n02Var, s sVar, EditText editText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n02Var, sVar, editText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sVar;
            this.b = editText;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            s sVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) || (sVar = this.a) == null) {
                return;
            }
            sVar.b(this.b.getText().toString());
        }
    }

    /* loaded from: classes6.dex */
    public class i implements m02.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r a;
        public final /* synthetic */ n02 b;

        public i(n02 n02Var, r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n02Var, rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n02Var;
            this.a = rVar;
        }

        @Override // com.repackage.m02.f
        public void a(String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, str3, str4) == null) {
                r rVar = this.a;
                if (rVar != null) {
                    rVar.b(str3, str4);
                }
                this.b.b = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements m02.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r a;
        public final /* synthetic */ n02 b;

        public j(n02 n02Var, r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n02Var, rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n02Var;
            this.a = rVar;
        }

        @Override // com.repackage.m02.e
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                r rVar = this.a;
                if (rVar != null) {
                    rVar.a();
                }
                this.b.b = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SslErrorHandler a;

        public k(n02 n02Var, SslErrorHandler sslErrorHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n02Var, sslErrorHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sslErrorHandler;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.cancel();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements sz2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t a;

        public l(n02 n02Var, t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n02Var, tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tVar;
        }

        @Override // com.repackage.sz2.c
        public void a(View view2) {
            t tVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (tVar = this.a) == null) {
                return;
            }
            tVar.c();
        }
    }

    /* loaded from: classes6.dex */
    public class m implements sz2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t a;
        public final /* synthetic */ SslErrorHandler b;
        public final /* synthetic */ SslError c;
        public final /* synthetic */ n02 d;

        public m(n02 n02Var, t tVar, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n02Var, tVar, sslErrorHandler, sslError};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = n02Var;
            this.a = tVar;
            this.b = sslErrorHandler;
            this.c = sslError;
        }

        @Override // com.repackage.sz2.c
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.d.o(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements sz2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t a;

        public n(n02 n02Var, t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n02Var, tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tVar;
        }

        @Override // com.repackage.sz2.c
        public void a(View view2) {
            t tVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (tVar = this.a) == null) {
                return;
            }
            tVar.b();
        }
    }

    /* loaded from: classes6.dex */
    public class o implements sz2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long[] a;
        public final /* synthetic */ SslError b;
        public final /* synthetic */ n02 c;

        public o(n02 n02Var, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n02Var, sslError};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = n02Var;
            this.b = sslError;
            this.a = null;
        }

        @Override // com.repackage.sz2.c
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a == null) {
                    this.a = new long[5];
                }
                long[] jArr = this.a;
                System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
                long[] jArr2 = this.a;
                jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
                if (this.a[0] >= SystemClock.uptimeMillis() - 3000) {
                    this.a = null;
                    this.c.g(this.b.toString());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t a;

        public p(n02 n02Var, t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n02Var, tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            t tVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (tVar = this.a) == null) {
                return;
            }
            tVar.a();
        }
    }

    /* loaded from: classes6.dex */
    public class q implements sz2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t a;

        public q(n02 n02Var, t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n02Var, tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tVar;
        }

        @Override // com.repackage.sz2.c
        public void a(View view2) {
            t tVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (tVar = this.a) == null) {
                return;
            }
            tVar.a();
        }
    }

    /* loaded from: classes6.dex */
    public interface r {
        void a();

        void b(String str, String str2);
    }

    /* loaded from: classes6.dex */
    public interface s {
        void a();

        void b(String str);

        void onCancel();
    }

    /* loaded from: classes6.dex */
    public interface t {
        void a();

        void b();

        void c();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755523391, "Lcom/repackage/n02;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755523391, "Lcom/repackage/n02;");
                return;
            }
        }
        c = eh1.a;
    }

    public n02(Context context) {
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
        this.a = context;
    }

    public final void c(LinearLayout linearLayout, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, linearLayout, i2) == null) {
            d(linearLayout, i2, R.drawable.obfuscated_res_0x7f080145);
        }
    }

    public final void d(LinearLayout linearLayout, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linearLayout, i2, i3) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d00d6, (ViewGroup) linearLayout, false);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091dd4);
            textView.setTextColor(inflate.getContext().getResources().getColor(R.color.obfuscated_res_0x7f0603d8));
            textView.setText(i2);
            ((BdBaseImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091dd3)).setImageResource(i3);
            linearLayout.addView(inflate);
        }
    }

    public final void e(LinearLayout linearLayout, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, linearLayout, i2) == null) {
            d(linearLayout, i2, R.drawable.obfuscated_res_0x7f080144);
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Context context = this.a;
            return (context instanceof Activity) && !((Activity) context).isFinishing();
        }
        return invokeV.booleanValue;
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            ((ClipboardManager) this.a.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setText(str);
            m03.f(this.a, R.string.obfuscated_res_0x7f0f01c8).G();
        }
    }

    public final p02.a h(SslCertificate sslCertificate, SslError sslError) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, sslCertificate, sslError)) == null) {
            View j2 = j(sslCertificate);
            LinearLayout linearLayout = (LinearLayout) j2.findViewById(R.id.obfuscated_res_0x7f0918a6);
            j2.findViewById(R.id.obfuscated_res_0x7f091dd2).setBackgroundColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06038f));
            if (sslError == null) {
                c(linearLayout, R.string.obfuscated_res_0x7f0f01c6);
            } else {
                if (sslError.hasError(3)) {
                    e(linearLayout, R.string.obfuscated_res_0x7f0f01d0);
                }
                if (sslError.hasError(2)) {
                    e(linearLayout, R.string.obfuscated_res_0x7f0f01cd);
                }
                if (sslError.hasError(1)) {
                    e(linearLayout, R.string.obfuscated_res_0x7f0f01ca);
                }
                if (sslError.hasError(0)) {
                    e(linearLayout, R.string.obfuscated_res_0x7f0f01ce);
                }
                if (sslError.hasError(4)) {
                    e(linearLayout, R.string.obfuscated_res_0x7f0f01c9);
                }
                if (sslError.hasError(5)) {
                    e(linearLayout, R.string.obfuscated_res_0x7f0f01cc);
                }
                if (linearLayout.getChildCount() == 0) {
                    e(linearLayout, R.string.obfuscated_res_0x7f0f01cf);
                }
            }
            p02.a aVar = new p02.a(this.a);
            aVar.d0(R.string.obfuscated_res_0x7f0f01c5);
            aVar.c0(j2);
            return aVar;
        }
        return (p02.a) invokeLL.objValue;
    }

    public final String i(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, date)) == null) ? date == null ? "" : DateFormat.getDateFormat(this.a).format(date) : (String) invokeL.objValue;
    }

    public final View j(SslCertificate sslCertificate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, sslCertificate)) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d00d5, (ViewGroup) null);
            int color = this.a.getResources().getColor(R.color.obfuscated_res_0x7f0603d8);
            ViewGroup viewGroup = (ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f090393);
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
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0920c2)).setText(issuedTo.getCName());
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0920c5)).setText(issuedTo.getOName());
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0920c7)).setText(issuedTo.getUName());
            }
            SslCertificate.DName issuedBy = sslCertificate.getIssuedBy();
            if (issuedBy != null) {
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090480)).setText(issuedBy.getCName());
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090482)).setText(issuedBy.getOName());
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090484)).setText(issuedBy.getUName());
            }
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090f5f)).setText(i(sslCertificate.getValidNotBeforeDate()));
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090942)).setText(i(sslCertificate.getValidNotAfterDate()));
            return inflate;
        }
        return (View) invokeL.objValue;
    }

    public void k(r rVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rVar, str, str2) == null) {
            m02 m02Var = new m02(this.a, str, str2);
            this.b = m02Var;
            m02Var.h(new i(this, rVar));
            this.b.g(new j(this, rVar));
            this.b.i();
        }
    }

    public boolean l(String str, String str2, s sVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, str, str2, sVar)) == null) {
            if (!f()) {
                if (c) {
                    Log.e("PageDialogsHandler", "can not showJsAlert");
                }
                if (sVar != null) {
                    sVar.a();
                }
                return false;
            }
            yz2.a aVar = new yz2.a(this.a);
            aVar.U(R.string.obfuscated_res_0x7f0f0150);
            aVar.x(str2);
            aVar.O(R.string.obfuscated_res_0x7f0f0112, new b(this, sVar));
            aVar.K(new a(this, sVar));
            if (bk2.M().a()) {
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
                if (c) {
                    Log.e("PageDialogsHandler", "can not showJsConfirm");
                }
                if (sVar != null) {
                    sVar.a();
                }
                return false;
            }
            yz2.a aVar = new yz2.a(this.a);
            aVar.U(R.string.obfuscated_res_0x7f0f0150);
            aVar.x(str2);
            aVar.O(R.string.obfuscated_res_0x7f0f0112, new e(this, sVar));
            aVar.B(R.string.obfuscated_res_0x7f0f010a, new d(this, sVar));
            aVar.K(new c(this, sVar));
            if (bk2.M().a()) {
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
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d00b5, (ViewGroup) null);
            EditText editText = (EditText) inflate.findViewById(R.id.obfuscated_res_0x7f092325);
            editText.setText(str3);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09140a)).setText(str2);
            yz2.a aVar = new yz2.a(this.a);
            aVar.U(R.string.obfuscated_res_0x7f0f0150);
            aVar.W(inflate);
            aVar.O(R.string.obfuscated_res_0x7f0f0112, new h(this, sVar, editText));
            aVar.B(R.string.obfuscated_res_0x7f0f010a, new g(this, sVar));
            aVar.K(new f(this, sVar));
            if (bk2.M().a()) {
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
            p02.a h2 = h(certificate, sslError);
            h2.a0(new sz2.a(this.a.getText(R.string.obfuscated_res_0x7f0f0114), R.color.obfuscated_res_0x7f0603d6, new q(this, tVar)));
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
            o02.c cVar = new o02.c(this.a);
            cVar.g0(R.string.obfuscated_res_0x7f0f01b8);
            cVar.f0(R.string.obfuscated_res_0x7f0f01d1, new o(this, sslError));
            cVar.a0(new sz2.a(this.a.getText(R.string.obfuscated_res_0x7f0f01c7), R.color.obfuscated_res_0x7f0603dc, new n(this, tVar)));
            cVar.a0(new sz2.a(this.a.getText(R.string.obfuscated_res_0x7f0f01e0), R.color.obfuscated_res_0x7f0603d6, new m(this, tVar, sslErrorHandler, sslError)));
            cVar.a0(new sz2.a(this.a.getText(R.string.obfuscated_res_0x7f0f01cb), R.color.obfuscated_res_0x7f0603d6, new l(this, tVar)));
            cVar.K(new k(this, sslErrorHandler));
            cVar.X();
        }
    }
}
