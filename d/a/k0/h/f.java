package d.a.k0.h;

import android.content.Context;
import android.os.Build;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.j0.r.q.v0;
import d.a.k0.h.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f {
    public String A;

    /* renamed from: a  reason: collision with root package name */
    public Context f55428a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f55429b;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f55431d;

    /* renamed from: h  reason: collision with root package name */
    public int f55435h;

    /* renamed from: i  reason: collision with root package name */
    public int f55436i;
    public int j;
    public PopupWindow l;
    public View m;
    public d.a.k0.h.b n;
    public boolean o;
    public int q;
    public LinearLayout r;
    public InterfaceC1350f s;
    public g t;
    public TextView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public View y;
    public View z;

    /* renamed from: c  reason: collision with root package name */
    public PopupWindow f55430c = null;

    /* renamed from: e  reason: collision with root package name */
    public v0 f55432e = null;

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<String> f55433f = null;

    /* renamed from: g  reason: collision with root package name */
    public List<b.C1348b> f55434g = new ArrayList();
    public NEGFeedBackView.b k = null;
    public int p = 3;
    public d.a.j0.r.f0.a B = null;
    public CompoundButton.OnCheckedChangeListener C = new a();
    public PopupWindow.OnDismissListener D = new b();
    public CustomMessageListener E = new c(2001304);

    /* loaded from: classes4.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (f.this.k != null) {
                f.this.k.onCheckedChanged(f.this.f55432e, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.C1348b) {
                b.C1348b c1348b = (b.C1348b) compoundButton.getTag();
                if (z) {
                    if (f.this.f55434g.contains(c1348b)) {
                        return;
                    }
                    f.this.f55434g.add(c1348b);
                    return;
                }
                f.this.f55434g.remove(c1348b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements PopupWindow.OnDismissListener {
        public b() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (f.this.l != null) {
                f.this.l.dismiss();
                f.this.l = null;
                MessageManager.getInstance().unRegisterListener(f.this.E);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                f.this.o();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.l != null) {
                f.this.l.dismiss();
                f.this.l = null;
            }
            if (f.this.f55430c != null) {
                f.this.f55430c.dismiss();
                f.this.f55430c = null;
            }
            if (f.this.s != null) {
                f.this.s.onClick();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            JSONObject r = f.this.r();
            if (f.this.A == "3" || f.this.A == "4" || f.this.A == "1") {
                f.this.q();
            } else if (r != null) {
                f.this.A();
                CustomMessage customMessage = new CustomMessage(2016489, f.this.f55429b.getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, r);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* renamed from: d.a.k0.h.f$f  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1350f {
        void onClick();
    }

    /* loaded from: classes4.dex */
    public interface g {
        void a(JSONArray jSONArray);
    }

    public f(TbPageContext tbPageContext, View view) {
        this.f55428a = null;
        this.f55428a = tbPageContext.getPageActivity();
        this.f55429b = tbPageContext;
        this.m = view;
        u();
    }

    public final void A() {
        if (this.B == null) {
            this.B = new d.a.j0.r.f0.a(this.f55429b);
        }
        this.B.i(R.string.loading);
        this.B.h(true);
    }

    public final void o() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.p) {
            SkinManager.setBackgroundColor(this.f55431d, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.v, R.color.CAM_X0106, 1);
            SkinManager.setViewTextColor(this.u, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundColor(this.y, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.z, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.w, R.color.CAM_X0106, 1);
            SkinManager.setViewTextColor(this.x, R.color.CAM_X0109, 1);
            this.p = skinType;
        }
    }

    public void p() {
        d.a.j0.r.f0.a aVar = this.B;
        if (aVar != null) {
            aVar.h(false);
        }
    }

    public void q() {
        PopupWindow popupWindow = this.f55430c;
        if (popupWindow != null) {
            popupWindow.dismiss();
            this.f55430c = null;
        }
        PopupWindow popupWindow2 = this.l;
        if (popupWindow2 != null) {
            popupWindow2.dismiss();
            this.l = null;
        }
    }

    public final JSONObject r() {
        JSONObject jSONObject = new JSONObject();
        if (this.f55432e == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        int i2 = 0;
        if (!ListUtils.isEmpty(this.f55434g)) {
            int i3 = 0;
            while (i2 < this.f55434g.size()) {
                b.C1348b c1348b = this.f55434g.get(i2);
                if (c1348b != null) {
                    jSONArray.put(String.valueOf(c1348b.f55402b));
                    i3 = c1348b.f55401a + 1;
                }
                i2++;
            }
            i2 = i3;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_DELETE_THREAD_REASON).param("obj_source", this.A).param("obj_type", i2));
        g gVar = this.t;
        if (gVar != null) {
            gVar.a(jSONArray);
        }
        try {
            jSONObject.put("reason", jSONArray);
            jSONObject.put("thread_ids", this.f55432e.f());
            jSONObject.put("type", this.f55432e.a());
            jSONObject.put("forum_id", this.f55432e.c());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public final View s() {
        Context context = this.f55428a;
        if (context == null) {
            return null;
        }
        if (this.f55431d == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
            this.f55431d = viewGroup;
            this.w = (TextView) viewGroup.findViewById(R.id.head_text);
            this.x = (TextView) this.f55431d.findViewById(R.id.sub_head_text);
        }
        View g2 = this.n.g();
        if (g2 != null && g2.getParent() == null) {
            int g3 = l.g(this.f55428a, R.dimen.ds40);
            g2.setPadding(g3, 0, g3, 0);
            this.f55431d.addView(g2);
        }
        if (this.r == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f55428a).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.r = linearLayout;
            this.v = (TextView) linearLayout.findViewById(R.id.dialog_bottom_cancel_button);
            this.u = (TextView) this.r.findViewById(R.id.dialog_bottom_certain_button);
            this.y = this.r.findViewById(R.id.top_line);
            this.z = this.r.findViewById(R.id.middle_line);
            this.f55431d.addView(this.r);
            this.v.setOnClickListener(new d());
            TextView textView = this.u;
            if (textView != null) {
                textView.setOnClickListener(new e());
            }
            o();
        }
        return this.f55431d;
    }

    public final int t() {
        ViewGroup viewGroup = this.f55431d;
        if (viewGroup == null) {
            return 0;
        }
        viewGroup.measure(0, 0);
        int measuredHeight = this.f55431d.getMeasuredHeight() + l.g(this.f55428a, R.dimen.ds12);
        this.j = measuredHeight;
        return measuredHeight;
    }

    public final void u() {
        this.q = l.g(this.f55428a, R.dimen.tbds32);
        this.f55436i = l.k(this.f55428a) - (this.q * 2);
        d.a.k0.h.b bVar = new d.a.k0.h.b(this.f55429b);
        this.n = bVar;
        bVar.o(this.C);
        this.n.n(true);
    }

    public final void v() {
        if (this.o && this.f55434g.size() != 0) {
            this.f55434g.clear();
        }
    }

    public void w(v0 v0Var) {
        if (v0Var == null) {
            return;
        }
        this.f55432e = v0Var;
        SparseArray<String> b2 = v0Var.b();
        this.f55433f = b2;
        if (b2 != null && b2.size() > 8) {
            for (int size = this.f55433f.size() - 1; size >= 8; size--) {
                this.f55433f.removeAt(size);
            }
        }
        this.n.j(v0Var);
    }

    public void x(String[] strArr) {
        this.n.k(strArr);
    }

    public void y(g gVar) {
        this.t = gVar;
    }

    public void z(String str) {
        if (this.f55428a == null) {
            return;
        }
        this.A = str;
        View s = s();
        if (s != null && s.getParent() != null) {
            ((ViewGroup) s.getParent()).removeView(s);
        }
        o();
        this.f55435h = t() - l.g(this.f55428a, R.dimen.ds12);
        PopupWindow popupWindow = new PopupWindow(s, this.f55436i, this.f55435h);
        this.f55430c = popupWindow;
        popupWindow.setFocusable(true);
        this.f55430c.setTouchable(true);
        this.f55430c.setOnDismissListener(this.D);
        v();
        PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(this.f55428a).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
        this.l = popupWindow2;
        if (Build.VERSION.SDK_INT >= 22) {
            popupWindow2.setAttachedInDecor(false);
        }
        this.l.showAtLocation(this.m, 0, 0, 0);
        SkinManager.setBackgroundDrawable(this.f55430c, R.drawable.bg_dailog);
        this.f55430c.showAtLocation(this.m, 17, 0, 0);
        NEGFeedBackView.b bVar = this.k;
        if (bVar != null) {
            bVar.onNEGFeedbackWindowShow(this.f55432e);
        }
        this.o = true;
        this.f55429b.registerListener(this.E);
    }
}
