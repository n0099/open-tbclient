package com.ss.android.download.api.model;

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
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f68340a;

    /* renamed from: b  reason: collision with root package name */
    public String f68341b;

    /* renamed from: c  reason: collision with root package name */
    public String f68342c;

    /* renamed from: d  reason: collision with root package name */
    public String f68343d;

    /* renamed from: e  reason: collision with root package name */
    public String f68344e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f68345f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f68346g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC1965b f68347h;

    /* renamed from: i  reason: collision with root package name */
    public View f68348i;
    public int j;

    /* renamed from: com.ss.android.download.api.model.b$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f68349a;

        /* renamed from: b  reason: collision with root package name */
        public int f68350b;

        /* renamed from: c  reason: collision with root package name */
        public Context f68351c;

        /* renamed from: d  reason: collision with root package name */
        public String f68352d;

        /* renamed from: e  reason: collision with root package name */
        public String f68353e;

        /* renamed from: f  reason: collision with root package name */
        public String f68354f;

        /* renamed from: g  reason: collision with root package name */
        public String f68355g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f68356h;

        /* renamed from: i  reason: collision with root package name */
        public Drawable f68357i;
        public InterfaceC1965b j;

        public a(Context context) {
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
            this.f68351c = context;
        }

        public a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f68352d = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f68353e = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                this.f68354f = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.f68355g = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.f68356h = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a a(Drawable drawable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawable)) == null) {
                this.f68357i = drawable;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(InterfaceC1965b interfaceC1965b) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC1965b)) == null) {
                this.j = interfaceC1965b;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f68350b = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public b a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new b(this, null) : (b) invokeV.objValue;
        }
    }

    /* renamed from: com.ss.android.download.api.model.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC1965b {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    public /* synthetic */ b(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    public b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68345f = true;
        this.f68340a = aVar.f68351c;
        this.f68341b = aVar.f68352d;
        this.f68342c = aVar.f68353e;
        this.f68343d = aVar.f68354f;
        this.f68344e = aVar.f68355g;
        this.f68345f = aVar.f68356h;
        this.f68346g = aVar.f68357i;
        this.f68347h = aVar.j;
        this.f68348i = aVar.f68349a;
        this.j = aVar.f68350b;
    }
}
