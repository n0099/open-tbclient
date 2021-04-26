package d.a.j0.h;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackReasonCheckBox;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.i0.r.q.v0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f54685b;

    /* renamed from: e  reason: collision with root package name */
    public String[] f54688e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f54689f;

    /* renamed from: g  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f54690g;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<NEGFeedBackReasonCheckBox, Boolean> f54692i;
    public int j;

    /* renamed from: a  reason: collision with root package name */
    public boolean f54684a = false;

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<String> f54686c = null;

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<String> f54687d = null;
    public boolean k = false;
    public boolean l = true;
    public int m = -1;

    /* renamed from: h  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f54691h = new a();

    /* loaded from: classes4.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Map.Entry entry;
            if (compoundButton == null || b.this.f54692i == null || b.this.f54692i.isEmpty()) {
                return;
            }
            boolean z2 = false;
            if (z && b.this.k) {
                for (Map.Entry entry2 : b.this.f54692i.entrySet()) {
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
            if (b.this.k && !z && !b.this.l) {
                Iterator it = b.this.f54692i.entrySet().iterator();
                while (it.hasNext() && ((entry = (Map.Entry) it.next()) == null || entry.getKey() == null || !(z2 = ((NEGFeedBackReasonCheckBox) entry.getKey()).isChecked()))) {
                }
                if (!z2) {
                    for (Map.Entry entry3 : b.this.f54692i.entrySet()) {
                        if (entry3 != null && entry3.getKey() == compoundButton) {
                            ((NEGFeedBackReasonCheckBox) entry3.getKey()).setChecked(true);
                            entry3.setValue(Boolean.TRUE);
                            return;
                        }
                    }
                }
            }
            if (b.this.f54690g != null) {
                b.this.f54690g.onCheckedChanged(compoundButton, z);
            }
        }
    }

    /* renamed from: d.a.j0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1276b {

        /* renamed from: a  reason: collision with root package name */
        public int f54694a;

        /* renamed from: b  reason: collision with root package name */
        public int f54695b;

        /* renamed from: c  reason: collision with root package name */
        public String f54696c;

        /* renamed from: d  reason: collision with root package name */
        public String f54697d;

        public C1276b(b bVar, int i2, int i3, String str) {
            this.f54695b = i3;
            if (str != null && str.contains("%")) {
                String[] split = str.split("%");
                this.f54696c = split[0];
                if (split.length > 1) {
                    this.f54697d = split[1];
                }
            } else {
                this.f54696c = str;
            }
            this.f54694a = i2;
        }
    }

    public b(TbPageContext tbPageContext) {
        this.f54685b = tbPageContext;
        this.j = l.g(tbPageContext.getPageActivity(), R.dimen.M_H_X003);
    }

    public final View e(List<C1276b> list, boolean z, View view) {
        LinearLayout linearLayout;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.f54685b.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.f54689f, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.a();
        nEGFeedBackReasonCheckBox2.a();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.f54692i.put(nEGFeedBackReasonCheckBox, Boolean.FALSE);
        this.f54692i.put(nEGFeedBackReasonCheckBox2, Boolean.FALSE);
        C1276b c1276b = list.get(0);
        if (c1276b != null) {
            nEGFeedBackReasonCheckBox.setText(c1276b.f54696c);
            nEGFeedBackReasonCheckBox.setTag(c1276b);
            if (c1276b.f54694a == this.m) {
                nEGFeedBackReasonCheckBox.setEnabled(false);
            }
        }
        if (list.size() > 1 && list.get(1) != null) {
            C1276b c1276b2 = list.get(1);
            nEGFeedBackReasonCheckBox2.setText(c1276b2.f54696c);
            nEGFeedBackReasonCheckBox2.setVisibility(0);
            nEGFeedBackReasonCheckBox2.setTag(c1276b2);
            if (c1276b2.f54694a == this.m) {
                nEGFeedBackReasonCheckBox2.setEnabled(false);
            }
        } else {
            nEGFeedBackReasonCheckBox2.setVisibility(4);
        }
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.f54691h);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.f54691h);
        int i2 = z ? 0 : this.j;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i2;
        }
        return linearLayout;
    }

    public final View f(List<C1276b> list, boolean z, View view) {
        LinearLayout linearLayout;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.f54685b.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.f54689f, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.a();
        nEGFeedBackReasonCheckBox2.a();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.f54692i.put(nEGFeedBackReasonCheckBox, Boolean.FALSE);
        this.f54692i.put(nEGFeedBackReasonCheckBox2, Boolean.FALSE);
        C1276b c1276b = list.get(0);
        if (c1276b != null) {
            nEGFeedBackReasonCheckBox.setText(c1276b.f54696c);
            nEGFeedBackReasonCheckBox.setTag(c1276b);
        }
        if (list.size() > 1 && list.get(1) != null) {
            C1276b c1276b2 = list.get(1);
            nEGFeedBackReasonCheckBox2.setText(c1276b2.f54696c);
            nEGFeedBackReasonCheckBox2.setVisibility(0);
            nEGFeedBackReasonCheckBox2.setTag(c1276b2);
        } else {
            nEGFeedBackReasonCheckBox2.setVisibility(8);
        }
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.f54691h);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.f54691h);
        int i2 = z ? 0 : this.j;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i2;
        }
        return linearLayout;
    }

    public View g() {
        if (this.f54689f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f54685b.getPageActivity());
            this.f54689f = linearLayout;
            linearLayout.setOrientation(1);
        }
        List<List<C1276b>> p = p();
        if (ListUtils.isEmpty(p)) {
            return null;
        }
        int size = p.size();
        HashMap<NEGFeedBackReasonCheckBox, Boolean> hashMap = this.f54692i;
        if (hashMap == null) {
            this.f54692i = new HashMap<>();
        } else {
            hashMap.clear();
        }
        int i2 = 0;
        while (i2 < size) {
            View e2 = e(p.get(i2), i2 == size + (-1), this.f54689f.getChildAt(i2));
            if (e2 != null && e2.getParent() == null) {
                this.f54689f.addView(e2);
            }
            i2++;
        }
        if (this.f54689f.getChildCount() > size) {
            LinearLayout linearLayout2 = this.f54689f;
            linearLayout2.removeViews(size, linearLayout2.getChildCount() - size);
        }
        return this.f54689f;
    }

    public View h() {
        if (this.f54689f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f54685b.getPageActivity());
            this.f54689f = linearLayout;
            linearLayout.setOrientation(1);
        }
        List<List<C1276b>> s = s();
        if (ListUtils.isEmpty(s)) {
            return null;
        }
        int size = s.size();
        HashMap<NEGFeedBackReasonCheckBox, Boolean> hashMap = this.f54692i;
        if (hashMap == null) {
            this.f54692i = new HashMap<>();
        } else {
            hashMap.clear();
        }
        int i2 = 0;
        while (i2 < size) {
            View f2 = f(s.get(i2), i2 == size + (-1), this.f54689f.getChildAt(i2));
            if (f2 != null && f2.getParent() == null) {
                this.f54689f.addView(f2);
            }
            i2++;
        }
        if (this.f54689f.getChildCount() > size) {
            LinearLayout linearLayout2 = this.f54689f;
            linearLayout2.removeViews(size, linearLayout2.getChildCount() - size);
        }
        return this.f54689f;
    }

    public void i(boolean z) {
        this.l = z;
    }

    public void j(v0 v0Var) {
        if (v0Var == null) {
            return;
        }
        this.f54686c = v0Var.b();
        this.f54687d = v0Var.f49284g;
    }

    public void k(String[] strArr) {
        this.f54688e = strArr;
    }

    public void l(int i2) {
        this.m = i2;
    }

    public void m(boolean z) {
        this.f54684a = z;
    }

    public void n(boolean z) {
        this.k = z;
    }

    public void o(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f54690g = onCheckedChangeListener;
    }

    public final List<List<C1276b>> p() {
        SparseArray<String> sparseArray = this.f54686c;
        if (sparseArray != null && sparseArray.size() != 0) {
            int size = this.f54686c.size();
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (i2 < size) {
                int i3 = i2 + 1;
                int i4 = i2 + 2;
                ArrayList arrayList2 = new ArrayList();
                C1276b c1276b = new C1276b(this, i2, this.f54686c.keyAt(i2), this.f54686c.valueAt(i2));
                SparseArray<String> sparseArray2 = this.f54687d;
                if (sparseArray2 != null && !StringUtils.isNull(sparseArray2.get(this.f54686c.keyAt(i2)))) {
                    c1276b.f54697d = this.f54687d.get(this.f54686c.keyAt(i2));
                }
                arrayList2.add(c1276b);
                if (i3 > i2 && i3 < size) {
                    C1276b c1276b2 = new C1276b(this, i3, this.f54686c.keyAt(i3), this.f54686c.valueAt(i3));
                    SparseArray<String> sparseArray3 = this.f54687d;
                    if (sparseArray3 != null && !StringUtils.isNull(sparseArray3.get(this.f54686c.keyAt(i2)))) {
                        c1276b2.f54697d = this.f54687d.get(this.f54686c.keyAt(i3));
                    }
                    arrayList2.add(c1276b2);
                }
                arrayList.add(arrayList2);
                i2 = i4;
            }
            return arrayList;
        }
        return q();
    }

    public final List<List<C1276b>> q() {
        String[] strArr = this.f54688e;
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.f54688e.length; i2 += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.f54688e[i2])) {
                arrayList2.add(new C1276b(this, i2, i2 + 1, this.f54688e[i2]));
            }
            int i3 = i2 + 1;
            String[] strArr2 = this.f54688e;
            if (i3 < strArr2.length && !StringUtils.isNull(strArr2[i3])) {
                arrayList2.add(new C1276b(this, i3, i2 + 2, this.f54688e[i3]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    public final List<List<C1276b>> r() {
        String[] strArr = this.f54688e;
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.f54688e.length; i2 += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.f54688e[i2])) {
                arrayList2.add(new C1276b(this, i2, 0, this.f54688e[i2]));
            }
            int i3 = i2 + 1;
            String[] strArr2 = this.f54688e;
            if (i3 < strArr2.length && !StringUtils.isNull(strArr2[i3])) {
                arrayList2.add(new C1276b(this, i3, 0, this.f54688e[i3]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    public final List<List<C1276b>> s() {
        int i2;
        int i3;
        SparseArray<String> sparseArray = this.f54686c;
        if (sparseArray != null && sparseArray.size() != 0) {
            int size = this.f54686c.size();
            int i4 = 0;
            int i5 = -1;
            int i6 = this.f54684a ? 0 : -1;
            int i7 = this.f54684a ? size - 1 : size;
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
                C1276b c1276b = new C1276b(this, i4, this.f54686c.keyAt(i4), this.f54686c.valueAt(i4));
                SparseArray<String> sparseArray2 = this.f54687d;
                if (sparseArray2 != null && !StringUtils.isNull(sparseArray2.get(this.f54686c.keyAt(i4)))) {
                    c1276b.f54697d = this.f54687d.get(this.f54686c.keyAt(i4));
                }
                arrayList2.add(c1276b);
                if (i3 > i4 && i3 < size) {
                    C1276b c1276b2 = new C1276b(this, i3, this.f54686c.keyAt(i3), this.f54686c.valueAt(i3));
                    SparseArray<String> sparseArray3 = this.f54687d;
                    if (sparseArray3 != null && !StringUtils.isNull(sparseArray3.get(this.f54686c.keyAt(i4)))) {
                        c1276b2.f54697d = this.f54687d.get(this.f54686c.keyAt(i3));
                    }
                    arrayList2.add(c1276b2);
                }
                arrayList.add(arrayList2);
                i4 = i2;
            }
            return arrayList;
        }
        return r();
    }
}
