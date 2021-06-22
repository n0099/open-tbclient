package d.a.o0.c2.d;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.RegisterUserFaceIDCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.callback.VerifyUserFaceIDCallback;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.sapi2.dto.FaceIDRegDTO;
import com.baidu.sapi2.dto.FaceIDVerifyDTO;
import com.baidu.sapi2.result.CheckUserFaceIdResult;
import com.baidu.sapi2.result.RealNameFaceIDResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.UnRealNameFaceIDResult;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import d.a.c.e.p.l;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f56212c;

    /* renamed from: a  reason: collision with root package name */
    public Activity f56213a;

    /* renamed from: b  reason: collision with root package name */
    public e f56214b;

    /* loaded from: classes5.dex */
    public class a implements SapiCallback<CheckUserFaceIdResult> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SapiAccount f56215e;

        public a(SapiAccount sapiAccount) {
            this.f56215e = sapiAccount;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: a */
        public void onFailure(CheckUserFaceIdResult checkUserFaceIdResult) {
            if (checkUserFaceIdResult != null) {
                l.M(TbadkCoreApplication.getInst(), checkUserFaceIdResult.getResultMsg());
            }
            if (c.this.f56214b != null) {
                c.this.f56214b.onFail();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: b */
        public void onSuccess(CheckUserFaceIdResult checkUserFaceIdResult) {
            int i2 = checkUserFaceIdResult.status;
            if (i2 == 1) {
                if (!TextUtils.isEmpty(checkUserFaceIdResult.livingUname)) {
                    BdLog.e("非实名人脸验证流程");
                    c.this.e(false, false, FaceBaseDTO.BUSINESS_SENCE_REALNAME_FACE, checkUserFaceIdResult.livingUname, this.f56215e.bduss);
                    return;
                }
                BdLog.e("实名人脸验证流程");
                c.this.e(false, false, FaceBaseDTO.BUSINESS_SENCE_REALNAME_FACE, "", this.f56215e.bduss);
            } else if (i2 == 2) {
                BdLog.e("人脸注册流程");
                c.this.j(false, false, FaceBaseDTO.BUSINESS_SENCE_REALNAME_FACE, checkUserFaceIdResult.authsid, checkUserFaceIdResult.livingUname, checkUserFaceIdResult.authWidgetURL);
            } else if (i2 == 3) {
                BdLog.e("人脸验证不可用");
                l.M(TbadkCoreApplication.getInst(), "刷脸功能暂不可用，请您稍后再试");
                if (c.this.f56214b != null) {
                    c.this.f56214b.c();
                }
            } else {
                BdLog.e("人脸验证不可用");
                l.M(TbadkCoreApplication.getInst(), "刷脸功能暂不可用，请您稍后再试");
                if (c.this.f56214b != null) {
                    c.this.f56214b.c();
                }
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
        }
    }

    /* loaded from: classes5.dex */
    public class b extends VerifyUserFaceIDCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f56217a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f56218b;

        public b(boolean z, boolean z2) {
            this.f56217a = z;
            this.f56218b = z2;
        }

        @Override // com.baidu.sapi2.callback.FaceIDCallback
        public void onFailure(SapiResult sapiResult) {
            if (sapiResult != null && sapiResult.getResultCode() != -204 && !StringHelper.equals("用户取消操作", sapiResult.getResultMsg())) {
                l.M(TbadkCoreApplication.getInst(), sapiResult.getResultMsg());
            }
            if (c.this.f56214b != null) {
                c.this.f56214b.b(sapiResult instanceof RealNameFaceIDResult, false, null);
            }
        }

        @Override // com.baidu.sapi2.callback.FaceIDCallback
        public void onSuccess(SapiResult sapiResult) {
            if (sapiResult instanceof RealNameFaceIDResult) {
                RealNameFaceIDResult realNameFaceIDResult = (RealNameFaceIDResult) sapiResult;
                BdLog.d("实名人脸验证成功,callBackKey:" + realNameFaceIDResult.callBackKey + ",authSid:" + realNameFaceIDResult.authSid);
                l.M(TbadkCoreApplication.getInst(), "刷脸验证成功");
                if (c.this.f56214b != null) {
                    c.this.f56214b.b(true, true, realNameFaceIDResult.callBackKey);
                }
                if (this.f56217a) {
                    c.this.h(this.f56218b, realNameFaceIDResult.callBackKey);
                }
            } else if (sapiResult instanceof UnRealNameFaceIDResult) {
                StringBuilder sb = new StringBuilder();
                sb.append("非实名人脸验证成功 callBackKey");
                UnRealNameFaceIDResult unRealNameFaceIDResult = (UnRealNameFaceIDResult) sapiResult;
                sb.append(unRealNameFaceIDResult.registerResult);
                BdLog.d(sb.toString());
                l.M(TbadkCoreApplication.getInst(), "刷脸验证成功");
                if (c.this.f56214b != null) {
                    c.this.f56214b.b(false, true, unRealNameFaceIDResult.callBackKey);
                }
                if (this.f56217a) {
                    c.this.h(this.f56218b, unRealNameFaceIDResult.callBackKey);
                }
            }
        }
    }

    /* renamed from: d.a.o0.c2.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1294c extends RegisterUserFaceIDCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f56220a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f56221b;

        public C1294c(boolean z, boolean z2) {
            this.f56220a = z;
            this.f56221b = z2;
        }

        @Override // com.baidu.sapi2.callback.FaceIDCallback
        public void onFailure(SapiResult sapiResult) {
            if (sapiResult != null && sapiResult.getResultCode() != -204 && !StringHelper.equals("用户取消操作", sapiResult.getResultMsg())) {
                l.M(TbadkCoreApplication.getInst(), sapiResult.getResultMsg());
            }
            if (c.this.f56214b != null) {
                c.this.f56214b.a(false, null);
            }
        }

        @Override // com.baidu.sapi2.callback.FaceIDCallback
        public void onSuccess(SapiResult sapiResult) {
            if (sapiResult instanceof UnRealNameFaceIDResult) {
                StringBuilder sb = new StringBuilder();
                sb.append("人脸注册结果");
                UnRealNameFaceIDResult unRealNameFaceIDResult = (UnRealNameFaceIDResult) sapiResult;
                sb.append(unRealNameFaceIDResult.registerResult);
                BdLog.d(sb.toString());
                l.M(TbadkCoreApplication.getInst(), "刷脸注册成功");
                if (c.this.f56214b != null) {
                    c.this.f56214b.a(true, unRealNameFaceIDResult.callBackKey);
                }
                if (this.f56220a) {
                    c.this.h(this.f56221b, unRealNameFaceIDResult.callBackKey);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements SapiCallback<SapiResult> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f56223e;

        public d(c cVar, boolean z) {
            this.f56223e = z;
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(SapiResult sapiResult) {
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(SapiResult sapiResult) {
            BdLog.d("faceLginSwitch onSuccess()" + sapiResult.getResultCode());
        }
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a(boolean z, String str);

        void b(boolean z, boolean z2, String str);

        void c();

        void onFail();
    }

    public static c i() {
        if (f56212c == null) {
            synchronized (c.class) {
                if (f56212c == null) {
                    f56212c = new c();
                }
            }
        }
        return f56212c;
    }

    public final void e(boolean z, boolean z2, String str, String str2, String str3) {
        FaceIDVerifyDTO faceIDVerifyDTO = new FaceIDVerifyDTO();
        faceIDVerifyDTO.livingUname = str2;
        faceIDVerifyDTO.businessSence = str;
        faceIDVerifyDTO.bduss = str3;
        faceIDVerifyDTO.showGuidePage = false;
        PassportSDK.getInstance().verifyUserFaceId(this.f56213a, new b(z, z2), faceIDVerifyDTO);
    }

    public final void f() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("scene", FaceBaseDTO.BUSINESS_SENCE_REALNAME_FACE);
        SapiAccountManager.getInstance().getAccountService().checkUserFaceId(new a(session), session.bduss, hashMap);
    }

    public void g(Activity activity, e eVar) {
        this.f56213a = activity;
        this.f56214b = eVar;
        f();
    }

    public final void h(boolean z, String str) {
        SapiAccountManager.getInstance().getAccountService().faceLoginSwitch(new d(this, z), SapiAccountManager.getInstance().getSession().bduss, !z, str);
    }

    public final void j(boolean z, boolean z2, String str, String str2, String str3, String str4) {
        FaceIDRegDTO faceIDRegDTO = new FaceIDRegDTO();
        faceIDRegDTO.authsid = str2;
        faceIDRegDTO.livingUname = str3;
        faceIDRegDTO.businessSence = str;
        faceIDRegDTO.authWidgetURL = str4;
        faceIDRegDTO.showGuidePage = true;
        PassportSDK.getInstance().registerUserFaceID(this.f56213a, new C1294c(z, z2), faceIDRegDTO);
    }

    public void k(e eVar) {
        this.f56214b = eVar;
    }
}
