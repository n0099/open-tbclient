package d.a.p0.q.e;

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
import d.a.p0.w2.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.App;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final d.a.p0.w2.c0.l.a f61482a;

    /* renamed from: b  reason: collision with root package name */
    public final int f61483b;

    /* renamed from: c  reason: collision with root package name */
    public final int f61484c;

    /* renamed from: d  reason: collision with root package name */
    public final int f61485d;

    /* renamed from: e  reason: collision with root package name */
    public final List<String> f61486e;

    /* renamed from: f  reason: collision with root package name */
    public final List<d.a.p0.w2.c0.l.b> f61487f;

    /* renamed from: d.a.p0.q.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class C1598a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public class b extends BdAsyncTask<Integer, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f61488a;

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
            this.f61488a = aVar;
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
                this.f61488a.f61482a.c(numArr[0], numArr[1]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ b(a aVar, C1598a c1598a) {
            this(aVar);
        }
    }

    /* loaded from: classes8.dex */
    public class c extends BdAsyncTask<String, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f61489a;

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
            this.f61489a = aVar;
        }

        public /* synthetic */ c(a aVar, C1598a c1598a) {
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
                this.f61489a.f61482a.d(strArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d extends BdAsyncTask<Integer, Integer, List<d.a.p0.w2.c0.l.b>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f61490a;

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
            this.f61490a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<d.a.p0.w2.c0.l.b> doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                if (numArr == null || numArr.length <= 1 || numArr[0] == null || numArr[1] == null) {
                    return null;
                }
                return this.f61490a.f61482a.f(numArr[0], numArr[1]);
            }
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<d.a.p0.w2.c0.l.b> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                super.onPostExecute(list);
                if (d.a.p0.n1.o.k.a.e(list)) {
                    return;
                }
                this.f61490a.f61487f.addAll(list);
            }
        }

        public /* synthetic */ d(a aVar, C1598a c1598a) {
            this(aVar);
        }
    }

    /* loaded from: classes8.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f61491a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1138219797, "Ld/a/p0/q/e/a$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1138219797, "Ld/a/p0/q/e/a$e;");
                    return;
                }
            }
            f61491a = new a(null);
        }
    }

    /* loaded from: classes8.dex */
    public class f extends BdAsyncTask<d.a.p0.w2.c0.l.b, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f61492a;

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
            this.f61492a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(d.a.p0.w2.c0.l.b... bVarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVarArr)) == null) {
                if (bVarArr == null || bVarArr.length <= 0 || bVarArr[0] == null) {
                    return null;
                }
                this.f61492a.f61482a.g(bVarArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ f(a aVar, C1598a c1598a) {
            this(aVar);
        }
    }

    public /* synthetic */ a(C1598a c1598a) {
        this();
    }

    public static String g(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, advertAppInfo)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? e.f61491a : (a) invokeV.objValue;
    }

    public final d.a.p0.w2.c0.l.b c(IDownloadModel iDownloadModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iDownloadModel)) == null) {
            d.a.p0.w2.c0.l.b bVar = new d.a.p0.w2.c0.l.b();
            bVar.f65834f = iDownloadModel.getAppJson();
            bVar.f65830b = iDownloadModel.getPkgName();
            bVar.f65829a = iDownloadModel.getDownloadKey();
            bVar.f65832d = 0;
            bVar.f65833e = System.currentTimeMillis();
            bVar.f65831c = System.currentTimeMillis();
            return bVar;
        }
        return (d.a.p0.w2.c0.l.b) invokeL.objValue;
    }

    public final boolean d(@NonNull Cmatch cmatch) {
        InterceptResult invokeL;
        d.a.p0.w2.c0.l.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cmatch)) == null) {
            if (!this.f61486e.contains(cmatch.value) || d.a.p0.n1.o.k.a.e(this.f61487f) || (bVar = (d.a.p0.w2.c0.l.b) d.a.p0.n1.o.k.a.d(this.f61487f, 0)) == null) {
                return false;
            }
            return this.f61484c <= ((int) ((System.currentTimeMillis() - bVar.f65833e) / 60000));
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
            Iterator<d.a.p0.w2.c0.l.b> it = this.f61487f.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().f65829a, str)) {
                    it.remove();
                }
            }
            e(str);
        }
    }

    public final App h(@NonNull App app, @NonNull Cmatch cmatch) {
        InterceptResult invokeLL;
        d.a.p0.w2.c0.l.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, app, cmatch)) == null) {
            if (d.a.p0.n1.o.k.a.e(this.f61487f)) {
                return null;
            }
            Iterator<d.a.p0.w2.c0.l.b> it = this.f61487f.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bVar = null;
                    break;
                }
                bVar = it.next();
                if (!x.q(bVar.f65830b)) {
                    break;
                }
                bVar.f65836h = 2;
                o(bVar);
                it.remove();
            }
            if (bVar == null) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(bVar.f65834f);
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
            if (cmatch == Cmatch.PB_BANNER && d.a.p0.w2.a.i(app) == 14 && !d.a.p0.w2.a.q(app)) {
                return false;
            }
            if (cmatch == Cmatch.VIDEO_PB_COMMENT) {
                return (d.a.p0.w2.a.i(app) == 14 || d.a.p0.w2.a.i(app) == 7) ? false : true;
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
        for (d.a.p0.w2.c0.l.b bVar : this.f61487f) {
            if (bVar != null && TextUtils.equals(bVar.f65829a, str)) {
                p(bVar);
            }
        }
    }

    public void l(DownloadStatus downloadStatus, IDownloadModel iDownloadModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, downloadStatus, iDownloadModel) == null) || TextUtils.isEmpty(iDownloadModel.getDownloadKey()) || TextUtils.isEmpty(iDownloadModel.getPkgName())) {
            return;
        }
        d.a.p0.w2.c0.l.b c2 = c(iDownloadModel);
        if (downloadStatus == DownloadStatus.STATUS_INSTALL_SUCCESS) {
            c2.f65836h = 2;
            this.f61487f.remove(c2);
        } else {
            c2.f65836h = 1;
            if (!this.f61487f.contains(c2)) {
                this.f61487f.add(0, c2);
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
            if (d(cmatch) && app != null && d.a.p0.w2.a.o(app)) {
                return h(app, cmatch);
            }
            return null;
        }
        return (App) invokeLL.objValue;
    }

    public final void o(d.a.p0.w2.c0.l.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            new f(this, null).execute(bVar);
        }
    }

    public final void p(@NonNull d.a.p0.w2.c0.l.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            int i2 = bVar.f65832d + 1;
            bVar.f65832d = i2;
            if (i2 >= this.f61483b) {
                f(bVar.f65829a);
                return;
            }
            bVar.f65833e = System.currentTimeMillis();
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
        this.f61482a = d.a.p0.w2.c0.l.a.e();
        this.f61483b = d.a.p0.a.h().f();
        this.f61484c = d.a.p0.a.h().e();
        this.f61485d = d.a.p0.a.h().d();
        String g2 = d.a.p0.a.h().g();
        if (TextUtils.isEmpty(g2)) {
            this.f61486e = new ArrayList();
        } else {
            this.f61486e = Arrays.asList(g2.split("_"));
        }
        this.f61487f = Collections.synchronizedList(new ArrayList());
        m(this.f61485d, this.f61483b);
        new b(this, null).execute(Integer.valueOf(this.f61485d), Integer.valueOf(this.f61483b));
    }
}
