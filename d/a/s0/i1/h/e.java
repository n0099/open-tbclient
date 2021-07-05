package d.a.s0.i1.h;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.R;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static e f61631c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f61632a;

    /* renamed from: b  reason: collision with root package name */
    public final DialogInterface.OnCancelListener f61633b;

    /* loaded from: classes9.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f61634e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61634e = eVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f61634e.c();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends BdAsyncTask<Object, d, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final d.a.s0.i1.f.i.b f61635a;

        /* renamed from: b  reason: collision with root package name */
        public final int f61636b;

        /* renamed from: c  reason: collision with root package name */
        public c f61637c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f61638d;

        /* loaded from: classes9.dex */
        public class a implements c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f61639a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f61639a = bVar;
            }

            @Override // d.a.s0.i1.h.e.c
            public void a(int i2, String str, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
                    if (this.f61639a.isCancelled()) {
                        this.f61639a.h(i2, str, i3);
                        return;
                    }
                    d dVar = new d();
                    dVar.f61646a = str;
                    dVar.f61647b = i3;
                    dVar.f61648c = i2;
                    this.f61639a.publishProgress(dVar);
                }
            }

            @Override // d.a.s0.i1.h.e.c
            public void b(List<d> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                    this.f61639a.i(list);
                }
            }
        }

        /* renamed from: d.a.s0.i1.h.e$b$b  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC1506b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f61640e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f61641f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f61642g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ b f61643h;

            public RunnableC1506b(b bVar, int i2, String str, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Integer.valueOf(i2), str, Integer.valueOf(i3)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f61643h = bVar;
                this.f61640e = i2;
                this.f61641f = str;
                this.f61642g = i3;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f61643h.f61635a == null) {
                    return;
                }
                this.f61643h.f61635a.onProgressUpdate(this.f61640e, this.f61641f, this.f61642g);
                this.f61643h.f61635a.onCanceled();
            }
        }

        /* loaded from: classes9.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ List f61644e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f61645f;

            public c(b bVar, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, list};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f61645f = bVar;
                this.f61644e = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f61644e == null || this.f61645f.f61635a == null) {
                    return;
                }
                for (d dVar : this.f61644e) {
                    if (dVar != null) {
                        this.f61645f.f61635a.onProgressUpdate(dVar.f61648c, dVar.f61646a, dVar.f61647b);
                    }
                }
                this.f61645f.f61635a.onCanceled();
                this.f61644e.clear();
            }
        }

        public b(e eVar, int i2, d.a.s0.i1.f.i.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2), bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61638d = eVar;
            this.f61637c = new a(this);
            this.f61636b = i2;
            this.f61635a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public Integer doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr)) == null) {
                if (isCancelled()) {
                    return -1;
                }
                if (objArr != null && objArr.length > 0 && objArr[0] != null) {
                    Object obj = objArr[0];
                    if (obj instanceof ArrayList) {
                        List<ImMessageCenterShowItemData> list = (List) obj;
                        int i2 = this.f61636b;
                        if (i2 == 4) {
                            this.f61638d.d(list, this.f61637c);
                        } else if (i2 == 2) {
                            this.f61638d.f(list, this.f61637c);
                        }
                    } else if (obj instanceof ImMessageCenterShowItemData) {
                        this.f61638d.s(((ImMessageCenterShowItemData) obj).getFriendId(), this.f61636b, this.f61637c);
                    }
                    return 0;
                }
                return -2;
            }
            return (Integer) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public void onProgressUpdate(d... dVarArr) {
            d.a.s0.i1.f.i.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVarArr) == null) {
                super.onProgressUpdate(dVarArr);
                if (dVarArr == null || dVarArr.length <= 0 || dVarArr[0] == null || (bVar = this.f61635a) == null) {
                    return;
                }
                d dVar = dVarArr[0];
                bVar.onProgressUpdate(dVar.f61648c, dVar.f61646a, dVar.f61647b);
            }
        }

        public final void h(int i2, String str, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
                d.a.c.e.m.e.a().post(new RunnableC1506b(this, i2, str, i3));
            }
        }

        public final void i(List<d> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
                d.a.c.e.m.e.a().post(new c(this, list));
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                super.onCancelled();
                d.a.s0.i1.f.i.b bVar = this.f61635a;
                if (bVar != null) {
                    bVar.onCanceled();
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                super.onPreExecute();
                d.a.s0.i1.f.i.b bVar = this.f61635a;
                if (bVar != null) {
                    bVar.onPreExecute();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, num) == null) {
                super.onPostExecute((b) num);
                if (this.f61635a != null) {
                    if (isCancelled()) {
                        this.f61635a.onCanceled();
                    } else {
                        this.f61635a.onPostExecute();
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface c {
        void a(int i2, String str, int i3);

        void b(List<d> list);
    }

    /* loaded from: classes9.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f61646a;

        /* renamed from: b  reason: collision with root package name */
        public int f61647b;

        /* renamed from: c  reason: collision with root package name */
        public int f61648c;

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
                }
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
        this.f61633b = new a(this);
    }

    public static e m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f61631c == null) {
                synchronized (e.class) {
                    if (f61631c == null) {
                        f61631c = new e();
                    }
                }
            }
            return f61631c;
        }
        return (e) invokeV.objValue;
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i2, d.a.s0.i1.f.i.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, imMessageCenterShowItemData, i2, bVar) == null) {
            b bVar2 = new b(this, i2, bVar);
            this.f61632a = bVar2;
            bVar2.setParallel(TiebaIMConfig.getParallel());
            this.f61632a.setPriority(3);
            this.f61632a.execute(imMessageCenterShowItemData);
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, int i2, d.a.s0.i1.f.i.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, i2, bVar) == null) {
            b bVar2 = new b(this, i2, bVar);
            this.f61632a = bVar2;
            bVar2.setParallel(TiebaIMConfig.getParallel());
            this.f61632a.setPriority(3);
            this.f61632a.execute(list);
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b bVar = this.f61632a;
            if (bVar != null && bVar.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
                this.f61632a.cancel(true);
            }
            this.f61632a = null;
            return true;
        }
        return invokeV.booleanValue;
    }

    public void d(List<ImMessageCenterShowItemData> list, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, list, cVar) == null) {
            try {
                try {
                    h.e().i();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                int size = list.size();
                int i2 = 0;
                for (int i3 = size - 1; i3 >= 0; i3--) {
                    if (o()) {
                        break;
                    }
                    ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) ListUtils.getItem(list, i3);
                    if (imMessageCenterShowItemData != null && !TextUtils.isEmpty(imMessageCenterShowItemData.getFriendId())) {
                        String friendId = imMessageCenterShowItemData.getFriendId();
                        k(friendId, 4);
                        l.t().e(friendId);
                        i2++;
                        if (cVar != null) {
                            cVar.a((i2 * 100) / size, friendId, 4);
                        }
                    }
                }
            } finally {
                h.e().c();
            }
        }
    }

    public void e(c cVar) {
        List<String> v;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            try {
                try {
                    h.e().i();
                    l.t();
                    v = l.v();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (!ListUtils.isEmpty(v)) {
                    int size = v.size();
                    int i2 = 0;
                    for (String str : v) {
                        if (o()) {
                            break;
                        }
                        k(str, 4);
                        l.t().e(str);
                        i2++;
                        if (cVar != null) {
                            cVar.a((i2 * 100) / size, str, 4);
                        }
                    }
                    if (!o()) {
                        k(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8);
                    }
                }
            } finally {
                h.e().c();
            }
        }
    }

    public void f(List<ImMessageCenterShowItemData> list, c cVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, list, cVar) == null) {
            try {
                try {
                    h.e().i();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (!ListUtils.isEmpty(list)) {
                    ArrayList arrayList = new ArrayList(list.size());
                    for (int size = list.size() - 1; size >= 0; size--) {
                        ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) ListUtils.getItem(list, size);
                        if (imMessageCenterShowItemData != null && !TextUtils.isEmpty(imMessageCenterShowItemData.getFriendId())) {
                            arrayList.add(imMessageCenterShowItemData.getFriendId());
                        }
                    }
                    int size2 = arrayList.size();
                    int i4 = size2 / 100;
                    if (size2 % 100 != 0) {
                        i4++;
                    }
                    int i5 = 0;
                    while (i5 < i4) {
                        if (!o()) {
                            if (i5 == i4 - 1) {
                                i2 = 100 * i5;
                                i3 = size2;
                            } else {
                                i2 = 100 * i5;
                                i3 = i2 + 100;
                            }
                            i5++;
                            l(ListUtils.subList(arrayList, i2, i3), cVar, (i5 * 100) / i4);
                        }
                    }
                }
            } finally {
                h.e().c();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0053, code lost:
        if (o() == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
        k(com.baidu.tbadk.core.util.TbEnum.CustomGroupId.STRANGE_MERGE, -7);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(c cVar) {
        List<String> e2;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            try {
                try {
                    h.e().i();
                    e2 = n.e();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                if (!ListUtils.isEmpty(e2)) {
                    int size = e2.size();
                    int i4 = size / 100;
                    if (size % 100 != 0) {
                        i4++;
                    }
                    int i5 = 0;
                    while (true) {
                        if (i5 >= i4) {
                            break;
                        } else if (o()) {
                            break;
                        } else {
                            if (i5 == i4 - 1) {
                                i2 = 100 * i5;
                                i3 = size;
                            } else {
                                i2 = 100 * i5;
                                i3 = i2 + 100;
                            }
                            i5++;
                            l(ListUtils.subList(e2, i2, i3), cVar, (i5 * 100) / i4);
                        }
                    }
                }
            } finally {
                h.e().c();
            }
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            try {
                try {
                    h.e().i();
                    ImMessageCenterPojo i2 = d.a.s0.i1.k.b.o().i(str, 1);
                    i2.setIs_hidden(1);
                    i2.setUnread_count(0);
                    j.f().k(i2, 2);
                    d.a.s0.i1.h.c.h().d(str);
                } catch (Exception e2) {
                    BdLog.detailException(e2);
                }
            } finally {
                h.e().c();
            }
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            try {
                try {
                    h.e().i();
                    k(str, 4);
                    l.t().e(str);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } finally {
                h.e().c();
            }
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            try {
                try {
                    h.e().i();
                    k(str, 2);
                    m.t().e(str);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } finally {
                h.e().c();
            }
        }
    }

    public void k(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, str, i2) == null) {
            j.f().c(str, i2);
        }
    }

    public final void l(List<String> list, c cVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048587, this, list, cVar, i2) == null) || list == null || cVar == null) {
            return;
        }
        n.b(t(list));
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            m.t().d(str);
            if (o()) {
                d dVar = new d();
                dVar.f61646a = str;
                dVar.f61647b = 2;
                dVar.f61648c = i2;
                arrayList.add(dVar);
            } else {
                cVar.a(i2, str, 2);
            }
        }
        if (arrayList.isEmpty() || cVar == null) {
            return;
        }
        cVar.b(arrayList);
    }

    public void n(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, str, i2) == null) {
            try {
                try {
                    h.e().i();
                    ImMessageCenterPojo i3 = d.a.s0.i1.k.b.o().i(str, i2);
                    i3.setIs_hidden(1);
                    i3.setUnread_count(0);
                    j.f().k(i3, 2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } finally {
                h.e().c();
            }
        }
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            b bVar = this.f61632a;
            if (bVar != null) {
                return bVar != null && bVar.isCancelled();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public d.a.r0.r.s.c p(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, context)) == null) {
            d.a.r0.r.s.c cVar = new d.a.r0.r.s.c(context);
            cVar.a(context.getString(R.string.delete_msg_loading));
            cVar.setCanceledOnTouchOutside(false);
            cVar.setCancelable(true);
            cVar.setOnCancelListener(this.f61633b);
            return cVar;
        }
        return (d.a.r0.r.s.c) invokeL.objValue;
    }

    public void q(String str, int i2) {
        ImMessageCenterPojo i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048591, this, str, i2) == null) || (i3 = d.a.s0.i1.k.b.o().i(str, i2)) == null) {
            return;
        }
        if (i2 == 2) {
            d.a.r0.s.d.b.g0().s(str);
        } else if (i2 == 4) {
            d.a.r0.s.d.b.g0().r(d.a.c.e.m.b.d(str, 0));
        } else if (i2 == -3) {
            d.a.r0.s.d.b.g0().f(2);
        } else if (i2 == -4) {
            d.a.r0.s.d.b.g0().f(1);
        } else {
            d.a.r0.s.d.b.g0().d(str);
        }
        i3.setIs_hidden(1);
        i3.setUnread_count(0);
        if (i2 == 2 || i2 == 4 || i2 == -7 || i2 == -8) {
            d.a.s0.i1.k.b.o().G(str, i2);
        } else if (i2 == 1) {
            d.a.s0.i1.k.b.o().B(str, i2, false);
        } else {
            d.a.s0.i1.k.b.o().B(str, i2, false);
        }
    }

    public void r(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, str, i2) == null) {
            d.a.s0.i1.k.b.o().H(str, i2);
        }
    }

    public void s(String str, int i2, c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048593, this, str, i2, cVar) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (1 == i2) {
            h(str);
        } else if (-7 == i2) {
            g(cVar);
        } else if (-8 == i2) {
            e(cVar);
        } else if (2 == i2) {
            j(str);
        } else if (4 == i2) {
            i(str);
        } else if (-3 == i2) {
            n(str, i2);
        } else if (-4 == i2) {
            n(str, i2);
        } else {
            n(str, i2);
        }
    }

    public final String t(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, list)) == null) {
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (String str : list) {
                if (z) {
                    z = false;
                } else {
                    sb.append(",");
                }
                sb.append(str);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}
