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
/* loaded from: classes6.dex */
public class kd6 implements nd6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext a;
    public final Context b;
    public ForumSquareModel c;
    public ld6 d;
    public md6 e;
    public String f;
    public CustomMessageListener g;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kd6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(kd6 kd6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kd6Var, Integer.valueOf(i)};
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
            this.a = kd6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                kd6 kd6Var = this.a;
                if (kd6Var.d == null || kd6Var.c == null) {
                    return;
                }
                this.a.f = "推荐";
                this.a.c.clearData();
                this.a.m();
            }
        }
    }

    public kd6(Context context, TbPageContext tbPageContext) {
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
        this.d = new ld6(context, this.a);
        this.a.registerListener(this.g);
    }

    public final void c(String str, List<on> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) || this.d == null || this.c == null) {
            return;
        }
        if (ListUtils.isEmpty(list)) {
            this.d.g();
        } else if (ListUtils.getCount(list) < 10) {
            this.d.o();
        } else {
            this.d.F(this.c.P(str));
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d.c();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.d.b();
        }
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f : (String) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            String f = f();
            ForumSquareModel forumSquareModel = this.c;
            if (forumSquareModel == null || this.d == null) {
                return;
            }
            boolean Q = forumSquareModel.Q();
            boolean F = this.d.F(this.c.P(f));
            if (Q || !F) {
                return;
            }
            this.c.R(f);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ld6 ld6Var = this.d;
            if (ld6Var != null) {
                ld6Var.G();
            }
            ForumSquareModel forumSquareModel = this.c;
            if (forumSquareModel != null) {
                forumSquareModel.R(f());
            }
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            l(this.f);
            this.f = str;
            ForumSquareModel forumSquareModel = this.c;
            if (forumSquareModel == null || this.d == null) {
                return;
            }
            rd6 O = forumSquareModel.O(str);
            if (O != null && (!O.d || !ListUtils.isEmpty(O.a()))) {
                this.d.K();
                c(str, O.a());
                this.d.t(O.a());
                this.d.r(O.f, O.g);
                return;
            }
            this.d.E();
            c(str, null);
            this.c.R(str);
            this.d.r(0, 0);
        }
    }

    public void j(String str) {
        ForumSquareModel forumSquareModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || (forumSquareModel = this.c) == null || this.d == null || !forumSquareModel.N(str)) {
            return;
        }
        this.d.C(str);
        i(str);
    }

    public void k(Intent intent) {
        Uri uri;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, intent) == null) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(ForumSquareActivityConfig.FORUM_CLASS_NAME);
        this.f = stringExtra;
        if (TextUtils.isEmpty(stringExtra) && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
            this.f = uri.getQueryParameter("tab_name");
        }
        this.d.D(intent.getIntExtra(ForumSquareActivityConfig.SHOW_CREATE_BAR, 0) == 0);
    }

    public void l(String str) {
        rd6 O;
        Pair<Integer, Integer> d;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || this.d == null || this.c == null || TextUtils.isEmpty(str) || (O = this.c.O(str)) == null || (d = this.d.d()) == null) {
            return;
        }
        O.f = ((Integer) d.first).intValue();
        O.g = ((Integer) d.second).intValue();
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            md6 md6Var = new md6(this.b, this, this.d);
            this.e = md6Var;
            md6Var.e();
            n();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.d.G();
            this.c.R(this.f);
        }
    }

    @Override // com.repackage.nd6
    public void onError(String str, ErrorData errorData) {
        ld6 ld6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, str, errorData) == null) || (ld6Var = this.d) == null || this.c == null) {
            return;
        }
        ld6Var.K();
        rd6 O = this.c.O(str);
        if (O != null && (!O.d || !ListUtils.isEmpty(O.a()))) {
            this.d.t(O.a());
            c(str, O.a());
            return;
        }
        this.d.g();
        this.d.v();
    }

    @Override // com.repackage.nd6
    public void onNoData(ErrorData errorData) {
        ld6 ld6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, errorData) == null) || (ld6Var = this.d) == null) {
            return;
        }
        ld6Var.J();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
        if (r5.equals(r1) == false) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
    @Override // com.repackage.nd6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSucc(String str, List<String> list, List<on> list2) {
        boolean isEmpty;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048590, this, str, list, list2) == null) || this.c == null || this.d == null) {
            return;
        }
        boolean z = false;
        if (TextUtils.isEmpty(str) || str.equals(this.f)) {
            String f = this.d.f();
            if (!TextUtils.isEmpty(str)) {
            }
            isEmpty = TextUtils.isEmpty(this.f);
            this.f = str;
            if (isEmpty) {
                this.d.G();
                this.c.R(this.f);
            }
            this.d.K();
            this.d.s(str, list, z);
            this.d.u(list2, this.c.U(list2, 300));
            c(str, list2);
        }
        z = true;
        isEmpty = TextUtils.isEmpty(this.f);
        this.f = str;
        if (isEmpty) {
        }
        this.d.K();
        this.d.s(str, list, z);
        this.d.u(list2, this.c.U(list2, 300));
        c(str, list2);
    }
}
