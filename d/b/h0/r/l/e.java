package d.b.h0.r.l;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.switchs.StokenEnableSwitch;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes3.dex */
public class e {

    /* loaded from: classes3.dex */
    public class a extends GetTplStokenCallback {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f51050e;

        public a(e eVar, b bVar) {
            this.f51050e = bVar;
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(GetTplStokenResult getTplStokenResult) {
            b bVar = this.f51050e;
            if (bVar != null) {
                bVar.onFailed();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetTplStokenResult getTplStokenResult) {
            if (getTplStokenResult == null) {
                b bVar = this.f51050e;
                if (bVar != null) {
                    bVar.onFailed();
                    return;
                }
                return;
            }
            Map<String, String> map = getTplStokenResult.tplStokenMap;
            if (map != null && map.size() > 0) {
                String str = map.get(TbConfig.PassConfig.TPL);
                if (StringUtils.isNULL(str)) {
                    b bVar2 = this.f51050e;
                    if (bVar2 != null) {
                        bVar2.onFailed();
                        return;
                    }
                    return;
                }
                b bVar3 = this.f51050e;
                if (bVar3 != null) {
                    bVar3.onSuccess(str);
                    return;
                }
                return;
            }
            b bVar4 = this.f51050e;
            if (bVar4 != null) {
                bVar4.onFailed();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onFailed();

        void onSuccess(String str);
    }

    public static String a(AccountData accountData) {
        if (accountData != null && b()) {
            return accountData.getStoken();
        }
        return null;
    }

    public static boolean b() {
        return SwitchManager.getInstance().findType(StokenEnableSwitch.KEY) == 1;
    }

    public void c(String str, b bVar) {
        if (StringUtils.isNull(str)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(TbConfig.PassConfig.TPL);
        if (SapiAccountManager.getInstance().getAccountService() == null) {
            return;
        }
        SapiAccountManager.getInstance().getAccountService().getTplStoken(new a(this, bVar), str, linkedList);
    }
}
