package d.b.i0.h;

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
import d.b.b.e.p.l;
import d.b.h0.r.q.v0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f55046b;

    /* renamed from: e  reason: collision with root package name */
    public String[] f55049e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f55050f;

    /* renamed from: g  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f55051g;
    public HashMap<NEGFeedBackReasonCheckBox, Boolean> i;
    public int j;

    /* renamed from: a  reason: collision with root package name */
    public boolean f55045a = false;

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<String> f55047c = null;

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<String> f55048d = null;
    public boolean k = false;
    public boolean l = true;
    public int m = -1;

    /* renamed from: h  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f55052h = new a();

    /* loaded from: classes4.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Map.Entry entry;
            if (compoundButton == null || b.this.i == null || b.this.i.isEmpty()) {
                return;
            }
            boolean z2 = false;
            if (z && b.this.k) {
                for (Map.Entry entry2 : b.this.i.entrySet()) {
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
                Iterator it = b.this.i.entrySet().iterator();
                while (it.hasNext() && ((entry = (Map.Entry) it.next()) == null || entry.getKey() == null || !(z2 = ((NEGFeedBackReasonCheckBox) entry.getKey()).isChecked()))) {
                }
                if (!z2) {
                    for (Map.Entry entry3 : b.this.i.entrySet()) {
                        if (entry3 != null && entry3.getKey() == compoundButton) {
                            ((NEGFeedBackReasonCheckBox) entry3.getKey()).setChecked(true);
                            entry3.setValue(Boolean.TRUE);
                            return;
                        }
                    }
                }
            }
            if (b.this.f55051g != null) {
                b.this.f55051g.onCheckedChanged(compoundButton, z);
            }
        }
    }

    /* renamed from: d.b.i0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1259b {

        /* renamed from: a  reason: collision with root package name */
        public int f55054a;

        /* renamed from: b  reason: collision with root package name */
        public int f55055b;

        /* renamed from: c  reason: collision with root package name */
        public String f55056c;

        /* renamed from: d  reason: collision with root package name */
        public String f55057d;

        public C1259b(b bVar, int i, int i2, String str) {
            this.f55055b = i2;
            if (str != null && str.contains("%")) {
                String[] split = str.split("%");
                this.f55056c = split[0];
                if (split.length > 1) {
                    this.f55057d = split[1];
                }
            } else {
                this.f55056c = str;
            }
            this.f55054a = i;
        }
    }

    public b(TbPageContext tbPageContext) {
        this.f55046b = tbPageContext;
        this.j = l.g(tbPageContext.getPageActivity(), R.dimen.M_H_X003);
    }

    public final View e(List<C1259b> list, boolean z, View view) {
        LinearLayout linearLayout;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.f55046b.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.f55050f, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.a();
        nEGFeedBackReasonCheckBox2.a();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.i.put(nEGFeedBackReasonCheckBox, Boolean.FALSE);
        this.i.put(nEGFeedBackReasonCheckBox2, Boolean.FALSE);
        C1259b c1259b = list.get(0);
        if (c1259b != null) {
            nEGFeedBackReasonCheckBox.setText(c1259b.f55056c);
            nEGFeedBackReasonCheckBox.setTag(c1259b);
            if (c1259b.f55054a == this.m) {
                nEGFeedBackReasonCheckBox.setEnabled(false);
            }
        }
        if (list.size() > 1 && list.get(1) != null) {
            C1259b c1259b2 = list.get(1);
            nEGFeedBackReasonCheckBox2.setText(c1259b2.f55056c);
            nEGFeedBackReasonCheckBox2.setVisibility(0);
            nEGFeedBackReasonCheckBox2.setTag(c1259b2);
            if (c1259b2.f55054a == this.m) {
                nEGFeedBackReasonCheckBox2.setEnabled(false);
            }
        } else {
            nEGFeedBackReasonCheckBox2.setVisibility(4);
        }
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.f55052h);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.f55052h);
        int i = z ? 0 : this.j;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
        }
        return linearLayout;
    }

    public final View f(List<C1259b> list, boolean z, View view) {
        LinearLayout linearLayout;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.f55046b.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.f55050f, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.a();
        nEGFeedBackReasonCheckBox2.a();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.i.put(nEGFeedBackReasonCheckBox, Boolean.FALSE);
        this.i.put(nEGFeedBackReasonCheckBox2, Boolean.FALSE);
        C1259b c1259b = list.get(0);
        if (c1259b != null) {
            nEGFeedBackReasonCheckBox.setText(c1259b.f55056c);
            nEGFeedBackReasonCheckBox.setTag(c1259b);
        }
        if (list.size() > 1 && list.get(1) != null) {
            C1259b c1259b2 = list.get(1);
            nEGFeedBackReasonCheckBox2.setText(c1259b2.f55056c);
            nEGFeedBackReasonCheckBox2.setVisibility(0);
            nEGFeedBackReasonCheckBox2.setTag(c1259b2);
        } else {
            nEGFeedBackReasonCheckBox2.setVisibility(8);
        }
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.f55052h);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.f55052h);
        int i = z ? 0 : this.j;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
        }
        return linearLayout;
    }

    public View g() {
        if (this.f55050f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f55046b.getPageActivity());
            this.f55050f = linearLayout;
            linearLayout.setOrientation(1);
        }
        List<List<C1259b>> p = p();
        if (ListUtils.isEmpty(p)) {
            return null;
        }
        int size = p.size();
        HashMap<NEGFeedBackReasonCheckBox, Boolean> hashMap = this.i;
        if (hashMap == null) {
            this.i = new HashMap<>();
        } else {
            hashMap.clear();
        }
        int i = 0;
        while (i < size) {
            View e2 = e(p.get(i), i == size + (-1), this.f55050f.getChildAt(i));
            if (e2 != null && e2.getParent() == null) {
                this.f55050f.addView(e2);
            }
            i++;
        }
        if (this.f55050f.getChildCount() > size) {
            LinearLayout linearLayout2 = this.f55050f;
            linearLayout2.removeViews(size, linearLayout2.getChildCount() - size);
        }
        return this.f55050f;
    }

    public View h() {
        if (this.f55050f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f55046b.getPageActivity());
            this.f55050f = linearLayout;
            linearLayout.setOrientation(1);
        }
        List<List<C1259b>> s = s();
        if (ListUtils.isEmpty(s)) {
            return null;
        }
        int size = s.size();
        HashMap<NEGFeedBackReasonCheckBox, Boolean> hashMap = this.i;
        if (hashMap == null) {
            this.i = new HashMap<>();
        } else {
            hashMap.clear();
        }
        int i = 0;
        while (i < size) {
            View f2 = f(s.get(i), i == size + (-1), this.f55050f.getChildAt(i));
            if (f2 != null && f2.getParent() == null) {
                this.f55050f.addView(f2);
            }
            i++;
        }
        if (this.f55050f.getChildCount() > size) {
            LinearLayout linearLayout2 = this.f55050f;
            linearLayout2.removeViews(size, linearLayout2.getChildCount() - size);
        }
        return this.f55050f;
    }

    public void i(boolean z) {
        this.l = z;
    }

    public void j(v0 v0Var) {
        if (v0Var == null) {
            return;
        }
        this.f55047c = v0Var.b();
        this.f55048d = v0Var.f50907g;
    }

    public void k(String[] strArr) {
        this.f55049e = strArr;
    }

    public void l(int i) {
        this.m = i;
    }

    public void m(boolean z) {
        this.f55045a = z;
    }

    public void n(boolean z) {
        this.k = z;
    }

    public void o(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f55051g = onCheckedChangeListener;
    }

    public final List<List<C1259b>> p() {
        SparseArray<String> sparseArray = this.f55047c;
        if (sparseArray != null && sparseArray.size() != 0) {
            int size = this.f55047c.size();
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i < size) {
                int i2 = i + 1;
                int i3 = i + 2;
                ArrayList arrayList2 = new ArrayList();
                C1259b c1259b = new C1259b(this, i, this.f55047c.keyAt(i), this.f55047c.valueAt(i));
                SparseArray<String> sparseArray2 = this.f55048d;
                if (sparseArray2 != null && !StringUtils.isNull(sparseArray2.get(this.f55047c.keyAt(i)))) {
                    c1259b.f55057d = this.f55048d.get(this.f55047c.keyAt(i));
                }
                arrayList2.add(c1259b);
                if (i2 > i && i2 < size) {
                    C1259b c1259b2 = new C1259b(this, i2, this.f55047c.keyAt(i2), this.f55047c.valueAt(i2));
                    SparseArray<String> sparseArray3 = this.f55048d;
                    if (sparseArray3 != null && !StringUtils.isNull(sparseArray3.get(this.f55047c.keyAt(i)))) {
                        c1259b2.f55057d = this.f55048d.get(this.f55047c.keyAt(i2));
                    }
                    arrayList2.add(c1259b2);
                }
                arrayList.add(arrayList2);
                i = i3;
            }
            return arrayList;
        }
        return q();
    }

    public final List<List<C1259b>> q() {
        String[] strArr = this.f55049e;
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f55049e.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.f55049e[i])) {
                arrayList2.add(new C1259b(this, i, i + 1, this.f55049e[i]));
            }
            int i2 = i + 1;
            String[] strArr2 = this.f55049e;
            if (i2 < strArr2.length && !StringUtils.isNull(strArr2[i2])) {
                arrayList2.add(new C1259b(this, i2, i + 2, this.f55049e[i2]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    public final List<List<C1259b>> r() {
        String[] strArr = this.f55049e;
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f55049e.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.f55049e[i])) {
                arrayList2.add(new C1259b(this, i, 0, this.f55049e[i]));
            }
            int i2 = i + 1;
            String[] strArr2 = this.f55049e;
            if (i2 < strArr2.length && !StringUtils.isNull(strArr2[i2])) {
                arrayList2.add(new C1259b(this, i2, 0, this.f55049e[i2]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    public final List<List<C1259b>> s() {
        int i;
        int i2;
        SparseArray<String> sparseArray = this.f55047c;
        if (sparseArray != null && sparseArray.size() != 0) {
            int size = this.f55047c.size();
            int i3 = 0;
            int i4 = -1;
            int i5 = this.f55045a ? 0 : -1;
            int i6 = this.f55045a ? size - 1 : size;
            if (i6 > 1 && i6 % 2 == 1) {
                i4 = i5 + 1;
            }
            ArrayList arrayList = new ArrayList();
            while (i3 < size) {
                if (i3 == i5 || i3 == i4) {
                    i = i3 + 1;
                    i2 = i3;
                } else {
                    i2 = i3 + 1;
                    i = i3 + 2;
                }
                ArrayList arrayList2 = new ArrayList();
                C1259b c1259b = new C1259b(this, i3, this.f55047c.keyAt(i3), this.f55047c.valueAt(i3));
                SparseArray<String> sparseArray2 = this.f55048d;
                if (sparseArray2 != null && !StringUtils.isNull(sparseArray2.get(this.f55047c.keyAt(i3)))) {
                    c1259b.f55057d = this.f55048d.get(this.f55047c.keyAt(i3));
                }
                arrayList2.add(c1259b);
                if (i2 > i3 && i2 < size) {
                    C1259b c1259b2 = new C1259b(this, i2, this.f55047c.keyAt(i2), this.f55047c.valueAt(i2));
                    SparseArray<String> sparseArray3 = this.f55048d;
                    if (sparseArray3 != null && !StringUtils.isNull(sparseArray3.get(this.f55047c.keyAt(i3)))) {
                        c1259b2.f55057d = this.f55048d.get(this.f55047c.keyAt(i2));
                    }
                    arrayList2.add(c1259b2);
                }
                arrayList.add(arrayList2);
                i3 = i;
            }
            return arrayList;
        }
        return r();
    }
}
