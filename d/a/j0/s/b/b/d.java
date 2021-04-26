package d.a.j0.s.b.b;

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
import d.a.h0.a.a2.g.h;
import d.a.h0.a.i2.w;
import d.a.h0.a.q1.b.b.g;
import d.a.h0.b.g;
import d.a.h0.b.i.a0;
import d.a.h0.b.i.b0;
import d.a.h0.b.i.l;
import d.a.h0.b.i.z;
import d.a.h0.b.j.a;
import d.a.h0.b.k.b;
import d.a.h0.b.n.a;
import java.util.ArrayList;
import java.util.List;
@Service
/* loaded from: classes4.dex */
public class d implements d.a.h0.b.i.c0.a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.h0.a.q1.b.b.c f59927a;

    /* loaded from: classes4.dex */
    public class a extends GetTplStokenCallback {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l.a f59928e;

        public a(d dVar, l.a aVar) {
            this.f59928e = aVar;
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            l.a aVar = this.f59928e;
            if (aVar != null) {
                aVar.onFinish();
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            l.a aVar = this.f59928e;
            if (aVar != null) {
                aVar.onStart();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(GetTplStokenResult getTplStokenResult) {
            if (this.f59928e != null) {
                l lVar = new l();
                if (getTplStokenResult != null) {
                    lVar.f45452b = getTplStokenResult.tplStokenMap;
                    lVar.f45451a = getTplStokenResult.getResultCode();
                    getTplStokenResult.getResultMsg();
                    GetTplStokenResult.FailureType failureType = getTplStokenResult.failureType;
                    if (failureType != null) {
                        failureType.name();
                    }
                }
                this.f59928e.a(lVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetTplStokenResult getTplStokenResult) {
            if (this.f59928e != null) {
                l lVar = new l();
                if (getTplStokenResult != null) {
                    lVar.f45452b = getTplStokenResult.tplStokenMap;
                    lVar.f45451a = getTplStokenResult.getResultCode();
                    getTplStokenResult.getResultMsg();
                    GetTplStokenResult.FailureType failureType = getTplStokenResult.failureType;
                    if (failureType != null) {
                        failureType.name();
                    }
                }
                this.f59928e.b(lVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends SmsViewLoginCallback {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppPhoneLoginDialog.g f59929e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f59930f;

        /* loaded from: classes4.dex */
        public class a implements DialogInterface.OnClickListener {
            public a(b bVar) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
            }
        }

        /* renamed from: d.a.j0.s.b.b.d$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class DialogInterface$OnClickListenerC1522b implements DialogInterface.OnClickListener {

            /* renamed from: d.a.j0.s.b.b.d$b$b$a */
            /* loaded from: classes4.dex */
            public class a implements d.a.h0.a.m.a {
                public a() {
                }

                @Override // d.a.h0.a.m.a
                public void onResult(int i2) {
                    if (i2 == 0) {
                        b.this.f59929e.onSuccess();
                    } else {
                        b.this.f59929e.onFailure();
                    }
                }
            }

            public DialogInterface$OnClickListenerC1522b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                d.a.h0.b.i.a.P((FragmentActivity) b.this.f59930f, false, null, new a());
            }
        }

        /* loaded from: classes4.dex */
        public class c implements d.a.h0.a.m.a {
            public c() {
            }

            @Override // d.a.h0.a.m.a
            public void onResult(int i2) {
                SwanAppPhoneLoginDialog.g gVar = b.this.f59929e;
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
            this.f59929e = gVar;
            this.f59930f = context;
        }

        @Override // com.baidu.sapi2.callback.SmsViewLoginCallback
        public void onCheckCodeViewHide() {
            this.f59929e.b();
        }

        @Override // com.baidu.sapi2.callback.SmsViewLoginCallback
        public void onCheckCodeViewShow() {
            this.f59929e.a();
        }

        @Override // com.baidu.sapi2.callback.SmsViewLoginCallback
        public void onNeedBack(WebAuthResult webAuthResult) {
            Context context = this.f59930f;
            w.a(context, ((FragmentActivity) context).getWindow().getDecorView().getWindowToken());
            String string = this.f59930f.getResources().getString(g.account_login_dialog_needback_other);
            String string2 = this.f59930f.getResources().getString(g.account_login_dialog_needback_positive_btn_login);
            if (webAuthResult.getResultCode() == 12) {
                string = this.f59930f.getResources().getString(g.account_login_dialog_needback_phone);
                string2 = this.f59930f.getResources().getString(g.account_login_dialog_needback_positive_btn_register);
            }
            g.a aVar = new g.a(this.f59930f);
            aVar.V(this.f59930f.getResources().getString(d.a.h0.b.g.account_login_dialog_needback_title));
            aVar.y(string);
            aVar.P(string2, new DialogInterface$OnClickListenerC1522b());
            aVar.D(this.f59930f.getResources().getString(d.a.h0.b.g.account_login_dialog_needback_negative_btn), new a(this));
            aVar.X();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            this.f59929e.onFailure();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            d.a.j0.s.b.b.a.l().x(new c());
        }
    }

    /* loaded from: classes4.dex */
    public class c extends OneKeyLoginCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.b.m.g.e f59934a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f59935b;

        /* loaded from: classes4.dex */
        public class a implements d.a.h0.a.m.a {
            public a() {
            }

            @Override // d.a.h0.a.m.a
            public void onResult(int i2) {
                if (i2 == 0) {
                    c.this.f59934a.onResult(0);
                } else {
                    c.this.f59934a.onResult(-1);
                }
                c cVar = c.this;
                d.this.r(cVar.f59935b);
            }
        }

        public c(d.a.h0.b.m.g.e eVar, Activity activity) {
            this.f59934a = eVar;
            this.f59935b = activity;
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onFail(OneKeyLoginResult oneKeyLoginResult) {
            this.f59934a.onResult(-1);
            d.this.r(this.f59935b);
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onGuideProcess(OneKeyLoginResult oneKeyLoginResult) {
            this.f59934a.onResult(-1);
            d.this.r(this.f59935b);
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onSuccess(OneKeyLoginResult oneKeyLoginResult) {
            d.a.j0.s.b.b.a.l().x(new a());
        }
    }

    /* renamed from: d.a.j0.s.b.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1523d extends VerifyUserFaceIDCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b0 f59938a;

        public C1523d(d dVar, b0 b0Var) {
            this.f59938a = b0Var;
        }

        @Override // com.baidu.sapi2.callback.FaceIDCallback
        public void onFailure(SapiResult sapiResult) {
            this.f59938a.onFailure(sapiResult.getResultMsg());
        }

        @Override // com.baidu.sapi2.callback.FaceIDCallback
        public void onSuccess(SapiResult sapiResult) {
            z zVar = new z();
            if (sapiResult instanceof RealNameFaceIDResult) {
                zVar.f45467a = ((RealNameFaceIDResult) sapiResult).callBackKey;
                this.f59938a.a(zVar);
            } else if (sapiResult instanceof UnRealNameFaceIDResult) {
                zVar.f45467a = ((UnRealNameFaceIDResult) sapiResult).registerResult;
                this.f59938a.a(zVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends AccountRealNameCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b0 f59939a;

        public e(d dVar, b0 b0Var) {
            this.f59939a = b0Var;
        }

        @Override // com.baidu.sapi2.callback.AccountRealNameCallback
        public void onFinish(AccountRealNameResult accountRealNameResult) {
            super.onFinish(accountRealNameResult);
            if (accountRealNameResult.getResultCode() == 0) {
                z zVar = new z();
                if (accountRealNameResult.seniorRealNameSuc) {
                    zVar.f45467a = accountRealNameResult.callbackkey;
                    this.f59939a.a(zVar);
                    return;
                }
            }
            this.f59939a.onFailure(accountRealNameResult.getResultMsg());
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
        return substring + d.a.h0.p.e.d((substring2 + d.a.h0.p.e.d(upperCase.getBytes(), false)).getBytes(), false);
    }

    @Override // d.a.h0.b.i.c0.a
    public String a(Context context) {
        return h.a().getString("bd_box_ptoken", "");
    }

    @Override // d.a.h0.b.i.c0.a
    public String b(Context context) {
        return d.a.j0.s.b.b.a.l().p();
    }

    @Override // d.a.h0.b.i.c0.a
    public void c(Context context, Bundle bundle, d.a.h0.a.m.a aVar) {
        d.a.j0.s.b.b.a.l().t(context, bundle, aVar);
    }

    @Override // d.a.h0.b.i.c0.a
    public a0 d(Context context) {
        a0 a0Var = new a0();
        a0Var.f45447a = d.a.j0.s.b.b.a.l().k();
        a0Var.f45448b = d.a.j0.s.b.b.a.l().i();
        return a0Var;
    }

    @Override // d.a.h0.b.i.c0.a
    public String e(Context context) {
        return FH.gz(AppRuntime.getAppContext());
    }

    @Override // d.a.h0.b.i.c0.a
    public void f(Activity activity, String str, String str2, b0 b0Var) {
        RealNameDTO realNameDTO = new RealNameDTO();
        realNameDTO.bduss = SapiAccountManager.getInstance().getSession().bduss;
        realNameDTO.scene = str;
        realNameDTO.needCbKey = true;
        PassportSDK.getInstance().loadAccountRealName(activity, new e(this, b0Var), realNameDTO);
    }

    @Override // d.a.h0.b.i.c0.a
    public void g(Context context, a.d dVar) {
        d.a.j0.s.b.b.a.l().h(context, "1", dVar);
    }

    @Override // d.a.h0.b.i.c0.a
    public String getBduss(Context context) {
        return d.a.j0.s.b.b.a.l().j();
    }

    @Override // d.a.h0.b.i.c0.a
    public boolean h(Context context) {
        return d.a.j0.s.b.b.a.l().s();
    }

    @Override // d.a.h0.b.i.c0.a
    public void i(d.a.h0.a.m.c cVar) {
        d.a.j0.s.b.b.a.l().f(cVar);
    }

    @Override // d.a.h0.b.i.c0.a
    public void j(Context context, a.d dVar) {
        d.a.j0.s.b.b.a.l().g(context, "1", dVar);
    }

    @Override // d.a.h0.b.i.c0.a
    public void k(Context context, SwanAppPhoneLoginDialog.g gVar, String str) {
        PassportSDK.getInstance().startSmsViewLogin(new b(this, gVar, context), str);
    }

    @Override // d.a.h0.b.i.c0.a
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

    @Override // d.a.h0.b.i.c0.a
    public void m(Activity activity, String str, String str2, b0 b0Var) {
        FaceIDVerifyDTO faceIDVerifyDTO = new FaceIDVerifyDTO();
        faceIDVerifyDTO.businessSence = str;
        faceIDVerifyDTO.bduss = str2;
        PassportSDK.getInstance().verifyUserFaceId(activity, new C1523d(this, b0Var), faceIDVerifyDTO);
    }

    @Override // d.a.h0.b.i.c0.a
    public void n(Activity activity, String str, d.a.h0.b.m.g.e eVar) {
        t(activity);
        PassportSDK.getInstance().loadOneKeyLogin(activity, s(activity, str), new c(eVar, activity));
    }

    @Override // d.a.h0.b.i.c0.a
    public void o(String str, ArrayList<String> arrayList, b.c cVar) {
        d.a.j0.s.b.b.a.l().n(str, arrayList, cVar);
    }

    @Override // d.a.h0.b.i.c0.a
    public void p(l.a aVar, String str, List<String> list) {
        SapiAccountManager.getInstance().getAccountService().getTplStoken(new a(this, aVar), str, list);
    }

    public void r(Context context) {
        d.a.h0.a.q1.b.b.c cVar;
        if (!(context instanceof Activity) || ((Activity) context).isFinishing() || (cVar = this.f59927a) == null) {
            return;
        }
        cVar.dismiss();
    }

    public final void t(Context context) {
        d.a.h0.a.q1.b.b.c cVar = new d.a.h0.a.q1.b.b.c(context, 16973833);
        this.f59927a = cVar;
        Window window = cVar.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(17170445);
            window.setDimAmount(0.0f);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.height = context.getResources().getDimensionPixelSize(R.dimen.account_loading_height);
            attributes.width = -1;
            window.setAttributes(attributes);
        }
        this.f59927a.setCanceledOnTouchOutside(false);
        this.f59927a.setCancelable(false);
        this.f59927a.a(true);
        this.f59927a.setContentView(R.layout.loading_layout);
        View findViewById = this.f59927a.findViewById(R.id.root_container);
        ProgressBar progressBar = (ProgressBar) this.f59927a.findViewById(R.id.loading_bar);
        TextView textView = (TextView) this.f59927a.findViewById(R.id.message);
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
        this.f59927a.show();
    }
}
