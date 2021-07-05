package d.a.s0.c2;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.faceshop.UserCollectModel;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import com.baidu.tieba.newfaceshop.NewFaceSyncDownloadModel;
import com.baidu.tieba.newfaceshop.NewFaceSyncUploadModel;
import com.baidu.tieba.newfaceshop.message.GetCloudFaceGroupMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.s0.p0.u;
import d.a.s0.p0.w;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static volatile d f57926g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NewFaceSyncUploadModel f57927a;

    /* renamed from: b  reason: collision with root package name */
    public NewFaceSyncDownloadModel f57928b;

    /* renamed from: c  reason: collision with root package name */
    public NewFaceGroupDownloadModel f57929c;

    /* renamed from: d  reason: collision with root package name */
    public w f57930d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f57931e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f57932f;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f57933e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57933e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<MyEmotionGroupData> f2;
            String str;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (f2 = d.a.s0.c2.c.i().f()) == null) {
                return;
            }
            if (f2.isEmpty()) {
                str = UserCollectModel.ALL_DELETE;
            } else {
                StringBuilder sb = new StringBuilder();
                int i2 = 0;
                for (int i3 = 0; i3 < f2.size() && i2 < 30; i3++) {
                    MyEmotionGroupData myEmotionGroupData = f2.get(i3);
                    if (myEmotionGroupData != null) {
                        sb.append(myEmotionGroupData.getGroupId());
                        if (i3 < f2.size() - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                str = sb.toString();
            }
            this.f57933e.f57927a.w(str);
        }
    }

    /* loaded from: classes9.dex */
    public class b implements d.a.s0.c2.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f57934a;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ GetCloudFaceGroupMessage f57935e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f57936f;

            public a(b bVar, GetCloudFaceGroupMessage getCloudFaceGroupMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, getCloudFaceGroupMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f57936f = bVar;
                this.f57935e = getCloudFaceGroupMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f57936f.f57934a.f57930d.f(this.f57935e.getCollectEmotionList());
                }
            }
        }

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57934a = dVar;
        }

        @Override // d.a.s0.c2.e.a
        public void a(GetCloudFaceGroupMessage getCloudFaceGroupMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, getCloudFaceGroupMessage) == null) {
                if (getCloudFaceGroupMessage == null) {
                    this.f57934a.f57932f = false;
                    this.f57934a.f57931e = false;
                    return;
                }
                if (getCloudFaceGroupMessage.getCollectUpdateTime() <= d.k()) {
                    this.f57934a.f57932f = false;
                    if (getCloudFaceGroupMessage.getCollectUpdateTime() < d.k()) {
                        new UserCollectModel().w();
                    }
                    u.s().n();
                } else if (getCloudFaceGroupMessage.getCollectEmotionList() == null) {
                    this.f57934a.f57932f = false;
                } else {
                    d.a.s0.c2.a.b().a(new a(this, getCloudFaceGroupMessage));
                }
                if (getCloudFaceGroupMessage.getFaceGroupUpdateTime() <= d.l()) {
                    this.f57934a.f57931e = false;
                    if (getCloudFaceGroupMessage.getFaceGroupUpdateTime() < d.l()) {
                        this.f57934a.w();
                    }
                    d.a.s0.c2.c.i().e();
                } else if (getCloudFaceGroupMessage.getFaceGroupData() != null) {
                    this.f57934a.p(getCloudFaceGroupMessage.getFaceGroupData());
                } else {
                    this.f57934a.f57931e = false;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f57937e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f57938f;

        public c(d dVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57938f = dVar;
            this.f57937e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.s0.c2.c.i().b(true);
                List<MyEmotionGroupData> f2 = d.a.s0.c2.c.i().f();
                ArrayList arrayList = new ArrayList();
                if (f2 != null) {
                    for (MyEmotionGroupData myEmotionGroupData : f2) {
                        arrayList.add(myEmotionGroupData.getGroupId());
                    }
                }
                this.f57938f.h(this.f57937e, arrayList);
            }
        }
    }

    /* renamed from: d.a.s0.c2.d$d  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1350d implements d.a.s0.c2.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f57939a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f57940b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f57941c;

        public C1350d(d dVar, AtomicInteger atomicInteger, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, atomicInteger, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57941c = dVar;
            this.f57939a = atomicInteger;
            this.f57940b = list;
        }

        @Override // d.a.s0.c2.e.b
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.f57939a.decrementAndGet() == 0) {
                this.f57941c.q(this.f57940b);
            }
        }

        @Override // d.a.s0.c2.e.b
        public void onProgress(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            }
        }

        @Override // d.a.s0.c2.e.b
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && this.f57939a.decrementAndGet() == 0) {
                this.f57941c.q(this.f57940b);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f57942e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f57943f;

        public e(d dVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57943f = dVar;
            this.f57942e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f57943f.q(this.f57942e);
            }
        }
    }

    public d() {
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
        this.f57927a = new NewFaceSyncUploadModel();
        this.f57928b = new NewFaceSyncDownloadModel();
        this.f57929c = new NewFaceGroupDownloadModel();
        this.f57930d = new w();
    }

    public static String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? TbadkCoreApplication.getCurrentAccount() == null ? "" : String.valueOf(Math.abs(TbadkCoreApplication.getCurrentAccount().hashCode())) : (String) invokeV.objValue;
    }

    public static long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            d.a.r0.r.d0.b j = d.a.r0.r.d0.b.j();
            return j.l("face_collect_update_time" + j(), 0L);
        }
        return invokeV.longValue;
    }

    public static long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            d.a.r0.r.d0.b j = d.a.r0.r.d0.b.j();
            return j.l("face_group_update_time" + j(), 0L);
        }
        return invokeV.longValue;
    }

    public static d m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f57926g == null) {
                synchronized (d.class) {
                    if (f57926g == null) {
                        f57926g = new d();
                    }
                }
            }
            return f57926g;
        }
        return (d) invokeV.objValue;
    }

    public static void s(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65548, null, j) == null) {
            d.a.r0.r.d0.b j2 = d.a.r0.r.d0.b.j();
            j2.w("face_collect_update_time" + j(), j);
        }
    }

    public static void t(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65549, null, j) == null) {
            d.a.r0.r.d0.b j2 = d.a.r0.r.d0.b.j();
            j2.w("face_group_update_time" + j(), j);
        }
    }

    public final void h(List<String> list, List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, list, list2) == null) {
            if (list2 != null) {
                ArrayList arrayList = new ArrayList();
                for (String str : list2) {
                    if (!TextUtils.isEmpty(str) && !list.contains(str)) {
                        arrayList.add(str);
                    }
                }
                if (!arrayList.isEmpty()) {
                    d.a.s0.c2.c.i().c(arrayList, false);
                }
            }
            i(list, list2);
        }
    }

    public final void i(List<String> list, List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, list2) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList<String> arrayList = new ArrayList();
                for (String str : list) {
                    if (!list2.contains(str)) {
                        arrayList.add(str);
                    }
                }
                if (!arrayList.isEmpty()) {
                    AtomicInteger atomicInteger = new AtomicInteger(arrayList.size());
                    for (String str2 : arrayList) {
                        this.f57929c.w(str2, Boolean.FALSE, new C1350d(this, atomicInteger, list));
                    }
                    return;
                }
                r(list);
                return;
            }
            this.f57931e = false;
        }
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f57932f : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f57931e : invokeV.booleanValue;
    }

    public final void p(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            d.a.s0.c2.a.b().a(new c(this, list));
        }
    }

    public final void q(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            if (d.a.s0.c2.c.i().j(list, false)) {
                t(System.currentTimeMillis());
            }
            this.f57931e = false;
        }
    }

    public final void r(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            if (l.C()) {
                d.a.s0.c2.a.b().a(new e(this, list));
            } else {
                q(list);
            }
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f57932f = z;
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f57931e = true;
            this.f57932f = true;
            this.f57928b.w(new b(this));
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            d.a.s0.c2.a.b().a(new a(this));
        }
    }
}
