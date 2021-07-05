package d.a.s0.h;

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
import d.a.c.e.p.l;
import d.a.r0.r.q.w0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f59848a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f59849b;

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<String> f59850c;

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<String> f59851d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f59852e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f59853f;

    /* renamed from: g  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f59854g;

    /* renamed from: h  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f59855h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<NEGFeedBackReasonCheckBox, Boolean> f59856i;
    public int j;
    public boolean k;
    public boolean l;
    public int m;

    /* loaded from: classes9.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f59857e;

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
            this.f59857e = bVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Map.Entry entry;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) || compoundButton == null || this.f59857e.f59856i == null || this.f59857e.f59856i.isEmpty()) {
                return;
            }
            boolean z2 = false;
            if (z && this.f59857e.k) {
                for (Map.Entry entry2 : this.f59857e.f59856i.entrySet()) {
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
            if (this.f59857e.k && !z && !this.f59857e.l) {
                Iterator it = this.f59857e.f59856i.entrySet().iterator();
                while (it.hasNext() && ((entry = (Map.Entry) it.next()) == null || entry.getKey() == null || !(z2 = ((NEGFeedBackReasonCheckBox) entry.getKey()).isChecked()))) {
                }
                if (!z2) {
                    for (Map.Entry entry3 : this.f59857e.f59856i.entrySet()) {
                        if (entry3 != null && entry3.getKey() == compoundButton) {
                            ((NEGFeedBackReasonCheckBox) entry3.getKey()).setChecked(true);
                            entry3.setValue(Boolean.TRUE);
                            return;
                        }
                    }
                }
            }
            if (this.f59857e.f59854g != null) {
                this.f59857e.f59854g.onCheckedChanged(compoundButton, z);
            }
        }
    }

    /* renamed from: d.a.s0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1438b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f59858a;

        /* renamed from: b  reason: collision with root package name */
        public int f59859b;

        /* renamed from: c  reason: collision with root package name */
        public String f59860c;

        /* renamed from: d  reason: collision with root package name */
        public String f59861d;

        public C1438b(b bVar, int i2, int i3, String str) {
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
            this.f59859b = i3;
            if (str != null && str.contains("%")) {
                String[] split = str.split("%");
                this.f59860c = split[0];
                if (split.length > 1) {
                    this.f59861d = split[1];
                }
            } else {
                this.f59860c = str;
            }
            this.f59858a = i2;
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
        this.f59848a = false;
        this.f59850c = null;
        this.f59851d = null;
        this.k = false;
        this.l = true;
        this.m = -1;
        this.f59849b = tbPageContext;
        this.j = l.g(tbPageContext.getPageActivity(), R.dimen.M_H_X003);
        this.f59855h = new a(this);
    }

    public final View e(List<C1438b> list, boolean z, View view) {
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
                linearLayout = (LinearLayout) LayoutInflater.from(this.f59849b.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.f59853f, false);
            }
            NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
            NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
            nEGFeedBackReasonCheckBox.a();
            nEGFeedBackReasonCheckBox2.a();
            nEGFeedBackReasonCheckBox.setChecked(false);
            nEGFeedBackReasonCheckBox2.setChecked(false);
            this.f59856i.put(nEGFeedBackReasonCheckBox, Boolean.FALSE);
            this.f59856i.put(nEGFeedBackReasonCheckBox2, Boolean.FALSE);
            C1438b c1438b = list.get(0);
            if (c1438b != null) {
                nEGFeedBackReasonCheckBox.setText(c1438b.f59860c);
                nEGFeedBackReasonCheckBox.setTag(c1438b);
                if (c1438b.f59858a == this.m) {
                    nEGFeedBackReasonCheckBox.setEnabled(false);
                }
            }
            if (list.size() > 1 && list.get(1) != null) {
                C1438b c1438b2 = list.get(1);
                nEGFeedBackReasonCheckBox2.setText(c1438b2.f59860c);
                nEGFeedBackReasonCheckBox2.setVisibility(0);
                nEGFeedBackReasonCheckBox2.setTag(c1438b2);
                if (c1438b2.f59858a == this.m) {
                    nEGFeedBackReasonCheckBox2.setEnabled(false);
                }
            } else {
                nEGFeedBackReasonCheckBox2.setVisibility(4);
            }
            nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.f59855h);
            nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.f59855h);
            int i2 = z ? 0 : this.j;
            if (linearLayout.getLayoutParams() != null) {
                ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i2;
            }
            return linearLayout;
        }
        return (View) invokeCommon.objValue;
    }

    public final View f(List<C1438b> list, boolean z, View view) {
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
                linearLayout = (LinearLayout) LayoutInflater.from(this.f59849b.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.f59853f, false);
            }
            NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
            NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
            nEGFeedBackReasonCheckBox.a();
            nEGFeedBackReasonCheckBox2.a();
            nEGFeedBackReasonCheckBox.setChecked(false);
            nEGFeedBackReasonCheckBox2.setChecked(false);
            this.f59856i.put(nEGFeedBackReasonCheckBox, Boolean.FALSE);
            this.f59856i.put(nEGFeedBackReasonCheckBox2, Boolean.FALSE);
            C1438b c1438b = list.get(0);
            if (c1438b != null) {
                nEGFeedBackReasonCheckBox.setText(c1438b.f59860c);
                nEGFeedBackReasonCheckBox.setTag(c1438b);
            }
            if (list.size() > 1 && list.get(1) != null) {
                C1438b c1438b2 = list.get(1);
                nEGFeedBackReasonCheckBox2.setText(c1438b2.f59860c);
                nEGFeedBackReasonCheckBox2.setVisibility(0);
                nEGFeedBackReasonCheckBox2.setTag(c1438b2);
            } else {
                nEGFeedBackReasonCheckBox2.setVisibility(8);
            }
            nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.f59855h);
            nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.f59855h);
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
            if (this.f59853f == null) {
                LinearLayout linearLayout = new LinearLayout(this.f59849b.getPageActivity());
                this.f59853f = linearLayout;
                linearLayout.setOrientation(1);
            }
            List<List<C1438b>> p = p();
            if (ListUtils.isEmpty(p)) {
                return null;
            }
            int size = p.size();
            HashMap<NEGFeedBackReasonCheckBox, Boolean> hashMap = this.f59856i;
            if (hashMap == null) {
                this.f59856i = new HashMap<>();
            } else {
                hashMap.clear();
            }
            int i2 = 0;
            while (i2 < size) {
                View e2 = e(p.get(i2), i2 == size + (-1), this.f59853f.getChildAt(i2));
                if (e2 != null && e2.getParent() == null) {
                    this.f59853f.addView(e2);
                }
                i2++;
            }
            if (this.f59853f.getChildCount() > size) {
                LinearLayout linearLayout2 = this.f59853f;
                linearLayout2.removeViews(size, linearLayout2.getChildCount() - size);
            }
            return this.f59853f;
        }
        return (View) invokeV.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f59853f == null) {
                LinearLayout linearLayout = new LinearLayout(this.f59849b.getPageActivity());
                this.f59853f = linearLayout;
                linearLayout.setOrientation(1);
            }
            List<List<C1438b>> s = s();
            if (ListUtils.isEmpty(s)) {
                return null;
            }
            int size = s.size();
            HashMap<NEGFeedBackReasonCheckBox, Boolean> hashMap = this.f59856i;
            if (hashMap == null) {
                this.f59856i = new HashMap<>();
            } else {
                hashMap.clear();
            }
            int i2 = 0;
            while (i2 < size) {
                View f2 = f(s.get(i2), i2 == size + (-1), this.f59853f.getChildAt(i2));
                if (f2 != null && f2.getParent() == null) {
                    this.f59853f.addView(f2);
                }
                i2++;
            }
            if (this.f59853f.getChildCount() > size) {
                LinearLayout linearLayout2 = this.f59853f;
                linearLayout2.removeViews(size, linearLayout2.getChildCount() - size);
            }
            return this.f59853f;
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
        this.f59850c = w0Var.b();
        this.f59851d = w0Var.f56085g;
    }

    public void k(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, strArr) == null) {
            this.f59852e = strArr;
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
            this.f59848a = z;
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
            this.f59854g = onCheckedChangeListener;
        }
    }

    public final List<List<C1438b>> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            SparseArray<String> sparseArray = this.f59850c;
            if (sparseArray != null && sparseArray.size() != 0) {
                int size = this.f59850c.size();
                ArrayList arrayList = new ArrayList();
                int i2 = 0;
                while (i2 < size) {
                    int i3 = i2 + 1;
                    int i4 = i2 + 2;
                    ArrayList arrayList2 = new ArrayList();
                    C1438b c1438b = new C1438b(this, i2, this.f59850c.keyAt(i2), this.f59850c.valueAt(i2));
                    SparseArray<String> sparseArray2 = this.f59851d;
                    if (sparseArray2 != null && !StringUtils.isNull(sparseArray2.get(this.f59850c.keyAt(i2)))) {
                        c1438b.f59861d = this.f59851d.get(this.f59850c.keyAt(i2));
                    }
                    arrayList2.add(c1438b);
                    if (i3 > i2 && i3 < size) {
                        C1438b c1438b2 = new C1438b(this, i3, this.f59850c.keyAt(i3), this.f59850c.valueAt(i3));
                        SparseArray<String> sparseArray3 = this.f59851d;
                        if (sparseArray3 != null && !StringUtils.isNull(sparseArray3.get(this.f59850c.keyAt(i2)))) {
                            c1438b2.f59861d = this.f59851d.get(this.f59850c.keyAt(i3));
                        }
                        arrayList2.add(c1438b2);
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

    public final List<List<C1438b>> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            String[] strArr = this.f59852e;
            if (strArr == null || strArr.length <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.f59852e.length; i2 += 2) {
                ArrayList arrayList2 = new ArrayList();
                if (!StringUtils.isNull(this.f59852e[i2])) {
                    arrayList2.add(new C1438b(this, i2, i2 + 1, this.f59852e[i2]));
                }
                int i3 = i2 + 1;
                String[] strArr2 = this.f59852e;
                if (i3 < strArr2.length && !StringUtils.isNull(strArr2[i3])) {
                    arrayList2.add(new C1438b(this, i3, i2 + 2, this.f59852e[i3]));
                }
                if (arrayList2.size() > 0) {
                    arrayList.add(arrayList2);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final List<List<C1438b>> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            String[] strArr = this.f59852e;
            if (strArr == null || strArr.length <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.f59852e.length; i2 += 2) {
                ArrayList arrayList2 = new ArrayList();
                if (!StringUtils.isNull(this.f59852e[i2])) {
                    arrayList2.add(new C1438b(this, i2, 0, this.f59852e[i2]));
                }
                int i3 = i2 + 1;
                String[] strArr2 = this.f59852e;
                if (i3 < strArr2.length && !StringUtils.isNull(strArr2[i3])) {
                    arrayList2.add(new C1438b(this, i3, 0, this.f59852e[i3]));
                }
                if (arrayList2.size() > 0) {
                    arrayList.add(arrayList2);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final List<List<C1438b>> s() {
        InterceptResult invokeV;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            SparseArray<String> sparseArray = this.f59850c;
            if (sparseArray != null && sparseArray.size() != 0) {
                int size = this.f59850c.size();
                int i4 = 0;
                int i5 = -1;
                int i6 = this.f59848a ? 0 : -1;
                int i7 = this.f59848a ? size - 1 : size;
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
                    C1438b c1438b = new C1438b(this, i4, this.f59850c.keyAt(i4), this.f59850c.valueAt(i4));
                    SparseArray<String> sparseArray2 = this.f59851d;
                    if (sparseArray2 != null && !StringUtils.isNull(sparseArray2.get(this.f59850c.keyAt(i4)))) {
                        c1438b.f59861d = this.f59851d.get(this.f59850c.keyAt(i4));
                    }
                    arrayList2.add(c1438b);
                    if (i3 > i4 && i3 < size) {
                        C1438b c1438b2 = new C1438b(this, i3, this.f59850c.keyAt(i3), this.f59850c.valueAt(i3));
                        SparseArray<String> sparseArray3 = this.f59851d;
                        if (sparseArray3 != null && !StringUtils.isNull(sparseArray3.get(this.f59850c.keyAt(i4)))) {
                            c1438b2.f59861d = this.f59851d.get(this.f59850c.keyAt(i3));
                        }
                        arrayList2.add(c1438b2);
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
