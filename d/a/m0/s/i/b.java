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
    public a.InterfaceC1141a A;
    public Activity k;
    public Drawable s;
    public Drawable t;
    public int u;
    public TextView v;
    public View w;
    public View x;
    public View y;

    /* renamed from: a  reason: collision with root package name */
    public View f50696a = null;

    /* renamed from: b  reason: collision with root package name */
    public Dialog f50697b = null;

    /* renamed from: c  reason: collision with root package name */
    public EditText f50698c = null;

    /* renamed from: d  reason: collision with root package name */
    public RadioGroup f50699d = null;

    /* renamed from: e  reason: collision with root package name */
    public RadioGroup f50700e = null;

    /* renamed from: f  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f50701f = null;

    /* renamed from: g  reason: collision with root package name */
    public RadioButton f50702g = null;

    /* renamed from: h  reason: collision with root package name */
    public RadioButton f50703h = null;

    /* renamed from: i  reason: collision with root package name */
    public RadioButton f50704i = null;
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
    public class View$OnClickListenerC1159b implements View.OnClickListener {
        public View$OnClickListenerC1159b() {
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
                if (compoundButton == b.this.f50702g) {
                    b.this.f50700e.clearCheck();
                    b.this.f50702g.setChecked(true);
                    b.this.f50702g.setCompoundDrawables(b.this.s, null, null, null);
                    b.this.f50703h.setChecked(false);
                    b.this.f50703h.setCompoundDrawables(b.this.t, null, null, null);
                    b.this.f50704i.setChecked(false);
                    b.this.f50704i.setCompoundDrawables(b.this.t, null, null, null);
                } else if (compoundButton == b.this.f50703h) {
                    b.this.f50700e.clearCheck();
                    b.this.f50702g.setChecked(false);
                    b.this.f50702g.setCompoundDrawables(b.this.t, null, null, null);
                    b.this.f50703h.setChecked(true);
                    b.this.f50703h.setCompoundDrawables(b.this.s, null, null, null);
                    b.this.f50704i.setChecked(false);
                    b.this.f50704i.setCompoundDrawables(b.this.t, null, null, null);
                } else if (compoundButton == b.this.f50704i) {
                    b.this.f50699d.clearCheck();
                    b.this.f50702g.setChecked(false);
                    b.this.f50702g.setCompoundDrawables(b.this.t, null, null, null);
                    b.this.f50703h.setChecked(false);
                    b.this.f50703h.setCompoundDrawables(b.this.t, null, null, null);
                    b.this.f50704i.setChecked(true);
                    b.this.f50704i.setCompoundDrawables(b.this.s, null, null, null);
                }
                b.this.f50698c.setText(compoundButton.getText());
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
        public View f50709e;

        public g(View view) {
            this.f50709e = null;
            this.f50709e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.k.isFinishing()) {
                return;
            }
            InputMethodManager inputMethodManager = (InputMethodManager) b.this.k.getSystemService("input_method");
            try {
                if (this.f50709e != null && inputMethodManager != null) {
                    inputMethodManager.showSoftInput(this.f50709e, 0);
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
        String obj = this.f50698c.getText().toString();
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
        Dialog dialog = this.f50697b;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        d.a.c.e.m.g.a(this.f50697b, this.k);
    }

    public void q() {
        this.f50699d.setVisibility(8);
        this.f50699d.clearCheck();
        this.f50700e.setVisibility(8);
        this.f50700e.clearCheck();
        this.f50702g.setVisibility(8);
        this.f50703h.setVisibility(8);
        this.f50704i.setVisibility(8);
        this.f50702g.setChecked(false);
        this.f50703h.setChecked(false);
        this.f50704i.setChecked(false);
    }

    public final void r() {
        SkinManager.setBackgroundResource(this.f50696a, R.drawable.dialog_background);
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.v, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.f50698c, R.color.CAM_X0105);
        SkinManager.setBackgroundResource(this.w, R.drawable.bg_search_input);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0301);
        SkinManager.setViewTextColor(this.f50702g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f50703h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f50704i, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(this.x, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.j, R.drawable.dialog_left_button_selector);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0302);
        SkinManager.setBackgroundColor(this.y, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.n, R.drawable.dialog_right_button_selector);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0302);
        this.f50698c.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        this.f50702g.setCompoundDrawables(this.t, null, null, null);
        this.f50703h.setCompoundDrawables(this.t, null, null, null);
        this.f50704i.setCompoundDrawables(this.t, null, null, null);
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

    public void x(a.InterfaceC1141a interfaceC1141a) {
        this.A = interfaceC1141a;
    }

    public void y() {
        z(0);
    }

    public void z(int i2) {
        if (this.f50697b == null) {
            View inflate = LayoutInflater.from(this.k).inflate(R.layout.main_input_username, (ViewGroup) null);
            this.f50696a = inflate;
            this.v = (TextView) inflate.findViewById(R.id.tip_info);
            this.w = this.f50696a.findViewById(R.id.divider_under_account);
            this.x = this.f50696a.findViewById(R.id.divider_under_radiongroup);
            this.y = this.f50696a.findViewById(R.id.divider_with_yes_no_button);
            EditText editText = (EditText) this.f50696a.findViewById(R.id.account);
            this.f50698c = editText;
            editText.setHint(this.k.getString(R.string.hint_tip_input_name));
            TextView textView = (TextView) this.f50696a.findViewById(R.id.back);
            this.j = textView;
            textView.setOnClickListener(new a());
            TextView textView2 = (TextView) this.f50696a.findViewById(R.id.confirm);
            this.n = textView2;
            textView2.setOnClickListener(new View$OnClickListenerC1159b());
            this.o = (ProgressBar) this.f50696a.findViewById(R.id.confirm_progress);
            this.m = (TextView) this.f50696a.findViewById(R.id.error_info);
            this.f50699d = (RadioGroup) this.f50696a.findViewById(R.id.names_group1);
            this.f50700e = (RadioGroup) this.f50696a.findViewById(R.id.names_group2);
            this.f50702g = (RadioButton) this.f50696a.findViewById(R.id.name1);
            this.f50703h = (RadioButton) this.f50696a.findViewById(R.id.name2);
            this.f50704i = (RadioButton) this.f50696a.findViewById(R.id.name3);
            c cVar = new c();
            this.f50701f = cVar;
            this.f50702g.setOnCheckedChangeListener(cVar);
            this.f50703h.setOnCheckedChangeListener(this.f50701f);
            this.f50704i.setOnCheckedChangeListener(this.f50701f);
            this.p = (TextView) this.f50696a.findViewById(R.id.phone_info);
            q();
            Dialog dialog = new Dialog(this.k, R.style.input_username_dialog);
            this.f50697b = dialog;
            dialog.setCanceledOnTouchOutside(false);
            this.f50697b.setCancelable(false);
            this.f50697b.setCanceledOnTouchOutside(false);
            r();
        }
        if (i2 == 1) {
            this.p.setText(R.string.tip_init_user_name);
        } else {
            this.p.setText(R.string.bar_friend);
        }
        if (this.f50697b.isShowing()) {
            return;
        }
        this.f50698c.setText((CharSequence) null);
        q();
        A(null);
        if (this.k.isFinishing()) {
            return;
        }
        this.f50697b.setContentView(this.f50696a);
        d.a.c.e.m.g.i(this.f50697b, this.k);
        Activity activity = this.k;
        if (activity instanceof BaseActivity) {
            ((BaseActivity) activity).ShowSoftKeyPadDelay(this.f50698c, 150);
        } else {
            new Handler().postDelayed(new g(this.f50698c), 150L);
        }
    }
}
