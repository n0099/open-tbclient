package d.a.g0.k.j;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public interface a {

    /* renamed from: d.a.g0.k.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0633a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f45482a;

        /* renamed from: b  reason: collision with root package name */
        public String f45483b;

        /* renamed from: c  reason: collision with root package name */
        public long f45484c;

        /* renamed from: d  reason: collision with root package name */
        public String f45485d;

        public C0633a() {
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
            this.f45482a = 2;
        }
    }

    void a(C0633a c0633a);
}
