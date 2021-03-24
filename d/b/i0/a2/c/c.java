package d.b.i0.a2.c;

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
public class c implements d.b.i0.a2.c.a, View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public LoginDialogActivity f51932e;

    /* renamed from: f  reason: collision with root package name */
    public View f51933f;

    /* renamed from: g  reason: collision with root package name */
    public View f51934g;

    /* renamed from: h  reason: collision with root package name */
    public View f51935h;
    public ImageView i;
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
    public final ShareStorage.StorageModel u;

    /* loaded from: classes4.dex */
    public class a extends WebAuthListener {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            c.this.f51932e.showToast(String.format(c.this.f51932e.getString(R.string.share_login_fail), Integer.valueOf(webAuthResult.getResultCode()), webAuthResult.getResultMsg()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            c.this.f51932e.passLoginSucc();
            c.this.f51932e.addLoginSuccessLog(DialogLoginHelper.DIALOG_TYPE_SHARE);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends WebAuthListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SocialType f51937e;

        public b(SocialType socialType) {
            this.f51937e = socialType;
        }

        @Override // com.baidu.sapi2.shell.listener.WebAuthListener
        public void beforeSuccess(SapiAccount sapiAccount) {
            c.this.f51932e.showLoading();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            c.this.f51932e.closeLoadingDialog();
            c.this.f51932e.showToast(String.format(c.this.f51932e.getString(R.string.third_login_fail), Integer.valueOf(webAuthResult.getResultCode()), webAuthResult.getResultMsg()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            c.this.f51932e.passLoginSucc();
            c.this.f51932e.addLoginSuccessLog(this.f51937e.name().toLowerCase());
        }
    }

    public c(@NonNull String str) {
        this.u = (ShareStorage.StorageModel) new Gson().fromJson(str, (Class<Object>) ShareStorage.StorageModel.class);
    }

    @Override // d.b.i0.a2.c.a
    public void a(LoginDialogActivity loginDialogActivity, ViewGroup viewGroup) {
        this.f51932e = loginDialogActivity;
        View inflate = LayoutInflater.from(loginDialogActivity).inflate(R.layout.share_login_dialog_activity_layout, viewGroup, true);
        this.f51933f = inflate.findViewById(R.id.dialog_background);
        this.f51934g = inflate.findViewById(R.id.dialog_layout);
        this.f51935h = inflate.findViewById(R.id.close_btn_layout);
        this.i = (ImageView) inflate.findViewById(R.id.close_btn_view);
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
        this.t = inflate.findViewById(R.id.more_login_btn);
        this.f51933f.setOnClickListener(this);
        this.f51935h.setOnClickListener(this);
        this.i.setOnClickListener(this);
        this.f51934g.setOnClickListener(this);
        this.m.setIsRound(true);
        this.m.setDefaultBgResource(R.drawable.icon_default_avatar100_bg);
        this.p.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.t.setOnClickListener(this);
        d();
    }

    public final void c() {
        this.f51932e.finish();
    }

    public final void d() {
        ShareStorage.StorageModel storageModel = this.u;
        if (storageModel == null) {
            return;
        }
        this.m.W(storageModel.url, 10, false);
        this.n.setText(this.u.displayname);
        this.o.setText(this.f51932e.getResources().getString(R.string.share_login_dialog_subtitle, this.u.app));
    }

    public final void e() {
        if (this.u != null) {
            PassportSDK.getInstance().invokeV2ShareLogin(this.f51932e, new a(), this.u);
        }
    }

    public final void f() {
        this.f51932e.finish();
        new LoginActivityConfig((Context) this.f51932e, true).start();
    }

    @Override // d.b.i0.a2.c.a
    public Intent getResultIntent() {
        return null;
    }

    public final void h() {
        i(SocialType.QQ_SSO);
    }

    public final void i(SocialType socialType) {
        PassportSDK.getInstance().loadThirdPartyLogin(new b(socialType), socialType);
    }

    public final void j() {
        i(SocialType.WEIXIN);
    }

    public final void k() {
        i(SocialType.SINA_WEIBO_SSO);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.dialog_background && id != R.id.close_btn_layout && id != R.id.close_btn_view) {
            if (id == R.id.login_btn) {
                e();
                return;
            } else if (id == R.id.qq_login_btn) {
                h();
                return;
            } else if (id == R.id.wechat_login_btn) {
                j();
                return;
            } else if (id == R.id.weibo_login_btn) {
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

    @Override // d.b.i0.a2.c.a
    public void onViewChangeSkinType(int i) {
        SkinManager.setBackgroundResource(this.f51934g, R.drawable.nav_bg_corner_shape, i);
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
        a4.h(R.string.J_X05);
        a4.c(R.color.CAM_X0204);
        d.b.h0.r.u.c a5 = d.b.h0.r.u.c.a(this.n);
        a5.n(R.color.CAM_X0105);
        a5.r(R.dimen.T_X05);
        a5.s(R.string.F_X02);
        d.b.h0.r.u.c a6 = d.b.h0.r.u.c.a(this.o);
        a6.n(R.color.CAM_X0108);
        a6.r(R.dimen.T_X08);
        a6.s(R.string.F_X01);
        d.b.h0.r.u.c a7 = d.b.h0.r.u.c.a(this.p);
        a7.n(R.color.CAM_X0101);
        a7.r(R.dimen.T_X05);
        a7.s(R.string.F_X01);
        a7.h(R.string.J_X01);
        a7.c(R.color.CAM_X0302);
    }
}
