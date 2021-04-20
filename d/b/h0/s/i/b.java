package d.b.h0.s.i;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.FillUsernameCallback;
import com.baidu.sapi2.result.FillUsernameResult;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.h0.r.l.a;
/* loaded from: classes3.dex */
public class b {
    public a.InterfaceC1095a A;
    public Activity k;
    public Drawable s;
    public Drawable t;
    public int u;
    public TextView v;
    public View w;
    public View x;
    public View y;

    /* renamed from: a  reason: collision with root package name */
    public View f51804a = null;

    /* renamed from: b  reason: collision with root package name */
    public Dialog f51805b = null;

    /* renamed from: c  reason: collision with root package name */
    public EditText f51806c = null;

    /* renamed from: d  reason: collision with root package name */
    public RadioGroup f51807d = null;

    /* renamed from: e  reason: collision with root package name */
    public RadioGroup f51808e = null;

    /* renamed from: f  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f51809f = null;

    /* renamed from: g  reason: collision with root package name */
    public RadioButton f51810g = null;

    /* renamed from: h  reason: collision with root package name */
    public RadioButton f51811h = null;
    public RadioButton i = null;
    public TextView j = null;
    public f l = null;
    public TextView m = null;
    public TextView n = null;
    public ProgressBar o = null;
    public TextView p = null;
    public AccountData q = null;
    public e r = null;
    public boolean z = false;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.p();
            b.this.t();
        }
    }

    /* renamed from: d.b.h0.s.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1114b implements View.OnClickListener {
        public View$OnClickListenerC1114b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.B();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements CompoundButton.OnCheckedChangeListener {
        public c() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                if (compoundButton == b.this.f51810g) {
                    b.this.f51808e.clearCheck();
                    b.this.f51810g.setChecked(true);
                    b.this.f51810g.setCompoundDrawables(b.this.s, null, null, null);
                    b.this.f51811h.setChecked(false);
                    b.this.f51811h.setCompoundDrawables(b.this.t, null, null, null);
                    b.this.i.setChecked(false);
                    b.this.i.setCompoundDrawables(b.this.t, null, null, null);
                } else if (compoundButton == b.this.f51811h) {
                    b.this.f51808e.clearCheck();
                    b.this.f51810g.setChecked(false);
                    b.this.f51810g.setCompoundDrawables(b.this.t, null, null, null);
                    b.this.f51811h.setChecked(true);
                    b.this.f51811h.setCompoundDrawables(b.this.s, null, null, null);
                    b.this.i.setChecked(false);
                    b.this.i.setCompoundDrawables(b.this.t, null, null, null);
                } else if (compoundButton == b.this.i) {
                    b.this.f51807d.clearCheck();
                    b.this.f51810g.setChecked(false);
                    b.this.f51810g.setCompoundDrawables(b.this.t, null, null, null);
                    b.this.f51811h.setChecked(false);
                    b.this.f51811h.setCompoundDrawables(b.this.t, null, null, null);
                    b.this.i.setChecked(true);
                    b.this.i.setCompoundDrawables(b.this.s, null, null, null);
                }
                b.this.f51806c.setText(compoundButton.getText());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends FillUsernameCallback {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.LoginStatusAware
        /* renamed from: a */
        public void onBdussExpired(FillUsernameResult fillUsernameResult) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: b */
        public void onFailure(FillUsernameResult fillUsernameResult) {
            if (StringUtils.isNull(fillUsernameResult.getResultMsg())) {
                return;
            }
            b.this.A(fillUsernameResult.getResultMsg());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: c */
        public void onSuccess(FillUsernameResult fillUsernameResult) {
            b.this.p();
            l.K(b.this.k, R.string.reset_success);
            SapiAccount session = SapiAccountManager.getInstance().getSession();
            d.b.h0.r.l.a.b().a(session.username, session.bduss, "", null, b.this.A);
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            b.this.o.setVisibility(8);
            b.this.n.setEnabled(true);
            b.this.z = false;
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            b.this.z = true;
        }

        @Override // com.baidu.sapi2.callback.FillUsernameCallback
        public void onUserHaveUsername(FillUsernameResult fillUsernameResult) {
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a(AccountData accountData);
    }

    /* loaded from: classes3.dex */
    public class f extends BdAsyncTask<String, Integer, Object> {
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public View f51816e;

        public g(View view) {
            this.f51816e = null;
            this.f51816e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.k.isFinishing()) {
                return;
            }
            InputMethodManager inputMethodManager = (InputMethodManager) b.this.k.getSystemService("input_method");
            try {
                if (this.f51816e != null && inputMethodManager != null) {
                    inputMethodManager.showSoftInput(this.f51816e, 0);
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public b(Activity activity) {
        this.k = null;
        this.s = null;
        this.t = null;
        this.u = 0;
        this.k = activity;
        this.s = SkinManager.getDrawable(R.drawable.icon_tips_names_s);
        this.t = SkinManager.getDrawable(R.drawable.icon_tips_names_n);
        int dimensionPixelSize = this.k.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.u = dimensionPixelSize;
        this.s.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        Drawable drawable = this.t;
        int i = this.u;
        drawable.setBounds(0, 0, i, i);
    }

    public final void A(String str) {
        if (str == null) {
            this.m.setVisibility(4);
            this.m.setText((CharSequence) null);
            return;
        }
        this.m.setVisibility(0);
        this.m.setText(str);
    }

    public void B() {
        String obj = this.f51806c.getText().toString();
        if (obj != null && obj.length() > 0) {
            if (UtilHelper.getFixedTextSize(obj) > 14) {
                A(this.k.getString(R.string.input_alias_limit_length_tip));
                return;
            }
            f fVar = this.l;
            if (fVar != null) {
                fVar.cancel();
            }
            if (this.z || this.q == null) {
                return;
            }
            this.o.setVisibility(0);
            this.n.setEnabled(false);
            A(null);
            q();
            SapiAccountManager.getInstance().getAccountService().fillUsername(new d(), this.q.getBDUSS(), obj);
            return;
        }
        A(this.k.getString(R.string.error_tip_name_cannot_empty));
    }

    public void p() {
        Dialog dialog = this.f51805b;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        d.b.c.e.m.g.a(this.f51805b, this.k);
    }

    public void q() {
        this.f51807d.setVisibility(8);
        this.f51807d.clearCheck();
        this.f51808e.setVisibility(8);
        this.f51808e.clearCheck();
        this.f51810g.setVisibility(8);
        this.f51811h.setVisibility(8);
        this.i.setVisibility(8);
        this.f51810g.setChecked(false);
        this.f51811h.setChecked(false);
        this.i.setChecked(false);
    }

    public final void r() {
        SkinManager.setBackgroundResource(this.f51804a, R.drawable.dialog_background);
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.v, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.f51806c, R.color.CAM_X0105);
        SkinManager.setBackgroundResource(this.w, R.drawable.bg_search_input);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0301);
        SkinManager.setViewTextColor(this.f51810g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f51811h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(this.x, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.j, R.drawable.dialog_left_button_selector);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0302);
        SkinManager.setBackgroundColor(this.y, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.n, R.drawable.dialog_right_button_selector);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0302);
        this.f51806c.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        this.f51810g.setCompoundDrawables(this.t, null, null, null);
        this.f51811h.setCompoundDrawables(this.t, null, null, null);
        this.i.setCompoundDrawables(this.t, null, null, null);
    }

    public void s() {
        f fVar = this.l;
        if (fVar != null) {
            fVar.cancel();
            this.l = null;
        }
        p();
    }

    public final void t() {
        e eVar = this.r;
        if (eVar != null) {
            eVar.a(null);
        }
    }

    public void u(AccountData accountData) {
        this.q = accountData;
    }

    public void v(e eVar) {
        this.r = eVar;
    }

    public void w(e eVar) {
    }

    public void x(a.InterfaceC1095a interfaceC1095a) {
        this.A = interfaceC1095a;
    }

    public void y() {
        z(0);
    }

    public void z(int i) {
        if (this.f51805b == null) {
            View inflate = LayoutInflater.from(this.k).inflate(R.layout.main_input_username, (ViewGroup) null);
            this.f51804a = inflate;
            this.v = (TextView) inflate.findViewById(R.id.tip_info);
            this.w = this.f51804a.findViewById(R.id.divider_under_account);
            this.x = this.f51804a.findViewById(R.id.divider_under_radiongroup);
            this.y = this.f51804a.findViewById(R.id.divider_with_yes_no_button);
            EditText editText = (EditText) this.f51804a.findViewById(R.id.account);
            this.f51806c = editText;
            editText.setHint(this.k.getString(R.string.hint_tip_input_name));
            TextView textView = (TextView) this.f51804a.findViewById(R.id.back);
            this.j = textView;
            textView.setOnClickListener(new a());
            TextView textView2 = (TextView) this.f51804a.findViewById(R.id.confirm);
            this.n = textView2;
            textView2.setOnClickListener(new View$OnClickListenerC1114b());
            this.o = (ProgressBar) this.f51804a.findViewById(R.id.confirm_progress);
            this.m = (TextView) this.f51804a.findViewById(R.id.error_info);
            this.f51807d = (RadioGroup) this.f51804a.findViewById(R.id.names_group1);
            this.f51808e = (RadioGroup) this.f51804a.findViewById(R.id.names_group2);
            this.f51810g = (RadioButton) this.f51804a.findViewById(R.id.name1);
            this.f51811h = (RadioButton) this.f51804a.findViewById(R.id.name2);
            this.i = (RadioButton) this.f51804a.findViewById(R.id.name3);
            c cVar = new c();
            this.f51809f = cVar;
            this.f51810g.setOnCheckedChangeListener(cVar);
            this.f51811h.setOnCheckedChangeListener(this.f51809f);
            this.i.setOnCheckedChangeListener(this.f51809f);
            this.p = (TextView) this.f51804a.findViewById(R.id.phone_info);
            q();
            Dialog dialog = new Dialog(this.k, R.style.input_username_dialog);
            this.f51805b = dialog;
            dialog.setCanceledOnTouchOutside(false);
            this.f51805b.setCancelable(false);
            this.f51805b.setCanceledOnTouchOutside(false);
            r();
        }
        if (i == 1) {
            this.p.setText(R.string.tip_init_user_name);
        } else {
            this.p.setText(R.string.bar_friend);
        }
        if (this.f51805b.isShowing()) {
            return;
        }
        this.f51806c.setText((CharSequence) null);
        q();
        A(null);
        if (this.k.isFinishing()) {
            return;
        }
        this.f51805b.setContentView(this.f51804a);
        d.b.c.e.m.g.i(this.f51805b, this.k);
        Activity activity = this.k;
        if (activity instanceof BaseActivity) {
            ((BaseActivity) activity).ShowSoftKeyPadDelay(this.f51806c, 150);
        } else {
            new Handler().postDelayed(new g(this.f51806c), 150L);
        }
    }
}
