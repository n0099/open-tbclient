package d.a.s0.a4.m;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.d.l;
import d.a.r0.z0.f0;
import d.a.r0.z0.i0;
import d.a.r0.z0.n;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.s0.a4.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1315a extends f0<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f57516a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f57517b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f57518c;

        public C1315a(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57516a = i2;
            this.f57517b = str;
            this.f57518c = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.r0.z0.f0
        public Integer doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i2 = this.f57516a;
                d.a.r0.r.r.a f2 = d.a.r0.r.r.a.f();
                l<String> g2 = f2.g("tb.write_privacy_state_space" + this.f57517b);
                if (g2 != null) {
                    i2 = d.a.c.e.m.b.d(g2.get(this.f57518c), this.f57516a);
                }
                return Integer.valueOf(i2);
            }
            return (Integer) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class b implements n<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f57519a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57519a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Integer num) {
            c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, num) == null) || (cVar = this.f57519a) == null) {
                return;
            }
            cVar.a(num.intValue());
        }
    }

    /* loaded from: classes9.dex */
    public interface c {
        void a(int i2);
    }

    public static void a(String str, int i2, c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65536, null, str, i2, cVar) == null) || StringUtils.isNull(str) || cVar == null) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (StringUtils.isNull(currentAccount)) {
            return;
        }
        i0.b(new C1315a(i2, currentAccount, str), new b(cVar));
    }

    public static void b(String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65537, null, str, i2) == null) || StringUtils.isNull(str)) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (StringUtils.isNull(currentAccount)) {
            return;
        }
        d.a.r0.r.r.a f2 = d.a.r0.r.r.a.f();
        l<String> g2 = f2.g("tb.write_privacy_state_space" + currentAccount);
        if (g2 != null) {
            g2.a(str, String.valueOf(i2));
        }
    }
}
