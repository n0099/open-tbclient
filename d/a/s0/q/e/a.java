package d.a.s0.q.e;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.ad.download.mvp.IDownloadModel;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.recapp.constants.Cmatch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.w2.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.App;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final d.a.s0.w2.c0.l.a f64711a;

    /* renamed from: b  reason: collision with root package name */
    public final int f64712b;

    /* renamed from: c  reason: collision with root package name */
    public final int f64713c;

    /* renamed from: d  reason: collision with root package name */
    public final int f64714d;

    /* renamed from: e  reason: collision with root package name */
    public final List<String> f64715e;

    /* renamed from: f  reason: collision with root package name */
    public final List<d.a.s0.w2.c0.l.b> f64716f;

    /* renamed from: d.a.s0.q.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class C1642a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public class b extends BdAsyncTask<Integer, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f64717a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64717a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                if (numArr == null || numArr.length <= 1 || numArr[0] == null || numArr[1] == null) {
                    return null;
                }
                this.f64717a.f64711a.c(numArr[0], numArr[1]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ b(a aVar, C1642a c1642a) {
            this(aVar);
        }
    }

    /* loaded from: classes9.dex */
    public class c extends BdAsyncTask<String, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f64718a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64718a = aVar;
        }

        public /* synthetic */ c(a aVar, C1642a c1642a) {
            this(aVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                if (strArr == null || strArr.length <= 0 || strArr[0] == null) {
                    return null;
                }
                this.f64718a.f64711a.d(strArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class d extends BdAsyncTask<Integer, Integer, List<d.a.s0.w2.c0.l.b>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f64719a;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64719a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<d.a.s0.w2.c0.l.b> doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                if (numArr == null || numArr.length <= 1 || numArr[0] == null || numArr[1] == null) {
                    return null;
                }
                return this.f64719a.f64711a.f(numArr[0], numArr[1]);
            }
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<d.a.s0.w2.c0.l.b> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                super.onPostExecute(list);
                if (d.a.s0.n1.o.k.a.e(list)) {
                    return;
                }
                this.f64719a.f64716f.addAll(list);
            }
        }

        public /* synthetic */ d(a aVar, C1642a c1642a) {
            this(aVar);
        }
    }

    /* loaded from: classes9.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f64720a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2060860718, "Ld/a/s0/q/e/a$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2060860718, "Ld/a/s0/q/e/a$e;");
                    return;
                }
            }
            f64720a = new a(null);
        }
    }

    /* loaded from: classes9.dex */
    public class f extends BdAsyncTask<d.a.s0.w2.c0.l.b, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f64721a;

        public f(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64721a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(d.a.s0.w2.c0.l.b... bVarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVarArr)) == null) {
                if (bVarArr == null || bVarArr.length <= 0 || bVarArr[0] == null) {
                    return null;
                }
                this.f64721a.f64711a.g(bVarArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ f(a aVar, C1642a c1642a) {
            this(aVar);
        }
    }

    public /* synthetic */ a(C1642a c1642a) {
        this();
    }

    public static String g(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, advertAppInfo)) == null) {
            if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.T3) == null) {
                return null;
            }
            return iLegoAdvert.getDownloadKey();
        }
        return (String) invokeL.objValue;
    }

    public static a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? e.f64720a : (a) invokeV.objValue;
    }

    public final d.a.s0.w2.c0.l.b c(IDownloadModel iDownloadModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iDownloadModel)) == null) {
            d.a.s0.w2.c0.l.b bVar = new d.a.s0.w2.c0.l.b();
            bVar.f69050f = iDownloadModel.getAppJson();
            bVar.f69046b = iDownloadModel.getPkgName();
            bVar.f69045a = iDownloadModel.getDownloadKey();
            bVar.f69048d = 0;
            bVar.f69049e = System.currentTimeMillis();
            bVar.f69047c = System.currentTimeMillis();
            return bVar;
        }
        return (d.a.s0.w2.c0.l.b) invokeL.objValue;
    }

    public final boolean d(@NonNull Cmatch cmatch) {
        InterceptResult invokeL;
        d.a.s0.w2.c0.l.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cmatch)) == null) {
            if (!this.f64715e.contains(cmatch.value) || d.a.s0.n1.o.k.a.e(this.f64716f) || (bVar = (d.a.s0.w2.c0.l.b) d.a.s0.n1.o.k.a.d(this.f64716f, 0)) == null) {
                return false;
            }
            return this.f64713c <= ((int) ((System.currentTimeMillis() - bVar.f69049e) / 60000));
        }
        return invokeL.booleanValue;
    }

    public final void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            new c(this, null).execute(str);
        }
    }

    public final void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            Iterator<d.a.s0.w2.c0.l.b> it = this.f64716f.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().f69045a, str)) {
                    it.remove();
                }
            }
            e(str);
        }
    }

    public final App h(@NonNull App app, @NonNull Cmatch cmatch) {
        InterceptResult invokeLL;
        d.a.s0.w2.c0.l.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, app, cmatch)) == null) {
            if (d.a.s0.n1.o.k.a.e(this.f64716f)) {
                return null;
            }
            Iterator<d.a.s0.w2.c0.l.b> it = this.f64716f.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bVar = null;
                    break;
                }
                bVar = it.next();
                if (!x.q(bVar.f69046b)) {
                    break;
                }
                bVar.f69052h = 2;
                o(bVar);
                it.remove();
            }
            if (bVar == null) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(bVar.f69050f);
                jSONObject.put("pos_name", app.pos_name);
                App parseFromJson = App.parseFromJson(jSONObject);
                if (j(cmatch, parseFromJson)) {
                    return parseFromJson;
                }
                return null;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (App) invokeLL.objValue;
    }

    public final boolean j(Cmatch cmatch, App app) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, cmatch, app)) == null) {
            if (cmatch == Cmatch.PB_BANNER && d.a.s0.w2.a.h(app) == 14 && !d.a.s0.w2.a.o(app)) {
                return false;
            }
            if (cmatch == Cmatch.VIDEO_PB_COMMENT) {
                return (d.a.s0.w2.a.h(app) == 14 || d.a.s0.w2.a.h(app) == 7) ? false : true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        for (d.a.s0.w2.c0.l.b bVar : this.f64716f) {
            if (bVar != null && TextUtils.equals(bVar.f69045a, str)) {
                p(bVar);
            }
        }
    }

    public void l(DownloadStatus downloadStatus, IDownloadModel iDownloadModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, downloadStatus, iDownloadModel) == null) || TextUtils.isEmpty(iDownloadModel.getDownloadKey()) || TextUtils.isEmpty(iDownloadModel.getPkgName())) {
            return;
        }
        d.a.s0.w2.c0.l.b c2 = c(iDownloadModel);
        if (downloadStatus == DownloadStatus.STATUS_INSTALL_SUCCESS) {
            c2.f69052h = 2;
            this.f64716f.remove(c2);
        } else {
            c2.f69052h = 1;
            if (!this.f64716f.contains(c2)) {
                this.f64716f.add(0, c2);
            }
        }
        o(c2);
    }

    public final void m(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            try {
                new d(this, null).execute(Integer.valueOf(i2), Integer.valueOf(i3));
            } catch (Exception unused) {
            }
        }
    }

    public App n(App app, Cmatch cmatch) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, app, cmatch)) == null) {
            if (d(cmatch) && app != null && d.a.s0.w2.a.m(app)) {
                return h(app, cmatch);
            }
            return null;
        }
        return (App) invokeLL.objValue;
    }

    public final void o(d.a.s0.w2.c0.l.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            new f(this, null).execute(bVar);
        }
    }

    public final void p(@NonNull d.a.s0.w2.c0.l.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            int i2 = bVar.f69048d + 1;
            bVar.f69048d = i2;
            if (i2 >= this.f64712b) {
                f(bVar.f69045a);
                return;
            }
            bVar.f69049e = System.currentTimeMillis();
            o(bVar);
        }
    }

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
                return;
            }
        }
        this.f64711a = d.a.s0.w2.c0.l.a.e();
        this.f64712b = d.a.s0.a.h().f();
        this.f64713c = d.a.s0.a.h().e();
        this.f64714d = d.a.s0.a.h().d();
        String g2 = d.a.s0.a.h().g();
        if (TextUtils.isEmpty(g2)) {
            this.f64715e = new ArrayList();
        } else {
            this.f64715e = Arrays.asList(g2.split("_"));
        }
        this.f64716f = Collections.synchronizedList(new ArrayList());
        m(this.f64714d, this.f64712b);
        new b(this, null).execute(Integer.valueOf(this.f64714d), Integer.valueOf(this.f64712b));
    }
}
