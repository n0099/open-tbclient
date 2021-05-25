package d.a.n0.u.b.b;

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
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.a.l0.a.v2.x;
import d.a.l0.a.z1.b.b.h;
import d.a.l0.b.g;
import d.a.l0.b.j.a0;
import d.a.l0.b.j.b0;
import d.a.l0.b.j.l;
import d.a.l0.b.j.z;
import d.a.l0.b.k.a;
import d.a.l0.b.l.b;
import d.a.l0.b.o.a;
import d.a.l0.t.f;
import java.util.ArrayList;
import java.util.List;
@Service
/* loaded from: classes4.dex */
public class d implements d.a.l0.b.j.c0.a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.a.z1.b.b.c f61245a;

    /* loaded from: classes4.dex */
    public class a extends GetTplStokenCallback {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l.a f61246e;

        public a(d dVar, l.a aVar) {
            this.f61246e = aVar;
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            l.a aVar = this.f61246e;
            if (aVar != null) {
                aVar.onFinish();
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            l.a aVar = this.f61246e;
            if (aVar != null) {
                aVar.onStart();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(GetTplStokenResult getTplStokenResult) {
            if (this.f61246e != null) {
                l lVar = new l();
                if (getTplStokenResult != null) {
                    lVar.f46253b = getTplStokenResult.tplStokenMap;
                    lVar.f46252a = getTplStokenResult.getResultCode();
                    getTplStokenResult.getResultMsg();
                    GetTplStokenResult.FailureType failureType = getTplStokenResult.failureType;
                    if (failureType != null) {
                        failureType.name();
                    }
                }
                this.f61246e.a(lVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetTplStokenResult getTplStokenResult) {
            if (this.f61246e != null) {
                l lVar = new l();
                if (getTplStokenResult != null) {
                    lVar.f46253b = getTplStokenResult.tplStokenMap;
                    lVar.f46252a = getTplStokenResult.getResultCode();
                    getTplStokenResult.getResultMsg();
                    GetTplStokenResult.FailureType failureType = getTplStokenResult.failureType;
                    if (failureType != null) {
                        failureType.name();
                    }
                }
                this.f61246e.b(lVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends SmsViewLoginCallback {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppPhoneLoginDialog.g f61247e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f61248f;

        /* loaded from: classes4.dex */
        public class a implements DialogInterface.OnClickListener {
            public a(b bVar) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
            }
        }

        /* renamed from: d.a.n0.u.b.b.d$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class DialogInterface$OnClickListenerC1627b implements DialogInterface.OnClickListener {

            /* renamed from: d.a.n0.u.b.b.d$b$b$a */
            /* loaded from: classes4.dex */
            public class a implements d.a.l0.a.m.a {
                public a() {
                }

                @Override // d.a.l0.a.m.a
                public void onResult(int i2) {
                    if (i2 == 0) {
                        b.this.f61247e.onSuccess();
                    } else {
                        b.this.f61247e.onFailure();
                    }
                }
            }

            public DialogInterface$OnClickListenerC1627b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                d.a.l0.b.j.a.N((FragmentActivity) b.this.f61248f, false, null, new a());
            }
        }

        /* loaded from: classes4.dex */
        public class c implements d.a.l0.a.m.a {
            public c() {
            }

            @Override // d.a.l0.a.m.a
            public void onResult(int i2) {
                SwanAppPhoneLoginDialog.g gVar = b.this.f61247e;
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
            this.f61247e = gVar;
            this.f61248f = context;
        }

        @Override // com.baidu.sapi2.callback.SmsViewLoginCallback
        public void onCheckCodeViewHide() {
            this.f61247e.b();
        }

        @Override // com.baidu.sapi2.callback.SmsViewLoginCallback
        public void onCheckCodeViewShow() {
            this.f61247e.a();
        }

        @Override // com.baidu.sapi2.callback.SmsViewLoginCallback
        public void onNeedBack(WebAuthResult webAuthResult) {
            Context context = this.f61248f;
            x.a(context, ((FragmentActivity) context).getWindow().getDecorView().getWindowToken());
            String string = this.f61248f.getResources().getString(g.account_login_dialog_needback_other);
            String string2 = this.f61248f.getResources().getString(g.account_login_dialog_needback_positive_btn_login);
            if (webAuthResult.getResultCode() == 12) {
                string = this.f61248f.getResources().getString(g.account_login_dialog_needback_phone);
                string2 = this.f61248f.getResources().getString(g.account_login_dialog_needback_positive_btn_register);
            }
            h.a aVar = new h.a(this.f61248f);
            aVar.V(this.f61248f.getResources().getString(g.account_login_dialog_needback_title));
            aVar.x(string);
            aVar.P(string2, new DialogInterface$OnClickListenerC1627b());
            aVar.C(this.f61248f.getResources().getString(g.account_login_dialog_needback_negative_btn), new a(this));
            aVar.X();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            this.f61247e.onFailure();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            d.a.n0.u.b.b.a.l().x(new c());
        }
    }

    /* loaded from: classes4.dex */
    public class c extends OneKeyLoginCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.b.n.g.e f61252a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f61253b;

        /* loaded from: classes4.dex */
        public class a implements d.a.l0.a.m.a {
            public a() {
            }

            @Override // d.a.l0.a.m.a
            public void onResult(int i2) {
                if (i2 == 0) {
                    c.this.f61252a.onResult(0);
                } else {
                    c.this.f61252a.onResult(-1);
                }
                c cVar = c.this;
                d.this.r(cVar.f61253b);
            }
        }

        public c(d.a.l0.b.n.g.e eVar, Activity activity) {
            this.f61252a = eVar;
            this.f61253b = activity;
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onFail(OneKeyLoginResult oneKeyLoginResult) {
            this.f61252a.onResult(-1);
            d.this.r(this.f61253b);
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onGuideProcess(OneKeyLoginResult oneKeyLoginResult) {
            this.f61252a.onResult(-1);
            d.this.r(this.f61253b);
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onSuccess(OneKeyLoginResult oneKeyLoginResult) {
            d.a.n0.u.b.b.a.l().x(new a());
        }
    }

    /* renamed from: d.a.n0.u.b.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1628d extends VerifyUserFaceIDCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b0 f61256a;

        public C1628d(d dVar, b0 b0Var) {
            this.f61256a = b0Var;
        }

        @Override // com.baidu.sapi2.callback.FaceIDCallback
        public void onFailure(SapiResult sapiResult) {
            this.f61256a.onFailure(sapiResult.getResultMsg());
        }

        @Override // com.baidu.sapi2.callback.FaceIDCallback
        public void onSuccess(SapiResult sapiResult) {
            z zVar = new z();
            if (sapiResult instanceof RealNameFaceIDResult) {
                zVar.f46268a = ((RealNameFaceIDResult) sapiResult).callBackKey;
                this.f61256a.a(zVar);
            } else if (sapiResult instanceof UnRealNameFaceIDResult) {
                zVar.f46268a = ((UnRealNameFaceIDResult) sapiResult).registerResult;
                this.f61256a.a(zVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends AccountRealNameCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b0 f61257a;

        public e(d dVar, b0 b0Var) {
            this.f61257a = b0Var;
        }

        @Override // com.baidu.sapi2.callback.AccountRealNameCallback
        public void onFinish(AccountRealNameResult accountRealNameResult) {
            super.onFinish(accountRealNameResult);
            if (accountRealNameResult.getResultCode() == 0) {
                z zVar = new z();
                if (accountRealNameResult.seniorRealNameSuc) {
                    zVar.f46268a = accountRealNameResult.callbackkey;
                    this.f61257a.a(zVar);
                    return;
                }
            }
            this.f61257a.onFailure(accountRealNameResult.getResultMsg());
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

    @Override // d.a.l0.b.j.c0.a
    public String a(Context context) {
        return d.a.l0.a.k2.g.h.a().getString("bd_box_ptoken", "");
    }

    @Override // d.a.l0.b.j.c0.a
    public String b(Context context) {
        return d.a.n0.u.b.b.a.l().p();
    }

    @Override // d.a.l0.b.j.c0.a
    public void c(Context context, Bundle bundle, d.a.l0.a.m.a aVar) {
        d.a.n0.u.b.b.a.l().t(context, bundle, aVar);
    }

    @Override // d.a.l0.b.j.c0.a
    public a0 d(Context context) {
        a0 a0Var = new a0();
        a0Var.f46248a = d.a.n0.u.b.b.a.l().k();
        a0Var.f46249b = d.a.n0.u.b.b.a.l().i();
        return a0Var;
    }

    @Override // d.a.l0.b.j.c0.a
    public String e(Context context) {
        return TbadkCoreApplication.getInst().getZid();
    }

    @Override // d.a.l0.b.j.c0.a
    public void f(Activity activity, String str, String str2, b0 b0Var) {
        RealNameDTO realNameDTO = new RealNameDTO();
        realNameDTO.bduss = SapiAccountManager.getInstance().getSession().bduss;
        realNameDTO.scene = str;
        realNameDTO.needCbKey = true;
        PassportSDK.getInstance().loadAccountRealName(activity, new e(this, b0Var), realNameDTO);
    }

    @Override // d.a.l0.b.j.c0.a
    public void g(Context context, a.d dVar) {
        d.a.n0.u.b.b.a.l().h(context, "1", dVar);
    }

    @Override // d.a.l0.b.j.c0.a
    public String getBduss(Context context) {
        return d.a.n0.u.b.b.a.l().j();
    }

    @Override // d.a.l0.b.j.c0.a
    public boolean h(Context context) {
        return d.a.n0.u.b.b.a.l().s();
    }

    @Override // d.a.l0.b.j.c0.a
    public void i(d.a.l0.a.m.c cVar) {
        d.a.n0.u.b.b.a.l().f(cVar);
    }

    @Override // d.a.l0.b.j.c0.a
    public void j(Context context, a.d dVar) {
        d.a.n0.u.b.b.a.l().g(context, "1", dVar);
    }

    @Override // d.a.l0.b.j.c0.a
    public void k(Context context, SwanAppPhoneLoginDialog.g gVar, String str) {
        PassportSDK.getInstance().startSmsViewLogin(new b(this, gVar, context), str);
    }

    @Override // d.a.l0.b.j.c0.a
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

    @Override // d.a.l0.b.j.c0.a
    public void m(Activity activity, String str, String str2, b0 b0Var) {
        FaceIDVerifyDTO faceIDVerifyDTO = new FaceIDVerifyDTO();
        faceIDVerifyDTO.businessSence = str;
        faceIDVerifyDTO.bduss = str2;
        PassportSDK.getInstance().verifyUserFaceId(activity, new C1628d(this, b0Var), faceIDVerifyDTO);
    }

    @Override // d.a.l0.b.j.c0.a
    public void n(Activity activity, String str, d.a.l0.b.n.g.e eVar) {
        t(activity);
        PassportSDK.getInstance().loadOneKeyLogin(activity, s(activity, str), new c(eVar, activity));
    }

    @Override // d.a.l0.b.j.c0.a
    public void o(String str, ArrayList<String> arrayList, b.c cVar) {
        d.a.n0.u.b.b.a.l().n(str, arrayList, cVar);
    }

    @Override // d.a.l0.b.j.c0.a
    public void p(l.a aVar, String str, List<String> list) {
        SapiAccountManager.getInstance().getAccountService().getTplStoken(new a(this, aVar), str, list);
    }

    public void r(Context context) {
        d.a.l0.a.z1.b.b.c cVar;
        if (!(context instanceof Activity) || ((Activity) context).isFinishing() || (cVar = this.f61245a) == null) {
            return;
        }
        cVar.dismiss();
    }

    public final void t(Context context) {
        d.a.l0.a.z1.b.b.c cVar = new d.a.l0.a.z1.b.b.c(context, 16973833);
        this.f61245a = cVar;
        Window window = cVar.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(17170445);
            window.setDimAmount(0.0f);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.height = context.getResources().getDimensionPixelSize(R.dimen.account_loading_height);
            attributes.width = -1;
            window.setAttributes(attributes);
        }
        this.f61245a.setCanceledOnTouchOutside(false);
        this.f61245a.setCancelable(false);
        this.f61245a.a(true);
        this.f61245a.setContentView(R.layout.loading_layout);
        View findViewById = this.f61245a.findViewById(R.id.root_container);
        ProgressBar progressBar = (ProgressBar) this.f61245a.findViewById(R.id.loading_bar);
        TextView textView = (TextView) this.f61245a.findViewById(R.id.message);
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
        this.f61245a.show();
    }
}
