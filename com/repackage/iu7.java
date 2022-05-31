package com.repackage;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class iu7 {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;
    public static final int b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdTypeListView a;
        public final /* synthetic */ int b;

        public a(BdTypeListView bdTypeListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdTypeListView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdTypeListView;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i = li.i(TbadkCoreApplication.getInst().getContext());
                int[] iArr = new int[2];
                this.a.getLocationOnScreen(iArr);
                this.a.setSelectionFromTop(this.b, ((i - iu7.b) - iArr[1]) / 2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdTypeListView a;
        public final /* synthetic */ int b;

        public b(BdTypeListView bdTypeListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdTypeListView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdTypeListView;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.smoothScrollToPosition(this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdTypeListView a;
        public final /* synthetic */ String b;

        public c(BdTypeListView bdTypeListView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdTypeListView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdTypeListView;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            int a;
            View view2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (a = iu7.a(this.a, this.b)) < 0) {
                return;
            }
            int height = this.a.getHeight();
            int width = this.a.getWidth();
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(width, 1073741824);
            BdTypeListView bdTypeListView = this.a;
            View childAt = bdTypeListView.getChildAt(a - bdTypeListView.getFirstVisiblePosition());
            if ((childAt == null || childAt.getBottom() > height - iu7.b) && (view2 = this.a.getAdapter2().getView(a, null, this.a)) != null) {
                view2.measure(makeMeasureSpec2, makeMeasureSpec);
                this.a.setSelectionFromTop(a, (height - view2.getMeasuredHeight()) - iu7.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755605882, "Lcom/repackage/iu7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755605882, "Lcom/repackage/iu7;");
                return;
            }
        }
        a = li.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds240);
        li.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
        b = li.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds150);
    }

    public static int a(BdTypeListView bdTypeListView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bdTypeListView, str)) == null) {
            if (bdTypeListView != null && !TextUtils.isEmpty(str)) {
                List<jn> data = bdTypeListView.getData();
                int headerViewsCount = bdTypeListView.getHeaderViewsCount();
                if (data != null && data.size() > 0) {
                    int size = data.size();
                    for (int i = 0; i < size; i++) {
                        jn jnVar = data.get(i);
                        if ((jnVar instanceof PostData) && jnVar.getType() == PostData.x0 && str.equals(((PostData) jnVar).I())) {
                            return i + headerViewsCount;
                        }
                    }
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public static int b(BdTypeListView bdTypeListView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bdTypeListView)) == null) {
            if (bdTypeListView == null) {
                return -1;
            }
            List<jn> data = bdTypeListView.getData();
            int headerViewsCount = bdTypeListView.getHeaderViewsCount();
            if (data != null && data.size() > 0) {
                int size = data.size();
                for (int i = 0; i < size; i++) {
                    if (data.get(i) instanceof xp7) {
                        return i + headerViewsCount;
                    }
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static int c(BdTypeListView bdTypeListView, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, bdTypeListView, str, i)) == null) {
            if (bdTypeListView != null && !StringUtils.isNull(str)) {
                List<jn> data = bdTypeListView.getData();
                int headerViewsCount = bdTypeListView.getHeaderViewsCount();
                if (data != null && data.size() > 0) {
                    int size = data.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        jn jnVar = data.get(i2);
                        if ((jnVar instanceof PostData) && str.equals(((PostData) jnVar).I())) {
                            return (i2 + headerViewsCount) - i;
                        }
                    }
                }
            }
            return -1;
        }
        return invokeLLI.intValue;
    }

    public static int d(BdTypeListView bdTypeListView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bdTypeListView)) == null) {
            if (bdTypeListView == null) {
                return -1;
            }
            List<jn> data = bdTypeListView.getData();
            int headerViewsCount = bdTypeListView.getHeaderViewsCount();
            if (data != null && data.size() > 0) {
                int size = data.size();
                for (int i = 0; i < size; i++) {
                    jn jnVar = data.get(i);
                    if ((jnVar instanceof PostData) && jnVar.getType() == PostData.x0) {
                        return i + headerViewsCount;
                    }
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static int e(BdTypeListView bdTypeListView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bdTypeListView)) == null) {
            if (bdTypeListView == null) {
                return -1;
            }
            List<jn> data = bdTypeListView.getData();
            int headerViewsCount = bdTypeListView.getHeaderViewsCount();
            if (data != null && data.size() > 0) {
                int size = data.size();
                for (int i = 0; i < size; i++) {
                    jn jnVar = data.get(i);
                    if ((jnVar instanceof xp7) && ((xp7) jnVar).b == xp7.i) {
                        return i + headerViewsCount;
                    }
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static void f(BdTypeListView bdTypeListView, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65542, null, bdTypeListView, str) == null) || bdTypeListView == null || StringUtils.isNull(str)) {
            return;
        }
        g(bdTypeListView);
        int c2 = c(bdTypeListView, str, 1);
        if (c2 >= 0) {
            bdTypeListView.post(new b(bdTypeListView, c2));
        }
    }

    public static void g(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        int e = e(bdTypeListView);
        if (e < 0) {
            e = b(bdTypeListView);
        }
        if (e >= 0) {
            bdTypeListView.setSelectionFromTop(e, a);
        }
    }

    public static void h(BdTypeListView bdTypeListView, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65544, null, bdTypeListView, str) == null) || bdTypeListView == null) {
            return;
        }
        int e = e(bdTypeListView);
        if (e < 0) {
            e = c(bdTypeListView, str, 0);
        }
        if (e >= 0) {
            bdTypeListView.post(new a(bdTypeListView, e));
        }
    }

    public static void i(int i, BdTypeListView bdTypeListView, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(65545, null, i, bdTypeListView, str) == null) || bdTypeListView == null || TextUtils.isEmpty(str) || bdTypeListView.getAdapter2() == null) {
            return;
        }
        if (12 == i) {
            h(bdTypeListView, str);
            return;
        }
        g(bdTypeListView);
        bdTypeListView.post(new c(bdTypeListView, str));
    }

    public static void j(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.setSelectionFromTop(0, 0);
    }
}
