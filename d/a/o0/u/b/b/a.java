package d.a.o0.u.b.b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.GetOpenBdussCallback;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.dto.GetOpenBdussDTO;
import com.baidu.sapi2.ecommerce.callback.AddressManageCallback;
import com.baidu.sapi2.ecommerce.callback.InvoiceBuildCallback;
import com.baidu.sapi2.ecommerce.dto.AddressManageDTO;
import com.baidu.sapi2.ecommerce.dto.InvoiceBuildDTO;
import com.baidu.sapi2.ecommerce.result.AddressManageResult;
import com.baidu.sapi2.ecommerce.result.InvoiceBuildResult;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.result.OpenBdussResult;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.m0.a.k;
import d.a.m0.a.v2.o0;
import d.a.m0.b.k.a;
import d.a.m0.b.l.b;
import d.a.m0.b.o.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final String f65051d = "a";

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f65052e = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.o0.u.b.b.b f65053a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.m0.a.m.c> f65054b;

    /* renamed from: c  reason: collision with root package name */
    public final CustomMessageListener f65055c;

    /* renamed from: d.a.o0.u.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1686a extends CustomMessageListener {
        public C1686a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            Integer num = (Integer) customResponsedMessage.getData();
            if (num.intValue() == 1) {
                a.this.r(TbadkCoreApplication.getInst());
            } else if (num.intValue() == 2) {
                a.this.v(SapiAccountManager.getInstance().isLogin());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends GetUserInfoCallback {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.LoginStatusAware
        public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(GetUserInfoResult getUserInfoResult) {
            a.this.v(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetUserInfoResult getUserInfoResult) {
            if (getUserInfoResult != null) {
                a.this.f65053a.f65076f = getUserInfoResult.portraitHttps;
            }
            a.this.v(true);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.m.a f65058a;

        /* renamed from: d.a.o0.u.b.b.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1687a extends GetUserInfoCallback {
            public C1687a() {
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onStart() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.LoginStatusAware
            public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                c.this.f65058a.onResult(-1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(GetUserInfoResult getUserInfoResult) {
                c.this.f65058a.onResult(-1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(GetUserInfoResult getUserInfoResult) {
                a.this.f65053a.f65072b = SapiAccountManager.getInstance().getSession().bduss;
                a.this.f65053a.f65078h = SapiAccountManager.getInstance().getSession().getPtoken();
                a.this.f65053a.f65071a = getUserInfoResult.displayname;
                a.this.f65053a.f65077g = getUserInfoResult.uid;
                a.this.f65053a.f65076f = getUserInfoResult.portraitHttps;
                d.a.m0.a.k2.g.h.a().putString("bd_box_display_name", a.this.f65053a.f65071a);
                d.a.m0.a.k2.g.h.a().putString("bd_box_uid", a.this.f65053a.f65077g);
                d.a.m0.a.k2.g.h.a().putString("bd_box_avatar_url", a.this.f65053a.f65076f);
                d.a.m0.a.k2.g.h.a().putString("bd_box_bduss", a.this.f65053a.f65072b);
                d.a.m0.a.k2.g.h.a().putString("bd_box_ptoken", a.this.f65053a.f65078h);
                c.this.f65058a.onResult(0);
                a.this.v(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i2, d.a.m0.a.m.a aVar) {
            super(i2);
            this.f65058a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof Integer) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 0) {
                    SapiAccountManager.getInstance().getAccountService().getUserInfo(new C1687a(), SapiAccountManager.getInstance().getSession().bduss);
                }
                this.f65058a.onResult(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends GetUserInfoCallback {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.m.a f65061e;

        public d(d.a.m0.a.m.a aVar) {
            this.f65061e = aVar;
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.LoginStatusAware
        public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
            this.f65061e.onResult(-1);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(GetUserInfoResult getUserInfoResult) {
            this.f65061e.onResult(-1);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetUserInfoResult getUserInfoResult) {
            a.this.f65053a.f65072b = SapiAccountManager.getInstance().getSession().bduss;
            a.this.f65053a.f65078h = SapiAccountManager.getInstance().getSession().getPtoken();
            a.this.f65053a.f65071a = getUserInfoResult.displayname;
            a.this.f65053a.f65077g = getUserInfoResult.uid;
            a.this.f65053a.f65076f = getUserInfoResult.portraitHttps;
            d.a.m0.a.k2.g.h.a().putString("bd_box_display_name", a.this.f65053a.f65071a);
            d.a.m0.a.k2.g.h.a().putString("bd_box_uid", a.this.f65053a.f65077g);
            d.a.m0.a.k2.g.h.a().putString("bd_box_avatar_url", a.this.f65053a.f65076f);
            d.a.m0.a.k2.g.h.a().putString("bd_box_bduss", a.this.f65053a.f65072b);
            d.a.m0.a.k2.g.h.a().putString("bd_box_ptoken", a.this.f65053a.f65078h);
            a.this.m();
            this.f65061e.onResult(0);
            a.this.v(true);
        }
    }

    /* loaded from: classes4.dex */
    public class e extends GetUserInfoCallback {
        public e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.LoginStatusAware
        public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(GetUserInfoResult getUserInfoResult) {
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetUserInfoResult getUserInfoResult) {
            a.this.f65053a.f65072b = SapiAccountManager.getInstance().getSession().bduss;
            a.this.f65053a.f65078h = SapiAccountManager.getInstance().getSession().getPtoken();
            a.this.f65053a.f65071a = getUserInfoResult.displayname;
            a.this.f65053a.f65077g = getUserInfoResult.uid;
            a.this.f65053a.f65076f = getUserInfoResult.portraitHttps;
            d.a.m0.a.k2.g.h.a().putString("bd_box_display_name", a.this.f65053a.f65071a);
            d.a.m0.a.k2.g.h.a().putString("bd_box_uid", a.this.f65053a.f65077g);
            d.a.m0.a.k2.g.h.a().putString("bd_box_avatar_url", a.this.f65053a.f65076f);
            d.a.m0.a.k2.g.h.a().putString("bd_box_bduss", a.this.f65053a.f65072b);
            d.a.m0.a.k2.g.h.a().putString("bd_box_ptoken", a.this.f65053a.f65078h);
        }
    }

    /* loaded from: classes4.dex */
    public class f extends AddressManageCallback {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f65064e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a.d f65065f;

        public f(a aVar, String str, a.d dVar) {
            this.f65064e = str;
            this.f65065f = dVar;
        }

        @Override // com.baidu.sapi2.ecommerce.callback.AddressManageCallback
        public void onFinish(AddressManageResult addressManageResult) {
            if ("0".equals(this.f65064e) || this.f65065f == null) {
                if (a.f65052e) {
                    Log.d(a.f65051d, String.format("管理收货地址流程结束（%d:%s", Integer.valueOf(addressManageResult.getResultCode()), addressManageResult.getResultMsg()));
                }
            } else if (addressManageResult.getResultCode() != 0) {
                if (a.f65052e) {
                    Log.d(a.f65051d, String.format("选择收货地址错误（%d:%s", Integer.valueOf(addressManageResult.getResultCode()), addressManageResult.getResultMsg()));
                }
                this.f65065f.b();
            } else {
                this.f65065f.a(addressManageResult.map.get("addrId"));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends InvoiceBuildCallback {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f65066e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a.d f65067f;

        public g(a aVar, String str, a.d dVar) {
            this.f65066e = str;
            this.f65067f = dVar;
        }

        @Override // com.baidu.sapi2.ecommerce.callback.InvoiceBuildCallback
        public void onFinish(InvoiceBuildResult invoiceBuildResult) {
            if ("0".equals(this.f65066e) || this.f65067f == null) {
                if (a.f65052e) {
                    Log.d(a.f65051d, String.format("发票管理流程结束（%d:%s）", Integer.valueOf(invoiceBuildResult.getResultCode()), invoiceBuildResult.getResultMsg()));
                }
            } else if (invoiceBuildResult.getResultCode() != 0) {
                if (a.f65052e) {
                    Log.d(a.f65051d, String.format("获取发票错误（%d:%s）", Integer.valueOf(invoiceBuildResult.getResultCode()), invoiceBuildResult.getResultMsg()));
                }
                this.f65067f.b();
            } else {
                this.f65067f.a(invoiceBuildResult.map.get(InvoiceBuildResult.KEY_INVOICE_ID), this.f65066e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends GetOpenBdussCallback {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.c f65068e;

        public h(b.c cVar) {
            this.f65068e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: c */
        public void onFailure(OpenBdussResult openBdussResult) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: d */
        public void onSuccess(OpenBdussResult openBdussResult) {
            a.this.f65053a.f65073c = openBdussResult.openBduss;
            a.this.f65053a.f65074d = openBdussResult.unionid;
            a.this.f65053a.f65075e = openBdussResult.tplStokenMap;
            d.a.m0.a.k2.g.h.a().putString("bd_box_open_bduss", a.this.f65053a.f65073c);
            d.a.m0.a.k2.g.h.a().putString("bd_box_union_id", a.this.f65053a.f65074d);
            d.a.m0.a.k2.g.h.a().putString("bd_box_stoken", o0.s(a.this.f65053a.f65075e));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(OpenBdussResult.PARAMS_OPEN_BDUSS, a.this.f65053a.f65073c);
                jSONObject.put("unionid", a.this.f65053a.f65074d);
                JSONObject jSONObject2 = new JSONObject();
                for (String str : a.this.f65053a.f65075e.keySet()) {
                    jSONObject2.put(str, a.this.f65053a.f65075e.get(str));
                }
                jSONObject.put("stokenmap", jSONObject2);
                jSONObject.put("uid", a.this.f65053a.f65077g);
                jSONObject.put("bduss", a.this.f65053a.f65072b);
                jSONObject.put("displayname", a.this.f65053a.f65071a);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.f65068e.a(jSONObject.toString());
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
        }
    }

    /* loaded from: classes4.dex */
    public static class i {

        /* renamed from: a  reason: collision with root package name */
        public static final a f65070a = new a(null);
    }

    public /* synthetic */ a(C1686a c1686a) {
        this();
    }

    public static a l() {
        return i.f65070a;
    }

    public void f(d.a.m0.a.m.c cVar) {
        this.f65054b.add(cVar);
    }

    public void g(Context context, String str, a.d dVar) {
        AddressManageDTO addressManageDTO = new AddressManageDTO();
        addressManageDTO.type = str;
        addressManageDTO.sweepLightLoading = true;
        PassportSDK.getInstance().loadAddressManage(context, addressManageDTO, new f(this, str, dVar));
    }

    public void h(Context context, String str, a.d dVar) {
        InvoiceBuildDTO invoiceBuildDTO = new InvoiceBuildDTO();
        invoiceBuildDTO.TYPE = str;
        PassportSDK.getInstance().loadInvoiceBuild(context, invoiceBuildDTO, new g(this, str, dVar));
    }

    public String i() {
        d.a.o0.u.b.b.b bVar = this.f65053a;
        if (bVar == null) {
            if (f65052e) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(bVar.f65076f)) {
            o();
        }
        return this.f65053a.f65076f;
    }

    public String j() {
        d.a.o0.u.b.b.b bVar = this.f65053a;
        if (bVar == null) {
            if (f65052e) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(bVar.f65072b)) {
            o();
        }
        return this.f65053a.f65072b;
    }

    public String k() {
        d.a.o0.u.b.b.b bVar = this.f65053a;
        if (bVar == null) {
            if (f65052e) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(bVar.f65071a)) {
            o();
        }
        return this.f65053a.f65071a;
    }

    public final void m() {
    }

    public void n(String str, ArrayList<String> arrayList, b.c cVar) {
        if (this.f65053a == null) {
            if (f65052e) {
                throw new NullPointerException("AccountInfo is null");
            }
            return;
        }
        GetOpenBdussDTO getOpenBdussDTO = new GetOpenBdussDTO();
        getOpenBdussDTO.clientId = str;
        getOpenBdussDTO.targetTplList.addAll(arrayList);
        SapiAccountManager.getInstance().getAccountService().getOpenBduss(getOpenBdussDTO, new h(cVar));
    }

    public void o() {
        try {
            SapiAccountManager.getInstance().getConfignation();
        } catch (Exception unused) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2921328, TbadkCoreApplication.getInst().getApp()));
        }
        try {
            SapiAccountManager.getInstance().isLogin();
            if (SapiAccountManager.getInstance().isLogin()) {
                SapiAccountManager.getInstance().getAccountService().getUserInfo(new e(), SapiAccountManager.getInstance().getSession().bduss);
            }
        } catch (NullPointerException unused2) {
        }
    }

    public String p() {
        d.a.o0.u.b.b.b bVar = this.f65053a;
        if (bVar == null) {
            if (f65052e) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(bVar.f65077g)) {
            o();
        }
        return this.f65053a.f65077g;
    }

    public void q(Context context) {
        w();
        r(context);
    }

    public final void r(Context context) {
        if (this.f65053a == null) {
            d.a.o0.u.b.b.b bVar = new d.a.o0.u.b.b.b();
            this.f65053a = bVar;
            bVar.f65076f = d.a.m0.a.k2.g.h.a().getString("bd_box_avatar_url", "");
            this.f65053a.f65072b = d.a.m0.a.k2.g.h.a().getString("bd_box_bduss", "");
            this.f65053a.f65078h = d.a.m0.a.k2.g.h.a().getString("bd_box_ptoken", "");
            this.f65053a.f65077g = d.a.m0.a.k2.g.h.a().getString("bd_box_uid", "");
            this.f65053a.f65073c = d.a.m0.a.k2.g.h.a().getString("bd_box_open_bduss", "");
            this.f65053a.f65074d = d.a.m0.a.k2.g.h.a().getString("bd_box_union_id", "");
            this.f65053a.f65075e = o0.t(d.a.m0.a.k2.g.h.a().getString("bd_box_stoken", ""));
            this.f65053a.f65071a = d.a.m0.a.k2.g.h.a().getString("bd_box_display_name", "");
        }
    }

    public boolean s() {
        d.a.o0.u.b.b.b bVar = this.f65053a;
        if (bVar != null && TextUtils.isEmpty(bVar.f65072b)) {
            o();
        }
        return SapiAccountManager.getInstance().isLogin();
    }

    public void t(Context context, Bundle bundle, d.a.m0.a.m.a aVar) {
        int i2;
        if (this.f65053a == null) {
            this.f65053a = new d.a.o0.u.b.b.b();
        }
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig(context, true, -1);
        loginActivityConfig.getIntent().putExtra(IntentConfig.CLOSE, true);
        if (bundle != null && (i2 = bundle.getInt("key_login_mode", 1)) > 1) {
            if (i2 == 4) {
                i2 = 1;
            }
            loginActivityConfig.setIsFromAiapp(true);
            loginActivityConfig.setThirdPartyLoginForResult(i2, "");
        }
        TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, loginActivityConfig));
        MessageManager.getInstance().registerListener(new c(2921362, aVar));
    }

    public void u(d.a.m0.a.m.a aVar) {
        SapiAccountManager.getInstance().logout();
        v(false);
        this.f65053a = new d.a.o0.u.b.b.b();
        d.a.m0.a.k2.g.h.a().putString("bd_box_display_name", "");
        d.a.m0.a.k2.g.h.a().putString("bd_box_uid", "");
        d.a.m0.a.k2.g.h.a().putString("bd_box_avatar_url", "");
        d.a.m0.a.k2.g.h.a().putString("bd_box_bduss", "");
        d.a.m0.a.k2.g.h.a().putString("bd_box_ptoken", "");
        if (aVar != null) {
            aVar.onResult(0);
        }
    }

    public final void v(boolean z) {
        for (d.a.m0.a.m.c cVar : this.f65054b) {
            cVar.a(z);
        }
    }

    public final void w() {
        MessageManager.getInstance().registerListener(this.f65055c);
    }

    public void x(d.a.m0.a.m.a aVar) {
        SapiAccountManager.getInstance().getAccountService().getUserInfo(new d(aVar), SapiAccountManager.getInstance().getSession().bduss);
    }

    public void y(GetUserInfoResult getUserInfoResult) {
        if (getUserInfoResult != null) {
            try {
                d.a.m0.a.k2.g.h.a().putString("host_account_info_string", getUserInfoResult.toString());
                if (this.f65053a == null) {
                    this.f65053a = new d.a.o0.u.b.b.b();
                }
                this.f65053a.f65072b = SapiAccountManager.getInstance().getSession().bduss;
                this.f65053a.f65078h = SapiAccountManager.getInstance().getSession().getPtoken();
                this.f65053a.f65071a = getUserInfoResult.displayname;
                this.f65053a.f65077g = getUserInfoResult.uid;
                this.f65053a.f65076f = getUserInfoResult.portraitHttps;
                d.a.m0.a.k2.g.h.a().putString("bd_box_display_name", this.f65053a.f65071a);
                d.a.m0.a.k2.g.h.a().putString("bd_box_uid", this.f65053a.f65077g);
                d.a.m0.a.k2.g.h.a().putString("bd_box_avatar_url", this.f65053a.f65076f);
                d.a.m0.a.k2.g.h.a().putString("bd_box_bduss", this.f65053a.f65072b);
                d.a.m0.a.k2.g.h.a().putString("bd_box_ptoken", this.f65053a.f65078h);
                SapiAccountManager.getInstance().getAccountService().getUserInfo(new b(), this.f65053a.f65072b);
                return;
            } catch (Exception e2) {
                if (f65052e) {
                    e2.printStackTrace();
                    return;
                }
                return;
            }
        }
        u(null);
    }

    public a() {
        this.f65055c = new C1686a(2921537);
        this.f65054b = new ArrayList();
    }
}
