package d.a.n0.a.c0.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.c0.b.b;
import d.a.n0.a.e0.d;
import d.a.n0.a.k;
import h.d;
import h.j;
/* loaded from: classes7.dex */
public abstract class a<V extends View, M extends d.a.n0.a.c0.b.b> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f43464h;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public d.a.n0.a.c0.e.a f43465a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public V f43466b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public M f43467c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public M f43468d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public SwanAppComponentContainerView f43469e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public j f43470f;

    /* renamed from: g  reason: collision with root package name */
    public int f43471g;

    /* renamed from: d.a.n0.a.c0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0639a extends j<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43472e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f43473f;

        public C0639a(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43473f = aVar;
            this.f43472e = str;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: d.a.n0.a.c0.b.a */
        /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: d.a.n0.a.c0.b.a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // h.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = this.f43473f;
                aVar.f43466b = aVar.v(aVar.f43465a.b());
                a aVar2 = this.f43473f;
                aVar2.B(aVar2.f43466b);
                this.f43473f.f43469e.setTargetView(this.f43473f.f43466b, 0);
                a aVar3 = this.f43473f;
                aVar3.D(aVar3.f43466b, this.f43473f.f43467c, new d.a.n0.a.c0.f.b(true));
                if (a.f43464h) {
                    Log.d("Component-Base", this.f43472e + " insert delayed（view）: success");
                }
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                d.l("Component-Base", this.f43472e + " insert delayed（view）: fail");
                if (a.f43464h && th != null && TextUtils.equals(th.getMessage(), "save subscriber and return subscriber: nolinear !")) {
                    throw new RuntimeException("save subscriber and return subscriber: nolinear !");
                }
                this.f43473f.C();
            }
        }

        @Override // h.e
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                d.l("Component-Base", this.f43472e + " success should call onCompleted");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.a<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f43474e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f43475f;

        public b(a aVar, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43475f = aVar;
            this.f43474e = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(j<? super Object> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                if (a.f43464h) {
                    Log.d("Component-Base", "insert delayed => save thread: " + Thread.currentThread().getName());
                }
                if (this.f43474e != Thread.currentThread().getId()) {
                    d.a.n0.a.c0.g.a.a("Component-Base", "save subscriber and return subscriber: nolinear !");
                }
                this.f43475f.f43470f = jVar;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends d.a.n0.a.w2.g.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, String str, String str2, String str3, boolean z) {
            super(str, str2, str3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, str2, str3, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (String) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.n = z;
        }

        @Override // d.a.n0.a.w2.g.b.b, android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) ? this.n && super.onTouch(view, motionEvent) : invokeLL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(175468979, "Ld/a/n0/a/c0/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(175468979, "Ld/a/n0/a/c0/b/a;");
                return;
            }
        }
        f43464h = k.f45831a;
    }

    public a(@Nullable Context context, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, m};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        M j = j(m);
        this.f43467c = j;
        d.a.n0.a.c0.e.a c2 = d.a.n0.a.c0.d.a.c(j);
        this.f43465a = c2;
        if (c2 != null) {
            if (context != null) {
                c2.d(context);
                return;
            }
            return;
        }
        d.a.n0.a.e0.d.b("Component-Base", o() + " context is null !");
    }

    @CallSuper
    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            F();
        }
    }

    public void B(@NonNull V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v) == null) {
        }
    }

    @NonNull
    @UiThread
    public final d.a.n0.a.c0.b.c C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String o = o();
            if (f43464h) {
                Log.i("Component-Base", "=====================" + o + " start remove=====================");
            }
            d.a.n0.a.c0.e.a aVar = this.f43465a;
            if (aVar == null) {
                d.a.n0.a.c0.g.a.a("Component-Base", o + " remove with a null component context!");
                return new d.a.n0.a.c0.b.c(202, "component context is null");
            } else if (this.f43469e == null) {
                d.a.n0.a.e0.d.b("Component-Base", o + " remove must after insert");
                return new d.a.n0.a.c0.b.c(202, "component remove must after insert");
            } else if (!aVar.a().e(this)) {
                String str = o + " remove fail";
                d.a.n0.a.e0.d.b("Component-Base", str);
                return new d.a.n0.a.c0.b.c(1001, str);
            } else {
                A();
                if (f43464h) {
                    Log.d("Component-Base", o + " remove: success");
                }
                return new d.a.n0.a.c0.b.c(0, "success");
            }
        }
        return (d.a.n0.a.c0.b.c) invokeV.objValue;
    }

    @CallSuper
    public void D(@NonNull V v, @NonNull M m, @NonNull d.a.n0.a.c0.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, v, m, bVar) == null) {
            E(m, bVar);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void E(@NonNull M m, @NonNull d.a.n0.a.c0.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, m, bVar) == null) {
            if (this.f43469e == null) {
                d.a.n0.a.c0.g.a.a("Component-Base", "renderContainerView with a null container view");
                return;
            }
            if (bVar.a(1)) {
                this.f43469e.setHidden(m.j);
            }
            if (bVar.a(2)) {
                r(this.f43469e, m);
            }
        }
    }

    public final void F() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (jVar = this.f43470f) == null || jVar.isUnsubscribed()) {
            return;
        }
        this.f43470f.unsubscribe();
    }

    @NonNull
    @UiThread
    public final d.a.n0.a.c0.b.c G(@NonNull M m) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, m)) == null) {
            String o = o();
            d.a.n0.a.c0.b.c i2 = i(m);
            if (!i2.a()) {
                d.a.n0.a.e0.d.b("Component-Base", o + " update with a invalid model => " + i2.f43482b);
                return i2;
            }
            if (f43464h) {
                Log.i("Component-Base", "=====================" + o + " start update=====================");
            }
            M m2 = this.f43467c;
            if (m2 == m) {
                String str = o + " update with the same model";
                d.a.n0.a.c0.g.a.a("Component-Base", str);
                return new d.a.n0.a.c0.b.c(202, str);
            } else if (!TextUtils.equals(m2.f43477f, m.f43477f)) {
                String str2 = o + " update with different id: " + this.f43467c.f43477f + StringUtil.ARRAY_ELEMENT_SEPARATOR + m.f43477f;
                d.a.n0.a.c0.g.a.a("Component-Base", str2);
                return new d.a.n0.a.c0.b.c(202, str2);
            } else if (!TextUtils.equals(this.f43467c.f43478g, m.f43478g)) {
                String str3 = o + " update with different slave id: " + this.f43467c.f43478g + StringUtil.ARRAY_ELEMENT_SEPARATOR + m.f43478g;
                d.a.n0.a.c0.g.a.a("Component-Base", str3);
                return new d.a.n0.a.c0.b.c(202, str3);
            } else if (this.f43466b != null && this.f43469e != null) {
                if (this.f43465a == null) {
                    d.a.n0.a.c0.g.a.a("Component-Base", o + " update with a null component context!");
                    return new d.a.n0.a.c0.b.c(202, "component context is null");
                }
                M m3 = this.f43467c;
                this.f43468d = m3;
                d.a.n0.a.c0.f.b k = k(m3, m);
                M j = j(m);
                this.f43467c = j;
                D(this.f43466b, j, k);
                boolean f2 = this.f43465a.a().f(this, k);
                this.f43468d = null;
                if (!f2) {
                    String str4 = o + " update component fail";
                    d.a.n0.a.e0.d.b("Component-Base", str4);
                    return new d.a.n0.a.c0.b.c(1001, str4);
                }
                if (f43464h) {
                    Log.d("Component-Base", o + " component update: success");
                }
                return new d.a.n0.a.c0.b.c(0, "success");
            } else {
                String str5 = o + " update must after insert succeeded";
                d.a.n0.a.c0.g.a.a("Component-Base", str5);
                return new d.a.n0.a.c0.b.c(202, str5);
            }
        }
        return (d.a.n0.a.c0.b.c) invokeL.objValue;
    }

    @NonNull
    public final a g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            this.f43471g = i2 | this.f43471g;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public final boolean h(@NonNull d.a.n0.a.c0.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar)) == null) {
            boolean b2 = aVar.a().b(this);
            y(b2);
            return b2;
        }
        return invokeL.booleanValue;
    }

    @NonNull
    public final d.a.n0.a.c0.b.c i(M m) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, m)) == null) {
            if (m == null) {
                return new d.a.n0.a.c0.b.c(202, "model is null");
            }
            if (TextUtils.isEmpty(m.f43478g)) {
                return new d.a.n0.a.c0.b.c(202, "slave id is empty");
            }
            if (!m.isValid()) {
                return new d.a.n0.a.c0.b.c(202, "model is invalid");
            }
            return new d.a.n0.a.c0.b.c(0, "model is valid");
        }
        return (d.a.n0.a.c0.b.c) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0027  */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final M j(@NonNull M m) {
        InterceptResult invokeL;
        d.a.n0.a.c0.b.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, m)) == null) {
            try {
                bVar = (d.a.n0.a.c0.b.b) m.clone();
            } catch (CloneNotSupportedException e2) {
                e2.printStackTrace();
                d.a.n0.a.c0.g.a.b("Component-Base", "model must implement cloneable", e2);
                bVar = null;
                if (bVar == null) {
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                d.a.n0.a.c0.g.a.b("Component-Base", "clone model fail ！", e3);
                bVar = null;
                if (bVar == null) {
                }
            }
            if (bVar == null) {
                d.a.n0.a.c0.g.a.a("Component-Base", "clone model fail ！");
                return m;
            }
            return (M) bVar;
        }
        return (M) invokeL.objValue;
    }

    @NonNull
    @CallSuper
    public d.a.n0.a.c0.f.b k(@NonNull M m, @NonNull M m2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, m, m2)) == null) {
            d.a.n0.a.c0.f.b bVar = new d.a.n0.a.c0.f.b();
            d.a.n0.a.l1.e.a.a aVar = m2.l;
            if (aVar != null && aVar.e(m.l)) {
                bVar.b(3);
            }
            if (m.j != m2.j) {
                bVar.b(1);
            }
            if (m.k != m2.k) {
                bVar.b(2);
            }
            return bVar;
        }
        return (d.a.n0.a.c0.f.b) invokeLL.objValue;
    }

    @NonNull
    public final M l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? j(this.f43467c) : (M) invokeV.objValue;
    }

    @Nullable
    public final SwanAppComponentContainerView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f43469e : (SwanAppComponentContainerView) invokeV.objValue;
    }

    @NonNull
    public final M n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f43467c : (M) invokeV.objValue;
    }

    @NonNull
    public final String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            d.a.n0.a.c0.b.c i2 = i(this.f43467c);
            if (i2.a()) {
                return this.f43467c.f();
            }
            return "【illegal component#" + i2.f43482b + "】";
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public final M p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f43468d : (M) invokeV.objValue;
    }

    @Nullable
    public final V q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f43466b : (V) invokeV.objValue;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void r(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, swanAppComponentContainerView, m) == null) {
            swanAppComponentContainerView.setOnTouchListener(new c(this, m.f43478g, m.f43477f, m.f43476e, m.k));
        }
    }

    public final boolean s(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) ? (this.f43471g & i2) == i2 : invokeI.booleanValue;
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f43468d != null : invokeV.booleanValue;
    }

    @NonNull
    public SwanAppComponentContainerView u(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, context)) == null) ? new SwanAppComponentContainerView(context) : (SwanAppComponentContainerView) invokeL.objValue;
    }

    @NonNull
    public abstract V v(@NonNull Context context);

    @NonNull
    @UiThread
    public final d.a.n0.a.c0.b.c w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            String o = o();
            d.a.n0.a.c0.b.c i2 = i(this.f43467c);
            if (!i2.a()) {
                d.a.n0.a.e0.d.b("Component-Base", o + " insert with a invalid model => " + i2.f43482b);
                return i2;
            }
            if (f43464h) {
                Log.i("Component-Base", "=====================" + o + " start insert=====================");
            }
            d.a.n0.a.c0.e.a aVar = this.f43465a;
            if (aVar == null) {
                d.a.n0.a.e0.d.b("Component-Base", o + " insert with a null component context!");
                return new d.a.n0.a.c0.b.c(202, "component context is null");
            }
            Context b2 = aVar.b();
            if (this.f43469e != null || this.f43466b != null) {
                d.a.n0.a.e0.d.l("Component-Base", o + " repeat insert");
            }
            V v = v(this.f43465a.b());
            this.f43466b = v;
            B(v);
            SwanAppComponentContainerView u = u(b2);
            this.f43469e = u;
            u.setTargetView(this.f43466b);
            D(this.f43466b, this.f43467c, new d.a.n0.a.c0.f.b(true));
            if (h(this.f43465a)) {
                if (f43464h) {
                    Log.d("Component-Base", o + " insert: success");
                }
                return new d.a.n0.a.c0.b.c(0, "success");
            }
            d.a.n0.a.e0.d.b("Component-Base", o + " insert: attach fail");
            return new d.a.n0.a.c0.b.c(1001, "attach fail");
        }
        return (d.a.n0.a.c0.b.c) invokeV.objValue;
    }

    @Nullable
    @UiThread
    public final j x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            String o = o();
            d.a.n0.a.c0.b.c i2 = i(this.f43467c);
            if (!i2.a()) {
                d.a.n0.a.e0.d.b("Component-Base", o + " insert delayed with a invalid model => " + i2.f43482b);
                return null;
            }
            if (f43464h) {
                Log.i("Component-Base", "=====================" + o + " start insertDelayed=====================");
            }
            if (this.f43465a == null) {
                d.a.n0.a.c0.g.a.a("Component-Base", o + " insert delayed with a null component context!");
                return null;
            }
            if (this.f43469e != null) {
                d.a.n0.a.e0.d.l("Component-Base", o + " repeat insert delayed: container view repeat");
            }
            j jVar = this.f43470f;
            if (jVar != null && !jVar.isUnsubscribed()) {
                this.f43470f.unsubscribe();
                this.f43470f = null;
                d.a.n0.a.e0.d.l("Component-Base", o + " insert delayed repeat: subscriber repeat");
            }
            this.f43469e = u(this.f43465a.b());
            E(this.f43467c, new d.a.n0.a.c0.f.b(true));
            if (h(this.f43465a)) {
                if (f43464h) {
                    Log.d("Component-Base", o + " insert delayed（container view）: success");
                }
                h.d.b(new b(this, Thread.currentThread().getId())).z(new C0639a(this, o));
                return this.f43470f;
            }
            d.a.n0.a.e0.d.b("Component-Base", o + " insert delayed: attach fail");
            return null;
        }
        return (j) invokeV.objValue;
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
        }
    }

    @CallSuper
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (f43464h) {
                Log.d("Component-Base", o() + " onDestroy");
            }
            F();
        }
    }
}
