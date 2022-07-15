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
/* loaded from: classes6.dex */
public class n36 extends l36 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int b;
    public boolean c;
    public final ArrayList<j36> d;
    public final ArrayList<j36> e;
    public final ArrayList<String> f;
    public o36 g;
    public DownloadManagerNetModel h;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n36 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(n36 n36Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n36Var, Integer.valueOf(i)};
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
            this.a = n36Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof j36)) {
                j36 j36Var = (j36) customResponsedMessage.getData();
                n36 n36Var = this.a;
                if (n36Var.p(n36Var.d, j36Var)) {
                    return;
                }
                this.a.d.add(0, j36Var);
                n36.h(this.a);
                if (this.a.g != null) {
                    this.a.g.b(this.a.d, this.a.e, 0);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n36(BaseFragment baseFragment, int i) {
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
        DownloadManagerNetModel downloadManagerNetModel = new DownloadManagerNetModel(baseFragment.getPageContext(), new r36(1, i));
        this.h = downloadManagerNetModel;
        downloadManagerNetModel.c0(this);
        this.h.setUniqueId(baseFragment.getUniqueId());
        q(baseFragment);
    }

    public static /* synthetic */ int h(n36 n36Var) {
        int i = n36Var.b;
        n36Var.b = i + 1;
        return i;
    }

    public static /* synthetic */ int i(n36 n36Var) {
        int i = n36Var.b;
        n36Var.b = i - 1;
        return i;
    }

    @Override // com.repackage.l36
    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.c) {
            return;
        }
        n();
    }

    @Override // com.repackage.l36
    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.c) {
            return;
        }
        this.b = 0;
        this.d.clear();
        this.e.clear();
        n();
    }

    @Override // com.repackage.l36
    public void d(o36 o36Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, o36Var) == null) {
            this.g = o36Var;
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.c = true;
            new b(this, null).execute(new Integer[0]);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void o(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            this.c = false;
            if (mvcSocketResponsedMessage == null) {
                return;
            }
            s36 s36Var = null;
            if (!mvcSocketResponsedMessage.hasError() && (mvcSocketResponsedMessage instanceof DownloadManagerSocketResponseMessage)) {
                s36Var = ((DownloadManagerSocketResponseMessage) mvcSocketResponsedMessage).getData();
            }
            if (s36Var == null || !u(s36Var)) {
                s();
            }
        }
    }

    public final boolean p(ArrayList<j36> arrayList, j36 j36Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, arrayList, j36Var)) == null) {
            Iterator<j36> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().d(j36Var)) {
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

    public final void r(List<i05> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, list, z) == null) {
            ArrayList arrayList = new ArrayList();
            for (i05 i05Var : list) {
                if (i05Var != null && i05Var.b != null) {
                    arrayList.add(j36.b(i05Var));
                }
            }
            this.d.addAll(arrayList);
            if (ListUtils.getCount(this.d) <= 4) {
                this.h.loadData();
                return;
            }
            this.c = false;
            o36 o36Var = this.g;
            if (o36Var != null) {
                o36Var.b(this.d, null, z ? 1 : 0);
            }
        }
    }

    public final void s() {
        o36 o36Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (o36Var = this.g) == null) {
            return;
        }
        o36Var.b(this.d, null, 0);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void t(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
            this.c = false;
            if (mvcHttpResponsedMessage == null) {
                return;
            }
            s36 s36Var = null;
            if (!mvcHttpResponsedMessage.hasError() && (mvcHttpResponsedMessage instanceof DownloadManagerHttpResponseMessage)) {
                s36Var = (s36) ((DownloadManagerHttpResponseMessage) mvcHttpResponsedMessage).getData();
            }
            if (s36Var == null || !u(s36Var)) {
                s();
            }
        }
    }

    public final boolean u(s36 s36Var) {
        InterceptResult invokeL;
        ItemData itemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, s36Var)) == null) {
            if (s36Var == null) {
                return false;
            }
            if (!ListUtils.isEmpty(s36Var.b)) {
                for (j36 j36Var : s36Var.b) {
                    if (j36Var != null && (itemData = j36Var.a) != null && !this.f.contains(itemData.pkgName) && b55.e(j36Var.a.pkgName) == null) {
                        this.e.add(j36Var);
                    }
                }
            }
            o36 o36Var = this.g;
            if (o36Var != null) {
                o36Var.b(this.d, this.e, 0);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<Integer, Integer, List<i05>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ n36 b;

        public b(n36 n36Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n36Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n36Var;
            this.a = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<i05> doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                List<i05> d = k36.e().d();
                ArrayList arrayList = new ArrayList(15);
                if (this.b.b >= d.size()) {
                    return arrayList;
                }
                int i = this.b.b;
                while (i < d.size()) {
                    n36.h(this.b);
                    i05 i05Var = d.get(i);
                    if (i05Var != null && !oi.isEmpty(i05Var.a) && !oi.isEmpty(i05Var.c)) {
                        ItemData d2 = d(i05Var.c);
                        i05Var.b = d2;
                        if (d2 != null && d2.apkDetail != null) {
                            PackageInfo e = b55.e(i05Var.a);
                            if (e != null && e.versionCode >= i05Var.b.apkDetail.version_code.intValue()) {
                                k36.e().c(i05Var.a);
                                n36.i(this.b);
                            } else {
                                DownloadData j = b55.j(i05Var.b);
                                if (b55.c(j) == 6 && !b55.b(j.getId()) && i05Var.d != 2) {
                                    k36.e().c(i05Var.a);
                                    n36.i(this.b);
                                } else if (i05Var.d == 2 && !c15.q().s(i05Var.a) && b55.d(i05Var.a, i05Var.b.appId) == 6) {
                                    k36.e().c(i05Var.a);
                                    n36.i(this.b);
                                } else {
                                    arrayList.add(i05Var);
                                    this.b.f.add(i05Var.a);
                                    if (arrayList.size() >= 15) {
                                        break;
                                    }
                                }
                            }
                        } else {
                            k36.e().c(i05Var.a);
                            n36.i(this.b);
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
        public void onPostExecute(List<i05> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                this.b.r(list, this.a);
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

        public /* synthetic */ b(n36 n36Var, a aVar) {
            this(n36Var);
        }
    }
}
