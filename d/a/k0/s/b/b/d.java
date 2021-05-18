package d.a.k0.s.b.b;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.common.util.CommonParam;
import com.baidu.pyramid.annotation.Service;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.AccountRealNameCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.SmsViewLoginCallback;
import com.baidu.sapi2.callback.VerifyUserFaceIDCallback;
import com.baidu.sapi2.dto.FaceIDVerifyDTO;
import com.baidu.sapi2.dto.RealNameDTO;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.result.RealNameFaceIDResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.UnRealNameFaceIDResult;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.sofire.ac.FH;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.tieba.R;
import d.a.i0.a.v2.x;
import d.a.i0.a.z1.b.b.h;
import d.a.i0.b.g;
import d.a.i0.b.j.a0;
import d.a.i0.b.j.b0;
import d.a.i0.b.j.l;
import d.a.i0.b.j.z;
import d.a.i0.b.k.a;
import d.a.i0.b.l.b;
import d.a.i0.b.o.a;
import d.a.i0.t.f;
import java.util.ArrayList;
import java.util.List;
@Service
/* loaded from: classes4.dex */
public class d implements d.a.i0.b.j.c0.a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.i0.a.z1.b.b.c f60672a;

    /* loaded from: classes4.dex */
    public class a extends GetTplStokenCallback {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l.a f60673e;

        public a(d dVar, l.a aVar) {
            this.f60673e = aVar;
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            l.a aVar = this.f60673e;
            if (aVar != null) {
                aVar.onFinish();
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            l.a aVar = this.f60673e;
            if (aVar != null) {
                aVar.onStart();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(GetTplStokenResult getTplStokenResult) {
            if (this.f60673e != null) {
                l lVar = new l();
                if (getTplStokenResult != null) {
                    lVar.f46077b = getTplStokenResult.tplStokenMap;
                    lVar.f46076a = getTplStokenResult.getResultCode();
                    getTplStokenResult.getResultMsg();
                    GetTplStokenResult.FailureType failureType = getTplStokenResult.failureType;
                    if (failureType != null) {
                        failureType.name();
                    }
                }
                this.f60673e.a(lVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetTplStokenResult getTplStokenResult) {
            if (this.f60673e != null) {
                l lVar = new l();
                if (getTplStokenResult != null) {
                    lVar.f46077b = getTplStokenResult.tplStokenMap;
                    lVar.f46076a = getTplStokenResult.getResultCode();
                    getTplStokenResult.getResultMsg();
                    GetTplStokenResult.FailureType failureType = getTplStokenResult.failureType;
                    if (failureType != null) {
                        failureType.name();
                    }
                }
                this.f60673e.b(lVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends SmsViewLoginCallback {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppPhoneLoginDialog.g f60674e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f60675f;

        /* loaded from: classes4.dex */
        public class a implements DialogInterface.OnClickListener {
            public a(b bVar) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
            }
        }

        /* renamed from: d.a.k0.s.b.b.d$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class DialogInterface$OnClickListenerC1596b implements DialogInterface.OnClickListener {

            /* renamed from: d.a.k0.s.b.b.d$b$b$a */
            /* loaded from: classes4.dex */
            public class a implements d.a.i0.a.m.a {
                public a() {
                }

                @Override // d.a.i0.a.m.a
                public void onResult(int i2) {
                    if (i2 == 0) {
                        b.this.f60674e.onSuccess();
                    } else {
                        b.this.f60674e.onFailure();
                    }
                }
            }

            public DialogInterface$OnClickListenerC1596b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                d.a.i0.b.j.a.N((FragmentActivity) b.this.f60675f, false, null, new a());
            }
        }

        /* loaded from: classes4.dex */
        public class c implements d.a.i0.a.m.a {
            public c() {
            }

            @Override // d.a.i0.a.m.a
            public void onResult(int i2) {
                SwanAppPhoneLoginDialog.g gVar = b.this.f60674e;
                if (gVar != null) {
                    if (i2 == 0) {
                        gVar.onSuccess();
                    } else {
                        gVar.onFailure();
                    }
                }
            }
        }

        public b(d dVar, SwanAppPhoneLoginDialog.g gVar, Context context) {
            this.f60674e = gVar;
            this.f60675f = context;
        }

        @Override // com.baidu.sapi2.callback.SmsViewLoginCallback
        public void onCheckCodeViewHide() {
            this.f60674e.b();
        }

        @Override // com.baidu.sapi2.callback.SmsViewLoginCallback
        public void onCheckCodeViewShow() {
            this.f60674e.a();
        }

        @Override // com.baidu.sapi2.callback.SmsViewLoginCallback
        public void onNeedBack(WebAuthResult webAuthResult) {
            Context context = this.f60675f;
            x.a(context, ((FragmentActivity) context).getWindow().getDecorView().getWindowToken());
            String string = this.f60675f.getResources().getString(g.account_login_dialog_needback_other);
            String string2 = this.f60675f.getResources().getString(g.account_login_dialog_needback_positive_btn_login);
            if (webAuthResult.getResultCode() == 12) {
                string = this.f60675f.getResources().getString(g.account_login_dialog_needback_phone);
                string2 = this.f60675f.getResources().getString(g.account_login_dialog_needback_positive_btn_register);
            }
            h.a aVar = new h.a(this.f60675f);
            aVar.V(this.f60675f.getResources().getString(g.account_login_dialog_needback_title));
            aVar.x(string);
            aVar.P(string2, new DialogInterface$OnClickListenerC1596b());
            aVar.C(this.f60675f.getResources().getString(g.account_login_dialog_needback_negative_btn), new a(this));
            aVar.X();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            this.f60674e.onFailure();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            d.a.k0.s.b.b.a.l().x(new c());
        }
    }

    /* loaded from: classes4.dex */
    public class c extends OneKeyLoginCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.b.n.g.e f60679a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f60680b;

        /* loaded from: classes4.dex */
        public class a implements d.a.i0.a.m.a {
            public a() {
            }

            @Override // d.a.i0.a.m.a
            public void onResult(int i2) {
                if (i2 == 0) {
                    c.this.f60679a.onResult(0);
                } else {
                    c.this.f60679a.onResult(-1);
                }
                c cVar = c.this;
                d.this.r(cVar.f60680b);
            }
        }

        public c(d.a.i0.b.n.g.e eVar, Activity activity) {
            this.f60679a = eVar;
            this.f60680b = activity;
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onFail(OneKeyLoginResult oneKeyLoginResult) {
            this.f60679a.onResult(-1);
            d.this.r(this.f60680b);
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onGuideProcess(OneKeyLoginResult oneKeyLoginResult) {
            this.f60679a.onResult(-1);
            d.this.r(this.f60680b);
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onSuccess(OneKeyLoginResult oneKeyLoginResult) {
            d.a.k0.s.b.b.a.l().x(new a());
        }
    }

    /* renamed from: d.a.k0.s.b.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1597d extends VerifyUserFaceIDCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b0 f60683a;

        public C1597d(d dVar, b0 b0Var) {
            this.f60683a = b0Var;
        }

        @Override // com.baidu.sapi2.callback.FaceIDCallback
        public void onFailure(SapiResult sapiResult) {
            this.f60683a.onFailure(sapiResult.getResultMsg());
        }

        @Override // com.baidu.sapi2.callback.FaceIDCallback
        public void onSuccess(SapiResult sapiResult) {
            z zVar = new z();
            if (sapiResult instanceof RealNameFaceIDResult) {
                zVar.f46092a = ((RealNameFaceIDResult) sapiResult).callBackKey;
                this.f60683a.a(zVar);
            } else if (sapiResult instanceof UnRealNameFaceIDResult) {
                zVar.f46092a = ((UnRealNameFaceIDResult) sapiResult).registerResult;
                this.f60683a.a(zVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends AccountRealNameCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b0 f60684a;

        public e(d dVar, b0 b0Var) {
            this.f60684a = b0Var;
        }

        @Override // com.baidu.sapi2.callback.AccountRealNameCallback
        public void onFinish(AccountRealNameResult accountRealNameResult) {
            super.onFinish(accountRealNameResult);
            if (accountRealNameResult.getResultCode() == 0) {
                z zVar = new z();
                if (accountRealNameResult.seniorRealNameSuc) {
                    zVar.f46092a = accountRealNameResult.callbackkey;
                    this.f60684a.a(zVar);
                    return;
                }
            }
            this.f60684a.onFailure(accountRealNameResult.getResultMsg());
        }
    }

    public static String q(Context context) {
        return CommonParam.getCUID(context);
    }

    public static String s(Context context, String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 7) {
            return null;
        }
        String substring = str.substring(0, 8);
        String substring2 = str.substring(8, str.length());
        String upperCase = SapiUtils.getClientId(context).toUpperCase();
        return substring + f.d((substring2 + f.d(upperCase.getBytes(), false)).getBytes(), false);
    }

    @Override // d.a.i0.b.j.c0.a
    public String a(Context context) {
        return d.a.i0.a.k2.g.h.a().getString("bd_box_ptoken", "");
    }

    @Override // d.a.i0.b.j.c0.a
    public String b(Context context) {
        return d.a.k0.s.b.b.a.l().p();
    }

    @Override // d.a.i0.b.j.c0.a
    public void c(Context context, Bundle bundle, d.a.i0.a.m.a aVar) {
        d.a.k0.s.b.b.a.l().t(context, bundle, aVar);
    }

    @Override // d.a.i0.b.j.c0.a
    public a0 d(Context context) {
        a0 a0Var = new a0();
        a0Var.f46072a = d.a.k0.s.b.b.a.l().k();
        a0Var.f46073b = d.a.k0.s.b.b.a.l().i();
        return a0Var;
    }

    @Override // d.a.i0.b.j.c0.a
    public String e(Context context) {
        return FH.gz(AppRuntime.getAppContext());
    }

    @Override // d.a.i0.b.j.c0.a
    public void f(Activity activity, String str, String str2, b0 b0Var) {
        RealNameDTO realNameDTO = new RealNameDTO();
        realNameDTO.bduss = SapiAccountManager.getInstance().getSession().bduss;
        realNameDTO.scene = str;
        realNameDTO.needCbKey = true;
        PassportSDK.getInstance().loadAccountRealName(activity, new e(this, b0Var), realNameDTO);
    }

    @Override // d.a.i0.b.j.c0.a
    public void g(Context context, a.d dVar) {
        d.a.k0.s.b.b.a.l().h(context, "1", dVar);
    }

    @Override // d.a.i0.b.j.c0.a
    public String getBduss(Context context) {
        return d.a.k0.s.b.b.a.l().j();
    }

    @Override // d.a.i0.b.j.c0.a
    public boolean h(Context context) {
        return d.a.k0.s.b.b.a.l().s();
    }

    @Override // d.a.i0.b.j.c0.a
    public void i(d.a.i0.a.m.c cVar) {
        d.a.k0.s.b.b.a.l().f(cVar);
    }

    @Override // d.a.i0.b.j.c0.a
    public void j(Context context, a.d dVar) {
        d.a.k0.s.b.b.a.l().g(context, "1", dVar);
    }

    @Override // d.a.i0.b.j.c0.a
    public void k(Context context, SwanAppPhoneLoginDialog.g gVar, String str) {
        PassportSDK.getInstance().startSmsViewLogin(new b(this, gVar, context), str);
    }

    @Override // d.a.i0.b.j.c0.a
    public String l(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("aps_identity", 0);
        String string = sharedPreferences.getString("uid_v3", "");
        if (TextUtils.isEmpty(string)) {
            String q = q(context);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("uid_v3", q);
            edit.apply();
            return q;
        }
        return string;
    }

    @Override // d.a.i0.b.j.c0.a
    public void m(Activity activity, String str, String str2, b0 b0Var) {
        FaceIDVerifyDTO faceIDVerifyDTO = new FaceIDVerifyDTO();
        faceIDVerifyDTO.businessSence = str;
        faceIDVerifyDTO.bduss = str2;
        PassportSDK.getInstance().verifyUserFaceId(activity, new C1597d(this, b0Var), faceIDVerifyDTO);
    }

    @Override // d.a.i0.b.j.c0.a
    public void n(Activity activity, String str, d.a.i0.b.n.g.e eVar) {
        t(activity);
        PassportSDK.getInstance().loadOneKeyLogin(activity, s(activity, str), new c(eVar, activity));
    }

    @Override // d.a.i0.b.j.c0.a
    public void o(String str, ArrayList<String> arrayList, b.c cVar) {
        d.a.k0.s.b.b.a.l().n(str, arrayList, cVar);
    }

    @Override // d.a.i0.b.j.c0.a
    public void p(l.a aVar, String str, List<String> list) {
        SapiAccountManager.getInstance().getAccountService().getTplStoken(new a(this, aVar), str, list);
    }

    public void r(Context context) {
        d.a.i0.a.z1.b.b.c cVar;
        if (!(context instanceof Activity) || ((Activity) context).isFinishing() || (cVar = this.f60672a) == null) {
            return;
        }
        cVar.dismiss();
    }

    public final void t(Context context) {
        d.a.i0.a.z1.b.b.c cVar = new d.a.i0.a.z1.b.b.c(context, 16973833);
        this.f60672a = cVar;
        Window window = cVar.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(17170445);
            window.setDimAmount(0.0f);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.height = context.getResources().getDimensionPixelSize(R.dimen.account_loading_height);
            attributes.width = -1;
            window.setAttributes(attributes);
        }
        this.f60672a.setCanceledOnTouchOutside(false);
        this.f60672a.setCancelable(false);
        this.f60672a.a(true);
        this.f60672a.setContentView(R.layout.loading_layout);
        View findViewById = this.f60672a.findViewById(R.id.root_container);
        ProgressBar progressBar = (ProgressBar) this.f60672a.findViewById(R.id.loading_bar);
        TextView textView = (TextView) this.f60672a.findViewById(R.id.message);
        if (findViewById != null) {
            findViewById.setBackground(findViewById.getResources().getDrawable(R.drawable.novel_loading_bg));
        }
        if (progressBar != null) {
            progressBar.setIndeterminateDrawable(progressBar.getResources().getDrawable(R.drawable.loading_progress_animation));
        }
        if (textView != null) {
            textView.setTextColor(textView.getResources().getColor(R.color.loading_text_color));
            textView.setText(R.string.account_onekey_loading);
        }
        this.f60672a.show();
    }
}
