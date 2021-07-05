package com.ksad.lottie;

import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f33835a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<a> f33836b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, com.ksad.lottie.d.d> f33837c;

    /* renamed from: d  reason: collision with root package name */
    public final Comparator<Pair<String, Float>> f33838d;

    /* loaded from: classes7.dex */
    public interface a {
        void a(float f2);
    }

    public l() {
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
        this.f33835a = false;
        this.f33836b = new ArraySet();
        this.f33837c = new HashMap();
        this.f33838d = new Comparator<Pair<String, Float>>(this) { // from class: com.ksad.lottie.l.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ l f33839a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f33839a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, pair, pair2)) == null) {
                    float floatValue = pair.second.floatValue();
                    float floatValue2 = pair2.second.floatValue();
                    if (floatValue2 > floatValue) {
                        return 1;
                    }
                    return floatValue > floatValue2 ? -1 : 0;
                }
                return invokeLL.intValue;
            }
        };
    }

    public void a(String str, float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLF(1048576, this, str, f2) == null) && this.f33835a) {
            com.ksad.lottie.d.d dVar = this.f33837c.get(str);
            if (dVar == null) {
                dVar = new com.ksad.lottie.d.d();
                this.f33837c.put(str, dVar);
            }
            dVar.a(f2);
            if (str.equals("__container")) {
                for (a aVar : this.f33836b) {
                    aVar.a(f2);
                }
            }
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f33835a = z;
        }
    }
}
