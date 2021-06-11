package d.a.n0.h;

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
import d.a.m0.r.q.v0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f58956b;

    /* renamed from: e  reason: collision with root package name */
    public String[] f58959e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f58960f;

    /* renamed from: g  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f58961g;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<NEGFeedBackReasonCheckBox, Boolean> f58963i;
    public int j;

    /* renamed from: a  reason: collision with root package name */
    public boolean f58955a = false;

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<String> f58957c = null;

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<String> f58958d = null;
    public boolean k = false;
    public boolean l = true;
    public int m = -1;

    /* renamed from: h  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f58962h = new a();

    /* loaded from: classes4.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Map.Entry entry;
            if (compoundButton == null || b.this.f58963i == null || b.this.f58963i.isEmpty()) {
                return;
            }
            boolean z2 = false;
            if (z && b.this.k) {
                for (Map.Entry entry2 : b.this.f58963i.entrySet()) {
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
                Iterator it = b.this.f58963i.entrySet().iterator();
                while (it.hasNext() && ((entry = (Map.Entry) it.next()) == null || entry.getKey() == null || !(z2 = ((NEGFeedBackReasonCheckBox) entry.getKey()).isChecked()))) {
                }
                if (!z2) {
                    for (Map.Entry entry3 : b.this.f58963i.entrySet()) {
                        if (entry3 != null && entry3.getKey() == compoundButton) {
                            ((NEGFeedBackReasonCheckBox) entry3.getKey()).setChecked(true);
                            entry3.setValue(Boolean.TRUE);
                            return;
                        }
                    }
                }
            }
            if (b.this.f58961g != null) {
                b.this.f58961g.onCheckedChanged(compoundButton, z);
            }
        }
    }

    /* renamed from: d.a.n0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1412b {

        /* renamed from: a  reason: collision with root package name */
        public int f58965a;

        /* renamed from: b  reason: collision with root package name */
        public int f58966b;

        /* renamed from: c  reason: collision with root package name */
        public String f58967c;

        /* renamed from: d  reason: collision with root package name */
        public String f58968d;

        public C1412b(b bVar, int i2, int i3, String str) {
            this.f58966b = i3;
            if (str != null && str.contains("%")) {
                String[] split = str.split("%");
                this.f58967c = split[0];
                if (split.length > 1) {
                    this.f58968d = split[1];
                }
            } else {
                this.f58967c = str;
            }
            this.f58965a = i2;
        }
    }

    public b(TbPageContext tbPageContext) {
        this.f58956b = tbPageContext;
        this.j = l.g(tbPageContext.getPageActivity(), R.dimen.M_H_X003);
    }

    public final View e(List<C1412b> list, boolean z, View view) {
        LinearLayout linearLayout;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.f58956b.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.f58960f, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.a();
        nEGFeedBackReasonCheckBox2.a();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.f58963i.put(nEGFeedBackReasonCheckBox, Boolean.FALSE);
        this.f58963i.put(nEGFeedBackReasonCheckBox2, Boolean.FALSE);
        C1412b c1412b = list.get(0);
        if (c1412b != null) {
            nEGFeedBackReasonCheckBox.setText(c1412b.f58967c);
            nEGFeedBackReasonCheckBox.setTag(c1412b);
            if (c1412b.f58965a == this.m) {
                nEGFeedBackReasonCheckBox.setEnabled(false);
            }
        }
        if (list.size() > 1 && list.get(1) != null) {
            C1412b c1412b2 = list.get(1);
            nEGFeedBackReasonCheckBox2.setText(c1412b2.f58967c);
            nEGFeedBackReasonCheckBox2.setVisibility(0);
            nEGFeedBackReasonCheckBox2.setTag(c1412b2);
            if (c1412b2.f58965a == this.m) {
                nEGFeedBackReasonCheckBox2.setEnabled(false);
            }
        } else {
            nEGFeedBackReasonCheckBox2.setVisibility(4);
        }
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.f58962h);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.f58962h);
        int i2 = z ? 0 : this.j;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i2;
        }
        return linearLayout;
    }

    public final View f(List<C1412b> list, boolean z, View view) {
        LinearLayout linearLayout;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.f58956b.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.f58960f, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.a();
        nEGFeedBackReasonCheckBox2.a();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.f58963i.put(nEGFeedBackReasonCheckBox, Boolean.FALSE);
        this.f58963i.put(nEGFeedBackReasonCheckBox2, Boolean.FALSE);
        C1412b c1412b = list.get(0);
        if (c1412b != null) {
            nEGFeedBackReasonCheckBox.setText(c1412b.f58967c);
            nEGFeedBackReasonCheckBox.setTag(c1412b);
        }
        if (list.size() > 1 && list.get(1) != null) {
            C1412b c1412b2 = list.get(1);
            nEGFeedBackReasonCheckBox2.setText(c1412b2.f58967c);
            nEGFeedBackReasonCheckBox2.setVisibility(0);
            nEGFeedBackReasonCheckBox2.setTag(c1412b2);
        } else {
            nEGFeedBackReasonCheckBox2.setVisibility(8);
        }
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.f58962h);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.f58962h);
        int i2 = z ? 0 : this.j;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i2;
        }
        return linearLayout;
    }

    public View g() {
        if (this.f58960f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f58956b.getPageActivity());
            this.f58960f = linearLayout;
            linearLayout.setOrientation(1);
        }
        List<List<C1412b>> p = p();
        if (ListUtils.isEmpty(p)) {
            return null;
        }
        int size = p.size();
        HashMap<NEGFeedBackReasonCheckBox, Boolean> hashMap = this.f58963i;
        if (hashMap == null) {
            this.f58963i = new HashMap<>();
        } else {
            hashMap.clear();
        }
        int i2 = 0;
        while (i2 < size) {
            View e2 = e(p.get(i2), i2 == size + (-1), this.f58960f.getChildAt(i2));
            if (e2 != null && e2.getParent() == null) {
                this.f58960f.addView(e2);
            }
            i2++;
        }
        if (this.f58960f.getChildCount() > size) {
            LinearLayout linearLayout2 = this.f58960f;
            linearLayout2.removeViews(size, linearLayout2.getChildCount() - size);
        }
        return this.f58960f;
    }

    public View h() {
        if (this.f58960f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f58956b.getPageActivity());
            this.f58960f = linearLayout;
            linearLayout.setOrientation(1);
        }
        List<List<C1412b>> s = s();
        if (ListUtils.isEmpty(s)) {
            return null;
        }
        int size = s.size();
        HashMap<NEGFeedBackReasonCheckBox, Boolean> hashMap = this.f58963i;
        if (hashMap == null) {
            this.f58963i = new HashMap<>();
        } else {
            hashMap.clear();
        }
        int i2 = 0;
        while (i2 < size) {
            View f2 = f(s.get(i2), i2 == size + (-1), this.f58960f.getChildAt(i2));
            if (f2 != null && f2.getParent() == null) {
                this.f58960f.addView(f2);
            }
            i2++;
        }
        if (this.f58960f.getChildCount() > size) {
            LinearLayout linearLayout2 = this.f58960f;
            linearLayout2.removeViews(size, linearLayout2.getChildCount() - size);
        }
        return this.f58960f;
    }

    public void i(boolean z) {
        this.l = z;
    }

    public void j(v0 v0Var) {
        if (v0Var == null) {
            return;
        }
        this.f58957c = v0Var.b();
        this.f58958d = v0Var.f53823g;
    }

    public void k(String[] strArr) {
        this.f58959e = strArr;
    }

    public void l(int i2) {
        this.m = i2;
    }

    public void m(boolean z) {
        this.f58955a = z;
    }

    public void n(boolean z) {
        this.k = z;
    }

    public void o(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f58961g = onCheckedChangeListener;
    }

    public final List<List<C1412b>> p() {
        SparseArray<String> sparseArray = this.f58957c;
        if (sparseArray != null && sparseArray.size() != 0) {
            int size = this.f58957c.size();
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (i2 < size) {
                int i3 = i2 + 1;
                int i4 = i2 + 2;
                ArrayList arrayList2 = new ArrayList();
                C1412b c1412b = new C1412b(this, i2, this.f58957c.keyAt(i2), this.f58957c.valueAt(i2));
                SparseArray<String> sparseArray2 = this.f58958d;
                if (sparseArray2 != null && !StringUtils.isNull(sparseArray2.get(this.f58957c.keyAt(i2)))) {
                    c1412b.f58968d = this.f58958d.get(this.f58957c.keyAt(i2));
                }
                arrayList2.add(c1412b);
                if (i3 > i2 && i3 < size) {
                    C1412b c1412b2 = new C1412b(this, i3, this.f58957c.keyAt(i3), this.f58957c.valueAt(i3));
                    SparseArray<String> sparseArray3 = this.f58958d;
                    if (sparseArray3 != null && !StringUtils.isNull(sparseArray3.get(this.f58957c.keyAt(i2)))) {
                        c1412b2.f58968d = this.f58958d.get(this.f58957c.keyAt(i3));
                    }
                    arrayList2.add(c1412b2);
                }
                arrayList.add(arrayList2);
                i2 = i4;
            }
            return arrayList;
        }
        return q();
    }

    public final List<List<C1412b>> q() {
        String[] strArr = this.f58959e;
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.f58959e.length; i2 += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.f58959e[i2])) {
                arrayList2.add(new C1412b(this, i2, i2 + 1, this.f58959e[i2]));
            }
            int i3 = i2 + 1;
            String[] strArr2 = this.f58959e;
            if (i3 < strArr2.length && !StringUtils.isNull(strArr2[i3])) {
                arrayList2.add(new C1412b(this, i3, i2 + 2, this.f58959e[i3]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    public final List<List<C1412b>> r() {
        String[] strArr = this.f58959e;
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.f58959e.length; i2 += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.f58959e[i2])) {
                arrayList2.add(new C1412b(this, i2, 0, this.f58959e[i2]));
            }
            int i3 = i2 + 1;
            String[] strArr2 = this.f58959e;
            if (i3 < strArr2.length && !StringUtils.isNull(strArr2[i3])) {
                arrayList2.add(new C1412b(this, i3, 0, this.f58959e[i3]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    public final List<List<C1412b>> s() {
        int i2;
        int i3;
        SparseArray<String> sparseArray = this.f58957c;
        if (sparseArray != null && sparseArray.size() != 0) {
            int size = this.f58957c.size();
            int i4 = 0;
            int i5 = -1;
            int i6 = this.f58955a ? 0 : -1;
            int i7 = this.f58955a ? size - 1 : size;
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
                C1412b c1412b = new C1412b(this, i4, this.f58957c.keyAt(i4), this.f58957c.valueAt(i4));
                SparseArray<String> sparseArray2 = this.f58958d;
                if (sparseArray2 != null && !StringUtils.isNull(sparseArray2.get(this.f58957c.keyAt(i4)))) {
                    c1412b.f58968d = this.f58958d.get(this.f58957c.keyAt(i4));
                }
                arrayList2.add(c1412b);
                if (i3 > i4 && i3 < size) {
                    C1412b c1412b2 = new C1412b(this, i3, this.f58957c.keyAt(i3), this.f58957c.valueAt(i3));
                    SparseArray<String> sparseArray3 = this.f58958d;
                    if (sparseArray3 != null && !StringUtils.isNull(sparseArray3.get(this.f58957c.keyAt(i4)))) {
                        c1412b2.f58968d = this.f58958d.get(this.f58957c.keyAt(i3));
                    }
                    arrayList2.add(c1412b2);
                }
                arrayList.add(arrayList2);
                i4 = i2;
            }
            return arrayList;
        }
        return r();
    }
}
