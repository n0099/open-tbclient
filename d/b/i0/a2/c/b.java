package d.b.i0.a2.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.common.security.MD5Util;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.tieba.passaccount.app.LoginDialogActivity;
/* loaded from: classes3.dex */
public class b implements d.b.i0.a2.c.a, View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public LoginDialogActivity f51928e;

    /* renamed from: f  reason: collision with root package name */
    public View f51929f;

    /* renamed from: g  reason: collision with root package name */
    public View f51930g;

    /* renamed from: h  reason: collision with root package name */
    public View f51931h;
    public ImageView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public int u;
    public String v;
    public String w;

    /* loaded from: classes3.dex */
    public class a extends OneKeyLoginCallback {
        public a() {
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onFail(OneKeyLoginResult oneKeyLoginResult) {
            b.this.f51928e.closeLoadingDialog();
            b.this.f51928e.showToast(String.format(b.this.f51928e.getString(R.string.onekey_login_fail), Integer.valueOf(oneKeyLoginResult.getResultCode()), oneKeyLoginResult.getResultMsg()));
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onGuideProcess(OneKeyLoginResult oneKeyLoginResult) {
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onSuccess(OneKeyLoginResult oneKeyLoginResult) {
            b.this.f51928e.passLoginSucc();
            b.this.f51928e.addLoginSuccessLog(DialogLoginHelper.DIALOG_TYPE_ONE_KEY);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0023, code lost:
        if (r5.equals(com.baidu.sapi2.outsdk.OneKeyLoginSdkCall.OPERATOR_TYPE_CUCC) == false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b(String str, String str2, String str3) {
        char c2 = 0;
        this.u = 0;
        this.v = str;
        this.w = str3;
        int hashCode = str2.hashCode();
        if (hashCode == 2154) {
            if (str2.equals(OneKeyLoginSdkCall.OPERATOR_TYPE_CMCC)) {
                c2 = 2;
            }
            c2 = 65535;
        } else if (hashCode != 2161) {
            if (hashCode == 2162) {
            }
            c2 = 65535;
        } else {
            if (str2.equals(OneKeyLoginSdkCall.OPERATOR_TYPE_CTCC)) {
                c2 = 1;
            }
            c2 = 65535;
        }
        if (c2 == 0) {
            this.u = 1;
        } else if (c2 != 1) {
            this.u = 3;
        } else {
            this.u = 2;
        }
    }

    public static String i(Activity activity, String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 7) {
            return null;
        }
        String substring = str.substring(0, 8);
        String substring2 = str.substring(8, str.length());
        String upperCase = SapiUtils.getClientId(activity).toUpperCase();
        return substring + MD5Util.toMd5((substring2 + MD5Util.toMd5(upperCase.getBytes(), false)).getBytes(), false);
    }

    @Override // d.b.i0.a2.c.a
    public void a(LoginDialogActivity loginDialogActivity, ViewGroup viewGroup) {
        this.f51928e = loginDialogActivity;
        View inflate = LayoutInflater.from(loginDialogActivity).inflate(R.layout.onekey_login_dialog_activity_layout, viewGroup, true);
        this.f51929f = inflate.findViewById(R.id.dialog_background);
        this.f51930g = inflate.findViewById(R.id.dialog_layout);
        this.f51931h = inflate.findViewById(R.id.close_btn_layout);
        this.i = (ImageView) inflate.findViewById(R.id.close_btn_view);
        this.j = (TextView) inflate.findViewById(R.id.dialog_title);
        this.k = (TextView) inflate.findViewById(R.id.dialog_subtitle);
        this.l = (TextView) inflate.findViewById(R.id.user_number);
        this.m = (TextView) inflate.findViewById(R.id.login_btn);
        this.n = (TextView) inflate.findViewById(R.id.other_login_btn);
        this.o = (TextView) inflate.findViewById(R.id.tip_1);
        this.p = (TextView) inflate.findViewById(R.id.operator_text);
        this.q = (TextView) inflate.findViewById(R.id.tip_2);
        this.r = (TextView) inflate.findViewById(R.id.agreement_text);
        this.s = (TextView) inflate.findViewById(R.id.tip_3);
        this.t = (TextView) inflate.findViewById(R.id.privacy_text);
        this.f51929f.setOnClickListener(this);
        this.f51931h.setOnClickListener(this);
        this.i.setOnClickListener(this);
        this.f51930g.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.t.setOnClickListener(this);
        e();
    }

    public final void c() {
        LoginDialogActivity loginDialogActivity = this.f51928e;
        new TbWebViewActivityConfig(loginDialogActivity, loginDialogActivity.getResources().getString(R.string.onekey_login_dialog_activity_agreement_text), "https://passport.baidu.com/static/passpc-account/html/protocal.html", false).start();
    }

    public final void d() {
        this.f51928e.finish();
    }

    public final void e() {
        this.l.setText(this.v);
        f(this.u);
    }

    public final void f(int i) {
        if (i == 1) {
            this.p.setText(R.string.onekey_login_dialog_activity_operator_1);
        } else if (i == 2) {
            this.p.setText(R.string.onekey_login_dialog_activity_operator_2);
        } else if (i != 3) {
        } else {
            this.p.setText(R.string.onekey_login_dialog_activity_operator_3);
        }
    }

    @Override // d.b.i0.a2.c.a
    public Intent getResultIntent() {
        return null;
    }

    public final void h() {
        this.f51928e.showLoading();
        PassportSDK passportSDK = PassportSDK.getInstance();
        LoginDialogActivity loginDialogActivity = this.f51928e;
        passportSDK.loadOneKeyLogin(loginDialogActivity, i(loginDialogActivity, this.w), new a());
    }

    public final void j() {
        int i = this.u;
        if (i == 1) {
            LoginDialogActivity loginDialogActivity = this.f51928e;
            new TbWebViewActivityConfig(loginDialogActivity, loginDialogActivity.getResources().getString(R.string.onekey_login_dialog_activity_operator_1), "https://ms.zzx9.cn/html/oauth/protocol2.html", false).start();
        } else if (i == 2) {
            LoginDialogActivity loginDialogActivity2 = this.f51928e;
            new TbWebViewActivityConfig(loginDialogActivity2, loginDialogActivity2.getResources().getString(R.string.onekey_login_dialog_activity_operator_2), "https://e.189.cn/sdk/agreement/detail.do?hidetop=true", false).start();
        } else if (i != 3) {
        } else {
            LoginDialogActivity loginDialogActivity3 = this.f51928e;
            new TbWebViewActivityConfig(loginDialogActivity3, loginDialogActivity3.getResources().getString(R.string.onekey_login_dialog_activity_operator_3), "https://wap.cmpassport.com/resources/html/contract.html", false).start();
        }
    }

    public final void k() {
        this.f51928e.finish();
        new LoginActivityConfig((Context) this.f51928e, true).start();
    }

    public final void l() {
        LoginDialogActivity loginDialogActivity = this.f51928e;
        new TbWebViewActivityConfig(loginDialogActivity, loginDialogActivity.getResources().getString(R.string.onekey_login_dialog_activity_privacy_text), "http://privacy.baidu.com/mdetail?id=288", false).start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.dialog_background && id != R.id.close_btn_layout && id != R.id.close_btn_view) {
            if (id == R.id.login_btn) {
                h();
                return;
            } else if (id == R.id.operator_text) {
                j();
                return;
            } else if (id == R.id.agreement_text) {
                c();
                return;
            } else if (id == R.id.privacy_text) {
                l();
                return;
            } else if (id == R.id.other_login_btn) {
                k();
                return;
            } else {
                return;
            }
        }
        d();
    }

    @Override // d.b.i0.a2.c.a
    public void onViewChangeSkinType(int i) {
        SkinManager.setBackgroundResource(this.f51930g, R.drawable.nav_bg_corner_shape, i);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.icon_pure_close12_n_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        d.b.h0.r.u.c a2 = d.b.h0.r.u.c.a(this.j);
        a2.n(R.color.CAM_X0105);
        a2.r(R.dimen.T_X05);
        a2.s(R.string.F_X02);
        d.b.h0.r.u.c a3 = d.b.h0.r.u.c.a(this.k);
        a3.n(R.color.CAM_X0108);
        a3.r(R.dimen.T_X08);
        a3.s(R.string.F_X01);
        d.b.h0.r.u.c a4 = d.b.h0.r.u.c.a(this.l);
        a4.n(R.color.CAM_X0105);
        a4.r(R.dimen.T_X03);
        a4.s(R.string.F_X02);
        d.b.h0.r.u.c a5 = d.b.h0.r.u.c.a(this.n);
        a5.n(R.color.CAM_X0107);
        a5.r(R.dimen.T_X07);
        a5.s(R.string.F_X01);
        d.b.h0.r.u.c a6 = d.b.h0.r.u.c.a(this.m);
        a6.n(R.color.CAM_X0101);
        a6.r(R.dimen.T_X05);
        a6.s(R.string.F_X01);
        a6.h(R.string.J_X01);
        a6.c(R.color.CAM_X0302);
        d.b.h0.r.u.c a7 = d.b.h0.r.u.c.a(this.o);
        a7.n(R.color.CAM_X0108);
        a7.r(R.dimen.tbds29);
        a7.s(R.string.F_X01);
        d.b.h0.r.u.c a8 = d.b.h0.r.u.c.a(this.q);
        a8.n(R.color.CAM_X0108);
        a8.r(R.dimen.tbds29);
        a8.s(R.string.F_X01);
        d.b.h0.r.u.c a9 = d.b.h0.r.u.c.a(this.s);
        a9.n(R.color.CAM_X0108);
        a9.r(R.dimen.tbds29);
        a9.s(R.string.F_X01);
        d.b.h0.r.u.c a10 = d.b.h0.r.u.c.a(this.p);
        a10.n(R.color.CAM_X0302);
        a10.r(R.dimen.tbds29);
        a10.s(R.string.F_X01);
        d.b.h0.r.u.c a11 = d.b.h0.r.u.c.a(this.r);
        a11.n(R.color.CAM_X0302);
        a11.r(R.dimen.tbds29);
        a11.s(R.string.F_X01);
        d.b.h0.r.u.c a12 = d.b.h0.r.u.c.a(this.t);
        a12.n(R.color.CAM_X0302);
        a12.r(R.dimen.tbds29);
        a12.s(R.string.F_X01);
    }
}
