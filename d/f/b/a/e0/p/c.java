package d.f.b.a.e0.p;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f73142a;

    /* renamed from: b  reason: collision with root package name */
    public final float f73143b;

    /* renamed from: c  reason: collision with root package name */
    public final float f73144c;

    /* renamed from: d  reason: collision with root package name */
    public final int f73145d;

    /* renamed from: e  reason: collision with root package name */
    public final int f73146e;

    /* renamed from: f  reason: collision with root package name */
    public final float f73147f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(String str) {
        this(str, Float.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], ((Float) objArr2[1]).floatValue(), ((Float) objArr2[2]).floatValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue(), ((Float) objArr2[5]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public c(String str, float f2, float f3, int i2, int i3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f4)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f73142a = str;
        this.f73143b = f2;
        this.f73144c = f3;
        this.f73145d = i2;
        this.f73146e = i3;
        this.f73147f = f4;
    }
}
