package com.ksad.lottie;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public class LottieAnimationView extends ImageView {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f33555a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final h<d> f33556b;

    /* renamed from: c  reason: collision with root package name */
    public final h<Throwable> f33557c;

    /* renamed from: d  reason: collision with root package name */
    public final f f33558d;

    /* renamed from: e  reason: collision with root package name */
    public String f33559e;
    @RawRes

    /* renamed from: f  reason: collision with root package name */
    public int f33560f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f33561g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f33562h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f33563i;
    public Set<i> j;
    @Nullable
    public k<d> k;
    @Nullable
    public d l;

    /* loaded from: classes7.dex */
    public static class a extends View.BaseSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<a> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f33566a;

        /* renamed from: b  reason: collision with root package name */
        public int f33567b;

        /* renamed from: c  reason: collision with root package name */
        public float f33568c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f33569d;

        /* renamed from: e  reason: collision with root package name */
        public String f33570e;

        /* renamed from: f  reason: collision with root package name */
        public int f33571f;

        /* renamed from: g  reason: collision with root package name */
        public int f33572g;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(740912026, "Lcom/ksad/lottie/LottieAnimationView$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(740912026, "Lcom/ksad/lottie/LottieAnimationView$a;");
                    return;
                }
            }
            CREATOR = new Parcelable.Creator<a>() { // from class: com.ksad.lottie.LottieAnimationView.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                /* renamed from: a */
                public a createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new a(parcel) : (a) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                /* renamed from: a */
                public a[] newArray(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new a[i2] : (a[]) invokeI.objValue;
                }
            };
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Parcel parcel) {
            super(parcel);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Parcel) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f33566a = parcel.readString();
            this.f33568c = parcel.readFloat();
            this.f33569d = parcel.readInt() == 1;
            this.f33570e = parcel.readString();
            this.f33571f = parcel.readInt();
            this.f33572g = parcel.readInt();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Parcelable parcelable) {
            super(parcelable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcelable};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Parcelable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i2) == null) {
                super.writeToParcel(parcel, i2);
                parcel.writeString(this.f33566a);
                parcel.writeFloat(this.f33568c);
                parcel.writeInt(this.f33569d ? 1 : 0);
                parcel.writeString(this.f33570e);
                parcel.writeInt(this.f33571f);
                parcel.writeInt(this.f33572g);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1211942839, "Lcom/ksad/lottie/LottieAnimationView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1211942839, "Lcom/ksad/lottie/LottieAnimationView;");
                return;
            }
        }
        f33555a = LottieAnimationView.class.getSimpleName();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LottieAnimationView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f33556b = new h<d>(this) { // from class: com.ksad.lottie.LottieAnimationView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LottieAnimationView f33564a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f33564a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.ksad.lottie.h
            public void a(d dVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, dVar) == null) {
                    this.f33564a.setComposition(dVar);
                }
            }
        };
        this.f33557c = new h<Throwable>(this) { // from class: com.ksad.lottie.LottieAnimationView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LottieAnimationView f33565a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f33565a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.ksad.lottie.h
            public void a(Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    throw new IllegalStateException("Unable to parse composition", th);
                }
            }
        };
        this.f33558d = new f();
        this.f33561g = false;
        this.f33562h = false;
        this.f33563i = false;
        this.j = new HashSet();
        a((AttributeSet) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f33556b = new h<d>(this) { // from class: com.ksad.lottie.LottieAnimationView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LottieAnimationView f33564a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f33564a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.ksad.lottie.h
            public void a(d dVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, dVar) == null) {
                    this.f33564a.setComposition(dVar);
                }
            }
        };
        this.f33557c = new h<Throwable>(this) { // from class: com.ksad.lottie.LottieAnimationView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LottieAnimationView f33565a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f33565a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.ksad.lottie.h
            public void a(Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    throw new IllegalStateException("Unable to parse composition", th);
                }
            }
        };
        this.f33558d = new f();
        this.f33561g = false;
        this.f33562h = false;
        this.f33563i = false;
        this.j = new HashSet();
        a(attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LottieAnimationView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f33556b = new h<d>(this) { // from class: com.ksad.lottie.LottieAnimationView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LottieAnimationView f33564a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f33564a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.ksad.lottie.h
            public void a(d dVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, dVar) == null) {
                    this.f33564a.setComposition(dVar);
                }
            }
        };
        this.f33557c = new h<Throwable>(this) { // from class: com.ksad.lottie.LottieAnimationView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LottieAnimationView f33565a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f33565a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.ksad.lottie.h
            public void a(Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    throw new IllegalStateException("Unable to parse composition", th);
                }
            }
        };
        this.f33558d = new f();
        this.f33561g = false;
        this.f33562h = false;
        this.f33563i = false;
        this.j = new HashSet();
        a(attributeSet);
    }

    private void a(Drawable drawable, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65540, this, drawable, z) == null) {
            if (z && drawable != this.f33558d) {
                a();
            }
            e();
            super.setImageDrawable(drawable);
        }
    }

    private void a(@Nullable AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, attributeSet) == null) {
            g();
        }
    }

    private void e() {
        k<d> kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) || (kVar = this.k) == null) {
            return;
        }
        kVar.b(this.f33556b);
        this.k.d(this.f33557c);
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.l = null;
            this.f33558d.e();
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            setLayerType(this.f33563i && this.f33558d.n() ? 2 : 1, null);
        }
    }

    private void setCompositionTask(k<d> kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, kVar) == null) {
            f();
            e();
            this.k = kVar.a(this.f33556b).c(this.f33557c);
        }
    }

    @VisibleForTesting
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f33558d.c();
        }
    }

    public void a(Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animatorListener) == null) {
            this.f33558d.a(animatorListener);
        }
    }

    public void a(JsonReader jsonReader, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jsonReader, str) == null) {
            setCompositionTask(e.a(jsonReader, str));
        }
    }

    public void a(String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            a(new JsonReader(new StringReader(str)), str2);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f33558d.a(z);
        }
    }

    @MainThread
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f33558d.f();
            g();
        }
    }

    public void b(Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, animatorListener) == null) {
            this.f33558d.b(animatorListener);
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f33558d.n() : invokeV.booleanValue;
    }

    @MainThread
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f33558d.s();
            g();
        }
    }

    @Nullable
    public d getComposition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.l : (d) invokeV.objValue;
    }

    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            d dVar = this.l;
            if (dVar != null) {
                return dVar.c();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public int getFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f33558d.k() : invokeV.intValue;
    }

    @Nullable
    public String getImageAssetsFolder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f33558d.b() : (String) invokeV.objValue;
    }

    public float getMaxFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f33558d.i() : invokeV.floatValue;
    }

    public float getMinFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f33558d.h() : invokeV.floatValue;
    }

    @Nullable
    public l getPerformanceTracker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f33558d.d() : (l) invokeV.objValue;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f33558d.t() : invokeV.floatValue;
    }

    public int getRepeatCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f33558d.m() : invokeV.intValue;
    }

    public int getRepeatMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f33558d.l() : invokeV.intValue;
    }

    public float getScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f33558d.q() : invokeV.floatValue;
    }

    public float getSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f33558d.j() : invokeV.floatValue;
    }

    public boolean getUseHardwareAcceleration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f33563i : invokeV.booleanValue;
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, drawable) == null) {
            Drawable drawable2 = getDrawable();
            f fVar = this.f33558d;
            if (drawable2 == fVar) {
                super.invalidateDrawable(fVar);
            } else {
                super.invalidateDrawable(drawable);
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onAttachedToWindow();
            if (this.f33562h && this.f33561g) {
                b();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (c()) {
                d();
                this.f33561g = true;
            }
            a();
            super.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, parcelable) == null) {
            if (!(parcelable instanceof a)) {
                super.onRestoreInstanceState(parcelable);
                return;
            }
            a aVar = (a) parcelable;
            super.onRestoreInstanceState(aVar.getSuperState());
            String str = aVar.f33566a;
            this.f33559e = str;
            if (!TextUtils.isEmpty(str)) {
                setAnimation(this.f33559e);
            }
            int i2 = aVar.f33567b;
            this.f33560f = i2;
            if (i2 != 0) {
                setAnimation(i2);
            }
            setProgress(aVar.f33568c);
            if (aVar.f33569d) {
                b();
            }
            this.f33558d.a(aVar.f33570e);
            setRepeatMode(aVar.f33571f);
            setRepeatCount(aVar.f33572g);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            a aVar = new a(super.onSaveInstanceState());
            aVar.f33566a = this.f33559e;
            aVar.f33567b = this.f33560f;
            aVar.f33568c = this.f33558d.t();
            aVar.f33569d = this.f33558d.n();
            aVar.f33570e = this.f33558d.b();
            aVar.f33571f = this.f33558d.l();
            aVar.f33572g = this.f33558d.m();
            return aVar;
        }
        return (Parcelable) invokeV.objValue;
    }

    public void setAnimation(@RawRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.f33560f = i2;
            this.f33559e = null;
            setCompositionTask(e.a(getContext(), i2));
        }
    }

    public void setAnimation(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.f33559e = str;
            this.f33560f = 0;
            setCompositionTask(e.b(getContext(), str));
        }
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            a(str, (String) null);
        }
    }

    public void setAnimationFromUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            setCompositionTask(e.a(getContext(), str));
        }
    }

    public void setComposition(@NonNull d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, dVar) == null) {
            if (c.f33717a) {
                String str = f33555a;
                Log.v(str, "Set Composition \n" + dVar);
            }
            this.f33558d.setCallback(this);
            this.l = dVar;
            boolean a2 = this.f33558d.a(dVar);
            g();
            if (getDrawable() != this.f33558d || a2) {
                setImageDrawable(null);
                setImageDrawable(this.f33558d);
                requestLayout();
                for (i iVar : this.j) {
                    iVar.a(dVar);
                }
            }
        }
    }

    public void setFontAssetDelegate(com.ksad.lottie.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, aVar) == null) {
            this.f33558d.a(aVar);
        }
    }

    public void setFrame(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            this.f33558d.c(i2);
        }
    }

    public void setImageAssetDelegate(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, bVar) == null) {
            this.f33558d.a(bVar);
        }
    }

    public void setImageAssetsFolder(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.f33558d.a(str);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, bitmap) == null) {
            a();
            e();
            super.setImageBitmap(bitmap);
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, drawable) == null) {
            a(drawable, true);
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            a();
            e();
            super.setImageResource(i2);
        }
    }

    public void setMaxFrame(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            this.f33558d.b(i2);
        }
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048616, this, f2) == null) {
            this.f33558d.b(f2);
        }
    }

    public void setMinFrame(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            this.f33558d.a(i2);
        }
    }

    public void setMinProgress(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048618, this, f2) == null) {
            this.f33558d.a(f2);
        }
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.f33558d.b(z);
        }
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048620, this, f2) == null) {
            this.f33558d.d(f2);
        }
    }

    public void setRepeatCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            this.f33558d.e(i2);
        }
    }

    public void setRepeatMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i2) == null) {
            this.f33558d.d(i2);
        }
    }

    public void setScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048623, this, f2) == null) {
            this.f33558d.e(f2);
            if (getDrawable() == this.f33558d) {
                a((Drawable) null, false);
                a((Drawable) this.f33558d, false);
            }
        }
    }

    public void setSpeed(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048624, this, f2) == null) {
            this.f33558d.c(f2);
        }
    }

    public void setTextDelegate(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, mVar) == null) {
            this.f33558d.a(mVar);
        }
    }
}
