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
    public Context f68339a;

    /* renamed from: b  reason: collision with root package name */
    public String f68340b;

    /* renamed from: c  reason: collision with root package name */
    public String f68341c;

    /* renamed from: d  reason: collision with root package name */
    public String f68342d;

    /* renamed from: e  reason: collision with root package name */
    public String f68343e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f68344f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f68345g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC1965b f68346h;

    /* renamed from: i  reason: collision with root package name */
    public View f68347i;
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
        public View f68348a;

        /* renamed from: b  reason: collision with root package name */
        public int f68349b;

        /* renamed from: c  reason: collision with root package name */
        public Context f68350c;

        /* renamed from: d  reason: collision with root package name */
        public String f68351d;

        /* renamed from: e  reason: collision with root package name */
        public String f68352e;

        /* renamed from: f  reason: collision with root package name */
        public String f68353f;

        /* renamed from: g  reason: collision with root package name */
        public String f68354g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f68355h;

        /* renamed from: i  reason: collision with root package name */
        public Drawable f68356i;
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
            this.f68350c = context;
        }

        public a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f68351d = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f68352e = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                this.f68353f = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.f68354g = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.f68355h = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a a(Drawable drawable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawable)) == null) {
                this.f68356i = drawable;
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
                this.f68349b = i2;
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
        this.f68344f = true;
        this.f68339a = aVar.f68350c;
        this.f68340b = aVar.f68351d;
        this.f68341c = aVar.f68352e;
        this.f68342d = aVar.f68353f;
        this.f68343e = aVar.f68354g;
        this.f68344f = aVar.f68355h;
        this.f68345g = aVar.f68356i;
        this.f68346h = aVar.j;
        this.f68347i = aVar.f68348a;
        this.j = aVar.f68349b;
    }
}
