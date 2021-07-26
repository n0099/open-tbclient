package d.a.q0.u0.n2;

import android.app.Activity;
import android.util.LongSparseArray;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f63981a;

    /* renamed from: b  reason: collision with root package name */
    public LongSparseArray<Integer> f63982b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.q0.u0.w1.c f63983c;

    /* renamed from: d  reason: collision with root package name */
    public d f63984d;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.u0.o2.f f63985e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f63986f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f63987g;

        public a(e eVar, d.a.q0.u0.o2.f fVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, fVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63985e = fVar;
            this.f63986f = str;
            this.f63987g = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.a.q0.u0.o2.f fVar = this.f63985e;
                if (fVar != null) {
                    fVar.n(this.f63986f, this.f63987g);
                }
                TiebaStatic.log(new StatisticItem("c13982").param("fid", this.f63987g).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public e() {
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
        this.f63981a = null;
        this.f63981a = new f();
        this.f63982b = new LongSparseArray<>();
    }

    public int a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            if (j == 0) {
                return 0;
            }
            Integer num = this.f63982b.get(j);
            if (num == null) {
                this.f63982b.put(j, 1);
                return 1;
            }
            this.f63982b.put(j, Integer.valueOf(num.intValue() + 1));
            return num.intValue() + 1;
        }
        return invokeJ.intValue;
    }

    public void b(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || j == 0) {
            return;
        }
        this.f63982b.remove(j);
    }

    public void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            this.f63981a.b(str, str2);
        }
    }

    public void d() {
        d.a.q0.u0.w1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (cVar = this.f63983c) == null) {
            return;
        }
        cVar.m();
    }

    public f e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f63981a : (f) invokeV.objValue;
    }

    public void f(Activity activity, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048581, this, activity, str, str2) == null) && activity != null && this.f63984d.c()) {
            if (this.f63983c == null) {
                this.f63983c = new d.a.q0.u0.w1.c(activity, R.id.frs_guide_delete_forum_tip);
            }
            this.f63983c.p(str);
            this.f63983c.q(str2);
            this.f63983c.r();
        }
    }

    public boolean g(String str, String str2) {
        InterceptResult invokeLL;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            if (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2) || (fVar = this.f63981a) == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis() - fVar.f(str, str2);
            if (currentTimeMillis < 3600000) {
                return false;
            }
            if (this.f63981a.e(str, str2) <= 3 || currentTimeMillis >= 2592000000L) {
                long c2 = this.f63981a.c(str, str2);
                if (c2 == 0 || System.currentTimeMillis() - c2 > 604800000) {
                    return this.f63981a.d(str, str2);
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void h(Activity activity, String str, String str2, String str3, d.a.q0.u0.o2.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048583, this, activity, str, str2, str3, fVar) == null) || activity == null) {
            return;
        }
        if (this.f63983c == null) {
            this.f63983c = new d.a.q0.u0.w1.c(activity, R.id.frs_guide_tip);
        }
        if (!StringUtils.isNull(str3)) {
            this.f63983c.n(str3);
        }
        this.f63983c.o(new a(this, fVar, str, str2));
        this.f63983c.s();
        TiebaStatic.log(new StatisticItem("c13894").param("fid", str2).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f63981a = null;
        this.f63984d = new d(str, str2);
    }
}
