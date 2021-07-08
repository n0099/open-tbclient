package d.a.n0.a.z1.b.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f48787a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f48788b;

    /* renamed from: c  reason: collision with root package name */
    public Drawable f48789c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f48790d;

    /* renamed from: e  reason: collision with root package name */
    public long f48791e;

    /* renamed from: f  reason: collision with root package name */
    public int f48792f;

    /* renamed from: g  reason: collision with root package name */
    public a f48793g;

    /* renamed from: h  reason: collision with root package name */
    public Context f48794h;

    /* loaded from: classes7.dex */
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
        this.f48790d = true;
        this.f48791e = 0L;
        this.f48792f = 0;
        this.f48794h = context;
        this.f48787a = i2;
        this.f48788b = charSequence;
        this.f48789c = drawable;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f48791e : invokeV.longValue;
    }

    public Drawable b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Drawable drawable = this.f48789c;
            if (drawable != null) {
                return drawable;
            }
            if (this.f48792f != 0) {
                Drawable drawable2 = this.f48794h.getResources().getDrawable(this.f48792f);
                this.f48792f = 0;
                this.f48789c = drawable2;
                return drawable2;
            }
            return null;
        }
        return (Drawable) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f48787a : invokeV.intValue;
    }

    public a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f48793g : (a) invokeV.objValue;
    }

    public CharSequence e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f48788b : (CharSequence) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f48790d : invokeV.booleanValue;
    }

    public void g(d.a.n0.a.z1.b.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
        }
    }

    public void h(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f48793g = aVar;
        }
    }
}
