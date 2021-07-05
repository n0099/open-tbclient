package d.a.r0.s.i;

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
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.FillUsernameCallback;
import com.baidu.sapi2.result.FillUsernameResult;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.r0.r.l.a;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a.InterfaceC1260a A;

    /* renamed from: a  reason: collision with root package name */
    public View f56621a;

    /* renamed from: b  reason: collision with root package name */
    public Dialog f56622b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f56623c;

    /* renamed from: d  reason: collision with root package name */
    public RadioGroup f56624d;

    /* renamed from: e  reason: collision with root package name */
    public RadioGroup f56625e;

    /* renamed from: f  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f56626f;

    /* renamed from: g  reason: collision with root package name */
    public RadioButton f56627g;

    /* renamed from: h  reason: collision with root package name */
    public RadioButton f56628h;

    /* renamed from: i  reason: collision with root package name */
    public RadioButton f56629i;
    public TextView j;
    public Activity k;
    public f l;
    public TextView m;
    public TextView n;
    public ProgressBar o;
    public TextView p;
    public AccountData q;
    public e r;
    public Drawable s;
    public Drawable t;
    public int u;
    public TextView v;
    public View w;
    public View x;
    public View y;
    public boolean z;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f56630e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56630e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f56630e.p();
                this.f56630e.t();
            }
        }
    }

    /* renamed from: d.a.r0.s.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1278b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f56631e;

        public View$OnClickListenerC1278b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56631e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f56631e.B();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f56632e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56632e = bVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                if (compoundButton == this.f56632e.f56627g) {
                    this.f56632e.f56625e.clearCheck();
                    this.f56632e.f56627g.setChecked(true);
                    this.f56632e.f56627g.setCompoundDrawables(this.f56632e.s, null, null, null);
                    this.f56632e.f56628h.setChecked(false);
                    this.f56632e.f56628h.setCompoundDrawables(this.f56632e.t, null, null, null);
                    this.f56632e.f56629i.setChecked(false);
                    this.f56632e.f56629i.setCompoundDrawables(this.f56632e.t, null, null, null);
                } else if (compoundButton == this.f56632e.f56628h) {
                    this.f56632e.f56625e.clearCheck();
                    this.f56632e.f56627g.setChecked(false);
                    this.f56632e.f56627g.setCompoundDrawables(this.f56632e.t, null, null, null);
                    this.f56632e.f56628h.setChecked(true);
                    this.f56632e.f56628h.setCompoundDrawables(this.f56632e.s, null, null, null);
                    this.f56632e.f56629i.setChecked(false);
                    this.f56632e.f56629i.setCompoundDrawables(this.f56632e.t, null, null, null);
                } else if (compoundButton == this.f56632e.f56629i) {
                    this.f56632e.f56624d.clearCheck();
                    this.f56632e.f56627g.setChecked(false);
                    this.f56632e.f56627g.setCompoundDrawables(this.f56632e.t, null, null, null);
                    this.f56632e.f56628h.setChecked(false);
                    this.f56632e.f56628h.setCompoundDrawables(this.f56632e.t, null, null, null);
                    this.f56632e.f56629i.setChecked(true);
                    this.f56632e.f56629i.setCompoundDrawables(this.f56632e.s, null, null, null);
                }
                this.f56632e.f56623c.setText(compoundButton.getText());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends FillUsernameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f56633e;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56633e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.LoginStatusAware
        /* renamed from: a */
        public void onBdussExpired(FillUsernameResult fillUsernameResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fillUsernameResult) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: b */
        public void onFailure(FillUsernameResult fillUsernameResult) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fillUsernameResult) == null) || StringUtils.isNull(fillUsernameResult.getResultMsg())) {
                return;
            }
            this.f56633e.A(fillUsernameResult.getResultMsg());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: c */
        public void onSuccess(FillUsernameResult fillUsernameResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fillUsernameResult) == null) {
                this.f56633e.p();
                l.L(this.f56633e.k, R.string.reset_success);
                SapiAccount session = SapiAccountManager.getInstance().getSession();
                d.a.r0.r.l.a.b().a(session.username, session.bduss, "", null, this.f56633e.A);
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f56633e.o.setVisibility(8);
                this.f56633e.n.setEnabled(true);
                this.f56633e.z = false;
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.f56633e.z = true;
            }
        }

        @Override // com.baidu.sapi2.callback.FillUsernameCallback
        public void onUserHaveUsername(FillUsernameResult fillUsernameResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fillUsernameResult) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface e {
        void a(AccountData accountData);
    }

    /* loaded from: classes9.dex */
    public class f extends BdAsyncTask<String, Integer, Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public View f56634e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f56635f;

        public g(b bVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56635f = bVar;
            this.f56634e = null;
            this.f56634e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f56635f.k.isFinishing()) {
                return;
            }
            InputMethodManager inputMethodManager = (InputMethodManager) this.f56635f.k.getSystemService("input_method");
            try {
                if (this.f56634e != null && inputMethodManager != null) {
                    inputMethodManager.showSoftInput(this.f56634e, 0);
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public b(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56621a = null;
        this.f56622b = null;
        this.f56623c = null;
        this.f56624d = null;
        this.f56625e = null;
        this.f56626f = null;
        this.f56627g = null;
        this.f56628h = null;
        this.f56629i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = 0;
        this.z = false;
        this.k = activity;
        this.s = SkinManager.getDrawable(R.drawable.icon_tips_names_s);
        this.t = SkinManager.getDrawable(R.drawable.icon_tips_names_n);
        int dimensionPixelSize = this.k.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.u = dimensionPixelSize;
        this.s.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        Drawable drawable = this.t;
        int i4 = this.u;
        drawable.setBounds(0, 0, i4, i4);
    }

    public final void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (str == null) {
                this.m.setVisibility(4);
                this.m.setText((CharSequence) null);
                return;
            }
            this.m.setVisibility(0);
            this.m.setText(str);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            String obj = this.f56623c.getText().toString();
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
                SapiAccountManager.getInstance().getAccountService().fillUsername(new d(this), this.q.getBDUSS(), obj);
                return;
            }
            A(this.k.getString(R.string.error_tip_name_cannot_empty));
        }
    }

    public void p() {
        Dialog dialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (dialog = this.f56622b) != null && dialog.isShowing()) {
            d.a.c.e.m.g.a(this.f56622b, this.k);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f56624d.setVisibility(8);
            this.f56624d.clearCheck();
            this.f56625e.setVisibility(8);
            this.f56625e.clearCheck();
            this.f56627g.setVisibility(8);
            this.f56628h.setVisibility(8);
            this.f56629i.setVisibility(8);
            this.f56627g.setChecked(false);
            this.f56628h.setChecked(false);
            this.f56629i.setChecked(false);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SkinManager.setBackgroundResource(this.f56621a, R.drawable.dialog_background);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.v, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.f56623c, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(this.w, R.drawable.bg_search_input);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0301);
            SkinManager.setViewTextColor(this.f56627g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f56628h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f56629i, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.x, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.j, R.drawable.dialog_left_button_selector);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0302);
            SkinManager.setBackgroundColor(this.y, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.n, R.drawable.dialog_right_button_selector);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0302);
            this.f56623c.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            this.f56627g.setCompoundDrawables(this.t, null, null, null);
            this.f56628h.setCompoundDrawables(this.t, null, null, null);
            this.f56629i.setCompoundDrawables(this.t, null, null, null);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            f fVar = this.l;
            if (fVar != null) {
                fVar.cancel();
                this.l = null;
            }
            p();
        }
    }

    public final void t() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (eVar = this.r) == null) {
            return;
        }
        eVar.a(null);
    }

    public void u(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, accountData) == null) {
            this.q = accountData;
        }
    }

    public void v(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) {
            this.r = eVar;
        }
    }

    public void w(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) {
        }
    }

    public void x(a.InterfaceC1260a interfaceC1260a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, interfaceC1260a) == null) {
            this.A = interfaceC1260a;
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            z(0);
        }
    }

    public void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            if (this.f56622b == null) {
                View inflate = LayoutInflater.from(this.k).inflate(R.layout.main_input_username, (ViewGroup) null);
                this.f56621a = inflate;
                this.v = (TextView) inflate.findViewById(R.id.tip_info);
                this.w = this.f56621a.findViewById(R.id.divider_under_account);
                this.x = this.f56621a.findViewById(R.id.divider_under_radiongroup);
                this.y = this.f56621a.findViewById(R.id.divider_with_yes_no_button);
                EditText editText = (EditText) this.f56621a.findViewById(R.id.account);
                this.f56623c = editText;
                editText.setHint(this.k.getString(R.string.hint_tip_input_name));
                TextView textView = (TextView) this.f56621a.findViewById(R.id.back);
                this.j = textView;
                textView.setOnClickListener(new a(this));
                TextView textView2 = (TextView) this.f56621a.findViewById(R.id.confirm);
                this.n = textView2;
                textView2.setOnClickListener(new View$OnClickListenerC1278b(this));
                this.o = (ProgressBar) this.f56621a.findViewById(R.id.confirm_progress);
                this.m = (TextView) this.f56621a.findViewById(R.id.error_info);
                this.f56624d = (RadioGroup) this.f56621a.findViewById(R.id.names_group1);
                this.f56625e = (RadioGroup) this.f56621a.findViewById(R.id.names_group2);
                this.f56627g = (RadioButton) this.f56621a.findViewById(R.id.name1);
                this.f56628h = (RadioButton) this.f56621a.findViewById(R.id.name2);
                this.f56629i = (RadioButton) this.f56621a.findViewById(R.id.name3);
                c cVar = new c(this);
                this.f56626f = cVar;
                this.f56627g.setOnCheckedChangeListener(cVar);
                this.f56628h.setOnCheckedChangeListener(this.f56626f);
                this.f56629i.setOnCheckedChangeListener(this.f56626f);
                this.p = (TextView) this.f56621a.findViewById(R.id.phone_info);
                q();
                Dialog dialog = new Dialog(this.k, R.style.input_username_dialog);
                this.f56622b = dialog;
                dialog.setCanceledOnTouchOutside(false);
                this.f56622b.setCancelable(false);
                this.f56622b.setCanceledOnTouchOutside(false);
                r();
            }
            if (i2 == 1) {
                this.p.setText(R.string.tip_init_user_name);
            } else {
                this.p.setText(R.string.bar_friend);
            }
            if (this.f56622b.isShowing()) {
                return;
            }
            this.f56623c.setText((CharSequence) null);
            q();
            A(null);
            if (this.k.isFinishing()) {
                return;
            }
            this.f56622b.setContentView(this.f56621a);
            d.a.c.e.m.g.i(this.f56622b, this.k);
            Activity activity = this.k;
            if (activity instanceof BaseActivity) {
                ((BaseActivity) activity).ShowSoftKeyPadDelay(this.f56623c, 150);
            } else {
                new Handler().postDelayed(new g(this, this.f56623c), 150L);
            }
        }
    }
}
