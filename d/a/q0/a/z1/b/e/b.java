package d.a.q0.a.z1.b.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f52089a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f52090b;

    /* renamed from: c  reason: collision with root package name */
    public Drawable f52091c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f52092d;

    /* renamed from: e  reason: collision with root package name */
    public long f52093e;

    /* renamed from: f  reason: collision with root package name */
    public int f52094f;

    /* renamed from: g  reason: collision with root package name */
    public a f52095g;

    /* renamed from: h  reason: collision with root package name */
    public Context f52096h;

    /* loaded from: classes8.dex */
    public interface a {
        void a(b bVar);
    }

    public b(Context context, int i2, CharSequence charSequence, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), charSequence, drawable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52092d = true;
        this.f52093e = 0L;
        this.f52094f = 0;
        this.f52096h = context;
        this.f52089a = i2;
        this.f52090b = charSequence;
        this.f52091c = drawable;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f52093e : invokeV.longValue;
    }

    public Drawable b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Drawable drawable = this.f52091c;
            if (drawable != null) {
                return drawable;
            }
            if (this.f52094f != 0) {
                Drawable drawable2 = this.f52096h.getResources().getDrawable(this.f52094f);
                this.f52094f = 0;
                this.f52091c = drawable2;
                return drawable2;
            }
            return null;
        }
        return (Drawable) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f52089a : invokeV.intValue;
    }

    public a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f52095g : (a) invokeV.objValue;
    }

    public CharSequence e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f52090b : (CharSequence) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f52092d : invokeV.booleanValue;
    }

    public void g(d.a.q0.a.z1.b.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
        }
    }

    public void h(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f52095g = aVar;
        }
    }
}
