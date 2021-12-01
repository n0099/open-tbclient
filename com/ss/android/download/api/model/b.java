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
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public String f61079b;

    /* renamed from: c  reason: collision with root package name */
    public String f61080c;

    /* renamed from: d  reason: collision with root package name */
    public String f61081d;

    /* renamed from: e  reason: collision with root package name */
    public String f61082e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f61083f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f61084g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC2094b f61085h;

    /* renamed from: i  reason: collision with root package name */
    public View f61086i;

    /* renamed from: j  reason: collision with root package name */
    public int f61087j;

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
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public int f61088b;

        /* renamed from: c  reason: collision with root package name */
        public Context f61089c;

        /* renamed from: d  reason: collision with root package name */
        public String f61090d;

        /* renamed from: e  reason: collision with root package name */
        public String f61091e;

        /* renamed from: f  reason: collision with root package name */
        public String f61092f;

        /* renamed from: g  reason: collision with root package name */
        public String f61093g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f61094h;

        /* renamed from: i  reason: collision with root package name */
        public Drawable f61095i;

        /* renamed from: j  reason: collision with root package name */
        public InterfaceC2094b f61096j;

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
            this.f61089c = context;
        }

        public a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f61090d = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f61091e = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                this.f61092f = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.f61093g = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.f61094h = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a a(Drawable drawable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawable)) == null) {
                this.f61095i = drawable;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(InterfaceC2094b interfaceC2094b) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC2094b)) == null) {
                this.f61096j = interfaceC2094b;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f61088b = i2;
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
    public interface InterfaceC2094b {
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
        this.f61083f = true;
        this.a = aVar.f61089c;
        this.f61079b = aVar.f61090d;
        this.f61080c = aVar.f61091e;
        this.f61081d = aVar.f61092f;
        this.f61082e = aVar.f61093g;
        this.f61083f = aVar.f61094h;
        this.f61084g = aVar.f61095i;
        this.f61085h = aVar.f61096j;
        this.f61086i = aVar.a;
        this.f61087j = aVar.f61088b;
    }
}
