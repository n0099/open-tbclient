package d.b.i0.h;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.h0.r.q.v0;
import d.b.i0.h.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public static String G;

    /* renamed from: a  reason: collision with root package name */
    public Context f56371a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f56372b;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f56374d;

    /* renamed from: h  reason: collision with root package name */
    public int f56378h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public PopupWindow q;
    public View r;
    public TextView s;
    public TBSpecificationBtn t;
    public d.b.h0.r.f0.m.b u;
    public d.b.i0.h.b v;
    public boolean w;
    public NEGFeedBackView y;

    /* renamed from: c  reason: collision with root package name */
    public PopupWindow f56373c = null;

    /* renamed from: e  reason: collision with root package name */
    public v0 f56375e = null;

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<String> f56376f = null;

    /* renamed from: g  reason: collision with root package name */
    public List<b.C1314b> f56377g = new ArrayList();
    public NEGFeedBackView.b p = null;
    public int x = 3;
    public boolean z = true;
    public boolean A = false;
    public CompoundButton.OnCheckedChangeListener B = new a();
    public Runnable C = new b();
    public View.OnClickListener D = new View$OnClickListenerC1315c();
    public PopupWindow.OnDismissListener E = new d();
    public CustomMessageListener F = new e(2016524);

    /* loaded from: classes4.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (c.this.p != null) {
                c.this.p.onCheckedChanged(c.this.f56375e, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.C1314b) {
                b.C1314b c1314b = (b.C1314b) compoundButton.getTag();
                if (z) {
                    if (!c.this.f56377g.contains(c1314b)) {
                        c.this.f56377g.add(c1314b);
                    }
                } else {
                    c.this.f56377g.remove(c1314b);
                }
            }
            if (c.this.y == null || ListUtils.isEmpty(c.this.f56377g)) {
                return;
            }
            c.this.y.removeCallbacks(c.this.C);
            c.this.y.postDelayed(c.this.C, 500L);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.s();
        }
    }

    /* renamed from: d.b.i0.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1315c implements View.OnClickListener {
        public View$OnClickListenerC1315c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.s();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements PopupWindow.OnDismissListener {
        public d() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.y != null) {
                c.this.y.setACRotateAnimation();
                c.this.y.removeCallbacks(c.this.C);
                c.this.y = null;
            }
            if (c.this.q != null) {
                c.this.q.dismiss();
                c.this.q = null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.l();
        }
    }

    public c(TbPageContext tbPageContext, View view) {
        this.f56371a = null;
        this.f56371a = tbPageContext.getPageActivity();
        this.f56372b = tbPageContext;
        this.r = view;
        q();
    }

    public void A(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return;
        }
        CustomMessageListener customMessageListener = this.F;
        if (customMessageListener != null) {
            customMessageListener.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.F);
    }

    public void B(View view) {
        SparseArray<String> sparseArray;
        if (this.f56371a == null) {
            return;
        }
        if (this.A || !((sparseArray = this.f56376f) == null || sparseArray.size() == 0)) {
            NEGFeedBackView nEGFeedBackView = (NEGFeedBackView) view;
            this.y = nEGFeedBackView;
            nEGFeedBackView.setCWRotateAnimation();
            View m = m();
            this.i = l.k(this.f56371a) - (this.l * 2);
            int p = p();
            this.f56378h = p;
            int[] iArr = new int[2];
            boolean j = j(this.f56371a, this.r, p, this.i, this.k, this.m, iArr);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0204));
            gradientDrawable.setCornerRadius(l.g(this.f56371a, R.dimen.tbds31));
            m.setBackgroundDrawable(gradientDrawable);
            PopupWindow popupWindow = new PopupWindow(m, this.i, p());
            this.f56373c = popupWindow;
            popupWindow.setFocusable(true);
            this.f56373c.setTouchable(true);
            this.f56373c.setOnDismissListener(this.E);
            t();
            PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(this.f56371a).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            this.q = popupWindow2;
            if (Build.VERSION.SDK_INT >= 22) {
                popupWindow2.setAttachedInDecor(false);
            }
            this.q.showAtLocation(this.r, 0, 0, 0);
            if (iArr[0] == 0 && iArr[1] == 0) {
                return;
            }
            this.f56373c.setBackgroundDrawable(new ColorDrawable(0));
            if (j) {
                this.f56373c.setAnimationStyle(R.style.scale_rb2lt_anim);
            } else {
                this.f56373c.setAnimationStyle(R.style.scale_rt2lb_anim);
            }
            this.f56373c.showAtLocation(this.r, 0, iArr[0] - this.l, iArr[1]);
            NEGFeedBackView.b bVar = this.p;
            if (bVar != null) {
                bVar.onNEGFeedbackWindowShow(this.f56375e);
            }
            this.w = true;
        }
    }

    public void C(boolean z) {
        this.A = z;
    }

    public final void D() {
        int size = this.f56377g.size();
        if (size > 0) {
            String string = this.f56371a.getResources().getString(R.string.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302)));
            TextView textView = this.s;
            if (textView != null) {
                textView.setText(spannableString);
            }
            TBSpecificationBtn tBSpecificationBtn = this.t;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.setText(this.f56371a.getResources().getString(R.string.confirm));
                return;
            }
            return;
        }
        if (this.s != null) {
            if (!k.isEmpty(G)) {
                this.s.setText(G);
            } else {
                this.s.setText(this.f56371a.getResources().getString(R.string.tell_us_reason));
            }
        }
        TBSpecificationBtn tBSpecificationBtn2 = this.t;
        if (tBSpecificationBtn2 != null) {
            tBSpecificationBtn2.setText(this.f56371a.getResources().getString(R.string.not_interested));
        }
    }

    public final boolean j(Context context, View view, int i, int i2, int i3, int i4, int[] iArr) {
        if (context == null || view == null || iArr == null || iArr.length != 2) {
            return false;
        }
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int height = view.getHeight();
        int i5 = l.i(context);
        int k = l.k(context);
        boolean z = ((i5 - iArr2[1]) - height) - i3 < i;
        iArr[0] = k - i2;
        if (z) {
            iArr[1] = (iArr2[1] - i) - i4;
            iArr[1] = Math.max(UtilHelper.getStatusBarHeight(), iArr[1]);
        } else {
            iArr[1] = iArr2[1] + height + i4;
        }
        return z;
    }

    public final void k() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.x) {
            SkinManager.setViewTextColor(this.s, R.color.CAM_X0105, 1);
            this.x = skinType;
        }
    }

    public void l() {
        PopupWindow popupWindow = this.f56373c;
        if (popupWindow != null) {
            popupWindow.dismiss();
            this.f56373c = null;
        }
        PopupWindow popupWindow2 = this.q;
        if (popupWindow2 != null) {
            popupWindow2.dismiss();
            this.q = null;
        }
    }

    public final View m() {
        Context context = this.f56371a;
        if (context == null) {
            return null;
        }
        if (this.f56374d == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.neg_feedback_popupwindow, (ViewGroup) null);
            this.f56374d = viewGroup;
            this.s = (TextView) viewGroup.findViewById(R.id.head_text);
            if (!k.isEmpty(G)) {
                this.s.setText(G);
            }
            this.t = (TBSpecificationBtn) this.f56374d.findViewById(R.id.uninterested_btn);
            d.b.h0.r.f0.m.b bVar = new d.b.h0.r.f0.m.b();
            this.u = bVar;
            bVar.q(R.color.CAM_X0304);
            this.t.setConfig(this.u);
            this.t.setOnClickListener(this.D);
            this.t.setText(this.f56371a.getResources().getString(R.string.not_interested));
            this.t.setTextSize(R.dimen.T_X08);
            ViewGroup viewGroup2 = this.f56374d;
            int i = this.n;
            viewGroup2.setPadding(i, 0, i, this.A ? 0 : this.o);
        }
        k();
        View h2 = this.v.h();
        if (h2 != null && h2.getParent() == null) {
            this.f56374d.addView(h2);
        }
        return this.f56374d;
    }

    public final String n() {
        if (ListUtils.isEmpty(this.f56377g)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (b.C1314b c1314b : this.f56377g) {
            if (c1314b != null) {
                if (sb.length() != 0) {
                    sb.append(",");
                }
                sb.append(c1314b.f56369c);
            }
        }
        return sb.toString();
    }

    public final JSONObject o(ArrayList<Integer> arrayList) {
        JSONObject jSONObject = new JSONObject();
        if (this.f56375e == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (!ListUtils.isEmpty(this.f56377g)) {
            for (b.C1314b c1314b : this.f56377g) {
                if (c1314b != null) {
                    arrayList.add(Integer.valueOf(c1314b.f56368b));
                    if (sb.length() != 0) {
                        sb.append(",");
                    }
                    sb.append(String.valueOf(c1314b.f56368b));
                    if (sb2.length() != 0) {
                        sb2.append(",");
                    }
                    sb2.append(c1314b.f56370d);
                }
            }
        }
        try {
            jSONObject.put("tid", this.f56375e.e());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.f56375e.c());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.f56375e.h())) {
                jSONObject.put("type", this.f56375e.h());
            }
            if (this.f56375e.g() != 0) {
                jSONObject.put("topic_id", this.f56375e.g());
            }
            jSONObject.put("extra", sb2.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public final int p() {
        ViewGroup viewGroup = this.f56374d;
        if (viewGroup == null) {
            return 0;
        }
        viewGroup.measure(0, 0);
        int measuredHeight = this.f56374d.getMeasuredHeight();
        this.j = measuredHeight;
        return measuredHeight;
    }

    public final void q() {
        this.l = l.g(this.f56371a, R.dimen.M_W_X004);
        this.m = l.g(this.f56371a, R.dimen.tbds14);
        this.n = l.g(this.f56371a, R.dimen.M_W_X005);
        this.o = l.g(this.f56371a, R.dimen.M_H_X007);
        this.i = l.k(this.f56371a) - (this.l * 2);
        this.k = l.g(this.f56371a, R.dimen.tbds160);
        d.b.i0.h.b bVar = new d.b.i0.h.b(this.f56372b);
        this.v = bVar;
        bVar.n(true);
        this.v.i(false);
        this.v.o(this.B);
        this.f56372b.registerListener(this.F);
    }

    public void r() {
        MessageManager.getInstance().unRegisterListener(this.F);
        l();
    }

    public final void s() {
        if (this.f56375e == null || this.f56373c == null) {
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        JSONObject o = o(arrayList);
        if (this.z) {
            if (!StringUtils.isNull(this.f56375e.h())) {
                CustomMessage customMessage = new CustomMessage(2921324, this.f56372b.getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921324, o);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            } else {
                CustomMessage customMessage2 = new CustomMessage(2016488, this.f56372b.getUniqueId());
                CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2016488, o);
                customResponsedMessage2.setOrginalMessage(customMessage2);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
            }
        }
        l();
        d.b.h0.r.f0.c cVar = new d.b.h0.r.f0.c();
        cVar.f50891a = 1500L;
        String string = this.f56371a.getResources().getString(R.string.reduce_related_thread_recommend);
        if (o != null && "7".equals(o.optString("dislike_ids"))) {
            string = this.f56371a.getResources().getString(R.string.forbidden_forum_success);
        }
        cVar.c(string);
        NEGFeedBackView.b bVar = this.p;
        if (bVar != null) {
            bVar.onNEGFeedbackConfirm(arrayList, n(), this.f56375e);
        }
    }

    public final void t() {
        if (this.w && this.f56377g.size() != 0) {
            this.f56377g.clear();
            D();
        }
    }

    public void u(boolean z) {
        this.z = z;
    }

    public void v(v0 v0Var) {
        if (v0Var == null) {
            return;
        }
        this.f56375e = v0Var;
        SparseArray<String> b2 = v0Var.b();
        this.f56376f = b2;
        if (b2 != null && b2.size() > 9) {
            for (int size = this.f56376f.size() - 1; size >= 9; size--) {
                this.f56376f.removeAt(size);
            }
        }
        this.v.j(v0Var);
    }

    public void w(String[] strArr) {
        this.v.k(strArr);
    }

    public void x(NEGFeedBackView.b bVar) {
        this.p = bVar;
    }

    public void y(boolean z) {
        this.v.m(z);
    }

    public void z(String str) {
        if (k.isEmpty(str)) {
            return;
        }
        G = str;
    }
}
