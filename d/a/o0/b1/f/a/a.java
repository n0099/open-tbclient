package d.a.o0.b1.f.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.m.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class a<T> extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f51633b;

    /* renamed from: c  reason: collision with root package name */
    public List<T> f51634c;

    /* renamed from: d  reason: collision with root package name */
    public Context f51635d;

    /* renamed from: e  reason: collision with root package name */
    public LayoutInflater f51636e;

    /* renamed from: f  reason: collision with root package name */
    public e<T> f51637f;

    /* renamed from: d.a.o0.b1.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC1175a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public T f51638e;

        /* renamed from: f  reason: collision with root package name */
        public int f51639f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f51640g;

        public View$OnClickListenerC1175a(a aVar, T t, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, t, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51640g = aVar;
            this.f51638e = t;
            this.f51639f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e<T> eVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (eVar = this.f51640g.f51637f) == null) {
                return;
            }
            T t = this.f51638e;
            int i2 = this.f51639f;
            eVar.a(view, t, i2, i2);
        }
    }

    public a(Context context, List<T> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f51635d = context;
        this.f51634c = list == null ? new ArrayList() : new ArrayList(list);
        this.f51633b = i2;
        this.f51636e = LayoutInflater.from(this.f51635d);
    }

    @Override // d.a.o0.b1.f.a.b
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f51634c.size() : invokeV.intValue;
    }

    @Override // d.a.o0.b1.f.a.b
    public View b(int i2, ViewGroup viewGroup) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, viewGroup)) == null) {
            View inflate = this.f51636e.inflate(this.f51633b, viewGroup, false);
            c cVar = new c(inflate);
            T t = this.f51634c.get(i2);
            f(cVar, t, i2);
            cVar.c(new View$OnClickListenerC1175a(this, t, i2));
            return inflate;
        }
        return (View) invokeIL.objValue;
    }

    public abstract void f(c cVar, T t, int i2);

    public void g(List<T> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            this.f51634c = list;
            c();
        }
    }

    public void h(e<T> eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.f51637f = eVar;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(Context context, int i2) {
        this(context, null, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (List) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }
}
