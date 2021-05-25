package d.a.n0.c2.c;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.passaccount.app.LoginDialogActivity;
import com.google.gson.Gson;
/* loaded from: classes4.dex */
public class c implements d.a.n0.c2.c.a, View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public LoginDialogActivity f52383e;

    /* renamed from: f  reason: collision with root package name */
    public View f52384f;

    /* renamed from: g  reason: collision with root package name */
    public View f52385g;

    /* renamed from: h  reason: collision with root package name */
    public View f52386h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f52387i;
    public TextView j;
    public TextView k;
    public View l;
    public TbImageView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public View q;
    public View r;
    public View s;
    public View t;
    public View u;
    public final ShareStorage.StorageModel v;

    /* loaded from: classes4.dex */
    public class a extends WebAuthListener {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            c.this.f52383e.showToast(String.format(c.this.f52383e.getString(R.string.share_login_fail), Integer.valueOf(webAuthResult.getResultCode()), webAuthResult.getResultMsg()));
            c.this.f52383e.passLoginFail();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            c.this.f52383e.passLoginSucc();
            c.this.f52383e.addLoginSuccessLog(DialogLoginHelper.DIALOG_TYPE_SHARE);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends WebAuthListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SocialType f52389e;

        public b(SocialType socialType) {
            this.f52389e = socialType;
        }

        @Override // com.baidu.sapi2.shell.listener.WebAuthListener
        public void beforeSuccess(SapiAccount sapiAccount) {
            c.this.f52383e.showLoading();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            c.this.f52383e.closeLoadingDialog();
            c.this.f52383e.showToast(String.format(c.this.f52383e.getString(R.string.third_login_fail), Integer.valueOf(webAuthResult.getResultCode()), webAuthResult.getResultMsg()));
            c.this.f52383e.passLoginFail();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            c.this.f52383e.passLoginSucc();
            c.this.f52383e.addLoginSuccessLog(this.f52389e.name().toLowerCase());
        }
    }

    public c(@NonNull String str) {
        this.v = (ShareStorage.StorageModel) new Gson().fromJson(str, (Class<Object>) ShareStorage.StorageModel.class);
    }

    @Override // d.a.n0.c2.c.a
    public void a(LoginDialogActivity loginDialogActivity, ViewGroup viewGroup) {
        this.f52383e = loginDialogActivity;
        View inflate = LayoutInflater.from(loginDialogActivity).inflate(R.layout.share_login_dialog_activity_layout, viewGroup, true);
        this.f52384f = inflate.findViewById(R.id.dialog_background);
        this.f52385g = inflate.findViewById(R.id.dialog_layout);
        this.f52386h = inflate.findViewById(R.id.close_btn_layout);
        this.f52387i = (ImageView) inflate.findViewById(R.id.close_btn_view);
        this.j = (TextView) inflate.findViewById(R.id.dialog_title);
        this.k = (TextView) inflate.findViewById(R.id.dialog_subtitle);
        this.l = inflate.findViewById(R.id.user_info_layout);
        this.m = (TbImageView) inflate.findViewById(R.id.user_avatar);
        this.n = (TextView) inflate.findViewById(R.id.user_name);
        this.o = (TextView) inflate.findViewById(R.id.user_subtitle);
        this.p = (TextView) inflate.findViewById(R.id.login_btn);
        this.q = inflate.findViewById(R.id.qq_login_btn);
        this.r = inflate.findViewById(R.id.wechat_login_btn);
        this.s = inflate.findViewById(R.id.weibo_login_btn);
        this.t = inflate.findViewById(R.id.yy_login_btn);
        this.u = inflate.findViewById(R.id.more_login_btn);
        this.f52384f.setOnClickListener(this);
        this.f52386h.setOnClickListener(this);
        this.f52387i.setOnClickListener(this);
        this.f52385g.setOnClickListener(this);
        this.m.setIsRound(true);
        this.m.setDefaultBgResource(R.drawable.icon_default_avatar100_bg);
        this.p.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.u.setOnClickListener(this);
        d();
    }

    public final void c() {
        this.f52383e.passLoginCancel();
        this.f52383e.finish();
    }

    public final void d() {
        ShareStorage.StorageModel storageModel = this.v;
        if (storageModel == null) {
            return;
        }
        this.m.V(storageModel.url, 10, false);
        this.n.setText(this.v.displayname);
        this.o.setText(this.f52383e.getResources().getString(R.string.share_login_dialog_subtitle, this.v.app));
    }

    public final void e() {
        if (this.v != null) {
            PassportSDK.getInstance().invokeV2ShareLogin(this.f52383e, new a(), this.v);
        }
    }

    public final void f() {
        this.f52383e.finish();
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.f52383e, true);
        loginActivityConfig.setLoginListener(this.f52383e.getLoginListener());
        loginActivityConfig.start();
    }

    public final void g() {
        h(SocialType.QQ_SSO);
    }

    @Override // d.a.n0.c2.c.a
    public Intent getResultIntent() {
        return null;
    }

    public final void h(SocialType socialType) {
        PassportSDK.getInstance().loadThirdPartyLogin(new b(socialType), socialType);
    }

    public final void i() {
        h(SocialType.WEIXIN);
    }

    public final void j() {
        h(SocialType.SINA_WEIBO_SSO);
    }

    public final void k() {
        h(SocialType.YY);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.dialog_background && id != R.id.close_btn_layout && id != R.id.close_btn_view) {
            if (id == R.id.login_btn) {
                e();
                return;
            } else if (id == R.id.qq_login_btn) {
                g();
                return;
            } else if (id == R.id.wechat_login_btn) {
                i();
                return;
            } else if (id == R.id.weibo_login_btn) {
                j();
                return;
            } else if (id == R.id.yy_login_btn) {
                k();
                return;
            } else if (id == R.id.more_login_btn) {
                f();
                return;
            } else {
                return;
            }
        }
        c();
    }

    @Override // d.a.n0.c2.c.a
    public void onViewChangeSkinType(int i2) {
        SkinManager.setBackgroundResource(this.f52385g, R.drawable.nav_bg_corner_shape, i2);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f52387i, R.drawable.icon_pure_close12_n_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        d.a.m0.r.u.c d2 = d.a.m0.r.u.c.d(this.j);
        d2.s(R.color.CAM_X0105);
        d2.w(R.dimen.T_X05);
        d2.x(R.string.F_X02);
        d.a.m0.r.u.c d3 = d.a.m0.r.u.c.d(this.k);
        d3.s(R.color.CAM_X0108);
        d3.w(R.dimen.T_X08);
        d3.x(R.string.F_X01);
        d.a.m0.r.u.c d4 = d.a.m0.r.u.c.d(this.l);
        d4.m(R.string.J_X05);
        d4.f(R.color.CAM_X0204);
        d.a.m0.r.u.c d5 = d.a.m0.r.u.c.d(this.n);
        d5.s(R.color.CAM_X0105);
        d5.w(R.dimen.T_X05);
        d5.x(R.string.F_X02);
        d.a.m0.r.u.c d6 = d.a.m0.r.u.c.d(this.o);
        d6.s(R.color.CAM_X0108);
        d6.w(R.dimen.T_X08);
        d6.x(R.string.F_X01);
        d.a.m0.r.u.c d7 = d.a.m0.r.u.c.d(this.p);
        d7.s(R.color.CAM_X0101);
        d7.w(R.dimen.T_X05);
        d7.x(R.string.F_X01);
        d7.m(R.string.J_X01);
        d7.f(R.color.CAM_X0302);
    }
}
