package com.kwad.sdk.mvp;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.core.a.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes10.dex */
public class Presenter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<Presenter> f73066a;

    /* renamed from: b  reason: collision with root package name */
    public View f73067b;

    /* renamed from: c  reason: collision with root package name */
    public Object f73068c;

    /* renamed from: d  reason: collision with root package name */
    public PresenterState f73069d;

    /* renamed from: com.kwad.sdk.mvp.Presenter$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static abstract class PresenterState {
        public static final /* synthetic */ PresenterState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final PresenterState BIND;
        public static final PresenterState CREATE;
        public static final PresenterState DESTROY;
        public static final PresenterState INIT;
        public static final PresenterState UNBIND;
        public transient /* synthetic */ FieldHolder $fh;
        public int mIndex;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(416715571, "Lcom/kwad/sdk/mvp/Presenter$PresenterState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(416715571, "Lcom/kwad/sdk/mvp/Presenter$PresenterState;");
                    return;
                }
            }
            INIT = new PresenterState("INIT", 0, 0) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r10, r11, r12, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r10, Integer.valueOf(r11), Integer.valueOf(r12)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), (AnonymousClass1) objArr2[3]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                public void performCallState(Presenter presenter) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, presenter) == null) {
                    }
                }
            };
            CREATE = new PresenterState("CREATE", 1, 1) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r10, r11, r12, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r10, Integer.valueOf(r11), Integer.valueOf(r12)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), (AnonymousClass1) objArr2[3]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                public void performCallState(Presenter presenter) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, presenter) == null) {
                        for (Presenter presenter2 : presenter.f73066a) {
                            try {
                                presenter2.a(presenter.f73067b);
                            } catch (Exception e2) {
                                a.a(e2);
                                com.kwad.sdk.core.d.a.a(e2);
                            }
                        }
                    }
                }
            };
            BIND = new PresenterState("BIND", 2, 2) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r10, r11, r12, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r10, Integer.valueOf(r11), Integer.valueOf(r12)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), (AnonymousClass1) objArr2[3]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                public void performCallState(Presenter presenter) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, presenter) == null) {
                        for (Presenter presenter2 : presenter.f73066a) {
                            try {
                                presenter2.a(presenter.f73068c);
                            } catch (Exception e2) {
                                a.a(e2);
                                com.kwad.sdk.core.d.a.a(e2);
                            }
                        }
                    }
                }
            };
            UNBIND = new PresenterState("UNBIND", 3, 3) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r10, r11, r12, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r10, Integer.valueOf(r11), Integer.valueOf(r12)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), (AnonymousClass1) objArr2[3]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                public void performCallState(Presenter presenter) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, presenter) == null) {
                        for (Presenter presenter2 : presenter.f73066a) {
                            try {
                                presenter2.g();
                            } catch (Exception e2) {
                                a.a(e2);
                                com.kwad.sdk.core.d.a.a(e2);
                            }
                        }
                    }
                }
            };
            PresenterState presenterState = new PresenterState("DESTROY", 4, 4) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r10, r11, r12, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r10, Integer.valueOf(r11), Integer.valueOf(r12)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), (AnonymousClass1) objArr2[3]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                public void performCallState(Presenter presenter) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, presenter) == null) {
                        for (Presenter presenter2 : presenter.f73066a) {
                            try {
                                presenter2.h();
                            } catch (Exception e2) {
                                a.a(e2);
                                com.kwad.sdk.core.d.a.a(e2);
                            }
                        }
                    }
                }
            };
            DESTROY = presenterState;
            $VALUES = new PresenterState[]{INIT, CREATE, BIND, UNBIND, presenterState};
        }

        public PresenterState(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mIndex = i3;
        }

        public /* synthetic */ PresenterState(String str, int i2, int i3, AnonymousClass1 anonymousClass1) {
            this(str, i2, i3);
        }

        public static PresenterState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (PresenterState) Enum.valueOf(PresenterState.class, str) : (PresenterState) invokeL.objValue;
        }

        public static PresenterState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (PresenterState[]) $VALUES.clone() : (PresenterState[]) invokeV.objValue;
        }

        public int index() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mIndex : invokeV.intValue;
        }

        public abstract void performCallState(Presenter presenter);
    }

    public Presenter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f73066a = new ArrayList();
        this.f73069d = PresenterState.INIT;
    }

    public final <T extends View> T a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (T) this.f73067b.findViewById(i2) : (T) invokeI.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @UiThread
    public final void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            this.f73069d = PresenterState.CREATE;
            this.f73067b = view;
            b();
            this.f73069d.performCallState(this);
        }
    }

    public final void a(Presenter presenter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, presenter) == null) {
            this.f73066a.add(presenter);
            if (!i() || presenter.i()) {
                return;
            }
            a(this.f73067b);
        }
    }

    @UiThread
    public final void a(@NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            if (this.f73069d != PresenterState.INIT) {
                PresenterState presenterState = PresenterState.DESTROY;
            }
            if (this.f73069d == PresenterState.BIND) {
                g();
            }
            this.f73069d = PresenterState.BIND;
            this.f73068c = obj;
            a();
            this.f73069d.performCallState(this);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @UiThread
    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f73069d = PresenterState.UNBIND;
            c();
            this.f73069d.performCallState(this);
        }
    }

    @UiThread
    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.f73069d == PresenterState.BIND) {
                g();
            }
            this.f73069d = PresenterState.DESTROY;
            d();
            this.f73069d.performCallState(this);
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f73069d.index() >= PresenterState.CREATE.index() : invokeV.booleanValue;
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f73067b : (View) invokeV.objValue;
    }

    @Nullable
    @UiThread
    public Activity k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            Context m = m();
            HashSet hashSet = new HashSet();
            do {
                hashSet.add(m);
                if (!(m instanceof ContextWrapper)) {
                    return null;
                }
                if (m instanceof Activity) {
                    return (Activity) m;
                }
                if (m instanceof ResContext) {
                    Context delegatedContext = ((ResContext) m).getDelegatedContext();
                    if (delegatedContext instanceof Activity) {
                        return (Activity) delegatedContext;
                    }
                }
                m = ((ContextWrapper) m).getBaseContext();
            } while (!hashSet.contains(m));
            return null;
        }
        return (Activity) invokeV.objValue;
    }

    public Object l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f73068c : invokeV.objValue;
    }

    public final Context m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            View view = this.f73067b;
            if (view == null) {
                return null;
            }
            return view.getContext();
        }
        return (Context) invokeV.objValue;
    }
}
