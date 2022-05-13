package com.repackage;

import android.content.pm.PackageInfo;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.ListUtils;
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
import java.util.List;
/* loaded from: classes6.dex */
public class g36 extends c36 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final DownloadManagerNetModel b;
    public i36 c;
    public j36 d;
    public List<String> e;
    public f36 f;
    public final List<a36> g;
    public int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g36(BaseFragment baseFragment, int i) {
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
        this.d = new j36();
        this.e = new ArrayList();
        this.g = new ArrayList();
        this.h = 0;
        this.c = new i36(1, i);
        DownloadManagerNetModel downloadManagerNetModel = new DownloadManagerNetModel(baseFragment.getPageContext(), this.c);
        this.b = downloadManagerNetModel;
        downloadManagerNetModel.a0(this);
        this.b.setUniqueId(baseFragment.getUniqueId());
    }

    @Override // com.repackage.c36
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            e();
            this.c.c();
            this.b.loadData();
        }
    }

    @Override // com.repackage.c36
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            e();
            this.d.a.clear();
            this.e.clear();
            this.c.b();
            this.b.loadData();
        }
    }

    @Override // com.repackage.c36
    public void d(f36 f36Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, f36Var) == null) {
            this.f = f36Var;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.g.clear();
            this.h = 0;
        }
    }

    public final void f(int i, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) || i == 0) {
            return;
        }
        this.f.a(i, str);
    }

    public void g(List<a36> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            for (a36 a36Var : list) {
                PackageInfo a = dp6.a(a36Var.a.pkgName);
                if (a != null) {
                    if (a.versionCode < a36Var.a.apkDetail.version_code.intValue()) {
                        List<a36> list2 = this.g;
                        int i = this.h;
                        this.h = i + 1;
                        list2.add(i, a36Var);
                    } else {
                        this.g.add(a36Var);
                    }
                    this.e.add(a36Var.a.pkgName);
                }
            }
            if (ListUtils.getCount(this.g) < 15 && this.d.c.intValue() != 0) {
                this.c.c();
                this.b.loadData();
                return;
            }
            this.d.a.addAll(this.g);
            if (ListUtils.getCount(this.d.a) <= 4) {
                this.f.b(this.d.a, h(), this.d.c.intValue());
                return;
            }
            f36 f36Var = this.f;
            j36 j36Var = this.d;
            f36Var.b(j36Var.a, null, j36Var.c.intValue());
        }
    }

    public List<a36> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (a36 a36Var : this.d.b) {
                if (!this.e.contains(a36Var.a.pkgName)) {
                    arrayList.add(a36Var);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final boolean i(j36 j36Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, j36Var)) == null) {
            if (j36Var == null) {
                return false;
            }
            j36 j36Var2 = this.d;
            j36Var2.c = j36Var.c;
            j36Var2.b = j36Var.b;
            g(j36Var.a);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void m(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) || mvcSocketResponsedMessage == null) {
            return;
        }
        j36 j36Var = null;
        if (!mvcSocketResponsedMessage.hasError() && (mvcSocketResponsedMessage instanceof DownloadManagerSocketResponseMessage)) {
            j36Var = ((DownloadManagerSocketResponseMessage) mvcSocketResponsedMessage).getData();
        }
        if (j36Var == null || !i(j36Var)) {
            f(mvcSocketResponsedMessage.getError(), mvcSocketResponsedMessage.getErrorString());
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void r(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048585, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) || mvcHttpResponsedMessage == null) {
            return;
        }
        j36 j36Var = null;
        if (!mvcHttpResponsedMessage.hasError() && (mvcHttpResponsedMessage instanceof DownloadManagerHttpResponseMessage)) {
            j36Var = (j36) ((DownloadManagerHttpResponseMessage) mvcHttpResponsedMessage).getData();
        }
        if (j36Var == null || !i(j36Var)) {
            f(mvcHttpResponsedMessage.getError(), mvcHttpResponsedMessage.getErrorString());
        }
    }
}
