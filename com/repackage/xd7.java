package com.repackage;

import android.text.TextUtils;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class xd7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b9 a;
    public int b;
    public int c;
    public ListView d;
    public String e;
    public int f;
    public Map<String, Integer> g;
    public View h;
    public boolean i;
    public w68 j;
    public f78 k;
    public boolean l;
    public s68 m;
    public final CustomMessageListener n;
    public pd7 o;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xd7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(xd7 xd7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xd7Var, Integer.valueOf(i)};
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
            this.a = xd7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                this.a.s();
                if (this.a.l && this.a.l) {
                    xd7 xd7Var = this.a;
                    xd7Var.k(xd7Var.k.a(), this.a.k.b(), this.a.k.d(), this.a.k.c());
                }
            }
        }
    }

    public xd7(b9 b9Var, ListView listView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b9Var, listView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.c = 0;
        this.e = null;
        this.f = 0;
        this.g = new HashMap();
        this.i = false;
        this.l = true;
        this.m = new s68();
        this.n = new a(this, 2000994);
        this.o = new pd7(this);
        this.a = b9Var;
        this.b = oi.i(b9Var.getPageActivity());
        this.d = listView;
        BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.k = new f78();
        b9Var.registerListener(this.n);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            pg.a().removeCallbacks(this.m);
            pg.a().removeCallbacks(this.o);
            d();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int i = 0; i < this.d.getChildCount(); i++) {
                View childAt = this.d.getChildAt(i);
                if (childAt.getTag() instanceof w68) {
                    ((w68) childAt.getTag()).stopPlay();
                }
            }
        }
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f : invokeV.intValue;
    }

    public int g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (this.g.containsKey(str)) {
                return this.g.get(str).intValue();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public void h(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view2) == null) || view2 == null || i(view2) || !(view2.getTag() instanceof w68)) {
            return;
        }
        w68 w68Var = (w68) view2.getTag();
        if (!TextUtils.isEmpty(w68Var.getPlayUrl()) && w68Var.getCurrentPosition() > 0) {
            q(w68Var.getPlayUrl(), w68Var.getCurrentPosition());
        }
        w68Var.stopPlay();
    }

    public boolean i(View view2) {
        InterceptResult invokeL;
        int measuredHeight;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view2)) == null) {
            if (view2 == null) {
                return false;
            }
            int[] iArr = new int[2];
            if (view2 == null) {
                return false;
            }
            view2.getLocationOnScreen(iArr);
            return view2 != null && (measuredHeight = iArr[1] + (view2.getMeasuredHeight() / 2)) > this.c && measuredHeight < this.b;
        }
        return invokeL.booleanValue;
    }

    public void j(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) == null) {
            this.k.e(i, i2, z);
            ListView listView = this.d;
            if (listView == null || listView.getChildCount() == 0) {
                return;
            }
            ListView listView2 = this.d;
            ListAdapter wrappedAdapter = listView2 instanceof BdListView ? ((BdListView) listView2).getWrappedAdapter() : listView2.getAdapter();
            if (wrappedAdapter == null || wrappedAdapter.getCount() == 0) {
                return;
            }
            w68 w68Var = this.j;
            if (w68Var != null && !i(w68Var.getVideoContainer())) {
                this.j.stopPlay();
            }
            int count = wrappedAdapter.getCount() + this.d.getHeaderViewsCount() + this.d.getFooterViewsCount();
            int i4 = 0;
            if (i == 0) {
                z2 = true;
            } else {
                int i5 = count - 1;
                z2 = false;
            }
            if (i == 0 || i2 == count - 1) {
                z3 = false;
                for (int i6 = 0; i6 < this.d.getChildCount(); i6++) {
                    View childAt = this.d.getChildAt(z2 ? i6 : (this.d.getChildCount() - 1) - i6);
                    if (childAt.getTag() instanceof w68) {
                        w68 w68Var2 = (w68) childAt.getTag();
                        if (!z3 && i(w68Var2.getVideoContainer())) {
                            r(i3, childAt);
                            z3 = true;
                        } else {
                            if (!TextUtils.isEmpty(w68Var2.getPlayUrl()) && w68Var2.getCurrentPosition() > 0) {
                                q(w68Var2.getPlayUrl(), w68Var2.getCurrentPosition());
                            }
                            u(i3, childAt);
                        }
                    }
                }
            } else {
                z3 = false;
            }
            if (z3) {
                return;
            }
            int i7 = -1;
            int i8 = 0;
            while (true) {
                if (i8 >= this.d.getChildCount()) {
                    break;
                }
                View childAt2 = this.d.getChildAt(i8);
                if (childAt2.getTag() instanceof w68) {
                    w68 w68Var3 = (w68) childAt2.getTag();
                    if (w68Var3.isPlayStarted() && i(w68Var3.getVideoContainer())) {
                        i7 = i8;
                        break;
                    }
                }
                i8++;
            }
            if (i7 >= 0) {
                while (i4 < this.d.getChildCount()) {
                    View childAt3 = this.d.getChildAt(i4);
                    if (i4 == i7) {
                        r(i3, childAt3);
                    } else {
                        if (childAt3.getTag() instanceof w68) {
                            w68 w68Var4 = (w68) childAt3.getTag();
                            if (!TextUtils.isEmpty(w68Var4.getPlayUrl()) && w68Var4.getCurrentPosition() > 0) {
                                q(w68Var4.getPlayUrl(), w68Var4.getCurrentPosition());
                            }
                        }
                        u(i3, childAt3);
                    }
                    i4++;
                }
                return;
            }
            boolean z4 = false;
            while (i4 < this.d.getChildCount()) {
                View childAt4 = this.d.getChildAt(z ? (this.d.getChildCount() - 1) - i4 : i4);
                if (childAt4.getTag() instanceof w68) {
                    w68 w68Var5 = (w68) childAt4.getTag();
                    if (!z4 && i(w68Var5.getVideoContainer())) {
                        r(i3, childAt4);
                        z4 = true;
                    } else {
                        if (!TextUtils.isEmpty(w68Var5.getPlayUrl()) && w68Var5.getCurrentPosition() > 0) {
                            q(w68Var5.getPlayUrl(), w68Var5.getCurrentPosition());
                        }
                        u(i3, childAt4);
                    }
                }
                i4++;
            }
        }
    }

    public void k(int i, int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            pg.a().removeCallbacks(this.o);
            this.o.a(i);
            this.o.c(i2);
            this.o.b(z);
            this.o.d(z2);
            this.k.f(z2);
            pg.a().post(this.o);
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, str) == null) && this.g.containsKey(str)) {
            this.g.put(str, 0);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.l) {
            View view2 = this.h;
            if (view2 != null && (view2.getTag() instanceof w68)) {
                w68 w68Var = (w68) this.h.getTag();
                if (this.i) {
                    w68Var.startPlay();
                }
                if (this.h.getTag() instanceof v68) {
                    ((v68) this.h.getTag()).c();
                }
            }
            this.h = null;
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.l = z;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.e = str;
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.f = i;
        }
    }

    public void q(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, str, i) == null) {
            if (this.g.containsKey(str)) {
                if (this.g.get(str).intValue() == 0) {
                    return;
                }
                this.g.put(str, Integer.valueOf(i));
                return;
            }
            this.g.put(str, Integer.valueOf(i));
        }
    }

    public final void r(int i, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048591, this, i, view2) == null) || view2 == null) {
            return;
        }
        this.h = view2;
        if (i == 1 && (view2.getTag() instanceof w68)) {
            w68 w68Var = (w68) view2.getTag();
            if (!this.l || w68Var.isPlayStarted()) {
                return;
            }
            w68Var.startPlay();
        } else if (i == 2 && (view2.getTag() instanceof v68)) {
            ((v68) view2.getTag()).a();
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            pg.a().removeCallbacks(this.m);
            pg.a().removeCallbacks(this.o);
            for (int i = 0; i < this.d.getChildCount(); i++) {
                View childAt = this.d.getChildAt(i);
                if (childAt.getTag() instanceof w68) {
                    w68 w68Var = (w68) childAt.getTag();
                    if (w68Var.isPlayStarted()) {
                        w68Var.stopPlay();
                        return;
                    }
                }
            }
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            for (int i = 0; i < this.d.getChildCount(); i++) {
                View childAt = this.d.getChildAt(i);
                if (childAt.getTag() instanceof w68) {
                    w68 w68Var = (w68) childAt.getTag();
                    if (w68Var.isPlayStarted()) {
                        p(w68Var.getCurrentPosition());
                        o(w68Var.getPlayUrl());
                        this.h = childAt;
                        this.i = w68Var.isPlaying();
                        w68Var.stopPlay();
                        return;
                    }
                }
            }
        }
    }

    public final void u(int i, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048594, this, i, view2) == null) {
            if (i == 1 && (view2.getTag() instanceof w68)) {
                ((w68) view2.getTag()).stopPlay();
            } else if (i == 2 && (view2.getTag() instanceof v68)) {
                ((v68) view2.getTag()).d();
            }
        }
    }
}
