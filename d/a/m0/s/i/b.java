package d.a.m0.s.i;

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
import d.a.c.e.p.l;
import d.a.m0.r.l.a;
/* loaded from: classes3.dex */
public class b {
    public a.InterfaceC1197a A;
    public Activity k;
    public Drawable s;
    public Drawable t;
    public int u;
    public TextView v;
    public View w;
    public View x;
    public View y;

    /* renamed from: a  reason: collision with root package name */
    public View f54373a = null;

    /* renamed from: b  reason: collision with root package name */
    public Dialog f54374b = null;

    /* renamed from: c  reason: collision with root package name */
    public EditText f54375c = null;

    /* renamed from: d  reason: collision with root package name */
    public RadioGroup f54376d = null;

    /* renamed from: e  reason: collision with root package name */
    public RadioGroup f54377e = null;

    /* renamed from: f  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f54378f = null;

    /* renamed from: g  reason: collision with root package name */
    public RadioButton f54379g = null;

    /* renamed from: h  reason: collision with root package name */
    public RadioButton f54380h = null;

    /* renamed from: i  reason: collision with root package name */
    public RadioButton f54381i = null;
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

    /* renamed from: d.a.m0.s.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1215b implements View.OnClickListener {
        public View$OnClickListenerC1215b() {
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
                if (compoundButton == b.this.f54379g) {
                    b.this.f54377e.clearCheck();
                    b.this.f54379g.setChecked(true);
                    b.this.f54379g.setCompoundDrawables(b.this.s, null, null, null);
                    b.this.f54380h.setChecked(false);
                    b.this.f54380h.setCompoundDrawables(b.this.t, null, null, null);
                    b.this.f54381i.setChecked(false);
                    b.this.f54381i.setCompoundDrawables(b.this.t, null, null, null);
                } else if (compoundButton == b.this.f54380h) {
                    b.this.f54377e.clearCheck();
                    b.this.f54379g.setChecked(false);
                    b.this.f54379g.setCompoundDrawables(b.this.t, null, null, null);
                    b.this.f54380h.setChecked(true);
                    b.this.f54380h.setCompoundDrawables(b.this.s, null, null, null);
                    b.this.f54381i.setChecked(false);
                    b.this.f54381i.setCompoundDrawables(b.this.t, null, null, null);
                } else if (compoundButton == b.this.f54381i) {
                    b.this.f54376d.clearCheck();
                    b.this.f54379g.setChecked(false);
                    b.this.f54379g.setCompoundDrawables(b.this.t, null, null, null);
                    b.this.f54380h.setChecked(false);
                    b.this.f54380h.setCompoundDrawables(b.this.t, null, null, null);
                    b.this.f54381i.setChecked(true);
                    b.this.f54381i.setCompoundDrawables(b.this.s, null, null, null);
                }
                b.this.f54375c.setText(compoundButton.getText());
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
            l.L(b.this.k, R.string.reset_success);
            SapiAccount session = SapiAccountManager.getInstance().getSession();
            d.a.m0.r.l.a.b().a(session.username, session.bduss, "", null, b.this.A);
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
        public View f54386e;

        public g(View view) {
            this.f54386e = null;
            this.f54386e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.k.isFinishing()) {
                return;
            }
            InputMethodManager inputMethodManager = (InputMethodManager) b.this.k.getSystemService("input_method");
            try {
                if (this.f54386e != null && inputMethodManager != null) {
                    inputMethodManager.showSoftInput(this.f54386e, 0);
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
        int i2 = this.u;
        drawable.setBounds(0, 0, i2, i2);
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
        String obj = this.f54375c.getText().toString();
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
        Dialog dialog = this.f54374b;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        d.a.c.e.m.g.a(this.f54374b, this.k);
    }

    public void q() {
        this.f54376d.setVisibility(8);
        this.f54376d.clearCheck();
        this.f54377e.setVisibility(8);
        this.f54377e.clearCheck();
        this.f54379g.setVisibility(8);
        this.f54380h.setVisibility(8);
        this.f54381i.setVisibility(8);
        this.f54379g.setChecked(false);
        this.f54380h.setChecked(false);
        this.f54381i.setChecked(false);
    }

    public final void r() {
        SkinManager.setBackgroundResource(this.f54373a, R.drawable.dialog_background);
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.v, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.f54375c, R.color.CAM_X0105);
        SkinManager.setBackgroundResource(this.w, R.drawable.bg_search_input);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0301);
        SkinManager.setViewTextColor(this.f54379g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f54380h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f54381i, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(this.x, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.j, R.drawable.dialog_left_button_selector);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0302);
        SkinManager.setBackgroundColor(this.y, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.n, R.drawable.dialog_right_button_selector);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0302);
        this.f54375c.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        this.f54379g.setCompoundDrawables(this.t, null, null, null);
        this.f54380h.setCompoundDrawables(this.t, null, null, null);
        this.f54381i.setCompoundDrawables(this.t, null, null, null);
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

    public void x(a.InterfaceC1197a interfaceC1197a) {
        this.A = interfaceC1197a;
    }

    public void y() {
        z(0);
    }

    public void z(int i2) {
        if (this.f54374b == null) {
            View inflate = LayoutInflater.from(this.k).inflate(R.layout.main_input_username, (ViewGroup) null);
            this.f54373a = inflate;
            this.v = (TextView) inflate.findViewById(R.id.tip_info);
            this.w = this.f54373a.findViewById(R.id.divider_under_account);
            this.x = this.f54373a.findViewById(R.id.divider_under_radiongroup);
            this.y = this.f54373a.findViewById(R.id.divider_with_yes_no_button);
            EditText editText = (EditText) this.f54373a.findViewById(R.id.account);
            this.f54375c = editText;
            editText.setHint(this.k.getString(R.string.hint_tip_input_name));
            TextView textView = (TextView) this.f54373a.findViewById(R.id.back);
            this.j = textView;
            textView.setOnClickListener(new a());
            TextView textView2 = (TextView) this.f54373a.findViewById(R.id.confirm);
            this.n = textView2;
            textView2.setOnClickListener(new View$OnClickListenerC1215b());
            this.o = (ProgressBar) this.f54373a.findViewById(R.id.confirm_progress);
            this.m = (TextView) this.f54373a.findViewById(R.id.error_info);
            this.f54376d = (RadioGroup) this.f54373a.findViewById(R.id.names_group1);
            this.f54377e = (RadioGroup) this.f54373a.findViewById(R.id.names_group2);
            this.f54379g = (RadioButton) this.f54373a.findViewById(R.id.name1);
            this.f54380h = (RadioButton) this.f54373a.findViewById(R.id.name2);
            this.f54381i = (RadioButton) this.f54373a.findViewById(R.id.name3);
            c cVar = new c();
            this.f54378f = cVar;
            this.f54379g.setOnCheckedChangeListener(cVar);
            this.f54380h.setOnCheckedChangeListener(this.f54378f);
            this.f54381i.setOnCheckedChangeListener(this.f54378f);
            this.p = (TextView) this.f54373a.findViewById(R.id.phone_info);
            q();
            Dialog dialog = new Dialog(this.k, R.style.input_username_dialog);
            this.f54374b = dialog;
            dialog.setCanceledOnTouchOutside(false);
            this.f54374b.setCancelable(false);
            this.f54374b.setCanceledOnTouchOutside(false);
            r();
        }
        if (i2 == 1) {
            this.p.setText(R.string.tip_init_user_name);
        } else {
            this.p.setText(R.string.bar_friend);
        }
        if (this.f54374b.isShowing()) {
            return;
        }
        this.f54375c.setText((CharSequence) null);
        q();
        A(null);
        if (this.k.isFinishing()) {
            return;
        }
        this.f54374b.setContentView(this.f54373a);
        d.a.c.e.m.g.i(this.f54374b, this.k);
        Activity activity = this.k;
        if (activity instanceof BaseActivity) {
            ((BaseActivity) activity).ShowSoftKeyPadDelay(this.f54375c, 150);
        } else {
            new Handler().postDelayed(new g(this.f54375c), 150L);
        }
    }
}
