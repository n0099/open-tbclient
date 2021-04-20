package d.b.i0.h;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRuleEditActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
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
public class i {
    public d.b.i0.h.h B;
    public UserData C;
    public int F;
    public ClickableSpan G;

    /* renamed from: a  reason: collision with root package name */
    public Context f56416a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f56417b;

    /* renamed from: f  reason: collision with root package name */
    public int f56421f;

    /* renamed from: g  reason: collision with root package name */
    public int f56422g;

    /* renamed from: h  reason: collision with root package name */
    public int f56423h;
    public PopupWindow j;
    public View k;
    public d.b.i0.h.b l;
    public boolean m;
    public int n;
    public ViewGroup p;
    public EMTextView q;
    public EMTextView r;
    public EMTextView s;
    public EMTextView t;
    public EMTextView u;
    public LinearLayout v;
    public String w;
    public g x;
    public h y;

    /* renamed from: c  reason: collision with root package name */
    public v0 f56418c = null;

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<String> f56419d = null;

    /* renamed from: e  reason: collision with root package name */
    public List<b.C1314b> f56420e = new ArrayList();
    public NEGFeedBackView.b i = null;
    public PopupWindow o = null;
    public d.b.h0.r.f0.a z = null;
    public int A = 3;
    public boolean D = true;
    public boolean E = false;
    public CompoundButton.OnCheckedChangeListener H = new a();
    public PopupWindow.OnDismissListener I = new b();
    public CustomMessageListener J = new c(2001304);

    /* loaded from: classes4.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (i.this.i != null) {
                i.this.i.onCheckedChanged(i.this.f56418c, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.C1314b) {
                b.C1314b c1314b = (b.C1314b) compoundButton.getTag();
                if (z) {
                    if (i.this.f56420e.contains(c1314b)) {
                        return;
                    }
                    i.this.f56420e.add(c1314b);
                    if (!i.this.D || i.this.r == null) {
                        return;
                    }
                    i.this.r.setClickable(true);
                    d.b.h0.r.u.c.d(i.this.r).q(R.color.CAM_X0302);
                    return;
                }
                i.this.f56420e.remove(c1314b);
                if (!i.this.D || i.this.r == null) {
                    return;
                }
                i.this.r.setClickable(false);
                i.this.r.setTextColor(d.b.i0.d3.c.a(SkinManager.getColor(R.color.CAM_X0302), SkinManager.RESOURCE_ALPHA_DISABLE));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements PopupWindow.OnDismissListener {
        public b() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (i.this.j != null) {
                i.this.j.dismiss();
                i.this.j = null;
                MessageManager.getInstance().unRegisterListener(i.this.J);
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
                i.this.s();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (i.this.j != null) {
                i.this.j.dismiss();
                i.this.j = null;
            }
            if (i.this.o != null) {
                i.this.o.dismiss();
                i.this.o = null;
            }
            if (i.this.x != null) {
                i.this.x.onClick();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            JSONObject u = i.this.u();
            if (i.this.w == "3" || i.this.w == "4" || i.this.w == "1") {
                i.this.t();
            } else if (u != null) {
                i.this.E();
                CustomMessage customMessage = new CustomMessage(2016489, i.this.f56417b.getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, u);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends ClickableSpan {
        public f() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumRuleEditActivityConfig(i.this.f56416a, i.this.B.b(), i.this.B.c(), i.this.B.a(), i.this.B.g(), ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_FRS)));
            if (i.this.j != null) {
                i.this.j.dismiss();
                i.this.j = null;
            }
            if (i.this.o != null) {
                i.this.o.dismiss();
                i.this.o = null;
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(SkinManager.getColor(R.color.CAM_X0304));
            textPaint.setUnderlineText(false);
        }
    }

    /* loaded from: classes4.dex */
    public interface g {
        void onClick();
    }

    /* loaded from: classes4.dex */
    public interface h {
        void a(JSONArray jSONArray);
    }

