package d.b.i0.h;

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
import d.b.c.e.p.l;
import d.b.h0.r.q.v0;
import d.b.i0.h.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f {
    public String A;

    /* renamed from: a  reason: collision with root package name */
    public Context f56393a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f56394b;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f56396d;

    /* renamed from: h  reason: collision with root package name */
    public int f56400h;
    public int i;
    public int j;
    public PopupWindow l;
    public View m;
    public d.b.i0.h.b n;
    public boolean o;
    public int q;
    public LinearLayout r;
    public InterfaceC1316f s;
    public g t;
    public TextView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public View y;
    public View z;

    /* renamed from: c  reason: collision with root package name */
    public PopupWindow f56395c = null;

    /* renamed from: e  reason: collision with root package name */
    public v0 f56397e = null;

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<String> f56398f = null;

    /* renamed from: g  reason: collision with root package name */
    public List<b.C1314b> f56399g = new ArrayList();
    public NEGFeedBackView.b k = null;
    public int p = 3;
    public d.b.h0.r.f0.a B = null;
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
                f.this.k.onCheckedChanged(f.this.f56397e, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.C1314b) {
                b.C1314b c1314b = (b.C1314b) compoundButton.getTag();
                if (z) {
                    if (f.this.f56399g.contains(c1314b)) {
                        return;
                    }
                    f.this.f56399g.add(c1314b);
                    return;
                }
                f.this.f56399g.remove(c1314b);
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
        public c(int i) {
            super(i);
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
            if (f.this.f56395c != null) {
                f.this.f56395c.dismiss();
                f.this.f56395c = null;
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
                CustomMessage customMessage = new CustomMessage(2016489, f.this.f56394b.getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, r);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* renamed from: d.b.i0.h.f$f  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1316f {
        void onClick();
    }

    /* loaded from: classes4.dex */
    public interface g {
        void a(JSONArray jSONArray);
    }

    public f(TbPageContext tbPageContext, View view) {
        this.f56393a = null;
        this.f56393a = tbPageContext.getPageActivity();
        this.f56394b = tbPageContext;
        this.m = view;
        u();
    }

    public final void A() {
        if (this.B == null) {
            this.B = new d.b.h0.r.f0.a(this.f56394b);
        }
        this.B.i(R.string.loading);
        this.B.h(true);
    }

    public final void o() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.p) {
            SkinManager.setBackgroundColor(this.f56396d, R.color.CAM_X0205);
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
        d.b.h0.r.f0.a aVar = this.B;
        if (aVar != null) {
            aVar.h(false);
        }
    }

    public void q() {
        PopupWindow popupWindow = this.f56395c;
        if (popupWindow != null) {
            popupWindow.dismiss();
            this.f56395c = null;
        }
        PopupWindow popupWindow2 = this.l;
        if (popupWindow2 != null) {
            popupWindow2.dismiss();
            this.l = null;
        }
    }

    public final JSONObject r() {
        JSONObject jSONObject = new JSONObject();
        if (this.f56397e == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        int i = 0;
        if (!ListUtils.isEmpty(this.f56399g)) {
            int i2 = 0;
            while (i < this.f56399g.size()) {
                b.C1314b c1314b = this.f56399g.get(i);
                if (c1314b != null) {
                    jSONArray.put(String.valueOf(c1314b.f56368b));
                    i2 = c1314b.f56367a + 1;
                }
                i++;
            }
            i = i2;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_DELETE_THREAD_REASON).param("obj_source", this.A).param("obj_type", i));
        g gVar = this.t;
        if (gVar != null) {
            gVar.a(jSONArray);
        }
        try {
            jSONObject.put("reason", jSONArray);
            jSONObject.put("thread_ids", this.f56397e.f());
            jSONObject.put("type", this.f56397e.a());
            jSONObject.put("forum_id", this.f56397e.c());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public final View s() {
        Context context = this.f56393a;
        if (context == null) {
            return null;
        }
        if (this.f56396d == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
            this.f56396d = viewGroup;
            this.w = (TextView) viewGroup.findViewById(R.id.head_text);
            this.x = (TextView) this.f56396d.findViewById(R.id.sub_head_text);
        }
        View g2 = this.n.g();
        if (g2 != null && g2.getParent() == null) {
            int g3 = l.g(this.f56393a, R.dimen.ds40);
            g2.setPadding(g3, 0, g3, 0);
            this.f56396d.addView(g2);
        }
        if (this.r == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f56393a).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.r = linearLayout;
            this.v = (TextView) linearLayout.findViewById(R.id.dialog_bottom_cancel_button);
            this.u = (TextView) this.r.findViewById(R.id.dialog_bottom_certain_button);
            this.y = this.r.findViewById(R.id.top_line);
            this.z = this.r.findViewById(R.id.middle_line);
            this.f56396d.addView(this.r);
            this.v.setOnClickListener(new d());
            TextView textView = this.u;
            if (textView != null) {
                textView.setOnClickListener(new e());
            }
            o();
        }
        return this.f56396d;
    }

    public final int t() {
        ViewGroup viewGroup = this.f56396d;
        if (viewGroup == null) {
            return 0;
        }
        viewGroup.measure(0, 0);
        int measuredHeight = this.f56396d.getMeasuredHeight() + l.g(this.f56393a, R.dimen.ds12);
        this.j = measuredHeight;
        return measuredHeight;
    }

    public final void u() {
        this.q = l.g(this.f56393a, R.dimen.tbds32);
        this.i = l.k(this.f56393a) - (this.q * 2);
        d.b.i0.h.b bVar = new d.b.i0.h.b(this.f56394b);
        this.n = bVar;
        bVar.o(this.C);
        this.n.n(true);
    }

    public final void v() {
        if (this.o && this.f56399g.size() != 0) {
            this.f56399g.clear();
        }
    }

    public void w(v0 v0Var) {
        if (v0Var == null) {
            return;
        }
        this.f56397e = v0Var;
        SparseArray<String> b2 = v0Var.b();
        this.f56398f = b2;
        if (b2 != null && b2.size() > 8) {
            for (int size = this.f56398f.size() - 1; size >= 8; size--) {
                this.f56398f.removeAt(size);
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
        if (this.f56393a == null) {
            return;
        }
        this.A = str;
        View s = s();
        if (s != null && s.getParent() != null) {
            ((ViewGroup) s.getParent()).removeView(s);
        }
        o();
        this.f56400h = t() - l.g(this.f56393a, R.dimen.ds12);
        PopupWindow popupWindow = new PopupWindow(s, this.i, this.f56400h);
        this.f56395c = popupWindow;
        popupWindow.setFocusable(true);
        this.f56395c.setTouchable(true);
        this.f56395c.setOnDismissListener(this.D);
        v();
        PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(this.f56393a).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
        this.l = popupWindow2;
        if (Build.VERSION.SDK_INT >= 22) {
            popupWindow2.setAttachedInDecor(false);
        }
        this.l.showAtLocation(this.m, 0, 0, 0);
        SkinManager.setBackgroundDrawable(this.f56395c, R.drawable.bg_dailog);
        this.f56395c.showAtLocation(this.m, 17, 0, 0);
        NEGFeedBackView.b bVar = this.k;
        if (bVar != null) {
            bVar.onNEGFeedbackWindowShow(this.f56397e);
        }
        this.o = true;
        this.f56394b.registerListener(this.E);
    }
}
