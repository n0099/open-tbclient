package d.a.n0.a.f1.e.f;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.f1.e.f.c;
import d.a.n0.a.v2.e1.d;
import d.a.n0.a.v2.y0;
import kotlin.TypeCastException;
/* loaded from: classes7.dex */
public abstract class c<SelfT extends c<SelfT>> implements d<SelfT> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f44483e;

    /* loaded from: classes7.dex */
    public static final class a extends c<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public a E() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (a) invokeV.objValue;
        }

        @Override // d.a.n0.a.v2.e1.d
        public /* bridge */ /* synthetic */ d a() {
            E();
            return this;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((Bundle) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public SelfT A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (q()) {
                this.f44483e.remove(str);
            }
            return (SelfT) a();
        }
        return (SelfT) invokeL.objValue;
    }

    public Bundle B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!q()) {
                this.f44483e = new Bundle();
            }
            return this.f44483e;
        }
        return (Bundle) invokeV.objValue;
    }

    public Bundle C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? q() ? new Bundle(B()) : new Bundle() : (Bundle) invokeV.objValue;
    }

    public SelfT D(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bundle)) == null) {
            r(bundle);
            return (SelfT) a();
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (q()) {
                this.f44483e.clear();
            }
            return (SelfT) a();
        }
        return (SelfT) invokeV.objValue;
    }

    public boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? q() && this.f44483e.containsKey(str) : invokeL.booleanValue;
    }

    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? d.a.n0.a.f1.e.f.a.f44474a.a(this, str).booleanValue() : invokeL.booleanValue;
    }

    public boolean e(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048583, this, str, z)) == null) ? d.a.n0.a.f1.e.f.a.f44474a.b(this, str, Boolean.valueOf(z)).booleanValue() : invokeLZ.booleanValue;
    }

    @Nullable
    public Bundle f(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? d.a.n0.a.f1.e.f.a.f44480g.a(this, str) : (Bundle) invokeL.objValue;
    }

    public float g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) ? d.a.n0.a.f1.e.f.a.f44477d.a(this, str).floatValue() : invokeL.floatValue;
    }

    public float h(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(1048586, this, str, f2)) == null) ? d.a.n0.a.f1.e.f.a.f44477d.b(this, str, Float.valueOf(f2)).floatValue() : invokeLF.floatValue;
    }

    public int i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) ? d.a.n0.a.f1.e.f.a.f44475b.a(this, str).intValue() : invokeL.intValue;
    }

    public int j(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, str, i2)) == null) ? d.a.n0.a.f1.e.f.a.f44475b.b(this, str, Integer.valueOf(i2)).intValue() : invokeLI.intValue;
    }

    public long k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) ? d.a.n0.a.f1.e.f.a.f44476c.a(this, str).longValue() : invokeL.longValue;
    }

    public long l(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048590, this, str, j)) == null) ? d.a.n0.a.f1.e.f.a.f44476c.b(this, str, Long.valueOf(j)).longValue() : invokeLJ.longValue;
    }

    @Nullable
    public <T extends Parcelable> T m(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            try {
                return (T) d.a.n0.a.f1.e.f.a.f44481h.a(this, str);
            } catch (TypeCastException unused) {
                return null;
            }
        }
        return (T) invokeL.objValue;
    }

    @Nullable
    public String n(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) ? d.a.n0.a.f1.e.f.a.f44478e.a(this, str) : (String) invokeL.objValue;
    }

    public String o(@Nullable String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, str, str2)) == null) ? d.a.n0.a.f1.e.f.a.f44478e.b(this, str, str2) : (String) invokeLL.objValue;
    }

    @Nullable
    public String[] p(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) ? d.a.n0.a.f1.e.f.a.f44479f.a(this, str) : (String[]) invokeL.objValue;
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f44483e != null : invokeV.booleanValue;
    }

    public SelfT r(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, bundle)) == null) {
            if (bundle != null && !bundle.isEmpty()) {
                B().putAll(bundle);
            }
            return (SelfT) a();
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT s(@Nullable String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048597, this, str, z)) == null) {
            d.a.n0.a.f1.e.f.a.f44474a.d(this, str, Boolean.valueOf(z));
            return (SelfT) a();
        }
        return (SelfT) invokeLZ.objValue;
    }

    public SelfT t(@Nullable String str, @Nullable Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, str, bundle)) == null) {
            d.a.n0.a.f1.e.f.a.f44480g.d(this, str, bundle);
            return (SelfT) a();
        }
        return (SelfT) invokeLL.objValue;
    }

    public synchronized String toString() {
        InterceptResult invokeV;
        String bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            synchronized (this) {
                bundle = q() ? this.f44483e.toString() : "empty";
            }
            return bundle;
        }
        return (String) invokeV.objValue;
    }

    public SelfT u(@Nullable String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048600, this, str, f2)) == null) {
            d.a.n0.a.f1.e.f.a.f44477d.d(this, str, Float.valueOf(f2));
            return (SelfT) a();
        }
        return (SelfT) invokeLF.objValue;
    }

    public SelfT v(@Nullable String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048601, this, str, i2)) == null) {
            d.a.n0.a.f1.e.f.a.f44475b.d(this, str, Integer.valueOf(i2));
            return (SelfT) a();
        }
        return (SelfT) invokeLI.objValue;
    }

    public SelfT w(@Nullable String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048602, this, str, j)) == null) {
            d.a.n0.a.f1.e.f.a.f44476c.d(this, str, Long.valueOf(j));
            return (SelfT) a();
        }
        return (SelfT) invokeLJ.objValue;
    }

    public SelfT x(@Nullable String str, @Nullable Parcelable parcelable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, str, parcelable)) == null) {
            d.a.n0.a.f1.e.f.a.f44481h.d(this, str, parcelable);
            return (SelfT) a();
        }
        return (SelfT) invokeLL.objValue;
    }

    public SelfT y(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, str2)) == null) {
            d.a.n0.a.f1.e.f.a.f44478e.d(this, str, str2);
            return (SelfT) a();
        }
        return (SelfT) invokeLL.objValue;
    }

    public SelfT z(@Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048605, this, str, strArr)) == null) {
            d.a.n0.a.f1.e.f.a.f44479f.d(this, str, strArr);
            return (SelfT) a();
        }
        return (SelfT) invokeLL.objValue;
    }

    public c(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bundle};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        new y0();
        this.f44483e = bundle;
    }
}
