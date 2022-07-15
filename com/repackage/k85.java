package com.repackage;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.novel.NovelMemberCardView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class k85 {
    public static /* synthetic */ Interceptable $ic;
    public static k85 f;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final int b;
    public boolean c;
    public boolean d;
    public boolean e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755604983, "Lcom/repackage/k85;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755604983, "Lcom/repackage/k85;");
        }
    }

    public k85() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = true;
        this.d = true;
        this.e = true;
        this.a = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds144);
        this.b = pi.i(TbadkCoreApplication.getInst());
    }

    public static k85 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f == null) {
                synchronized (k85.class) {
                    if (f == null) {
                        f = new k85();
                    }
                }
            }
            return f;
        }
        return (k85) invokeV.objValue;
    }

    public boolean b(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
            if (view2 == null) {
                return false;
            }
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            int i = iArr[1];
            return i > 0 && i < this.b - this.a;
        }
        return invokeL.booleanValue;
    }

    public void c(String str, String str2, q05 q05Var, NovelMemberCardView novelMemberCardView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, q05Var, novelMemberCardView) == null) || q05Var == null || novelMemberCardView == null || novelMemberCardView.getVisibility() != 0) {
            return;
        }
        String valueOf = String.valueOf(q05Var.f());
        int i = q05Var.h() ? 2 : 1;
        if (b(novelMemberCardView.getNovelReadMoreButton()) && !q05Var.h()) {
            if (this.c) {
                this.c = false;
                m85.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_READ_MORE_BUTTON_SHOW, i, valueOf, str, str2);
            }
        } else {
            this.c = true;
        }
        if (b(novelMemberCardView.getNovelPaidButton()) && q05Var.h()) {
            if (this.d) {
                this.d = false;
                m85.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_READ_MORE_BUTTON_SHOW, i, valueOf, str, str2);
            }
        } else {
            this.d = true;
        }
        if (b(novelMemberCardView.getNovelCoverPage()) && !q05Var.h()) {
            if (this.e) {
                this.e = false;
                m85.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_CARD_VIEW_SHOW, 4, valueOf, str, str2);
                return;
            }
            return;
        }
        this.e = true;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            f = null;
            this.c = true;
            this.d = true;
            this.e = true;
        }
    }
}
