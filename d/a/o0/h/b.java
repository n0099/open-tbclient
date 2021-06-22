package d.a.o0.h;

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
import d.a.n0.r.q.v0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f59081b;

    /* renamed from: e  reason: collision with root package name */
    public String[] f59084e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f59085f;

    /* renamed from: g  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f59086g;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<NEGFeedBackReasonCheckBox, Boolean> f59088i;
    public int j;

    /* renamed from: a  reason: collision with root package name */
    public boolean f59080a = false;

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<String> f59082c = null;

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<String> f59083d = null;
    public boolean k = false;
    public boolean l = true;
    public int m = -1;

    /* renamed from: h  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f59087h = new a();

    /* loaded from: classes4.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Map.Entry entry;
            if (compoundButton == null || b.this.f59088i == null || b.this.f59088i.isEmpty()) {
                return;
            }
            boolean z2 = false;
            if (z && b.this.k) {
                for (Map.Entry entry2 : b.this.f59088i.entrySet()) {
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
                Iterator it = b.this.f59088i.entrySet().iterator();
                while (it.hasNext() && ((entry = (Map.Entry) it.next()) == null || entry.getKey() == null || !(z2 = ((NEGFeedBackReasonCheckBox) entry.getKey()).isChecked()))) {
                }
                if (!z2) {
                    for (Map.Entry entry3 : b.this.f59088i.entrySet()) {
                        if (entry3 != null && entry3.getKey() == compoundButton) {
                            ((NEGFeedBackReasonCheckBox) entry3.getKey()).setChecked(true);
                            entry3.setValue(Boolean.TRUE);
                            return;
                        }
                    }
                }
            }
            if (b.this.f59086g != null) {
                b.this.f59086g.onCheckedChanged(compoundButton, z);
            }
        }
    }

    /* renamed from: d.a.o0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1416b {

        /* renamed from: a  reason: collision with root package name */
        public int f59090a;

        /* renamed from: b  reason: collision with root package name */
        public int f59091b;

        /* renamed from: c  reason: collision with root package name */
        public String f59092c;

        /* renamed from: d  reason: collision with root package name */
        public String f59093d;

        public C1416b(b bVar, int i2, int i3, String str) {
            this.f59091b = i3;
            if (str != null && str.contains("%")) {
                String[] split = str.split("%");
                this.f59092c = split[0];
                if (split.length > 1) {
                    this.f59093d = split[1];
                }
            } else {
                this.f59092c = str;
            }
            this.f59090a = i2;
        }
    }

    public b(TbPageContext tbPageContext) {
        this.f59081b = tbPageContext;
        this.j = l.g(tbPageContext.getPageActivity(), R.dimen.M_H_X003);
    }

    public final View e(List<C1416b> list, boolean z, View view) {
        LinearLayout linearLayout;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.f59081b.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.f59085f, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.a();
        nEGFeedBackReasonCheckBox2.a();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.f59088i.put(nEGFeedBackReasonCheckBox, Boolean.FALSE);
        this.f59088i.put(nEGFeedBackReasonCheckBox2, Boolean.FALSE);
        C1416b c1416b = list.get(0);
        if (c1416b != null) {
            nEGFeedBackReasonCheckBox.setText(c1416b.f59092c);
            nEGFeedBackReasonCheckBox.setTag(c1416b);
            if (c1416b.f59090a == this.m) {
                nEGFeedBackReasonCheckBox.setEnabled(false);
            }
        }
        if (list.size() > 1 && list.get(1) != null) {
            C1416b c1416b2 = list.get(1);
            nEGFeedBackReasonCheckBox2.setText(c1416b2.f59092c);
            nEGFeedBackReasonCheckBox2.setVisibility(0);
            nEGFeedBackReasonCheckBox2.setTag(c1416b2);
            if (c1416b2.f59090a == this.m) {
                nEGFeedBackReasonCheckBox2.setEnabled(false);
            }
        } else {
            nEGFeedBackReasonCheckBox2.setVisibility(4);
        }
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.f59087h);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.f59087h);
        int i2 = z ? 0 : this.j;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i2;
        }
        return linearLayout;
    }

    public final View f(List<C1416b> list, boolean z, View view) {
        LinearLayout linearLayout;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.f59081b.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.f59085f, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.a();
        nEGFeedBackReasonCheckBox2.a();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.f59088i.put(nEGFeedBackReasonCheckBox, Boolean.FALSE);
        this.f59088i.put(nEGFeedBackReasonCheckBox2, Boolean.FALSE);
        C1416b c1416b = list.get(0);
        if (c1416b != null) {
            nEGFeedBackReasonCheckBox.setText(c1416b.f59092c);
            nEGFeedBackReasonCheckBox.setTag(c1416b);
        }
        if (list.size() > 1 && list.get(1) != null) {
            C1416b c1416b2 = list.get(1);
            nEGFeedBackReasonCheckBox2.setText(c1416b2.f59092c);
            nEGFeedBackReasonCheckBox2.setVisibility(0);
            nEGFeedBackReasonCheckBox2.setTag(c1416b2);
        } else {
            nEGFeedBackReasonCheckBox2.setVisibility(8);
        }
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.f59087h);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.f59087h);
        int i2 = z ? 0 : this.j;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i2;
        }
        return linearLayout;
    }

    public View g() {
        if (this.f59085f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f59081b.getPageActivity());
            this.f59085f = linearLayout;
            linearLayout.setOrientation(1);
        }
        List<List<C1416b>> p = p();
        if (ListUtils.isEmpty(p)) {
            return null;
        }
        int size = p.size();
        HashMap<NEGFeedBackReasonCheckBox, Boolean> hashMap = this.f59088i;
        if (hashMap == null) {
            this.f59088i = new HashMap<>();
        } else {
            hashMap.clear();
        }
        int i2 = 0;
        while (i2 < size) {
            View e2 = e(p.get(i2), i2 == size + (-1), this.f59085f.getChildAt(i2));
            if (e2 != null && e2.getParent() == null) {
                this.f59085f.addView(e2);
            }
            i2++;
        }
        if (this.f59085f.getChildCount() > size) {
            LinearLayout linearLayout2 = this.f59085f;
            linearLayout2.removeViews(size, linearLayout2.getChildCount() - size);
        }
        return this.f59085f;
    }

    public View h() {
        if (this.f59085f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f59081b.getPageActivity());
            this.f59085f = linearLayout;
            linearLayout.setOrientation(1);
        }
        List<List<C1416b>> s = s();
        if (ListUtils.isEmpty(s)) {
            return null;
        }
        int size = s.size();
        HashMap<NEGFeedBackReasonCheckBox, Boolean> hashMap = this.f59088i;
        if (hashMap == null) {
            this.f59088i = new HashMap<>();
        } else {
            hashMap.clear();
        }
        int i2 = 0;
        while (i2 < size) {
            View f2 = f(s.get(i2), i2 == size + (-1), this.f59085f.getChildAt(i2));
            if (f2 != null && f2.getParent() == null) {
                this.f59085f.addView(f2);
            }
            i2++;
        }
        if (this.f59085f.getChildCount() > size) {
            LinearLayout linearLayout2 = this.f59085f;
            linearLayout2.removeViews(size, linearLayout2.getChildCount() - size);
        }
        return this.f59085f;
    }

    public void i(boolean z) {
        this.l = z;
    }

    public void j(v0 v0Var) {
        if (v0Var == null) {
            return;
        }
        this.f59082c = v0Var.b();
        this.f59083d = v0Var.f53930g;
    }

    public void k(String[] strArr) {
        this.f59084e = strArr;
    }

    public void l(int i2) {
        this.m = i2;
    }

    public void m(boolean z) {
        this.f59080a = z;
    }

    public void n(boolean z) {
        this.k = z;
    }

    public void o(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f59086g = onCheckedChangeListener;
    }

    public final List<List<C1416b>> p() {
        SparseArray<String> sparseArray = this.f59082c;
        if (sparseArray != null && sparseArray.size() != 0) {
            int size = this.f59082c.size();
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (i2 < size) {
                int i3 = i2 + 1;
                int i4 = i2 + 2;
                ArrayList arrayList2 = new ArrayList();
                C1416b c1416b = new C1416b(this, i2, this.f59082c.keyAt(i2), this.f59082c.valueAt(i2));
                SparseArray<String> sparseArray2 = this.f59083d;
                if (sparseArray2 != null && !StringUtils.isNull(sparseArray2.get(this.f59082c.keyAt(i2)))) {
                    c1416b.f59093d = this.f59083d.get(this.f59082c.keyAt(i2));
                }
                arrayList2.add(c1416b);
                if (i3 > i2 && i3 < size) {
                    C1416b c1416b2 = new C1416b(this, i3, this.f59082c.keyAt(i3), this.f59082c.valueAt(i3));
                    SparseArray<String> sparseArray3 = this.f59083d;
                    if (sparseArray3 != null && !StringUtils.isNull(sparseArray3.get(this.f59082c.keyAt(i2)))) {
                        c1416b2.f59093d = this.f59083d.get(this.f59082c.keyAt(i3));
                    }
                    arrayList2.add(c1416b2);
                }
                arrayList.add(arrayList2);
                i2 = i4;
            }
            return arrayList;
        }
        return q();
    }

    public final List<List<C1416b>> q() {
        String[] strArr = this.f59084e;
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.f59084e.length; i2 += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.f59084e[i2])) {
                arrayList2.add(new C1416b(this, i2, i2 + 1, this.f59084e[i2]));
            }
            int i3 = i2 + 1;
            String[] strArr2 = this.f59084e;
            if (i3 < strArr2.length && !StringUtils.isNull(strArr2[i3])) {
                arrayList2.add(new C1416b(this, i3, i2 + 2, this.f59084e[i3]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    public final List<List<C1416b>> r() {
        String[] strArr = this.f59084e;
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.f59084e.length; i2 += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.f59084e[i2])) {
                arrayList2.add(new C1416b(this, i2, 0, this.f59084e[i2]));
            }
            int i3 = i2 + 1;
            String[] strArr2 = this.f59084e;
            if (i3 < strArr2.length && !StringUtils.isNull(strArr2[i3])) {
                arrayList2.add(new C1416b(this, i3, 0, this.f59084e[i3]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    public final List<List<C1416b>> s() {
        int i2;
        int i3;
        SparseArray<String> sparseArray = this.f59082c;
        if (sparseArray != null && sparseArray.size() != 0) {
            int size = this.f59082c.size();
            int i4 = 0;
            int i5 = -1;
            int i6 = this.f59080a ? 0 : -1;
            int i7 = this.f59080a ? size - 1 : size;
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
                C1416b c1416b = new C1416b(this, i4, this.f59082c.keyAt(i4), this.f59082c.valueAt(i4));
                SparseArray<String> sparseArray2 = this.f59083d;
                if (sparseArray2 != null && !StringUtils.isNull(sparseArray2.get(this.f59082c.keyAt(i4)))) {
                    c1416b.f59093d = this.f59083d.get(this.f59082c.keyAt(i4));
                }
                arrayList2.add(c1416b);
                if (i3 > i4 && i3 < size) {
                    C1416b c1416b2 = new C1416b(this, i3, this.f59082c.keyAt(i3), this.f59082c.valueAt(i3));
                    SparseArray<String> sparseArray3 = this.f59083d;
                    if (sparseArray3 != null && !StringUtils.isNull(sparseArray3.get(this.f59082c.keyAt(i4)))) {
                        c1416b2.f59093d = this.f59083d.get(this.f59082c.keyAt(i3));
                    }
                    arrayList2.add(c1416b2);
                }
                arrayList.add(arrayList2);
                i4 = i2;
            }
            return arrayList;
        }
        return r();
    }
}
