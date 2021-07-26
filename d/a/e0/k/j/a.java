package d.a.e0.k.j;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public interface a {

    /* renamed from: d.a.e0.k.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0591a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f42667a;

        /* renamed from: b  reason: collision with root package name */
        public String f42668b;

        /* renamed from: c  reason: collision with root package name */
        public long f42669c;

        /* renamed from: d  reason: collision with root package name */
        public String f42670d;

        public C0591a() {
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
            this.f42667a = 2;
        }
    }

    void a(C0591a c0591a);
}
