package com.repackage;

import android.graphics.Rect;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class c78 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public b9 b;
    public int c;
    public int d;
    public to e;
    public View f;
    public boolean g;
    public w68 h;
    public f78 i;
    public boolean j;
    public float k;
    public boolean l;
    public CustomMessageListener m;
    public CustomMessageListener n;
    public s68 o;
    public final CustomMessageListener p;
    public final CustomMessageListener q;
    public t68 r;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c78 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c78 c78Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c78Var, Integer.valueOf(i)};
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
            this.a = c78Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                return;
            }
            ng.a().postDelayed(this.a.r, 500L);
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c78 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c78 c78Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c78Var, Integer.valueOf(i)};
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
            this.a = c78Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            ng.a().postDelayed(this.a.r, 500L);
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c78 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(c78 c78Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c78Var, Integer.valueOf(i)};
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
            this.a = c78Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                this.a.x();
                if (this.a.l && this.a.l) {
                    c78 c78Var = this.a;
                    c78Var.n(c78Var.i.a(), this.a.i.b(), this.a.i.d(), this.a.i.c());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c78 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(c78 c78Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c78Var, Integer.valueOf(i)};
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
            this.a = c78Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (li.isEmpty(str)) {
                    return;
                }
                ng.a().removeCallbacks(this.a.o);
                ng.a().removeCallbacks(this.a.r);
                if (this.a.f != null && (this.a.f.getTag() instanceof w68)) {
                    if (str.equals(((w68) this.a.f.getTag()).getPlayUrl())) {
                        return;
                    }
                    ((w68) this.a.f.getTag()).stopPlay();
                }
                for (int i = 0; i < this.a.e.getListView().getChildCount(); i++) {
                    View childAt = this.a.e.getListView().getChildAt(i);
                    if ((childAt.getTag() instanceof w68) && str.equals(((w68) childAt.getTag()).getPlayUrl())) {
                        this.a.f = childAt;
                        return;
                    }
                }
            }
        }
    }

    public c78(b9 b9Var, to toVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b9Var, toVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.c = 0;
        this.d = 0;
        this.g = false;
        this.j = true;
        this.k = 0.0f;
        this.l = true;
        this.m = new a(this, 2921637);
        this.n = new b(this, 2921636);
        this.o = new s68();
        this.p = new c(this, 2000994);
        this.q = new d(this, 2921387);
        this.r = new t68(this);
        this.b = b9Var;
        this.c = mi.i(b9Var.getPageActivity());
        this.e = toVar;
        BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.i = new f78();
        b9Var.registerListener(this.p);
        b9Var.registerListener(this.n);
        b9Var.registerListener(this.m);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ng.a().removeCallbacks(this.o);
            ng.a().removeCallbacks(this.r);
            i();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int i = 0; i < this.e.getListView().getChildCount(); i++) {
                View childAt = this.e.getListView().getChildAt(i);
                if (childAt.getTag() instanceof w68) {
                    ((w68) childAt.getTag()).stopPlay();
                }
            }
        }
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f : (View) invokeV.objValue;
    }

    public void k(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view2) == null) || view2 == null || l(view2) || !(view2.getTag() instanceof w68)) {
            return;
        }
        ((w68) view2.getTag()).stopPlay();
    }

    public boolean l(View view2) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) {
            if (view2 == null) {
                return false;
            }
            Rect rect = new Rect();
            view2.getGlobalVisibleRect(rect);
            int i2 = this.a;
            if (i2 == 1) {
                int i3 = mi.i(this.b.getPageActivity()) / 2;
                int i4 = rect.top;
                return i4 >= 0 && i4 <= i3 && rect.bottom - i4 >= view2.getMeasuredHeight();
            } else if (i2 == 2) {
                int j = mi.j(this.b.getPageActivity(), true);
                float measuredHeight = (view2.getMeasuredHeight() * 2.0f) / 3.0f;
                float statusBarHeight = UtilHelper.getStatusBarHeight() + measuredHeight + mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds104);
                int mainTabBottomBarHeight = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
                if (this.j) {
                    this.k = measuredHeight + mainTabBottomBarHeight;
                } else {
                    this.k = measuredHeight;
                }
                return ((float) rect.top) <= ((float) j) - this.k && ((float) rect.bottom) >= statusBarHeight;
            } else {
                int i5 = rect.top;
                return i5 >= 0 && (i = rect.bottom) <= this.c - this.d && i - i5 >= view2.getMeasuredHeight();
            }
        }
        return invokeL.booleanValue;
    }

    public void m(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) == null) {
            this.i.e(i, i2, z);
            to toVar = this.e;
            if (toVar == null || toVar.getListView().getChildCount() == 0 || this.e.getContentViewsCount() == 0) {
                return;
            }
            w68 w68Var = this.h;
            if (w68Var != null && !l(w68Var.getVideoContainer())) {
                this.h.stopPlay();
            }
            View view3 = this.f;
            int i4 = 0;
            if (view3 != null && (view3.getTag() instanceof w68) && this.g) {
                if (l(((w68) this.f.getTag()).getVideoContainer())) {
                    w(i3, this.f);
                    this.g = false;
                    return;
                }
                this.f = null;
            }
            int contentViewsCount = this.e.getContentViewsCount() + this.e.getHeaderViewsCount() + this.e.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                int i5 = contentViewsCount - 1;
                z2 = false;
            }
            int childCount = this.e.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                z3 = false;
                for (int i6 = 0; i6 < childCount; i6++) {
                    View childAt = this.e.getListView().getChildAt(z2 ? i6 : (childCount - 1) - i6);
                    if (childAt.getTag() instanceof w68) {
                        w68 w68Var2 = (w68) childAt.getTag();
                        if (!z3 && l(w68Var2.getVideoContainer())) {
                            w(i3, childAt);
                            z3 = true;
                        } else {
                            z(i3, childAt);
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
                if (i8 >= childCount) {
                    break;
                }
                View childAt2 = this.e.getListView().getChildAt(i8);
                if (childAt2.getTag() instanceof w68) {
                    w68 w68Var3 = (w68) childAt2.getTag();
                    if (w68Var3.isPlayStarted() && l(w68Var3.getVideoContainer())) {
                        i7 = i8;
                        break;
                    }
                }
                i8++;
            }
            if (i7 >= 0) {
                while (i4 < childCount) {
                    View childAt3 = this.e.getListView().getChildAt(i4);
                    if (i4 != i7) {
                        z(i3, childAt3);
                    } else {
                        w(i3, childAt3);
                    }
                    i4++;
                }
                return;
            }
            boolean z4 = false;
            while (i4 < childCount) {
                View childAt4 = this.e.getListView().getChildAt(z ? (childCount - 1) - i4 : i4);
                if (childAt4.getTag() instanceof w68) {
                    w68 w68Var4 = (w68) childAt4.getTag();
                    if (!z4 && (w68Var4.isFullScreen() || l(w68Var4.getVideoContainer()))) {
                        w(i3, childAt4);
                        z4 = true;
                    } else {
                        z(i3, childAt4);
                    }
                }
                i4++;
            }
            if (z4 || (view2 = this.f) == null || !(view2.getTag() instanceof w68)) {
                return;
            }
            ((w68) this.f.getTag()).stopPlay();
        }
    }

    public void n(int i, int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            ng.a().removeCallbacks(this.r);
            this.r.a(i);
            this.r.c(i2);
            this.r.b(z);
            this.r.d(z2);
            this.i.f(z2);
            ng.a().postDelayed(this.r, 500L);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.l) {
            View view2 = this.f;
            if (view2 != null && (view2.getTag() instanceof w68)) {
                w68 w68Var = (w68) this.f.getTag();
                if (this.g) {
                    w68Var.startPlay();
                    this.g = false;
                }
                if (this.f.getTag() instanceof v68) {
                    ((v68) this.f.getTag()).c();
                }
            }
            this.f = null;
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.a = i;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.j = z;
        }
    }

    public void r(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.l = z;
            if (z || (view2 = this.f) == null || !(view2.getTag() instanceof w68) || ((w68) this.f.getTag()).getVideoContainer() == null) {
                return;
            }
            ((w68) this.f.getTag()).getVideoContainer().setTag(-1001, "1");
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
        }
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
        }
    }

    public void u(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        CustomMessageListener customMessageListener = this.p;
        if (customMessageListener != null) {
            customMessageListener.setTag(bdUniqueId);
        }
        CustomMessageListener customMessageListener2 = this.q;
        if (customMessageListener2 != null) {
            customMessageListener2.setSelfListener(true);
            this.q.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.p);
        MessageManager.getInstance().registerListener(this.q);
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.d = i;
        }
    }

    public final void w(int i, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048591, this, i, view2) == null) || view2 == null) {
            return;
        }
        View view3 = this.f;
        if (view3 != null && view3 != view2 && (view3.getTag() instanceof w68)) {
            ((w68) this.f.getTag()).stopPlay();
        }
        this.f = view2;
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

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            ng.a().removeCallbacks(this.o);
            ng.a().removeCallbacks(this.r);
            for (int i = 0; i < this.e.getListView().getChildCount(); i++) {
                View childAt = this.e.getListView().getChildAt(i);
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

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            for (int i = 0; i < this.e.getListView().getChildCount(); i++) {
                View childAt = this.e.getListView().getChildAt(i);
                if (childAt.getTag() instanceof w68) {
                    w68 w68Var = (w68) childAt.getTag();
                    if (w68Var.isPlayStarted()) {
                        t(w68Var.getCurrentPosition());
                        s(w68Var.getPlayUrl());
                        this.f = childAt;
                        this.g = w68Var.isPlaying();
                        w68Var.stopPlay();
                        return;
                    }
                }
            }
        }
    }

    public final void z(int i, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048594, this, i, view2) == null) {
            if (i == 1 && (view2.getTag() instanceof w68)) {
                w68 w68Var = (w68) view2.getTag();
                if (w68Var.isPlaying()) {
                    w68Var.stopPlay();
                }
            } else if (i == 2 && (view2.getTag() instanceof v68)) {
                ((v68) view2.getTag()).d();
            }
        }
    }
}
