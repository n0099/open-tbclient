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
/* loaded from: classes10.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f74046a;

    /* renamed from: b  reason: collision with root package name */
    public String f74047b;

    /* renamed from: c  reason: collision with root package name */
    public String f74048c;

    /* renamed from: d  reason: collision with root package name */
    public String f74049d;

    /* renamed from: e  reason: collision with root package name */
    public String f74050e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f74051f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f74052g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC2044c f74053h;

    /* renamed from: i  reason: collision with root package name */
    public View f74054i;
    public int j;

    /* loaded from: classes10.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Context f74055a;

        /* renamed from: b  reason: collision with root package name */
        public String f74056b;

        /* renamed from: c  reason: collision with root package name */
        public String f74057c;

        /* renamed from: d  reason: collision with root package name */
        public String f74058d;

        /* renamed from: e  reason: collision with root package name */
        public String f74059e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f74060f;

        /* renamed from: g  reason: collision with root package name */
        public Drawable f74061g;

        /* renamed from: h  reason: collision with root package name */
        public InterfaceC2044c f74062h;

        /* renamed from: i  reason: collision with root package name */
        public View f74063i;
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
            this.f74055a = context;
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
                this.f74061g = drawable;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b d(InterfaceC2044c interfaceC2044c) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC2044c)) == null) {
                this.f74062h = interfaceC2044c;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f74056b = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b f(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.f74060f = z;
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
                this.f74057c = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b j(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                this.f74058d = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b l(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.f74059e = str;
                return this;
            }
            return (b) invokeL.objValue;
        }
    }

    /* renamed from: d.l.a.a.a.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC2044c {
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
        this.f74051f = true;
        this.f74046a = bVar.f74055a;
        this.f74047b = bVar.f74056b;
        this.f74048c = bVar.f74057c;
        this.f74049d = bVar.f74058d;
        this.f74050e = bVar.f74059e;
        this.f74051f = bVar.f74060f;
        this.f74052g = bVar.f74061g;
        this.f74053h = bVar.f74062h;
        this.f74054i = bVar.f74063i;
        this.j = bVar.j;
    }
}
