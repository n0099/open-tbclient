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
public class p16 extends n16 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int b;
    public boolean c;
    public final ArrayList<l16> d;
    public final ArrayList<l16> e;
    public final ArrayList<String> f;
    public q16 g;
    public DownloadManagerNetModel h;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p16 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(p16 p16Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p16Var, Integer.valueOf(i)};
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
            this.a = p16Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof l16)) {
                l16 l16Var = (l16) customResponsedMessage.getData();
                p16 p16Var = this.a;
                if (p16Var.p(p16Var.d, l16Var)) {
                    return;
                }
                this.a.d.add(0, l16Var);
                p16.h(this.a);
                if (this.a.g != null) {
                    this.a.g.b(this.a.d, this.a.e, 0);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p16(BaseFragment baseFragment, int i) {
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
        DownloadManagerNetModel downloadManagerNetModel = new DownloadManagerNetModel(baseFragment.getPageContext(), new t16(1, i));
        this.h = downloadManagerNetModel;
        downloadManagerNetModel.a0(this);
        this.h.setUniqueId(baseFragment.getUniqueId());
        q(baseFragment);
    }

    public static /* synthetic */ int h(p16 p16Var) {
        int i = p16Var.b;
        p16Var.b = i + 1;
        return i;
    }

    public static /* synthetic */ int i(p16 p16Var) {
        int i = p16Var.b;
        p16Var.b = i - 1;
        return i;
    }

    @Override // com.repackage.n16
    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.c) {
            return;
        }
        o();
    }

    @Override // com.repackage.n16
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

    @Override // com.repackage.n16
    public void d(q16 q16Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, q16Var) == null) {
            this.g = q16Var;
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
            u16 u16Var = null;
            if (!mvcSocketResponsedMessage.hasError() && (mvcSocketResponsedMessage instanceof DownloadManagerSocketResponseMessage)) {
                u16Var = ((DownloadManagerSocketResponseMessage) mvcSocketResponsedMessage).getData();
            }
            if (u16Var == null || !u(u16Var)) {
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

    public final boolean p(ArrayList<l16> arrayList, l16 l16Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, arrayList, l16Var)) == null) {
            Iterator<l16> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().f(l16Var)) {
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
            u16 u16Var = null;
            if (!mvcHttpResponsedMessage.hasError() && (mvcHttpResponsedMessage instanceof DownloadManagerHttpResponseMessage)) {
                u16Var = (u16) ((DownloadManagerHttpResponseMessage) mvcHttpResponsedMessage).getData();
            }
            if (u16Var == null || !u(u16Var)) {
                t();
            }
        }
    }

    public final void s(List<vy4> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, z) == null) {
            ArrayList arrayList = new ArrayList();
            for (vy4 vy4Var : list) {
                if (vy4Var != null && vy4Var.b != null) {
                    arrayList.add(l16.b(vy4Var));
                }
            }
            this.d.addAll(arrayList);
            if (ListUtils.getCount(this.d) <= 4) {
                this.h.loadData();
                return;
            }
            this.c = false;
            q16 q16Var = this.g;
            if (q16Var != null) {
                q16Var.b(this.d, null, z ? 1 : 0);
            }
        }
    }

    public final void t() {
        q16 q16Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (q16Var = this.g) == null) {
            return;
        }
        q16Var.b(this.d, null, 0);
    }

    public final boolean u(u16 u16Var) {
        InterceptResult invokeL;
        ItemData itemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, u16Var)) == null) {
            if (u16Var == null) {
                return false;
            }
            if (!ListUtils.isEmpty(u16Var.b)) {
                for (l16 l16Var : u16Var.b) {
                    if (l16Var != null && (itemData = l16Var.a) != null && !this.f.contains(itemData.pkgName) && k35.e(l16Var.a.pkgName) == null) {
                        this.e.add(l16Var);
                    }
                }
            }
            q16 q16Var = this.g;
            if (q16Var != null) {
                q16Var.b(this.d, this.e, 0);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<Integer, Integer, List<vy4>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ p16 b;

        public b(p16 p16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p16Var;
            this.a = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<vy4> doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                List<vy4> d = m16.e().d();
                ArrayList arrayList = new ArrayList(15);
                if (this.b.b >= d.size()) {
                    return arrayList;
                }
                int i = this.b.b;
                while (i < d.size()) {
                    p16.h(this.b);
                    vy4 vy4Var = d.get(i);
                    if (vy4Var != null && !ki.isEmpty(vy4Var.a) && !ki.isEmpty(vy4Var.c)) {
                        ItemData d2 = d(vy4Var.c);
                        vy4Var.b = d2;
                        if (d2 != null && d2.apkDetail != null) {
                            PackageInfo e = k35.e(vy4Var.a);
                            if (e != null && e.versionCode >= vy4Var.b.apkDetail.version_code.intValue()) {
                                m16.e().c(vy4Var.a);
                                p16.i(this.b);
                            } else {
                                DownloadData j = k35.j(vy4Var.b);
                                if (k35.c(j) == 6 && !k35.b(j.getId()) && vy4Var.d != 2) {
                                    m16.e().c(vy4Var.a);
                                    p16.i(this.b);
                                } else if (vy4Var.d == 2 && !lz4.q().s(vy4Var.a) && k35.d(vy4Var.a, vy4Var.b.appId) == 6) {
                                    m16.e().c(vy4Var.a);
                                    p16.i(this.b);
                                } else {
                                    arrayList.add(vy4Var);
                                    this.b.f.add(vy4Var.a);
                                    if (arrayList.size() >= 15) {
                                        break;
                                    }
                                }
                            }
                        } else {
                            m16.e().c(vy4Var.a);
                            p16.i(this.b);
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
        public void onPostExecute(List<vy4> list) {
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

        public /* synthetic */ b(p16 p16Var, a aVar) {
            this(p16Var);
        }
    }
}
