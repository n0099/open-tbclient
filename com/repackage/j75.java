package com.repackage;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.view.NovelInfoCardView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class j75 {
    public static /* synthetic */ Interceptable $ic;
    public static j75 h;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final int b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755635735, "Lcom/repackage/j75;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755635735, "Lcom/repackage/j75;");
        }
    }

    public j75() {
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
        this.f = true;
        this.g = true;
        this.a = oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds144);
        this.b = oi.i(TbadkCoreApplication.getInst());
    }

    public static j75 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (h == null) {
                synchronized (j75.class) {
                    if (h == null) {
                        h = new j75();
                    }
                }
            }
            return h;
        }
        return (j75) invokeV.objValue;
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

    public void c(String str, String str2, rz4 rz4Var, View view2, NovelInfoCardView novelInfoCardView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, rz4Var, view2, novelInfoCardView) == null) || rz4Var == null || view2 == null || novelInfoCardView == null || novelInfoCardView.getVisibility() != 0) {
            return;
        }
        String valueOf = String.valueOf(rz4Var.h());
        if (b(view2) && view2.getVisibility() == 0) {
            if (this.c) {
                this.c = false;
                m75.b(CommonStatisticKey.KEY_PB_NOVEL_INFO_READ_MORE_BUTTON_SHOW, valueOf, str, str2);
            }
        } else {
            this.c = true;
        }
        if (b(novelInfoCardView)) {
            if (this.d) {
                this.d = false;
                m75.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_CARD_VIEW_SHOW, 4, valueOf, str, str2);
            }
        } else {
            this.d = true;
        }
        if (b(novelInfoCardView.getNovelCoverPage())) {
            if (this.e) {
                this.e = false;
                m75.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_CARD_VIEW_SHOW, 3, valueOf, str, str2);
            }
        } else {
            this.e = true;
        }
        if (rz4Var.i()) {
            if (b(novelInfoCardView.getNovelStateButton())) {
                if (this.g) {
                    this.g = false;
                    m75.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_CARD_VIEW_SHOW, 2, valueOf, str, str2);
                    return;
                }
                return;
            }
            this.g = true;
        } else if (b(novelInfoCardView.getNovelStateButton())) {
            if (this.f) {
                this.f = false;
                m75.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_CARD_VIEW_SHOW, 1, valueOf, str, str2);
            }
        } else {
            this.f = true;
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            h = null;
            this.c = true;
            this.d = true;
            this.e = true;
            this.f = true;
            this.g = true;
        }
    }
}
