package com.repackage;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.hw;
import com.repackage.iw;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public final class jw extends iw {
    public static /* synthetic */ Interceptable $ic;
    public static WeakReference<kw> a;
    public static Toast b;
    public static Handler c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ ViewGroup b;
        public final /* synthetic */ int c;

        /* renamed from: com.repackage.jw$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0439a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0439a(a aVar) {
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
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && rw.q()) {
                    Toast unused = jw.b = new Toast(this.a.a);
                    jw.b.setView(this.a.b);
                    jw.b.setGravity(81, 0, this.a.c);
                    rw.m(jw.b, R.style.obfuscated_res_0x7f100410);
                    jw.b.show();
                }
            }
        }

        public a(Context context, ViewGroup viewGroup, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, viewGroup, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = viewGroup;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                jw.c.post(new RunnableC0439a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ ViewGroup b;
        public final /* synthetic */ int c;
        public final /* synthetic */ hw.a d;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            /* renamed from: com.repackage.jw$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class View$OnClickListenerC0440a implements View.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public View$OnClickListenerC0440a(a aVar) {
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
                            return;
                        }
                    }
                    this.a = aVar;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    hw.a aVar;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (aVar = this.a.a.d) == null) {
                        return;
                    }
                    aVar.a();
                }
            }

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

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && rw.q()) {
                    Toast unused = jw.b = new Toast(this.a.a);
                    jw.b.setView(this.a.b);
                    jw.b.setGravity(81, 0, this.a.c);
                    rw.m(jw.b, R.style.obfuscated_res_0x7f100410);
                    this.a.b.setOnClickListener(new View$OnClickListenerC0440a(this));
                    jw.b.show();
                }
            }
        }

        public b(Context context, ViewGroup viewGroup, int i, hw.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, viewGroup, Integer.valueOf(i), aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = viewGroup;
            this.c = i;
            this.d = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                jw.c.post(new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements iw.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;

        public c(Context context, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = i;
            this.c = i2;
        }

        @Override // com.repackage.iw.e
        public void a(ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                kw kwVar = new kw(this.a);
                jw.j(kwVar);
                if (rw.d()) {
                    kwVar.n(2003);
                }
                kwVar.f(viewGroup);
                kwVar.e(81, 0, this.b);
                kwVar.d(this.c);
                kwVar.j(R.style.obfuscated_res_0x7f100410);
                kwVar.c();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements hw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hw.a a;

        public d(hw.a aVar) {
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
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.repackage.hw.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hw.a aVar = this.a;
                if (aVar != null) {
                    aVar.a();
                }
                jw.e();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964036008, "Lcom/repackage/jw;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964036008, "Lcom/repackage/jw;");
                return;
            }
        }
        c = new Handler(Looper.getMainLooper());
    }

    public static void e() {
        kw kwVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            WeakReference<kw> weakReference = a;
            if (weakReference != null && (kwVar = weakReference.get()) != null) {
                kwVar.i();
            }
            Toast toast = b;
            if (toast != null) {
                toast.cancel();
            }
        }
    }

    public static void f(Context context, CharSequence charSequence, int i, String str, CharSequence charSequence2, int i2, int i3, String str2, String str3, String str4, String str5, String str6, hw.a aVar, fu fuVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, charSequence, Integer.valueOf(i), str, charSequence2, Integer.valueOf(i2), Integer.valueOf(i3), str2, str3, str4, str5, str6, aVar, fuVar}) == null) {
            Context applicationContext = context.getApplicationContext();
            int dimension = (int) context.getResources().getDimension(R.dimen.obfuscated_res_0x7f0705f3);
            if (fuVar != null) {
                dimension = fuVar.a();
            }
            if (rw.p(context)) {
                ViewGroup a2 = iw.a(context, charSequence, str2, str3);
                iw.c(str, a2, new b(applicationContext, a2, dimension, aVar));
                return;
            }
            iw.b(context, charSequence, i, charSequence2, i2, str2, str, str3, str4, str5, str6, new c(applicationContext, dimension, i3), new d(aVar));
        }
    }

    public static void g(Context context, CharSequence charSequence, int i, String str, String str2, String str3, fu fuVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, charSequence, Integer.valueOf(i), str, str2, str3, fuVar}) == null) {
            Context applicationContext = context.getApplicationContext();
            int dimension = (int) context.getResources().getDimension(R.dimen.obfuscated_res_0x7f0705f3);
            if (fuVar != null) {
                dimension = fuVar.a();
            }
            ViewGroup a2 = iw.a(context, charSequence, str, str3);
            iw.c(str2, a2, new a(applicationContext, a2, dimension));
        }
    }

    public static void j(kw kwVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, kwVar) == null) {
            WeakReference<kw> weakReference = a;
            if (weakReference != null) {
                weakReference.clear();
            }
            a = new WeakReference<>(kwVar);
        }
    }
}
