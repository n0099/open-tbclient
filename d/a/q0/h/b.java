package d.a.q0.h;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackReasonCheckBox;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.p0.s.q.w0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f57134a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f57135b;

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<String> f57136c;

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<String> f57137d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f57138e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f57139f;

    /* renamed from: g  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f57140g;

    /* renamed from: h  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f57141h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<NEGFeedBackReasonCheckBox, Boolean> f57142i;
    public int j;
    public boolean k;
    public boolean l;
    public int m;

    /* loaded from: classes8.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f57143e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57143e = bVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Map.Entry entry;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) || compoundButton == null || this.f57143e.f57142i == null || this.f57143e.f57142i.isEmpty()) {
                return;
            }
            boolean z2 = false;
            if (z && this.f57143e.k) {
                for (Map.Entry entry2 : this.f57143e.f57142i.entrySet()) {
                    if (entry2 != null) {
                        if (entry2.getKey() == compoundButton) {
                            ((NEGFeedBackReasonCheckBox) entry2.getKey()).setChecked(true);
                            entry2.setValue(Boolean.TRUE);
                        } else {
                            ((NEGFeedBackReasonCheckBox) entry2.getKey()).setChecked(false);
                            entry2.setValue(Boolean.FALSE);
                        }
                    }
                }
            }
            if (this.f57143e.k && !z && !this.f57143e.l) {
                Iterator it = this.f57143e.f57142i.entrySet().iterator();
                while (it.hasNext() && ((entry = (Map.Entry) it.next()) == null || entry.getKey() == null || !(z2 = ((NEGFeedBackReasonCheckBox) entry.getKey()).isChecked()))) {
                }
                if (!z2) {
                    for (Map.Entry entry3 : this.f57143e.f57142i.entrySet()) {
                        if (entry3 != null && entry3.getKey() == compoundButton) {
                            ((NEGFeedBackReasonCheckBox) entry3.getKey()).setChecked(true);
                            entry3.setValue(Boolean.TRUE);
                            return;
                        }
                    }
                }
            }
            if (this.f57143e.f57140g != null) {
                this.f57143e.f57140g.onCheckedChanged(compoundButton, z);
            }
        }
    }

    /* renamed from: d.a.q0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1401b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f57144a;

        /* renamed from: b  reason: collision with root package name */
        public int f57145b;

        /* renamed from: c  reason: collision with root package name */
        public String f57146c;

        /* renamed from: d  reason: collision with root package name */
        public String f57147d;

        public C1401b(b bVar, int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2), Integer.valueOf(i3), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57145b = i3;
            if (str != null && str.contains("%")) {
                String[] split = str.split("%");
                this.f57146c = split[0];
                if (split.length > 1) {
                    this.f57147d = split[1];
                }
            } else {
                this.f57146c = str;
            }
            this.f57144a = i2;
        }
    }

    public b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57134a = false;
        this.f57136c = null;
        this.f57137d = null;
        this.k = false;
        this.l = true;
        this.m = -1;
        this.f57135b = tbPageContext;
        this.j = l.g(tbPageContext.getPageActivity(), R.dimen.M_H_X003);
        this.f57141h = new a(this);
    }

    public final View e(List<C1401b> list, boolean z, View view) {
        InterceptResult invokeCommon;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{list, Boolean.valueOf(z), view})) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            if (view instanceof LinearLayout) {
                linearLayout = (LinearLayout) view;
            } else {
                linearLayout = (LinearLayout) LayoutInflater.from(this.f57135b.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.f57139f, false);
            }
            NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
            NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
            nEGFeedBackReasonCheckBox.a();
            nEGFeedBackReasonCheckBox2.a();
            nEGFeedBackReasonCheckBox.setChecked(false);
            nEGFeedBackReasonCheckBox2.setChecked(false);
            this.f57142i.put(nEGFeedBackReasonCheckBox, Boolean.FALSE);
            this.f57142i.put(nEGFeedBackReasonCheckBox2, Boolean.FALSE);
            C1401b c1401b = list.get(0);
            if (c1401b != null) {
                nEGFeedBackReasonCheckBox.setText(c1401b.f57146c);
                nEGFeedBackReasonCheckBox.setTag(c1401b);
                if (c1401b.f57144a == this.m) {
                    nEGFeedBackReasonCheckBox.setEnabled(false);
                }
            }
            if (list.size() > 1 && list.get(1) != null) {
                C1401b c1401b2 = list.get(1);
                nEGFeedBackReasonCheckBox2.setText(c1401b2.f57146c);
                nEGFeedBackReasonCheckBox2.setVisibility(0);
                nEGFeedBackReasonCheckBox2.setTag(c1401b2);
                if (c1401b2.f57144a == this.m) {
                    nEGFeedBackReasonCheckBox2.setEnabled(false);
                }
            } else {
                nEGFeedBackReasonCheckBox2.setVisibility(4);
            }
            nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.f57141h);
            nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.f57141h);
            int i2 = z ? 0 : this.j;
            if (linearLayout.getLayoutParams() != null) {
                ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i2;
            }
            return linearLayout;
        }
        return (View) invokeCommon.objValue;
    }

    public final View f(List<C1401b> list, boolean z, View view) {
        InterceptResult invokeCommon;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{list, Boolean.valueOf(z), view})) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            if (view instanceof LinearLayout) {
                linearLayout = (LinearLayout) view;
            } else {
                linearLayout = (LinearLayout) LayoutInflater.from(this.f57135b.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.f57139f, false);
            }
            NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
            NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
            nEGFeedBackReasonCheckBox.a();
            nEGFeedBackReasonCheckBox2.a();
            nEGFeedBackReasonCheckBox.setChecked(false);
            nEGFeedBackReasonCheckBox2.setChecked(false);
            this.f57142i.put(nEGFeedBackReasonCheckBox, Boolean.FALSE);
            this.f57142i.put(nEGFeedBackReasonCheckBox2, Boolean.FALSE);
            C1401b c1401b = list.get(0);
            if (c1401b != null) {
                nEGFeedBackReasonCheckBox.setText(c1401b.f57146c);
                nEGFeedBackReasonCheckBox.setTag(c1401b);
            }
            if (list.size() > 1 && list.get(1) != null) {
                C1401b c1401b2 = list.get(1);
                nEGFeedBackReasonCheckBox2.setText(c1401b2.f57146c);
                nEGFeedBackReasonCheckBox2.setVisibility(0);
                nEGFeedBackReasonCheckBox2.setTag(c1401b2);
            } else {
                nEGFeedBackReasonCheckBox2.setVisibility(8);
            }
            nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.f57141h);
            nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.f57141h);
            int i2 = z ? 0 : this.j;
            if (linearLayout.getLayoutParams() != null) {
                ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i2;
            }
            return linearLayout;
        }
        return (View) invokeCommon.objValue;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f57139f == null) {
                LinearLayout linearLayout = new LinearLayout(this.f57135b.getPageActivity());
                this.f57139f = linearLayout;
                linearLayout.setOrientation(1);
            }
            List<List<C1401b>> p = p();
            if (ListUtils.isEmpty(p)) {
                return null;
            }
            int size = p.size();
            HashMap<NEGFeedBackReasonCheckBox, Boolean> hashMap = this.f57142i;
            if (hashMap == null) {
                this.f57142i = new HashMap<>();
            } else {
                hashMap.clear();
            }
            int i2 = 0;
            while (i2 < size) {
                View e2 = e(p.get(i2), i2 == size + (-1), this.f57139f.getChildAt(i2));
                if (e2 != null && e2.getParent() == null) {
                    this.f57139f.addView(e2);
                }
                i2++;
            }
            if (this.f57139f.getChildCount() > size) {
                LinearLayout linearLayout2 = this.f57139f;
                linearLayout2.removeViews(size, linearLayout2.getChildCount() - size);
            }
            return this.f57139f;
        }
        return (View) invokeV.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f57139f == null) {
                LinearLayout linearLayout = new LinearLayout(this.f57135b.getPageActivity());
                this.f57139f = linearLayout;
                linearLayout.setOrientation(1);
            }
            List<List<C1401b>> s = s();
            if (ListUtils.isEmpty(s)) {
                return null;
            }
            int size = s.size();
            HashMap<NEGFeedBackReasonCheckBox, Boolean> hashMap = this.f57142i;
            if (hashMap == null) {
                this.f57142i = new HashMap<>();
            } else {
                hashMap.clear();
            }
            int i2 = 0;
            while (i2 < size) {
                View f2 = f(s.get(i2), i2 == size + (-1), this.f57139f.getChildAt(i2));
                if (f2 != null && f2.getParent() == null) {
                    this.f57139f.addView(f2);
                }
                i2++;
            }
            if (this.f57139f.getChildCount() > size) {
                LinearLayout linearLayout2 = this.f57139f;
                linearLayout2.removeViews(size, linearLayout2.getChildCount() - size);
            }
            return this.f57139f;
        }
        return (View) invokeV.objValue;
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.l = z;
        }
    }

    public void j(w0 w0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, w0Var) == null) || w0Var == null) {
            return;
        }
        this.f57136c = w0Var.b();
        this.f57137d = w0Var.f53468g;
    }

    public void k(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, strArr) == null) {
            this.f57138e = strArr;
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.m = i2;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f57134a = z;
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.k = z;
        }
    }

    public void o(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onCheckedChangeListener) == null) {
            this.f57140g = onCheckedChangeListener;
        }
    }

    public final List<List<C1401b>> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            SparseArray<String> sparseArray = this.f57136c;
            if (sparseArray != null && sparseArray.size() != 0) {
                int size = this.f57136c.size();
                ArrayList arrayList = new ArrayList();
                int i2 = 0;
                while (i2 < size) {
                    int i3 = i2 + 1;
                    int i4 = i2 + 2;
                    ArrayList arrayList2 = new ArrayList();
                    C1401b c1401b = new C1401b(this, i2, this.f57136c.keyAt(i2), this.f57136c.valueAt(i2));
                    SparseArray<String> sparseArray2 = this.f57137d;
                    if (sparseArray2 != null && !StringUtils.isNull(sparseArray2.get(this.f57136c.keyAt(i2)))) {
                        c1401b.f57147d = this.f57137d.get(this.f57136c.keyAt(i2));
                    }
                    arrayList2.add(c1401b);
                    if (i3 > i2 && i3 < size) {
                        C1401b c1401b2 = new C1401b(this, i3, this.f57136c.keyAt(i3), this.f57136c.valueAt(i3));
                        SparseArray<String> sparseArray3 = this.f57137d;
                        if (sparseArray3 != null && !StringUtils.isNull(sparseArray3.get(this.f57136c.keyAt(i2)))) {
                            c1401b2.f57147d = this.f57137d.get(this.f57136c.keyAt(i3));
                        }
                        arrayList2.add(c1401b2);
                    }
                    arrayList.add(arrayList2);
                    i2 = i4;
                }
                return arrayList;
            }
            return q();
        }
        return (List) invokeV.objValue;
    }

    public final List<List<C1401b>> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            String[] strArr = this.f57138e;
            if (strArr == null || strArr.length <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.f57138e.length; i2 += 2) {
                ArrayList arrayList2 = new ArrayList();
                if (!StringUtils.isNull(this.f57138e[i2])) {
                    arrayList2.add(new C1401b(this, i2, i2 + 1, this.f57138e[i2]));
                }
                int i3 = i2 + 1;
                String[] strArr2 = this.f57138e;
                if (i3 < strArr2.length && !StringUtils.isNull(strArr2[i3])) {
                    arrayList2.add(new C1401b(this, i3, i2 + 2, this.f57138e[i3]));
                }
                if (arrayList2.size() > 0) {
                    arrayList.add(arrayList2);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final List<List<C1401b>> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            String[] strArr = this.f57138e;
            if (strArr == null || strArr.length <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.f57138e.length; i2 += 2) {
                ArrayList arrayList2 = new ArrayList();
                if (!StringUtils.isNull(this.f57138e[i2])) {
                    arrayList2.add(new C1401b(this, i2, 0, this.f57138e[i2]));
                }
                int i3 = i2 + 1;
                String[] strArr2 = this.f57138e;
                if (i3 < strArr2.length && !StringUtils.isNull(strArr2[i3])) {
                    arrayList2.add(new C1401b(this, i3, 0, this.f57138e[i3]));
                }
                if (arrayList2.size() > 0) {
                    arrayList.add(arrayList2);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final List<List<C1401b>> s() {
        InterceptResult invokeV;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            SparseArray<String> sparseArray = this.f57136c;
            if (sparseArray != null && sparseArray.size() != 0) {
                int size = this.f57136c.size();
                int i4 = 0;
                int i5 = -1;
                int i6 = this.f57134a ? 0 : -1;
                int i7 = this.f57134a ? size - 1 : size;
                if (i7 > 1 && i7 % 2 == 1) {
                    i5 = i6 + 1;
                }
                ArrayList arrayList = new ArrayList();
                while (i4 < size) {
                    if (i4 == i6 || i4 == i5) {
                        i2 = i4 + 1;
                        i3 = i4;
                    } else {
                        i3 = i4 + 1;
                        i2 = i4 + 2;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    C1401b c1401b = new C1401b(this, i4, this.f57136c.keyAt(i4), this.f57136c.valueAt(i4));
                    SparseArray<String> sparseArray2 = this.f57137d;
                    if (sparseArray2 != null && !StringUtils.isNull(sparseArray2.get(this.f57136c.keyAt(i4)))) {
                        c1401b.f57147d = this.f57137d.get(this.f57136c.keyAt(i4));
                    }
                    arrayList2.add(c1401b);
                    if (i3 > i4 && i3 < size) {
                        C1401b c1401b2 = new C1401b(this, i3, this.f57136c.keyAt(i3), this.f57136c.valueAt(i3));
                        SparseArray<String> sparseArray3 = this.f57137d;
                        if (sparseArray3 != null && !StringUtils.isNull(sparseArray3.get(this.f57136c.keyAt(i4)))) {
                            c1401b2.f57147d = this.f57137d.get(this.f57136c.keyAt(i3));
                        }
                        arrayList2.add(c1401b2);
                    }
                    arrayList.add(arrayList2);
                    i4 = i2;
                }
                return arrayList;
            }
            return r();
        }
        return (List) invokeV.objValue;
    }
}
