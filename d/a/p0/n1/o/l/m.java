package d.a.p0.n1.o.l;

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
/* loaded from: classes8.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.a.f f60623a;

    /* renamed from: b  reason: collision with root package name */
    public int f60624b;

    /* renamed from: c  reason: collision with root package name */
    public int f60625c;

    /* renamed from: d  reason: collision with root package name */
    public ListView f60626d;

    /* renamed from: e  reason: collision with root package name */
    public String f60627e;

    /* renamed from: f  reason: collision with root package name */
    public int f60628f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, Integer> f60629g;

    /* renamed from: h  reason: collision with root package name */
    public View f60630h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f60631i;
    public d.a.p0.n2.e j;
    public d.a.p0.n2.l k;
    public boolean l;
    public d.a.p0.n2.a m;
    public final CustomMessageListener n;
    public b o;

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f60632a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(m mVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60632a = mVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                this.f60632a.s();
                if (this.f60632a.l && this.f60632a.l) {
                    m mVar = this.f60632a;
                    mVar.k(mVar.k.a(), this.f60632a.k.b(), this.f60632a.k.d(), this.f60632a.k.c());
                }
            }
        }
    }

    public m(d.a.c.a.f fVar, ListView listView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, listView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60624b = 0;
        this.f60625c = 0;
        this.f60627e = null;
        this.f60628f = 0;
        this.f60629g = new HashMap();
        this.f60631i = false;
        this.l = true;
        this.m = new d.a.p0.n2.a();
        this.n = new a(this, 2000994);
        this.o = new b(this);
        this.f60623a = fVar;
        this.f60624b = d.a.c.e.p.l.i(fVar.getPageActivity());
        this.f60626d = listView;
        BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.k = new d.a.p0.n2.l();
        fVar.registerListener(this.n);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d.a.c.e.m.e.a().removeCallbacks(this.m);
            d.a.c.e.m.e.a().removeCallbacks(this.o);
            d();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int i2 = 0; i2 < this.f60626d.getChildCount(); i2++) {
                View childAt = this.f60626d.getChildAt(i2);
                if (childAt.getTag() instanceof d.a.p0.n2.e) {
                    ((d.a.p0.n2.e) childAt.getTag()).stopPlay();
                }
            }
        }
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f60627e : (String) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f60628f : invokeV.intValue;
    }

    public int g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (this.f60629g.containsKey(str)) {
                return this.f60629g.get(str).intValue();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public void h(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view) == null) || view == null || i(view) || !(view.getTag() instanceof d.a.p0.n2.e)) {
            return;
        }
        d.a.p0.n2.e eVar = (d.a.p0.n2.e) view.getTag();
        if (!TextUtils.isEmpty(eVar.getPlayUrl()) && eVar.getCurrentPosition() > 0) {
            q(eVar.getPlayUrl(), eVar.getCurrentPosition());
        }
        eVar.stopPlay();
    }

    public boolean i(View view) {
        InterceptResult invokeL;
        int measuredHeight;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view)) == null) {
            if (view == null) {
                return false;
            }
            int[] iArr = new int[2];
            if (view == null) {
                return false;
            }
            view.getLocationOnScreen(iArr);
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.f60625c && measuredHeight < this.f60624b;
        }
        return invokeL.booleanValue;
    }

    public void j(int i2, int i3, boolean z, int i4) {
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Integer.valueOf(i4)}) == null) {
            this.k.e(i2, i3, z);
            ListView listView = this.f60626d;
            if (listView == null || listView.getChildCount() == 0) {
                return;
            }
            ListView listView2 = this.f60626d;
            ListAdapter wrappedAdapter = listView2 instanceof BdListView ? ((BdListView) listView2).getWrappedAdapter() : listView2.getAdapter();
            if (wrappedAdapter == null || wrappedAdapter.getCount() == 0) {
                return;
            }
            d.a.p0.n2.e eVar = this.j;
            if (eVar != null && !i(eVar.getVideoContainer())) {
                this.j.stopPlay();
            }
            int count = wrappedAdapter.getCount() + this.f60626d.getHeaderViewsCount() + this.f60626d.getFooterViewsCount();
            int i5 = 0;
            if (i2 == 0) {
                z2 = true;
            } else {
                int i6 = count - 1;
                z2 = false;
            }
            if (i2 == 0 || i3 == count - 1) {
                z3 = false;
                for (int i7 = 0; i7 < this.f60626d.getChildCount(); i7++) {
                    View childAt = this.f60626d.getChildAt(z2 ? i7 : (this.f60626d.getChildCount() - 1) - i7);
                    if (childAt.getTag() instanceof d.a.p0.n2.e) {
                        d.a.p0.n2.e eVar2 = (d.a.p0.n2.e) childAt.getTag();
                        if (!z3 && i(eVar2.getVideoContainer())) {
                            r(i4, childAt);
                            z3 = true;
                        } else {
                            if (!TextUtils.isEmpty(eVar2.getPlayUrl()) && eVar2.getCurrentPosition() > 0) {
                                q(eVar2.getPlayUrl(), eVar2.getCurrentPosition());
                            }
                            u(i4, childAt);
                        }
                    }
                }
            } else {
                z3 = false;
            }
            if (z3) {
                return;
            }
            int i8 = -1;
            int i9 = 0;
            while (true) {
                if (i9 >= this.f60626d.getChildCount()) {
                    break;
                }
                View childAt2 = this.f60626d.getChildAt(i9);
                if (childAt2.getTag() instanceof d.a.p0.n2.e) {
                    d.a.p0.n2.e eVar3 = (d.a.p0.n2.e) childAt2.getTag();
                    if (eVar3.isPlayStarted() && i(eVar3.getVideoContainer())) {
                        i8 = i9;
                        break;
                    }
                }
                i9++;
            }
            if (i8 >= 0) {
                while (i5 < this.f60626d.getChildCount()) {
                    View childAt3 = this.f60626d.getChildAt(i5);
                    if (i5 == i8) {
                        r(i4, childAt3);
                    } else {
                        if (childAt3.getTag() instanceof d.a.p0.n2.e) {
                            d.a.p0.n2.e eVar4 = (d.a.p0.n2.e) childAt3.getTag();
                            if (!TextUtils.isEmpty(eVar4.getPlayUrl()) && eVar4.getCurrentPosition() > 0) {
                                q(eVar4.getPlayUrl(), eVar4.getCurrentPosition());
                            }
                        }
                        u(i4, childAt3);
                    }
                    i5++;
                }
                return;
            }
            boolean z4 = false;
            while (i5 < this.f60626d.getChildCount()) {
                View childAt4 = this.f60626d.getChildAt(z ? (this.f60626d.getChildCount() - 1) - i5 : i5);
                if (childAt4.getTag() instanceof d.a.p0.n2.e) {
                    d.a.p0.n2.e eVar5 = (d.a.p0.n2.e) childAt4.getTag();
                    if (!z4 && i(eVar5.getVideoContainer())) {
                        r(i4, childAt4);
                        z4 = true;
                    } else {
                        if (!TextUtils.isEmpty(eVar5.getPlayUrl()) && eVar5.getCurrentPosition() > 0) {
                            q(eVar5.getPlayUrl(), eVar5.getCurrentPosition());
                        }
                        u(i4, childAt4);
                    }
                }
                i5++;
            }
        }
    }

    public void k(int i2, int i3, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            d.a.c.e.m.e.a().removeCallbacks(this.o);
            this.o.a(i2);
            this.o.c(i3);
            this.o.b(z);
            this.o.d(z2);
            this.k.f(z2);
            d.a.c.e.m.e.a().post(this.o);
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, str) == null) && this.f60629g.containsKey(str)) {
            this.f60629g.put(str, 0);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.l) {
            View view = this.f60630h;
            if (view != null && (view.getTag() instanceof d.a.p0.n2.e)) {
                d.a.p0.n2.e eVar = (d.a.p0.n2.e) this.f60630h.getTag();
                if (this.f60631i) {
                    eVar.startPlay();
                }
                if (this.f60630h.getTag() instanceof d.a.p0.n2.d) {
                    ((d.a.p0.n2.d) this.f60630h.getTag()).c();
                }
            }
            this.f60630h = null;
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
            this.f60627e = str;
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f60628f = i2;
        }
    }

    public void q(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, str, i2) == null) {
            if (this.f60629g.containsKey(str)) {
                if (this.f60629g.get(str).intValue() == 0) {
                    return;
                }
                this.f60629g.put(str, Integer.valueOf(i2));
                return;
            }
            this.f60629g.put(str, Integer.valueOf(i2));
        }
    }

    public final void r(int i2, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048591, this, i2, view) == null) || view == null) {
            return;
        }
        this.f60630h = view;
        if (i2 == 1 && (view.getTag() instanceof d.a.p0.n2.e)) {
            d.a.p0.n2.e eVar = (d.a.p0.n2.e) view.getTag();
            if (!this.l || eVar.isPlayStarted()) {
                return;
            }
            eVar.startPlay();
        } else if (i2 == 2 && (view.getTag() instanceof d.a.p0.n2.d)) {
            ((d.a.p0.n2.d) view.getTag()).b();
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            d.a.c.e.m.e.a().removeCallbacks(this.m);
            d.a.c.e.m.e.a().removeCallbacks(this.o);
            for (int i2 = 0; i2 < this.f60626d.getChildCount(); i2++) {
                View childAt = this.f60626d.getChildAt(i2);
                if (childAt.getTag() instanceof d.a.p0.n2.e) {
                    d.a.p0.n2.e eVar = (d.a.p0.n2.e) childAt.getTag();
                    if (eVar.isPlayStarted()) {
                        eVar.stopPlay();
                        return;
                    }
                }
            }
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            for (int i2 = 0; i2 < this.f60626d.getChildCount(); i2++) {
                View childAt = this.f60626d.getChildAt(i2);
                if (childAt.getTag() instanceof d.a.p0.n2.e) {
                    d.a.p0.n2.e eVar = (d.a.p0.n2.e) childAt.getTag();
                    if (eVar.isPlayStarted()) {
                        p(eVar.getCurrentPosition());
                        o(eVar.getPlayUrl());
                        this.f60630h = childAt;
                        this.f60631i = eVar.isPlaying();
                        eVar.stopPlay();
                        return;
                    }
                }
            }
        }
    }

    public final void u(int i2, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048594, this, i2, view) == null) {
            if (i2 == 1 && (view.getTag() instanceof d.a.p0.n2.e)) {
                ((d.a.p0.n2.e) view.getTag()).stopPlay();
            } else if (i2 == 2 && (view.getTag() instanceof d.a.p0.n2.d)) {
                ((d.a.p0.n2.d) view.getTag()).d();
            }
        }
    }
}
