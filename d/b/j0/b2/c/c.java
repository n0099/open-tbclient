package d.b.j0.b2.c;

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
/* loaded from: classes3.dex */
public class c implements d.b.j0.b2.c.a, View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public LoginDialogActivity f53774e;

    /* renamed from: f  reason: collision with root package name */
    public View f53775f;

    /* renamed from: g  reason: collision with root package name */
    public View f53776g;

    /* renamed from: h  reason: collision with root package name */
    public View f53777h;
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

    /* loaded from: classes3.dex */
    public class a extends WebAuthListener {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            c.this.f53774e.showToast(String.format(c.this.f53774e.getString(R.string.share_login_fail), Integer.valueOf(webAuthResult.getResultCode()), webAuthResult.getResultMsg()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            c.this.f53774e.passLoginSucc();
            c.this.f53774e.addLoginSuccessLog(DialogLoginHelper.DIALOG_TYPE_SHARE);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends WebAuthListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SocialType f53779e;

        public b(SocialType socialType) {
            this.f53779e = socialType;
        }

        @Override // com.baidu.sapi2.shell.listener.WebAuthListener
        public void beforeSuccess(SapiAccount sapiAccount) {
            c.this.f53774e.showLoading();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            c.this.f53774e.closeLoadingDialog();
            c.this.f53774e.showToast(String.format(c.this.f53774e.getString(R.string.third_login_fail), Integer.valueOf(webAuthResult.getResultCode()), webAuthResult.getResultMsg()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            c.this.f53774e.passLoginSucc();
            c.this.f53774e.addLoginSuccessLog(this.f53779e.name().toLowerCase());
        }
    }

    public c(@NonNull String str) {
        this.u = (ShareStorage.StorageModel) new Gson().fromJson(str, (Class<Object>) ShareStorage.StorageModel.class);
    }

    @Override // d.b.j0.b2.c.a
    public void a(LoginDialogActivity loginDialogActivity, ViewGroup viewGroup) {
        this.f53774e = loginDialogActivity;
        View inflate = LayoutInflater.from(loginDialogActivity).inflate(R.layout.share_login_dialog_activity_layout, viewGroup, true);
        this.f53775f = inflate.findViewById(R.id.dialog_background);
        this.f53776g = inflate.findViewById(R.id.dialog_layout);
        this.f53777h = inflate.findViewById(R.id.close_btn_layout);
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
        this.f53775f.setOnClickListener(this);
        this.f53777h.setOnClickListener(this);
        this.i.setOnClickListener(this);
        this.f53776g.setOnClickListener(this);
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
        this.f53774e.finish();
    }

    public final void d() {
        ShareStorage.StorageModel storageModel = this.u;
        if (storageModel == null) {
            return;
        }
        this.m.W(storageModel.url, 10, false);
        this.n.setText(this.u.displayname);
        this.o.setText(this.f53774e.getResources().getString(R.string.share_login_dialog_subtitle, this.u.app));
    }

    public final void e() {
        if (this.u != null) {
            PassportSDK.getInstance().invokeV2ShareLogin(this.f53774e, new a(), this.u);
        }
    }

    public final void f() {
        this.f53774e.finish();
        new LoginActivityConfig((Context) this.f53774e, true).start();
    }

    @Override // d.b.j0.b2.c.a
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

    @Override // d.b.j0.b2.c.a
    public void onViewChangeSkinType(int i) {
        SkinManager.setBackgroundResource(this.f53776g, R.drawable.nav_bg_corner_shape, i);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.icon_pure_close12_n_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        d.b.i0.r.u.c d2 = d.b.i0.r.u.c.d(this.j);
        d2.q(R.color.CAM_X0105);
        d2.u(R.dimen.T_X05);
        d2.v(R.string.F_X02);
        d.b.i0.r.u.c d3 = d.b.i0.r.u.c.d(this.k);
        d3.q(R.color.CAM_X0108);
        d3.u(R.dimen.T_X08);
        d3.v(R.string.F_X01);
        d.b.i0.r.u.c d4 = d.b.i0.r.u.c.d(this.l);
        d4.k(R.string.J_X05);
        d4.f(R.color.CAM_X0204);
        d.b.i0.r.u.c d5 = d.b.i0.r.u.c.d(this.n);
        d5.q(R.color.CAM_X0105);
        d5.u(R.dimen.T_X05);
        d5.v(R.string.F_X02);
        d.b.i0.r.u.c d6 = d.b.i0.r.u.c.d(this.o);
        d6.q(R.color.CAM_X0108);
        d6.u(R.dimen.T_X08);
        d6.v(R.string.F_X01);
        d.b.i0.r.u.c d7 = d.b.i0.r.u.c.d(this.p);
        d7.q(R.color.CAM_X0101);
        d7.u(R.dimen.T_X05);
        d7.v(R.string.F_X01);
        d7.k(R.string.J_X01);
        d7.f(R.color.CAM_X0302);
    }
}
