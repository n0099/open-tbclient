package d.a.o0.h;

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
import d.a.n0.r.q.v0;
import d.a.o0.h.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f {
    public String A;

    /* renamed from: a  reason: collision with root package name */
    public Context f59117a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f59118b;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f59120d;

    /* renamed from: h  reason: collision with root package name */
    public int f59124h;

    /* renamed from: i  reason: collision with root package name */
    public int f59125i;
    public int j;
    public PopupWindow l;
    public View m;
    public d.a.o0.h.b n;
    public boolean o;
    public int q;
    public LinearLayout r;
    public InterfaceC1418f s;
    public g t;
    public TextView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public View y;
    public View z;

    /* renamed from: c  reason: collision with root package name */
    public PopupWindow f59119c = null;

    /* renamed from: e  reason: collision with root package name */
    public v0 f59121e = null;

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<String> f59122f = null;

    /* renamed from: g  reason: collision with root package name */
    public List<b.C1416b> f59123g = new ArrayList();
    public NEGFeedBackView.b k = null;
    public int p = 3;
    public d.a.n0.r.f0.a B = null;
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
                f.this.k.onCheckedChanged(f.this.f59121e, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.C1416b) {
                b.C1416b c1416b = (b.C1416b) compoundButton.getTag();
                if (z) {
                    if (f.this.f59123g.contains(c1416b)) {
                        return;
                    }
                    f.this.f59123g.add(c1416b);
                    return;
                }
                f.this.f59123g.remove(c1416b);
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
            if (f.this.f59119c != null) {
                f.this.f59119c.dismiss();
                f.this.f59119c = null;
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
                CustomMessage customMessage = new CustomMessage(2016489, f.this.f59118b.getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, r);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* renamed from: d.a.o0.h.f$f  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1418f {
        void onClick();
    }

    /* loaded from: classes4.dex */
    public interface g {
        void a(JSONArray jSONArray);
    }

    public f(TbPageContext tbPageContext, View view) {
        this.f59117a = null;
        this.f59117a = tbPageContext.getPageActivity();
        this.f59118b = tbPageContext;
        this.m = view;
        u();
    }

    public final void A() {
        if (this.B == null) {
            this.B = new d.a.n0.r.f0.a(this.f59118b);
        }
        this.B.i(R.string.loading);
        this.B.h(true);
    }

    public final void o() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.p) {
            SkinManager.setBackgroundColor(this.f59120d, R.color.CAM_X0205);
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
        d.a.n0.r.f0.a aVar = this.B;
        if (aVar != null) {
            aVar.h(false);
        }
    }

    public void q() {
        PopupWindow popupWindow = this.f59119c;
        if (popupWindow != null) {
            popupWindow.dismiss();
            this.f59119c = null;
        }
        PopupWindow popupWindow2 = this.l;
        if (popupWindow2 != null) {
            popupWindow2.dismiss();
            this.l = null;
        }
    }

    public final JSONObject r() {
        JSONObject jSONObject = new JSONObject();
        if (this.f59121e == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        int i2 = 0;
        if (!ListUtils.isEmpty(this.f59123g)) {
            int i3 = 0;
            while (i2 < this.f59123g.size()) {
                b.C1416b c1416b = this.f59123g.get(i2);
                if (c1416b != null) {
                    jSONArray.put(String.valueOf(c1416b.f59091b));
                    i3 = c1416b.f59090a + 1;
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
            jSONObject.put("thread_ids", this.f59121e.f());
            jSONObject.put("type", this.f59121e.a());
            jSONObject.put("forum_id", this.f59121e.c());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public final View s() {
        Context context = this.f59117a;
        if (context == null) {
            return null;
        }
        if (this.f59120d == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
            this.f59120d = viewGroup;
            this.w = (TextView) viewGroup.findViewById(R.id.head_text);
            this.x = (TextView) this.f59120d.findViewById(R.id.sub_head_text);
        }
        View g2 = this.n.g();
        if (g2 != null && g2.getParent() == null) {
            int g3 = l.g(this.f59117a, R.dimen.ds40);
            g2.setPadding(g3, 0, g3, 0);
            this.f59120d.addView(g2);
        }
        if (this.r == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f59117a).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.r = linearLayout;
            this.v = (TextView) linearLayout.findViewById(R.id.dialog_bottom_cancel_button);
            this.u = (TextView) this.r.findViewById(R.id.dialog_bottom_certain_button);
            this.y = this.r.findViewById(R.id.top_line);
            this.z = this.r.findViewById(R.id.middle_line);
            this.f59120d.addView(this.r);
            this.v.setOnClickListener(new d());
            TextView textView = this.u;
            if (textView != null) {
                textView.setOnClickListener(new e());
            }
            o();
        }
        return this.f59120d;
    }

    public final int t() {
        ViewGroup viewGroup = this.f59120d;
        if (viewGroup == null) {
            return 0;
        }
        viewGroup.measure(0, 0);
        int measuredHeight = this.f59120d.getMeasuredHeight() + l.g(this.f59117a, R.dimen.ds12);
        this.j = measuredHeight;
        return measuredHeight;
    }

    public final void u() {
        this.q = l.g(this.f59117a, R.dimen.tbds32);
        this.f59125i = l.k(this.f59117a) - (this.q * 2);
        d.a.o0.h.b bVar = new d.a.o0.h.b(this.f59118b);
        this.n = bVar;
        bVar.o(this.C);
        this.n.n(true);
    }

    public final void v() {
        if (this.o && this.f59123g.size() != 0) {
            this.f59123g.clear();
        }
    }

    public void w(v0 v0Var) {
        if (v0Var == null) {
            return;
        }
        this.f59121e = v0Var;
        SparseArray<String> b2 = v0Var.b();
        this.f59122f = b2;
        if (b2 != null && b2.size() > 8) {
            for (int size = this.f59122f.size() - 1; size >= 8; size--) {
                this.f59122f.removeAt(size);
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
        if (this.f59117a == null) {
            return;
        }
        this.A = str;
        View s = s();
        if (s != null && s.getParent() != null) {
            ((ViewGroup) s.getParent()).removeView(s);
        }
        o();
        this.f59124h = t() - l.g(this.f59117a, R.dimen.ds12);
        PopupWindow popupWindow = new PopupWindow(s, this.f59125i, this.f59124h);
        this.f59119c = popupWindow;
        popupWindow.setFocusable(true);
        this.f59119c.setTouchable(true);
        this.f59119c.setOnDismissListener(this.D);
        v();
        PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(this.f59117a).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
        this.l = popupWindow2;
        if (Build.VERSION.SDK_INT >= 22) {
            popupWindow2.setAttachedInDecor(false);
        }
        this.l.showAtLocation(this.m, 0, 0, 0);
        SkinManager.setBackgroundDrawable(this.f59119c, R.drawable.bg_dailog);
        this.f59119c.showAtLocation(this.m, 17, 0, 0);
        NEGFeedBackView.b bVar = this.k;
        if (bVar != null) {
            bVar.onNEGFeedbackWindowShow(this.f59121e);
        }
        this.o = true;
        this.f59118b.registerListener(this.E);
    }
}
