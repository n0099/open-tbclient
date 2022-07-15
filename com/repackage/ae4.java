package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes5.dex */
public abstract class ae4<E> extends yd4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity a;
    public final Context b;
    public final Handler c;
    public final int d;
    public final ce4 e;
    public re4<String, fe4> f;
    public ge4 g;
    public boolean h;
    public boolean i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ae4(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.a, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Activity) objArr2[0], (Context) objArr2[1], (Handler) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.yd4
    @Nullable
    public View a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            return null;
        }
        return (View) invokeI.objValue;
    }

    @Override // com.repackage.yd4
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void c() {
        ge4 ge4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (ge4Var = this.g) == null) {
            return;
        }
        ge4Var.b();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.i) {
            return;
        }
        this.i = true;
        ge4 ge4Var = this.g;
        if (ge4Var != null) {
            ge4Var.f();
        } else if (!this.h) {
            ge4 i = i("(root)", true, false);
            this.g = i;
            if (i != null && !i.d) {
                i.f();
            }
        }
        this.h = true;
    }

    public void e(boolean z) {
        ge4 ge4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (ge4Var = this.g) != null && this.i) {
            this.i = false;
            if (z) {
                ge4Var.e();
            } else {
                ge4Var.g();
            }
        }
    }

    public void f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, str, fileDescriptor, printWriter, strArr) == null) {
            printWriter.print(str);
            printWriter.print("mLoadersStarted=");
            printWriter.println(this.i);
            if (this.g != null) {
                printWriter.print(str);
                printWriter.print("Loader Manager ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this.g)));
                printWriter.println(":");
                ge4 ge4Var = this.g;
                ge4Var.h(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
            }
        }
    }

    public ce4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.e : (ce4) invokeV.objValue;
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : (Activity) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.b : (Context) invokeV.objValue;
    }

    public Handler h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.c : (Handler) invokeV.objValue;
    }

    public ge4 i(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (this.f == null) {
                this.f = new re4<>();
            }
            ge4 ge4Var = (ge4) this.f.get(str);
            if (ge4Var != null) {
                ge4Var.k(this);
                return ge4Var;
            } else if (z2) {
                ge4 ge4Var2 = new ge4(str, this, z);
                this.f.put(str, ge4Var2);
                return ge4Var2;
            } else {
                return ge4Var;
            }
        }
        return (ge4) invokeCommon.objValue;
    }

    public void j(String str) {
        re4<String, fe4> re4Var;
        ge4 ge4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || (re4Var = this.f) == null || (ge4Var = (ge4) re4Var.get(str)) == null || ge4Var.e) {
            return;
        }
        ge4Var.b();
        this.f.remove(str);
    }

    public void k(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, fragment) == null) {
        }
    }

    public void l(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048589, this, str, fileDescriptor, printWriter, strArr) == null) {
        }
    }

    public LayoutInflater m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? (LayoutInflater) this.b.getSystemService("layout_inflater") : (LayoutInflater) invokeV.objValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.d : invokeV.intValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void p(@NonNull Fragment fragment, @NonNull String[] strArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048593, this, fragment, strArr, i) == null) {
        }
    }

    public boolean q(Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, fragment)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public void r(Fragment fragment, Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048595, this, fragment, intent, i) == null) {
            if (i == -1) {
                this.b.startActivity(intent);
                return;
            }
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
        }
    }

    public void t() {
        re4<String, fe4> re4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (re4Var = this.f) == null) {
            return;
        }
        int size = re4Var.size();
        ge4[] ge4VarArr = new ge4[size];
        for (int i = size - 1; i >= 0; i--) {
            ge4VarArr[i] = (ge4) this.f.k(i);
        }
        for (int i2 = 0; i2 < size; i2++) {
            ge4 ge4Var = ge4VarArr[i2];
            ge4Var.i();
            ge4Var.d();
        }
    }

    public void u(re4<String, fe4> re4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, re4Var) == null) {
            this.f = re4Var;
        }
    }

    public re4<String, fe4> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            re4<String, fe4> re4Var = this.f;
            int i = 0;
            if (re4Var != null) {
                int size = re4Var.size();
                ge4[] ge4VarArr = new ge4[size];
                for (int i2 = size - 1; i2 >= 0; i2--) {
                    ge4VarArr[i2] = (ge4) this.f.k(i2);
                }
                int i3 = 0;
                while (i < size) {
                    ge4 ge4Var = ge4VarArr[i];
                    if (ge4Var.e) {
                        i3 = 1;
                    } else {
                        ge4Var.b();
                        this.f.remove(ge4Var.c);
                    }
                    i++;
                }
                i = i3;
            }
            if (i != 0) {
                return this.f;
            }
            return null;
        }
        return (re4) invokeV.objValue;
    }

    public ae4(Activity activity, Context context, Handler handler, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, context, handler, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new ce4();
        this.a = activity;
        this.b = context;
        this.c = handler;
        this.d = i;
    }
}
