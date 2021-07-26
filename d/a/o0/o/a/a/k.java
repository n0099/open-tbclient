package d.a.o0.o.a.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;
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
/* loaded from: classes7.dex */
public abstract class k<E> extends i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Activity f51352a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f51353b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f51354c;

    /* renamed from: d  reason: collision with root package name */
    public final m f51355d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.o.a.c.f<String, p> f51356e;

    /* renamed from: f  reason: collision with root package name */
    public q f51357f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51358g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f51359h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.mHandler, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Activity) objArr2[0], (Context) objArr2[1], (Handler) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void c() {
        q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (qVar = this.f51357f) == null) {
            return;
        }
        qVar.b();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f51359h) {
            return;
        }
        this.f51359h = true;
        q qVar = this.f51357f;
        if (qVar != null) {
            qVar.f();
        } else if (!this.f51358g) {
            q k = k("(root)", true, false);
            this.f51357f = k;
            if (k != null && !k.f51398d) {
                k.f();
            }
        }
        this.f51358g = true;
    }

    public void e(boolean z) {
        q qVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && (qVar = this.f51357f) != null && this.f51359h) {
            this.f51359h = false;
            if (z) {
                qVar.e();
            } else {
                qVar.g();
            }
        }
    }

    public void f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, str, fileDescriptor, printWriter, strArr) == null) {
            printWriter.print(str);
            printWriter.print("mLoadersStarted=");
            printWriter.println(this.f51359h);
            if (this.f51357f != null) {
                printWriter.print(str);
                printWriter.print("Loader Manager ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this.f51357f)));
                printWriter.println(":");
                q qVar = this.f51357f;
                qVar.h(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
            }
        }
    }

    public Activity g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f51352a : (Activity) invokeV.objValue;
    }

    public Context h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f51353b : (Context) invokeV.objValue;
    }

    public m i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f51355d : (m) invokeV.objValue;
    }

    public Handler j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f51354c : (Handler) invokeV.objValue;
    }

    public q k(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (this.f51356e == null) {
                this.f51356e = new d.a.o0.o.a.c.f<>();
            }
            q qVar = (q) this.f51356e.get(str);
            if (qVar != null) {
                qVar.k(this);
                return qVar;
            } else if (z2) {
                q qVar2 = new q(str, this, z);
                this.f51356e.put(str, qVar2);
                return qVar2;
            } else {
                return qVar;
            }
        }
        return (q) invokeCommon.objValue;
    }

    public q l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            q qVar = this.f51357f;
            if (qVar != null) {
                return qVar;
            }
            this.f51358g = true;
            q k = k("(root)", this.f51359h, true);
            this.f51357f = k;
            return k;
        }
        return (q) invokeV.objValue;
    }

    public void m(String str) {
        d.a.o0.o.a.c.f<String, p> fVar;
        q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || (fVar = this.f51356e) == null || (qVar = (q) fVar.get(str)) == null || qVar.f51399e) {
            return;
        }
        qVar.b();
        this.f51356e.remove(str);
    }

    public abstract void n(Fragment fragment);

    public abstract void o(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract LayoutInflater p();

    public abstract int q();

    public abstract boolean r();

    public abstract void s(@NonNull Fragment fragment, @NonNull String[] strArr, int i2);

    public abstract boolean t(Fragment fragment);

    public abstract void u();

    public void v() {
        d.a.o0.o.a.c.f<String, p> fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (fVar = this.f51356e) == null) {
            return;
        }
        int size = fVar.size();
        q[] qVarArr = new q[size];
        for (int i2 = size - 1; i2 >= 0; i2--) {
            qVarArr[i2] = (q) this.f51356e.k(i2);
        }
        for (int i3 = 0; i3 < size; i3++) {
            q qVar = qVarArr[i3];
            qVar.i();
            qVar.d();
        }
    }

    public void w(d.a.o0.o.a.c.f<String, p> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, fVar) == null) {
            this.f51356e = fVar;
        }
    }

    public d.a.o0.o.a.c.f<String, p> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            d.a.o0.o.a.c.f<String, p> fVar = this.f51356e;
            int i2 = 0;
            if (fVar != null) {
                int size = fVar.size();
                q[] qVarArr = new q[size];
                for (int i3 = size - 1; i3 >= 0; i3--) {
                    qVarArr[i3] = (q) this.f51356e.k(i3);
                }
                int i4 = 0;
                while (i2 < size) {
                    q qVar = qVarArr[i2];
                    if (qVar.f51399e) {
                        i4 = 1;
                    } else {
                        qVar.b();
                        this.f51356e.remove(qVar.f51397c);
                    }
                    i2++;
                }
                i2 = i4;
            }
            if (i2 != 0) {
                return this.f51356e;
            }
            return null;
        }
        return (d.a.o0.o.a.c.f) invokeV.objValue;
    }

    public k(Activity activity, Context context, Handler handler, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, context, handler, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f51355d = new m();
        this.f51352a = activity;
        this.f51353b = context;
        this.f51354c = handler;
    }
}
