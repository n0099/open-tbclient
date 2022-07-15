package com.repackage;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ud0;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class md0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String m = "def";
    public transient /* synthetic */ FieldHolder $fh;
    public td0 a;
    public String b;
    public List<ud0> c;
    public List<ud0> d;
    public od0 e;
    public od0 f;
    public ud0 g;
    public ud0.c h;
    public Context i;
    public Boolean j;
    public boolean k;
    public ud0.c l;

    /* loaded from: classes6.dex */
    public class a extends ud0.c<ud0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ md0 a;

        public a(md0 md0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {md0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = md0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ud0.c
        /* renamed from: e */
        public void a(ud0 ud0Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, ud0Var, str) == null) {
                this.a.d.remove(ud0Var);
                this.a.c.add(ud0Var);
                if (ud0Var == this.a.g) {
                    this.a.a.i(md0.m, this.a.g.m());
                }
                if (this.a.q()) {
                    this.a.r();
                }
                super.a(ud0Var, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ud0.c
        /* renamed from: f */
        public void b(ud0 ud0Var, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, ud0Var, exc) == null) {
                super.b(ud0Var, exc);
                this.a.s();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ud0.c
        /* renamed from: g */
        public void c(ud0 ud0Var, long j, long j2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{ud0Var, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)}) == null) {
                super.c(ud0Var, j, j2, i);
                int k = this.a.k();
                if (this.a.h != null) {
                    this.a.h.c(this.a, 0L, 100L, k);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final md0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-189190374, "Lcom/repackage/md0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-189190374, "Lcom/repackage/md0$b;");
                    return;
                }
            }
            a = new md0(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755503272, "Lcom/repackage/md0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755503272, "Lcom/repackage/md0;");
        }
    }

    public /* synthetic */ md0(a aVar) {
        this();
    }

    public static void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            Log.d("DuAr_InitModel", str);
        }
    }

    public static final md0 j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            m = str;
            return b.a;
        }
        return (md0) invokeL.objValue;
    }

    public final void h(ud0 ud0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ud0Var) == null) {
            boolean q = ud0Var.q();
            if (p()) {
                i("isLoaded " + q + StringUtil.ARRAY_ELEMENT_SEPARATOR + ud0Var.o() + " to " + ud0Var.m());
            }
            if (ud0Var.q()) {
                this.c.add(ud0Var);
                return;
            }
            if (this.d == null) {
                this.d = new ArrayList();
            }
            this.d.add(ud0Var);
        }
    }

    public final int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<ud0> list = this.d;
            float f = 100.0f;
            if (list != null && list.size() != 0) {
                float size = 100.0f / (this.c.size() + this.d.size());
                float f2 = 0.0f;
                for (int i = 0; i < this.d.size(); i++) {
                    f2 += (this.d.get(i).n() / 100.0f) * size;
                }
                f = (this.c.size() * size) + f2;
            }
            return (int) f;
        }
        return invokeV.intValue;
    }

    public File l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f.g : (File) invokeV.objValue;
    }

    public File m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.e.g : (File) invokeV.objValue;
    }

    public boolean n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            Boolean bool = this.j;
            if (bool != null && bool.booleanValue()) {
                return this.j.booleanValue();
            }
            this.j = Boolean.FALSE;
            long currentTimeMillis = System.currentTimeMillis();
            boolean k0 = dd0.k0();
            if (p()) {
                i("ARControllerProxy.loadSoFile " + k0);
            }
            if (!k0) {
                return this.j.booleanValue();
            }
            File file = this.f.g;
            if (p()) {
                i("setResConfig " + file);
            }
            if (file != null) {
                ed0.s(new fd0(file.getAbsolutePath()));
            }
            if (p()) {
                i("initRecource costMS: " + (System.currentTimeMillis() - currentTimeMillis));
            }
            Boolean bool2 = Boolean.TRUE;
            this.j = bool2;
            return bool2.booleanValue();
        }
        return invokeL.booleanValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.c.clear();
            List<ud0> list = this.d;
            if (list != null) {
                list.clear();
            }
            if ("live".equals(ed0.e())) {
                this.e = od0.i();
                this.f = od0.g();
            }
            if (BdUploadHandler.MEDIA_SOURCE_KEY.equals(ed0.e())) {
                this.e = od0.h();
                this.f = od0.f();
            }
            if ("tieba".equals(ed0.e())) {
                this.e = od0.i();
                this.f = od0.f();
            }
            nd0 nd0Var = new nd0(this.f);
            this.g = nd0Var;
            h(nd0Var);
            h(new nd0(this.e));
        }
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? ed0.m() : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        List<ud0> list;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.c.size() > 0 && ((list = this.d) == null || list.size() == 0) : invokeV.booleanValue;
    }

    public void r() {
        File file;
        ud0.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this) {
                this.k = false;
            }
            boolean n = n(this.i);
            String str = null;
            if (!n && (cVar = this.h) != null) {
                cVar.b(null, null);
                return;
            }
            this.a.n(this.b);
            this.a.f();
            if (p()) {
                i("all onCompleted " + n);
            }
            if (this.h == null || !n) {
                return;
            }
            od0 od0Var = this.f;
            if (od0Var != null && (file = od0Var.g) != null) {
                str = file.getAbsolutePath();
            }
            this.h.a(this, str);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (p()) {
                i("all onFailed .");
            }
            synchronized (this) {
                this.k = false;
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b = this.a.e(m);
            List<ud0> list = this.d;
            if (list != null && list.size() > 0) {
                for (ud0 ud0Var : this.d) {
                    ud0Var.l(this.l);
                }
                return;
            }
            r();
        }
    }

    public void u(Context context, ud0.c<md0> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, context, cVar) == null) {
            this.i = context;
            this.h = cVar;
            synchronized (this) {
                if (this.k) {
                    if (p()) {
                        i("start return, isLoading true");
                    }
                    return;
                }
                this.k = true;
                o();
                t();
            }
        }
    }

    public md0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new ArrayList();
        this.d = null;
        this.l = new a(this);
        td0 td0Var = new td0(pd0.d().g());
        this.a = td0Var;
        td0Var.h(m);
        o();
    }
}
