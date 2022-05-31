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
public abstract class ad4<E> extends yc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity a;
    public final Context b;
    public final Handler c;
    public final int d;
    public final cd4 e;
    public sd4<String, fd4> f;
    public gd4 g;
    public boolean h;
    public boolean i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ad4(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.mHandler, 0);
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

    @Override // com.repackage.yc4
    @Nullable
    public View a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            return null;
        }
        return (View) invokeI.objValue;
    }

    @Override // com.repackage.yc4
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void c() {
        gd4 gd4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (gd4Var = this.g) == null) {
            return;
        }
        gd4Var.b();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.i) {
            return;
        }
        this.i = true;
        gd4 gd4Var = this.g;
        if (gd4Var != null) {
            gd4Var.f();
        } else if (!this.h) {
            gd4 i = i("(root)", true, false);
            this.g = i;
            if (i != null && !i.d) {
                i.f();
            }
        }
        this.h = true;
    }

    public void e(boolean z) {
        gd4 gd4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (gd4Var = this.g) != null && this.i) {
            this.i = false;
            if (z) {
                gd4Var.e();
            } else {
                gd4Var.g();
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
                gd4 gd4Var = this.g;
                gd4Var.h(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
            }
        }
    }

    public cd4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.e : (cd4) invokeV.objValue;
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

    public gd4 i(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (this.f == null) {
                this.f = new sd4<>();
            }
            gd4 gd4Var = (gd4) this.f.get(str);
            if (gd4Var != null) {
                gd4Var.k(this);
                return gd4Var;
            } else if (z2) {
                gd4 gd4Var2 = new gd4(str, this, z);
                this.f.put(str, gd4Var2);
                return gd4Var2;
            } else {
                return gd4Var;
            }
        }
        return (gd4) invokeCommon.objValue;
    }

    public gd4 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            gd4 gd4Var = this.g;
            if (gd4Var != null) {
                return gd4Var;
            }
            this.h = true;
            gd4 i = i("(root)", this.i, true);
            this.g = i;
            return i;
        }
        return (gd4) invokeV.objValue;
    }

    public void k(String str) {
        sd4<String, fd4> sd4Var;
        gd4 gd4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || (sd4Var = this.f) == null || (gd4Var = (gd4) sd4Var.get(str)) == null || gd4Var.e) {
            return;
        }
        gd4Var.b();
        this.f.remove(str);
    }

    public void l(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, fragment) == null) {
        }
    }

    public void m(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048590, this, str, fileDescriptor, printWriter, strArr) == null) {
        }
    }

    public LayoutInflater n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (LayoutInflater) this.b.getSystemService("layout_inflater") : (LayoutInflater) invokeV.objValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.d : invokeV.intValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void q(@NonNull Fragment fragment, @NonNull String[] strArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048594, this, fragment, strArr, i) == null) {
        }
    }

    public boolean r(Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, fragment)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public void s(Fragment fragment, Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048596, this, fragment, intent, i) == null) {
            if (i == -1) {
                this.b.startActivity(intent);
                return;
            }
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    public void u() {
        sd4<String, fd4> sd4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (sd4Var = this.f) == null) {
            return;
        }
        int size = sd4Var.size();
        gd4[] gd4VarArr = new gd4[size];
        for (int i = size - 1; i >= 0; i--) {
            gd4VarArr[i] = (gd4) this.f.k(i);
        }
        for (int i2 = 0; i2 < size; i2++) {
            gd4 gd4Var = gd4VarArr[i2];
            gd4Var.i();
            gd4Var.d();
        }
    }

    public void v(sd4<String, fd4> sd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, sd4Var) == null) {
            this.f = sd4Var;
        }
    }

    public sd4<String, fd4> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            sd4<String, fd4> sd4Var = this.f;
            int i = 0;
            if (sd4Var != null) {
                int size = sd4Var.size();
                gd4[] gd4VarArr = new gd4[size];
                for (int i2 = size - 1; i2 >= 0; i2--) {
                    gd4VarArr[i2] = (gd4) this.f.k(i2);
                }
                int i3 = 0;
                while (i < size) {
                    gd4 gd4Var = gd4VarArr[i];
                    if (gd4Var.e) {
                        i3 = 1;
                    } else {
                        gd4Var.b();
                        this.f.remove(gd4Var.c);
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
        return (sd4) invokeV.objValue;
    }

    public ad4(Activity activity, Context context, Handler handler, int i) {
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
        this.e = new cd4();
        this.a = activity;
        this.b = context;
        this.c = handler;
        this.d = i;
    }
}
