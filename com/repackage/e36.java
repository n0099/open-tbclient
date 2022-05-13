package com.repackage;

import android.content.pm.PackageInfo;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.downloadmanager.net.DownloadManagerHttpResponseMessage;
import com.baidu.tieba.downloadmanager.net.DownloadManagerNetModel;
import com.baidu.tieba.downloadmanager.net.DownloadManagerSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class e36 extends c36 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int b;
    public boolean c;
    public final ArrayList<a36> d;
    public final ArrayList<a36> e;
    public final ArrayList<String> f;
    public f36 g;
    public DownloadManagerNetModel h;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e36 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e36 e36Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e36Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e36Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof a36)) {
                a36 a36Var = (a36) customResponsedMessage.getData();
                e36 e36Var = this.a;
                if (e36Var.p(e36Var.d, a36Var)) {
                    return;
                }
                this.a.d.add(0, a36Var);
                e36.h(this.a);
                if (this.a.g != null) {
                    this.a.g.b(this.a.d, this.a.e, 0);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e36(BaseFragment baseFragment, int i) {
        super(baseFragment, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((BaseFragment) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.d = new ArrayList<>();
        this.e = new ArrayList<>();
        this.f = new ArrayList<>();
        DownloadManagerNetModel downloadManagerNetModel = new DownloadManagerNetModel(baseFragment.getPageContext(), new i36(1, i));
        this.h = downloadManagerNetModel;
        downloadManagerNetModel.a0(this);
        this.h.setUniqueId(baseFragment.getUniqueId());
        q(baseFragment);
    }

    public static /* synthetic */ int h(e36 e36Var) {
        int i = e36Var.b;
        e36Var.b = i + 1;
        return i;
    }

    public static /* synthetic */ int i(e36 e36Var) {
        int i = e36Var.b;
        e36Var.b = i - 1;
        return i;
    }

    @Override // com.repackage.c36
    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.c) {
            return;
        }
        o();
    }

    @Override // com.repackage.c36
    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.c) {
            return;
        }
        this.b = 0;
        this.d.clear();
        this.e.clear();
        o();
    }

    @Override // com.repackage.c36
    public void d(f36 f36Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, f36Var) == null) {
            this.g = f36Var;
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void m(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            this.c = false;
            if (mvcSocketResponsedMessage == null) {
                return;
            }
            j36 j36Var = null;
            if (!mvcSocketResponsedMessage.hasError() && (mvcSocketResponsedMessage instanceof DownloadManagerSocketResponseMessage)) {
                j36Var = ((DownloadManagerSocketResponseMessage) mvcSocketResponsedMessage).getData();
            }
            if (j36Var == null || !u(j36Var)) {
                t();
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.c = true;
            new b(this, null).execute(new Integer[0]);
        }
    }

    public final boolean p(ArrayList<a36> arrayList, a36 a36Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, arrayList, a36Var)) == null) {
            Iterator<a36> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().f(a36Var)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void q(BaseFragment baseFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, baseFragment) == null) {
            a aVar = new a(this, 2921627);
            aVar.setTag(baseFragment.getUniqueId());
            MessageManager.getInstance().registerListener(aVar);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void r(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
            this.c = false;
            if (mvcHttpResponsedMessage == null) {
                return;
            }
            j36 j36Var = null;
            if (!mvcHttpResponsedMessage.hasError() && (mvcHttpResponsedMessage instanceof DownloadManagerHttpResponseMessage)) {
                j36Var = (j36) ((DownloadManagerHttpResponseMessage) mvcHttpResponsedMessage).getData();
            }
            if (j36Var == null || !u(j36Var)) {
                t();
            }
        }
    }

    public final void s(List<zz4> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, z) == null) {
            ArrayList arrayList = new ArrayList();
            for (zz4 zz4Var : list) {
                if (zz4Var != null && zz4Var.b != null) {
                    arrayList.add(a36.b(zz4Var));
                }
            }
            this.d.addAll(arrayList);
            if (ListUtils.getCount(this.d) <= 4) {
                this.h.loadData();
                return;
            }
            this.c = false;
            f36 f36Var = this.g;
            if (f36Var != null) {
                f36Var.b(this.d, null, z ? 1 : 0);
            }
        }
    }

    public final void t() {
        f36 f36Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (f36Var = this.g) == null) {
            return;
        }
        f36Var.b(this.d, null, 0);
    }

    public final boolean u(j36 j36Var) {
        InterceptResult invokeL;
        ItemData itemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, j36Var)) == null) {
            if (j36Var == null) {
                return false;
            }
            if (!ListUtils.isEmpty(j36Var.b)) {
                for (a36 a36Var : j36Var.b) {
                    if (a36Var != null && (itemData = a36Var.a) != null && !this.f.contains(itemData.pkgName) && p45.e(a36Var.a.pkgName) == null) {
                        this.e.add(a36Var);
                    }
                }
            }
            f36 f36Var = this.g;
            if (f36Var != null) {
                f36Var.b(this.d, this.e, 0);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Integer, Integer, List<zz4>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ e36 b;

        public b(e36 e36Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e36Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = e36Var;
            this.a = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<zz4> doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                List<zz4> d = b36.e().d();
                ArrayList arrayList = new ArrayList(15);
                if (this.b.b >= d.size()) {
                    return arrayList;
                }
                int i = this.b.b;
                while (i < d.size()) {
                    e36.h(this.b);
                    zz4 zz4Var = d.get(i);
                    if (zz4Var != null && !li.isEmpty(zz4Var.a) && !li.isEmpty(zz4Var.c)) {
                        ItemData d2 = d(zz4Var.c);
                        zz4Var.b = d2;
                        if (d2 != null && d2.apkDetail != null) {
                            PackageInfo e = p45.e(zz4Var.a);
                            if (e != null && e.versionCode >= zz4Var.b.apkDetail.version_code.intValue()) {
                                b36.e().c(zz4Var.a);
                                e36.i(this.b);
                            } else {
                                DownloadData j = p45.j(zz4Var.b);
                                if (p45.c(j) == 6 && !p45.b(j.getId()) && zz4Var.d != 2) {
                                    b36.e().c(zz4Var.a);
                                    e36.i(this.b);
                                } else if (zz4Var.d == 2 && !p05.q().s(zz4Var.a) && p45.d(zz4Var.a, zz4Var.b.appId) == 6) {
                                    b36.e().c(zz4Var.a);
                                    e36.i(this.b);
                                } else {
                                    arrayList.add(zz4Var);
                                    this.b.f.add(zz4Var.a);
                                    if (arrayList.size() >= 15) {
                                        break;
                                    }
                                }
                            }
                        } else {
                            b36.e().c(zz4Var.a);
                            e36.i(this.b);
                        }
                    }
                    i++;
                }
                if (arrayList.size() >= 15 && i < d.size()) {
                    this.a = true;
                } else {
                    this.a = false;
                }
                return arrayList;
            }
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<zz4> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                this.b.s(list, this.a);
            }
        }

        public final ItemData d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                ItemData itemData = new ItemData();
                itemData.parseJson(str);
                return itemData;
            }
            return (ItemData) invokeL.objValue;
        }

        public /* synthetic */ b(e36 e36Var, a aVar) {
            this(e36Var);
        }
    }
}
