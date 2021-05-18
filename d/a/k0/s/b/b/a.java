package d.a.k0.s.b.b;

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
import d.a.i0.a.k;
import d.a.i0.a.v2.o0;
import d.a.i0.b.k.a;
import d.a.i0.b.l.b;
import d.a.i0.b.o.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final String f60644d = "a";

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f60645e = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.k0.s.b.b.b f60646a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.i0.a.m.c> f60647b;

    /* renamed from: c  reason: collision with root package name */
    public final CustomMessageListener f60648c;

    /* renamed from: d.a.k0.s.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1594a extends CustomMessageListener {
        public C1594a(int i2) {
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
                a.this.f60646a.f60669f = getUserInfoResult.portraitHttps;
            }
            a.this.v(true);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.m.a f60651a;

        /* renamed from: d.a.k0.s.b.b.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1595a extends GetUserInfoCallback {
            public C1595a() {
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
                c.this.f60651a.onResult(-1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(GetUserInfoResult getUserInfoResult) {
                c.this.f60651a.onResult(-1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(GetUserInfoResult getUserInfoResult) {
                a.this.f60646a.f60665b = SapiAccountManager.getInstance().getSession().bduss;
                a.this.f60646a.f60671h = SapiAccountManager.getInstance().getSession().getPtoken();
                a.this.f60646a.f60664a = getUserInfoResult.displayname;
                a.this.f60646a.f60670g = getUserInfoResult.uid;
                a.this.f60646a.f60669f = getUserInfoResult.portraitHttps;
                d.a.i0.a.k2.g.h.a().putString("bd_box_display_name", a.this.f60646a.f60664a);
                d.a.i0.a.k2.g.h.a().putString("bd_box_uid", a.this.f60646a.f60670g);
                d.a.i0.a.k2.g.h.a().putString("bd_box_avatar_url", a.this.f60646a.f60669f);
                d.a.i0.a.k2.g.h.a().putString("bd_box_bduss", a.this.f60646a.f60665b);
                d.a.i0.a.k2.g.h.a().putString("bd_box_ptoken", a.this.f60646a.f60671h);
                c.this.f60651a.onResult(0);
                a.this.v(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i2, d.a.i0.a.m.a aVar) {
            super(i2);
            this.f60651a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof Integer) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 0) {
                    SapiAccountManager.getInstance().getAccountService().getUserInfo(new C1595a(), SapiAccountManager.getInstance().getSession().bduss);
                }
                this.f60651a.onResult(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends GetUserInfoCallback {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.m.a f60654e;

        public d(d.a.i0.a.m.a aVar) {
            this.f60654e = aVar;
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
            this.f60654e.onResult(-1);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(GetUserInfoResult getUserInfoResult) {
            this.f60654e.onResult(-1);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetUserInfoResult getUserInfoResult) {
            a.this.f60646a.f60665b = SapiAccountManager.getInstance().getSession().bduss;
            a.this.f60646a.f60671h = SapiAccountManager.getInstance().getSession().getPtoken();
            a.this.f60646a.f60664a = getUserInfoResult.displayname;
            a.this.f60646a.f60670g = getUserInfoResult.uid;
            a.this.f60646a.f60669f = getUserInfoResult.portraitHttps;
            d.a.i0.a.k2.g.h.a().putString("bd_box_display_name", a.this.f60646a.f60664a);
            d.a.i0.a.k2.g.h.a().putString("bd_box_uid", a.this.f60646a.f60670g);
            d.a.i0.a.k2.g.h.a().putString("bd_box_avatar_url", a.this.f60646a.f60669f);
            d.a.i0.a.k2.g.h.a().putString("bd_box_bduss", a.this.f60646a.f60665b);
            d.a.i0.a.k2.g.h.a().putString("bd_box_ptoken", a.this.f60646a.f60671h);
            a.this.m();
            this.f60654e.onResult(0);
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
            a.this.f60646a.f60665b = SapiAccountManager.getInstance().getSession().bduss;
            a.this.f60646a.f60671h = SapiAccountManager.getInstance().getSession().getPtoken();
            a.this.f60646a.f60664a = getUserInfoResult.displayname;
            a.this.f60646a.f60670g = getUserInfoResult.uid;
            a.this.f60646a.f60669f = getUserInfoResult.portraitHttps;
            d.a.i0.a.k2.g.h.a().putString("bd_box_display_name", a.this.f60646a.f60664a);
            d.a.i0.a.k2.g.h.a().putString("bd_box_uid", a.this.f60646a.f60670g);
            d.a.i0.a.k2.g.h.a().putString("bd_box_avatar_url", a.this.f60646a.f60669f);
            d.a.i0.a.k2.g.h.a().putString("bd_box_bduss", a.this.f60646a.f60665b);
            d.a.i0.a.k2.g.h.a().putString("bd_box_ptoken", a.this.f60646a.f60671h);
        }
    }

    /* loaded from: classes4.dex */
    public class f extends AddressManageCallback {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f60657e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a.d f60658f;

        public f(a aVar, String str, a.d dVar) {
            this.f60657e = str;
            this.f60658f = dVar;
        }

        @Override // com.baidu.sapi2.ecommerce.callback.AddressManageCallback
        public void onFinish(AddressManageResult addressManageResult) {
            if ("0".equals(this.f60657e) || this.f60658f == null) {
                if (a.f60645e) {
                    Log.d(a.f60644d, String.format("管理收货地址流程结束（%d:%s", Integer.valueOf(addressManageResult.getResultCode()), addressManageResult.getResultMsg()));
                }
            } else if (addressManageResult.getResultCode() != 0) {
                if (a.f60645e) {
                    Log.d(a.f60644d, String.format("选择收货地址错误（%d:%s", Integer.valueOf(addressManageResult.getResultCode()), addressManageResult.getResultMsg()));
                }
                this.f60658f.b();
            } else {
                this.f60658f.a(addressManageResult.map.get("addrId"));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends InvoiceBuildCallback {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f60659e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a.d f60660f;

        public g(a aVar, String str, a.d dVar) {
            this.f60659e = str;
            this.f60660f = dVar;
        }

        @Override // com.baidu.sapi2.ecommerce.callback.InvoiceBuildCallback
        public void onFinish(InvoiceBuildResult invoiceBuildResult) {
            if ("0".equals(this.f60659e) || this.f60660f == null) {
                if (a.f60645e) {
                    Log.d(a.f60644d, String.format("发票管理流程结束（%d:%s）", Integer.valueOf(invoiceBuildResult.getResultCode()), invoiceBuildResult.getResultMsg()));
                }
            } else if (invoiceBuildResult.getResultCode() != 0) {
                if (a.f60645e) {
                    Log.d(a.f60644d, String.format("获取发票错误（%d:%s）", Integer.valueOf(invoiceBuildResult.getResultCode()), invoiceBuildResult.getResultMsg()));
                }
                this.f60660f.b();
            } else {
                this.f60660f.a(invoiceBuildResult.map.get(InvoiceBuildResult.KEY_INVOICE_ID), this.f60659e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends GetOpenBdussCallback {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.c f60661e;

        public h(b.c cVar) {
            this.f60661e = cVar;
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
            a.this.f60646a.f60666c = openBdussResult.openBduss;
            a.this.f60646a.f60667d = openBdussResult.unionid;
            a.this.f60646a.f60668e = openBdussResult.tplStokenMap;
            d.a.i0.a.k2.g.h.a().putString("bd_box_open_bduss", a.this.f60646a.f60666c);
            d.a.i0.a.k2.g.h.a().putString("bd_box_union_id", a.this.f60646a.f60667d);
            d.a.i0.a.k2.g.h.a().putString("bd_box_stoken", o0.s(a.this.f60646a.f60668e));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(OpenBdussResult.PARAMS_OPEN_BDUSS, a.this.f60646a.f60666c);
                jSONObject.put("unionid", a.this.f60646a.f60667d);
                JSONObject jSONObject2 = new JSONObject();
                for (String str : a.this.f60646a.f60668e.keySet()) {
                    jSONObject2.put(str, a.this.f60646a.f60668e.get(str));
                }
                jSONObject.put("stokenmap", jSONObject2);
                jSONObject.put("uid", a.this.f60646a.f60670g);
                jSONObject.put("bduss", a.this.f60646a.f60665b);
                jSONObject.put("displayname", a.this.f60646a.f60664a);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.f60661e.a(jSONObject.toString());
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
        public static final a f60663a = new a(null);
    }

    public /* synthetic */ a(C1594a c1594a) {
        this();
    }

    public static a l() {
        return i.f60663a;
    }

    public void f(d.a.i0.a.m.c cVar) {
        this.f60647b.add(cVar);
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
        d.a.k0.s.b.b.b bVar = this.f60646a;
        if (bVar == null) {
            if (f60645e) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(bVar.f60669f)) {
            o();
        }
        return this.f60646a.f60669f;
    }

    public String j() {
        d.a.k0.s.b.b.b bVar = this.f60646a;
        if (bVar == null) {
            if (f60645e) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(bVar.f60665b)) {
            o();
        }
        return this.f60646a.f60665b;
    }

    public String k() {
        d.a.k0.s.b.b.b bVar = this.f60646a;
        if (bVar == null) {
            if (f60645e) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(bVar.f60664a)) {
            o();
        }
        return this.f60646a.f60664a;
    }

    public final void m() {
    }

    public void n(String str, ArrayList<String> arrayList, b.c cVar) {
        if (this.f60646a == null) {
            if (f60645e) {
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
        d.a.k0.s.b.b.b bVar = this.f60646a;
        if (bVar == null) {
            if (f60645e) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(bVar.f60670g)) {
            o();
        }
        return this.f60646a.f60670g;
    }

    public void q(Context context) {
        w();
        r(context);
    }

    public final void r(Context context) {
        if (this.f60646a == null) {
            d.a.k0.s.b.b.b bVar = new d.a.k0.s.b.b.b();
            this.f60646a = bVar;
            bVar.f60669f = d.a.i0.a.k2.g.h.a().getString("bd_box_avatar_url", "");
            this.f60646a.f60665b = d.a.i0.a.k2.g.h.a().getString("bd_box_bduss", "");
            this.f60646a.f60671h = d.a.i0.a.k2.g.h.a().getString("bd_box_ptoken", "");
            this.f60646a.f60670g = d.a.i0.a.k2.g.h.a().getString("bd_box_uid", "");
            this.f60646a.f60666c = d.a.i0.a.k2.g.h.a().getString("bd_box_open_bduss", "");
            this.f60646a.f60667d = d.a.i0.a.k2.g.h.a().getString("bd_box_union_id", "");
            this.f60646a.f60668e = o0.t(d.a.i0.a.k2.g.h.a().getString("bd_box_stoken", ""));
            this.f60646a.f60664a = d.a.i0.a.k2.g.h.a().getString("bd_box_display_name", "");
        }
    }

    public boolean s() {
        d.a.k0.s.b.b.b bVar = this.f60646a;
        if (bVar != null && TextUtils.isEmpty(bVar.f60665b)) {
            o();
        }
        return SapiAccountManager.getInstance().isLogin();
    }

    public void t(Context context, Bundle bundle, d.a.i0.a.m.a aVar) {
        int i2;
        if (this.f60646a == null) {
            this.f60646a = new d.a.k0.s.b.b.b();
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

    public void u(d.a.i0.a.m.a aVar) {
        SapiAccountManager.getInstance().logout();
        v(false);
        this.f60646a = new d.a.k0.s.b.b.b();
        d.a.i0.a.k2.g.h.a().putString("bd_box_display_name", "");
        d.a.i0.a.k2.g.h.a().putString("bd_box_uid", "");
        d.a.i0.a.k2.g.h.a().putString("bd_box_avatar_url", "");
        d.a.i0.a.k2.g.h.a().putString("bd_box_bduss", "");
        d.a.i0.a.k2.g.h.a().putString("bd_box_ptoken", "");
        if (aVar != null) {
            aVar.onResult(0);
        }
    }

    public final void v(boolean z) {
        for (d.a.i0.a.m.c cVar : this.f60647b) {
            cVar.a(z);
        }
    }

    public final void w() {
        MessageManager.getInstance().registerListener(this.f60648c);
    }

    public void x(d.a.i0.a.m.a aVar) {
        SapiAccountManager.getInstance().getAccountService().getUserInfo(new d(aVar), SapiAccountManager.getInstance().getSession().bduss);
    }

    public void y(GetUserInfoResult getUserInfoResult) {
        if (getUserInfoResult != null) {
            try {
                d.a.i0.a.k2.g.h.a().putString("host_account_info_string", getUserInfoResult.toString());
                if (this.f60646a == null) {
                    this.f60646a = new d.a.k0.s.b.b.b();
                }
                this.f60646a.f60665b = SapiAccountManager.getInstance().getSession().bduss;
                this.f60646a.f60671h = SapiAccountManager.getInstance().getSession().getPtoken();
                this.f60646a.f60664a = getUserInfoResult.displayname;
                this.f60646a.f60670g = getUserInfoResult.uid;
                this.f60646a.f60669f = getUserInfoResult.portraitHttps;
                d.a.i0.a.k2.g.h.a().putString("bd_box_display_name", this.f60646a.f60664a);
                d.a.i0.a.k2.g.h.a().putString("bd_box_uid", this.f60646a.f60670g);
                d.a.i0.a.k2.g.h.a().putString("bd_box_avatar_url", this.f60646a.f60669f);
                d.a.i0.a.k2.g.h.a().putString("bd_box_bduss", this.f60646a.f60665b);
                d.a.i0.a.k2.g.h.a().putString("bd_box_ptoken", this.f60646a.f60671h);
                SapiAccountManager.getInstance().getAccountService().getUserInfo(new b(), this.f60646a.f60665b);
                return;
            } catch (Exception e2) {
                if (f60645e) {
                    e2.printStackTrace();
                    return;
                }
                return;
            }
        }
        u(null);
    }

    public a() {
        this.f60648c = new C1594a(2921537);
        this.f60647b = new ArrayList();
    }
}
