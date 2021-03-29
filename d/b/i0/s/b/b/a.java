package d.b.i0.s.b.b;

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
import d.b.g0.a.i2.i0;
import d.b.g0.a.k;
import d.b.g0.b.j.a;
import d.b.g0.b.k.b;
import d.b.g0.b.n.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final String f60019d = "a";

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f60020e = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public d.b.i0.s.b.b.b f60021a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.b.g0.a.m.c> f60022b;

    /* renamed from: c  reason: collision with root package name */
    public final CustomMessageListener f60023c;

    /* renamed from: d.b.i0.s.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1519a extends CustomMessageListener {
        public C1519a(int i) {
            super(i);
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
                a.this.f60021a.f60044f = getUserInfoResult.portraitHttps;
            }
            a.this.v(true);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.m.a f60026a;

        /* renamed from: d.b.i0.s.b.b.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1520a extends GetUserInfoCallback {
            public C1520a() {
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
                c.this.f60026a.onResult(-1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(GetUserInfoResult getUserInfoResult) {
                c.this.f60026a.onResult(-1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(GetUserInfoResult getUserInfoResult) {
                a.this.f60021a.f60040b = SapiAccountManager.getInstance().getSession().bduss;
                a.this.f60021a.f60046h = SapiAccountManager.getInstance().getSession().getPtoken();
                a.this.f60021a.f60039a = getUserInfoResult.displayname;
                a.this.f60021a.f60045g = getUserInfoResult.uid;
                a.this.f60021a.f60044f = getUserInfoResult.portraitHttps;
                d.b.g0.a.a2.g.h.a().putString("bd_box_display_name", a.this.f60021a.f60039a);
                d.b.g0.a.a2.g.h.a().putString("bd_box_uid", a.this.f60021a.f60045g);
                d.b.g0.a.a2.g.h.a().putString("bd_box_avatar_url", a.this.f60021a.f60044f);
                d.b.g0.a.a2.g.h.a().putString("bd_box_bduss", a.this.f60021a.f60040b);
                d.b.g0.a.a2.g.h.a().putString("bd_box_ptoken", a.this.f60021a.f60046h);
                c.this.f60026a.onResult(0);
                a.this.v(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i, d.b.g0.a.m.a aVar) {
            super(i);
            this.f60026a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof Integer) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 0) {
                    SapiAccountManager.getInstance().getAccountService().getUserInfo(new C1520a(), SapiAccountManager.getInstance().getSession().bduss);
                }
                this.f60026a.onResult(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends GetUserInfoCallback {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.m.a f60029e;

        public d(d.b.g0.a.m.a aVar) {
            this.f60029e = aVar;
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
            this.f60029e.onResult(-1);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(GetUserInfoResult getUserInfoResult) {
            this.f60029e.onResult(-1);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetUserInfoResult getUserInfoResult) {
            a.this.f60021a.f60040b = SapiAccountManager.getInstance().getSession().bduss;
            a.this.f60021a.f60046h = SapiAccountManager.getInstance().getSession().getPtoken();
            a.this.f60021a.f60039a = getUserInfoResult.displayname;
            a.this.f60021a.f60045g = getUserInfoResult.uid;
            a.this.f60021a.f60044f = getUserInfoResult.portraitHttps;
            d.b.g0.a.a2.g.h.a().putString("bd_box_display_name", a.this.f60021a.f60039a);
            d.b.g0.a.a2.g.h.a().putString("bd_box_uid", a.this.f60021a.f60045g);
            d.b.g0.a.a2.g.h.a().putString("bd_box_avatar_url", a.this.f60021a.f60044f);
            d.b.g0.a.a2.g.h.a().putString("bd_box_bduss", a.this.f60021a.f60040b);
            d.b.g0.a.a2.g.h.a().putString("bd_box_ptoken", a.this.f60021a.f60046h);
            a.this.m();
            this.f60029e.onResult(0);
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
            a.this.f60021a.f60040b = SapiAccountManager.getInstance().getSession().bduss;
            a.this.f60021a.f60046h = SapiAccountManager.getInstance().getSession().getPtoken();
            a.this.f60021a.f60039a = getUserInfoResult.displayname;
            a.this.f60021a.f60045g = getUserInfoResult.uid;
            a.this.f60021a.f60044f = getUserInfoResult.portraitHttps;
            d.b.g0.a.a2.g.h.a().putString("bd_box_display_name", a.this.f60021a.f60039a);
            d.b.g0.a.a2.g.h.a().putString("bd_box_uid", a.this.f60021a.f60045g);
            d.b.g0.a.a2.g.h.a().putString("bd_box_avatar_url", a.this.f60021a.f60044f);
            d.b.g0.a.a2.g.h.a().putString("bd_box_bduss", a.this.f60021a.f60040b);
            d.b.g0.a.a2.g.h.a().putString("bd_box_ptoken", a.this.f60021a.f60046h);
        }
    }

    /* loaded from: classes4.dex */
    public class f extends AddressManageCallback {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f60032e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a.d f60033f;

        public f(a aVar, String str, a.d dVar) {
            this.f60032e = str;
            this.f60033f = dVar;
        }

        @Override // com.baidu.sapi2.ecommerce.callback.AddressManageCallback
        public void onFinish(AddressManageResult addressManageResult) {
            if ("0".equals(this.f60032e) || this.f60033f == null) {
                if (a.f60020e) {
                    Log.d(a.f60019d, String.format("管理收货地址流程结束（%d:%s", Integer.valueOf(addressManageResult.getResultCode()), addressManageResult.getResultMsg()));
                }
            } else if (addressManageResult.getResultCode() != 0) {
                if (a.f60020e) {
                    Log.d(a.f60019d, String.format("选择收货地址错误（%d:%s", Integer.valueOf(addressManageResult.getResultCode()), addressManageResult.getResultMsg()));
                }
                this.f60033f.b();
            } else {
                this.f60033f.a(addressManageResult.map.get("addrId"));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends InvoiceBuildCallback {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f60034e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a.d f60035f;

        public g(a aVar, String str, a.d dVar) {
            this.f60034e = str;
            this.f60035f = dVar;
        }

        @Override // com.baidu.sapi2.ecommerce.callback.InvoiceBuildCallback
        public void onFinish(InvoiceBuildResult invoiceBuildResult) {
            if ("0".equals(this.f60034e) || this.f60035f == null) {
                if (a.f60020e) {
                    Log.d(a.f60019d, String.format("发票管理流程结束（%d:%s）", Integer.valueOf(invoiceBuildResult.getResultCode()), invoiceBuildResult.getResultMsg()));
                }
            } else if (invoiceBuildResult.getResultCode() != 0) {
                if (a.f60020e) {
                    Log.d(a.f60019d, String.format("获取发票错误（%d:%s）", Integer.valueOf(invoiceBuildResult.getResultCode()), invoiceBuildResult.getResultMsg()));
                }
                this.f60035f.b();
            } else {
                this.f60035f.a(invoiceBuildResult.map.get(InvoiceBuildResult.KEY_INVOICE_ID), this.f60034e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends GetOpenBdussCallback {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.c f60036e;

        public h(b.c cVar) {
            this.f60036e = cVar;
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
            a.this.f60021a.f60041c = openBdussResult.openBduss;
            a.this.f60021a.f60042d = openBdussResult.unionid;
            a.this.f60021a.f60043e = openBdussResult.tplStokenMap;
            d.b.g0.a.a2.g.h.a().putString("bd_box_open_bduss", a.this.f60021a.f60041c);
            d.b.g0.a.a2.g.h.a().putString("bd_box_union_id", a.this.f60021a.f60042d);
            d.b.g0.a.a2.g.h.a().putString("bd_box_stoken", i0.q(a.this.f60021a.f60043e));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(OpenBdussResult.PARAMS_OPEN_BDUSS, a.this.f60021a.f60041c);
                jSONObject.put("unionid", a.this.f60021a.f60042d);
                JSONObject jSONObject2 = new JSONObject();
                for (String str : a.this.f60021a.f60043e.keySet()) {
                    jSONObject2.put(str, a.this.f60021a.f60043e.get(str));
                }
                jSONObject.put("stokenmap", jSONObject2);
                jSONObject.put("uid", a.this.f60021a.f60045g);
                jSONObject.put("bduss", a.this.f60021a.f60040b);
                jSONObject.put("displayname", a.this.f60021a.f60039a);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.f60036e.a(jSONObject.toString());
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
        public static final a f60038a = new a(null);
    }

    public /* synthetic */ a(C1519a c1519a) {
        this();
    }

    public static a l() {
        return i.f60038a;
    }

    public void f(d.b.g0.a.m.c cVar) {
        this.f60022b.add(cVar);
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
        d.b.i0.s.b.b.b bVar = this.f60021a;
        if (bVar == null) {
            if (f60020e) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(bVar.f60044f)) {
            o();
        }
        return this.f60021a.f60044f;
    }

    public String j() {
        d.b.i0.s.b.b.b bVar = this.f60021a;
        if (bVar == null) {
            if (f60020e) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(bVar.f60040b)) {
            o();
        }
        return this.f60021a.f60040b;
    }

    public String k() {
        d.b.i0.s.b.b.b bVar = this.f60021a;
        if (bVar == null) {
            if (f60020e) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(bVar.f60039a)) {
            o();
        }
        return this.f60021a.f60039a;
    }

    public final void m() {
    }

    public void n(String str, ArrayList<String> arrayList, b.c cVar) {
        if (this.f60021a == null) {
            if (f60020e) {
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
        d.b.i0.s.b.b.b bVar = this.f60021a;
        if (bVar == null) {
            if (f60020e) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(bVar.f60045g)) {
            o();
        }
        return this.f60021a.f60045g;
    }

    public void q(Context context) {
        w();
        r(context);
    }

    public final void r(Context context) {
        if (this.f60021a == null) {
            d.b.i0.s.b.b.b bVar = new d.b.i0.s.b.b.b();
            this.f60021a = bVar;
            bVar.f60044f = d.b.g0.a.a2.g.h.a().getString("bd_box_avatar_url", "");
            this.f60021a.f60040b = d.b.g0.a.a2.g.h.a().getString("bd_box_bduss", "");
            this.f60021a.f60046h = d.b.g0.a.a2.g.h.a().getString("bd_box_ptoken", "");
            this.f60021a.f60045g = d.b.g0.a.a2.g.h.a().getString("bd_box_uid", "");
            this.f60021a.f60041c = d.b.g0.a.a2.g.h.a().getString("bd_box_open_bduss", "");
            this.f60021a.f60042d = d.b.g0.a.a2.g.h.a().getString("bd_box_union_id", "");
            this.f60021a.f60043e = i0.r(d.b.g0.a.a2.g.h.a().getString("bd_box_stoken", ""));
            this.f60021a.f60039a = d.b.g0.a.a2.g.h.a().getString("bd_box_display_name", "");
        }
    }

    public boolean s() {
        d.b.i0.s.b.b.b bVar = this.f60021a;
        if (bVar != null && TextUtils.isEmpty(bVar.f60040b)) {
            o();
        }
        return SapiAccountManager.getInstance().isLogin();
    }

    public void t(Context context, Bundle bundle, d.b.g0.a.m.a aVar) {
        int i2;
        if (this.f60021a == null) {
            this.f60021a = new d.b.i0.s.b.b.b();
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

    public void u(d.b.g0.a.m.a aVar) {
        SapiAccountManager.getInstance().logout();
        v(false);
        this.f60021a = new d.b.i0.s.b.b.b();
        d.b.g0.a.a2.g.h.a().putString("bd_box_display_name", "");
        d.b.g0.a.a2.g.h.a().putString("bd_box_uid", "");
        d.b.g0.a.a2.g.h.a().putString("bd_box_avatar_url", "");
        d.b.g0.a.a2.g.h.a().putString("bd_box_bduss", "");
        d.b.g0.a.a2.g.h.a().putString("bd_box_ptoken", "");
        if (aVar != null) {
            aVar.onResult(0);
        }
    }

    public final void v(boolean z) {
        for (d.b.g0.a.m.c cVar : this.f60022b) {
            cVar.a(z);
        }
    }

    public final void w() {
        MessageManager.getInstance().registerListener(this.f60023c);
    }

    public void x(d.b.g0.a.m.a aVar) {
        SapiAccountManager.getInstance().getAccountService().getUserInfo(new d(aVar), SapiAccountManager.getInstance().getSession().bduss);
    }

    public void y(GetUserInfoResult getUserInfoResult) {
        if (getUserInfoResult != null) {
            try {
                d.b.g0.a.a2.g.h.a().putString("host_account_info_string", getUserInfoResult.toString());
                if (this.f60021a == null) {
                    this.f60021a = new d.b.i0.s.b.b.b();
                }
                this.f60021a.f60040b = SapiAccountManager.getInstance().getSession().bduss;
                this.f60021a.f60046h = SapiAccountManager.getInstance().getSession().getPtoken();
                this.f60021a.f60039a = getUserInfoResult.displayname;
                this.f60021a.f60045g = getUserInfoResult.uid;
                this.f60021a.f60044f = getUserInfoResult.portraitHttps;
                d.b.g0.a.a2.g.h.a().putString("bd_box_display_name", this.f60021a.f60039a);
                d.b.g0.a.a2.g.h.a().putString("bd_box_uid", this.f60021a.f60045g);
                d.b.g0.a.a2.g.h.a().putString("bd_box_avatar_url", this.f60021a.f60044f);
                d.b.g0.a.a2.g.h.a().putString("bd_box_bduss", this.f60021a.f60040b);
                d.b.g0.a.a2.g.h.a().putString("bd_box_ptoken", this.f60021a.f60046h);
                SapiAccountManager.getInstance().getAccountService().getUserInfo(new b(), this.f60021a.f60040b);
                return;
            } catch (Exception e2) {
                if (f60020e) {
                    e2.printStackTrace();
                    return;
                }
                return;
            }
        }
        u(null);
    }

    public a() {
        this.f60023c = new C1519a(2921537);
        this.f60022b = new ArrayList();
    }
}
