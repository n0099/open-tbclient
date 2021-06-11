package d.a.n0.u.b.b;

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
import d.a.l0.a.k;
import d.a.l0.a.v2.o0;
import d.a.l0.b.k.a;
import d.a.l0.b.l.b;
import d.a.l0.b.o.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final String f64926d = "a";

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f64927e = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.n0.u.b.b.b f64928a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.l0.a.m.c> f64929b;

    /* renamed from: c  reason: collision with root package name */
    public final CustomMessageListener f64930c;

    /* renamed from: d.a.n0.u.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1682a extends CustomMessageListener {
        public C1682a(int i2) {
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
                a.this.f64928a.f64951f = getUserInfoResult.portraitHttps;
            }
            a.this.v(true);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.m.a f64933a;

        /* renamed from: d.a.n0.u.b.b.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1683a extends GetUserInfoCallback {
            public C1683a() {
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
                c.this.f64933a.onResult(-1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(GetUserInfoResult getUserInfoResult) {
                c.this.f64933a.onResult(-1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(GetUserInfoResult getUserInfoResult) {
                a.this.f64928a.f64947b = SapiAccountManager.getInstance().getSession().bduss;
                a.this.f64928a.f64953h = SapiAccountManager.getInstance().getSession().getPtoken();
                a.this.f64928a.f64946a = getUserInfoResult.displayname;
                a.this.f64928a.f64952g = getUserInfoResult.uid;
                a.this.f64928a.f64951f = getUserInfoResult.portraitHttps;
                d.a.l0.a.k2.g.h.a().putString("bd_box_display_name", a.this.f64928a.f64946a);
                d.a.l0.a.k2.g.h.a().putString("bd_box_uid", a.this.f64928a.f64952g);
                d.a.l0.a.k2.g.h.a().putString("bd_box_avatar_url", a.this.f64928a.f64951f);
                d.a.l0.a.k2.g.h.a().putString("bd_box_bduss", a.this.f64928a.f64947b);
                d.a.l0.a.k2.g.h.a().putString("bd_box_ptoken", a.this.f64928a.f64953h);
                c.this.f64933a.onResult(0);
                a.this.v(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i2, d.a.l0.a.m.a aVar) {
            super(i2);
            this.f64933a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof Integer) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 0) {
                    SapiAccountManager.getInstance().getAccountService().getUserInfo(new C1683a(), SapiAccountManager.getInstance().getSession().bduss);
                }
                this.f64933a.onResult(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends GetUserInfoCallback {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.m.a f64936e;

        public d(d.a.l0.a.m.a aVar) {
            this.f64936e = aVar;
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
            this.f64936e.onResult(-1);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(GetUserInfoResult getUserInfoResult) {
            this.f64936e.onResult(-1);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetUserInfoResult getUserInfoResult) {
            a.this.f64928a.f64947b = SapiAccountManager.getInstance().getSession().bduss;
            a.this.f64928a.f64953h = SapiAccountManager.getInstance().getSession().getPtoken();
            a.this.f64928a.f64946a = getUserInfoResult.displayname;
            a.this.f64928a.f64952g = getUserInfoResult.uid;
            a.this.f64928a.f64951f = getUserInfoResult.portraitHttps;
            d.a.l0.a.k2.g.h.a().putString("bd_box_display_name", a.this.f64928a.f64946a);
            d.a.l0.a.k2.g.h.a().putString("bd_box_uid", a.this.f64928a.f64952g);
            d.a.l0.a.k2.g.h.a().putString("bd_box_avatar_url", a.this.f64928a.f64951f);
            d.a.l0.a.k2.g.h.a().putString("bd_box_bduss", a.this.f64928a.f64947b);
            d.a.l0.a.k2.g.h.a().putString("bd_box_ptoken", a.this.f64928a.f64953h);
            a.this.m();
            this.f64936e.onResult(0);
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
            a.this.f64928a.f64947b = SapiAccountManager.getInstance().getSession().bduss;
            a.this.f64928a.f64953h = SapiAccountManager.getInstance().getSession().getPtoken();
            a.this.f64928a.f64946a = getUserInfoResult.displayname;
            a.this.f64928a.f64952g = getUserInfoResult.uid;
            a.this.f64928a.f64951f = getUserInfoResult.portraitHttps;
            d.a.l0.a.k2.g.h.a().putString("bd_box_display_name", a.this.f64928a.f64946a);
            d.a.l0.a.k2.g.h.a().putString("bd_box_uid", a.this.f64928a.f64952g);
            d.a.l0.a.k2.g.h.a().putString("bd_box_avatar_url", a.this.f64928a.f64951f);
            d.a.l0.a.k2.g.h.a().putString("bd_box_bduss", a.this.f64928a.f64947b);
            d.a.l0.a.k2.g.h.a().putString("bd_box_ptoken", a.this.f64928a.f64953h);
        }
    }

    /* loaded from: classes4.dex */
    public class f extends AddressManageCallback {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f64939e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a.d f64940f;

        public f(a aVar, String str, a.d dVar) {
            this.f64939e = str;
            this.f64940f = dVar;
        }

        @Override // com.baidu.sapi2.ecommerce.callback.AddressManageCallback
        public void onFinish(AddressManageResult addressManageResult) {
            if ("0".equals(this.f64939e) || this.f64940f == null) {
                if (a.f64927e) {
                    Log.d(a.f64926d, String.format("管理收货地址流程结束（%d:%s", Integer.valueOf(addressManageResult.getResultCode()), addressManageResult.getResultMsg()));
                }
            } else if (addressManageResult.getResultCode() != 0) {
                if (a.f64927e) {
                    Log.d(a.f64926d, String.format("选择收货地址错误（%d:%s", Integer.valueOf(addressManageResult.getResultCode()), addressManageResult.getResultMsg()));
                }
                this.f64940f.b();
            } else {
                this.f64940f.a(addressManageResult.map.get("addrId"));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends InvoiceBuildCallback {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f64941e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a.d f64942f;

        public g(a aVar, String str, a.d dVar) {
            this.f64941e = str;
            this.f64942f = dVar;
        }

        @Override // com.baidu.sapi2.ecommerce.callback.InvoiceBuildCallback
        public void onFinish(InvoiceBuildResult invoiceBuildResult) {
            if ("0".equals(this.f64941e) || this.f64942f == null) {
                if (a.f64927e) {
                    Log.d(a.f64926d, String.format("发票管理流程结束（%d:%s）", Integer.valueOf(invoiceBuildResult.getResultCode()), invoiceBuildResult.getResultMsg()));
                }
            } else if (invoiceBuildResult.getResultCode() != 0) {
                if (a.f64927e) {
                    Log.d(a.f64926d, String.format("获取发票错误（%d:%s）", Integer.valueOf(invoiceBuildResult.getResultCode()), invoiceBuildResult.getResultMsg()));
                }
                this.f64942f.b();
            } else {
                this.f64942f.a(invoiceBuildResult.map.get(InvoiceBuildResult.KEY_INVOICE_ID), this.f64941e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends GetOpenBdussCallback {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.c f64943e;

        public h(b.c cVar) {
            this.f64943e = cVar;
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
            a.this.f64928a.f64948c = openBdussResult.openBduss;
            a.this.f64928a.f64949d = openBdussResult.unionid;
            a.this.f64928a.f64950e = openBdussResult.tplStokenMap;
            d.a.l0.a.k2.g.h.a().putString("bd_box_open_bduss", a.this.f64928a.f64948c);
            d.a.l0.a.k2.g.h.a().putString("bd_box_union_id", a.this.f64928a.f64949d);
            d.a.l0.a.k2.g.h.a().putString("bd_box_stoken", o0.s(a.this.f64928a.f64950e));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(OpenBdussResult.PARAMS_OPEN_BDUSS, a.this.f64928a.f64948c);
                jSONObject.put("unionid", a.this.f64928a.f64949d);
                JSONObject jSONObject2 = new JSONObject();
                for (String str : a.this.f64928a.f64950e.keySet()) {
                    jSONObject2.put(str, a.this.f64928a.f64950e.get(str));
                }
                jSONObject.put("stokenmap", jSONObject2);
                jSONObject.put("uid", a.this.f64928a.f64952g);
                jSONObject.put("bduss", a.this.f64928a.f64947b);
                jSONObject.put("displayname", a.this.f64928a.f64946a);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.f64943e.a(jSONObject.toString());
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
        public static final a f64945a = new a(null);
    }

    public /* synthetic */ a(C1682a c1682a) {
        this();
    }

    public static a l() {
        return i.f64945a;
    }

    public void f(d.a.l0.a.m.c cVar) {
        this.f64929b.add(cVar);
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
        d.a.n0.u.b.b.b bVar = this.f64928a;
        if (bVar == null) {
            if (f64927e) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(bVar.f64951f)) {
            o();
        }
        return this.f64928a.f64951f;
    }

    public String j() {
        d.a.n0.u.b.b.b bVar = this.f64928a;
        if (bVar == null) {
            if (f64927e) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(bVar.f64947b)) {
            o();
        }
        return this.f64928a.f64947b;
    }

    public String k() {
        d.a.n0.u.b.b.b bVar = this.f64928a;
        if (bVar == null) {
            if (f64927e) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(bVar.f64946a)) {
            o();
        }
        return this.f64928a.f64946a;
    }

    public final void m() {
    }

    public void n(String str, ArrayList<String> arrayList, b.c cVar) {
        if (this.f64928a == null) {
            if (f64927e) {
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
        d.a.n0.u.b.b.b bVar = this.f64928a;
        if (bVar == null) {
            if (f64927e) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(bVar.f64952g)) {
            o();
        }
        return this.f64928a.f64952g;
    }

    public void q(Context context) {
        w();
        r(context);
    }

    public final void r(Context context) {
        if (this.f64928a == null) {
            d.a.n0.u.b.b.b bVar = new d.a.n0.u.b.b.b();
            this.f64928a = bVar;
            bVar.f64951f = d.a.l0.a.k2.g.h.a().getString("bd_box_avatar_url", "");
            this.f64928a.f64947b = d.a.l0.a.k2.g.h.a().getString("bd_box_bduss", "");
            this.f64928a.f64953h = d.a.l0.a.k2.g.h.a().getString("bd_box_ptoken", "");
            this.f64928a.f64952g = d.a.l0.a.k2.g.h.a().getString("bd_box_uid", "");
            this.f64928a.f64948c = d.a.l0.a.k2.g.h.a().getString("bd_box_open_bduss", "");
            this.f64928a.f64949d = d.a.l0.a.k2.g.h.a().getString("bd_box_union_id", "");
            this.f64928a.f64950e = o0.t(d.a.l0.a.k2.g.h.a().getString("bd_box_stoken", ""));
            this.f64928a.f64946a = d.a.l0.a.k2.g.h.a().getString("bd_box_display_name", "");
        }
    }

    public boolean s() {
        d.a.n0.u.b.b.b bVar = this.f64928a;
        if (bVar != null && TextUtils.isEmpty(bVar.f64947b)) {
            o();
        }
        return SapiAccountManager.getInstance().isLogin();
    }

    public void t(Context context, Bundle bundle, d.a.l0.a.m.a aVar) {
        int i2;
        if (this.f64928a == null) {
            this.f64928a = new d.a.n0.u.b.b.b();
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

    public void u(d.a.l0.a.m.a aVar) {
        SapiAccountManager.getInstance().logout();
        v(false);
        this.f64928a = new d.a.n0.u.b.b.b();
        d.a.l0.a.k2.g.h.a().putString("bd_box_display_name", "");
        d.a.l0.a.k2.g.h.a().putString("bd_box_uid", "");
        d.a.l0.a.k2.g.h.a().putString("bd_box_avatar_url", "");
        d.a.l0.a.k2.g.h.a().putString("bd_box_bduss", "");
        d.a.l0.a.k2.g.h.a().putString("bd_box_ptoken", "");
        if (aVar != null) {
            aVar.onResult(0);
        }
    }

    public final void v(boolean z) {
        for (d.a.l0.a.m.c cVar : this.f64929b) {
            cVar.a(z);
        }
    }

    public final void w() {
        MessageManager.getInstance().registerListener(this.f64930c);
    }

    public void x(d.a.l0.a.m.a aVar) {
        SapiAccountManager.getInstance().getAccountService().getUserInfo(new d(aVar), SapiAccountManager.getInstance().getSession().bduss);
    }

    public void y(GetUserInfoResult getUserInfoResult) {
        if (getUserInfoResult != null) {
            try {
                d.a.l0.a.k2.g.h.a().putString("host_account_info_string", getUserInfoResult.toString());
                if (this.f64928a == null) {
                    this.f64928a = new d.a.n0.u.b.b.b();
                }
                this.f64928a.f64947b = SapiAccountManager.getInstance().getSession().bduss;
                this.f64928a.f64953h = SapiAccountManager.getInstance().getSession().getPtoken();
                this.f64928a.f64946a = getUserInfoResult.displayname;
                this.f64928a.f64952g = getUserInfoResult.uid;
                this.f64928a.f64951f = getUserInfoResult.portraitHttps;
                d.a.l0.a.k2.g.h.a().putString("bd_box_display_name", this.f64928a.f64946a);
                d.a.l0.a.k2.g.h.a().putString("bd_box_uid", this.f64928a.f64952g);
                d.a.l0.a.k2.g.h.a().putString("bd_box_avatar_url", this.f64928a.f64951f);
                d.a.l0.a.k2.g.h.a().putString("bd_box_bduss", this.f64928a.f64947b);
                d.a.l0.a.k2.g.h.a().putString("bd_box_ptoken", this.f64928a.f64953h);
                SapiAccountManager.getInstance().getAccountService().getUserInfo(new b(), this.f64928a.f64947b);
                return;
            } catch (Exception e2) {
                if (f64927e) {
                    e2.printStackTrace();
                    return;
                }
                return;
            }
        }
        u(null);
    }

    public a() {
        this.f64930c = new C1682a(2921537);
        this.f64929b = new ArrayList();
    }
}