    public i(TbPageContext tbPageContext, View view, d.b.i0.h.h hVar, UserData userData) {
        this.f56416a = null;
        this.f56416a = tbPageContext.getPageActivity();
        this.f56417b = tbPageContext;
        this.k = view;
        this.B = hVar;
        this.C = userData;
        y();
        x();
    }

    public void A(v0 v0Var) {
        if (v0Var == null) {
            return;
        }
        this.f56418c = v0Var;
        SparseArray<String> b2 = v0Var.b();
        this.f56419d = b2;
        if (b2 != null && b2.size() > 8) {
            for (int size = this.f56419d.size() - 1; size >= 8; size--) {
                this.f56419d.removeAt(size);
            }
        }
        this.l.j(v0Var);
    }

    public void B(String[] strArr) {
        this.l.k(strArr);
    }

    public void C(h hVar) {
        this.y = hVar;
    }

    public void D(String str) {
        if (this.f56416a == null) {
            return;
        }
        this.w = str;
        View v = v();
        if (v != null && v.getParent() != null) {
            ((ViewGroup) v.getParent()).removeView(v);
        }
        if (v == null) {
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0205));
        gradientDrawable.setCornerRadius(l.g(this.f56416a, R.dimen.tbds31));
        v.setBackgroundDrawable(gradientDrawable);
        s();
        this.f56421f = w();
        PopupWindow popupWindow = new PopupWindow(v, this.f56422g, this.f56421f);
        this.o = popupWindow;
        popupWindow.setFocusable(true);
        this.o.setTouchable(true);
        this.o.setOnDismissListener(this.I);
        z();
        PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(this.f56416a).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
        this.j = popupWindow2;
        if (Build.VERSION.SDK_INT >= 22) {
            popupWindow2.setAttachedInDecor(false);
        }
        this.j.showAtLocation(this.k, 0, 0, 0);
        this.o.showAtLocation(this.k, 17, 0, 0);
        NEGFeedBackView.b bVar = this.i;
        if (bVar != null) {
            bVar.onNEGFeedbackWindowShow(this.f56418c);
        }
        this.m = true;
        MessageManager.getInstance().registerListener(this.J);
    }

    public final void E() {
        if (this.z == null) {
            this.z = new d.b.h0.r.f0.a(this.f56417b);
        }
        this.z.i(R.string.loading);
        this.z.h(true);
    }

    public final void s() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.A) {
            SkinManager.setViewTextColor(this.s, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColorSelector(this.q, R.color.CAM_X0105);
            if (this.D) {
                this.r.setTextColor(d.b.i0.d3.c.a(SkinManager.getColor(R.color.CAM_X0302), SkinManager.RESOURCE_ALPHA_DISABLE));
                this.r.setClickable(false);
            } else {
                d.b.h0.r.u.c.d(this.r).q(R.color.CAM_X0302);
            }
            SkinManager.setViewTextColor(this.t, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.u, R.color.CAM_X0105, 1);
            this.u.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.pic_popup_guide));
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0205));
            gradientDrawable.setCornerRadius(l.g(this.f56416a, R.dimen.tbds31));
            this.p.setBackgroundDrawable(gradientDrawable);
            this.A = skinType;
        }
    }

    public void t() {
        PopupWindow popupWindow = this.o;
        if (popupWindow != null) {
            popupWindow.dismiss();
            this.o = null;
        }
        PopupWindow popupWindow2 = this.j;
        if (popupWindow2 != null) {
            popupWindow2.dismiss();
            this.j = null;
        }
    }

    public final JSONObject u() {
        JSONObject jSONObject = new JSONObject();
        if (this.f56418c == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        int i = 0;
        if (!ListUtils.isEmpty(this.f56420e)) {
            int i2 = 0;
            while (i < this.f56420e.size()) {
                b.C1314b c1314b = this.f56420e.get(i);
                if (c1314b != null) {
                    jSONArray.put(String.valueOf(c1314b.f56368b));
                    i2 = c1314b.f56367a + 1;
                }
                i++;
            }
            i = i2;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_DELETE_THREAD_REASON).param("obj_source", this.w).param("obj_type", i));
        h hVar = this.y;
        if (hVar != null) {
            hVar.a(jSONArray);
        }
        try {
            jSONObject.put("reason", jSONArray);
            jSONObject.put("thread_ids", this.f56418c.f());
            jSONObject.put("type", this.f56418c.a());
            jSONObject.put("forum_id", this.f56418c.c());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public final View v() {
        Context context = this.f56416a;
        if (context == null) {
            return null;
        }
        if (this.p == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.ueg_new_delete_thread_view, (ViewGroup) null);
            this.p = viewGroup;
            EMTextView eMTextView = (EMTextView) viewGroup.findViewById(R.id.ueg_new_delete_thread_title_view);
            this.s = eMTextView;
            d.b.h0.r.u.c d2 = d.b.h0.r.u.c.d(eMTextView);
            d2.v(R.string.F_X02);
            d2.q(R.color.CAM_X0105);
            EMTextView eMTextView2 = (EMTextView) this.p.findViewById(R.id.ueg_new_delete_thread_describe_view);
            this.t = eMTextView2;
            d.b.h0.r.u.c.d(eMTextView2).u(R.dimen.T_X08);
            EMTextView eMTextView3 = (EMTextView) this.p.findViewById(R.id.ueg_new_delete_thread_cancel_view);
            this.q = eMTextView3;
            eMTextView3.setOnClickListener(new d());
            EMTextView eMTextView4 = (EMTextView) this.p.findViewById(R.id.ueg_new_delete_thread_certain_view);
            this.r = eMTextView4;
            eMTextView4.setOnClickListener(new e());
        }
        this.v = (LinearLayout) this.p.findViewById(R.id.ueg_new_delete_thread_reason_view_container);
        View g2 = this.l.g();
        if (g2 != null && g2.getParent() == null) {
            int g3 = l.g(this.f56416a, R.dimen.M_W_X009);
            g2.setPadding(g3, 0, g3, 0);
            this.v.addView(g2);
        }
        EMTextView eMTextView5 = (EMTextView) this.p.findViewById(R.id.ueg_new_delete_thread_tip_view);
        this.u = eMTextView5;
        eMTextView5.setHighlightColor(SelectorHelper.getResources().getColor(17170445));
        if (this.E) {
            this.u.setVisibility(0);
            if (1 == this.F) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) this.f56416a.getString(R.string.set_forum_rule_tip_manager));
                f fVar = new f();
                this.G = fVar;
                spannableStringBuilder.setSpan(fVar, 13, 17, 18);
                this.u.setText(spannableStringBuilder);
                this.u.setMovementMethod(LinkMovementMethod.getInstance());
            } else {
                this.u.setText(this.f56416a.getString(R.string.set_forum_rule_tip_assist));
            }
        } else {
            this.u.setVisibility(8);
        }
        this.u.setClickable(false);
        this.u.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.pic_popup_guide));
        s();
        return this.p;
    }

    public final int w() {
        ViewGroup viewGroup = this.p;
        if (viewGroup == null) {
            return 0;
        }
        viewGroup.measure(0, 0);
        int measuredHeight = this.p.getMeasuredHeight();
        this.f56423h = measuredHeight;
        return measuredHeight;
    }

    public final void x() {
        this.n = l.g(this.f56416a, R.dimen.M_W_X009);
        this.f56422g = l.k(this.f56416a) - (this.n * 2);
        d.b.i0.h.b bVar = new d.b.i0.h.b(this.f56417b);
        this.l = bVar;
        bVar.o(this.H);
        this.l.n(true);
        if (this.E) {
            this.l.l(5);
        }
    }

    public final void y() {
        UserData userData;
        d.b.i0.h.h hVar = this.B;
        if (hVar != null) {
            if (hVar.e() == 1) {
                this.D = false;
            } else {
                this.D = true;
            }
            if (this.B.d() == 1) {
                this.E = false;
            } else {
                this.E = true;
            }
        }
        if (!this.E || (userData = this.C) == null) {
            return;
        }
        this.F = userData.getIs_manager();
    }

    public final void z() {
        if (this.m && this.f56420e.size() != 0) {
            this.f56420e.clear();
        }
    }
}
