package com.repackage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.forumSquare.model.ForumSquareModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class ac6 implements dc6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext a;
    public final Context b;
    public ForumSquareModel c;
    public bc6 d;
    public cc6 e;
    public String f;
    public CustomMessageListener g;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ac6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ac6 ac6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ac6Var, Integer.valueOf(i)};
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
            this.a = ac6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                ac6 ac6Var = this.a;
                if (ac6Var.d == null || ac6Var.c == null) {
                    return;
                }
                this.a.f = "推荐";
                this.a.c.clearData();
                this.a.p();
            }
        }
    }

    public ac6(Context context, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = "推荐";
        this.g = new a(this, 2921589);
        this.a = tbPageContext;
        this.b = context;
        this.c = new ForumSquareModel(context, this);
        this.d = new bc6(context, this.a);
        this.a.registerListener(this.g);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
        if (r5.equals(r1) == false) goto L11;
     */
    @Override // com.repackage.dc6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, List<String> list, List<uo> list2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, str, list, list2) == null) || this.c == null || this.d == null) {
            return;
        }
        boolean z = false;
        if (TextUtils.isEmpty(str) || str.equals(this.f)) {
            String f = this.d.f();
            if (!TextUtils.isEmpty(str)) {
            }
            this.f = str;
            this.d.K();
            this.d.s(str, list, z);
            this.d.u(list2, this.c.R(list2, 300));
            f(str, list2);
        }
        z = true;
        this.f = str;
        this.d.K();
        this.d.s(str, list, z);
        this.d.u(list2, this.c.R(list2, 300));
        f(str, list2);
    }

    @Override // com.repackage.dc6
    public void b(ErrorData errorData) {
        bc6 bc6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, errorData) == null) || (bc6Var = this.d) == null) {
            return;
        }
        bc6Var.J();
    }

    @Override // com.repackage.dc6
    public void c(String str, ErrorData errorData) {
        bc6 bc6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, errorData) == null) || (bc6Var = this.d) == null || this.c == null) {
            return;
        }
        bc6Var.K();
        hc6 L = this.c.L(str);
        if (L != null && (!L.d || !ListUtils.isEmpty(L.a()))) {
            this.d.t(L.a());
            f(str, L.a());
            return;
        }
        this.d.g();
        this.d.v();
    }

    public final void f(String str, List<uo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, list) == null) || this.d == null || this.c == null) {
            return;
        }
        if (ListUtils.isEmpty(list)) {
            this.d.g();
        } else if (ListUtils.getCount(list) < 10) {
            this.d.o();
        } else {
            this.d.F(this.c.M(str));
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.d.c();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.d.b();
        }
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f : (String) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            String i = i();
            ForumSquareModel forumSquareModel = this.c;
            if (forumSquareModel == null || this.d == null) {
                return;
            }
            boolean N = forumSquareModel.N();
            boolean F = this.d.F(this.c.M(i));
            if (N || !F) {
                return;
            }
            this.c.O(i);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            bc6 bc6Var = this.d;
            if (bc6Var != null) {
                bc6Var.G();
            }
            ForumSquareModel forumSquareModel = this.c;
            if (forumSquareModel != null) {
                forumSquareModel.O(i());
            }
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            o(this.f);
            this.f = str;
            ForumSquareModel forumSquareModel = this.c;
            if (forumSquareModel == null || this.d == null) {
                return;
            }
            hc6 L = forumSquareModel.L(str);
            if (L != null && (!L.d || !ListUtils.isEmpty(L.a()))) {
                this.d.K();
                f(str, L.a());
                this.d.t(L.a());
                this.d.r(L.f, L.g);
                return;
            }
            this.d.E();
            f(str, null);
            this.c.O(str);
            this.d.r(0, 0);
        }
    }

    public void m(String str) {
        ForumSquareModel forumSquareModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || (forumSquareModel = this.c) == null || this.d == null || !forumSquareModel.K(str)) {
            return;
        }
        this.d.C(str);
        l(str);
    }

    public void n(Intent intent) {
        Uri uri;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, intent) == null) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(ForumSquareActivityConfig.FORUM_CLASS_NAME);
        this.f = stringExtra;
        if (TextUtils.isEmpty(stringExtra) && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
            this.f = uri.getQueryParameter("tab_name");
        }
        this.d.D(intent.getIntExtra(ForumSquareActivityConfig.SHOW_CREATE_BAR, 0) == 0);
    }

    public void o(String str) {
        hc6 L;
        Pair<Integer, Integer> d;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || this.d == null || this.c == null || TextUtils.isEmpty(str) || (L = this.c.L(str)) == null || (d = this.d.d()) == null) {
            return;
        }
        L.f = ((Integer) d.first).intValue();
        L.g = ((Integer) d.second).intValue();
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            cc6 cc6Var = new cc6(this.b, this, this.d);
            this.e = cc6Var;
            cc6Var.e();
            q();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.d.G();
            this.c.O(this.f);
        }
    }
}
