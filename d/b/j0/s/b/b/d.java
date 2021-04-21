package d.b.j0.s.b.b;

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
import d.b.h0.a.a2.g.h;
import d.b.h0.a.i2.w;
import d.b.h0.a.q1.b.b.g;
import d.b.h0.b.g;
import d.b.h0.b.i.a0;
import d.b.h0.b.i.b0;
import d.b.h0.b.i.l;
import d.b.h0.b.i.z;
import d.b.h0.b.j.a;
import d.b.h0.b.k.b;
import d.b.h0.b.n.a;
import java.util.ArrayList;
import java.util.List;
@Service
/* loaded from: classes4.dex */
public class d implements d.b.h0.b.i.c0.a {

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.a.q1.b.b.c f61769a;

    /* loaded from: classes4.dex */
    public class a extends GetTplStokenCallback {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l.a f61770e;

        public a(d dVar, l.a aVar) {
            this.f61770e = aVar;
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            l.a aVar = this.f61770e;
            if (aVar != null) {
                aVar.onFinish();
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            l.a aVar = this.f61770e;
            if (aVar != null) {
                aVar.onStart();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(GetTplStokenResult getTplStokenResult) {
            if (this.f61770e != null) {
                l lVar = new l();
                if (getTplStokenResult != null) {
                    lVar.f48012b = getTplStokenResult.tplStokenMap;
                    lVar.f48011a = getTplStokenResult.getResultCode();
                    getTplStokenResult.getResultMsg();
                    GetTplStokenResult.FailureType failureType = getTplStokenResult.failureType;
                    if (failureType != null) {
                        failureType.name();
                    }
                }
                this.f61770e.b(lVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetTplStokenResult getTplStokenResult) {
            if (this.f61770e != null) {
                l lVar = new l();
                if (getTplStokenResult != null) {
                    lVar.f48012b = getTplStokenResult.tplStokenMap;
                    lVar.f48011a = getTplStokenResult.getResultCode();
                    getTplStokenResult.getResultMsg();
                    GetTplStokenResult.FailureType failureType = getTplStokenResult.failureType;
                    if (failureType != null) {
                        failureType.name();
                    }
                }
                this.f61770e.a(lVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends SmsViewLoginCallback {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppPhoneLoginDialog.g f61771e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f61772f;

        /* loaded from: classes4.dex */
        public class a implements DialogInterface.OnClickListener {
            public a(b bVar) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        /* renamed from: d.b.j0.s.b.b.d$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class DialogInterface$OnClickListenerC1583b implements DialogInterface.OnClickListener {

            /* renamed from: d.b.j0.s.b.b.d$b$b$a */
            /* loaded from: classes4.dex */
            public class a implements d.b.h0.a.m.a {
                public a() {
                }

                @Override // d.b.h0.a.m.a
                public void onResult(int i) {
                    if (i == 0) {
                        b.this.f61771e.onSuccess();
                    } else {
                        b.this.f61771e.onFailure();
                    }
                }
            }

            public DialogInterface$OnClickListenerC1583b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                d.b.h0.b.i.a.P((FragmentActivity) b.this.f61772f, false, null, new a());
            }
        }

        /* loaded from: classes4.dex */
        public class c implements d.b.h0.a.m.a {
            public c() {
            }

            @Override // d.b.h0.a.m.a
            public void onResult(int i) {
                SwanAppPhoneLoginDialog.g gVar = b.this.f61771e;
                if (gVar != null) {
                    if (i == 0) {
                        gVar.onSuccess();
                    } else {
                        gVar.onFailure();
                    }
                }
            }
        }

        public b(d dVar, SwanAppPhoneLoginDialog.g gVar, Context context) {
            this.f61771e = gVar;
            this.f61772f = context;
        }

        @Override // com.baidu.sapi2.callback.SmsViewLoginCallback
        public void onCheckCodeViewHide() {
            this.f61771e.b();
        }

        @Override // com.baidu.sapi2.callback.SmsViewLoginCallback
        public void onCheckCodeViewShow() {
            this.f61771e.a();
        }

        @Override // com.baidu.sapi2.callback.SmsViewLoginCallback
        public void onNeedBack(WebAuthResult webAuthResult) {
            Context context = this.f61772f;
            w.a(context, ((FragmentActivity) context).getWindow().getDecorView().getWindowToken());
            String string = this.f61772f.getResources().getString(g.account_login_dialog_needback_other);
            String string2 = this.f61772f.getResources().getString(g.account_login_dialog_needback_positive_btn_login);
            if (webAuthResult.getResultCode() == 12) {
                string = this.f61772f.getResources().getString(g.account_login_dialog_needback_phone);
                string2 = this.f61772f.getResources().getString(g.account_login_dialog_needback_positive_btn_register);
            }
            g.a aVar = new g.a(this.f61772f);
            aVar.V(this.f61772f.getResources().getString(d.b.h0.b.g.account_login_dialog_needback_title));
            aVar.y(string);
            aVar.P(string2, new DialogInterface$OnClickListenerC1583b());
            aVar.D(this.f61772f.getResources().getString(d.b.h0.b.g.account_login_dialog_needback_negative_btn), new a(this));
            aVar.X();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            this.f61771e.onFailure();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            d.b.j0.s.b.b.a.l().x(new c());
        }
    }

    /* loaded from: classes4.dex */
    public class c extends OneKeyLoginCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.b.m.g.e f61776a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f61777b;

        /* loaded from: classes4.dex */
        public class a implements d.b.h0.a.m.a {
            public a() {
            }

            @Override // d.b.h0.a.m.a
            public void onResult(int i) {
                if (i == 0) {
                    c.this.f61776a.onResult(0);
                } else {
                    c.this.f61776a.onResult(-1);
                }
                c cVar = c.this;
                d.this.r(cVar.f61777b);
            }
        }

        public c(d.b.h0.b.m.g.e eVar, Activity activity) {
            this.f61776a = eVar;
            this.f61777b = activity;
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onFail(OneKeyLoginResult oneKeyLoginResult) {
            this.f61776a.onResult(-1);
            d.this.r(this.f61777b);
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onGuideProcess(OneKeyLoginResult oneKeyLoginResult) {
            this.f61776a.onResult(-1);
            d.this.r(this.f61777b);
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onSuccess(OneKeyLoginResult oneKeyLoginResult) {
            d.b.j0.s.b.b.a.l().x(new a());
        }
    }

    /* renamed from: d.b.j0.s.b.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1584d extends VerifyUserFaceIDCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b0 f61780a;

        public C1584d(d dVar, b0 b0Var) {
            this.f61780a = b0Var;
        }

        @Override // com.baidu.sapi2.callback.FaceIDCallback
        public void onFailure(SapiResult sapiResult) {
            this.f61780a.onFailure(sapiResult.getResultMsg());
        }

        @Override // com.baidu.sapi2.callback.FaceIDCallback
        public void onSuccess(SapiResult sapiResult) {
            z zVar = new z();
            if (sapiResult instanceof RealNameFaceIDResult) {
                zVar.f48027a = ((RealNameFaceIDResult) sapiResult).callBackKey;
                this.f61780a.a(zVar);
            } else if (sapiResult instanceof UnRealNameFaceIDResult) {
                zVar.f48027a = ((UnRealNameFaceIDResult) sapiResult).registerResult;
                this.f61780a.a(zVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends AccountRealNameCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b0 f61781a;

        public e(d dVar, b0 b0Var) {
            this.f61781a = b0Var;
        }

        @Override // com.baidu.sapi2.callback.AccountRealNameCallback
        public void onFinish(AccountRealNameResult accountRealNameResult) {
            super.onFinish(accountRealNameResult);
            if (accountRealNameResult.getResultCode() == 0) {
                z zVar = new z();
                if (accountRealNameResult.seniorRealNameSuc) {
                    zVar.f48027a = accountRealNameResult.callbackkey;
                    this.f61781a.a(zVar);
                    return;
                }
            }
            this.f61781a.onFailure(accountRealNameResult.getResultMsg());
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
        return substring + d.b.h0.p.e.d((substring2 + d.b.h0.p.e.d(upperCase.getBytes(), false)).getBytes(), false);
    }

    @Override // d.b.h0.b.i.c0.a
    public void a(Context context, a.d dVar) {
        d.b.j0.s.b.b.a.l().g(context, "1", dVar);
    }

    @Override // d.b.h0.b.i.c0.a
    public String b(Context context) {
        return h.a().getString("bd_box_ptoken", "");
    }

    @Override // d.b.h0.b.i.c0.a
    public void c(Context context, SwanAppPhoneLoginDialog.g gVar, String str) {
        PassportSDK.getInstance().startSmsViewLogin(new b(this, gVar, context), str);
    }

    @Override // d.b.h0.b.i.c0.a
    public String d(Context context) {
        return d.b.j0.s.b.b.a.l().p();
    }

    @Override // d.b.h0.b.i.c0.a
    public String e(Context context) {
        return FH.gz(AppRuntime.getAppContext());
    }

    @Override // d.b.h0.b.i.c0.a
    public String f(Context context) {
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

    @Override // d.b.h0.b.i.c0.a
    public void g(Context context, Bundle bundle, d.b.h0.a.m.a aVar) {
        d.b.j0.s.b.b.a.l().t(context, bundle, aVar);
    }

    @Override // d.b.h0.b.i.c0.a
    public String getBduss(Context context) {
        return d.b.j0.s.b.b.a.l().j();
    }

    @Override // d.b.h0.b.i.c0.a
    public void h(Activity activity, String str, String str2, b0 b0Var) {
        FaceIDVerifyDTO faceIDVerifyDTO = new FaceIDVerifyDTO();
        faceIDVerifyDTO.businessSence = str;
        faceIDVerifyDTO.bduss = str2;
        PassportSDK.getInstance().verifyUserFaceId(activity, new C1584d(this, b0Var), faceIDVerifyDTO);
    }

    @Override // d.b.h0.b.i.c0.a
    public a0 i(Context context) {
        a0 a0Var = new a0();
        a0Var.f48007a = d.b.j0.s.b.b.a.l().k();
        a0Var.f48008b = d.b.j0.s.b.b.a.l().i();
        return a0Var;
    }

    @Override // d.b.h0.b.i.c0.a
    public void j(Activity activity, String str, String str2, b0 b0Var) {
        RealNameDTO realNameDTO = new RealNameDTO();
        realNameDTO.bduss = SapiAccountManager.getInstance().getSession().bduss;
        realNameDTO.scene = str;
        realNameDTO.needCbKey = true;
        PassportSDK.getInstance().loadAccountRealName(activity, new e(this, b0Var), realNameDTO);
    }

    @Override // d.b.h0.b.i.c0.a
    public void k(Activity activity, String str, d.b.h0.b.m.g.e eVar) {
        t(activity);
        PassportSDK.getInstance().loadOneKeyLogin(activity, s(activity, str), new c(eVar, activity));
    }

    @Override // d.b.h0.b.i.c0.a
    public void l(Context context, a.d dVar) {
        d.b.j0.s.b.b.a.l().h(context, "1", dVar);
    }

    @Override // d.b.h0.b.i.c0.a
    public boolean m(Context context) {
        return d.b.j0.s.b.b.a.l().s();
    }

    @Override // d.b.h0.b.i.c0.a
    public void n(String str, ArrayList<String> arrayList, b.c cVar) {
        d.b.j0.s.b.b.a.l().n(str, arrayList, cVar);
    }

    @Override // d.b.h0.b.i.c0.a
    public void o(l.a aVar, String str, List<String> list) {
        SapiAccountManager.getInstance().getAccountService().getTplStoken(new a(this, aVar), str, list);
    }

    @Override // d.b.h0.b.i.c0.a
    public void p(d.b.h0.a.m.c cVar) {
        d.b.j0.s.b.b.a.l().f(cVar);
    }

    public void r(Context context) {
        d.b.h0.a.q1.b.b.c cVar;
        if (!(context instanceof Activity) || ((Activity) context).isFinishing() || (cVar = this.f61769a) == null) {
            return;
        }
        cVar.dismiss();
    }

    public final void t(Context context) {
        d.b.h0.a.q1.b.b.c cVar = new d.b.h0.a.q1.b.b.c(context, 16973833);
        this.f61769a = cVar;
        Window window = cVar.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(17170445);
            window.setDimAmount(0.0f);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.height = context.getResources().getDimensionPixelSize(R.dimen.account_loading_height);
            attributes.width = -1;
            window.setAttributes(attributes);
        }
        this.f61769a.setCanceledOnTouchOutside(false);
        this.f61769a.setCancelable(false);
        this.f61769a.a(true);
        this.f61769a.setContentView(R.layout.loading_layout);
        View findViewById = this.f61769a.findViewById(R.id.root_container);
        ProgressBar progressBar = (ProgressBar) this.f61769a.findViewById(R.id.loading_bar);
        TextView textView = (TextView) this.f61769a.findViewById(R.id.message);
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
        this.f61769a.show();
    }
}
