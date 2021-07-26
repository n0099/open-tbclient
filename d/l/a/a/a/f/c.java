package d.l.a.a.a.f;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f71552a;

    /* renamed from: b  reason: collision with root package name */
    public String f71553b;

    /* renamed from: c  reason: collision with root package name */
    public String f71554c;

    /* renamed from: d  reason: collision with root package name */
    public String f71555d;

    /* renamed from: e  reason: collision with root package name */
    public String f71556e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f71557f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f71558g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC2011c f71559h;

    /* renamed from: i  reason: collision with root package name */
    public View f71560i;
    public int j;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Context f71561a;

        /* renamed from: b  reason: collision with root package name */
        public String f71562b;

        /* renamed from: c  reason: collision with root package name */
        public String f71563c;

        /* renamed from: d  reason: collision with root package name */
        public String f71564d;

        /* renamed from: e  reason: collision with root package name */
        public String f71565e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f71566f;

        /* renamed from: g  reason: collision with root package name */
        public Drawable f71567g;

        /* renamed from: h  reason: collision with root package name */
        public InterfaceC2011c f71568h;

        /* renamed from: i  reason: collision with root package name */
        public View f71569i;
        public int j;

        public b(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71561a = context;
        }

        public b b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.j = i2;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b c(Drawable drawable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawable)) == null) {
                this.f71567g = drawable;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b d(InterfaceC2011c interfaceC2011c) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC2011c)) == null) {
                this.f71568h = interfaceC2011c;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f71562b = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b f(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.f71566f = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public c g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new c(this, null) : (c) invokeV.objValue;
        }

        public b h(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f71563c = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b j(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                this.f71564d = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b l(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.f71565e = str;
                return this;
            }
            return (b) invokeL.objValue;
        }
    }

    /* renamed from: d.l.a.a.a.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC2011c {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    public /* synthetic */ c(b bVar, a aVar) {
        this(bVar);
    }

    public c(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71557f = true;
        this.f71552a = bVar.f71561a;
        this.f71553b = bVar.f71562b;
        this.f71554c = bVar.f71563c;
        this.f71555d = bVar.f71564d;
        this.f71556e = bVar.f71565e;
        this.f71557f = bVar.f71566f;
        this.f71558g = bVar.f71567g;
        this.f71559h = bVar.f71568h;
        this.f71560i = bVar.f71569i;
        this.j = bVar.j;
    }
}
